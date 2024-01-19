package kotlin.text;

import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Regex.kt */
public final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements Function1<Integer, MatchGroup> {
    public final /* synthetic */ MatcherMatchResult$groups$1 this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MatcherMatchResult$groups$1$iterator$1(MatcherMatchResult$groups$1 matcherMatchResult$groups$1) {
        // this.this$0 = matcherMatchResult$groups$1;
        super(1);
    }

    public Object invoke(Object obj) {
        int intValue = ((Number) obj).intValue();
        MatcherMatchResult$groups$1 matcherMatchResult$groups$1 = this.this$0;
        Matcher matcher = matcherMatchResult$groups$1.this$0.matcher;
        IntRange until = RangesKt___RangesKt.until(matcher.start(intValue), matcher.end(intValue));
        if (until.getStart().intValue() < 0) {
            return null;
        }
        String group = matcherMatchResult$groups$1.this$0.matcher.group(intValue);
        Intrinsics.checkNotNullExpressionValue(group, "matchResult.group(index)");
        return new MatchGroup(group, until);
    }
}
