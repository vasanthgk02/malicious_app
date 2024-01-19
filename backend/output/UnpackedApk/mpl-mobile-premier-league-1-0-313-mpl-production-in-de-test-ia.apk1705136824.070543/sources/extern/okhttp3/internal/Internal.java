package extern.okhttp3.internal;

import extern.okhttp3.Address;
import extern.okhttp3.Call;
import extern.okhttp3.ConnectionPool;
import extern.okhttp3.ConnectionSpec;
import extern.okhttp3.Headers.Builder;
import extern.okhttp3.OkHttpClient;
import extern.okhttp3.Request;
import extern.okhttp3.Response;
import extern.okhttp3.Route;
import extern.okhttp3.internal.cache.InternalCache;
import extern.okhttp3.internal.connection.RealConnection;
import extern.okhttp3.internal.connection.RouteDatabase;
import extern.okhttp3.internal.connection.StreamAllocation;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

public abstract class Internal {
    public static Internal instance;

    public abstract void addLenient(Builder builder, String str);

    public abstract void addLenient(Builder builder, String str, String str2);

    public abstract void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    public abstract int code(Response.Builder builder);

    public abstract boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    public abstract boolean equalsNonHost(Address address, Address address2);

    public abstract RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route);

    public abstract boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException);

    public abstract Call newWebSocketCall(OkHttpClient okHttpClient, Request request);

    public abstract void put(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract RouteDatabase routeDatabase(ConnectionPool connectionPool);

    public abstract void setCache(OkHttpClient.Builder builder, InternalCache internalCache);

    public abstract StreamAllocation streamAllocation(Call call);

    @Nullable
    public abstract IOException timeoutExit(Call call, @Nullable IOException iOException);

    public static void initializeInstanceForTests() {
        new OkHttpClient();
    }
}
