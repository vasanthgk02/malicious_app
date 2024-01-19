package com.idology.cameralibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.resources.TextAppearanceConfig;
import com.idology.cameralibrary.ActivationKey.Feature;
import com.idology.cameralibrary.Constants.CardCombination;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.Objects;

public class PreviewActivity extends AppCompatActivity {
    public static int blinkCount;
    public static byte[] mBitmapData;
    public static int mImageHeight;
    public static int mImageWidth;
    public static Options options;
    public static int retryCount;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f1720b;
    public Constants constants = Constants.ourInstance;
    public ImageView previewImageView;

    public void acceptAction(View view) {
        String str;
        try {
            options.inSampleSize = 1;
            options.inDensity = 60;
            String str2 = this.constants.selectedSide;
            Objects.requireNonNull(this.constants);
            if (str2.equals("SELFIE")) {
                str = TextAppearanceConfig.convertToBase64(this.f1720b, 80);
            } else {
                str = TextAppearanceConfig.convertToBase64(BitmapFactory.decodeByteArray(mBitmapData, 0, mBitmapData.length, options), 90);
            }
            int ordinal = this.constants.combination.ordinal();
            if (ordinal == 0) {
                this.constants.frontString = str;
                this.constants.combination = CardCombination.licenseBack;
            } else if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        this.constants.frontString = str;
                        if (this.constants.useSelfie) {
                            this.constants.combination = CardCombination.passportSelfie;
                        }
                    } else if (ordinal != 4) {
                        retryCount = 0;
                        blinkCount = 0;
                    }
                }
                Constants constants2 = this.constants;
                Objects.requireNonNull(this.constants);
                constants2.selectedSide = "SELFIE";
                this.constants.selfieString = str;
                retryCount = 0;
                blinkCount = 0;
            } else {
                this.constants.backString = str;
                if (this.constants.useSelfie || this.constants.activationKey.isEnabled(Feature.SelfieAndLivelinessEnabled)) {
                    this.constants.combination = CardCombination.licenseSelfie;
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        finish();
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1409683804, bundle);
    }

    public void retryAction(View view) {
        int ordinal = this.constants.combination.ordinal();
        if (ordinal == 2 || ordinal == 4) {
            retryCount++;
        }
        finish();
    }
}
