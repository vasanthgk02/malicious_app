package androidx.navigation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.common.R$styleable;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class NavDestination {
    public SparseArrayCompat<NavAction> mActions;
    public HashMap<String, NavArgument> mArguments;
    public ArrayList<NavDeepLink> mDeepLinks;
    public int mId;
    public String mIdName;
    public CharSequence mLabel;
    public final String mNavigatorName;
    public NavGraph mParent;

    public static class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        public final NavDestination mDestination;
        public final boolean mHasMatchingAction;
        public final boolean mIsExactDeepLink;
        public final Bundle mMatchingArgs;
        public final int mMimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean z, boolean z2, int i) {
            this.mDestination = navDestination;
            this.mMatchingArgs = bundle;
            this.mIsExactDeepLink = z;
            this.mHasMatchingAction = z2;
            this.mMimeTypeMatchLevel = i;
        }

        public int compareTo(DeepLinkMatch deepLinkMatch) {
            if (this.mIsExactDeepLink && !deepLinkMatch.mIsExactDeepLink) {
                return 1;
            }
            if (!this.mIsExactDeepLink && deepLinkMatch.mIsExactDeepLink) {
                return -1;
            }
            if (this.mMatchingArgs != null && deepLinkMatch.mMatchingArgs == null) {
                return 1;
            }
            if (this.mMatchingArgs == null && deepLinkMatch.mMatchingArgs != null) {
                return -1;
            }
            Bundle bundle = this.mMatchingArgs;
            if (bundle != null) {
                int size = bundle.size() - deepLinkMatch.mMatchingArgs.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            if (this.mHasMatchingAction && !deepLinkMatch.mHasMatchingAction) {
                return 1;
            }
            if (this.mHasMatchingAction || !deepLinkMatch.mHasMatchingAction) {
                return this.mMimeTypeMatchLevel - deepLinkMatch.mMimeTypeMatchLevel;
            }
            return -1;
        }
    }

    static {
        new HashMap();
    }

    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this.mNavigatorName = NavigatorProvider.getNameForNavigator(navigator.getClass());
    }

    public static String getDisplayName(Context context, int i) {
        if (i <= 16777215) {
            return Integer.toString(i);
        }
        try {
            return context.getResources().getResourceName(i);
        } catch (NotFoundException unused) {
            return Integer.toString(i);
        }
    }

    public Bundle addInDefaultArgs(Bundle bundle) {
        if (bundle == null) {
            HashMap<String, NavArgument> hashMap = this.mArguments;
            if (hashMap == null || hashMap.isEmpty()) {
                return null;
            }
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, NavArgument> hashMap2 = this.mArguments;
        if (hashMap2 != null) {
            for (Entry next : hashMap2.entrySet()) {
                NavArgument navArgument = (NavArgument) next.getValue();
                String str = (String) next.getKey();
                if (navArgument.mDefaultValuePresent) {
                    navArgument.mType.put(bundle2, str, navArgument.mDefaultValue);
                }
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, NavArgument> hashMap3 = this.mArguments;
            if (hashMap3 != null) {
                for (Entry next2 : hashMap3.entrySet()) {
                    NavArgument navArgument2 = (NavArgument) next2.getValue();
                    String str2 = (String) next2.getKey();
                    boolean z = false;
                    if (navArgument2.mIsNullable || !bundle.containsKey(str2) || bundle.get(str2) != null) {
                        try {
                            navArgument2.mType.get(bundle, str2);
                            z = true;
                            continue;
                        } catch (ClassCastException unused) {
                            continue;
                        }
                    }
                    if (!z) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Wrong argument type for '");
                        outline73.append((String) next2.getKey());
                        outline73.append("' in argument bundle. ");
                        outline73.append(((NavArgument) next2.getValue()).mType.getName());
                        outline73.append(" expected.");
                        throw new IllegalArgumentException(outline73.toString());
                    }
                }
            }
        }
        return bundle2;
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r14v4 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00df, code lost:
        if (r14.replaceAll("[{}]", "").equals(r15) != false) goto L_0x00e4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.navigation.NavDestination.DeepLinkMatch matchDeepLink(androidx.navigation.NavDeepLinkRequest r19) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            java.util.ArrayList<androidx.navigation.NavDeepLink> r0 = r6.mDeepLinks
            r8 = 0
            if (r0 != 0) goto L_0x000a
            return r8
        L_0x000a:
            java.util.Iterator r9 = r0.iterator()
            r10 = r8
        L_0x000f:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x015d
            java.lang.Object r0 = r9.next()
            androidx.navigation.NavDeepLink r0 = (androidx.navigation.NavDeepLink) r0
            android.net.Uri r1 = r7.mUri
            if (r1 == 0) goto L_0x0105
            java.util.HashMap<java.lang.String, androidx.navigation.NavArgument> r3 = r6.mArguments
            if (r3 != 0) goto L_0x0028
            java.util.Map r3 = java.util.Collections.emptyMap()
            goto L_0x002c
        L_0x0028:
            java.util.Map r3 = java.util.Collections.unmodifiableMap(r3)
        L_0x002c:
            java.util.regex.Pattern r4 = r0.mPattern
            java.lang.String r5 = r1.toString()
            java.util.regex.Matcher r4 = r4.matcher(r5)
            boolean r5 = r4.matches()
            if (r5 != 0) goto L_0x003f
        L_0x003c:
            r5 = r8
            goto L_0x0103
        L_0x003f:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.util.ArrayList<java.lang.String> r11 = r0.mArguments
            int r11 = r11.size()
            r12 = 0
        L_0x004b:
            if (r12 >= r11) goto L_0x006c
            java.util.ArrayList<java.lang.String> r13 = r0.mArguments
            java.lang.Object r13 = r13.get(r12)
            java.lang.String r13 = (java.lang.String) r13
            int r12 = r12 + 1
            java.lang.String r14 = r4.group(r12)
            java.lang.String r14 = android.net.Uri.decode(r14)
            java.lang.Object r15 = r3.get(r13)
            androidx.navigation.NavArgument r15 = (androidx.navigation.NavArgument) r15
            boolean r13 = r0.parseArgument(r5, r13, r14, r15)
            if (r13 == 0) goto L_0x004b
            goto L_0x003c
        L_0x006c:
            boolean r4 = r0.mIsParameterizedQuery
            if (r4 == 0) goto L_0x0103
            java.util.Map<java.lang.String, androidx.navigation.NavDeepLink$ParamQuery> r4 = r0.mParamArgMap
            java.util.Set r4 = r4.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x007a:
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L_0x0103
            java.lang.Object r11 = r4.next()
            java.lang.String r11 = (java.lang.String) r11
            java.util.Map<java.lang.String, androidx.navigation.NavDeepLink$ParamQuery> r12 = r0.mParamArgMap
            java.lang.Object r12 = r12.get(r11)
            androidx.navigation.NavDeepLink$ParamQuery r12 = (androidx.navigation.NavDeepLink.ParamQuery) r12
            java.lang.String r11 = r1.getQueryParameter(r11)
            if (r11 == 0) goto L_0x00a5
            java.lang.String r13 = r12.mParamRegex
            java.util.regex.Pattern r13 = java.util.regex.Pattern.compile(r13)
            java.util.regex.Matcher r11 = r13.matcher(r11)
            boolean r13 = r11.matches()
            if (r13 != 0) goto L_0x00a6
            goto L_0x003c
        L_0x00a5:
            r11 = r8
        L_0x00a6:
            r13 = 0
        L_0x00a7:
            java.util.ArrayList<java.lang.String> r14 = r12.mArguments
            int r14 = r14.size()
            if (r13 >= r14) goto L_0x007a
            if (r11 == 0) goto L_0x00bc
            int r14 = r13 + 1
            java.lang.String r14 = r11.group(r14)
            java.lang.String r14 = android.net.Uri.decode(r14)
            goto L_0x00bd
        L_0x00bc:
            r14 = r8
        L_0x00bd:
            java.util.ArrayList<java.lang.String> r15 = r12.mArguments
            java.lang.Object r15 = r15.get(r13)
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r16 = r3.get(r15)
            r2 = r16
            androidx.navigation.NavArgument r2 = (androidx.navigation.NavArgument) r2
            if (r2 == 0) goto L_0x00f3
            if (r14 == 0) goto L_0x00e2
            java.lang.String r8 = "[{}]"
            r17 = r1
            java.lang.String r1 = ""
            java.lang.String r1 = r14.replaceAll(r8, r1)
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x00f5
            goto L_0x00e4
        L_0x00e2:
            r17 = r1
        L_0x00e4:
            java.lang.Object r1 = r2.mDefaultValue
            if (r1 == 0) goto L_0x00ed
            java.lang.String r14 = r1.toString()
            goto L_0x00f5
        L_0x00ed:
            boolean r1 = r2.mIsNullable
            if (r1 == 0) goto L_0x00f5
            r14 = 0
            goto L_0x00f5
        L_0x00f3:
            r17 = r1
        L_0x00f5:
            boolean r1 = r0.parseArgument(r5, r15, r14, r2)
            if (r1 == 0) goto L_0x00fd
            r5 = 0
            goto L_0x0103
        L_0x00fd:
            int r13 = r13 + 1
            r1 = r17
            r8 = 0
            goto L_0x00a7
        L_0x0103:
            r2 = r5
            goto L_0x0106
        L_0x0105:
            r2 = 0
        L_0x0106:
            java.lang.String r1 = r7.mAction
            if (r1 == 0) goto L_0x0115
            java.lang.String r3 = r0.mAction
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0115
            r1 = 1
            r4 = 1
            goto L_0x0116
        L_0x0115:
            r4 = 0
        L_0x0116:
            java.lang.String r1 = r7.mMimeType
            r3 = -1
            if (r1 == 0) goto L_0x0140
            java.lang.String r5 = r0.mMimeType
            if (r5 == 0) goto L_0x013d
            java.util.regex.Pattern r5 = r0.mMimeTypePattern
            java.util.regex.Matcher r5 = r5.matcher(r1)
            boolean r5 = r5.matches()
            if (r5 != 0) goto L_0x012c
            goto L_0x013d
        L_0x012c:
            androidx.navigation.NavDeepLink$MimeType r5 = new androidx.navigation.NavDeepLink$MimeType
            java.lang.String r8 = r0.mMimeType
            r5.<init>(r8)
            androidx.navigation.NavDeepLink$MimeType r8 = new androidx.navigation.NavDeepLink$MimeType
            r8.<init>(r1)
            int r1 = r5.compareTo(r8)
            goto L_0x013e
        L_0x013d:
            r1 = -1
        L_0x013e:
            r5 = r1
            goto L_0x0141
        L_0x0140:
            r5 = -1
        L_0x0141:
            if (r2 != 0) goto L_0x0147
            if (r4 != 0) goto L_0x0147
            if (r5 <= r3) goto L_0x015a
        L_0x0147:
            androidx.navigation.NavDestination$DeepLinkMatch r8 = new androidx.navigation.NavDestination$DeepLinkMatch
            boolean r3 = r0.mExactDeepLink
            r0 = r8
            r1 = r18
            r0.<init>(r1, r2, r3, r4, r5)
            if (r10 == 0) goto L_0x0159
            int r0 = r8.compareTo(r10)
            if (r0 <= 0) goto L_0x015a
        L_0x0159:
            r10 = r8
        L_0x015a:
            r8 = 0
            goto L_0x000f
        L_0x015d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.matchDeepLink(androidx.navigation.NavDeepLinkRequest):androidx.navigation.NavDestination$DeepLinkMatch");
    }

    public void onInflate(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.Navigator);
        int resourceId = obtainAttributes.getResourceId(R$styleable.Navigator_android_id, 0);
        this.mId = resourceId;
        this.mIdName = null;
        this.mIdName = getDisplayName(context, resourceId);
        this.mLabel = obtainAttributes.getText(R$styleable.Navigator_android_label);
        obtainAttributes.recycle();
    }

    public boolean supportsActions() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.mIdName;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.mId));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.mLabel != null) {
            sb.append(" label=");
            sb.append(this.mLabel);
        }
        return sb.toString();
    }
}
