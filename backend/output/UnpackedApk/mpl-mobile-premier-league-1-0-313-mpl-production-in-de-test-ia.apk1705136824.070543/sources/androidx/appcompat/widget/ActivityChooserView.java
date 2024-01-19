package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;

public class ActivityChooserView extends ViewGroup {
    public final View mActivityChooserContent;
    public final Drawable mActivityChooserContentBackground;
    public final ActivityChooserViewAdapter mAdapter;
    public final Callbacks mCallbacks;
    public int mDefaultActionButtonContentDescription;
    public final FrameLayout mDefaultActivityButton;
    public final ImageView mDefaultActivityButtonImage;
    public final FrameLayout mExpandActivityOverflowButton;
    public final ImageView mExpandActivityOverflowButtonImage;
    public int mInitialActivityCount;
    public boolean mIsAttachedToWindow;
    public boolean mIsSelectingDefaultActivity;
    public final int mListPopupMaxWidth;
    public ListPopupWindow mListPopupWindow;
    public final DataSetObserver mModelDataSetObserver;
    public OnDismissListener mOnDismissListener;
    public final OnGlobalLayoutListener mOnGlobalLayoutListener;
    public ActionProvider mProvider;

    public class ActivityChooserViewAdapter extends BaseAdapter {
        public ActivityChooserModel mDataModel;
        public int mMaxActivityCount = 4;
        public boolean mShowDefaultActivity;
        public boolean mShowFooterView;

        public ActivityChooserViewAdapter() {
        }

        public int getCount() {
            throw null;
        }

        public Object getItem(int i) {
            if (this.mShowFooterView) {
                throw null;
            } else if (!this.mShowDefaultActivity) {
                throw null;
            } else {
                throw null;
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            if (!this.mShowFooterView) {
                return 0;
            }
            throw null;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (!this.mShowFooterView) {
                if (view == null || view.getId() != R$id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                ActivityChooserView.this.getContext().getPackageManager();
                ImageView imageView = (ImageView) view.findViewById(R$id.icon);
                getItem(i);
                throw null;
            }
            throw null;
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    public class Callbacks implements OnItemClickListener, OnClickListener, OnLongClickListener, OnDismissListener {
        public Callbacks() {
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.mDefaultActivityButton) {
                activityChooserView.dismissPopup();
                if (ActivityChooserView.this.mAdapter != null) {
                    throw null;
                }
                throw null;
            } else if (view == activityChooserView.mExpandActivityOverflowButton) {
                activityChooserView.mIsSelectingDefaultActivity = false;
                activityChooserView.showPopupUnchecked(activityChooserView.mInitialActivityCount);
                throw null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            OnDismissListener onDismissListener = ActivityChooserView.this.mOnDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
            ActionProvider actionProvider = ActivityChooserView.this.mProvider;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!((ActivityChooserViewAdapter) adapterView.getAdapter()).mShowFooterView) {
                ActivityChooserView.this.dismissPopup();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.mIsSelectingDefaultActivity) {
                    boolean z = activityChooserView.mAdapter.mShowDefaultActivity;
                    if (ActivityChooserView.this.mAdapter != null) {
                        throw null;
                    }
                    throw null;
                } else if (i <= 0) {
                } else {
                    if (activityChooserView.mAdapter != null) {
                        throw null;
                    }
                    throw null;
                }
            } else {
                throw null;
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.mDefaultActivityButton) {
                throw new IllegalArgumentException();
            } else if (activityChooserView.mAdapter != null) {
                throw null;
            } else {
                throw null;
            }
        }
    }

    public static class InnerLayout extends LinearLayout {
        public static final int[] TINT_ATTRS = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            Drawable drawable;
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, TINT_ATTRS);
            if (obtainStyledAttributes.hasValue(0)) {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    drawable = AppCompatResources.getDrawable(context, resourceId);
                    setBackgroundDrawable(drawable);
                    obtainStyledAttributes.recycle();
                }
            }
            drawable = obtainStyledAttributes.getDrawable(0);
            setBackgroundDrawable(drawable);
            obtainStyledAttributes.recycle();
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean dismissPopup() {
        if (isShowingPopup()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
            }
        }
        return true;
    }

    public ActivityChooserModel getDataModel() {
        if (this.mAdapter != null) {
            return null;
        }
        throw null;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext(), null, R$attr.listPopupWindowStyle);
            this.mListPopupWindow = listPopupWindow;
            listPopupWindow.setAdapter(this.mAdapter);
            ListPopupWindow listPopupWindow2 = this.mListPopupWindow;
            listPopupWindow2.mDropDownAnchorView = this;
            listPopupWindow2.setModal(true);
            ListPopupWindow listPopupWindow3 = this.mListPopupWindow;
            Callbacks callbacks = this.mCallbacks;
            listPopupWindow3.mItemClickListener = callbacks;
            listPopupWindow3.mPopup.setOnDismissListener(callbacks);
        }
        return this.mListPopupWindow;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mAdapter != null) {
            this.mIsAttachedToWindow = true;
            return;
        }
        throw null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mAdapter != null) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
            }
            if (isShowingPopup()) {
                dismissPopup();
            }
            this.mIsAttachedToWindow = false;
            return;
        }
        throw null;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mActivityChooserContent.layout(0, 0, i3 - i, i4 - i2);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    public void onMeasure(int i, int i2) {
        View view = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        ActivityChooserViewAdapter activityChooserViewAdapter = this.mAdapter;
        ActivityChooserView activityChooserView = ActivityChooserView.this;
        if (activityChooserView.mAdapter != null) {
            activityChooserViewAdapter.mDataModel = activityChooserModel;
            if (activityChooserModel == null || !activityChooserView.isShown()) {
                activityChooserViewAdapter.notifyDataSetChanged();
                if (isShowingPopup()) {
                    dismissPopup();
                    showPopup();
                    return;
                }
                return;
            }
            DataSetObserver dataSetObserver = ActivityChooserView.this.mModelDataSetObserver;
            throw null;
        }
        throw null;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.mDefaultActionButtonContentDescription = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.mExpandActivityOverflowButtonImage.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.mInitialActivityCount = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.mProvider = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.mIsAttachedToWindow) {
            return false;
        }
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        throw null;
    }

    public void showPopupUnchecked(int i) {
        if (this.mAdapter != null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        throw null;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mModelDataSetObserver = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.mAdapter.notifyDataSetChanged();
            }

            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.mAdapter.notifyDataSetInvalidated();
            }
        };
        this.mOnGlobalLayoutListener = new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (!ActivityChooserView.this.isShowingPopup()) {
                    return;
                }
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                ActionProvider actionProvider = ActivityChooserView.this.mProvider;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
            }
        };
        this.mInitialActivityCount = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActivityChooserView, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.ActivityChooserView, attributeSet, obtainStyledAttributes, i, 0);
        this.mInitialActivityCount = obtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, this, true);
        this.mCallbacks = new Callbacks();
        View findViewById = findViewById(R$id.activity_chooser_view_content);
        this.mActivityChooserContent = findViewById;
        this.mActivityChooserContentBackground = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.default_activity_button);
        this.mDefaultActivityButton = frameLayout;
        frameLayout.setOnClickListener(this.mCallbacks);
        this.mDefaultActivityButton.setOnLongClickListener(this.mCallbacks);
        this.mDefaultActivityButtonImage = (ImageView) this.mDefaultActivityButton.findViewById(R$id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout2.setOnClickListener(this.mCallbacks);
        frameLayout2.setAccessibilityDelegate(new AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCanOpenPopup(true);
            }
        });
        frameLayout2.setOnTouchListener(new ForwardingListener(frameLayout2) {
            public ShowableListMenu getPopup() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            public boolean onForwardingStarted() {
                ActivityChooserView.this.showPopup();
                return true;
            }

            public boolean onForwardingStopped() {
                ActivityChooserView.this.dismissPopup();
                return true;
            }
        });
        this.mExpandActivityOverflowButton = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R$id.image);
        this.mExpandActivityOverflowButtonImage = imageView;
        imageView.setImageDrawable(drawable);
        ActivityChooserViewAdapter activityChooserViewAdapter = new ActivityChooserViewAdapter();
        this.mAdapter = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                if (ActivityChooserView.this.mAdapter != null) {
                    throw null;
                }
                throw null;
            }
        });
        Resources resources = context.getResources();
        this.mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }
}
