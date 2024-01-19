package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.FilteringSequence$iterator$1;
import kotlin.sequences.Sequence;

/* compiled from: DeclaredMemberIndex.kt */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    public final Map<Name, JavaRecordComponent> components;
    public final Map<Name, JavaField> fields;
    public final JavaClass jClass;
    public final Function1<JavaMember, Boolean> memberFilter;
    public final Function1<JavaMethod, Boolean> methodFilter = new ClassDeclaredMemberIndex$methodFilter$1(this);
    public final Map<Name, List<JavaMethod>> methods;

    public ClassDeclaredMemberIndex(JavaClass javaClass, Function1<? super JavaMember, Boolean> function1) {
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        Intrinsics.checkNotNullParameter(function1, "memberFilter");
        this.jClass = javaClass;
        this.memberFilter = function1;
        Sequence filter = TypeUtilsKt.filter(ArraysKt___ArraysJvmKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FilteringSequence$iterator$1 filteringSequence$iterator$1 = new FilteringSequence$iterator$1((FilteringSequence) filter);
        while (filteringSequence$iterator$1.hasNext()) {
            Object next = filteringSequence$iterator$1.next();
            Name name = ((JavaMethod) next).getName();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add(next);
        }
        this.methods = linkedHashMap;
        Sequence filter2 = TypeUtilsKt.filter(ArraysKt___ArraysJvmKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        FilteringSequence$iterator$1 filteringSequence$iterator$12 = new FilteringSequence$iterator$1((FilteringSequence) filter2);
        while (filteringSequence$iterator$12.hasNext()) {
            Object next2 = filteringSequence$iterator$12.next();
            linkedHashMap2.put(((JavaField) next2).getName(), next2);
        }
        this.fields = linkedHashMap2;
        Collection<JavaRecordComponent> recordComponents = this.jClass.getRecordComponents();
        Function1<JavaMember, Boolean> function12 = this.memberFilter;
        ArrayList arrayList = new ArrayList();
        for (T next3 : recordComponents) {
            if (((Boolean) function12.invoke(next3)).booleanValue()) {
                arrayList.add(next3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(arrayList, 10)) < 16 ? 16 : TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(arrayList, 10)));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next4 = it.next();
            linkedHashMap3.put(((JavaRecordComponent) next4).getName(), next4);
        }
        this.components = linkedHashMap3;
    }

    public JavaField findFieldByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.fields.get(name);
    }

    public Collection<JavaMethod> findMethodsByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = this.methods.get(name);
        return list == null ? EmptyList.INSTANCE : list;
    }

    public JavaRecordComponent findRecordComponentByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.components.get(name);
    }

    public Set<Name> getFieldNames() {
        Sequence filter = TypeUtilsKt.filter(ArraysKt___ArraysJvmKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        FilteringSequence$iterator$1 filteringSequence$iterator$1 = new FilteringSequence$iterator$1((FilteringSequence) filter);
        while (filteringSequence$iterator$1.hasNext()) {
            linkedHashSet.add(((JavaNamedElement) filteringSequence$iterator$1.next()).getName());
        }
        return linkedHashSet;
    }

    public Set<Name> getMethodNames() {
        Sequence filter = TypeUtilsKt.filter(ArraysKt___ArraysJvmKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        FilteringSequence$iterator$1 filteringSequence$iterator$1 = new FilteringSequence$iterator$1((FilteringSequence) filter);
        while (filteringSequence$iterator$1.hasNext()) {
            linkedHashSet.add(((JavaNamedElement) filteringSequence$iterator$1.next()).getName());
        }
        return linkedHashSet;
    }

    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }
}
