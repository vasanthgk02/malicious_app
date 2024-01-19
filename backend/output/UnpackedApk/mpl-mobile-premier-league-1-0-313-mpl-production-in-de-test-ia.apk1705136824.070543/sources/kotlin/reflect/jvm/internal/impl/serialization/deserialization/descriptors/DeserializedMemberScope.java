package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.mpl.androidapp.login.LoginReactModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator$NameAndTypeMemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: DeserializedMemberScope.kt */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;

    /* renamed from: c  reason: collision with root package name */
    public final DeserializationContext f5951c;
    public final NotNullLazyValue classNames$delegate;
    public final NullableLazyValue classifierNamesLazy$delegate;
    public final Implementation impl;

    /* compiled from: DeserializedMemberScope.kt */
    public interface Implementation {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation);

        Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name name);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    /* compiled from: DeserializedMemberScope.kt */
    public final class NoReorderImplementation implements Implementation {
        public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        public final NotNullLazyValue allFunctions$delegate;
        public final NotNullLazyValue allProperties$delegate;
        public final NotNullLazyValue allTypeAliases$delegate;
        public final NotNullLazyValue declaredFunctions$delegate;
        public final NotNullLazyValue declaredProperties$delegate;
        public final List<ProtoBuf$Function> functionList;
        public final NotNullLazyValue functionNames$delegate;
        public final NotNullLazyValue functionsByName$delegate;
        public final NotNullLazyValue propertiesByName$delegate;
        public final List<ProtoBuf$Property> propertyList;
        public final /* synthetic */ DeserializedMemberScope this$0;
        public final List<ProtoBuf$TypeAlias> typeAliasList;
        public final NotNullLazyValue typeAliasesByName$delegate;
        public final NotNullLazyValue variableNames$delegate;

        static {
            Class<NoReorderImplementation> cls = NoReorderImplementation.class;
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allFunctions", "getAllFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allProperties", "getAllProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public NoReorderImplementation(DeserializedMemberScope deserializedMemberScope, List<ProtoBuf$Function> list, List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3) {
            Intrinsics.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics.checkNotNullParameter(list, "functionList");
            Intrinsics.checkNotNullParameter(list2, "propertyList");
            Intrinsics.checkNotNullParameter(list3, "typeAliasList");
            this.this$0 = deserializedMemberScope;
            this.functionList = list;
            this.propertyList = list2;
            this.typeAliasList = !this.this$0.f5951c.components.configuration.getTypeAliasesAllowed() ? EmptyList.INSTANCE : list3;
            this.declaredFunctions$delegate = this.this$0.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2(this));
            this.declaredProperties$delegate = this.this$0.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredProperties$2(this));
            this.allTypeAliases$delegate = this.this$0.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(this));
            this.allFunctions$delegate = this.this$0.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allFunctions$2(this));
            this.allProperties$delegate = this.this$0.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allProperties$2(this));
            this.typeAliasesByName$delegate = this.this$0.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(this));
            this.functionsByName$delegate = this.this$0.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionsByName$2(this));
            this.propertiesByName$delegate = this.this$0.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(this));
            DeserializedMemberScope deserializedMemberScope2 = this.this$0;
            this.functionNames$delegate = deserializedMemberScope2.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionNames$2(this, deserializedMemberScope2));
            DeserializedMemberScope deserializedMemberScope3 = this.this$0;
            this.variableNames$delegate = deserializedMemberScope3.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$NoReorderImplementation$variableNames$2(this, deserializedMemberScope3));
        }

        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(collection, LoginReactModule.RESULT);
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            Companion companion = DescriptorKindFilter.Companion;
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.VARIABLES_MASK)) {
                for (Object next : (List) TweetUtils.getValue(this.allProperties$delegate, $$delegatedProperties[4])) {
                    Name name = ((PropertyDescriptor) next).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    if (((Boolean) function1.invoke(name)).booleanValue()) {
                        collection.add(next);
                    }
                }
            }
            Companion companion2 = DescriptorKindFilter.Companion;
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.FUNCTIONS_MASK)) {
                for (Object next2 : (List) TweetUtils.getValue(this.allFunctions$delegate, $$delegatedProperties[3])) {
                    Name name2 = ((SimpleFunctionDescriptor) next2).getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                    if (((Boolean) function1.invoke(name2)).booleanValue()) {
                        collection.add(next2);
                    }
                }
            }
        }

        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!((Set) TweetUtils.getValue(this.functionNames$delegate, $$delegatedProperties[8])).contains(name)) {
                return EmptyList.INSTANCE;
            }
            Collection<SimpleFunctionDescriptor> collection = (Collection) ((Map) TweetUtils.getValue(this.functionsByName$delegate, $$delegatedProperties[6])).get(name);
            if (collection == null) {
                collection = EmptyList.INSTANCE;
            }
            return collection;
        }

        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!((Set) TweetUtils.getValue(this.variableNames$delegate, $$delegatedProperties[9])).contains(name)) {
                return EmptyList.INSTANCE;
            }
            Collection<PropertyDescriptor> collection = (Collection) ((Map) TweetUtils.getValue(this.propertiesByName$delegate, $$delegatedProperties[7])).get(name);
            if (collection == null) {
                collection = EmptyList.INSTANCE;
            }
            return collection;
        }

        public Set<Name> getFunctionNames() {
            return (Set) TweetUtils.getValue(this.functionNames$delegate, $$delegatedProperties[8]);
        }

        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return (TypeAliasDescriptor) ((Map) TweetUtils.getValue(this.typeAliasesByName$delegate, $$delegatedProperties[5])).get(name);
        }

        public Set<Name> getTypeAliasNames() {
            List<ProtoBuf$TypeAlias> list = this.typeAliasList;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            for (MessageLite messageLite : list) {
                linkedHashSet.add(TweetUtils.getName(deserializedMemberScope.f5951c.nameResolver, ((ProtoBuf$TypeAlias) messageLite).name_));
            }
            return linkedHashSet;
        }

        public Set<Name> getVariableNames() {
            return (Set) TweetUtils.getValue(this.variableNames$delegate, $$delegatedProperties[9]);
        }
    }

    /* compiled from: DeserializedMemberScope.kt */
    public final class OptimizedImplementation implements Implementation {
        public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        public final NotNullLazyValue functionNames$delegate;
        public final Map<Name, byte[]> functionProtosBytes;
        public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
        public final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
        public final Map<Name, byte[]> propertyProtosBytes;
        public final /* synthetic */ DeserializedMemberScope this$0;
        public final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
        public final Map<Name, byte[]> typeAliasBytes;
        public final NotNullLazyValue variableNames$delegate;

        static {
            Class<OptimizedImplementation> cls = OptimizedImplementation.class;
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public OptimizedImplementation(DeserializedMemberScope deserializedMemberScope, List<ProtoBuf$Function> list, List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3) {
            Map<Name, byte[]> map;
            Intrinsics.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics.checkNotNullParameter(list, "functionList");
            Intrinsics.checkNotNullParameter(list2, "propertyList");
            Intrinsics.checkNotNullParameter(list3, "typeAliasList");
            this.this$0 = deserializedMemberScope;
            DeserializedMemberScope deserializedMemberScope2 = this.this$0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T next : list) {
                Name name = TweetUtils.getName(deserializedMemberScope2.f5951c.nameResolver, ((ProtoBuf$Function) ((MessageLite) next)).name_);
                Object obj = linkedHashMap.get(name);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(name, obj);
                }
                ((List) obj).add(next);
            }
            this.functionProtosBytes = packToByteArray(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope3 = this.this$0;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (T next2 : list2) {
                Name name2 = TweetUtils.getName(deserializedMemberScope3.f5951c.nameResolver, ((ProtoBuf$Property) ((MessageLite) next2)).name_);
                Object obj2 = linkedHashMap2.get(name2);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap2.put(name2, obj2);
                }
                ((List) obj2).add(next2);
            }
            this.propertyProtosBytes = packToByteArray(linkedHashMap2);
            if (this.this$0.f5951c.components.configuration.getTypeAliasesAllowed()) {
                DeserializedMemberScope deserializedMemberScope4 = this.this$0;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (T next3 : list3) {
                    Name name3 = TweetUtils.getName(deserializedMemberScope4.f5951c.nameResolver, ((ProtoBuf$TypeAlias) ((MessageLite) next3)).name_);
                    Object obj3 = linkedHashMap3.get(name3);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap3.put(name3, obj3);
                    }
                    ((List) obj3).add(next3);
                }
                map = packToByteArray(linkedHashMap3);
            } else {
                map = ArraysKt___ArraysJvmKt.emptyMap();
            }
            this.typeAliasBytes = map;
            this.functions = this.this$0.f5951c.components.storageManager.createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$functions$1(this));
            this.properties = this.this$0.f5951c.components.storageManager.createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$properties$1(this));
            this.typeAliasByName = this.this$0.f5951c.components.storageManager.createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(this));
            DeserializedMemberScope deserializedMemberScope5 = this.this$0;
            this.functionNames$delegate = deserializedMemberScope5.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$functionNames$2(this, deserializedMemberScope5));
            DeserializedMemberScope deserializedMemberScope6 = this.this$0;
            this.variableNames$delegate = deserializedMemberScope6.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$variableNames$2(this, deserializedMemberScope6));
        }

        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(collection, LoginReactModule.RESULT);
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            Companion companion = DescriptorKindFilter.Companion;
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.VARIABLES_MASK)) {
                Set<Name> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (Name next : variableNames) {
                    if (((Boolean) function1.invoke(next)).booleanValue()) {
                        arrayList.addAll(getContributedVariables(next, lookupLocation));
                    }
                }
                MemberComparator$NameAndTypeMemberComparator memberComparator$NameAndTypeMemberComparator = MemberComparator$NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(memberComparator$NameAndTypeMemberComparator, "INSTANCE");
                TweetUtils.sortWith(arrayList, memberComparator$NameAndTypeMemberComparator);
                collection.addAll(arrayList);
            }
            Companion companion2 = DescriptorKindFilter.Companion;
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.FUNCTIONS_MASK)) {
                Set<Name> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (Name next2 : functionNames) {
                    if (((Boolean) function1.invoke(next2)).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(next2, lookupLocation));
                    }
                }
                MemberComparator$NameAndTypeMemberComparator memberComparator$NameAndTypeMemberComparator2 = MemberComparator$NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(memberComparator$NameAndTypeMemberComparator2, "INSTANCE");
                TweetUtils.sortWith(arrayList2, memberComparator$NameAndTypeMemberComparator2);
                collection.addAll(arrayList2);
            }
        }

        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!getFunctionNames().contains(name)) {
                return EmptyList.INSTANCE;
            }
            return (Collection) this.functions.invoke(name);
        }

        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!getVariableNames().contains(name)) {
                return EmptyList.INSTANCE;
            }
            return (Collection) this.properties.invoke(name);
        }

        public Set<Name> getFunctionNames() {
            return (Set) TweetUtils.getValue(this.functionNames$delegate, $$delegatedProperties[0]);
        }

        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return (TypeAliasDescriptor) this.typeAliasByName.invoke(name);
        }

        public Set<Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        public Set<Name> getVariableNames() {
            return (Set) TweetUtils.getValue(this.variableNames$delegate, $$delegatedProperties[1]);
        }

        public final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(TweetUtils.mapCapacity(map.size()));
            for (Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<AbstractMessageLite> iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
                for (AbstractMessageLite abstractMessageLite : iterable) {
                    int serializedSize = abstractMessageLite.getSerializedSize();
                    int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize;
                    if (computeRawVarint32Size > 4096) {
                        computeRawVarint32Size = 4096;
                    }
                    CodedOutputStream newInstance = CodedOutputStream.newInstance(byteArrayOutputStream, computeRawVarint32Size);
                    newInstance.writeRawVarint32(serializedSize);
                    abstractMessageLite.writeTo(newInstance);
                    newInstance.flush();
                    arrayList.add(Unit.INSTANCE);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }
    }

    static {
        Class<DeserializedMemberScope> cls = DeserializedMemberScope.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public DeserializedMemberScope(DeserializationContext deserializationContext, List<ProtoBuf$Function> list, List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3, Function0<? extends Collection<Name>> function0) {
        Implementation implementation;
        Intrinsics.checkNotNullParameter(deserializationContext, "c");
        Intrinsics.checkNotNullParameter(list, "functionList");
        Intrinsics.checkNotNullParameter(list2, "propertyList");
        Intrinsics.checkNotNullParameter(list3, "typeAliasList");
        Intrinsics.checkNotNullParameter(function0, "classNames");
        this.f5951c = deserializationContext;
        if (deserializationContext.components.configuration.getPreserveDeclarationsOrdering()) {
            implementation = new NoReorderImplementation(this, list, list2, list3);
        } else {
            implementation = new OptimizedImplementation(this, list, list2, list3);
        }
        this.impl = implementation;
        this.classNames$delegate = this.f5951c.components.storageManager.createLazyValue(new DeserializedMemberScope$classNames$2(function0));
        this.classifierNamesLazy$delegate = this.f5951c.components.storageManager.createNullableLazyValue(new DeserializedMemberScope$classifierNamesLazy$2(this));
    }

    public abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1);

    public final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        ArrayList arrayList = new ArrayList(0);
        Companion companion = DescriptorKindFilter.Companion;
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.SINGLETON_CLASSIFIERS_MASK)) {
            addEnumEntryDescriptors(arrayList, function1);
        }
        this.impl.addFunctionsAndPropertiesTo(arrayList, descriptorKindFilter, function1, lookupLocation);
        Companion companion2 = DescriptorKindFilter.Companion;
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.CLASSIFIERS_MASK)) {
            for (Name next : getClassNames$deserialization()) {
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    TypeUtilsKt.addIfNotNull(arrayList, this.f5951c.components.deserializeClass(createClassId(next)));
                }
            }
        }
        Companion companion3 = DescriptorKindFilter.Companion;
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.TYPE_ALIASES_MASK)) {
            for (Name next2 : this.impl.getTypeAliasNames()) {
                if (((Boolean) function1.invoke(next2)).booleanValue()) {
                    TypeUtilsKt.addIfNotNull(arrayList, this.impl.getTypeAliasByName(next2));
                }
            }
        }
        return TypeUtilsKt.compact(arrayList);
    }

    public void computeNonDeclaredFunctions(Name name, List<SimpleFunctionDescriptor> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "functions");
    }

    public void computeNonDeclaredProperties(Name name, List<PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "descriptors");
    }

    public abstract ClassId createClassId(Name name);

    public final Set<Name> getClassNames$deserialization() {
        return (Set) TweetUtils.getValue(this.classNames$delegate, $$delegatedProperties[0]);
    }

    public Set<Name> getClassifierNames() {
        NullableLazyValue nullableLazyValue = this.classifierNamesLazy$delegate;
        KProperty<Object> kProperty = $$delegatedProperties[1];
        Intrinsics.checkNotNullParameter(nullableLazyValue, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "p");
        return (Set) nullableLazyValue.invoke();
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (hasClass(name)) {
            return this.f5951c.components.deserializeClass(createClassId(name));
        }
        if (this.impl.getTypeAliasNames().contains(name)) {
            return this.impl.getTypeAliasByName(name);
        }
        return null;
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return this.impl.getContributedFunctions(name, lookupLocation);
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return this.impl.getContributedVariables(name, lookupLocation);
    }

    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    public abstract Set<Name> getNonDeclaredClassifierNames();

    public abstract Set<Name> getNonDeclaredFunctionNames();

    public abstract Set<Name> getNonDeclaredVariableNames();

    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    public boolean hasClass(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getClassNames$deserialization().contains(name);
    }

    public boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "function");
        return true;
    }
}
