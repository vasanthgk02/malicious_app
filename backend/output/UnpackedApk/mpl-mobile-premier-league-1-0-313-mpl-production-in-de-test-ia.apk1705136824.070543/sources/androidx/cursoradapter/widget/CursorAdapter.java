package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.cursoradapter.widget.CursorFilter.CursorFilterClient;
import com.android.tools.r8.GeneratedOutlineSupport;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilterClient {
    public boolean mAutoRequery;
    public ChangeObserver mChangeObserver;
    public Context mContext;
    public Cursor mCursor;
    public CursorFilter mCursorFilter;
    public DataSetObserver mDataSetObserver;
    public boolean mDataValid;
    public int mRowIDColumn;

    public class ChangeObserver extends ContentObserver {
        public ChangeObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            if (cursorAdapter.mAutoRequery) {
                Cursor cursor = cursorAdapter.mCursor;
                if (cursor != null && !cursor.isClosed()) {
                    cursorAdapter.mDataValid = cursorAdapter.mCursor.requery();
                }
            }
        }
    }

    public class MyDataSetObserver extends DataSetObserver {
        public MyDataSetObserver() {
        }

        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.mDataValid = true;
            cursorAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.mDataValid = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        boolean z2 = true;
        char c2 = z ? (char) 1 : 2;
        if ((c2 & 1) == 1) {
            c2 |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        z2 = cursor == null ? false : z2;
        this.mCursor = cursor;
        this.mDataValid = z2;
        this.mContext = context;
        this.mRowIDColumn = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((c2 & 2) == 2) {
            this.mChangeObserver = new ChangeObserver();
            this.mDataSetObserver = new MyDataSetObserver();
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z2) {
            ChangeObserver changeObserver = this.mChangeObserver;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                ChangeObserver changeObserver = this.mChangeObserver;
                if (changeObserver != null) {
                    cursor2.unregisterContentObserver(changeObserver);
                }
                DataSetObserver dataSetObserver = this.mDataSetObserver;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.mCursor = cursor;
            if (cursor != null) {
                ChangeObserver changeObserver2 = this.mChangeObserver;
                if (changeObserver2 != null) {
                    cursor.registerContentObserver(changeObserver2);
                }
                DataSetObserver dataSetObserver2 = this.mDataSetObserver;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
                this.mDataValid = true;
                notifyDataSetChanged();
            } else {
                this.mRowIDColumn = -1;
                this.mDataValid = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract CharSequence convertToString(Cursor cursor);

    public int getCount() {
        if (this.mDataValid) {
            Cursor cursor = this.mCursor;
            if (cursor != null) {
                return cursor.getCount();
            }
        }
        return 0;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            return null;
        }
        this.mCursor.moveToPosition(i);
        if (view == null) {
            ResourceCursorAdapter resourceCursorAdapter = (ResourceCursorAdapter) this;
            view = resourceCursorAdapter.mInflater.inflate(resourceCursorAdapter.mDropDownLayout, viewGroup, false);
        }
        bindView(view, this.mContext, this.mCursor);
        return view;
    }

    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new CursorFilter(this);
        }
        return this.mCursorFilter;
    }

    public Object getItem(int i) {
        if (this.mDataValid) {
            Cursor cursor = this.mCursor;
            if (cursor != null) {
                cursor.moveToPosition(i);
                return this.mCursor;
            }
        }
        return null;
    }

    public long getItemId(int i) {
        if (this.mDataValid) {
            Cursor cursor = this.mCursor;
            if (cursor != null && cursor.moveToPosition(i)) {
                return this.mCursor.getLong(this.mRowIDColumn);
            }
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.mCursor.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.mCursor, viewGroup);
            }
            bindView(view, this.mContext, this.mCursor);
            return view;
        } else {
            throw new IllegalStateException(GeneratedOutlineSupport.outline41("couldn't move cursor to position ", i));
        }
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);
}
