package com.mpl.androidapp.filehandling.downloadservice.states;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\n\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "", "()V", "DeleteExistingFile", "DeleteFileInStorage", "DownloadFailure", "DownloadInProgress", "DownloadSuccessful", "ErrorState", "FilePlaceHolderForDownload", "InitialState", "IsConnectedToInternet", "ValidInputs", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$InitialState;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DeleteFileInStorage;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DownloadInProgress;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DownloadFailure;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$ValidInputs;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DownloadSuccessful;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$FilePlaceHolderForDownload;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DeleteExistingFile;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$IsConnectedToInternet;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$ErrorState;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GenericFileDownloadStates.kt */
public abstract class GenericFileDownloadStates {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DeleteExistingFile;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "wasFilePresentAndDeleted", "", "(Z)V", "getWasFilePresentAndDeleted", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class DeleteExistingFile extends GenericFileDownloadStates {
        public final boolean wasFilePresentAndDeleted;

        public DeleteExistingFile(boolean z) {
            super(null);
            this.wasFilePresentAndDeleted = z;
        }

        public static /* synthetic */ DeleteExistingFile copy$default(DeleteExistingFile deleteExistingFile, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = deleteExistingFile.wasFilePresentAndDeleted;
            }
            return deleteExistingFile.copy(z);
        }

        public final boolean component1() {
            return this.wasFilePresentAndDeleted;
        }

        public final DeleteExistingFile copy(boolean z) {
            return new DeleteExistingFile(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteExistingFile) && this.wasFilePresentAndDeleted == ((DeleteExistingFile) obj).wasFilePresentAndDeleted;
        }

        public final boolean getWasFilePresentAndDeleted() {
            return this.wasFilePresentAndDeleted;
        }

        public int hashCode() {
            boolean z = this.wasFilePresentAndDeleted;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("DeleteExistingFile(wasFilePresentAndDeleted="), this.wasFilePresentAndDeleted, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DeleteFileInStorage;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class DeleteFileInStorage extends GenericFileDownloadStates {
        public static final DeleteFileInStorage INSTANCE = new DeleteFileInStorage();

        public DeleteFileInStorage() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DownloadFailure;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class DownloadFailure extends GenericFileDownloadStates {
        public static final DownloadFailure INSTANCE = new DownloadFailure();

        public DownloadFailure() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DownloadInProgress;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class DownloadInProgress extends GenericFileDownloadStates {
        public static final DownloadInProgress INSTANCE = new DownloadInProgress();

        public DownloadInProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$DownloadSuccessful;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "fileDownloaded", "Ljava/io/File;", "(Ljava/io/File;)V", "getFileDownloaded", "()Ljava/io/File;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class DownloadSuccessful extends GenericFileDownloadStates {
        public final File fileDownloaded;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public DownloadSuccessful(File file) {
            // Intrinsics.checkNotNullParameter(file, "fileDownloaded");
            super(null);
            this.fileDownloaded = file;
        }

        public static /* synthetic */ DownloadSuccessful copy$default(DownloadSuccessful downloadSuccessful, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                file = downloadSuccessful.fileDownloaded;
            }
            return downloadSuccessful.copy(file);
        }

        public final File component1() {
            return this.fileDownloaded;
        }

        public final DownloadSuccessful copy(File file) {
            Intrinsics.checkNotNullParameter(file, "fileDownloaded");
            return new DownloadSuccessful(file);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DownloadSuccessful) && Intrinsics.areEqual(this.fileDownloaded, ((DownloadSuccessful) obj).fileDownloaded);
        }

        public final File getFileDownloaded() {
            return this.fileDownloaded;
        }

        public int hashCode() {
            return this.fileDownloaded.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("DownloadSuccessful(fileDownloaded=");
            outline73.append(this.fileDownloaded);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$ErrorState;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class ErrorState extends GenericFileDownloadStates {
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$FilePlaceHolderForDownload;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "fileCreated", "Ljava/io/File;", "(Ljava/io/File;)V", "getFileCreated", "()Ljava/io/File;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class FilePlaceHolderForDownload extends GenericFileDownloadStates {
        public final File fileCreated;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public FilePlaceHolderForDownload(File file) {
            // Intrinsics.checkNotNullParameter(file, "fileCreated");
            super(null);
            this.fileCreated = file;
        }

        public static /* synthetic */ FilePlaceHolderForDownload copy$default(FilePlaceHolderForDownload filePlaceHolderForDownload, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                file = filePlaceHolderForDownload.fileCreated;
            }
            return filePlaceHolderForDownload.copy(file);
        }

        public final File component1() {
            return this.fileCreated;
        }

        public final FilePlaceHolderForDownload copy(File file) {
            Intrinsics.checkNotNullParameter(file, "fileCreated");
            return new FilePlaceHolderForDownload(file);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FilePlaceHolderForDownload) && Intrinsics.areEqual(this.fileCreated, ((FilePlaceHolderForDownload) obj).fileCreated);
        }

        public final File getFileCreated() {
            return this.fileCreated;
        }

        public int hashCode() {
            return this.fileCreated.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("FilePlaceHolderForDownload(fileCreated=");
            outline73.append(this.fileCreated);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$InitialState;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class InitialState extends GenericFileDownloadStates {
        public static final InitialState INSTANCE = new InitialState();

        public InitialState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$IsConnectedToInternet;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "isConnected", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class IsConnectedToInternet extends GenericFileDownloadStates {
        public final boolean isConnected;

        public IsConnectedToInternet(boolean z) {
            super(null);
            this.isConnected = z;
        }

        public static /* synthetic */ IsConnectedToInternet copy$default(IsConnectedToInternet isConnectedToInternet, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = isConnectedToInternet.isConnected;
            }
            return isConnectedToInternet.copy(z);
        }

        public final boolean component1() {
            return this.isConnected;
        }

        public final IsConnectedToInternet copy(boolean z) {
            return new IsConnectedToInternet(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IsConnectedToInternet) && this.isConnected == ((IsConnectedToInternet) obj).isConnected;
        }

        public int hashCode() {
            boolean z = this.isConnected;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isConnected() {
            return this.isConnected;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("IsConnectedToInternet(isConnected="), this.isConnected, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates$ValidInputs;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GenericFileDownloadStates.kt */
    public static final class ValidInputs extends GenericFileDownloadStates {
        public final String url;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ValidInputs(String str) {
            // Intrinsics.checkNotNullParameter(str, "url");
            super(null);
            this.url = str;
        }

        public static /* synthetic */ ValidInputs copy$default(ValidInputs validInputs, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = validInputs.url;
            }
            return validInputs.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final ValidInputs copy(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new ValidInputs(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ValidInputs) && Intrinsics.areEqual(this.url, ((ValidInputs) obj).url);
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("ValidInputs(url="), this.url, ')');
        }
    }

    public GenericFileDownloadStates() {
    }

    public /* synthetic */ GenericFileDownloadStates(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
