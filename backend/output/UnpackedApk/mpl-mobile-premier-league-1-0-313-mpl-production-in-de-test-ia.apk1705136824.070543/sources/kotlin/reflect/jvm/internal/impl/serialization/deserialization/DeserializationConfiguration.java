package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeserializationConfiguration.kt */
public interface DeserializationConfiguration {

    /* compiled from: DeserializationConfiguration.kt */
    public static final class Default implements DeserializationConfiguration {
        public static final Default INSTANCE = new Default();

        public boolean getAllowUnstableDependencies() {
            Intrinsics.checkNotNullParameter(this, "this");
            return false;
        }

        public boolean getPreserveDeclarationsOrdering() {
            Intrinsics.checkNotNullParameter(this, "this");
            return false;
        }

        public boolean getReleaseCoroutines() {
            Intrinsics.checkNotNullParameter(this, "this");
            return false;
        }

        public boolean getReportErrorsOnPreReleaseDependencies() {
            Intrinsics.checkNotNullParameter(this, "this");
            return false;
        }

        public boolean getSkipMetadataVersionCheck() {
            Intrinsics.checkNotNullParameter(this, "this");
            return false;
        }

        public boolean getSkipPrereleaseCheck() {
            Intrinsics.checkNotNullParameter(this, "this");
            return false;
        }

        public boolean getTypeAliasesAllowed() {
            Intrinsics.checkNotNullParameter(this, "this");
            return true;
        }
    }

    boolean getAllowUnstableDependencies();

    boolean getPreserveDeclarationsOrdering();

    boolean getReleaseCoroutines();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();
}
