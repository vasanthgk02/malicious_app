package kotlinx.serialization.descriptors;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00122\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010&\u001a\u00020\u0017R*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR$\u0010\u0019\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\t\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "serialName", "", "(Ljava/lang/String;)V", "annotations", "", "", "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementAnnotations", "", "getElementAnnotations$kotlinx_serialization_core", "elementDescriptors", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_core", "elementNames", "getElementNames$kotlinx_serialization_core", "elementOptionality", "", "getElementOptionality$kotlinx_serialization_core", "isNullable", "isNullable$annotations", "()Z", "setNullable", "(Z)V", "getSerialName", "()Ljava/lang/String;", "uniqueNames", "", "element", "", "elementName", "descriptor", "isOptional", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerialDescriptors.kt */
public final class ClassSerialDescriptorBuilder {
    public List<? extends Annotation> annotations = EmptyList.INSTANCE;
    public final List<List<Annotation>> elementAnnotations = new ArrayList();
    public final List<SerialDescriptor> elementDescriptors = new ArrayList();
    public final List<String> elementNames = new ArrayList();
    public final List<Boolean> elementOptionality = new ArrayList();
    public final Set<String> uniqueNames = new HashSet();

    public ClassSerialDescriptorBuilder(String str) {
        Intrinsics.checkNotNullParameter(str, "serialName");
    }

    public static void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, SerialDescriptor serialDescriptor, List list, boolean z, int i) {
        EmptyList emptyList = (i & 4) != 0 ? EmptyList.INSTANCE : null;
        if ((i & 8) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(str, "elementName");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(emptyList, "annotations");
        if (classSerialDescriptorBuilder.uniqueNames.add(str)) {
            classSerialDescriptorBuilder.elementNames.add(str);
            classSerialDescriptorBuilder.elementDescriptors.add(serialDescriptor);
            classSerialDescriptorBuilder.elementAnnotations.add(emptyList);
            classSerialDescriptorBuilder.elementOptionality.add(Boolean.valueOf(z));
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("Element with name '", str, "' is already registered").toString());
    }
}
