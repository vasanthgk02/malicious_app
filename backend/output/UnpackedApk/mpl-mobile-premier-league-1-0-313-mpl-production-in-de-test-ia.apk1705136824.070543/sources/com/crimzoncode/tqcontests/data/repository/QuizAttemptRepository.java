package com.crimzoncode.tqcontests.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.crimzoncode.tqcontests.api.ApiClient;
import com.crimzoncode.tqcontests.data.model.Question;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;
import com.crimzoncode.tqcontests.data.model.QuizModel;
import com.crimzoncode.tqcontests.data.model.Resource;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J:\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJR\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u00062\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ:\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/crimzoncode/tqcontests/data/repository/QuizAttemptRepository;", "", "apiClient", "Lcom/crimzoncode/tqcontests/api/ApiClient;", "(Lcom/crimzoncode/tqcontests/api/ApiClient;)V", "abortQuiz", "Landroidx/lifecycle/LiveData;", "Lcom/crimzoncode/tqcontests/data/model/Resource;", "sessionId", "", "tournamentId", "userId", "", "entryFee", "entryCurrency", "startQuizAttempt", "Lcom/crimzoncode/tqcontests/data/model/QuizAttempt;", "subject", "chapter", "lang", "submitQuizAttempt", "quizAttempt", "Companion", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizAttemptRepository.kt */
public final class QuizAttemptRepository {
    public static final Companion Companion = new Companion(null);
    public static final String TAG;
    public final ApiClient apiClient;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/crimzoncode/tqcontests/data/repository/QuizAttemptRepository$Companion;", "", "()V", "TAG", "", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: QuizAttemptRepository.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = QuizAttemptRepository.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "QuizAttemptRepository::class.java.simpleName");
        TAG = simpleName;
    }

    public QuizAttemptRepository(ApiClient apiClient2) {
        Intrinsics.checkParameterIsNotNull(apiClient2, "apiClient");
        this.apiClient = apiClient2;
    }

    public final LiveData<Resource<Object>> abortQuiz(String str, String str2, long j, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "sessionId");
        Intrinsics.checkParameterIsNotNull(str2, "tournamentId");
        Intrinsics.checkParameterIsNotNull(str3, "entryFee");
        Intrinsics.checkParameterIsNotNull(str4, "entryCurrency");
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(Resource.Companion.loading(null));
        this.apiClient.abortQuiz(str, str2, j, str3, str4).enqueue(new QuizAttemptRepository$abortQuiz$1(mutableLiveData));
        return mutableLiveData;
    }

    public final LiveData<Resource<QuizAttempt>> startQuizAttempt(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7) {
        Intrinsics.checkParameterIsNotNull(str, "subject");
        String str8 = str2;
        Intrinsics.checkParameterIsNotNull(str8, "chapter");
        String str9 = str3;
        Intrinsics.checkParameterIsNotNull(str9, "tournamentId");
        String str10 = str4;
        Intrinsics.checkParameterIsNotNull(str10, "lang");
        String str11 = str5;
        Intrinsics.checkParameterIsNotNull(str11, "sessionId");
        String str12 = str6;
        Intrinsics.checkParameterIsNotNull(str12, "entryFee");
        String str13 = str7;
        Intrinsics.checkParameterIsNotNull(str13, "entryCurrency");
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(Resource.Companion.loading(null));
        this.apiClient.startQuizAttempt("TRIVIA", "TRIVIA", str, str8, j, str10, str9, str11, str12, str13).enqueue(new QuizAttemptRepository$startQuizAttempt$1(mutableLiveData));
        return mutableLiveData;
    }

    public final LiveData<Resource<Object>> submitQuizAttempt(QuizAttempt quizAttempt, String str, long j, String str2, String str3) {
        QuizAttempt quizAttempt2 = quizAttempt;
        Intrinsics.checkParameterIsNotNull(quizAttempt, "quizAttempt");
        String str4 = str;
        Intrinsics.checkParameterIsNotNull(str, "sessionId");
        Intrinsics.checkParameterIsNotNull(str2, "entryFee");
        Intrinsics.checkParameterIsNotNull(str3, "entryCurrency");
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(Resource.Companion.loading(null));
        HashMap hashMap = new HashMap();
        QuizModel quiz = quizAttempt.getQuiz();
        if (quiz != null) {
            for (Question next : quiz.getQuestions()) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("details[");
                outline73.append(next.getQuestionNum() - 1);
                outline73.append("][options]");
                String sb = outline73.toString();
                String userOption = next.getUserOption();
                if (userOption == null) {
                    userOption = "";
                }
                hashMap.put(sb, userOption);
                hashMap.put("details[" + (next.getQuestionNum() - 1) + "][millis]", String.valueOf(next.getTimeSpent()));
            }
            this.apiClient.submitQuizAttempt(hashMap, String.valueOf(quizAttempt.getAttemptId()), (int) quizAttempt.getMillis(), str, j, str2, str3).enqueue(new QuizAttemptRepository$submitQuizAttempt$1(quizAttempt, mutableLiveData));
            return mutableLiveData;
        }
        Intrinsics.throwNpe();
        throw null;
    }
}
