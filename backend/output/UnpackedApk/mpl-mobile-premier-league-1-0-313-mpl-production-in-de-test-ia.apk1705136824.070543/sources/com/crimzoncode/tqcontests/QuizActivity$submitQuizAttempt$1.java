package com.crimzoncode.tqcontests;

import androidx.lifecycle.Observer;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;
import com.crimzoncode.tqcontests.data.model.Resource;
import com.crimzoncode.tqcontests.data.model.Resource.Status;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/crimzoncode/tqcontests/data/model/Resource;", "", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: QuizActivity.kt */
public final class QuizActivity$submitQuizAttempt$1<T> implements Observer<Resource<Object>> {
    public final /* synthetic */ QuizAttempt $quizAttempt;
    public final /* synthetic */ QuizActivity this$0;

    public QuizActivity$submitQuizAttempt$1(QuizActivity quizActivity, QuizAttempt quizAttempt) {
        this.this$0 = quizActivity;
        this.$quizAttempt = quizAttempt;
    }

    public final void onChanged(Resource<Object> resource) {
        Status status = resource != null ? resource.getStatus() : null;
        if (status != null) {
            int ordinal = status.ordinal();
            if (ordinal == 0) {
                QuizActivity quizActivity = this.this$0;
                String string = quizActivity.getString(R.string.submitting_quiz);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.submitting_quiz)");
                quizActivity.showLoaderIcon(string);
            } else if (ordinal == 1) {
                this.this$0.hideLoaderIcon();
                this.this$0.onQuizComplete(this.$quizAttempt);
            } else if (ordinal == 2) {
                this.this$0.hideLoaderIcon();
                this.this$0.onQuizAttemptSubmitFailed();
            }
        }
    }
}
