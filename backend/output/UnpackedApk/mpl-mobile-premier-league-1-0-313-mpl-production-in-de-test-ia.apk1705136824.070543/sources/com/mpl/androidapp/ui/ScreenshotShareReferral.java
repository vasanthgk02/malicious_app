package com.mpl.androidapp.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mpl.androidapp.R;
import com.mpl.androidapp.share.ct.CtShareEventConstants.ShareEventShareInitiated;
import com.mpl.androidapp.share.utils.Keys.SocialPkgName;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.ShareFile;
import com.mpl.androidapp.utils.Util;
import java.io.File;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMap;

public class ScreenshotShareReferral extends BottomSheetDialogFragment {
    public static final String IMAGE_ADDRESS = "img";
    public static final String MESSAGE = "msg";
    public static final String SCREE_NAME = "screenName";
    public static final String SHOULD_CLOSE_SCREEN = "shouldCloseScreen";
    public static final String TAG = "ScreenshotShareReferral";
    public String mFilepath;
    public AppCompatButton mOtherOptionsShareBtn;
    public String mScreenName;
    public String mShareMessage;
    public AppCompatButton mShareNowBtn;
    public AppCompatButton mWhatsAppShareBtn;
    public boolean shouldCloseApp;
    public boolean shouldCloseScreen;

    public static /* synthetic */ void lambda$onCreateDialog$0(DialogInterface dialogInterface) {
        BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet));
        from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        from.setState(3);
    }

    public static ScreenshotShareReferral newInstance() {
        Bundle bundle = new Bundle();
        ScreenshotShareReferral screenshotShareReferral = new ScreenshotShareReferral();
        screenshotShareReferral.setArguments(bundle);
        return screenshotShareReferral;
    }

    public void closeDialog() {
        if (this.shouldCloseApp) {
            System.exit(0);
        }
        if (!this.shouldCloseScreen || getActivity() == null) {
            dismissAllowingStateLoss();
        } else {
            getActivity().finish();
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        MLogger.d(TAG, "onCancel: ");
        closeDialog();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey(IMAGE_ADDRESS)) {
                this.mFilepath = arguments.getString(IMAGE_ADDRESS);
            }
            if (arguments.containsKey("msg")) {
                this.mShareMessage = arguments.getString("msg");
            }
            if (arguments.containsKey("screenName")) {
                this.mScreenName = arguments.getString("screenName");
            }
            if (arguments.containsKey("shouldCloseScreen")) {
                this.shouldCloseScreen = arguments.getBoolean("shouldCloseScreen", false);
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        bottomSheetDialog.setOnShowListener($$Lambda$ScreenshotShareReferral$sYu5x01te7SxpdeY4bBPFgk1G2E.INSTANCE);
        return bottomSheetDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_screenshot_referral_dialog, viewGroup, false);
        if (!Util.isWhatsappPresent(getContext())) {
            ((LinearLayout) inflate.findViewById(R.id.btnLayout)).setVisibility(8);
            ((LinearLayout) inflate.findViewById(R.id.LinearLayoutShareNow)).setVisibility(0);
        }
        File file = new File(this.mFilepath);
        if (file.exists()) {
            ((ImageView) inflate.findViewById(R.id.screenshotimage)).setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
        this.mWhatsAppShareBtn = (AppCompatButton) inflate.findViewById(R.id.whattsappbutton);
        this.mOtherOptionsShareBtn = (AppCompatButton) inflate.findViewById(R.id.moreoptionbutton);
        this.mShareNowBtn = (AppCompatButton) inflate.findViewById(R.id.share_now_btn);
        ((ImageView) inflate.findViewById(R.id.imageview_close_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                File file = new File(ScreenshotShareReferral.this.mFilepath);
                if (file.exists()) {
                    file.delete();
                }
                ScreenshotShareReferral.this.closeDialog();
            }
        });
        this.mWhatsAppShareBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ScreenshotShareReferral.this.closeDialog();
                ScreenshotShareReferral screenshotShareReferral = ScreenshotShareReferral.this;
                screenshotShareReferral.shareViaWhatsApp(screenshotShareReferral.getContext(), ScreenshotShareReferral.this.mFilepath, ScreenshotShareReferral.this.mShareMessage);
                ScreenshotShareReferral.this.sendButtonClickEventWhattsapp();
            }
        });
        this.mOtherOptionsShareBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ScreenshotShareReferral.this.closeDialog();
                ScreenshotShareReferral screenshotShareReferral = ScreenshotShareReferral.this;
                screenshotShareReferral.shareAllPossibleOptions(screenshotShareReferral.getContext(), ScreenshotShareReferral.this.mFilepath, ScreenshotShareReferral.this.mShareMessage);
                ScreenshotShareReferral.this.sendButtonClickEventMoreOptions();
            }
        });
        this.mShareNowBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ScreenshotShareReferral.this.closeDialog();
                ScreenshotShareReferral screenshotShareReferral = ScreenshotShareReferral.this;
                screenshotShareReferral.shareAllPossibleOptions(screenshotShareReferral.getContext(), ScreenshotShareReferral.this.mFilepath, ScreenshotShareReferral.this.mShareMessage);
                ScreenshotShareReferral.this.sendButtonClickEventMoreOptions();
            }
        });
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        MLogger.d(TAG, "onDismiss: ");
        closeDialog();
    }

    public void sendButtonClickEventMoreOptions() {
        HashMap outline88 = GeneratedOutlineSupport.outline88("Entry Point", "Screen Share button", ShareEventShareInitiated.PROPERTY_SHARE_CHANNEL, "MORE OPTIONS");
        outline88.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, this.mScreenName);
        outline88.put("Text shared", this.mShareMessage);
        CleverTapAnalyticsUtils.sendEvent((String) "Share Initiated", outline88);
    }

    public void sendButtonClickEventWhattsapp() {
        HashMap outline88 = GeneratedOutlineSupport.outline88("Entry Point", "Screen Share button", ShareEventShareInitiated.PROPERTY_SHARE_CHANNEL, "WhatsApp");
        outline88.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, this.mScreenName);
        outline88.put("Text shared", this.mShareMessage);
        CleverTapAnalyticsUtils.sendEvent((String) "Share Initiated", outline88);
    }

    public void shareAllPossibleOptions(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        ShareFile shareFile = new ShareFile(Uri.fromFile(new File(str)).toString(), context);
        if (shareFile.isFile()) {
            Uri uri = shareFile.getURI();
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.putExtra("android.intent.extra.STREAM", uri);
        } else {
            intent.putExtra("android.intent.extra.TEXT", str2 + CMap.SPACE + str);
        }
        startActivity(Intent.createChooser(intent, "Share Image"));
    }

    public void shareViaWhatsApp(Context context, String str, String str2) {
        MLogger.d(TAG, "shareViaWhatsApp: ");
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setAction("android.intent.action.SEND");
            ShareFile shareFile = new ShareFile(Uri.fromFile(new File(str)).toString(), context);
            if (shareFile.isFile()) {
                Uri uri = shareFile.getURI();
                intent.setType(shareFile.getType());
                intent.putExtra("android.intent.extra.STREAM", uri);
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.addFlags(1);
            } else {
                intent.putExtra("android.intent.extra.TEXT", str2 + CMap.SPACE + str);
            }
            intent.setPackage(SocialPkgName.WHATSAPP_PACKAGE_NAME);
            startActivity(intent);
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error/n");
            outline73.append(e2.toString());
            MLogger.e(TAG, outline73.toString());
        }
    }

    public static ScreenshotShareReferral newInstance(String str, String str2, String str3, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(IMAGE_ADDRESS, str);
        bundle.putString("msg", str2);
        bundle.putString("screenName", str3);
        bundle.putBoolean("shouldCloseScreen", z);
        ScreenshotShareReferral screenshotShareReferral = new ScreenshotShareReferral();
        screenshotShareReferral.setArguments(bundle);
        return screenshotShareReferral;
    }
}
