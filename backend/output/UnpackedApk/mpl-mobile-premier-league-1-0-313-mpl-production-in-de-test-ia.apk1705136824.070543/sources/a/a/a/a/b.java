package a.a.a.a;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

public class b extends EntityInsertionAdapter<l> {
    public b(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
        l lVar = (l) obj;
        supportSQLiteStatement.bindLong(1, lVar.f2430a);
        String str = lVar.f2431b;
        if (str == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, str);
        }
        String str2 = lVar.f2432c;
        if (str2 == null) {
            supportSQLiteStatement.bindNull(3);
        } else {
            supportSQLiteStatement.bindString(3, str2);
        }
        String str3 = lVar.f2433d;
        if (str3 == null) {
            supportSQLiteStatement.bindNull(4);
        } else {
            supportSQLiteStatement.bindString(4, str3);
        }
        String str4 = lVar.f2434e;
        if (str4 == null) {
            supportSQLiteStatement.bindNull(5);
        } else {
            supportSQLiteStatement.bindString(5, str4);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `events` (`_ID`,`key`,`value`,`timeStamp`,`state`) VALUES (nullif(?, 0),?,?,?,?)";
    }
}
