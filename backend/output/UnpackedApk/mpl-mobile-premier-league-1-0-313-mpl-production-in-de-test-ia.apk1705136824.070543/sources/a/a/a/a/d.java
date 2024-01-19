package a.a.a.a;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

public class d extends SharedSQLiteStatement {
    public d(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public String createQuery() {
        return "delete FROM events where `key`==?";
    }
}
