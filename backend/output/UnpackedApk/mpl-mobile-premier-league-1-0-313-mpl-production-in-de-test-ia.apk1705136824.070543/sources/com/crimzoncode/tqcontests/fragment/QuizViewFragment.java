package com.crimzoncode.tqcontests.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.crimzoncode.tqcontests.R;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;
import com.crimzoncode.tqcontests.databinding.FragmentQuizQuestionBinding;
import com.crimzoncode.tqcontests.util.CountdownTimerListener;
import com.crimzoncode.tqcontests.util.CustomJavascriptInterface;
import com.crimzoncode.tqcontests.util.CustomJavascriptInterface.QUIZ_VIEW_MODE;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\u001a\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J!\u0010-\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010+2\b\u0010/\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/crimzoncode/tqcontests/fragment/QuizViewFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/crimzoncode/tqcontests/databinding/FragmentQuizQuestionBinding;", "customJsInterface", "Lcom/crimzoncode/tqcontests/util/CustomJavascriptInterface;", "endTime", "", "imagesLoadedTime", "listener", "Lcom/crimzoncode/tqcontests/fragment/QuizViewFragment$OnListFragmentInteractionListener;", "questionStartTime", "questionTimer", "Landroid/os/CountDownTimer;", "quizAttempt", "Lcom/crimzoncode/tqcontests/data/model/QuizAttempt;", "quizLoadedTime", "quizMode", "Lcom/crimzoncode/tqcontests/util/CustomJavascriptInterface$QUIZ_VIEW_MODE;", "quizViewHandler", "Landroid/os/Handler;", "startTime", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onPause", "onResume", "onViewCreated", "view", "setQuestionTimer", "questionIdx", "", "submitQuiz", "updateQuestionNum", "i", "numOfQuestions", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "updateUI", "Companion", "OnListFragmentInteractionListener", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizViewFragment.kt */
public final class QuizViewFragment extends Fragment {
    public static final String ARG_QUIZ_ATTEMPT = "QUIZ_ATTEMPT";
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "QUIZ_VIEW_FRAGMENT";
    public HashMap _$_findViewCache;
    public FragmentQuizQuestionBinding binding;
    public CustomJavascriptInterface customJsInterface;
    public long endTime;
    public long imagesLoadedTime;
    public OnListFragmentInteractionListener listener;
    public long questionStartTime;
    public CountDownTimer questionTimer;
    public QuizAttempt quizAttempt;
    public long quizLoadedTime;
    public final QUIZ_VIEW_MODE quizMode = QUIZ_VIEW_MODE.QUIZ;
    public Handler quizViewHandler;
    public long startTime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/crimzoncode/tqcontests/fragment/QuizViewFragment$Companion;", "", "()V", "ARG_QUIZ_ATTEMPT", "", "TAG", "newInstance", "Lcom/crimzoncode/tqcontests/fragment/QuizViewFragment;", "quizAttempt", "Lcom/crimzoncode/tqcontests/data/model/QuizAttempt;", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: QuizViewFragment.kt */
    public static final class Companion {
        public Companion() {
        }

        public final QuizViewFragment newInstance(QuizAttempt quizAttempt) {
            Intrinsics.checkParameterIsNotNull(quizAttempt, "quizAttempt");
            QuizViewFragment quizViewFragment = new QuizViewFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(QuizViewFragment.ARG_QUIZ_ATTEMPT, quizAttempt);
            quizViewFragment.setArguments(bundle);
            return quizViewFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/crimzoncode/tqcontests/fragment/QuizViewFragment$OnListFragmentInteractionListener;", "", "hideLoaderIcon", "", "showCountDown", "listener", "Lcom/crimzoncode/tqcontests/util/CountdownTimerListener;", "showLoaderIcon", "message", "", "submitQuizAttempt", "quizAttempt", "Lcom/crimzoncode/tqcontests/data/model/QuizAttempt;", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: QuizViewFragment.kt */
    public interface OnListFragmentInteractionListener {
        void hideLoaderIcon();

        void showCountDown(CountdownTimerListener countdownTimerListener);

        void showLoaderIcon(String str);

        void submitQuizAttempt(QuizAttempt quizAttempt);
    }

    public static final /* synthetic */ FragmentQuizQuestionBinding access$getBinding$p(QuizViewFragment quizViewFragment) {
        FragmentQuizQuestionBinding fragmentQuizQuestionBinding = quizViewFragment.binding;
        if (fragmentQuizQuestionBinding != null) {
            return fragmentQuizQuestionBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public static final /* synthetic */ CustomJavascriptInterface access$getCustomJsInterface$p(QuizViewFragment quizViewFragment) {
        CustomJavascriptInterface customJavascriptInterface = quizViewFragment.customJsInterface;
        if (customJavascriptInterface != null) {
            return customJavascriptInterface;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customJsInterface");
        throw null;
    }

    public static final /* synthetic */ Handler access$getQuizViewHandler$p(QuizViewFragment quizViewFragment) {
        Handler handler = quizViewFragment.quizViewHandler;
        if (handler != null) {
            return handler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("quizViewHandler");
        throw null;
    }

    /* access modifiers changed from: private */
    public final void setQuestionTimer(QuizAttempt quizAttempt2, int i) {
        QuizViewFragment$setQuestionTimer$1 quizViewFragment$setQuestionTimer$1 = new QuizViewFragment$setQuestionTimer$1(this, quizAttempt2, i, 11000, 1000);
        this.questionTimer = quizViewFragment$setQuestionTimer$1;
        if (quizViewFragment$setQuestionTimer$1 != null) {
            quizViewFragment$setQuestionTimer$1.start();
        }
    }

    /* access modifiers changed from: private */
    public final void submitQuiz(QuizAttempt quizAttempt2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.endTime = currentTimeMillis;
        quizAttempt2.setMillis(currentTimeMillis - this.startTime);
        OnListFragmentInteractionListener onListFragmentInteractionListener = this.listener;
        if (onListFragmentInteractionListener != null) {
            onListFragmentInteractionListener.submitQuizAttempt(quizAttempt2);
        }
    }

    /* access modifiers changed from: private */
    public final void updateQuestionNum(Integer num, Integer num2) {
        FragmentQuizQuestionBinding fragmentQuizQuestionBinding = this.binding;
        if (fragmentQuizQuestionBinding != null) {
            TextView textView = fragmentQuizQuestionBinding.questionCount;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.questionCount");
            Locale locale = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
            Object[] objArr = new Object[2];
            if (num != null) {
                objArr[0] = Integer.valueOf(num.intValue() + 1);
                objArr[1] = num2;
                String format = String.format(locale, "%d/%d", Arrays.copyOf(objArr, 2));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
                textView.setText(format);
                return;
            }
            Intrinsics.throwNpe();
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            this.listener = (OnListFragmentInteractionListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(ARG_QUIZ_ATTEMPT);
            if (serializable != null) {
                this.quizAttempt = (QuizAttempt) serializable;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.crimzoncode.tqcontests.data.model.QuizAttempt");
            }
        }
        this.quizViewHandler = new Handler();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_quiz_question, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…estion, container, false)");
        FragmentQuizQuestionBinding fragmentQuizQuestionBinding = (FragmentQuizQuestionBinding) inflate;
        this.binding = fragmentQuizQuestionBinding;
        if (fragmentQuizQuestionBinding != null) {
            QuizAttempt quizAttempt2 = this.quizAttempt;
            if (quizAttempt2 != null) {
                fragmentQuizQuestionBinding.setQuizAttempt(quizAttempt2);
                FragmentQuizQuestionBinding fragmentQuizQuestionBinding2 = this.binding;
                if (fragmentQuizQuestionBinding2 != null) {
                    AppCompatTextView appCompatTextView = fragmentQuizQuestionBinding2.questionTimer;
                    Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "questionTimer");
                    appCompatTextView.setVisibility(0);
                    TextView textView = fragmentQuizQuestionBinding2.labelQuestionTimer;
                    Intrinsics.checkExpressionValueIsNotNull(textView, "labelQuestionTimer");
                    textView.setVisibility(0);
                    FragmentQuizQuestionBinding fragmentQuizQuestionBinding3 = this.binding;
                    if (fragmentQuizQuestionBinding3 != null) {
                        return fragmentQuizQuestionBinding3.getRoot();
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("quizAttempt");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        this.listener = null;
        super.onDetach();
    }

    public void onPause() {
        super.onPause();
        CountDownTimer countDownTimer = this.questionTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void onResume() {
        super.onResume();
        CountDownTimer countDownTimer = this.questionTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        QuizAttempt quizAttempt2 = this.quizAttempt;
        if (quizAttempt2 != null) {
            updateUI(quizAttempt2);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("quizAttempt");
            throw null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void updateUI(QuizAttempt quizAttempt2) {
        Intrinsics.checkParameterIsNotNull(quizAttempt2, "quizAttempt");
        OnListFragmentInteractionListener onListFragmentInteractionListener = this.listener;
        if (onListFragmentInteractionListener != null) {
            String string = getString(R.string.label_quiz_rendering);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.label_quiz_rendering)");
            onListFragmentInteractionListener.showLoaderIcon(string);
        }
        QuizViewFragment$updateUI$jsInteractionListener$1 quizViewFragment$updateUI$jsInteractionListener$1 = new QuizViewFragment$updateUI$jsInteractionListener$1(this, quizAttempt2);
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
            FragmentQuizQuestionBinding fragmentQuizQuestionBinding = this.binding;
            if (fragmentQuizQuestionBinding != null) {
                WebView webView = fragmentQuizQuestionBinding.questionWebview;
                Intrinsics.checkExpressionValueIsNotNull(webView, "binding.questionWebview");
                this.customJsInterface = new CustomJavascriptInterface(context, webView, quizViewFragment$updateUI$jsInteractionListener$1);
                FragmentQuizQuestionBinding fragmentQuizQuestionBinding2 = this.binding;
                if (fragmentQuizQuestionBinding2 != null) {
                    WebView webView2 = fragmentQuizQuestionBinding2.questionWebview;
                    Intrinsics.checkExpressionValueIsNotNull(webView2, "binding.questionWebview");
                    WebSettings settings = webView2.getSettings();
                    Intrinsics.checkExpressionValueIsNotNull(settings, "binding.questionWebview.settings");
                    settings.setJavaScriptEnabled(true);
                    FragmentQuizQuestionBinding fragmentQuizQuestionBinding3 = this.binding;
                    if (fragmentQuizQuestionBinding3 != null) {
                        WebView webView3 = fragmentQuizQuestionBinding3.questionWebview;
                        Intrinsics.checkExpressionValueIsNotNull(webView3, "binding.questionWebview");
                        WebSettings settings2 = webView3.getSettings();
                        Intrinsics.checkExpressionValueIsNotNull(settings2, "binding.questionWebview.settings");
                        settings2.setDomStorageEnabled(true);
                        FragmentQuizQuestionBinding fragmentQuizQuestionBinding4 = this.binding;
                        if (fragmentQuizQuestionBinding4 != null) {
                            WebView webView4 = fragmentQuizQuestionBinding4.questionWebview;
                            Intrinsics.checkExpressionValueIsNotNull(webView4, "binding.questionWebview");
                            webView4.setWebChromeClient(new WebChromeClient());
                            FragmentQuizQuestionBinding fragmentQuizQuestionBinding5 = this.binding;
                            if (fragmentQuizQuestionBinding5 != null) {
                                WebView webView5 = fragmentQuizQuestionBinding5.questionWebview;
                                CustomJavascriptInterface customJavascriptInterface = this.customJsInterface;
                                if (customJavascriptInterface != null) {
                                    webView5.addJavascriptInterface(customJavascriptInterface, "androidJsInterface");
                                    FragmentQuizQuestionBinding fragmentQuizQuestionBinding6 = this.binding;
                                    if (fragmentQuizQuestionBinding6 != null) {
                                        WebView webView6 = fragmentQuizQuestionBinding6.questionWebview;
                                        Intrinsics.checkExpressionValueIsNotNull(webView6, "binding.questionWebview");
                                        webView6.setScrollbarFadingEnabled(true);
                                        FragmentQuizQuestionBinding fragmentQuizQuestionBinding7 = this.binding;
                                        if (fragmentQuizQuestionBinding7 != null) {
                                            WebView webView7 = fragmentQuizQuestionBinding7.questionWebview;
                                            Intrinsics.checkExpressionValueIsNotNull(webView7, "binding.questionWebview");
                                            webView7.setVerticalScrollBarEnabled(true);
                                            FragmentQuizQuestionBinding fragmentQuizQuestionBinding8 = this.binding;
                                            if (fragmentQuizQuestionBinding8 != null) {
                                                WebView webView8 = fragmentQuizQuestionBinding8.questionWebview;
                                                Intrinsics.checkExpressionValueIsNotNull(webView8, "binding.questionWebview");
                                                webView8.setWebViewClient(new WebViewClient());
                                                FragmentQuizQuestionBinding fragmentQuizQuestionBinding9 = this.binding;
                                                if (fragmentQuizQuestionBinding9 != null) {
                                                    fragmentQuizQuestionBinding9.questionWebview.loadUrl("file:///android_asset/question.html");
                                                } else {
                                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                                    throw null;
                                                }
                                            } else {
                                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                                throw null;
                                            }
                                        } else {
                                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                                            throw null;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                                        throw null;
                                    }
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("customJsInterface");
                                    throw null;
                                }
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                throw null;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
        } else {
            Intrinsics.throwNpe();
            throw null;
        }
    }
}
