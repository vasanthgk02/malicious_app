package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.identity.auth.device.AuthError;
import com.crimzoncode.tqcontests.util.TQConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: ao  reason: default package */
public final class ao extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final long f2750a = TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: a  reason: collision with other field name */
    public static final String f59a = ao.class.getName();

    public ao(Context context) {
        super(context, "MAPDataStore.db", null, 9);
        cp.a(f59a, (String) "DatabaseHelper created ver=9", (String) "MAP_DB_NAME=MAPDataStore.db");
    }

    public static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    public static Date a(String str) throws ParseException {
        if (str.endsWith("Z")) {
            return a().parse(str);
        }
        return new SimpleDateFormat(TQConstants.SERVER_DATE_FORMAT, Locale.US).parse(str);
    }

    public static Date a(Date date) {
        if (date == null) {
            return null;
        }
        long time = date.getTime();
        long j = f2750a;
        date.setTime((time / j) * j);
        return date;
    }

    public static void a(Context context) {
        cp.c(f59a, "Clearing Authorization Locally");
        am.a(context).a();
        an.a(context).a();
        aq.a(context).a();
        ap.a(context).a();
    }

    public static void b(Context context) throws AuthError {
        new ci<Bundle>() {
            public Object a(Context context, k kVar) throws AuthError, RemoteException {
                cp.c(ao.f59a, "Clearing Authorization via Service");
                Bundle a2 = kVar.a(null, context.getPackageName());
                if (a2 == null || !a2.containsKey(AuthError.AUTH_ERROR_EXECEPTION)) {
                    return new Bundle();
                }
                throw AuthError.extractError(a2);
            }
        }.a(context, new ac());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        cp.c(f59a, "onCreate called");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AppInfo (AppFamilyId TEXT NOT NULL, PackageName TEXT NOT NULL, AllowedScopes TEXT, GrantedPermissions TEXT, ClientId TEXT, AppVariantId TEXT,AuthzHost TEXT, ExchangeHost TEXT, Payload TEXT,UNIQUE (PackageName), PRIMARY KEY (AppVariantId))");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS app_info_index_pkg_name ON AppInfo (PackageName)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS app_info_index_app_variant_id ON AppInfo (AppVariantId)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS RequestedScope (Scope TEXT NOT NULL, AppId TEXT NOT NULL, DirectedId TEXT, AtzAccessTokenId INTEGER NOT NULL, AtzRefreshTokenId INTEGER NOT NULL, PRIMARY KEY (Scope,AppId,AtzAccessTokenId,AtzRefreshTokenId))");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_scope ON RequestedScope (Scope)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_app_id ON RequestedScope (AppId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_atz_access_token_id ON RequestedScope (AtzAccessTokenId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_directed_id ON RequestedScope (DirectedId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_atz_refresh_token_id ON RequestedScope (AtzRefreshTokenId)");
        sQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS requested_scope_valid_atz_access_token_id BEFORE INSERT ON RequestedScope FOR EACH ROW BEGIN SELECT CASE WHEN (new.AtzAccessTokenId != " + b.UNKNOWN.f54a + " AND new." + "AtzAccessTokenId" + " != " + b.REJECTED.f54a + " AND new." + "AtzAccessTokenId" + " < " + b.GRANTED_LOCALLY.f54a + ") THEN RAISE(ABORT, 'Invalid authorization token ID') END; END;");
        sQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS requested_scope_valid_atz_refresh_token_id BEFORE INSERT ON RequestedScope FOR EACH ROW BEGIN SELECT CASE WHEN (new.AtzRefreshTokenId != " + b.UNKNOWN.f54a + " AND new." + "AtzRefreshTokenId" + " != " + b.REJECTED.f54a + " AND new." + "AtzRefreshTokenId" + " < " + b.GRANTED_LOCALLY.f54a + ") THEN RAISE(ABORT, 'Invalid authorization token ID') END; END;");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AuthorizationToken (Id INTEGER PRIMARY KEY AUTOINCREMENT, AppId TEXT NOT NULL, Token TEXT NOT NULL, CreationTime DATETIME NOT NULL, ExpirationTime DATETIME NOT NULL, MiscData BLOB, type INTEGER NOT NULL, directedId TEXT )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS authz_token_index_app_id ON AuthorizationToken (AppId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS authz_token_index_directed_id ON AuthorizationToken (directedId)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AuthorizationCode (Id INTEGER PRIMARY KEY AUTOINCREMENT, Code TEXT NOT NULL, AppId TEXT NOT NULL, AuthorizationTokenId INTEGER NOT NULL )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS authz_code_index_app_id ON AuthorizationCode (AppId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS authz_code_index_token_id ON AuthorizationCode (AuthorizationTokenId)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Profile (Id INTEGER PRIMARY KEY AUTOINCREMENT, ExpirationTime DATETIME NOT NULL, AppId TEXT NOT NULL, Data TEXT NOT NULL )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS profile_index_app_id ON Profile (AppId)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String str = f59a;
        cp.c(str, "onUpgrade called old=" + i + " new=" + i2);
        if (i < 4 && i2 >= 4) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AuthorizationToken");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS RequestedScope");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS RequestedScope.requested_scope_index_directed_id");
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS RequestedScope.requested_scope_index_atz_token_id");
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS requested_scope_valid_atz_token_id");
        }
        if (i < 6 && i2 >= 6) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
        }
        if ((i < 8 && i2 >= 8) || (i < 9 && i2 >= 9)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
        }
        if (i2 <= 9) {
            onCreate(sQLiteDatabase);
            return;
        }
        throw new IllegalStateException("Database version was updated, but no upgrade was done ver=8");
    }
}
