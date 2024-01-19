package com.mpl.androidapp.unity.states;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "", "()V", "ErrorState", "InitialState", "LogFirebaseCrashState", "SendEventForGamesSuccessful", "UnityScreenSnapshotSuccess", "ViewProfileDeepLink", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$InitialState;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$LogFirebaseCrashState;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$SendEventForGamesSuccessful;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$UnityScreenSnapshotSuccess;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$ViewProfileDeepLink;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$ErrorState;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MPLUnityFeaturesState.kt */
public abstract class MPLUnityFeaturesState {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$ErrorState;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLUnityFeaturesState.kt */
    public static final class ErrorState extends MPLUnityFeaturesState {
        public final String errorMessage;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ErrorState(String str) {
            // Intrinsics.checkNotNullParameter(str, "errorMessage");
            super(null);
            this.errorMessage = str;
        }

        public static /* synthetic */ ErrorState copy$default(ErrorState errorState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = errorState.errorMessage;
            }
            return errorState.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final ErrorState copy(String str) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            return new ErrorState(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ErrorState) && Intrinsics.areEqual(this.errorMessage, ((ErrorState) obj).errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("ErrorState(errorMessage="), this.errorMessage, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$InitialState;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLUnityFeaturesState.kt */
    public static final class InitialState extends MPLUnityFeaturesState {
        public static final InitialState INSTANCE = new InitialState();

        public InitialState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$LogFirebaseCrashState;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLUnityFeaturesState.kt */
    public static final class LogFirebaseCrashState extends MPLUnityFeaturesState {
        public static final LogFirebaseCrashState INSTANCE = new LogFirebaseCrashState();

        public LogFirebaseCrashState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$SendEventForGamesSuccessful;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLUnityFeaturesState.kt */
    public static final class SendEventForGamesSuccessful extends MPLUnityFeaturesState {
        public static final SendEventForGamesSuccessful INSTANCE = new SendEventForGamesSuccessful();

        public SendEventForGamesSuccessful() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$UnityScreenSnapshotSuccess;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "fileLink", "", "(Ljava/lang/String;)V", "getFileLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLUnityFeaturesState.kt */
    public static final class UnityScreenSnapshotSuccess extends MPLUnityFeaturesState {
        public final String fileLink;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public UnityScreenSnapshotSuccess(String str) {
            // Intrinsics.checkNotNullParameter(str, "fileLink");
            super(null);
            this.fileLink = str;
        }

        public static /* synthetic */ UnityScreenSnapshotSuccess copy$default(UnityScreenSnapshotSuccess unityScreenSnapshotSuccess, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unityScreenSnapshotSuccess.fileLink;
            }
            return unityScreenSnapshotSuccess.copy(str);
        }

        public final String component1() {
            return this.fileLink;
        }

        public final UnityScreenSnapshotSuccess copy(String str) {
            Intrinsics.checkNotNullParameter(str, "fileLink");
            return new UnityScreenSnapshotSuccess(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnityScreenSnapshotSuccess) && Intrinsics.areEqual(this.fileLink, ((UnityScreenSnapshotSuccess) obj).fileLink);
        }

        public final String getFileLink() {
            return this.fileLink;
        }

        public int hashCode() {
            return this.fileLink.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("UnityScreenSnapshotSuccess(fileLink="), this.fileLink, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState$ViewProfileDeepLink;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "reactDeepLink", "", "(Ljava/lang/String;)V", "getReactDeepLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLUnityFeaturesState.kt */
    public static final class ViewProfileDeepLink extends MPLUnityFeaturesState {
        public final String reactDeepLink;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ViewProfileDeepLink(String str) {
            // Intrinsics.checkNotNullParameter(str, "reactDeepLink");
            super(null);
            this.reactDeepLink = str;
        }

        public static /* synthetic */ ViewProfileDeepLink copy$default(ViewProfileDeepLink viewProfileDeepLink, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewProfileDeepLink.reactDeepLink;
            }
            return viewProfileDeepLink.copy(str);
        }

        public final String component1() {
            return this.reactDeepLink;
        }

        public final ViewProfileDeepLink copy(String str) {
            Intrinsics.checkNotNullParameter(str, "reactDeepLink");
            return new ViewProfileDeepLink(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ViewProfileDeepLink) && Intrinsics.areEqual(this.reactDeepLink, ((ViewProfileDeepLink) obj).reactDeepLink);
        }

        public final String getReactDeepLink() {
            return this.reactDeepLink;
        }

        public int hashCode() {
            return this.reactDeepLink.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("ViewProfileDeepLink(reactDeepLink="), this.reactDeepLink, ')');
        }
    }

    public MPLUnityFeaturesState() {
    }

    public /* synthetic */ MPLUnityFeaturesState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
