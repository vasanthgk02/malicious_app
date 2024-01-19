package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemberScope.kt */
public final class DescriptorKindFilter {
    public static final DescriptorKindFilter ALL;
    public static final int ALL_KINDS_MASK;
    public static final DescriptorKindFilter CALLABLES = new DescriptorKindFilter(CALLABLES_MASK, null, 2);
    public static final int CALLABLES_MASK;
    public static final DescriptorKindFilter CLASSIFIERS = new DescriptorKindFilter(CLASSIFIERS_MASK, null, 2);
    public static final int CLASSIFIERS_MASK;
    public static final Companion Companion = new Companion(null);
    public static final List<MaskToName> DEBUG_MASK_BIT_NAMES;
    public static final List<MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
    public static final DescriptorKindFilter FUNCTIONS = new DescriptorKindFilter(FUNCTIONS_MASK, null, 2);
    public static final int FUNCTIONS_MASK;
    public static final int NON_SINGLETON_CLASSIFIERS_MASK;
    public static final int PACKAGES_MASK;
    public static final int SINGLETON_CLASSIFIERS_MASK;
    public static final int TYPE_ALIASES_MASK;
    public static final int VALUES_MASK;
    public static final DescriptorKindFilter VARIABLES = new DescriptorKindFilter(VARIABLES_MASK, null, 2);
    public static final int VARIABLES_MASK;
    public static int nextMaskValue = 1;
    public final List<DescriptorKindExclude> excludes;
    public final int kindMask;

    /* compiled from: MemberScope.kt */
    public static final class Companion {

        /* compiled from: MemberScope.kt */
        public static final class MaskToName {
            public final int mask;
            public final String name;

            public MaskToName(int i, String str) {
                Intrinsics.checkNotNullParameter(str, "name");
                this.mask = i;
                this.name = str;
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        Object obj;
        Object obj2;
        Class<DescriptorKindFilter> cls = DescriptorKindFilter.class;
        int i = nextMaskValue;
        int i2 = i << 1;
        nextMaskValue = i2;
        NON_SINGLETON_CLASSIFIERS_MASK = i;
        int i3 = i2 << 1;
        nextMaskValue = i3;
        SINGLETON_CLASSIFIERS_MASK = i2;
        int i4 = i3 << 1;
        nextMaskValue = i4;
        TYPE_ALIASES_MASK = i3;
        int i5 = i4 << 1;
        nextMaskValue = i5;
        PACKAGES_MASK = i4;
        int i6 = i5 << 1;
        nextMaskValue = i6;
        FUNCTIONS_MASK = i5;
        int i7 = i6 << 1;
        nextMaskValue = i7;
        VARIABLES_MASK = i6;
        nextMaskValue = i7 << 1;
        int i8 = i7 - 1;
        ALL_KINDS_MASK = i8;
        CLASSIFIERS_MASK = i | i2 | i3;
        VALUES_MASK = i2 | i5 | i6;
        CALLABLES_MASK = i5 | i6;
        ALL = new DescriptorKindFilter(i8, null, 2);
        new DescriptorKindFilter(NON_SINGLETON_CLASSIFIERS_MASK, null, 2);
        new DescriptorKindFilter(SINGLETON_CLASSIFIERS_MASK, null, 2);
        new DescriptorKindFilter(TYPE_ALIASES_MASK, null, 2);
        new DescriptorKindFilter(PACKAGES_MASK, null, 2);
        new DescriptorKindFilter(VALUES_MASK, null, 2);
        Field[] fields = cls.getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "T::class.java.fields");
        ArrayList arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Field field2 = (Field) it.next();
            Object obj3 = field2.get(null);
            DescriptorKindFilter descriptorKindFilter = obj3 instanceof DescriptorKindFilter ? (DescriptorKindFilter) obj3 : null;
            if (descriptorKindFilter != null) {
                int i9 = descriptorKindFilter.kindMask;
                String name = field2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "field.name");
                obj2 = new MaskToName(i9, name);
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                arrayList2.add(obj2);
            }
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = arrayList2;
        Field[] fields2 = cls.getFields();
        Intrinsics.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (Intrinsics.areEqual(((Field) next).getType(), Integer.TYPE)) {
                arrayList4.add(next);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            Field field4 = (Field) it3.next();
            Object obj4 = field4.get(null);
            if (obj4 != null) {
                int intValue = ((Integer) obj4).intValue();
                if (intValue == ((-intValue) & intValue)) {
                    String name2 = field4.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "field.name");
                    obj = new MaskToName(intValue, name2);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    arrayList5.add(obj);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        DEBUG_MASK_BIT_NAMES = arrayList5;
    }

    public DescriptorKindFilter(int i, List list, int i2) {
        this(i, (i2 & 2) != 0 ? EmptyList.INSTANCE : null);
    }

    public final boolean acceptsKinds(int i) {
        return (i & this.kindMask) != 0;
    }

    public String toString() {
        T t;
        String str;
        boolean z;
        Iterator<T> it = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((MaskToName) t).mask == this.kindMask) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        MaskToName maskToName = (MaskToName) t;
        if (maskToName == null) {
            str = null;
        } else {
            str = maskToName.name;
        }
        if (str == null) {
            List<MaskToName> list = DEBUG_MASK_BIT_NAMES;
            ArrayList arrayList = new ArrayList();
            for (MaskToName maskToName2 : list) {
                Object obj = acceptsKinds(maskToName2.mask) ? maskToName2.name : null;
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            str = ArraysKt___ArraysJvmKt.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62);
        }
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("DescriptorKindFilter(", str, ", ");
        outline80.append(this.excludes);
        outline80.append(')');
        return outline80.toString();
    }

    public DescriptorKindFilter(int i, List<? extends DescriptorKindExclude> list) {
        Intrinsics.checkNotNullParameter(list, "excludes");
        this.excludes = list;
        for (DescriptorKindExclude fullyExcludedDescriptorKinds : list) {
            i &= ~fullyExcludedDescriptorKinds.getFullyExcludedDescriptorKinds();
        }
        this.kindMask = i;
    }
}
