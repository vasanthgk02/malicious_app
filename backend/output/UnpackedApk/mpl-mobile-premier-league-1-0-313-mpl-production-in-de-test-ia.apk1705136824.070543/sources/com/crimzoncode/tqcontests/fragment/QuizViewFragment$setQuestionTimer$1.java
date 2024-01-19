package com.crimzoncode.tqcontests.fragment;

import android.os.CountDownTimer;
import androidx.appcompat.widget.AppCompatTextView;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;
import com.crimzoncode.tqcontests.util.HelperFns;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/crimzoncode/tqcontests/fragment/QuizViewFragment$setQuestionTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "p0", "", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizViewFragment.kt */
public final class QuizViewFragment$setQuestionTimer$1 extends CountDownTimer {
    public final /* synthetic */ int $questionIdx;
    public final /* synthetic */ QuizAttempt $quizAttempt;
    public final /* synthetic */ QuizViewFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public QuizViewFragment$setQuestionTimer$1(QuizViewFragment quizViewFragment, QuizAttempt quizAttempt, int i, long j, long j2) {
        // this.this$0 = quizViewFragment;
        // this.$quizAttempt = quizAttempt;
        // this.$questionIdx = i;
        super(j, j2);
    }

    public void onFinish() {
        if (this.$quizAttempt.isNextQuestionAvailable(this.$questionIdx)) {
            QuizViewFragment.access$getCustomJsInterface$p(this.this$0).moveQuestionByOffset(1);
            this.this$0.updateQuestionNum(Integer.valueOf(this.$questionIdx + 1), Integer.valueOf(this.$quizAttempt.getNumQuestions()));
            this.this$0.setQuestionTimer(this.$quizAttempt, this.$questionIdx + 1);
            return;
        }
        this.this$0.submitQuiz(this.$quizAttempt);
    }

    public void onTick(long j) {
        AppCompatTextView appCompatTextView = QuizViewFragment.access$getBinding$p(this.this$0).questionTimer;
        Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "binding.questionTimer");
        appCompatTextView.setText(HelperFns.getFormattedTime(j, false, false));
    }
}
