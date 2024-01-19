package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SOURCE_CODE_QUALIFIED;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler.DEFAULT;

/* compiled from: DescriptorRendererOptionsImpl.kt */
public final class DescriptorRendererOptionsImpl implements DescriptorRendererOptions {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public final ReadWriteProperty actualPropertiesInPrimaryConstructor$delegate;
    public final ReadWriteProperty alwaysRenderModifiers$delegate;
    public final ReadWriteProperty annotationArgumentsRenderingPolicy$delegate;
    public final ReadWriteProperty annotationFilter$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(null, null, this);
    public final ReadWriteProperty boldOnlyForNamesInHtml$delegate;
    public final ReadWriteProperty classWithPrimaryConstructor$delegate;
    public final ReadWriteProperty classifierNamePolicy$delegate;
    public final ReadWriteProperty debugMode$delegate;
    public final ReadWriteProperty defaultParameterValueRenderer$delegate;
    public final ReadWriteProperty eachAnnotationOnNewLine$delegate;
    public final ReadWriteProperty enhancedTypes$delegate;
    public final ReadWriteProperty excludedAnnotationClasses$delegate;
    public final ReadWriteProperty excludedTypeAnnotationClasses$delegate;
    public final ReadWriteProperty includeAdditionalModifiers$delegate;
    public final ReadWriteProperty includePropertyConstant$delegate;
    public final ReadWriteProperty informativeErrorType$delegate;
    public boolean isLocked;
    public final ReadWriteProperty modifiers$delegate;
    public final ReadWriteProperty normalizedVisibilities$delegate;
    public final ReadWriteProperty overrideRenderingPolicy$delegate;
    public final ReadWriteProperty parameterNameRenderingPolicy$delegate;
    public final ReadWriteProperty parameterNamesInFunctionalTypes$delegate;
    public final ReadWriteProperty presentableUnresolvedTypes$delegate;
    public final ReadWriteProperty propertyAccessorRenderingPolicy$delegate;
    public final ReadWriteProperty receiverAfterName$delegate;
    public final ReadWriteProperty renderCompanionObjectName$delegate;
    public final ReadWriteProperty renderConstructorDelegation$delegate;
    public final ReadWriteProperty renderConstructorKeyword$delegate;
    public final ReadWriteProperty renderDefaultAnnotationArguments$delegate;
    public final ReadWriteProperty renderDefaultModality$delegate;
    public final ReadWriteProperty renderDefaultVisibility$delegate;
    public final ReadWriteProperty renderPrimaryConstructorParametersAsProperties$delegate;
    public final ReadWriteProperty renderTypeExpansions$delegate;
    public final ReadWriteProperty renderUnabbreviatedType$delegate;
    public final ReadWriteProperty secondaryConstructorsAsPrimary$delegate;
    public final ReadWriteProperty startFromDeclarationKeyword$delegate;
    public final ReadWriteProperty startFromName$delegate;
    public final ReadWriteProperty textFormat$delegate;
    public final ReadWriteProperty typeNormalizer$delegate;
    public final ReadWriteProperty uninferredTypeParameterAsName$delegate;
    public final ReadWriteProperty unitReturnType$delegate;
    public final ReadWriteProperty valueParametersHandler$delegate;
    public final ReadWriteProperty verbose$delegate;
    public final ReadWriteProperty withDefinedIn$delegate;
    public final ReadWriteProperty withSourceFileForTopLevel$delegate;
    public final ReadWriteProperty withoutReturnType$delegate;
    public final ReadWriteProperty withoutSuperTypes$delegate;
    public final ReadWriteProperty withoutTypeParameters$delegate;

    static {
        Class<DescriptorRendererOptionsImpl> cls = DescriptorRendererOptionsImpl.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "withDefinedIn", "getWithDefinedIn()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "modifiers", "getModifiers()Ljava/util/Set;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "startFromName", "getStartFromName()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "debugMode", "getDebugMode()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "verbose", "getVerbose()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "unitReturnType", "getUnitReturnType()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "withoutReturnType", "getWithoutReturnType()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "enhancedTypes", "getEnhancedTypes()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "normalizedVisibilities", "getNormalizedVisibilities()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderDefaultModality", "getRenderDefaultModality()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "includePropertyConstant", "getIncludePropertyConstant()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "withoutTypeParameters", "getWithoutTypeParameters()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "withoutSuperTypes", "getWithoutSuperTypes()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "receiverAfterName", "getReceiverAfterName()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderTypeExpansions", "getRenderTypeExpansions()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "renderFunctionContracts", "getRenderFunctionContracts()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "informativeErrorType", "getInformativeErrorType()Z"))};
    }

    public DescriptorRendererOptionsImpl() {
        SOURCE_CODE_QUALIFIED source_code_qualified = SOURCE_CODE_QUALIFIED.INSTANCE;
        this.classifierNamePolicy$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(source_code_qualified, source_code_qualified, this);
        Boolean bool = Boolean.TRUE;
        this.withDefinedIn$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool, bool, this);
        Boolean bool2 = Boolean.TRUE;
        this.withSourceFileForTopLevel$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool2, bool2, this);
        Set<DescriptorRendererModifier> set = DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS;
        this.modifiers$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(set, set, this);
        Boolean bool3 = Boolean.FALSE;
        this.startFromName$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool3, bool3, this);
        Boolean bool4 = Boolean.FALSE;
        this.startFromDeclarationKeyword$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool4, bool4, this);
        Boolean bool5 = Boolean.FALSE;
        this.debugMode$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool5, bool5, this);
        Boolean bool6 = Boolean.FALSE;
        this.classWithPrimaryConstructor$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool6, bool6, this);
        Boolean bool7 = Boolean.FALSE;
        this.verbose$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool7, bool7, this);
        Boolean bool8 = Boolean.TRUE;
        this.unitReturnType$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool8, bool8, this);
        Boolean bool9 = Boolean.FALSE;
        this.withoutReturnType$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool9, bool9, this);
        Boolean bool10 = Boolean.FALSE;
        this.enhancedTypes$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool10, bool10, this);
        Boolean bool11 = Boolean.FALSE;
        this.normalizedVisibilities$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool11, bool11, this);
        Boolean bool12 = Boolean.TRUE;
        this.renderDefaultVisibility$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool12, bool12, this);
        Boolean bool13 = Boolean.TRUE;
        this.renderDefaultModality$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool13, bool13, this);
        Boolean bool14 = Boolean.FALSE;
        this.renderConstructorDelegation$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool14, bool14, this);
        Boolean bool15 = Boolean.FALSE;
        this.renderPrimaryConstructorParametersAsProperties$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool15, bool15, this);
        Boolean bool16 = Boolean.FALSE;
        this.actualPropertiesInPrimaryConstructor$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool16, bool16, this);
        Boolean bool17 = Boolean.FALSE;
        this.uninferredTypeParameterAsName$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool17, bool17, this);
        Boolean bool18 = Boolean.FALSE;
        this.includePropertyConstant$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool18, bool18, this);
        Boolean bool19 = Boolean.FALSE;
        this.withoutTypeParameters$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool19, bool19, this);
        Boolean bool20 = Boolean.FALSE;
        this.withoutSuperTypes$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool20, bool20, this);
        DescriptorRendererOptionsImpl$typeNormalizer$2 descriptorRendererOptionsImpl$typeNormalizer$2 = DescriptorRendererOptionsImpl$typeNormalizer$2.INSTANCE;
        this.typeNormalizer$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(descriptorRendererOptionsImpl$typeNormalizer$2, descriptorRendererOptionsImpl$typeNormalizer$2, this);
        DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2 descriptorRendererOptionsImpl$defaultParameterValueRenderer$2 = DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2.INSTANCE;
        this.defaultParameterValueRenderer$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(descriptorRendererOptionsImpl$defaultParameterValueRenderer$2, descriptorRendererOptionsImpl$defaultParameterValueRenderer$2, this);
        Boolean bool21 = Boolean.TRUE;
        this.secondaryConstructorsAsPrimary$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool21, bool21, this);
        OverrideRenderingPolicy overrideRenderingPolicy = OverrideRenderingPolicy.RENDER_OPEN;
        this.overrideRenderingPolicy$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(overrideRenderingPolicy, overrideRenderingPolicy, this);
        DEFAULT defaultR = DEFAULT.INSTANCE;
        this.valueParametersHandler$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(defaultR, defaultR, this);
        RenderingFormat renderingFormat = RenderingFormat.PLAIN;
        this.textFormat$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(renderingFormat, renderingFormat, this);
        ParameterNameRenderingPolicy parameterNameRenderingPolicy = ParameterNameRenderingPolicy.ALL;
        this.parameterNameRenderingPolicy$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(parameterNameRenderingPolicy, parameterNameRenderingPolicy, this);
        Boolean bool22 = Boolean.FALSE;
        this.receiverAfterName$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool22, bool22, this);
        Boolean bool23 = Boolean.FALSE;
        this.renderCompanionObjectName$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool23, bool23, this);
        PropertyAccessorRenderingPolicy propertyAccessorRenderingPolicy = PropertyAccessorRenderingPolicy.DEBUG;
        this.propertyAccessorRenderingPolicy$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(propertyAccessorRenderingPolicy, propertyAccessorRenderingPolicy, this);
        Boolean bool24 = Boolean.FALSE;
        this.renderDefaultAnnotationArguments$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool24, bool24, this);
        Boolean bool25 = Boolean.FALSE;
        this.eachAnnotationOnNewLine$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool25, bool25, this);
        EmptySet emptySet = EmptySet.INSTANCE;
        this.excludedAnnotationClasses$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(emptySet, emptySet, this);
        ExcludedTypeAnnotations excludedTypeAnnotations = ExcludedTypeAnnotations.INSTANCE;
        Set<FqName> set2 = ExcludedTypeAnnotations.internalAnnotationsForResolve;
        this.excludedTypeAnnotationClasses$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(set2, set2, this);
        AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy = AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS;
        this.annotationArgumentsRenderingPolicy$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(annotationArgumentsRenderingPolicy, annotationArgumentsRenderingPolicy, this);
        Boolean bool26 = Boolean.FALSE;
        this.alwaysRenderModifiers$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool26, bool26, this);
        Boolean bool27 = Boolean.TRUE;
        this.renderConstructorKeyword$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool27, bool27, this);
        Boolean bool28 = Boolean.TRUE;
        this.renderUnabbreviatedType$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool28, bool28, this);
        Boolean bool29 = Boolean.FALSE;
        this.renderTypeExpansions$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool29, bool29, this);
        Boolean bool30 = Boolean.TRUE;
        this.includeAdditionalModifiers$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool30, bool30, this);
        Boolean bool31 = Boolean.TRUE;
        this.parameterNamesInFunctionalTypes$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool31, bool31, this);
        Boolean bool32 = Boolean.FALSE;
        this.presentableUnresolvedTypes$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool32, bool32, this);
        Boolean bool33 = Boolean.FALSE;
        this.boldOnlyForNamesInHtml$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool33, bool33, this);
        Boolean bool34 = Boolean.TRUE;
        this.informativeErrorType$delegate = new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(bool34, bool34, this);
    }

    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return (AnnotationArgumentsRenderingPolicy) this.annotationArgumentsRenderingPolicy$delegate.getValue(this, $$delegatedProperties[37]);
    }

    public boolean getDebugMode() {
        return ((Boolean) this.debugMode$delegate.getValue(this, $$delegatedProperties[6])).booleanValue();
    }

    public boolean getEnhancedTypes() {
        return ((Boolean) this.enhancedTypes$delegate.getValue(this, $$delegatedProperties[11])).booleanValue();
    }

    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return (Set) this.excludedTypeAnnotationClasses$delegate.getValue(this, $$delegatedProperties[35]);
    }

    public final void lock() {
        boolean z = !this.isLocked;
        if (!_Assertions.ENABLED || z) {
            this.isLocked = true;
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.annotationArgumentsRenderingPolicy$delegate.setValue(this, $$delegatedProperties[37], annotationArgumentsRenderingPolicy);
    }

    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.classifierNamePolicy$delegate.setValue(this, $$delegatedProperties[0], classifierNamePolicy);
    }

    public void setDebugMode(boolean z) {
        this.debugMode$delegate.setValue(this, $$delegatedProperties[6], Boolean.valueOf(z));
    }

    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.excludedTypeAnnotationClasses$delegate.setValue(this, $$delegatedProperties[35], set);
    }

    public void setModifiers(Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.modifiers$delegate.setValue(this, $$delegatedProperties[3], set);
    }

    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.parameterNameRenderingPolicy$delegate.setValue(this, $$delegatedProperties[28], parameterNameRenderingPolicy);
    }

    public void setReceiverAfterName(boolean z) {
        this.receiverAfterName$delegate.setValue(this, $$delegatedProperties[29], Boolean.valueOf(z));
    }

    public void setRenderCompanionObjectName(boolean z) {
        this.renderCompanionObjectName$delegate.setValue(this, $$delegatedProperties[30], Boolean.valueOf(z));
    }

    public void setStartFromName(boolean z) {
        this.startFromName$delegate.setValue(this, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    public void setTextFormat(RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.textFormat$delegate.setValue(this, $$delegatedProperties[27], renderingFormat);
    }

    public void setWithDefinedIn(boolean z) {
        this.withDefinedIn$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    public void setWithoutSuperTypes(boolean z) {
        this.withoutSuperTypes$delegate.setValue(this, $$delegatedProperties[21], Boolean.valueOf(z));
    }

    public void setWithoutTypeParameters(boolean z) {
        this.withoutTypeParameters$delegate.setValue(this, $$delegatedProperties[20], Boolean.valueOf(z));
    }
}
