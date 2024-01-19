package com.mpl.androidapp.game.androidgames.cardGame.implementations;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardGameConfigImpl.kt */
public final class CardGameConfigImpl$applicationContext$2 extends Lambda implements Function0<Context> {
    public final /* synthetic */ CardGameConfigImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CardGameConfigImpl$applicationContext$2(CardGameConfigImpl cardGameConfigImpl) {
        // this.this$0 = cardGameConfigImpl;
        super(0);
    }

    public final Context invoke() {
        return this.this$0.input.getContext();
    }
}
