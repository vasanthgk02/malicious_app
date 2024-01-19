package com.twitter.sdk.android.tweetui;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.RectF;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.amazon.identity.auth.device.api.authorization.Region;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.facebook.react.bridge.PromiseImpl;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import com.mpl.androidapp.login.LoginReactModule;
import com.netcore.android.notification.SMTNotificationConstants;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.squareup.picasso.NetworkRequestHandler;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetEntities;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.core.models.VideoInfo.Variant;
import com.xiaomi.mipush.sdk.Constants;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories$ActivityEntryPoint;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories$FragmentEntryPoint;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories$InternalFactoryFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.internal.GeneratedComponentManager;
import in.juspay.hypersdk.core.InflateView;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result.Failure;
import kotlin.SafePublicationLazyImpl;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.UnsafeLazyImpl;
import kotlin._Assertions;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1;
import kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$1;
import kotlin.collections.CollectionSystemProperties;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IntIterator;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl.Accessor;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal;
import kotlin.reflect.jvm.internal.ReflectProperties$LazyVal;
import kotlin.reflect.jvm.internal.RuntimeTypeMapperKt$signature$1;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$2;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$result$1;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$toString$2;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.CapturedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities$PackageVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities$ProtectedAndPackage;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities$ProtectedStaticVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$2;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils$1;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$childForClassOrPackage$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$copyWithNewDefaultTypeQualifiers$1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfigurationImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtensionDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$createCapturedIfNeeded$1;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt$WhenMappings;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt$starProjectionType$1;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion$createByConstructorsMap$1;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerProcedureCallbacksImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.sequences.EmptySequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.TakeWhileSequence;
import kotlin.text.CharsKt__CharKt;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public final class TweetUtils {
    public static Thread mainThread;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i == 1 || i == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static /* synthetic */ void $$$reportNull$$$01(int i) {
        Object[] objArr = new Object[3];
        if (i == 1 || i == 2) {
            objArr[0] = "companionObject";
        } else if (i != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static /* synthetic */ void $$$reportNull$$$02(int i) {
        String str = i != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 18 ? 3 : 2)];
        switch (i) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
            default:
                objArr[0] = "name";
                break;
        }
        if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        throw (i != 18 ? new IllegalArgumentException(format) : new IllegalStateException(format));
    }

    public static /* synthetic */ void $$$reportNull$$$03(int i) {
        String str = (i == 12 || i == 23 || i == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 12 || i == 23 || i == 25) ? 2 : 3)];
        switch (i) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
            default:
                objArr[0] = "propertyDescriptor";
                break;
        }
        if (i == 12) {
            objArr[1] = "createSetter";
        } else if (i == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 12 || i == 23 || i == 25) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public static /* synthetic */ void $$$reportNull$$$04(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 4 ? 3 : 2)];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = LoginReactModule.RESULT;
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        throw (i != 4 ? new IllegalArgumentException(format) : new IllegalStateException(format));
    }

    public static Animation a(float f2, float f3, float f4, float f5, int i, float f6, int i2, float f7, long j) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f4, f5, i, f6, i2, f7);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(j);
        return scaleAnimation;
    }

    public static Animation a(float f2, float f3, int i, float f4, int i2, float f5, long j) {
        RotateAnimation rotateAnimation = new RotateAnimation(f2, f3, i, f4, i2, f5);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(j);
        return rotateAnimation;
    }

    public static Animation a(int i, float f2, int i2, float f3, int i3, float f4, int i4, float f5, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(i, f2, i2, f3, i3, f4, i4, f5);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(j);
        return translateAnimation;
    }

    public static Region a(Context context) {
        return Region.valueOf(context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).getString("com.amazon.lwa.regionMode", Region.AUTO.toString()));
    }

    public static final FqName access$child(FqName fqName, String str) {
        FqName child = fqName.child(Name.identifier(str));
        Intrinsics.checkNotNullExpressionValue(child, "child(Name.identifier(name))");
        return child;
    }

    public static final FqName access$childSafe(FqNameUnsafe fqNameUnsafe, String str) {
        FqName safe = fqNameUnsafe.child(Name.identifier(str)).toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "child(Name.identifier(name)).toSafe()");
        return safe;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.calls.Caller access$computeCallerForAccessor(kotlin.reflect.jvm.internal.KPropertyImpl.Accessor r6, boolean r7) {
        /*
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl r0 = kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Companion
            kotlin.text.Regex r0 = kotlin.reflect.jvm.internal.KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE
            kotlin.reflect.jvm.internal.KPropertyImpl r1 = r6.getProperty()
            java.lang.String r1 = r1.signature
            boolean r0 = r0.matches(r1)
            if (r0 == 0) goto L_0x0014
            kotlin.reflect.jvm.internal.calls.ThrowingCaller r6 = kotlin.reflect.jvm.internal.calls.ThrowingCaller.INSTANCE
            goto L_0x020b
        L_0x0014:
            kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$1 r0 = new kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$1
            r0.<init>(r6)
            kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$2 r1 = new kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$2
            r1.<init>(r6)
            kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$3 r2 = new kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$3
            r2.<init>(r6, r7, r1, r0)
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r1 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.KPropertyImpl r1 = r6.getProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r1 = r1.getDescriptor()
            kotlin.reflect.jvm.internal.JvmPropertySignature r1 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.mapPropertySignature(r1)
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty
            if (r3 == 0) goto L_0x0157
            kotlin.reflect.jvm.internal.JvmPropertySignature$KotlinProperty r1 = (kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty) r1
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r3 = r1.signature
            r4 = 0
            if (r7 == 0) goto L_0x0045
            boolean r7 = r3.hasGetter()
            if (r7 == 0) goto L_0x004e
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r7 = r3.getter_
            goto L_0x004f
        L_0x0045:
            boolean r7 = r3.hasSetter()
            if (r7 == 0) goto L_0x004e
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r7 = r3.setter_
            goto L_0x004f
        L_0x004e:
            r7 = r4
        L_0x004f:
            if (r7 == 0) goto L_0x006b
            kotlin.reflect.jvm.internal.KPropertyImpl r3 = r6.getProperty()
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl r3 = r3.container
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r4 = r1.nameResolver
            int r5 = r7.name_
            java.lang.String r4 = r4.getString(r5)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r1 = r1.nameResolver
            int r7 = r7.desc_
            java.lang.String r7 = r1.getString(r7)
            java.lang.reflect.Method r4 = r3.findMethodBySignature(r4, r7)
        L_0x006b:
            if (r4 != 0) goto L_0x0108
            kotlin.reflect.jvm.internal.KPropertyImpl r7 = r6.getProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r7 = r7.getDescriptor()
            boolean r7 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass(r7)
            if (r7 == 0) goto L_0x00e1
            kotlin.reflect.jvm.internal.KPropertyImpl r7 = r6.getProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r7 = r7.getDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r7 = r7.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INTERNAL
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            if (r7 == 0) goto L_0x00e1
            kotlin.reflect.jvm.internal.KPropertyImpl r7 = r6.getProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r7 = r7.getDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r7 = r7.getContainingDeclaration()
            java.lang.Class r7 = toInlineClass(r7)
            if (r7 == 0) goto L_0x00c5
            kotlin.reflect.jvm.internal.KPropertyImpl r0 = r6.getProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = r0.getDescriptor()
            java.lang.reflect.Method r7 = getUnboxMethod(r7, r0)
            boolean r0 = r6.isBound()
            if (r0 == 0) goto L_0x00be
            kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass$Bound r0 = new kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass$Bound
            java.lang.Object r1 = getBoundReceiver(r6)
            r0.<init>(r7, r1)
            goto L_0x018a
        L_0x00be:
            kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass$Unbound r0 = new kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass$Unbound
            r0.<init>(r7)
            goto L_0x018a
        L_0x00c5:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r7 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r0 = "Underlying property of inline class "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            kotlin.reflect.jvm.internal.KPropertyImpl r6 = r6.getProperty()
            r0.append(r6)
            java.lang.String r6 = " should have a field"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L_0x00e1:
            kotlin.reflect.jvm.internal.KPropertyImpl r7 = r6.getProperty()
            java.lang.reflect.Field r7 = r7.getJavaField()
            if (r7 == 0) goto L_0x00f1
            kotlin.reflect.jvm.internal.calls.CallerImpl r0 = r2.invoke(r7)
            goto L_0x018a
        L_0x00f1:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r7 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r0 = "No accessors or field is found for property "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            kotlin.reflect.jvm.internal.KPropertyImpl r6 = r6.getProperty()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L_0x0108:
            int r7 = r4.getModifiers()
            boolean r7 = java.lang.reflect.Modifier.isStatic(r7)
            if (r7 != 0) goto L_0x0129
            boolean r7 = r6.isBound()
            if (r7 == 0) goto L_0x0122
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundInstance r7 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundInstance
            java.lang.Object r0 = getBoundReceiver(r6)
            r7.<init>(r4, r0)
            goto L_0x0127
        L_0x0122:
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Instance r7 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Instance
            r7.<init>(r4)
        L_0x0127:
            r0 = r7
            goto L_0x018a
        L_0x0129:
            boolean r7 = r0.invoke()
            if (r7 == 0) goto L_0x0141
            boolean r7 = r6.isBound()
            if (r7 == 0) goto L_0x013b
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundJvmStaticInObject r7 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundJvmStaticInObject
            r7.<init>(r4)
            goto L_0x0127
        L_0x013b:
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$JvmStaticInObject r7 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$JvmStaticInObject
            r7.<init>(r4)
            goto L_0x0127
        L_0x0141:
            boolean r7 = r6.isBound()
            if (r7 == 0) goto L_0x0151
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundStatic r7 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundStatic
            java.lang.Object r0 = getBoundReceiver(r6)
            r7.<init>(r4, r0)
            goto L_0x0127
        L_0x0151:
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Static r7 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Static
            r7.<init>(r4)
            goto L_0x0127
        L_0x0157:
            boolean r0 = r1 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField
            if (r0 == 0) goto L_0x0164
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaField r1 = (kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField) r1
            java.lang.reflect.Field r7 = r1.field
            kotlin.reflect.jvm.internal.calls.CallerImpl r0 = r2.invoke(r7)
            goto L_0x018a
        L_0x0164:
            boolean r0 = r1 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty
            if (r0 == 0) goto L_0x01aa
            if (r7 == 0) goto L_0x016f
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaMethodProperty r1 = (kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty) r1
            java.lang.reflect.Method r7 = r1.getterMethod
            goto L_0x0175
        L_0x016f:
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaMethodProperty r1 = (kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty) r1
            java.lang.reflect.Method r7 = r1.setterMethod
            if (r7 == 0) goto L_0x0195
        L_0x0175:
            boolean r0 = r6.isBound()
            if (r0 == 0) goto L_0x0185
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundInstance r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundInstance
            java.lang.Object r1 = getBoundReceiver(r6)
            r0.<init>(r7, r1)
            goto L_0x018a
        L_0x0185:
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Instance r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Instance
            r0.<init>(r7)
        L_0x018a:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor r6 = r6.getDescriptor()
            r7 = 0
            kotlin.reflect.jvm.internal.calls.Caller r6 = createInlineClassAwareCallerIfNeeded(r0, r6, r7)
            goto L_0x020b
        L_0x0195:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r6 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r7 = "No source found for setter of Java method property: "
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            java.lang.reflect.Method r0 = r1.getterMethod
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x01aa:
            boolean r0 = r1 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.MappedKotlinProperty
            if (r0 == 0) goto L_0x023a
            if (r7 == 0) goto L_0x01b5
            kotlin.reflect.jvm.internal.JvmPropertySignature$MappedKotlinProperty r1 = (kotlin.reflect.jvm.internal.JvmPropertySignature.MappedKotlinProperty) r1
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r7 = r1.getterSignature
            goto L_0x01bb
        L_0x01b5:
            kotlin.reflect.jvm.internal.JvmPropertySignature$MappedKotlinProperty r1 = (kotlin.reflect.jvm.internal.JvmPropertySignature.MappedKotlinProperty) r1
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r7 = r1.setterSignature
            if (r7 == 0) goto L_0x0223
        L_0x01bb:
            kotlin.reflect.jvm.internal.KPropertyImpl r0 = r6.getProperty()
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl r0 = r0.container
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Method r7 = r7.signature
            java.lang.String r1 = r7.name
            java.lang.String r7 = r7.desc
            java.lang.reflect.Method r7 = r0.findMethodBySignature(r1, r7)
            if (r7 == 0) goto L_0x020c
            int r0 = r7.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            r0 = r0 ^ 1
            boolean r1 = kotlin._Assertions.ENABLED
            if (r1 == 0) goto L_0x01f5
            if (r0 == 0) goto L_0x01de
            goto L_0x01f5
        L_0x01de:
            java.lang.String r7 = "Mapped property cannot have a static accessor: "
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            kotlin.reflect.jvm.internal.KPropertyImpl r6 = r6.getProperty()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>(r6)
            throw r7
        L_0x01f5:
            boolean r0 = r6.isBound()
            if (r0 == 0) goto L_0x0206
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundInstance r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundInstance
            java.lang.Object r6 = getBoundReceiver(r6)
            r0.<init>(r7, r6)
            r6 = r0
            goto L_0x020b
        L_0x0206:
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Instance r6 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Instance
            r6.<init>(r7)
        L_0x020b:
            return r6
        L_0x020c:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r7 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r0 = "No accessor found for property "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            kotlin.reflect.jvm.internal.KPropertyImpl r6 = r6.getProperty()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L_0x0223:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r7 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r0 = "No setter found for property "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            kotlin.reflect.jvm.internal.KPropertyImpl r6 = r6.getProperty()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L_0x023a:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.access$computeCallerForAccessor(kotlin.reflect.jvm.internal.KPropertyImpl$Accessor, boolean):kotlin.reflect.jvm.internal.calls.Caller");
    }

    public static final String access$errorMessage(Object obj) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ClassicTypeCheckerContext couldn't handle ");
        outline73.append(Reflection.getOrCreateKotlinClass(obj.getClass()));
        outline73.append(' ');
        outline73.append(obj);
        return outline73.toString();
    }

    public static final String access$getSignature$p(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        sb.append(joinToString$default(parameterTypes, "", "(", ")", 0, null, RuntimeTypeMapperKt$signature$1.INSTANCE, 24));
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "returnType");
        sb.append(ReflectClassUtilKt.getDesc(returnType));
        return sb.toString();
    }

    public static final int access$reverseElementIndex(List list, int i) {
        if (new IntRange(0, getLastIndex(list)).contains(i)) {
            return getLastIndex(list) - i;
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Element index ", i, " must be in range [");
        outline74.append(new IntRange(0, getLastIndex(list)));
        outline74.append("].");
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z = true;
            }
        }
        return z;
    }

    public static final void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(th2, MqttServiceConstants.TRACE_EXCEPTION);
        if (th != th2) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, th2);
        }
    }

    public static int argumentsCount(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof KotlinType) {
            return ((KotlinType) kotlinTypeMarker).getArguments().size();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList(new ArrayAsCollection(tArr, true));
    }

    public static final <E> E[] arrayOfUninitializedElements(int i) {
        if (i >= 0) {
            return new Object[i];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        if (simpleTypeMarker instanceof SimpleType) {
            return (TypeArgumentListMarker) simpleTypeMarker;
        }
        StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
        outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
        throw new IllegalArgumentException(outline83.toString().toString());
    }

    public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        if (!(simpleTypeMarker instanceof SimpleType)) {
            StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
            outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(outline83.toString().toString());
        } else if (simpleTypeMarker instanceof NewCapturedType) {
            return (NewCapturedType) simpleTypeMarker;
        } else {
            return null;
        }
    }

    public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        if (!(simpleTypeMarker instanceof SimpleType)) {
            StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
            outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(outline83.toString().toString());
        } else if (simpleTypeMarker instanceof DefinitelyNotNullType) {
            return (DefinitelyNotNullType) simpleTypeMarker;
        } else {
            return null;
        }
    }

    public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(flexibleTypeMarker, "receiver");
        if (!(flexibleTypeMarker instanceof FlexibleType)) {
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
        } else if (flexibleTypeMarker instanceof DynamicType) {
            return (DynamicType) flexibleTypeMarker;
        } else {
            return null;
        }
    }

    public static final FlexibleType asFlexibleType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return (FlexibleType) kotlinType.unwrap();
    }

    public static final <T> Iterable<T> asIterable(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return EmptyList.INSTANCE;
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(tArr);
    }

    public static final <T> Sequence<T> asSequence(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return EmptySequence.INSTANCE;
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1(tArr);
    }

    public static SimpleTypeMarker asSimpleType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof KotlinType) {
            UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
            if (unwrap instanceof SimpleType) {
                return (SimpleType) unwrap;
            }
            return null;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof KotlinType) {
            return TypeUtilsKt.asTypeProjection((KotlinType) kotlinTypeMarker);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static void b(Context context, boolean z) {
        context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putBoolean("com.amazon.lwa.sandboxMode", z).commit();
    }

    public static final <E> Set<E> build(Set<E> set) {
        Intrinsics.checkNotNullParameter(set, "builder");
        SetBuilder setBuilder = (SetBuilder) set;
        MapBuilder<E, ?> mapBuilder = setBuilder.backing;
        mapBuilder.checkIsMutable$kotlin_stdlib();
        mapBuilder.isReadOnly = true;
        return setBuilder;
    }

    public static final PossiblyInnerType buildPossiblyInnerType(KotlinType kotlinType, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters2 = null;
        if (classifierDescriptorWithTypeParameters == null || ErrorUtils.isError(classifierDescriptorWithTypeParameters)) {
            return null;
        }
        int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i;
        if (!classifierDescriptorWithTypeParameters.isInner()) {
            boolean z = size == kotlinType.getArguments().size() || DescriptorUtils.isLocal(classifierDescriptorWithTypeParameters);
            if (!_Assertions.ENABLED || z) {
                return new PossiblyInnerType(classifierDescriptorWithTypeParameters, kotlinType.getArguments().subList(i, kotlinType.getArguments().size()), null);
            }
            throw new AssertionError((kotlinType.getArguments().size() - size) + " trailing arguments were found in " + kotlinType + " type");
        }
        List<TypeProjection> subList = kotlinType.getArguments().subList(i, size);
        DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
        if (containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) {
            classifierDescriptorWithTypeParameters2 = (ClassifierDescriptorWithTypeParameters) containingDeclaration;
        }
        return new PossiblyInnerType(classifierDescriptorWithTypeParameters, subList, buildPossiblyInnerType(kotlinType, classifierDescriptorWithTypeParameters2, size));
    }

    public static Scheduler callRequireNonNull1(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            ObjectHelper.requireNonNull(call, "Scheduler Callable result can't be null");
            return call;
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker captureFromArguments(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext r19, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r20, kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus r21) {
        /*
            r0 = r20
            r8 = r21
            java.lang.String r1 = "this"
            r2 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r2 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            boolean r3 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r3 == 0) goto L_0x0202
            r9 = r0
            kotlin.reflect.jvm.internal.impl.types.SimpleType r9 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r9
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            java.util.List r0 = r9.getArguments()
            int r0 = r0.size()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r9.getConstructor()
            java.util.List r1 = r1.getParameters()
            int r1 = r1.size()
            r10 = 0
            if (r0 == r1) goto L_0x003d
            goto L_0x006e
        L_0x003d:
            java.util.List r11 = r9.getArguments()
            boolean r0 = r11 instanceof java.util.Collection
            if (r0 == 0) goto L_0x004c
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L_0x004c
            goto L_0x006b
        L_0x004c:
            java.util.Iterator r0 = r11.iterator()
        L_0x0050:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x006b
            java.lang.Object r1 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r1 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r1
            kotlin.reflect.jvm.internal.impl.types.Variance r1 = r1.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r2 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            if (r1 != r2) goto L_0x0066
            r1 = 1
            goto L_0x0067
        L_0x0066:
            r1 = 0
        L_0x0067:
            if (r1 != 0) goto L_0x0050
            r0 = 0
            goto L_0x006c
        L_0x006b:
            r0 = 1
        L_0x006c:
            if (r0 == 0) goto L_0x0071
        L_0x006e:
            r15 = r10
            goto L_0x01e8
        L_0x0071:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r9.getConstructor()
            java.util.List r0 = r0.getParameters()
            java.lang.String r1 = "type.constructor.parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.zip(r11, r0)
            java.util.ArrayList r12 = new java.util.ArrayList
            r1 = 10
            int r1 = collectionSizeOrDefault(r0, r1)
            r12.<init>(r1)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r13 = r0.iterator()
        L_0x0094:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x0104
            java.lang.Object r0 = r13.next()
            kotlin.Pair r0 = (kotlin.Pair) r0
            A r1 = r0.first
            r3 = r1
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r3 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r3
            B r0 = r0.second
            r6 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = r3.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r1 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            if (r0 != r1) goto L_0x00b3
            goto L_0x0100
        L_0x00b3:
            boolean r0 = r3.isStarProjection()
            if (r0 != 0) goto L_0x00cb
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = r3.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r1 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r0 != r1) goto L_0x00cb
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r3.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r0 = r0.unwrap()
            r14 = r0
            goto L_0x00cc
        L_0x00cb:
            r14 = r10
        L_0x00cc:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType r15 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType
            java.lang.String r0 = "parameter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            java.lang.String r0 = "captureStatus"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "projection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "typeParameter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r16 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor
            r17 = 0
            r5 = 0
            r7 = 6
            r4 = 0
            r2 = r16
            r2.<init>(r3, r4, r5, r6, r7)
            r5 = 0
            r6 = 0
            r7 = 56
            r0 = r15
            r1 = r21
            r3 = r14
            r4 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection(r15)
        L_0x0100:
            r12.add(r3)
            goto L_0x0094
        L_0x0104:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion r0 = kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r9.getConstructor()
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitution r0 = r0.create(r1, r12)
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r0 = r0.buildSubstitutor()
            int r1 = r11.size()
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x01e7
            r2 = 0
        L_0x011b:
            int r3 = r2 + 1
            java.lang.Object r4 = r11.get(r2)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r4 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r4
            java.lang.Object r5 = r12.get(r2)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r5 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r5
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = r4.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r7 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            if (r6 != r7) goto L_0x0133
            goto L_0x01e0
        L_0x0133:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r9.getConstructor()
            java.util.List r6 = r6.getParameters()
            java.lang.Object r2 = r6.get(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
            java.util.List r2 = r2.getUpperBounds()
            java.lang.String r6 = "type.constructor.parameters[index].upperBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0154:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0179
            java.lang.Object r7 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r7
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker$Companion r8 = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion
            if (r8 == 0) goto L_0x0178
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl r8 = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion.Default
            kotlin.reflect.jvm.internal.impl.types.Variance r13 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r0.safeSubstitute(r7, r13)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r7 = r7.unwrap()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r7 = r8.transformToNewType(r7)
            r6.add(r7)
            goto L_0x0154
        L_0x0178:
            throw r10
        L_0x0179:
            boolean r2 = r4.isStarProjection()
            if (r2 != 0) goto L_0x019e
            kotlin.reflect.jvm.internal.impl.types.Variance r2 = r4.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r7 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE
            if (r2 != r7) goto L_0x019e
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker$Companion r2 = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion
            if (r2 == 0) goto L_0x019d
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl r2 = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion.Default
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r4 = r4.unwrap()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r2 = r2.transformToNewType(r4)
            r6.add(r2)
            goto L_0x019e
        L_0x019d:
            throw r10
        L_0x019e:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r5.getType()
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType r2 = (kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) r2
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r2 = r2.constructor
            if (r2 == 0) goto L_0x01e6
            java.lang.String r4 = "supertypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r4)
            kotlin.jvm.functions.Function0<? extends java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType>> r4 = r2.supertypesComputation
            if (r4 != 0) goto L_0x01b4
            r4 = 1
            goto L_0x01b5
        L_0x01b4:
            r4 = 0
        L_0x01b5:
            boolean r5 = kotlin._Assertions.ENABLED
            if (r5 == 0) goto L_0x01d9
            if (r4 == 0) goto L_0x01bc
            goto L_0x01d9
        L_0x01bc:
            java.lang.String r0 = "Already initialized! oldValue = "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            kotlin.jvm.functions.Function0<? extends java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType>> r1 = r2.supertypesComputation
            r0.append(r1)
            java.lang.String r1 = ", newValue = "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x01d9:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$initializeSupertypes$2 r4 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$initializeSupertypes$2
            r4.<init>(r6)
            r2.supertypesComputation = r4
        L_0x01e0:
            if (r3 <= r1) goto L_0x01e3
            goto L_0x01e7
        L_0x01e3:
            r2 = r3
            goto L_0x011b
        L_0x01e6:
            throw r10
        L_0x01e7:
            r15 = r12
        L_0x01e8:
            if (r15 != 0) goto L_0x01eb
            goto L_0x0201
        L_0x01eb:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r13 = r9.getAnnotations()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r14 = r9.getConstructor()
            boolean r16 = r9.isMarkedNullable()
            r17 = 0
            r18 = 16
            kotlin.reflect.jvm.internal.impl.types.SimpleType r10 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(r13, r14, r15, r16, r17, r18)
        L_0x0201:
            return r10
        L_0x0202:
            java.lang.String r1 = "ClassicTypeSystemContext couldn't handle: "
            java.lang.String r2 = ", "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline83(r1, r0, r2)
            java.lang.Class r0 = r20.getClass()
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.captureFromArguments(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus):kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker");
    }

    public static <M extends Member> void checkArguments(Caller<? extends M> caller, Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        if (getArity(caller) != objArr.length) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Callable expects ");
            outline73.append(getArity(caller));
            outline73.append(" arguments, but ");
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline57(outline73, objArr.length, " were provided."));
        }
    }

    public static <T> void checkBuilderRequirement(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static <T> T checkNotNull1(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static <T> T checkNotNullFromProvides(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static final LazyJavaResolverContext child(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, Lazy<JavaTypeQualifiersByElementType> lazy) {
        TypeParameterResolver typeParameterResolver;
        JavaResolverComponents javaResolverComponents = lazyJavaResolverContext.components;
        if (javaTypeParameterListOwner == null) {
            typeParameterResolver = null;
        } else {
            typeParameterResolver = new LazyJavaTypeParameterResolver(lazyJavaResolverContext, declarationDescriptor, javaTypeParameterListOwner, i);
        }
        if (typeParameterResolver == null) {
            typeParameterResolver = lazyJavaResolverContext.typeParameterResolver;
        }
        return new LazyJavaResolverContext(javaResolverComponents, typeParameterResolver, lazy);
    }

    public static LazyJavaResolverContext childForClassOrPackage$default(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2) {
        if ((i2 & 2) != 0) {
            javaTypeParameterListOwner = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        Intrinsics.checkNotNullParameter(classOrPackageFragmentDescriptor, "containingDeclaration");
        return child(lazyJavaResolverContext, classOrPackageFragmentDescriptor, javaTypeParameterListOwner, i, lazy(LazyThreadSafetyMode.NONE, new ContextKt$childForClassOrPackage$1(lazyJavaResolverContext, classOrPackageFragmentDescriptor)));
    }

    public static LazyJavaResolverContext childForMethod$default(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(javaTypeParameterListOwner, "typeParameterOwner");
        return child(lazyJavaResolverContext, declarationDescriptor, javaTypeParameterListOwner, i, lazyJavaResolverContext.delegateForDefaultTypeQualifiers);
    }

    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            addSuppressed(th, th2);
        }
    }

    public static final Object coerceToExpectedReceiverType(Object obj, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        if ((callableMemberDescriptor instanceof PropertyDescriptor) && InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor) callableMemberDescriptor)) {
            return obj;
        }
        KotlinType expectedReceiverType = getExpectedReceiverType(callableMemberDescriptor);
        if (expectedReceiverType != null) {
            Class<?> inlineClass = toInlineClass(expectedReceiverType);
            if (inlineClass != null) {
                obj = getUnboxMethod(inlineClass, callableMemberDescriptor).invoke(obj, new Object[0]);
            }
        }
        return obj;
    }

    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider packageFragmentProvider, FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        if (packageFragmentProvider instanceof PackageFragmentProviderOptimized) {
            ((PackageFragmentProviderOptimized) packageFragmentProvider).collectPackageFragments(fqName, collection);
        } else {
            collection.addAll(packageFragmentProvider.getPackageFragments(fqName));
        }
    }

    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    public static final <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static final Annotations composeAnnotations(Annotations annotations, Annotations annotations2) {
        Intrinsics.checkNotNullParameter(annotations, "first");
        Intrinsics.checkNotNullParameter(annotations2, AnonymousClass27.SECOND);
        if (annotations.isEmpty()) {
            return annotations2;
        }
        if (annotations2.isEmpty()) {
            return annotations;
        }
        return new CompositeAnnotations(annotations, annotations2);
    }

    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        List<TypeParameterDescriptor> list;
        Object obj;
        Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "declaredTypeParameters");
        if (!classifierDescriptorWithTypeParameters.isInner() && !(classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            return declaredTypeParameters;
        }
        Sequence<DeclarationDescriptor> parents = DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters);
        TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1 typeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1 = TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1.INSTANCE;
        Intrinsics.checkNotNullParameter(parents, "<this>");
        Intrinsics.checkNotNullParameter(typeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1, "predicate");
        List list2 = TypeUtilsKt.toList(TypeUtilsKt.flatMap(TypeUtilsKt.filter(new TakeWhileSequence(parents, typeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3.INSTANCE));
        Iterator it = DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (obj instanceof ClassDescriptor) {
                break;
            }
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) obj;
        if (classDescriptor != null) {
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            if (typeConstructor != null) {
                list = typeConstructor.getParameters();
            }
        }
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        if (!list2.isEmpty() || !list.isEmpty()) {
            List<T> plus = ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) list2, (Iterable<? extends T>) list);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault(plus, 10));
            for (T t : plus) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                arrayList.add(new CapturedTypeParameterDescriptor(t, classifierDescriptorWithTypeParameters, declaredTypeParameters.size()));
            }
            return ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) declaredTypeParameters, (Iterable<? extends T>) arrayList);
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "declaredTypeParameters");
        return declaredTypeParameters2;
    }

    public static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, HashSet<TypeConstructorMarker> hashSet) {
        KotlinTypeMarker computeExpandedTypeInner;
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!hashSet.add(typeConstructor)) {
            return null;
        }
        TypeParameterMarker typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(typeConstructor);
        if (typeParameterClassifier != null) {
            computeExpandedTypeInner = computeExpandedTypeInner(typeSystemCommonBackendContext, typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier), hashSet);
            if (computeExpandedTypeInner == null) {
                kotlinTypeMarker = null;
            } else if (!typeSystemCommonBackendContext.isNullableType(computeExpandedTypeInner) && typeSystemCommonBackendContext.isMarkedNullable(kotlinTypeMarker)) {
                kotlinTypeMarker = typeSystemCommonBackendContext.makeNullable(computeExpandedTypeInner);
            }
            return kotlinTypeMarker;
        }
        if (typeSystemCommonBackendContext.isInlineClass(typeConstructor)) {
            KotlinTypeMarker substitutedUnderlyingType = typeSystemCommonBackendContext.getSubstitutedUnderlyingType(kotlinTypeMarker);
            if (substitutedUnderlyingType == null) {
                return null;
            }
            computeExpandedTypeInner = computeExpandedTypeInner(typeSystemCommonBackendContext, substitutedUnderlyingType, hashSet);
            if (computeExpandedTypeInner == null) {
                return null;
            }
            if (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker)) {
                if (!typeSystemCommonBackendContext.isNullableType(computeExpandedTypeInner) && (!(computeExpandedTypeInner instanceof SimpleTypeMarker) || !typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) computeExpandedTypeInner))) {
                    kotlinTypeMarker = typeSystemCommonBackendContext.makeNullable(computeExpandedTypeInner);
                }
            }
        }
        return kotlinTypeMarker;
        kotlinTypeMarker = computeExpandedTypeInner;
        return kotlinTypeMarker;
    }

    public static final String computeInternalName(ClassDescriptor classDescriptor, TypeMappingConfiguration<?> typeMappingConfiguration) {
        Intrinsics.checkNotNullParameter(classDescriptor, "klass");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(classDescriptor);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "klass.containingDeclaration");
        String identifier = SpecialNames.safeIdentifier(classDescriptor.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (!fqName.isRoot()) {
                StringBuilder sb = new StringBuilder();
                String asString = fqName.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
                sb.append(CharsKt__CharKt.replace$default(asString, '.', '/', false, 4));
                sb.append('/');
                sb.append(identifier);
                identifier = sb.toString();
            }
            return identifier;
        }
        ClassDescriptor classDescriptor2 = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor2 != null) {
            String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor2);
            if (predefinedInternalNameForClass == null) {
                predefinedInternalNameForClass = computeInternalName(classDescriptor2, typeMappingConfiguration);
            }
            return predefinedInternalNameForClass + '$' + identifier;
        }
        throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + classDescriptor);
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.util.EnumMap, java.util.Map] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.util.EnumMap] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.util.EnumMap] */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7, types: [kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers] */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r10v8, types: [kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r10v9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.util.EnumMap, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.util.Map, java.util.EnumMap, java.lang.Object]
      mth insns count: 172
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0020 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0192  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r12, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "additionalAnnotations"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r12.components
            kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState r0 = r0.javaTypeEnhancementState
            boolean r0 = r0.disabledDefaultAnnotations
            if (r0 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r12 = r12.getDefaultTypeQualifiers()
            return r12
        L_0x0017:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r13 = r13.iterator()
        L_0x0020:
            boolean r1 = r13.hasNext()
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0198
            java.lang.Object r1 = r13.next()
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) r1
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r5 = r12.components
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver r5 = r5.annotationTypeQualifierResolver
            if (r5 == 0) goto L_0x0197
            java.lang.String r6 = "annotationDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
            kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState r7 = r5.javaTypeEnhancementState
            boolean r7 = r7.disabledDefaultAnnotations
            if (r7 == 0) goto L_0x0041
            goto L_0x0072
        L_0x0041:
            java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> r7 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifiersFqNamesKt.BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = r1.getFqName()
            java.lang.Object r7 = r7.get(r8)
            kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r7 = (kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers) r7
            if (r7 != 0) goto L_0x0050
            goto L_0x0072
        L_0x0050:
            java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> r8 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifiersFqNamesKt.JSPECIFY_DEFAULT_ANNOTATIONS
            kotlin.reflect.jvm.internal.impl.name.FqName r9 = r1.getFqName()
            boolean r8 = r8.containsKey(r9)
            if (r8 == 0) goto L_0x0061
            kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState r8 = r5.javaTypeEnhancementState
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r8 = r8.jspecifyReportLevel
            goto L_0x0065
        L_0x0061:
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r8 = r5.resolveJsr305AnnotationState(r1)
        L_0x0065:
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r9 = kotlin.reflect.jvm.internal.impl.utils.ReportLevel.IGNORE
            if (r8 == r9) goto L_0x006b
            r9 = 1
            goto L_0x006c
        L_0x006b:
            r9 = 0
        L_0x006c:
            if (r9 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r8 = r2
        L_0x0070:
            if (r8 != 0) goto L_0x0074
        L_0x0072:
            r10 = r2
            goto L_0x0091
        L_0x0074:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r9 = r7.nullabilityQualifier
            boolean r8 = r8.isWarning()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(r9, r2, r8, r4)
            java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> r9 = r7.qualifierApplicabilityTypes
            boolean r7 = r7.affectsTypeParameterBasedTypes
            java.lang.String r10 = "nullabilityQualifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r10)
            java.lang.String r10 = "qualifierApplicabilityTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
            kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r10 = new kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers
            r10.<init>(r8, r9, r7)
        L_0x0091:
            if (r10 != 0) goto L_0x018f
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
            kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState r6 = r5.javaTypeEnhancementState
            boolean r6 = r6.disabledJsr305
            if (r6 == 0) goto L_0x009e
            goto L_0x0148
        L_0x009e:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getAnnotationClass(r1)
            if (r6 != 0) goto L_0x00a5
            goto L_0x00b2
        L_0x00a5:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r7 = r6.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifiersFqNamesKt.TYPE_QUALIFIER_DEFAULT_FQNAME
            boolean r7 = r7.hasAnnotation(r8)
            if (r7 == 0) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r6 = r2
        L_0x00b3:
            if (r6 != 0) goto L_0x00b7
            goto L_0x0148
        L_0x00b7:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r7 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getAnnotationClass(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r7 = r7.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifiersFqNamesKt.TYPE_QUALIFIER_DEFAULT_FQNAME
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r7 = r7.findAnnotation(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.util.Map r7 = r7.getAllValueArguments()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x00dc:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0109
            java.lang.Object r9 = r7.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            kotlin.reflect.jvm.internal.impl.name.Name r10 = (kotlin.reflect.jvm.internal.impl.name.Name) r10
            java.lang.Object r9 = r9.getValue()
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9
            kotlin.reflect.jvm.internal.impl.name.Name r11 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r11)
            if (r10 == 0) goto L_0x0103
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1 r10 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1.INSTANCE
            java.util.List r9 = r5.mapConstantToQualifierApplicabilityTypes(r9, r10)
            goto L_0x0105
        L_0x0103:
            kotlin.collections.EmptyList r9 = kotlin.collections.EmptyList.INSTANCE
        L_0x0105:
            addAll(r8, r9)
            goto L_0x00dc
        L_0x0109:
            java.util.Iterator r7 = r8.iterator()
            r8 = 0
        L_0x010e:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0122
            java.lang.Object r9 = r7.next()
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r9 = (kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType) r9
            int r9 = r9.ordinal()
            int r9 = r4 << r9
            r8 = r8 | r9
            goto L_0x010e
        L_0x0122:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6 = r6.getAnnotations()
            java.util.Iterator r6 = r6.iterator()
        L_0x012a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0143
            java.lang.Object r7 = r6.next()
            r9 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) r9
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r9 = r5.resolveTypeQualifierAnnotation(r9)
            if (r9 == 0) goto L_0x013f
            r9 = 1
            goto L_0x0140
        L_0x013f:
            r9 = 0
        L_0x0140:
            if (r9 == 0) goto L_0x012a
            goto L_0x0144
        L_0x0143:
            r7 = r2
        L_0x0144:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) r7
            if (r7 != 0) goto L_0x014a
        L_0x0148:
            r6 = r2
            goto L_0x014f
        L_0x014a:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$TypeQualifierWithApplicability r6 = new kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$TypeQualifierWithApplicability
            r6.<init>(r7, r8)
        L_0x014f:
            if (r6 != 0) goto L_0x0152
            goto L_0x0190
        L_0x0152:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r7 = r6.typeQualifier
            java.util.List r6 = r6.component2()
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r1 = r5.resolveJsr305CustomState(r1)
            if (r1 != 0) goto L_0x0162
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r1 = r5.resolveJsr305AnnotationState(r7)
        L_0x0162:
            boolean r5 = r1.isIgnore()
            if (r5 == 0) goto L_0x0169
            goto L_0x0190
        L_0x0169:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r5 = r12.components
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r5 = r5.settings
            boolean r5 = r5.getTypeEnhancementImprovements()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r8 = r12.components
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement r8 = r8.signatureEnhancement
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r5 = r8.extractNullability(r7, r5, r3)
            if (r5 != 0) goto L_0x017d
            r1 = r2
            goto L_0x0185
        L_0x017d:
            boolean r1 = r1.isWarning()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(r5, r2, r1, r4)
        L_0x0185:
            if (r1 != 0) goto L_0x0188
            goto L_0x0190
        L_0x0188:
            kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r2 = new kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers
            r4 = 4
            r2.<init>(r1, r6, r3, r4)
            goto L_0x0190
        L_0x018f:
            r2 = r10
        L_0x0190:
            if (r2 == 0) goto L_0x0020
            r0.add(r2)
            goto L_0x0020
        L_0x0197:
            throw r2
        L_0x0198:
            boolean r13 = r0.isEmpty()
            if (r13 == 0) goto L_0x01a3
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r12 = r12.getDefaultTypeQualifiers()
            return r12
        L_0x01a3:
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r13 = r12.getDefaultTypeQualifiers()
            if (r13 != 0) goto L_0x01aa
            goto L_0x01b4
        L_0x01aa:
            java.util.EnumMap<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> r13 = r13.defaultQualifiers
            if (r13 != 0) goto L_0x01af
            goto L_0x01b4
        L_0x01af:
            java.util.EnumMap r2 = new java.util.EnumMap
            r2.<init>(r13)
        L_0x01b4:
            if (r2 != 0) goto L_0x01bd
            java.util.EnumMap r2 = new java.util.EnumMap
            java.lang.Class<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> r13 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.class
            r2.<init>(r13)
        L_0x01bd:
            java.util.Iterator r13 = r0.iterator()
        L_0x01c1:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x01e4
            java.lang.Object r0 = r13.next()
            kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r0 = (kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers) r0
            java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> r1 = r0.qualifierApplicabilityTypes
            java.util.Iterator r1 = r1.iterator()
        L_0x01d3:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x01c1
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r3 = (kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType) r3
            r2.put(r3, r0)
            r3 = 1
            goto L_0x01d3
        L_0x01e4:
            if (r3 != 0) goto L_0x01eb
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r12 = r12.getDefaultTypeQualifiers()
            goto L_0x01f0
        L_0x01eb:
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r12 = new kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType
            r12.<init>(r2)
        L_0x01f0:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.computeNewDefaultTypeQualifiers(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations):kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType");
    }

    public static final <T> boolean contains(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return indexOf(tArr, t) >= 0;
    }

    public static final <T> Collection<T> convertToSetForSetOperationWith(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(iterable2, DefaultSettingsSpiCall.SOURCE_PARAM);
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return CollectionSystemProperties.brittleContainsOptimizationEnabled ? ArraysKt___ArraysJvmKt.toHashSet(iterable) : ArraysKt___ArraysJvmKt.toList(iterable);
        }
        if (((Collection) iterable2).size() < 2) {
            return (Collection) iterable;
        }
        Collection collection = (Collection) iterable;
        return CollectionSystemProperties.brittleContainsOptimizationEnabled && collection.size() > 2 && (collection instanceof ArrayList) ? ArraysKt___ArraysJvmKt.toHashSet(iterable) : collection;
    }

    public static final TypeVariance convertVariance(Variance variance) {
        Intrinsics.checkNotNullParameter(variance, "<this>");
        int ordinal = variance.ordinal();
        if (ordinal == 0) {
            return TypeVariance.INV;
        }
        if (ordinal == 1) {
            return TypeVariance.IN;
        }
        if (ordinal == 2) {
            return TypeVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void copyOfRangeToIndexCheck(int i, int i2) {
        if (i > i2) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline44("toIndex (", i, ") is greater than size (", i2, ")."));
        }
    }

    public static final <T> T[] copyOfUninitializedElements(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] copyOf = Arrays.copyOf(tArr, i);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Intrinsics.checkNotNull(copyOf, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilderKt.copyOfUninitializedElements>");
        return copyOf;
    }

    public static final List<ValueParameterDescriptor> copyValueParameters(Collection<ValueParameterData> collection, Collection<? extends ValueParameterDescriptor> collection2, CallableDescriptor callableDescriptor) {
        Intrinsics.checkNotNullParameter(collection, "newValueParametersTypes");
        Intrinsics.checkNotNullParameter(collection2, "oldValueParameters");
        Intrinsics.checkNotNullParameter(callableDescriptor, "newOwner");
        boolean z = collection.size() == collection2.size();
        if (!_Assertions.ENABLED || z) {
            List<Pair<T, R>> zip = ArraysKt___ArraysJvmKt.zip(collection, collection2);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault(zip, 10));
            Iterator it = ((ArrayList) zip).iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                ValueParameterData valueParameterData = (ValueParameterData) pair.first;
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.second;
                int index = valueParameterDescriptor.getIndex();
                Annotations annotations = valueParameterDescriptor.getAnnotations();
                Name name = valueParameterDescriptor.getName();
                Intrinsics.checkNotNullExpressionValue(name, "oldParameter.name");
                KotlinType kotlinType = valueParameterData.type;
                boolean z2 = valueParameterData.hasDefaultValue;
                boolean isCrossinline = valueParameterDescriptor.isCrossinline();
                boolean isNoinline = valueParameterDescriptor.isNoinline();
                KotlinType arrayElementType = valueParameterDescriptor.getVarargElementType() != null ? DescriptorUtilsKt.getModule(callableDescriptor).getBuiltIns().getArrayElementType(valueParameterData.type) : null;
                SourceElement source = valueParameterDescriptor.getSource();
                Intrinsics.checkNotNullExpressionValue(source, "oldParameter.source");
                ValueParameterDescriptorImpl valueParameterDescriptorImpl = new ValueParameterDescriptorImpl(callableDescriptor, null, index, annotations, name, kotlinType, z2, isCrossinline, isNoinline, arrayElementType, source);
                arrayList.add(valueParameterDescriptorImpl);
            }
            return arrayList;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Different value parameters sizes: Enhanced = ");
        outline73.append(collection.size());
        outline73.append(", Old = ");
        outline73.append(collection2.size());
        throw new AssertionError(outline73.toString());
    }

    public static final LazyJavaResolverContext copyWithNewDefaultTypeQualifiers(LazyJavaResolverContext lazyJavaResolverContext, Annotations annotations) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        Intrinsics.checkNotNullParameter(annotations, "additionalAnnotations");
        return annotations.isEmpty() ? lazyJavaResolverContext : new LazyJavaResolverContext(lazyJavaResolverContext.components, lazyJavaResolverContext.typeParameterResolver, lazy(LazyThreadSafetyMode.NONE, new ContextKt$copyWithNewDefaultTypeQualifiers$1(lazyJavaResolverContext, annotations)));
    }

    public static final <T> T createAnnotationInstance(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        Intrinsics.checkNotNullParameter(cls, "annotationClass");
        Intrinsics.checkNotNullParameter(map, "values");
        Intrinsics.checkNotNullParameter(list, "methods");
        AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2 = new AnnotationConstructorCallerKt$createAnnotationInstance$2(cls, list, map);
        Lazy lazy = lazy((Function0<? extends T>) new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2<Object>(map));
        Lazy lazy2 = lazy((Function0<? extends T>) new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2<Object>(cls, map));
        AnnotationConstructorCallerKt$createAnnotationInstance$result$1 annotationConstructorCallerKt$createAnnotationInstance$result$1 = new AnnotationConstructorCallerKt$createAnnotationInstance$result$1(cls, lazy2, null, lazy, null, annotationConstructorCallerKt$createAnnotationInstance$2, map);
        T newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, annotationConstructorCallerKt$createAnnotationInstance$result$1);
        if (newProxyInstance != null) {
            return newProxyInstance;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public static final TypeProjection createCapturedIfNeeded(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        TypeProjectionImpl typeProjectionImpl;
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() == typeProjection.getProjectionKind()) {
            if (typeProjection.isStarProjection()) {
                StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
                Intrinsics.checkNotNullExpressionValue(storageManager, "NO_LOCKS");
                typeProjectionImpl = new TypeProjectionImpl(new LazyWrappedType(storageManager, new CapturedTypeConstructorKt$createCapturedIfNeeded$1(typeProjection)));
            } else {
                typeProjectionImpl = new TypeProjectionImpl(typeProjection.getType());
            }
            return typeProjectionImpl;
        }
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        CapturedTypeConstructorImpl capturedTypeConstructorImpl = new CapturedTypeConstructorImpl(typeProjection);
        if (Annotations.Companion != null) {
            return new TypeProjectionImpl(new CapturedType(typeProjection, capturedTypeConstructorImpl, false, Companion.EMPTY));
        }
        throw null;
    }

    public static final <T> Continuation<Unit> createCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(continuation);
        }
        CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(continuation, function1);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2(continuation, context, function1);
    }

    public static PropertyGetterDescriptorImpl createDefaultGetter(PropertyDescriptor propertyDescriptor, Annotations annotations) {
        if (annotations != null) {
            return createGetter(propertyDescriptor, annotations, true, false, false, propertyDescriptor.getSource());
        }
        $$$reportNull$$$03(14);
        throw null;
    }

    public static PropertySetterDescriptorImpl createDefaultSetter(PropertyDescriptor propertyDescriptor, Annotations annotations, Annotations annotations2) {
        if (annotations == null) {
            $$$reportNull$$$03(1);
            throw null;
        } else if (annotations2 != null) {
            SourceElement source = propertyDescriptor.getSource();
            if (source != null) {
                return createSetter(propertyDescriptor, annotations, annotations2, true, false, false, propertyDescriptor.getVisibility(), source);
            }
            $$$reportNull$$$03(6);
            throw null;
        } else {
            $$$reportNull$$$03(2);
            throw null;
        }
    }

    public static SimpleFunctionDescriptor createEnumValueOfMethod(ClassDescriptor classDescriptor) {
        ClassDescriptor classDescriptor2 = classDescriptor;
        if (classDescriptor2 == null) {
            $$$reportNull$$$03(24);
            throw null;
        } else if (Annotations.Companion != null) {
            SimpleFunctionDescriptorImpl create = SimpleFunctionDescriptorImpl.create(classDescriptor2, Companion.EMPTY, StandardNames.ENUM_VALUE_OF, Kind.SYNTHESIZED, classDescriptor.getSource());
            if (Annotations.Companion != null) {
                ValueParameterDescriptorImpl valueParameterDescriptorImpl = new ValueParameterDescriptorImpl(create, null, 0, Companion.EMPTY, Name.identifier(HSLCriteriaBuilder.VALUE), DescriptorUtilsKt.getBuiltIns(classDescriptor).getStringType(), false, false, false, null, classDescriptor.getSource());
                SimpleFunctionDescriptorImpl initialize = create.initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.singletonList(valueParameterDescriptorImpl), (KotlinType) classDescriptor.getDefaultType(), Modality.FINAL, DescriptorVisibilities.PUBLIC);
                if (initialize != null) {
                    return initialize;
                }
                $$$reportNull$$$03(25);
                throw null;
            }
            throw null;
        } else {
            throw null;
        }
    }

    public static SimpleFunctionDescriptor createEnumValuesMethod(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$03(22);
            throw null;
        } else if (Annotations.Companion != null) {
            SimpleFunctionDescriptorImpl initialize = SimpleFunctionDescriptorImpl.create(classDescriptor, Companion.EMPTY, StandardNames.ENUM_VALUES, Kind.SYNTHESIZED, classDescriptor.getSource()).initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.emptyList(), (KotlinType) DescriptorUtilsKt.getBuiltIns(classDescriptor).getArrayType(Variance.INVARIANT, classDescriptor.getDefaultType()), Modality.FINAL, DescriptorVisibilities.PUBLIC);
            if (initialize != null) {
                return initialize;
            }
            $$$reportNull$$$03(23);
            throw null;
        } else {
            throw null;
        }
    }

    public static ReceiverParameterDescriptor createExtensionReceiverParameterForCallable(CallableDescriptor callableDescriptor, KotlinType kotlinType, Annotations annotations) {
        if (annotations == null) {
            $$$reportNull$$$03(30);
            throw null;
        } else if (kotlinType == null) {
            return null;
        } else {
            return new ReceiverParameterDescriptorImpl(callableDescriptor, new ExtensionReceiver(callableDescriptor, kotlinType, null), annotations);
        }
    }

    public static final Object createFailure(Throwable th) {
        Intrinsics.checkNotNullParameter(th, MqttServiceConstants.TRACE_EXCEPTION);
        return new Failure(th);
    }

    public static KotlinTypeMarker createFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "upperBound");
        if (!(simpleTypeMarker instanceof SimpleType)) {
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + ", " + Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
        } else if (simpleTypeMarker2 instanceof SimpleType) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.flexibleType((SimpleType) simpleTypeMarker, (SimpleType) simpleTypeMarker2);
        } else {
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + ", " + Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
        }
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor propertyDescriptor, Annotations annotations, boolean z, boolean z2, boolean z3, SourceElement sourceElement) {
        if (annotations == null) {
            $$$reportNull$$$03(18);
            throw null;
        } else if (sourceElement != null) {
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.getModality(), propertyDescriptor.getVisibility(), z, z2, z3, Kind.DECLARATION, null, sourceElement);
            return propertyGetterDescriptorImpl;
        } else {
            $$$reportNull$$$03(19);
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        if ((r0 != null && kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(r0)) != false) goto L_0x006b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <M extends java.lang.reflect.Member> kotlin.reflect.jvm.internal.calls.Caller<M> createInlineClassAwareCallerIfNeeded(kotlin.reflect.jvm.internal.calls.Caller<? extends M> r5, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6, boolean r7) {
        /*
            java.lang.String r0 = "$this$createInlineClassAwareCallerIfNeeded"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r6)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x006b
            java.util.List r0 = r6.getValueParameters()
            java.lang.String r3 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0023
        L_0x0021:
            r0 = 0
            goto L_0x0048
        L_0x0023:
            java.util.Iterator r0 = r0.iterator()
        L_0x0027:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0021
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r3
            java.lang.String r4 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getType()
            java.lang.String r4 = "it.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r3 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(r3)
            if (r3 == 0) goto L_0x0027
            r0 = 1
        L_0x0048:
            if (r0 != 0) goto L_0x006b
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r6.getReturnType()
            if (r0 == 0) goto L_0x0056
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(r0)
            if (r0 == r2) goto L_0x006b
        L_0x0056:
            boolean r0 = r5 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r0 != 0) goto L_0x006c
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = getExpectedReceiverType(r6)
            if (r0 == 0) goto L_0x0068
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(r0)
            if (r0 != r2) goto L_0x0068
            r0 = 1
            goto L_0x0069
        L_0x0068:
            r0 = 0
        L_0x0069:
            if (r0 == 0) goto L_0x006c
        L_0x006b:
            r1 = 1
        L_0x006c:
            if (r1 == 0) goto L_0x0074
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller r0 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller
            r0.<init>(r6, r5, r7)
            r5 = r0
        L_0x0074:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.createInlineClassAwareCallerIfNeeded(kotlin.reflect.jvm.internal.calls.Caller, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, boolean):kotlin.reflect.jvm.internal.calls.Caller");
    }

    public static final JavaTypeQualifiers createJavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        if (!z2 || nullabilityQualifier != NullabilityQualifier.NOT_NULL) {
            return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, false, z);
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, true, z);
    }

    public static final <E> List<E> createListBuilder() {
        return new ListBuilder(10);
    }

    public static final <K, V> Map<K, V> createMapBuilder() {
        return new MapBuilder(8);
    }

    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        Intrinsics.checkNotNullParameter(classDescriptor, "from");
        Intrinsics.checkNotNullParameter(classDescriptor2, "to");
        boolean z = classDescriptor.getDeclaredTypeParameters().size() == classDescriptor2.getDeclaredTypeParameters().size();
        if (!_Assertions.ENABLED || z) {
            List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "from.declaredTypeParameters");
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault(declaredTypeParameters, 10));
            for (TypeParameterDescriptor typeConstructor : declaredTypeParameters) {
                arrayList.add(typeConstructor.getTypeConstructor());
            }
            List<TypeParameterDescriptor> declaredTypeParameters2 = classDescriptor2.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "to.declaredTypeParameters");
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault(declaredTypeParameters2, 10));
            for (TypeParameterDescriptor defaultType : declaredTypeParameters2) {
                SimpleType defaultType2 = defaultType.getDefaultType();
                Intrinsics.checkNotNullExpressionValue(defaultType2, "it.defaultType");
                arrayList2.add(TypeUtilsKt.asTypeProjection(defaultType2));
            }
            Map map = ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) ArraysKt___ArraysJvmKt.zip(arrayList, arrayList2));
            boolean z2 = true & true;
            Intrinsics.checkNotNullParameter(map, "map");
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(map, false);
        }
        throw new AssertionError(classDescriptor + " and " + classDescriptor2 + " should have same number of type parameters, but " + classDescriptor.getDeclaredTypeParameters().size() + " / " + classDescriptor2.getDeclaredTypeParameters().size() + " found");
    }

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor propertyDescriptor, Annotations annotations, Annotations annotations2, boolean z, boolean z2, boolean z3, DescriptorVisibility descriptorVisibility, SourceElement sourceElement) {
        Annotations annotations3 = annotations2;
        if (annotations == null) {
            $$$reportNull$$$03(8);
            throw null;
        } else if (annotations3 == null) {
            $$$reportNull$$$03(9);
            throw null;
        } else if (descriptorVisibility == null) {
            $$$reportNull$$$03(10);
            throw null;
        } else if (sourceElement != null) {
            PropertySetterDescriptorImpl propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(propertyDescriptor, annotations, propertyDescriptor.getModality(), descriptorVisibility, z, z2, z3, Kind.DECLARATION, null, sourceElement);
            propertySetterDescriptorImpl.initialize(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, propertyDescriptor.getType(), annotations2));
            return propertySetterDescriptorImpl;
        } else {
            $$$reportNull$$$03(11);
            throw null;
        }
    }

    public static final String debugInfo(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        m309debugInfo$lambda1$unaryPlus(Intrinsics.stringPlus("type: ", typeConstructor), sb);
        m309debugInfo$lambda1$unaryPlus(Intrinsics.stringPlus("hashCode: ", Integer.valueOf(typeConstructor.hashCode())), sb);
        m309debugInfo$lambda1$unaryPlus(Intrinsics.stringPlus("javaClass: ", typeConstructor.getClass().getCanonicalName()), sb);
        for (DeclarationDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            m309debugInfo$lambda1$unaryPlus(Intrinsics.stringPlus("fqName: ", DescriptorRenderer.FQ_NAMES_IN_TYPES.render(declarationDescriptor)), sb);
            m309debugInfo$lambda1$unaryPlus(Intrinsics.stringPlus("javaClass: ", declarationDescriptor.getClass().getCanonicalName()), sb);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: debugInfo$lambda-1$unaryPlus  reason: not valid java name */
    public static final StringBuilder m309debugInfo$lambda1$unaryPlus(String str, StringBuilder sb) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(sb, "$this_anonymous");
        sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    public static final DescriptorVisibility descriptorVisibility(ProtoEnumFlags protoEnumFlags, ProtoBuf$Visibility protoBuf$Visibility) {
        Intrinsics.checkNotNullParameter(protoEnumFlags, "<this>");
        switch (protoBuf$Visibility == null ? -1 : ProtoEnumFlagsUtilsKt$WhenMappings.$EnumSwitchMapping$2[protoBuf$Visibility.ordinal()]) {
            case 1:
                DescriptorVisibility descriptorVisibility = DescriptorVisibilities.INTERNAL;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "INTERNAL");
                return descriptorVisibility;
            case 2:
                DescriptorVisibility descriptorVisibility2 = DescriptorVisibilities.PRIVATE;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility2, "PRIVATE");
                return descriptorVisibility2;
            case 3:
                DescriptorVisibility descriptorVisibility3 = DescriptorVisibilities.PRIVATE_TO_THIS;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility3, "PRIVATE_TO_THIS");
                return descriptorVisibility3;
            case 4:
                DescriptorVisibility descriptorVisibility4 = DescriptorVisibilities.PROTECTED;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility4, "PROTECTED");
                return descriptorVisibility4;
            case 5:
                DescriptorVisibility descriptorVisibility5 = DescriptorVisibilities.PUBLIC;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility5, "PUBLIC");
                return descriptorVisibility5;
            case 6:
                DescriptorVisibility descriptorVisibility6 = DescriptorVisibilities.LOCAL;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility6, "LOCAL");
                return descriptorVisibility6;
            default:
                DescriptorVisibility descriptorVisibility7 = DescriptorVisibilities.PRIVATE;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility7, "PRIVATE");
                return descriptorVisibility7;
        }
    }

    public static float easeInOut(float f2, float f3, float f4, float f5) {
        float f6 = f2 / (f5 / 2.0f);
        float f7 = f4 / 2.0f;
        if (f6 < 1.0f) {
            return (f7 * f6 * f6 * f6) + f3;
        }
        float f8 = f6 - 2.0f;
        return (((f8 * f8 * f8) + 2.0f) * f7) + f3;
    }

    public static final <T> List<T> filterNotNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, Values.DESTINATION);
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static ReflectJavaAnnotation findAnnotation(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, FqName fqName) {
        Intrinsics.checkNotNullParameter(reflectJavaAnnotationOwner, "this");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
        if (element != null) {
            Annotation[] declaredAnnotations = element.getDeclaredAnnotations();
            if (declaredAnnotations != null) {
                return findAnnotation(declaredAnnotations, fqName);
            }
        }
        return null;
    }

    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor findClassifierAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r10, kotlin.reflect.jvm.internal.impl.name.ClassId r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "classId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r0 = kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt.getResolutionAnchorIfAny(r10)
            java.lang.String r1 = "name"
            r2 = 1
            java.lang.String r3 = "segments.first()"
            java.lang.String r4 = "classId.relativeClassName.pathSegments()"
            java.lang.String r5 = "classId.packageFqName"
            r6 = 0
            if (r0 != 0) goto L_0x0083
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r11.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r10 = r10.getPackage(r0)
            kotlin.reflect.jvm.internal.impl.name.FqName r11 = r11.getRelativeClassName()
            java.util.List r11 = r11.pathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getMemberScope()
            java.lang.Object r0 = kotlin.collections.ArraysKt___ArraysJvmKt.first(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r3 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r3)
            if (r10 != 0) goto L_0x0047
            goto L_0x014c
        L_0x0047:
            int r0 = r11.size()
            java.util.List r11 = r11.subList(r2, r0)
            java.util.Iterator r11 = r11.iterator()
        L_0x0053:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0080
            java.lang.Object r0 = r11.next()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            boolean r2 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r2 != 0) goto L_0x0065
            goto L_0x014c
        L_0x0065:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getUnsubstitutedInnerClassesScope()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r2 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r2)
            boolean r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 == 0) goto L_0x007b
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            goto L_0x007c
        L_0x007b:
            r10 = r6
        L_0x007c:
            if (r10 != 0) goto L_0x0053
            goto L_0x014c
        L_0x0080:
            r6 = r10
            goto L_0x014c
        L_0x0083:
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = r11.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r0 = r0.getPackage(r7)
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = r11.getRelativeClassName()
            java.util.List r7 = r7.pathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getMemberScope()
            java.lang.Object r8 = kotlin.collections.ArraysKt___ArraysJvmKt.first(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            kotlin.reflect.jvm.internal.impl.name.Name r8 = (kotlin.reflect.jvm.internal.impl.name.Name) r8
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r9 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getContributedClassifier(r8, r9)
            if (r0 != 0) goto L_0x00af
            goto L_0x00e5
        L_0x00af:
            int r8 = r7.size()
            java.util.List r7 = r7.subList(r2, r8)
            java.util.Iterator r7 = r7.iterator()
        L_0x00bb:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00e6
            java.lang.Object r8 = r7.next()
            kotlin.reflect.jvm.internal.impl.name.Name r8 = (kotlin.reflect.jvm.internal.impl.name.Name) r8
            boolean r9 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r9 != 0) goto L_0x00cc
            goto L_0x00e5
        L_0x00cc:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getUnsubstitutedInnerClassesScope()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r9 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getContributedClassifier(r8, r9)
            boolean r8 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r8 == 0) goto L_0x00e2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            goto L_0x00e3
        L_0x00e2:
            r0 = r6
        L_0x00e3:
            if (r0 != 0) goto L_0x00bb
        L_0x00e5:
            r0 = r6
        L_0x00e6:
            if (r0 != 0) goto L_0x014b
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r11.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r10 = r10.getPackage(r0)
            kotlin.reflect.jvm.internal.impl.name.FqName r11 = r11.getRelativeClassName()
            java.util.List r11 = r11.pathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getMemberScope()
            java.lang.Object r0 = kotlin.collections.ArraysKt___ArraysJvmKt.first(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r3 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r3)
            if (r10 != 0) goto L_0x0114
            goto L_0x014c
        L_0x0114:
            int r0 = r11.size()
            java.util.List r11 = r11.subList(r2, r0)
            java.util.Iterator r11 = r11.iterator()
        L_0x0120:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0080
            java.lang.Object r0 = r11.next()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            boolean r2 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r2 != 0) goto L_0x0131
            goto L_0x014c
        L_0x0131:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getUnsubstitutedInnerClassesScope()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r2 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r2)
            boolean r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 == 0) goto L_0x0147
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            goto L_0x0148
        L_0x0147:
            r10 = r6
        L_0x0148:
            if (r10 != 0) goto L_0x0120
            goto L_0x014c
        L_0x014b:
            r6 = r0
        L_0x014c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.findClassifierAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.name.ClassId):kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor");
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder kotlinClassFinder, ClassId classId) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Result findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(classId);
        if (findKotlinClassOrContent == null) {
            return null;
        }
        return findKotlinClassOrContent.toKotlinJvmBinaryClass();
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassAcrossModuleDependencies != null) {
            return findClassAcrossModuleDependencies;
        }
        return notFoundClasses.getClass(classId, TypeUtilsKt.toList(TypeUtilsKt.map(TypeUtilsKt.generateSequence(classId, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    public static final <T> T first(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (!(tArr.length == 0)) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T firstOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final Set<Name> flatMapClassifierNamesOrNull(Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        HashSet hashSet = new HashSet();
        for (MemberScope classifierNames : iterable) {
            Set<Name> classifierNames2 = classifierNames.getClassifierNames();
            if (classifierNames2 == null) {
                return null;
            }
            addAll(hashSet, classifierNames2);
        }
        return hashSet;
    }

    public static <T> T fromApplication(Context context, Class<T> cls) {
        return get(getApplication(context.getApplicationContext()), cls);
    }

    public static <T> T get(Object obj, Class<T> cls) {
        if (obj instanceof GeneratedComponent) {
            return cls.cast(obj);
        }
        if (obj instanceof GeneratedComponentManager) {
            return get(((GeneratedComponentManager) obj).generatedComponent(), cls);
        }
        throw new IllegalStateException(String.format("Given component holder %s does not implement %s or %s", new Object[]{obj.getClass(), GeneratedComponent.class, GeneratedComponentManager.class}));
    }

    public static Factory getActivityFactory(ComponentActivity componentActivity, Factory factory) {
        DefaultViewModelFactories$InternalFactoryFactory hiltInternalFactoryFactory = ((DefaultViewModelFactories$ActivityEntryPoint) get(componentActivity, DefaultViewModelFactories$ActivityEntryPoint.class)).getHiltInternalFactoryFactory();
        Bundle bundle = null;
        if (hiltInternalFactoryFactory != null) {
            if (componentActivity.getIntent() != null) {
                bundle = componentActivity.getIntent().getExtras();
            }
            return hiltInternalFactoryFactory.getHiltViewModelFactory(componentActivity, bundle, factory);
        }
        throw null;
    }

    public static List<MediaEntity> getAllMediaEntities(Tweet tweet) {
        ArrayList arrayList = new ArrayList();
        TweetEntities tweetEntities = tweet.entities;
        if (tweetEntities != null) {
            List<MediaEntity> list = tweetEntities.media;
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        TweetEntities tweetEntities2 = tweet.extendedEntities;
        if (tweetEntities2 != null) {
            List<MediaEntity> list2 = tweetEntities2.media;
            if (list2 != null) {
                arrayList.addAll(list2);
            }
        }
        return arrayList;
    }

    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Class<? extends Annotation> annotationType = t.annotationType();
        Intrinsics.checkNotNullExpressionValue(annotationType, "this as java.lang.annota…otation).annotationType()");
        KClass<? extends T> kotlinClass = getKotlinClass(annotationType);
        Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return kotlinClass;
    }

    public static ValueParameterDescriptor getAnnotationParameterByName(Name name, ClassDescriptor classDescriptor) {
        if (name == null) {
            $$$reportNull$$$02(19);
            throw null;
        } else if (classDescriptor != null) {
            Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
            if (constructors.size() != 1) {
                return null;
            }
            for (ValueParameterDescriptor next : constructors.iterator().next().getValueParameters()) {
                if (next.getName().equals(name)) {
                    return next;
                }
            }
            return null;
        } else {
            $$$reportNull$$$02(20);
            throw null;
        }
    }

    public static List<ReflectJavaAnnotation> getAnnotations(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
        Intrinsics.checkNotNullParameter(reflectJavaAnnotationOwner, "this");
        AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
        Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
        if (declaredAnnotations == null) {
            return EmptyList.INSTANCE;
        }
        return getAnnotations(declaredAnnotations);
    }

    public static Application getApplication(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        Context context2 = context;
        while (context2 instanceof ContextWrapper) {
            context2 = ((ContextWrapper) context2).getBaseContext();
            if (context2 instanceof Application) {
                return (Application) context2;
            }
        }
        throw new IllegalStateException("Could not find an Application in the given context: " + context);
    }

    public static TypeArgumentMarker getArgument(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, int i) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof KotlinType) {
            return ((KotlinType) kotlinTypeMarker).getArguments().get(i);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static final int getArity(Caller<?> caller) {
        Intrinsics.checkNotNullParameter(caller, "$this$arity");
        return caller.getParameterTypes().size();
    }

    public static final Object getBoundReceiver(Accessor<?, ?> accessor) {
        Intrinsics.checkNotNullParameter(accessor, "$this$boundReceiver");
        KPropertyImpl property = accessor.getProperty();
        return coerceToExpectedReceiverType(property.rawBoundReceiver, property.getDescriptor());
    }

    public static float[] getCenterFromRect(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
            if (declarationDescriptor != null) {
                return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) declarationDescriptor);
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static final ClassId getClassId(NameResolver nameResolver, int i) {
        Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        ClassId fromString = ClassId.fromString(nameResolver.getQualifiedClassName(i), nameResolver.isLocalClassName(i));
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(getQualifiedClassName(index), isLocalClassName(index))");
        return fromString;
    }

    public static Collection getContributedDescriptors$default(ResolutionScope resolutionScope, DescriptorKindFilter descriptorKindFilter, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            descriptorKindFilter = DescriptorKindFilter.ALL;
        }
        int i2 = i & 2;
        Function1<Name, Boolean> function12 = null;
        if (i2 != 0) {
            if (MemberScope.Companion != null) {
                function12 = MemberScope.Companion.ALL_NAME_FILTER;
            } else {
                throw null;
            }
        }
        return resolutionScope.getContributedDescriptors(descriptorKindFilter, function12);
    }

    public static float[] getCornersFromRect(RectF rectF) {
        float f2 = rectF.left;
        float f3 = rectF.top;
        float f4 = rectF.right;
        float f5 = rectF.bottom;
        return new float[]{f2, f3, f4, f3, f4, f5, f2, f5};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r8 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
        if (r8 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x0031, all -> 0x002f }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0031, all -> 0x002f }
            if (r8 == 0) goto L_0x0029
            boolean r9 = r8.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x0027 }
            if (r9 == 0) goto L_0x0029
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ IllegalArgumentException -> 0x0027 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ IllegalArgumentException -> 0x0027 }
            r8.close()
            return r9
        L_0x0027:
            r9 = move-exception
            goto L_0x0033
        L_0x0029:
            if (r8 == 0) goto L_0x0049
        L_0x002b:
            r8.close()
            goto L_0x0049
        L_0x002f:
            r9 = move-exception
            goto L_0x004c
        L_0x0031:
            r9 = move-exception
            r8 = r7
        L_0x0033:
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch:{ all -> 0x004a }
            java.lang.String r11 = "getDataColumn: _data - [%s]"
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x004a }
            r1 = 0
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x004a }
            r0[r1] = r9     // Catch:{ all -> 0x004a }
            java.lang.String.format(r10, r11, r0)     // Catch:{ all -> 0x004a }
            if (r8 == 0) goto L_0x0049
            goto L_0x002b
        L_0x0049:
            return r7
        L_0x004a:
            r9 = move-exception
            r7 = r8
        L_0x004c:
            if (r7 == 0) goto L_0x0051
            r7.close()
        L_0x0051:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static final KotlinType getEnhancement(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) kotlinType).getEnhancement();
        }
        return null;
    }

    public static final KotlinType getExpectedReceiverType(CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof ConstructorDescriptor) {
            return dispatchReceiverParameter.getType();
        }
        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        if (classDescriptor != null) {
            return classDescriptor.getDefaultType();
        }
        return null;
    }

    public static final <M extends ExtendableMessage<M>, T> T getExtensionOrNull(ExtendableMessage<M> extendableMessage, GeneratedExtension<M, T> generatedExtension) {
        Intrinsics.checkNotNullParameter(extendableMessage, "<this>");
        Intrinsics.checkNotNullParameter(generatedExtension, "extension");
        if (extendableMessage.hasExtension(generatedExtension)) {
            return extendableMessage.getExtension(generatedExtension);
        }
        return null;
    }

    public static FqName getFqName(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "this");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null) {
            return null;
        }
        if (ErrorUtils.isError(annotationClass)) {
            annotationClass = null;
        }
        if (annotationClass == null) {
            return null;
        }
        return DescriptorUtilsKt.fqNameOrNull(annotationClass);
    }

    public static Factory getFragmentFactory(Fragment fragment, Factory factory) {
        DefaultViewModelFactories$InternalFactoryFactory hiltInternalFactoryFactory = ((DefaultViewModelFactories$FragmentEntryPoint) get(fragment, DefaultViewModelFactories$FragmentEntryPoint.class)).getHiltInternalFactoryFactory();
        if (hiltInternalFactoryFactory != null) {
            return hiltInternalFactoryFactory.getHiltViewModelFactory(fragment, fragment.getArguments(), factory);
        }
        throw null;
    }

    public static final <T> Class<T> getJavaClass(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return jClass;
    }

    public static final Field getJavaField(KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "$this$javaField");
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(kProperty);
        if (asKPropertyImpl != null) {
            return asKPropertyImpl.getJavaField();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.reflect.Method getJavaMethod(kotlin.reflect.KFunction<?> r2) {
        /*
            java.lang.String r0 = "$this$javaMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.KCallableImpl r2 = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(r2)
            r0 = 0
            if (r2 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.calls.Caller r2 = r2.getCaller()
            if (r2 == 0) goto L_0x0017
            java.lang.reflect.Member r2 = r2.getMember()
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            boolean r1 = r2 instanceof java.lang.reflect.Method
            if (r1 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.getJavaMethod(kotlin.reflect.KFunction):java.lang.reflect.Method");
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!jClass.isPrimitive()) {
            Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return jClass;
        }
        String name = jClass.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    jClass = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    jClass = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    jClass = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    jClass = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    jClass = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    jClass = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    jClass = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    jClass = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    jClass = Short.class;
                    break;
                }
                break;
        }
        Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return jClass;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Class<T> getJavaPrimitiveType(kotlin.reflect.KClass<T> r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            kotlin.jvm.internal.ClassBasedDeclarationContainer r1 = (kotlin.jvm.internal.ClassBasedDeclarationContainer) r1
            java.lang.Class r1 = r1.getJClass()
            boolean r0 = r1.isPrimitive()
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r0)
            return r1
        L_0x0017:
            java.lang.String r1 = r1.getName()
            int r0 = r1.hashCode()
            switch(r0) {
                case -2056817302: goto L_0x0086;
                case -527879800: goto L_0x007a;
                case -515992664: goto L_0x006e;
                case 155276373: goto L_0x0062;
                case 344809556: goto L_0x0056;
                case 398507100: goto L_0x004a;
                case 398795216: goto L_0x003e;
                case 399092968: goto L_0x0032;
                case 761287205: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0092
        L_0x0024:
            java.lang.String r0 = "java.lang.Double"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x002e
            goto L_0x0092
        L_0x002e:
            java.lang.Class r1 = java.lang.Double.TYPE
            goto L_0x0093
        L_0x0032:
            java.lang.String r0 = "java.lang.Void"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x003b
            goto L_0x0092
        L_0x003b:
            java.lang.Class r1 = java.lang.Void.TYPE
            goto L_0x0093
        L_0x003e:
            java.lang.String r0 = "java.lang.Long"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0047
            goto L_0x0092
        L_0x0047:
            java.lang.Class r1 = java.lang.Long.TYPE
            goto L_0x0093
        L_0x004a:
            java.lang.String r0 = "java.lang.Byte"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0053
            goto L_0x0092
        L_0x0053:
            java.lang.Class r1 = java.lang.Byte.TYPE
            goto L_0x0093
        L_0x0056:
            java.lang.String r0 = "java.lang.Boolean"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x005f
            goto L_0x0092
        L_0x005f:
            java.lang.Class r1 = java.lang.Boolean.TYPE
            goto L_0x0093
        L_0x0062:
            java.lang.String r0 = "java.lang.Character"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x006b
            goto L_0x0092
        L_0x006b:
            java.lang.Class r1 = java.lang.Character.TYPE
            goto L_0x0093
        L_0x006e:
            java.lang.String r0 = "java.lang.Short"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0077
            goto L_0x0092
        L_0x0077:
            java.lang.Class r1 = java.lang.Short.TYPE
            goto L_0x0093
        L_0x007a:
            java.lang.String r0 = "java.lang.Float"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0083
            goto L_0x0092
        L_0x0083:
            java.lang.Class r1 = java.lang.Float.TYPE
            goto L_0x0093
        L_0x0086:
            java.lang.String r0 = "java.lang.Integer"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            java.lang.Class r1 = java.lang.Integer.TYPE
            goto L_0x0093
        L_0x0092:
            r1 = 0
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.getJavaPrimitiveType(kotlin.reflect.KClass):java.lang.Class");
    }

    public static final Type getJavaType(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "$this$javaType");
        Type javaType = ((KTypeImpl) kType).getJavaType();
        return javaType != null ? javaType : TypesJVMKt.getJavaType(kType);
    }

    public static final KClass<?> getJvmErasure(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "$this$jvmErasure");
        KClassifier classifier = kType.getClassifier();
        if (classifier != null) {
            KClass<?> jvmErasure = getJvmErasure(classifier);
            if (jvmErasure != null) {
                return jvmErasure;
            }
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kType);
    }

    public static final String getJvmMethodNameIfSpecial(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor callableMemberDescriptor2;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        String str = null;
        CallableMemberDescriptor overriddenBuiltinWithDifferentJvmName = KotlinBuiltIns.isBuiltIn(callableMemberDescriptor) ? getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) : null;
        if (overriddenBuiltinWithDifferentJvmName == null) {
            callableMemberDescriptor2 = null;
        } else {
            callableMemberDescriptor2 = DescriptorUtilsKt.getPropertyIfAccessor(overriddenBuiltinWithDifferentJvmName);
        }
        if (callableMemberDescriptor2 == null) {
            return null;
        }
        if (callableMemberDescriptor2 instanceof PropertyDescriptor) {
            str = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(callableMemberDescriptor2);
        } else if (callableMemberDescriptor2 instanceof SimpleFunctionDescriptor) {
            BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE;
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) callableMemberDescriptor2;
            Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
            Map<String, Name> map = SpecialGenericSignatures.SIGNATURE_TO_JVM_REPRESENTATION_NAME;
            String computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(simpleFunctionDescriptor);
            Name name = computeJvmSignature == null ? null : map.get(computeJvmSignature);
            if (name != null) {
                str = name.asString();
            }
        }
        return str;
    }

    public static final <T> KClass<T> getKotlinClass(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Reflection.getOrCreateKotlinClass(cls);
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    @TargetApi(17)
    public static int getMaxTextureEgl14() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        int[] iArr = new int[2];
        EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (iArr2[0] == 0) {
            return 0;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344}, 0);
        EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
        int[] iArr3 = new int[1];
        GLES20.glGetIntegerv(GL20.GL_MAX_TEXTURE_SIZE, iArr3, 0);
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
        EGL14.eglDestroyContext(eglGetDisplay, eglCreateContext);
        EGL14.eglTerminate(eglGetDisplay);
        return iArr3[0];
    }

    public static final Name getName(NameResolver nameResolver, int i) {
        Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        Name guessByFirstCharacter = Name.guessByFirstCharacter(nameResolver.getString(i));
        Intrinsics.checkNotNullExpressionValue(guessByFirstCharacter, "guessByFirstCharacter(getString(index))");
        return guessByFirstCharacter;
    }

    public static final Integer getOrNull(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i >= 0) {
            Intrinsics.checkNotNullParameter(iArr, "<this>");
            if (i <= iArr.length - 1) {
                return Integer.valueOf(iArr[i]);
            }
        }
        return null;
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
        T t2 = null;
        if (!SpecialGenericSignatures.ORIGINAL_SHORT_NAMES.contains(t.getName())) {
            BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.INSTANCE;
            if (!BuiltinSpecialProperties.SPECIAL_SHORT_NAMES.contains(DescriptorUtilsKt.getPropertyIfAccessor(t).getName())) {
                return null;
            }
        }
        if (t instanceof PropertyDescriptor ? true : t instanceof PropertyAccessorDescriptor) {
            t2 = DescriptorUtilsKt.firstOverridden$default(t, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1.INSTANCE, 1);
        } else if (t instanceof SimpleFunctionDescriptor) {
            t2 = DescriptorUtilsKt.firstOverridden$default(t, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$2.INSTANCE, 1);
        }
        return t2;
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        T overriddenBuiltinWithDifferentJvmName = getOverriddenBuiltinWithDifferentJvmName(t);
        if (overriddenBuiltinWithDifferentJvmName != null) {
            return overriddenBuiltinWithDifferentJvmName;
        }
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name name = t.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return null;
        }
        return DescriptorUtilsKt.firstOverridden$default(t, false, SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2.INSTANCE, 1);
    }

    public static TypeParameterMarker getParameter(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker, int i) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) typeConstructorMarker).getParameters().get(i);
            Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "this.parameters[index]");
            return typeParameterDescriptor;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static final LazyJavaStaticClassScope getParentJavaStaticClassScope(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        ClassDescriptor superClassNotAny = DescriptorUtilsKt.getSuperClassNotAny(classDescriptor);
        LazyJavaStaticClassScope lazyJavaStaticClassScope = null;
        if (superClassNotAny == null) {
            return null;
        }
        MemberScope staticScope = superClassNotAny.getStaticScope();
        if (staticScope instanceof LazyJavaStaticClassScope) {
            lazyJavaStaticClassScope = (LazyJavaStaticClassScope) staticScope;
        }
        if (lazyJavaStaticClassScope == null) {
            lazyJavaStaticClassScope = getParentJavaStaticClassScope(superClassNotAny);
        }
        return lazyJavaStaticClassScope;
    }

    public static String getPlaybackTime(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT;
        if (i4 > 0) {
            return String.format(Locale.getDefault(), "%1$d:%2$02d:%3$02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)});
        }
        return String.format(Locale.getDefault(), "%1$d:%2$02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }

    public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
            if (declarationDescriptor != null) {
                return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) declarationDescriptor);
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
            if (declarationDescriptor != null) {
                return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) declarationDescriptor);
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static String getProfilePermalink(String str) {
        if (TextUtils.isEmpty(str)) {
            return String.format(Locale.US, "https://twitter.com/%s?ref_src=twsrc%%5Etwitterkit", new Object[]{"twitter_unknown"});
        }
        return String.format(Locale.US, "https://twitter.com/%s?ref_src=twsrc%%5Etwitterkit", new Object[]{str});
    }

    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i >= i2) {
                return i2;
            }
            return i2 - mod(mod(i2, i3) - mod(i, i3), i3);
        } else if (i3 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (i <= i2) {
            return i2;
        } else {
            int i4 = -i3;
            return i2 + mod(mod(i, i4) - mod(i2, i4), i4);
        }
    }

    public static KotlinTypeMarker getRepresentativeUpperBound(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeParameterMarker, "receiver");
        if (typeParameterMarker instanceof TypeParameterDescriptor) {
            return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) typeParameterMarker);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + ", " + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
    }

    public static KotlinTypeMarker getSubstitutedUnderlyingType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof KotlinType) {
            return InlineClassesUtilsKt.substitutedUnderlyingType((KotlinType) kotlinTypeMarker);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static Variant getSupportedVariant(MediaEntity mediaEntity) {
        for (Variant next : mediaEntity.videoInfo.variants) {
            boolean z = true;
            if (!"application/x-mpegURL".equals(next.contentType) && !"video/mp4".equals(next.contentType)) {
                z = false;
                continue;
            }
            if (z) {
                return next;
            }
        }
        return null;
    }

    public static KotlinTypeMarker getType(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeArgumentMarker, "receiver");
        if (typeArgumentMarker instanceof TypeProjection) {
            return ((TypeProjection) typeArgumentMarker).getType().unwrap();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
    }

    public static TypeParameterMarker getTypeParameterClassifier(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                return (TypeParameterDescriptor) declarationDescriptor;
            }
            return null;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static final Method getUnboxMethod(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(cls, "$this$getUnboxMethod");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    public static final <T> Object getValue(NotNullLazyValue notNullLazyValue, KProperty kProperty) {
        Intrinsics.checkNotNullParameter(notNullLazyValue, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "p");
        return notNullLazyValue.invoke();
    }

    public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeArgumentMarker, "receiver");
        if (typeArgumentMarker instanceof TypeProjection) {
            Variance projectionKind = ((TypeProjection) typeArgumentMarker).getProjectionKind();
            Intrinsics.checkNotNullExpressionValue(projectionKind, "this.projectionKind");
            return convertVariance(projectionKind);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement> getVersionRequirements(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor r21) {
        /*
            java.lang.String r0 = "this"
            r1 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r21.getProto()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r2 = r21.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r1 = r21.getVersionRequirementTable()
            java.lang.String r3 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r4 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            boolean r5 = r0 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class
            if (r5 == 0) goto L_0x002d
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class) r0
            java.util.List<java.lang.Integer> r0 = r0.versionRequirement_
            goto L_0x0050
        L_0x002d:
            boolean r5 = r0 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor
            if (r5 == 0) goto L_0x0036
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor) r0
            java.util.List<java.lang.Integer> r0 = r0.versionRequirement_
            goto L_0x0050
        L_0x0036:
            boolean r5 = r0 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function
            if (r5 == 0) goto L_0x003f
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function) r0
            java.util.List<java.lang.Integer> r0 = r0.versionRequirement_
            goto L_0x0050
        L_0x003f:
            boolean r5 = r0 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property
            if (r5 == 0) goto L_0x0048
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property) r0
            java.util.List<java.lang.Integer> r0 = r0.versionRequirement_
            goto L_0x0050
        L_0x0048:
            boolean r5 = r0 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias
            if (r5 == 0) goto L_0x0151
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias) r0
            java.util.List<java.lang.Integer> r0 = r0.versionRequirement_
        L_0x0050:
            java.lang.String r5 = "ids"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x005e:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0150
            java.lang.Object r6 = r0.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            java.lang.String r7 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            int r6 = r6.intValue()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement> r7 = r1.infos
            java.lang.Object r6 = kotlin.collections.ArraysKt___ArraysJvmKt.getOrNull(r7, r6)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement) r6
            if (r6 != 0) goto L_0x0086
            r7 = 0
            goto L_0x0149
        L_0x0086:
            int r8 = r6.bitField0_
            r9 = 1
            r8 = r8 & r9
            r10 = 0
            if (r8 != r9) goto L_0x008f
            r8 = 1
            goto L_0x0090
        L_0x008f:
            r8 = 0
        L_0x0090:
            if (r8 == 0) goto L_0x0099
            int r8 = r6.version_
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x009a
        L_0x0099:
            r8 = 0
        L_0x009a:
            int r11 = r6.bitField0_
            r12 = 2
            r11 = r11 & r12
            if (r11 != r12) goto L_0x00a2
            r11 = 1
            goto L_0x00a3
        L_0x00a2:
            r11 = 0
        L_0x00a3:
            if (r11 == 0) goto L_0x00ac
            int r11 = r6.versionFull_
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x00ad
        L_0x00ac:
            r11 = 0
        L_0x00ad:
            r13 = 16
            r14 = 8
            if (r11 == 0) goto L_0x00ce
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement$Version r8 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement$Version
            int r15 = r11.intValue()
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r16 = r11.intValue()
            int r7 = r16 >> 8
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r11 = r11.intValue()
            int r11 = r11 >> r13
            r11 = r11 & 255(0xff, float:3.57E-43)
            r8.<init>(r15, r7, r11)
            goto L_0x00f0
        L_0x00ce:
            if (r8 == 0) goto L_0x00ee
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement$Version r7 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement$Version
            int r11 = r8.intValue()
            r11 = r11 & 7
            int r15 = r8.intValue()
            int r15 = r15 >> 3
            r15 = r15 & 15
            int r8 = r8.intValue()
            int r8 = r8 >> 7
            r8 = r8 & 127(0x7f, float:1.78E-43)
            r7.<init>(r11, r15, r8)
            r16 = r7
            goto L_0x00f2
        L_0x00ee:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement$Version r8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version.INFINITY
        L_0x00f0:
            r16 = r8
        L_0x00f2:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement$Level r7 = r6.level_
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r7 = r7.ordinal()
            if (r7 == 0) goto L_0x010d
            if (r7 == r9) goto L_0x010a
            if (r7 != r12) goto L_0x0104
            kotlin.DeprecationLevel r7 = kotlin.DeprecationLevel.HIDDEN
            goto L_0x010f
        L_0x0104:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x010a:
            kotlin.DeprecationLevel r7 = kotlin.DeprecationLevel.ERROR
            goto L_0x010f
        L_0x010d:
            kotlin.DeprecationLevel r7 = kotlin.DeprecationLevel.WARNING
        L_0x010f:
            r18 = r7
            int r7 = r6.bitField0_
            r7 = r7 & r14
            if (r7 != r14) goto L_0x0118
            r7 = 1
            goto L_0x0119
        L_0x0118:
            r7 = 0
        L_0x0119:
            if (r7 == 0) goto L_0x0124
            int r7 = r6.errorCode_
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r19 = r7
            goto L_0x0126
        L_0x0124:
            r19 = 0
        L_0x0126:
            int r7 = r6.bitField0_
            r7 = r7 & r13
            if (r7 != r13) goto L_0x012c
            goto L_0x012d
        L_0x012c:
            r9 = 0
        L_0x012d:
            if (r9 == 0) goto L_0x0138
            int r7 = r6.message_
            java.lang.String r7 = r2.getString(r7)
            r20 = r7
            goto L_0x013a
        L_0x0138:
            r20 = 0
        L_0x013a:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement r7 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement$VersionKind r6 = r6.versionKind_
            java.lang.String r8 = "info.versionKind"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            r15 = r7
            r17 = r6
            r15.<init>(r16, r17, r18, r19, r20)
        L_0x0149:
            if (r7 == 0) goto L_0x005e
            r5.add(r7)
            goto L_0x005e
        L_0x0150:
            return r5
        L_0x0151:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "Unexpected declaration: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.getVersionRequirements(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor):java.util.List");
    }

    public static MediaEntity getVideoEntity(Tweet tweet) {
        Iterator it = ((ArrayList) getAllMediaEntities(tweet)).iterator();
        while (it.hasNext()) {
            MediaEntity mediaEntity = (MediaEntity) it.next();
            if (mediaEntity.type != null && isVideoType(mediaEntity)) {
                return mediaEntity;
            }
        }
        return null;
    }

    public static Visibility getVisibility(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
        Intrinsics.checkNotNullParameter(reflectJavaModifierListOwner, "this");
        int modifiers = reflectJavaModifierListOwner.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            return Public.INSTANCE;
        }
        if (Modifier.isPrivate(modifiers)) {
            return Private.INSTANCE;
        }
        if (!Modifier.isProtected(modifiers)) {
            return JavaVisibilities$PackageVisibility.INSTANCE;
        }
        if (Modifier.isStatic(modifiers)) {
            return JavaVisibilities$ProtectedStaticVisibility.INSTANCE;
        }
        return JavaVisibilities$ProtectedAndPackage.INSTANCE;
    }

    public static boolean hasAnnotation(Annotations annotations, FqName fqName) {
        Intrinsics.checkNotNullParameter(annotations, "this");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return annotations.findAnnotation(fqName) != null;
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(ClassDescriptor classDescriptor, CallableDescriptor callableDescriptor) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(callableDescriptor, "specialCallableDescriptor");
        SimpleType defaultType = ((ClassDescriptor) callableDescriptor.getContainingDeclaration()).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "specialCallableDescriptor.containingDeclaration as ClassDescriptor).defaultType");
        ClassDescriptor superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(classDescriptor);
        while (true) {
            boolean z3 = false;
            if (superClassDescriptor == null) {
                return false;
            }
            if (!(superClassDescriptor instanceof JavaClassDescriptor)) {
                SimpleType defaultType2 = superClassDescriptor.getDefaultType();
                KotlinType kotlinType = null;
                if (defaultType2 != null) {
                    TypeCheckerProcedureCallbacksImpl typeCheckerProcedureCallbacksImpl = new TypeCheckerProcedureCallbacksImpl();
                    Intrinsics.checkNotNullParameter(defaultType2, "subtype");
                    Intrinsics.checkNotNullParameter(defaultType, "supertype");
                    Intrinsics.checkNotNullParameter(typeCheckerProcedureCallbacksImpl, "typeCheckingProcedureCallbacks");
                    ArrayDeque arrayDeque = new ArrayDeque();
                    arrayDeque.add(new SubtypePathNode(defaultType2, null));
                    TypeConstructor constructor = defaultType.getConstructor();
                    while (true) {
                        if (arrayDeque.isEmpty()) {
                            break;
                        }
                        SubtypePathNode subtypePathNode = (SubtypePathNode) arrayDeque.poll();
                        KotlinType kotlinType2 = subtypePathNode.type;
                        TypeConstructor constructor2 = kotlinType2.getConstructor();
                        if (typeCheckerProcedureCallbacksImpl.assertEqualTypeConstructors(constructor2, constructor)) {
                            boolean isMarkedNullable = kotlinType2.isMarkedNullable();
                            for (SubtypePathNode subtypePathNode2 = subtypePathNode.previous; subtypePathNode2 != null; subtypePathNode2 = subtypePathNode2.previous) {
                                KotlinType kotlinType3 = subtypePathNode2.type;
                                List<TypeProjection> arguments = kotlinType3.getArguments();
                                if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                                    Iterator<T> it = arguments.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        if (((TypeProjection) it.next()).getProjectionKind() != Variance.INVARIANT) {
                                            z2 = true;
                                            continue;
                                        } else {
                                            z2 = false;
                                            continue;
                                        }
                                        if (z2) {
                                            z = true;
                                            break;
                                        }
                                    }
                                }
                                z = false;
                                if (z) {
                                    KotlinType safeSubstitute = wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(kotlinType3), false, 1).buildSubstitutor().safeSubstitute(kotlinType2, Variance.INVARIANT);
                                    Intrinsics.checkNotNullExpressionValue(safeSubstitute, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                                    kotlinType2 = (KotlinType) TypeUtilsKt.approximateCapturedTypes(safeSubstitute).upper;
                                } else {
                                    kotlinType2 = TypeConstructorSubstitution.Companion.create(kotlinType3).buildSubstitutor().safeSubstitute(kotlinType2, Variance.INVARIANT);
                                    Intrinsics.checkNotNullExpressionValue(kotlinType2, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                                }
                                isMarkedNullable = isMarkedNullable || kotlinType3.isMarkedNullable();
                            }
                            TypeConstructor constructor3 = kotlinType2.getConstructor();
                            if (typeCheckerProcedureCallbacksImpl.assertEqualTypeConstructors(constructor3, constructor)) {
                                kotlinType = TypeUtils.makeNullableAsSpecified(kotlinType2, isMarkedNullable);
                            } else {
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Type constructors should be equals!\nsubstitutedSuperType: ");
                                outline73.append(debugInfo(constructor3));
                                outline73.append(", \n\nsupertype: ");
                                outline73.append(debugInfo(constructor));
                                outline73.append(" \n");
                                outline73.append(typeCheckerProcedureCallbacksImpl.assertEqualTypeConstructors(constructor3, constructor));
                                throw new AssertionError(outline73.toString());
                            }
                        } else {
                            for (KotlinType next : constructor2.getSupertypes()) {
                                Intrinsics.checkNotNullExpressionValue(next, "immediateSupertype");
                                arrayDeque.add(new SubtypePathNode(next, subtypePathNode));
                            }
                        }
                    }
                    if (kotlinType != null) {
                        z3 = true;
                    }
                    if (z3) {
                        return !KotlinBuiltIns.isBuiltIn(superClassDescriptor);
                    }
                } else {
                    TypeCheckingProcedure.$$$reportNull$$$0(0);
                    throw null;
                }
            }
            superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(superClassDescriptor);
        }
    }

    public static final boolean hasReceiver(ProtoBuf$Function protoBuf$Function) {
        Intrinsics.checkNotNullParameter(protoBuf$Function, "<this>");
        return protoBuf$Function.hasReceiverType() || protoBuf$Function.hasReceiverTypeId();
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        HashSet<T> hashSet = new HashSet<>(mapCapacity(tArr.length));
        toCollection(tArr, hashSet);
        return hashSet;
    }

    public static boolean identicalArguments(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "a");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "b");
        if (!(simpleTypeMarker instanceof SimpleType)) {
            StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
            outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(outline83.toString().toString());
        } else if (simpleTypeMarker2 instanceof SimpleType) {
            return ((SimpleType) simpleTypeMarker).getArguments() == ((SimpleType) simpleTypeMarker2).getArguments();
        } else {
            StringBuilder outline832 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker2, ", ");
            outline832.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker2.getClass()));
            throw new IllegalArgumentException(outline832.toString().toString());
        }
    }

    public static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int incompleteStateFor(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            if (b2 > -12) {
                b2 = -1;
            }
            return b2;
        } else if (i3 == 1) {
            return incompleteStateFor(b2, bArr[i]);
        } else {
            if (i3 == 2) {
                return incompleteStateFor((int) b2, (int) bArr[i], (int) bArr[i + 1]);
            }
            throw new AssertionError();
        }
    }

    public static final <T> int indexOf(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
        } else {
            int length2 = tArr.length;
            while (i < length2) {
                if (Intrinsics.areEqual(t, tArr[i])) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType unwrappedType, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        Intrinsics.checkNotNullParameter(kotlinType, "origin");
        return wrapEnhancement(unwrappedType, getEnhancement(kotlinType));
    }

    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        if (continuationImpl == null) {
            return continuation;
        }
        Continuation<Object> intercepted = continuationImpl.intercepted();
        return intercepted == null ? continuation : intercepted;
    }

    public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext classicTypeSystemContext, List<? extends KotlinTypeMarker> list) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(list, "types");
        Intrinsics.checkNotNullParameter(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        } else if (size == 1) {
            return (UnwrappedType) ArraysKt___ArraysJvmKt.single(list);
        } else {
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                UnwrappedType unwrappedType = (UnwrappedType) it.next();
                z = z || isError(unwrappedType);
                if (unwrappedType instanceof SimpleType) {
                    simpleType = (SimpleType) unwrappedType;
                } else if (!(unwrappedType instanceof FlexibleType)) {
                    throw new NoWhenBranchMatchedException();
                } else if (isDynamic(unwrappedType)) {
                    return unwrappedType;
                } else {
                    simpleType = ((FlexibleType) unwrappedType).lowerBound;
                    z2 = true;
                }
                arrayList.add(simpleType);
            }
            if (z) {
                SimpleType createErrorType = ErrorUtils.createErrorType(Intrinsics.stringPlus("Intersection of error types: ", list));
                Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Intersection of error types: $types\")");
                return createErrorType;
            } else if (!z2) {
                return TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList);
            } else {
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(upperIfFlexible((UnwrappedType) it2.next()));
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                return KotlinTypeFactory.flexibleType(TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList), TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList2));
            }
        }
    }

    public static boolean isAnyConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, FqNames.any);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static final boolean isCaptured(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.getConstructor() instanceof CapturedTypeConstructor;
    }

    public static boolean isClassTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            return ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor() instanceof ClassDescriptor;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            boolean z = false;
            if (classDescriptor == null) {
                return false;
            }
            if (!(!isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS)) {
                z = true;
            }
            return z;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static boolean isDenotable(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            return ((TypeConstructor) typeConstructorMarker).isDenotable();
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static boolean isDeprecatedInJavaDoc(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
        Intrinsics.checkNotNullParameter(reflectJavaAnnotationOwner, "this");
        return false;
    }

    public static final boolean isDynamic(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof DynamicType;
    }

    public static boolean isEnumSpecialMethod(FunctionDescriptor functionDescriptor) {
        return functionDescriptor.getKind() == Kind.SYNTHESIZED && DescriptorUtils.isEnumClass(functionDescriptor.getContainingDeclaration());
    }

    public static boolean isError(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof KotlinType) {
            return isError((KotlinType) kotlinTypeMarker);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static final boolean isFinalClass(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        return classDescriptor.getModality() == Modality.FINAL && classDescriptor.getKind() != ClassKind.ENUM_CLASS;
    }

    public static final boolean isFlexible(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof FlexibleType;
    }

    public static boolean isInlineClass(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
            Boolean bool = null;
            DeclarationDescriptor declarationDescriptor2 = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (declarationDescriptor2 != null) {
                bool = Boolean.valueOf(InlineClassesUtilsKt.isInlineClass(declarationDescriptor2));
            }
            return Intrinsics.areEqual(bool, Boolean.TRUE);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            return typeConstructorMarker instanceof IntegerLiteralTypeConstructor;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static boolean isIntersection(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            return typeConstructorMarker instanceof IntersectionTypeConstructor;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static final boolean isJavaField(PropertyDescriptor propertyDescriptor) {
        Intrinsics.checkNotNullParameter(propertyDescriptor, "<this>");
        return propertyDescriptor.getGetter() == null;
    }

    public static final boolean isMappedIntrinsicCompanionObject(CompanionObjectMapping companionObjectMapping, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(companionObjectMapping, "<this>");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            Set<ClassId> set = CompanionObjectMapping.classIds;
            ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
            if (ArraysKt___ArraysJvmKt.contains(set, classId == null ? null : classId.getOuterClassId())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        if (simpleTypeMarker instanceof SimpleType) {
            return ((SimpleType) simpleTypeMarker).isMarkedNullable();
        }
        StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
        outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
        throw new IllegalArgumentException(outline83.toString().toString());
    }

    public static boolean isNothingConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, FqNames.nothing);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static boolean isNullableType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof KotlinType) {
            return TypeUtils.isNullableType((KotlinType) kotlinTypeMarker);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static boolean isPhotoType(MediaEntity mediaEntity) {
        return "photo".equals(mediaEntity.type);
    }

    public static boolean isPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        if (simpleTypeMarker instanceof KotlinType) {
            return KotlinBuiltIns.isPrimitiveType((KotlinType) simpleTypeMarker);
        }
        StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
        outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
        throw new IllegalArgumentException(outline83.toString().toString());
    }

    public static boolean isProjectionNotNull(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(capturedTypeMarker, "receiver");
        if (capturedTypeMarker instanceof NewCapturedType) {
            return ((NewCapturedType) capturedTypeMarker).isProjectionNotNull;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + ", " + Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass())).toString());
    }

    public static boolean isStarProjection(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeArgumentMarker, "receiver");
        if (typeArgumentMarker instanceof TypeProjection) {
            return ((TypeProjection) typeArgumentMarker).isStarProjection();
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
    }

    public static boolean isStubType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        if (simpleTypeMarker instanceof SimpleType) {
            return false;
        }
        StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
        outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
        throw new IllegalArgumentException(outline83.toString().toString());
    }

    public static boolean isTweetResolvable(Tweet tweet) {
        if (tweet != null && tweet.id > 0) {
            User user = tweet.user;
            if (user != null && !TextUtils.isEmpty(user.screenName)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return false;
        }
        return requiresFunctionNameManglingInParameterTypes(TypeUtilsKt.getRepresentativeUpperBound(typeParameterDescriptor));
    }

    public static boolean isUnderKotlinPackage(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
            return Intrinsics.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)), Boolean.TRUE);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return partialIsValidUtf8(bArr, i, i2) == 0;
    }

    public static boolean isVideoType(MediaEntity mediaEntity) {
        return "video".equals(mediaEntity.type) || "animated_gif".equals(mediaEntity.type);
    }

    public static final <T> Iterator<T> iterator(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return new ArrayIterator(tArr);
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(a2, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : tArr) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            TypeUtilsKt.appendElement(a2, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence7 = (i2 & 4) != 0 ? "" : charSequence3;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        CharSequence charSequence8 = (i2 & 16) != 0 ? "..." : null;
        Function1 function12 = (i2 & 32) != 0 ? null : function1;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(charSequence5, "separator");
        Intrinsics.checkNotNullParameter(charSequence6, "prefix");
        Intrinsics.checkNotNullParameter(charSequence7, "postfix");
        Intrinsics.checkNotNullParameter(charSequence8, "truncated");
        StringBuilder sb = new StringBuilder();
        joinTo(objArr, sb, charSequence5, charSequence6, charSequence7, i3, charSequence8, function12);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final <T> T last(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (!(tArr.length == 0)) {
            return tArr[getLastIndex(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> Lazy<T> lazy(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        return new SynchronizedLazyImpl(function0, null, 2);
    }

    public static <T> ReflectProperties$LazySoftVal<T> lazySoft(T t, Function0<T> function0) {
        if (function0 != null) {
            return new ReflectProperties$LazySoftVal<>(t, function0);
        }
        $$$reportNull$$$0(1);
        throw null;
    }

    public static final <T> List<T> listOf(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(element)");
        return singletonList;
    }

    public static final <T> List<T> listOfNotNull(T t) {
        if (t != null) {
            return listOf(t);
        }
        return EmptyList.INSTANCE;
    }

    public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(flexibleTypeMarker, "receiver");
        if (flexibleTypeMarker instanceof FlexibleType) {
            return ((FlexibleType) flexibleTypeMarker).lowerBound;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
    }

    public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
        if (asFlexibleType != null) {
            return typeSystemContext.lowerBound(asFlexibleType);
        }
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        Intrinsics.checkNotNull(asSimpleType);
        return asSimpleType;
    }

    public static final SimpleType lowerIfFlexible(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrap).lowerBound;
        }
        if (unwrap instanceof SimpleType) {
            return (SimpleType) unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static KotlinTypeMarker lowerType(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(capturedTypeMarker, "receiver");
        if (capturedTypeMarker instanceof NewCapturedType) {
            return ((NewCapturedType) capturedTypeMarker).lowerType;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + ", " + Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass())).toString());
    }

    public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof UnwrappedType) {
            return SpecialTypesKt.makeDefinitelyNotNullOrNotNull$default((UnwrappedType) kotlinTypeMarker, false, 1);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static KotlinTypeMarker makeNullable(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        SimpleTypeMarker asSimpleType = classicTypeSystemContext.asSimpleType(kotlinTypeMarker);
        return asSimpleType == null ? kotlinTypeMarker : classicTypeSystemContext.withNullability(asSimpleType, true);
    }

    public static final int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.first, pair.second);
        Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f3, code lost:
        if (r6 == false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0191, code lost:
        if (r0 == null) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0196, code lost:
        if (r0 == null) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x019b, code lost:
        if (r0 == null) goto L_0x019d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object mapType(kotlin.reflect.jvm.internal.impl.types.KotlinType r19, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory r20, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r21, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration r22, kotlin.jvm.functions.Function3 r23) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            java.lang.String r5 = "kotlinType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
            java.lang.String r5 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "mode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            java.lang.String r6 = "typeMappingConfiguration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            java.lang.String r6 = "writeGenericType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r3.preprocessType(r0)
            if (r6 != 0) goto L_0x0292
            boolean r6 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(r19)
            if (r6 == 0) goto L_0x003e
            boolean r5 = r22.releaseCoroutines()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(r0, r5)
            java.lang.Object r0 = mapType(r0, r1, r2, r3, r4)
            return r0
        L_0x003e:
            kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext r6 = kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            java.lang.String r8 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r8)
            java.lang.String r9 = "typeFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r5 = typeConstructor(r6, r0)
            boolean r9 = isClassTypeConstructor(r6, r5)
            r10 = 0
            java.lang.String r11 = "possiblyPrimitiveType"
            java.lang.String r12 = "["
            r13 = 1
            r14 = 0
            if (r9 != 0) goto L_0x0067
            goto L_0x0107
        L_0x0067:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r9 = getPrimitiveType(r6, r5)
            if (r9 == 0) goto L_0x009c
            java.lang.Object r5 = r1.createPrimitiveType(r9)
            boolean r9 = isNullableType(r6, r0)
            if (r9 != 0) goto L_0x008d
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r8)
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION
            java.lang.String r9 = "ENHANCED_NULLABILITY_ANNOTATION"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            boolean r6 = hasAnnotation(r6, r0, r8)
            if (r6 == 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r6 = 0
            goto L_0x008e
        L_0x008d:
            r6 = 1
        L_0x008e:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r11)
            if (r6 == 0) goto L_0x009a
            java.lang.Object r5 = r1.boxType(r5)
        L_0x009a:
            r10 = r5
            goto L_0x0107
        L_0x009c:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r8 = getPrimitiveArrayType(r6, r5)
            if (r8 == 0) goto L_0x00b3
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType r5 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.get(r8)
            java.lang.String r5 = r5.getDesc()
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r5)
            java.lang.Object r10 = r1.createFromString(r5)
            goto L_0x0107
        L_0x00b3:
            boolean r8 = isUnderKotlinPackage(r6, r5)
            if (r8 == 0) goto L_0x0107
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r5 = getClassFqNameUnsafe(r6, r5)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap r6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.ClassId r5 = r6.mapKotlinToJava(r5)
            if (r5 == 0) goto L_0x0107
            boolean r6 = r2.kotlinCollectionsToJavaCollections
            if (r6 != 0) goto L_0x00f6
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap r6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE
            java.util.List<kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap$PlatformMutabilityMapping> r6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.mutabilityMappings
            boolean r8 = r6 instanceof java.util.Collection
            if (r8 == 0) goto L_0x00d8
            boolean r8 = r6.isEmpty()
            if (r8 == 0) goto L_0x00d8
            goto L_0x00f2
        L_0x00d8:
            java.util.Iterator r6 = r6.iterator()
        L_0x00dc:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00f2
            java.lang.Object r8 = r6.next()
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap$PlatformMutabilityMapping r8 = (kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping) r8
            kotlin.reflect.jvm.internal.impl.name.ClassId r8 = r8.javaClass
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r5)
            if (r8 == 0) goto L_0x00dc
            r6 = 1
            goto L_0x00f3
        L_0x00f2:
            r6 = 0
        L_0x00f3:
            if (r6 == 0) goto L_0x00f6
            goto L_0x0107
        L_0x00f6:
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r5 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byClassId(r5)
            java.lang.String r5 = r5.getInternalName()
            java.lang.String r6 = "byClassId(classId).internalName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.Object r10 = r1.createObjectType(r5)
        L_0x0107:
            if (r10 != 0) goto L_0x0280
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r19.getConstructor()
            boolean r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r6 == 0) goto L_0x0126
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r5 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r5
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r5.alternative
            if (r0 != 0) goto L_0x011d
            java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.types.KotlinType> r0 = r5.intersectedTypes
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r3.commonSupertype(r0)
        L_0x011d:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r0)
            java.lang.Object r0 = mapType(r0, r1, r2, r3, r4)
            return r0
        L_0x0126:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r5 = r5.getDeclarationDescriptor()
            if (r5 == 0) goto L_0x0274
            boolean r6 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.isError(r5)
            if (r6 == 0) goto L_0x013e
            java.lang.String r2 = "error/NonExistentClass"
            java.lang.Object r1 = r1.createObjectType(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r5
            r3.processErrorType(r0, r5)
            return r1
        L_0x013e:
            boolean r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r6 == 0) goto L_0x01b7
            boolean r8 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(r19)
            if (r8 == 0) goto L_0x01b7
            java.util.List r5 = r19.getArguments()
            int r5 = r5.size()
            if (r5 != r13) goto L_0x01af
            java.util.List r0 = r19.getArguments()
            java.lang.Object r0 = r0.get(r14)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r0.getType()
            java.lang.String r6 = "memberProjection.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = r0.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r7 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r6 != r7) goto L_0x0174
            java.lang.String r0 = "java/lang/Object"
            java.lang.Object r0 = r1.createObjectType(r0)
            goto L_0x01a2
        L_0x0174:
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = r0.getProjectionKind()
            java.lang.String r6 = "memberProjection.projectionKind"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            java.lang.String r6 = "effectiveVariance"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
            boolean r6 = r2.isForAnnotationParameter
            if (r6 == 0) goto L_0x0187
            goto L_0x019d
        L_0x0187:
            int r0 = r0.ordinal()
            if (r0 == 0) goto L_0x0199
            if (r0 == r13) goto L_0x0194
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r0 = r2.genericArgumentMode
            if (r0 != 0) goto L_0x019e
            goto L_0x019d
        L_0x0194:
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r0 = r2.genericContravariantArgumentMode
            if (r0 != 0) goto L_0x019e
            goto L_0x019d
        L_0x0199:
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r0 = r2.genericInvariantArgumentMode
            if (r0 != 0) goto L_0x019e
        L_0x019d:
            r0 = r2
        L_0x019e:
            java.lang.Object r0 = mapType(r5, r1, r0, r3, r4)
        L_0x01a2:
            java.lang.String r0 = r1.toString(r0)
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r0)
            java.lang.Object r0 = r1.createFromString(r0)
            return r0
        L_0x01af:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "arrays must have one type argument"
            r0.<init>(r1)
            throw r0
        L_0x01b7:
            if (r6 == 0) goto L_0x0244
            boolean r6 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r5)
            if (r6 == 0) goto L_0x01fc
            boolean r6 = r2.needInlineClassWrapping
            if (r6 != 0) goto L_0x01fc
            kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext r6 = kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            java.lang.String r7 = "inlineClassType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r7)
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = computeExpandedTypeInner(r6, r0, r7)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
            if (r6 == 0) goto L_0x01fc
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r0 = new kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode
            boolean r8 = r2.needPrimitiveBoxing
            boolean r10 = r2.isForAnnotationParameter
            boolean r11 = r2.skipDeclarationSiteWildcards
            boolean r12 = r2.skipDeclarationSiteWildcardsIfPossible
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r13 = r2.genericArgumentMode
            boolean r14 = r2.kotlinCollectionsToJavaCollections
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r15 = r2.genericContravariantArgumentMode
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r2 = r2.genericInvariantArgumentMode
            r9 = 1
            r17 = 0
            r18 = 512(0x200, float:7.17E-43)
            r7 = r0
            r16 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            java.lang.Object r0 = mapType(r6, r1, r0, r3, r4)
            return r0
        L_0x01fc:
            boolean r6 = r2.isForAnnotationParameter
            if (r6 == 0) goto L_0x020e
            r6 = r5
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            boolean r6 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isKClass(r6)
            if (r6 == 0) goto L_0x020e
            java.lang.Object r1 = r20.getJavaLangClassType()
            goto L_0x0240
        L_0x020e:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r5
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = r5.getOriginal()
            java.lang.String r7 = "descriptor.original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.Object r6 = r3.getPredefinedTypeForClass(r6)
            if (r6 != 0) goto L_0x023f
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = r5.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r7 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY
            if (r6 != r7) goto L_0x022d
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r5.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r5
        L_0x022d:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = r5.getOriginal()
            java.lang.String r6 = "enumClassIfEnumEntry.original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r3 = computeInternalName(r5, r3)
            java.lang.Object r1 = r1.createObjectType(r3)
            goto L_0x0240
        L_0x023f:
            r1 = r6
        L_0x0240:
            r4.invoke(r0, r1, r2)
            return r1
        L_0x0244:
            boolean r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r6 == 0) goto L_0x0255
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(r5)
            kotlin.jvm.functions.Function3<java.lang.Object, java.lang.Object, java.lang.Object, kotlin.Unit> r4 = kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.DO_NOTHING_3
            java.lang.Object r0 = mapType(r0, r1, r2, r3, r4)
            return r0
        L_0x0255:
            boolean r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
            if (r6 == 0) goto L_0x0268
            boolean r6 = r2.mapTypeAliases
            if (r6 == 0) goto L_0x0268
            kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) r5
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r5.getExpandedType()
            java.lang.Object r0 = mapType(r0, r1, r2, r3, r4)
            return r0
        L_0x0268:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Unknown type "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x0274:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "no descriptor for type constructor of "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x0280:
            boolean r3 = r2.needPrimitiveBoxing
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            if (r3 == 0) goto L_0x028e
            java.lang.Object r10 = r1.boxType(r10)
        L_0x028e:
            r4.invoke(r0, r10, r2)
            return r10
        L_0x0292:
            java.lang.Object r0 = mapType(r6, r1, r2, r3, r4)     // Catch:{ all -> 0x0297 }
            return r0
        L_0x0297:
            r0 = move-exception
            r1 = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.mapType(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public static final Kind memberKind(ProtoEnumFlags protoEnumFlags, ProtoBuf$MemberKind protoBuf$MemberKind) {
        Intrinsics.checkNotNullParameter(protoEnumFlags, "<this>");
        int i = protoBuf$MemberKind == null ? -1 : ProtoEnumFlagsUtilsKt$WhenMappings.$EnumSwitchMapping$0[protoBuf$MemberKind.ordinal()];
        if (i == 1) {
            return Kind.DECLARATION;
        }
        if (i == 2) {
            return Kind.FAKE_OVERRIDE;
        }
        if (i == 3) {
            return Kind.DELEGATION;
        }
        if (i != 4) {
            return Kind.DECLARATION;
        }
        return Kind.SYNTHESIZED;
    }

    public static final int mod(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static final <T> List<T> mutableListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(tArr, true));
    }

    public static final int nextInt(Random random, IntRange intRange) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(intRange, "range");
        if (!intRange.isEmpty()) {
            int i = intRange.last;
            if (i < Integer.MAX_VALUE) {
                return random.nextInt(intRange.first, i + 1);
            }
            int i2 = intRange.first;
            if (i2 > Integer.MIN_VALUE) {
                return random.nextInt(i2 - 1, i) + 1;
            }
            return random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + intRange);
    }

    public static void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            boolean z = true;
            if (!(th instanceof OnErrorNotImplementedException) && !(th instanceof MissingBackpressureException) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof CompositeException)) {
                z = false;
            }
            if (!z) {
                th = new UndeliverableException(th);
            }
        }
        th.printStackTrace();
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size == 0) {
            return EmptyList.INSTANCE;
        }
        if (size != 1) {
            return list;
        }
        return listOf((T) list.get(0));
    }

    public static SimpleTypeMarker original(ClassicTypeSystemContext classicTypeSystemContext, DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(definitelyNotNullTypeMarker, "receiver");
        if (definitelyNotNullTypeMarker instanceof DefinitelyNotNullType) {
            return ((DefinitelyNotNullType) definitelyNotNullTypeMarker).original;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + definitelyNotNullTypeMarker + ", " + Reflection.getOrCreateKotlinClass(definitelyNotNullTypeMarker.getClass())).toString());
    }

    public static final ProtoBuf$Type outerType(ProtoBuf$Type protoBuf$Type, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter(protoBuf$Type, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (protoBuf$Type.hasOuterType()) {
            return protoBuf$Type.outerType_;
        }
        if ((protoBuf$Type.bitField0_ & 512) == 512) {
            return typeTable.get(protoBuf$Type.outerTypeId_);
        }
        return null;
    }

    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider packageFragmentProvider, FqName fqName) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(packageFragmentProvider, fqName, arrayList);
        return arrayList;
    }

    public static int parametersCount(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            return ((TypeConstructor) typeConstructorMarker).getParameters().size();
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    public static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
        while (r8 < i2 && bArr[r8] >= 0) {
            i = r8 + 1;
        }
        if (r8 >= i2) {
            return 0;
        }
        while (r8 < i2) {
            int i3 = r8 + 1;
            byte b2 = bArr[r8];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i3 >= i2) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        r8 = i3 + 1;
                        if (bArr[i3] > -65) {
                        }
                    }
                } else if (b2 < -16) {
                    if (i3 >= i2 - 1) {
                        return incompleteStateFor(bArr, i3, i2);
                    }
                    int i4 = i3 + 1;
                    byte b3 = bArr[i3];
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        r8 = i4 + 1;
                        if (bArr[i4] > -65) {
                        }
                    }
                } else if (i3 >= i2 - 2) {
                    return incompleteStateFor(bArr, i3, i2);
                } else {
                    int i5 = i3 + 1;
                    byte b4 = bArr[i3];
                    if (b4 <= -65) {
                        if ((((b4 + 112) + (b2 << 28)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (bArr[i5] <= -65) {
                                i3 = i6 + 1;
                                if (bArr[i6] > -65) {
                                }
                            }
                        }
                    }
                }
                return -1;
            }
            r8 = i3;
        }
        return 0;
    }

    public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        TypeConstructorMarker typeConstructor = classicTypeSystemContext.typeConstructor(simpleTypeMarker);
        if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor).possibleTypes;
        }
        StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
        outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
        throw new IllegalArgumentException(outline83.toString().toString());
    }

    public static final Name propertyNameBySetMethodName(Name name, boolean z) {
        Intrinsics.checkNotNullParameter(name, PromiseImpl.STACK_FRAME_KEY_METHOD_NAME);
        return propertyNameFromAccessorMethodName$default(name, "set", false, z ? "is" : null, 4);
    }

    public static Name propertyNameFromAccessorMethodName$default(Name name, String str, boolean z, String str2, int i) {
        Object obj;
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if (!name.special) {
            String identifier = name.getIdentifier();
            Intrinsics.checkNotNullExpressionValue(identifier, "methodName.identifier");
            boolean z2 = false;
            if (CharsKt__CharKt.startsWith$default(identifier, str, false, 2) && identifier.length() != str.length()) {
                char charAt = identifier.charAt(str.length());
                if (!('a' <= charAt && charAt <= 'z')) {
                    if (str2 != null) {
                        if (!_Assertions.ENABLED || z) {
                            return Name.identifier(Intrinsics.stringPlus(str2, CharsKt__CharKt.removePrefix(identifier, str)));
                        }
                        throw new AssertionError("Assertion failed");
                    } else if (!z) {
                        return name;
                    } else {
                        String removePrefix = CharsKt__CharKt.removePrefix(identifier, str);
                        Intrinsics.checkNotNullParameter(removePrefix, "<this>");
                        if (!(removePrefix.length() == 0) && TypeUtilsKt.isUpperCaseCharAt(removePrefix, 0, true)) {
                            if (removePrefix.length() == 1 || !TypeUtilsKt.isUpperCaseCharAt(removePrefix, 1, true)) {
                                Intrinsics.checkNotNullParameter(removePrefix, "<this>");
                                if (!(removePrefix.length() == 0)) {
                                    char charAt2 = removePrefix.charAt(0);
                                    if ('A' <= charAt2 && charAt2 <= 'Z') {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        char lowerCase = Character.toLowerCase(charAt2);
                                        Intrinsics.checkNotNullExpressionValue(removePrefix.substring(1), "(this as java.lang.String).substring(startIndex)");
                                        removePrefix = String.valueOf(lowerCase) + r5;
                                    }
                                }
                            } else {
                                Intrinsics.checkNotNullParameter(removePrefix, "<this>");
                                IntIterator it = new IntRange(0, removePrefix.length() - 1).iterator();
                                while (true) {
                                    if (!((IntProgressionIterator) it).hasNext) {
                                        obj = null;
                                        break;
                                    }
                                    obj = it.next();
                                    if (!TypeUtilsKt.isUpperCaseCharAt(removePrefix, ((Number) obj).intValue(), true)) {
                                        break;
                                    }
                                }
                                Integer num = (Integer) obj;
                                if (num == null) {
                                    removePrefix = TypeUtilsKt.toLowerCase(removePrefix, true);
                                } else {
                                    int intValue = num.intValue() - 1;
                                    String substring = removePrefix.substring(0, intValue);
                                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    String lowerCase2 = TypeUtilsKt.toLowerCase(substring, true);
                                    String substring2 = removePrefix.substring(intValue);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                                    removePrefix = Intrinsics.stringPlus(lowerCase2, substring2);
                                }
                            }
                        }
                        if (Name.isValidIdentifier(removePrefix)) {
                            return Name.identifier(removePrefix);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static Application provideApplication(ApplicationContextModule applicationContextModule) {
        Application application = getApplication(applicationContextModule.applicationContext);
        checkNotNullFromProvides(application);
        return application;
    }

    public static Context provideContext(ApplicationContextModule applicationContextModule) {
        Context context = applicationContextModule.applicationContext;
        checkNotNullFromProvides(context);
        return context;
    }

    public static final String readText(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(stringWriter, "out");
        char[] cArr = new char[8192];
        int read = reader.read(cArr);
        while (read >= 0) {
            stringWriter.write(cArr, 0, read);
            read = reader.read(cArr);
        }
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    public static final ProtoBuf$Type receiverType(ProtoBuf$Function protoBuf$Function, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter(protoBuf$Function, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (protoBuf$Function.hasReceiverType()) {
            return protoBuf$Function.receiverType_;
        }
        if (protoBuf$Function.hasReceiverTypeId()) {
            return typeTable.get(protoBuf$Function.receiverTypeId_);
        }
        return null;
    }

    public static final void record(LookupTracker lookupTracker, LookupLocation lookupLocation, ClassDescriptor classDescriptor, Name name) {
        Position position;
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(lookupLocation, "from");
        Intrinsics.checkNotNullParameter(classDescriptor, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        if (lookupTracker != DO_NOTHING.INSTANCE) {
            LocationInfo location = lookupLocation.getLocation();
            if (location != null) {
                if (lookupTracker.getRequiresPosition()) {
                    position = location.getPosition();
                } else {
                    position = Position.NO_POSITION;
                }
                String filePath = location.getFilePath();
                String asString = DescriptorUtils.getFqName(classDescriptor).asString();
                Intrinsics.checkNotNullExpressionValue(asString, "getFqName(scopeOwner).asString()");
                ScopeKind scopeKind = ScopeKind.CLASSIFIER;
                String asString2 = name.asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "name.asString()");
                lookupTracker.record(filePath, position, asString, scopeKind, asString2);
            }
        }
    }

    public static final <T> T removeLast(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r0 != false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String render(kotlin.reflect.jvm.internal.impl.name.Name r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7.special
            java.lang.String r1 = "asString()"
            r2 = 0
            if (r0 == 0) goto L_0x000d
            goto L_0x0040
        L_0x000d:
            java.lang.String r0 = r7.asString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Set<java.lang.String> r3 = kotlin.reflect.jvm.internal.impl.renderer.KeywordStringsGenerated.KEYWORDS
            boolean r3 = r3.contains(r0)
            r4 = 1
            if (r3 != 0) goto L_0x003f
            r3 = 0
        L_0x001e:
            int r5 = r0.length()
            if (r3 >= r5) goto L_0x003c
            char r5 = r0.charAt(r3)
            boolean r6 = java.lang.Character.isLetterOrDigit(r5)
            if (r6 != 0) goto L_0x0034
            r6 = 95
            if (r5 == r6) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            if (r5 == 0) goto L_0x0039
            r0 = 1
            goto L_0x003d
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x001e
        L_0x003c:
            r0 = 0
        L_0x003d:
            if (r0 == 0) goto L_0x0040
        L_0x003f:
            r2 = 1
        L_0x0040:
            if (r2 == 0) goto L_0x0065
            r0 = 96
            java.lang.String r7 = r7.asString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String r0 = "`"
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r0)
            goto L_0x006c
        L_0x0065:
            java.lang.String r7 = r7.asString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
        L_0x006c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.render(kotlin.reflect.jvm.internal.impl.name.Name):java.lang.String");
    }

    public static final String renderFqName(List<Name> list) {
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (Name next : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(next));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final SimpleType replace(SimpleType simpleType, List<? extends TypeProjection> list, Annotations annotations) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        Intrinsics.checkNotNullParameter(list, "newArguments");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        if (list.isEmpty() && annotations == simpleType.getAnnotations()) {
            return simpleType;
        }
        if (list.isEmpty()) {
            return simpleType.replaceAnnotations(annotations);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.simpleType$default(annotations, simpleType.getConstructor(), list, simpleType.isMarkedNullable(), null, 16);
    }

    public static KotlinType replace$default(KotlinType kotlinType, List<TypeProjection> list, Annotations annotations, List list2, int i) {
        if ((i & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((i & 2) != 0) {
            annotations = kotlinType.getAnnotations();
        }
        List list3 = (i & 4) != 0 ? list : null;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(list, "newArguments");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        Intrinsics.checkNotNullParameter(list3, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == kotlinType.getArguments()) && annotations == kotlinType.getAnnotations()) {
            return kotlinType;
        }
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            FlexibleType flexibleType = (FlexibleType) unwrap;
            return KotlinTypeFactory.flexibleType(replace(flexibleType.lowerBound, list, annotations), replace(flexibleType.upperBound, list3, annotations));
        } else if (unwrap instanceof SimpleType) {
            return replace((SimpleType) unwrap, list, annotations);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean requiresFunctionNameManglingInParameterTypes(KotlinType kotlinType) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            bool = null;
        } else {
            Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
            bool = Boolean.valueOf(InlineClassesUtilsKt.isInlineClass(declarationDescriptor) && !Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) declarationDescriptor), StandardNames.RESULT_FQ_NAME));
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE) || isTypeParameterWithUpperBoundThatRequiresMangling(kotlinType)) {
            return true;
        }
        return false;
    }

    public static final <E> void resetAt(E[] eArr, int i) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        eArr[i] = null;
    }

    public static final <E> void resetRange(E[] eArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        while (i < i2) {
            resetAt(eArr, i);
            i++;
        }
    }

    public static final Annotations resolveAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        Intrinsics.checkNotNullParameter(javaAnnotationOwner, "annotationsOwner");
        return new LazyJavaAnnotations(lazyJavaResolverContext, javaAnnotationOwner, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor resolveClassByFqName(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r5, kotlin.reflect.jvm.internal.impl.name.FqName r6, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "fqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "lookupLocation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r6.isRoot()
            r1 = 0
            if (r0 == 0) goto L_0x0017
            return r1
        L_0x0017:
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r6.parent()
            java.lang.String r2 = "fqName.parent()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r0 = r5.getPackage(r0)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getMemberScope()
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r6.shortName()
            java.lang.String r4 = "fqName.shortName()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getContributedClassifier(r3, r7)
            boolean r3 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x003c
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            goto L_0x003d
        L_0x003c:
            r0 = r1
        L_0x003d:
            if (r0 != 0) goto L_0x0068
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r6.parent()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = resolveClassByFqName(r5, r0, r7)
            if (r5 != 0) goto L_0x004e
        L_0x004c:
            r5 = r1
            goto L_0x0060
        L_0x004e:
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r5 = r5.getUnsubstitutedInnerClassesScope()
            if (r5 != 0) goto L_0x0055
            goto L_0x004c
        L_0x0055:
            kotlin.reflect.jvm.internal.impl.name.Name r6 = r6.shortName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r5 = r5.getContributedClassifier(r6, r7)
        L_0x0060:
            boolean r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r6 == 0) goto L_0x0067
            r1 = r5
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1
        L_0x0067:
            return r1
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.resolveClassByFqName(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation):kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor");
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverrides(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter, OverridingUtil overridingUtil, boolean z) {
        if (name == null) {
            $$$reportNull$$$02(12);
            throw null;
        } else if (collection == null) {
            $$$reportNull$$$02(13);
            throw null;
        } else if (collection2 == null) {
            $$$reportNull$$$02(14);
            throw null;
        } else if (classDescriptor == null) {
            $$$reportNull$$$02(15);
            throw null;
        } else if (errorReporter == null) {
            $$$reportNull$$$02(16);
            throw null;
        } else if (overridingUtil != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            overridingUtil.generateOverridesInFunctionGroup(name, collection, collection2, classDescriptor, new DescriptorResolverUtils$1(errorReporter, linkedHashSet, z));
            return linkedHashSet;
        } else {
            $$$reportNull$$$02(17);
            throw null;
        }
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter, OverridingUtil overridingUtil) {
        if (name == null) {
            $$$reportNull$$$02(0);
            throw null;
        } else if (collection == null) {
            $$$reportNull$$$02(1);
            throw null;
        } else if (collection2 == null) {
            $$$reportNull$$$02(2);
            throw null;
        } else if (classDescriptor == null) {
            $$$reportNull$$$02(3);
            throw null;
        } else if (errorReporter == null) {
            $$$reportNull$$$02(4);
            throw null;
        } else if (overridingUtil != null) {
            return resolveOverrides(name, collection, collection2, classDescriptor, errorReporter, overridingUtil, false);
        } else {
            $$$reportNull$$$02(5);
            throw null;
        }
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter, OverridingUtil overridingUtil) {
        if (collection == null) {
            $$$reportNull$$$02(7);
            throw null;
        } else if (classDescriptor == null) {
            $$$reportNull$$$02(9);
            throw null;
        } else if (errorReporter == null) {
            $$$reportNull$$$02(10);
            throw null;
        } else if (overridingUtil != null) {
            return resolveOverrides(name, collection, collection2, classDescriptor, errorReporter, overridingUtil, true);
        } else {
            $$$reportNull$$$02(11);
            throw null;
        }
    }

    public static final ProtoBuf$Type returnType(ProtoBuf$Function protoBuf$Function, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter(protoBuf$Function, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (protoBuf$Function.hasReturnType()) {
            ProtoBuf$Type protoBuf$Type = protoBuf$Function.returnType_;
            Intrinsics.checkNotNullExpressionValue(protoBuf$Type, "returnType");
            return protoBuf$Type;
        }
        if ((protoBuf$Function.bitField0_ & 16) == 16) {
            return typeTable.get(protoBuf$Function.returnTypeId_);
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Set<? extends T>, code=java.util.Set, for r1v0, types: [java.util.Set<? extends T>, java.util.Set, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T select(java.util.Set r1, T r2, T r3, T r4, boolean r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "low"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "high"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r5 == 0) goto L_0x0035
            boolean r5 = r1.contains(r2)
            r0 = 0
            if (r5 == 0) goto L_0x001a
            r1 = r2
            goto L_0x0023
        L_0x001a:
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto L_0x0022
            r1 = r3
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r2 == 0) goto L_0x0031
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r3)
            if (r2 == 0) goto L_0x0031
            r4 = r0
            goto L_0x0034
        L_0x0031:
            if (r4 != 0) goto L_0x0034
            r4 = r1
        L_0x0034:
            return r4
        L_0x0035:
            if (r4 != 0) goto L_0x0038
            goto L_0x0040
        L_0x0038:
            java.util.Set r1 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r1, r4)
            java.util.Set r1 = kotlin.collections.ArraysKt___ArraysJvmKt.toSet(r1)
        L_0x0040:
            java.lang.Object r1 = kotlin.collections.ArraysKt___ArraysJvmKt.singleOrNull(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.select(java.util.Set, java.lang.Object, java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends CallableDescriptor> function1) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet create = SmartSet.Companion.create();
        while (!linkedList.isEmpty()) {
            Object first = ArraysKt___ArraysJvmKt.first((List<? extends T>) linkedList);
            SmartSet create2 = SmartSet.Companion.create();
            Collection extractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(first, linkedList, function1, new OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(create2));
            Intrinsics.checkNotNullExpressionValue(extractMembersOverridableInBothWays, "val conflictedHandles = SmartSet.create<H>()\n\n        val overridableGroup =\n            OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle) { conflictedHandles.add(it) }");
            ArrayList arrayList = (ArrayList) extractMembersOverridableInBothWays;
            if (arrayList.size() != 1 || !create2.isEmpty()) {
                Object selectMostSpecificMember = OverridingUtil.selectMostSpecificMember(extractMembersOverridableInBothWays, function1);
                Intrinsics.checkNotNullExpressionValue(selectMostSpecificMember, "selectMostSpecificMember(overridableGroup, descriptorByHandle)");
                CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(selectMostSpecificMember);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "it");
                    if (!OverridingUtil.isMoreSpecific(callableDescriptor, (CallableDescriptor) function1.invoke(next))) {
                        create2.add(next);
                    }
                }
                if (!create2.isEmpty()) {
                    create.addAll(create2);
                }
                create.add(selectMostSpecificMember);
            } else {
                Object single = ArraysKt___ArraysJvmKt.single((Iterable<? extends T>) extractMembersOverridableInBothWays);
                Intrinsics.checkNotNullExpressionValue(single, "overridableGroup.single()");
                create.add(single);
            }
        }
        return create;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setAccessible(kotlin.reflect.KCallable<?> r3, boolean r4) {
        /*
            java.lang.String r0 = "$this$isAccessible"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3 instanceof kotlin.reflect.KMutableProperty
            java.lang.String r1 = "$this$javaGetter"
            if (r0 == 0) goto L_0x003d
            r0 = r3
            kotlin.reflect.KProperty r0 = (kotlin.reflect.KProperty) r0
            java.lang.reflect.Field r2 = getJavaField(r0)
            if (r2 == 0) goto L_0x0017
            r2.setAccessible(r4)
        L_0x0017:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlin.reflect.KProperty$Getter r0 = r0.getGetter()
            java.lang.reflect.Method r0 = getJavaMethod(r0)
            if (r0 == 0) goto L_0x0027
            r0.setAccessible(r4)
        L_0x0027:
            kotlin.reflect.KMutableProperty r3 = (kotlin.reflect.KMutableProperty) r3
            java.lang.String r0 = "$this$javaSetter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.reflect.KMutableProperty$Setter r3 = r3.getSetter()
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            if (r3 == 0) goto L_0x00f3
            r3.setAccessible(r4)
            goto L_0x00f3
        L_0x003d:
            boolean r0 = r3 instanceof kotlin.reflect.KProperty
            if (r0 == 0) goto L_0x005e
            kotlin.reflect.KProperty r3 = (kotlin.reflect.KProperty) r3
            java.lang.reflect.Field r0 = getJavaField(r3)
            if (r0 == 0) goto L_0x004c
            r0.setAccessible(r4)
        L_0x004c:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            kotlin.reflect.KProperty$Getter r3 = r3.getGetter()
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            if (r3 == 0) goto L_0x00f3
            r3.setAccessible(r4)
            goto L_0x00f3
        L_0x005e:
            boolean r0 = r3 instanceof kotlin.reflect.KProperty.Getter
            if (r0 == 0) goto L_0x007f
            r0 = r3
            kotlin.reflect.KProperty$Getter r0 = (kotlin.reflect.KProperty.Getter) r0
            kotlin.reflect.KProperty r0 = r0.getProperty()
            java.lang.reflect.Field r0 = getJavaField(r0)
            if (r0 == 0) goto L_0x0072
            r0.setAccessible(r4)
        L_0x0072:
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            if (r3 == 0) goto L_0x00f3
            r3.setAccessible(r4)
            goto L_0x00f3
        L_0x007f:
            boolean r0 = r3 instanceof kotlin.reflect.KMutableProperty.Setter
            if (r0 == 0) goto L_0x009f
            r0 = r3
            kotlin.reflect.KMutableProperty$Setter r0 = (kotlin.reflect.KMutableProperty.Setter) r0
            kotlin.reflect.KProperty r0 = r0.getProperty()
            java.lang.reflect.Field r0 = getJavaField(r0)
            if (r0 == 0) goto L_0x0093
            r0.setAccessible(r4)
        L_0x0093:
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            if (r3 == 0) goto L_0x00f3
            r3.setAccessible(r4)
            goto L_0x00f3
        L_0x009f:
            boolean r0 = r3 instanceof kotlin.reflect.KFunction
            if (r0 == 0) goto L_0x00f4
            r0 = r3
            kotlin.reflect.KFunction r0 = (kotlin.reflect.KFunction) r0
            java.lang.reflect.Method r1 = getJavaMethod(r0)
            if (r1 == 0) goto L_0x00af
            r1.setAccessible(r4)
        L_0x00af:
            kotlin.reflect.jvm.internal.KCallableImpl r3 = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(r3)
            r1 = 0
            if (r3 == 0) goto L_0x00c1
            kotlin.reflect.jvm.internal.calls.Caller r3 = r3.getDefaultCaller()
            if (r3 == 0) goto L_0x00c1
            java.lang.reflect.Member r3 = r3.getMember()
            goto L_0x00c2
        L_0x00c1:
            r3 = r1
        L_0x00c2:
            boolean r2 = r3 instanceof java.lang.reflect.AccessibleObject
            if (r2 != 0) goto L_0x00c7
            r3 = r1
        L_0x00c7:
            java.lang.reflect.AccessibleObject r3 = (java.lang.reflect.AccessibleObject) r3
            if (r3 == 0) goto L_0x00cf
            r2 = 1
            r3.setAccessible(r2)
        L_0x00cf:
            java.lang.String r3 = "$this$javaConstructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(r0)
            if (r3 == 0) goto L_0x00e5
            kotlin.reflect.jvm.internal.calls.Caller r3 = r3.getCaller()
            if (r3 == 0) goto L_0x00e5
            java.lang.reflect.Member r3 = r3.getMember()
            goto L_0x00e6
        L_0x00e5:
            r3 = r1
        L_0x00e6:
            boolean r0 = r3 instanceof java.lang.reflect.Constructor
            if (r0 != 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r1 = r3
        L_0x00ec:
            java.lang.reflect.Constructor r1 = (java.lang.reflect.Constructor) r1
            if (r1 == 0) goto L_0x00f3
            r1.setAccessible(r4)
        L_0x00f3:
            return
        L_0x00f4:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown callable: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = " ("
            r0.append(r1)
            java.lang.Class r3 = r3.getClass()
            r0.append(r3)
            r3 = 41
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.setAccessible(kotlin.reflect.KCallable, boolean):void");
    }

    public static final <T> Set<T> setOf(T t) {
        Set<T> singleton = Collections.singleton(t);
        Intrinsics.checkNotNullExpressionValue(singleton, "singleton(element)");
        return singleton;
    }

    public static final boolean shouldEnhance(TypeComponentPosition typeComponentPosition) {
        Intrinsics.checkNotNullParameter(typeComponentPosition, "<this>");
        return typeComponentPosition != TypeComponentPosition.INFLEXIBLE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r1.isEmpty() == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean showQuoteTweet(com.twitter.sdk.android.core.models.Tweet r1) {
        /*
            com.twitter.sdk.android.core.models.Tweet r0 = r1.quotedStatus
            if (r0 == 0) goto L_0x0018
            com.twitter.sdk.android.core.models.Card r0 = r1.card
            if (r0 != 0) goto L_0x0018
            com.twitter.sdk.android.core.models.TweetEntities r1 = r1.entities
            if (r1 == 0) goto L_0x0016
            java.util.List<com.twitter.sdk.android.core.models.MediaEntity> r1 = r1.media
            if (r1 == 0) goto L_0x0016
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0018
        L_0x0016:
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.showQuoteTweet(com.twitter.sdk.android.core.models.Tweet):boolean");
    }

    public static final String signature(SignatureBuildingComponents signatureBuildingComponents, ClassDescriptor classDescriptor, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(signatureBuildingComponents, "<this>");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(str, "jvmDescriptor");
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe unsafe = DescriptorUtilsKt.getFqNameSafe(classDescriptor).toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "fqNameSafe.toUnsafe()");
        ClassId mapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (mapKotlinToJava == null) {
            str2 = computeInternalName(classDescriptor, TypeMappingConfigurationImpl.INSTANCE);
        } else {
            str2 = JvmClassName.byClassId(mapKotlinToJava).getInternalName();
            Intrinsics.checkNotNullExpressionValue(str2, "byClassId(it).internalName");
        }
        return signatureBuildingComponents.signature(str2, str);
    }

    public static final <T> T single(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return tArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static int size(TypeSystemContext typeSystemContext, TypeArgumentListMarker typeArgumentListMarker) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeArgumentListMarker, "receiver");
        if (typeArgumentListMarker instanceof SimpleTypeMarker) {
            return typeSystemContext.argumentsCount((KotlinTypeMarker) typeArgumentListMarker);
        }
        if (typeArgumentListMarker instanceof ArgumentList) {
            return ((ArgumentList) typeArgumentListMarker).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
    }

    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    public static final <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!(tArr.length == 0)) {
            tArr = Arrays.copyOf(tArr, tArr.length);
            Intrinsics.checkNotNullExpressionValue(tArr, "copyOf(this, size)");
            Intrinsics.checkNotNullParameter(tArr, "<this>");
            Intrinsics.checkNotNullParameter(comparator, "comparator");
            if (tArr.length > 1) {
                Arrays.sort(tArr, comparator);
            }
        }
        return ArraysKt___ArraysJvmKt.asList(tArr);
    }

    public static final String stackTraceToString(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }

    public static final KotlinType starProjectionType(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "<this>");
        List<TypeParameterDescriptor> parameters = ((ClassifierDescriptorWithTypeParameters) typeParameterDescriptor.getContainingDeclaration()).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "classDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault(parameters, 10));
        for (TypeParameterDescriptor typeConstructor : parameters) {
            arrayList.add(typeConstructor.getTypeConstructor());
        }
        TypeSubstitutor create = TypeSubstitutor.create((TypeSubstitution) new StarProjectionImplKt$starProjectionType$1(arrayList));
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "this.upperBounds");
        KotlinType substitute = create.substitute((KotlinType) ArraysKt___ArraysJvmKt.first(upperBounds), Variance.OUT_VARIANCE);
        if (substitute != null) {
            return substitute;
        }
        SimpleType defaultBound = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getDefaultBound();
        Intrinsics.checkNotNullExpressionValue(defaultBound, "builtIns.defaultBound");
        return defaultBound;
    }

    public static String stringOrEmpty(String str) {
        return str != null ? str : "";
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> list, TypeSubstitution typeSubstitution, DeclarationDescriptor declarationDescriptor, List<TypeParameterDescriptor> list2) {
        if (list == null) {
            $$$reportNull$$$04(0);
            throw null;
        } else if (typeSubstitution == null) {
            $$$reportNull$$$04(1);
            throw null;
        } else if (declarationDescriptor == null) {
            $$$reportNull$$$04(2);
            throw null;
        } else if (list2 != null) {
            TypeSubstitutor substituteTypeParameters = substituteTypeParameters(list, typeSubstitution, declarationDescriptor, list2, null);
            if (substituteTypeParameters != null) {
                return substituteTypeParameters;
            }
            throw new AssertionError("Substitution failed");
        } else {
            $$$reportNull$$$04(3);
            throw null;
        }
    }

    public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "receiver");
        if (typeConstructorMarker instanceof TypeConstructor) {
            Collection<KotlinType> supertypes = ((TypeConstructor) typeConstructorMarker).getSupertypes();
            Intrinsics.checkNotNullExpressionValue(supertypes, "this.supertypes");
            return supertypes;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline68(typeConstructorMarker, GeneratedOutlineSupport.outline84("ClassicTypeSystemContext couldn't handle: ", typeConstructorMarker, ", ")).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0046, code lost:
        if (r0.charAt(r3.length()) == '.') goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.name.FqName tail(kotlin.reflect.jvm.internal.impl.name.FqName r5, kotlin.reflect.jvm.internal.impl.name.FqName r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r1 = "prefix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001b
            goto L_0x0048
        L_0x001b:
            boolean r0 = r6.isRoot()
            if (r0 == 0) goto L_0x0022
            goto L_0x0048
        L_0x0022:
            java.lang.String r0 = r5.asString()
            java.lang.String r3 = "this.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.String r3 = r6.asString()
            java.lang.String r4 = "packageName.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r4 = 2
            boolean r4 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r3, r2, r4)
            if (r4 == 0) goto L_0x0049
            int r3 = r3.length()
            char r0 = r0.charAt(r3)
            r3 = 46
            if (r0 != r3) goto L_0x0049
        L_0x0048:
            r2 = 1
        L_0x0049:
            if (r2 == 0) goto L_0x0081
            boolean r0 = r6.isRoot()
            if (r0 == 0) goto L_0x0052
            goto L_0x0081
        L_0x0052:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r0 == 0) goto L_0x0060
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = kotlin.reflect.jvm.internal.impl.name.FqName.ROOT
            java.lang.String r6 = "ROOT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            goto L_0x0081
        L_0x0060:
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = new kotlin.reflect.jvm.internal.impl.name.FqName
            java.lang.String r5 = r5.asString()
            java.lang.String r2 = "asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            java.lang.String r6 = r6.asString()
            int r6 = r6.length()
            int r6 = r6 + r1
            java.lang.String r5 = r5.substring(r6)
            java.lang.String r6 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r0.<init>(r5)
            r5 = r0
        L_0x0081:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetUtils.tail(kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.FqName):kotlin.reflect.jvm.internal.impl.name.FqName");
    }

    public static void throwIfFatal(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Failure) {
            throw ((Failure) obj).exception;
        }
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C c2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(c2, Values.DESTINATION);
        for (T add : tArr) {
            c2.add(add);
        }
        return c2;
    }

    public static final DescriptorVisibility toDescriptorVisibility(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "<this>");
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.visibilitiesMapping.get(visibility);
        if (descriptorVisibility == null) {
            descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(visibility);
        }
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(this)");
        return descriptorVisibility;
    }

    public static final Class<?> toInlineClass(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "$this$toInlineClass");
        return toInlineClass((DeclarationDescriptor) kotlinType.getConstructor().getDeclarationDescriptor());
    }

    public static final <T> List<T> toList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        if (length != 1) {
            return toMutableList(tArr);
        }
        return listOf(tArr[0]);
    }

    public static final <T> List<T> toMutableList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList(new ArrayAsCollection(tArr, false));
    }

    public static final <T> Set<T> toSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return EmptySet.INSTANCE;
        }
        if (length == 1) {
            return setOf(tArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(mapCapacity(tArr.length));
        toCollection(tArr, linkedHashSet);
        return linkedHashSet;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static RectF trapToRect(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i = 1; i < fArr.length; i += 2) {
            float round = ((float) Math.round(fArr[i - 1] * 10.0f)) / 10.0f;
            float round2 = ((float) Math.round(fArr[i] * 10.0f)) / 10.0f;
            float f2 = rectF.left;
            if (round < f2) {
                f2 = round;
            }
            rectF.left = f2;
            float f3 = rectF.top;
            if (round2 < f3) {
                f3 = round2;
            }
            rectF.top = f3;
            float f4 = rectF.right;
            if (round <= f4) {
                round = f4;
            }
            rectF.right = round;
            float f5 = rectF.bottom;
            if (round2 <= f5) {
                round2 = f5;
            }
            rectF.bottom = round2;
        }
        rectF.sort();
        return rectF;
    }

    public static final Class<?> tryLoadClass(ClassLoader classLoader, String str) {
        Intrinsics.checkNotNullParameter(classLoader, "<this>");
        Intrinsics.checkNotNullParameter(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final ProtoBuf$Type type(ProtoBuf$ValueParameter protoBuf$ValueParameter, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter(protoBuf$ValueParameter, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (protoBuf$ValueParameter.hasType()) {
            ProtoBuf$Type protoBuf$Type = protoBuf$ValueParameter.type_;
            Intrinsics.checkNotNullExpressionValue(protoBuf$Type, "type");
            return protoBuf$Type;
        }
        if ((protoBuf$ValueParameter.bitField0_ & 8) == 8) {
            return typeTable.get(protoBuf$ValueParameter.typeId_);
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        if (simpleTypeMarker instanceof SimpleType) {
            return ((SimpleType) simpleTypeMarker).getConstructor();
        }
        StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
        outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
        throw new IllegalArgumentException(outline83.toString().toString());
    }

    public static final int uintCompare(int i, int i2) {
        return Intrinsics.compare(i ^ LinearLayoutManager.INVALID_OFFSET, i2 ^ LinearLayoutManager.INVALID_OFFSET);
    }

    public static final int ulongCompare(long j, long j2) {
        return Intrinsics.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    public static SimpleTypeMarker upperBound(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(flexibleTypeMarker, "receiver");
        if (flexibleTypeMarker instanceof FlexibleType) {
            return ((FlexibleType) flexibleTypeMarker).upperBound;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + ", " + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
    }

    public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
        if (asFlexibleType != null) {
            return typeSystemContext.upperBound(asFlexibleType);
        }
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        Intrinsics.checkNotNull(asSimpleType);
        return asSimpleType;
    }

    public static final SimpleType upperIfFlexible(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrap).upperBound;
        }
        if (unwrap instanceof SimpleType) {
            return (SimpleType) unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> Iterable<IndexedValue<T>> withIndex(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$1(tArr));
    }

    public static SimpleTypeMarker withNullability(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, boolean z) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        if (simpleTypeMarker instanceof SimpleType) {
            return ((SimpleType) simpleTypeMarker).makeNullableAsSpecified(z);
        }
        StringBuilder outline83 = GeneratedOutlineSupport.outline83("ClassicTypeSystemContext couldn't handle: ", simpleTypeMarker, ", ");
        outline83.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
        throw new IllegalArgumentException(outline83.toString().toString());
    }

    public static final UnwrappedType wrapEnhancement(UnwrappedType unwrappedType, KotlinType kotlinType) {
        UnwrappedType unwrappedType2;
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        if (kotlinType == null) {
            return unwrappedType;
        }
        if (unwrappedType instanceof SimpleType) {
            unwrappedType2 = new SimpleTypeWithEnhancement((SimpleType) unwrappedType, kotlinType);
        } else if (unwrappedType instanceof FlexibleType) {
            unwrappedType2 = new FlexibleTypeWithEnhancement((FlexibleType) unwrappedType, kotlinType);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return unwrappedType2;
    }

    public static TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution typeSubstitution, boolean z, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        Intrinsics.checkNotNullParameter(typeSubstitution, "<this>");
        if (!(typeSubstitution instanceof IndexedParametersSubstitution)) {
            return new CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2(z, typeSubstitution);
        }
        IndexedParametersSubstitution indexedParametersSubstitution = (IndexedParametersSubstitution) typeSubstitution;
        TypeParameterDescriptor[] typeParameterDescriptorArr = indexedParametersSubstitution.parameters;
        TypeProjection[] typeProjectionArr = indexedParametersSubstitution.arguments;
        Intrinsics.checkNotNullParameter(typeProjectionArr, "<this>");
        Intrinsics.checkNotNullParameter(typeParameterDescriptorArr, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER);
        int min = Math.min(typeProjectionArr.length, typeParameterDescriptorArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(new Pair(typeProjectionArr[i2], typeParameterDescriptorArr[i2]));
        }
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList2.add(createCapturedIfNeeded((TypeProjection) pair.first, (TypeParameterDescriptor) pair.second));
        }
        Object[] array = arrayList2.toArray(new TypeProjection[0]);
        if (array != null) {
            return new IndexedParametersSubstitution(typeParameterDescriptorArr, (TypeProjection[]) array, z);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof KotlinType) {
            UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
            if (unwrap instanceof FlexibleType) {
                return (FlexibleType) unwrap;
            }
            return null;
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static <T> T checkNotNull1(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static final ReflectJavaAnnotation findAnnotation(Annotation[] annotationArr, FqName fqName) {
        Annotation annotation;
        Intrinsics.checkNotNullParameter(annotationArr, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (Intrinsics.areEqual(ReflectClassUtilKt.getClassId(getJavaClass(getAnnotationClass(annotation))).asSingleFqName(), fqName)) {
                break;
            }
            i++;
        }
        if (annotation == null) {
            return null;
        }
        return new ReflectJavaAnnotation(annotation);
    }

    public static final <M extends ExtendableMessage<M>, T> T getExtensionOrNull(ExtendableMessage<M> extendableMessage, GeneratedExtension<M, List<T>> generatedExtension, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(extendableMessage, "<this>");
        Intrinsics.checkNotNullParameter(generatedExtension, "extension");
        extendableMessage.verifyExtensionContainingType(generatedExtension);
        FieldSet<ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        ExtensionDescriptor extensionDescriptor = generatedExtension.descriptor;
        if (fieldSet == null) {
            throw null;
        } else if (extensionDescriptor.isRepeated) {
            Object field = fieldSet.getField(extensionDescriptor);
            if (field == null) {
                i2 = 0;
            } else {
                i2 = ((List) field).size();
            }
            if (i >= i2) {
                return null;
            }
            extendableMessage.verifyExtensionContainingType(generatedExtension);
            FieldSet<ExtensionDescriptor> fieldSet2 = extendableMessage.extensions;
            ExtensionDescriptor extensionDescriptor2 = generatedExtension.descriptor;
            if (fieldSet2 == null) {
                throw null;
            } else if (extensionDescriptor2.isRepeated) {
                Object field2 = fieldSet2.getField(extensionDescriptor2);
                if (field2 != null) {
                    return generatedExtension.singularFromFieldSetType(((List) field2).get(i));
                }
                throw new IndexOutOfBoundsException();
            } else {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
        } else {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }

    public static final KClass<?> getJvmErasure(KClassifier kClassifier) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(kClassifier, "$this$jvmErasure");
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (kClassifier instanceof KTypeParameter) {
            List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                t = null;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                KType kType = (KType) next;
                if (kType != null) {
                    T declarationDescriptor = ((KTypeImpl) kType).type.getConstructor().getDeclarationDescriptor();
                    if (declarationDescriptor instanceof ClassDescriptor) {
                        t = declarationDescriptor;
                    }
                    ClassDescriptor classDescriptor = (ClassDescriptor) t;
                    if (classDescriptor == null || classDescriptor.getKind() == ClassKind.INTERFACE || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t = next;
                        break;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                }
            }
            KType kType2 = (KType) t;
            if (kType2 == null) {
                kType2 = (KType) ArraysKt___ArraysJvmKt.firstOrNull(upperBounds);
            }
            return kType2 != null ? getJvmErasure(kType2) : Reflection.getOrCreateKotlinClass(Object.class);
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kClassifier);
    }

    public static final <T> int getLastIndex(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length - 1;
    }

    public static boolean hasAnnotation(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, FqName fqName) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (kotlinTypeMarker instanceof KotlinType) {
            return ((KotlinType) kotlinTypeMarker).getAnnotations().hasAnnotation(fqName);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + ", " + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
    }

    public static final boolean hasReceiver(ProtoBuf$Property protoBuf$Property) {
        Intrinsics.checkNotNullParameter(protoBuf$Property, "<this>");
        return protoBuf$Property.hasReceiverType() || protoBuf$Property.hasReceiverTypeId();
    }

    public static final <T> Lazy<T> lazy(LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        int ordinal = lazyThreadSafetyMode.ordinal();
        if (ordinal == 0) {
            return new SynchronizedLazyImpl(function0, null, 2);
        }
        if (ordinal == 1) {
            return new SafePublicationLazyImpl(function0);
        }
        if (ordinal == 2) {
            return new UnsafeLazyImpl(function0);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> List<T> listOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length > 0) {
            return ArraysKt___ArraysJvmKt.asList(tArr);
        }
        return EmptyList.INSTANCE;
    }

    public static final <T> Set<T> setOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length > 0) {
            return toSet(tArr);
        }
        return EmptySet.INSTANCE;
    }

    public static final Class<?> toInlineClass(DeclarationDescriptor declarationDescriptor) {
        if (!(declarationDescriptor instanceof ClassDescriptor) || !InlineClassesUtilsKt.isInlineClass(declarationDescriptor)) {
            return null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
        if (javaClass != null) {
            return javaClass;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Class object for the class ");
        outline73.append(classDescriptor.getName());
        outline73.append(" cannot be found (classId=");
        outline73.append(DescriptorUtilsKt.getClassId((ClassifierDescriptor) declarationDescriptor));
        outline73.append(')');
        throw new KotlinReflectionInternalError(outline73.toString());
    }

    public static void a(Context context, boolean z) {
        context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putBoolean("com.amazon.lwa.isTokenObtainedFromSSO", z).commit();
    }

    public static Message b(String str, String str2, Map<String, String> map) {
        Timber.TREE_OF_SOULS.d("HttpsClient:post url: %s", str);
        Timber.TREE_OF_SOULS.d("HttpsClient:post payload: %s", str2);
        Bundle bundle = new Bundle();
        try {
            HttpsURLConnection a2 = a(str, RNCWebViewManager.HTTP_METHOD_POST, map);
            a2.setRequestProperty("Content-Length", Integer.toString(str2.getBytes().length));
            DataOutputStream dataOutputStream = new DataOutputStream(a2.getOutputStream());
            dataOutputStream.write(str2.getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            bundle.putInt(APayConstants.RESPONSE_CODE, a2.getResponseCode());
            Timber.TREE_OF_SOULS.d("HttpsClient:post response: %s", Integer.valueOf(a2.getResponseCode()));
        } catch (IOException e2) {
            Timber.TREE_OF_SOULS.w(e2, "IOException occurred while calling HttpsClient:post method", new Object[0]);
            bundle.putInt(APayConstants.RESPONSE_CODE, 500);
        }
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    public static <T> ReflectProperties$LazySoftVal<T> lazySoft(Function0<T> function0) {
        return lazySoft(null, function0);
    }

    public static final <T> List<T> listOfNotNull(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return filterNotNull(tArr);
    }

    public static AnnotationDescriptor findAnnotation(Annotations annotations, FqName fqName) {
        Object obj;
        Intrinsics.checkNotNullParameter(annotations, "this");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterator it = annotations.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((AnnotationDescriptor) obj).getFqName(), fqName)) {
                break;
            }
        }
        return (AnnotationDescriptor) obj;
    }

    public static final List<ReflectJavaAnnotation> getAnnotations(Annotation[] annotationArr) {
        Intrinsics.checkNotNullParameter(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation reflectJavaAnnotation : annotationArr) {
            arrayList.add(new ReflectJavaAnnotation(reflectJavaAnnotation));
        }
        return arrayList;
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> list, TypeSubstitution typeSubstitution, DeclarationDescriptor declarationDescriptor, List<TypeParameterDescriptor> list2, boolean[] zArr) {
        TypeSubstitution typeSubstitution2 = typeSubstitution;
        List<TypeParameterDescriptor> list3 = list2;
        if (list == null) {
            $$$reportNull$$$04(5);
            throw null;
        } else if (typeSubstitution2 == null) {
            $$$reportNull$$$04(6);
            throw null;
        } else if (declarationDescriptor == null) {
            $$$reportNull$$$04(7);
            throw null;
        } else if (list3 != null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            int i = 0;
            for (TypeParameterDescriptor next : list) {
                TypeParameterDescriptorImpl createForFurtherModification = TypeParameterDescriptorImpl.createForFurtherModification(declarationDescriptor, next.getAnnotations(), next.isReified(), next.getVariance(), next.getName(), i, SourceElement.NO_SOURCE, next.getStorageManager());
                hashMap.put(next.getTypeConstructor(), new TypeProjectionImpl(createForFurtherModification.getDefaultType()));
                hashMap2.put(next, createForFurtherModification);
                list3.add(createForFurtherModification);
                i++;
            }
            Intrinsics.checkNotNullParameter(hashMap, "map");
            Intrinsics.checkNotNullParameter(hashMap, "map");
            TypeSubstitutor createChainedSubstitutor = TypeSubstitutor.createChainedSubstitutor(typeSubstitution2, new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(hashMap, false));
            for (TypeParameterDescriptor next2 : list) {
                TypeParameterDescriptorImpl typeParameterDescriptorImpl = (TypeParameterDescriptorImpl) hashMap2.get(next2);
                for (KotlinType next3 : next2.getUpperBounds()) {
                    KotlinType substitute = createChainedSubstitutor.substitute(next3, Variance.IN_VARIANCE);
                    if (substitute == null) {
                        return null;
                    }
                    if (!(substitute == next3 || zArr == null)) {
                        zArr[0] = true;
                    }
                    typeParameterDescriptorImpl.addUpperBound(substitute);
                }
                typeParameterDescriptorImpl.checkUninitialized();
                typeParameterDescriptorImpl.initialized = true;
            }
            return createChainedSubstitutor;
        } else {
            $$$reportNull$$$04(8);
            throw null;
        }
    }

    public static void a(String str, String str2) throws IllegalArgumentException {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(String.format("%s cannot be null or empty", new Object[]{str2}));
        }
    }

    public static final SimpleType asSimpleType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        SimpleType simpleType = unwrap instanceof SimpleType ? (SimpleType) unwrap : null;
        if (simpleType != null) {
            return simpleType;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("This is should be simple type: ", kotlinType).toString());
    }

    public static final <E> List<E> build(List<E> list) {
        Intrinsics.checkNotNullParameter(list, "builder");
        ListBuilder listBuilder = (ListBuilder) list;
        if (listBuilder.backing == null) {
            listBuilder.checkIsMutable();
            listBuilder.isReadOnly = true;
            return listBuilder;
        }
        throw new IllegalStateException();
    }

    public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeParameterMarker, "receiver");
        if (typeParameterMarker instanceof TypeParameterDescriptor) {
            Variance variance = ((TypeParameterDescriptor) typeParameterMarker).getVariance();
            Intrinsics.checkNotNullExpressionValue(variance, "this.variance");
            return convertVariance(variance);
        }
        throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + ", " + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
    }

    public static final int indexOf(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final boolean isError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        return (unwrap instanceof ErrorType) || ((unwrap instanceof FlexibleType) && (((FlexibleType) unwrap).getDelegate() instanceof ErrorType));
    }

    public static boolean isMarkedNullable(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        return (kotlinTypeMarker instanceof SimpleTypeMarker) && typeSystemContext.isMarkedNullable((SimpleTypeMarker) kotlinTypeMarker);
    }

    public static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }

    public static final char single(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static TypeConstructorMarker typeConstructor(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        if (asSimpleType == null) {
            asSimpleType = typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker);
        }
        return typeSystemContext.typeConstructor(asSimpleType);
    }

    public static KotlinTypeMarker withNullability(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, boolean z) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        if (kotlinTypeMarker instanceof SimpleTypeMarker) {
            return classicTypeSystemContext.withNullability((SimpleTypeMarker) kotlinTypeMarker, z);
        }
        if (kotlinTypeMarker instanceof FlexibleTypeMarker) {
            FlexibleTypeMarker flexibleTypeMarker = (FlexibleTypeMarker) kotlinTypeMarker;
            return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability(classicTypeSystemContext.lowerBound(flexibleTypeMarker), z), classicTypeSystemContext.withNullability(classicTypeSystemContext.upperBound(flexibleTypeMarker), z));
        }
        throw new IllegalStateException("sealed".toString());
    }

    /* renamed from: lazy  reason: collision with other method in class */
    public static <T> ReflectProperties$LazyVal<T> m310lazy(Function0<T> function0) {
        return new ReflectProperties$LazyVal<>(function0);
    }

    public static final void record(LookupTracker lookupTracker, LookupLocation lookupLocation, PackageFragmentDescriptor packageFragmentDescriptor, Name name) {
        Position position;
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(lookupLocation, "from");
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = packageFragmentDescriptor.getFqName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "scopeOwner.fqName.asString()");
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "name.asString()");
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(lookupLocation, "from");
        Intrinsics.checkNotNullParameter(asString, "packageFqName");
        Intrinsics.checkNotNullParameter(asString2, "name");
        if (lookupTracker != DO_NOTHING.INSTANCE) {
            LocationInfo location = lookupLocation.getLocation();
            if (location != null) {
                if (lookupTracker.getRequiresPosition()) {
                    position = location.getPosition();
                } else {
                    position = Position.NO_POSITION;
                }
                LookupTracker lookupTracker2 = lookupTracker;
                lookupTracker2.record(location.getFilePath(), position, asString, ScopeKind.PACKAGE, asString2);
            }
        }
    }

    public static String a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        Iterator it = new TreeMap(map).entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            Object value = entry.getValue();
            sb.append((String) entry.getKey());
            sb.append(InflateView.SETTER_EQUALS);
            String valueOf = String.valueOf(value);
            try {
                sb.append(URLEncoder.encode(valueOf, "UTF-8").replace(MqttTopic.SINGLE_LEVEL_WILDCARD, "%20").replace("*", "%2A").replace("%7E", Constants.WAVE_SEPARATOR));
                if (it.hasNext()) {
                    sb.append("&");
                }
            } catch (UnsupportedEncodingException unused) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Unable to URL encode:", valueOf));
            }
        }
        return sb.toString();
    }

    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r, continuation);
        }
        CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(continuation, function2, r);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(continuation, context, function2, r);
    }

    public static TypeArgumentMarker get(TypeSystemContext typeSystemContext, TypeArgumentListMarker typeArgumentListMarker, int i) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "this");
        Intrinsics.checkNotNullParameter(typeArgumentListMarker, "receiver");
        if (typeArgumentListMarker instanceof SimpleTypeMarker) {
            return typeSystemContext.getArgument((KotlinTypeMarker) typeArgumentListMarker, i);
        }
        if (typeArgumentListMarker instanceof ArgumentList) {
            Object obj = ((ArgumentList) typeArgumentListMarker).get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(index)");
            return (TypeArgumentMarker) obj;
        }
        throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
    }

    public static final ProtoBuf$Type returnType(ProtoBuf$Property protoBuf$Property, TypeTable typeTable) {
        Intrinsics.checkNotNullParameter(protoBuf$Property, "<this>");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        if (protoBuf$Property.hasReturnType()) {
            ProtoBuf$Type protoBuf$Type = protoBuf$Property.returnType_;
            Intrinsics.checkNotNullExpressionValue(protoBuf$Type, "returnType");
            return protoBuf$Type;
        }
        if ((protoBuf$Property.bitField0_ & 16) == 16) {
            return typeTable.get(protoBuf$Property.returnTypeId_);
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final <K, V> Map<K, V> build(Map<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "builder");
        MapBuilder mapBuilder = (MapBuilder) map;
        mapBuilder.checkIsMutable$kotlin_stdlib();
        mapBuilder.isReadOnly = true;
        return mapBuilder;
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType simpleType, List<TypeProjection> list, Annotations annotations, int i) {
        if ((i & 1) != 0) {
            list = simpleType.getArguments();
        }
        if ((i & 2) != 0) {
            annotations = simpleType.getAnnotations();
        }
        return replace(simpleType, list, annotations);
    }

    public static <T> T a(T t, String str) throws IllegalArgumentException {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(String.format("%s cannot be null", new Object[]{str}));
    }

    public static void a(String str) {
        try {
            a(str, (String) "payUrl");
            URI uri = new URI(str);
            if ("amazonpay.amazon.in".equalsIgnoreCase(uri.getHost())) {
                if (NetworkRequestHandler.SCHEME_HTTPS.equalsIgnoreCase(uri.getScheme())) {
                    return;
                }
            }
            throw new IllegalArgumentException();
        } catch (Exception unused) {
            throw new IllegalArgumentException(String.format("The supplied pay url (%s) is invalid", new Object[]{String.valueOf(str)}));
        }
    }

    public static HttpsURLConnection a(String str, String str2, Map<String, String> map) throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpsURLConnection.setRequestMethod(str2);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setRequestProperty("Connection", "close");
        httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpsURLConnection.setRequestProperty("charset", "UTF-8");
        for (String next : map.keySet()) {
            httpsURLConnection.setRequestProperty(next, map.get(next));
        }
        return httpsURLConnection;
    }

    public static Map<String, Object> a(JSONObject jSONObject) throws JSONException {
        TreeMap treeMap = new TreeMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = a((JSONObject) obj);
            }
            treeMap.put(next, obj);
        }
        return treeMap;
    }

    public static List<Object> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = a((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
