package com.mpl.androidapp.miniprofile.kotlin.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.models.BroadcastChatConfig;
import com.mpl.androidapp.miniprofile.models.ChatDisclaimerConfig;
import com.mpl.androidapp.miniprofile.models.ExoPlayerConfig;
import com.mpl.androidapp.miniprofile.models.TournamentDetailsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sfs2x.client.entities.invitation.InvitationReply;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/GameBroadcastConfig;", "", "exoplayer", "Lcom/mpl/androidapp/miniprofile/models/ExoPlayerConfig;", "broadcastChat", "Lcom/mpl/androidapp/miniprofile/models/BroadcastChatConfig;", "tournamentDetails", "Lcom/mpl/androidapp/miniprofile/models/TournamentDetailsConfig;", "chatDisclaimer", "Lcom/mpl/androidapp/miniprofile/models/ChatDisclaimerConfig;", "(Lcom/mpl/androidapp/miniprofile/models/ExoPlayerConfig;Lcom/mpl/androidapp/miniprofile/models/BroadcastChatConfig;Lcom/mpl/androidapp/miniprofile/models/TournamentDetailsConfig;Lcom/mpl/androidapp/miniprofile/models/ChatDisclaimerConfig;)V", "getBroadcastChat", "()Lcom/mpl/androidapp/miniprofile/models/BroadcastChatConfig;", "getChatDisclaimer", "()Lcom/mpl/androidapp/miniprofile/models/ChatDisclaimerConfig;", "getExoplayer", "()Lcom/mpl/androidapp/miniprofile/models/ExoPlayerConfig;", "getTournamentDetails", "()Lcom/mpl/androidapp/miniprofile/models/TournamentDetailsConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameBroadcastConfig.kt */
public final class GameBroadcastConfig {
    public final BroadcastChatConfig broadcastChat;
    public final ChatDisclaimerConfig chatDisclaimer;
    public final ExoPlayerConfig exoplayer;
    public final TournamentDetailsConfig tournamentDetails;

    public GameBroadcastConfig() {
        this(null, null, null, null, 15, null);
    }

    public GameBroadcastConfig(ExoPlayerConfig exoPlayerConfig, BroadcastChatConfig broadcastChatConfig, TournamentDetailsConfig tournamentDetailsConfig, ChatDisclaimerConfig chatDisclaimerConfig) {
        Intrinsics.checkNotNullParameter(exoPlayerConfig, "exoplayer");
        Intrinsics.checkNotNullParameter(broadcastChatConfig, "broadcastChat");
        Intrinsics.checkNotNullParameter(tournamentDetailsConfig, "tournamentDetails");
        Intrinsics.checkNotNullParameter(chatDisclaimerConfig, "chatDisclaimer");
        this.exoplayer = exoPlayerConfig;
        this.broadcastChat = broadcastChatConfig;
        this.tournamentDetails = tournamentDetailsConfig;
        this.chatDisclaimer = chatDisclaimerConfig;
    }

    public static /* synthetic */ GameBroadcastConfig copy$default(GameBroadcastConfig gameBroadcastConfig, ExoPlayerConfig exoPlayerConfig, BroadcastChatConfig broadcastChatConfig, TournamentDetailsConfig tournamentDetailsConfig, ChatDisclaimerConfig chatDisclaimerConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            exoPlayerConfig = gameBroadcastConfig.exoplayer;
        }
        if ((i & 2) != 0) {
            broadcastChatConfig = gameBroadcastConfig.broadcastChat;
        }
        if ((i & 4) != 0) {
            tournamentDetailsConfig = gameBroadcastConfig.tournamentDetails;
        }
        if ((i & 8) != 0) {
            chatDisclaimerConfig = gameBroadcastConfig.chatDisclaimer;
        }
        return gameBroadcastConfig.copy(exoPlayerConfig, broadcastChatConfig, tournamentDetailsConfig, chatDisclaimerConfig);
    }

    public final ExoPlayerConfig component1() {
        return this.exoplayer;
    }

    public final BroadcastChatConfig component2() {
        return this.broadcastChat;
    }

    public final TournamentDetailsConfig component3() {
        return this.tournamentDetails;
    }

    public final ChatDisclaimerConfig component4() {
        return this.chatDisclaimer;
    }

    public final GameBroadcastConfig copy(ExoPlayerConfig exoPlayerConfig, BroadcastChatConfig broadcastChatConfig, TournamentDetailsConfig tournamentDetailsConfig, ChatDisclaimerConfig chatDisclaimerConfig) {
        Intrinsics.checkNotNullParameter(exoPlayerConfig, "exoplayer");
        Intrinsics.checkNotNullParameter(broadcastChatConfig, "broadcastChat");
        Intrinsics.checkNotNullParameter(tournamentDetailsConfig, "tournamentDetails");
        Intrinsics.checkNotNullParameter(chatDisclaimerConfig, "chatDisclaimer");
        return new GameBroadcastConfig(exoPlayerConfig, broadcastChatConfig, tournamentDetailsConfig, chatDisclaimerConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameBroadcastConfig)) {
            return false;
        }
        GameBroadcastConfig gameBroadcastConfig = (GameBroadcastConfig) obj;
        return Intrinsics.areEqual(this.exoplayer, gameBroadcastConfig.exoplayer) && Intrinsics.areEqual(this.broadcastChat, gameBroadcastConfig.broadcastChat) && Intrinsics.areEqual(this.tournamentDetails, gameBroadcastConfig.tournamentDetails) && Intrinsics.areEqual(this.chatDisclaimer, gameBroadcastConfig.chatDisclaimer);
    }

    public final BroadcastChatConfig getBroadcastChat() {
        return this.broadcastChat;
    }

    public final ChatDisclaimerConfig getChatDisclaimer() {
        return this.chatDisclaimer;
    }

    public final ExoPlayerConfig getExoplayer() {
        return this.exoplayer;
    }

    public final TournamentDetailsConfig getTournamentDetails() {
        return this.tournamentDetails;
    }

    public int hashCode() {
        int hashCode = this.broadcastChat.hashCode();
        int hashCode2 = this.tournamentDetails.hashCode();
        return this.chatDisclaimer.hashCode() + ((hashCode2 + ((hashCode + (this.exoplayer.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameBroadcastConfig(exoplayer=");
        outline73.append(this.exoplayer);
        outline73.append(", broadcastChat=");
        outline73.append(this.broadcastChat);
        outline73.append(", tournamentDetails=");
        outline73.append(this.tournamentDetails);
        outline73.append(", chatDisclaimer=");
        outline73.append(this.chatDisclaimer);
        outline73.append(')');
        return outline73.toString();
    }

    public /* synthetic */ GameBroadcastConfig(ExoPlayerConfig exoPlayerConfig, BroadcastChatConfig broadcastChatConfig, TournamentDetailsConfig tournamentDetailsConfig, ChatDisclaimerConfig chatDisclaimerConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        GameBroadcastConfig gameBroadcastConfig;
        ChatDisclaimerConfig chatDisclaimerConfig2;
        ExoPlayerConfig exoPlayerConfig2 = (i & 1) != 0 ? new ExoPlayerConfig(null, null, 0, 0, 0, 0, false, false, 0, 0, false, 0, 0, false, false, false, 0, 0, null, 524287, null) : exoPlayerConfig;
        BroadcastChatConfig broadcastChatConfig2 = (i & 2) != 0 ? new BroadcastChatConfig(false, false, false, false, 0, false, null, false, InvitationReply.EXPIRED, null) : broadcastChatConfig;
        TournamentDetailsConfig tournamentDetailsConfig2 = (i & 4) != 0 ? new TournamentDetailsConfig(false, false, false, 7, null) : tournamentDetailsConfig;
        if ((i & 8) != 0) {
            chatDisclaimerConfig2 = new ChatDisclaimerConfig(false, null, null, 7, null);
            gameBroadcastConfig = this;
        } else {
            gameBroadcastConfig = this;
            chatDisclaimerConfig2 = chatDisclaimerConfig;
        }
        new GameBroadcastConfig(exoPlayerConfig2, broadcastChatConfig2, tournamentDetailsConfig2, chatDisclaimerConfig2);
    }
}
