package com.crimzoncode.tqcontests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;
import com.crimzoncode.tqcontests.data.model.Resource.Status;
import com.crimzoncode.tqcontests.fragment.QuizViewFragment;
import com.crimzoncode.tqcontests.fragment.QuizViewFragment.OnListFragmentInteractionListener;
import com.crimzoncode.tqcontests.util.HelperFns;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.crimzoncode.tqcontests.util.dialog.DialogUtils;
import com.crimzoncode.tqcontests.viewmodel.QuizAttemptViewModel;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0014J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0014J\b\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/crimzoncode/tqcontests/QuizActivity;", "Lcom/crimzoncode/tqcontests/BaseActivity;", "Lcom/crimzoncode/tqcontests/fragment/QuizViewFragment$OnListFragmentInteractionListener;", "()V", "chapter", "", "entryCurrency", "entryFee", "gameId", "", "gameName", "lang", "quizAttemptViewModel", "Lcom/crimzoncode/tqcontests/viewmodel/QuizAttemptViewModel;", "sessionId", "subject", "tournamentId", "userId", "wasPaused", "", "getMplIntent", "Landroid/content/Intent;", "loadQuiz", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGameAbort", "isError", "onPause", "onQuizAttemptSubmitFailed", "onQuizComplete", "quizAttempt", "Lcom/crimzoncode/tqcontests/data/model/QuizAttempt;", "onQuizLoadError", "onResume", "showExitConfirmationDialog", "showLoaderIcon", "message", "showNoNetwork", "startQuiz", "submitQuizAttempt", "Companion", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizActivity.kt */
public final class QuizActivity extends BaseActivity implements OnListFragmentInteractionListener {
    public static final Companion Companion = new Companion(null);
    public static final String QUESTION_FRAGMENT_TAG = "QUESTION_FRAGMENT";
    public HashMap _$_findViewCache;
    public String chapter;
    public String entryCurrency;
    public String entryFee;
    public long gameId;
    public String gameName;
    public String lang;
    public QuizAttemptViewModel quizAttemptViewModel;
    public String sessionId;
    public String subject;
    public String tournamentId;
    public long userId;
    public boolean wasPaused;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/crimzoncode/tqcontests/QuizActivity$Companion;", "", "()V", "QUESTION_FRAGMENT_TAG", "", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: QuizActivity.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Status.values().length];
            $EnumSwitchMapping$0 = iArr;
            Status status = Status.LOADING;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            Status status2 = Status.SUCCESS;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            Status status3 = Status.ERROR;
            iArr3[2] = 3;
            int[] iArr4 = new int[Status.values().length];
            $EnumSwitchMapping$1 = iArr4;
            Status status4 = Status.LOADING;
            iArr4[0] = 1;
            int[] iArr5 = $EnumSwitchMapping$1;
            Status status5 = Status.SUCCESS;
            iArr5[1] = 2;
            int[] iArr6 = $EnumSwitchMapping$1;
            Status status6 = Status.ERROR;
            iArr6[2] = 3;
            int[] iArr7 = new int[Status.values().length];
            $EnumSwitchMapping$2 = iArr7;
            Status status7 = Status.SUCCESS;
            iArr7[1] = 1;
            int[] iArr8 = $EnumSwitchMapping$2;
            Status status8 = Status.ERROR;
            iArr8[2] = 2;
            int[] iArr9 = $EnumSwitchMapping$2;
            Status status9 = Status.LOADING;
            iArr9[0] = 3;
        }
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
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: 0000 */
    public final Intent getMplIntent() {
        Intent intent = new Intent();
        String str = this.gameName;
        if (str != null) {
            intent.putExtra("GameName", str);
            intent.putExtra("GameId", this.gameId);
            intent.putExtra("Score", 0);
            intent.putExtra(TQConstants.USER_MAX_SCORE, 0);
            String str2 = this.tournamentId;
            if (str2 != null) {
                intent.putExtra("TournamentId", str2);
                String str3 = this.sessionId;
                if (str3 != null) {
                    intent.putExtra(TQConstants.SESSION_ID, str3);
                    return intent;
                }
                Intrinsics.throwUninitializedPropertyAccessException("sessionId");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("tournamentId");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameName");
        throw null;
    }

    /* access modifiers changed from: 0000 */
    public final void loadQuiz() {
        QuizAttemptViewModel quizAttemptViewModel2 = this.quizAttemptViewModel;
        if (quizAttemptViewModel2 != null) {
            String str = this.subject;
            if (str != null) {
                String str2 = this.chapter;
                if (str2 != null) {
                    String str3 = this.tournamentId;
                    if (str3 != null) {
                        long j = this.userId;
                        String str4 = this.lang;
                        if (str4 != null) {
                            String str5 = this.sessionId;
                            if (str5 != null) {
                                String str6 = this.entryFee;
                                if (str6 != null) {
                                    String str7 = this.entryCurrency;
                                    if (str7 != null) {
                                        quizAttemptViewModel2.startQuizAttempt(str, str2, str3, j, str4, str5, str6, str7).observe(this, new QuizActivity$loadQuiz$1(this));
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("entryCurrency");
                                        throw null;
                                    }
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("entryFee");
                                    throw null;
                                }
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("sessionId");
                                throw null;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("lang");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("tournamentId");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("chapter");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("subject");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("quizAttemptViewModel");
            throw null;
        }
    }

    public void onBackPressed() {
        showExitConfirmationDialog();
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1186750250, bundle);
    }

    /* access modifiers changed from: 0000 */
    public final void onGameAbort(boolean z) {
        Intent mplIntent = getMplIntent();
        mplIntent.putExtra("Score", 0);
        if (z) {
            mplIntent.putExtra(TQConstants.ERROR_DETAILS, TQConstants.APP_ABORTED_ERROR);
        } else {
            mplIntent.putExtra(TQConstants.ERROR_DETAILS, TQConstants.USER_ABORTED);
        }
        QuizAttemptViewModel quizAttemptViewModel2 = this.quizAttemptViewModel;
        if (quizAttemptViewModel2 != null) {
            String str = this.sessionId;
            if (str != null) {
                String str2 = this.tournamentId;
                if (str2 != null) {
                    long j = this.userId;
                    String str3 = this.entryFee;
                    if (str3 != null) {
                        String str4 = this.entryCurrency;
                        if (str4 != null) {
                            quizAttemptViewModel2.abortQuiz(str, str2, j, str3, str4).observe(this, new QuizActivity$onGameAbort$1(this, mplIntent));
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("entryCurrency");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("entryFee");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("tournamentId");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("sessionId");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("quizAttemptViewModel");
            throw null;
        }
    }

    public void onPause() {
        iIiIiIiIii.IiiiIiiiII(this, -1000076511, new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public final void onQuizAttemptSubmitFailed() {
        if (!HelperFns.isInternetConnected(this)) {
            showNoNetwork();
            return;
        }
        DialogUtils.showErrorPopup$default(DialogUtils.INSTANCE, this, null, getString(R.string.error_message_upload_quiz), null, getString(R.string.ok), null, new QuizActivity$onQuizAttemptSubmitFailed$1(this), false, null, 298, null);
    }

    /* access modifiers changed from: 0000 */
    public final void onQuizComplete(QuizAttempt quizAttempt) {
        Intent mplIntent = getMplIntent();
        mplIntent.putExtra("Score", quizAttempt.getMarks());
        mplIntent.putExtra(TQConstants.USER_MAX_SCORE, quizAttempt.getUserMaxMarks());
        setResult(-1, mplIntent);
        finish();
    }

    /* access modifiers changed from: 0000 */
    public final void onQuizLoadError() {
        if (!HelperFns.isInternetConnected(this)) {
            showNoNetwork();
            return;
        }
        DialogUtils.showErrorPopup$default(DialogUtils.INSTANCE, this, null, getString(R.string.error_message_loading_quiz), null, getString(R.string.ok), null, new QuizActivity$onQuizLoadError$1(this), false, null, 298, null);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 1590732706, new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public final void showExitConfirmationDialog() {
        DialogUtils.showCustomPopup$default(DialogUtils.INSTANCE, this, R.drawable.circle_bg_dialog, getString(R.string.exit_quiz_title), getString(R.string.exit_quiz_description), null, getString(R.string.exit_quiz_btn), getString(R.string.exit_quiz_btn_secondary), false, new QuizActivity$showExitConfirmationDialog$1(this), null, 656, null);
    }

    public void showLoaderIcon(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        showLoaderIcon(str, R.id.layout_root);
    }

    /* access modifiers changed from: 0000 */
    public final void showNoNetwork() {
        onGameAbort(true);
    }

    /* access modifiers changed from: 0000 */
    public final void startQuiz(QuizAttempt quizAttempt) {
        BaseActivity.setFragment$default(this, QuizViewFragment.Companion.newInstance(quizAttempt), QUESTION_FRAGMENT_TAG, R.id.layout_root, false, 8, null);
    }

    public void submitQuizAttempt(QuizAttempt quizAttempt) {
        Intrinsics.checkParameterIsNotNull(quizAttempt, "quizAttempt");
        QuizAttemptViewModel quizAttemptViewModel2 = this.quizAttemptViewModel;
        if (quizAttemptViewModel2 != null) {
            String str = this.sessionId;
            if (str != null) {
                long j = this.userId;
                String str2 = this.entryFee;
                if (str2 != null) {
                    String str3 = this.entryCurrency;
                    if (str3 != null) {
                        quizAttemptViewModel2.submitQuizAttempt(quizAttempt, str, j, str2, str3).observe(this, new QuizActivity$submitQuizAttempt$1(this, quizAttempt));
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("entryCurrency");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("entryFee");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("sessionId");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("quizAttemptViewModel");
            throw null;
        }
    }
}
