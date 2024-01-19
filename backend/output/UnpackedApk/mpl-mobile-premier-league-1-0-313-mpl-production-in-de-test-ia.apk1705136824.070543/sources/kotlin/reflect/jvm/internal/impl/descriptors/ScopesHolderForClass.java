package kotlin.reflect.jvm.internal.impl.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ScopesHolderForClass.kt */
public final class ScopesHolderForClass<T extends MemberScope> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public static final ScopesHolderForClass Companion = null;
    public final ClassDescriptor classDescriptor;
    public final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
    public final Function1<KotlinTypeRefiner, T> scopeFactory;
    public final NotNullLazyValue scopeForOwnerModule$delegate;

    public ScopesHolderForClass(ClassDescriptor classDescriptor2, StorageManager storageManager, Function1 function1, KotlinTypeRefiner kotlinTypeRefiner, DefaultConstructorMarker defaultConstructorMarker) {
        this.classDescriptor = classDescriptor2;
        this.scopeFactory = function1;
        this.kotlinTypeRefinerForOwnerModule = kotlinTypeRefiner;
        this.scopeForOwnerModule$delegate = storageManager.createLazyValue(new ScopesHolderForClass$scopeForOwnerModule$2(this));
    }

    public static final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor classDescriptor2, StorageManager storageManager, KotlinTypeRefiner kotlinTypeRefiner, Function1<? super KotlinTypeRefiner, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(classDescriptor2, "classDescriptor");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefinerForOwnerModule");
        Intrinsics.checkNotNullParameter(function1, "scopeFactory");
        ScopesHolderForClass scopesHolderForClass = new ScopesHolderForClass(classDescriptor2, storageManager, function1, kotlinTypeRefiner, null);
        return scopesHolderForClass;
    }

    public final T getScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(DescriptorUtilsKt.getModule(this.classDescriptor), "moduleDescriptor");
        return (MemberScope) TweetUtils.getValue(this.scopeForOwnerModule$delegate, $$delegatedProperties[0]);
    }
}
