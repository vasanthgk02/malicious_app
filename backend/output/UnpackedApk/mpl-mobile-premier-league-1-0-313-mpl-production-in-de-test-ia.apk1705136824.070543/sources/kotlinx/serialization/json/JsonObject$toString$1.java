package kotlinx.serialization.json;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.StringOpsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "", "", "Lkotlinx/serialization/json/JsonElement;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonElement.kt */
public final class JsonObject$toString$1 extends Lambda implements Function1<Entry<? extends String, ? extends JsonElement>, CharSequence> {
    public static final JsonObject$toString$1 INSTANCE = new JsonObject$toString$1();

    public JsonObject$toString$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        Entry entry = (Entry) obj;
        Intrinsics.checkNotNullParameter(entry, "$dstr$k$v");
        StringBuilder sb = new StringBuilder();
        StringOpsKt.printQuoted(sb, (String) entry.getKey());
        sb.append(':');
        sb.append((JsonElement) entry.getValue());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
