package com.crimzoncode.tqcontests.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.crimzoncode.tqcontests.api.response.GenericResponse;
import com.crimzoncode.tqcontests.api.response.ResultResponse;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;
import com.crimzoncode.tqcontests.data.model.Resource;
import com.crimzoncode.tqcontests.data.model.Resource.Companion;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\t\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/crimzoncode/tqcontests/data/repository/QuizAttemptRepository$submitQuizAttempt$1", "Lretrofit2/Callback;", "Lcom/crimzoncode/tqcontests/api/response/GenericResponse;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizAttemptRepository.kt */
public final class QuizAttemptRepository$submitQuizAttempt$1 implements Callback<GenericResponse> {
    public final /* synthetic */ QuizAttempt $quizAttempt;
    public final /* synthetic */ MutableLiveData $resourceLiveData;

    public QuizAttemptRepository$submitQuizAttempt$1(QuizAttempt quizAttempt, MutableLiveData mutableLiveData) {
        this.$quizAttempt = quizAttempt;
        this.$resourceLiveData = mutableLiveData;
    }

    public void onFailure(Call<GenericResponse> call, Throwable th) {
        MutableLiveData mutableLiveData = this.$resourceLiveData;
        Companion companion = Resource.Companion;
        String message = th != null ? th.getMessage() : null;
        if (message != null) {
            mutableLiveData.setValue(companion.error(message, null));
        } else {
            Intrinsics.throwNpe();
            throw null;
        }
    }

    public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
        if ((response != null ? Boolean.valueOf(response.isSuccessful()) : null) == null || !response.isSuccessful()) {
            this.$resourceLiveData.setValue(Resource.Companion.error("Unable to submit Quiz. \n Something went wrong", null));
            return;
        }
        GenericResponse genericResponse = (GenericResponse) response.body;
        if ((genericResponse != null ? Boolean.valueOf(genericResponse.isSuccessful()) : null) == null || !genericResponse.isSuccessful()) {
            this.$resourceLiveData.setValue(Resource.Companion.error("Unable to submit Quiz. \n Something went wrong", null));
            return;
        }
        ResultResponse resultWithKey = genericResponse.getResultWithKey("quiz-complete");
        if (resultWithKey != null) {
            Type type = new QuizAttemptRepository$submitQuizAttempt$1$onResponse$type$1().getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "object : TypeToken<Map<String, String>>() {}.type");
            Object dataAsObject = resultWithKey.getDataAsObject(type);
            Intrinsics.checkExpressionValueIsNotNull(dataAsObject, "resultResponse.getDataAsObject(type)");
            Map map = (Map) dataAsObject;
            QuizAttempt quizAttempt = this.$quizAttempt;
            String str = (String) map.get("marks");
            int i = -1;
            quizAttempt.setMarks(str != null ? Integer.parseInt(str) : -1);
            QuizAttempt quizAttempt2 = this.$quizAttempt;
            String str2 = (String) map.get("highest_marks");
            if (str2 != null) {
                i = Integer.parseInt(str2);
            }
            quizAttempt2.setUserMaxMarks(i);
            this.$resourceLiveData.setValue(Companion.success$default(Resource.Companion, null, null, 3, null));
        }
    }
}
