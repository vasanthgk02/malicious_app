package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NavDeepLink {
    public static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    public final String mAction;
    public final ArrayList<String> mArguments = new ArrayList<>();
    public boolean mExactDeepLink = false;
    public boolean mIsParameterizedQuery = false;
    public final String mMimeType;
    public Pattern mMimeTypePattern = null;
    public final Map<String, ParamQuery> mParamArgMap = new HashMap();
    public Pattern mPattern = null;

    public static class MimeType implements Comparable<MimeType> {
        public String mSubType;
        public String mType;

        public MimeType(String str) {
            String[] split = str.split("/", -1);
            this.mType = split[0];
            this.mSubType = split[1];
        }

        public int compareTo(MimeType mimeType) {
            int i = this.mType.equals(mimeType.mType) ? 2 : 0;
            return this.mSubType.equals(mimeType.mSubType) ? i + 1 : i;
        }
    }

    public static class ParamQuery {
        public ArrayList<String> mArguments = new ArrayList<>();
        public String mParamRegex;
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.mAction = str2;
        this.mMimeType = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            int i = 1;
            this.mIsParameterizedQuery = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!SCHEME_PATTERN.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.mIsParameterizedQuery) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    buildPathRegex(str.substring(0, matcher.start()), sb, compile);
                }
                this.mExactDeepLink = false;
                for (String next : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(next);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    ParamQuery paramQuery = new ParamQuery();
                    int i2 = 0;
                    while (matcher2.find()) {
                        paramQuery.mArguments.add(matcher2.group(i));
                        sb2.append(Pattern.quote(queryParameter.substring(i2, matcher2.start())));
                        sb2.append("(.+?)?");
                        i2 = matcher2.end();
                        i = 1;
                    }
                    if (i2 < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i2)));
                    }
                    paramQuery.mParamRegex = sb2.toString().replace(".*", "\\E.*\\Q");
                    this.mParamArgMap.put(next, paramQuery);
                    i = 1;
                }
            } else {
                this.mExactDeepLink = buildPathRegex(str, sb, compile);
            }
            this.mPattern = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"));
        }
        if (str3 == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
            MimeType mimeType = new MimeType(str3);
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("^(");
            outline73.append(mimeType.mType);
            outline73.append("|[*]+)/(");
            outline73.append(mimeType.mSubType);
            outline73.append("|[*]+)$");
            this.mMimeTypePattern = Pattern.compile(outline73.toString().replace("*|[*]", "[\\s\\S]"));
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("The given mimeType ", str3, " does not match to required \"type/subtype\" format"));
    }

    public final boolean buildPathRegex(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i = 0;
        while (matcher.find()) {
            this.mArguments.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i, matcher.start())));
            sb.append("(.+?)");
            i = matcher.end();
            z = false;
        }
        if (i < str.length()) {
            sb.append(Pattern.quote(str.substring(i)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }

    public final boolean parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            NavType navType = navArgument.mType;
            try {
                navType.put(bundle, str, navType.parseValue(str2));
            } catch (IllegalArgumentException unused) {
                return true;
            }
        } else {
            bundle.putString(str, str2);
        }
        return false;
    }
}
