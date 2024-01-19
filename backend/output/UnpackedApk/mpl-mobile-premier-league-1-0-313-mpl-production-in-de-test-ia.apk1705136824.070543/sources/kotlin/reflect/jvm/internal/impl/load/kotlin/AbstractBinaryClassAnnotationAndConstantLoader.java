package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver.Companion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Package;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.CharsKt__CharKt;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> implements AnnotationAndConstantLoader<A, C> {
    public final KotlinClassFinder kotlinClassFinder;
    public final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, Storage<A, C>> storage;

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public enum PropertyRelatedElement {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class Storage<A, C> {
        public final Map<MemberSignature, List<A>> memberAnnotations;
        public final Map<MemberSignature, C> propertyConstants;

        public Storage(Map<MemberSignature, ? extends List<? extends A>> map, Map<MemberSignature, ? extends C> map2) {
            Intrinsics.checkNotNullParameter(map, "memberAnnotations");
            Intrinsics.checkNotNullParameter(map2, "propertyConstants");
            this.memberAnnotations = map;
            this.propertyConstants = map2;
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager storageManager, KotlinClassFinder kotlinClassFinder2) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinClassFinder2, "kotlinClassFinder");
        this.kotlinClassFinder = kotlinClassFinder2;
        this.storage = storageManager.createMemoizedFunction(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    public static final AnnotationArgumentVisitor access$loadAnnotationIfNotSpecial(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ClassId classId, SourceElement sourceElement, List list) {
        if (abstractBinaryClassAnnotationAndConstantLoader != null) {
            SpecialJvmAnnotations specialJvmAnnotations = SpecialJvmAnnotations.INSTANCE;
            if (SpecialJvmAnnotations.SPECIAL_ANNOTATIONS.contains(classId)) {
                return null;
            }
            return abstractBinaryClassAnnotationAndConstantLoader.loadAnnotation(classId, sourceElement, list);
        }
        throw null;
    }

    public static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.findClassAndLoadMemberAnnotations(protoContainer, memberSignature, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z3);
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.getCallableSignature(messageLite, nameResolver, typeTable, annotatedCallableKind, (i & 16) != 0 ? false : z);
    }

    public static /* synthetic */ MemberSignature getPropertySignature$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, TypeTable typeTable, boolean z, boolean z2, boolean z3, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.getPropertySignature(protoBuf$Property, nameResolver, typeTable, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? true : z3);
    }

    public final List<A> findClassAndLoadMemberAnnotations(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3) {
        KotlinJvmBinaryClass specialCaseContainerClass = getSpecialCaseContainerClass(protoContainer, z, z2, bool, z3);
        if (specialCaseContainerClass == null) {
            specialCaseContainerClass = protoContainer instanceof Class ? toBinaryClass((Class) protoContainer) : null;
        }
        if (specialCaseContainerClass == null) {
            return EmptyList.INSTANCE;
        }
        List<A> list = ((Storage) this.storage.invoke(specialCaseContainerClass)).memberAnnotations.get(memberSignature);
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        return list;
    }

    public final MemberSignature getCallableSignature(MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z) {
        MemberSignature memberSignature = null;
        if (messageLite instanceof ProtoBuf$Constructor) {
            Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf$Constructor) messageLite, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            memberSignature = MemberSignature.fromJvmMemberSignature(jvmConstructorSignature);
        } else if (messageLite instanceof ProtoBuf$Function) {
            Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf$Function) messageLite, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            memberSignature = MemberSignature.fromJvmMemberSignature(jvmMethodSignature);
        } else if (messageLite instanceof ProtoBuf$Property) {
            GeneratedExtension<ProtoBuf$Property, JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
            JvmPropertySignature jvmPropertySignature = (JvmPropertySignature) TweetUtils.getExtensionOrNull((ExtendableMessage) messageLite, generatedExtension);
            if (jvmPropertySignature == null) {
                return null;
            }
            int ordinal = annotatedCallableKind.ordinal();
            if (ordinal == 1) {
                memberSignature = getPropertySignature((ProtoBuf$Property) messageLite, nameResolver, typeTable, true, true, z);
            } else if (ordinal != 2) {
                if (ordinal == 3 && jvmPropertySignature.hasSetter()) {
                    JvmMethodSignature jvmMethodSignature2 = jvmPropertySignature.setter_;
                    Intrinsics.checkNotNullExpressionValue(jvmMethodSignature2, "signature.setter");
                    memberSignature = MemberSignature.fromMethod(nameResolver, jvmMethodSignature2);
                }
            } else if (jvmPropertySignature.hasGetter()) {
                JvmMethodSignature jvmMethodSignature3 = jvmPropertySignature.getter_;
                Intrinsics.checkNotNullExpressionValue(jvmMethodSignature3, "signature.getter");
                memberSignature = MemberSignature.fromMethod(nameResolver, jvmMethodSignature3);
            }
        }
        return memberSignature;
    }

    public final MemberSignature getPropertySignature(ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, TypeTable typeTable, boolean z, boolean z2, boolean z3) {
        GeneratedExtension<ProtoBuf$Property, JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
        JvmPropertySignature jvmPropertySignature = (JvmPropertySignature) TweetUtils.getExtensionOrNull(protoBuf$Property, generatedExtension);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z) {
            Field jvmFieldSignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(protoBuf$Property, nameResolver, typeTable, z3);
            if (jvmFieldSignature == null) {
                return null;
            }
            return MemberSignature.fromJvmMemberSignature(jvmFieldSignature);
        }
        if (z2) {
            if ((jvmPropertySignature.bitField0_ & 2) == 2) {
                JvmMethodSignature jvmMethodSignature = jvmPropertySignature.syntheticMethod_;
                Intrinsics.checkNotNullExpressionValue(jvmMethodSignature, "signature.syntheticMethod");
                return MemberSignature.fromMethod(nameResolver, jvmMethodSignature);
            }
        }
        return null;
    }

    public final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer protoContainer, boolean z, boolean z2, Boolean bool, boolean z3) {
        JvmClassName jvmClassName;
        if (z) {
            if (bool != null) {
                if (protoContainer instanceof Class) {
                    Class classR = (Class) protoContainer;
                    if (classR.kind == Kind.INTERFACE) {
                        KotlinClassFinder kotlinClassFinder2 = this.kotlinClassFinder;
                        ClassId createNestedClassId = classR.classId.createNestedClassId(Name.identifier("DefaultImpls"));
                        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                        return TweetUtils.findKotlinClass(kotlinClassFinder2, createNestedClassId);
                    }
                }
                if (bool.booleanValue() && (protoContainer instanceof Package)) {
                    SourceElement sourceElement = protoContainer.source;
                    JvmPackagePartSource jvmPackagePartSource = sourceElement instanceof JvmPackagePartSource ? (JvmPackagePartSource) sourceElement : null;
                    if (jvmPackagePartSource == null) {
                        jvmClassName = null;
                    } else {
                        jvmClassName = jvmPackagePartSource.facadeClassName;
                    }
                    if (jvmClassName != null) {
                        KotlinClassFinder kotlinClassFinder3 = this.kotlinClassFinder;
                        String internalName = jvmClassName.getInternalName();
                        Intrinsics.checkNotNullExpressionValue(internalName, "facadeClassName.internalName");
                        ClassId classId = ClassId.topLevel(new FqName(CharsKt__CharKt.replace$default(internalName, '/', '.', false, 4)));
                        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                        return TweetUtils.findKotlinClass(kotlinClassFinder3, classId);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + protoContainer + ')').toString());
            }
        }
        if (z2 && (protoContainer instanceof Class)) {
            Class classR2 = (Class) protoContainer;
            if (classR2.kind == Kind.COMPANION_OBJECT) {
                Class classR3 = classR2.outerClass;
                if (classR3 != null) {
                    Kind kind = classR3.kind;
                    if (kind == Kind.CLASS || kind == Kind.ENUM_CLASS || (z3 && (kind == Kind.INTERFACE || kind == Kind.ANNOTATION_CLASS))) {
                        return toBinaryClass(classR3);
                    }
                }
            }
        }
        if (protoContainer instanceof Package) {
            SourceElement sourceElement2 = protoContainer.source;
            if (sourceElement2 instanceof JvmPackagePartSource) {
                if (sourceElement2 != null) {
                    JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) sourceElement2;
                    KotlinJvmBinaryClass kotlinJvmBinaryClass = jvmPackagePartSource2.knownJvmBinaryClass;
                    if (kotlinJvmBinaryClass == null) {
                        kotlinJvmBinaryClass = TweetUtils.findKotlinClass(this.kotlinClassFinder, jvmPackagePartSource2.getClassId());
                    }
                    return kotlinJvmBinaryClass;
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            }
        }
        return null;
    }

    public abstract AnnotationArgumentVisitor loadAnnotation(ClassId classId, SourceElement sourceElement, List<A> list);

    public List<A> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return loadPropertyAnnotations(protoContainer, (ProtoBuf$Property) messageLite, PropertyRelatedElement.PROPERTY);
        }
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.nameResolver, protoContainer.typeTable, annotatedCallableKind, false, 16, null);
        if (callableSignature$default == null) {
            return EmptyList.INSTANCE;
        }
        return findClassAndLoadMemberAnnotations$default(this, protoContainer, callableSignature$default, false, false, null, false, 60, null);
    }

    public List<A> loadClassAnnotations(Class classR) {
        Intrinsics.checkNotNullParameter(classR, "container");
        KotlinJvmBinaryClass binaryClass = toBinaryClass(classR);
        if (binaryClass != null) {
            ArrayList arrayList = new ArrayList(1);
            AbstractBinaryClassAnnotationAndConstantLoader$loadClassAnnotations$1 abstractBinaryClassAnnotationAndConstantLoader$loadClassAnnotations$1 = new AbstractBinaryClassAnnotationAndConstantLoader$loadClassAnnotations$1(this, arrayList);
            Intrinsics.checkNotNullParameter(binaryClass, "kotlinClass");
            binaryClass.loadClassAnnotations(abstractBinaryClassAnnotationAndConstantLoader$loadClassAnnotations$1, null);
            return arrayList;
        }
        FqName asSingleFqName = classR.classId.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "classId.asSingleFqName()");
        throw new IllegalStateException(Intrinsics.stringPlus("Class for loading annotations is not found: ", asSingleFqName).toString());
    }

    public List<A> loadEnumEntryAnnotations(ProtoContainer protoContainer, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(protoBuf$EnumEntry, "proto");
        String string = protoContainer.nameResolver.getString(protoBuf$EnumEntry.name_);
        ClassMapperLite classMapperLite = ClassMapperLite.INSTANCE;
        String asString = ((Class) protoContainer).classId.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "container as ProtoContainer.Class).classId.asString()");
        String mapClass = ClassMapperLite.mapClass(asString);
        Intrinsics.checkNotNullParameter(string, "name");
        Intrinsics.checkNotNullParameter(mapClass, "desc");
        return findClassAndLoadMemberAnnotations$default(this, protoContainer, new MemberSignature(string + '#' + mapClass, null), false, false, null, false, 60, null);
    }

    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.nameResolver, protoContainer.typeTable, annotatedCallableKind, false, 16, null);
        if (callableSignature$default == null) {
            return EmptyList.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(callableSignature$default, "signature");
        return findClassAndLoadMemberAnnotations$default(this, protoContainer, new MemberSignature(callableSignature$default.signature + '@' + 0, null), false, false, null, false, 60, null);
    }

    public final List<A> loadPropertyAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property, PropertyRelatedElement propertyRelatedElement) {
        ProtoContainer protoContainer2 = protoContainer;
        PropertyRelatedElement propertyRelatedElement2 = propertyRelatedElement;
        boolean outline108 = GeneratedOutlineSupport.outline108(Flags.IS_CONST, protoBuf$Property.flags_, "IS_CONST.get(proto.flags)");
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
        boolean isMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(protoBuf$Property);
        if (propertyRelatedElement2 == PropertyRelatedElement.PROPERTY) {
            MemberSignature propertySignature$default = getPropertySignature$default(this, protoBuf$Property, protoContainer2.nameResolver, protoContainer2.typeTable, false, true, false, 40, null);
            if (propertySignature$default == null) {
                return EmptyList.INSTANCE;
            }
            return findClassAndLoadMemberAnnotations$default(this, protoContainer, propertySignature$default, true, false, Boolean.valueOf(outline108), isMovedFromInterfaceCompanion, 8, null);
        }
        MemberSignature propertySignature$default2 = getPropertySignature$default(this, protoBuf$Property, protoContainer2.nameResolver, protoContainer2.typeTable, true, false, false, 48, null);
        if (propertySignature$default2 == null) {
            return EmptyList.INSTANCE;
        }
        boolean z = false;
        boolean contains$default = CharsKt__CharKt.contains$default((CharSequence) propertySignature$default2.signature, (CharSequence) "$delegate", false, 2);
        if (propertyRelatedElement2 == PropertyRelatedElement.DELEGATE_FIELD) {
            z = true;
        }
        if (contains$default != z) {
            return EmptyList.INSTANCE;
        }
        return findClassAndLoadMemberAnnotations(protoContainer, propertySignature$default2, true, true, Boolean.valueOf(outline108), isMovedFromInterfaceCompanion);
    }

    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(protoBuf$Property, "proto");
        return loadPropertyAnnotations(protoContainer, protoBuf$Property, PropertyRelatedElement.BACKING_FIELD);
    }

    public C loadPropertyConstant(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property, KotlinType kotlinType) {
        C uLongValue;
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(protoBuf$Property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        Boolean bool = Flags.IS_CONST.get(protoBuf$Property.flags_);
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
        KotlinJvmBinaryClass specialCaseContainerClass = getSpecialCaseContainerClass(protoContainer, true, true, bool, JvmProtoBufUtil.isMovedFromInterfaceCompanion(protoBuf$Property));
        if (specialCaseContainerClass == null) {
            specialCaseContainerClass = protoContainer instanceof Class ? toBinaryClass((Class) protoContainer) : null;
        }
        if (specialCaseContainerClass == null) {
            return null;
        }
        JvmMetadataVersion jvmMetadataVersion = specialCaseContainerClass.getClassHeader().metadataVersion;
        Companion companion = DeserializedDescriptorResolver.Companion;
        JvmMetadataVersion jvmMetadataVersion2 = DeserializedDescriptorResolver.KOTLIN_1_3_RC_METADATA_VERSION;
        if (jvmMetadataVersion != null) {
            Intrinsics.checkNotNullParameter(jvmMetadataVersion2, "version");
            MemberSignature callableSignature = getCallableSignature(protoBuf$Property, protoContainer.nameResolver, protoContainer.typeTable, AnnotatedCallableKind.PROPERTY, jvmMetadataVersion.isAtLeast(jvmMetadataVersion2.major, jvmMetadataVersion2.minor, jvmMetadataVersion2.patch));
            if (callableSignature == null) {
                return null;
            }
            C c2 = ((Storage) this.storage.invoke(specialCaseContainerClass)).propertyConstants.get(callableSignature);
            if (c2 == null) {
                return null;
            }
            UnsignedTypes unsignedTypes = UnsignedTypes.INSTANCE;
            if (UnsignedTypes.isUnsignedType(kotlinType)) {
                c2 = (ConstantValue) c2;
                Intrinsics.checkNotNullParameter(c2, "constant");
                if (c2 instanceof ByteValue) {
                    uLongValue = new UByteValue(((Number) ((ByteValue) c2).value).byteValue());
                } else if (c2 instanceof ShortValue) {
                    uLongValue = new UShortValue(((Number) ((ShortValue) c2).value).shortValue());
                } else if (c2 instanceof IntValue) {
                    uLongValue = new UIntValue(((Number) ((IntValue) c2).value).intValue());
                } else if (c2 instanceof LongValue) {
                    uLongValue = new ULongValue(((Number) ((LongValue) c2).value).longValue());
                }
                c2 = uLongValue;
            }
            return c2;
        }
        throw null;
    }

    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(protoBuf$Property, "proto");
        return loadPropertyAnnotations(protoContainer, protoBuf$Property, PropertyRelatedElement.DELEGATE_FIELD);
    }

    public List<A> loadTypeAnnotations(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(protoBuf$Type, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = protoBuf$Type.getExtension(JvmProtoBuf.typeAnnotation);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            Intrinsics.checkNotNullExpressionValue(protoBuf$Annotation, "it");
            Intrinsics.checkNotNullParameter(protoBuf$Annotation, "proto");
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            arrayList.add(((BinaryClassAnnotationAndConstantLoaderImpl) this).annotationDeserializer.deserializeAnnotation(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    public List<A> loadTypeParameterAnnotations(ProtoBuf$TypeParameter protoBuf$TypeParameter, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(protoBuf$TypeParameter, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = protoBuf$TypeParameter.getExtension(JvmProtoBuf.typeParameterAnnotation);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            Intrinsics.checkNotNullExpressionValue(protoBuf$Annotation, "it");
            Intrinsics.checkNotNullParameter(protoBuf$Annotation, "proto");
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            arrayList.add(((BinaryClassAnnotationAndConstantLoaderImpl) this).annotationDeserializer.deserializeAnnotation(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r11.isInner != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0030, code lost:
        if (com.twitter.sdk.android.tweetui.TweetUtils.hasReceiver((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r11) != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        if (com.twitter.sdk.android.tweetui.TweetUtils.hasReceiver((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property) r11) != false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<A> loadValueParameterAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer r10, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r12, int r13, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r14) {
        /*
            r9 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "callableProto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "kind"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r3 = r10.nameResolver
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r4 = r10.typeTable
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r9
            r2 = r11
            r5 = r12
            kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature r12 = getCallableSignature$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 == 0) goto L_0x0096
            boolean r14 = r11 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function
            r0 = 1
            if (r14 == 0) goto L_0x0033
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r11 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r11
            boolean r11 = com.twitter.sdk.android.tweetui.TweetUtils.hasReceiver(r11)
            if (r11 == 0) goto L_0x0054
            goto L_0x0055
        L_0x0033:
            boolean r14 = r11 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property
            if (r14 == 0) goto L_0x0040
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r11 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property) r11
            boolean r11 = com.twitter.sdk.android.tweetui.TweetUtils.hasReceiver(r11)
            if (r11 == 0) goto L_0x0054
            goto L_0x0055
        L_0x0040:
            boolean r14 = r11 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor
            if (r14 == 0) goto L_0x0086
            r11 = r10
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer$Class r11 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) r11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r14 = r11.kind
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.Kind.ENUM_CLASS
            if (r14 != r1) goto L_0x004f
            r0 = 2
            goto L_0x0055
        L_0x004f:
            boolean r11 = r11.isInner
            if (r11 == 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            int r13 = r13 + r0
            java.lang.String r11 = "signature"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r11)
            kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature r2 = new kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r12.signature
            r11.append(r12)
            r12 = 64
            r11.append(r12)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            r12 = 0
            r2.<init>(r11, r12)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 60
            r8 = 0
            r0 = r9
            r1 = r10
            java.util.List r10 = findClassAndLoadMemberAnnotations$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            return r10
        L_0x0086:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.Class r11 = r11.getClass()
            java.lang.String r12 = "Unsupported message: "
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r11)
            r10.<init>(r11)
            throw r10
        L_0x0096:
            kotlin.collections.EmptyList r10 = kotlin.collections.EmptyList.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadValueParameterAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind, int, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter):java.util.List");
    }

    public final KotlinJvmBinaryClass toBinaryClass(Class classR) {
        SourceElement sourceElement = classR.source;
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = sourceElement instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement) sourceElement : null;
        if (kotlinJvmBinarySourceElement == null) {
            return null;
        }
        return kotlinJvmBinarySourceElement.binaryClass;
    }
}
