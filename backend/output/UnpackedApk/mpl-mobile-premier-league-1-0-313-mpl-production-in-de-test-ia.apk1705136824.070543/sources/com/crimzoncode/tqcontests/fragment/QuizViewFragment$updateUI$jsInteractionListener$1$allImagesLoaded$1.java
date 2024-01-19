package com.crimzoncode.tqcontests.fragment;

import android.webkit.WebView;
import com.crimzoncode.tqcontests.fragment.QuizViewFragment.OnListFragmentInteractionListener;
import com.crimzoncode.tqcontests.util.CountdownTimerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: QuizViewFragment.kt */
public final class QuizViewFragment$updateUI$jsInteractionListener$1$allImagesLoaded$1 implements Runnable {
    public final /* synthetic */ QuizViewFragment$updateUI$jsInteractionListener$1 this$0;

    public QuizViewFragment$updateUI$jsInteractionListener$1$allImagesLoaded$1(QuizViewFragment$updateUI$jsInteractionListener$1 quizViewFragment$updateUI$jsInteractionListener$1) {
        this.this$0 = quizViewFragment$updateUI$jsInteractionListener$1;
    }

    public final void run() {
        OnListFragmentInteractionListener access$getListener$p = this.this$0.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.showCountDown(new CountdownTimerListener(this) {
                public final /* synthetic */ QuizViewFragment$updateUI$jsInteractionListener$1$allImagesLoaded$1 this$0;

                {
                    this.this$0 = r1;
                }

                public void onCountdownFinish() {
                    WebView webView = QuizViewFragment.access$getBinding$p(this.this$0.this$0.this$0).questionWebview;
                    Intrinsics.checkExpressionValueIsNotNull(webView, "binding.questionWebview");
                    webView.setVisibility(0);
                    OnListFragmentInteractionListener access$getListener$p = this.this$0.this$0.this$0.listener;
                    if (access$getListener$p != null) {
                        access$getListener$p.hideLoaderIcon();
                    }
                    this.this$0.this$0.this$0.updateQuestionNum(Integer.valueOf(0), Integer.valueOf(this.this$0.this$0.$quizAttempt.getNumQuestions()));
                    QuizViewFragment$updateUI$jsInteractionListener$1 quizViewFragment$updateUI$jsInteractionListener$1 = this.this$0.this$0;
                    quizViewFragment$updateUI$jsInteractionListener$1.this$0.setQuestionTimer(quizViewFragment$updateUI$jsInteractionListener$1.$quizAttempt, 0);
                }
            });
        }
    }
}
