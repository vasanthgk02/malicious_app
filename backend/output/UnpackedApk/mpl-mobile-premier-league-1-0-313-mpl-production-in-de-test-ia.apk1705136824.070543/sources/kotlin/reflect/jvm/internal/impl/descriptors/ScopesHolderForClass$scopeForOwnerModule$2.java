package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: ScopesHolderForClass.kt */
public final class ScopesHolderForClass$scopeForOwnerModule$2 extends Lambda implements Function0<T> {
    public final /* synthetic */ ScopesHolderForClass<T> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ScopesHolderForClass$scopeForOwnerModule$2(ScopesHolderForClass<T> scopesHolderForClass) {
        // this.this$0 = scopesHolderForClass;
        super(0);
    }

    public Object invoke() {
        ScopesHolderForClass<T> scopesHolderForClass = this.this$0;
        return (MemberScope) scopesHolderForClass.scopeFactory.invoke(scopesHolderForClass.kotlinTypeRefinerForOwnerModule);
    }
}
