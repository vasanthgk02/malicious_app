package org.eclipse.paho.client.mqttv3.persist;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttPersistable;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.internal.FileLock;
import org.eclipse.paho.client.mqttv3.internal.MqttPersistentData;

public class MqttDefaultFilePersistence implements MqttClientPersistence {
    public static FilenameFilter FILENAME_FILTER = null;
    public static final String LOCK_FILENAME = ".lck";
    public static final String MESSAGE_BACKUP_FILE_EXTENSION = ".bup";
    public static final String MESSAGE_FILE_EXTENSION = ".msg";
    public File clientDir;
    public File dataDir;
    public FileLock fileLock;

    public MqttDefaultFilePersistence() {
        this(System.getProperty(SystemUtils.USER_DIR_KEY));
    }

    private void checkIsOpen() throws MqttPersistenceException {
        if (this.clientDir == null) {
            throw new MqttPersistenceException();
        }
    }

    public static FilenameFilter getFilenameFilter() {
        if (FILENAME_FILTER == null) {
            FILENAME_FILTER = new PersistanceFileNameFilter(MESSAGE_FILE_EXTENSION);
        }
        return FILENAME_FILTER;
    }

    private File[] getFiles() throws MqttPersistenceException {
        checkIsOpen();
        File[] listFiles = this.clientDir.listFiles(getFilenameFilter());
        if (listFiles != null) {
            return listFiles;
        }
        throw new MqttPersistenceException();
    }

    private boolean isSafeChar(char c2) {
        return Character.isJavaIdentifierPart(c2) || c2 == '-';
    }

    private void restoreBackups(File file) throws MqttPersistenceException {
        File[] listFiles = file.listFiles(new PersistanceFileFilter(MESSAGE_BACKUP_FILE_EXTENSION));
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                File file2 = new File(file, listFiles[i].getName().substring(0, listFiles[i].getName().length() - 4));
                if (!listFiles[i].renameTo(file2)) {
                    file2.delete();
                    listFiles[i].renameTo(file2);
                }
            }
            return;
        }
        throw new MqttPersistenceException();
    }

    public void clear() throws MqttPersistenceException {
        checkIsOpen();
        File[] files = getFiles();
        for (File delete : files) {
            delete.delete();
        }
        this.clientDir.delete();
    }

    public void close() throws MqttPersistenceException {
        synchronized (this) {
            if (this.fileLock != null) {
                this.fileLock.release();
            }
            if (getFiles().length == 0) {
                this.clientDir.delete();
            }
            this.clientDir = null;
        }
    }

    public boolean containsKey(String str) throws MqttPersistenceException {
        checkIsOpen();
        File file = this.clientDir;
        return new File(file, String.valueOf(str) + MESSAGE_FILE_EXTENSION).exists();
    }

    public MqttPersistable get(String str) throws MqttPersistenceException {
        checkIsOpen();
        try {
            File file = this.clientDir;
            FileInputStream fileInputStream = new FileInputStream(new File(file, String.valueOf(str) + MESSAGE_FILE_EXTENSION));
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            for (int i = 0; i < available; i += fileInputStream.read(bArr, i, available - i)) {
            }
            fileInputStream.close();
            MqttPersistentData mqttPersistentData = new MqttPersistentData(str, bArr, 0, available, null, 0, 0);
            return mqttPersistentData;
        } catch (IOException e2) {
            throw new MqttPersistenceException((Throwable) e2);
        }
    }

    public Enumeration keys() throws MqttPersistenceException {
        String name;
        checkIsOpen();
        File[] files = getFiles();
        Vector vector = new Vector(files.length);
        for (File name2 : files) {
            vector.addElement(name.substring(0, name2.getName().length() - 4));
        }
        return vector.elements();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:21|22|(2:24|(1:26))|27|28|29|30|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0076 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void open(java.lang.String r6, java.lang.String r7) throws org.eclipse.paho.client.mqttv3.MqttPersistenceException {
        /*
            r5 = this;
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0017
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.isDirectory()
            if (r0 == 0) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            org.eclipse.paho.client.mqttv3.MqttPersistenceException r6 = new org.eclipse.paho.client.mqttv3.MqttPersistenceException
            r6.<init>()
            throw r6
        L_0x0017:
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x002e
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.mkdirs()
            if (r0 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            org.eclipse.paho.client.mqttv3.MqttPersistenceException r6 = new org.eclipse.paho.client.mqttv3.MqttPersistenceException
            r6.<init>()
            throw r6
        L_0x002e:
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.canWrite()
            if (r0 == 0) goto L_0x00a0
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x003d:
            int r3 = r6.length()
            if (r2 < r3) goto L_0x0090
            java.lang.String r6 = "-"
            r0.append(r6)
        L_0x0048:
            int r6 = r7.length()
            if (r1 < r6) goto L_0x0080
            monitor-enter(r5)
            java.io.File r6 = r5.clientDir     // Catch:{ all -> 0x007d }
            if (r6 != 0) goto L_0x006b
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x007d }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x007d }
            java.io.File r0 = r5.dataDir     // Catch:{ all -> 0x007d }
            r7.<init>(r0, r6)     // Catch:{ all -> 0x007d }
            r5.clientDir = r7     // Catch:{ all -> 0x007d }
            boolean r6 = r7.exists()     // Catch:{ all -> 0x007d }
            if (r6 != 0) goto L_0x006b
            java.io.File r6 = r5.clientDir     // Catch:{ all -> 0x007d }
            r6.mkdir()     // Catch:{ all -> 0x007d }
        L_0x006b:
            org.eclipse.paho.client.mqttv3.internal.FileLock r6 = new org.eclipse.paho.client.mqttv3.internal.FileLock     // Catch:{ Exception -> 0x0076 }
            java.io.File r7 = r5.clientDir     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = ".lck"
            r6.<init>(r7, r0)     // Catch:{ Exception -> 0x0076 }
            r5.fileLock = r6     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            java.io.File r6 = r5.clientDir     // Catch:{ all -> 0x007d }
            r5.restoreBackups(r6)     // Catch:{ all -> 0x007d }
            monitor-exit(r5)     // Catch:{ all -> 0x007d }
            return
        L_0x007d:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007d }
            throw r6
        L_0x0080:
            char r6 = r7.charAt(r1)
            boolean r2 = r5.isSafeChar(r6)
            if (r2 == 0) goto L_0x008d
            r0.append(r6)
        L_0x008d:
            int r1 = r1 + 1
            goto L_0x0048
        L_0x0090:
            char r3 = r6.charAt(r2)
            boolean r4 = r5.isSafeChar(r3)
            if (r4 == 0) goto L_0x009d
            r0.append(r3)
        L_0x009d:
            int r2 = r2 + 1
            goto L_0x003d
        L_0x00a0:
            org.eclipse.paho.client.mqttv3.MqttPersistenceException r6 = new org.eclipse.paho.client.mqttv3.MqttPersistenceException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence.open(java.lang.String, java.lang.String):void");
    }

    public void put(String str, MqttPersistable mqttPersistable) throws MqttPersistenceException {
        checkIsOpen();
        File file = this.clientDir;
        File file2 = new File(file, String.valueOf(str) + MESSAGE_FILE_EXTENSION);
        File file3 = new File(this.clientDir, GeneratedOutlineSupport.outline62(new StringBuilder(String.valueOf(str)), MESSAGE_FILE_EXTENSION, MESSAGE_BACKUP_FILE_EXTENSION));
        if (file2.exists() && !file2.renameTo(file3)) {
            file3.delete();
            file2.renameTo(file3);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(mqttPersistable.getHeaderBytes(), mqttPersistable.getHeaderOffset(), mqttPersistable.getHeaderLength());
            if (mqttPersistable.getPayloadBytes() != null) {
                fileOutputStream.write(mqttPersistable.getPayloadBytes(), mqttPersistable.getPayloadOffset(), mqttPersistable.getPayloadLength());
            }
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            if (file3.exists()) {
                file3.delete();
            }
            if (file3.exists() && !file3.renameTo(file2)) {
                file2.delete();
                file3.renameTo(file2);
            }
        } catch (IOException e2) {
            throw new MqttPersistenceException((Throwable) e2);
        } catch (Throwable th) {
            if (file3.exists() && !file3.renameTo(file2)) {
                file2.delete();
                file3.renameTo(file2);
            }
            throw th;
        }
    }

    public void remove(String str) throws MqttPersistenceException {
        checkIsOpen();
        File file = this.clientDir;
        File file2 = new File(file, String.valueOf(str) + MESSAGE_FILE_EXTENSION);
        if (file2.exists()) {
            file2.delete();
        }
    }

    public MqttDefaultFilePersistence(String str) {
        this.clientDir = null;
        this.fileLock = null;
        this.dataDir = new File(str);
    }
}
