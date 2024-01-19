package com.mpl.payment.common.cardinput;

import android.content.Intent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.common.OnActivityResultConsumer;
import com.mpl.payment.common.cardinput.models.AdditionalDetails;
import com.mpl.payment.common.cardinput.models.SavedCard;
import com.mpl.payment.common.cardinput.models.SavedCardsModel;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010)\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u001e\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000203J\u0016\u00104\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,2\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0018\u00107\u001a\u0002082\u0006\u00105\u001a\u0002062\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010;\u001a\u00020*H\u0002J\u000e\u0010<\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\rR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006="}, d2 = {"Lcom/mpl/payment/common/cardinput/CardInputManager;", "", "cardInputRouter", "Lcom/mpl/payment/common/cardinput/CardInputRouter;", "hostedFieldHandlerResolver", "Lcom/mpl/payment/common/cardinput/HostedFieldHandlerResolver;", "reactPayload", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/mpl/payment/common/cardinput/CardInputRouter;Lcom/mpl/payment/common/cardinput/HostedFieldHandlerResolver;Ljava/lang/String;Lcom/squareup/moshi/Moshi;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "cardInputResultListener", "Lcom/mpl/payment/common/cardinput/CardInputResultListener;", "getCardInputResultListener", "()Lcom/mpl/payment/common/cardinput/CardInputResultListener;", "setCardInputResultListener", "(Lcom/mpl/payment/common/cardinput/CardInputResultListener;)V", "getCardInputRouter", "()Lcom/mpl/payment/common/cardinput/CardInputRouter;", "getHostedFieldHandlerResolver", "()Lcom/mpl/payment/common/cardinput/HostedFieldHandlerResolver;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "onActivityResultConsumer", "Lcom/mpl/payment/common/OnActivityResultConsumer;", "getOnActivityResultConsumer", "()Lcom/mpl/payment/common/OnActivityResultConsumer;", "setOnActivityResultConsumer", "(Lcom/mpl/payment/common/OnActivityResultConsumer;)V", "getReactPayload", "savedCard", "Lcom/mpl/payment/common/cardinput/models/SavedCard;", "getSavedCard", "()Lcom/mpl/payment/common/cardinput/models/SavedCard;", "setSavedCard", "(Lcom/mpl/payment/common/cardinput/models/SavedCard;)V", "collectCardInfo", "", "cardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "routingPayloadJsonString", "forwardOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getPaymentMode", "tokenisationResultJson", "Lorg/json/JSONObject;", "isTokenisedCardDuplicate", "", "bin", "lastFour", "sendDuplicateCardStatus", "startCardCollection", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardInputManager.kt */
public final class CardInputManager {
    public String TAG = "CardInputManager";
    public CardInputResultListener cardInputResultListener;
    public final CardInputRouter cardInputRouter;
    public final HostedFieldHandlerResolver hostedFieldHandlerResolver;
    public final Moshi moshi;
    public OnActivityResultConsumer onActivityResultConsumer;
    public final String reactPayload;
    public SavedCard savedCard;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[CardInputType.values().length];
            $EnumSwitchMapping$0 = iArr;
            CardInputType cardInputType = CardInputType.BRAINTREE_HOSTED_FIELD;
            iArr[0] = 1;
            int[] iArr2 = new int[CardInputType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            CardInputType cardInputType2 = CardInputType.BRAINTREE_HOSTED_FIELD;
            iArr2[0] = 1;
            int[] iArr3 = new int[CardInputType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            CardInputType cardInputType3 = CardInputType.BRAINTREE_HOSTED_FIELD;
            iArr3[0] = 1;
        }
    }

    public CardInputManager(CardInputRouter cardInputRouter2, HostedFieldHandlerResolver hostedFieldHandlerResolver2, String str, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(cardInputRouter2, "cardInputRouter");
        Intrinsics.checkNotNullParameter(hostedFieldHandlerResolver2, "hostedFieldHandlerResolver");
        Intrinsics.checkNotNullParameter(str, "reactPayload");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.cardInputRouter = cardInputRouter2;
        this.hostedFieldHandlerResolver = hostedFieldHandlerResolver2;
        this.reactPayload = str;
        this.moshi = moshi2;
    }

    /* access modifiers changed from: private */
    public final void collectCardInfo(CardInputResultListener cardInputResultListener2, CardInputType cardInputType, String str) {
        if (cardInputType.ordinal() == 0) {
            try {
                HostedFieldHandler hostedFieldHandler = this.hostedFieldHandlerResolver.getHostedFieldHandler(cardInputType, str, this.reactPayload);
                this.onActivityResultConsumer = (OnActivityResultConsumer) (!(hostedFieldHandler instanceof OnActivityResultConsumer) ? null : hostedFieldHandler);
                hostedFieldHandler.collectAndTokenizeCard(new CardInputManager$collectCardInfo$1(this, cardInputType, str, cardInputResultListener2));
            } catch (Exception e2) {
                String message = e2.getMessage();
                if (message == null) {
                    message = GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " Exception in CardInput manager");
                }
                cardInputResultListener2.onCardInputError(message);
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean isTokenisedCardDuplicate(JSONObject jSONObject, CardInputType cardInputType) {
        if (cardInputType.ordinal() == 0) {
            String optString = jSONObject.optString("bin");
            String optString2 = jSONObject.optString("lastFour");
            boolean z = true;
            if (optString == null || CharsKt__CharKt.isBlank(optString)) {
                return false;
            }
            if (optString2 != null && !CharsKt__CharKt.isBlank(optString2)) {
                z = false;
            }
            if (z) {
                return false;
            }
            return isTokenisedCardDuplicate(optString, optString2);
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " cardinput type unknown"));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendDuplicateCardStatus() {
        /*
            r4 = this;
            com.mpl.payment.common.cardinput.models.SavedCard r0 = r4.savedCard
            if (r0 == 0) goto L_0x004a
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "status"
            java.lang.String r2 = "DUPLICATE_CARD"
            r0.put(r1, r2)
            com.mpl.payment.common.cardinput.models.SavedCard r1 = r4.savedCard
            r2 = 0
            if (r1 == 0) goto L_0x0020
            com.mpl.payment.common.cardinput.models.AdditionalDetails r1 = r1.getAdditionalDetails()
            if (r1 == 0) goto L_0x0020
            java.lang.String r1 = r1.getBinNo()
            goto L_0x0021
        L_0x0020:
            r1 = r2
        L_0x0021:
            java.lang.String r3 = "bin"
            r0.put(r3, r1)
            com.mpl.payment.common.cardinput.models.SavedCard r1 = r4.savedCard
            if (r1 == 0) goto L_0x0034
            com.mpl.payment.common.cardinput.models.AdditionalDetails r1 = r1.getAdditionalDetails()
            if (r1 == 0) goto L_0x0034
            java.lang.String r2 = r1.getLast4()
        L_0x0034:
            java.lang.String r1 = "lastFour"
            r0.put(r1, r2)
            com.mpl.payment.common.cardinput.CardInputResultListener r1 = r4.cardInputResultListener
            if (r1 == 0) goto L_0x0064
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "failedJson.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r1.onCardInputFailed(r0)
            goto L_0x0064
        L_0x004a:
            com.mpl.payment.common.cardinput.CardInputResultListener r0 = r4.cardInputResultListener
            if (r0 == 0) goto L_0x0064
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r4.TAG
            r1.append(r2)
            java.lang.String r2 = " duplicate saved card data not found"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.onCardInputError(r1)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.common.cardinput.CardInputManager.sendDuplicateCardStatus():void");
    }

    public final void forwardOnActivityResult(int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        OnActivityResultConsumer onActivityResultConsumer2 = this.onActivityResultConsumer;
        if (onActivityResultConsumer2 != null) {
            onActivityResultConsumer2.onActivityResult(i, i2, intent);
            return;
        }
        CardInputResultListener cardInputResultListener2 = this.cardInputResultListener;
        if (cardInputResultListener2 != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("result forwarded to ");
            outline73.append(this.TAG);
            outline73.append(" but no onActivityResultConsumerFound");
            cardInputResultListener2.onCardInputError(outline73.toString());
        }
    }

    public final CardInputResultListener getCardInputResultListener() {
        return this.cardInputResultListener;
    }

    public final CardInputRouter getCardInputRouter() {
        return this.cardInputRouter;
    }

    public final HostedFieldHandlerResolver getHostedFieldHandlerResolver() {
        return this.hostedFieldHandlerResolver;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final OnActivityResultConsumer getOnActivityResultConsumer() {
        return this.onActivityResultConsumer;
    }

    public final String getPaymentMode(CardInputType cardInputType, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(cardInputType, "cardInputType");
        Intrinsics.checkNotNullParameter(jSONObject, "tokenisationResultJson");
        if (cardInputType.ordinal() == 0) {
            String optString = jSONObject.optString("paymentMode");
            Intrinsics.checkNotNullExpressionValue(optString, "tokenisationResultJson.optString(\"paymentMode\")");
            return optString;
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " cardinput type unknown"));
    }

    public final String getReactPayload() {
        return this.reactPayload;
    }

    public final SavedCard getSavedCard() {
        return this.savedCard;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void setCardInputResultListener(CardInputResultListener cardInputResultListener2) {
        this.cardInputResultListener = cardInputResultListener2;
    }

    public final void setOnActivityResultConsumer(OnActivityResultConsumer onActivityResultConsumer2) {
        this.onActivityResultConsumer = onActivityResultConsumer2;
    }

    public final void setSavedCard(SavedCard savedCard2) {
        this.savedCard = savedCard2;
    }

    public final void setTAG(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.TAG = str;
    }

    public final void startCardCollection(CardInputResultListener cardInputResultListener2) {
        Intrinsics.checkNotNullParameter(cardInputResultListener2, "cardInputResultListener");
        this.cardInputResultListener = cardInputResultListener2;
        this.cardInputRouter.routeCardInput(new CardInputManager$startCardCollection$1(this, cardInputResultListener2));
    }

    private final boolean isTokenisedCardDuplicate(String str, String str2) {
        JsonAdapter<SavedCardsModel> adapter = this.moshi.adapter(SavedCardsModel.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(SavedCardsModel::class.java)");
        SavedCardsModel savedCardsModel = (SavedCardsModel) adapter.fromJson(this.reactPayload);
        if (savedCardsModel != null) {
            List<SavedCard> savedCardsData = savedCardsModel.getSavedCardsData();
            if (savedCardsData != null) {
                for (SavedCard savedCard2 : savedCardsData) {
                    AdditionalDetails additionalDetails = savedCard2.getAdditionalDetails();
                    String str3 = null;
                    if (Intrinsics.areEqual(additionalDetails != null ? additionalDetails.getBinNo() : null, str)) {
                        AdditionalDetails additionalDetails2 = savedCard2.getAdditionalDetails();
                        if (additionalDetails2 != null) {
                            str3 = additionalDetails2.getLast4();
                        }
                        if (Intrinsics.areEqual(str3, str2)) {
                            this.savedCard = savedCard2;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
