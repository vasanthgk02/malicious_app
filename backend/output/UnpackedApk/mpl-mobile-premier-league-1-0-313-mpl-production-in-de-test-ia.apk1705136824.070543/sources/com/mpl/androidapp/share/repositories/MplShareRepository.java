package com.mpl.androidapp.share.repositories;

import com.mpl.androidapp.share.services.GenerateDeepLinkService;
import com.mpl.androidapp.share.services.GenerateDeepLinkServiceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/mpl/androidapp/share/repositories/MplShareRepository;", "", "generateDeepLinkService", "Lcom/mpl/androidapp/share/services/GenerateDeepLinkService;", "(Lcom/mpl/androidapp/share/services/GenerateDeepLinkService;)V", "deepLinkService", "", "view", "Lcom/mpl/androidapp/share/services/GenerateDeepLinkServiceImpl;", "payload", "", "(Lcom/mpl/androidapp/share/services/GenerateDeepLinkServiceImpl;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MplShareRepository.kt */
public final class MplShareRepository {
    public final GenerateDeepLinkService generateDeepLinkService;

    public MplShareRepository(GenerateDeepLinkService generateDeepLinkService2) {
        Intrinsics.checkNotNullParameter(generateDeepLinkService2, "generateDeepLinkService");
        this.generateDeepLinkService = generateDeepLinkService2;
    }

    public final Object deepLinkService(GenerateDeepLinkServiceImpl generateDeepLinkServiceImpl, String str, Continuation<? super Unit> continuation) {
        Object appFlyersApiService = this.generateDeepLinkService.appFlyersApiService(generateDeepLinkServiceImpl, str, continuation);
        if (appFlyersApiService == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return appFlyersApiService;
        }
        return Unit.INSTANCE;
    }
}
