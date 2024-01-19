package com.crimzoncode.tqcontests.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.crimzoncode.tqcontests.TQContestsClientProvider;
import com.crimzoncode.tqcontests.api.ApiClient;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;
import com.crimzoncode.tqcontests.data.model.Resource;
import com.crimzoncode.tqcontests.data.repository.QuizAttemptRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJR\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00070\u00062\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ:\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/crimzoncode/tqcontests/viewmodel/QuizAttemptViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "repository", "Lcom/crimzoncode/tqcontests/data/repository/QuizAttemptRepository;", "abortQuiz", "Landroidx/lifecycle/LiveData;", "Lcom/crimzoncode/tqcontests/data/model/Resource;", "", "sessionId", "", "tournamentId", "userId", "", "entryFee", "entryCurrency", "initRepository", "", "restHost", "auth", "startQuizAttempt", "Lcom/crimzoncode/tqcontests/data/model/QuizAttempt;", "subject", "chapter", "lang", "submitQuizAttempt", "quizAttempt", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizAttemptViewModel.kt */
public final class QuizAttemptViewModel extends ViewModel {
    public QuizAttemptRepository repository;

    public final LiveData<Resource<Object>> abortQuiz(String str, String str2, long j, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "sessionId");
        Intrinsics.checkParameterIsNotNull(str2, "tournamentId");
        Intrinsics.checkParameterIsNotNull(str3, "entryFee");
        Intrinsics.checkParameterIsNotNull(str4, "entryCurrency");
        QuizAttemptRepository quizAttemptRepository = this.repository;
        if (quizAttemptRepository != null) {
            return quizAttemptRepository.abortQuiz(str, str2, j, str3, str4);
        }
        Intrinsics.throwUninitializedPropertyAccessException("repository");
        throw null;
    }

    public final void initRepository(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "restHost");
        Intrinsics.checkParameterIsNotNull(str2, "auth");
        ApiClient apiClient = TQContestsClientProvider.getApiClient(str, str2);
        Intrinsics.checkExpressionValueIsNotNull(apiClient, "apiClient");
        this.repository = new QuizAttemptRepository(apiClient);
    }

    public final LiveData<Resource<QuizAttempt>> startQuizAttempt(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7) {
        String str8 = str;
        Intrinsics.checkParameterIsNotNull(str, "subject");
        String str9 = str2;
        Intrinsics.checkParameterIsNotNull(str2, "chapter");
        String str10 = str3;
        Intrinsics.checkParameterIsNotNull(str3, "tournamentId");
        Intrinsics.checkParameterIsNotNull(str4, "lang");
        Intrinsics.checkParameterIsNotNull(str5, "sessionId");
        Intrinsics.checkParameterIsNotNull(str6, "entryFee");
        Intrinsics.checkParameterIsNotNull(str7, "entryCurrency");
        QuizAttemptRepository quizAttemptRepository = this.repository;
        if (quizAttemptRepository != null) {
            return quizAttemptRepository.startQuizAttempt(str, str2, str3, j, str4, str5, str6, str7);
        }
        Intrinsics.throwUninitializedPropertyAccessException("repository");
        throw null;
    }

    public final LiveData<Resource<Object>> submitQuizAttempt(QuizAttempt quizAttempt, String str, long j, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(quizAttempt, "quizAttempt");
        Intrinsics.checkParameterIsNotNull(str, "sessionId");
        Intrinsics.checkParameterIsNotNull(str2, "entryFee");
        Intrinsics.checkParameterIsNotNull(str3, "entryCurrency");
        QuizAttemptRepository quizAttemptRepository = this.repository;
        if (quizAttemptRepository != null) {
            return quizAttemptRepository.submitQuizAttempt(quizAttempt, str, j, str2, str3);
        }
        Intrinsics.throwUninitializedPropertyAccessException("repository");
        throw null;
    }
}
