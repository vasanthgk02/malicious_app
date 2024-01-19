package kotlin.text;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.netcore.android.notification.SMTNotificationConstants;
import com.squareup.tape2.QueueFile;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007¨\u0006\u0010"}, d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/CharsKt")
/* compiled from: Char.kt */
public class CharsKt__CharKt {
    public static final String capitalize(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(charAt);
        if (titleCase != Character.toUpperCase(charAt)) {
            sb.append(titleCase);
        } else {
            String substring = str.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = substring.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
        }
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER);
        if (!(charSequence2 instanceof String)) {
            if (indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), z, false, 16) >= 0) {
                return true;
            }
        } else if (indexOf$default(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean contains$default(CharSequence charSequence, char c2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (indexOf$default(charSequence, c2, 0, z, 2) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        boolean z2 = (i & 2) != 0 ? false : z;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "suffix");
        if (!z2 && (charSequence2 instanceof String)) {
            return endsWith$default((String) charSequence, (String) charSequence2, false, 2);
        }
        return regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z2);
    }

    public static final boolean equals(String str, String str2, boolean z) {
        boolean z2;
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            z2 = str.equals(str2);
        } else {
            z2 = str.equalsIgnoreCase(str2);
        }
        return z2;
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String str) {
        if (str.length() == 0) {
            return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
        }
        return new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16);
    }

    public static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        if (!z2) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            new IntRange(i, i2);
        } else {
            int lastIndex = getLastIndex(charSequence);
            if (i > lastIndex) {
                i = lastIndex;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            intProgression = RangesKt___RangesKt.downTo(i, i2);
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int i3 = intProgression.first;
            int i4 = intProgression.last;
            int i5 = intProgression.step;
            if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                while (true) {
                    if (!regionMatchesImpl(charSequence2, 0, charSequence, i3, charSequence2.length(), z)) {
                        if (i3 == i4) {
                            break;
                        }
                        i3 += i5;
                    } else {
                        return i3;
                    }
                }
            }
        } else {
            int i6 = intProgression.first;
            int i7 = intProgression.last;
            int i8 = intProgression.step;
            if ((i8 > 0 && i6 <= i7) || (i8 < 0 && i7 <= i6)) {
                while (true) {
                    if (!regionMatches((String) charSequence2, 0, (String) charSequence, i6, charSequence2.length(), z)) {
                        if (i6 == i7) {
                            break;
                        }
                        i6 += i8;
                    } else {
                        return i6;
                    }
                }
            }
        }
        return -1;
    }

    public static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3) {
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static int indexOf$default(CharSequence charSequence, char c2, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i);
        }
        return indexOfAny(charSequence, new char[]{c2}, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            if (i < 0) {
                i = 0;
            }
            IntIterator it = new IntRange(i, getLastIndex(charSequence)).iterator();
            while (((IntProgressionIterator) it).hasNext) {
                int nextInt = it.nextInt();
                char charAt = charSequence.charAt(nextInt);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        continue;
                        break;
                    } else if (equals(cArr[i2], charAt, z)) {
                        z2 = true;
                        continue;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return nextInt;
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(TweetUtils.single(cArr), i);
    }

    public static final boolean isBlank(CharSequence charSequence) {
        boolean z;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        IntRange intRange = new IntRange(0, charSequence.length() - 1);
        if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
            IntIterator it = intRange.iterator();
            while (true) {
                if (((IntProgressionIterator) it).hasNext) {
                    if (!TypeUtilsKt.isWhitespace(charSequence.charAt(it.nextInt()))) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return true;
        }
        return false;
    }

    public static int lastIndexOf$default(CharSequence charSequence, char c2, int i, boolean z, int i2) {
        boolean z2;
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i);
        }
        char[] cArr = {c2};
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (z || !(charSequence instanceof String)) {
            int lastIndex = getLastIndex(charSequence);
            if (i > lastIndex) {
                i = lastIndex;
            }
            while (-1 < i) {
                char charAt = charSequence.charAt(i);
                int i3 = 0;
                while (true) {
                    if (i3 >= 1) {
                        z2 = false;
                        break;
                    } else if (equals(cArr[i3], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z2) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(TweetUtils.single(cArr), i);
    }

    public static final List<String> lines(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        String[] strArr = {"\r\n", "\n", "\r"};
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        return TypeUtilsKt.toList(TypeUtilsKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, false, 0, 2), new StringsKt__StringsKt$splitToSequence$1(charSequence)));
    }

    public static final Void numberFormatError(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        throw new NumberFormatException("Invalid number format: '" + str + ExtendedMessageFormat.QUOTE);
    }

    public static final String padStart(String str, int i, char c2) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i >= 0) {
            if (i <= str.length()) {
                obj = str.subSequence(0, str.length());
            } else {
                StringBuilder sb = new StringBuilder(i);
                IntIterator it = new IntRange(1, i - str.length()).iterator();
                while (((IntProgressionIterator) it).hasNext) {
                    it.nextInt();
                    sb.append(c2);
                }
                sb.append(str);
                obj = sb;
            }
            return obj.toString();
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Desired length ", i, " is less than zero."));
    }

    public static Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        requireNonNegativeLimit(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$2(ArraysKt___ArraysJvmKt.asList(strArr), z));
    }

    public static final boolean regionMatches(String str, int i, String str2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER);
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }

    public static /* synthetic */ boolean regionMatches$default(String str, int i, String str2, int i2, int i3, boolean z, int i4) {
        return regionMatches(str, i, str2, i2, i3, (i4 & 16) != 0 ? false : z);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER);
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final String removePrefix(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "prefix");
        if (!startsWith$default((CharSequence) str, charSequence, false, 2)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final String repeat(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i >= 0) {
            if (i != 0) {
                if (i == 1) {
                    return charSequence.toString();
                }
                int length = charSequence.length();
                if (length != 0) {
                    if (length != 1) {
                        StringBuilder sb = new StringBuilder(charSequence.length() * i);
                        IntIterator it = new IntRange(1, i).iterator();
                        while (((IntProgressionIterator) it).hasNext) {
                            it.nextInt();
                            sb.append(charSequence);
                        }
                        String sb2 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb2, "{\n                    va…tring()\n                }");
                        return sb2;
                    }
                    char charAt = charSequence.charAt(0);
                    char[] cArr = new char[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        cArr[i2] = charAt;
                    }
                    return new String(cArr);
                }
            }
            return "";
        }
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
    }

    public static String replace$default(String str, char c2, char c3, boolean z, int i) {
        if ((i & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!z) {
            String replace = str.replace(c2, c3);
            Intrinsics.checkNotNullExpressionValue(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (equals(charAt, c2, z)) {
                charAt = c3;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final void requireNonNegativeLimit(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Limit must be non-negative, but was ", i).toString());
        }
    }

    public static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        requireNonNegativeLimit(i);
        int i2 = 0;
        int indexOf = indexOf(charSequence, str, 0, z);
        if (indexOf != -1) {
            boolean z2 = true;
            if (i != 1) {
                if (i <= 0) {
                    z2 = false;
                }
                int i3 = 10;
                if (z2 && i <= 10) {
                    i3 = i;
                }
                ArrayList arrayList = new ArrayList(i3);
                do {
                    arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                    i2 = str.length() + indexOf;
                    if (z2 && arrayList.size() == i - 1) {
                        break;
                    }
                    indexOf = indexOf(charSequence, str, i2, z);
                } while (indexOf != -1);
                arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                return arrayList;
            }
        }
        return TweetUtils.listOf(charSequence.toString());
    }

    public static List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "delimiters");
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(cArr[0]), z, i);
        }
        requireNonNegativeLimit(i);
        Iterable asIterable = TypeUtilsKt.asIterable(new DelimitedRangesSequence(charSequence, 0, i, new StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z)));
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(asIterable, 10));
        Iterator it = ((SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1) asIterable).iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static final boolean startsWith(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return regionMatches(str, 0, str2, 0, str2.length(), z);
    }

    public static boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        boolean z2 = (i & 2) != 0 ? false : z;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        if (!z2 && (charSequence2 instanceof String)) {
            return startsWith$default((String) charSequence, (String) charSequence2, false, 2);
        }
        return regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z2);
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), Integer.valueOf(intRange.last).intValue() + 1).toString();
    }

    public static final String substringAfter(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "delimiter");
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(str2.length() + indexOf$default, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String substringAfter$default(String str, char c2, String str2, int i) {
        String str3 = (i & 2) != 0 ? str : null;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String substringAfterLast(String str, char c2, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c2, 0, false, 6);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c2, String str2, int i) {
        return substringAfterLast(str, c2, (i & 2) != 0 ? str : null);
    }

    public static String substringBefore$default(String str, char c2, String str2, int i) {
        String str3 = (i & 2) != 0 ? str : null;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c2, 0, false, 6);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final Integer toIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toIntOrNull(str, 10);
    }

    public static final Long toLongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toLongOrNull(str, 10);
    }

    public static final UInt toUIntOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        TypeUtilsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        int i3 = 1;
        if (Intrinsics.compare((int) charAt, 48) >= 0) {
            i3 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int i4 = 119304647;
        while (i3 < length) {
            int digit = Character.digit(str.charAt(i3), i);
            if (digit < 0) {
                return null;
            }
            if (TweetUtils.uintCompare(i2, i4) > 0) {
                if (i4 == 119304647) {
                    i4 = (int) ((((long) -1) & 4294967295L) / (4294967295L & ((long) i)));
                    if (TweetUtils.uintCompare(i2, i4) > 0) {
                    }
                }
                return null;
            }
            int i5 = i2 * i;
            int i6 = digit + i5;
            if (TweetUtils.uintCompare(i6, i5) < 0) {
                return null;
            }
            i3++;
            i2 = i6;
        }
        return new UInt(i2);
    }

    public static final ULong toULongOrNull(String str) {
        int i;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "<this>");
        Intrinsics.checkNotNullParameter(str2, "<this>");
        int i2 = 10;
        TypeUtilsKt.checkRadix(10);
        int length = str.length();
        if (length != 0) {
            char charAt = str2.charAt(0);
            if (Intrinsics.compare((int) charAt, 48) >= 0) {
                i = 0;
            } else if (length != 1 && charAt == '+') {
                i = 1;
            }
            long j = (long) 10;
            long j2 = 0;
            long j3 = 512409557603043100L;
            while (i < length) {
                int digit = Character.digit(str2.charAt(i), i2);
                if (digit >= 0) {
                    if (TweetUtils.ulongCompare(j2, j3) > 0) {
                        if (j3 == 512409557603043100L) {
                            if (j < 0) {
                                j3 = TweetUtils.ulongCompare(-1, j) < 0 ? 0 : 1;
                            } else {
                                long j4 = (Long.MAX_VALUE / j) << 1;
                                j3 = j4 + ((long) (TweetUtils.ulongCompare(-1 - (j4 * j), j) >= 0 ? 1 : 0));
                            }
                            if (TweetUtils.ulongCompare(j2, j3) > 0) {
                            }
                        }
                    }
                    long j5 = j2 * j;
                    int i3 = length;
                    long j6 = (((long) digit) & 4294967295L) + j5;
                    if (TweetUtils.ulongCompare(j6, j5) >= 0) {
                        i++;
                        j2 = j6;
                        length = i3;
                        i2 = 10;
                    }
                }
            }
            return new ULong(j2);
        }
        return null;
    }

    public static final CharSequence trim(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean isWhitespace = TypeUtilsKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!isWhitespace) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!isWhitespace) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final String trimIndent(String str) {
        Iterator<T> it;
        Comparable comparable;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("", "newIndent");
        List<String> lines = lines(str);
        ArrayList arrayList = new ArrayList();
        for (String isBlank : lines) {
            if (!isBlank(isBlank)) {
                arrayList.add(it.next());
            }
        }
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (true) {
            int i = 0;
            if (!it2.hasNext()) {
                break;
            }
            String str2 = (String) it2.next();
            int length = str2.length();
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (!TypeUtilsKt.isWhitespace(str2.charAt(i))) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                i = str2.length();
            }
            arrayList2.add(Integer.valueOf(i));
        }
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        Iterator it3 = arrayList2.iterator();
        if (!it3.hasNext()) {
            comparable = null;
        } else {
            comparable = (Comparable) it3.next();
            while (it3.hasNext()) {
                Comparable comparable2 = (Comparable) it3.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        }
        Integer num = (Integer) comparable;
        int intValue = num != null ? num.intValue() : 0;
        int size = (lines.size() * 0) + str.length();
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt("");
        int lastIndex = TweetUtils.getLastIndex(lines);
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        for (T next : lines) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                String str3 = (String) next;
                if ((i2 == 0 || i2 == lastIndex) && isBlank(str3)) {
                    str3 = null;
                } else {
                    Intrinsics.checkNotNullParameter(str3, "<this>");
                    if (intValue >= 0) {
                        int length2 = str3.length();
                        if (intValue <= length2) {
                            length2 = intValue;
                        }
                        String substring = str3.substring(length2);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        String str4 = (String) indentFunction$StringsKt__IndentKt.invoke(substring);
                        if (str4 != null) {
                            str3 = str4;
                        }
                    } else {
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Requested character count ", intValue, " is less than zero.").toString());
                    }
                }
                if (str3 != null) {
                    arrayList3.add(str3);
                }
                i2 = i3;
            } else {
                TweetUtils.throwIndexOverflow();
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder(size);
        ArraysKt___ArraysJvmKt.joinTo$default(arrayList3, sb, "\n", null, null, 0, null, null, 124);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb2;
    }

    public static String trimMargin$default(String str, String str2, int i) {
        Object obj;
        String str3 = (i & 1) != 0 ? "|" : null;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str3, "marginPrefix");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("", "newIndent");
        Intrinsics.checkNotNullParameter(str3, "marginPrefix");
        if (!isBlank(str3)) {
            List<String> lines = lines(str);
            int size = (lines.size() * 0) + str.length();
            Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt("");
            int lastIndex = TweetUtils.getLastIndex(lines);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (T next : lines) {
                int i3 = i2 + 1;
                if (i2 >= 0) {
                    String str4 = (String) next;
                    if ((i2 == 0 || i2 == lastIndex) && isBlank(str4)) {
                        str4 = null;
                    } else {
                        int length = str4.length();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                i4 = -1;
                                break;
                            } else if (!TypeUtilsKt.isWhitespace(str4.charAt(i4))) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (i4 != -1 && startsWith$default(str4, str3, i4, false, 4)) {
                            Intrinsics.checkNotNull(str4, "null cannot be cast to non-null type java.lang.String");
                            obj = str4.substring(str3.length() + i4);
                            Intrinsics.checkNotNullExpressionValue(obj, "this as java.lang.String).substring(startIndex)");
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            String str5 = (String) indentFunction$StringsKt__IndentKt.invoke(obj);
                            if (str5 != null) {
                                str4 = str5;
                            }
                        }
                    }
                    if (str4 != null) {
                        arrayList.add(str4);
                    }
                    i2 = i3;
                } else {
                    TweetUtils.throwIndexOverflow();
                    throw null;
                }
            }
            StringBuilder sb = new StringBuilder(size);
            ArraysKt___ArraysJvmKt.joinTo$default(arrayList, sb, "\n", null, null, 0, null, null, 124);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb2;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static final Integer toIntOrNull(String str, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        TypeUtilsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        int compare = Intrinsics.compare((int) charAt, 48);
        int i3 = QueueFile.VERSIONED_HEADER;
        int i4 = 1;
        if (compare >= 0) {
            z = false;
            i4 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i3 = LinearLayoutManager.INVALID_OFFSET;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        }
        int i5 = -59652323;
        while (i4 < length) {
            int digit = Character.digit(str.charAt(i4), i);
            if (digit < 0) {
                return null;
            }
            if (i2 < i5) {
                if (i5 == -59652323) {
                    i5 = i3 / i;
                    if (i2 < i5) {
                    }
                }
                return null;
            }
            int i6 = i2 * i;
            if (i6 < i3 + digit) {
                return null;
            }
            i2 = i6 - digit;
            i4++;
        }
        return z ? Integer.valueOf(i2) : Integer.valueOf(-i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long toLongOrNull(java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.checkRadix(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            return r3
        L_0x0014:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.Intrinsics.compare(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 1
            if (r6 >= 0) goto L_0x0039
            if (r2 != r9) goto L_0x002a
            return r3
        L_0x002a:
            r6 = 45
            if (r5 != r6) goto L_0x0032
            r7 = -9223372036854775808
            r4 = 1
            goto L_0x003a
        L_0x0032:
            r6 = 43
            if (r5 != r6) goto L_0x0038
            r4 = 1
            goto L_0x0039
        L_0x0038:
            return r3
        L_0x0039:
            r9 = 0
        L_0x003a:
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r10 = 0
            r12 = r5
        L_0x0042:
            if (r4 >= r2) goto L_0x0073
            char r14 = r0.charAt(r4)
            int r14 = java.lang.Character.digit(r14, r1)
            if (r14 >= 0) goto L_0x004f
            return r3
        L_0x004f:
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L_0x005f
            int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r15 != 0) goto L_0x005e
            long r12 = (long) r1
            long r12 = r7 / r12
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L_0x005f
        L_0x005e:
            return r3
        L_0x005f:
            long r5 = (long) r1
            long r10 = r10 * r5
            long r5 = (long) r14
            long r16 = r7 + r5
            int r14 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x006a
            return r3
        L_0x006a:
            long r10 = r10 - r5
            int r4 = r4 + 1
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L_0x0042
        L_0x0073:
            if (r9 == 0) goto L_0x007a
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            goto L_0x007f
        L_0x007a:
            long r0 = -r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.CharsKt__CharKt.toLongOrNull(java.lang.String, int):java.lang.Long");
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static final boolean equals(char c2, char c3, boolean z) {
        boolean z2 = true;
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        if (!(upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2))) {
            z2 = false;
        }
        return z2;
    }

    public static final boolean startsWith(String str, String str2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z) {
            return str.startsWith(str2, i);
        }
        return regionMatches(str, i, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i) {
        return substringAfter(str, str2, (i & 2) != 0 ? str : null);
    }

    public static String substringBefore$default(String str, String str2, String str3, int i) {
        String str4 = (i & 2) != 0 ? str : null;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "delimiter");
        Intrinsics.checkNotNullParameter(str4, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6);
        if (indexOf$default == -1) {
            return str4;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static boolean endsWith$default(String str, String str2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(str, str2, z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i, boolean z, int i2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(str, str2, i, z);
    }

    public static String replace$default(String str, String str2, String str3, boolean z, int i) {
        int i2 = 0;
        if ((i & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "oldValue");
        Intrinsics.checkNotNullParameter(str3, "newValue");
        int indexOf = indexOf(str, str2, 0, z);
        if (indexOf < 0) {
            return str;
        }
        int length = str2.length();
        int i3 = 1;
        if (length >= 1) {
            i3 = length;
        }
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(str, i2, indexOf);
                sb.append(str3);
                i2 = indexOf + length;
                if (indexOf >= str.length()) {
                    break;
                }
                indexOf = indexOf(str, str2, indexOf + i3, z);
            } while (indexOf > 0);
            sb.append(str, i2, str.length());
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2) {
        boolean z2 = false;
        boolean z3 = (i2 & 2) != 0 ? false : z;
        int i3 = (i2 & 4) != 0 ? 0 : i;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                return split$StringsKt__StringsKt(charSequence, str, z3, i3);
            }
        }
        Iterable asIterable = TypeUtilsKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z3, i3, 2));
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(asIterable, 10));
        Iterator it = ((SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1) asIterable).iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        int i3 = i;
        boolean z2 = (i2 & 4) != 0 ? false : z;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
        if (z2 || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt(charSequence, str, i3, 0, z2, true);
        }
        return ((String) charSequence).lastIndexOf(str, i3);
    }
}
