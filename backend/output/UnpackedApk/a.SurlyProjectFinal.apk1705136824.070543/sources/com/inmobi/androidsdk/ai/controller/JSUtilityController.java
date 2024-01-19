package com.inmobi.androidsdk.ai.controller;

import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.controller.JSController.Dimensions;
import com.inmobi.androidsdk.impl.Constants;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JSUtilityController extends JSController {
    private JSAssetController mAssetController;
    private JSDisplayController mDisplayController;

    public JSUtilityController(IMWebView adView, Context context) {
        super(adView, context);
        this.mAssetController = new JSAssetController(adView, context);
        this.mDisplayController = new JSDisplayController(adView, context);
        adView.addJavascriptInterface(this.mDisplayController, "displayController");
    }

    public void sendSMS(String recipient, String body) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSUtilityController-> sendSMS: recipient: " + recipient + " body: " + body);
        }
        try {
            Intent sendIntent = new Intent("android.intent.action.VIEW");
            sendIntent.putExtra("address", recipient);
            sendIntent.putExtra("sms_body", body);
            sendIntent.setType("vnd.android-dir/mms-sms");
            sendIntent.addFlags(268435456);
            this.imWebView.getExpandedActivity().startActivity(sendIntent);
            this.imWebView.fireOnLeaveApplication();
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception in sending SMS", e);
            }
            this.imWebView.raiseError("Exception in sending SMS", "sendSMS");
        }
    }

    public void sendMail(String recipient, String subject, String body) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSUtilityController-> sendMail: recipient: " + recipient + " subject: " + subject + " body: " + body);
        }
        try {
            Intent i = new Intent("android.intent.action.SEND");
            i.setType("plain/text");
            i.putExtra("android.intent.extra.EMAIL", new String[]{recipient});
            i.putExtra("android.intent.extra.SUBJECT", subject);
            i.putExtra("android.intent.extra.TEXT", body);
            i.addFlags(268435456);
            Intent targetIntent = Intent.createChooser(i, "Choose the Email Client.");
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "target Intent: " + targetIntent);
            }
            this.imWebView.getExpandedActivity().startActivity(targetIntent);
            this.imWebView.fireOnLeaveApplication();
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception in sending mail", e);
            }
            this.imWebView.raiseError("Exception in sending mail", "sendMail");
        }
    }

    private String createTelUrl(String number) {
        if (TextUtils.isEmpty(number)) {
            return null;
        }
        if (number.startsWith("tel:")) {
            return number;
        }
        return "tel:" + number;
    }

    public void makeCall(String number) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSUtilityController-> makeCall: number: " + number);
        }
        try {
            if (this.mContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") != -1) {
                String url = createTelUrl(number);
                if (url == null) {
                    this.imWebView.raiseError("Bad Phone Number", "makeCall");
                    return;
                }
                Intent i = new Intent("android.intent.action.CALL", Uri.parse(url.toString()));
                i.addFlags(268435456);
                this.imWebView.getExpandedActivity().startActivity(i);
                this.imWebView.fireOnLeaveApplication();
            } else if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "No Permisson to make call");
                this.imWebView.raiseError("No Permisson to make call", "makeCall");
            }
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception in making call", e);
            }
            this.imWebView.raiseError("Exception in making call", "makeCall");
        }
    }

    public void createEvent(String date, String title, String body) {
        Cursor cursor;
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSUtilityController-> createEvent: date: " + date + " title: " + title + " body: " + body);
        }
        ContentResolver cr = this.mContext.getContentResolver();
        String[] cols = {"_id", "displayName", "_sync_account"};
        if (Integer.parseInt(VERSION.SDK) == 8) {
            cursor = cr.query(Uri.parse("content://com.android.calendar/calendars"), cols, null, null, null);
        } else {
            cursor = cr.query(Uri.parse("content://calendar/calendars"), cols, null, null, null);
        }
        if (cursor == null || (cursor != null && !cursor.moveToFirst())) {
            Toast.makeText(this.mContext, "No calendar account found", 1).show();
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        if (cursor.getCount() == 1) {
            addCalendarEvent(cursor.getInt(0), date, title, body);
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < cursor.getCount(); i++) {
                HashMap hashMap = new HashMap();
                hashMap.put("ID", cursor.getString(0));
                hashMap.put("NAME", cursor.getString(1));
                hashMap.put("EMAILID", cursor.getString(2));
                arrayList.add(hashMap);
                cursor.moveToNext();
            }
            Builder builder = new Builder(this.mContext);
            builder.setTitle("Choose Calendar to save event to");
            final ArrayList arrayList2 = arrayList;
            final String str = date;
            final String str2 = title;
            final String str3 = body;
            Builder builder2 = builder;
            builder2.setSingleChoiceItems(new SimpleAdapter(this.mContext, arrayList, 17367053, new String[]{"NAME", "EMAILID"}, new int[]{16908308, 16908309}), -1, new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    JSUtilityController.this.addCalendarEvent(Integer.parseInt(((Map) arrayList2.get(which)).get("ID")), str, str2, str3);
                    dialog.cancel();
                }
            });
            builder.create().show();
        }
        cursor.close();
    }

    /* access modifiers changed from: private */
    public void addCalendarEvent(int callId, String date, String title, String body) {
        Uri newEvent;
        ContentResolver cr = this.mContext.getContentResolver();
        long dtStart = Long.parseLong(date);
        ContentValues cv = new ContentValues();
        cv.put("calendar_id", Integer.valueOf(callId));
        cv.put("title", title);
        cv.put("description", body);
        cv.put("dtstart", Long.valueOf(dtStart));
        cv.put("hasAlarm", Integer.valueOf(1));
        cv.put("dtend", Long.valueOf(dtStart + 3600000));
        if (Integer.parseInt(VERSION.SDK) == 8) {
            newEvent = cr.insert(Uri.parse("content://com.android.calendar/events"), cv);
        } else {
            newEvent = cr.insert(Uri.parse("content://calendar/events"), cv);
        }
        if (newEvent != null) {
            long id = Long.parseLong(newEvent.getLastPathSegment());
            ContentValues values = new ContentValues();
            values.put("event_id", Long.valueOf(id));
            values.put("method", Integer.valueOf(1));
            values.put("minutes", Integer.valueOf(15));
            if (Integer.parseInt(VERSION.SDK) == 8) {
                cr.insert(Uri.parse("content://com.android.calendar/reminders"), values);
            } else {
                cr.insert(Uri.parse("content://calendar/reminders"), values);
            }
        }
        Toast.makeText(this.mContext, "Event added to calendar", 0).show();
    }

    public String copyTextFromJarIntoAssetDir(String alias, String source) {
        return this.mAssetController.copyTextFromJarIntoAssetDir(alias, source);
    }

    public String writeToDiskWrap(InputStream is, String currentFile, boolean storeInHashedDirectory, String injection, String bridgePath, String mraidPath) throws IllegalStateException, IOException {
        return this.mAssetController.writeToDiskWrap(is, currentFile, storeInHashedDirectory, injection, bridgePath, mraidPath);
    }

    public void activate(String event) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSUtilityController-> activate: " + event);
        }
    }

    public void deactivate(String event) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSUtilityController-> deactivate: " + event);
        }
    }

    public void deleteOldAds() {
        this.mAssetController.deleteOldAds();
    }

    public void stopAllListeners() {
        try {
            this.mAssetController.stopAllListeners();
            this.mDisplayController.stopAllListeners();
        } catch (Exception e) {
        }
    }

    public void showAlert(String message) {
        Log.e(Constants.LOGGING_TAG, message);
    }

    public void log(String message) {
        if (Constants.DEBUG) {
            Log.v(Constants.LOGGING_TAG, "Ad Log Message: " + message);
        }
    }

    public void asyncPing(String url) {
        try {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "JSUtilityController-> asyncPing: url: " + url);
            }
            if (!URLUtil.isValidUrl(url)) {
                this.imWebView.raiseError("Invalid url", "asyncPing");
            } else {
                new RequestResponseManager(this.imWebView.getExpandedActivity()).asyncPing(url);
            }
        } catch (Exception e) {
        }
    }

    public void playAudio(String url, boolean autoPlay, boolean controls, boolean loop, String startStyle, String stopStyle, String id) {
        Log.d(Constants.LOGGING_TAG, "playAudio: url: " + url + " autoPlay: " + autoPlay + " controls: " + controls + " loop: " + loop + " startStyle: " + startStyle + " stopStyle: " + stopStyle + " id:" + id);
        this.imWebView.playAudio(url, autoPlay, controls, loop, startStyle, stopStyle, id);
    }

    public void muteAudio(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> muteAudio: ");
        this.imWebView.muteAudio(id);
    }

    public void unMuteAudio(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> unMuteAudio: ");
        this.imWebView.unMuteAudio(id);
    }

    public boolean isAudioMuted(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> isAudioMuted: ");
        return this.imWebView.isAudioMuted(id);
    }

    public void setAudioVolume(String id, int volume) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> setAudioVolume: ");
        this.imWebView.setAudioVolume(id, volume);
    }

    public int getAudioVolume(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> getAudioVolume: ");
        return this.imWebView.getAudioVolume(id);
    }

    public void seekAudio(String id, int seekPos) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> seekAudio: ");
        this.imWebView.seekAudio(id, seekPos);
    }

    public void playVideo(String url, boolean audioMuted, boolean autoPlay, boolean controls, boolean loop, String top, String left, String width, String height, String startStyle, String stopStyle, String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> playVideo: url: " + url + " audioMuted: " + audioMuted + " autoPlay: " + autoPlay + " controls: " + controls + " loop: " + loop + " x: " + top + " y: " + left + " width: " + width + " height: " + height + " startStyle: " + startStyle + " stopStyle: " + stopStyle + " id:" + id);
        Dimensions d = new Dimensions();
        d.x = Integer.parseInt(top);
        d.y = Integer.parseInt(left);
        d.width = Integer.parseInt(width);
        d.height = Integer.parseInt(height);
        this.imWebView.playVideo(url, audioMuted, autoPlay, controls, loop, d, startStyle, stopStyle, id);
    }

    public void pauseAudio(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> pauseAudio: id :" + id);
        this.imWebView.pauseAudio(id);
    }

    public void pauseVideo(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> pauseVideo: id :" + id);
        this.imWebView.pauseVideo(id);
    }

    public void closeVideo(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> closeVideo: id :" + id);
        this.imWebView.closeVideo(id);
    }

    public void hideVideo(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> hideVideo: id :" + id);
        this.imWebView.hideVideo(id);
    }

    public void showVideo(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> showVideo: id :" + id);
        this.imWebView.showVideo(id);
    }

    public void muteVideo(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> muteVideo: ");
        this.imWebView.muteVideo(id);
    }

    public void unMuteVideo(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> unMuteVideo: ");
        this.imWebView.unMuteVideo(id);
    }

    public void seekVideo(String id, int seekPos) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> seekVideo: ");
        this.imWebView.seekVideo(id, seekPos);
    }

    public boolean isVideoMuted(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> isVideoMuted: ");
        return this.imWebView.isVideoMuted(id);
    }

    public void setVideoVolume(String id, int volume) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> setVideoVolume: ");
        this.imWebView.setVideoVolume(id, volume);
    }

    public int getVideoVolume(String id) {
        Log.d(Constants.LOGGING_TAG, "JSUtilityController-> getVideoVolume: ");
        return this.imWebView.getVideoVolume(id);
    }
}
