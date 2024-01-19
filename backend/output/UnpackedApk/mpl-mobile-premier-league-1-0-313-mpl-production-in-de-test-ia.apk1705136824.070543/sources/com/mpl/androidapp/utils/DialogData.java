package com.mpl.androidapp.utils;

public class DialogData {
    public String mBody;
    public String mCancelButton;
    public TYPE mDialogType;
    public String mOkButton;
    public String mPopUpName;
    public String mTitle;
    public boolean shouldCloseApp;

    public enum TYPE {
        USB_DEBUGGING,
        DEVELOPER_OPTION,
        SPLIT_SCREEN,
        MAGNIFICATION,
        ORIENTATION_DIALOG,
        COMMON
    }

    public String getBody() {
        return this.mBody;
    }

    public String getCancelButton() {
        return this.mCancelButton;
    }

    public TYPE getDialogType() {
        return this.mDialogType;
    }

    public String getOkButton() {
        return this.mOkButton;
    }

    public String getPopUpName() {
        return this.mPopUpName;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isShouldCloseApp() {
        return this.shouldCloseApp;
    }

    public void setBody(String str) {
        this.mBody = str;
    }

    public void setCancelButton(String str) {
        this.mCancelButton = str;
    }

    public void setDialogType(TYPE type) {
        this.mDialogType = type;
    }

    public void setOkButton(String str) {
        this.mOkButton = str;
    }

    public void setPopUpName(String str) {
        this.mPopUpName = str;
    }

    public void setShouldCloseApp(boolean z) {
        this.shouldCloseApp = z;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}
