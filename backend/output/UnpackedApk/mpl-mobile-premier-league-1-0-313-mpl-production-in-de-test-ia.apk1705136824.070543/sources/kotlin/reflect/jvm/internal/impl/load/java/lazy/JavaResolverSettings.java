package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* compiled from: context.kt */
public interface JavaResolverSettings {

    /* compiled from: context.kt */
    public static final class Default implements JavaResolverSettings {
        public static final Default INSTANCE = new Default();

        public boolean getCorrectNullabilityForNotNullTypeParameter() {
            return false;
        }

        public boolean getTypeEnhancementImprovements() {
            return false;
        }

        public boolean isReleaseCoroutines() {
            return false;
        }
    }

    boolean getCorrectNullabilityForNotNullTypeParameter();

    boolean getTypeEnhancementImprovements();

    boolean isReleaseCoroutines();
}
