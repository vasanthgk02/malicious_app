package okhttp3;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import okhttp3.Cookie.Builder;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import sfs2x.client.entities.variables.SFSBuddyVariable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokhttp3/JavaNetCookieJar;", "Lokhttp3/CookieJar;", "cookieHandler", "Ljava/net/CookieHandler;", "(Ljava/net/CookieHandler;)V", "decodeHeaderAsJavaNetCookies", "", "Lokhttp3/Cookie;", "url", "Lokhttp3/HttpUrl;", "header", "", "loadForRequest", "saveFromResponse", "", "cookies", "okhttp-urlconnection"}, k = 1, mv = {1, 1, 16})
/* compiled from: JavaNetCookieJar.kt */
public final class JavaNetCookieJar implements CookieJar {
    public final CookieHandler cookieHandler;

    public JavaNetCookieJar(CookieHandler cookieHandler2) {
        Intrinsics.checkParameterIsNotNull(cookieHandler2, "cookieHandler");
        this.cookieHandler = cookieHandler2;
    }

    private final List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl httpUrl, String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int delimiterOffset = Util.delimiterOffset(str, (String) ";,", i, length);
            int delimiterOffset2 = Util.delimiterOffset(str, '=', i, delimiterOffset);
            String trimSubstring = Util.trimSubstring(str, i, delimiterOffset2);
            if (!CharsKt__CharKt.startsWith$default(trimSubstring, (String) SFSBuddyVariable.OFFLINE_PREFIX, false, 2)) {
                String trimSubstring2 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (CharsKt__CharKt.startsWith$default(trimSubstring2, (String) "\"", false, 2) && CharsKt__CharKt.endsWith$default(trimSubstring2, (String) "\"", false, 2)) {
                    trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
                    Intrinsics.checkExpressionValueIsNotNull(trimSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(new Builder().name(trimSubstring).value(trimSubstring2).domain(httpUrl.host()).build());
            }
            i = delimiterOffset + 1;
        }
        return arrayList;
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        List<Cookie> list;
        Intrinsics.checkParameterIsNotNull(httpUrl, "url");
        ArrayList arrayList = null;
        try {
            Map<String, List<String>> map = this.cookieHandler.get(httpUrl.uri(), ArraysKt___ArraysJvmKt.emptyMap());
            Intrinsics.checkExpressionValueIsNotNull(map, "cookieHeaders");
            for (Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                List<String> list2 = (List) next.getValue();
                if (CharsKt__CharKt.equals((String) Names.COOKIE, str, true) || CharsKt__CharKt.equals((String) "Cookie2", str, true)) {
                    Intrinsics.checkExpressionValueIsNotNull(list2, HSLCriteriaBuilder.VALUE);
                    if (!list2.isEmpty()) {
                        for (String str2 : list2) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            Intrinsics.checkExpressionValueIsNotNull(str2, "header");
                            arrayList.addAll(decodeHeaderAsJavaNetCookies(httpUrl, str2));
                        }
                    }
                }
            }
            if (arrayList != null) {
                list = Collections.unmodifiableList(arrayList);
                Intrinsics.checkExpressionValueIsNotNull(list, "Collections.unmodifiableList(cookies)");
            } else {
                list = EmptyList.INSTANCE;
            }
            return list;
        } catch (IOException e2) {
            Platform platform = Platform.Companion.get();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Loading cookies failed for ");
            HttpUrl resolve = httpUrl.resolve("/...");
            if (resolve != null) {
                outline73.append(resolve);
                platform.log(outline73.toString(), 5, e2);
                return EmptyList.INSTANCE;
            }
            Intrinsics.throwNpe();
            throw null;
        }
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Intrinsics.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics.checkParameterIsNotNull(list, "cookies");
        ArrayList arrayList = new ArrayList();
        for (Cookie cookieToString : list) {
            arrayList.add(Internal.cookieToString(cookieToString, true));
        }
        try {
            this.cookieHandler.put(httpUrl.uri(), TweetUtils.mapOf(new Pair(Names.SET_COOKIE, arrayList)));
        } catch (IOException e2) {
            Platform platform = Platform.Companion.get();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Saving cookies failed for ");
            HttpUrl resolve = httpUrl.resolve("/...");
            if (resolve != null) {
                outline73.append(resolve);
                platform.log(outline73.toString(), 5, e2);
                return;
            }
            Intrinsics.throwNpe();
            throw null;
        }
    }
}
