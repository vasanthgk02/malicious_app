package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import androidx.appcompat.widget.SuggestionsAdapter;

public class CursorFilter extends Filter {
    public CursorFilterClient mClient;

    public interface CursorFilterClient {
    }

    public CursorFilter(CursorFilterClient cursorFilterClient) {
        this.mClient = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return ((SuggestionsAdapter) this.mClient).convertToString((Cursor) obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r5) {
        /*
            r4 = this;
            androidx.cursoradapter.widget.CursorFilter$CursorFilterClient r0 = r4.mClient
            androidx.appcompat.widget.SuggestionsAdapter r0 = (androidx.appcompat.widget.SuggestionsAdapter) r0
            r1 = 0
            if (r0 == 0) goto L_0x0046
            if (r5 != 0) goto L_0x000c
            java.lang.String r5 = ""
            goto L_0x0010
        L_0x000c:
            java.lang.String r5 = r5.toString()
        L_0x0010:
            androidx.appcompat.widget.SearchView r2 = r0.mSearchView
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x002f
            androidx.appcompat.widget.SearchView r2 = r0.mSearchView
            int r2 = r2.getWindowVisibility()
            if (r2 == 0) goto L_0x0021
            goto L_0x002f
        L_0x0021:
            android.app.SearchableInfo r2 = r0.mSearchable     // Catch:{ RuntimeException -> 0x002f }
            r3 = 50
            android.database.Cursor r5 = r0.getSearchManagerSuggestions(r2, r5, r3)     // Catch:{ RuntimeException -> 0x002f }
            if (r5 == 0) goto L_0x002f
            r5.getCount()     // Catch:{ RuntimeException -> 0x002f }
            goto L_0x0030
        L_0x002f:
            r5 = r1
        L_0x0030:
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            if (r5 == 0) goto L_0x0040
            int r1 = r5.getCount()
            r0.count = r1
            r0.values = r5
            goto L_0x0045
        L_0x0040:
            r5 = 0
            r0.count = r5
            r0.values = r1
        L_0x0045:
            return r0
        L_0x0046:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.cursoradapter.widget.CursorFilter.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    public void publishResults(CharSequence charSequence, FilterResults filterResults) {
        CursorFilterClient cursorFilterClient = this.mClient;
        Cursor cursor = ((CursorAdapter) cursorFilterClient).mCursor;
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            ((SuggestionsAdapter) cursorFilterClient).changeCursor((Cursor) obj);
        }
    }
}
