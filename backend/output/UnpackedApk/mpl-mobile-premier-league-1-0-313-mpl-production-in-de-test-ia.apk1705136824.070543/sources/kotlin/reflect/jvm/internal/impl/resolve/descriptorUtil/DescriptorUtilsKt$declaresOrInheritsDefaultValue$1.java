package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;

/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt$declaresOrInheritsDefaultValue$1 implements DFS$Neighbors<ValueParameterDescriptor> {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$1 INSTANCE = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$1();

    public Iterable getNeighbors(Object obj) {
        Collection<ValueParameterDescriptor> overriddenDescriptors = ((ValueParameterDescriptor) obj).getOverriddenDescriptors();
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (ValueParameterDescriptor original : overriddenDescriptors) {
            arrayList.add(original.getOriginal());
        }
        return arrayList;
    }
}
