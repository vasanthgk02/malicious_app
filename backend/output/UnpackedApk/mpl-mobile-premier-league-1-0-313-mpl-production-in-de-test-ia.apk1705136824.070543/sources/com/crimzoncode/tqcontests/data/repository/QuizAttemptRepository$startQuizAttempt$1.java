package com.crimzoncode.tqcontests.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.crimzoncode.tqcontests.api.response.GenericResponse;
import com.crimzoncode.tqcontests.api.response.ResultResponse;
import com.crimzoncode.tqcontests.data.model.BaseModel;
import com.crimzoncode.tqcontests.data.model.Option;
import com.crimzoncode.tqcontests.data.model.Question;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;
import com.crimzoncode.tqcontests.data.model.QuizModel;
import com.crimzoncode.tqcontests.data.model.Resource;
import com.crimzoncode.tqcontests.data.model.Resource.Companion;
import com.paynimo.android.payment.util.Constant;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/crimzoncode/tqcontests/data/repository/QuizAttemptRepository$startQuizAttempt$1", "Lretrofit2/Callback;", "Lcom/crimzoncode/tqcontests/api/response/GenericResponse;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizAttemptRepository.kt */
public final class QuizAttemptRepository$startQuizAttempt$1 implements Callback<GenericResponse> {
    public final /* synthetic */ MutableLiveData $resourceLiveData;

    public QuizAttemptRepository$startQuizAttempt$1(MutableLiveData mutableLiveData) {
        this.$resourceLiveData = mutableLiveData;
    }

    public void onFailure(Call<GenericResponse> call, Throwable th) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(th, "t");
        MutableLiveData mutableLiveData = this.$resourceLiveData;
        Companion companion = Resource.Companion;
        String message = th.getMessage();
        if (message != null) {
            mutableLiveData.setValue(companion.error(message, null));
        } else {
            Intrinsics.throwNpe();
            throw null;
        }
    }

    public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(response, Constant.TAG_RESPONSE);
        if (response.isSuccessful()) {
            GenericResponse genericResponse = (GenericResponse) response.body;
            if (genericResponse == null || !genericResponse.isSuccessful()) {
                this.$resourceLiveData.setValue(Resource.Companion.error("Unable to load Quiz", null));
                return;
            }
            ResultResponse resultWithKey = genericResponse.getResultWithKey("quiz-attempt-start");
            if (resultWithKey != null) {
                BaseModel dataAsObject = resultWithKey.getDataAsObject(QuizAttempt.class);
                Intrinsics.checkExpressionValueIsNotNull(dataAsObject, "result.getDataAsObject(QuizAttempt::class.java)");
                QuizAttempt quizAttempt = (QuizAttempt) dataAsObject;
                QuizModel quiz = quizAttempt.getQuiz();
                if (quiz != null) {
                    Collections.shuffle(quiz.getQuestions());
                    QuizModel quiz2 = quizAttempt.getQuiz();
                    if (quiz2 != null) {
                        for (Question question : quiz2.getQuestions()) {
                            List<Option> options = question.getOptions();
                            Intrinsics.checkExpressionValueIsNotNull(options, "it.options");
                            Option option = (Option) ArraysKt___ArraysJvmKt.last(options);
                            List<Option> options2 = question.getOptions();
                            Intrinsics.checkExpressionValueIsNotNull(options2, "it.options");
                            int lastIndex = TweetUtils.getLastIndex(options2);
                            question.getOptions().remove(option);
                            List<Option> options3 = question.getOptions();
                            Intrinsics.checkExpressionValueIsNotNull(options3, "it.options");
                            Collections.shuffle(options3);
                            question.getOptions().add(lastIndex, option);
                        }
                        this.$resourceLiveData.setValue(Companion.success$default(Resource.Companion, quizAttempt, null, 2, null));
                    } else {
                        Intrinsics.throwNpe();
                        throw null;
                    }
                } else {
                    Intrinsics.throwNpe();
                    throw null;
                }
            }
            if (genericResponse.getResultWithKey("quiz-attempt-start-failed") != null) {
                this.$resourceLiveData.setValue(Resource.Companion.error("Unable to load Quiz", null));
                return;
            }
            return;
        }
        this.$resourceLiveData.setValue(Resource.Companion.error("Unable to load Quiz", null));
    }
}
