package a.a.a.a;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

public class f extends SharedSQLiteStatement {
    public f(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public String createQuery() {
        return "delete FROM events where _ID > ? and _ID <=?";
    }
}
