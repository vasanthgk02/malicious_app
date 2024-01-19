package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.CharsKt__CharKt;

/* compiled from: RawType.kt */
public final class RawTypeImpl extends FlexibleType implements RawType {
    public RawTypeImpl(SimpleType simpleType, SimpleType simpleType2, boolean z) {
        super(simpleType, simpleType2);
        if (!z) {
            boolean isSubtypeOf = KotlinTypeChecker.DEFAULT.isSubtypeOf(simpleType, simpleType2);
            if (_Assertions.ENABLED && !isSubtypeOf) {
                throw new AssertionError("Lower bound " + simpleType + " of a flexible type must be a subtype of the upper bound " + simpleType2);
            }
        }
    }

    public static final List<String> render$renderArguments(DescriptorRenderer descriptorRenderer, KotlinType kotlinType) {
        List<TypeProjection> arguments = kotlinType.getArguments();
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(arguments, 10));
        for (TypeProjection renderTypeProjection : arguments) {
            arrayList.add(descriptorRenderer.renderTypeProjection(renderTypeProjection));
        }
        return arrayList;
    }

    public static final String render$replaceArgs(String str, String str2) {
        if (!CharsKt__CharKt.contains$default((CharSequence) str, '<', false, 2)) {
            return str;
        }
        return CharsKt__CharKt.substringBefore$default(str, '<', (String) null, 2) + '<' + str2 + '>' + CharsKt__CharKt.substringAfterLast$default(str, '>', null, 2);
    }

    public SimpleType getDelegate() {
        return this.lowerBound;
    }

    public MemberScope getMemberScope() {
        ClassifierDescriptor declarationDescriptor = getConstructor().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor != null) {
            MemberScope memberScope = classDescriptor.getMemberScope(RawSubstitution.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(memberScope, "classDescriptor.getMemberScope(RawSubstitution)");
            return memberScope;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Incorrect classifier: ", getConstructor().getDeclarationDescriptor()).toString());
    }

    public UnwrappedType makeNullableAsSpecified(boolean z) {
        return new RawTypeImpl(this.lowerBound.makeNullableAsSpecified(z), this.upperBound.makeNullableAsSpecified(z));
    }

    public String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        boolean z;
        Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, "options");
        String renderType = descriptorRenderer.renderType(this.lowerBound);
        String renderType2 = descriptorRenderer.renderType(this.upperBound);
        if (descriptorRendererOptions.getDebugMode()) {
            return "raw (" + renderType + ".." + renderType2 + ')';
        } else if (this.upperBound.getArguments().isEmpty()) {
            return descriptorRenderer.renderFlexibleType(renderType, renderType2, TypeUtilsKt.getBuiltIns(this));
        } else {
            List<String> render$renderArguments = render$renderArguments(descriptorRenderer, this.lowerBound);
            List<String> render$renderArguments2 = render$renderArguments(descriptorRenderer, this.upperBound);
            String joinToString$default = ArraysKt___ArraysJvmKt.joinToString$default(render$renderArguments, ", ", null, null, 0, null, RawTypeImpl$render$newArgs$1.INSTANCE, 30);
            ArrayList arrayList = (ArrayList) ArraysKt___ArraysJvmKt.zip(render$renderArguments, render$renderArguments2);
            boolean z2 = true;
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    String str = (String) pair.second;
                    if (Intrinsics.areEqual((String) pair.first, CharsKt__CharKt.removePrefix(str, "out ")) || Intrinsics.areEqual(str, "*")) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                renderType2 = render$replaceArgs(renderType2, joinToString$default);
            }
            String render$replaceArgs = render$replaceArgs(renderType, joinToString$default);
            if (Intrinsics.areEqual(render$replaceArgs, renderType2)) {
                return render$replaceArgs;
            }
            return descriptorRenderer.renderFlexibleType(render$replaceArgs, renderType2, TypeUtilsKt.getBuiltIns(this));
        }
    }

    public UnwrappedType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new RawTypeImpl(this.lowerBound.replaceAnnotations(annotations), this.upperBound.replaceAnnotations(annotations));
    }

    public FlexibleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType simpleType = this.lowerBound;
        Intrinsics.checkNotNullParameter(simpleType, "type");
        SimpleType simpleType2 = this.upperBound;
        Intrinsics.checkNotNullParameter(simpleType2, "type");
        return new RawTypeImpl(simpleType, simpleType2, true);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RawTypeImpl(SimpleType simpleType, SimpleType simpleType2) {
        // Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        // Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
        this(simpleType, simpleType2, false);
    }
}
