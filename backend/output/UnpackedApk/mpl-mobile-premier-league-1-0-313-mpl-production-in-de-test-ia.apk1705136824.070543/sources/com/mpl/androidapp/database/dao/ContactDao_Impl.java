package com.mpl.androidapp.database.dao;

import android.database.Cursor;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.facebook.react.bridge.ColorPropConverter;
import com.mpl.androidapp.database.entity.Contact;
import com.paynimo.android.payment.UPIFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ContactDao_Impl implements ContactDao {
    public final RoomDatabase __db;
    public final EntityDeletionOrUpdateAdapter<Contact> __deletionAdapterOfContact;
    public final EntityInsertionAdapter<Contact> __insertionAdapterOfContact;
    public final SharedSQLiteStatement __preparedStmtOfDeleteAllContact;
    public final EntityDeletionOrUpdateAdapter<Contact> __updateAdapterOfContact;

    public ContactDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfContact = new EntityInsertionAdapter<Contact>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `contacts` (`_ID`,`number`,`type`,`id`,`lookup_key`,`name`,`display_name`,`given_name`,`family_name`,`mpl_contact`,`mpl_name`,`mpl_id`,`isSync`,`isOnline`,`lastSeen`,`lastUpdateTimeStamp`,`photo_thumb_uri`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Contact contact) {
                supportSQLiteStatement.bindLong(1, (long) contact.getId());
                if (contact.getPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, contact.getPhoneNumber());
                }
                if (contact.getContactType() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, contact.getContactType());
                }
                if (contact.getContactId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, contact.getContactId());
                }
                if (contact.getContactLookupKey() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, contact.getContactLookupKey());
                }
                if (contact.getContactName() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, contact.getContactName());
                }
                if (contact.getContactDisplayName() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, contact.getContactDisplayName());
                }
                if (contact.getContactGivenName() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, contact.getContactGivenName());
                }
                if (contact.getContactFamilyName() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, contact.getContactFamilyName());
                }
                Integer num = null;
                Integer valueOf = contact.isMplContact() == null ? null : Integer.valueOf(contact.isMplContact().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, (long) valueOf.intValue());
                }
                if (contact.getMplContactName() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, contact.getMplContactName());
                }
                if (contact.getMplId() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, contact.getMplId());
                }
                Integer valueOf2 = contact.isSync() == null ? null : Integer.valueOf(contact.isSync().booleanValue() ? 1 : 0);
                if (valueOf2 == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, (long) valueOf2.intValue());
                }
                if (contact.isOnline() != null) {
                    num = Integer.valueOf(contact.isOnline().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, (long) num.intValue());
                }
                if (contact.getLastSeen() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, contact.getLastSeen());
                }
                if (contact.getLastUpdateTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, contact.getLastUpdateTimeStamp());
                }
                if (contact.getPhotoThumbUri() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, contact.getPhotoThumbUri());
                }
            }
        };
        this.__deletionAdapterOfContact = new EntityDeletionOrUpdateAdapter<Contact>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `contacts` WHERE `_ID` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Contact contact) {
                supportSQLiteStatement.bindLong(1, (long) contact.getId());
            }
        };
        this.__updateAdapterOfContact = new EntityDeletionOrUpdateAdapter<Contact>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `contacts` SET `_ID` = ?,`number` = ?,`type` = ?,`id` = ?,`lookup_key` = ?,`name` = ?,`display_name` = ?,`given_name` = ?,`family_name` = ?,`mpl_contact` = ?,`mpl_name` = ?,`mpl_id` = ?,`isSync` = ?,`isOnline` = ?,`lastSeen` = ?,`lastUpdateTimeStamp` = ?,`photo_thumb_uri` = ? WHERE `_ID` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Contact contact) {
                supportSQLiteStatement.bindLong(1, (long) contact.getId());
                if (contact.getPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, contact.getPhoneNumber());
                }
                if (contact.getContactType() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, contact.getContactType());
                }
                if (contact.getContactId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, contact.getContactId());
                }
                if (contact.getContactLookupKey() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, contact.getContactLookupKey());
                }
                if (contact.getContactName() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, contact.getContactName());
                }
                if (contact.getContactDisplayName() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, contact.getContactDisplayName());
                }
                if (contact.getContactGivenName() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, contact.getContactGivenName());
                }
                if (contact.getContactFamilyName() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, contact.getContactFamilyName());
                }
                Integer num = null;
                Integer valueOf = contact.isMplContact() == null ? null : Integer.valueOf(contact.isMplContact().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, (long) valueOf.intValue());
                }
                if (contact.getMplContactName() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, contact.getMplContactName());
                }
                if (contact.getMplId() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, contact.getMplId());
                }
                Integer valueOf2 = contact.isSync() == null ? null : Integer.valueOf(contact.isSync().booleanValue() ? 1 : 0);
                if (valueOf2 == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, (long) valueOf2.intValue());
                }
                if (contact.isOnline() != null) {
                    num = Integer.valueOf(contact.isOnline().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, (long) num.intValue());
                }
                if (contact.getLastSeen() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, contact.getLastSeen());
                }
                if (contact.getLastUpdateTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, contact.getLastUpdateTimeStamp());
                }
                if (contact.getPhotoThumbUri() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, contact.getPhotoThumbUri());
                }
                supportSQLiteStatement.bindLong(18, (long) contact.getId());
            }
        };
        this.__preparedStmtOfDeleteAllContact = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE  from contacts";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(Contact contact) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfContact.handle(contact);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAllContact() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllContact.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllContact.release(acquire);
        }
    }

    public int deleteByContactId(List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM contacts WHERE id NOT IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(sb.toString());
        int i = 1;
        for (String next : list) {
            if (next == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, next);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }

    public List<Contact> getAllContacts() {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Integer num;
        Boolean bool;
        String str9;
        String str10;
        Integer num2;
        Boolean bool2;
        Integer num3;
        int i;
        Boolean bool3;
        int i2;
        String str11;
        String str12;
        String str13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM contacts", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, UPIFragment.CONFIG_TYPE_NUMBER);
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lookup_key");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "display_name");
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "given_name");
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "family_name");
            int columnIndexOrThrow10 = CompoundButtonCompat.getColumnIndexOrThrow(query, "mpl_contact");
            int columnIndexOrThrow11 = CompoundButtonCompat.getColumnIndexOrThrow(query, "mpl_name");
            int columnIndexOrThrow12 = CompoundButtonCompat.getColumnIndexOrThrow(query, "mpl_id");
            int columnIndexOrThrow13 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isSync");
            int columnIndexOrThrow14 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isOnline");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lastSeen");
                int columnIndexOrThrow16 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lastUpdateTimeStamp");
                int columnIndexOrThrow17 = CompoundButtonCompat.getColumnIndexOrThrow(query, "photo_thumb_uri");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    Contact contact = new Contact();
                    ArrayList arrayList2 = arrayList;
                    contact.setId(query.getInt(columnIndexOrThrow));
                    if (query.isNull(columnIndexOrThrow2)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow2);
                    }
                    contact.setPhoneNumber(str);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    contact.setContactType(str2);
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    contact.setContactId(str3);
                    if (query.isNull(columnIndexOrThrow5)) {
                        str4 = null;
                    } else {
                        str4 = query.getString(columnIndexOrThrow5);
                    }
                    contact.setContactLookupKey(str4);
                    if (query.isNull(columnIndexOrThrow6)) {
                        str5 = null;
                    } else {
                        str5 = query.getString(columnIndexOrThrow6);
                    }
                    contact.setContactName(str5);
                    if (query.isNull(columnIndexOrThrow7)) {
                        str6 = null;
                    } else {
                        str6 = query.getString(columnIndexOrThrow7);
                    }
                    contact.setContactDisplayName(str6);
                    if (query.isNull(columnIndexOrThrow8)) {
                        str7 = null;
                    } else {
                        str7 = query.getString(columnIndexOrThrow8);
                    }
                    contact.setContactGivenName(str7);
                    if (query.isNull(columnIndexOrThrow9)) {
                        str8 = null;
                    } else {
                        str8 = query.getString(columnIndexOrThrow9);
                    }
                    contact.setContactFamilyName(str8);
                    if (query.isNull(columnIndexOrThrow10)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    }
                    boolean z = true;
                    if (num == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(num.intValue() != 0);
                    }
                    contact.setMplContact(bool);
                    if (query.isNull(columnIndexOrThrow11)) {
                        str9 = null;
                    } else {
                        str9 = query.getString(columnIndexOrThrow11);
                    }
                    contact.setMplContactName(str9);
                    if (query.isNull(columnIndexOrThrow12)) {
                        str10 = null;
                    } else {
                        str10 = query.getString(columnIndexOrThrow12);
                    }
                    contact.setMplId(str10);
                    if (query.isNull(columnIndexOrThrow13)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                    }
                    if (num2 == null) {
                        bool2 = null;
                    } else {
                        bool2 = Boolean.valueOf(num2.intValue() != 0);
                    }
                    contact.setSync(bool2);
                    int i4 = i3;
                    if (query.isNull(i4)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(query.getInt(i4));
                    }
                    if (num3 == null) {
                        i = columnIndexOrThrow;
                        bool3 = null;
                    } else {
                        if (num3.intValue() == 0) {
                            z = false;
                        }
                        Boolean valueOf = Boolean.valueOf(z);
                        i = columnIndexOrThrow;
                        bool3 = valueOf;
                    }
                    contact.setOnline(bool3);
                    int i5 = columnIndexOrThrow15;
                    if (query.isNull(i5)) {
                        i2 = i5;
                        str11 = null;
                    } else {
                        i2 = i5;
                        str11 = query.getString(i5);
                    }
                    contact.setLastSeen(str11);
                    int i6 = columnIndexOrThrow16;
                    if (query.isNull(i6)) {
                        columnIndexOrThrow16 = i6;
                        str12 = null;
                    } else {
                        columnIndexOrThrow16 = i6;
                        str12 = query.getString(i6);
                    }
                    contact.setLastUpdateTimeStamp(str12);
                    int i7 = columnIndexOrThrow17;
                    if (query.isNull(i7)) {
                        columnIndexOrThrow17 = i7;
                        str13 = null;
                    } else {
                        columnIndexOrThrow17 = i7;
                        str13 = query.getString(i7);
                    }
                    contact.setPhotoThumbUri(str13);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(contact);
                    columnIndexOrThrow15 = i2;
                    i3 = i4;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public int getAllContactsCount() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT count(_ID) FROM contacts", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                i = query.getInt(0);
            }
            return i;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Contact> getAllMPLContacts() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT _ID,display_name,number,mpl_id,lastUpdateTimeStamp,photo_thumb_uri,lookup_key FROM contacts where mpl_id!='0'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(query.getInt(0));
                if (query.isNull(1)) {
                    str = null;
                } else {
                    str = query.getString(1);
                }
                contact.setContactDisplayName(str);
                if (query.isNull(2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(2);
                }
                contact.setPhoneNumber(str2);
                if (query.isNull(3)) {
                    str3 = null;
                } else {
                    str3 = query.getString(3);
                }
                contact.setMplId(str3);
                if (query.isNull(4)) {
                    str4 = null;
                } else {
                    str4 = query.getString(4);
                }
                contact.setLastUpdateTimeStamp(str4);
                if (query.isNull(5)) {
                    str5 = null;
                } else {
                    str5 = query.getString(5);
                }
                contact.setPhotoThumbUri(str5);
                if (query.isNull(6)) {
                    str6 = null;
                } else {
                    str6 = query.getString(6);
                }
                contact.setContactLookupKey(str6);
                arrayList.add(contact);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Contact> getAllNoNMPLContacts() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT _ID,display_name,number,mpl_id,lastUpdateTimeStamp,photo_thumb_uri,lookup_key FROM contacts where mpl_id ='' or mpl_id=' ' or mpl_id ='0'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(query.getInt(0));
                if (query.isNull(1)) {
                    str = null;
                } else {
                    str = query.getString(1);
                }
                contact.setContactDisplayName(str);
                if (query.isNull(2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(2);
                }
                contact.setPhoneNumber(str2);
                if (query.isNull(3)) {
                    str3 = null;
                } else {
                    str3 = query.getString(3);
                }
                contact.setMplId(str3);
                if (query.isNull(4)) {
                    str4 = null;
                } else {
                    str4 = query.getString(4);
                }
                contact.setLastUpdateTimeStamp(str4);
                if (query.isNull(5)) {
                    str5 = null;
                } else {
                    str5 = query.getString(5);
                }
                contact.setPhotoThumbUri(str5);
                if (query.isNull(6)) {
                    str6 = null;
                } else {
                    str6 = query.getString(6);
                }
                contact.setContactLookupKey(str6);
                arrayList.add(contact);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [com.mpl.androidapp.database.entity.Contact] */
    /* JADX WARNING: type inference failed for: r4v1, types: [com.mpl.androidapp.database.entity.Contact] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.lang.String]
      uses: [com.mpl.androidapp.database.entity.Contact, java.lang.String]
      mth insns count: 64
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mpl.androidapp.database.entity.Contact getContactBasedOnMplId(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "SELECT _ID,display_name,name,number,mpl_id,lastUpdateTimeStamp,photo_thumb_uri,lookup_key FROM contacts where mpl_id =?"
            r1 = 1
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            if (r6 != 0) goto L_0x000d
            r0.bindNull(r1)
            goto L_0x0010
        L_0x000d:
            r0.bindString(r1, r6)
        L_0x0010:
            androidx.room.RoomDatabase r6 = r5.__db
            r6.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r6 = r5.__db
            r2 = 0
            r3 = 0
            android.database.Cursor r6 = androidx.core.widget.CompoundButtonCompat.query(r6, r0, r2, r3)
            boolean r4 = r6.moveToFirst()     // Catch:{ all -> 0x00a5 }
            if (r4 == 0) goto L_0x009e
            com.mpl.androidapp.database.entity.Contact r4 = new com.mpl.androidapp.database.entity.Contact     // Catch:{ all -> 0x00a5 }
            r4.<init>()     // Catch:{ all -> 0x00a5 }
            int r2 = r6.getInt(r2)     // Catch:{ all -> 0x00a5 }
            r4.setId(r2)     // Catch:{ all -> 0x00a5 }
            boolean r2 = r6.isNull(r1)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0037
            r1 = r3
            goto L_0x003b
        L_0x0037:
            java.lang.String r1 = r6.getString(r1)     // Catch:{ all -> 0x00a5 }
        L_0x003b:
            r4.setContactDisplayName(r1)     // Catch:{ all -> 0x00a5 }
            r1 = 2
            boolean r2 = r6.isNull(r1)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0047
            r1 = r3
            goto L_0x004b
        L_0x0047:
            java.lang.String r1 = r6.getString(r1)     // Catch:{ all -> 0x00a5 }
        L_0x004b:
            r4.setContactName(r1)     // Catch:{ all -> 0x00a5 }
            r1 = 3
            boolean r2 = r6.isNull(r1)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0057
            r1 = r3
            goto L_0x005b
        L_0x0057:
            java.lang.String r1 = r6.getString(r1)     // Catch:{ all -> 0x00a5 }
        L_0x005b:
            r4.setPhoneNumber(r1)     // Catch:{ all -> 0x00a5 }
            r1 = 4
            boolean r2 = r6.isNull(r1)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0067
            r1 = r3
            goto L_0x006b
        L_0x0067:
            java.lang.String r1 = r6.getString(r1)     // Catch:{ all -> 0x00a5 }
        L_0x006b:
            r4.setMplId(r1)     // Catch:{ all -> 0x00a5 }
            r1 = 5
            boolean r2 = r6.isNull(r1)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0077
            r1 = r3
            goto L_0x007b
        L_0x0077:
            java.lang.String r1 = r6.getString(r1)     // Catch:{ all -> 0x00a5 }
        L_0x007b:
            r4.setLastUpdateTimeStamp(r1)     // Catch:{ all -> 0x00a5 }
            r1 = 6
            boolean r2 = r6.isNull(r1)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0087
            r1 = r3
            goto L_0x008b
        L_0x0087:
            java.lang.String r1 = r6.getString(r1)     // Catch:{ all -> 0x00a5 }
        L_0x008b:
            r4.setPhotoThumbUri(r1)     // Catch:{ all -> 0x00a5 }
            r1 = 7
            boolean r2 = r6.isNull(r1)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x0096
            goto L_0x009a
        L_0x0096:
            java.lang.String r3 = r6.getString(r1)     // Catch:{ all -> 0x00a5 }
        L_0x009a:
            r4.setContactLookupKey(r3)     // Catch:{ all -> 0x00a5 }
            r3 = r4
        L_0x009e:
            r6.close()
            r0.release()
            return r3
        L_0x00a5:
            r1 = move-exception
            r6.close()
            r0.release()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.database.dao.ContactDao_Impl.getContactBasedOnMplId(java.lang.String):com.mpl.androidapp.database.entity.Contact");
    }

    public List<Contact> getContactsBasedOnMplId(String[] strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT _ID,display_name,number,mpl_id,lastUpdateTimeStamp,photo_thumb_uri,lookup_key FROM contacts where mpl_id IN(");
        int length = strArr.length;
        StringUtil.appendPlaceholders(sb, length);
        sb.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(sb.toString(), length + 0);
        int i = 1;
        for (String str7 : strArr) {
            if (str7 == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str7);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(query.getInt(0));
                if (query.isNull(1)) {
                    str = null;
                } else {
                    str = query.getString(1);
                }
                contact.setContactDisplayName(str);
                if (query.isNull(2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(2);
                }
                contact.setPhoneNumber(str2);
                if (query.isNull(3)) {
                    str3 = null;
                } else {
                    str3 = query.getString(3);
                }
                contact.setMplId(str3);
                if (query.isNull(4)) {
                    str4 = null;
                } else {
                    str4 = query.getString(4);
                }
                contact.setLastUpdateTimeStamp(str4);
                if (query.isNull(5)) {
                    str5 = null;
                } else {
                    str5 = query.getString(5);
                }
                contact.setPhotoThumbUri(str5);
                if (query.isNull(6)) {
                    str6 = null;
                } else {
                    str6 = query.getString(6);
                }
                contact.setContactLookupKey(str6);
                arrayList.add(contact);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Contact> getContactsForReactSync() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT _ID,display_name,number,mpl_id,lastUpdateTimeStamp,photo_thumb_uri,lookup_key FROM contacts", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(query.getInt(0));
                if (query.isNull(1)) {
                    str = null;
                } else {
                    str = query.getString(1);
                }
                contact.setContactDisplayName(str);
                if (query.isNull(2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(2);
                }
                contact.setPhoneNumber(str2);
                if (query.isNull(3)) {
                    str3 = null;
                } else {
                    str3 = query.getString(3);
                }
                contact.setMplId(str3);
                if (query.isNull(4)) {
                    str4 = null;
                } else {
                    str4 = query.getString(4);
                }
                contact.setLastUpdateTimeStamp(str4);
                if (query.isNull(5)) {
                    str5 = null;
                } else {
                    str5 = query.getString(5);
                }
                contact.setPhotoThumbUri(str5);
                if (query.isNull(6)) {
                    str6 = null;
                } else {
                    str6 = query.getString(6);
                }
                contact.setContactLookupKey(str6);
                arrayList.add(contact);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Contact> getContactsForSyncServer() {
        String str;
        String str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT _ID,display_name,number FROM contacts", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(query.getInt(0));
                if (query.isNull(1)) {
                    str = null;
                } else {
                    str = query.getString(1);
                }
                contact.setContactDisplayName(str);
                if (query.isNull(2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(2);
                }
                contact.setPhoneNumber(str2);
                arrayList.add(contact);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Contact> getContactsNameFromLocal(List<String> list) {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT _ID,display_name,lookup_key,number FROM contacts WHERE lookup_key IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sb, size);
        sb.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(sb.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(query.getInt(0));
                if (query.isNull(1)) {
                    str = null;
                } else {
                    str = query.getString(1);
                }
                contact.setContactDisplayName(str);
                if (query.isNull(2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(2);
                }
                contact.setContactLookupKey(str2);
                if (query.isNull(3)) {
                    str3 = null;
                } else {
                    str3 = query.getString(3);
                }
                contact.setPhoneNumber(str3);
                arrayList.add(contact);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Contact> getContactsSearchBasedOnName(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Integer num;
        Boolean bool;
        String str10;
        String str11;
        Integer num2;
        Boolean bool2;
        Integer num3;
        int i;
        Boolean bool3;
        int i2;
        String str12;
        String str13;
        String str14;
        String str15 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM contacts WHERE display_name LIKE '%' || ? || '%' or name LIKE '%' || ? || '%'", 2);
        if (str15 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str15);
        }
        if (str15 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str15);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, UPIFragment.CONFIG_TYPE_NUMBER);
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lookup_key");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "display_name");
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "given_name");
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "family_name");
            int columnIndexOrThrow10 = CompoundButtonCompat.getColumnIndexOrThrow(query, "mpl_contact");
            int columnIndexOrThrow11 = CompoundButtonCompat.getColumnIndexOrThrow(query, "mpl_name");
            int columnIndexOrThrow12 = CompoundButtonCompat.getColumnIndexOrThrow(query, "mpl_id");
            int columnIndexOrThrow13 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isSync");
            int columnIndexOrThrow14 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isOnline");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lastSeen");
                int columnIndexOrThrow16 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lastUpdateTimeStamp");
                int columnIndexOrThrow17 = CompoundButtonCompat.getColumnIndexOrThrow(query, "photo_thumb_uri");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    Contact contact = new Contact();
                    ArrayList arrayList2 = arrayList;
                    contact.setId(query.getInt(columnIndexOrThrow));
                    if (query.isNull(columnIndexOrThrow2)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow2);
                    }
                    contact.setPhoneNumber(str2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow3);
                    }
                    contact.setContactType(str3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        str4 = null;
                    } else {
                        str4 = query.getString(columnIndexOrThrow4);
                    }
                    contact.setContactId(str4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        str5 = null;
                    } else {
                        str5 = query.getString(columnIndexOrThrow5);
                    }
                    contact.setContactLookupKey(str5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        str6 = null;
                    } else {
                        str6 = query.getString(columnIndexOrThrow6);
                    }
                    contact.setContactName(str6);
                    if (query.isNull(columnIndexOrThrow7)) {
                        str7 = null;
                    } else {
                        str7 = query.getString(columnIndexOrThrow7);
                    }
                    contact.setContactDisplayName(str7);
                    if (query.isNull(columnIndexOrThrow8)) {
                        str8 = null;
                    } else {
                        str8 = query.getString(columnIndexOrThrow8);
                    }
                    contact.setContactGivenName(str8);
                    if (query.isNull(columnIndexOrThrow9)) {
                        str9 = null;
                    } else {
                        str9 = query.getString(columnIndexOrThrow9);
                    }
                    contact.setContactFamilyName(str9);
                    if (query.isNull(columnIndexOrThrow10)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    }
                    if (num == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(num.intValue() != 0);
                    }
                    contact.setMplContact(bool);
                    if (query.isNull(columnIndexOrThrow11)) {
                        str10 = null;
                    } else {
                        str10 = query.getString(columnIndexOrThrow11);
                    }
                    contact.setMplContactName(str10);
                    if (query.isNull(columnIndexOrThrow12)) {
                        str11 = null;
                    } else {
                        str11 = query.getString(columnIndexOrThrow12);
                    }
                    contact.setMplId(str11);
                    if (query.isNull(columnIndexOrThrow13)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                    }
                    if (num2 == null) {
                        bool2 = null;
                    } else {
                        bool2 = Boolean.valueOf(num2.intValue() != 0);
                    }
                    contact.setSync(bool2);
                    int i4 = i3;
                    if (query.isNull(i4)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(query.getInt(i4));
                    }
                    if (num3 == null) {
                        i = columnIndexOrThrow;
                        bool3 = null;
                    } else {
                        i = columnIndexOrThrow;
                        bool3 = Boolean.valueOf(num3.intValue() != 0);
                    }
                    contact.setOnline(bool3);
                    int i5 = columnIndexOrThrow15;
                    if (query.isNull(i5)) {
                        i2 = i5;
                        str12 = null;
                    } else {
                        i2 = i5;
                        str12 = query.getString(i5);
                    }
                    contact.setLastSeen(str12);
                    int i6 = columnIndexOrThrow16;
                    if (query.isNull(i6)) {
                        columnIndexOrThrow16 = i6;
                        str13 = null;
                    } else {
                        columnIndexOrThrow16 = i6;
                        str13 = query.getString(i6);
                    }
                    contact.setLastUpdateTimeStamp(str13);
                    int i7 = columnIndexOrThrow17;
                    if (query.isNull(i7)) {
                        columnIndexOrThrow17 = i7;
                        str14 = null;
                    } else {
                        columnIndexOrThrow17 = i7;
                        str14 = query.getString(i7);
                    }
                    contact.setPhotoThumbUri(str14);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(contact);
                    columnIndexOrThrow15 = i2;
                    i3 = i4;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<Contact> getContactsSearchBasedOnNumber(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Integer num;
        Boolean bool;
        String str11;
        String str12;
        Integer num2;
        Boolean bool2;
        Integer num3;
        int i;
        Boolean bool3;
        int i2;
        String str13;
        String str14;
        String str15;
        String str16 = str;
        String str17 = str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM contacts WHERE number =? or number =?", 2);
        if (str16 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str16);
        }
        if (str17 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str17);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, UPIFragment.CONFIG_TYPE_NUMBER);
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lookup_key");
            int columnIndexOrThrow6 = CompoundButtonCompat.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow7 = CompoundButtonCompat.getColumnIndexOrThrow(query, "display_name");
            int columnIndexOrThrow8 = CompoundButtonCompat.getColumnIndexOrThrow(query, "given_name");
            int columnIndexOrThrow9 = CompoundButtonCompat.getColumnIndexOrThrow(query, "family_name");
            int columnIndexOrThrow10 = CompoundButtonCompat.getColumnIndexOrThrow(query, "mpl_contact");
            int columnIndexOrThrow11 = CompoundButtonCompat.getColumnIndexOrThrow(query, "mpl_name");
            int columnIndexOrThrow12 = CompoundButtonCompat.getColumnIndexOrThrow(query, "mpl_id");
            int columnIndexOrThrow13 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isSync");
            int columnIndexOrThrow14 = CompoundButtonCompat.getColumnIndexOrThrow(query, "isOnline");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lastSeen");
                int columnIndexOrThrow16 = CompoundButtonCompat.getColumnIndexOrThrow(query, "lastUpdateTimeStamp");
                int columnIndexOrThrow17 = CompoundButtonCompat.getColumnIndexOrThrow(query, "photo_thumb_uri");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    Contact contact = new Contact();
                    ArrayList arrayList2 = arrayList;
                    contact.setId(query.getInt(columnIndexOrThrow));
                    if (query.isNull(columnIndexOrThrow2)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow2);
                    }
                    contact.setPhoneNumber(str3);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str4 = null;
                    } else {
                        str4 = query.getString(columnIndexOrThrow3);
                    }
                    contact.setContactType(str4);
                    if (query.isNull(columnIndexOrThrow4)) {
                        str5 = null;
                    } else {
                        str5 = query.getString(columnIndexOrThrow4);
                    }
                    contact.setContactId(str5);
                    if (query.isNull(columnIndexOrThrow5)) {
                        str6 = null;
                    } else {
                        str6 = query.getString(columnIndexOrThrow5);
                    }
                    contact.setContactLookupKey(str6);
                    if (query.isNull(columnIndexOrThrow6)) {
                        str7 = null;
                    } else {
                        str7 = query.getString(columnIndexOrThrow6);
                    }
                    contact.setContactName(str7);
                    if (query.isNull(columnIndexOrThrow7)) {
                        str8 = null;
                    } else {
                        str8 = query.getString(columnIndexOrThrow7);
                    }
                    contact.setContactDisplayName(str8);
                    if (query.isNull(columnIndexOrThrow8)) {
                        str9 = null;
                    } else {
                        str9 = query.getString(columnIndexOrThrow8);
                    }
                    contact.setContactGivenName(str9);
                    if (query.isNull(columnIndexOrThrow9)) {
                        str10 = null;
                    } else {
                        str10 = query.getString(columnIndexOrThrow9);
                    }
                    contact.setContactFamilyName(str10);
                    if (query.isNull(columnIndexOrThrow10)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    }
                    if (num == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(num.intValue() != 0);
                    }
                    contact.setMplContact(bool);
                    if (query.isNull(columnIndexOrThrow11)) {
                        str11 = null;
                    } else {
                        str11 = query.getString(columnIndexOrThrow11);
                    }
                    contact.setMplContactName(str11);
                    if (query.isNull(columnIndexOrThrow12)) {
                        str12 = null;
                    } else {
                        str12 = query.getString(columnIndexOrThrow12);
                    }
                    contact.setMplId(str12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                    }
                    if (num2 == null) {
                        bool2 = null;
                    } else {
                        bool2 = Boolean.valueOf(num2.intValue() != 0);
                    }
                    contact.setSync(bool2);
                    int i4 = i3;
                    if (query.isNull(i4)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(query.getInt(i4));
                    }
                    if (num3 == null) {
                        i = columnIndexOrThrow;
                        bool3 = null;
                    } else {
                        i = columnIndexOrThrow;
                        bool3 = Boolean.valueOf(num3.intValue() != 0);
                    }
                    contact.setOnline(bool3);
                    int i5 = columnIndexOrThrow15;
                    if (query.isNull(i5)) {
                        i2 = i5;
                        str13 = null;
                    } else {
                        i2 = i5;
                        str13 = query.getString(i5);
                    }
                    contact.setLastSeen(str13);
                    int i6 = columnIndexOrThrow16;
                    if (query.isNull(i6)) {
                        columnIndexOrThrow16 = i6;
                        str14 = null;
                    } else {
                        columnIndexOrThrow16 = i6;
                        str14 = query.getString(i6);
                    }
                    contact.setLastUpdateTimeStamp(str14);
                    int i7 = columnIndexOrThrow17;
                    if (query.isNull(i7)) {
                        columnIndexOrThrow17 = i7;
                        str15 = null;
                    } else {
                        columnIndexOrThrow17 = i7;
                        str15 = query.getString(i7);
                    }
                    contact.setPhotoThumbUri(str15);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(contact);
                    columnIndexOrThrow15 = i2;
                    i3 = i4;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<Contact> getDeletedContactsBasedOnContactIds(List<String> list) {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT _ID,id,display_name,number,mpl_id FROM contacts WHERE id NOT IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sb, size);
        sb.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(sb.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(query.getInt(0));
                if (query.isNull(1)) {
                    str = null;
                } else {
                    str = query.getString(1);
                }
                contact.setContactId(str);
                if (query.isNull(2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(2);
                }
                contact.setContactDisplayName(str2);
                if (query.isNull(3)) {
                    str3 = null;
                } else {
                    str3 = query.getString(3);
                }
                contact.setPhoneNumber(str3);
                if (query.isNull(4)) {
                    str4 = null;
                } else {
                    str4 = query.getString(4);
                }
                contact.setMplId(str4);
                arrayList.add(contact);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<Contact> getSingleContactBasedOnId(String str) {
        String str2;
        String str3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT _ID,lastUpdateTimeStamp,number FROM contacts where id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(query.getInt(0));
                if (query.isNull(1)) {
                    str2 = null;
                } else {
                    str2 = query.getString(1);
                }
                contact.setLastUpdateTimeStamp(str2);
                if (query.isNull(2)) {
                    str3 = null;
                } else {
                    str3 = query.getString(2);
                }
                contact.setPhoneNumber(str3);
                arrayList.add(contact);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insert(Contact contact) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfContact.insert(contact);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(Contact contact) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfContact.handle(contact);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void updateMplIds(String str, List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE contacts SET mpl_id=");
        sb.append(ColorPropConverter.PREFIX_ATTR);
        sb.append(" WHERE lookup_key IN (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(sb.toString());
        if (str == null) {
            compileStatement.bindNull(1);
        } else {
            compileStatement.bindString(1, str);
        }
        int i = 2;
        for (String next : list) {
            if (next == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, next);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
