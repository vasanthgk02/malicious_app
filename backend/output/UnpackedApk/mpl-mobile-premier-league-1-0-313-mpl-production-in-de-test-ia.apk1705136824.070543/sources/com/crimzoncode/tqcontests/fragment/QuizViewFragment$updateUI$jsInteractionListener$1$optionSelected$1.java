package com.crimzoncode.tqcontests.fragment;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: QuizViewFragment.kt */
public final class QuizViewFragment$updateUI$jsInteractionListener$1$optionSelected$1 implements Runnable {
    public final /* synthetic */ int $questionIdx;
    public final /* synthetic */ QuizViewFragment$updateUI$jsInteractionListener$1 this$0;

    public QuizViewFragment$updateUI$jsInteractionListener$1$optionSelected$1(QuizViewFragment$updateUI$jsInteractionListener$1 quizViewFragment$updateUI$jsInteractionListener$1, int i) {
        this.this$0 = quizViewFragment$updateUI$jsInteractionListener$1;
        this.$questionIdx = i;
    }

    public final void run() {
        if (this.this$0.$quizAttempt.isNextQuestionAvailable(this.$questionIdx)) {
            QuizViewFragment.access$getCustomJsInterface$p(this.this$0.this$0).moveQuestionByOffset(1);
            this.this$0.this$0.updateQuestionNum(Integer.valueOf(this.$questionIdx + 1), Integer.valueOf(this.this$0.$quizAttempt.getNumQuestions()));
            QuizViewFragment$updateUI$jsInteractionListener$1 quizViewFragment$updateUI$jsInteractionListener$1 = this.this$0;
            quizViewFragment$updateUI$jsInteractionListener$1.this$0.setQuestionTimer(quizViewFragment$updateUI$jsInteractionListener$1.$quizAttempt, this.$questionIdx + 1);
            this.this$0.this$0.questionStartTime = System.currentTimeMillis();
            return;
        }
        CountDownTimer access$getQuestionTimer$p = this.this$0.this$0.questionTimer;
        if (access$getQuestionTimer$p != null) {
            access$getQuestionTimer$p.cancel();
        }
        QuizViewFragment$updateUI$jsInteractionListener$1 quizViewFragment$updateUI$jsInteractionListener$12 = this.this$0;
        quizViewFragment$updateUI$jsInteractionListener$12.this$0.submitQuiz(quizViewFragment$updateUI$jsInteractionListener$12.$quizAttempt);
    }
}
