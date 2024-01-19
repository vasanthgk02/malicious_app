package com.mpl.androidapp.updater.downloadmanager.states;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.database.entity.GameAssetResource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000f\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u000f\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "", "()V", "AnalyticsUpdated", "AssetCopied", "AssetInserted", "AssetsExtracted", "CheckNotificationToBeDisplayed", "CheckOptionalDownloadNotificationDisplay", "DeleteAssetFile", "DeleteGameAssetResourceFromId", "ErrorState", "GameAssetResourceState", "GameResourceDeleted", "InitialState", "ProgressPublished", "UserVisitToOptionalDownload", "UserVisitToOptionalDownloadUpdate", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$InitialState;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$GameResourceDeleted;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$DeleteAssetFile;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$AnalyticsUpdated;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$ProgressPublished;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$AssetsExtracted;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$AssetInserted;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$AssetCopied;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$GameAssetResourceState;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$ErrorState;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$UserVisitToOptionalDownload;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$UserVisitToOptionalDownloadUpdate;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$CheckNotificationToBeDisplayed;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$DeleteGameAssetResourceFromId;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$CheckOptionalDownloadNotificationDisplay;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QueryDownloadStates.kt */
public abstract class QueryDownloadStates {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$AnalyticsUpdated;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class AnalyticsUpdated extends QueryDownloadStates {
        public static final AnalyticsUpdated INSTANCE = new AnalyticsUpdated();

        public AnalyticsUpdated() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$AssetCopied;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class AssetCopied extends QueryDownloadStates {
        public static final AssetCopied INSTANCE = new AssetCopied();

        public AssetCopied() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$AssetInserted;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class AssetInserted extends QueryDownloadStates {
        public static final AssetInserted INSTANCE = new AssetInserted();

        public AssetInserted() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$AssetsExtracted;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class AssetsExtracted extends QueryDownloadStates {
        public static final AssetsExtracted INSTANCE = new AssetsExtracted();

        public AssetsExtracted() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$CheckNotificationToBeDisplayed;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "isDisplayed", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class CheckNotificationToBeDisplayed extends QueryDownloadStates {
        public final boolean isDisplayed;

        public CheckNotificationToBeDisplayed(boolean z) {
            super(null);
            this.isDisplayed = z;
        }

        public static /* synthetic */ CheckNotificationToBeDisplayed copy$default(CheckNotificationToBeDisplayed checkNotificationToBeDisplayed, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = checkNotificationToBeDisplayed.isDisplayed;
            }
            return checkNotificationToBeDisplayed.copy(z);
        }

        public final boolean component1() {
            return this.isDisplayed;
        }

        public final CheckNotificationToBeDisplayed copy(boolean z) {
            return new CheckNotificationToBeDisplayed(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CheckNotificationToBeDisplayed) && this.isDisplayed == ((CheckNotificationToBeDisplayed) obj).isDisplayed;
        }

        public int hashCode() {
            boolean z = this.isDisplayed;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isDisplayed() {
            return this.isDisplayed;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("CheckNotificationToBeDisplayed(isDisplayed="), this.isDisplayed, ')');
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$CheckOptionalDownloadNotificationDisplay;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "isEnabled", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class CheckOptionalDownloadNotificationDisplay extends QueryDownloadStates {
        public final boolean isEnabled;

        public CheckOptionalDownloadNotificationDisplay(boolean z) {
            super(null);
            this.isEnabled = z;
        }

        public static /* synthetic */ CheckOptionalDownloadNotificationDisplay copy$default(CheckOptionalDownloadNotificationDisplay checkOptionalDownloadNotificationDisplay, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = checkOptionalDownloadNotificationDisplay.isEnabled;
            }
            return checkOptionalDownloadNotificationDisplay.copy(z);
        }

        public final boolean component1() {
            return this.isEnabled;
        }

        public final CheckOptionalDownloadNotificationDisplay copy(boolean z) {
            return new CheckOptionalDownloadNotificationDisplay(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CheckOptionalDownloadNotificationDisplay) && this.isEnabled == ((CheckOptionalDownloadNotificationDisplay) obj).isEnabled;
        }

        public int hashCode() {
            boolean z = this.isEnabled;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("CheckOptionalDownloadNotificationDisplay(isEnabled="), this.isEnabled, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$DeleteAssetFile;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class DeleteAssetFile extends QueryDownloadStates {
        public static final DeleteAssetFile INSTANCE = new DeleteAssetFile();

        public DeleteAssetFile() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$DeleteGameAssetResourceFromId;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "isDeleted", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class DeleteGameAssetResourceFromId extends QueryDownloadStates {
        public final boolean isDeleted;

        public DeleteGameAssetResourceFromId(boolean z) {
            super(null);
            this.isDeleted = z;
        }

        public static /* synthetic */ DeleteGameAssetResourceFromId copy$default(DeleteGameAssetResourceFromId deleteGameAssetResourceFromId, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = deleteGameAssetResourceFromId.isDeleted;
            }
            return deleteGameAssetResourceFromId.copy(z);
        }

        public final boolean component1() {
            return this.isDeleted;
        }

        public final DeleteGameAssetResourceFromId copy(boolean z) {
            return new DeleteGameAssetResourceFromId(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteGameAssetResourceFromId) && this.isDeleted == ((DeleteGameAssetResourceFromId) obj).isDeleted;
        }

        public int hashCode() {
            boolean z = this.isDeleted;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isDeleted() {
            return this.isDeleted;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("DeleteGameAssetResourceFromId(isDeleted="), this.isDeleted, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$ErrorState;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class ErrorState extends QueryDownloadStates {
        public final String errorMessage;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ErrorState(String str) {
            // Intrinsics.checkNotNullParameter(str, "errorMessage");
            super(null);
            this.errorMessage = str;
        }

        public static /* synthetic */ ErrorState copy$default(ErrorState errorState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = errorState.errorMessage;
            }
            return errorState.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final ErrorState copy(String str) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            return new ErrorState(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ErrorState) && Intrinsics.areEqual(this.errorMessage, ((ErrorState) obj).errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("ErrorState(errorMessage="), this.errorMessage, ')');
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$GameAssetResourceState;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "gameAssetResource", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "(Lcom/mpl/androidapp/database/entity/GameAssetResource;)V", "getGameAssetResource", "()Lcom/mpl/androidapp/database/entity/GameAssetResource;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class GameAssetResourceState extends QueryDownloadStates {
        public final GameAssetResource gameAssetResource;

        public GameAssetResourceState(GameAssetResource gameAssetResource2) {
            super(null);
            this.gameAssetResource = gameAssetResource2;
        }

        public static /* synthetic */ GameAssetResourceState copy$default(GameAssetResourceState gameAssetResourceState, GameAssetResource gameAssetResource2, int i, Object obj) {
            if ((i & 1) != 0) {
                gameAssetResource2 = gameAssetResourceState.gameAssetResource;
            }
            return gameAssetResourceState.copy(gameAssetResource2);
        }

        public final GameAssetResource component1() {
            return this.gameAssetResource;
        }

        public final GameAssetResourceState copy(GameAssetResource gameAssetResource2) {
            return new GameAssetResourceState(gameAssetResource2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GameAssetResourceState) && Intrinsics.areEqual(this.gameAssetResource, ((GameAssetResourceState) obj).gameAssetResource);
        }

        public final GameAssetResource getGameAssetResource() {
            return this.gameAssetResource;
        }

        public int hashCode() {
            GameAssetResource gameAssetResource2 = this.gameAssetResource;
            if (gameAssetResource2 == null) {
                return 0;
            }
            return gameAssetResource2.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameAssetResourceState(gameAssetResource=");
            outline73.append(this.gameAssetResource);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$GameResourceDeleted;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class GameResourceDeleted extends QueryDownloadStates {
        public static final GameResourceDeleted INSTANCE = new GameResourceDeleted();

        public GameResourceDeleted() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$InitialState;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class InitialState extends QueryDownloadStates {
        public static final InitialState INSTANCE = new InitialState();

        public InitialState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$ProgressPublished;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class ProgressPublished extends QueryDownloadStates {
        public static final ProgressPublished INSTANCE = new ProgressPublished();

        public ProgressPublished() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$UserVisitToOptionalDownload;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "isVisitTrue", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class UserVisitToOptionalDownload extends QueryDownloadStates {
        public final boolean isVisitTrue;

        public UserVisitToOptionalDownload(boolean z) {
            super(null);
            this.isVisitTrue = z;
        }

        public static /* synthetic */ UserVisitToOptionalDownload copy$default(UserVisitToOptionalDownload userVisitToOptionalDownload, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = userVisitToOptionalDownload.isVisitTrue;
            }
            return userVisitToOptionalDownload.copy(z);
        }

        public final boolean component1() {
            return this.isVisitTrue;
        }

        public final UserVisitToOptionalDownload copy(boolean z) {
            return new UserVisitToOptionalDownload(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserVisitToOptionalDownload) && this.isVisitTrue == ((UserVisitToOptionalDownload) obj).isVisitTrue;
        }

        public int hashCode() {
            boolean z = this.isVisitTrue;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isVisitTrue() {
            return this.isVisitTrue;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("UserVisitToOptionalDownload(isVisitTrue="), this.isVisitTrue, ')');
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates$UserVisitToOptionalDownloadUpdate;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "isUpdated", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryDownloadStates.kt */
    public static final class UserVisitToOptionalDownloadUpdate extends QueryDownloadStates {
        public final boolean isUpdated;

        public UserVisitToOptionalDownloadUpdate(boolean z) {
            super(null);
            this.isUpdated = z;
        }

        public static /* synthetic */ UserVisitToOptionalDownloadUpdate copy$default(UserVisitToOptionalDownloadUpdate userVisitToOptionalDownloadUpdate, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = userVisitToOptionalDownloadUpdate.isUpdated;
            }
            return userVisitToOptionalDownloadUpdate.copy(z);
        }

        public final boolean component1() {
            return this.isUpdated;
        }

        public final UserVisitToOptionalDownloadUpdate copy(boolean z) {
            return new UserVisitToOptionalDownloadUpdate(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserVisitToOptionalDownloadUpdate) && this.isUpdated == ((UserVisitToOptionalDownloadUpdate) obj).isUpdated;
        }

        public int hashCode() {
            boolean z = this.isUpdated;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isUpdated() {
            return this.isUpdated;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("UserVisitToOptionalDownloadUpdate(isUpdated="), this.isUpdated, ')');
        }
    }

    public QueryDownloadStates() {
    }

    public /* synthetic */ QueryDownloadStates(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
