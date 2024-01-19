package kotlinx.serialization.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.CLASS;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u000208J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0!H\u0002J\u0013\u0010:\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010>\u001a\u00020\bH\u0016J\u0010\u0010?\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0004H\u0016J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\bH\u0016J\b\u0010B\u001a\u00020\bH\u0016J\u0010\u0010C\u001a\u0002082\u0006\u0010>\u001a\u00020\bH\u0016J\u000e\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020\u0012J\u000e\u0010F\u001a\u0002052\u0006\u0010G\u001a\u00020\u0012J\b\u0010H\u001a\u00020\u0004H\u0016R\u001b\u0010\n\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u00168BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016X\u0004¢\u0006\u0004\n\u0002\u0010'R\u001e\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001c0\u0016X\u0004¢\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u00168@X\u0002¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b1\u00102¨\u0006I"}, d2 = {"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers$delegate", "classAnnotations", "", "getElementsCount", "elementsOptionality", "", "indices", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "names", "[Ljava/lang/String;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "typeParameterDescriptors", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors$delegate", "addElement", "", "name", "isOptional", "", "buildIndices", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PluginGeneratedSerialDescriptor.kt */
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {
    public final Lazy _hashCode$delegate;
    public int added = -1;
    public final Lazy childSerializers$delegate;
    public final int elementsCount;
    public final boolean[] elementsOptionality;
    public final GeneratedSerializer<?> generatedSerializer;
    public Map<String, Integer> indices;
    public final String[] names;
    public final List<Annotation>[] propertiesAnnotations;
    public final String serialName;
    public final Lazy typeParameterDescriptors$delegate;

    public PluginGeneratedSerialDescriptor(String str, GeneratedSerializer<?> generatedSerializer2, int i) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        this.serialName = str;
        this.generatedSerializer = generatedSerializer2;
        this.elementsCount = i;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        int i3 = this.elementsCount;
        this.propertiesAnnotations = new List[i3];
        this.elementsOptionality = new boolean[i3];
        this.indices = ArraysKt___ArraysJvmKt.emptyMap();
        this.childSerializers$delegate = TweetUtils.lazy(LazyThreadSafetyMode.PUBLICATION, new PluginGeneratedSerialDescriptor$childSerializers$2(this));
        this.typeParameterDescriptors$delegate = TweetUtils.lazy(LazyThreadSafetyMode.PUBLICATION, new PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(this));
        this._hashCode$delegate = TweetUtils.lazy(LazyThreadSafetyMode.PUBLICATION, new PluginGeneratedSerialDescriptor$_hashCode$2(this));
    }

    public final void addElement(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        String[] strArr = this.names;
        int i = this.added + 1;
        this.added = i;
        strArr[i] = str;
        this.elementsOptionality[i] = z;
        this.propertiesAnnotations[i] = null;
        if (i == this.elementsCount - 1) {
            HashMap hashMap = new HashMap();
            int length = this.names.length - 1;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    hashMap.put(this.names[i2], Integer.valueOf(i2));
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            this.indices = hashMap;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual(getSerialName(), serialDescriptor.getSerialName()) && Arrays.equals(getTypeParameterDescriptors$kotlinx_serialization_core(), ((PluginGeneratedSerialDescriptor) obj).getTypeParameterDescriptors$kotlinx_serialization_core()) && getElementsCount() == serialDescriptor.getElementsCount()) {
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
        return EmptyList.INSTANCE;
    }

    public List<Annotation> getElementAnnotations(int i) {
        List<Annotation> list = this.propertiesAnnotations[i];
        return list == null ? EmptyList.INSTANCE : list;
    }

    public SerialDescriptor getElementDescriptor(int i) {
        return ((KSerializer[]) this.childSerializers$delegate.getValue())[i].getDescriptor();
    }

    public int getElementIndex(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Integer num = this.indices.get(str);
        if (num == null) {
            return -3;
        }
        return num.intValue();
    }

    public String getElementName(int i) {
        return this.names[i];
    }

    public final int getElementsCount() {
        return this.elementsCount;
    }

    public SerialKind getKind() {
        return CLASS.INSTANCE;
    }

    public String getSerialName() {
        return this.serialName;
    }

    public Set<String> getSerialNames() {
        return this.indices.keySet();
    }

    public final SerialDescriptor[] getTypeParameterDescriptors$kotlinx_serialization_core() {
        return (SerialDescriptor[]) this.typeParameterDescriptors$delegate.getValue();
    }

    public int hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    public boolean isElementOptional(int i) {
        return this.elementsOptionality[i];
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
        return ArraysKt___ArraysJvmKt.joinToString$default(RangesKt___RangesKt.until(0, this.elementsCount), ", ", Intrinsics.stringPlus(this.serialName, "("), ")", 0, null, new PluginGeneratedSerialDescriptor$toString$1(this), 24);
    }
}
