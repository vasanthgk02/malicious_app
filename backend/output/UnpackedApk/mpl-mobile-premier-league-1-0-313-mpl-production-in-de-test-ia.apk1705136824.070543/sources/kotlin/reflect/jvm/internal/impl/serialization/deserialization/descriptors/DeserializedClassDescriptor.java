package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.WhenMappings;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeclarationDescriptor {
    public final Annotations annotations;

    /* renamed from: c  reason: collision with root package name */
    public final DeserializationContext f5950c;
    public final ClassId classId;
    public final ProtoBuf$Class classProto;
    public final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
    public final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
    public final DeclarationDescriptor containingDeclaration;
    public final EnumEntryClassDescriptors enumEntries;
    public final ClassKind kind;
    public final ScopesHolderForClass<DeserializedClassMemberScope> memberScopeHolder;
    public final BinaryVersion metadataVersion;
    public final Modality modality;
    public final NullableLazyValue<ClassConstructorDescriptor> primaryConstructor;
    public final NotNullLazyValue<Collection<ClassDescriptor>> sealedSubclasses;
    public final SourceElement sourceElement;
    public final MemberScopeImpl staticScope;
    public final Class thisAsProtoContainer;
    public final DeserializedClassTypeConstructor typeConstructor;
    public final DescriptorVisibility visibility;

    /* compiled from: DeserializedClassDescriptor.kt */
    public final class DeserializedClassMemberScope extends DeserializedMemberScope {
        public final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        public final KotlinTypeRefiner kotlinTypeRefiner;
        public final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;
        public final /* synthetic */ DeserializedClassDescriptor this$0;

        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DeserializedClassMemberScope(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r8, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r9) {
            /*
                r7 = this;
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.String r0 = "kotlinTypeRefiner"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                r7.this$0 = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r8.f5950c
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.classProto
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r3 = r0.function_
                java.lang.String r0 = "classProto.functionList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.classProto
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r4 = r0.property_
                java.lang.String r0 = "classProto.propertyList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.classProto
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r5 = r0.typeAlias_
                java.lang.String r0 = "classProto.typeAliasList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.classProto
                java.util.List<java.lang.Integer> r0 = r0.nestedClassName_
                java.lang.String r1 = "classProto.nestedClassNameList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r8.f5950c
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r8 = r8.nameResolver
                java.util.ArrayList r1 = new java.util.ArrayList
                r6 = 10
                int r6 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r0, r6)
                r1.<init>(r6)
                java.util.Iterator r0 = r0.iterator()
            L_0x0046:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L_0x005e
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                kotlin.reflect.jvm.internal.impl.name.Name r6 = com.twitter.sdk.android.tweetui.TweetUtils.getName(r8, r6)
                r1.add(r6)
                goto L_0x0046
            L_0x005e:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1
                r6.<init>(r1)
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                r7.kotlinTypeRefiner = r9
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.f5951c
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r8 = r8.components
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.storageManager
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1
                r9.<init>(r7)
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.allDescriptors = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.f5951c
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r8 = r8.components
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.storageManager
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1
                r9.<init>(r7)
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.refinedSupertypes = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner):void");
        }

        /* JADX WARNING: type inference failed for: r6v3 */
        /* JADX WARNING: type inference failed for: r6v4, types: [java.util.Collection] */
        /* JADX WARNING: type inference failed for: r6v5, types: [kotlin.collections.EmptyList] */
        /* JADX WARNING: type inference failed for: r6v6 */
        /* JADX WARNING: type inference failed for: r6v7 */
        /* JADX WARNING: type inference failed for: r6v8 */
        /* JADX WARNING: type inference failed for: r6v9 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void addEnumEntryDescriptors(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> r5, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> r6) {
            /*
                r4 = this;
                java.lang.String r0 = "result"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "nameFilter"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r6 = r4.this$0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors r6 = r6.enumEntries
                if (r6 != 0) goto L_0x0012
                r6 = 0
                goto L_0x0041
            L_0x0012:
                java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r0 = r6.enumEntryProtos
                java.util.Set r0 = r0.keySet()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Iterator r0 = r0.iterator()
            L_0x0021:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0040
                java.lang.Object r2 = r0.next()
                kotlin.reflect.jvm.internal.impl.name.Name r2 = (kotlin.reflect.jvm.internal.impl.name.Name) r2
                java.lang.String r3 = "name"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
                kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> r3 = r6.enumEntryByName
                java.lang.Object r2 = r3.invoke(r2)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
                if (r2 == 0) goto L_0x0021
                r1.add(r2)
                goto L_0x0021
            L_0x0040:
                r6 = r1
            L_0x0041:
                if (r6 == 0) goto L_0x0044
                goto L_0x0046
            L_0x0044:
                kotlin.collections.EmptyList r6 = kotlin.collections.EmptyList.INSTANCE
            L_0x0046:
                r5.addAll(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.addEnumEntryDescriptors(java.util.Collection, kotlin.jvm.functions.Function1):void");
        }

        public void computeNonDeclaredFunctions(Name name, List<SimpleFunctionDescriptor> list) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(list, "functions");
            ArrayList arrayList = new ArrayList();
            for (KotlinType memberScope : (Collection) this.refinedSupertypes.invoke()) {
                arrayList.addAll(memberScope.getMemberScope().getContributedFunctions(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            list.addAll(this.f5951c.components.additionalClassPartsProvider.getFunctions(name, this.this$0));
            generateFakeOverrides(name, arrayList, list);
        }

        public void computeNonDeclaredProperties(Name name, List<PropertyDescriptor> list) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (KotlinType memberScope : (Collection) this.refinedSupertypes.invoke()) {
                arrayList.addAll(memberScope.getMemberScope().getContributedVariables(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            generateFakeOverrides(name, arrayList, list);
        }

        public ClassId createClassId(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            ClassId createNestedClassId = this.this$0.classId.createNestedClassId(name);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId, "classId.createNestedClassId(name)");
            return createNestedClassId;
        }

        public final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name name, Collection<? extends D> collection, List<D> list) {
            Name name2 = name;
            Collection<? extends D> collection2 = collection;
            this.f5951c.components.kotlinTypeChecker.getOverridingUtil().generateOverridesInFunctionGroup(name2, collection2, new ArrayList(list), this.this$0, new DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(list));
        }

        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name, lookupLocation);
            EnumEntryClassDescriptors enumEntryClassDescriptors = this.this$0.enumEntries;
            if (enumEntryClassDescriptors != null) {
                Intrinsics.checkNotNullParameter(name, "name");
                ClassDescriptor classDescriptor = (ClassDescriptor) enumEntryClassDescriptors.enumEntryByName.invoke(name);
                if (classDescriptor != null) {
                    return classDescriptor;
                }
            }
            return super.getContributedClassifier(name, lookupLocation);
        }

        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            return (Collection) this.allDescriptors.invoke();
        }

        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name, lookupLocation);
            return super.getContributedFunctions(name, lookupLocation);
        }

        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name, lookupLocation);
            return super.getContributedVariables(name, lookupLocation);
        }

        public Set<Name> getNonDeclaredClassifierNames() {
            List<KotlinType> supertypes = this.this$0.typeConstructor.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : supertypes) {
                Set<Name> classifierNames = memberScope.getMemberScope().getClassifierNames();
                if (classifierNames == null) {
                    return null;
                }
                TweetUtils.addAll(linkedHashSet, classifierNames);
            }
            return linkedHashSet;
        }

        public Set<Name> getNonDeclaredFunctionNames() {
            List<KotlinType> supertypes = this.this$0.typeConstructor.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : supertypes) {
                TweetUtils.addAll(linkedHashSet, memberScope.getMemberScope().getFunctionNames());
            }
            linkedHashSet.addAll(this.f5951c.components.additionalClassPartsProvider.getFunctionsNames(this.this$0));
            return linkedHashSet;
        }

        public Set<Name> getNonDeclaredVariableNames() {
            List<KotlinType> supertypes = this.this$0.typeConstructor.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : supertypes) {
                TweetUtils.addAll(linkedHashSet, memberScope.getMemberScope().getVariableNames());
            }
            return linkedHashSet;
        }

        public boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "function");
            return this.f5951c.components.platformDependentDeclarationFilter.isFunctionAvailable(this.this$0, simpleFunctionDescriptor);
        }

        public void recordLookup(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            TweetUtils.record(this.f5951c.components.lookupTracker, lookupLocation, (ClassDescriptor) this.this$0, name);
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    public final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        public final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
        public final /* synthetic */ DeserializedClassDescriptor this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public DeserializedClassTypeConstructor(DeserializedClassDescriptor deserializedClassDescriptor) {
            // Intrinsics.checkNotNullParameter(deserializedClassDescriptor, "this$0");
            // this.this$0 = deserializedClassDescriptor;
            super(deserializedClassDescriptor.f5950c.components.storageManager);
            DeserializedClassDescriptor deserializedClassDescriptor2 = this.this$0;
            this.parameters = deserializedClassDescriptor2.f5950c.components.storageManager.createLazyValue(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(deserializedClassDescriptor2));
        }

        /* JADX WARNING: type inference failed for: r2v2, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>, java.util.Collection] */
        /* JADX WARNING: type inference failed for: r2v3 */
        /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.Iterable] */
        /* JADX WARNING: type inference failed for: r2v14, types: [java.util.ArrayList] */
        /* JADX WARNING: type inference failed for: r2v15 */
        /* JADX WARNING: type inference failed for: r2v16 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v15
          assigns: [?[OBJECT, ARRAY], java.util.ArrayList, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>]
          uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.Iterable, java.util.ArrayList, java.util.Collection]
          mth insns count: 85
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
         */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00f6  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00fe A[SYNTHETIC] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeSupertypes() {
            /*
                r8 = this;
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r0 = r8.this$0
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r1 = r0.classProto
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r0.f5950c
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r0 = r0.typeTable
                java.lang.String r2 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                java.lang.String r2 = "typeTable"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r2 = r1.supertype_
                boolean r3 = r2.isEmpty()
                r3 = r3 ^ 1
                r4 = 0
                if (r3 == 0) goto L_0x001f
                goto L_0x0020
            L_0x001f:
                r2 = r4
            L_0x0020:
                r3 = 10
                if (r2 != 0) goto L_0x0056
                java.util.List<java.lang.Integer> r1 = r1.supertypeId_
                java.lang.String r2 = "supertypeIdList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                java.util.ArrayList r2 = new java.util.ArrayList
                int r5 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r1, r3)
                r2.<init>(r5)
                java.util.Iterator r1 = r1.iterator()
            L_0x0039:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L_0x0056
                java.lang.Object r5 = r1.next()
                java.lang.Integer r5 = (java.lang.Integer) r5
                java.lang.String r6 = "it"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                int r5 = r5.intValue()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r5 = r0.get(r5)
                r2.add(r5)
                goto L_0x0039
            L_0x0056:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r0 = r8.this$0
                java.util.ArrayList r1 = new java.util.ArrayList
                int r5 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r2, r3)
                r1.<init>(r5)
                java.util.Iterator r2 = r2.iterator()
            L_0x0065:
                boolean r5 = r2.hasNext()
                if (r5 == 0) goto L_0x007d
                java.lang.Object r5 = r2.next()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type) r5
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r6 = r0.f5950c
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r6 = r6.typeDeserializer
                kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r6.type(r5)
                r1.add(r5)
                goto L_0x0065
            L_0x007d:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r0 = r8.this$0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r0.f5950c
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r2 = r2.components
                kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider r2 = r2.additionalClassPartsProvider
                java.util.Collection r0 = r2.getSupertypes(r0)
                java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r1, r0)
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Iterator r2 = r0.iterator()
            L_0x0096:
                boolean r5 = r2.hasNext()
                if (r5 == 0) goto L_0x00b8
                java.lang.Object r5 = r2.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r5.getConstructor()
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r5 = r5.getDeclarationDescriptor()
                boolean r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor
                if (r6 == 0) goto L_0x00b1
                kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$MockClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor) r5
                goto L_0x00b2
            L_0x00b1:
                r5 = r4
            L_0x00b2:
                if (r5 == 0) goto L_0x0096
                r1.add(r5)
                goto L_0x0096
            L_0x00b8:
                boolean r2 = r1.isEmpty()
                r2 = r2 ^ 1
                if (r2 == 0) goto L_0x0105
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r2 = r8.this$0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r5 = r2.f5950c
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r5 = r5.components
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r5 = r5.errorReporter
                java.util.ArrayList r6 = new java.util.ArrayList
                int r3 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r1, r3)
                r6.<init>(r3)
                java.util.Iterator r1 = r1.iterator()
            L_0x00d5:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x0102
                java.lang.Object r3 = r1.next()
                kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$MockClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor) r3
                kotlin.reflect.jvm.internal.impl.name.ClassId r7 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(r3)
                if (r7 != 0) goto L_0x00e9
            L_0x00e7:
                r7 = r4
                goto L_0x00f4
            L_0x00e9:
                kotlin.reflect.jvm.internal.impl.name.FqName r7 = r7.asSingleFqName()
                if (r7 != 0) goto L_0x00f0
                goto L_0x00e7
            L_0x00f0:
                java.lang.String r7 = r7.asString()
            L_0x00f4:
                if (r7 != 0) goto L_0x00fe
                kotlin.reflect.jvm.internal.impl.name.Name r3 = r3.getName()
                java.lang.String r7 = r3.asString()
            L_0x00fe:
                r6.add(r7)
                goto L_0x00d5
            L_0x0102:
                r5.reportIncompleteHierarchy(r2, r6)
            L_0x0105:
                java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassTypeConstructor.computeSupertypes():java.util.Collection");
        }

        public ClassDescriptor getDeclarationDescriptor() {
            return this.this$0;
        }

        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.parameters.invoke();
        }

        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return EMPTY.INSTANCE;
        }

        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            String str = this.this$0.getName().name;
            Intrinsics.checkNotNullExpressionValue(str, "name.toString()");
            return str;
        }

        /* renamed from: getDeclarationDescriptor  reason: collision with other method in class */
        public ClassifierDescriptor m971getDeclarationDescriptor() {
            return this.this$0;
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    public final class EnumEntryClassDescriptors {
        public final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        public final Map<Name, ProtoBuf$EnumEntry> enumEntryProtos;
        public final NotNullLazyValue<Set<Name>> enumMemberNames;
        public final /* synthetic */ DeserializedClassDescriptor this$0;

        public EnumEntryClassDescriptors(DeserializedClassDescriptor deserializedClassDescriptor) {
            Intrinsics.checkNotNullParameter(deserializedClassDescriptor, "this$0");
            this.this$0 = deserializedClassDescriptor;
            List<ProtoBuf$EnumEntry> list = this.this$0.classProto.enumEntry_;
            Intrinsics.checkNotNullExpressionValue(list, "classProto.enumEntryList");
            DeserializedClassDescriptor deserializedClassDescriptor2 = this.this$0;
            LinkedHashMap linkedHashMap = new LinkedHashMap(TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(list, 10)) < 16 ? 16 : TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(list, 10)));
            for (T next : list) {
                linkedHashMap.put(TweetUtils.getName(deserializedClassDescriptor2.f5950c.nameResolver, ((ProtoBuf$EnumEntry) next).name_), next);
            }
            this.enumEntryProtos = linkedHashMap;
            DeserializedClassDescriptor deserializedClassDescriptor3 = this.this$0;
            this.enumEntryByName = deserializedClassDescriptor3.f5950c.components.storageManager.createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this, deserializedClassDescriptor3));
            this.enumMemberNames = this.this$0.f5950c.components.storageManager.createLazyValue(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(this));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor(DeserializationContext deserializationContext, ProtoBuf$Class protoBuf$Class, NameResolver nameResolver, BinaryVersion binaryVersion, SourceElement sourceElement2) {
        int i;
        Modality modality2;
        ClassKind classKind;
        Annotations annotations2;
        // Intrinsics.checkNotNullParameter(deserializationContext, "outerContext");
        // Intrinsics.checkNotNullParameter(protoBuf$Class, "classProto");
        // Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        // Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        // Intrinsics.checkNotNullParameter(sourceElement2, "sourceElement");
        super(deserializationContext.components.storageManager, TweetUtils.getClassId(nameResolver, protoBuf$Class.fqName_).getShortClassName());
        this.classProto = protoBuf$Class;
        this.metadataVersion = binaryVersion;
        this.sourceElement = sourceElement2;
        this.classId = TweetUtils.getClassId(nameResolver, protoBuf$Class.fqName_);
        ProtoBuf$Modality protoBuf$Modality = (ProtoBuf$Modality) Flags.MODALITY.get(this.classProto.flags_);
        int i2 = -1;
        if (protoBuf$Modality == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[protoBuf$Modality.ordinal()];
        }
        if (i == 1) {
            modality2 = Modality.FINAL;
        } else if (i == 2) {
            modality2 = Modality.OPEN;
        } else if (i == 3) {
            modality2 = Modality.ABSTRACT;
        } else if (i != 4) {
            modality2 = Modality.FINAL;
        } else {
            modality2 = Modality.SEALED;
        }
        this.modality = modality2;
        this.visibility = TweetUtils.descriptorVisibility(ProtoEnumFlags.INSTANCE, (ProtoBuf$Visibility) Flags.VISIBILITY.get(this.classProto.flags_));
        Kind kind2 = (Kind) Flags.CLASS_KIND.get(this.classProto.flags_);
        switch (kind2 != null ? WhenMappings.$EnumSwitchMapping$3[kind2.ordinal()] : i2) {
            case 1:
                classKind = ClassKind.CLASS;
                break;
            case 2:
                classKind = ClassKind.INTERFACE;
                break;
            case 3:
                classKind = ClassKind.ENUM_CLASS;
                break;
            case 4:
                classKind = ClassKind.ENUM_ENTRY;
                break;
            case 5:
                classKind = ClassKind.ANNOTATION_CLASS;
                break;
            case 6:
            case 7:
                classKind = ClassKind.OBJECT;
                break;
            default:
                classKind = ClassKind.CLASS;
                break;
        }
        this.kind = classKind;
        List<ProtoBuf$TypeParameter> list = this.classProto.typeParameter_;
        Intrinsics.checkNotNullExpressionValue(list, "classProto.typeParameterList");
        ProtoBuf$TypeTable protoBuf$TypeTable = this.classProto.typeTable_;
        Intrinsics.checkNotNullExpressionValue(protoBuf$TypeTable, "classProto.typeTable");
        TypeTable typeTable = new TypeTable(protoBuf$TypeTable);
        Companion companion = VersionRequirementTable.Companion;
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = this.classProto.versionRequirementTable_;
        Intrinsics.checkNotNullExpressionValue(protoBuf$VersionRequirementTable, "classProto.versionRequirementTable");
        this.f5950c = deserializationContext.childContext(this, list, nameResolver, typeTable, companion.create(protoBuf$VersionRequirementTable), this.metadataVersion);
        this.staticScope = this.kind == ClassKind.ENUM_CLASS ? new StaticScopeForKotlinEnum(this.f5950c.components.storageManager, this) : Empty.INSTANCE;
        this.typeConstructor = new DeserializedClassTypeConstructor(this);
        ScopesHolderForClass scopesHolderForClass = ScopesHolderForClass.Companion;
        DeserializationComponents deserializationComponents = this.f5950c.components;
        this.memberScopeHolder = ScopesHolderForClass.create(this, deserializationComponents.storageManager, deserializationComponents.kotlinTypeChecker.getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        this.enumEntries = this.kind == ClassKind.ENUM_CLASS ? new EnumEntryClassDescriptors(this) : null;
        this.containingDeclaration = deserializationContext.containingDeclaration;
        this.primaryConstructor = this.f5950c.components.storageManager.createNullableLazyValue(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.constructors = this.f5950c.components.storageManager.createLazyValue(new DeserializedClassDescriptor$constructors$1(this));
        this.companionObjectDescriptor = this.f5950c.components.storageManager.createNullableLazyValue(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.sealedSubclasses = this.f5950c.components.storageManager.createLazyValue(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        ProtoBuf$Class protoBuf$Class2 = this.classProto;
        DeserializationContext deserializationContext2 = this.f5950c;
        NameResolver nameResolver2 = deserializationContext2.nameResolver;
        TypeTable typeTable2 = deserializationContext2.typeTable;
        SourceElement sourceElement3 = this.sourceElement;
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        DeserializedClassDescriptor deserializedClassDescriptor = declarationDescriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) declarationDescriptor : null;
        Class classR = new Class(protoBuf$Class2, nameResolver2, typeTable2, sourceElement3, deserializedClassDescriptor == null ? null : deserializedClassDescriptor.thisAsProtoContainer);
        this.thisAsProtoContainer = classR;
        if (Flags.HAS_ANNOTATIONS.get(this.classProto.flags_).booleanValue()) {
            annotations2 = new NonEmptyDeserializedAnnotations(this.f5950c.components.storageManager, new DeserializedClassDescriptor$annotations$1(this));
        } else if (Annotations.Companion != null) {
            annotations2 = Annotations.Companion.EMPTY;
        } else {
            throw null;
        }
        this.annotations = annotations2;
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) this.companionObjectDescriptor.invoke();
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        return (Collection) this.constructors.invoke();
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.f5950c.typeDeserializer.getOwnTypeParameters();
    }

    public ClassKind getKind() {
        return this.kind;
    }

    public Modality getModality() {
        return this.modality;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        return (Collection) this.sealedSubclasses.invoke();
    }

    public SourceElement getSource() {
        return this.sourceElement;
    }

    public MemberScope getStaticScope() {
        return this.staticScope;
    }

    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScopeHolder.getScope(kotlinTypeRefiner);
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) this.primaryConstructor.invoke();
    }

    public DescriptorVisibility getVisibility() {
        return this.visibility;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return Flags.CLASS_KIND.get(this.classProto.flags_) == Kind.COMPANION_OBJECT;
    }

    public boolean isData() {
        return GeneratedOutlineSupport.outline108(Flags.IS_DATA, this.classProto.flags_, "IS_DATA.get(classProto.flags)");
    }

    public boolean isExpect() {
        return GeneratedOutlineSupport.outline108(Flags.IS_EXPECT_CLASS, this.classProto.flags_, "IS_EXPECT_CLASS.get(classProto.flags)");
    }

    public boolean isExternal() {
        return GeneratedOutlineSupport.outline108(Flags.IS_EXTERNAL_CLASS, this.classProto.flags_, "IS_EXTERNAL_CLASS.get(classProto.flags)");
    }

    public boolean isFun() {
        return GeneratedOutlineSupport.outline108(Flags.IS_FUN_INTERFACE, this.classProto.flags_, "IS_FUN_INTERFACE.get(classProto.flags)");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r0.patch <= 1) goto L_0x0027;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isInline() {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE_CLASS
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r1 = r5.classProto
            int r1 = r1.flags_
            java.lang.String r2 = "IS_INLINE_CLASS.get(classProto.flags)"
            boolean r0 = com.android.tools.r8.GeneratedOutlineSupport.outline108(r0, r1, r2)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x002d
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r0 = r5.metadataVersion
            r3 = 4
            int r4 = r0.major
            if (r4 >= r2) goto L_0x0018
            goto L_0x0027
        L_0x0018:
            if (r4 <= r2) goto L_0x001b
            goto L_0x0029
        L_0x001b:
            int r4 = r0.minor
            if (r4 >= r3) goto L_0x0020
            goto L_0x0027
        L_0x0020:
            if (r4 <= r3) goto L_0x0023
            goto L_0x0029
        L_0x0023:
            int r0 = r0.patch
            if (r0 > r2) goto L_0x0029
        L_0x0027:
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            if (r0 == 0) goto L_0x002d
            r1 = 1
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.isInline():boolean");
    }

    public boolean isInner() {
        return GeneratedOutlineSupport.outline108(Flags.IS_INNER, this.classProto.flags_, "IS_INNER.get(classProto.flags)");
    }

    public boolean isValue() {
        return GeneratedOutlineSupport.outline108(Flags.IS_INLINE_CLASS, this.classProto.flags_, "IS_INLINE_CLASS.get(classProto.flags)") && this.metadataVersion.isAtLeast(1, 4, 2);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("deserialized ");
        outline73.append(isExpect() ? "expect " : "");
        outline73.append("class ");
        outline73.append(getName());
        return outline73.toString();
    }
}
