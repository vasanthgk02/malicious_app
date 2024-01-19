package kotlin.reflect.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.ReflectLambdaKt$reflect$descriptor$1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public class ReflectionFactoryImpl extends ReflectionFactory {
    public static KDeclarationContainerImpl getOwner(CallableReference callableReference) {
        KDeclarationContainer owner = callableReference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : EmptyContainerForLocal.INSTANCE;
    }

    public KFunction function(FunctionReference functionReference) {
        KDeclarationContainerImpl owner = getOwner(functionReference);
        String name = functionReference.getName();
        String signature = functionReference.getSignature();
        Object boundReceiver = functionReference.getBoundReceiver();
        Intrinsics.checkNotNullParameter(owner, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        KFunctionImpl kFunctionImpl = new KFunctionImpl(owner, name, signature, null, boundReceiver);
        return kFunctionImpl;
    }

    public KClass getOrCreateKotlinClass(Class cls) {
        return KClassCacheKt.getOrCreateKotlinClass(cls);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new KPackageImpl(cls, str);
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return new KMutableProperty0Impl(getOwner(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return new KMutableProperty1Impl(getOwner(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    public KProperty0 property0(PropertyReference0 propertyReference0) {
        return new KProperty0Impl(getOwner(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    public KProperty1 property1(PropertyReference1 propertyReference1) {
        return new KProperty1Impl(getOwner(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    public String renderLambdaToString(FunctionBase functionBase) {
        Intrinsics.checkNotNullParameter(functionBase, "$this$reflect");
        Metadata metadata = (Metadata) functionBase.getClass().getAnnotation(Metadata.class);
        KFunctionImpl kFunctionImpl = null;
        if (metadata != null) {
            String[] d1 = metadata.d1();
            boolean z = false;
            if (d1.length == 0) {
                d1 = null;
            }
            if (d1 != null) {
                Pair<JvmNameResolver, ProtoBuf$Function> readFunctionDataFrom = JvmProtoBufUtil.readFunctionDataFrom(d1, metadata.d2());
                JvmNameResolver jvmNameResolver = (JvmNameResolver) readFunctionDataFrom.first;
                ProtoBuf$Function protoBuf$Function = (ProtoBuf$Function) readFunctionDataFrom.second;
                int[] mv = metadata.mv();
                if ((metadata.xi() & 8) != 0) {
                    z = true;
                }
                JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(mv, z);
                Class<?> cls = functionBase.getClass();
                ProtoBuf$TypeTable protoBuf$TypeTable = protoBuf$Function.typeTable_;
                Intrinsics.checkNotNullExpressionValue(protoBuf$TypeTable, "proto.typeTable");
                SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) UtilKt.deserializeToDescriptor(cls, protoBuf$Function, jvmNameResolver, new TypeTable(protoBuf$TypeTable), jvmMetadataVersion, ReflectLambdaKt$reflect$descriptor$1.INSTANCE);
                if (simpleFunctionDescriptor != null) {
                    kFunctionImpl = new KFunctionImpl(EmptyContainerForLocal.INSTANCE, simpleFunctionDescriptor);
                }
            }
        }
        if (kFunctionImpl != null) {
            KFunctionImpl asKFunctionImpl = UtilKt.asKFunctionImpl(kFunctionImpl);
            if (asKFunctionImpl != null) {
                ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.INSTANCE;
                FunctionDescriptor descriptor = asKFunctionImpl.getDescriptor();
                Intrinsics.checkNotNullParameter(descriptor, "invoke");
                StringBuilder sb = new StringBuilder();
                ReflectionObjectRenderer reflectionObjectRenderer2 = ReflectionObjectRenderer.INSTANCE;
                ReflectionObjectRenderer.appendReceivers(sb, descriptor);
                List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "invoke.valueParameters");
                ArraysKt___ArraysJvmKt.joinTo$default(valueParameters, sb, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderLambda$1$1.INSTANCE, 48);
                sb.append(" -> ");
                KotlinType returnType = descriptor.getReturnType();
                Intrinsics.checkNotNull(returnType);
                Intrinsics.checkNotNullExpressionValue(returnType, "invoke.returnType!!");
                Intrinsics.checkNotNullParameter(returnType, "type");
                sb.append(ReflectionObjectRenderer.renderer.renderType(returnType));
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }
        return super.renderLambdaToString(functionBase);
    }

    public KType typeOf(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        Annotations annotations;
        Object obj;
        List emptyList = Collections.emptyList();
        Intrinsics.checkNotNullParameter(kClassifier, "$this$createType");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(emptyList, "annotations");
        KClassifierImpl kClassifierImpl = (KClassifierImpl) (!(kClassifier instanceof KClassifierImpl) ? null : kClassifier);
        if (kClassifierImpl != null) {
            ClassifierDescriptor descriptor = kClassifierImpl.getDescriptor();
            if (descriptor != null) {
                TypeConstructor typeConstructor = descriptor.getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
                List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
                if (parameters.size() == list.size()) {
                    if (emptyList.isEmpty()) {
                        if (Annotations.Companion != null) {
                            annotations = Companion.EMPTY;
                        } else {
                            throw null;
                        }
                    } else if (Annotations.Companion != null) {
                        annotations = Companion.EMPTY;
                    } else {
                        throw null;
                    }
                    Annotations annotations2 = annotations;
                    List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters2, "typeConstructor.parameters");
                    ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
                    int i = 0;
                    for (T next : list) {
                        int i2 = i + 1;
                        if (i >= 0) {
                            KTypeProjection kTypeProjection = (KTypeProjection) next;
                            KTypeImpl kTypeImpl = (KTypeImpl) kTypeProjection.type;
                            KotlinType kotlinType = kTypeImpl != null ? kTypeImpl.type : null;
                            KVariance kVariance = kTypeProjection.variance;
                            if (kVariance == null) {
                                TypeParameterDescriptor typeParameterDescriptor = parameters2.get(i);
                                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "parameters[index]");
                                obj = new StarProjectionImpl(typeParameterDescriptor);
                            } else {
                                int ordinal = kVariance.ordinal();
                                if (ordinal == 0) {
                                    Variance variance = Variance.INVARIANT;
                                    Intrinsics.checkNotNull(kotlinType);
                                    obj = new TypeProjectionImpl(variance, kotlinType);
                                } else if (ordinal == 1) {
                                    Variance variance2 = Variance.IN_VARIANCE;
                                    Intrinsics.checkNotNull(kotlinType);
                                    obj = new TypeProjectionImpl(variance2, kotlinType);
                                } else if (ordinal == 2) {
                                    Variance variance3 = Variance.OUT_VARIANCE;
                                    Intrinsics.checkNotNull(kotlinType);
                                    obj = new TypeProjectionImpl(variance3, kotlinType);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            arrayList.add(obj);
                            i = i2;
                        } else {
                            TweetUtils.throwIndexOverflow();
                            throw null;
                        }
                    }
                    return new KTypeImpl(KotlinTypeFactory.simpleType$default(annotations2, typeConstructor, arrayList, z, null, 16), null);
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Class declares ");
                outline73.append(parameters.size());
                outline73.append(" type parameters, but ");
                outline73.append(list.size());
                outline73.append(" were provided.");
                throw new IllegalArgumentException(outline73.toString());
            }
        }
        throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + kClassifier + " (" + kClassifier.getClass() + ')');
    }

    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((FunctionBase) lambda);
    }
}
