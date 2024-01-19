package com.mpl.androidapp.unity.states;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/unity/states/UnityViewProfileState;", "", "()V", "ErrorState", "InitialUnityProfileState", "ViewProfileDeepLink", "Lcom/mpl/androidapp/unity/states/UnityViewProfileState$InitialUnityProfileState;", "Lcom/mpl/androidapp/unity/states/UnityViewProfileState$ViewProfileDeepLink;", "Lcom/mpl/androidapp/unity/states/UnityViewProfileState$ErrorState;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityViewProfileState.kt */
public abstract class UnityViewProfileState {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/unity/states/UnityViewProfileState$ErrorState;", "Lcom/mpl/androidapp/unity/states/UnityViewProfileState;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityViewProfileState.kt */
    public static final class ErrorState extends UnityViewProfileState {
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/unity/states/UnityViewProfileState$InitialUnityProfileState;", "Lcom/mpl/androidapp/unity/states/UnityViewProfileState;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityViewProfileState.kt */
    public static final class InitialUnityProfileState extends UnityViewProfileState {
        public static final InitialUnityProfileState INSTANCE = new InitialUnityProfileState();

        public InitialUnityProfileState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/unity/states/UnityViewProfileState$ViewProfileDeepLink;", "Lcom/mpl/androidapp/unity/states/UnityViewProfileState;", "reactDeepLink", "", "(Ljava/lang/String;)V", "getReactDeepLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityViewProfileState.kt */
    public static final class ViewProfileDeepLink extends UnityViewProfileState {
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

    public UnityViewProfileState() {
    }

    public /* synthetic */ UnityViewProfileState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
