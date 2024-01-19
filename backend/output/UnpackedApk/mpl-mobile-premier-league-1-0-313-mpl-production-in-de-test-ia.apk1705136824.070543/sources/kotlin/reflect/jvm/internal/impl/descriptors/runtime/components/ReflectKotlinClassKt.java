package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Set;

/* compiled from: ReflectKotlinClass.kt */
public final class ReflectKotlinClassKt {
    public static final Set<Class<?>> TYPES_ELIGIBLE_FOR_SIMPLE_VISIT = TweetUtils.setOf((T[]) new Class[]{Integer.class, Character.class, Byte.class, Long.class, Short.class, Boolean.class, Double.class, Float.class, int[].class, char[].class, byte[].class, long[].class, short[].class, boolean[].class, double[].class, float[].class, Class.class, String.class});
}
