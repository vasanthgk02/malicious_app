package okhttp3.internal.authenticator;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;
import okhttp3.Dns;
import okhttp3.HttpUrl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/authenticator/JavaNetAuthenticator;", "Lokhttp3/Authenticator;", "defaultDns", "Lokhttp3/Dns;", "(Lokhttp3/Dns;)V", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "connectToInetAddress", "Ljava/net/InetAddress;", "Ljava/net/Proxy;", "url", "Lokhttp3/HttpUrl;", "dns", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: JavaNetAuthenticator.kt */
public final class JavaNetAuthenticator implements Authenticator {
    public final Dns defaultDns;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Type.DIRECT.ordinal()] = 1;
        }
    }

    public JavaNetAuthenticator() {
        this(null, 1, null);
    }

    public JavaNetAuthenticator(Dns dns) {
        Intrinsics.checkNotNullParameter(dns, "defaultDns");
        this.defaultDns = dns;
    }

    private final InetAddress connectToInetAddress(Proxy proxy, HttpUrl httpUrl, Dns dns) throws IOException {
        Type type = proxy.type();
        if (type != null && WhenMappings.$EnumSwitchMapping$0[type.ordinal()] == 1) {
            return (InetAddress) ArraysKt___ArraysJvmKt.first(dns.lookup(httpUrl.host()));
        }
        SocketAddress address = proxy.address();
        if (address != null) {
            InetAddress address2 = ((InetSocketAddress) address).getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "(address() as InetSocketAddress).address");
            return address2;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r8 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        if (r6 != null) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Request authenticate(okhttp3.Route r20, okhttp3.Response r21) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = "response"
            r2 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.util.List r1 = r21.challenges()
            okhttp3.Request r3 = r21.request()
            okhttp3.HttpUrl r4 = r3.url()
            int r2 = r21.code()
            r5 = 1
            r6 = 407(0x197, float:5.7E-43)
            if (r2 != r6) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r20 == 0) goto L_0x002a
            java.net.Proxy r6 = r20.proxy()
            if (r6 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            java.net.Proxy r6 = java.net.Proxy.NO_PROXY
        L_0x002c:
            java.util.Iterator r1 = r1.iterator()
        L_0x0030:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00f6
            java.lang.Object r7 = r1.next()
            okhttp3.Challenge r7 = (okhttp3.Challenge) r7
            java.lang.String r8 = r7.scheme()
            java.lang.String r9 = "Basic"
            boolean r8 = kotlin.text.CharsKt__CharKt.equals(r9, r8, r5)
            if (r8 != 0) goto L_0x0049
            goto L_0x0030
        L_0x0049:
            if (r20 == 0) goto L_0x0058
            okhttp3.Address r8 = r20.address()
            if (r8 == 0) goto L_0x0058
            okhttp3.Dns r8 = r8.dns()
            if (r8 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            okhttp3.Dns r8 = r0.defaultDns
        L_0x005a:
            java.lang.String r9 = "proxy"
            if (r2 == 0) goto L_0x0094
            java.net.SocketAddress r10 = r6.address()
            if (r10 == 0) goto L_0x008c
            java.net.InetSocketAddress r10 = (java.net.InetSocketAddress) r10
            java.lang.String r11 = r10.getHostName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            java.net.InetAddress r12 = r0.connectToInetAddress(r6, r4, r8)
            int r13 = r10.getPort()
            java.lang.String r14 = r4.scheme()
            java.lang.String r15 = r7.realm()
            java.lang.String r16 = r7.scheme()
            java.net.URL r17 = r4.url()
            java.net.Authenticator$RequestorType r18 = java.net.Authenticator.RequestorType.PROXY
            java.net.PasswordAuthentication r8 = java.net.Authenticator.requestPasswordAuthentication(r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x00c1
        L_0x008c:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type java.net.InetSocketAddress"
            r1.<init>(r2)
            throw r1
        L_0x0094:
            java.lang.String r10 = r4.host()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            java.net.InetAddress r9 = r0.connectToInetAddress(r6, r4, r8)
            int r11 = r4.port()
            java.lang.String r12 = r4.scheme()
            java.lang.String r13 = r7.realm()
            java.lang.String r14 = r7.scheme()
            java.net.URL r15 = r4.url()
            java.net.Authenticator$RequestorType r16 = java.net.Authenticator.RequestorType.SERVER
            r8 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r16
            java.net.PasswordAuthentication r8 = java.net.Authenticator.requestPasswordAuthentication(r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x00c1:
            if (r8 == 0) goto L_0x0030
            if (r2 == 0) goto L_0x00c8
            java.lang.String r1 = "Proxy-Authorization"
            goto L_0x00ca
        L_0x00c8:
            java.lang.String r1 = "Authorization"
        L_0x00ca:
            java.lang.String r2 = r8.getUserName()
            java.lang.String r4 = "auth.userName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            char[] r4 = r8.getPassword()
            java.lang.String r5 = "auth.password"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            java.nio.charset.Charset r4 = r7.charset()
            java.lang.String r2 = okhttp3.Credentials.basic(r2, r5, r4)
            okhttp3.Request$Builder r3 = r3.newBuilder()
            okhttp3.Request$Builder r1 = r3.header(r1, r2)
            okhttp3.Request r1 = r1.build()
            return r1
        L_0x00f6:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.authenticator.JavaNetAuthenticator.authenticate(okhttp3.Route, okhttp3.Response):okhttp3.Request");
    }

    public /* synthetic */ JavaNetAuthenticator(Dns dns, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dns.SYSTEM : dns);
    }
}
