package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
public final class IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        return TweetUtils.compareValues(((KotlinType) t).toString(), ((KotlinType) t2).toString());
    }
}
