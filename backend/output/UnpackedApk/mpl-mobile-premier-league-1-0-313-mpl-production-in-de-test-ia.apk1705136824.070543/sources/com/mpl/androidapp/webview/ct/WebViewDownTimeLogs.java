package com.mpl.androidapp.webview.ct;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010 \u001a\u00020\u0016H\u0002J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/mpl/androidapp/webview/ct/WebViewDownTimeLogs;", "", "()V", "clkDurationEnd", "", "clkDurationFinal", "getClkDurationFinal", "()J", "setClkDurationFinal", "(J)V", "clkDurationStart", "sessionApiEnd", "sessionApiFinal", "getSessionApiFinal", "setSessionApiFinal", "sessionApiStart", "webLoadEnd", "webLoadFinal", "getWebLoadFinal", "setWebLoadFinal", "webLoadStart", "resetTimes", "", "setFinalTileClick", "setFinalTime", "setSessionEnd", "time", "setSessionFinal", "setSessionStart", "setTileClickEnd", "setTileClickStart", "setWebEnd", "setWebFinal", "setWebStart", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewDownTimeLogs.kt */
public final class WebViewDownTimeLogs {
    public long clkDurationEnd;
    public long clkDurationFinal;
    public long clkDurationStart;
    public long sessionApiEnd;
    public long sessionApiFinal;
    public long sessionApiStart;
    public long webLoadEnd;
    public long webLoadFinal;
    public long webLoadStart;

    private final void setFinalTileClick() {
        this.clkDurationFinal = this.clkDurationEnd - this.clkDurationStart;
    }

    private final void setSessionFinal() {
        this.sessionApiFinal = this.sessionApiEnd - this.sessionApiStart;
    }

    private final void setWebFinal() {
        this.webLoadFinal = this.webLoadEnd - this.webLoadStart;
    }

    public final long getClkDurationFinal() {
        return this.clkDurationFinal;
    }

    public final long getSessionApiFinal() {
        return this.sessionApiFinal;
    }

    public final long getWebLoadFinal() {
        return this.webLoadFinal;
    }

    public final void resetTimes() {
        this.clkDurationStart = 0;
        this.clkDurationEnd = 0;
        this.clkDurationFinal = 0;
        this.sessionApiStart = 0;
        this.sessionApiEnd = 0;
        this.sessionApiFinal = 0;
        this.webLoadStart = 0;
        this.webLoadEnd = 0;
        this.webLoadFinal = 0;
    }

    public final void setClkDurationFinal(long j) {
        this.clkDurationFinal = j;
    }

    public final void setFinalTime() {
        setFinalTileClick();
        setSessionFinal();
        setWebFinal();
    }

    public final void setSessionApiFinal(long j) {
        this.sessionApiFinal = j;
    }

    public final void setSessionEnd(long j) {
        this.sessionApiEnd = j;
    }

    public final void setSessionStart(long j) {
        this.sessionApiStart = j;
    }

    public final void setTileClickEnd(long j) {
        this.clkDurationEnd = j;
    }

    public final void setTileClickStart(long j) {
        this.clkDurationStart = j;
    }

    public final void setWebEnd(long j) {
        this.webLoadEnd = j;
    }

    public final void setWebLoadFinal(long j) {
        this.webLoadFinal = j;
    }

    public final void setWebStart(long j) {
        this.webLoadStart = j;
    }
}
