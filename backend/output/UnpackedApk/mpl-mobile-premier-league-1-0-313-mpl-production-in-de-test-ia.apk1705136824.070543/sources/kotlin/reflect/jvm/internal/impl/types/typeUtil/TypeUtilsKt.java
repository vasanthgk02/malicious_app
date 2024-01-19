package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.amazon.identity.auth.device.api.authorization.Region;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import com.mpl.androidapp.login.LoginReactModule;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.LockSupport;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.utils.DFS$1;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;
import kotlin.reflect.jvm.internal.impl.utils.DFS$NodeHandler;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Visited;
import kotlin.reflect.jvm.internal.impl.utils.DFS$VisitedWithSet;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.DropSequence;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.EmptySequence;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.FlatteningSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt$flatten$1;
import kotlin.sequences.SequencesKt__SequencesKt$flatten$3;
import kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;
import kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1;
import kotlin.sequences.SequencesKt___SequencesKt$flatMap$2;
import kotlin.sequences.TransformingSequence;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.ScreenFloatValueRegEx;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Active;
import kotlinx.coroutines.BlockingCoroutine;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CompletedContinuation;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineContextKt$foldCopies$1;
import kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1;
import kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandlerImplKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.DispatchedCoroutine;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.DispatcherExecutor;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.LazyDeferredCoroutine;
import kotlinx.coroutines.LazyStandaloneCoroutine;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.UndispatchedMarker;
import kotlinx.coroutines.channels.ArrayChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.Channel.Factory;
import kotlinx.coroutines.channels.ConflatedChannel;
import kotlinx.coroutines.channels.LinkedListChannel;
import kotlinx.coroutines.channels.RendezvousChannel;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt__SerializersJvmKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextDescriptor;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.StructureKind.CLASS;
import kotlinx.serialization.descriptors.StructureKind.LIST;
import kotlinx.serialization.descriptors.StructureKind.MAP;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.InlineClassDescriptorKt$InlinePrimitiveDescriptor$1;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.NullableSerializer;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginHelperInterfacesKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.internal.AbstractJsonLexer;
import kotlinx.serialization.json.internal.CharMappings;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.JsonEncodingException;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModule;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONFunction;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONTokener;
import net.sf.json.util.JSONUtils;
import okio.Utf8;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.commons.net.ftp.FTPReply;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.BaseDateTimeField;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.opencv.android.StaticHelper;
import org.opencv.core.Core;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.anssi.ANSSINamedCurves;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.spongycastle.asn1.x9.X962NamedCurves;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.PolynomialExtensionField;
import org.spongycastle.util.BigIntegers;

/* compiled from: TypeUtils.kt */
public final class TypeUtilsKt {
    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
            default:
                objArr[0] = "nodes";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static final <T, E extends T> KSerializer<E[]> ArraySerializer(KClass<T> kClass, KSerializer<E> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "elementSerializer");
        return new ReferenceArraySerializer(kClass, kSerializer);
    }

    public static Channel Channel$default(int i, BufferOverflow bufferOverflow, Function1 function1, int i2) {
        boolean z = false;
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        int i3 = i2 & 4;
        int i4 = 1;
        if (i == -2) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                if (Channel.Factory != null) {
                    i4 = Factory.CHANNEL_DEFAULT_CAPACITY;
                } else {
                    throw null;
                }
            }
            return new ArrayChannel(i4, bufferOverflow, null);
        } else if (i == -1) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                z = true;
            }
            if (z) {
                return new ConflatedChannel(null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i != 0) {
            if (i == Integer.MAX_VALUE) {
                return new LinkedListChannel(null);
            }
            if (i == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new ConflatedChannel(null);
            }
            return new ArrayChannel(i, bufferOverflow, null);
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            return new RendezvousChannel(null);
        } else {
            return new ArrayChannel(1, bufferOverflow, null);
        }
    }

    public static final CoroutineScope CoroutineScope(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key) == null) {
            coroutineContext = coroutineContext.plus(new JobImpl(null));
        }
        return new ContextScope(coroutineContext);
    }

    public static final <T> SerialDescriptor InlinePrimitiveDescriptor(String str, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(kSerializer, "primitiveSerializer");
        return new InlineClassDescriptor(str, new InlineClassDescriptorKt$InlinePrimitiveDescriptor$1(kSerializer));
    }

    public static final JsonDecodingException InvalidFloatingPointDecoded(Number number, String str, String str2) {
        Intrinsics.checkNotNullParameter(number, HSLCriteriaBuilder.VALUE);
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "output");
        return JsonDecodingException(-1, "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + minify$default(str2, 0, 1));
    }

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number number, String str) {
        Intrinsics.checkNotNullParameter(number, HSLCriteriaBuilder.VALUE);
        Intrinsics.checkNotNullParameter(str, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + minify$default(str, 0, 1));
    }

    public static final JsonEncodingException InvalidKeyKindException(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "keyDescriptor");
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value of type '");
        outline73.append(serialDescriptor.getSerialName());
        outline73.append("' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '");
        outline73.append(serialDescriptor.getKind());
        outline73.append("'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
        return new JsonEncodingException(outline73.toString());
    }

    public static final JsonDecodingException JsonDecodingException(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (i >= 0) {
            str = "Unexpected JSON token at offset " + i + ": " + str;
        }
        return new JsonDecodingException(str);
    }

    public static final <T> KSerializer<List<T>> ListSerializer(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "elementSerializer");
        return new ArrayListSerializer(kSerializer);
    }

    public static final <K, V> KSerializer<Map<K, V>> MapSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        return new LinkedHashMapSerializer(kSerializer, kSerializer2);
    }

    public static final SerialDescriptor PrimitiveSerialDescriptor(String str, PrimitiveKind primitiveKind) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(primitiveKind, "kind");
        if (!CharsKt__CharKt.isBlank(str)) {
            return PrimitivesKt.PrimitiveDescriptorSafe(str, primitiveKind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static CompletableJob SupervisorJob$default(Job job, int i) {
        int i2 = i & 1;
        return new SupervisorJobImpl(null);
    }

    public static Region a(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("regionString cannot be null or empty");
        } else if ("AUTO".equals(str)) {
            return Region.AUTO;
        } else {
            if (AnalyticsConstants.NOT_AVAILABLE.equals(str)) {
                return Region.NA;
            }
            if ("EU".equals(str)) {
                return Region.EU;
            }
            if ("FE".equals(str)) {
                return Region.FE;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Undefined region for string: ", str));
        }
    }

    public static boolean a(Context context, List<String> list) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        boolean z = false;
        for (String packageInfo : list) {
            try {
                packageManager.getPackageInfo(packageInfo, 0);
                z = true;
            } catch (NameNotFoundException unused) {
            }
        }
        return z;
    }

    public static final void access$verify(Encoder encoder) {
        Intrinsics.checkNotNullParameter(encoder, "<this>");
        if ((encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null) == null) {
            throw new IllegalStateException(Intrinsics.stringPlus("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got ", Reflection.getOrCreateKotlinClass(encoder.getClass())));
        }
    }

    public static final <T> void addIfNotNull(Collection<T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        if (t != null) {
            collection.add(t);
        }
    }

    public static final <T> void appendElement(Appendable appendable, T t, Function1<? super T, ? extends CharSequence> function1) {
        boolean z;
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        if (function1 != null) {
            appendable.append((CharSequence) function1.invoke(t));
            return;
        }
        if (t == null) {
            z = true;
        } else {
            z = t instanceof CharSequence;
        }
        if (z) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<kotlin.reflect.jvm.internal.impl.types.KotlinType> approximateCapturedTypes(kotlin.reflect.jvm.internal.impl.types.KotlinType r14) {
        /*
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            boolean r1 = com.twitter.sdk.android.tweetui.TweetUtils.isFlexible(r14)
            if (r1 == 0) goto L_0x0056
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = com.twitter.sdk.android.tweetui.TweetUtils.lowerIfFlexible(r14)
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = approximateCapturedTypes(r0)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = com.twitter.sdk.android.tweetui.TweetUtils.upperIfFlexible(r14)
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r1 = approximateCapturedTypes(r1)
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r2 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r3 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            T r3 = r0.lower
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = com.twitter.sdk.android.tweetui.TweetUtils.lowerIfFlexible(r3)
            T r4 = r1.lower
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = com.twitter.sdk.android.tweetui.TweetUtils.upperIfFlexible(r4)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r3 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r3, r4)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r3 = com.twitter.sdk.android.tweetui.TweetUtils.inheritEnhancement(r3, r14)
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r4 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            T r0 = r0.upper
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = com.twitter.sdk.android.tweetui.TweetUtils.lowerIfFlexible(r0)
            T r1 = r1.upper
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = com.twitter.sdk.android.tweetui.TweetUtils.upperIfFlexible(r1)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r14 = com.twitter.sdk.android.tweetui.TweetUtils.inheritEnhancement(r0, r14)
            r2.<init>(r3, r14)
            return r2
        L_0x0056:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r14.getConstructor()
            boolean r2 = com.twitter.sdk.android.tweetui.TweetUtils.isCaptured(r14)
            java.lang.String r3 = "type.builtIns.nothingType"
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x00ca
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor r1 = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor) r1
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = r1.getProjection()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r0.getType()
            java.lang.String r2 = "typeProjection.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r2 = r14.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableIfNeeded(r1, r2)
            java.lang.String r2 = "makeNullableIfNeeded(this, type.isMarkedNullable)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = r0.getProjectionKind()
            int r6 = r6.ordinal()
            if (r6 == r5) goto L_0x00b6
            if (r6 != r4) goto L_0x00aa
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r4 = getBuiltIns(r14)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getNothingType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            boolean r14 = r14.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r14 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableIfNeeded(r4, r14)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r2)
            r0.<init>(r14, r1)
            goto L_0x00c9
        L_0x00aa:
            java.lang.AssertionError r14 = new java.lang.AssertionError
            java.lang.String r1 = "Only nontrivial projections should have been captured, not: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            r14.<init>(r0)
            throw r14
        L_0x00b6:
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r14 = getBuiltIns(r14)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r14.getNullableAnyType()
            java.lang.String r2 = "type.builtIns.nullableAnyType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r2)
            r0.<init>(r1, r14)
        L_0x00c9:
            return r0
        L_0x00ca:
            java.util.List r2 = r14.getArguments()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x020b
            java.util.List r2 = r14.getArguments()
            int r2 = r2.size()
            java.util.List r6 = r1.getParameters()
            int r6 = r6.size()
            if (r2 == r6) goto L_0x00e8
            goto L_0x020b
        L_0x00e8:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r7 = r14.getArguments()
            java.util.List r1 = r1.getParameters()
            java.lang.String r8 = "typeConstructor.parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
            java.util.List r1 = kotlin.collections.ArraysKt___ArraysJvmKt.zip(r7, r1)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x010a:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x01c5
            java.lang.Object r7 = r1.next()
            kotlin.Pair r7 = (kotlin.Pair) r7
            A r8 = r7.first
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r8 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r8
            B r7 = r7.second
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r7
            java.lang.String r9 = "typeParameter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            kotlin.reflect.jvm.internal.impl.types.Variance r9 = r7.getVariance()
            kotlin.reflect.jvm.internal.impl.types.Variance r9 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.combine(r9, r8)
            int r9 = r9.ordinal()
            if (r9 == 0) goto L_0x0172
            if (r9 == r5) goto L_0x0157
            if (r9 != r4) goto L_0x0151
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r9 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r10 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(r7)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r10 = r10.getNothingType()
            java.lang.String r11 = "typeParameter.builtIns.nothingType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = r8.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            r9.<init>(r7, r10, r11)
            goto L_0x0185
        L_0x0151:
            kotlin.NoWhenBranchMatchedException r14 = new kotlin.NoWhenBranchMatchedException
            r14.<init>()
            throw r14
        L_0x0157:
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r9 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r8.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r11 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(r7)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r11.getNullableAnyType()
            java.lang.String r12 = "typeParameter.builtIns.nullableAnyType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            r9.<init>(r7, r10, r11)
            goto L_0x0185
        L_0x0172:
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r9 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r8.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = r8.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            r9.<init>(r7, r10, r11)
        L_0x0185:
            boolean r7 = r8.isStarProjection()
            if (r7 == 0) goto L_0x0193
            r2.add(r9)
            r6.add(r9)
            goto L_0x010a
        L_0x0193:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r9.inProjection
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r7 = approximateCapturedTypes(r7)
            T r8 = r7.lower
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r8
            T r7 = r7.upper
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r7
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r9.outProjection
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r10 = approximateCapturedTypes(r10)
            T r11 = r10.lower
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11
            T r10 = r10.upper
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r10
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r12 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r13 = r9.typeParameter
            r12.<init>(r13, r7, r11)
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r7 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = r9.typeParameter
            r7.<init>(r9, r8, r10)
            r2.add(r12)
            r6.add(r7)
            goto L_0x010a
        L_0x01c5:
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x01cc
            goto L_0x01ee
        L_0x01cc:
            java.util.Iterator r0 = r2.iterator()
        L_0x01d0:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01ee
            java.lang.Object r1 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r1 = (kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument) r1
            if (r1 == 0) goto L_0x01ec
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r4 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r1.inProjection
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.outProjection
            boolean r1 = r4.isSubtypeOf(r7, r1)
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x01d0
            goto L_0x01ef
        L_0x01ec:
            r14 = 0
            throw r14
        L_0x01ee:
            r5 = 0
        L_0x01ef:
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            if (r5 == 0) goto L_0x01ff
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r1 = getBuiltIns(r14)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.getNothingType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            goto L_0x0203
        L_0x01ff:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = replaceTypeArguments(r14, r2)
        L_0x0203:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r14 = replaceTypeArguments(r14, r6)
            r0.<init>(r1, r14)
            return r0
        L_0x020b:
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            r0.<init>(r14, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.approximateCapturedTypes(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds");
    }

    public static boolean areEqual(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i != bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static final <T> Iterable<T> asIterable(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    public static final JsonDecoder asJsonDecoder(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "<this>");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder != null) {
            return jsonDecoder;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got ", Reflection.getOrCreateKotlinClass(decoder.getClass())));
    }

    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, null);
    }

    public static final TypeProjection asTypeProjection(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return new TypeProjectionImpl(kotlinType);
    }

    public static Deferred async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        DeferredCoroutine deferredCoroutine;
        CoroutineStart coroutineStart2 = null;
        CoroutineContext coroutineContext2 = (i & 1) != 0 ? EmptyCoroutineContext.INSTANCE : null;
        if ((i & 2) != 0) {
            coroutineStart2 = CoroutineStart.DEFAULT;
        }
        CoroutineContext newCoroutineContext = newCoroutineContext(coroutineScope, coroutineContext2);
        if (coroutineStart2.isLazy()) {
            deferredCoroutine = new LazyDeferredCoroutine(newCoroutineContext, function2);
        } else {
            deferredCoroutine = new DeferredCoroutine(newCoroutineContext, true);
        }
        coroutineStart2.invoke(function2, deferredCoroutine, deferredCoroutine);
        return deferredCoroutine;
    }

    public static void autoBoxing(MethodVisitor methodVisitor, Type type) {
        switch (type.f6241a) {
            case 1:
                methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                return;
            case 2:
                methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                return;
            case 3:
                methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                return;
            case 4:
                methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                return;
            case 5:
                methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                return;
            case 6:
                methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                return;
            case 7:
                methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                return;
            case 8:
                methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                return;
            default:
                return;
        }
    }

    public static final SerialDescriptor buildClassSerialDescriptor(String str, SerialDescriptor[] serialDescriptorArr, Function1<? super ClassSerialDescriptorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(serialDescriptorArr, "typeParameters");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        if (!CharsKt__CharKt.isBlank(str)) {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
            function1.invoke(classSerialDescriptorBuilder);
            SerialDescriptorImpl serialDescriptorImpl = new SerialDescriptorImpl(str, CLASS.INSTANCE, classSerialDescriptorBuilder.elementNames.size(), TweetUtils.toList(serialDescriptorArr), classSerialDescriptorBuilder);
            return serialDescriptorImpl;
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptor buildSerialDescriptor(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1<? super ClassSerialDescriptorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(serialKind, "kind");
        Intrinsics.checkNotNullParameter(serialDescriptorArr, "typeParameters");
        Intrinsics.checkNotNullParameter(function1, "builder");
        if (!(!CharsKt__CharKt.isBlank(str))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        } else if (!Intrinsics.areEqual(serialKind, CLASS.INSTANCE)) {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
            function1.invoke(classSerialDescriptorBuilder);
            SerialDescriptorImpl serialDescriptorImpl = new SerialDescriptorImpl(str, serialKind, classSerialDescriptorBuilder.elementNames.size(), TweetUtils.toList(serialDescriptorArr), classSerialDescriptorBuilder);
            return serialDescriptorImpl;
        } else {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
    }

    public static /* synthetic */ SerialDescriptor buildSerialDescriptor$default(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i) {
        return buildSerialDescriptor(str, serialKind, serialDescriptorArr, (i & 8) != 0 ? SerialDescriptorsKt$buildSerialDescriptor$1.INSTANCE : null);
    }

    public static final <E> UndeliveredElementException callUndeliveredElementCatchingException(Function1<? super E, Unit> function1, E e2, UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e2);
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException(GeneratedOutlineSupport.outline48("Exception in undelivered element handler for ", e2), th);
            }
            TweetUtils.addSuppressed(undeliveredElementException, th);
        }
        return undeliveredElementException;
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancel$default(Job job, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        job.cancel(null);
    }

    public static final int capacity(int i) {
        if (i < 3) {
            return 3;
        }
        return (i / 3) + i + 1;
    }

    public static final String capitalizeAsciiOnly(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt <= 'z') {
            z = true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(charAt);
            Intrinsics.checkNotNullExpressionValue(str.substring(1), "(this as java.lang.String).substring(startIndex)");
            str = String.valueOf(upperCase) + r4;
        }
        return str;
    }

    public static final SerialDescriptor carrierDescriptor(SerialDescriptor serialDescriptor, SerializersModule serializersModule) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(serializersModule, "module");
        if (!Intrinsics.areEqual(serialDescriptor.getKind(), CONTEXTUAL.INSTANCE)) {
            return serialDescriptor.isInline() ? serialDescriptor.getElementDescriptor(0) : serialDescriptor;
        }
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        KClass<?> capturedKClass = getCapturedKClass(serialDescriptor);
        SerialDescriptor serialDescriptor2 = null;
        if (capturedKClass != null) {
            KSerializer contextual$default = SerializersModule.getContextual$default(serializersModule, capturedKClass, null, 2, null);
            if (contextual$default != null) {
                serialDescriptor2 = contextual$default.getDescriptor();
            }
        }
        if (serialDescriptor2 == null) {
            return serialDescriptor;
        }
        return carrierDescriptor(serialDescriptor2, serializersModule);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6, r1) != false) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object catchImpl(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlinx.coroutines.flow.FlowCollector<? super T> r5, kotlin.coroutines.Continuation<? super java.lang.Throwable> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref$ObjectRef) r4
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)     // Catch:{ all -> 0x002b }
            goto L_0x004e
        L_0x002b:
            r5 = move-exception
            r1 = r5
            goto L_0x0053
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2     // Catch:{ all -> 0x0050 }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x0050 }
            r0.L$0 = r6     // Catch:{ all -> 0x0050 }
            r0.label = r3     // Catch:{ all -> 0x0050 }
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch:{ all -> 0x0050 }
            if (r4 != r1) goto L_0x004e
            goto L_0x008c
        L_0x004e:
            r1 = 0
            goto L_0x008c
        L_0x0050:
            r4 = move-exception
            r1 = r4
            r4 = r6
        L_0x0053:
            T r4 = r4.element
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r5 = 0
            if (r4 == 0) goto L_0x0062
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r6 == 0) goto L_0x0062
            r6 = 1
            goto L_0x0063
        L_0x0062:
            r6 = 0
        L_0x0063:
            if (r6 != 0) goto L_0x0099
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.Job$Key r0 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r0)
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            if (r6 == 0) goto L_0x0087
            boolean r0 = r6.isCancelled()
            if (r0 != 0) goto L_0x007a
            goto L_0x0087
        L_0x007a:
            java.util.concurrent.CancellationException r6 = r6.getCancellationException()
            if (r6 == 0) goto L_0x0087
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r6 == 0) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            r3 = 0
        L_0x0088:
            if (r3 != 0) goto L_0x0099
            if (r4 != 0) goto L_0x008d
        L_0x008c:
            return r1
        L_0x008d:
            boolean r5 = r1 instanceof java.util.concurrent.CancellationException
            if (r5 == 0) goto L_0x0095
            com.twitter.sdk.android.tweetui.TweetUtils.addSuppressed(r4, r1)
            throw r4
        L_0x0095:
            com.twitter.sdk.android.tweetui.TweetUtils.addSuppressed(r1, r4)
            throw r1
        L_0x0099:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.catchImpl(kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final byte charToTokenClass(char c2) {
        if (c2 < '~') {
            return CharMappings.CHAR_TO_TOKEN[c2];
        }
        return 0;
    }

    public static String checkCharacterData(String str) {
        if (str == null) {
            return "A null is not a legal XML value";
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            int charAt = str.charAt(i);
            if (charAt >= 55296 && charAt <= 56319) {
                i++;
                if (i >= length) {
                    return "Surrogate Pair Truncated";
                }
                char charAt2 = str.charAt(i);
                if (charAt2 < 56320 || charAt2 > 57343) {
                    return "Illegal Surrogate Pair";
                }
                charAt = ((charAt - 55296) * 1024) + 65536 + (charAt2 - Utf8.LOG_SURROGATE_HEADER);
            }
            if (!(charAt == 10 || charAt == 13 || charAt == 9 || (charAt >= 32 && (charAt <= 55295 || (charAt >= 57344 && (charAt <= 65533 || (charAt >= 65536 && charAt <= 1114111))))))) {
                StringBuffer outline71 = GeneratedOutlineSupport.outline71("0x");
                outline71.append(Integer.toHexString(charAt));
                outline71.append(" is not a legal XML character");
                return outline71.toString();
            }
            i++;
        }
        return null;
    }

    public static String checkNamespaceCollision(Namespace namespace, Element element) {
        List list;
        String checkNamespaceCollision = checkNamespaceCollision(namespace, element.namespace);
        if (checkNamespaceCollision != null) {
            return GeneratedOutlineSupport.outline49(checkNamespaceCollision, " with the element namespace prefix");
        }
        List list2 = element.additionalNamespaces;
        if (list2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            list = Collections.unmodifiableList(list2);
        }
        String checkNamespaceCollision2 = checkNamespaceCollision(namespace, list);
        if (checkNamespaceCollision2 != null) {
            return checkNamespaceCollision2;
        }
        String checkNamespaceCollision3 = checkNamespaceCollision(namespace, (List) element.attributes);
        if (checkNamespaceCollision3 != null) {
            return checkNamespaceCollision3;
        }
        return null;
    }

    public static final void checkParallelism(int i) {
        boolean z = true;
        if (i < 1) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Expected positive parallelism level, but got ", i).toString());
        }
    }

    public static String checkPublicID(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                break;
            }
            char charAt = str.charAt(i);
            boolean z = true;
            if ((charAt < 'a' || charAt > 'z') && ((charAt < '?' || charAt > 'Z') && !((charAt >= '\'' && charAt <= ';') || charAt == ' ' || charAt == '!' || charAt == '=' || charAt == '#' || charAt == '$' || charAt == '_' || charAt == '%' || charAt == 10 || charAt == 13 || charAt == 9))) {
                z = false;
            }
            if (!z) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(charAt);
                stringBuffer.append(" is not a legal character in public IDs");
                str2 = stringBuffer.toString();
                break;
            }
            i++;
        }
        return str2;
    }

    public static final int checkRadix(int i) {
        if (new IntRange(2, 36).contains(i)) {
            return i;
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("radix ", i, " was not in valid range ");
        outline74.append(new IntRange(2, 36));
        throw new IllegalArgumentException(outline74.toString());
    }

    public static String checkSystemLiteral(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        if (str.indexOf(39) == -1 || str.indexOf(34) == -1) {
            str2 = checkCharacterData(str);
        } else {
            str2 = "System literals cannot simultaneously contain both single and double quotes.";
        }
        return str2;
    }

    public static String checkXMLName(String str) {
        if (str == null || str.length() == 0 || str.trim().equals("")) {
            return "XML names cannot be null or empty";
        }
        boolean z = false;
        char charAt = str.charAt(0);
        if (isXMLLetter(charAt) || charAt == '_' || charAt == ':') {
            z = true;
        }
        if (!z) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("XML names cannot begin with the character \"");
            stringBuffer.append(charAt);
            stringBuffer.append("\"");
            return stringBuffer.toString();
        }
        int length = str.length();
        for (int i = 1; i < length; i++) {
            char charAt2 = str.charAt(i);
            if (!isXMLNameCharacter(charAt2)) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("XML names cannot contain the character \"");
                stringBuffer2.append(charAt2);
                stringBuffer2.append("\"");
                return stringBuffer2.toString();
            }
        }
        return null;
    }

    public static final String classDiscriminator(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        for (Annotation next : serialDescriptor.getAnnotations()) {
            if (next instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator) next).discriminator();
            }
        }
        return json.configuration.classDiscriminator;
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static final <T> List<T> compact(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return EmptyList.INSTANCE;
        }
        if (size == 1) {
            return TweetUtils.listOf(ArraysKt___ArraysJvmKt.first((List<? extends T>) arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final <T> Collection<T> concat(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01b4, code lost:
        if (r4 == false) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012a, code lost:
        if (r11 == false) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012c, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x017a, code lost:
        if (r12 == false) goto L_0x017c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01ce A[Catch:{ NoSuchFieldException -> 0x01d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01d5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0175 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00eb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0170  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlinx.serialization.KSerializer<T> constructSerializerForGivenTypeArgs(kotlin.reflect.KClass<T> r16, kotlinx.serialization.KSerializer<java.lang.Object>... r17) {
        /*
            r0 = r16
            r1 = r17
            java.lang.Class<kotlinx.serialization.PolymorphicSerializer> r2 = kotlinx.serialization.PolymorphicSerializer.class
            java.lang.Class<kotlinx.serialization.KSerializer> r3 = kotlinx.serialization.KSerializer.class
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            java.lang.String r4 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.Class r4 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaClass(r16)
            boolean r5 = r4.isEnum()
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0052
            java.lang.Class<kotlinx.serialization.Serializable> r5 = kotlinx.serialization.Serializable.class
            java.lang.annotation.Annotation r5 = r4.getAnnotation(r5)
            if (r5 != 0) goto L_0x0030
            java.lang.Class<kotlinx.serialization.Polymorphic> r5 = kotlinx.serialization.Polymorphic.class
            java.lang.annotation.Annotation r5 = r4.getAnnotation(r5)
            if (r5 != 0) goto L_0x0030
            r5 = 1
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            if (r5 == 0) goto L_0x0052
            java.lang.Object[] r0 = r4.getEnumConstants()
            kotlinx.serialization.internal.EnumSerializer r1 = new kotlinx.serialization.internal.EnumSerializer
            java.lang.String r2 = r4.getCanonicalName()
            java.lang.String r3 = "canonicalName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            if (r0 == 0) goto L_0x004a
            java.lang.Enum[] r0 = (java.lang.Enum[]) r0
            r1.<init>(r2, r0)
            return r1
        L_0x004a:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>"
            r0.<init>(r1)
            throw r0
        L_0x0052:
            boolean r5 = r4.isInterface()
            r8 = 0
            if (r5 == 0) goto L_0x007f
            java.lang.Class r1 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaClass(r16)
            java.lang.Class<kotlinx.serialization.Serializable> r3 = kotlinx.serialization.Serializable.class
            java.lang.annotation.Annotation r1 = r1.getAnnotation(r3)
            kotlinx.serialization.Serializable r1 = (kotlinx.serialization.Serializable) r1
            if (r1 == 0) goto L_0x0079
            java.lang.Class r1 = r1.with()
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L_0x007e
        L_0x0079:
            kotlinx.serialization.PolymorphicSerializer r8 = new kotlinx.serialization.PolymorphicSerializer
            r8.<init>(r0)
        L_0x007e:
            return r8
        L_0x007f:
            int r5 = r1.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r5)
            kotlinx.serialization.KSerializer[] r1 = (kotlinx.serialization.KSerializer[]) r1
            java.lang.String r5 = "Companion"
            java.lang.reflect.Field r5 = r4.getDeclaredField(r5)     // Catch:{ all -> 0x0094 }
            r5.setAccessible(r6)     // Catch:{ all -> 0x0094 }
            java.lang.Object r5 = r5.get(r8)     // Catch:{ all -> 0x0094 }
            goto L_0x0095
        L_0x0094:
            r5 = r8
        L_0x0095:
            java.lang.String r9 = "serializer"
            if (r5 != 0) goto L_0x009a
            goto L_0x00e8
        L_0x009a:
            int r10 = r1.length     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            if (r10 != 0) goto L_0x009f
            r10 = 1
            goto L_0x00a0
        L_0x009f:
            r10 = 0
        L_0x00a0:
            if (r10 == 0) goto L_0x00a5
            java.lang.Class[] r10 = new java.lang.Class[r7]     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            goto L_0x00b1
        L_0x00a5:
            int r10 = r1.length     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            r12 = 0
        L_0x00a9:
            if (r12 >= r10) goto L_0x00b0
            r11[r12] = r3     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            int r12 = r12 + 1
            goto L_0x00a9
        L_0x00b0:
            r10 = r11
        L_0x00b1:
            java.lang.Class r11 = r5.getClass()     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            int r12 = r10.length     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r12)     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            java.lang.Class[] r10 = (java.lang.Class[]) r10     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            java.lang.reflect.Method r10 = r11.getDeclaredMethod(r9, r10)     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            int r11 = r1.length     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r11)     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            java.lang.Object r1 = r10.invoke(r5, r1)     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            boolean r5 = r1 instanceof kotlinx.serialization.KSerializer     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            if (r5 == 0) goto L_0x00e8
            kotlinx.serialization.KSerializer r1 = (kotlinx.serialization.KSerializer) r1     // Catch:{ NoSuchMethodException -> 0x00e8, InvocationTargetException -> 0x00d0 }
            goto L_0x00e9
        L_0x00d0:
            r0 = move-exception
            java.lang.Throwable r1 = r0.getCause()
            if (r1 == 0) goto L_0x00e7
            java.lang.reflect.InvocationTargetException r2 = new java.lang.reflect.InvocationTargetException
            java.lang.String r3 = r1.getMessage()
            if (r3 != 0) goto L_0x00e3
            java.lang.String r3 = r0.getMessage()
        L_0x00e3:
            r2.<init>(r1, r3)
            throw r2
        L_0x00e7:
            throw r0
        L_0x00e8:
            r1 = r8
        L_0x00e9:
            if (r1 == 0) goto L_0x00ec
            return r1
        L_0x00ec:
            java.lang.reflect.Field[] r1 = r4.getDeclaredFields()
            java.lang.String r5 = "jClass.declaredFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            int r5 = r1.length
            r12 = r8
            r10 = 0
            r11 = 0
        L_0x00f9:
            java.lang.String r13 = "INSTANCE"
            if (r10 >= r5) goto L_0x012a
            r14 = r1[r10]
            java.lang.String r15 = r14.getName()
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r13)
            if (r15 == 0) goto L_0x011f
            java.lang.Class r15 = r14.getType()
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r4)
            if (r15 == 0) goto L_0x011f
            int r15 = r14.getModifiers()
            boolean r15 = java.lang.reflect.Modifier.isStatic(r15)
            if (r15 == 0) goto L_0x011f
            r15 = 1
            goto L_0x0120
        L_0x011f:
            r15 = 0
        L_0x0120:
            if (r15 == 0) goto L_0x0127
            if (r11 == 0) goto L_0x0125
            goto L_0x012c
        L_0x0125:
            r12 = r14
            r11 = 1
        L_0x0127:
            int r10 = r10 + 1
            goto L_0x00f9
        L_0x012a:
            if (r11 != 0) goto L_0x012d
        L_0x012c:
            r12 = r8
        L_0x012d:
            if (r12 != 0) goto L_0x0131
            r1 = r8
            goto L_0x018e
        L_0x0131:
            java.lang.Object r1 = r12.get(r8)
            java.lang.reflect.Method[] r5 = r4.getMethods()
            java.lang.String r10 = "jClass.methods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)
            int r10 = r5.length
            r14 = r8
            r11 = 0
            r12 = 0
        L_0x0142:
            if (r11 >= r10) goto L_0x017a
            r15 = r5[r11]
            java.lang.String r6 = r15.getName()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r9)
            if (r6 == 0) goto L_0x016d
            java.lang.Class[] r6 = r15.getParameterTypes()
            java.lang.String r8 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            int r6 = r6.length
            if (r6 != 0) goto L_0x015e
            r6 = 1
            goto L_0x015f
        L_0x015e:
            r6 = 0
        L_0x015f:
            if (r6 == 0) goto L_0x016d
            java.lang.Class r6 = r15.getReturnType()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r3)
            if (r6 == 0) goto L_0x016d
            r6 = 1
            goto L_0x016e
        L_0x016d:
            r6 = 0
        L_0x016e:
            if (r6 == 0) goto L_0x0175
            if (r12 == 0) goto L_0x0173
            goto L_0x017c
        L_0x0173:
            r14 = r15
            r12 = 1
        L_0x0175:
            int r11 = r11 + 1
            r6 = 1
            r8 = 0
            goto L_0x0142
        L_0x017a:
            if (r12 != 0) goto L_0x017d
        L_0x017c:
            r14 = 0
        L_0x017d:
            if (r14 != 0) goto L_0x0180
            goto L_0x018d
        L_0x0180:
            java.lang.Object[] r3 = new java.lang.Object[r7]
            java.lang.Object r1 = r14.invoke(r1, r3)
            boolean r3 = r1 instanceof kotlinx.serialization.KSerializer
            if (r3 == 0) goto L_0x018d
            kotlinx.serialization.KSerializer r1 = (kotlinx.serialization.KSerializer) r1
            goto L_0x018e
        L_0x018d:
            r1 = 0
        L_0x018e:
            if (r1 != 0) goto L_0x020c
            java.lang.Class[] r1 = r4.getDeclaredClasses()     // Catch:{ NoSuchFieldException -> 0x01d1 }
            java.lang.String r3 = "jClass.declaredClasses"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ NoSuchFieldException -> 0x01d1 }
            int r3 = r1.length     // Catch:{ NoSuchFieldException -> 0x01d1 }
            r4 = 0
            r5 = 0
        L_0x019c:
            if (r7 >= r3) goto L_0x01b4
            r6 = r1[r7]     // Catch:{ NoSuchFieldException -> 0x01d1 }
            java.lang.String r8 = r6.getSimpleName()     // Catch:{ NoSuchFieldException -> 0x01d1 }
            java.lang.String r9 = "$serializer"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)     // Catch:{ NoSuchFieldException -> 0x01d1 }
            if (r8 == 0) goto L_0x01b1
            if (r4 == 0) goto L_0x01af
            goto L_0x01b6
        L_0x01af:
            r5 = r6
            r4 = 1
        L_0x01b1:
            int r7 = r7 + 1
            goto L_0x019c
        L_0x01b4:
            if (r4 != 0) goto L_0x01b7
        L_0x01b6:
            r5 = 0
        L_0x01b7:
            java.lang.Class r5 = (java.lang.Class) r5     // Catch:{ NoSuchFieldException -> 0x01d1 }
            if (r5 != 0) goto L_0x01be
        L_0x01bb:
            r1 = 0
            r3 = 0
            goto L_0x01ca
        L_0x01be:
            java.lang.reflect.Field r1 = r5.getField(r13)     // Catch:{ NoSuchFieldException -> 0x01d1 }
            if (r1 != 0) goto L_0x01c5
            goto L_0x01bb
        L_0x01c5:
            r3 = 0
            java.lang.Object r1 = r1.get(r3)     // Catch:{ NoSuchFieldException -> 0x01d2 }
        L_0x01ca:
            boolean r4 = r1 instanceof kotlinx.serialization.KSerializer     // Catch:{ NoSuchFieldException -> 0x01d2 }
            if (r4 == 0) goto L_0x01d2
            kotlinx.serialization.KSerializer r1 = (kotlinx.serialization.KSerializer) r1     // Catch:{ NoSuchFieldException -> 0x01d2 }
            goto L_0x01d3
        L_0x01d1:
            r3 = 0
        L_0x01d2:
            r1 = r3
        L_0x01d3:
            if (r1 == 0) goto L_0x01d6
            return r1
        L_0x01d6:
            java.lang.Class r1 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaClass(r16)
            java.lang.Class<kotlinx.serialization.Polymorphic> r4 = kotlinx.serialization.Polymorphic.class
            java.lang.annotation.Annotation r4 = r1.getAnnotation(r4)
            if (r4 == 0) goto L_0x01e8
            kotlinx.serialization.PolymorphicSerializer r8 = new kotlinx.serialization.PolymorphicSerializer
            r8.<init>(r0)
            goto L_0x020b
        L_0x01e8:
            java.lang.Class<kotlinx.serialization.Serializable> r4 = kotlinx.serialization.Serializable.class
            java.lang.annotation.Annotation r1 = r1.getAnnotation(r4)
            kotlinx.serialization.Serializable r1 = (kotlinx.serialization.Serializable) r1
            if (r1 == 0) goto L_0x020a
            java.lang.Class r1 = r1.with()
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L_0x020a
            kotlinx.serialization.PolymorphicSerializer r8 = new kotlinx.serialization.PolymorphicSerializer
            r8.<init>(r0)
            goto L_0x020b
        L_0x020a:
            r8 = r3
        L_0x020b:
            return r8
        L_0x020c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.constructSerializerForGivenTypeArgs(kotlin.reflect.KClass, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    public static final boolean contains(KotlinType kotlinType, Function1<? super UnwrappedType, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return TypeUtils.contains(kotlinType, function1);
    }

    public static final <R> Object coroutineScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation.getContext(), continuation);
        Object startUndispatchedOrReturn = startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        if (startUndispatchedOrReturn == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return startUndispatchedOrReturn;
    }

    public static final <T> int count(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }

    public static final TypeProjection createProjection(KotlinType kotlinType, Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        Intrinsics.checkNotNullParameter(variance, "projectionKind");
        if ((typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance()) == variance) {
            variance = Variance.INVARIANT;
        }
        return new TypeProjectionImpl(variance, kotlinType);
    }

    public static ECPoint decodePoint(BigInteger bigInteger, ECCurve eCCurve) throws IOException {
        ECPoint eCPoint;
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
        int fieldSize = (eCCurve.getFieldSize() + 7) / 8;
        boolean z = false;
        byte b2 = asUnsignedByteArray[0];
        if (b2 != 0) {
            if (b2 == 2 || b2 == 3) {
                if (asUnsignedByteArray.length == fieldSize + 1) {
                    eCPoint = eCCurve.decompressPoint(b2 & 1, BigIntegers.fromUnsignedByteArray(asUnsignedByteArray, 1, fieldSize));
                    if (!eCPoint.satisfiesCofactor()) {
                        throw new IllegalArgumentException("Invalid point");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
            } else if (b2 != 4) {
                if (b2 != 6 && b2 != 7) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid point encoding 0x");
                    outline73.append(Integer.toString(b2, 16));
                    throw new IllegalArgumentException(outline73.toString());
                } else if (asUnsignedByteArray.length == (fieldSize * 2) + 1) {
                    BigInteger fromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(asUnsignedByteArray, 1, fieldSize);
                    BigInteger fromUnsignedByteArray2 = BigIntegers.fromUnsignedByteArray(asUnsignedByteArray, fieldSize + 1, fieldSize);
                    boolean testBit = fromUnsignedByteArray2.testBit(0);
                    if (b2 == 7) {
                        z = true;
                    }
                    if (testBit == z) {
                        eCPoint = eCCurve.validatePoint(fromUnsignedByteArray, fromUnsignedByteArray2);
                    } else {
                        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
            } else if (asUnsignedByteArray.length == (fieldSize * 2) + 1) {
                eCPoint = eCCurve.validatePoint(BigIntegers.fromUnsignedByteArray(asUnsignedByteArray, 1, fieldSize), BigIntegers.fromUnsignedByteArray(asUnsignedByteArray, fieldSize + 1, fieldSize));
            } else {
                throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
            }
        } else if (asUnsignedByteArray.length == 1) {
            eCPoint = eCCurve.getInfinity();
        } else {
            throw new IllegalArgumentException("Incorrect length for infinity encoding");
        }
        if (b2 == 0 || !eCPoint.isInfinity()) {
            return eCPoint;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public static /* synthetic */ Object decodeSerializableElement$default(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj, int i2, Object obj2) {
        int i3 = i2 & 8;
        return compositeDecoder.decodeSerializableElement(serialDescriptor, i, deserializationStrategy, null);
    }

    public static <T> T decodeSerializableValue(Decoder decoder, DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(decoder, "this");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return deserializationStrategy.deserialize(decoder);
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v2, types: [kotlinx.serialization.json.JsonPrimitive] */
    /* JADX WARNING: type inference failed for: r6v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v5, types: [kotlinx.serialization.json.JsonPrimitive] */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], kotlinx.serialization.json.JsonPrimitive, java.lang.String]
      uses: [java.lang.String, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.Object, kotlinx.serialization.json.JsonPrimitive]
      mth insns count: 77
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T decodeSerializableValuePolymorphic(kotlinx.serialization.json.JsonDecoder r8, kotlinx.serialization.DeserializationStrategy<T> r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r1 = "deserializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            boolean r2 = r9 instanceof kotlinx.serialization.internal.AbstractPolymorphicSerializer
            if (r2 == 0) goto L_0x00fc
            kotlinx.serialization.json.Json r2 = r8.getJson()
            kotlinx.serialization.json.JsonConfiguration r2 = r2.configuration
            boolean r2 = r2.useArrayPolymorphism
            if (r2 == 0) goto L_0x001a
            goto L_0x00fc
        L_0x001a:
            kotlinx.serialization.json.JsonElement r2 = r8.decodeJsonElement()
            kotlinx.serialization.descriptors.SerialDescriptor r3 = r9.getDescriptor()
            boolean r4 = r2 instanceof kotlinx.serialization.json.JsonObject
            r5 = -1
            if (r4 == 0) goto L_0x00c8
            kotlinx.serialization.json.JsonObject r2 = (kotlinx.serialization.json.JsonObject) r2
            kotlinx.serialization.descriptors.SerialDescriptor r3 = r9.getDescriptor()
            kotlinx.serialization.json.Json r4 = r8.getJson()
            java.lang.String r3 = classDiscriminator(r3, r4)
            java.lang.Object r4 = r2.get(r3)
            kotlinx.serialization.json.JsonElement r4 = (kotlinx.serialization.json.JsonElement) r4
            r6 = 0
            if (r4 != 0) goto L_0x003f
            goto L_0x004f
        L_0x003f:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r7 = r4 instanceof kotlinx.serialization.json.JsonPrimitive
            if (r7 == 0) goto L_0x0049
            r6 = r4
            kotlinx.serialization.json.JsonPrimitive r6 = (kotlinx.serialization.json.JsonPrimitive) r6
        L_0x0049:
            if (r6 == 0) goto L_0x00a3
            java.lang.String r6 = r6.getContent()
        L_0x004f:
            kotlinx.serialization.internal.AbstractPolymorphicSerializer r9 = (kotlinx.serialization.internal.AbstractPolymorphicSerializer) r9
            kotlinx.serialization.DeserializationStrategy r9 = r9.findPolymorphicSerializerOrNull(r8, r6)
            if (r9 != 0) goto L_0x0081
            if (r6 != 0) goto L_0x005c
            java.lang.String r8 = "missing class discriminator ('null')"
            goto L_0x0072
        L_0x005c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "class discriminator '"
            r8.append(r9)
            r8.append(r6)
            r9 = 39
            r8.append(r9)
            java.lang.String r8 = r8.toString()
        L_0x0072:
            java.lang.String r9 = "Polymorphic serializer was not found for "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r8)
            java.lang.String r9 = r2.toString()
            kotlinx.serialization.json.internal.JsonDecodingException r8 = JsonDecodingException(r5, r8, r9)
            throw r8
        L_0x0081:
            kotlinx.serialization.json.Json r8 = r8.getJson()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "discriminator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "element"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            kotlinx.serialization.json.internal.JsonTreeDecoder r0 = new kotlinx.serialization.json.internal.JsonTreeDecoder
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r9.getDescriptor()
            r0.<init>(r8, r2, r3, r1)
            java.lang.Object r8 = r0.decodeSerializableValue(r9)
            return r8
        L_0x00a3:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Element "
            java.lang.StringBuilder r9 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r9)
            java.lang.Class r0 = r4.getClass()
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            r9.append(r0)
            java.lang.String r0 = " is not a "
            r9.append(r0)
            java.lang.String r0 = "JsonPrimitive"
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x00c8:
            java.lang.String r8 = "Expected "
            java.lang.StringBuilder r8 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r8)
            java.lang.Class<kotlinx.serialization.json.JsonObject> r9 = kotlinx.serialization.json.JsonObject.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            r8.append(r9)
            java.lang.String r9 = " as the serialized body of "
            r8.append(r9)
            java.lang.String r9 = r3.getSerialName()
            r8.append(r9)
            java.lang.String r9 = ", but had "
            r8.append(r9)
            java.lang.Class r9 = r2.getClass()
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            kotlinx.serialization.json.internal.JsonDecodingException r8 = JsonDecodingException(r5, r8)
            throw r8
        L_0x00fc:
            java.lang.Object r8 = r9.deserialize(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.decodeSerializableValuePolymorphic(kotlinx.serialization.json.JsonDecoder, kotlinx.serialization.DeserializationStrategy):java.lang.Object");
    }

    public static <N, R> R dfs(Collection<N> collection, DFS$Neighbors<N> dFS$Neighbors, DFS$NodeHandler<N, R> dFS$NodeHandler) {
        if (collection == null) {
            $$$reportNull$$$0(4);
            throw null;
        } else if (dFS$Neighbors != null) {
            DFS$VisitedWithSet dFS$VisitedWithSet = new DFS$VisitedWithSet();
            for (N doDfs : collection) {
                doDfs(doDfs, dFS$Neighbors, dFS$VisitedWithSet, dFS$NodeHandler);
            }
            return dFS$NodeHandler.result();
        } else {
            $$$reportNull$$$0(5);
            throw null;
        }
    }

    public static final void dispatcherFailure(Continuation<?> continuation, Throwable th) {
        continuation.resumeWith(TweetUtils.createFailure(th));
        throw th;
    }

    public static <N> void doDfs(N n, DFS$Neighbors<N> dFS$Neighbors, DFS$Visited<N> dFS$Visited, DFS$NodeHandler<N, ?> dFS$NodeHandler) {
        if (n == null) {
            $$$reportNull$$$0(22);
            throw null;
        } else if (dFS$Neighbors == null) {
            $$$reportNull$$$0(23);
            throw null;
        } else if (dFS$Visited == null) {
            $$$reportNull$$$0(24);
            throw null;
        } else if (dFS$NodeHandler == null) {
            $$$reportNull$$$0(25);
            throw null;
        } else if (((DFS$VisitedWithSet) dFS$Visited).visited.add(n) && dFS$NodeHandler.beforeChildren(n)) {
            for (Object doDfs : dFS$Neighbors.getNeighbors(n)) {
                doDfs(doDfs, dFS$Neighbors, dFS$Visited, dFS$NodeHandler);
            }
            dFS$NodeHandler.afterChildren(n);
        }
    }

    public static final <T> Sequence<T> drop(Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return sequence;
        } else {
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).drop(i);
            }
            return new DropSequence(sequence, i);
        }
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null && !job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static final <T> Sequence<T> filter(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new FilteringSequence(sequence, true, function1);
    }

    public static final <T> Sequence<T> filterNot(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new FilteringSequence(sequence, false, function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005a, code lost:
        if ((r6 instanceof kotlinx.serialization.SerializationStrategy) != false) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlinx.serialization.SerializationStrategy<T> findPolymorphicSerializer(kotlinx.serialization.internal.AbstractPolymorphicSerializer<T> r5, kotlinx.serialization.encoding.Encoder r6, T r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r1 = "encoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r2 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            kotlinx.serialization.modules.SerializersModule r6 = r6.getSerializersModule()
            kotlin.reflect.KClass r1 = r5.getBaseClass()
            kotlinx.serialization.modules.SerialModuleImpl r6 = (kotlinx.serialization.modules.SerialModuleImpl) r6
            r3 = 0
            if (r6 == 0) goto L_0x0084
            java.lang.String r4 = "baseClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "kclass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.Class r0 = com.twitter.sdk.android.tweetui.TweetUtils.getJavaObjectType(r1)
            boolean r0 = r0.isInstance(r7)
            if (r0 != 0) goto L_0x003e
            goto L_0x005d
        L_0x003e:
            java.util.Map<kotlin.reflect.KClass<?>, java.util.Map<kotlin.reflect.KClass<?>, kotlinx.serialization.KSerializer<?>>> r6 = r6.polyBase2Serializers
            java.lang.Object r6 = r6.get(r1)
            java.util.Map r6 = (java.util.Map) r6
            if (r6 != 0) goto L_0x004a
            r6 = r3
            goto L_0x0058
        L_0x004a:
            java.lang.Class r0 = r7.getClass()
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.Object r6 = r6.get(r0)
            kotlinx.serialization.KSerializer r6 = (kotlinx.serialization.KSerializer) r6
        L_0x0058:
            boolean r0 = r6 instanceof kotlinx.serialization.SerializationStrategy
            if (r0 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r6 = r3
        L_0x005e:
            if (r6 != 0) goto L_0x0083
            java.lang.Class r6 = r7.getClass()
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            kotlin.reflect.KClass r5 = r5.getBaseClass()
            java.lang.String r7 = "subClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            java.lang.String r7 = r6.getSimpleName()
            if (r7 != 0) goto L_0x007f
            java.lang.String r7 = java.lang.String.valueOf(r6)
        L_0x007f:
            throwSubtypeNotRegistered(r7, r5)
            throw r3
        L_0x0083:
            return r6
        L_0x0084:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.findPolymorphicSerializer(kotlinx.serialization.internal.AbstractPolymorphicSerializer, kotlinx.serialization.encoding.Encoder, java.lang.Object):kotlinx.serialization.SerializationStrategy");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object firstOrNull(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlin.coroutines.Continuation<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r4 = r0.L$1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) r4
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)     // Catch:{ AbortFlowException -> 0x002f }
            goto L_0x005d
        L_0x002f:
            r5 = move-exception
            goto L_0x0059
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
            r2.<init>(r5)
            r0.L$0 = r5     // Catch:{ AbortFlowException -> 0x0055 }
            r0.L$1 = r2     // Catch:{ AbortFlowException -> 0x0055 }
            r0.label = r3     // Catch:{ AbortFlowException -> 0x0055 }
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch:{ AbortFlowException -> 0x0055 }
            if (r4 != r1) goto L_0x0053
            goto L_0x005f
        L_0x0053:
            r0 = r5
            goto L_0x005d
        L_0x0055:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L_0x0059:
            kotlinx.coroutines.flow.FlowCollector<?> r1 = r5.owner
            if (r1 != r4) goto L_0x0060
        L_0x005d:
            T r1 = r0.element
        L_0x005f:
            return r1
        L_0x0060:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.firstOrNull(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T, R> Sequence<R> flatMap(Sequence<? extends T> sequence, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return new FlatteningSequence(sequence, function1, SequencesKt___SequencesKt$flatMap$2.INSTANCE);
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        SequencesKt__SequencesKt$flatten$1 sequencesKt__SequencesKt$flatten$1 = SequencesKt__SequencesKt$flatten$1.INSTANCE;
        if (!(sequence instanceof TransformingSequence)) {
            return new FlatteningSequence(sequence, SequencesKt__SequencesKt$flatten$3.INSTANCE, sequencesKt__SequencesKt$flatten$1);
        }
        TransformingSequence transformingSequence = (TransformingSequence) sequence;
        Intrinsics.checkNotNullParameter(sequencesKt__SequencesKt$flatten$1, "iterator");
        return new FlatteningSequence(transformingSequence.sequence, transformingSequence.transformer, sequencesKt__SequencesKt$flatten$1);
    }

    public static final CoroutineContext foldCopies(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z) {
        boolean hasCopyableElements = hasCopyableElements(coroutineContext);
        boolean hasCopyableElements2 = hasCopyableElements(coroutineContext2);
        if (!hasCopyableElements && !hasCopyableElements2) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = coroutineContext2;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(EmptyCoroutineContext.INSTANCE, new CoroutineContextKt$foldCopies$folded$1(ref$ObjectRef, z));
        if (hasCopyableElements2) {
            ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).fold(EmptyCoroutineContext.INSTANCE, CoroutineContextKt$foldCopies$1.INSTANCE);
        }
        return coroutineContext3.plus((CoroutineContext) ref$ObjectRef.element);
    }

    public static final CoroutineDispatcher from(Executor executor) {
        DispatcherExecutor dispatcherExecutor = executor instanceof DispatcherExecutor ? (DispatcherExecutor) executor : null;
        if (dispatcherExecutor != null) {
            CoroutineDispatcher coroutineDispatcher = dispatcherExecutor.dispatcher;
            if (coroutineDispatcher != null) {
                return coroutineDispatcher;
            }
        }
        return new ExecutorCoroutineDispatcherImpl(executor);
    }

    public static int[] fromBigInteger(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[((i + 31) >> 5)];
        int i2 = 0;
        while (bigInteger.signum() != 0) {
            iArr[i2] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i2++;
        }
        return iArr;
    }

    public static final <T> Sequence<T> generateSequence(T t, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        if (t == null) {
            return EmptySequence.INSTANCE;
        }
        return new GeneratorSequence(new SequencesKt__SequencesKt$generateSequence$2(t), function1);
    }

    public static List<Annotation> getAnnotations(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "this");
        return EmptyList.INSTANCE;
    }

    public static final KotlinBuiltIns getBuiltIns(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinBuiltIns builtIns = kotlinType.getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "constructor.builtIns");
        return builtIns;
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters x9ECParameters;
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder) X962NamedCurves.curves.get(aSN1ObjectIdentifier);
        X9ECParameters x9ECParameters2 = null;
        if (x9ECParametersHolder == null) {
            x9ECParameters = null;
        } else {
            x9ECParameters = x9ECParametersHolder.getParameters();
        }
        if (x9ECParameters == null) {
            X9ECParametersHolder x9ECParametersHolder2 = (X9ECParametersHolder) SECNamedCurves.curves.get(aSN1ObjectIdentifier);
            if (x9ECParametersHolder2 == null) {
                x9ECParameters = null;
            } else {
                x9ECParameters = x9ECParametersHolder2.getParameters();
            }
        }
        if (x9ECParameters == null) {
            X9ECParametersHolder x9ECParametersHolder3 = (X9ECParametersHolder) TeleTrusTNamedCurves.curves.get(aSN1ObjectIdentifier);
            if (x9ECParametersHolder3 == null) {
                x9ECParameters = null;
            } else {
                x9ECParameters = x9ECParametersHolder3.getParameters();
            }
        }
        if (x9ECParameters != null) {
            return x9ECParameters;
        }
        X9ECParametersHolder x9ECParametersHolder4 = (X9ECParametersHolder) ANSSINamedCurves.curves.get(aSN1ObjectIdentifier);
        if (x9ECParametersHolder4 != null) {
            x9ECParameters2 = x9ECParametersHolder4.getParameters();
        }
        return x9ECParameters2;
    }

    public static final KClass<?> getCapturedKClass(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor instanceof ContextDescriptor) {
            return ((ContextDescriptor) serialDescriptor).kClass;
        }
        if (serialDescriptor instanceof SerialDescriptorForNullable) {
            return getCapturedKClass(((SerialDescriptorForNullable) serialDescriptor).original);
        }
        return null;
    }

    public static String getGetterName(String str) {
        int length = str.length();
        char[] cArr = new char[(length + 3)];
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[3] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static final int getInt(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return Integer.parseInt(jsonPrimitive.getContent());
    }

    public static final <T> KSerializer<T> getNullable(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        return kSerializer.getDescriptor().isNullable() ? kSerializer : new NullableSerializer(kSerializer);
    }

    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(Continuation<? super T> continuation) {
        CancellableContinuationImpl<T> cancellableContinuationImpl;
        CancellableContinuationImpl<T> cancellableContinuationImpl2;
        boolean z = true;
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 1);
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        while (true) {
            Object obj = dispatchedContinuation._reusableCancellableContinuation;
            cancellableContinuationImpl = null;
            if (obj == null) {
                dispatchedContinuation._reusableCancellableContinuation = DispatchedContinuationKt.REUSABLE_CLAIMED;
                cancellableContinuationImpl2 = null;
                break;
            } else if (obj instanceof CancellableContinuationImpl) {
                if (DispatchedContinuation._reusableCancellableContinuation$FU.compareAndSet(dispatchedContinuation, obj, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                    cancellableContinuationImpl2 = (CancellableContinuationImpl) obj;
                    break;
                }
            } else if (obj != DispatchedContinuationKt.REUSABLE_CLAIMED && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (cancellableContinuationImpl2 != null) {
            Object obj2 = cancellableContinuationImpl2._state;
            if (!(obj2 instanceof CompletedContinuation) || ((CompletedContinuation) obj2).idempotentResume == null) {
                cancellableContinuationImpl2._decision = 0;
                cancellableContinuationImpl2._state = Active.INSTANCE;
            } else {
                cancellableContinuationImpl2.detachChild$kotlinx_coroutines_core();
                z = false;
            }
            if (z) {
                cancellableContinuationImpl = cancellableContinuationImpl2;
            }
            if (cancellableContinuationImpl != null) {
                return cancellableContinuationImpl;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 2);
    }

    public static final KotlinType getRepresentativeUpperBound(TypeParameterDescriptor typeParameterDescriptor) {
        T t;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "<this>");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "upperBounds");
        boolean z = !upperBounds.isEmpty();
        if (!_Assertions.ENABLED || z) {
            List<KotlinType> upperBounds2 = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds2, "upperBounds");
            Iterator<T> it = upperBounds2.iterator();
            while (true) {
                t = null;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                T declarationDescriptor = ((KotlinType) next).getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor instanceof ClassDescriptor) {
                    t = (ClassDescriptor) declarationDescriptor;
                }
                boolean z2 = false;
                if (!(t == null || t.getKind() == ClassKind.INTERFACE || t.getKind() == ClassKind.ANNOTATION_CLASS)) {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    t = next;
                    break;
                }
            }
            KotlinType kotlinType = (KotlinType) t;
            if (kotlinType != null) {
                return kotlinType;
            }
            List<KotlinType> upperBounds3 = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds3, "upperBounds");
            Object first = ArraysKt___ArraysJvmKt.first(upperBounds3);
            Intrinsics.checkNotNullExpressionValue(first, "upperBounds.first()");
            return (KotlinType) first;
        }
        throw new AssertionError(Intrinsics.stringPlus("Upper bounds should not be empty: ", typeParameterDescriptor));
    }

    public static final DescriptorSchemaCache getSchemaCache(Json json) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        return json._schemaCache;
    }

    public static final void handleCoroutineException(CoroutineContext coroutineContext, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                Throwable runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                TweetUtils.addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, th);
        }
    }

    public static final boolean hasCopyableElements(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue();
    }

    public static int hashCode(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * FTPReply.PATHNAME_CREATED) ^ bArr[length];
        }
    }

    public static final int hashCodeImpl(SerialDescriptor serialDescriptor, SerialDescriptor[] serialDescriptorArr) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptorArr, "typeParams");
        int hashCode = (serialDescriptor.getSerialName().hashCode() * 31) + Arrays.hashCode(serialDescriptorArr);
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        int elementsCount = serialDescriptor.getElementsCount();
        int i = 1;
        while (true) {
            int i2 = 0;
            if (!(elementsCount > 0)) {
                break;
            }
            int i3 = elementsCount - 1;
            int i4 = i * 31;
            String serialName = serialDescriptor.getElementDescriptor(serialDescriptor.getElementsCount() - elementsCount).getSerialName();
            if (serialName != null) {
                i2 = serialName.hashCode();
            }
            i = i4 + i2;
            elementsCount = i3;
        }
        int elementsCount2 = serialDescriptor.getElementsCount();
        int i5 = 1;
        while (true) {
            if (!(elementsCount2 > 0)) {
                return (((hashCode * 31) + i) * 31) + i5;
            }
            int i6 = elementsCount2 - 1;
            int i7 = i5 * 31;
            SerialKind kind = serialDescriptor.getElementDescriptor(serialDescriptor.getElementsCount() - elementsCount2).getKind();
            i5 = i7 + (kind != null ? kind.hashCode() : 0);
            elementsCount2 = i6;
        }
    }

    public static <N> Boolean ifAny(Collection<N> collection, DFS$Neighbors<N> dFS$Neighbors, Function1<N, Boolean> function1) {
        if (function1 != null) {
            return (Boolean) dfs(collection, dFS$Neighbors, new DFS$1(function1, new boolean[1]));
        }
        $$$reportNull$$$0(9);
        throw null;
    }

    public static boolean initDebug() {
        String str;
        boolean z;
        try {
            System.loadLibrary("opencv_info");
            str = StaticHelper.getLibraryList();
        } catch (UnsatisfiedLinkError unused) {
            str = "";
        }
        if (str == null || str.length() == 0) {
            z = StaticHelper.loadLibrary("opencv_java3") & true;
        } else {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
            z = true;
            while (stringTokenizer.hasMoreTokens()) {
                z &= StaticHelper.loadLibrary(stringTokenizer.nextToken());
            }
        }
        if (!z) {
            return false;
        }
        for (String str2 : Core.getBuildInformation_0().split(System.getProperty("line.separator"))) {
        }
        return true;
    }

    public static void intToBigEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static void inversionResult(int[] iArr, int i, int[] iArr2, int[] iArr3) {
        if (i < 0) {
            int length = iArr.length;
            long j = 0;
            for (int i2 = 0; i2 < length; i2++) {
                long j2 = (((long) iArr2[i2]) & 4294967295L) + (4294967295L & ((long) iArr[i2])) + j;
                iArr3[i2] = (int) j2;
                j = j2 >>> 32;
            }
            return;
        }
        System.arraycopy(iArr2, 0, iArr3, 0, iArr.length);
    }

    public static int inversionStep(int[] iArr, int[] iArr2, int i, int[] iArr3, int i2) {
        int length = iArr.length;
        int i3 = 0;
        while (iArr2[0] == 0) {
            int i4 = i;
            int i5 = 0;
            while (true) {
                i4--;
                if (i4 < 0) {
                    break;
                }
                int i6 = iArr2[i4];
                iArr2[i4] = i5;
                i5 = i6;
            }
            i3 += 32;
        }
        int i7 = iArr2[0];
        int i8 = 0;
        while ((i7 & 1) == 0) {
            i7 >>>= 1;
            i8++;
        }
        if (i8 > 0) {
            int i9 = 0;
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                int i10 = iArr2[i];
                iArr2[i] = (i9 << (-i8)) | (i10 >>> i8);
                i9 = i10;
            }
            i3 += i8;
        }
        for (int i11 = 0; i11 < i3; i11++) {
            if ((iArr3[0] & 1) != 0) {
                if (i2 < 0) {
                    long j = 0;
                    for (int i12 = 0; i12 < length; i12++) {
                        long j2 = (((long) iArr[i12]) & 4294967295L) + (4294967295L & ((long) iArr3[i12])) + j;
                        iArr3[i12] = (int) j2;
                        j = j2 >>> 32;
                    }
                    i2 += (int) j;
                } else {
                    i2 = subFrom(length, iArr, iArr3) + i2;
                }
            }
            int i13 = i2;
            int i14 = length;
            while (true) {
                i14--;
                if (i14 < 0) {
                    break;
                }
                int i15 = iArr3[i14];
                iArr3[i14] = (i13 << 31) | (i15 >>> 1);
                i13 = i15;
            }
        }
        return i2;
    }

    public static String invoke(Check check, FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(check, "this");
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        if (!check.check(functionDescriptor)) {
            return check.getDescription();
        }
        return null;
    }

    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return job.invokeOnCompletion(z, z2, function1);
    }

    public static boolean isAndroidSDKAvailable() {
        try {
            if (Class.forName("android.os.Looper").getDeclaredMethod("getMainLooper", new Class[0]).invoke(null, new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static final boolean isCancellableMode(int i) {
        return i == 1 || i == 2;
    }

    public static boolean isF2mCurve(ECCurve eCCurve) {
        FiniteField finiteField = eCCurve.field;
        return finiteField.getDimension() > 1 && finiteField.getCharacteristic().equals(ECConstants.TWO) && (finiteField instanceof PolynomialExtensionField);
    }

    public static boolean isInline(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "this");
        return false;
    }

    public static boolean isNullable(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "this");
        return false;
    }

    public static boolean isOne(int i, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < i; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isProcessCanceledException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Class cls = th.getClass();
        while (!Intrinsics.areEqual(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isTypeParameter(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeUtils.isTypeParameter(kotlinType);
    }

    public static final boolean isUpperCaseCharAt(String str, int i, boolean z) {
        char charAt = str.charAt(i);
        if (z) {
            return 'A' <= charAt && charAt <= 'Z';
        }
        return Character.isUpperCase(charAt);
    }

    public static boolean isValidJsonValue(Object obj) {
        return JSONNull.instance.equals(obj) || (obj instanceof JSON) || (obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof BigInteger) || (obj instanceof BigDecimal) || (obj instanceof JSONFunction) || (obj instanceof JSONString) || (obj instanceof String);
    }

    public static final boolean isWhitespace(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static boolean isXMLDigit(char c2) {
        if (c2 < '0') {
            return false;
        }
        if (c2 <= '9') {
            return true;
        }
        if (c2 < 1632) {
            return false;
        }
        if (c2 <= 1641) {
            return true;
        }
        if (c2 < 1776) {
            return false;
        }
        if (c2 <= 1785) {
            return true;
        }
        if (c2 < 2406) {
            return false;
        }
        if (c2 <= 2415) {
            return true;
        }
        if (c2 < 2534) {
            return false;
        }
        if (c2 <= 2543) {
            return true;
        }
        if (c2 < 2662) {
            return false;
        }
        if (c2 <= 2671) {
            return true;
        }
        if (c2 < 2790) {
            return false;
        }
        if (c2 <= 2799) {
            return true;
        }
        if (c2 < 2918) {
            return false;
        }
        if (c2 <= 2927) {
            return true;
        }
        if (c2 < 3047) {
            return false;
        }
        if (c2 <= 3055) {
            return true;
        }
        if (c2 < 3174) {
            return false;
        }
        if (c2 <= 3183) {
            return true;
        }
        if (c2 < 3302) {
            return false;
        }
        if (c2 <= 3311) {
            return true;
        }
        if (c2 < 3430) {
            return false;
        }
        if (c2 <= 3439) {
            return true;
        }
        if (c2 < 3664) {
            return false;
        }
        if (c2 <= 3673) {
            return true;
        }
        if (c2 < 3792) {
            return false;
        }
        if (c2 <= 3801) {
            return true;
        }
        return c2 >= 3872 && c2 <= 3881;
    }

    public static boolean isXMLLetter(char c2) {
        if (c2 < 'A') {
            return false;
        }
        if (c2 <= 'Z') {
            return true;
        }
        if (c2 < 'a') {
            return false;
        }
        if (c2 <= 'z') {
            return true;
        }
        if (c2 < 192) {
            return false;
        }
        if (c2 <= 214) {
            return true;
        }
        if (c2 < 216) {
            return false;
        }
        if (c2 <= 246) {
            return true;
        }
        if (c2 < 248) {
            return false;
        }
        if (c2 <= 255) {
            return true;
        }
        if (c2 < 256) {
            return false;
        }
        if (c2 <= 305) {
            return true;
        }
        if (c2 < 308) {
            return false;
        }
        if (c2 <= 318) {
            return true;
        }
        if (c2 < 321) {
            return false;
        }
        if (c2 <= 328) {
            return true;
        }
        if (c2 < 330) {
            return false;
        }
        if (c2 <= 382) {
            return true;
        }
        if (c2 < 384) {
            return false;
        }
        if (c2 <= 451) {
            return true;
        }
        if (c2 < 461) {
            return false;
        }
        if (c2 <= 496) {
            return true;
        }
        if (c2 < 500) {
            return false;
        }
        if (c2 <= 501) {
            return true;
        }
        if (c2 < 506) {
            return false;
        }
        if (c2 <= 535) {
            return true;
        }
        if (c2 < 592) {
            return false;
        }
        if (c2 <= 680) {
            return true;
        }
        if (c2 < 699) {
            return false;
        }
        if (c2 <= 705 || c2 == 902) {
            return true;
        }
        if (c2 < 904) {
            return false;
        }
        if (c2 <= 906 || c2 == 908) {
            return true;
        }
        if (c2 < 910) {
            return false;
        }
        if (c2 <= 929) {
            return true;
        }
        if (c2 < 931) {
            return false;
        }
        if (c2 <= 974) {
            return true;
        }
        if (c2 < 976) {
            return false;
        }
        if (c2 <= 982 || c2 == 986 || c2 == 988 || c2 == 990 || c2 == 992) {
            return true;
        }
        if (c2 < 994) {
            return false;
        }
        if (c2 <= 1011) {
            return true;
        }
        if (c2 < 1025) {
            return false;
        }
        if (c2 <= 1036) {
            return true;
        }
        if (c2 < 1038) {
            return false;
        }
        if (c2 <= 1103) {
            return true;
        }
        if (c2 < 1105) {
            return false;
        }
        if (c2 <= 1116) {
            return true;
        }
        if (c2 < 1118) {
            return false;
        }
        if (c2 <= 1153) {
            return true;
        }
        if (c2 < 1168) {
            return false;
        }
        if (c2 <= 1220) {
            return true;
        }
        if (c2 < 1223) {
            return false;
        }
        if (c2 <= 1224) {
            return true;
        }
        if (c2 < 1227) {
            return false;
        }
        if (c2 <= 1228) {
            return true;
        }
        if (c2 < 1232) {
            return false;
        }
        if (c2 <= 1259) {
            return true;
        }
        if (c2 < 1262) {
            return false;
        }
        if (c2 <= 1269) {
            return true;
        }
        if (c2 < 1272) {
            return false;
        }
        if (c2 <= 1273) {
            return true;
        }
        if (c2 < 1329) {
            return false;
        }
        if (c2 <= 1366 || c2 == 1369) {
            return true;
        }
        if (c2 < 1377) {
            return false;
        }
        if (c2 <= 1414) {
            return true;
        }
        if (c2 < 1488) {
            return false;
        }
        if (c2 <= 1514) {
            return true;
        }
        if (c2 < 1520) {
            return false;
        }
        if (c2 <= 1522) {
            return true;
        }
        if (c2 < 1569) {
            return false;
        }
        if (c2 <= 1594) {
            return true;
        }
        if (c2 < 1601) {
            return false;
        }
        if (c2 <= 1610) {
            return true;
        }
        if (c2 < 1649) {
            return false;
        }
        if (c2 <= 1719) {
            return true;
        }
        if (c2 < 1722) {
            return false;
        }
        if (c2 <= 1726) {
            return true;
        }
        if (c2 < 1728) {
            return false;
        }
        if (c2 <= 1742) {
            return true;
        }
        if (c2 < 1744) {
            return false;
        }
        if (c2 <= 1747 || c2 == 1749) {
            return true;
        }
        if (c2 < 1765) {
            return false;
        }
        if (c2 <= 1766) {
            return true;
        }
        if (c2 < 2309) {
            return false;
        }
        if (c2 <= 2361 || c2 == 2365) {
            return true;
        }
        if (c2 < 2392) {
            return false;
        }
        if (c2 <= 2401) {
            return true;
        }
        if (c2 < 2437) {
            return false;
        }
        if (c2 <= 2444) {
            return true;
        }
        if (c2 < 2447) {
            return false;
        }
        if (c2 <= 2448) {
            return true;
        }
        if (c2 < 2451) {
            return false;
        }
        if (c2 <= 2472) {
            return true;
        }
        if (c2 < 2474) {
            return false;
        }
        if (c2 <= 2480 || c2 == 2482) {
            return true;
        }
        if (c2 < 2486) {
            return false;
        }
        if (c2 <= 2489) {
            return true;
        }
        if (c2 < 2524) {
            return false;
        }
        if (c2 <= 2525) {
            return true;
        }
        if (c2 < 2527) {
            return false;
        }
        if (c2 <= 2529) {
            return true;
        }
        if (c2 < 2544) {
            return false;
        }
        if (c2 <= 2545) {
            return true;
        }
        if (c2 < 2565) {
            return false;
        }
        if (c2 <= 2570) {
            return true;
        }
        if (c2 < 2575) {
            return false;
        }
        if (c2 <= 2576) {
            return true;
        }
        if (c2 < 2579) {
            return false;
        }
        if (c2 <= 2600) {
            return true;
        }
        if (c2 < 2602) {
            return false;
        }
        if (c2 <= 2608) {
            return true;
        }
        if (c2 < 2610) {
            return false;
        }
        if (c2 <= 2611) {
            return true;
        }
        if (c2 < 2613) {
            return false;
        }
        if (c2 <= 2614) {
            return true;
        }
        if (c2 < 2616) {
            return false;
        }
        if (c2 <= 2617) {
            return true;
        }
        if (c2 < 2649) {
            return false;
        }
        if (c2 <= 2652 || c2 == 2654) {
            return true;
        }
        if (c2 < 2674) {
            return false;
        }
        if (c2 <= 2676) {
            return true;
        }
        if (c2 < 2693) {
            return false;
        }
        if (c2 <= 2699 || c2 == 2701) {
            return true;
        }
        if (c2 < 2703) {
            return false;
        }
        if (c2 <= 2705) {
            return true;
        }
        if (c2 < 2707) {
            return false;
        }
        if (c2 <= 2728) {
            return true;
        }
        if (c2 < 2730) {
            return false;
        }
        if (c2 <= 2736) {
            return true;
        }
        if (c2 < 2738) {
            return false;
        }
        if (c2 <= 2739) {
            return true;
        }
        if (c2 < 2741) {
            return false;
        }
        if (c2 <= 2745 || c2 == 2749 || c2 == 2784) {
            return true;
        }
        if (c2 < 2821) {
            return false;
        }
        if (c2 <= 2828) {
            return true;
        }
        if (c2 < 2831) {
            return false;
        }
        if (c2 <= 2832) {
            return true;
        }
        if (c2 < 2835) {
            return false;
        }
        if (c2 <= 2856) {
            return true;
        }
        if (c2 < 2858) {
            return false;
        }
        if (c2 <= 2864) {
            return true;
        }
        if (c2 < 2866) {
            return false;
        }
        if (c2 <= 2867) {
            return true;
        }
        if (c2 < 2870) {
            return false;
        }
        if (c2 <= 2873 || c2 == 2877) {
            return true;
        }
        if (c2 < 2908) {
            return false;
        }
        if (c2 <= 2909) {
            return true;
        }
        if (c2 < 2911) {
            return false;
        }
        if (c2 <= 2913) {
            return true;
        }
        if (c2 < 2949) {
            return false;
        }
        if (c2 <= 2954) {
            return true;
        }
        if (c2 < 2958) {
            return false;
        }
        if (c2 <= 2960) {
            return true;
        }
        if (c2 < 2962) {
            return false;
        }
        if (c2 <= 2965) {
            return true;
        }
        if (c2 < 2969) {
            return false;
        }
        if (c2 <= 2970 || c2 == 2972) {
            return true;
        }
        if (c2 < 2974) {
            return false;
        }
        if (c2 <= 2975) {
            return true;
        }
        if (c2 < 2979) {
            return false;
        }
        if (c2 <= 2980) {
            return true;
        }
        if (c2 < 2984) {
            return false;
        }
        if (c2 <= 2986) {
            return true;
        }
        if (c2 < 2990) {
            return false;
        }
        if (c2 <= 2997) {
            return true;
        }
        if (c2 < 2999) {
            return false;
        }
        if (c2 <= 3001) {
            return true;
        }
        if (c2 < 3077) {
            return false;
        }
        if (c2 <= 3084) {
            return true;
        }
        if (c2 < 3086) {
            return false;
        }
        if (c2 <= 3088) {
            return true;
        }
        if (c2 < 3090) {
            return false;
        }
        if (c2 <= 3112) {
            return true;
        }
        if (c2 < 3114) {
            return false;
        }
        if (c2 <= 3123) {
            return true;
        }
        if (c2 < 3125) {
            return false;
        }
        if (c2 <= 3129) {
            return true;
        }
        if (c2 < 3168) {
            return false;
        }
        if (c2 <= 3169) {
            return true;
        }
        if (c2 < 3205) {
            return false;
        }
        if (c2 <= 3212) {
            return true;
        }
        if (c2 < 3214) {
            return false;
        }
        if (c2 <= 3216) {
            return true;
        }
        if (c2 < 3218) {
            return false;
        }
        if (c2 <= 3240) {
            return true;
        }
        if (c2 < 3242) {
            return false;
        }
        if (c2 <= 3251) {
            return true;
        }
        if (c2 < 3253) {
            return false;
        }
        if (c2 <= 3257 || c2 == 3294) {
            return true;
        }
        if (c2 < 3296) {
            return false;
        }
        if (c2 <= 3297) {
            return true;
        }
        if (c2 < 3333) {
            return false;
        }
        if (c2 <= 3340) {
            return true;
        }
        if (c2 < 3342) {
            return false;
        }
        if (c2 <= 3344) {
            return true;
        }
        if (c2 < 3346) {
            return false;
        }
        if (c2 <= 3368) {
            return true;
        }
        if (c2 < 3370) {
            return false;
        }
        if (c2 <= 3385) {
            return true;
        }
        if (c2 < 3424) {
            return false;
        }
        if (c2 <= 3425) {
            return true;
        }
        if (c2 < 3585) {
            return false;
        }
        if (c2 <= 3630 || c2 == 3632) {
            return true;
        }
        if (c2 < 3634) {
            return false;
        }
        if (c2 <= 3635) {
            return true;
        }
        if (c2 < 3648) {
            return false;
        }
        if (c2 <= 3653) {
            return true;
        }
        if (c2 < 3713) {
            return false;
        }
        if (c2 <= 3714 || c2 == 3716) {
            return true;
        }
        if (c2 < 3719) {
            return false;
        }
        if (c2 <= 3720 || c2 == 3722 || c2 == 3725) {
            return true;
        }
        if (c2 < 3732) {
            return false;
        }
        if (c2 <= 3735) {
            return true;
        }
        if (c2 < 3737) {
            return false;
        }
        if (c2 <= 3743) {
            return true;
        }
        if (c2 < 3745) {
            return false;
        }
        if (c2 <= 3747 || c2 == 3749 || c2 == 3751) {
            return true;
        }
        if (c2 < 3754) {
            return false;
        }
        if (c2 <= 3755) {
            return true;
        }
        if (c2 < 3757) {
            return false;
        }
        if (c2 <= 3758 || c2 == 3760) {
            return true;
        }
        if (c2 < 3762) {
            return false;
        }
        if (c2 <= 3763 || c2 == 3773) {
            return true;
        }
        if (c2 < 3776) {
            return false;
        }
        if (c2 <= 3780) {
            return true;
        }
        if (c2 < 3904) {
            return false;
        }
        if (c2 <= 3911) {
            return true;
        }
        if (c2 < 3913) {
            return false;
        }
        if (c2 <= 3945) {
            return true;
        }
        if (c2 < 4256) {
            return false;
        }
        if (c2 <= 4293) {
            return true;
        }
        if (c2 < 4304) {
            return false;
        }
        if (c2 <= 4342 || c2 == 4352) {
            return true;
        }
        if (c2 < 4354) {
            return false;
        }
        if (c2 <= 4355) {
            return true;
        }
        if (c2 < 4357) {
            return false;
        }
        if (c2 <= 4359 || c2 == 4361) {
            return true;
        }
        if (c2 < 4363) {
            return false;
        }
        if (c2 <= 4364) {
            return true;
        }
        if (c2 < 4366) {
            return false;
        }
        if (c2 <= 4370 || c2 == 4412 || c2 == 4414 || c2 == 4416 || c2 == 4428 || c2 == 4430 || c2 == 4432) {
            return true;
        }
        if (c2 < 4436) {
            return false;
        }
        if (c2 <= 4437 || c2 == 4441) {
            return true;
        }
        if (c2 < 4447) {
            return false;
        }
        if (c2 <= 4449 || c2 == 4451 || c2 == 4453 || c2 == 4455 || c2 == 4457) {
            return true;
        }
        if (c2 < 4461) {
            return false;
        }
        if (c2 <= 4462) {
            return true;
        }
        if (c2 < 4466) {
            return false;
        }
        if (c2 <= 4467 || c2 == 4469 || c2 == 4510 || c2 == 4520 || c2 == 4523) {
            return true;
        }
        if (c2 < 4526) {
            return false;
        }
        if (c2 <= 4527) {
            return true;
        }
        if (c2 < 4535) {
            return false;
        }
        if (c2 <= 4536 || c2 == 4538) {
            return true;
        }
        if (c2 < 4540) {
            return false;
        }
        if (c2 <= 4546 || c2 == 4587 || c2 == 4592 || c2 == 4601) {
            return true;
        }
        if (c2 < 7680) {
            return false;
        }
        if (c2 <= 7835) {
            return true;
        }
        if (c2 < 7840) {
            return false;
        }
        if (c2 <= 7929) {
            return true;
        }
        if (c2 < 7936) {
            return false;
        }
        if (c2 <= 7957) {
            return true;
        }
        if (c2 < 7960) {
            return false;
        }
        if (c2 <= 7965) {
            return true;
        }
        if (c2 < 7968) {
            return false;
        }
        if (c2 <= 8005) {
            return true;
        }
        if (c2 < 8008) {
            return false;
        }
        if (c2 <= 8013) {
            return true;
        }
        if (c2 < 8016) {
            return false;
        }
        if (c2 <= 8023 || c2 == 8025 || c2 == 8027 || c2 == 8029) {
            return true;
        }
        if (c2 < 8031) {
            return false;
        }
        if (c2 <= 8061) {
            return true;
        }
        if (c2 < 8064) {
            return false;
        }
        if (c2 <= 8116) {
            return true;
        }
        if (c2 < 8118) {
            return false;
        }
        if (c2 <= 8124 || c2 == 8126) {
            return true;
        }
        if (c2 < 8130) {
            return false;
        }
        if (c2 <= 8132) {
            return true;
        }
        if (c2 < 8134) {
            return false;
        }
        if (c2 <= 8140) {
            return true;
        }
        if (c2 < 8144) {
            return false;
        }
        if (c2 <= 8147) {
            return true;
        }
        if (c2 < 8150) {
            return false;
        }
        if (c2 <= 8155) {
            return true;
        }
        if (c2 < 8160) {
            return false;
        }
        if (c2 <= 8172) {
            return true;
        }
        if (c2 < 8178) {
            return false;
        }
        if (c2 <= 8180) {
            return true;
        }
        if (c2 < 8182) {
            return false;
        }
        if (c2 <= 8188 || c2 == 8486) {
            return true;
        }
        if (c2 < 8490) {
            return false;
        }
        if (c2 <= 8491 || c2 == 8494) {
            return true;
        }
        if (c2 < 8576) {
            return false;
        }
        if (c2 <= 8578 || c2 == 12295) {
            return true;
        }
        if (c2 < 12321) {
            return false;
        }
        if (c2 <= 12329) {
            return true;
        }
        if (c2 < 12353) {
            return false;
        }
        if (c2 <= 12436) {
            return true;
        }
        if (c2 < 12449) {
            return false;
        }
        if (c2 <= 12538) {
            return true;
        }
        if (c2 < 12549) {
            return false;
        }
        if (c2 <= 12588) {
            return true;
        }
        if (c2 < 19968) {
            return false;
        }
        if (c2 <= 40869) {
            return true;
        }
        return c2 >= 44032 && c2 <= 55203;
    }

    public static boolean isXMLNameCharacter(char c2) {
        if (!(isXMLLetter(c2) || isXMLDigit(c2) || c2 == '.' || c2 == '-' || c2 == '_' || c2 == ':')) {
            if (!(c2 >= 768 && (c2 <= 837 || (c2 >= 864 && (c2 <= 865 || (c2 >= 1155 && (c2 <= 1158 || (c2 >= 1425 && (c2 <= 1441 || (c2 >= 1443 && (c2 <= 1465 || (c2 >= 1467 && (c2 <= 1469 || c2 == 1471 || (c2 >= 1473 && (c2 <= 1474 || c2 == 1476 || (c2 >= 1611 && (c2 <= 1618 || c2 == 1648 || (c2 >= 1750 && (c2 <= 1756 || (c2 >= 1757 && (c2 <= 1759 || (c2 >= 1760 && (c2 <= 1764 || (c2 >= 1767 && (c2 <= 1768 || (c2 >= 1770 && (c2 <= 1773 || (c2 >= 2305 && (c2 <= 2307 || c2 == 2364 || (c2 >= 2366 && (c2 <= 2380 || c2 == 2381 || (c2 >= 2385 && (c2 <= 2388 || (c2 >= 2402 && (c2 <= 2403 || (c2 >= 2433 && (c2 <= 2435 || c2 == 2492 || c2 == 2494 || c2 == 2495 || (c2 >= 2496 && (c2 <= 2500 || (c2 >= 2503 && (c2 <= 2504 || (c2 >= 2507 && (c2 <= 2509 || c2 == 2519 || (c2 >= 2530 && (c2 <= 2531 || c2 == 2562 || c2 == 2620 || c2 == 2622 || c2 == 2623 || (c2 >= 2624 && (c2 <= 2626 || (c2 >= 2631 && (c2 <= 2632 || (c2 >= 2635 && (c2 <= 2637 || (c2 >= 2672 && (c2 <= 2673 || (c2 >= 2689 && (c2 <= 2691 || c2 == 2748 || (c2 >= 2750 && (c2 <= 2757 || (c2 >= 2759 && (c2 <= 2761 || (c2 >= 2763 && (c2 <= 2765 || (c2 >= 2817 && (c2 <= 2819 || c2 == 2876 || (c2 >= 2878 && (c2 <= 2883 || (c2 >= 2887 && (c2 <= 2888 || (c2 >= 2891 && (c2 <= 2893 || (c2 >= 2902 && (c2 <= 2903 || (c2 >= 2946 && (c2 <= 2947 || (c2 >= 3006 && (c2 <= 3010 || (c2 >= 3014 && (c2 <= 3016 || (c2 >= 3018 && (c2 <= 3021 || c2 == 3031 || (c2 >= 3073 && (c2 <= 3075 || (c2 >= 3134 && (c2 <= 3140 || (c2 >= 3142 && (c2 <= 3144 || (c2 >= 3146 && (c2 <= 3149 || (c2 >= 3157 && (c2 <= 3158 || (c2 >= 3202 && (c2 <= 3203 || (c2 >= 3262 && (c2 <= 3268 || (c2 >= 3270 && (c2 <= 3272 || (c2 >= 3274 && (c2 <= 3277 || (c2 >= 3285 && (c2 <= 3286 || (c2 >= 3330 && (c2 <= 3331 || (c2 >= 3390 && (c2 <= 3395 || (c2 >= 3398 && (c2 <= 3400 || (c2 >= 3402 && (c2 <= 3405 || c2 == 3415 || c2 == 3633 || (c2 >= 3636 && (c2 <= 3642 || (c2 >= 3655 && (c2 <= 3662 || c2 == 3761 || (c2 >= 3764 && (c2 <= 3769 || (c2 >= 3771 && (c2 <= 3772 || (c2 >= 3784 && (c2 <= 3789 || (c2 >= 3864 && (c2 <= 3865 || c2 == 3893 || c2 == 3895 || c2 == 3897 || c2 == 3902 || c2 == 3903 || (c2 >= 3953 && (c2 <= 3972 || (c2 >= 3974 && (c2 <= 3979 || (c2 >= 3984 && (c2 <= 3989 || c2 == 3991 || (c2 >= 3993 && (c2 <= 4013 || (c2 >= 4017 && (c2 <= 4023 || c2 == 4025 || (c2 >= 8400 && (c2 <= 8412 || c2 == 8417 || (c2 >= 12330 && (c2 <= 12335 || c2 == 12441 || c2 == 12442))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))) {
                if (!(c2 >= 182 && (c2 == 183 || c2 == 720 || c2 == 721 || c2 == 903 || c2 == 1600 || c2 == 3654 || c2 == 3782 || c2 == 12293 || (c2 >= 12337 && (c2 <= 12341 || (c2 >= 12445 && (c2 <= 12446 || (c2 >= 12540 && c2 <= 12542)))))))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isXMLWhitespace(char c2) {
        return c2 == ' ' || c2 == 10 || c2 == 9 || c2 == 13;
    }

    public static final Set<String> jsonCachedSerialNames(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return Platform_commonKt.cachedSerialNames(serialDescriptor);
    }

    public static Job launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        AbstractCoroutine abstractCoroutine;
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineStart coroutineStart2 = (i & 2) != 0 ? CoroutineStart.DEFAULT : null;
        CoroutineContext newCoroutineContext = newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart2.isLazy()) {
            abstractCoroutine = new LazyStandaloneCoroutine(newCoroutineContext, function2);
        } else {
            abstractCoroutine = new StandaloneCoroutine(newCoroutineContext, true);
        }
        coroutineStart2.invoke(function2, abstractCoroutine, abstractCoroutine);
        return abstractCoroutine;
    }

    public static final SmartList<MemberScope> listOfNonEmptyScopes(Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "scopes");
        SmartList<MemberScope> smartList = new SmartList<>();
        for (Object next : iterable) {
            MemberScope memberScope = (MemberScope) next;
            if ((memberScope == null || memberScope == Empty.INSTANCE) ? false : true) {
                smartList.add(next);
            }
        }
        return smartList;
    }

    public static final KotlinType makeNotNullable(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(this)");
        return makeNotNullable;
    }

    public static final KotlinType makeNullable(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(kotlinType, true);
        Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "makeNullable(this)");
        return makeNullableAsSpecified;
    }

    public static final <T, R> Sequence<R> map(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return new TransformingSequence(sequence, function1);
    }

    public static final <T, R> Sequence<R> mapNotNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        TransformingSequence transformingSequence = new TransformingSequence(sequence, function1);
        Intrinsics.checkNotNullParameter(transformingSequence, "<this>");
        Sequence<R> filterNot = filterNot(transformingSequence, SequencesKt___SequencesKt$filterNotNull$1.INSTANCE);
        Intrinsics.checkNotNull(filterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return filterNot;
    }

    public static final CharSequence minify(CharSequence charSequence, int i) {
        if (charSequence.length() < 200) {
            return charSequence;
        }
        String str = ".....";
        if (i == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return Intrinsics.stringPlus(str, charSequence.subSequence(length, charSequence.length()).toString());
        }
        int i2 = i - 30;
        int i3 = i + 30;
        String str2 = i2 <= 0 ? "" : str;
        if (i3 >= charSequence.length()) {
            str = "";
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(str2);
        if (i2 < 0) {
            i2 = 0;
        }
        int length2 = charSequence.length();
        if (i3 > length2) {
            i3 = length2;
        }
        outline73.append(charSequence.subSequence(i2, i3).toString());
        outline73.append(str);
        return outline73.toString();
    }

    public static /* synthetic */ CharSequence minify$default(CharSequence charSequence, int i, int i2) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return minify(charSequence, i);
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext foldCopies = foldCopies(coroutineScope.getCoroutineContext(), coroutineContext, true);
        return (foldCopies == Dispatchers.Default || foldCopies.get(ContinuationInterceptor.Key) != null) ? foldCopies : foldCopies.plus(Dispatchers.Default);
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new HashMap<>(capacity(i));
    }

    public static Label[] newLabels(int i) {
        Label[] labelArr = new Label[i];
        for (int i2 = 0; i2 < i; i2++) {
            labelArr[i2] = new Label();
        }
        return labelArr;
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten(sequenceOf(sequence, sequenceOf(t)));
    }

    public static DateTimeZone readFrom(InputStream inputStream, String str) throws IOException {
        if (inputStream instanceof DataInput) {
            return readFrom((DataInput) inputStream, str);
        }
        return readFrom((DataInput) new DataInputStream(inputStream), str);
    }

    public static long readMillis(DataInput dataInput) throws IOException {
        long readUnsignedByte;
        long j;
        int readUnsignedByte2 = dataInput.readUnsignedByte();
        int i = readUnsignedByte2 >> 6;
        if (i == 1) {
            readUnsignedByte = (long) (dataInput.readUnsignedByte() | ((readUnsignedByte2 << 26) >> 2) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8));
            j = 60000;
        } else if (i == 2) {
            readUnsignedByte = ((((long) readUnsignedByte2) << 58) >> 26) | ((long) (dataInput.readUnsignedByte() << 24)) | ((long) (dataInput.readUnsignedByte() << 16)) | ((long) (dataInput.readUnsignedByte() << 8)) | ((long) dataInput.readUnsignedByte());
            j = 1000;
        } else if (i == 3) {
            return dataInput.readLong();
        } else {
            readUnsignedByte = (long) ((readUnsignedByte2 << 26) >> 26);
            j = DefaultRemoteConfig.SESSION_TIMEOUT_DURATION;
        }
        return readUnsignedByte * j;
    }

    public static final <T> Object recoverResult(Object obj, Continuation<? super T> continuation) {
        return obj instanceof CompletedExceptionally ? TweetUtils.createFailure(((CompletedExceptionally) obj).cause) : obj;
    }

    public static final <T> KSerializer<T> reflectiveOrContextual(SerializersModule serializersModule, KClass<T> kClass, List<? extends KSerializer<Object>> list) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(list, "typeArgumentsSerializers");
        KSerializer<T> serializerOrNull = serializerOrNull(kClass);
        return serializerOrNull == null ? serializersModule.getContextual(kClass, list) : serializerOrNull;
    }

    public static final KotlinType replaceAnnotations(KotlinType kotlinType, Annotations annotations) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        if (!kotlinType.getAnnotations().isEmpty() || !annotations.isEmpty()) {
            return kotlinType.unwrap().replaceAnnotations(annotations);
        }
        return kotlinType;
    }

    /* JADX WARNING: type inference failed for: r0v12, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType replaceArgumentsWithStarProjections(kotlin.reflect.jvm.internal.impl.types.KotlinType r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r10 = r10.unwrap()
            boolean r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
            r1 = 2
            r2 = 0
            r3 = 10
            java.lang.String r4 = "constructor.parameters"
            if (r0 == 0) goto L_0x00b5
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            r0 = r10
            kotlin.reflect.jvm.internal.impl.types.FlexibleType r0 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r0
            kotlin.reflect.jvm.internal.impl.types.SimpleType r5 = r0.lowerBound
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r5.getConstructor()
            java.util.List r6 = r6.getParameters()
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0064
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r5.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r6 = r6.getDeclarationDescriptor()
            if (r6 != 0) goto L_0x0033
            goto L_0x0064
        L_0x0033:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r5.getConstructor()
            java.util.List r6 = r6.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r6, r3)
            r7.<init>(r8)
            java.util.Iterator r6 = r6.iterator()
        L_0x004b:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0060
            java.lang.Object r8 = r6.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r8
            kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl r9 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl
            r9.<init>(r8)
            r7.add(r9)
            goto L_0x004b
        L_0x0060:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r5 = com.twitter.sdk.android.tweetui.TweetUtils.replace$default(r5, r7, r2, r1)
        L_0x0064:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r0.upperBound
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r0.getConstructor()
            java.util.List r6 = r6.getParameters()
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x00b0
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r0.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r6 = r6.getDeclarationDescriptor()
            if (r6 != 0) goto L_0x007f
            goto L_0x00b0
        L_0x007f:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r0.getConstructor()
            java.util.List r6 = r6.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r3 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r6, r3)
            r4.<init>(r3)
            java.util.Iterator r3 = r6.iterator()
        L_0x0097:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00ac
            java.lang.Object r6 = r3.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl r7 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl
            r7.<init>(r6)
            r4.add(r7)
            goto L_0x0097
        L_0x00ac:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = com.twitter.sdk.android.tweetui.TweetUtils.replace$default(r0, r4, r2, r1)
        L_0x00b0:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r5, r0)
            goto L_0x0106
        L_0x00b5:
            boolean r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r0 == 0) goto L_0x010b
            r0 = r10
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r0
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r0.getConstructor()
            java.util.List r5 = r5.getParameters()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0106
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r0.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r5 = r5.getDeclarationDescriptor()
            if (r5 != 0) goto L_0x00d5
            goto L_0x0106
        L_0x00d5:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r0.getConstructor()
            java.util.List r5 = r5.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r3 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r5, r3)
            r4.<init>(r3)
            java.util.Iterator r3 = r5.iterator()
        L_0x00ed:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0102
            java.lang.Object r5 = r3.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5
            kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl r6 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl
            r6.<init>(r5)
            r4.add(r6)
            goto L_0x00ed
        L_0x0102:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = com.twitter.sdk.android.tweetui.TweetUtils.replace$default(r0, r4, r2, r1)
        L_0x0106:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r10 = com.twitter.sdk.android.tweetui.TweetUtils.inheritEnhancement(r0, r10)
            return r10
        L_0x010b:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    public static final KotlinType replaceTypeArguments(KotlinType kotlinType, List<TypeArgument> list) {
        TypeProjectionImpl typeProjectionImpl;
        boolean z = kotlinType.getArguments().size() == list.size();
        if (!_Assertions.ENABLED || z) {
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (TypeArgument typeArgument : list) {
                if (typeArgument != null) {
                    boolean isSubtypeOf = KotlinTypeChecker.DEFAULT.isSubtypeOf(typeArgument.inProjection, typeArgument.outProjection);
                    if (!_Assertions.ENABLED || isSubtypeOf) {
                        if (Intrinsics.areEqual(typeArgument.inProjection, typeArgument.outProjection) || typeArgument.typeParameter.getVariance() == Variance.IN_VARIANCE) {
                            typeProjectionImpl = new TypeProjectionImpl(typeArgument.inProjection);
                        } else if (KotlinBuiltIns.isNothing(typeArgument.inProjection) && typeArgument.typeParameter.getVariance() != Variance.IN_VARIANCE) {
                            Variance variance = Variance.OUT_VARIANCE;
                            if (variance == typeArgument.typeParameter.getVariance()) {
                                variance = Variance.INVARIANT;
                            }
                            new TypeProjectionImpl(variance, typeArgument.outProjection);
                        } else if (KotlinBuiltIns.isNullableAny(typeArgument.outProjection)) {
                            Variance variance2 = Variance.IN_VARIANCE;
                            if (variance2 == typeArgument.typeParameter.getVariance()) {
                                variance2 = Variance.INVARIANT;
                            }
                            new TypeProjectionImpl(variance2, typeArgument.inProjection);
                        } else {
                            Variance variance3 = Variance.OUT_VARIANCE;
                            if (variance3 == typeArgument.typeParameter.getVariance()) {
                                variance3 = Variance.INVARIANT;
                            }
                            new TypeProjectionImpl(variance3, typeArgument.outProjection);
                        }
                        arrayList.add(typeProjectionImpl);
                    } else {
                        DescriptorRenderer withOptions = DescriptorRenderer.Companion.withOptions(CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1.INSTANCE);
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Only consistent enhanced type projection can be converted to type projection, but [");
                        outline73.append(withOptions.render(typeArgument.typeParameter));
                        outline73.append(": <");
                        outline73.append(withOptions.renderType(typeArgument.inProjection));
                        outline73.append(", ");
                        outline73.append(withOptions.renderType(typeArgument.outProjection));
                        outline73.append(">] was found");
                        throw new AssertionError(outline73.toString());
                    }
                } else {
                    throw null;
                }
            }
            return TweetUtils.replace$default(kotlinType, arrayList, null, null, 6);
        }
        throw new AssertionError(Intrinsics.stringPlus("Incorrect type arguments ", list));
    }

    public static final <T> void resume(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z) {
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        Object createFailure = exceptionalResult$kotlinx_coroutines_core != null ? TweetUtils.createFailure(exceptionalResult$kotlinx_coroutines_core) : dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (z) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation<T> continuation2 = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            CoroutineContext context = continuation2.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
            UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? updateUndispatchedCompletion(continuation2, context, updateThreadContext) : null;
            try {
                dispatchedContinuation.continuation.resumeWith(createFailure);
            } finally {
                if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                }
            }
        } else {
            continuation.resumeWith(createFailure);
        }
    }

    public static final <T> T runBlocking(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        CoroutineContext coroutineContext2;
        EventLoop eventLoop;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        CompletedExceptionally completedExceptionally = null;
        if (continuationInterceptor == null) {
            ThreadLocalEventLoop threadLocalEventLoop = ThreadLocalEventLoop.INSTANCE;
            eventLoop = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
            coroutineContext2 = newCoroutineContext(GlobalScope.INSTANCE, coroutineContext.plus(eventLoop));
        } else {
            if (continuationInterceptor instanceof EventLoop) {
                EventLoop eventLoop2 = (EventLoop) continuationInterceptor;
            }
            ThreadLocalEventLoop threadLocalEventLoop2 = ThreadLocalEventLoop.INSTANCE;
            eventLoop = ThreadLocalEventLoop.ref.get();
            coroutineContext2 = newCoroutineContext(GlobalScope.INSTANCE, coroutineContext);
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(coroutineContext2, currentThread, eventLoop);
        CoroutineStart.DEFAULT.invoke(function2, blockingCoroutine, blockingCoroutine);
        EventLoop eventLoop3 = blockingCoroutine.eventLoop;
        if (eventLoop3 != null) {
            EventLoop.incrementUseCount$default(eventLoop3, false, 1, completedExceptionally);
        }
        while (!Thread.interrupted()) {
            try {
                EventLoop eventLoop4 = blockingCoroutine.eventLoop;
                long processNextEvent = eventLoop4 != null ? eventLoop4.processNextEvent() : Long.MAX_VALUE;
                if (!(!(blockingCoroutine.getState$kotlinx_coroutines_core() instanceof Incomplete))) {
                    LockSupport.parkNanos(blockingCoroutine, processNextEvent);
                } else {
                    T unboxState = JobSupportKt.unboxState(blockingCoroutine.getState$kotlinx_coroutines_core());
                    if (unboxState instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) unboxState;
                    }
                    if (completedExceptionally == null) {
                        return unboxState;
                    }
                    throw completedExceptionally.cause;
                }
            } finally {
                EventLoop eventLoop5 = blockingCoroutine.eventLoop;
                if (eventLoop5 != null) {
                    EventLoop.decrementUseCount$default(eventLoop5, false, 1, completedExceptionally);
                }
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        blockingCoroutine.cancelImpl$kotlinx_coroutines_core(interruptedException);
        throw interruptedException;
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        return runBlocking((i & 1) != 0 ? EmptyCoroutineContext.INSTANCE : null, function2);
    }

    public static long safeAdd(long j, long j2) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        StringBuilder outline76 = GeneratedOutlineSupport.outline76("The calculation caused an overflow: ", j, " + ");
        outline76.append(j2);
        throw new ArithmeticException(outline76.toString());
    }

    public static int safeToInt(long j) {
        if (-2147483648L <= j && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException(GeneratedOutlineSupport.outline45("Value cannot fit in an int: ", j));
    }

    public static final <T> Sequence<T> sequenceOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length == 0) {
            return EmptySequence.INSTANCE;
        }
        return TweetUtils.asSequence(tArr);
    }

    public static final KSerializer<Object> serializer(SerializersModule serializersModule, java.lang.reflect.Type type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer<Object> serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt = SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, true);
        if (serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt != null) {
            return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt;
        }
        Platform_commonKt.serializerNotRegistered(SerializersKt__SerializersJvmKt.kclass$SerializersKt__SerializersJvmKt(type));
        throw null;
    }

    public static final <T> KSerializer<T> serializerOrNull(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer<T> constructSerializerForGivenTypeArgs = constructSerializerForGivenTypeArgs(kClass, new KSerializer[0]);
        return constructSerializerForGivenTypeArgs == null ? PrimitivesKt.builtinSerializerOrNull(kClass) : constructSerializerForGivenTypeArgs;
    }

    public static void startCoroutineCancellable$default(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i) {
        int i2 = i & 4;
        try {
            DispatchedContinuationKt.resumeCancellableWith(TweetUtils.intercepted(TweetUtils.createCoroutineUnintercepted(function2, obj, continuation)), Unit.INSTANCE, null);
        } catch (Throwable th) {
            dispatcherFailure(continuation, th);
            throw null;
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        try {
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2);
            obj = function2.invoke(r, scopeCoroutine);
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th, false, 2);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (obj == coroutineSingletons) {
            return coroutineSingletons;
        }
        Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(obj);
        if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
        if (!(makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
            return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
        }
        throw ((CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
    }

    public static int subFrom(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = ((((long) iArr2[i2]) & 4294967295L) - (4294967295L & ((long) iArr[i2]))) + j;
            iArr2[i2] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object suspendAndThrow(java.lang.Exception r4, kotlin.coroutines.Continuation<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            goto L_0x0054
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.Default
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>(r0, r4)
            r5.dispatch(r2, r3)
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r4 != r4) goto L_0x0051
            java.lang.String r5 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
        L_0x0051:
            if (r4 != r1) goto L_0x0054
            return r1
        L_0x0054:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.suspendAndThrow(java.lang.Exception, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final WriteMode switchMode(Json json, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "desc");
        SerialKind kind = serialDescriptor.getKind();
        if (kind instanceof PolymorphicKind) {
            return WriteMode.POLY_OBJ;
        }
        if (Intrinsics.areEqual(kind, LIST.INSTANCE)) {
            return WriteMode.LIST;
        }
        if (!Intrinsics.areEqual(kind, MAP.INSTANCE)) {
            return WriteMode.OBJ;
        }
        SerialDescriptor carrierDescriptor = carrierDescriptor(serialDescriptor.getElementDescriptor(0), json.serializersModule);
        SerialKind kind2 = carrierDescriptor.getKind();
        if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual(kind2, ENUM.INSTANCE)) {
            return WriteMode.MAP;
        }
        if (json.configuration.allowStructuredMapKeys) {
            return WriteMode.LIST;
        }
        throw InvalidKeyKindException(carrierDescriptor);
    }

    public static final long systemProp(String str, long j, long j2, long j3) {
        String systemProp = SystemPropsKt__SystemPropsKt.systemProp(str);
        if (systemProp == null) {
            return j;
        }
        Long longOrNull = CharsKt__CharKt.toLongOrNull(systemProp);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            boolean z = false;
            if (j2 <= longValue && longValue <= j3) {
                z = true;
            }
            if (z) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + ExtendedMessageFormat.QUOTE).toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + ExtendedMessageFormat.QUOTE).toString());
    }

    public static int systemProp$default(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return (int) systemProp(str, (long) i, (long) i2, (long) i3);
    }

    public static final Void throwInvalidFloatingPointDecoded(AbstractJsonLexer abstractJsonLexer, Number number) {
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "<this>");
        Intrinsics.checkNotNullParameter(number, LoginReactModule.RESULT);
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 0, 2, null);
        throw null;
    }

    public static final void throwMissingFieldException(int i, int i2, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i3 = (~i) & i2;
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if ((i3 & 1) != 0) {
                arrayList.add(serialDescriptor.getElementName(i4));
            }
            i3 >>>= 1;
            if (i5 < 32) {
                i4 = i5;
            } else {
                throw new MissingFieldException(arrayList, serialDescriptor.getSerialName());
            }
        }
    }

    public static final Void throwSubtypeNotRegistered(String str, KClass<?> kClass) {
        String str2;
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        String str3 = "in the scope of '" + kClass.getSimpleName() + ExtendedMessageFormat.QUOTE;
        if (str == null) {
            str2 = Intrinsics.stringPlus("Class discriminator was missing and no default polymorphic serializers were registered ", str3);
        } else {
            str2 = "Class '" + str + "' is not registered for polymorphic serialization " + str3 + ".\nMark the base class as 'sealed' or register the serializer explicitly.";
        }
        throw new SerializationException(str2);
    }

    public static final Double toDoubleOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static JSON toJSON(Object obj, JsonConfig jsonConfig) {
        if (obj instanceof JSONString) {
            return toJSON(((JSONString) obj).toJSONString(), jsonConfig);
        }
        if (obj instanceof String) {
            return toJSON((String) obj, jsonConfig);
        }
        if (JSONUtils.isArray(obj)) {
            return JSONArray.fromObject(obj, jsonConfig);
        }
        try {
            return JSONObject.fromObject(obj, jsonConfig);
        } catch (JSONException unused) {
            if (obj instanceof JSONTokener) {
                ((JSONTokener) obj).myIndex = 0;
            }
            return JSONArray.fromObject(obj, jsonConfig);
        }
    }

    public static final <T> List<T> toList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return TweetUtils.optimizeReadOnlyList(toMutableList(sequence));
    }

    public static final String toLowerCase(String str, boolean z) {
        if (z) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            StringBuilder sb = new StringBuilder(str.length());
            int length = str.length();
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                i++;
                if ('A' <= charAt && charAt <= 'Z') {
                    charAt = Character.toLowerCase(charAt);
                }
                sb.append(charAt);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
            return sb2;
        }
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final <T> List<T> toMutableList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, Values.DESTINATION);
        for (Object add : sequence) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static final <T> Object toState(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable r0 = Result.m884exceptionOrNullimpl(obj);
        if (r0 != null) {
            return new CompletedExceptionally(r0, false, 2);
        }
        if (function1 != null) {
            return new CompletedWithCancellation(obj, function1);
        }
        return obj;
    }

    public static <T> KSerializer<?>[] typeParametersSerializers(GeneratedSerializer<T> generatedSerializer) {
        Intrinsics.checkNotNullParameter(generatedSerializer, "this");
        return PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY;
    }

    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        UndispatchedCoroutine<?> undispatchedCoroutine = null;
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (!(coroutineContext.get(UndispatchedMarker.INSTANCE) != null)) {
            return null;
        }
        CoroutineStackFrame coroutineStackFrame = (CoroutineStackFrame) continuation;
        while (true) {
            if (!(coroutineStackFrame instanceof DispatchedCoroutine)) {
                coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                if (coroutineStackFrame != null) {
                    if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                        undispatchedCoroutine = (UndispatchedCoroutine) coroutineStackFrame;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        if (undispatchedCoroutine != null) {
            undispatchedCoroutine.threadStateToRecover.set(new Pair(coroutineContext, obj));
        }
        return undispatchedCoroutine;
    }

    public static void verifyValueBounds(DateTimeField dateTimeField, int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new IllegalFieldValueException(((BaseDateTimeField) dateTimeField).iType, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    /* JADX INFO: finally extract failed */
    public static final <T> Object withContext(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        CoroutineContext coroutineContext2;
        Object obj;
        CoroutineContext context = continuation.getContext();
        boolean z = false;
        if (!hasCopyableElements(coroutineContext)) {
            coroutineContext2 = context.plus(coroutineContext);
        } else {
            coroutineContext2 = foldCopies(context, coroutineContext, false);
        }
        ensureActive(coroutineContext2);
        if (coroutineContext2 == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(coroutineContext2, continuation);
            obj = startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        } else if (Intrinsics.areEqual(coroutineContext2.get(ContinuationInterceptor.Key), context.get(ContinuationInterceptor.Key))) {
            UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(coroutineContext2, continuation);
            Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext2, null);
            try {
                Object startUndispatchedOrReturn = startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, function2);
                ThreadContextKt.restoreThreadContext(coroutineContext2, updateThreadContext);
                obj = startUndispatchedOrReturn;
            } catch (Throwable th) {
                ThreadContextKt.restoreThreadContext(coroutineContext2, updateThreadContext);
                throw th;
            }
        } else {
            DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(coroutineContext2, continuation);
            startCoroutineCancellable$default(function2, dispatchedCoroutine, dispatchedCoroutine, null, 4);
            while (true) {
                int i = dispatchedCoroutine._decision;
                if (i == 0) {
                    if (DispatchedCoroutine._decision$FU.compareAndSet(dispatchedCoroutine, 0, 1)) {
                        z = true;
                        break;
                    }
                } else if (i != 2) {
                    throw new IllegalStateException("Already suspended".toString());
                }
            }
            if (z) {
                obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            } else {
                obj = JobSupportKt.unboxState(dispatchedCoroutine.getState$kotlinx_coroutines_core());
                if (obj instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) obj).cause;
                }
            }
        }
        if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return obj;
    }

    public static final JsonDecodingException JsonDecodingException(int i, String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        return JsonDecodingException(i, str + "\nJSON input: " + minify(charSequence, i));
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        cancel(coroutineContext, null);
    }

    public static /* synthetic */ long systemProp$default(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return systemProp(str, j, j4, j3);
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * FTPReply.PATHNAME_CREATED) ^ iArr[length];
        }
    }

    public static final KSerializer<Object> serializer(SerializersModule serializersModule, KType kType) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(kType, "type");
        KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt = SerializersKt__SerializersJvmKt.serializerByKTypeImpl$SerializersKt__SerializersKt(serializersModule, kType, true);
        if (serializerByKTypeImpl$SerializersKt__SerializersKt != null) {
            return serializerByKTypeImpl$SerializersKt__SerializersKt;
        }
        KClass<Object> kclass = Platform_commonKt.kclass(kType);
        Intrinsics.checkNotNullParameter(kclass, "<this>");
        Platform_commonKt.serializerNotRegistered(kclass);
        throw null;
    }

    public static boolean areEqual(int[] iArr, int[] iArr2) {
        if (iArr == iArr2) {
            return true;
        }
        if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
            return false;
        }
        for (int i = 0; i != iArr.length; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [org.joda.time.DateTimeZone] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.DateTimeZone readFrom(java.io.DataInput r6, java.lang.String r7) throws java.io.IOException {
        /*
            int r0 = r6.readUnsignedByte()
            r1 = 67
            if (r0 == r1) goto L_0x003b
            r1 = 70
            if (r0 == r1) goto L_0x001d
            r1 = 80
            if (r0 != r1) goto L_0x0015
            org.joda.time.tz.DateTimeZoneBuilder$PrecalculatedZone r6 = org.joda.time.tz.DateTimeZoneBuilder$PrecalculatedZone.readFrom(r6, r7)
            return r6
        L_0x0015:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "Invalid encoding"
            r6.<init>(r7)
            throw r6
        L_0x001d:
            org.joda.time.tz.FixedDateTimeZone r0 = new org.joda.time.tz.FixedDateTimeZone
            java.lang.String r1 = r6.readUTF()
            long r2 = readMillis(r6)
            int r3 = (int) r2
            long r4 = readMillis(r6)
            int r6 = (int) r4
            r0.<init>(r7, r1, r3, r6)
            org.joda.time.DateTimeZone r6 = org.joda.time.DateTimeZone.UTC
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L_0x003a
            org.joda.time.DateTimeZone r0 = org.joda.time.DateTimeZone.UTC
        L_0x003a:
            return r0
        L_0x003b:
            org.joda.time.tz.DateTimeZoneBuilder$PrecalculatedZone r6 = org.joda.time.tz.DateTimeZoneBuilder$PrecalculatedZone.readFrom(r6, r7)
            org.joda.time.tz.CachedDateTimeZone r6 = org.joda.time.tz.CachedDateTimeZone.forZone(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.readFrom(java.io.DataInput, java.lang.String):org.joda.time.DateTimeZone");
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule serializersModule, java.lang.reflect.Type type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, false);
    }

    public static final KSerializer<Byte> serializer(ByteCompanionObject byteCompanionObject) {
        Intrinsics.checkNotNullParameter(byteCompanionObject, "<this>");
        return ByteSerializer.INSTANCE;
    }

    public static final boolean systemProp(String str, boolean z) {
        String systemProp = SystemPropsKt__SystemPropsKt.systemProp(str);
        return systemProp != null ? Boolean.parseBoolean(systemProp) : z;
    }

    public static final KSerializer<Short> serializer(ShortCompanionObject shortCompanionObject) {
        Intrinsics.checkNotNullParameter(shortCompanionObject, "<this>");
        return ShortSerializer.INSTANCE;
    }

    public static final KSerializer<Integer> serializer(IntCompanionObject intCompanionObject) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return IntSerializer.INSTANCE;
    }

    public static String checkNamespaceCollision(Namespace namespace, Namespace namespace2) {
        String str = namespace.prefix;
        String str2 = namespace.uri;
        String str3 = namespace2.prefix;
        String str4 = namespace2.uri;
        if (!str.equals(str3) || str2.equals(str4)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The namespace prefix \"");
        stringBuffer.append(str);
        stringBuffer.append("\" collides");
        return stringBuffer.toString();
    }

    public static final KSerializer<Long> serializer(LongCompanionObject longCompanionObject) {
        Intrinsics.checkNotNullParameter(longCompanionObject, "<this>");
        return LongSerializer.INSTANCE;
    }

    public static final <T> DeserializationStrategy<? extends T> findPolymorphicSerializer(AbstractPolymorphicSerializer<T> abstractPolymorphicSerializer, CompositeDecoder compositeDecoder, String str) {
        Intrinsics.checkNotNullParameter(abstractPolymorphicSerializer, "<this>");
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        DeserializationStrategy<? extends T> findPolymorphicSerializerOrNull = abstractPolymorphicSerializer.findPolymorphicSerializerOrNull(compositeDecoder, str);
        if (findPolymorphicSerializerOrNull != null) {
            return findPolymorphicSerializerOrNull;
        }
        throwSubtypeNotRegistered(str, abstractPolymorphicSerializer.getBaseClass());
        throw null;
    }

    public static final KSerializer<String> serializer(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        return StringSerializer.INSTANCE;
    }

    public static JSON toJSON(String str, JsonConfig jsonConfig) {
        if (str.startsWith("[")) {
            return JSONArray.fromObject(str, jsonConfig);
        }
        if (str.startsWith("{")) {
            return JSONObject.fromObject(str, jsonConfig);
        }
        if ("null".equals(str)) {
            return JSONNull.instance;
        }
        throw new JSONException((String) "Invalid JSON String");
    }

    public static String checkNamespaceCollision(Namespace namespace, List list) {
        String str = null;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (str == null && it.hasNext()) {
            Object next = it.next();
            if (next instanceof Attribute) {
                str = checkNamespaceCollision(namespace, ((Attribute) next).namespace);
                if (str != null) {
                    str = GeneratedOutlineSupport.outline49(str, " with an attribute namespace prefix on the element");
                }
            } else if (next instanceof Element) {
                str = checkNamespaceCollision(namespace, (Element) next);
            } else if (next instanceof Namespace) {
                str = checkNamespaceCollision(namespace, (Namespace) next);
                if (str != null) {
                    str = GeneratedOutlineSupport.outline49(str, " with an additional namespace declared by the element");
                }
            }
        }
        return str;
    }

    public static String checkNamespaceCollision(Attribute attribute, Element element) {
        Namespace namespace = attribute.namespace;
        if ("".equals(namespace.prefix)) {
            return null;
        }
        return checkNamespaceCollision(namespace, element);
    }
}
