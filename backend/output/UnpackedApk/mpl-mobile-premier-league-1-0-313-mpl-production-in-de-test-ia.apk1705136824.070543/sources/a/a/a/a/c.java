package a.a.a.a;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

public class c extends SharedSQLiteStatement {
    public c(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public String createQuery() {
        return "delete FROM events";
    }
}
