package com.midtrans.sdk.gopaycheckout.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.midtrans.sdk.gopaycheckout.core.account.AccountResponse;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse;
import com.midtrans.sdk.gopaycheckout.core.web.GoPayCheckoutWebViewActivity;
import com.mpl.androidapp.utils.Constant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\r\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0002J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0016J-\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001cJ-\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\rH\u0002J\u0015\u0010!\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\"H\u0000¢\u0006\u0002\b#J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\rH\u0002J&\u0010&\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0004J&\u0010'\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0004J*\u0010(\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutProcessor;", "", "()V", "processCallback", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutProcessorCallback;", "clearCallback", "", "clearCallback$gopay_checkout_release", "createInternalCallback", "callback", "getCallback", "getCallback$gopay_checkout_release", "getLinkAccountAction", "Lcom/midtrans/sdk/gopaycheckout/core/PendingAction;", "response", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "getTransactionAction", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionResponse;", "hasActions", "", "hasActions$gopay_checkout_release", "hasTransactionActions", "hasTransactionActions$gopay_checkout_release", "internalProcessAccountLinking", "activity", "Landroid/app/Activity;", "callbackUrl", "", "internalProcessAccountLinking$gopay_checkout_release", "internalProcessTransaction", "internalProcessTransaction$gopay_checkout_release", "isDeepLinkActivationAction", "action", "isPending", "Lcom/midtrans/sdk/gopaycheckout/core/BaseResponse;", "isPending$gopay_checkout_release", "isSucceeded", "isUserVerificationAction", "processAccountLinking", "processTransaction", "startWebView", "url", "Companion", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutProcessor {
    public static final Companion Companion = new Companion(null);
    @SuppressLint({"StaticFieldLeak"})
    public static volatile GoPayCheckoutProcessor instance;
    public GoPayCheckoutProcessorCallback processCallback;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutProcessor$Companion;", "", "()V", "instance", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutProcessor;", "getInstance", "setInstance", "", "goPayCheckoutProcessor", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void setInstance(GoPayCheckoutProcessor goPayCheckoutProcessor) {
            GoPayCheckoutProcessor.instance = goPayCheckoutProcessor;
        }

        public final GoPayCheckoutProcessor getInstance() {
            if (GoPayCheckoutProcessor.instance == null) {
                new GoPayCheckoutProcessor();
            }
            GoPayCheckoutProcessor access$getInstance$cp = GoPayCheckoutProcessor.instance;
            if (access$getInstance$cp != null) {
                return access$getInstance$cp;
            }
            Intrinsics.throwNpe();
            throw null;
        }
    }

    public GoPayCheckoutProcessor() {
        instance = this;
    }

    private final GoPayCheckoutProcessorCallback createInternalCallback(GoPayCheckoutProcessorCallback goPayCheckoutProcessorCallback) {
        return new GoPayCheckoutProcessor$createInternalCallback$1(goPayCheckoutProcessorCallback);
    }

    private final PendingAction getLinkAccountAction(AccountResponse accountResponse) {
        List<PendingAction> actions = accountResponse.getActions();
        T t = null;
        if (actions == null) {
            return null;
        }
        Iterator<T> it = actions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (isDeepLinkActivationAction((PendingAction) next)) {
                t = next;
                break;
            }
        }
        return (PendingAction) t;
    }

    private final PendingAction getTransactionAction(TransactionResponse transactionResponse) {
        List<PendingAction> actions = transactionResponse.getActions();
        T t = null;
        if (actions == null) {
            return null;
        }
        Iterator<T> it = actions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (isUserVerificationAction((PendingAction) next)) {
                t = next;
                break;
            }
        }
        return (PendingAction) t;
    }

    private final boolean isDeepLinkActivationAction(PendingAction pendingAction) {
        return Intrinsics.areEqual(pendingAction.getName(), "activation-deeplink") && CharsKt__CharKt.equals(pendingAction.getMethod(), (String) Constant.GET, true);
    }

    private final boolean isSucceeded(BaseResponse baseResponse) {
        return Intrinsics.areEqual(baseResponse.getStatusCode(), "200");
    }

    private final boolean isUserVerificationAction(PendingAction pendingAction) {
        return Intrinsics.areEqual(pendingAction.getName(), "user-verification") && CharsKt__CharKt.equals(pendingAction.getMethod(), (String) Constant.GET, true);
    }

    private final void startWebView(Activity activity, String str, String str2, GoPayCheckoutProcessorCallback goPayCheckoutProcessorCallback) {
        this.processCallback = goPayCheckoutProcessorCallback;
        com.midtrans.sdk.gopaycheckout.core.web.GoPayCheckoutWebViewActivity.Companion companion = GoPayCheckoutWebViewActivity.Companion;
        if (str == null) {
            str = "";
        }
        activity.startActivity(companion.intent$gopay_checkout_release(activity, str, str2));
    }

    public final void clearCallback$gopay_checkout_release() {
        this.processCallback = null;
    }

    public final GoPayCheckoutProcessorCallback getCallback$gopay_checkout_release() {
        GoPayCheckoutProcessorCallback goPayCheckoutProcessorCallback = this.processCallback;
        return goPayCheckoutProcessorCallback != null ? goPayCheckoutProcessorCallback : new GoPayCheckoutProcessor$getCallback$1();
    }

    public final boolean hasActions$gopay_checkout_release(AccountResponse accountResponse) {
        Intrinsics.checkParameterIsNotNull(accountResponse, com.paynimo.android.payment.util.Constant.TAG_RESPONSE);
        List<PendingAction> actions = accountResponse.getActions();
        return !(actions == null || actions.isEmpty());
    }

    public final boolean hasTransactionActions$gopay_checkout_release(TransactionResponse transactionResponse) {
        Intrinsics.checkParameterIsNotNull(transactionResponse, com.paynimo.android.payment.util.Constant.TAG_RESPONSE);
        List<PendingAction> actions = transactionResponse.getActions();
        return !(actions == null || actions.isEmpty());
    }

    public final void internalProcessAccountLinking$gopay_checkout_release(Activity activity, String str, AccountResponse accountResponse, GoPayCheckoutProcessorCallback goPayCheckoutProcessorCallback) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "callbackUrl");
        Intrinsics.checkParameterIsNotNull(accountResponse, com.paynimo.android.payment.util.Constant.TAG_RESPONSE);
        Intrinsics.checkParameterIsNotNull(goPayCheckoutProcessorCallback, "callback");
        if (!isPending$gopay_checkout_release(accountResponse) || !hasActions$gopay_checkout_release(accountResponse)) {
            isSucceeded(accountResponse);
            goPayCheckoutProcessorCallback.onCompleted();
            return;
        }
        PendingAction linkAccountAction = getLinkAccountAction(accountResponse);
        if (linkAccountAction != null) {
            this.processCallback = goPayCheckoutProcessorCallback;
            startWebView(activity, linkAccountAction.getUrl(), str, goPayCheckoutProcessorCallback);
        }
    }

    public final void internalProcessTransaction$gopay_checkout_release(Activity activity, String str, TransactionResponse transactionResponse, GoPayCheckoutProcessorCallback goPayCheckoutProcessorCallback) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "callbackUrl");
        Intrinsics.checkParameterIsNotNull(transactionResponse, com.paynimo.android.payment.util.Constant.TAG_RESPONSE);
        Intrinsics.checkParameterIsNotNull(goPayCheckoutProcessorCallback, "callback");
        if (!isPending$gopay_checkout_release(transactionResponse) || !hasTransactionActions$gopay_checkout_release(transactionResponse)) {
            isSucceeded(transactionResponse);
            goPayCheckoutProcessorCallback.onCompleted();
            return;
        }
        PendingAction transactionAction = getTransactionAction(transactionResponse);
        if (transactionAction != null) {
            startWebView(activity, transactionAction.getUrl(), str, goPayCheckoutProcessorCallback);
        }
    }

    public final boolean isPending$gopay_checkout_release(BaseResponse baseResponse) {
        Intrinsics.checkParameterIsNotNull(baseResponse, com.paynimo.android.payment.util.Constant.TAG_RESPONSE);
        return Intrinsics.areEqual(baseResponse.getStatusCode(), "201");
    }

    public final void processAccountLinking(Activity activity, String str, AccountResponse accountResponse, GoPayCheckoutProcessorCallback goPayCheckoutProcessorCallback) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "callbackUrl");
        Intrinsics.checkParameterIsNotNull(accountResponse, com.paynimo.android.payment.util.Constant.TAG_RESPONSE);
        Intrinsics.checkParameterIsNotNull(goPayCheckoutProcessorCallback, "callback");
        if (GoPayCheckoutState.INSTANCE.checkExecutable()) {
            GoPayCheckoutState.INSTANCE.setExecutable(false);
            internalProcessAccountLinking$gopay_checkout_release(activity, str, accountResponse, createInternalCallback(goPayCheckoutProcessorCallback));
        }
    }

    public final void processTransaction(Activity activity, String str, TransactionResponse transactionResponse, GoPayCheckoutProcessorCallback goPayCheckoutProcessorCallback) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "callbackUrl");
        Intrinsics.checkParameterIsNotNull(transactionResponse, com.paynimo.android.payment.util.Constant.TAG_RESPONSE);
        Intrinsics.checkParameterIsNotNull(goPayCheckoutProcessorCallback, "callback");
        if (GoPayCheckoutState.INSTANCE.checkExecutable()) {
            GoPayCheckoutState.INSTANCE.setExecutable(false);
            internalProcessTransaction$gopay_checkout_release(activity, str, transactionResponse, createInternalCallback(goPayCheckoutProcessorCallback));
        }
    }
}
