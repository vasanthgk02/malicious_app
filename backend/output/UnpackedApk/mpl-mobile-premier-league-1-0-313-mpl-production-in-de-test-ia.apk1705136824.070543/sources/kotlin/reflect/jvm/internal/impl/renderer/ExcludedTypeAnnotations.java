package kotlin.reflect.jvm.internal.impl.renderer;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: DescriptorRenderer.kt */
public final class ExcludedTypeAnnotations {
    public static final ExcludedTypeAnnotations INSTANCE = null;
    public static final Set<FqName> internalAnnotationsForResolve = TweetUtils.setOf((T[]) new FqName[]{new FqName((String) "kotlin.internal.NoInfer"), new FqName((String) "kotlin.internal.Exact")});
}
