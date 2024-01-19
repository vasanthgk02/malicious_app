package co.hyperverge.crashguard.services;

import co.hyperverge.crashguard.data.repo.CrashEventsRepo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lco/hyperverge/crashguard/data/repo/CrashEventsRepo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashIntentService.kt */
public final class CrashIntentService$crashEventsRepo$2 extends Lambda implements Function0<CrashEventsRepo> {
    public final /* synthetic */ CrashIntentService this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CrashIntentService$crashEventsRepo$2(CrashIntentService crashIntentService) {
        // this.this$0 = crashIntentService;
        super(0);
    }

    public Object invoke() {
        return CrashEventsRepo.Companion.getInstance(this.this$0);
    }
}
