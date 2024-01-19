package kotlinx.serialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0004H\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u00101\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\bH\u0016J\u0010\u00107\u001a\u00020-2\u0006\u00101\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020\u0004H\u0016R\u001b\u0010\u000e\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040(X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00069"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "typeParameters", "", "builder", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "annotations", "", "getAnnotations", "()Ljava/util/List;", "elementAnnotations", "", "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", "", "getElementsCount", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "name2Index", "", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "typeParametersDescriptors", "equals", "", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerialDescriptors.kt */
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {
    public final Lazy _hashCode$delegate;
    public final List<Annotation> annotations;
    public final List<Annotation>[] elementAnnotations;
    public final SerialDescriptor[] elementDescriptors;
    public final String[] elementNames;
    public final boolean[] elementOptionality;
    public final int elementsCount;
    public final SerialKind kind;
    public final Map<String, Integer> name2Index;
    public final String serialName;
    public final Set<String> serialNames;
    public final SerialDescriptor[] typeParametersDescriptors;

    public SerialDescriptorImpl(String str, SerialKind serialKind, int i, List<? extends SerialDescriptor> list, ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(serialKind, "kind");
        Intrinsics.checkNotNullParameter(list, "typeParameters");
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "builder");
        this.serialName = str;
        this.kind = serialKind;
        this.elementsCount = i;
        this.annotations = classSerialDescriptorBuilder.annotations;
        this.serialNames = ArraysKt___ArraysJvmKt.toHashSet(classSerialDescriptorBuilder.elementNames);
        int i2 = 0;
        Object[] array = classSerialDescriptorBuilder.elementNames.toArray(new String[0]);
        if (array != null) {
            this.elementNames = (String[]) array;
            this.elementDescriptors = Platform_commonKt.compactArray(classSerialDescriptorBuilder.elementDescriptors);
            Object[] array2 = classSerialDescriptorBuilder.elementAnnotations.toArray(new List[0]);
            if (array2 != null) {
                this.elementAnnotations = (List[]) array2;
                List<Boolean> list2 = classSerialDescriptorBuilder.elementOptionality;
                Intrinsics.checkNotNullParameter(list2, "<this>");
                boolean[] zArr = new boolean[list2.size()];
                for (Boolean booleanValue : list2) {
                    zArr[i2] = booleanValue.booleanValue();
                    i2++;
                }
                this.elementOptionality = zArr;
                Iterable withIndex = TweetUtils.withIndex(this.elementNames);
                ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(withIndex, 10));
                Iterator it = ((IndexingIterable) withIndex).iterator();
                while (true) {
                    IndexingIterator indexingIterator = (IndexingIterator) it;
                    if (indexingIterator.hasNext()) {
                        IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
                        arrayList.add(new Pair(indexedValue.value, Integer.valueOf(indexedValue.index)));
                    } else {
                        this.name2Index = ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) arrayList);
                        this.typeParametersDescriptors = Platform_commonKt.compactArray(list);
                        this._hashCode$delegate = TweetUtils.lazy((Function0<? extends T>) new SerialDescriptorImpl$_hashCode$2<Object>(this));
                        return;
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual(getSerialName(), serialDescriptor.getSerialName()) && Arrays.equals(this.typeParametersDescriptors, ((SerialDescriptorImpl) obj).typeParametersDescriptors) && getElementsCount() == serialDescriptor.getElementsCount()) {
                int elementsCount2 = getElementsCount();
                if (elementsCount2 > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        if (!Intrinsics.areEqual(getElementDescriptor(i).getSerialName(), serialDescriptor.getElementDescriptor(i).getSerialName()) || !Intrinsics.areEqual(getElementDescriptor(i).getKind(), serialDescriptor.getElementDescriptor(i).getKind())) {
                            break;
                        } else if (i2 >= elementsCount2) {
                            return true;
                        } else {
                            i = i2;
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    public List<Annotation> getElementAnnotations(int i) {
        return this.elementAnnotations[i];
    }

    public SerialDescriptor getElementDescriptor(int i) {
        return this.elementDescriptors[i];
    }

    public int getElementIndex(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Integer num = this.name2Index.get(str);
        if (num == null) {
            return -3;
        }
        return num.intValue();
    }

    public String getElementName(int i) {
        return this.elementNames[i];
    }

    public int getElementsCount() {
        return this.elementsCount;
    }

    public SerialKind getKind() {
        return this.kind;
    }

    public String getSerialName() {
        return this.serialName;
    }

    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    public int hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    public boolean isElementOptional(int i) {
        return this.elementOptionality[i];
    }

    public boolean isInline() {
        TypeUtilsKt.isInline(this);
        return false;
    }

    public boolean isNullable() {
        TypeUtilsKt.isNullable(this);
        return false;
    }

    public String toString() {
        return ArraysKt___ArraysJvmKt.joinToString$default(RangesKt___RangesKt.until(0, this.elementsCount), ", ", Intrinsics.stringPlus(this.serialName, "("), ")", 0, null, new SerialDescriptorImpl$toString$1(this), 24);
    }
}
