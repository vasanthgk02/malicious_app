package co.hyperverge.hypersnapsdk.objects;

import java.io.Serializable;

public class HVBaseConfig implements Serializable {
    public String closeAlertDialogDesc;
    public String closeAlertDialogTitle;
    public String errorReviewRetakeButton;
    public int errorReviewScreenDescTypeface;
    public int errorReviewScreenRetakeButtonTypeface;
    public int errorReviewScreenTitleTypeface;
    public String errorReviewTitle;
    public boolean shouldShowCloseAlert = false;
    public boolean showTrustLogos = false;

    public String getCloseAlertDialogDesc() {
        return this.closeAlertDialogDesc;
    }

    public String getCloseAlertDialogTitle() {
        return this.closeAlertDialogTitle;
    }

    public int getErroReviewScreenRetakeButtonTypeface() {
        return this.errorReviewScreenRetakeButtonTypeface;
    }

    public String getErrorReviewRetakeButton() {
        return this.errorReviewRetakeButton;
    }

    public int getErrorReviewScreenDescTypeface() {
        return this.errorReviewScreenDescTypeface;
    }

    public int getErrorReviewScreenTitleTypeface() {
        return this.errorReviewScreenTitleTypeface;
    }

    public String getErrorReviewTitle() {
        return this.errorReviewTitle;
    }

    public void setCloseAlertDialogDesc(String str) {
        this.closeAlertDialogDesc = str;
    }

    public void setCloseAlertDialogTitle(String str) {
        this.closeAlertDialogTitle = str;
    }

    public void setErroReviewScreenRetakeButtonTypeface(int i) {
        this.errorReviewScreenRetakeButtonTypeface = i;
    }

    public void setErrorReviewRetakeButton(String str) {
        this.errorReviewRetakeButton = str;
    }

    public void setErrorReviewScreenDescTypeface(int i) {
        this.errorReviewScreenDescTypeface = i;
    }

    public void setErrorReviewScreenTitleTypeface(int i) {
        this.errorReviewScreenTitleTypeface = i;
    }

    public void setErrorReviewTitle(String str) {
        this.errorReviewTitle = str;
    }

    public void setShouldShowCloseAlert(boolean z) {
        this.shouldShowCloseAlert = z;
    }

    public void setShowTrustLogos(boolean z) {
        this.showTrustLogos = z;
    }

    public boolean shouldShowCloseAlert() {
        return this.shouldShowCloseAlert;
    }

    public boolean shouldShowTrustLogos() {
        return this.showTrustLogos;
    }
}
