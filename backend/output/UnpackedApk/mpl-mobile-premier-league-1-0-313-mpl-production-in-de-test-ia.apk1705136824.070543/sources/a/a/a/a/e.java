package a.a.a.a;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

public class e extends SharedSQLiteStatement {
    public e(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public String createQuery() {
        return "delete FROM events where _ID <=?";
    }
}
