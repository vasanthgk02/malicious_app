package kotlinx.serialization.json.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.DeepRecursiveScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {110}, m = "invokeSuspend")
/* compiled from: JsonTreeReader.kt */
public final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ JsonTreeReader this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readDeepRecursive$1> continuation) {
        // this.this$0 = jsonTreeReader;
        super(3, continuation);
    }

    public Object invoke(Object obj, Object obj2, Object obj3) {
        Unit unit = (Unit) obj2;
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.this$0, (Continuation) obj3);
        jsonTreeReader$readDeepRecursive$1.L$0 = (DeepRecursiveScope) obj;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            DeepRecursiveScope deepRecursiveScope = (DeepRecursiveScope) this.L$0;
            byte peekNextToken = this.this$0.lexer.peekNextToken();
            if (peekNextToken == 1) {
                obj2 = this.this$0.readValue(true);
            } else if (peekNextToken == 0) {
                obj2 = this.this$0.readValue(false);
            } else if (peekNextToken == 6) {
                JsonTreeReader jsonTreeReader = this.this$0;
                this.label = 1;
                obj = JsonTreeReader.access$readObject(jsonTreeReader, deepRecursiveScope, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else if (peekNextToken == 8) {
                obj2 = this.this$0.readArray();
            } else {
                AbstractJsonLexer.fail$default(this.this$0.lexer, "Can't begin reading element, unexpected token", 0, 2, null);
                throw null;
            }
            return obj2;
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = (JsonElement) obj;
        return obj2;
    }
}
