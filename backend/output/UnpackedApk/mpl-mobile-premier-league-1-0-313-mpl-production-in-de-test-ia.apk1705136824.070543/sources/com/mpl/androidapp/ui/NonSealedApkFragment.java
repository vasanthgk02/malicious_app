package com.mpl.androidapp.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.MLogger;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.util.HashMap;

public class NonSealedApkFragment extends BottomSheetDialogFragment {
    public static final String ARG_BTN_TITLE = "btnTitle";
    public static final String ARG_DIALOG_TYPE = "dialogType";
    public static final String ARG_MESSAGE = "message";
    public static final String ARG_SHOULD_CLOSE_APP = "shouldCloseApp";
    public static final String ARG_TITLE = "title";
    public static final String TAG = "NonSealedApkFragment";
    public String mBody;
    public AppCompatTextView mBodyTxt;
    public String mCTAText;
    public String mDialogType;
    public AppCompatButton mOkBtn;
    public String mTitle;
    public AppCompatTextView mTitleTxt;
    public boolean shouldCloseApp;

    public static /* synthetic */ void lambda$onCreateDialog$0(DialogInterface dialogInterface) {
        BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet));
        from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        from.setState(3);
    }

    public static NonSealedApkFragment newInstance() {
        Bundle bundle = new Bundle();
        NonSealedApkFragment nonSealedApkFragment = new NonSealedApkFragment();
        nonSealedApkFragment.setArguments(bundle);
        return nonSealedApkFragment;
    }

    public void closeDialog() {
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
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("title")) {
                this.mTitle = arguments.getString("title");
            }
            if (arguments.containsKey("message")) {
                this.mBody = arguments.getString("message");
            }
            if (arguments.containsKey(ARG_BTN_TITLE)) {
                this.mCTAText = arguments.getString(ARG_BTN_TITLE);
            }
            if (arguments.containsKey(ARG_DIALOG_TYPE)) {
                this.mDialogType = arguments.getString(ARG_DIALOG_TYPE);
            }
            if (arguments.containsKey(ARG_SHOULD_CLOSE_APP)) {
                this.shouldCloseApp = arguments.getBoolean(ARG_SHOULD_CLOSE_APP, true);
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        bottomSheetDialog.setOnShowListener($$Lambda$NonSealedApkFragment$tTrMBf_qeUnNSwSfLOMtMKvHfng.INSTANCE);
        return bottomSheetDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_appsealing_dialog, viewGroup, false);
        this.mTitleTxt = (AppCompatTextView) inflate.findViewById(R.id.dialog_title);
        this.mBodyTxt = (AppCompatTextView) inflate.findViewById(R.id.dialog_msg);
        this.mOkBtn = (AppCompatButton) inflate.findViewById(R.id.close_btn);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTxt.setText(this.mTitle);
        }
        if (!TextUtils.isEmpty(this.mBody)) {
            this.mBodyTxt.setText(this.mBody);
        }
        if (!TextUtils.isEmpty(this.mCTAText)) {
            this.mOkBtn.setText(this.mCTAText);
        }
        this.mOkBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                NonSealedApkFragment.this.sendButtonClickEvent();
                NonSealedApkFragment.this.closeDialog();
            }
        });
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
        getDialog().setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                NonSealedApkFragment.this.closeDialog();
                return false;
            }
        });
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        MLogger.d(TAG, "onDismiss: ");
        closeDialog();
    }

    public void sendButtonClickEvent() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.mDialogType) && Constant.VPN_DIALOG.equalsIgnoreCase(this.mDialogType)) {
            hashMap.put("Button Name", "VPN CTA");
            hashMap.put(EventsConstants.CTA, LiveVideoBroadcaster.OK);
        } else if (!TextUtils.isEmpty(this.mDialogType) && Constant.GPS_SPOOFING_DIALOG.equalsIgnoreCase(this.mDialogType)) {
            hashMap.put("Button Name", "OK, Got It, Shield GPS Spoofer Pop Up");
            hashMap.put(EventsConstants.CTA, LiveVideoBroadcaster.OK);
        } else if (!TextUtils.isEmpty(this.mDialogType) && Constant.NATIVE_GPS_SPOOFING_DIALOG.equalsIgnoreCase(this.mDialogType)) {
            hashMap.put("Button Name", "OK, Got It, Native GPS Spoofer Pop Up");
            hashMap.put(EventsConstants.CTA, LiveVideoBroadcaster.OK);
        }
        CleverTapAnalyticsUtils.sendEvent((String) "Button Clicked", hashMap);
    }

    public static NonSealedApkFragment newInstance(String str, String str2, String str3, boolean z, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("message", str2);
        bundle.putString(ARG_BTN_TITLE, str3);
        bundle.putBoolean(ARG_SHOULD_CLOSE_APP, z);
        bundle.putString(ARG_DIALOG_TYPE, str4);
        NonSealedApkFragment nonSealedApkFragment = new NonSealedApkFragment();
        nonSealedApkFragment.setArguments(bundle);
        return nonSealedApkFragment;
    }
}
