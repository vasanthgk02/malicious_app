package androidx.preference;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;

public class Preference implements Comparable<Preference> {
    public final Context mContext;
    public Object mDefaultValue;
    public boolean mDependencyMet;
    public boolean mEnabled;
    public String mFragment;
    public boolean mHasSingleLineTitleAttr;
    public String mKey;
    public int mOrder;
    public boolean mParentDependencyMet;
    public boolean mPersistent;
    public boolean mSelectable;
    public CharSequence mSummary;
    public SummaryProvider mSummaryProvider;
    public CharSequence mTitle;

    public interface SummaryProvider<T extends Preference> {
        CharSequence provideSummary(T t);
    }

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrder = Integer.MAX_VALUE;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Preference, i, i2);
        b.getResourceId(obtainStyledAttributes, R$styleable.Preference_icon, R$styleable.Preference_android_icon, 0);
        this.mKey = obtainStyledAttributes.getString(R$styleable.Preference_key) == null ? obtainStyledAttributes.getString(R$styleable.Preference_android_key) : obtainStyledAttributes.getString(R$styleable.Preference_key);
        this.mTitle = obtainStyledAttributes.getText(R$styleable.Preference_title) == null ? obtainStyledAttributes.getText(R$styleable.Preference_android_title) : obtainStyledAttributes.getText(R$styleable.Preference_title);
        this.mSummary = obtainStyledAttributes.getText(R$styleable.Preference_summary) == null ? obtainStyledAttributes.getText(R$styleable.Preference_android_summary) : obtainStyledAttributes.getText(R$styleable.Preference_summary);
        this.mOrder = obtainStyledAttributes.getInt(R$styleable.Preference_order, obtainStyledAttributes.getInt(R$styleable.Preference_android_order, Integer.MAX_VALUE));
        int i3 = R$styleable.Preference_fragment;
        int i4 = R$styleable.Preference_android_fragment;
        this.mFragment = obtainStyledAttributes.getString(i3) == null ? obtainStyledAttributes.getString(i4) : obtainStyledAttributes.getString(i3);
        obtainStyledAttributes.getResourceId(R$styleable.Preference_layout, obtainStyledAttributes.getResourceId(R$styleable.Preference_android_layout, R$layout.preference));
        obtainStyledAttributes.getResourceId(R$styleable.Preference_widgetLayout, obtainStyledAttributes.getResourceId(R$styleable.Preference_android_widgetLayout, 0));
        this.mEnabled = obtainStyledAttributes.getBoolean(R$styleable.Preference_enabled, obtainStyledAttributes.getBoolean(R$styleable.Preference_android_enabled, true));
        this.mSelectable = obtainStyledAttributes.getBoolean(R$styleable.Preference_selectable, obtainStyledAttributes.getBoolean(R$styleable.Preference_android_selectable, true));
        this.mPersistent = obtainStyledAttributes.getBoolean(R$styleable.Preference_persistent, obtainStyledAttributes.getBoolean(R$styleable.Preference_android_persistent, true));
        int i5 = R$styleable.Preference_dependency;
        int i6 = R$styleable.Preference_android_dependency;
        if (obtainStyledAttributes.getString(i5) == null) {
            obtainStyledAttributes.getString(i6);
        }
        int i7 = R$styleable.Preference_allowDividerAbove;
        obtainStyledAttributes.getBoolean(i7, obtainStyledAttributes.getBoolean(i7, this.mSelectable));
        int i8 = R$styleable.Preference_allowDividerBelow;
        obtainStyledAttributes.getBoolean(i8, obtainStyledAttributes.getBoolean(i8, this.mSelectable));
        if (obtainStyledAttributes.hasValue(R$styleable.Preference_defaultValue)) {
            this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, R$styleable.Preference_defaultValue);
        } else if (obtainStyledAttributes.hasValue(R$styleable.Preference_android_defaultValue)) {
            this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, R$styleable.Preference_android_defaultValue);
        }
        obtainStyledAttributes.getBoolean(R$styleable.Preference_shouldDisableView, obtainStyledAttributes.getBoolean(R$styleable.Preference_android_shouldDisableView, true));
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.Preference_singleLineTitle);
        this.mHasSingleLineTitleAttr = hasValue;
        if (hasValue) {
            obtainStyledAttributes.getBoolean(R$styleable.Preference_singleLineTitle, obtainStyledAttributes.getBoolean(R$styleable.Preference_android_singleLineTitle, true));
        }
        obtainStyledAttributes.getBoolean(R$styleable.Preference_iconSpaceReserved, obtainStyledAttributes.getBoolean(R$styleable.Preference_android_iconSpaceReserved, false));
        int i9 = R$styleable.Preference_isPreferenceVisible;
        obtainStyledAttributes.getBoolean(i9, obtainStyledAttributes.getBoolean(i9, true));
        int i10 = R$styleable.Preference_enableCopying;
        obtainStyledAttributes.getBoolean(i10, obtainStyledAttributes.getBoolean(i10, false));
        obtainStyledAttributes.recycle();
    }

    public int compareTo(Object obj) {
        Preference preference = (Preference) obj;
        int i = this.mOrder;
        int i2 = preference.mOrder;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = preference.mTitle;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.mTitle.toString());
    }

    public CharSequence getSummary() {
        SummaryProvider summaryProvider = this.mSummaryProvider;
        if (summaryProvider != null) {
            return summaryProvider.provideSummary(this);
        }
        return this.mSummary;
    }

    public boolean isEnabled() {
        return this.mEnabled && this.mDependencyMet && this.mParentDependencyMet;
    }

    public void notifyChanged() {
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return null;
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.mTitle;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.getAttr(context, R$attr.preferenceStyle, 16842894));
    }
}
