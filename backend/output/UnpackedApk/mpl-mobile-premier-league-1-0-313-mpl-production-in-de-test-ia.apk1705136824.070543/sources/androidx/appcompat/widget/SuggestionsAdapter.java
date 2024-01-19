package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$id;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.rudderstack.android.sdk.core.EventContentProvider;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

public class SuggestionsAdapter extends ResourceCursorAdapter implements OnClickListener {
    public boolean mClosed = false;
    public final int mCommitIconResId;
    public int mFlagsCol = -1;
    public int mIconName1Col = -1;
    public int mIconName2Col = -1;
    public final WeakHashMap<String, ConstantState> mOutsideDrawablesCache;
    public final Context mProviderContext;
    public int mQueryRefinement = 1;
    public final SearchView mSearchView;
    public final SearchableInfo mSearchable;
    public int mText1Col = -1;
    public int mText2Col = -1;
    public int mText2UrlCol = -1;
    public ColorStateList mUrlColor;

    public static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            this.mText1 = (TextView) view.findViewById(16908308);
            this.mText2 = (TextView) view.findViewById(16908309);
            this.mIcon1 = (ImageView) view.findViewById(16908295);
            this.mIcon2 = (ImageView) view.findViewById(16908296);
            this.mIconRefine = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    public static String getColumnString(Cursor cursor, String str) {
        return getStringOrNull(cursor, cursor.getColumnIndex(str));
    }

    public static String getStringOrNull(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(android.view.View r19, android.content.Context r20, android.database.Cursor r21) {
        /*
            r18 = this;
            r1 = r18
            r2 = r21
            java.lang.Object r0 = r19.getTag()
            r3 = r0
            androidx.appcompat.widget.SuggestionsAdapter$ChildViewCache r3 = (androidx.appcompat.widget.SuggestionsAdapter.ChildViewCache) r3
            int r0 = r1.mFlagsCol
            r4 = 0
            r5 = -1
            if (r0 == r5) goto L_0x0017
            int r0 = r2.getInt(r0)
            r6 = r0
            goto L_0x0018
        L_0x0017:
            r6 = 0
        L_0x0018:
            android.widget.TextView r0 = r3.mText1
            r7 = 8
            if (r0 == 0) goto L_0x0036
            int r0 = r1.mText1Col
            java.lang.String r0 = getStringOrNull(r2, r0)
            android.widget.TextView r8 = r3.mText1
            r8.setText(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0033
            r8.setVisibility(r7)
            goto L_0x0036
        L_0x0033:
            r8.setVisibility(r4)
        L_0x0036:
            android.widget.TextView r0 = r3.mText2
            r8 = 2
            r9 = 1
            if (r0 == 0) goto L_0x00be
            int r0 = r1.mText2UrlCol
            java.lang.String r0 = getStringOrNull(r2, r0)
            if (r0 == 0) goto L_0x0087
            android.content.res.ColorStateList r10 = r1.mUrlColor
            if (r10 != 0) goto L_0x0066
            android.util.TypedValue r10 = new android.util.TypedValue
            r10.<init>()
            android.content.Context r11 = r1.mProviderContext
            android.content.res.Resources$Theme r11 = r11.getTheme()
            int r12 = androidx.appcompat.R$attr.textColorSearchUrl
            r11.resolveAttribute(r12, r10, r9)
            android.content.Context r11 = r1.mProviderContext
            android.content.res.Resources r11 = r11.getResources()
            int r10 = r10.resourceId
            android.content.res.ColorStateList r10 = r11.getColorStateList(r10)
            r1.mUrlColor = r10
        L_0x0066:
            android.text.SpannableString r10 = new android.text.SpannableString
            r10.<init>(r0)
            android.text.style.TextAppearanceSpan r15 = new android.text.style.TextAppearanceSpan
            r12 = 0
            r13 = 0
            r14 = 0
            android.content.res.ColorStateList r11 = r1.mUrlColor
            r16 = 0
            r17 = r11
            r11 = r15
            r5 = r15
            r15 = r17
            r11.<init>(r12, r13, r14, r15, r16)
            int r0 = r0.length()
            r11 = 33
            r10.setSpan(r5, r4, r0, r11)
            goto L_0x008d
        L_0x0087:
            int r0 = r1.mText2Col
            java.lang.String r10 = getStringOrNull(r2, r0)
        L_0x008d:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L_0x00a0
            android.widget.TextView r0 = r3.mText1
            if (r0 == 0) goto L_0x00ac
            r0.setSingleLine(r4)
            android.widget.TextView r0 = r3.mText1
            r0.setMaxLines(r8)
            goto L_0x00ac
        L_0x00a0:
            android.widget.TextView r0 = r3.mText1
            if (r0 == 0) goto L_0x00ac
            r0.setSingleLine(r9)
            android.widget.TextView r0 = r3.mText1
            r0.setMaxLines(r9)
        L_0x00ac:
            android.widget.TextView r0 = r3.mText2
            r0.setText(r10)
            boolean r5 = android.text.TextUtils.isEmpty(r10)
            if (r5 == 0) goto L_0x00bb
            r0.setVisibility(r7)
            goto L_0x00be
        L_0x00bb:
            r0.setVisibility(r4)
        L_0x00be:
            android.widget.ImageView r5 = r3.mIcon1
            r10 = 0
            if (r5 == 0) goto L_0x0157
            int r0 = r1.mIconName1Col
            r11 = -1
            if (r0 != r11) goto L_0x00cb
            r0 = r10
            goto L_0x0144
        L_0x00cb:
            java.lang.String r0 = r2.getString(r0)
            android.graphics.drawable.Drawable r0 = r1.getDrawableFromResourceValue(r0)
            if (r0 == 0) goto L_0x00d7
            goto L_0x0144
        L_0x00d7:
            android.app.SearchableInfo r0 = r1.mSearchable
            android.content.ComponentName r0 = r0.getSearchActivity()
            java.lang.String r11 = r0.flattenToShortString()
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r12 = r1.mOutsideDrawablesCache
            boolean r12 = r12.containsKey(r11)
            if (r12 == 0) goto L_0x0100
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r0 = r1.mOutsideDrawablesCache
            java.lang.Object r0 = r0.get(r11)
            android.graphics.drawable.Drawable$ConstantState r0 = (android.graphics.drawable.Drawable.ConstantState) r0
            if (r0 != 0) goto L_0x00f5
            r0 = r10
            goto L_0x0137
        L_0x00f5:
            android.content.Context r11 = r1.mProviderContext
            android.content.res.Resources r11 = r11.getResources()
            android.graphics.drawable.Drawable r0 = r0.newDrawable(r11)
            goto L_0x0137
        L_0x0100:
            android.content.Context r12 = r1.mProviderContext
            android.content.pm.PackageManager r12 = r12.getPackageManager()
            r13 = 128(0x80, float:1.8E-43)
            android.content.pm.ActivityInfo r13 = r12.getActivityInfo(r0, r13)     // Catch:{ NameNotFoundException -> 0x0123 }
            int r14 = r13.getIconResource()
            if (r14 != 0) goto L_0x0113
            goto L_0x0128
        L_0x0113:
            java.lang.String r15 = r0.getPackageName()
            android.content.pm.ApplicationInfo r13 = r13.applicationInfo
            android.graphics.drawable.Drawable r12 = r12.getDrawable(r15, r14, r13)
            if (r12 != 0) goto L_0x0129
            r0.flattenToShortString()
            goto L_0x0128
        L_0x0123:
            r0 = move-exception
            r12 = r0
            r12.toString()
        L_0x0128:
            r12 = r10
        L_0x0129:
            if (r12 != 0) goto L_0x012d
            r0 = r10
            goto L_0x0131
        L_0x012d:
            android.graphics.drawable.Drawable$ConstantState r0 = r12.getConstantState()
        L_0x0131:
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r13 = r1.mOutsideDrawablesCache
            r13.put(r11, r0)
            r0 = r12
        L_0x0137:
            if (r0 == 0) goto L_0x013a
            goto L_0x0144
        L_0x013a:
            android.content.Context r0 = r1.mProviderContext
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.graphics.drawable.Drawable r0 = r0.getDefaultActivityIcon()
        L_0x0144:
            r11 = 4
            r5.setImageDrawable(r0)
            if (r0 != 0) goto L_0x014e
            r5.setVisibility(r11)
            goto L_0x0157
        L_0x014e:
            r5.setVisibility(r4)
            r0.setVisible(r4, r4)
            r0.setVisible(r9, r4)
        L_0x0157:
            android.widget.ImageView r0 = r3.mIcon2
            if (r0 == 0) goto L_0x017b
            int r5 = r1.mIconName2Col
            r11 = -1
            if (r5 != r11) goto L_0x0161
            goto L_0x0169
        L_0x0161:
            java.lang.String r2 = r2.getString(r5)
            android.graphics.drawable.Drawable r10 = r1.getDrawableFromResourceValue(r2)
        L_0x0169:
            r0.setImageDrawable(r10)
            if (r10 != 0) goto L_0x0172
            r0.setVisibility(r7)
            goto L_0x017b
        L_0x0172:
            r0.setVisibility(r4)
            r10.setVisible(r4, r4)
            r10.setVisible(r9, r4)
        L_0x017b:
            int r0 = r1.mQueryRefinement
            if (r0 == r8) goto L_0x018c
            if (r0 != r9) goto L_0x0186
            r0 = r6 & 1
            if (r0 == 0) goto L_0x0186
            goto L_0x018c
        L_0x0186:
            android.widget.ImageView r0 = r3.mIconRefine
            r0.setVisibility(r7)
            goto L_0x01a1
        L_0x018c:
            android.widget.ImageView r0 = r3.mIconRefine
            r0.setVisibility(r4)
            android.widget.ImageView r0 = r3.mIconRefine
            android.widget.TextView r2 = r3.mText1
            java.lang.CharSequence r2 = r2.getText()
            r0.setTag(r2)
            android.widget.ImageView r0 = r3.mIconRefine
            r0.setOnClickListener(r1)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SuggestionsAdapter.bindView(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    public void changeCursor(Cursor cursor) {
        if (this.mClosed) {
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.mText1Col = cursor.getColumnIndex("suggest_text_1");
                this.mText2Col = cursor.getColumnIndex("suggest_text_2");
                this.mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                this.mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                this.mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                this.mFlagsCol = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception unused) {
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String stringOrNull = getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (stringOrNull != null) {
            return stringOrNull;
        }
        if (this.mSearchable.shouldRewriteQueryFromData()) {
            String stringOrNull2 = getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_data"));
            if (stringOrNull2 != null) {
                return stringOrNull2;
            }
        }
        if (this.mSearchable.shouldRewriteQueryFromText()) {
            String stringOrNull3 = getStringOrNull(cursor, cursor.getColumnIndex("suggest_text_1"));
            if (stringOrNull3 != null) {
                return stringOrNull3;
            }
        }
        return null;
    }

    public Drawable getDrawableFromResourceUri(Uri uri) throws FileNotFoundException {
        int i;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.mProviderContext.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException(GeneratedOutlineSupport.outline46("Single path segment is not a resource ID: ", uri));
                        }
                    } else if (size == 2) {
                        i = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException(GeneratedOutlineSupport.outline46("More than two path segments: ", uri));
                    }
                    if (i != 0) {
                        return resourcesForApplication.getDrawable(i);
                    }
                    throw new FileNotFoundException(GeneratedOutlineSupport.outline46("No resource found for: ", uri));
                }
                throw new FileNotFoundException(GeneratedOutlineSupport.outline46("No path: ", uri));
            } catch (NameNotFoundException unused2) {
                throw new FileNotFoundException(GeneratedOutlineSupport.outline46("No package found for authority: ", uri));
            }
        } else {
            throw new FileNotFoundException(GeneratedOutlineSupport.outline46("No authority: ", uri));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:32|33|34) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:44|45|46|47|48|49) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:37|38|39|40|41|42|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r1);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0088 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c8 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0082=Splitter:B:30:0x0082, B:41:0x00b3=Splitter:B:41:0x00b3, B:47:0x00c8=Splitter:B:47:0x00c8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable getDrawableFromResourceValue(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0116
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x0116
            java.lang.String r1 = "0"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0013
            goto L_0x0116
        L_0x0013:
            int r1 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            r2.<init>()     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            java.lang.String r3 = "android.resource://"
            r2.append(r3)     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            android.content.Context r3 = r5.mProviderContext     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            r2.append(r3)     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            java.lang.String r3 = "/"
            r2.append(r3)     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            r2.append(r1)     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            java.lang.String r2 = r2.toString()     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r3 = r5.mOutsideDrawablesCache     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            android.graphics.drawable.Drawable$ConstantState r3 = (android.graphics.drawable.Drawable.ConstantState) r3     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            if (r3 != 0) goto L_0x0042
            r3 = r0
            goto L_0x0046
        L_0x0042:
            android.graphics.drawable.Drawable r3 = r3.newDrawable()     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
        L_0x0046:
            if (r3 == 0) goto L_0x0049
            return r3
        L_0x0049:
            android.content.Context r3 = r5.mProviderContext     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r3, r1)     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            if (r1 == 0) goto L_0x005a
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r3 = r5.mOutsideDrawablesCache     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            android.graphics.drawable.Drawable$ConstantState r4 = r1.getConstantState()     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
            r3.put(r2, r4)     // Catch:{ NumberFormatException -> 0x005c, NotFoundException -> 0x005b }
        L_0x005a:
            return r1
        L_0x005b:
            return r0
        L_0x005c:
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r1 = r5.mOutsideDrawablesCache
            java.lang.Object r1 = r1.get(r6)
            android.graphics.drawable.Drawable$ConstantState r1 = (android.graphics.drawable.Drawable.ConstantState) r1
            if (r1 != 0) goto L_0x0069
            r1 = r0
            goto L_0x006d
        L_0x0069:
            android.graphics.drawable.Drawable r1 = r1.newDrawable()
        L_0x006d:
            if (r1 == 0) goto L_0x0070
            return r1
        L_0x0070:
            android.net.Uri r1 = android.net.Uri.parse(r6)
            java.lang.String r2 = "Error closing icon stream for "
            java.lang.String r3 = r1.getScheme()     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x00ee }
            if (r3 == 0) goto L_0x009f
            android.graphics.drawable.Drawable r0 = r5.getDrawableFromResourceUri(r1)     // Catch:{ NotFoundException -> 0x0088 }
            goto L_0x010b
        L_0x0088:
            java.io.FileNotFoundException r2 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r4 = "Resource does not exist: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.append(r1)     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x00ee }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00ee }
            throw r2     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x009f:
            android.content.Context r3 = r5.mProviderContext     // Catch:{ FileNotFoundException -> 0x00ee }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x00ee }
            java.io.InputStream r3 = r3.openInputStream(r1)     // Catch:{ FileNotFoundException -> 0x00ee }
            if (r3 == 0) goto L_0x00d7
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r0)     // Catch:{ all -> 0x00c3 }
            r3.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00c1
        L_0x00b3:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.append(r2)     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.append(r1)     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.toString()     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x00c1:
            r0 = r4
            goto L_0x010b
        L_0x00c3:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x00c8 }
            goto L_0x00d6
        L_0x00c8:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.append(r2)     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.append(r1)     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.toString()     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x00d6:
            throw r4     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x00d7:
            java.io.FileNotFoundException r2 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r4 = "Failed to open "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x00ee }
            r3.append(r1)     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x00ee }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00ee }
            throw r2     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x00ee:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ", "
            r3.append(r1)
            java.lang.String r1 = r2.getMessage()
            r3.append(r1)
            r3.toString()
        L_0x010b:
            if (r0 == 0) goto L_0x0116
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r1 = r5.mOutsideDrawablesCache
            android.graphics.drawable.Drawable$ConstantState r2 = r0.getConstantState()
            r1.put(r6, r2)
        L_0x0116:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SuggestionsAdapter.getDrawableFromResourceValue(java.lang.String):android.graphics.drawable.Drawable");
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            View inflate = this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
            if (inflate != null) {
                ((ChildViewCache) inflate.getTag()).mText1.setText(e2.toString());
            }
            return inflate;
        }
    }

    public Cursor getSearchManagerSuggestions(SearchableInfo searchableInfo, String str, int i) {
        String[] strArr = null;
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter(EventContentProvider.QUERY_PARAMETER_LIMIT, String.valueOf(i));
        }
        return this.mProviderContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            View newView = newView(this.mProviderContext, this.mCursor, viewGroup);
            ((ChildViewCache) newView.getTag()).mText1.setText(e2.toString());
            return newView;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View inflate = this.mInflater.inflate(this.mLayout, viewGroup, false);
        inflate.setTag(new ChildViewCache(inflate));
        ((ImageView) inflate.findViewById(R$id.edit_query)).setImageResource(this.mCommitIconResId);
        return inflate;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(this.mCursor);
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(this.mCursor);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.mSearchView.onQueryRefine((CharSequence) tag);
        }
    }

    public final void updateSpinnerState(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }
}
