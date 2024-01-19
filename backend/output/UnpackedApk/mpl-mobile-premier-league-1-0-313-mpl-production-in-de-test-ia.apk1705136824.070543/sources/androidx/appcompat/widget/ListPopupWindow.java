package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
    public static Method sGetMaxAvailableHeightMethod;
    public static Method sSetClipToWindowEnabledMethod;
    public static Method sSetEpicenterBoundsMethod;
    public ListAdapter mAdapter;
    public Context mContext;
    public boolean mDropDownAlwaysVisible;
    public View mDropDownAnchorView;
    public int mDropDownGravity;
    public int mDropDownHeight;
    public int mDropDownHorizontalOffset;
    public DropDownListView mDropDownList;
    public int mDropDownVerticalOffset;
    public boolean mDropDownVerticalOffsetSet;
    public int mDropDownWidth;
    public int mDropDownWindowLayoutType;
    public Rect mEpicenterBounds;
    public boolean mForceIgnoreOutsideTouch;
    public final Handler mHandler;
    public final ListSelectorHider mHideSelector;
    public OnItemClickListener mItemClickListener;
    public int mListItemExpandMaximum;
    public boolean mModal;
    public DataSetObserver mObserver;
    public boolean mOverlapAnchor;
    public boolean mOverlapAnchorSet;
    public PopupWindow mPopup;
    public int mPromptPosition;
    public final ResizePopupRunnable mResizePopupRunnable;
    public final PopupScrollListener mScrollListener;
    public final Rect mTempRect;
    public final PopupTouchInterceptor mTouchInterceptor;

    public class ListSelectorHider implements Runnable {
        public ListSelectorHider() {
        }

        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.mDropDownList;
            if (dropDownListView != null) {
                dropDownListView.setListSelectionHidden(true);
                dropDownListView.requestLayout();
            }
        }
    }

    public class PopupDataSetObserver extends DataSetObserver {
        public PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    public class PopupScrollListener implements OnScrollListener {
        public PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            boolean z = true;
            if (i == 1) {
                if (ListPopupWindow.this.mPopup.getInputMethodMode() != 2) {
                    z = false;
                }
                if (!z && ListPopupWindow.this.mPopup.getContentView() != null) {
                    ListPopupWindow listPopupWindow = ListPopupWindow.this;
                    listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
                    ListPopupWindow.this.mResizePopupRunnable.run();
                }
            }
        }
    }

    public class PopupTouchInterceptor implements OnTouchListener {
        public PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0) {
                PopupWindow popupWindow = ListPopupWindow.this.mPopup;
                if (popupWindow != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < ListPopupWindow.this.mPopup.getHeight()) {
                    ListPopupWindow listPopupWindow = ListPopupWindow.this;
                    listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250);
                    return false;
                }
            }
            if (action == 1) {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.mHandler.removeCallbacks(listPopupWindow2.mResizePopupRunnable);
            }
            return false;
        }
    }

    public class ResizePopupRunnable implements Runnable {
        public ResizePopupRunnable() {
        }

        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.mDropDownList;
            if (dropDownListView != null && ViewCompat.isAttachedToWindow(dropDownListView) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount()) {
                int childCount = ListPopupWindow.this.mDropDownList.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.mListItemExpandMaximum) {
                    listPopupWindow.mPopup.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        if (VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                sSetClipToWindowEnabledMethod = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
            }
            try {
                sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                sGetMaxAvailableHeightMethod = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listPopupWindowStyle);
    }

    public DropDownListView createDropDownListView(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    public void dismiss() {
        this.mPopup.dismiss();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public void setAdapter(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.mObserver;
        if (dataSetObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.mAdapter);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            this.mDropDownWidth = rect.left + rect.right + i;
            return;
        }
        this.mDropDownWidth = i;
    }

    public void setHorizontalOffset(int i) {
        this.mDropDownHorizontalOffset = i;
    }

    public void setModal(boolean z) {
        this.mModal = z;
        this.mPopup.setFocusable(z);
    }

    public void setVerticalOffset(int i) {
        this.mDropDownVerticalOffset = i;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void show() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        if (this.mDropDownList == null) {
            DropDownListView createDropDownListView = createDropDownListView(this.mContext, !this.mModal);
            this.mDropDownList = createDropDownListView;
            createDropDownListView.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        DropDownListView dropDownListView = ListPopupWindow.this.mDropDownList;
                        if (dropDownListView != null) {
                            dropDownListView.setListSelectionHidden(false);
                        }
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            this.mPopup.setContentView(this.mDropDownList);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.mPopup.getContentView();
        }
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            int i5 = rect.top;
            i = rect.bottom + i5;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -i5;
            }
        } else {
            this.mTempRect.setEmpty();
            i = 0;
        }
        boolean z2 = this.mPopup.getInputMethodMode() == 2;
        View view = this.mDropDownAnchorView;
        int i6 = this.mDropDownVerticalOffset;
        if (VERSION.SDK_INT <= 23) {
            Method method = sGetMaxAvailableHeightMethod;
            if (method != null) {
                try {
                    i2 = ((Integer) method.invoke(this.mPopup, new Object[]{view, Integer.valueOf(i6), Boolean.valueOf(z2)})).intValue();
                } catch (Exception unused) {
                }
            }
            i2 = this.mPopup.getMaxAvailableHeight(view, i6);
        } else {
            i2 = this.mPopup.getMaxAvailableHeight(view, i6, z2);
        }
        if (this.mDropDownAlwaysVisible || this.mDropDownHeight == -1) {
            i3 = i2 + i;
        } else {
            int i7 = this.mDropDownWidth;
            if (i7 == -2) {
                int i8 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.mTempRect;
                i4 = MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), LinearLayoutManager.INVALID_OFFSET);
            } else if (i7 != -1) {
                i4 = MeasureSpec.makeMeasureSpec(i7, 1073741824);
            } else {
                int i9 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.mTempRect;
                i4 = MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
            }
            int measureHeightOfChildrenCompat = this.mDropDownList.measureHeightOfChildrenCompat(i4, i2 - 0, -1);
            i3 = measureHeightOfChildrenCompat + (measureHeightOfChildrenCompat > 0 ? this.mDropDownList.getPaddingBottom() + this.mDropDownList.getPaddingTop() + i + 0 : 0);
        }
        boolean z3 = this.mPopup.getInputMethodMode() == 2;
        CompoundButtonCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        if (!this.mPopup.isShowing()) {
            int i10 = this.mDropDownWidth;
            if (i10 == -1) {
                i10 = -1;
            } else if (i10 == -2) {
                i10 = this.mDropDownAnchorView.getWidth();
            }
            int i11 = this.mDropDownHeight;
            if (i11 == -1) {
                i3 = -1;
            } else if (i11 != -2) {
                i3 = i11;
            }
            this.mPopup.setWidth(i10);
            this.mPopup.setHeight(i3);
            if (VERSION.SDK_INT <= 28) {
                Method method2 = sSetClipToWindowEnabledMethod;
                if (method2 != null) {
                    try {
                        method2.invoke(this.mPopup, new Object[]{Boolean.TRUE});
                    } catch (Exception unused2) {
                    }
                }
            } else {
                this.mPopup.setIsClippedToScreen(true);
            }
            this.mPopup.setOutsideTouchable(!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible);
            this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
            if (this.mOverlapAnchorSet) {
                CompoundButtonCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
            }
            if (VERSION.SDK_INT <= 28) {
                Method method3 = sSetEpicenterBoundsMethod;
                if (method3 != null) {
                    try {
                        method3.invoke(this.mPopup, new Object[]{this.mEpicenterBounds});
                    } catch (Exception unused3) {
                    }
                }
            } else {
                this.mPopup.setEpicenterBounds(this.mEpicenterBounds);
            }
            this.mPopup.showAsDropDown(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
            this.mDropDownList.setSelection(-1);
            if (!this.mModal || this.mDropDownList.isInTouchMode()) {
                DropDownListView dropDownListView = this.mDropDownList;
                if (dropDownListView != null) {
                    dropDownListView.setListSelectionHidden(true);
                    dropDownListView.requestLayout();
                }
            }
            if (!this.mModal) {
                this.mHandler.post(this.mHideSelector);
            }
        } else if (ViewCompat.isAttachedToWindow(this.mDropDownAnchorView)) {
            int i12 = this.mDropDownWidth;
            if (i12 == -1) {
                i12 = -1;
            } else if (i12 == -2) {
                i12 = this.mDropDownAnchorView.getWidth();
            }
            int i13 = this.mDropDownHeight;
            if (i13 == -1) {
                if (!z3) {
                    i3 = -1;
                }
                if (z3) {
                    this.mPopup.setWidth(this.mDropDownWidth == -1 ? -1 : 0);
                    this.mPopup.setHeight(0);
                } else {
                    this.mPopup.setWidth(this.mDropDownWidth == -1 ? -1 : 0);
                    this.mPopup.setHeight(-1);
                }
            } else if (i13 != -2) {
                i3 = i13;
            }
            PopupWindow popupWindow = this.mPopup;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.mPopup.update(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, i12 < 0 ? -1 : i12, i3 < 0 ? -1 : i3);
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i, i2);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.mDropDownVerticalOffset = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.mPopup = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
