package com.crimzoncode.tqcontests.fragment;

import android.os.CountDownTimer;
import com.crimzoncode.tqcontests.data.model.Question;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;
import com.crimzoncode.tqcontests.data.model.QuizModel;
import com.crimzoncode.tqcontests.util.CustomJavascriptInterface;
import com.crimzoncode.tqcontests.util.JsInteractionListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"com/crimzoncode/tqcontests/fragment/QuizViewFragment$updateUI$jsInteractionListener$1", "Lcom/crimzoncode/tqcontests/util/JsInteractionListener;", "allImagesLoaded", "", "documentLoaded", "imageFailedToLoad", "loadedImages", "", "totalImages", "imageLoadingProgress", "optionSelected", "questionIdx", "optionIdx", "quizLoadCompleted", "updateNavButtons", "currentQuestionIdx", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizViewFragment.kt */
public final class QuizViewFragment$updateUI$jsInteractionListener$1 implements JsInteractionListener {
    public final /* synthetic */ QuizAttempt $quizAttempt;
    public final /* synthetic */ QuizViewFragment this$0;

    public QuizViewFragment$updateUI$jsInteractionListener$1(QuizViewFragment quizViewFragment, QuizAttempt quizAttempt) {
        this.this$0 = quizViewFragment;
        this.$quizAttempt = quizAttempt;
    }

    public void allImagesLoaded() {
        this.this$0.imagesLoadedTime = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("loadTime", String.valueOf(this.this$0.imagesLoadedTime - this.this$0.quizLoadedTime));
        QuizModel quiz = this.$quizAttempt.getQuiz();
        if (quiz != null) {
            hashMap.put("quiz_id", String.valueOf(quiz.getQuizId()));
            QuizViewFragment.access$getQuizViewHandler$p(this.this$0).post(new QuizViewFragment$updateUI$jsInteractionListener$1$allImagesLoaded$1(this));
            this.this$0.startTime = System.currentTimeMillis();
            this.this$0.questionStartTime = System.currentTimeMillis();
            return;
        }
        Intrinsics.throwNpe();
        throw null;
    }

    public void documentLoaded() {
        CustomJavascriptInterface access$getCustomJsInterface$p = QuizViewFragment.access$getCustomJsInterface$p(this.this$0);
        QuizModel quiz = this.$quizAttempt.getQuiz();
        if (quiz != null) {
            access$getCustomJsInterface$p.setQuiz(quiz, this.this$0.quizMode);
        } else {
            Intrinsics.throwNpe();
            throw null;
        }
    }

    public void imageFailedToLoad(int i, int i2) {
    }

    public void imageLoadingProgress(int i, int i2) {
        QuizViewFragment.access$getQuizViewHandler$p(this.this$0).post(new QuizViewFragment$updateUI$jsInteractionListener$1$imageLoadingProgress$1(this, i, i2));
    }

    public void optionSelected(int i, int i2) {
        CountDownTimer access$getQuestionTimer$p = this.this$0.questionTimer;
        if (access$getQuestionTimer$p != null) {
            access$getQuestionTimer$p.cancel();
        }
        Question questionByIdx = this.$quizAttempt.getQuestionByIdx(i);
        questionByIdx.setUserOptionIdx(i2);
        questionByIdx.setTimeSpent(System.currentTimeMillis() - this.this$0.questionStartTime);
        QuizViewFragment.access$getCustomJsInterface$p(this.this$0).updateOptionStatus(i, i2, "NORMAL");
        QuizViewFragment.access$getQuizViewHandler$p(this.this$0).postDelayed(new QuizViewFragment$updateUI$jsInteractionListener$1$optionSelected$1(this, i), 650);
    }

    public void quizLoadCompleted() {
        this.this$0.quizLoadedTime = System.currentTimeMillis();
        QuizViewFragment.access$getQuizViewHandler$p(this.this$0).post(new QuizViewFragment$updateUI$jsInteractionListener$1$quizLoadCompleted$1(this));
    }

    public void updateNavButtons(int i) {
    }
}
