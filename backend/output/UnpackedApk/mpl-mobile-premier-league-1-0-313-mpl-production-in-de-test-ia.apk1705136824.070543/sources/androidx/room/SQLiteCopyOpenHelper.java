package androidx.room;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.core.widget.CompoundButtonCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0002\u0010\u000fJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\bH\u0002J\u0018\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u000e\u0010'\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u001cH\u0017J\u0010\u0010*\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001a¨\u0006+"}, d2 = {"Landroidx/room/SQLiteCopyOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "context", "Landroid/content/Context;", "copyFromAssetPath", "", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "databaseVersion", "", "delegate", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;ILandroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "databaseConfiguration", "Landroidx/room/DatabaseConfiguration;", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "verified", "", "writableDatabase", "getWritableDatabase", "close", "", "copyDatabaseFile", "destinationFile", "writable", "createFrameworkOpenHelper", "databaseFile", "dispatchOnOpenPrepackagedDatabase", "setDatabaseConfiguration", "setWriteAheadLoggingEnabled", "enabled", "verifyDatabaseFile", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SQLiteCopyOpenHelper.kt */
public final class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public DatabaseConfiguration databaseConfiguration;
    public final int databaseVersion;
    public final SupportSQLiteOpenHelper delegate;
    public boolean verified;

    public synchronized void close() {
        this.delegate.close();
        this.verified = false;
    }

    /* JADX INFO: finally extract failed */
    public final void copyDatabaseFile(File file, boolean z) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.copyFromAssetPath != null) {
            readableByteChannel = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
            Intrinsics.checkNotNullExpressionValue(readableByteChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.copyFromFile != null) {
            readableByteChannel = new FileInputStream(this.copyFromFile).getChannel();
            Intrinsics.checkNotNullExpressionValue(readableByteChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable<InputStream> callable = this.copyFromInputStream;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel(callable.call());
                    Intrinsics.checkNotNullExpressionValue(readableByteChannel, "newChannel(inputStream)");
                } catch (Exception e2) {
                    throw new IOException("inputStreamCallable exception on call", e2);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "output");
        Intrinsics.checkNotNullParameter(readableByteChannel, "input");
        Intrinsics.checkNotNullParameter(channel, "output");
        try {
            if (VERSION.SDK_INT <= 23) {
                InputStream newInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream newOutputStream = Channels.newOutputStream(channel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    newOutputStream.write(bArr, 0, read);
                }
            } else {
                channel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            }
            channel.force(false);
            readableByteChannel.close();
            channel.close();
            File parentFile = file.getParentFile();
            if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                Intrinsics.checkNotNullExpressionValue(createTempFile, "intermediateFile");
                if (this.databaseConfiguration == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                    throw null;
                } else if (!createTempFile.renameTo(file)) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to move intermediate file (");
                    outline73.append(createTempFile.getAbsolutePath());
                    outline73.append(") to destination (");
                    outline73.append(file.getAbsolutePath());
                    outline73.append(").");
                    throw new IOException(outline73.toString());
                }
            } else {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Failed to create directories for ");
                outline732.append(file.getAbsolutePath());
                throw new IOException(outline732.toString());
            }
        } catch (Throwable th) {
            readableByteChannel.close();
            channel.close();
            throw th;
        }
    }

    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(true);
            this.verified = true;
        }
        return this.delegate.getWritableDatabase();
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        this.delegate.setWriteAheadLoggingEnabled(z);
    }

    public final void verifyDatabaseFile(boolean z) {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            File databasePath = this.context.getDatabasePath(databaseName);
            DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
            if (databaseConfiguration2 != null) {
                boolean z2 = databaseConfiguration2.multiInstanceInvalidation;
                File filesDir = this.context.getFilesDir();
                Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
                ProcessLock processLock = new ProcessLock(databaseName, filesDir, z2);
                try {
                    processLock.lock(processLock.processLock);
                    if (!databasePath.exists()) {
                        Intrinsics.checkNotNullExpressionValue(databasePath, "databaseFile");
                        copyDatabaseFile(databasePath, z);
                        processLock.unlock();
                        return;
                    }
                    try {
                        Intrinsics.checkNotNullExpressionValue(databasePath, "databaseFile");
                        int readVersion = CompoundButtonCompat.readVersion(databasePath);
                        if (readVersion == this.databaseVersion) {
                            processLock.unlock();
                            return;
                        }
                        DatabaseConfiguration databaseConfiguration3 = this.databaseConfiguration;
                        if (databaseConfiguration3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                            throw null;
                        } else if (databaseConfiguration3.isMigrationRequired(readVersion, this.databaseVersion)) {
                            processLock.unlock();
                        } else {
                            if (this.context.deleteDatabase(databaseName)) {
                                try {
                                    copyDatabaseFile(databasePath, z);
                                } catch (IOException unused) {
                                }
                            }
                            processLock.unlock();
                        }
                    } catch (IOException unused2) {
                        processLock.unlock();
                    }
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to copy database file.", e2);
                } catch (Throwable th) {
                    processLock.unlock();
                    throw th;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                throw null;
            }
        } else {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }
}
