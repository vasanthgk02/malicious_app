package com.mpl.androidapp.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.IntentFilter;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.provider.CalendarContract.Events;
import android.provider.Settings.Global;
import android.provider.Telephony.Sms;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AppsFlyerLib;
import com.badlogic.gdx.graphics.GL20;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.mpl.androidapp.BuildConfig;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.MPLSplashActivity;
import com.mpl.androidapp.R;
import com.mpl.androidapp.cleverTap.MplCtEventConstants.CtNativeLaunchInitiated;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.game.AllGame;
import com.mpl.androidapp.game.ApkInfo;
import com.mpl.androidapp.game.GameConfigGameInfo;
import com.mpl.androidapp.game.GameInfo;
import com.mpl.androidapp.game.ServerGame;
import com.mpl.androidapp.miniprofile.ct.C.Config;
import com.mpl.androidapp.miniprofile.ct.C.InternalShare;
import com.mpl.androidapp.model.GameReplayConfigModel;
import com.mpl.androidapp.notification.ApkDownloadNotificationData;
import com.mpl.androidapp.notification.NotificationBuilder;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.UserInfo;
import com.mpl.androidapp.react.modules.GameLaunchHelper;
import com.mpl.androidapp.share.ct.CtShareEventConstants.ShareEventShareInitiated;
import com.mpl.androidapp.share.utils.Keys.SharePlatform;
import com.mpl.androidapp.share.utils.Keys.SocialPkgName;
import com.mpl.androidapp.ui.ScreenshotShareReferral;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.Constant.HanselEventConstant;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.utils.MException;
import com.netcore.android.SMTConfigConstants;
import com.razorpay.AnalyticsConstants;
import com.razorpay.BaseConstants;
import io.hansel.actions.configs.HanselConfigs;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.requests.BaseRequest;

public class CommonUtils {
    public static final int BUFFER = 8192;
    public static final HashMap<String, String> GAME_COMPETITOR_APPS = new HashMap<>();
    public static final String TAG = "CommonUtils";
    public static HashSet<String> ctRemovedParams = new HashSet<>();
    public static final ArrayList<Integer> defaultReleaseNoteIcon = new ArrayList<>();
    public static final ArrayList<String> defaultReleaseNoteText = new ArrayList<>();
    public static final Gson gson = new Gson();
    public static final HashMap<String, String> hanselPlayStoreConfigs = new HashMap<>();
    public static final HashMap<String, String> hanselProConfigs = new HashMap<>();
    public static boolean isInternalUser = false;
    public static boolean isInternalUserAPICallDone = false;
    public static String mCurrentScreenName = "";
    public static FileObserver mFileObserver;
    public static ServerGame mServerGame;
    public static final ArrayList<String> requestedPermissions = new ArrayList<>();
    public static HashMap<Integer, AllGame> sAllGamesItemHashMap;
    public static HashMap<String, ApkInfo> sAllThirdPartyGamesItemHashMap;
    public static ArrayList<ApkInfo> sAllThirdPartyGamesItems;
    public static final HashMap<Integer, GameInfo> sGameInfoMap = new HashMap<>();
    public static final HashMap<String, Integer> sTeirMap = new HashMap<>();

    static {
        requestedPermissions.add("android.permission.ACCESS_WIFI_STATE");
        requestedPermissions.add("android.permission.INTERNET");
        requestedPermissions.add("android.permission.ACCESS_NETWORK_STATE");
        requestedPermissions.add("android.permission.SYSTEM_ALERT_WINDOW");
        requestedPermissions.add("android.permission.WRITE_INTERNAL_STORAGE");
        requestedPermissions.add(SMTConfigConstants.READ_STORAGE_PERMISSION_MF_KEY);
        requestedPermissions.add(SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY);
        requestedPermissions.add("android.permission.REQUEST_INSTALL_PACKAGES");
        requestedPermissions.add("android.permission.CAMERA");
        requestedPermissions.add("android.permission.READ_CONTACTS");
        requestedPermissions.add("android.permission.RECORD_AUDIO");
        requestedPermissions.add(SMTConfigConstants.LOCATION_PERMISSION_MF_KEY);
        requestedPermissions.add("android.permission.ACCESS_COARSE_LOCATION");
        requestedPermissions.add("android.permission.DOWNLOAD_WITHOUT_NOTIFICATION");
        requestedPermissions.add("android.permission.READ_PHONE_STATE");
        requestedPermissions.add("android.permission.FOREGROUND_SERVICE");
        requestedPermissions.add("android.permission.RECEIVE_BOOT_COMPLETED");
        requestedPermissions.add("com.android.vending.CHECK_LICENSE");
        requestedPermissions.add("android.permission.WAKE_LOCK");
        requestedPermissions.add("com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE");
        if (MBuildConfigUtils.isCashApp()) {
            requestedPermissions.add("com.mpl.androidapp.permission.C2D_MESSAGE");
            requestedPermissions.add("com.mpl.androidapp.permission.MIPUSH_RECEIVE");
            requestedPermissions.add("android.permission.READ_SMS");
            requestedPermissions.add("android.permission.RECEIVE_SMS");
        } else {
            requestedPermissions.add("com.mpl.androidapp.ps.permission.C2D_MESSAGE");
            requestedPermissions.add("com.mpl.androidapp.free.permission.MIPUSH_RECEIVE");
        }
        requestedPermissions.add("com.google.android.c2dm.permission.RECEIVE");
        requestedPermissions.add("android.permission.VIBRATE");
        requestedPermissions.add("com.sec.android.provider.badge.permission.READ");
        requestedPermissions.add("com.sec.android.provider.badge.permission.WRITE");
        requestedPermissions.add("com.htc.launcher.permission.READ_SETTINGS");
        requestedPermissions.add("com.htc.launcher.permission.UPDATE_SHORTCUT");
        requestedPermissions.add("com.sonyericsson.home.permission.BROADCAST_BADGE");
        requestedPermissions.add("com.sonymobile.home.permission.PROVIDER_INSERT_BADGE");
        requestedPermissions.add("com.anddoes.launcher.permission.UPDATE_COUNT");
        requestedPermissions.add("com.majeur.launcher.permission.UPDATE_BADGE");
        requestedPermissions.add("com.huawei.android.launcher.permission.CHANGE_BADGE");
        requestedPermissions.add("com.huawei.android.launcher.permission.READ_SETTINGS");
        requestedPermissions.add("com.huawei.android.launcher.permission.WRITE_SETTINGS");
        requestedPermissions.add("android.permission.READ_APP_BADGE");
        requestedPermissions.add("com.oppo.launcher.permission.READ_SETTINGS");
        requestedPermissions.add("com.oppo.launcher.permission.WRITE_SETTINGS");
        requestedPermissions.add("me.everything.badger.permission.BADGE_COUNT_READ");
        requestedPermissions.add("me.everything.badger.permission.BADGE_COUNT_WRITE");
        requestedPermissions.add("com.android.launcher.permission.INSTALL_SHORTCUT");
        requestedPermissions.add("com.android.launcher.permission.UNINSTALL_SHORTCUT");
        requestedPermissions.add("android.permission.MODIFY_AUDIO_SETTINGS");
        requestedPermissions.add("com.google.android.providers.gsf.permission.READ_GSERVICES");
        requestedPermissions.add("android.permission.REQUEST_DELETE_PACKAGES");
        requestedPermissions.add("android.permission.BLUETOOTH");
        requestedPermissions.add("android.permission.CHANGE_WIFI_STATE");
        requestedPermissions.add("android.permission.WRITE_CALENDAR");
        requestedPermissions.add("android.permission.READ_CALENDAR");
        requestedPermissions.add("android.permission.GET_PACKAGE_SIZE");
        requestedPermissions.add("android.permission.FLASHLIGHT");
        requestedPermissions.add("android.permission.REORDER_TASKS");
        requestedPermissions.add("android.permission.READ_PRIVILEGED_PHONE_STATE");
        requestedPermissions.add("android.permission.AUTHENTICATE_ACCOUNTS");
        requestedPermissions.add("android.permission.GET_ACCOUNTS");
        requestedPermissions.add("android.permission.MANAGE_ACCOUNTS");
        requestedPermissions.add("android.permission.USE_CREDENTIALS");
        requestedPermissions.add("android.permission.BLUETOOTH_SCAN");
        requestedPermissions.add("android.permission.BLUETOOTH_CONNECT");
        requestedPermissions.add("android.permission.BLUETOOTH_ADVERTISE");
        requestedPermissions.add("android.permission.MICROPHONE");
        requestedPermissions.add("com.google.android.gms.permission.AD_ID");
        requestedPermissions.add("android.permission.POST_NOTIFICATIONS");
        requestedPermissions.add("com.mpl.androidapp.free.permission.C2D_MESSAGE");
        requestedPermissions.add("com.mpl.androidapp.free.permission.MIPUSH_RECEIVE");
        HashMap<Integer, GameInfo> hashMap = sGameInfoMap;
        Integer valueOf = Integer.valueOf(1);
        GameInfo gameInfo = new GameInfo("Space Breaker", 1, false, false, true);
        hashMap.put(valueOf, gameInfo);
        HashMap<Integer, GameInfo> hashMap2 = sGameInfoMap;
        Integer valueOf2 = Integer.valueOf(2);
        GameInfo gameInfo2 = new GameInfo("Fruit Chop", 2, true, false, true);
        hashMap2.put(valueOf2, gameInfo2);
        HashMap<Integer, GameInfo> hashMap3 = sGameInfoMap;
        Integer valueOf3 = Integer.valueOf(3);
        GameInfo gameInfo3 = new GameInfo("3D Runner", 3, false, false, true);
        hashMap3.put(valueOf3, gameInfo3);
        HashMap<Integer, GameInfo> hashMap4 = sGameInfoMap;
        Integer valueOf4 = Integer.valueOf(4);
        GameInfo gameInfo4 = new GameInfo("Bubble Shooter", 4, false, false, true);
        hashMap4.put(valueOf4, gameInfo4);
        HashMap<Integer, GameInfo> hashMap5 = sGameInfoMap;
        Integer valueOf5 = Integer.valueOf(5);
        GameInfo gameInfo5 = new GameInfo("Run Out", 5, false, false, true);
        hashMap5.put(valueOf5, gameInfo5);
        HashMap<Integer, GameInfo> hashMap6 = sGameInfoMap;
        Integer valueOf6 = Integer.valueOf(6);
        GameInfo gameInfo6 = new GameInfo("Ninja Jumper", 6, false, false, true);
        hashMap6.put(valueOf6, gameInfo6);
        HashMap<Integer, GameInfo> hashMap7 = sGameInfoMap;
        Integer valueOf7 = Integer.valueOf(7);
        GameInfo gameInfo7 = new GameInfo("Monster Truck", 7, true, false, true);
        hashMap7.put(valueOf7, gameInfo7);
        HashMap<Integer, GameInfo> hashMap8 = sGameInfoMap;
        Integer valueOf8 = Integer.valueOf(8);
        GameInfo gameInfo8 = new GameInfo("Gem Crush", 8, false, false, true);
        hashMap8.put(valueOf8, gameInfo8);
        HashMap<Integer, GameInfo> hashMap9 = sGameInfoMap;
        Integer valueOf9 = Integer.valueOf(9);
        GameInfo gameInfo9 = new GameInfo("Build Up", 9, false, false, true);
        hashMap9.put(valueOf9, gameInfo9);
        HashMap<Integer, GameInfo> hashMap10 = sGameInfoMap;
        Integer valueOf10 = Integer.valueOf(10);
        GameInfo gameInfo10 = new GameInfo("Can Jump", 10, false, false, true);
        hashMap10.put(valueOf10, gameInfo10);
        HashMap<Integer, GameInfo> hashMap11 = sGameInfoMap;
        Integer valueOf11 = Integer.valueOf(11);
        GameInfo gameInfo11 = new GameInfo("Flipster", 11, true, false, true);
        hashMap11.put(valueOf11, gameInfo11);
        HashMap<Integer, GameInfo> hashMap12 = sGameInfoMap;
        Integer valueOf12 = Integer.valueOf(12);
        GameInfo gameInfo12 = new GameInfo("Fruit Dart", 12, false, false, true);
        hashMap12.put(valueOf12, gameInfo12);
        HashMap<Integer, GameInfo> hashMap13 = sGameInfoMap;
        Integer valueOf13 = Integer.valueOf(13);
        GameInfo gameInfo13 = new GameInfo("Cricket", 13, true, false, false);
        hashMap13.put(valueOf13, gameInfo13);
        HashMap<Integer, GameInfo> hashMap14 = sGameInfoMap;
        Integer valueOf14 = Integer.valueOf(14);
        GameInfo gameInfo14 = new GameInfo("Kite Up", 14, false, false, true);
        hashMap14.put(valueOf14, gameInfo14);
        HashMap<Integer, GameInfo> hashMap15 = sGameInfoMap;
        Integer valueOf15 = Integer.valueOf(15);
        GameInfo gameInfo15 = new GameInfo("Tiny Army", 15, false, false, true);
        hashMap15.put(valueOf15, gameInfo15);
        HashMap<Integer, GameInfo> hashMap16 = sGameInfoMap;
        Integer valueOf16 = Integer.valueOf(16);
        GameInfo gameInfo16 = new GameInfo("Basket Ball", 16, false, false, true);
        hashMap16.put(valueOf16, gameInfo16);
        HashMap<Integer, GameInfo> hashMap17 = sGameInfoMap;
        Integer valueOf17 = Integer.valueOf(17);
        GameInfo gameInfo17 = new GameInfo("Pro Cricket", 17, true, false, true);
        hashMap17.put(valueOf17, gameInfo17);
        HashMap<Integer, GameInfo> hashMap18 = sGameInfoMap;
        Integer valueOf18 = Integer.valueOf(18);
        GameInfo gameInfo18 = new GameInfo("Tuk Tuk Go", 18, true, false, true);
        hashMap18.put(valueOf18, gameInfo18);
        HashMap<Integer, GameInfo> hashMap19 = sGameInfoMap;
        Integer valueOf19 = Integer.valueOf(19);
        GameInfo gameInfo19 = new GameInfo("Maze Up", 19, false, false, true);
        hashMap19.put(valueOf19, gameInfo19);
        HashMap<Integer, GameInfo> hashMap20 = sGameInfoMap;
        Integer valueOf20 = Integer.valueOf(20);
        GameInfo gameInfo20 = new GameInfo("Go Ride", 20, true, false, true);
        hashMap20.put(valueOf20, gameInfo20);
        HashMap<Integer, GameInfo> hashMap21 = sGameInfoMap;
        Integer valueOf21 = Integer.valueOf(22);
        GameInfo gameInfo21 = new GameInfo("Volatile Planet", 22, false, false, true);
        hashMap21.put(valueOf21, gameInfo21);
        HashMap<Integer, GameInfo> hashMap22 = sGameInfoMap;
        Integer valueOf22 = Integer.valueOf(23);
        GameInfo gameInfo22 = new GameInfo("BloxMash", 23, false, false, true);
        hashMap22.put(valueOf22, gameInfo22);
        HashMap<Integer, GameInfo> hashMap23 = sGameInfoMap;
        Integer valueOf23 = Integer.valueOf(25);
        GameInfo gameInfo23 = new GameInfo("Tuk Tuk Go", 25, true, false, true);
        hashMap23.put(valueOf23, gameInfo23);
        HashMap<Integer, GameInfo> hashMap24 = sGameInfoMap;
        Integer valueOf24 = Integer.valueOf(26);
        GameInfo gameInfo24 = new GameInfo("Sniper", 26, true, false, true);
        hashMap24.put(valueOf24, gameInfo24);
        HashMap<Integer, GameInfo> hashMap25 = sGameInfoMap;
        Integer valueOf25 = Integer.valueOf(27);
        GameInfo gameInfo25 = new GameInfo("Foot Ball", 27, false, false, true);
        hashMap25.put(valueOf25, gameInfo25);
        HashMap<Integer, GameInfo> hashMap26 = sGameInfoMap;
        Integer valueOf26 = Integer.valueOf(28);
        GameInfo gameInfo26 = new GameInfo("Pro Cricket", 28, true, false, true);
        hashMap26.put(valueOf26, gameInfo26);
        HashMap<Integer, GameInfo> hashMap27 = sGameInfoMap;
        Integer valueOf27 = Integer.valueOf(35);
        GameInfo gameInfo27 = new GameInfo("FootBall", 35, false, false, true);
        hashMap27.put(valueOf27, gameInfo27);
        HashMap<Integer, GameInfo> hashMap28 = sGameInfoMap;
        Integer valueOf28 = Integer.valueOf(37);
        GameInfo gameInfo28 = new GameInfo("IceBreaker", 37, false, false, true);
        hashMap28.put(valueOf28, gameInfo28);
        HashMap<Integer, GameInfo> hashMap29 = sGameInfoMap;
        Integer valueOf29 = Integer.valueOf(31);
        GameInfo gameInfo29 = new GameInfo("Heli Dash", 31, true, false, true);
        hashMap29.put(valueOf29, gameInfo29);
        HashMap<Integer, GameInfo> hashMap30 = sGameInfoMap;
        Integer valueOf30 = Integer.valueOf(42);
        GameInfo gameInfo30 = new GameInfo("Fruit Slice", 42, false, false, true);
        hashMap30.put(valueOf30, gameInfo30);
        HashMap<Integer, GameInfo> hashMap31 = sGameInfoMap;
        Integer valueOf31 = Integer.valueOf(43);
        GameInfo gameInfo31 = new GameInfo("Puma Pro Cricket", 43, true, false, true);
        hashMap31.put(valueOf31, gameInfo31);
        HashMap<Integer, GameInfo> hashMap32 = sGameInfoMap;
        Integer valueOf32 = Integer.valueOf(777);
        GameInfo gameInfo32 = new GameInfo("Fantasy Cricket", 777, false, false, true);
        hashMap32.put(valueOf32, gameInfo32);
        HashMap<Integer, GameInfo> hashMap33 = sGameInfoMap;
        Integer valueOf33 = Integer.valueOf(778);
        GameInfo gameInfo33 = new GameInfo("Fantasy kabaddi ", 778, false, false, true);
        hashMap33.put(valueOf33, gameInfo33);
        HashMap<Integer, GameInfo> hashMap34 = sGameInfoMap;
        Integer valueOf34 = Integer.valueOf(GL20.GL_ONE_MINUS_DST_COLOR);
        GameInfo gameInfo34 = new GameInfo("Fantasy Football", GL20.GL_ONE_MINUS_DST_COLOR, false, false, true);
        hashMap34.put(valueOf34, gameInfo34);
        HashMap<Integer, GameInfo> hashMap35 = sGameInfoMap;
        Integer valueOf35 = Integer.valueOf(GL20.GL_SRC_ALPHA);
        GameInfo gameInfo35 = new GameInfo("Fantasy Stock", GL20.GL_SRC_ALPHA, false, false, true);
        hashMap35.put(valueOf35, gameInfo35);
        HashMap<Integer, GameInfo> hashMap36 = sGameInfoMap;
        Integer valueOf36 = Integer.valueOf(GL20.GL_SRC_ALPHA_SATURATE);
        GameInfo gameInfo36 = new GameInfo("Fantasy Basketball", GL20.GL_SRC_ALPHA, false, false, true);
        hashMap36.put(valueOf36, gameInfo36);
        HashMap<Integer, GameInfo> hashMap37 = sGameInfoMap;
        Integer valueOf37 = Integer.valueOf(65);
        GameInfo gameInfo37 = new GameInfo("Fruit Slice", 65, false, false, true);
        hashMap37.put(valueOf37, gameInfo37);
        HashMap<Integer, GameInfo> hashMap38 = sGameInfoMap;
        Integer valueOf38 = Integer.valueOf(71);
        GameInfo gameInfo38 = new GameInfo("Space Combat", 71, false, false, true);
        hashMap38.put(valueOf38, gameInfo38);
        HashMap<Integer, GameInfo> hashMap39 = sGameInfoMap;
        Integer valueOf39 = Integer.valueOf(73);
        GameInfo gameInfo39 = new GameInfo("Rage Road", 73, false, false, true);
        hashMap39.put(valueOf39, gameInfo39);
        HashMap<Integer, GameInfo> hashMap40 = sGameInfoMap;
        Integer valueOf40 = Integer.valueOf(103);
        GameInfo gameInfo40 = new GameInfo("Ice Jump", 103, false, false, true);
        hashMap40.put(valueOf40, gameInfo40);
        HashMap<Integer, GameInfo> hashMap41 = sGameInfoMap;
        Integer valueOf41 = Integer.valueOf(104);
        GameInfo gameInfo41 = new GameInfo("Run Out", 104, false, false, true);
        hashMap41.put(valueOf41, gameInfo41);
        HashMap<Integer, GameInfo> hashMap42 = sGameInfoMap;
        Integer valueOf42 = Integer.valueOf(154);
        GameInfo gameInfo42 = new GameInfo("Run out new", 154, false, false, true);
        hashMap42.put(valueOf42, gameInfo42);
        HashMap<Integer, GameInfo> hashMap43 = sGameInfoMap;
        Integer valueOf43 = Integer.valueOf(155);
        GameInfo gameInfo43 = new GameInfo("Runner No1 new", 155, false, false, true);
        hashMap43.put(valueOf43, gameInfo43);
        HashMap<Integer, GameInfo> hashMap44 = sGameInfoMap;
        Integer valueOf44 = Integer.valueOf(121);
        GameInfo gameInfo44 = new GameInfo("Fruit Cutter", 121, false, false, true);
        hashMap44.put(valueOf44, gameInfo44);
        HashMap<Integer, GameInfo> hashMap45 = sGameInfoMap;
        Integer valueOf45 = Integer.valueOf(156);
        GameInfo gameInfo45 = new GameInfo("Bubble Shooter", 156, false, false, true);
        hashMap45.put(valueOf45, gameInfo45);
        HashMap<Integer, GameInfo> hashMap46 = sGameInfoMap;
        Integer valueOf46 = Integer.valueOf(195);
        GameInfo gameInfo46 = new GameInfo("Cube Solitaire", 195, false, false, true);
        hashMap46.put(valueOf46, gameInfo46);
        HashMap<Integer, GameInfo> hashMap47 = sGameInfoMap;
        Integer valueOf47 = Integer.valueOf(184);
        GameInfo gameInfo47 = new GameInfo("Spider Solitaire", 184, false, false, true);
        hashMap47.put(valueOf47, gameInfo47);
        HashMap<Integer, GameInfo> hashMap48 = sGameInfoMap;
        Integer valueOf48 = Integer.valueOf(112);
        GameInfo gameInfo48 = new GameInfo("Solitaire", 112, false, false, true);
        hashMap48.put(valueOf48, gameInfo48);
        HashMap<Integer, GameInfo> hashMap49 = sGameInfoMap;
        Integer valueOf49 = Integer.valueOf(163);
        GameInfo gameInfo49 = new GameInfo("21puzzle", 163, false, true, true);
        hashMap49.put(valueOf49, gameInfo49);
        HashMap<Integer, GameInfo> hashMap50 = sGameInfoMap;
        Integer valueOf50 = Integer.valueOf(192);
        GameInfo gameInfo50 = new GameInfo("bowling", 192, true, true, true);
        hashMap50.put(valueOf50, gameInfo50);
        HashMap<Integer, GameInfo> hashMap51 = sGameInfoMap;
        Integer valueOf51 = Integer.valueOf(166);
        GameInfo gameInfo51 = new GameInfo("Block puzzle", 166, false, true, true);
        hashMap51.put(valueOf51, gameInfo51);
        HashMap<Integer, GameInfo> hashMap52 = sGameInfoMap;
        Integer valueOf52 = Integer.valueOf(178);
        GameInfo gameInfo52 = new GameInfo("Base Ball", 178, true, true, true);
        hashMap52.put(valueOf52, gameInfo52);
        HashMap<Integer, GameInfo> hashMap53 = sGameInfoMap;
        Integer valueOf53 = Integer.valueOf(1000195);
        GameInfo gameInfo53 = new GameInfo("Cube Solitaire", 1000195, false, false, true);
        hashMap53.put(valueOf53, gameInfo53);
        HashMap<Integer, GameInfo> hashMap54 = sGameInfoMap;
        Integer valueOf54 = Integer.valueOf(1000002);
        GameInfo gameInfo54 = new GameInfo("Fruit Chop", 1000002, true, true, true);
        hashMap54.put(valueOf54, gameInfo54);
        HashMap<Integer, GameInfo> hashMap55 = sGameInfoMap;
        Integer valueOf55 = Integer.valueOf(1000007);
        GameInfo gameInfo55 = new GameInfo("Monster Truck", 1000007, true, true, true);
        hashMap55.put(valueOf55, gameInfo55);
        HashMap<Integer, GameInfo> hashMap56 = sGameInfoMap;
        Integer valueOf56 = Integer.valueOf(1000017);
        GameInfo gameInfo56 = new GameInfo("Pro Cricket", 1000017, true, true, true);
        hashMap56.put(valueOf56, gameInfo56);
        HashMap<Integer, GameInfo> hashMap57 = sGameInfoMap;
        Integer valueOf57 = Integer.valueOf(1000011);
        GameInfo gameInfo57 = new GameInfo("Flipster", 1000011, true, true, true);
        hashMap57.put(valueOf57, gameInfo57);
        HashMap<Integer, GameInfo> hashMap58 = sGameInfoMap;
        Integer valueOf58 = Integer.valueOf(1000005);
        GameInfo gameInfo58 = new GameInfo("Run Out", 1000005, false, true, true);
        hashMap58.put(valueOf58, gameInfo58);
        HashMap<Integer, GameInfo> hashMap59 = sGameInfoMap;
        Integer valueOf59 = Integer.valueOf(1000154);
        GameInfo gameInfo59 = new GameInfo("Run out new", 1000154, false, true, true);
        hashMap59.put(valueOf59, gameInfo59);
        HashMap<Integer, GameInfo> hashMap60 = sGameInfoMap;
        Integer valueOf60 = Integer.valueOf(1000155);
        GameInfo gameInfo60 = new GameInfo("Runner No1 new", 1000155, false, true, true);
        hashMap60.put(valueOf60, gameInfo60);
        HashMap<Integer, GameInfo> hashMap61 = sGameInfoMap;
        Integer valueOf61 = Integer.valueOf(1000012);
        GameInfo gameInfo61 = new GameInfo("Fruit Dart", 1000012, false, true, true);
        hashMap61.put(valueOf61, gameInfo61);
        HashMap<Integer, GameInfo> hashMap62 = sGameInfoMap;
        Integer valueOf62 = Integer.valueOf(1000003);
        GameInfo gameInfo62 = new GameInfo("3D Runner", 1000003, false, true, true);
        hashMap62.put(valueOf62, gameInfo62);
        HashMap<Integer, GameInfo> hashMap63 = sGameInfoMap;
        Integer valueOf63 = Integer.valueOf(1000021);
        GameInfo gameInfo63 = new GameInfo("Pool", 1000021, true, true, true);
        hashMap63.put(valueOf63, gameInfo63);
        HashMap<Integer, GameInfo> hashMap64 = sGameInfoMap;
        Integer valueOf64 = Integer.valueOf(1000019);
        GameInfo gameInfo64 = new GameInfo("Maze Up", 1000019, false, true, true);
        hashMap64.put(valueOf64, gameInfo64);
        HashMap<Integer, GameInfo> hashMap65 = sGameInfoMap;
        Integer valueOf65 = Integer.valueOf(1000020);
        GameInfo gameInfo65 = new GameInfo("Go Ride", 1000020, true, true, true);
        hashMap65.put(valueOf65, gameInfo65);
        HashMap<Integer, GameInfo> hashMap66 = sGameInfoMap;
        Integer valueOf66 = Integer.valueOf(1000023);
        GameInfo gameInfo66 = new GameInfo("BloxMash", 1000023, false, true, true);
        hashMap66.put(valueOf66, gameInfo66);
        HashMap<Integer, GameInfo> hashMap67 = sGameInfoMap;
        Integer valueOf67 = Integer.valueOf(1000024);
        GameInfo gameInfo67 = new GameInfo("Carrom", 1000024, false, true, true);
        hashMap67.put(valueOf67, gameInfo67);
        HashMap<Integer, GameInfo> hashMap68 = sGameInfoMap;
        Integer valueOf68 = Integer.valueOf(1000028);
        GameInfo gameInfo68 = new GameInfo("Pro Cricket", 1000028, true, true, true);
        hashMap68.put(valueOf68, gameInfo68);
        HashMap<Integer, GameInfo> hashMap69 = sGameInfoMap;
        Integer valueOf69 = Integer.valueOf(1000029);
        GameInfo gameInfo69 = new GameInfo("Pool", 1000029, true, false, true);
        hashMap69.put(valueOf69, gameInfo69);
        HashMap<Integer, GameInfo> hashMap70 = sGameInfoMap;
        Integer valueOf70 = Integer.valueOf(1000030);
        GameInfo gameInfo70 = new GameInfo("Carrom", 1000030, false, true, true);
        hashMap70.put(valueOf70, gameInfo70);
        HashMap<Integer, GameInfo> hashMap71 = sGameInfoMap;
        Integer valueOf71 = Integer.valueOf(1000033);
        GameInfo gameInfo71 = new GameInfo("Pool", 1000033, true, false, true);
        hashMap71.put(valueOf71, gameInfo71);
        HashMap<Integer, GameInfo> hashMap72 = sGameInfoMap;
        Integer valueOf72 = Integer.valueOf(1000034);
        GameInfo gameInfo72 = new GameInfo("Carrom", 1000034, false, true, true);
        hashMap72.put(valueOf72, gameInfo72);
        HashMap<Integer, GameInfo> hashMap73 = sGameInfoMap;
        Integer valueOf73 = Integer.valueOf(1000039);
        GameInfo gameInfo73 = new GameInfo("Pool", 1000039, true, false, true);
        hashMap73.put(valueOf73, gameInfo73);
        HashMap<Integer, GameInfo> hashMap74 = sGameInfoMap;
        Integer valueOf74 = Integer.valueOf(1000040);
        GameInfo gameInfo74 = new GameInfo("Ludo", 1000040, false, false, true);
        hashMap74.put(valueOf74, gameInfo74);
        HashMap<Integer, GameInfo> hashMap75 = sGameInfoMap;
        Integer valueOf75 = Integer.valueOf(1000041);
        GameInfo gameInfo75 = new GameInfo("ShootOut", 1000041, false, false, true);
        hashMap75.put(valueOf75, gameInfo75);
        HashMap<Integer, GameInfo> hashMap76 = sGameInfoMap;
        Integer valueOf76 = Integer.valueOf(1000043);
        GameInfo gameInfo76 = new GameInfo("Puma Pro Cricket", 1000043, true, true, true);
        hashMap76.put(valueOf76, gameInfo76);
        HashMap<Integer, GameInfo> hashMap77 = sGameInfoMap;
        Integer valueOf77 = Integer.valueOf(1000038);
        GameInfo gameInfo77 = new GameInfo("Chess", 1000038, false, true, true);
        hashMap77.put(valueOf77, gameInfo77);
        HashMap<Integer, GameInfo> hashMap78 = sGameInfoMap;
        Integer valueOf78 = Integer.valueOf(1000047);
        GameInfo gameInfo78 = new GameInfo("ShootOut", 1000047, false, true, true);
        hashMap78.put(valueOf78, gameInfo78);
        HashMap<Integer, GameInfo> hashMap79 = sGameInfoMap;
        Integer valueOf79 = Integer.valueOf(1000049);
        GameInfo gameInfo79 = new GameInfo("Chess", 1000049, false, true, true);
        hashMap79.put(valueOf79, gameInfo79);
        HashMap<Integer, GameInfo> hashMap80 = sGameInfoMap;
        Integer valueOf80 = Integer.valueOf(1000048);
        GameInfo gameInfo80 = new GameInfo("Bump", 1000048, false, true, true);
        hashMap80.put(valueOf80, gameInfo80);
        HashMap<Integer, GameInfo> hashMap81 = sGameInfoMap;
        Integer valueOf81 = Integer.valueOf(1000050);
        GameInfo gameInfo81 = new GameInfo("Chess", 1000050, false, true, true);
        hashMap81.put(valueOf81, gameInfo81);
        HashMap<Integer, GameInfo> hashMap82 = sGameInfoMap;
        Integer valueOf82 = Integer.valueOf(1000051);
        GameInfo gameInfo82 = new GameInfo("Chess", 1000051, false, true, true);
        hashMap82.put(valueOf82, gameInfo82);
        HashMap<Integer, GameInfo> hashMap83 = sGameInfoMap;
        Integer valueOf83 = Integer.valueOf(1000044);
        GameInfo gameInfo83 = new GameInfo("Rummy", 1000044, true, true, true);
        hashMap83.put(valueOf83, gameInfo83);
        HashMap<Integer, GameInfo> hashMap84 = sGameInfoMap;
        Integer valueOf84 = Integer.valueOf(1000052);
        GameInfo gameInfo84 = new GameInfo("Chess", 1000052, true, true, true);
        hashMap84.put(valueOf84, gameInfo84);
        HashMap<Integer, GameInfo> hashMap85 = sGameInfoMap;
        Integer valueOf85 = Integer.valueOf(1000054);
        GameInfo gameInfo85 = new GameInfo("Rummy", 1000054, true, true, true);
        hashMap85.put(valueOf85, gameInfo85);
        HashMap<Integer, GameInfo> hashMap86 = sGameInfoMap;
        Integer valueOf86 = Integer.valueOf(1000056);
        GameInfo gameInfo86 = new GameInfo("Pool Rummy", 1000056, true, true, true);
        hashMap86.put(valueOf86, gameInfo86);
        HashMap<Integer, GameInfo> hashMap87 = sGameInfoMap;
        Integer valueOf87 = Integer.valueOf(1000058);
        GameInfo gameInfo87 = new GameInfo("Points Rummy", 1000058, true, true, true);
        hashMap87.put(valueOf87, gameInfo87);
        HashMap<Integer, GameInfo> hashMap88 = sGameInfoMap;
        Integer valueOf88 = Integer.valueOf(1000063);
        GameInfo gameInfo88 = new GameInfo("Points Rummy", 1000063, true, true, true);
        hashMap88.put(valueOf88, gameInfo88);
        HashMap<Integer, GameInfo> hashMap89 = sGameInfoMap;
        Integer valueOf89 = Integer.valueOf(1000060);
        GameInfo gameInfo89 = new GameInfo("Cricket Clash", 1000060, true, true, true);
        hashMap89.put(valueOf89, gameInfo89);
        HashMap<Integer, GameInfo> hashMap90 = sGameInfoMap;
        Integer valueOf90 = Integer.valueOf(1000066);
        GameInfo gameInfo90 = new GameInfo("Pool", 1000066, true, true, true);
        hashMap90.put(valueOf90, gameInfo90);
        HashMap<Integer, GameInfo> hashMap91 = sGameInfoMap;
        Integer valueOf91 = Integer.valueOf(1000068);
        GameInfo gameInfo91 = new GameInfo("Rummy", 1000068, true, true, true);
        hashMap91.put(valueOf91, gameInfo91);
        HashMap<Integer, GameInfo> hashMap92 = sGameInfoMap;
        Integer valueOf92 = Integer.valueOf(1000069);
        GameInfo gameInfo92 = new GameInfo("Rummy", 1000069, true, true, true);
        hashMap92.put(valueOf92, gameInfo92);
        HashMap<Integer, GameInfo> hashMap93 = sGameInfoMap;
        Integer valueOf93 = Integer.valueOf(1000071);
        GameInfo gameInfo93 = new GameInfo("Space Combat", 1000071, false, true, true);
        hashMap93.put(valueOf93, gameInfo93);
        HashMap<Integer, GameInfo> hashMap94 = sGameInfoMap;
        Integer valueOf94 = Integer.valueOf(1000073);
        GameInfo gameInfo94 = new GameInfo("Rage Road", 1000073, false, true, true);
        hashMap94.put(valueOf94, gameInfo94);
        HashMap<Integer, GameInfo> hashMap95 = sGameInfoMap;
        Integer valueOf95 = Integer.valueOf(1000077);
        GameInfo gameInfo95 = new GameInfo("Points Rummy", 1000077, true, true, true);
        hashMap95.put(valueOf95, gameInfo95);
        HashMap<Integer, GameInfo> hashMap96 = sGameInfoMap;
        Integer valueOf96 = Integer.valueOf(1000078);
        GameInfo gameInfo96 = new GameInfo("Pool Rummy", 1000078, true, true, true);
        hashMap96.put(valueOf96, gameInfo96);
        HashMap<Integer, GameInfo> hashMap97 = sGameInfoMap;
        Integer valueOf97 = Integer.valueOf(1000004);
        GameInfo gameInfo97 = new GameInfo("Bubble Shooter", 1000004, false, true, true);
        hashMap97.put(valueOf97, gameInfo97);
        HashMap<Integer, GameInfo> hashMap98 = sGameInfoMap;
        Integer valueOf98 = Integer.valueOf(1000009);
        GameInfo gameInfo98 = new GameInfo("Build Up", 1000009, false, true, true);
        hashMap98.put(valueOf98, gameInfo98);
        HashMap<Integer, GameInfo> hashMap99 = sGameInfoMap;
        Integer valueOf99 = Integer.valueOf(1000065);
        GameInfo gameInfo99 = new GameInfo("Fruit Slice", 1000065, false, true, true);
        hashMap99.put(valueOf99, gameInfo99);
        HashMap<Integer, GameInfo> hashMap100 = sGameInfoMap;
        Integer valueOf100 = Integer.valueOf(1000076);
        GameInfo gameInfo100 = new GameInfo("Cricket Clash", 1000076, true, true, true);
        hashMap100.put(valueOf100, gameInfo100);
        HashMap<Integer, GameInfo> hashMap101 = sGameInfoMap;
        Integer valueOf101 = Integer.valueOf(1000084);
        GameInfo gameInfo101 = new GameInfo("Cricket Clash", 1000084, true, true, true);
        hashMap101.put(valueOf101, gameInfo101);
        HashMap<Integer, GameInfo> hashMap102 = sGameInfoMap;
        Integer valueOf102 = Integer.valueOf(1000072);
        GameInfo gameInfo102 = new GameInfo("Checkers", 1000072, false, true, true);
        hashMap102.put(valueOf102, gameInfo102);
        HashMap<Integer, GameInfo> hashMap103 = sGameInfoMap;
        Integer valueOf103 = Integer.valueOf(1000082);
        GameInfo gameInfo103 = new GameInfo("Math Clash", 1000082, false, true, true);
        hashMap103.put(valueOf103, gameInfo103);
        HashMap<Integer, GameInfo> hashMap104 = sGameInfoMap;
        Integer valueOf104 = Integer.valueOf(1000061);
        GameInfo gameInfo104 = new GameInfo("Carrom", 1000061, false, true, true);
        hashMap104.put(valueOf104, gameInfo104);
        HashMap<Integer, GameInfo> hashMap105 = sGameInfoMap;
        Integer valueOf105 = Integer.valueOf(1000080);
        GameInfo gameInfo105 = new GameInfo("2048 Clash", 1000080, false, true, true);
        hashMap105.put(valueOf105, gameInfo105);
        HashMap<Integer, GameInfo> hashMap106 = sGameInfoMap;
        Integer valueOf106 = Integer.valueOf(1000090);
        GameInfo gameInfo106 = new GameInfo("Finger Soccer", 1000090, true, true, true);
        hashMap106.put(valueOf106, gameInfo106);
        HashMap<Integer, GameInfo> hashMap107 = sGameInfoMap;
        Integer valueOf107 = Integer.valueOf(1000098);
        GameInfo gameInfo107 = new GameInfo("Word Connect", 1000098, false, true, true);
        hashMap107.put(valueOf107, gameInfo107);
        HashMap<Integer, GameInfo> hashMap108 = sGameInfoMap;
        Integer valueOf108 = Integer.valueOf(1000092);
        GameInfo gameInfo108 = new GameInfo("Battle Fleet", 1000092, true, true, true);
        hashMap108.put(valueOf108, gameInfo108);
        HashMap<Integer, GameInfo> hashMap109 = sGameInfoMap;
        Integer valueOf109 = Integer.valueOf(1000086);
        GameInfo gameInfo109 = new GameInfo("Wild Rush", 1000086, false, true, true);
        hashMap109.put(valueOf109, gameInfo109);
        HashMap<Integer, GameInfo> hashMap110 = sGameInfoMap;
        Integer valueOf110 = Integer.valueOf(1000081);
        GameInfo gameInfo110 = new GameInfo("Solitaire", 1000081, false, true, true);
        hashMap110.put(valueOf110, gameInfo110);
        HashMap<Integer, GameInfo> hashMap111 = sGameInfoMap;
        Integer valueOf111 = Integer.valueOf(1000104);
        GameInfo gameInfo111 = new GameInfo("Run Out", 1000104, false, true, true);
        hashMap111.put(valueOf111, gameInfo111);
        HashMap<Integer, GameInfo> hashMap112 = sGameInfoMap;
        Integer valueOf112 = Integer.valueOf(1000109);
        GameInfo gameInfo112 = new GameInfo("2048 new", 1000109, false, true, true);
        hashMap112.put(valueOf112, gameInfo112);
        HashMap<Integer, GameInfo> hashMap113 = sGameInfoMap;
        Integer valueOf113 = Integer.valueOf(1000106);
        GameInfo gameInfo113 = new GameInfo("Deals Rummy", 1000106, true, true, true);
        hashMap113.put(valueOf113, gameInfo113);
        HashMap<Integer, GameInfo> hashMap114 = sGameInfoMap;
        Integer valueOf114 = Integer.valueOf(1000099);
        GameInfo gameInfo114 = new GameInfo("Archery", 1000099, false, true, true);
        hashMap114.put(valueOf114, gameInfo114);
        HashMap<Integer, GameInfo> hashMap115 = sGameInfoMap;
        Integer valueOf115 = Integer.valueOf(1000046);
        GameInfo gameInfo115 = new GameInfo("Pirate Tanks", 1000046, true, true, true);
        hashMap115.put(valueOf115, gameInfo115);
        HashMap<Integer, GameInfo> hashMap116 = sGameInfoMap;
        Integer valueOf116 = Integer.valueOf(1000115);
        GameInfo gameInfo116 = new GameInfo("Points Rummy", 1000115, true, true, true);
        hashMap116.put(valueOf116, gameInfo116);
        HashMap<Integer, GameInfo> hashMap117 = sGameInfoMap;
        Integer valueOf117 = Integer.valueOf(1000114);
        GameInfo gameInfo117 = new GameInfo("Pool Rummy", 1000114, true, true, true);
        hashMap117.put(valueOf117, gameInfo117);
        HashMap<Integer, GameInfo> hashMap118 = sGameInfoMap;
        Integer valueOf118 = Integer.valueOf(1000107);
        GameInfo gameInfo118 = new GameInfo("2048 MM", 1000107, false, true, true);
        hashMap118.put(valueOf118, gameInfo118);
        HashMap<Integer, GameInfo> hashMap119 = sGameInfoMap;
        Integer valueOf119 = Integer.valueOf(1000111);
        GameInfo gameInfo119 = new GameInfo("Cricket Clash", 1000111, true, true, true);
        hashMap119.put(valueOf119, gameInfo119);
        HashMap<Integer, GameInfo> hashMap120 = sGameInfoMap;
        Integer valueOf120 = Integer.valueOf(1000101);
        GameInfo gameInfo120 = new GameInfo("Hoop Clash", 1000101, true, true, true);
        hashMap120.put(valueOf120, gameInfo120);
        HashMap<Integer, GameInfo> hashMap121 = sGameInfoMap;
        Integer valueOf121 = Integer.valueOf(1000113);
        GameInfo gameInfo121 = new GameInfo("War tanks", 1000113, true, true, true);
        hashMap121.put(valueOf121, gameInfo121);
        HashMap<Integer, GameInfo> hashMap122 = sGameInfoMap;
        Integer valueOf122 = Integer.valueOf(1000125);
        GameInfo gameInfo122 = new GameInfo("Point Rummy", 1000125, true, true, true);
        hashMap122.put(valueOf122, gameInfo122);
        HashMap<Integer, GameInfo> hashMap123 = sGameInfoMap;
        Integer valueOf123 = Integer.valueOf(1000126);
        GameInfo gameInfo123 = new GameInfo("Pool Rummy", 1000126, true, true, true);
        hashMap123.put(valueOf123, gameInfo123);
        HashMap<Integer, GameInfo> hashMap124 = sGameInfoMap;
        Integer valueOf124 = Integer.valueOf(1000127);
        GameInfo gameInfo124 = new GameInfo("Deals Rummy", 1000127, true, true, true);
        hashMap124.put(valueOf124, gameInfo124);
        HashMap<Integer, GameInfo> hashMap125 = sGameInfoMap;
        Integer valueOf125 = Integer.valueOf(1000112);
        GameInfo gameInfo125 = new GameInfo("Solitaire MM", 1000112, false, true, true);
        hashMap125.put(valueOf125, gameInfo125);
        HashMap<Integer, GameInfo> hashMap126 = sGameInfoMap;
        Integer valueOf126 = Integer.valueOf(1000128);
        GameInfo gameInfo126 = new GameInfo("2048", 1000128, false, true, true);
        hashMap126.put(valueOf126, gameInfo126);
        HashMap<Integer, GameInfo> hashMap127 = sGameInfoMap;
        Integer valueOf127 = Integer.valueOf(1000129);
        GameInfo gameInfo127 = new GameInfo("2048", 1000129, false, true, true);
        hashMap127.put(valueOf127, gameInfo127);
        HashMap<Integer, GameInfo> hashMap128 = sGameInfoMap;
        Integer valueOf128 = Integer.valueOf(1000100);
        GameInfo gameInfo128 = new GameInfo("8 Ball Pool", 1000100, true, true, true);
        hashMap128.put(valueOf128, gameInfo128);
        HashMap<Integer, GameInfo> hashMap129 = sGameInfoMap;
        Integer valueOf129 = Integer.valueOf(1000153);
        GameInfo gameInfo129 = new GameInfo("8 Ball Pool", 1000153, true, true, true);
        hashMap129.put(valueOf129, gameInfo129);
        HashMap<Integer, GameInfo> hashMap130 = sGameInfoMap;
        Integer valueOf130 = Integer.valueOf(1000130);
        GameInfo gameInfo130 = new GameInfo("Archery", 1000130, false, true, true);
        hashMap130.put(valueOf130, gameInfo130);
        HashMap<Integer, GameInfo> hashMap131 = sGameInfoMap;
        Integer valueOf131 = Integer.valueOf(1000121);
        GameInfo gameInfo131 = new GameInfo("Fruit Cutter", 1000121, false, true, true);
        hashMap131.put(valueOf131, gameInfo131);
        HashMap<Integer, GameInfo> hashMap132 = sGameInfoMap;
        Integer valueOf132 = Integer.valueOf(1000136);
        GameInfo gameInfo132 = new GameInfo("Soccer Royale", 1000136, true, true, true);
        hashMap132.put(valueOf132, gameInfo132);
        HashMap<Integer, GameInfo> hashMap133 = sGameInfoMap;
        Integer valueOf133 = Integer.valueOf(1000135);
        GameInfo gameInfo133 = new GameInfo("Archery", 1000135, false, true, true);
        hashMap133.put(valueOf133, gameInfo133);
        HashMap<Integer, GameInfo> hashMap134 = sGameInfoMap;
        Integer valueOf134 = Integer.valueOf(1000134);
        GameInfo gameInfo134 = new GameInfo("Poker Puzzle", 1000134, false, true, true);
        hashMap134.put(valueOf134, gameInfo134);
        HashMap<Integer, GameInfo> hashMap135 = sGameInfoMap;
        Integer valueOf135 = Integer.valueOf(1000139);
        GameInfo gameInfo135 = new GameInfo("Jungle Fight", 1000139, false, true, true);
        hashMap135.put(valueOf135, gameInfo135);
        HashMap<Integer, GameInfo> hashMap136 = sGameInfoMap;
        Integer valueOf136 = Integer.valueOf(1000105);
        GameInfo gameInfo136 = new GameInfo("Cell Breakers", 1000105, false, true, true);
        hashMap136.put(valueOf136, gameInfo136);
        HashMap<Integer, GameInfo> hashMap137 = sGameInfoMap;
        Integer valueOf137 = Integer.valueOf(1000141);
        GameInfo gameInfo137 = new GameInfo("Point Rummy New1", 1000141, true, true, true);
        hashMap137.put(valueOf137, gameInfo137);
        HashMap<Integer, GameInfo> hashMap138 = sGameInfoMap;
        Integer valueOf138 = Integer.valueOf(1000142);
        GameInfo gameInfo138 = new GameInfo("Pool Rummy new1", 1000142, true, true, true);
        hashMap138.put(valueOf138, gameInfo138);
        HashMap<Integer, GameInfo> hashMap139 = sGameInfoMap;
        Integer valueOf139 = Integer.valueOf(1000143);
        GameInfo gameInfo139 = new GameInfo("Deals Rummy new1", 1000143, true, true, true);
        hashMap139.put(valueOf139, gameInfo139);
        HashMap<Integer, GameInfo> hashMap140 = sGameInfoMap;
        Integer valueOf140 = Integer.valueOf(1000145);
        GameInfo gameInfo140 = new GameInfo("Carrom New", 1000145, false, true, true);
        hashMap140.put(valueOf140, gameInfo140);
        HashMap<Integer, GameInfo> hashMap141 = sGameInfoMap;
        Integer valueOf141 = Integer.valueOf(1000144);
        GameInfo gameInfo141 = new GameInfo("Knife Hit", 1000144, false, true, true);
        hashMap141.put(valueOf141, gameInfo141);
        HashMap<Integer, GameInfo> hashMap142 = sGameInfoMap;
        Integer valueOf142 = Integer.valueOf(1000118);
        GameInfo gameInfo142 = new GameInfo("TINY MILITIA", 1000118, true, true, true);
        hashMap142.put(valueOf142, gameInfo142);
        HashMap<Integer, GameInfo> hashMap143 = sGameInfoMap;
        Integer valueOf143 = Integer.valueOf(1000161);
        GameInfo gameInfo143 = new GameInfo("TINY MILITIA", 1000161, true, true, true);
        hashMap143.put(valueOf143, gameInfo143);
        HashMap<Integer, GameInfo> hashMap144 = sGameInfoMap;
        Integer valueOf144 = Integer.valueOf(1000133);
        GameInfo gameInfo144 = new GameInfo("Golf clash", 1000133, false, true, true);
        hashMap144.put(valueOf144, gameInfo144);
        HashMap<Integer, GameInfo> hashMap145 = sGameInfoMap;
        Integer valueOf145 = Integer.valueOf(1000151);
        GameInfo gameInfo145 = new GameInfo("Archery", 1000151, false, true, true);
        hashMap145.put(valueOf145, gameInfo145);
        HashMap<Integer, GameInfo> hashMap146 = sGameInfoMap;
        Integer valueOf146 = Integer.valueOf(1000102);
        GameInfo gameInfo146 = new GameInfo("Word Antakshari", 1000102, false, true, true);
        hashMap146.put(valueOf146, gameInfo146);
        HashMap<Integer, GameInfo> hashMap147 = sGameInfoMap;
        Integer valueOf147 = Integer.valueOf(1000156);
        GameInfo gameInfo147 = new GameInfo("Bubble Shooter 2", 1000156, false, true, true);
        hashMap147.put(valueOf147, gameInfo147);
        HashMap<Integer, GameInfo> hashMap148 = sGameInfoMap;
        Integer valueOf148 = Integer.valueOf(1000158);
        GameInfo gameInfo148 = new GameInfo("Word Search", 1000158, false, true, true);
        hashMap148.put(valueOf148, gameInfo148);
        HashMap<Integer, GameInfo> hashMap149 = sGameInfoMap;
        Integer valueOf149 = Integer.valueOf(1000162);
        GameInfo gameInfo149 = new GameInfo("Cricket Clash", 1000162, true, true, true);
        hashMap149.put(valueOf149, gameInfo149);
        HashMap<Integer, GameInfo> hashMap150 = sGameInfoMap;
        Integer valueOf150 = Integer.valueOf(1000169);
        GameInfo gameInfo150 = new GameInfo("Point Rummy", 1000169, true, true, true);
        hashMap150.put(valueOf150, gameInfo150);
        HashMap<Integer, GameInfo> hashMap151 = sGameInfoMap;
        Integer valueOf151 = Integer.valueOf(1000163);
        GameInfo gameInfo151 = new GameInfo("21puzzle", 1000163, false, true, true);
        hashMap151.put(valueOf151, gameInfo151);
        HashMap<Integer, GameInfo> hashMap152 = sGameInfoMap;
        Integer valueOf152 = Integer.valueOf(1000166);
        GameInfo gameInfo152 = new GameInfo("Block puzzle", 1000166, false, true, true);
        hashMap152.put(valueOf152, gameInfo152);
        HashMap<Integer, GameInfo> hashMap153 = sGameInfoMap;
        Integer valueOf153 = Integer.valueOf(1000168);
        GameInfo gameInfo153 = new GameInfo("Ball blaster", 1000168, false, true, true);
        hashMap153.put(valueOf153, gameInfo153);
        HashMap<Integer, GameInfo> hashMap154 = sGameInfoMap;
        Integer valueOf154 = Integer.valueOf(1000165);
        GameInfo gameInfo154 = new GameInfo("Puzzle & Warriors", 1000165, false, true, true);
        hashMap154.put(valueOf154, gameInfo154);
        HashMap<Integer, GameInfo> hashMap155 = sGameInfoMap;
        Integer valueOf155 = Integer.valueOf(1000171);
        GameInfo gameInfo155 = new GameInfo("Deals Rummy", 1000171, true, true, true);
        hashMap155.put(valueOf155, gameInfo155);
        HashMap<Integer, GameInfo> hashMap156 = sGameInfoMap;
        Integer valueOf156 = Integer.valueOf(1000170);
        GameInfo gameInfo156 = new GameInfo("Pool Rummy", 1000170, true, true, true);
        hashMap156.put(valueOf156, gameInfo156);
        HashMap<Integer, GameInfo> hashMap157 = sGameInfoMap;
        Integer valueOf157 = Integer.valueOf(1000178);
        GameInfo gameInfo157 = new GameInfo("Base Ball", 1000178, true, true, true);
        hashMap157.put(valueOf157, gameInfo157);
        HashMap<Integer, GameInfo> hashMap158 = sGameInfoMap;
        Integer valueOf158 = Integer.valueOf(Constant.ASSETS_CODE_MERGE_VERSION);
        GameInfo gameInfo158 = new GameInfo("xoxo", Constant.ASSETS_CODE_MERGE_VERSION, false, true, true);
        hashMap158.put(valueOf158, gameInfo158);
        HashMap<Integer, GameInfo> hashMap159 = sGameInfoMap;
        Integer valueOf159 = Integer.valueOf(1000152);
        GameInfo gameInfo159 = new GameInfo("City surfers", 1000152, true, true, true);
        hashMap159.put(valueOf159, gameInfo159);
        HashMap<Integer, GameInfo> hashMap160 = sGameInfoMap;
        Integer valueOf160 = Integer.valueOf(1000181);
        GameInfo gameInfo160 = new GameInfo("match 2", 1000181, true, true, true);
        hashMap160.put(valueOf160, gameInfo160);
        HashMap<Integer, GameInfo> hashMap161 = sGameInfoMap;
        Integer valueOf161 = Integer.valueOf(1000188);
        GameInfo gameInfo161 = new GameInfo("rummy", 1000188, true, true, true);
        hashMap161.put(valueOf161, gameInfo161);
        HashMap<Integer, GameInfo> hashMap162 = sGameInfoMap;
        Integer valueOf162 = Integer.valueOf(1000189);
        GameInfo gameInfo162 = new GameInfo("rummy", 1000189, true, true, true);
        hashMap162.put(valueOf162, gameInfo162);
        HashMap<Integer, GameInfo> hashMap163 = sGameInfoMap;
        Integer valueOf163 = Integer.valueOf(1000190);
        GameInfo gameInfo163 = new GameInfo("rummy", 1000190, true, true, true);
        hashMap163.put(valueOf163, gameInfo163);
        HashMap<Integer, GameInfo> hashMap164 = sGameInfoMap;
        Integer valueOf164 = Integer.valueOf(1000179);
        GameInfo gameInfo164 = new GameInfo("ludo", 1000179, true, true, true);
        hashMap164.put(valueOf164, gameInfo164);
        HashMap<Integer, GameInfo> hashMap165 = sGameInfoMap;
        Integer valueOf165 = Integer.valueOf(1000157);
        GameInfo gameInfo165 = new GameInfo("sudoku", 1000157, true, true, true);
        hashMap165.put(valueOf165, gameInfo165);
        HashMap<Integer, GameInfo> hashMap166 = sGameInfoMap;
        Integer valueOf166 = Integer.valueOf(1000192);
        GameInfo gameInfo166 = new GameInfo("bowling", 1000192, true, true, true);
        hashMap166.put(valueOf166, gameInfo166);
        HashMap<Integer, GameInfo> hashMap167 = sGameInfoMap;
        Integer valueOf167 = Integer.valueOf(1000194);
        GameInfo gameInfo167 = new GameInfo("Puzzles and Warriors", 1000194, true, true, true);
        hashMap167.put(valueOf167, gameInfo167);
        HashMap<Integer, GameInfo> hashMap168 = sGameInfoMap;
        Integer valueOf168 = Integer.valueOf(1000180);
        GameInfo gameInfo168 = new GameInfo("Gun Slinger", 1000180, true, true, true);
        hashMap168.put(valueOf168, gameInfo168);
        HashMap<Integer, GameInfo> hashMap169 = sGameInfoMap;
        Integer valueOf169 = Integer.valueOf(1000187);
        GameInfo gameInfo169 = new GameInfo("Color Switch", 1000187, false, true, true);
        hashMap169.put(valueOf169, gameInfo169);
        HashMap<Integer, GameInfo> hashMap170 = sGameInfoMap;
        Integer valueOf170 = Integer.valueOf(1000186);
        GameInfo gameInfo170 = new GameInfo("Color roller", 1000186, false, true, true);
        hashMap170.put(valueOf170, gameInfo170);
        HashMap<Integer, GameInfo> hashMap171 = sGameInfoMap;
        Integer valueOf171 = Integer.valueOf(1000185);
        GameInfo gameInfo171 = new GameInfo("Bingo Clash", 1000185, false, true, true);
        hashMap171.put(valueOf171, gameInfo171);
        HashMap<Integer, GameInfo> hashMap172 = sGameInfoMap;
        Integer valueOf172 = Integer.valueOf(185);
        GameInfo gameInfo172 = new GameInfo("Bingo Clash", 185, false, true, true);
        hashMap172.put(valueOf172, gameInfo172);
        HashMap<Integer, GameInfo> hashMap173 = sGameInfoMap;
        Integer valueOf173 = Integer.valueOf(1000203);
        GameInfo gameInfo173 = new GameInfo("pool async", 1000203, false, true, true);
        hashMap173.put(valueOf173, gameInfo173);
        HashMap<Integer, GameInfo> hashMap174 = sGameInfoMap;
        Integer valueOf174 = Integer.valueOf(BaseRequest.RemoveBuddy);
        GameInfo gameInfo174 = new GameInfo("pool async", BaseRequest.RemoveBuddy, false, true, true);
        hashMap174.put(valueOf174, gameInfo174);
        HashMap<Integer, GameInfo> hashMap175 = sGameInfoMap;
        Integer valueOf175 = Integer.valueOf(98);
        GameInfo gameInfo175 = new GameInfo("word connect", 98, false, true, true);
        hashMap175.put(valueOf175, gameInfo175);
        HashMap<Integer, GameInfo> hashMap176 = sGameInfoMap;
        Integer valueOf176 = Integer.valueOf(1000208);
        GameInfo gameInfo176 = new GameInfo("Match3D", 1000208, false, true, true);
        hashMap176.put(valueOf176, gameInfo176);
        HashMap<Integer, GameInfo> hashMap177 = sGameInfoMap;
        Integer valueOf177 = Integer.valueOf(208);
        GameInfo gameInfo177 = new GameInfo("Match3D", 208, false, true, true);
        hashMap177.put(valueOf177, gameInfo177);
        HashMap<Integer, GameInfo> hashMap178 = sGameInfoMap;
        Integer valueOf178 = Integer.valueOf(101);
        GameInfo gameInfo178 = new GameInfo("Hoops", 101, false, true, true);
        hashMap178.put(valueOf178, gameInfo178);
        HashMap<Integer, GameInfo> hashMap179 = sGameInfoMap;
        Integer valueOf179 = Integer.valueOf(144);
        GameInfo gameInfo179 = new GameInfo("knifehit", 144, false, true, true);
        hashMap179.put(valueOf179, gameInfo179);
        HashMap<Integer, GameInfo> hashMap180 = sGameInfoMap;
        Integer valueOf180 = Integer.valueOf(151);
        GameInfo gameInfo180 = new GameInfo("Hoops", 151, false, true, true);
        hashMap180.put(valueOf180, gameInfo180);
        HashMap<Integer, GameInfo> hashMap181 = sGameInfoMap;
        Integer valueOf181 = Integer.valueOf(1000211);
        GameInfo gameInfo181 = new GameInfo("Hoops", 1000211, false, true, true);
        hashMap181.put(valueOf181, gameInfo181);
        HashMap<Integer, GameInfo> hashMap182 = sGameInfoMap;
        Integer valueOf182 = Integer.valueOf(FTPReply.SYSTEM_STATUS);
        GameInfo gameInfo182 = new GameInfo("Hoops", FTPReply.SYSTEM_STATUS, false, true, true);
        hashMap182.put(valueOf182, gameInfo182);
        HashMap<Integer, GameInfo> hashMap183 = sGameInfoMap;
        Integer valueOf183 = Integer.valueOf(162);
        GameInfo gameInfo183 = new GameInfo("Cricket Clash ", 162, false, true, true);
        hashMap183.put(valueOf183, gameInfo183);
        HashMap<Integer, GameInfo> hashMap184 = sGameInfoMap;
        Integer valueOf184 = Integer.valueOf(1001957);
        GameInfo gameInfo184 = new GameInfo("Man vs Missile", 1001957, false, true, true);
        hashMap184.put(valueOf184, gameInfo184);
        HashMap<Integer, GameInfo> hashMap185 = sGameInfoMap;
        Integer valueOf185 = Integer.valueOf(1957);
        GameInfo gameInfo185 = new GameInfo("Man vs Missile", 1957, false, true, true);
        hashMap185.put(valueOf185, gameInfo185);
        HashMap<Integer, GameInfo> hashMap186 = sGameInfoMap;
        Integer valueOf186 = Integer.valueOf(1001965);
        GameInfo gameInfo186 = new GameInfo("Mahjong", 1001965, false, true, true);
        hashMap186.put(valueOf186, gameInfo186);
        HashMap<Integer, GameInfo> hashMap187 = sGameInfoMap;
        Integer valueOf187 = Integer.valueOf(1965);
        GameInfo gameInfo187 = new GameInfo("Mahjong", 1965, false, true, true);
        hashMap187.put(valueOf187, gameInfo187);
        HashMap<Integer, GameInfo> hashMap188 = sGameInfoMap;
        Integer valueOf188 = Integer.valueOf(1000215);
        GameInfo gameInfo188 = new GameInfo("Point Rummy", 1000215, false, true, true);
        hashMap188.put(valueOf188, gameInfo188);
        HashMap<Integer, GameInfo> hashMap189 = sGameInfoMap;
        Integer valueOf189 = Integer.valueOf(1000216);
        GameInfo gameInfo189 = new GameInfo(" Pool Rummy", 1000216, false, true, true);
        hashMap189.put(valueOf189, gameInfo189);
        HashMap<Integer, GameInfo> hashMap190 = sGameInfoMap;
        Integer valueOf190 = Integer.valueOf(1000217);
        GameInfo gameInfo190 = new GameInfo("Deals Rummy", 1000217, false, true, true);
        hashMap190.put(valueOf190, gameInfo190);
        HashMap<Integer, GameInfo> hashMap191 = sGameInfoMap;
        Integer valueOf191 = Integer.valueOf(134);
        GameInfo gameInfo191 = new GameInfo(Constant.POKER_DIR_NAME, 134, false, true, true);
        hashMap191.put(valueOf191, gameInfo191);
        HashMap<Integer, GameInfo> hashMap192 = sGameInfoMap;
        Integer valueOf192 = Integer.valueOf(218);
        GameInfo gameInfo192 = new GameInfo("rummy tournament", 218, true, true, true);
        hashMap192.put(valueOf192, gameInfo192);
        HashMap<Integer, GameInfo> hashMap193 = sGameInfoMap;
        Integer valueOf193 = Integer.valueOf(1000218);
        GameInfo gameInfo193 = new GameInfo("rummy battle", 1000218, true, true, true);
        hashMap193.put(valueOf193, gameInfo193);
        HashMap<Integer, GameInfo> hashMap194 = sGameInfoMap;
        Integer valueOf194 = Integer.valueOf(1000301);
        GameInfo gameInfo194 = new GameInfo("speed chess", 1000301, true, true, true);
        hashMap194.put(valueOf194, gameInfo194);
        HashMap<Integer, GameInfo> hashMap195 = sGameInfoMap;
        Integer valueOf195 = Integer.valueOf(1000212);
        GameInfo gameInfo195 = new GameInfo("rock climber", 1000212, true, true, true);
        hashMap195.put(valueOf195, gameInfo195);
        HashMap<Integer, GameInfo> hashMap196 = sGameInfoMap;
        Integer valueOf196 = Integer.valueOf(FTPReply.DIRECTORY_STATUS);
        GameInfo gameInfo196 = new GameInfo("rock climber", FTPReply.DIRECTORY_STATUS, true, true, true);
        hashMap196.put(valueOf196, gameInfo196);
        HashMap<Integer, GameInfo> hashMap197 = sGameInfoMap;
        Integer valueOf197 = Integer.valueOf(158);
        GameInfo gameInfo197 = new GameInfo("word search", 158, true, true, true);
        hashMap197.put(valueOf197, gameInfo197);
        HashMap<Integer, GameInfo> hashMap198 = sGameInfoMap;
        Integer valueOf198 = Integer.valueOf(152);
        GameInfo gameInfo198 = new GameInfo("city surfer", 152, true, true, true);
        hashMap198.put(valueOf198, gameInfo198);
        HashMap<Integer, GameInfo> hashMap199 = sGameInfoMap;
        Integer valueOf199 = Integer.valueOf(1000219);
        GameInfo gameInfo199 = new GameInfo("callbreak", 1000219, true, true, true);
        hashMap199.put(valueOf199, gameInfo199);
        HashMap<Integer, GameInfo> hashMap200 = sGameInfoMap;
        Integer valueOf200 = Integer.valueOf(181);
        GameInfo gameInfo200 = new GameInfo("Match 2", 181, false, true, true);
        hashMap200.put(valueOf200, gameInfo200);
        HashMap<Integer, GameInfo> hashMap201 = sGameInfoMap;
        Integer valueOf201 = Integer.valueOf(186);
        GameInfo gameInfo201 = new GameInfo("color roller", 186, false, true, true);
        hashMap201.put(valueOf201, gameInfo201);
        HashMap<Integer, GameInfo> hashMap202 = sGameInfoMap;
        Integer valueOf202 = Integer.valueOf(1978);
        GameInfo gameInfo202 = new GameInfo("Golden boot", 1978, false, true, true);
        hashMap202.put(valueOf202, gameInfo202);
        HashMap<Integer, GameInfo> hashMap203 = sGameInfoMap;
        Integer valueOf203 = Integer.valueOf(1001978);
        GameInfo gameInfo203 = new GameInfo("Golden boot battle", 1001978, false, true, true);
        hashMap203.put(valueOf203, gameInfo203);
        HashMap<Integer, GameInfo> hashMap204 = sGameInfoMap;
        Integer valueOf204 = Integer.valueOf(2008);
        GameInfo gameInfo204 = new GameInfo("Speed Bingo", 2008, false, true, true);
        hashMap204.put(valueOf204, gameInfo204);
        HashMap<Integer, GameInfo> hashMap205 = sGameInfoMap;
        Integer valueOf205 = Integer.valueOf(1002008);
        GameInfo gameInfo205 = new GameInfo("Speed Bingo battle", 1002008, false, true, true);
        hashMap205.put(valueOf205, gameInfo205);
        HashMap<Integer, GameInfo> hashMap206 = sGameInfoMap;
        Integer valueOf206 = Integer.valueOf(1001992);
        GameInfo gameInfo206 = new GameInfo("pinball", 1001992, false, true, true);
        hashMap206.put(valueOf206, gameInfo206);
        HashMap<Integer, GameInfo> hashMap207 = sGameInfoMap;
        Integer valueOf207 = Integer.valueOf(1992);
        GameInfo gameInfo207 = new GameInfo("pinball", 1992, false, true, true);
        hashMap207.put(valueOf207, gameInfo207);
        HashMap<Integer, GameInfo> hashMap208 = sGameInfoMap;
        Integer valueOf208 = Integer.valueOf(1000220);
        GameInfo gameInfo208 = new GameInfo("gin rummy", 1000220, true, true, true);
        hashMap208.put(valueOf208, gameInfo208);
        HashMap<Integer, GameInfo> hashMap209 = sGameInfoMap;
        Integer valueOf209 = Integer.valueOf(1002012);
        GameInfo gameInfo209 = new GameInfo("Dominoes Battle", 1002012, false, true, true);
        hashMap209.put(valueOf209, gameInfo209);
        HashMap<Integer, GameInfo> hashMap210 = sGameInfoMap;
        Integer valueOf210 = Integer.valueOf(2012);
        GameInfo gameInfo210 = new GameInfo("Dominoes ", 2012, false, true, true);
        hashMap210.put(valueOf210, gameInfo210);
        HashMap<Integer, GameInfo> hashMap211 = sGameInfoMap;
        Integer valueOf211 = Integer.valueOf(1002013);
        GameInfo gameInfo211 = new GameInfo("Backgammon battle", 1002013, false, true, true);
        hashMap211.put(valueOf211, gameInfo211);
        HashMap<Integer, GameInfo> hashMap212 = sGameInfoMap;
        Integer valueOf212 = Integer.valueOf(2013);
        GameInfo gameInfo212 = new GameInfo("Backgammon", 2013, false, true, true);
        hashMap212.put(valueOf212, gameInfo212);
        HashMap<Integer, GameInfo> hashMap213 = sGameInfoMap;
        Integer valueOf213 = Integer.valueOf(1000223);
        GameInfo gameInfo213 = new GameInfo("Call Break", 1000223, true, true, true);
        hashMap213.put(valueOf213, gameInfo213);
        HashMap<Integer, GameInfo> hashMap214 = sGameInfoMap;
        Integer valueOf214 = Integer.valueOf(168);
        GameInfo gameInfo214 = new GameInfo("Ball Blaster", 168, false, true, true);
        hashMap214.put(valueOf214, gameInfo214);
        HashMap<Integer, GameInfo> hashMap215 = sGameInfoMap;
        Integer valueOf215 = Integer.valueOf(1000227);
        GameInfo gameInfo215 = new GameInfo("Call Break", 1000227, false, true, true);
        hashMap215.put(valueOf215, gameInfo215);
        HashMap<Integer, GameInfo> hashMap216 = sGameInfoMap;
        Integer valueOf216 = Integer.valueOf(1002019);
        GameInfo gameInfo216 = new GameInfo("Chess puzzle", 1002019, false, true, true);
        hashMap216.put(valueOf216, gameInfo216);
        HashMap<Integer, GameInfo> hashMap217 = sGameInfoMap;
        Integer valueOf217 = Integer.valueOf(2019);
        GameInfo gameInfo217 = new GameInfo("Chess puzzle", 2019, false, true, true);
        hashMap217.put(valueOf217, gameInfo217);
        HashMap<Integer, GameInfo> hashMap218 = sGameInfoMap;
        Integer valueOf218 = Integer.valueOf(1000228);
        GameInfo gameInfo218 = new GameInfo("ludo number", 1000228, true, true, true);
        hashMap218.put(valueOf218, gameInfo218);
        HashMap<Integer, GameInfo> hashMap219 = sGameInfoMap;
        Integer valueOf219 = Integer.valueOf(2035);
        GameInfo gameInfo219 = new GameInfo("wordle tournamnet", 2035, false, false, true);
        hashMap219.put(valueOf219, gameInfo219);
        HashMap<Integer, GameInfo> hashMap220 = sGameInfoMap;
        Integer valueOf220 = Integer.valueOf(1002035);
        GameInfo gameInfo220 = new GameInfo("wordle battle", 1002035, false, true, true);
        hashMap220.put(valueOf220, gameInfo220);
        HashMap<Integer, GameInfo> hashMap221 = sGameInfoMap;
        Integer valueOf221 = Integer.valueOf(228);
        GameInfo gameInfo221 = new GameInfo("ludo number", 228, true, true, true);
        hashMap221.put(valueOf221, gameInfo221);
        HashMap<Integer, GameInfo> hashMap222 = sGameInfoMap;
        Integer valueOf222 = Integer.valueOf(1000226);
        GameInfo gameInfo222 = new GameInfo("callbreak tournament", 1000226, true, true, true);
        hashMap222.put(valueOf222, gameInfo222);
        HashMap<Integer, GameInfo> hashMap223 = sGameInfoMap;
        Integer valueOf223 = Integer.valueOf(2028);
        GameInfo gameInfo223 = new GameInfo("WWTABM tournamnet", 2028, false, false, true);
        hashMap223.put(valueOf223, gameInfo223);
        HashMap<Integer, GameInfo> hashMap224 = sGameInfoMap;
        Integer valueOf224 = Integer.valueOf(1002028);
        GameInfo gameInfo224 = new GameInfo("WWTABM battle", 1002028, false, true, true);
        hashMap224.put(valueOf224, gameInfo224);
        HashMap<Integer, GameInfo> hashMap225 = sGameInfoMap;
        Integer valueOf225 = Integer.valueOf(1000221);
        GameInfo gameInfo225 = new GameInfo("Spades", 1000221, false, true, true);
        hashMap225.put(valueOf225, gameInfo225);
        HashMap<Integer, GameInfo> hashMap226 = sGameInfoMap;
        Integer valueOf226 = Integer.valueOf(1002026);
        GameInfo gameInfo226 = new GameInfo("buck hunte battle", 1002026, false, true, true);
        hashMap226.put(valueOf226, gameInfo226);
        HashMap<Integer, GameInfo> hashMap227 = sGameInfoMap;
        Integer valueOf227 = Integer.valueOf(2026);
        GameInfo gameInfo227 = new GameInfo("buck hunte tournamnet", 2026, false, true, true);
        hashMap227.put(valueOf227, gameInfo227);
        HashMap<Integer, GameInfo> hashMap228 = sGameInfoMap;
        Integer valueOf228 = Integer.valueOf(1002052);
        GameInfo gameInfo228 = new GameInfo("Rapid Fire battle", 1002052, false, true, true);
        hashMap228.put(valueOf228, gameInfo228);
        HashMap<Integer, GameInfo> hashMap229 = sGameInfoMap;
        Integer valueOf229 = Integer.valueOf(2052);
        GameInfo gameInfo229 = new GameInfo("Rapid Fire tournamnet", 2052, false, true, true);
        hashMap229.put(valueOf229, gameInfo229);
        HashMap<Integer, GameInfo> hashMap230 = sGameInfoMap;
        Integer valueOf230 = Integer.valueOf(1000229);
        GameInfo gameInfo230 = new GameInfo("Pool Rummy", 1000229, false, true, true);
        hashMap230.put(valueOf230, gameInfo230);
        HashMap<Integer, GameInfo> hashMap231 = sGameInfoMap;
        Integer valueOf231 = Integer.valueOf(1000234);
        GameInfo gameInfo231 = new GameInfo("Rummy Mt Deals", 1000234, false, true, true);
        hashMap231.put(valueOf231, gameInfo231);
        HashMap<Integer, GameInfo> hashMap232 = sGameInfoMap;
        Integer valueOf232 = Integer.valueOf(BuildConfig.launchingGameId);
        GameInfo gameInfo232 = new GameInfo("Ludo win dice battle", BuildConfig.launchingGameId, false, true, true);
        hashMap232.put(valueOf232, gameInfo232);
        HashMap<Integer, GameInfo> hashMap233 = sGameInfoMap;
        Integer valueOf233 = Integer.valueOf(2054);
        GameInfo gameInfo233 = new GameInfo("Ludo win dice tournamnet", 2054, false, true, true);
        hashMap233.put(valueOf233, gameInfo233);
        HashMap<Integer, GameInfo> hashMap234 = sGameInfoMap;
        Integer valueOf234 = Integer.valueOf(1002053);
        GameInfo gameInfo234 = new GameInfo("snl", 1002053, false, true, true);
        hashMap234.put(valueOf234, gameInfo234);
        HashMap<Integer, GameInfo> hashMap235 = sGameInfoMap;
        Integer valueOf235 = Integer.valueOf(2053);
        GameInfo gameInfo235 = new GameInfo("snl", 2053, false, false, true);
        hashMap235.put(valueOf235, gameInfo235);
        HashMap<Integer, GameInfo> hashMap236 = sGameInfoMap;
        Integer valueOf236 = Integer.valueOf(2056);
        GameInfo gameInfo236 = new GameInfo("Draw4 tournamnet", 2056, false, true, true);
        hashMap236.put(valueOf236, gameInfo236);
        HashMap<Integer, GameInfo> hashMap237 = sGameInfoMap;
        Integer valueOf237 = Integer.valueOf(1002056);
        GameInfo gameInfo237 = new GameInfo("Draw4 battle", 1002056, false, true, true);
        hashMap237.put(valueOf237, gameInfo237);
        HashMap<Integer, GameInfo> hashMap238 = sGameInfoMap;
        Integer valueOf238 = Integer.valueOf(1002044);
        GameInfo gameInfo238 = new GameInfo("3 card poker battle", 1002044, false, true, true);
        hashMap238.put(valueOf238, gameInfo238);
        HashMap<Integer, GameInfo> hashMap239 = sGameInfoMap;
        Integer valueOf239 = Integer.valueOf(2044);
        GameInfo gameInfo239 = new GameInfo("3 card poker tournamnet", 2044, false, true, true);
        hashMap239.put(valueOf239, gameInfo239);
        HashMap<Integer, GameInfo> hashMap240 = sGameInfoMap;
        Integer valueOf240 = Integer.valueOf(1000500);
        GameInfo gameInfo240 = new GameInfo("Call Break Fantasy battle", 1000500, false, true, true);
        hashMap240.put(valueOf240, gameInfo240);
        HashMap<Integer, GameInfo> hashMap241 = sGameInfoMap;
        Integer valueOf241 = Integer.valueOf(1000231);
        GameInfo gameInfo241 = new GameInfo("ludo fantasy ", 1000231, false, true, true);
        hashMap241.put(valueOf241, gameInfo241);
        HashMap<Integer, GameInfo> hashMap242 = sGameInfoMap;
        Integer valueOf242 = Integer.valueOf(1002051);
        GameInfo gameInfo242 = new GameInfo("trump card battle", 1002051, false, true, true);
        hashMap242.put(valueOf242, gameInfo242);
        HashMap<Integer, GameInfo> hashMap243 = sGameInfoMap;
        Integer valueOf243 = Integer.valueOf(2051);
        GameInfo gameInfo243 = new GameInfo("trump card tournament", 2051, false, true, true);
        hashMap243.put(valueOf243, gameInfo243);
        HashMap<Integer, GameInfo> hashMap244 = sGameInfoMap;
        Integer valueOf244 = Integer.valueOf(1002062);
        GameInfo gameInfo244 = new GameInfo("SNL Reel battle", 1002062, false, true, true);
        hashMap244.put(valueOf244, gameInfo244);
        HashMap<Integer, GameInfo> hashMap245 = sGameInfoMap;
        Integer valueOf245 = Integer.valueOf(2062);
        GameInfo gameInfo245 = new GameInfo("SNL Reel tournament", 2062, false, true, true);
        hashMap245.put(valueOf245, gameInfo245);
        HashMap<Integer, GameInfo> hashMap246 = sGameInfoMap;
        Integer valueOf246 = Integer.valueOf(1000232);
        GameInfo gameInfo246 = new GameInfo("trump Callbreak battle", 1000232, false, true, true);
        hashMap246.put(valueOf246, gameInfo246);
        HashMap<Integer, GameInfo> hashMap247 = sGameInfoMap;
        Integer valueOf247 = Integer.valueOf(2069);
        GameInfo gameInfo247 = new GameInfo("SNL Express tournament", 2069, false, true, true);
        hashMap247.put(valueOf247, gameInfo247);
        HashMap<Integer, GameInfo> hashMap248 = sGameInfoMap;
        Integer valueOf248 = Integer.valueOf(1002069);
        GameInfo gameInfo248 = new GameInfo("SNL Express battle", 1002069, false, true, true);
        hashMap248.put(valueOf248, gameInfo248);
        HashMap<Integer, GameInfo> hashMap249 = sGameInfoMap;
        Integer valueOf249 = Integer.valueOf(1000233);
        GameInfo gameInfo249 = new GameInfo("Rummy Mt Points", 1000233, false, true, true);
        hashMap249.put(valueOf249, gameInfo249);
        HashMap<Integer, GameInfo> hashMap250 = sGameInfoMap;
        Integer valueOf250 = Integer.valueOf(1002071);
        GameInfo gameInfo250 = new GameInfo("Ludo 2 Dice battle", 1002071, false, true, true);
        hashMap250.put(valueOf250, gameInfo250);
        HashMap<Integer, GameInfo> hashMap251 = sGameInfoMap;
        Integer valueOf251 = Integer.valueOf(2071);
        GameInfo gameInfo251 = new GameInfo("Ludo 2 Dice tournament", 2071, false, true, true);
        hashMap251.put(valueOf251, gameInfo251);
        HashMap<Integer, GameInfo> hashMap252 = sGameInfoMap;
        Integer valueOf252 = Integer.valueOf(2073);
        GameInfo gameInfo252 = new GameInfo("Patte pe Patta tournament", 2073, false, true, true);
        hashMap252.put(valueOf252, gameInfo252);
        HashMap<Integer, GameInfo> hashMap253 = sGameInfoMap;
        Integer valueOf253 = Integer.valueOf(1002073);
        GameInfo gameInfo253 = new GameInfo("Patte pe Patta battle", 1002073, false, true, true);
        hashMap253.put(valueOf253, gameInfo253);
        HashMap<Integer, GameInfo> hashMap254 = sGameInfoMap;
        Integer valueOf254 = Integer.valueOf(2078);
        GameInfo gameInfo254 = new GameInfo("Poker Puzzle", 2078, false, true, true);
        hashMap254.put(valueOf254, gameInfo254);
        HashMap<Integer, GameInfo> hashMap255 = sGameInfoMap;
        Integer valueOf255 = Integer.valueOf(1002078);
        GameInfo gameInfo255 = new GameInfo("Poker Puzzle", 1002078, false, true, true);
        hashMap255.put(valueOf255, gameInfo255);
        hanselProConfigs.put(HanselEventConstant.KEY_HANSEL_DUMMY_FLAG, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_game_layout", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("home_game_order", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("home_format_layout", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("referral_readFromCB_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_hide_inactive_format", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_hide_inactive_game", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("add_shortcut_prompt_after", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("add_shortcut_prompt_limit", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("popup_announcement_config", HanselEventConstant.DATA_TYPE_STRING);
        hanselProConfigs.put("admob_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("admob_tournament_index", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("admob_banner_index", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("admob_screens", HanselEventConstant.DATA_TYPE_STRING);
        hanselProConfigs.put("chatbot_show", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("admob_enabled_new", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("admob_tournament_index_new", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("admob_banner_index_new", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("admob_screens_new", HanselEventConstant.DATA_TYPE_STRING);
        hanselProConfigs.put("juspay_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("fantasy_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("quiz_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("background_running_service_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("tab_callout_config", HanselEventConstant.DATA_TYPE_STRING);
        hanselProConfigs.put("pooled_tournament_config", HanselEventConstant.DATA_TYPE_STRING);
        hanselProConfigs.put("withdrawal_fee_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("podcast_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("podcast_create_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("podcast_create_button_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("bb_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("fantasy_new_create_team_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_show_chess", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("addmoney_newLayout_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_game_tile_show_winnings", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("rummy_join_confirmation_show", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("deals_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("challenges_tier_diff", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("challenges_ui_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("challenge_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("deals_homepage_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_show_pool_rummy", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_ads", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("add_money_scratchcard", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("rank_result_layout", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("groups_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("fantasyCreateTeamNewFormat", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_show_pokerV2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("superteam_team_list_action_labels_disabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("chat_resethistory_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("chat_requestfollower_threshold", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("showReferTabOnFooter", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("payments_compliance_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_net_amount_userprofile", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("rewardbot_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_revamp_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_coupon_new_UI", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("new_walletpage_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("games_revamp_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("mpl_helpdesk_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("reality_check_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_show_deal_rummy", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_payment_popup", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("channels_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("collectable_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_banner_autoplay", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("support_faqs_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_addmoney_new_UI", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("horizontal_feature_event", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_coupon_horizontal", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("golden_spin_wheel_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_search_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_explore_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("wtm_battle_autolaunch", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_chat_bot", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_banner_ads_v1", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_home_ads_v1", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_game_rank_ads_v1", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("superteam_new_match_cards_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_configurable_gamelist", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_recently_played", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("is_ml_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_rummy_tournament", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("vip_call_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_collectable_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("profile_user_name_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("profile_username_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("profile_username_edit_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Config.HANSEL_KEY_PROFILE_USERNAME_SURFACE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("rtue_popup_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("collectable_missions_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("stories_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("is_ml_enabled_fe", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_recently_played_v1", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_game_reels", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("podcast_create_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("podcast_create_button_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("new_walletpage_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_explore_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("money_in_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("home_config", HanselEventConstant.DATA_TYPE_JSON);
        hanselProConfigs.put("is_ml_spinwheel_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_invoice_gst", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("interactiveftue_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("responsiblegaming_withdrawcheck_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("responsiblegaming_depositcheck_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("responsiblegaming_timecheck_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("tickets_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_practice_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("fantasy_show_selection_percentage", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("prime_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("deposit_fraud_check_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Config.HANSEL_KEY_FEATURE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("deposit_limit_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("payments_new_options_ui_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("new_event_card", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("payments_new_options_ui_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("responsible_gaming_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_score_metrics_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("new_game_header", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_in_appshare_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("payments_new_options_ui_enabled_v3", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_view_revamp_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("gopaySdkFlow_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("superteam_edit_team_button_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("indo_reg_journey", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.IS_SUPPORT_REVAMP, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("kyc_v3_flow_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("low_balance_revamp_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("preferred_payment_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("profile_pic_v2_surface_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("superteam_contestdetails_cta_experiment_variation", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselProConfigs.put("game_streak_on_hansel", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("support_revamp_version", HanselEventConstant.DATA_TYPE_STRING);
        hanselProConfigs.put("game_view_new", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("event_details_new", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("quick_edit_team_view", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("geo_fencing_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("penny_drop_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("fantasy_quick_access", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("global_search_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("bnpl_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("kyc_aadhaar_xml_flow_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("low_balance_revamp_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_randomiser_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_replay_surface_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("money_in_card_verification_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Config.HANSEL_KEY_PROFILE_SHOW_WIN_RATE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("gopaySdkFlow_enabled_V2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("dana_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("profile_age_last_played", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.IS_TEAM_CLASH_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("game_stats_on_hansel", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("mini_profile_on_hansel", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("transaction_history_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("transaction_real_time_status_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("amazonLinkingFlow_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("payments_is_3ds_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("profile_trophy_surface_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.HANSEL_KEY_HAPTIK_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("transaction_history_v3_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("transaction_real_time_status_enabled_v4", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("account_deletion_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("addMoneyNewUIIndo_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.IS_NEW_PWF_REFERRAL_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.PWF_FOOTER_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.IS_QUICK_BATTLE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("bonus_sink_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("money_out_linking_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("withdrawal_fee_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.IS_SYNC_GAMES_ENABLED_PWF, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.IS_PWF_FOOTER_FANTASY_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("is_submit_score_compressed", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.IS_PWF_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("geo_fencing_withdraw_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("upi_intent_flow_enabled_v3", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("payments_coins_expiry_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.SHOW_PUBLIC_TOURNAMENTS_PWF, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.CHAMPIONS_LEAGUE, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.IS_POWER_LEAGUE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("tokens_sink_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("kyc_camera_sdk_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("lossProtection_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("show_bigger_tiles", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("kyc_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("payments_moneyin_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.IS_NEW_GAMES_SEARCH_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("payments_deposit_status_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("tds_certificate_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("starter_pack_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("locked_cash_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put(Constant.FIRST_LAUNCH_FLUSHING_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("coupon_bs_flow_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("payments_one_tap_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselProConfigs.put("kyc_aadhaar_xml_flow_enabled_v3", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(HanselEventConstant.KEY_HANSEL_DUMMY_FLAG, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_game_layout", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("home_game_order", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("home_format_layout", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("referral_readFromCB_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_hide_inactive_format", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_hide_inactive_game", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("add_shortcut_prompt_after", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("add_shortcut_prompt_limit", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("popup_announcement_config", HanselEventConstant.DATA_TYPE_STRING);
        hanselPlayStoreConfigs.put("admob_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("admob_tournament_index", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("admob_banner_index", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("admob_screens", HanselEventConstant.DATA_TYPE_STRING);
        hanselPlayStoreConfigs.put("chatbot_show", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("admob_enabled_new", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("admob_tournament_index_new", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("admob_banner_index_new", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("admob_screens_new", HanselEventConstant.DATA_TYPE_STRING);
        hanselPlayStoreConfigs.put("juspay_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("addmoney_ps_enabled_r37", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("fantasy_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("quiz_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("background_running_service_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("tab_callout_config", HanselEventConstant.DATA_TYPE_STRING);
        hanselPlayStoreConfigs.put("pooled_tournament_config", HanselEventConstant.DATA_TYPE_STRING);
        hanselPlayStoreConfigs.put("withdrawal_fee_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("admob_superteam_contest_index", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("podcast_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("podcast_create_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("podcast_create_button_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("bb_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("fantasy_new_create_team_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_show_chess", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("addmoney_newLayout_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_game_tile_show_winnings", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("rummy_join_confirmation_show", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("deals_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("challenges_tier_diff", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("challenges_ui_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("challenge_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("deals_homepage_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_show_pool_rummy", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_ads", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("add_money_scratchcard", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("rank_result_layout", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("groups_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("fantasyCreateTeamNewFormat", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_show_pokerV2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("superteam_team_list_action_labels_disabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("chat_resethistory_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("chat_requestfollower_threshold", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("showReferTabOnFooter", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("payments_compliance_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_net_amount_userprofile", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("rewardbot_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_revamp_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_coupon_new_UI", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("new_walletpage_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("games_revamp_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("mpl_helpdesk_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("reality_check_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_show_deal_rummy", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_payment_popup", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("channels_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("collectable_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_banner_autoplay", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("support_faqs_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_addmoney_new_UI", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("horizontal_feature_event", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_coupon_horizontal", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("golden_spin_wheel_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_search_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_explore_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("wtm_battle_autolaunch", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_chat_bot", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_banner_ads_v1", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_home_ads_v1", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_game_rank_ads_v1", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("superteam_new_match_cards_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_configurable_gamelist", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_recently_played", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("is_ml_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_rummy_tournament", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("vip_call_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_collectable_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("profile_username_edit_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Config.HANSEL_KEY_PROFILE_USERNAME_SURFACE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("profile_user_name_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("profile_username_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("rtue_popup_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("collectable_missions_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("stories_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("is_ml_enabled_fe", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_recently_played_v1", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_game_reels", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("podcast_create_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("podcast_create_button_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("new_walletpage_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_explore_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("money_in_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("home_config", HanselEventConstant.DATA_TYPE_JSON);
        hanselPlayStoreConfigs.put("is_ml_spinwheel_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_invoice_gst", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("interactiveftue_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("responsiblegaming_withdrawcheck_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("responsiblegaming_depositcheck_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("responsiblegaming_timecheck_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("tickets_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_practice_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("fantasy_show_selection_percentage", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("prime_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("deposit_fraud_check_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Config.HANSEL_KEY_FEATURE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("deposit_limit_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("payments_new_options_ui_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("new_event_card", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("payments_new_options_ui_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("responsible_gaming_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_score_metrics_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("new_game_header", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_in_appshare_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("payments_new_options_ui_enabled_v3", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_view_revamp_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("gopaySdkFlow_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("superteam_edit_team_button_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("indo_reg_journey", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.IS_SUPPORT_REVAMP, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("kyc_v3_flow_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("low_balance_revamp_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("preferred_payment_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("profile_pic_v2_surface_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("superteam_contestdetails_cta_experiment_variation", HanselEventConstant.DATA_TYPE_INTEGER);
        hanselPlayStoreConfigs.put("game_streak_on_hansel", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("support_revamp_version", HanselEventConstant.DATA_TYPE_STRING);
        hanselPlayStoreConfigs.put("game_view_new", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("event_details_new", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("quick_edit_team_view", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("geo_fencing_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("penny_drop_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("fantasy_quick_access", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("global_search_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("kyc_aadhaar_xml_flow_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("low_balance_revamp_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_randomiser_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_replay_surface_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("money_in_card_verification_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Config.HANSEL_KEY_PROFILE_SHOW_WIN_RATE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("gopaySdkFlow_enabled_V2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("dana_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("profile_age_last_played", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.IS_TEAM_CLASH_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("game_stats_on_hansel", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("mini_profile_on_hansel", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("transaction_history_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("transaction_real_time_status_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("amazonLinkingFlow_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("payments_is_3ds_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("profile_trophy_surface_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.HANSEL_KEY_HAPTIK_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("transaction_history_v3_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("transaction_real_time_status_enabled_v4", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("account_deletion_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("bnpl_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("addMoneyNewUIIndo_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.IS_NEW_PWF_REFERRAL_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.PWF_FOOTER_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.IS_QUICK_BATTLE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("bonus_sink_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("money_out_linking_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("withdrawal_fee_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.IS_SYNC_GAMES_ENABLED_PWF, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.IS_PWF_FOOTER_FANTASY_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("is_submit_score_compressed", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.IS_PWF_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("geo_fencing_withdraw_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("upi_intent_flow_enabled_v3", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("payments_coins_expiry_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.SHOW_PUBLIC_TOURNAMENTS_PWF, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.CHAMPIONS_LEAGUE, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.IS_POWER_LEAGUE_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("tokens_sink_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("kyc_camera_sdk_v2_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("lossProtection_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("show_bigger_tiles", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("kyc_enabled_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("payments_moneyin_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.IS_NEW_GAMES_SEARCH_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("payments_deposit_status_v2", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("tds_certificate_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("starter_pack_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("locked_cash_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put(Constant.FIRST_LAUNCH_FLUSHING_ENABLED, HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("coupon_bs_flow_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("payments_one_tap_enabled", HanselEventConstant.DATA_TYPE_BOOLEAN);
        hanselPlayStoreConfigs.put("kyc_aadhaar_xml_flow_enabled_v3", HanselEventConstant.DATA_TYPE_BOOLEAN);
        GAME_COMPETITOR_APPS.put("Game Champ", "play.game.champ.win.cash");
        GAME_COMPETITOR_APPS.put("Dream 11", "com.app.dream11");
        GAME_COMPETITOR_APPS.put("Dream11", "com.app.dream11Pro");
        GAME_COMPETITOR_APPS.put("MGPL", "com.mgpl");
        GAME_COMPETITOR_APPS.put("WinZo", "com.tictok.tictokgame");
        GAME_COMPETITOR_APPS.put("Baazi Now!", "com.brainbaazi");
        GAME_COMPETITOR_APPS.put("TopQuiz", "com.brainnr.trivia");
        GAME_COMPETITOR_APPS.put("Mind Quiz", "com.web.mindgame");
        GAME_COMPETITOR_APPS.put("Gaming Players League", "com.gpl.games");
        GAME_COMPETITOR_APPS.put("Loco", "com.showtimeapp");
        GAME_COMPETITOR_APPS.put("Qureka", "qureka.live.game.show");
        GAME_COMPETITOR_APPS.put("Ace2three", "air.com.ace2three.mobile");
        GAME_COMPETITOR_APPS.put("Rummy Circle", "com.teenpattiarena.supreme2017");
        GAME_COMPETITOR_APPS.put("League Adda", "com.fantasycricket.leagueadda");
        GAME_COMPETITOR_APPS.put("11 Wickets", "com.ww11WicketsWebapp_7946785");
        GAME_COMPETITOR_APPS.put("GamePind", "com.paytm.paytmplay");
        GAME_COMPETITOR_APPS.put("747 Games", "com.idyllic.a747");
        GAME_COMPETITOR_APPS.put("Adda 52", "com.adda52.rummyapp.free");
        GAME_COMPETITOR_APPS.put("Draft Kings", "com.rotogrinders.rg_lineups_dk");
        GAME_COMPETITOR_APPS.put("Fan Mojo", "com.fanmojoexpertteam.blogger.nikhilkomalan");
        GAME_COMPETITOR_APPS.put("BetFair", "com.betfair.sportsbook");
        GAME_COMPETITOR_APPS.put("Poker Stars", "com.solverlimited.poker");
        GAME_COMPETITOR_APPS.put("Reward Mob", "com.jackpotvacations.rewardmob");
        GAME_COMPETITOR_APPS.put("Spartan Poker", "air.spartanmobile");
        GAME_COMPETITOR_APPS.put("Swoo Live Games", "com.kryptolabs.android.speakerswire");
        GAME_COMPETITOR_APPS.put("Hago", "com.yy.hiyo");
        GAME_COMPETITOR_APPS.put("Gamee", "com.gameeapp.android.app");
        GAME_COMPETITOR_APPS.put("Bulb Smash", "best.game.bulbsmash");
        GAME_COMPETITOR_APPS.put("HalaPlay", "com.halaplay");
        GAME_COMPETITOR_APPS.put("Hive Reward", "com.mscreator.ms");
        GAME_COMPETITOR_APPS.put("Garena Free Fire: Spooky Night", "com.dts.freefireth");
        GAME_COMPETITOR_APPS.put("PUBG MOBILE", "com.tencent.ig");
        GAME_COMPETITOR_APPS.put("PUBG MOBILE LITE", "com.tencent.iglite");
        if (MBuildConfigUtils.isCashApp()) {
            GAME_COMPETITOR_APPS.put("MPL", "com.mpl.androidapp.ps");
        } else {
            GAME_COMPETITOR_APPS.put("MPL Pro", "com.mpl.androidapp");
        }
        sTeirMap.put("STEEL", Integer.valueOf(1));
        sTeirMap.put("COPPER", Integer.valueOf(2));
        sTeirMap.put("BRONZE", Integer.valueOf(3));
        sTeirMap.put("SILVER", Integer.valueOf(4));
        sTeirMap.put("GOLD", Integer.valueOf(5));
        sTeirMap.put("PLATINUM", Integer.valueOf(6));
        sTeirMap.put("PEARL", Integer.valueOf(7));
        sTeirMap.put("ONYX", Integer.valueOf(8));
        sTeirMap.put("JADE", Integer.valueOf(9));
        sTeirMap.put("OPAL", Integer.valueOf(10));
        sTeirMap.put("TOPAZ", Integer.valueOf(11));
        sTeirMap.put("SAPPHIRE", Integer.valueOf(12));
        sTeirMap.put("EMERALD", Integer.valueOf(13));
        sTeirMap.put("RUBY", Integer.valueOf(14));
        sTeirMap.put("DIAMOND", Integer.valueOf(15));
        defaultReleaseNoteText.add("Improvements to App and Game performance");
        defaultReleaseNoteText.add("Bug fixes and optimizations");
        defaultReleaseNoteIcon.add(Integer.valueOf(R.drawable.default_update_note_a));
        defaultReleaseNoteIcon.add(Integer.valueOf(R.drawable.default_update_note_b));
        needToRemoveEventProps();
    }

    public static void addEventInCalender(Activity activity, ReadableMap readableMap) {
        try {
            if (readableMap.hasKey("startTime") && readableMap.hasKey("endTime")) {
                MLogger.d(TAG, "addEventInCalender: ", readableMap);
                Intent intent = new Intent("android.intent.action.EDIT");
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", Long.parseLong(readableMap.getString("startTime")));
                intent.putExtra("allDay", false);
                intent.putExtra("endTime", Long.parseLong(readableMap.getString("endTime")));
                intent.putExtra("title", readableMap.getString("title"));
                intent.putExtra("description", readableMap.getString("description"));
                activity.startActivity(intent);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "addEventInCalender: ", e2);
        }
    }

    public static void addShortcut(final Activity activity, JSONObject jSONObject, String str) {
        Icon icon;
        try {
            if (activity.isFinishing()) {
                return;
            }
            if (!activity.isDestroyed()) {
                final Context applicationContext = activity.getApplicationContext();
                Intent intent = new Intent(applicationContext, MPLSplashActivity.class);
                boolean z = true;
                intent.putExtra(Constant.INIT_PROP_LAUNCH_FROM_SHORT_CUT, true);
                intent.putExtra("gameData", jSONObject.toString());
                String optString = jSONObject.optString("name", MBuildConfigUtils.getAppName());
                File file = new File(str);
                intent.setAction("android.intent.action.MAIN");
                if (!file.exists() || file.length() <= 0) {
                    z = false;
                }
                if (VERSION.SDK_INT < 26) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                    intent2.putExtra("android.intent.extra.shortcut.NAME", optString);
                    if (z) {
                        intent2.putExtra("android.intent.extra.shortcut.ICON", createBitmapFromFile(applicationContext, file));
                    } else {
                        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(applicationContext, R.mipmap.ic_launcher));
                    }
                    intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
                    intent2.putExtra(MqttServiceConstants.DUPLICATE, false);
                    applicationContext.sendBroadcast(intent2);
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(applicationContext, "Home Shortcut Created", 0).show();
                        }
                    });
                    return;
                }
                ShortcutManager shortcutManager = (ShortcutManager) applicationContext.getSystemService(ShortcutManager.class);
                if (shortcutManager == null || !shortcutManager.isRequestPinShortcutSupported()) {
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(applicationContext, "Does not support Shortcut!", 0).show();
                        }
                    });
                    return;
                }
                Bitmap bitmap = null;
                if (z) {
                    bitmap = createAdaptiveBitmapFromFile(file);
                }
                if (bitmap != null) {
                    icon = Icon.createWithAdaptiveBitmap(bitmap);
                } else {
                    icon = Icon.createWithResource(applicationContext, R.mipmap.ic_launcher);
                }
                ShortcutInfo build = new Builder(applicationContext, optString).setIcon(icon).setIntent(intent).setShortLabel(optString).build();
                Intent intent3 = new Intent("short_cut_created");
                applicationContext.registerReceiver(new BroadcastReceiver() {
                    public void onReceive(final Context context, Intent intent) {
                        activity.runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(context, "Home Shortcut Created", 0).show();
                            }
                        });
                    }
                }, new IntentFilter("short_cut_created"));
                shortcutManager.requestPinShortcut(build, PendingIntent.getBroadcast(applicationContext, Constant.REQUEST_CODE_FOR_SHORT_CUT, intent3, 0).getIntentSender());
            }
        } catch (Exception unused) {
        }
    }

    public static String captureDeviceName() {
        try {
            String string = Global.getString(MPLApplication.getInstance().getContentResolver(), "device_name");
            return string == null ? AnalyticsConstants.NOT_AVAILABLE : string;
        } catch (Exception e2) {
            MLogger.e(TAG, e2.getMessage());
            return AnalyticsConstants.NOT_AVAILABLE;
        }
    }

    public static int changeToBattleGameId(int i) {
        return (i % 1000000) + 1000000;
    }

    public static String checkLocationPermissions() {
        return (ContextCompat.checkSelfPermission(MPLApplication.getInstance(), SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) == 0 && ContextCompat.checkSelfPermission(MPLApplication.getInstance(), "android.permission.ACCESS_COARSE_LOCATION") == 0) ? "Allowed" : "Not Allowed";
    }

    public static void checkProgressAndSendToReact(DownloadManager downloadManager, IResponseListener<String> iResponseListener, String str) {
        if (downloadManager != null && iResponseListener != null) {
            Query query = new Query();
            query.setFilterByStatus(31);
            Cursor query2 = downloadManager.query(query);
            if (query2 != null && query2.moveToFirst()) {
                int i = query2.getInt(query2.getColumnIndex("status"));
                int i2 = query2.getInt(query2.getColumnIndex("total_size"));
                int i3 = query2.getInt(query2.getColumnIndex("bytes_so_far"));
                if (i == 1) {
                    MLogger.d(TAG, GeneratedOutlineSupport.outline43("file_download:STATUS_PENDING ", i2, "  ", i3));
                } else if (i == 2) {
                    iResponseListener.progressResponse((long) i3, (long) i2, false);
                    MLogger.d(TAG, GeneratedOutlineSupport.outline43("file_download:STATUS_RUNNING ", i2, "  ", i3));
                } else if (i == 4) {
                    MLogger.d(TAG, GeneratedOutlineSupport.outline43("file_download:STATUS_PAUSED ", i2, "  ", i3));
                } else if (i == 8) {
                    iResponseListener.onResponseSuccess(str);
                    FileObserver fileObserver = mFileObserver;
                    if (fileObserver != null) {
                        fileObserver.stopWatching();
                    }
                    MLogger.d(TAG, GeneratedOutlineSupport.outline43("file_download:STATUS_SUCCESSFUL ", i2, "  ", i3));
                } else if (i == 16) {
                    iResponseListener.onResponseFail(new MException((Throwable) new RuntimeException("download fail")));
                    FileObserver fileObserver2 = mFileObserver;
                    if (fileObserver2 != null) {
                        fileObserver2.stopWatching();
                    }
                    MLogger.d(TAG, GeneratedOutlineSupport.outline43("file_download:STATUS_FAILED ", i2, "  ", i3));
                }
            }
            if (query2 != null) {
                query2.close();
            }
        }
    }

    public static void copyAssetZipToExternalStorage(Context context, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                copyFile(context.getAssets().open(str), (OutputStream) new FileOutputStream(str2));
            } catch (Exception e2) {
                MLogger.e(TAG, "", e2);
            }
        }
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                outputStream.flush();
                outputStream.close();
                return;
            }
        }
    }

    public static void copyFileOrDirectory(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2, file.getName());
            if (file.isDirectory()) {
                String[] list = file.list();
                int length = list.length;
                for (String file3 : list) {
                    copyFileOrDirectory(new File(file, file3).getPath(), file2.getPath());
                }
                return;
            }
            copyFile(file, file2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void copyFiles(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                copyFile((InputStream) new FileInputStream(str), (OutputStream) new FileOutputStream(str2));
            } catch (Exception e2) {
                MLogger.e(TAG, "", e2);
            }
        }
    }

    public static Bitmap createAdaptiveBitmapFromFile(File file) {
        try {
            Drawable createFromPath = AdaptiveIconDrawable.createFromPath(file.getAbsolutePath());
            if (createFromPath != null) {
                return drawableToBitmap(createFromPath);
            }
            return null;
        } catch (Exception e2) {
            MLogger.e(TAG, "createAdaptiveBitmapFromFile: ", e2);
            return null;
        }
    }

    public static void createAppsFlyerBattleShareLink(Context context, String str, String str2, Promise promise) {
        createAppsFlyerTournamentBattleShareLink(context, str, str2, false, promise, false);
    }

    public static void createAppsFlyerFantasyLink(Context context, String str, Promise promise) {
        createAppsFlyerTournamentBattleShareLink(context, str, null, true, promise, true);
    }

    public static String createAppsFlyerRedirectUrl(ReadableMap readableMap) {
        String str;
        try {
            UserInfo userInfo = MSharedPreferencesUtils.getUserInfo();
            if (userInfo == null || TextUtils.isEmpty("")) {
                str = "";
            } else {
                str = userInfo.getReferralCode();
            }
            if (TextUtils.isEmpty(str)) {
                str = MSharedPreferencesUtils.getUserReferralCode();
            }
            if (TextUtils.isEmpty(str)) {
                str = MSharedPreferencesUtils.getUserReferralCodeFromPref();
            }
            Uri parse = Uri.parse(readableMap.getString("redirectUrl"));
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(parse.getScheme());
            if (readableMap.hasKey("pathSegment") && !TextUtils.isEmpty(readableMap.getString("pathSegment"))) {
                for (String appendPath : readableMap.getString("pathSegment").split("/")) {
                    builder.appendPath(appendPath);
                }
            }
            builder.authority(parse.getAuthority());
            if (readableMap.hasKey("queryParams") && readableMap.getMap("queryParams") != null) {
                for (Entry next : readableMap.getMap("queryParams").toHashMap().entrySet()) {
                    builder.appendQueryParameter((String) next.getKey(), Uri.encode(String.valueOf(next.getValue())));
                }
            }
            builder.appendQueryParameter("referralCode", Uri.encode(str));
            String builder2 = builder.toString();
            MLogger.d(TAG, "createAppsFlyerRedirectUrl: ", builder2);
            return builder2;
        } catch (Exception unused) {
            return "";
        }
    }

    public static void createAppsFlyerReferralLink(Context context, String str, Promise promise) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("type")) {
                String optString = jSONObject.optString("type", "");
                String optString2 = jSONObject.optString("Entry Point", "");
                MLogger.d(TAG, "createAppsFlyerReferralLink: ", optString);
                if ((!"general".equalsIgnoreCase(optString) || !optString2.equalsIgnoreCase("Rank Results")) && !"winner".equalsIgnoreCase(optString) && !Constant.SPONSOR.equalsIgnoreCase(optString)) {
                    if (!"tournament".equalsIgnoreCase(optString)) {
                        if ("lobby".equalsIgnoreCase(optString)) {
                            createAppsFlyerBattleShareLink(context, str, jSONObject.optString("Battle ID", ""), promise);
                            return;
                        }
                        if (!"superteam".equalsIgnoreCase(optString) && !"contest".equalsIgnoreCase(optString)) {
                            if (!"Team".equalsIgnoreCase(optString)) {
                                if ("audio".equalsIgnoreCase(optString)) {
                                    try {
                                        jSONObject.put("isDeepLinkRequired", BaseParser.TRUE);
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("id", jSONObject.get("Room ID"));
                                        JSONObject createDeepLinkPayload = createDeepLinkPayload("nav", "ChatRoomPodcast", jSONObject2.toString());
                                        if (createDeepLinkPayload != null) {
                                            jSONObject.put("deepLinkPayLoad", createDeepLinkPayload.toString());
                                        }
                                    } catch (Exception e2) {
                                        MLogger.e(Constant.APPS_FLYER_TAG, "createDeepLinkPayload: ", e2);
                                    }
                                    createAppsFlyerReferralShareLink(context, jSONObject.toString(), promise);
                                    return;
                                }
                                createAppsFlyerReferralShareLink(context, str, promise);
                                return;
                            }
                        }
                        createAppsFlyerFantasyLink(context, str, promise);
                        return;
                    }
                }
                createAppsFlyerTournamentShareLink(context, str, jSONObject.optString("Tournament ID", ""), promise);
                return;
            }
            createAppsFlyerReferralShareLink(context, str, promise);
        } catch (Exception e3) {
            promise.reject((String) "fail", e3.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0298, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x029a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x024e A[Catch:{ Exception -> 0x03ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x047a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010c A[Catch:{ Exception -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0234 A[SYNTHETIC, Splitter:B:97:0x0234] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void createAppsFlyerReferralShareLink(android.content.Context r25, java.lang.String r26, com.facebook.react.bridge.Promise r27) {
        /*
            r1 = r26
            java.lang.String r0 = "channel"
            java.lang.String r2 = "rd?referralCode="
            java.lang.String r3 = "actionParams"
            java.lang.String r4 = "notification_data"
            java.lang.String r5 = "actionPayload"
            java.lang.String r6 = "img"
            java.lang.String r7 = "name"
            java.lang.String r8 = "redirectUrl"
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]
            java.lang.String r11 = "createAppsFlyerReferralShareLink"
            r12 = 0
            r10[r12] = r11
            java.lang.String r11 = "CommonUtils"
            com.mpl.androidapp.utils.MLogger.d(r11, r10)
            setAppInviteOneLink(r12)
            com.appsflyer.share.LinkGenerator r10 = com.appsflyer.share.ShareInviteHelper.generateInviteUrl(r25)
            com.mpl.androidapp.react.UserInfo r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserInfo()
            java.lang.String r14 = "AppsFlyerRef"
            java.lang.String r15 = ""
            if (r13 == 0) goto L_0x00a2
            java.lang.String r16 = r13.getDisplayName()
            if (r16 == 0) goto L_0x003b
            java.lang.String r16 = r13.getDisplayName()
            goto L_0x003f
        L_0x003b:
            java.lang.String r16 = r13.getMobileNumber()
        L_0x003f:
            r12 = r16
            r10.setReferrerName(r12)
            int r12 = r13.getId()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r10.setReferrerUID(r12)
            int r12 = r13.getId()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r10.setReferrerCustomerId(r12)
            int r12 = r13.getId()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r9 = "Referrer ID"
            r10.addParameter(r9, r12)
            java.lang.String r9 = r13.getDisplayName()
            if (r9 == 0) goto L_0x0072
            java.lang.String r9 = r13.getDisplayName()
            goto L_0x0076
        L_0x0072:
            java.lang.String r9 = r13.getMobileNumber()
        L_0x0076:
            java.lang.String r12 = "Referrer Name"
            r10.addParameter(r12, r9)
            java.lang.String r9 = r13.getAvatar()
            if (r9 == 0) goto L_0x0092
            java.lang.String r9 = r13.getAvatar()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0092
            java.lang.String r9 = r13.getAvatar()
            r10.setReferrerImageURL(r9)
        L_0x0092:
            java.lang.String r9 = r13.getReferralCode()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x009d
            goto L_0x00ac
        L_0x009d:
            java.lang.String r9 = r13.getReferralCode()
            goto L_0x00ad
        L_0x00a2:
            java.lang.Object[] r12 = new java.lang.Object[r9]
            java.lang.String r9 = "createAppsFlyerTournamentBattleShareLink: user data is null"
            r13 = 0
            r12[r13] = r9
            com.mpl.androidapp.utils.MLogger.d(r14, r12)
        L_0x00ac:
            r9 = r15
        L_0x00ad:
            boolean r12 = android.text.TextUtils.isEmpty(r9)
            if (r12 == 0) goto L_0x00b7
            java.lang.String r9 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserReferralCode()
        L_0x00b7:
            boolean r12 = android.text.TextUtils.isEmpty(r9)
            if (r12 == 0) goto L_0x00c1
            java.lang.String r9 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserReferralCodeFromPref()
        L_0x00c1:
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x0409 }
            r13.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            java.lang.String r12 = "storyId"
            java.lang.String r12 = r13.optString(r12, r15)     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = "hashTagId"
            java.lang.String r1 = r13.optString(r1, r15)     // Catch:{ Exception -> 0x0409 }
            r17 = r14
            java.lang.String r14 = "isKO"
            r18 = r2
            r2 = 0
            boolean r14 = r13.optBoolean(r14, r2)     // Catch:{ Exception -> 0x0400 }
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ Exception -> 0x03f8 }
            r2.<init>()     // Catch:{ Exception -> 0x03f8 }
            r19 = r14
            java.lang.String r14 = r13.toString()     // Catch:{ Exception -> 0x03f5 }
            com.mpl.androidapp.utils.CommonUtils$5 r20 = new com.mpl.androidapp.utils.CommonUtils$5     // Catch:{ Exception -> 0x03f5 }
            r20.<init>()     // Catch:{ Exception -> 0x03f5 }
            r21 = r1
            java.lang.reflect.Type r1 = r20.getType()     // Catch:{ Exception -> 0x03f5 }
            java.lang.Object r1 = r2.fromJson(r14, r1)     // Catch:{ Exception -> 0x03f5 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x03f5 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x03f5 }
            r2.<init>()     // Catch:{ Exception -> 0x03f5 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x03f5 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x03f5 }
        L_0x0106:
            boolean r14 = r1.hasNext()     // Catch:{ Exception -> 0x03f5 }
            if (r14 == 0) goto L_0x01dd
            java.lang.Object r14 = r1.next()     // Catch:{ Exception -> 0x03f5 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ Exception -> 0x03f5 }
            java.lang.Object r20 = r14.getKey()     // Catch:{ Exception -> 0x03f5 }
            r22 = r1
            r1 = r20
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x03f5 }
            java.lang.Object r14 = r14.getValue()     // Catch:{ Exception -> 0x03f5 }
            boolean r20 = r8.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x03f5 }
            if (r20 == 0) goto L_0x0129
            r1 = r22
            goto L_0x0106
        L_0x0129:
            r20 = r8
            java.lang.String r8 = "Tournament ID"
            boolean r8 = r8.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x03ef }
            r23 = r12
            java.lang.String r12 = "Unique Code"
            r24 = r0
            java.lang.String r0 = "Feature"
            if (r8 == 0) goto L_0x0150
            if (r14 == 0) goto L_0x0150
            boolean r8 = isEmpty(r14)     // Catch:{ Exception -> 0x03ef }
            if (r8 != 0) goto L_0x0150
            java.lang.String r8 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x03ef }
            r10.addParameter(r12, r8)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r8 = "Tournament"
            r10.addParameter(r0, r8)     // Catch:{ Exception -> 0x03ef }
            goto L_0x01a6
        L_0x0150:
            java.lang.String r8 = "Battle ID"
            boolean r8 = r8.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x03ef }
            if (r8 == 0) goto L_0x016d
            if (r14 == 0) goto L_0x016d
            boolean r8 = isEmpty(r14)     // Catch:{ Exception -> 0x03ef }
            if (r8 != 0) goto L_0x016d
            java.lang.String r8 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x03ef }
            r10.addParameter(r12, r8)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r8 = "Battle"
            r10.addParameter(r0, r8)     // Catch:{ Exception -> 0x03ef }
            goto L_0x01a6
        L_0x016d:
            java.lang.String r8 = "Room ID"
            boolean r8 = r8.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x03ef }
            if (r8 == 0) goto L_0x018a
            if (r14 == 0) goto L_0x018a
            boolean r8 = isEmpty(r14)     // Catch:{ Exception -> 0x03ef }
            if (r8 != 0) goto L_0x018a
            java.lang.String r8 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x03ef }
            r10.addParameter(r12, r8)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r8 = "Audio Show"
            r10.addParameter(r0, r8)     // Catch:{ Exception -> 0x03ef }
            goto L_0x01a6
        L_0x018a:
            java.lang.String r8 = "Contest ID"
            boolean r8 = r8.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x03ef }
            if (r8 == 0) goto L_0x01a6
            if (r14 == 0) goto L_0x01a6
            boolean r8 = isEmpty(r14)     // Catch:{ Exception -> 0x03ef }
            if (r8 != 0) goto L_0x01a6
            java.lang.String r8 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x03ef }
            r10.addParameter(r12, r8)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r8 = "Contest"
            r10.addParameter(r0, r8)     // Catch:{ Exception -> 0x03ef }
        L_0x01a6:
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x03ef }
            if (r0 == 0) goto L_0x01bb
            if (r14 == 0) goto L_0x01bb
            boolean r0 = isEmpty(r14)     // Catch:{ Exception -> 0x03ef }
            if (r0 != 0) goto L_0x01bb
            java.lang.String r0 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x03ef }
            r10.setCampaign(r0)     // Catch:{ Exception -> 0x03ef }
        L_0x01bb:
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x03ef }
            java.lang.String r8 = "createAppsFlyerReferralShareLink: "
            r12 = 0
            r0[r12] = r8     // Catch:{ Exception -> 0x03ef }
            r8 = 1
            r0[r8] = r1     // Catch:{ Exception -> 0x03ef }
            r8 = 2
            r0[r8] = r14     // Catch:{ Exception -> 0x03ef }
            com.mpl.androidapp.utils.MLogger.d(r11, r0)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r0 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x03ef }
            r2.put(r1, r0)     // Catch:{ Exception -> 0x03ef }
            r8 = r20
            r1 = r22
            r12 = r23
            r0 = r24
            goto L_0x0106
        L_0x01dd:
            r24 = r0
            r20 = r8
            r23 = r12
            r10.addParameters(r2)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r0 = "type"
            java.lang.String r0 = r13.optString(r0, r15)     // Catch:{ Exception -> 0x03ef }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03ef }
            if (r1 != 0) goto L_0x01fc
            java.lang.String r1 = "audio"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x03ef }
            if (r1 == 0) goto L_0x01fc
            r0 = 1
            goto L_0x0220
        L_0x01fc:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03ef }
            if (r1 != 0) goto L_0x020e
            java.lang.String r1 = "group_invite"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x03ef }
            if (r1 == 0) goto L_0x020e
            r0 = 0
            r1 = 0
            r2 = 1
            goto L_0x0222
        L_0x020e:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03ef }
            if (r1 != 0) goto L_0x021f
            java.lang.String r1 = "story"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x03ef }
            if (r0 == 0) goto L_0x021f
            r0 = 0
            r1 = 1
            goto L_0x0221
        L_0x021f:
            r0 = 0
        L_0x0220:
            r1 = 0
        L_0x0221:
            r2 = 0
        L_0x0222:
            java.lang.String r8 = "MPLReferralCode"
            r10.addParameter(r8, r9)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r8 = "config.website.url"
            java.lang.String r12 = "https://www.mpl.live/"
            r14 = 1
            java.lang.String r8 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringPref(r8, r12, r14)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r12 = "af_android_url"
            if (r0 == 0) goto L_0x024e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ef }
            r0.<init>()     // Catch:{ Exception -> 0x03ef }
            r0.append(r8)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r1 = "audio-show"
            r0.append(r1)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03ef }
            r10.addParameter(r12, r0)     // Catch:{ Exception -> 0x03ef }
        L_0x0248:
            r1 = r18
            r3 = r20
            goto L_0x0420
        L_0x024e:
            boolean r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isReferralRedirectEnabled()     // Catch:{ Exception -> 0x03ef }
            java.lang.String r14 = com.mpl.androidapp.utils.MSharedPreferencesUtils.referralRedirectUrl()     // Catch:{ Exception -> 0x03ef }
            if (r0 == 0) goto L_0x03c1
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x03bd }
            if (r0 != 0) goto L_0x03c1
            if (r2 == 0) goto L_0x035e
            boolean r0 = r13.has(r7)     // Catch:{ Exception -> 0x03ef }
            if (r0 == 0) goto L_0x0275
            java.lang.String r0 = r13.optString(r7)     // Catch:{ Exception -> 0x03ef }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03ef }
            if (r0 != 0) goto L_0x0275
            java.lang.String r0 = r13.optString(r7)     // Catch:{ Exception -> 0x03ef }
            goto L_0x0276
        L_0x0275:
            r0 = r15
        L_0x0276:
            boolean r1 = r13.has(r6)     // Catch:{ Exception -> 0x03ef }
            if (r1 == 0) goto L_0x028b
            java.lang.String r1 = r13.optString(r6)     // Catch:{ Exception -> 0x03ef }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x03ef }
            if (r1 != 0) goto L_0x028b
            java.lang.String r1 = r13.optString(r6)     // Catch:{ Exception -> 0x03ef }
            goto L_0x028c
        L_0x028b:
            r1 = r15
        L_0x028c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r8 = "channel_url"
            if (r2 != 0) goto L_0x029a
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x03ef }
            if (r2 == 0) goto L_0x02fc
        L_0x029a:
            boolean r2 = r13.has(r4)     // Catch:{ Exception -> 0x03ef }
            if (r2 == 0) goto L_0x02fc
            java.lang.String r2 = r13.optString(r4)     // Catch:{ Exception -> 0x03ef }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x03ef }
            if (r2 != 0) goto L_0x02fc
            java.lang.String r2 = r13.optString(r4)     // Catch:{ Exception -> 0x03ef }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x03ef }
            r4.<init>(r2)     // Catch:{ Exception -> 0x03ef }
            boolean r2 = r4.has(r3)     // Catch:{ Exception -> 0x03ef }
            if (r2 == 0) goto L_0x02fc
            java.lang.String r2 = r4.optString(r3)     // Catch:{ Exception -> 0x03ef }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x03ef }
            if (r2 != 0) goto L_0x02fc
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x03ef }
            java.lang.String r3 = r4.optString(r3)     // Catch:{ Exception -> 0x03ef }
            r2.<init>(r3)     // Catch:{ Exception -> 0x03ef }
            boolean r3 = r2.has(r5)     // Catch:{ Exception -> 0x03ef }
            if (r3 == 0) goto L_0x02fc
            org.json.JSONObject r3 = r2.optJSONObject(r5)     // Catch:{ Exception -> 0x03ef }
            if (r3 == 0) goto L_0x02fc
            org.json.JSONObject r3 = r2.optJSONObject(r5)     // Catch:{ Exception -> 0x03ef }
            r4 = r24
            org.json.JSONObject r3 = r3.optJSONObject(r4)     // Catch:{ Exception -> 0x03ef }
            if (r3 == 0) goto L_0x02fc
            org.json.JSONObject r0 = r2.optJSONObject(r5)     // Catch:{ Exception -> 0x03ef }
            org.json.JSONObject r0 = r0.optJSONObject(r4)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r1 = r0.optString(r7)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r2 = "coverUrl"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r15 = r0.optString(r8)     // Catch:{ Exception -> 0x03ef }
            r0 = r1
            r1 = r2
        L_0x02fc:
            android.net.Uri r2 = android.net.Uri.parse(r14)     // Catch:{ Exception -> 0x03ef }
            android.net.Uri$Builder r3 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x03ef }
            r3.<init>()     // Catch:{ Exception -> 0x03ef }
            java.lang.String r4 = r2.getScheme()     // Catch:{ Exception -> 0x03ef }
            r3.scheme(r4)     // Catch:{ Exception -> 0x03ef }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03ef }
            if (r4 != 0) goto L_0x031a
            java.lang.String r4 = "groups"
            r3.appendPath(r4)     // Catch:{ Exception -> 0x03ef }
            r3.appendPath(r0)     // Catch:{ Exception -> 0x03ef }
        L_0x031a:
            java.lang.String r0 = r2.getAuthority()     // Catch:{ Exception -> 0x03ef }
            r3.authority(r0)     // Catch:{ Exception -> 0x03ef }
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x03ef }
            if (r0 != 0) goto L_0x032e
            java.lang.String r0 = android.net.Uri.encode(r1)     // Catch:{ Exception -> 0x03ef }
            r3.appendQueryParameter(r6, r0)     // Catch:{ Exception -> 0x03ef }
        L_0x032e:
            android.net.Uri r0 = r3.build()     // Catch:{ Exception -> 0x03ef }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03ef }
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x03ef }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ef }
            r1.<init>()     // Catch:{ Exception -> 0x03ef }
            java.lang.String r3 = "added url for share"
            r1.append(r3)     // Catch:{ Exception -> 0x03ef }
            r1.append(r0)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03ef }
            r3 = 0
            r2[r3] = r1     // Catch:{ Exception -> 0x03ef }
            com.mpl.androidapp.utils.MLogger.d(r11, r2)     // Catch:{ Exception -> 0x03ef }
            r10.addParameter(r12, r0)     // Catch:{ Exception -> 0x03ef }
            boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x03ef }
            if (r0 != 0) goto L_0x0248
            r10.addParameter(r8, r15)     // Catch:{ Exception -> 0x03ef }
            goto L_0x0248
        L_0x035e:
            java.lang.String r0 = "?referralCode="
            if (r1 == 0) goto L_0x0393
            boolean r1 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x03ef }
            if (r1 == 0) goto L_0x0386
            boolean r1 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x03ef }
            if (r1 != 0) goto L_0x036f
            goto L_0x0386
        L_0x036f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ef }
            r1.<init>()     // Catch:{ Exception -> 0x03ef }
            r1.append(r14)     // Catch:{ Exception -> 0x03ef }
            r1.append(r0)     // Catch:{ Exception -> 0x03ef }
            r1.append(r9)     // Catch:{ Exception -> 0x03ef }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x03ef }
            r10.addParameter(r12, r0)     // Catch:{ Exception -> 0x03ef }
            goto L_0x0248
        L_0x0386:
            r2 = r21
            r0 = r23
            java.lang.String r0 = getStoryUrl(r14, r0, r2)     // Catch:{ Exception -> 0x03ef }
            r10.addParameter(r12, r0)     // Catch:{ Exception -> 0x03ef }
            goto L_0x0248
        L_0x0393:
            r3 = r20
            java.lang.String r1 = r13.optString(r3, r15)     // Catch:{ Exception -> 0x03ed }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x03ed }
            if (r1 != 0) goto L_0x03a7
            java.lang.String r0 = r13.optString(r3, r15)     // Catch:{ Exception -> 0x03ed }
            r10.addParameter(r12, r0)     // Catch:{ Exception -> 0x03ed }
            goto L_0x03d0
        L_0x03a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ed }
            r1.<init>()     // Catch:{ Exception -> 0x03ed }
            r1.append(r14)     // Catch:{ Exception -> 0x03ed }
            r1.append(r0)     // Catch:{ Exception -> 0x03ed }
            r1.append(r9)     // Catch:{ Exception -> 0x03ed }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x03ed }
            r10.addParameter(r12, r0)     // Catch:{ Exception -> 0x03ed }
            goto L_0x03d0
        L_0x03bd:
            r0 = move-exception
            r3 = r20
            goto L_0x03fc
        L_0x03c1:
            r3 = r20
            r2 = r21
            r0 = r23
            if (r1 == 0) goto L_0x03d3
            java.lang.String r0 = getStoryUrl(r8, r0, r2)     // Catch:{ Exception -> 0x03ed }
            r10.addParameter(r12, r0)     // Catch:{ Exception -> 0x03ed }
        L_0x03d0:
            r1 = r18
            goto L_0x0420
        L_0x03d3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ed }
            r0.<init>()     // Catch:{ Exception -> 0x03ed }
            r0.append(r8)     // Catch:{ Exception -> 0x03ed }
            r1 = r18
            r0.append(r1)     // Catch:{ Exception -> 0x03eb }
            r0.append(r9)     // Catch:{ Exception -> 0x03eb }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03eb }
            r10.addParameter(r12, r0)     // Catch:{ Exception -> 0x03eb }
            goto L_0x0420
        L_0x03eb:
            r0 = move-exception
            goto L_0x03fe
        L_0x03ed:
            r0 = move-exception
            goto L_0x03fc
        L_0x03ef:
            r0 = move-exception
            r1 = r18
            r3 = r20
            goto L_0x03fe
        L_0x03f5:
            r0 = move-exception
            r3 = r8
            goto L_0x03fc
        L_0x03f8:
            r0 = move-exception
            r3 = r8
            r19 = r14
        L_0x03fc:
            r1 = r18
        L_0x03fe:
            r2 = 2
            goto L_0x0411
        L_0x0400:
            r0 = move-exception
            r3 = r8
            r1 = r18
            goto L_0x040e
        L_0x0405:
            r0 = move-exception
            r1 = r2
            r3 = r8
            goto L_0x040e
        L_0x0409:
            r0 = move-exception
            r1 = r2
            r3 = r8
            r17 = r14
        L_0x040e:
            r2 = 2
            r19 = 0
        L_0x0411:
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "createAppsFlyerReferralLink: "
            r5 = 0
            r2[r5] = r4
            r4 = 1
            r2[r4] = r0
            r4 = r17
            com.mpl.androidapp.utils.MLogger.e(r4, r2)
        L_0x0420:
            r14 = r19
            java.lang.String r0 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppName()
            r10.setChannel(r0)
            java.lang.String r0 = "Referrer Code"
            r10.addParameter(r0, r9)
            java.lang.String r0 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppName()
            java.lang.String r2 = "Referral Source"
            r10.addParameter(r2, r0)
            java.lang.String r0 = "is_retargeting"
            java.lang.String r2 = "true"
            r10.addParameter(r0, r2)
            java.lang.String r0 = "af_param_forwarding"
            java.lang.String r2 = "false"
            r10.addParameter(r0, r2)
            r2 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x045f }
            r4 = r26
            r0.<init>(r4)     // Catch:{ JSONException -> 0x045f }
            java.lang.String r2 = r0.optString(r3)     // Catch:{ JSONException -> 0x045f }
            r3 = 1
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ JSONException -> 0x045f }
            java.lang.String r3 = r2.toString()     // Catch:{ JSONException -> 0x045f }
            r4 = 0
            r0[r4] = r3     // Catch:{ JSONException -> 0x045f }
            com.mpl.androidapp.utils.MLogger.d(r11, r0)     // Catch:{ JSONException -> 0x045f }
            goto L_0x0463
        L_0x045f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0463:
            if (r14 == 0) goto L_0x0472
            java.lang.String r0 = "gamekhelo://mplpro"
            java.lang.String r3 = "utf-8"
            java.lang.String r0 = android.net.Uri.encode(r0, r3)
            java.lang.String r3 = "af_dp"
            r10.addParameter(r3, r0)
        L_0x0472:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = "af_web_dp"
            if (r0 != 0) goto L_0x0489
            if (r2 == 0) goto L_0x0489
            r10.addParameter(r3, r2)
            r1 = 1
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r1 = 0
            r0[r1] = r2
            com.mpl.androidapp.utils.MLogger.d(r11, r0)
            goto L_0x04c9
        L_0x0489:
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            if (r0 == 0) goto L_0x04c9
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            java.lang.String r4 = "referral.website.url"
            java.lang.String r0 = r0.optString(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04c9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            org.json.JSONObject r5 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            java.lang.String r4 = r5.optString(r4)
            r0.append(r4)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r10.addParameter(r3, r0)
            r1 = 1
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = r2.toString()
            r2 = 0
            r0[r2] = r1
            com.mpl.androidapp.utils.MLogger.d(r11, r0)
        L_0x04c9:
            com.mpl.androidapp.utils.CommonUtils$6 r0 = new com.mpl.androidapp.utils.CommonUtils$6
            r1 = r27
            r0.<init>()
            r1 = r25
            r10.generateLink(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.CommonUtils.createAppsFlyerReferralShareLink(android.content.Context, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r23v0 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v31 */
    /* JADX WARNING: type inference failed for: r5v32 */
    /* JADX WARNING: type inference failed for: r5v33 */
    /* JADX WARNING: type inference failed for: r23v1 */
    /* JADX WARNING: type inference failed for: r5v34 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r23v4 */
    /* JADX WARNING: type inference failed for: r9v15 */
    /* JADX WARNING: type inference failed for: r9v30 */
    /* JADX WARNING: type inference failed for: r9v31 */
    /* JADX WARNING: type inference failed for: r9v32 */
    /* JADX WARNING: type inference failed for: r5v41 */
    /* JADX WARNING: type inference failed for: r5v42 */
    /* JADX WARNING: type inference failed for: r5v43 */
    /* JADX WARNING: type inference failed for: r5v44 */
    /* JADX WARNING: type inference failed for: r5v45 */
    /* JADX WARNING: type inference failed for: r9v33 */
    /* JADX WARNING: type inference failed for: r9v34 */
    /* JADX WARNING: type inference failed for: r9v35 */
    /* JADX WARNING: type inference failed for: r23v5 */
    /* JADX WARNING: type inference failed for: r23v6 */
    /* JADX WARNING: type inference failed for: r23v7 */
    /* JADX WARNING: type inference failed for: r23v8 */
    /* JADX WARNING: type inference failed for: r23v9 */
    /* JADX WARNING: type inference failed for: r23v10 */
    /* JADX WARNING: type inference failed for: r23v11 */
    /* JADX WARNING: type inference failed for: r23v12 */
    /* JADX WARNING: type inference failed for: r5v46 */
    /* JADX WARNING: type inference failed for: r5v47 */
    /* JADX WARNING: type inference failed for: r5v48 */
    /* JADX WARNING: type inference failed for: r5v49 */
    /* JADX WARNING: type inference failed for: r5v50 */
    /* JADX WARNING: type inference failed for: r5v51 */
    /* JADX WARNING: type inference failed for: r5v52 */
    /* JADX WARNING: type inference failed for: r5v53 */
    /* JADX WARNING: type inference failed for: r5v54 */
    /* JADX WARNING: type inference failed for: r5v55 */
    /* JADX WARNING: type inference failed for: r5v56 */
    /* JADX WARNING: type inference failed for: r5v57 */
    /* JADX WARNING: type inference failed for: r5v58 */
    /* JADX WARNING: type inference failed for: r9v36 */
    /* JADX WARNING: type inference failed for: r23v13 */
    /* JADX WARNING: type inference failed for: r23v14 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v2
      assigns: []
      uses: []
      mth insns count: 467
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0265 A[SYNTHETIC, Splitter:B:113:0x0265] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x027f A[SYNTHETIC, Splitter:B:116:0x027f] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0350 A[Catch:{ Exception -> 0x01f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0365 A[Catch:{ Exception -> 0x01f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0396 A[Catch:{ Exception -> 0x01f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x04af  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x04c0  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0106 A[SYNTHETIC, Splitter:B:39:0x0106] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0201  */
    /* JADX WARNING: Unknown variable types count: 21 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void createAppsFlyerTournamentBattleShareLink(android.content.Context r27, java.lang.String r28, java.lang.String r29, boolean r30, com.facebook.react.bridge.Promise r31, boolean r32) {
        /*
            r1 = r28
            java.lang.String r0 = "channel"
            java.lang.String r2 = "true"
            java.lang.String r3 = "actionParams"
            java.lang.String r4 = "notification_data"
            java.lang.String r5 = "actionPayload"
            java.lang.String r6 = "img"
            java.lang.String r7 = "name"
            java.lang.String r8 = "rd?referralCode="
            java.lang.String r9 = "redirectUrl"
            setAppInviteOneLink(r32)
            com.appsflyer.share.LinkGenerator r10 = com.appsflyer.share.ShareInviteHelper.generateInviteUrl(r27)
            com.mpl.androidapp.react.UserInfo r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserInfo()
            java.lang.String r12 = "AppsFlyerRef"
            java.lang.String r15 = ""
            if (r11 == 0) goto L_0x0097
            java.lang.String r16 = r11.getDisplayName()
            if (r16 == 0) goto L_0x0030
            java.lang.String r16 = r11.getDisplayName()
            goto L_0x0034
        L_0x0030:
            java.lang.String r16 = r11.getMobileNumber()
        L_0x0034:
            r14 = r16
            r10.setReferrerName(r14)
            int r14 = r11.getId()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            r10.setReferrerUID(r14)
            int r14 = r11.getId()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            r10.setReferrerCustomerId(r14)
            int r14 = r11.getId()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r13 = "Referrer ID"
            r10.addParameter(r13, r14)
            java.lang.String r13 = r11.getDisplayName()
            if (r13 == 0) goto L_0x0067
            java.lang.String r13 = r11.getDisplayName()
            goto L_0x006b
        L_0x0067:
            java.lang.String r13 = r11.getMobileNumber()
        L_0x006b:
            java.lang.String r14 = "Referrer Name"
            r10.addParameter(r14, r13)
            java.lang.String r13 = r11.getAvatar()
            if (r13 == 0) goto L_0x0087
            java.lang.String r13 = r11.getAvatar()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x0087
            java.lang.String r13 = r11.getAvatar()
            r10.setReferrerImageURL(r13)
        L_0x0087:
            java.lang.String r13 = r11.getReferralCode()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x0092
            goto L_0x00a2
        L_0x0092:
            java.lang.String r11 = r11.getReferralCode()
            goto L_0x00a3
        L_0x0097:
            r11 = 1
            java.lang.Object[] r13 = new java.lang.Object[r11]
            java.lang.String r11 = "createAppsFlyerTournamentBattleShareLink: user data is null"
            r14 = 0
            r13[r14] = r11
            com.mpl.androidapp.utils.MLogger.d(r12, r13)
        L_0x00a2:
            r11 = r15
        L_0x00a3:
            boolean r13 = android.text.TextUtils.isEmpty(r11)
            if (r13 == 0) goto L_0x00ad
            java.lang.String r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserReferralCode()
        L_0x00ad:
            boolean r13 = android.text.TextUtils.isEmpty(r11)
            if (r13 == 0) goto L_0x00b7
            java.lang.String r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserReferralCodeFromPref()
        L_0x00b7:
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x0471 }
            r14.<init>(r1)     // Catch:{ Exception -> 0x0471 }
            java.lang.String r13 = "storyId"
            java.lang.String r13 = r14.optString(r13, r15)     // Catch:{ Exception -> 0x0471 }
            r17 = r8
            java.lang.String r8 = "hashTagId"
            java.lang.String r8 = r14.optString(r8, r15)     // Catch:{ Exception -> 0x046c }
            r18 = r8
            java.lang.String r8 = "isKO"
            r19 = r13
            r13 = 0
            boolean r8 = r14.optBoolean(r8, r13)     // Catch:{ Exception -> 0x046c }
            com.google.gson.Gson r13 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0462 }
            r13.<init>()     // Catch:{ Exception -> 0x0462 }
            r20 = r8
            java.lang.String r8 = r14.toString()     // Catch:{ Exception -> 0x0460 }
            com.mpl.androidapp.utils.CommonUtils$7 r21 = new com.mpl.androidapp.utils.CommonUtils$7     // Catch:{ Exception -> 0x0460 }
            r21.<init>()     // Catch:{ Exception -> 0x0460 }
            r22 = r0
            java.lang.reflect.Type r0 = r21.getType()     // Catch:{ Exception -> 0x0460 }
            java.lang.Object r0 = r13.fromJson(r8, r0)     // Catch:{ Exception -> 0x0460 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0460 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x0460 }
            r8.<init>()     // Catch:{ Exception -> 0x0460 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x0460 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0460 }
        L_0x00fe:
            boolean r13 = r0.hasNext()     // Catch:{ Exception -> 0x0460 }
            java.lang.String r21 = "createAppsFlyerTournamentBattleShareLink: "
            if (r13 == 0) goto L_0x01d5
            java.lang.Object r13 = r0.next()     // Catch:{ Exception -> 0x0460 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ Exception -> 0x0460 }
            java.lang.Object r23 = r13.getKey()     // Catch:{ Exception -> 0x0460 }
            r24 = r0
            r0 = r23
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0460 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ Exception -> 0x0460 }
            boolean r23 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0460 }
            if (r23 == 0) goto L_0x0123
            r0 = r24
            goto L_0x00fe
        L_0x0123:
            r23 = r9
            java.lang.String r9 = "Tournament ID"
            boolean r9 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x01f2 }
            r25 = r5
            java.lang.String r5 = "Unique Code"
            r26 = r3
            java.lang.String r3 = "Feature"
            if (r9 == 0) goto L_0x014a
            if (r13 == 0) goto L_0x014a
            boolean r9 = isEmpty(r13)     // Catch:{ Exception -> 0x01f2 }
            if (r9 != 0) goto L_0x014a
            java.lang.String r9 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01f2 }
            r10.addParameter(r5, r9)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r5 = "Tournament"
            r10.addParameter(r3, r5)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x01a0
        L_0x014a:
            java.lang.String r9 = "Battle ID"
            boolean r9 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x01f2 }
            if (r9 == 0) goto L_0x0167
            if (r13 == 0) goto L_0x0167
            boolean r9 = isEmpty(r13)     // Catch:{ Exception -> 0x01f2 }
            if (r9 != 0) goto L_0x0167
            java.lang.String r9 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01f2 }
            r10.addParameter(r5, r9)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r5 = "Battle"
            r10.addParameter(r3, r5)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x01a0
        L_0x0167:
            java.lang.String r9 = "Room ID"
            boolean r9 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x01f2 }
            if (r9 == 0) goto L_0x0184
            if (r13 == 0) goto L_0x0184
            boolean r9 = isEmpty(r13)     // Catch:{ Exception -> 0x01f2 }
            if (r9 != 0) goto L_0x0184
            java.lang.String r9 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01f2 }
            r10.addParameter(r5, r9)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r5 = "Audio Show"
            r10.addParameter(r3, r5)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x01a0
        L_0x0184:
            java.lang.String r9 = "Contest ID"
            boolean r9 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x01f2 }
            if (r9 == 0) goto L_0x01a0
            if (r13 == 0) goto L_0x01a0
            boolean r9 = isEmpty(r13)     // Catch:{ Exception -> 0x01f2 }
            if (r9 != 0) goto L_0x01a0
            java.lang.String r9 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01f2 }
            r10.addParameter(r5, r9)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r5 = "Contest"
            r10.addParameter(r3, r5)     // Catch:{ Exception -> 0x01f2 }
        L_0x01a0:
            boolean r3 = r3.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x01f2 }
            if (r3 == 0) goto L_0x01b5
            if (r13 == 0) goto L_0x01b5
            boolean r3 = isEmpty(r13)     // Catch:{ Exception -> 0x01f2 }
            if (r3 != 0) goto L_0x01b5
            java.lang.String r3 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01f2 }
            r10.setCampaign(r3)     // Catch:{ Exception -> 0x01f2 }
        L_0x01b5:
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01f2 }
            r5 = 0
            r3[r5] = r21     // Catch:{ Exception -> 0x01f2 }
            r5 = 1
            r3[r5] = r0     // Catch:{ Exception -> 0x01f2 }
            r5 = 2
            r3[r5] = r13     // Catch:{ Exception -> 0x01f2 }
            com.mpl.androidapp.utils.MLogger.d(r12, r3)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r3 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01f2 }
            r8.put(r0, r3)     // Catch:{ Exception -> 0x01f2 }
            r9 = r23
            r0 = r24
            r5 = r25
            r3 = r26
            goto L_0x00fe
        L_0x01d5:
            r26 = r3
            r25 = r5
            r23 = r9
            java.lang.String r0 = "type"
            java.lang.String r0 = r14.optString(r0, r15)     // Catch:{ Exception -> 0x045a }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x045a }
            if (r3 != 0) goto L_0x01fb
            java.lang.String r3 = "audio"
            boolean r3 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x01f2 }
            if (r3 == 0) goto L_0x01fb
            r0 = 0
            r3 = 1
            goto L_0x021f
        L_0x01f2:
            r0 = move-exception
            r6 = r17
            r14 = r20
            r5 = r23
            goto L_0x046a
        L_0x01fb:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x045a }
            if (r3 != 0) goto L_0x020d
            java.lang.String r3 = "group_invite"
            boolean r3 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x01f2 }
            if (r3 == 0) goto L_0x020d
            r0 = 0
            r3 = 0
            r5 = 1
            goto L_0x0220
        L_0x020d:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x045a }
            if (r3 != 0) goto L_0x021d
            java.lang.String r3 = "story"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x01f2 }
            if (r0 == 0) goto L_0x021d
            r0 = 1
            goto L_0x021e
        L_0x021d:
            r0 = 0
        L_0x021e:
            r3 = 0
        L_0x021f:
            r5 = 0
        L_0x0220:
            r10.addParameters(r8)     // Catch:{ Exception -> 0x045a }
            r8 = r29
            r9 = r30
            r13 = r32
            org.json.JSONObject r8 = createDeepLinkPayload(r1, r8, r9, r13)     // Catch:{ Exception -> 0x045a }
            r9 = 2
            java.lang.Object[] r13 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x045a }
            r9 = 0
            r13[r9] = r21     // Catch:{ Exception -> 0x045a }
            java.lang.String r9 = r8.toString()     // Catch:{ Exception -> 0x045a }
            r16 = 1
            r13[r16] = r9     // Catch:{ Exception -> 0x045a }
            com.mpl.androidapp.utils.MLogger.d(r12, r13)     // Catch:{ Exception -> 0x045a }
            java.lang.String r9 = "isDeepLinkRequired"
            r10.addParameter(r9, r2)     // Catch:{ Exception -> 0x045a }
            java.lang.String r9 = "deepLinkPayLoad"
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x045a }
            r10.addParameter(r9, r8)     // Catch:{ Exception -> 0x045a }
            java.lang.String r8 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppName()     // Catch:{ Exception -> 0x045a }
            r10.setChannel(r8)     // Catch:{ Exception -> 0x045a }
            java.lang.String r8 = "MPLReferralCode"
            r10.addParameter(r8, r11)     // Catch:{ Exception -> 0x045a }
            java.lang.String r8 = "config.website.url"
            java.lang.String r9 = "https://www.mpl.live/"
            r13 = 1
            java.lang.String r8 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringPref(r8, r9, r13)     // Catch:{ Exception -> 0x045a }
            java.lang.String r9 = "af_android_url"
            if (r3 == 0) goto L_0x027f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f2 }
            r0.<init>()     // Catch:{ Exception -> 0x01f2 }
            r0.append(r8)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r3 = "audio-show"
            r0.append(r3)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01f2 }
            r10.addParameter(r9, r0)     // Catch:{ Exception -> 0x01f2 }
        L_0x0279:
            r6 = r17
            r5 = r23
            goto L_0x0455
        L_0x027f:
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isReferralRedirectEnabled()     // Catch:{ Exception -> 0x045a }
            java.lang.String r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.referralRedirectUrl()     // Catch:{ Exception -> 0x045a }
            if (r3 == 0) goto L_0x0405
            boolean r3 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0400 }
            if (r3 != 0) goto L_0x0405
            if (r5 == 0) goto L_0x039e
            boolean r0 = r14.has(r7)     // Catch:{ Exception -> 0x01f2 }
            if (r0 == 0) goto L_0x02a6
            java.lang.String r0 = r14.optString(r7)     // Catch:{ Exception -> 0x01f2 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01f2 }
            if (r0 != 0) goto L_0x02a6
            java.lang.String r0 = r14.optString(r7)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x02a7
        L_0x02a6:
            r0 = r15
        L_0x02a7:
            boolean r3 = r14.has(r6)     // Catch:{ Exception -> 0x01f2 }
            if (r3 == 0) goto L_0x02bc
            java.lang.String r3 = r14.optString(r6)     // Catch:{ Exception -> 0x01f2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01f2 }
            if (r3 != 0) goto L_0x02bc
            java.lang.String r3 = r14.optString(r6)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x02bd
        L_0x02bc:
            r3 = r15
        L_0x02bd:
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r8 = "channel_url"
            if (r5 != 0) goto L_0x02cf
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01f2 }
            if (r5 == 0) goto L_0x02cc
            goto L_0x02cf
        L_0x02cc:
            r29 = r0
            goto L_0x0338
        L_0x02cf:
            boolean r5 = r14.has(r4)     // Catch:{ Exception -> 0x01f2 }
            if (r5 == 0) goto L_0x02cc
            java.lang.String r5 = r14.optString(r4)     // Catch:{ Exception -> 0x01f2 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01f2 }
            if (r5 != 0) goto L_0x02cc
            java.lang.String r4 = r14.optString(r4)     // Catch:{ Exception -> 0x01f2 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x01f2 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x01f2 }
            r4 = r26
            boolean r14 = r5.has(r4)     // Catch:{ Exception -> 0x01f2 }
            if (r14 == 0) goto L_0x02cc
            java.lang.String r14 = r5.optString(r4)     // Catch:{ Exception -> 0x01f2 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x01f2 }
            if (r14 != 0) goto L_0x02cc
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r4 = r5.optString(r4)     // Catch:{ Exception -> 0x01f2 }
            r14.<init>(r4)     // Catch:{ Exception -> 0x01f2 }
            r4 = r25
            boolean r5 = r14.has(r4)     // Catch:{ Exception -> 0x01f2 }
            if (r5 == 0) goto L_0x02cc
            org.json.JSONObject r5 = r14.optJSONObject(r4)     // Catch:{ Exception -> 0x01f2 }
            if (r5 == 0) goto L_0x02cc
            org.json.JSONObject r5 = r14.optJSONObject(r4)     // Catch:{ Exception -> 0x01f2 }
            r29 = r0
            r0 = r22
            org.json.JSONObject r5 = r5.optJSONObject(r0)     // Catch:{ Exception -> 0x01f2 }
            if (r5 == 0) goto L_0x0338
            org.json.JSONObject r3 = r14.optJSONObject(r4)     // Catch:{ Exception -> 0x01f2 }
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r3 = r0.optString(r7)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r4 = "coverUrl"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r15 = r0.optString(r8)     // Catch:{ Exception -> 0x01f2 }
            r0 = r3
            r3 = r4
            goto L_0x033a
        L_0x0338:
            r0 = r29
        L_0x033a:
            android.net.Uri r4 = android.net.Uri.parse(r13)     // Catch:{ Exception -> 0x01f2 }
            android.net.Uri$Builder r5 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x01f2 }
            r5.<init>()     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r7 = r4.getScheme()     // Catch:{ Exception -> 0x01f2 }
            r5.scheme(r7)     // Catch:{ Exception -> 0x01f2 }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01f2 }
            if (r7 != 0) goto L_0x0358
            java.lang.String r7 = "groups"
            r5.appendPath(r7)     // Catch:{ Exception -> 0x01f2 }
            r5.appendPath(r0)     // Catch:{ Exception -> 0x01f2 }
        L_0x0358:
            java.lang.String r0 = r4.getAuthority()     // Catch:{ Exception -> 0x01f2 }
            r5.authority(r0)     // Catch:{ Exception -> 0x01f2 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01f2 }
            if (r0 != 0) goto L_0x036c
            java.lang.String r0 = android.net.Uri.encode(r3)     // Catch:{ Exception -> 0x01f2 }
            r5.appendQueryParameter(r6, r0)     // Catch:{ Exception -> 0x01f2 }
        L_0x036c:
            android.net.Uri r0 = r5.build()     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r3 = "CommonUtils"
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01f2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f2 }
            r4.<init>()     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r6 = "added url for share"
            r4.append(r6)     // Catch:{ Exception -> 0x01f2 }
            r4.append(r0)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01f2 }
            r6 = 0
            r5[r6] = r4     // Catch:{ Exception -> 0x01f2 }
            com.mpl.androidapp.utils.MLogger.d(r3, r5)     // Catch:{ Exception -> 0x01f2 }
            boolean r3 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x01f2 }
            if (r3 != 0) goto L_0x0399
            r10.addParameter(r8, r15)     // Catch:{ Exception -> 0x01f2 }
        L_0x0399:
            r10.addParameter(r9, r0)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x0279
        L_0x039e:
            java.lang.String r3 = "?referralCode="
            if (r0 == 0) goto L_0x03d3
            boolean r0 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x01f2 }
            if (r0 == 0) goto L_0x03c6
            boolean r0 = android.text.TextUtils.isEmpty(r18)     // Catch:{ Exception -> 0x01f2 }
            if (r0 != 0) goto L_0x03af
            goto L_0x03c6
        L_0x03af:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f2 }
            r0.<init>()     // Catch:{ Exception -> 0x01f2 }
            r0.append(r13)     // Catch:{ Exception -> 0x01f2 }
            r0.append(r3)     // Catch:{ Exception -> 0x01f2 }
            r0.append(r11)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01f2 }
            r10.addParameter(r9, r0)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x0279
        L_0x03c6:
            r4 = r18
            r3 = r19
            java.lang.String r0 = getStoryUrl(r13, r3, r4)     // Catch:{ Exception -> 0x01f2 }
            r10.addParameter(r9, r0)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x0279
        L_0x03d3:
            r5 = r23
            java.lang.String r0 = r14.optString(r5, r15)     // Catch:{ Exception -> 0x043c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x043c }
            if (r0 != 0) goto L_0x03ea
            java.lang.String r0 = r14.optString(r5, r15)     // Catch:{ Exception -> 0x043c }
            r10.addParameter(r9, r0)     // Catch:{ Exception -> 0x043c }
        L_0x03e6:
            r6 = r17
            goto L_0x0455
        L_0x03ea:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x043c }
            r0.<init>()     // Catch:{ Exception -> 0x043c }
            r0.append(r13)     // Catch:{ Exception -> 0x043c }
            r0.append(r3)     // Catch:{ Exception -> 0x043c }
            r0.append(r11)     // Catch:{ Exception -> 0x043c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x043c }
            r10.addParameter(r9, r0)     // Catch:{ Exception -> 0x043c }
            goto L_0x03e6
        L_0x0400:
            r0 = move-exception
            r5 = r23
            goto L_0x0466
        L_0x0405:
            r4 = r18
            r3 = r19
            r5 = r23
            if (r0 == 0) goto L_0x043e
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x043c }
            if (r0 == 0) goto L_0x0432
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x043c }
            if (r0 != 0) goto L_0x041a
            goto L_0x0432
        L_0x041a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x043c }
            r0.<init>()     // Catch:{ Exception -> 0x043c }
            r0.append(r8)     // Catch:{ Exception -> 0x043c }
            r6 = r17
            r0.append(r6)     // Catch:{ Exception -> 0x0458 }
            r0.append(r11)     // Catch:{ Exception -> 0x0458 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0458 }
            r10.addParameter(r9, r0)     // Catch:{ Exception -> 0x0458 }
            goto L_0x0455
        L_0x0432:
            r6 = r17
            java.lang.String r0 = getStoryUrl(r8, r3, r4)     // Catch:{ Exception -> 0x0458 }
            r10.addParameter(r9, r0)     // Catch:{ Exception -> 0x0458 }
            goto L_0x0455
        L_0x043c:
            r0 = move-exception
            goto L_0x0466
        L_0x043e:
            r6 = r17
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0458 }
            r0.<init>()     // Catch:{ Exception -> 0x0458 }
            r0.append(r8)     // Catch:{ Exception -> 0x0458 }
            r0.append(r6)     // Catch:{ Exception -> 0x0458 }
            r0.append(r11)     // Catch:{ Exception -> 0x0458 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0458 }
            r10.addParameter(r9, r0)     // Catch:{ Exception -> 0x0458 }
        L_0x0455:
            r8 = r20
            goto L_0x0484
        L_0x0458:
            r0 = move-exception
            goto L_0x0468
        L_0x045a:
            r0 = move-exception
            r6 = r17
            r5 = r23
            goto L_0x0468
        L_0x0460:
            r0 = move-exception
            goto L_0x0465
        L_0x0462:
            r0 = move-exception
            r20 = r8
        L_0x0465:
            r5 = r9
        L_0x0466:
            r6 = r17
        L_0x0468:
            r14 = r20
        L_0x046a:
            r3 = 2
            goto L_0x0476
        L_0x046c:
            r0 = move-exception
            r5 = r9
            r6 = r17
            goto L_0x0474
        L_0x0471:
            r0 = move-exception
            r6 = r8
            r5 = r9
        L_0x0474:
            r3 = 2
            r14 = 0
        L_0x0476:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "createAppsFlyerReferralLink: "
            r7 = 0
            r3[r7] = r4
            r4 = 1
            r3[r4] = r0
            com.mpl.androidapp.utils.MLogger.e(r12, r3)
            r8 = r14
        L_0x0484:
            java.lang.String r0 = "Referrer Code"
            r10.addParameter(r0, r11)
            java.lang.String r0 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppName()
            java.lang.String r3 = "Referral Source"
            r10.addParameter(r3, r0)
            java.lang.String r0 = "is_retargeting"
            r10.addParameter(r0, r2)
            java.lang.String r0 = "af_param_forwarding"
            java.lang.String r2 = "false"
            r10.addParameter(r0, r2)
            r2 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x04a9 }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x04a9 }
            java.lang.String r2 = r0.optString(r5)     // Catch:{ JSONException -> 0x04a9 }
            goto L_0x04ad
        L_0x04a9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x04ad:
            if (r8 == 0) goto L_0x04b6
            java.lang.String r0 = "af_dp"
            java.lang.String r1 = "gamekhelo://mplpro"
            r10.addParameter(r0, r1)
        L_0x04b6:
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            java.lang.String r1 = "af_web_dp"
            java.lang.String r3 = "referral.website.url"
            if (r0 == 0) goto L_0x04ea
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            java.lang.String r0 = r0.optString(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04ea
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x04ea
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r6)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r10.addParameter(r1, r0)
            goto L_0x051b
        L_0x04ea:
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            if (r0 == 0) goto L_0x051b
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            java.lang.String r0 = r0.optString(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x051b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            org.json.JSONObject r2 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            java.lang.String r2 = r2.optString(r3)
            r0.append(r2)
            r0.append(r6)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r10.addParameter(r1, r0)
        L_0x051b:
            com.mpl.androidapp.utils.CommonUtils$8 r0 = new com.mpl.androidapp.utils.CommonUtils$8
            r1 = r31
            r0.<init>()
            r1 = r27
            r10.generateLink(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.CommonUtils.createAppsFlyerTournamentBattleShareLink(android.content.Context, java.lang.String, java.lang.String, boolean, com.facebook.react.bridge.Promise, boolean):void");
    }

    public static void createAppsFlyerTournamentShareLink(Context context, String str, String str2, Promise promise) {
        createAppsFlyerTournamentBattleShareLink(context, str, str2, true, promise, false);
    }

    public static Bitmap createBitmapFromFile(Context context, File file) {
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), new Options());
        return VERSION.SDK_INT < 28 ? Bitmap.createScaledBitmap(decodeFile, getIconSize(context), getIconSize(context), true) : decodeFile;
    }

    public static JSONObject createDeepLinkPayload(String str, String str2, boolean z, boolean z2) {
        String str3;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (str2 != null) {
                str3 = z ? "TournamentDetails" : "LobbyDetails";
                jSONObject2.put("id", str2);
            } else if (z2) {
                JSONObject jSONObject3 = new JSONObject(str);
                int optInt = jSONObject3.optInt("Contest ID", 0);
                int optInt2 = jSONObject3.optInt("Match ID", 0);
                int optInt3 = jSONObject3.optInt("Sport ID", 0);
                String str4 = "SuperTeamHome";
                if (optInt != 0 && optInt2 != 0 && optInt3 != 0) {
                    str4 = "SuperTeamContestDetail";
                    jSONObject2.put("matchId", optInt2);
                    jSONObject2.put("contestId", optInt);
                    jSONObject2.put("sportId", optInt3);
                } else if (optInt3 != 0 && optInt2 != 0) {
                    str3 = "SuperTeamContests";
                    jSONObject2.put("matchId", optInt2);
                    jSONObject2.put("sportId", optInt3);
                } else if (optInt3 != 0) {
                    jSONObject2.put("sportId", optInt3);
                }
                str3 = str4;
            } else {
                str3 = "EarnTokens";
            }
            return createDeepLinkPayload("nav", str3, jSONObject2.toString());
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "createDeepLinkPayload: ", e2);
            return jSONObject;
        }
    }

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            for (String file2 : file.list()) {
                if (!new File(file, file2).delete()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void deleteToSDFile(Context context) {
        try {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "mpl");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, "config.json");
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "deleteToSDFile: ", e2);
        }
    }

    public static String deviceNameHeader() {
        try {
            return Base64.encodeToString((MBuildConfigUtils.getAPKHash() + MBuildConfigUtils.getAppType() + MBuildConfigUtils.getBuildFlavor()).getBytes(), 2);
        } catch (Exception unused) {
            return MBuildConfigUtils.getBuildFlavor();
        }
    }

    public static long downloadFile(Context context, String str, File file, String str2, String str3, IResponseListener<String> iResponseListener) {
        MLogger.d(TAG, "downloadFile: ");
        if (!(file == null || file.getParentFile() == null)) {
            MLogger.d(TAG, "downloadFile: ", str, file, Boolean.valueOf(file.exists()), Boolean.valueOf(file.getParentFile().exists()));
            final DownloadManager downloadManager = (DownloadManager) context.getSystemService(Constant.DOWNLOAD);
            Request request = new Request(Uri.parse(str));
            request.setNotificationVisibility(2).setTitle(str2).setDescription(str3).setDestinationUri(Uri.fromFile(file));
            if (downloadManager != null) {
                long enqueue = downloadManager.enqueue(request);
                final IResponseListener<String> iResponseListener2 = iResponseListener;
                final File file2 = file;
                AnonymousClass11 r2 = new FileObserver(file.getParent(), 4095) {
                    public void onEvent(int i, String str) {
                        MLogger.d(CommonUtils.TAG, "onEvent() called with: event = [" + i + "], file = [" + str + CMapParser.MARK_END_OF_ARRAY);
                        if (i == 2) {
                            MLogger.d(CommonUtils.TAG, "onEvent:MODIFY ", Integer.valueOf(i), str);
                            CommonUtils.checkProgressAndSendToReact(downloadManager, iResponseListener2, file2.getAbsolutePath());
                        } else if (i == 32) {
                            MLogger.d(CommonUtils.TAG, "onEvent:OPEN ", Integer.valueOf(i), str);
                        } else if (i == 64) {
                            MLogger.d(CommonUtils.TAG, "onEvent:MOVED_FROM ", Integer.valueOf(i), str);
                        } else if (i == 128) {
                            MLogger.d(CommonUtils.TAG, "MOVED_TO ", Integer.valueOf(i), str);
                        } else if (i == 256) {
                            MLogger.d(CommonUtils.TAG, "onEvent:CREATE ", Integer.valueOf(i), str);
                        } else if (i == 512) {
                            MLogger.d(CommonUtils.TAG, "onEvent:DELETE ", Integer.valueOf(i), str);
                        } else if (i == 1024) {
                            MLogger.d(CommonUtils.TAG, "onEvent:DELETE_SELF ", Integer.valueOf(i), str);
                        } else if (i != 2048) {
                            MLogger.d(CommonUtils.TAG, "onEvent:default ", Integer.valueOf(i), str);
                        } else {
                            MLogger.d(CommonUtils.TAG, "onEvent:MOVE_SELF ", Integer.valueOf(i), str);
                        }
                    }
                };
                mFileObserver = r2;
                MSharedPreferencesUtils.saveLongInNormalPref(context, Constant.CURRENTLY_DOWNLOADING_ID, enqueue);
                return enqueue;
            }
        }
        return 0;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static boolean extractZipFile(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            MLogger.d(TAG, "extractZipFile() called with: zipFile = [" + file + "], targetDirectory = [" + file2 + CMapParser.MARK_END_OF_ARRAY);
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        File file3 = new File(file2, nextEntry.getName());
                        File parentFile = nextEntry.isDirectory() ? file3 : file3.getParentFile();
                        if (!parentFile.isDirectory()) {
                            if (!parentFile.mkdirs()) {
                                throw new FileNotFoundException("Failed to ensure directory: " + parentFile.getAbsolutePath());
                            }
                        }
                        if (!nextEntry.isDirectory()) {
                            fileOutputStream = new FileOutputStream(file3);
                            while (true) {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.close();
                            if (file3.exists()) {
                                String fileNameWithoutExtension = FileUtils.getFileNameWithoutExtension(file3);
                                String fileExtension = FileUtils.getFileExtension(file3);
                                if ("config".equals(fileNameWithoutExtension) && "json".equalsIgnoreCase(fileExtension)) {
                                    String readFromJsonFile = readFromJsonFile(file3);
                                    MLogger.d(TAG, "gameConfig: ", readFromJsonFile);
                                    MSharedPreferencesUtils.putGameSponsorConfigJson(readFromJsonFile);
                                }
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return true;
                    }
                }
            } catch (Throwable th) {
                zipInputStream.close();
                throw th;
            }
            throw th;
        } catch (Exception unused) {
            return false;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public static ArrayList<ApkInfo> getAllThirdPartyGamesItems() {
        return sAllThirdPartyGamesItems;
    }

    public static String getApkSignedSignature(Context context, String str) {
        String str2 = "";
        try {
            for (Signature byteArray : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                MessageDigest instance = MessageDigest.getInstance("SHA");
                instance.update(byteArray.toByteArray());
                str2 = Base64.encodeToString(instance.digest(), 0).trim();
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "installedApkIntegrityCheck", e2);
        }
        return str2;
    }

    public static MHeader getApkTypeHeader() {
        return new MHeader(Constant.HEADER_APK_TYPE, MBuildConfigUtils.getApkType());
    }

    public static MHeader getAppTypeHeader() {
        return new MHeader(Constant.HEADER_APP_TYPE, MBuildConfigUtils.getAppType());
    }

    public static int getBadgeId(String str, boolean z) {
        String str2 = str;
        if (!z) {
            if (str2.equalsIgnoreCase("STEEL")) {
                return R.drawable.full_steel;
            }
            if (str2.equalsIgnoreCase("COPPER")) {
                return R.drawable.full_copper;
            }
            if (str2.equalsIgnoreCase("BRONZE")) {
                return R.drawable.full_bronze;
            }
            if (str2.equalsIgnoreCase("SILVER")) {
                return R.drawable.full_silver;
            }
            if (str2.equalsIgnoreCase("GOLD")) {
                return R.drawable.full_gold;
            }
            if (str2.equalsIgnoreCase("PLATINUM")) {
                return R.drawable.full_platinum;
            }
            if (str2.equalsIgnoreCase("PEARL")) {
                return R.drawable.full_pearl;
            }
            if (str2.equalsIgnoreCase("ONYX")) {
                return R.drawable.full_onyx;
            }
            if (str2.equalsIgnoreCase("JADE")) {
                return R.drawable.full_jade;
            }
            if (str2.equalsIgnoreCase("OPAL")) {
                return R.drawable.full_opal;
            }
            if (str2.equalsIgnoreCase("TOPAZ")) {
                return R.drawable.full_topaz;
            }
            if (str2.equalsIgnoreCase("SAPPHIRE")) {
                return R.drawable.full_sapphire;
            }
            if (str2.equalsIgnoreCase("EMERALD")) {
                return R.drawable.full_emerald;
            }
            if (str2.equalsIgnoreCase("RUBY")) {
                return R.drawable.full_ruby;
            }
            if (str2.equalsIgnoreCase("DIAMOND")) {
                return R.drawable.full_diamond;
            }
            return R.drawable.full_steel;
        } else if (str2.equalsIgnoreCase("STEEL")) {
            return R.drawable.badge_steel;
        } else {
            if (str2.equalsIgnoreCase("COPPER")) {
                return R.drawable.badge_copper;
            }
            if (str2.equalsIgnoreCase("BRONZE")) {
                return R.drawable.badge_bronze;
            }
            if (str2.equalsIgnoreCase("SILVER")) {
                return R.drawable.badge_silver;
            }
            if (str2.equalsIgnoreCase("GOLD")) {
                return R.drawable.badge_gold;
            }
            if (str2.equalsIgnoreCase("PLATINUM")) {
                return R.drawable.badge_platinum;
            }
            if (str2.equalsIgnoreCase("PEARL")) {
                return R.drawable.badge_pearl;
            }
            if (str2.equalsIgnoreCase("ONYX")) {
                return R.drawable.badge_onyx;
            }
            if (str2.equalsIgnoreCase("JADE")) {
                return R.drawable.badge_jade;
            }
            if (str2.equalsIgnoreCase("OPAL")) {
                return R.drawable.badge_opal;
            }
            if (str2.equalsIgnoreCase("TOPAZ")) {
                return R.drawable.badge_topaz;
            }
            if (str2.equalsIgnoreCase("SAPPHIRE")) {
                return R.drawable.badge_sapphire;
            }
            if (str2.equalsIgnoreCase("EMERALD")) {
                return R.drawable.badge_emerald;
            }
            if (str2.equalsIgnoreCase("RUBY")) {
                return R.drawable.badge_ruby;
            }
            if (str2.equalsIgnoreCase("DIAMOND")) {
                return R.drawable.badge_diamond;
            }
            return R.drawable.full_steel;
        }
    }

    public static MHeader getBuildTimeHeader() {
        return new MHeader("buildTime", String.valueOf(MBuildConfigUtils.getBuildTime()));
    }

    public static MHeader getBuildTypeHeader() {
        return new MHeader(Constant.HEADER_APP_BUILD_TYPE, String.valueOf(MBuildConfigUtils.isDebuggable()));
    }

    public static Bitmap getCircularBitmap(Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawOval(new RectF(new Rect(0, 0, min, min)), paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (float) ((min - bitmap.getWidth()) >> 1), (float) ((min - bitmap.getHeight()) >> 1), paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static List<MHeader> getCommonHeaders() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MHeader("User-Agent", String.format(Locale.ENGLISH, Constant.USER_AGENT_FORMAT, new Object[]{Integer.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()), Integer.valueOf(DBInteractor.getCurrentRNBundleVersionCode())})));
        arrayList.add(getAppTypeHeader());
        arrayList.add(getCountryHeader());
        arrayList.add(getCountryCodeHeader());
        arrayList.add(getFlavourHeader());
        arrayList.add(getBuildTypeHeader());
        arrayList.add(isLogEnabledHeader());
        arrayList.add(isDevelopmentEnabledHeader());
        arrayList.add(getVersionNameHeader());
        arrayList.add(getBuildTimeHeader());
        arrayList.add(getLanguageHeader());
        arrayList.add(getDeviceIdHeader());
        arrayList.add(getOsVersionCodeHeader());
        arrayList.add(getOsVersionHeader());
        arrayList.add(getDeviceMakeHeader());
        arrayList.add(getDeviceModelHeader());
        arrayList.add(getDeviceManufacturer());
        arrayList.add(getDeviceArchHeader());
        arrayList.add(getApkTypeHeader());
        arrayList.add(getDeviceIdConfigHeader());
        arrayList.add(getCountryHeaderNew());
        if (ConfigManager.getState() != null) {
            arrayList.add(getStateHeader());
        }
        return arrayList;
    }

    public static MHeader getCountryCodeHeader() {
        return new MHeader(Constant.HEADER_COUNTRY_CALLING_CODE, String.valueOf(CountryUtils.getCountryCallingCode()));
    }

    public static MHeader getCountryHeader() {
        return new MHeader("countryCode", MBuildConfigUtils.getCountryCode());
    }

    public static MHeader getCountryHeaderNew() {
        String countryCode = MBuildConfigUtils.getCountryCode();
        if (TextUtils.isEmpty(countryCode)) {
            countryCode = CountryUtils.getCountryCodeInNormalPrefNew();
        }
        MLogger.d(TAG, "getCountryHeaderNew: ", countryCode);
        return new MHeader(Constant.HEADER_COUNTRY_CODE_NEW, countryCode);
    }

    public static HashSet<String> getCtRemovedParams() {
        return ctRemovedParams;
    }

    public static String getCurrentScreenName() {
        return mCurrentScreenName;
    }

    public static String getDeviceArch() {
        try {
            return System.getProperty("os.arch");
        } catch (Exception unused) {
            return "";
        }
    }

    public static MHeader getDeviceArchHeader() {
        return new MHeader(Constant.HEADER_DEVICE_ARCH, getDeviceArch());
    }

    public static MHeader getDeviceIdConfigHeader() {
        String deviceIdForPreLogin = MSharedPreferencesUtils.getDeviceIdForPreLogin();
        if (TextUtils.isEmpty(deviceIdForPreLogin)) {
            deviceIdForPreLogin = MSharedPreferencesUtils.getDeviceId();
        }
        return new MHeader(Constant.HEADER_ANDROID_DEVICE_ID_NEW, deviceIdForPreLogin);
    }

    public static MHeader getDeviceIdHeader() {
        String stringPref = MSharedPreferencesUtils.getStringPref(Constant.DEVICE_ID, "", false);
        if (TextUtils.isEmpty(stringPref)) {
            stringPref = MSharedPreferencesUtils.getStringInNormalPref(MPLApplication.getInstance(), Constant.DEVICE_ID, "");
        }
        return new MHeader(Constant.HEADER_ANDROID_DEVICE_ID, stringPref);
    }

    public static MHeader getDeviceMakeHeader() {
        return new MHeader(Constant.HEADER_MOBILE_MAKE, Build.BRAND);
    }

    public static MHeader getDeviceManufacturer() {
        return new MHeader("manufacturer", Build.MANUFACTURER);
    }

    public static HashMap<String, Object> getDeviceMemoryInfo() {
        HashMap<String, Object> hashMap = new HashMap<>();
        ActivityManager activityManager = (ActivityManager) MPLApplication.getInstance().getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            hashMap.put(EventsConstants.PROP_PHONE_TOTAL_RAM, Long.valueOf(memoryInfo.totalMem / 1048576));
            hashMap.put(EventsConstants.PROP_PHONE_AVAILABLE_RAM, Long.valueOf(memoryInfo.availMem / 1048576));
            hashMap.put("Threshold RAM", Long.valueOf(memoryInfo.threshold / 1048576));
            hashMap.put("Is Low RAM", Boolean.valueOf(memoryInfo.lowMemory));
            try {
                hashMap.put("Total RAM GB", humanReadableByteCountBin(memoryInfo.totalMem));
                hashMap.put("Total RAM GB Double", Double.valueOf(humanReadableByteCountBinDouble(memoryInfo.totalMem)));
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public static MHeader getDeviceModelHeader() {
        return new MHeader("model", Build.MODEL);
    }

    public static MHeader getFlavourHeader() {
        return new MHeader(Constant.HEADER_APP_FLAVOR_NAME, MBuildConfigUtils.getBuildFlavor());
    }

    public static GameInfo getGameInfo(int i) {
        if (sGameInfoMap.get(Integer.valueOf(i)) != null) {
            return sGameInfoMap.get(Integer.valueOf(i));
        }
        return sGameInfoMap.get(Integer.valueOf(1));
    }

    public static String getGameNameForID(int i) {
        return getGameInfo(i).getName();
    }

    public static int getIconSize(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i == 120) {
            return 36;
        }
        if (i == 160) {
            return 48;
        }
        if (i == 240) {
            return 72;
        }
        if (i != 480) {
            return i != 640 ? 96 : 192;
        }
        return 144;
    }

    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e2) {
            MLogger.e(TAG, e2.getMessage());
        } catch (Exception e3) {
            MLogger.e(TAG, e3.getMessage());
        }
        return null;
    }

    public static MHeader getLanguageHeader() {
        return new MHeader("language", LocaleHelper.getSelectedLanguage());
    }

    public static HashMap<String, String> getLocationMap() {
        String str;
        JSONException jSONException;
        String str2;
        Exception exc;
        String str3 = EventsConstants.PROP_LOCATION_EMPTY;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(MSharedPreferencesUtils.getLocationProps(MPLApplication.getInstance()));
            String optString = jSONObject.optString("state", str3);
            try {
                str3 = jSONObject.optString("country", str3);
                hashMap.put("state", optString);
                hashMap.put("country", str3);
                hashMap.put("state", optString);
                hashMap.put("country", str3);
                return hashMap;
            } catch (JSONException e2) {
                JSONException jSONException2 = e2;
                str2 = str3;
                str3 = optString;
                jSONException = jSONException2;
                MLogger.e(TAG, jSONException.getMessage());
                hashMap.put("state", str3);
                hashMap.put("country", str);
                return hashMap;
            } catch (Exception e3) {
                Exception exc2 = e3;
                str = str3;
                str3 = optString;
                exc = exc2;
                MLogger.e(TAG, exc.getMessage());
                hashMap.put("state", str3);
                hashMap.put("country", str);
                return hashMap;
            } catch (Throwable th) {
                th = th;
                str = str3;
                str3 = optString;
                hashMap.put("state", str3);
                hashMap.put("country", str);
                throw th;
            }
        } catch (JSONException e4) {
            jSONException = e4;
            str2 = str3;
            MLogger.e(TAG, jSONException.getMessage());
            hashMap.put("state", str3);
            hashMap.put("country", str);
            return hashMap;
        } catch (Exception e5) {
            exc = e5;
            str = str3;
            MLogger.e(TAG, exc.getMessage());
            hashMap.put("state", str3);
            hashMap.put("country", str);
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
            hashMap.put("state", str3);
            hashMap.put("country", str);
            throw th;
        }
    }

    public static MHeader getOsVersionCodeHeader() {
        return new MHeader(Constant.HEADER_OS_VERSION_CODE, String.valueOf(VERSION.SDK_INT));
    }

    public static MHeader getOsVersionHeader() {
        return new MHeader("osVersion", VERSION.RELEASE);
    }

    public static int getPackageVersionCode(String str, Activity activity) {
        try {
            return activity.getPackageManager().getPackageInfo(str, 1).versionCode;
        } catch (NameNotFoundException unused) {
            return 0;
        }
    }

    public static double getRamRange(double d2) {
        PrintStream printStream = System.out;
        printStream.println("getRamRange: " + d2);
        if (d2 < 1.5d) {
            return 1.0d;
        }
        if (d2 > 1.5d && d2 <= 2.5d) {
            return 2.0d;
        }
        if (d2 > 2.5d && d2 <= 3.5d) {
            return 3.0d;
        }
        if (d2 > 3.5d && d2 <= 4.5d) {
            return 4.0d;
        }
        if (d2 > 4.5d && d2 <= 6.5d) {
            return 6.0d;
        }
        if (d2 > 6.5d) {
            d2 = 7.0d;
        }
        return d2;
    }

    public static void getRecommendedApp(Activity activity, Promise promise) {
        try {
            MLogger.d(TAG, "RecommendedApp: ");
            HashMap hashMap = new HashMap();
            hashMap.putAll(MSharedPreferencesUtils.getRecommendedAppsCheckList());
            StringBuilder sb = new StringBuilder();
            for (Entry entry : hashMap.entrySet()) {
                JSONObject jSONObject = new JSONObject((String) entry.getValue());
                if (jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (true) {
                        if (!keys.hasNext()) {
                            break;
                        }
                        if (Util.isAppInstalled(activity.getApplicationContext(), jSONObject.optString(keys.next()))) {
                            sb.append((String) entry.getKey());
                            sb.append(",");
                            break;
                        }
                    }
                }
            }
            if (sb.toString().equals("")) {
                promise.reject((String) "");
            } else {
                promise.resolve(String.valueOf(sb));
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "RecommendedApp");
            promise.reject((String) "");
        }
    }

    public static String getScreenSize(Context context) {
        int i = context.getResources().getConfiguration().screenLayout & 15;
        if (i == 1) {
            return "Small screen";
        }
        if (i != 2) {
            return i != 3 ? "Screen size is neither large, normal or small" : "Large screen";
        }
        return "Normal screen";
    }

    public static ServerGame getServerGame() {
        return mServerGame;
    }

    public static String getSimCarrierNames(Context context) {
        StringBuilder sb = new StringBuilder();
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
            sb.append(((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName());
        } else {
            List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
            try {
                int size = activeSubscriptionInfoList.size();
                int i = 0;
                while (i < size) {
                    sb.append(activeSubscriptionInfoList.get(i).getCarrierName().toString());
                    i++;
                    if (i != activeSubscriptionInfoList.size()) {
                        sb.append(",");
                    }
                }
            } catch (Exception unused) {
                MLogger.e(TAG, "No Sim is available in slot");
            }
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return EventsConstants.PROP_NETWORK_CARRIER_EMPTY;
        }
        return sb.toString();
    }

    public static MHeader getStateHeader() {
        return new MHeader("state", ConfigManager.getState());
    }

    public static String getStoryUrl(String str, String str2, String str3) {
        String str4 = "https://www.mpl.live/";
        if (ConfigManager.getNormalConfig() != null) {
            str4 = ConfigManager.getNormalConfig().optString("stories.redirect.url", str4);
        }
        Uri parse = Uri.parse(str4);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.appendPath("stories");
        if (!TextUtils.isEmpty(str3)) {
            builder.appendQueryParameter("tagid", str3);
        }
        String uri = builder.build().toString();
        try {
            MLogger.d(TAG, Constant.APPS_FLYER_TAG, "getStoryUrl : ", uri);
            uri = URLEncoder.encode(uri, "UTF-8");
            MLogger.d(TAG, Constant.APPS_FLYER_TAG, "getStoryUrl : ", URLEncoder.encode(uri, "UTF-8"));
            return uri;
        } catch (Exception e2) {
            MLogger.e(TAG, Constant.APPS_FLYER_TAG, "getStoryUrl: ", e2);
            return uri;
        }
    }

    public static ApkInfo getThirdPartyAppInfoBasedOnPackageName(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, ApkInfo> hashMap = sAllThirdPartyGamesItemHashMap;
            if (hashMap != null && hashMap.containsKey(str)) {
                return sAllThirdPartyGamesItemHashMap.get(str);
            }
        }
        return null;
    }

    public static int getTierRank(String str) {
        if (str == null) {
            return 0;
        }
        try {
            if (TextUtils.isEmpty(str) || !sTeirMap.containsKey(str)) {
                return 0;
            }
            return sTeirMap.get(str).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static MHeader getVersionNameHeader() {
        return new MHeader(Constant.HEADER_APP_VERSION_NAME, MBuildConfigUtils.getCurrentAppVersionName());
    }

    public static String humanReadableByteCountBin(long j) {
        long j2;
        String str = "";
        if (j == Long.MIN_VALUE) {
            j2 = Long.MAX_VALUE;
        } else {
            try {
                j2 = Math.abs(j);
            } catch (Exception unused) {
                return str;
            }
        }
        if (j2 < 1024) {
            str = j + " B";
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("KMGTPE");
        int i = 40;
        long j3 = j2;
        while (i >= 0 && j2 > (1152865209611504844 >> i)) {
            j3 >>= 10;
            stringCharacterIterator.next();
            i -= 10;
        }
        long signum = j3 * ((long) Long.signum(j));
        if ("G".equalsIgnoreCase(String.valueOf(stringCharacterIterator.current()))) {
            double ramRange = getRamRange(((double) signum) / 1024.0d);
            if (ramRange > 6.0d) {
                return String.format(Locale.ENGLISH, "%.1f above GB", new Object[]{Double.valueOf(ramRange - 1.0d)});
            }
            return String.format(Locale.ENGLISH, "%.1f GB", new Object[]{Double.valueOf(ramRange)});
        }
        return String.format(Locale.ENGLISH, "%.1f GB", new Object[]{Double.valueOf(((double) signum) / 1024.0d)});
    }

    public static double humanReadableByteCountBinDouble(long j) {
        long j2;
        if (j == Long.MIN_VALUE) {
            j2 = Long.MAX_VALUE;
        } else {
            try {
                j2 = Math.abs(j);
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        if (j2 < 1024) {
            double d2 = (double) j;
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("KMGTPE");
        int i = 40;
        long j3 = j2;
        while (i >= 0 && j2 > (1152865209611504844 >> i)) {
            j3 >>= 10;
            stringCharacterIterator.next();
            i -= 10;
        }
        return ((double) (j3 * ((long) Long.signum(j)))) / 1024.0d;
    }

    public static boolean isAppIsInBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z = true;
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            int i = 0;
            while (runningAppProcesses != null && i < runningAppProcesses.size()) {
                RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100) {
                    String[] strArr = runningAppProcessInfo.pkgList;
                    int i2 = 0;
                    while (strArr != null && i2 < strArr.length) {
                        if (context.getPackageName().equals(strArr[i2])) {
                            z = false;
                        }
                        i2++;
                    }
                }
                i++;
            }
        }
        return z;
    }

    public static boolean isAvailableRamSupportedForGameReplay(GameReplayConfigModel gameReplayConfigModel) {
        boolean z = false;
        try {
            ActivityManager activityManager = (ActivityManager) MPLApplication.getInstance().getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            if (activityManager == null) {
                return true;
            }
            activityManager.getMemoryInfo(memoryInfo);
            long j = memoryInfo.availMem / 1048576;
            String minAvailableRAM = gameReplayConfigModel.getMinAvailableRAM();
            MLogger.d(TAG, "isMinRamSupportedForGameReplay:gameReplay totalMemory ", Long.valueOf(j), "minAvailableRamFromServer: ", minAvailableRAM);
            if (j <= 0 || TextUtils.isEmpty(minAvailableRAM) || Long.parseLong(minAvailableRAM) <= 0) {
                return true;
            }
            if (Long.parseLong(minAvailableRAM) <= j) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            MLogger.e(TAG, "isMinRamSupportedForGameReplay:gameReplay ", e2);
            return true;
        }
    }

    public static boolean isComponentEnabled(Context context, ComponentName componentName) {
        MLogger.d(TAG, "isComponentEnabled: ", Integer.valueOf(context.getPackageManager().getComponentEnabledSetting(componentName)));
        if (context.getPackageManager().getComponentEnabledSetting(componentName) == 1 || context.getPackageManager().getComponentEnabledSetting(componentName) == 0) {
            return true;
        }
        return false;
    }

    public static MHeader isDevelopmentEnabledHeader() {
        return new MHeader(Constant.HEADER_APP_DEVELOPMENT_ENABLED, String.valueOf(MBuildConfigUtils.isDevelopmentModeEnabled()));
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        try {
            return obj.toString().trim().isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isExternalStorageWritable() {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            str = null;
        }
        return "mounted".equals(str);
    }

    public static boolean isInternalUser() {
        return isInternalUser;
    }

    public static boolean isInternalUserAPICallDone() {
        return isInternalUserAPICallDone;
    }

    public static boolean isJSONArrayValid(String str) {
        try {
            new JSONArray(str);
            return true;
        } catch (JSONException e2) {
            MLogger.printStackTrace(e2);
            return false;
        }
    }

    public static boolean isJSONValid(String str) {
        try {
            gson.fromJson(str, Object.class);
            return true;
        } catch (JsonSyntaxException unused) {
            return false;
        }
    }

    public static MHeader isLogEnabledHeader() {
        return new MHeader(Constant.HEADER_APP_LOG_ENABLED, String.valueOf(MBuildConfigUtils.isLogEnabled()));
    }

    public static boolean isMinRamSupportedForGameReplay(GameReplayConfigModel gameReplayConfigModel) {
        boolean z = false;
        try {
            ActivityManager activityManager = (ActivityManager) MPLApplication.getInstance().getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            if (activityManager == null) {
                return true;
            }
            activityManager.getMemoryInfo(memoryInfo);
            long j = memoryInfo.totalMem / 1048576;
            String minTotalRAM = gameReplayConfigModel.getMinTotalRAM();
            MLogger.d(TAG, "isMinRamSupportedForGameReplay:gameReplay totalMemory ", Long.valueOf(j), "ramFromServer: ", minTotalRAM);
            if (j <= 0 || TextUtils.isEmpty(minTotalRAM) || Long.parseLong(minTotalRAM) <= 0) {
                return true;
            }
            if (Long.parseLong(minTotalRAM) <= j) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            MLogger.e(TAG, "isMinRamSupportedForGameReplay:gameReplay ", e2);
            return true;
        }
    }

    public static boolean isRummyGameId(int i) {
        return i == 1000188 || i == 1000189 || i == 1000190;
    }

    public static JSONObject mergeJSON(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject[] jSONObjectArr = {jSONObject, jSONObject2};
            for (int i = 0; i < 2; i++) {
                JSONObject jSONObject4 = jSONObjectArr[i];
                Iterator<String> keys = jSONObject4.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject3.put(next, jSONObject4.opt(next));
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "mergeJSON: ", e2);
        }
        return jSONObject3;
    }

    public static void needToRemoveEventProps() {
        ctRemovedParams.add("4Rk/wT3cl5SUOD+");
        ctRemovedParams.add("Active Players");
        ctRemovedParams.add(AFInAppEventParameterName.CONTENT_TYPE);
        ctRemovedParams.add(AFInAppEventParameterName.DESCRIPTION);
        ctRemovedParams.add("Apk Typw(h7dQvQ¡MښxN鏍fime Spent");
        ctRemovedParams.add("App La¥nch TS");
        ctRemovedParams.add(EventsConstants.APP_VERSION_CODE_GRADLE);
        ctRemovedParams.add(EventsConstants.APP_VERSION_NAME_GRADLE);
        ctRemovedParams.add("Apply Bonus Limit");
        ctRemovedParams.add("aS ersion");
        ctRemovedParams.add("Available From");
        ctRemovedParams.add("Block Duration");
        ctRemovedParams.add("Blocked Warning Shown");
        ctRemovedParams.add("Bonus Cash Cap");
        ctRemovedParams.add("Bo਽㹗਽㹗Cash Cap");
        ctRemovedParams.add("Challenge Enabled");
        ctRemovedParams.add("Challenge ID");
        ctRemovedParams.add("CPL ID");
        ctRemovedParams.add("CPL Name");
        ctRemovedParams.add("ct");
        ctRemovedParams.add("CT Latitude");
        ctRemovedParams.add("CT Longitude");
        ctRemovedParams.add("CT Session Id");
        ctRemovedParams.add("CT Source");
        ctRemovedParams.add("Current Score");
        ctRemovedParams.add("Deck Count");
        ctRemovedParams.add("Devace ID");
        ctRemovedParams.add("Devi?rchitecture");
        ctRemovedParams.add("Device Architucture");
        ctRemovedParams.add("End Date Name");
        ctRemovedParams.add("End Time");
        ctRemovedParams.add("End Time Name");
        ctRemovedParams.add("En롒㺞롒㺞Currency");
        ctRemovedParams.add("fb_content_type");
        ctRemovedParams.add("fb_description");
        ctRemovedParams.add("Featured");
        ctRemovedParams.add("Flow");
        ctRemovedParams.add("Foreshadow Time");
        ctRemovedParams.add("Full Count Value");
        ctRemovedParams.add("Has Enough Balance");
        ctRemovedParams.add("Icon Status");
        ctRemovedParams.add("Is Challenge");
        ctRemovedParams.add(EventsConstants.IS_EMULATOR);
        ctRemovedParams.add("Is Expanded Header");
        ctRemovedParams.add("Is Guaranteed");
        ctRemovedParams.add("Is i?pp");
        ctRemovedParams.add("Is OSzApp");
        ctRemovedParams.add("Is Phone Roote");
        ctRemovedParams.add("Is Phone Roote2");
        ctRemovedParams.add("Is Replay Enabled");
        ctRemovedParams.add("is_ticket_enabled_lobby");
        ctRemovedParams.add("is_vip_ticket_available");
        ctRemovedParams.add(GameConstant.IS_KAFKA_ENABLED);
        ctRemovedParams.add("Last Logged ?pp");
        ctRemovedParams.add("Locked lobby");
        ctRemovedParams.add("Max Cash Prize");
        ctRemovedParams.add(CtNativeLaunchInitiated.PROPERTY_MAX_PLAYERS);
        ctRemovedParams.add("Max Token Prize");
        ctRemovedParams.add("Message");
        ctRemovedParams.add("Middle Drop Value");
        ctRemovedParams.add("Min Cash Prize");
        ctRemovedParams.add("Min Players");
        ctRemovedParams.add("Min Token Prize");
        ctRemovedParams.add("ML Price");
        ctRemovedParams.add("MPL CleverTapId");
        ctRemovedParams.add("MPL Pro User CTId");
        ctRemovedParams.add("MPL_CT_ID");
        ctRemovedParams.add("New Game Start Time");
        ctRemovedParams.add("No of non playing players");
        ctRemovedParams.add("null");
        ctRemovedParams.add("Offence Details");
        ctRemovedParams.add("Original CleverTapId");
        ctRemovedParams.add("Originals Game CTId");
        ctRemovedParams.add("Originals Game Name");
        ctRemovedParams.add("Originals GameId");
        ctRemovedParams.add("Player Number");
        ctRemovedParams.add("Prize Currency");
        ctRemovedParams.add("ps");
        ctRemovedParams.add("RE Counter");
        ctRemovedParams.add("RE Farst Launch");
        ctRemovedParams.add("RE Tima Difference");
        ctRemovedParams.add("RE Time Takef");
        ctRemovedParams.add("Receiver ID");
        ctRemovedParams.add("Recurrence End Time");
        ctRemovedParams.add("Recurrence Start Time");
        ctRemovedParams.add("Registration Hard Stop");
        ctRemovedParams.add("Rewards Config Name");
        ctRemovedParams.add("Round ID");
        ctRemovedParams.add("Saved Score");
        ctRemovedParams.add(EventsConstants.PROP_PHONE_SCREEN_DENSITY);
        ctRemovedParams.add("Sender ID");
        ctRemovedParams.add("Sending Event Form`tted Time");
        ctRemovedParams.add(EventsConstants.PROP_SENDING_FORMATTED_EVENT_TIME_STAMP);
        ctRemovedParams.add(EventsConstants.PROP_SENDING_EVENT_TIME_STAMP);
        ctRemovedParams.add("Session Count");
        ctRemovedParams.add("Single Entry");
        ctRemovedParams.add("Snackbar Name");
        ctRemovedParams.add("SSO Button Available");
        ctRemovedParams.add("Start Date");
        ctRemovedParams.add("Start Date Name");
        ctRemovedParams.add("Start Time");
        ctRemovedParams.add("Start Time Name");
        ctRemovedParams.add("style");
        ctRemovedParams.add("t");
        ctRemovedParams.add("Table Name");
        ctRemovedParams.add("Target Screen");
        ctRemovedParams.add("Tile Spent");
        ctRemovedParams.add("Time Gap");
        ctRemovedParams.add("Title");
        ctRemovedParams.add("Token Entry Fee");
        ctRemovedParams.add("Token Prize Offere");
        ctRemovedParams.add("Token Prize Offered");
        ctRemovedParams.add("Total RAM GB Double");
        ctRemovedParams.add("Total Reconnection Attempts񀏉ᤨ덁meꏉῨ뮕Disconnected Due To Hacking𠏉Ῠ뮕Opponent Al");
        ctRemovedParams.add("Total Reconnection Time");
        ctRemovedParams.add("Tournament App Types");
        ctRemovedParams.add(CtNativeLaunchInitiated.PROPERTY_TOURNAMENT_DESCRIPTION);
        ctRemovedParams.add("Tournament Engine Version");
        ctRemovedParams.add("Unique Eve*t Id");
        ctRemovedParams.add("Unique Event I");
        ctRemovedParams.add("Unique Event I2");
        ctRemovedParams.add(EventsConstants.UPDATER_VERSION);
        ctRemovedParams.add(CtNativeLaunchInitiated.PROPERTY_VARIANT);
        ctRemovedParams.add("Winners End Rank");
        ctRemovedParams.add("�OS]Version\"");
    }

    public static void openEmailApps(Activity activity, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("mailto:"));
            PackageManager packageManager = activity.getPackageManager();
            if (!TextUtils.isEmpty(str) && isJSONValid(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("subject")) {
                    intent.putExtra("android.intent.extra.SUBJECT", jSONObject.optString("subject", ""));
                }
                if (jSONObject.has("message")) {
                    intent.putExtra("android.intent.extra.TEXT", jSONObject.optString("message", ""));
                }
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 0) {
                Intent createChooser = Intent.createChooser(packageManager.getLaunchIntentForPackage(queryIntentActivities.get(0).activityInfo.packageName), "Select Email");
                ArrayList arrayList = new ArrayList();
                for (int i = 1; i < queryIntentActivities.size(); i++) {
                    ResolveInfo resolveInfo = queryIntentActivities.get(i);
                    String str2 = resolveInfo.activityInfo.packageName;
                    arrayList.add(new LabeledIntent(packageManager.getLaunchIntentForPackage(str2), str2, resolveInfo.loadLabel(packageManager), resolveInfo.icon));
                }
                createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[]) arrayList.toArray(new LabeledIntent[0]));
                activity.startActivity(createChooser);
            }
        } catch (Exception unused) {
        }
    }

    public static void processAfterLoginJobs(Context context) {
        try {
            MLogger.d(TAG, "userLoggedIn() called [START]");
            MSharedPreferencesUtils.setMoneyInBranchEventPushed(false);
            MSharedPreferencesUtils.setMoneyOutBranchEventPushed(false);
            MSharedPreferencesUtils.setGamePlayedBranchEventPushed(false);
            MSharedPreferencesUtils.setGamePlayedBranchEventPushedV2(false);
            MSharedPreferencesUtils.setUserLoggedIn(true);
            if (context != null) {
                VideoRecordingUtils.setInitiallyUserPlayedGame(context);
            }
            if (!(context == null || context.getApplicationContext() == null)) {
                if (MSharedPreferencesUtils.getUserIdInNormalPref(context.getApplicationContext()) == 0) {
                    MSharedPreferencesUtils.moveUserIdInNormalPref(context.getApplicationContext());
                }
                if (TextUtils.isEmpty(MSharedPreferencesUtils.getMobileNumberInNormalPref(context.getApplicationContext()))) {
                    MSharedPreferencesUtils.moveMobileNumberInNormalPref(context.getApplicationContext());
                }
            }
            MSharedPreferencesUtils.setUserCurrentTier();
            MSharedPreferencesUtils.setIsNewUserValue(context);
            MLogger.d(TAG, "userLoggedIn() called [END]");
        } catch (Exception unused) {
        }
    }

    public static String readFromJsonFile(File file) {
        FileInputStream fileInputStream;
        String str = null;
        try {
            fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            str = Charset.defaultCharset().decode(channel.map(MapMode.READ_ONLY, 0, channel.size())).toString();
            fileInputStream.close();
        } catch (IOException e2) {
            MLogger.e(TAG, "", e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        return str;
        throw th;
    }

    public static void restartApp(final Context context) {
        MLogger.e(TAG, "Restarting application");
        new Handler(new Callback() {
            public boolean handleMessage(Message message) {
                Intent intent = new Intent(context, MPLReactContainerActivity.class);
                long currentTimeMillis = System.currentTimeMillis();
                PendingIntent activity = PendingIntent.getActivity(context, 123456, intent, ClientDefaults.MAX_MSG_SIZE);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                if (alarmManager != null) {
                    alarmManager.setExact(1, currentTimeMillis + 20, activity);
                }
                System.exit(0);
                return false;
            }
        }).sendEmptyMessageDelayed(0, 2000);
    }

    public static void restartAppWithIntentExtra(Context context, Bundle bundle) {
        MLogger.d(TAG, "restartAppWithIntentExtra: ");
        Intent intent = new Intent(context, MPLReactContainerActivity.class);
        intent.putExtras(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        PendingIntent activity = PendingIntent.getActivity(context, 142345, intent, ClientDefaults.MAX_MSG_SIZE);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            alarmManager.setExact(1, currentTimeMillis + TQConstants.COUNTDOWN_DURATION, activity);
        }
        System.exit(0);
    }

    public static void restartMPL(Context context) {
        MLogger.d(TAG, "restartMPL: ");
        ProcessPhoenix.triggerRebirth(context);
    }

    public static void restartMPLActivity(Activity activity, Class<?> cls) {
        MLogger.d(TAG, "restartMPLActivity: ");
        ProcessPhoenix.triggerRebirth(activity, new Intent(activity, cls));
    }

    public static void saveCurrentScreenName(String str) {
        mCurrentScreenName = str;
    }

    public static void saveFireBaseTokenToServer(String str) {
        if (!MSharedPreferencesUtils.getGuestUserLogin()) {
            try {
                String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
                if (!TextUtils.isEmpty(accessUserToken)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
                    arrayList.add(new MHeader("Authorization", "Bearer " + accessUserToken));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("mobileNumber", CountryUtils.getUniqueIdForThirdPartySDKs());
                    jSONObject.put("oneSignalId", MSharedPreferencesUtils.getOneSignalId());
                    jSONObject.put("oneSignalToken", str);
                    NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
                    NetworkUtils.doPostRequest(builder.setUrl(MBuildConfigUtils.getMainUrl() + ApiEndPoints.OSID_CALL).setMRequestBody(jSONObject.toString()).setMHeaders(arrayList).build(), new IResponseListener<String>() {
                        public void onResponseFail(Exception exc) {
                            MLogger.e(IResponseListener.TAG, "onResponseFail: ", exc);
                        }

                        public void progressResponse(long j, long j2, boolean z) {
                        }

                        public void onResponseSuccess(String str) {
                            MLogger.d(IResponseListener.TAG, "onResponseSuccess: ", str);
                        }
                    }, "osid_update");
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        com.mpl.androidapp.utils.MLogger.d(TAG, "saveHomeConfigResponse: ");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x008a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveHomeConfigResponse(java.lang.String r8) {
        /*
            java.lang.String r0 = "code"
            java.lang.String r1 = "games"
            java.lang.String r2 = "assets"
            java.lang.String r3 = "status"
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r6 = "saveHomeConfigResponse"
            r7 = 0
            r5[r7] = r6
            java.lang.String r6 = "CommonUtils"
            com.mpl.androidapp.utils.MLogger.d(r6, r5)
            if (r8 == 0) goto L_0x00c7
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00be }
            if (r5 != 0) goto L_0x00c7
            boolean r5 = isJSONValid(r8)     // Catch:{ Exception -> 0x00be }
            if (r5 == 0) goto L_0x00c7
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x00be }
            r5.<init>(r8)     // Catch:{ Exception -> 0x00be }
            boolean r8 = r5.has(r3)     // Catch:{ Exception -> 0x00be }
            if (r8 == 0) goto L_0x00c7
            org.json.JSONObject r8 = r5.optJSONObject(r3)     // Catch:{ Exception -> 0x00be }
            if (r8 == 0) goto L_0x00c7
            org.json.JSONObject r8 = r5.optJSONObject(r3)     // Catch:{ Exception -> 0x00be }
            boolean r8 = r8.has(r0)     // Catch:{ Exception -> 0x00be }
            if (r8 == 0) goto L_0x00c7
            org.json.JSONObject r8 = r5.optJSONObject(r3)     // Catch:{ Exception -> 0x00be }
            int r8 = r8.optInt(r0)     // Catch:{ Exception -> 0x00be }
            r0 = 200(0xc8, float:2.8E-43)
            if (r8 != r0) goto L_0x00c7
            java.lang.String r8 = "payload"
            org.json.JSONObject r8 = r5.optJSONObject(r8)     // Catch:{ Exception -> 0x00be }
            if (r8 == 0) goto L_0x0093
            boolean r0 = r8.has(r1)     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x0093
            org.json.JSONArray r0 = r8.optJSONArray(r1)     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x0093
            java.lang.String r0 = "processed"
            r8.put(r0, r4)     // Catch:{ Exception -> 0x008a }
            java.lang.String r0 = "allGames"
            org.json.JSONArray r1 = r8.optJSONArray(r1)     // Catch:{ Exception -> 0x008a }
            r8.put(r0, r1)     // Catch:{ Exception -> 0x008a }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x008a }
            r0.<init>()     // Catch:{ Exception -> 0x008a }
            java.lang.String r1 = r8.toString()     // Catch:{ Exception -> 0x008a }
            java.lang.Class<com.mpl.androidapp.game.ServerGame> r3 = com.mpl.androidapp.game.ServerGame.class
            java.lang.Object r0 = r0.fromJson(r1, r3)     // Catch:{ Exception -> 0x008a }
            com.mpl.androidapp.game.ServerGame r0 = (com.mpl.androidapp.game.ServerGame) r0     // Catch:{ Exception -> 0x008a }
            mServerGame = r0     // Catch:{ Exception -> 0x008a }
            setGameMappingBasedOnGameId()     // Catch:{ Exception -> 0x008a }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x008a }
            com.mpl.androidapp.utils.MSharedPreferencesUtils.setHomeDataAndroid(r0)     // Catch:{ Exception -> 0x008a }
            goto L_0x0093
        L_0x008a:
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = "saveHomeConfigResponse: "
            r0[r7] = r1     // Catch:{ Exception -> 0x00be }
            com.mpl.androidapp.utils.MLogger.d(r6, r0)     // Catch:{ Exception -> 0x00be }
        L_0x0093:
            if (r8 == 0) goto L_0x00c7
            boolean r0 = r8.has(r2)     // Catch:{ Exception -> 0x00be }
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = ""
            java.lang.String r0 = r8.optString(r2, r0)     // Catch:{ Exception -> 0x00be }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00be }
            if (r0 != 0) goto L_0x00c7
            java.lang.String r0 = r8.optString(r2)     // Catch:{ Exception -> 0x00be }
            boolean r0 = isJSONValid(r0)     // Catch:{ Exception -> 0x00be }
            if (r0 == 0) goto L_0x00c7
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00be }
            java.lang.String r8 = r8.optString(r2)     // Catch:{ Exception -> 0x00be }
            r0.<init>(r8)     // Catch:{ Exception -> 0x00be }
            com.mpl.androidapp.utils.AssetsUtils.setAssetsJson(r0)     // Catch:{ Exception -> 0x00be }
            goto L_0x00c7
        L_0x00be:
            java.lang.Object[] r8 = new java.lang.Object[r4]
            java.lang.String r0 = "Error in parsing games"
            r8[r7] = r0
            com.mpl.androidapp.utils.MLogger.e(r6, r8)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.CommonUtils.saveHomeConfigResponse(java.lang.String):void");
    }

    public static void sendInstallStatusNotification(ReactContext reactContext, String str, int i) {
        try {
            MLogger.d(GameLaunchHelper.TAG, "sendInstallStatusNotification: ", str);
            if (!TextUtils.isEmpty(str) && "Install Succeeded!".equalsIgnoreCase(str)) {
                AllGame gameInfo = getGameInfo(Integer.valueOf(i));
                if (gameInfo != null && gameInfo.getGameConfigGameInfo() != null && gameInfo.getGameConfigGameInfo().getApkInfo() != null && !TextUtils.isEmpty(gameInfo.getGameConfigGameInfo().getApkInfo().getPackageName())) {
                    ApkDownloadNotificationData apkDownloadNotificationData = new ApkDownloadNotificationData();
                    apkDownloadNotificationData.setContext(reactContext);
                    apkDownloadNotificationData.setPercentage(100);
                    apkDownloadNotificationData.setGameIconUrl("");
                    apkDownloadNotificationData.setGameName(gameInfo.getName());
                    apkDownloadNotificationData.setPackageName(gameInfo.getGameConfigGameInfo().getApkInfo().getPackageName());
                    apkDownloadNotificationData.setGameId(i);
                    apkDownloadNotificationData.setDownloaded(true);
                    apkDownloadNotificationData.setServerVersion(gameInfo.getGameConfigGameInfo().getApkInfo().getGameVersion() != null ? String.valueOf(gameInfo.getGameConfigGameInfo().getApkInfo().getGameVersion()) : "0");
                    apkDownloadNotificationData.setForceUpdate(gameInfo.getGameConfigGameInfo().getApkInfo().getForceUpdate());
                    new NotificationBuilder(reactContext).createApkDownloadIntent(apkDownloadNotificationData, reactContext.getCurrentActivity(), 100);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void sendInstallStatusToReact(ReactContext reactContext, String str, int i) {
        try {
            MLogger.d(GameLaunchHelper.TAG, "sendInstallStatusToReact: ", str);
            AllGame gameInfo = getGameInfo(Integer.valueOf(i));
            if (!(gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null)) {
                boolean isShowInstallToast = gameInfo.getGameConfigGameInfo().getApkInfo().isShowInstallToast();
                MLogger.d(TAG, "sendInstallStatusToReact: ", Boolean.valueOf(isShowInstallToast));
                if (!isShowInstallToast) {
                    return;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Game ID", i);
            jSONObject.put("Status", str);
            ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("third_party_apk_status", jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public static void sendShareAppEvent(String str, String str2) {
        HashMap outline88 = GeneratedOutlineSupport.outline88("Entry Point", "Screen Share button", ShareEventShareInitiated.PROPERTY_SHARE_CHANNEL, str2);
        outline88.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, str);
        outline88.put(ShareEventShareInitiated.PROPERTY_SHARE_SKIP_SCREEN, Boolean.TRUE);
        CleverTapAnalyticsUtils.sendEvent((String) "Share Initiated", outline88);
    }

    public static void setAppInviteOneLink(boolean z) {
        boolean z2 = ConfigManager.getPlatformConfig() != null && ConfigManager.getPlatformConfig().optBoolean("referral.redirect.pro.enabled", false);
        if (!z2) {
            z2 = HanselConfigs.getBoolean("referral_redirect_pro_enabled", false);
        }
        String str = (MBuildConfigUtils.isCashApp() || z2) ? "eMpV" : "r43o";
        if (!TextUtils.isEmpty(MBuildConfigUtils.getBuildFlavor()) && MBuildConfigUtils.getBuildFlavor().contains(BaseConstants.DEVELOPMENT)) {
            str = (MBuildConfigUtils.isCashApp() || z2) ? "CPCz" : "nRJb";
        }
        MLogger.d(TAG, "setAppInviteOneLink: ", str);
        AppsFlyerLib.getInstance().setAppInviteOneLink(str);
    }

    public static void setGameMappingBasedOnGameId() {
        ServerGame serverGame = mServerGame;
        if (serverGame != null && serverGame.getAllGames().size() > 0) {
            sAllGamesItemHashMap = new HashMap<>();
            sAllThirdPartyGamesItemHashMap = new HashMap<>();
            sAllThirdPartyGamesItems = new ArrayList<>();
            List<AllGame> allGames = mServerGame.getAllGames();
            Gson gson2 = new Gson();
            for (int i = 0; i < allGames.size(); i++) {
                AllGame allGame = allGames.get(i);
                if (!TextUtils.isEmpty(allGame.getGameInfo())) {
                    GameConfigGameInfo gameConfigGameInfo = (GameConfigGameInfo) gson2.fromJson(allGame.getGameInfo(), GameConfigGameInfo.class);
                    allGame.setGameConfigGameInfo(gameConfigGameInfo);
                    if (gameConfigGameInfo.getApkInfo() != null && gameConfigGameInfo.getApkInfo().isThirdParty()) {
                        ApkInfo apkInfo = gameConfigGameInfo.getApkInfo();
                        apkInfo.setGameName(allGame.getName());
                        apkInfo.setGameId(allGame.getId());
                        sAllThirdPartyGamesItemHashMap.put(apkInfo.getPackageName(), apkInfo);
                        sAllThirdPartyGamesItems.add(apkInfo);
                    }
                }
                if (!allGame.getTournamentSupported().booleanValue() || !allGame.getBattleSupported().booleanValue()) {
                    sAllGamesItemHashMap.put(allGame.getId(), allGame);
                } else {
                    sAllGamesItemHashMap.put(allGame.getId(), allGame);
                    sAllGamesItemHashMap.put(Integer.valueOf(allGame.getId().intValue() + 1000000), allGame);
                }
            }
        }
    }

    public static void setGames() {
        String homeDataAndroid = MSharedPreferencesUtils.getHomeDataAndroid();
        if (!TextUtils.isEmpty(homeDataAndroid)) {
            mServerGame = (ServerGame) new Gson().fromJson(homeDataAndroid, ServerGame.class);
            setGameMappingBasedOnGameId();
        }
    }

    public static void setInternalUser(boolean z) {
        isInternalUser = z;
    }

    public static void setInternalUserAPICallDone(boolean z) {
        isInternalUserAPICallDone = z;
    }

    public static void shareAllPossibleOptions(Activity activity, String str, Intent intent) {
        activity.startActivity(Intent.createChooser(intent, "Share Image"));
        sendShareAppEvent(str, "default");
    }

    public static void shareThroughSms(Activity activity, String str, Promise promise) {
        try {
            MLogger.d(TAG, "shareThroughSms: ");
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(str) && isJSONValid(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("message")) {
                    intent.putExtra("sms_body", jSONObject.optString("message", ""));
                }
                intent.setType("vnd.android-dir/mms-sms");
                intent.setData(Uri.parse("sms:"));
                activity.startActivity(intent);
                promise.resolve("success");
            }
            activity.startActivity(intent);
        } catch (Exception e2) {
            promise.reject(e2.getMessage());
        }
    }

    public static void shareViaEmailApp(Activity activity, String str, Intent intent) {
        MLogger.d(TAG, "shareViaEmailApp: ");
        if (Util.isEmailPresent(activity.getApplicationContext())) {
            try {
                intent.setPackage(SocialPkgName.EMAIL_PACKAGE_NAME);
                activity.startActivity(intent);
                sendShareAppEvent(str, EventsConstants.USER_EMAIL_CLEVER_TAP);
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error/n");
                outline73.append(e2.toString());
                MLogger.e(TAG, outline73.toString());
            }
        } else {
            shareAllPossibleOptions(activity, str, intent);
        }
    }

    public static void shareViaSmsApp(Activity activity, String str, Intent intent) {
        MLogger.d(TAG, "shareViaSmsApp: ");
        try {
            intent.setPackage(Sms.getDefaultSmsPackage(activity.getApplicationContext()));
            activity.startActivity(intent);
            sendShareAppEvent(str, "Sms");
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error/n");
            outline73.append(e2.toString());
            MLogger.e(TAG, outline73.toString());
        }
    }

    public static void shareViaTelegramApp(Activity activity, String str, Intent intent) {
        MLogger.d(TAG, "shareViaTelegramApp: ");
        if (Util.isTelegramPresent(activity.getApplicationContext())) {
            try {
                intent.setPackage(SocialPkgName.TELEGRAM_PACKAGE_NAME);
                activity.startActivity(intent);
                sendShareAppEvent(str, InternalShare.SHARE_MODE_TELEGRAM);
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error/n");
                outline73.append(e2.toString());
                MLogger.e(TAG, outline73.toString());
            }
        } else {
            shareAllPossibleOptions(activity, str, intent);
        }
    }

    public static void shareViaWhatsApp(Activity activity, String str, Intent intent) {
        MLogger.d(TAG, "shareViaWhatsApp: ");
        if (Util.isWhatsappPresent(activity.getApplicationContext())) {
            try {
                intent.setPackage(SocialPkgName.WHATSAPP_PACKAGE_NAME);
                activity.startActivity(intent);
                sendShareAppEvent(str, InternalShare.SHARE_MODE_WHATSAPP);
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error/n");
                outline73.append(e2.toString());
                MLogger.e(TAG, outline73.toString());
            }
        } else {
            shareAllPossibleOptions(activity, str, intent);
        }
    }

    public static void showScreenshotImage(FragmentActivity fragmentActivity, String str, String str2, String str3, boolean z, String str4, boolean z2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                MLogger.d(TAG, "path is empty " + TextUtils.isEmpty(str));
            }
            if (z2) {
                MLogger.d(TAG, GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, Boolean.valueOf(ConfigManager.getPlatformConfig().optBoolean(GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, false)));
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setAction("android.intent.action.SEND");
                ShareFile shareFile = new ShareFile(Uri.fromFile(new File(str)).toString(), fragmentActivity.getApplicationContext());
                if (shareFile.isFile()) {
                    Uri uri = shareFile.getURI();
                    intent.setType(shareFile.getType());
                    intent.putExtra("android.intent.extra.STREAM", uri);
                    intent.putExtra("android.intent.extra.TEXT", str2);
                    intent.addFlags(1);
                } else {
                    intent.putExtra("android.intent.extra.TEXT", str2 + CMap.SPACE + str);
                }
                if (str4.equalsIgnoreCase(InternalShare.SHARE_MODE_WHATSAPP)) {
                    shareViaWhatsApp(fragmentActivity, str3, intent);
                } else if (str4.equalsIgnoreCase(InternalShare.SHARE_MODE_TELEGRAM)) {
                    shareViaTelegramApp(fragmentActivity, str3, intent);
                } else if (str4.equalsIgnoreCase(EventsConstants.USER_EMAIL_CLEVER_TAP)) {
                    shareViaEmailApp(fragmentActivity, str3, intent);
                } else if (str4.equalsIgnoreCase(SharePlatform.SMS)) {
                    shareViaSmsApp(fragmentActivity, str3, intent);
                } else {
                    shareAllPossibleOptions(fragmentActivity, str3, intent);
                }
            } else {
                MLogger.d(TAG, "sharescreen.ui.disabled false", Boolean.valueOf(ConfigManager.getPlatformConfig().optBoolean(GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, false)));
                HashMap hashMap = new HashMap();
                hashMap.put("Pop Up Title", "Screenshare button");
                hashMap.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, str3);
                CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.POP_UP_SHOWN, hashMap);
                ScreenshotShareReferral.newInstance(str, str2, str3, z).show(fragmentActivity.getSupportFragmentManager(), (String) "screenshot referral dialogue");
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showScreenshotImage: ", e2);
        }
    }

    public static void showToast(final Activity activity, final boolean z, final Object... objArr) {
        if (activity != null && MBuildConfigUtils.isDebuggable()) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        StringBuilder sb = new StringBuilder();
                        for (Object append : objArr) {
                            sb.append(append);
                            sb.append(CMap.SPACE);
                        }
                        Toast.makeText(activity, sb.toString(), 0).show();
                        return;
                    }
                    MLogger.t(activity, 0, objArr);
                }
            });
        }
    }

    public static JSONObject takeReferralScreenshot(Activity activity) throws IOException, JSONException {
        MLogger.d(TAG, "takeReferralScreenshot:1 ");
        return takeReferralScreenshot(activity, activity.getWindow().getDecorView().getRootView());
    }

    public static JSONObject takeScreenshot(Activity activity, String str) throws IOException, JSONException {
        MLogger.d(TAG, "takeScreenshot: ");
        Date date = new Date();
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", date);
        File appExternalScreenShotStoragePath = FileUtils.getAppExternalScreenShotStoragePath(activity);
        File file = new File(appExternalScreenShotStoragePath, "MPL_" + date + ".jpg");
        View rootView = activity.getWindow().getDecorView().getRootView();
        rootView.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        createBitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        fileOutputStream.flush();
        fileOutputStream.close();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imgPath", file.getAbsolutePath());
        jSONObject.put("imgBase64", "data:image/png;base64," + encodeToString);
        return jSONObject;
    }

    public static AllGame getGameInfo(Integer num) {
        MLogger.d(TAG, "getGameInfo: ", num);
        HashMap<Integer, AllGame> hashMap = sAllGamesItemHashMap;
        if (hashMap != null) {
            if (hashMap.containsKey(num)) {
                return sAllGamesItemHashMap.get(num);
            }
            if (sAllGamesItemHashMap.containsKey(Integer.valueOf(num.intValue() % 1000000))) {
                return sAllGamesItemHashMap.get(Integer.valueOf(num.intValue() % 1000000));
            }
        }
        return null;
    }

    public static JSONObject takeReferralScreenshot(Activity activity, View view) throws IOException, JSONException {
        MLogger.d(TAG, "takeReferralScreenshot:2 ");
        Date date = new Date();
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", date);
        File appExternalScreenShotStoragePath = FileUtils.getAppExternalScreenShotStoragePath(activity);
        File file = new File(appExternalScreenShotStoragePath, "MPL_" + date + ".jpg");
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        createBitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        byteArrayOutputStream.toByteArray();
        fileOutputStream.flush();
        fileOutputStream.close();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imgPath", file.getAbsolutePath());
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.io.File r9, java.io.File r10) throws java.io.IOException {
        /*
            java.io.File r0 = r10.getParentFile()
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0011
            java.io.File r0 = r10.getParentFile()
            r0.mkdirs()
        L_0x0011:
            boolean r0 = r10.exists()
            if (r0 != 0) goto L_0x001a
            r10.createNewFile()
        L_0x001a:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0044 }
            r1.<init>(r9)     // Catch:{ all -> 0x0044 }
            java.nio.channels.FileChannel r9 = r1.getChannel()     // Catch:{ all -> 0x0044 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x003f }
            r1.<init>(r10)     // Catch:{ all -> 0x003f }
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch:{ all -> 0x003f }
            r4 = 0
            long r6 = r9.size()     // Catch:{ all -> 0x003f }
            r2 = r0
            r3 = r9
            r2.transferFrom(r3, r4, r6)     // Catch:{ all -> 0x003f }
            r9.close()
            r0.close()
            return
        L_0x003f:
            r10 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x0046
        L_0x0044:
            r10 = move-exception
            r9 = r0
        L_0x0046:
            if (r0 == 0) goto L_0x004b
            r0.close()
        L_0x004b:
            if (r9 == 0) goto L_0x0050
            r9.close()
        L_0x0050:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.CommonUtils.copyFile(java.io.File, java.io.File):void");
    }

    public static boolean addEventInCalender(Activity activity, ReadableArray readableArray) {
        ReadableArray readableArray2 = readableArray;
        boolean z = false;
        try {
            if (ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_CALENDAR") == 0) {
                ContentResolver contentResolver = activity.getContentResolver();
                MPLCalendar[] calendar = Util.getCalendar(activity);
                int i = 0;
                while (calendar != null && calendar.length > 0 && i < calendar.length) {
                    int i2 = 0;
                    while (readableArray2 != null && i2 < readableArray.size()) {
                        ReadableMap map = readableArray2.getMap(i2);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("dtstart", Long.valueOf(Long.parseLong(map.getString("startTime"))));
                        contentValues.put("dtend", Long.valueOf(Long.parseLong(map.getString("endTime"))));
                        contentValues.put("title", map.getString("title"));
                        contentValues.put("description", map.getString("description"));
                        contentValues.put("calendar_id", calendar[i].getCalenderId());
                        contentValues.put("eventTimezone", TimeZone.getDefault().getDisplayName(z, z ? 1 : 0));
                        contentValues.put("eventStatus", Integer.valueOf(1));
                        contentValues.put("hasAlarm", Integer.valueOf(1));
                        Uri insert = contentResolver.insert(Events.CONTENT_URI, contentValues);
                        long parseLong = (insert == null || insert.getLastPathSegment() == null) ? 0 : Long.parseLong(insert.getLastPathSegment());
                        if (parseLong != 0) {
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("event_id", Long.valueOf(parseLong));
                            if (map.hasKey("reminderMinute")) {
                                contentValues2.put("minutes", Integer.valueOf(map.getInt("reminderMinute")));
                            } else {
                                contentValues2.put("minutes", Integer.valueOf(5));
                            }
                            contentValues2.put(AnalyticsConstants.METHOD, Integer.valueOf(1));
                            MLogger.d(TAG, "addEventInCalender: ", contentResolver.insert(Uri.parse("content://com.android.calendar/reminders"), contentValues2));
                        }
                        i2++;
                        z = false;
                    }
                    i++;
                    z = false;
                }
                return true;
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "addEventInCalender: ", e2);
        }
        return false;
    }

    public static JSONObject createDeepLinkPayload(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "OPEN_DEEP_LINK");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(OneSingnalConstant.PARAM_ACTION_TYPE, str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("route", str2);
            jSONObject3.put("param", new JSONObject(str3));
            jSONObject2.put(OneSingnalConstant.PARAM_ACTION_PAYLOAD, jSONObject3);
            jSONObject.put("actionParams", jSONObject2);
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "createDeepLinkPayload: ", e2);
        }
        return jSONObject;
    }

    public static void openEmailApps(Activity activity, String str, Promise promise) {
        try {
            MLogger.d(TAG, "shareThroughemail: ");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            if (!TextUtils.isEmpty(str) && isJSONValid(str)) {
                MLogger.d(TAG, "json for email" + str.toString());
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("subject")) {
                    MLogger.d(TAG, "subject of mail" + jSONObject.optString("subject", ""));
                }
                intent.putExtra("android.intent.extra.SUBJECT", jSONObject.optString("subject", ""));
                if (jSONObject.has("message")) {
                    MLogger.d(TAG, "message of mail" + jSONObject.optString("message", ""));
                }
                intent.putExtra("android.intent.extra.TEXT", jSONObject.optString("message", ""));
            }
            intent.setPackage(SocialPkgName.EMAIL_PACKAGE_NAME);
            promise.resolve("success");
            activity.startActivity(Intent.createChooser(intent, "Send Email"));
        } catch (Exception e2) {
            promise.reject(e2.getMessage());
        }
    }
}
