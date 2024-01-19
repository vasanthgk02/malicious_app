package com.mpl.androidapp.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mpl.androidapp.R;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.share.ct.CtShareEventConstants.ShareEventShareInitiated;
import com.mpl.androidapp.share.utils.Keys.SocialPkgName;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.ShareFile;
import com.mpl.androidapp.utils.Util;
import java.io.File;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMap;

public class ReferralNudgeApkFragment extends BottomSheetDialogFragment {
    public static final String ARG_MESSAGE = "message";
    public static final String ARG_TITLE = "imagepath";
    public static final String SCREE_NAME = "screenName";
    public static final String TAG = "ReferralNudgeApkFragment";
    public String mCTAText;
    public String mDialogType;
    public String mFilepath;
    public AppCompatButton mOtherOptionsShareBtn;
    public String mScreenName;
    public String mShareMessage;
    public AppCompatButton mShareNowBtn;
    public AppCompatButton mWhatsAppShareBtn;
    public boolean shouldCloseApp;

    public static /* synthetic */ void lambda$onCreateDialog$0(DialogInterface dialogInterface) {
        BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet));
        from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        from.setState(3);
    }

    public static ReferralNudgeApkFragment newInstance() {
        Bundle bundle = new Bundle();
        ReferralNudgeApkFragment referralNudgeApkFragment = new ReferralNudgeApkFragment();
        referralNudgeApkFragment.setArguments(bundle);
        return referralNudgeApkFragment;
    }

    public void closeDialog() {
        MSharedPreferencesUtils.setContentObservercount(1);
        if (this.shouldCloseApp) {
            System.exit(0);
        } else {
            dismissAllowingStateLoss();
        }
    }

    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        MLogger.d(TAG, "onCancel: ");
        closeDialog();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.AppBottomSheetDialogTheme);
        getActivity().getWindow().getDecorView().setSystemUiVisibility(16);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey(ARG_TITLE)) {
                this.mFilepath = arguments.getString(ARG_TITLE);
            }
            if (arguments.containsKey("message")) {
                this.mShareMessage = arguments.getString("message");
            }
            if (arguments.containsKey("screenName")) {
                this.mScreenName = arguments.getString("screenName");
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        bottomSheetDialog.setOnShowListener($$Lambda$ReferralNudgeApkFragment$1eCE8Z4U7Qg5kd7Jjleodbrqko.INSTANCE);
        return bottomSheetDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_nudge_referral_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.textview_nudge)).setText(ConfigManager.getReferralNudgeConfig().optString("title"));
        if (!Util.isWhatsappPresent(getContext())) {
            ((LinearLayout) inflate.findViewById(R.id.btnLayout_nudge)).setVisibility(8);
            ((LinearLayout) inflate.findViewById(R.id.LinearLayoutShareNowNudge)).setVisibility(0);
        }
        File file = new File(this.mFilepath);
        if (file.exists()) {
            ((ImageView) inflate.findViewById(R.id.screenshotimage_nudge)).setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
        ((ImageView) inflate.findViewById(R.id.imageview_close_button_nudge)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ReferralNudgeApkFragment.this.closeDialog();
                File file = new File(ReferralNudgeApkFragment.this.mFilepath);
                if (file.exists()) {
                    file.delete();
                }
            }
        });
        this.mWhatsAppShareBtn = (AppCompatButton) inflate.findViewById(R.id.whattsappbutton_nudge);
        this.mOtherOptionsShareBtn = (AppCompatButton) inflate.findViewById(R.id.moreoptionbutton_nudge);
        this.mShareNowBtn = (AppCompatButton) inflate.findViewById(R.id.share_now_btn_nudge);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
        getDialog().setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                ReferralNudgeApkFragment.this.closeDialog();
                return false;
            }
        });
        this.mWhatsAppShareBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ReferralNudgeApkFragment.this.closeDialog();
                ReferralNudgeApkFragment referralNudgeApkFragment = ReferralNudgeApkFragment.this;
                referralNudgeApkFragment.shareViaWhatsApp(referralNudgeApkFragment.getContext(), ReferralNudgeApkFragment.this.mFilepath, ReferralNudgeApkFragment.this.mShareMessage);
                ReferralNudgeApkFragment.this.sendButtonClickEventWhattsapp();
            }
        });
        this.mOtherOptionsShareBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ReferralNudgeApkFragment.this.closeDialog();
                ReferralNudgeApkFragment referralNudgeApkFragment = ReferralNudgeApkFragment.this;
                referralNudgeApkFragment.shareAllPossibleOptions(referralNudgeApkFragment.getContext(), ReferralNudgeApkFragment.this.mFilepath, ReferralNudgeApkFragment.this.mShareMessage);
                ReferralNudgeApkFragment.this.sendButtonClickEventMoreOptions();
            }
        });
        this.mShareNowBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ReferralNudgeApkFragment.this.closeDialog();
                ReferralNudgeApkFragment referralNudgeApkFragment = ReferralNudgeApkFragment.this;
                referralNudgeApkFragment.shareAllPossibleOptions(referralNudgeApkFragment.getContext(), ReferralNudgeApkFragment.this.mFilepath, ReferralNudgeApkFragment.this.mShareMessage);
                ReferralNudgeApkFragment.this.sendButtonClickEventMoreOptions();
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
        HashMap outline88 = GeneratedOutlineSupport.outline88("Entry Point", "Screenshot Nudge", ShareEventShareInitiated.PROPERTY_SHARE_CHANNEL, "MORE OPTIONS");
        outline88.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, this.mScreenName);
        outline88.put("Text shared", this.mShareMessage);
        CleverTapAnalyticsUtils.sendEvent((String) "Share Initiated", outline88);
    }

    public void sendButtonClickEventWhattsapp() {
        HashMap outline88 = GeneratedOutlineSupport.outline88("Entry Point", "Screenshot Nudge", ShareEventShareInitiated.PROPERTY_SHARE_CHANNEL, "WhatsApp");
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

    public static ReferralNudgeApkFragment newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, str);
        bundle.putString("message", str2);
        ReferralNudgeApkFragment referralNudgeApkFragment = new ReferralNudgeApkFragment();
        referralNudgeApkFragment.setArguments(bundle);
        return referralNudgeApkFragment;
    }

    public static ReferralNudgeApkFragment newInstance(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, str);
        bundle.putString("message", str2);
        bundle.putString("screenName", str3);
        ReferralNudgeApkFragment referralNudgeApkFragment = new ReferralNudgeApkFragment();
        referralNudgeApkFragment.setArguments(bundle);
        return referralNudgeApkFragment;
    }
}
