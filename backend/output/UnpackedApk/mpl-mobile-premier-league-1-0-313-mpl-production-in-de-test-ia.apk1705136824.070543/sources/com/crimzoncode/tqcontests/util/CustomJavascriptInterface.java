package com.crimzoncode.tqcontests.util;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.crimzoncode.tqcontests.data.model.QuizModel;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u000201B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0007J\b\u0010\u0019\u001a\u00020\u0015H\u0007J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0007J\b\u0010\u001b\u001a\u00020\u0015H\u0007J,\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010 2\u0006\u0010!\u001a\u00020\fH\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0011H\u0007J\b\u0010$\u001a\u00020\u0015H\u0007J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011H\u0007J\u0018\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0007J \u0010-\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u001eH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lcom/crimzoncode/tqcontests/util/CustomJavascriptInterface;", "", "context", "Landroid/content/Context;", "questionWebView", "Landroid/webkit/WebView;", "listener", "Lcom/crimzoncode/tqcontests/util/JsInteractionListener;", "(Landroid/content/Context;Landroid/webkit/WebView;Lcom/crimzoncode/tqcontests/util/JsInteractionListener;)V", "getContext", "()Landroid/content/Context;", "isPageLoaded", "", "isTransitionActive", "getListener", "()Lcom/crimzoncode/tqcontests/util/JsInteractionListener;", "questionIdx", "", "getQuestionWebView", "()Landroid/webkit/WebView;", "documentLoad", "", "imageFailedToLoad", "loadedImages", "totalImages", "javaAllImagesLoaded", "javaImageLoadingProgress", "javaQuizLoadCompleted", "loadUrl", "jsMethod", "", "params", "", "checkPageLoaded", "moveQuestionByOffset", "offset", "questionTransitionComplete", "selectedOption", "currentQuestionIdx", "option", "setQuiz", "quizModel", "Lcom/crimzoncode/tqcontests/data/model/QuizModel;", "quizViewMode", "Lcom/crimzoncode/tqcontests/util/CustomJavascriptInterface$QUIZ_VIEW_MODE;", "updateOptionStatus", "optionIdx", "status", "Companion", "QUIZ_VIEW_MODE", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CustomJavascriptInterface.kt */
public final class CustomJavascriptInterface {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = TAG;
    public final Context context;
    public boolean isPageLoaded;
    public boolean isTransitionActive;
    public final JsInteractionListener listener;
    public int questionIdx;
    public final WebView questionWebView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/crimzoncode/tqcontests/util/CustomJavascriptInterface$Companion;", "", "()V", "TAG", "", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CustomJavascriptInterface.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/crimzoncode/tqcontests/util/CustomJavascriptInterface$QUIZ_VIEW_MODE;", "", "(Ljava/lang/String;I)V", "QUIZ", "REVIEW", "CHALLENGE", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CustomJavascriptInterface.kt */
    public enum QUIZ_VIEW_MODE {
        QUIZ,
        REVIEW,
        CHALLENGE
    }

    public CustomJavascriptInterface(Context context2, WebView webView, JsInteractionListener jsInteractionListener) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(webView, "questionWebView");
        Intrinsics.checkParameterIsNotNull(jsInteractionListener, "listener");
        this.context = context2;
        this.questionWebView = webView;
        this.listener = jsInteractionListener;
    }

    private final void loadUrl(String str, Map<String, ? extends Object> map, boolean z) {
        this.questionWebView.post(new CustomJavascriptInterface$loadUrl$1(this, z, str, new Gson().toJson((Object) map)));
    }

    @JavascriptInterface
    public final void documentLoad() {
        this.listener.documentLoaded();
    }

    public final Context getContext() {
        return this.context;
    }

    public final JsInteractionListener getListener() {
        return this.listener;
    }

    public final WebView getQuestionWebView() {
        return this.questionWebView;
    }

    @JavascriptInterface
    public final void imageFailedToLoad(int i, int i2) {
        this.listener.imageFailedToLoad(i, i2);
    }

    @JavascriptInterface
    public final void javaAllImagesLoaded() {
        this.listener.allImagesLoaded();
        this.listener.updateNavButtons(0);
        this.isPageLoaded = true;
        loadUrl("jbShowQuiz", new HashMap(), false);
    }

    @JavascriptInterface
    public final void javaImageLoadingProgress(int i, int i2) {
        this.listener.imageLoadingProgress(i, i2);
    }

    @JavascriptInterface
    public final void javaQuizLoadCompleted() {
        this.listener.quizLoadCompleted();
    }

    @JavascriptInterface
    public final void moveQuestionByOffset(int i) {
        if (!this.isTransitionActive) {
            HashMap hashMap = new HashMap();
            hashMap.put("offset", Integer.valueOf(i));
            loadUrl("jbMoveQuestion", hashMap, true);
            this.isTransitionActive = true;
        }
        this.questionIdx += i;
    }

    @JavascriptInterface
    public final void questionTransitionComplete() {
        this.isTransitionActive = false;
        this.listener.updateNavButtons(this.questionIdx);
    }

    @JavascriptInterface
    public final void selectedOption(int i, int i2) {
        this.listener.optionSelected(i, i2);
    }

    @JavascriptInterface
    public final void setQuiz(QuizModel quizModel, QUIZ_VIEW_MODE quiz_view_mode) {
        Intrinsics.checkParameterIsNotNull(quizModel, "quizModel");
        Intrinsics.checkParameterIsNotNull(quiz_view_mode, "quizViewMode");
        HashMap hashMap = new HashMap();
        hashMap.put("quiz", quizModel);
        hashMap.put("quizMode", quiz_view_mode);
        loadUrl("jbSetQuiz", hashMap, false);
    }

    @JavascriptInterface
    public final void updateOptionStatus(int i, int i2, String str) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        HashMap hashMap = new HashMap();
        hashMap.put("questionIdx", Integer.valueOf(i));
        hashMap.put("optionIdx", Integer.valueOf(i2));
        hashMap.put("status", str);
        loadUrl("jbUpdateOptionStatus", hashMap, true);
    }
}
