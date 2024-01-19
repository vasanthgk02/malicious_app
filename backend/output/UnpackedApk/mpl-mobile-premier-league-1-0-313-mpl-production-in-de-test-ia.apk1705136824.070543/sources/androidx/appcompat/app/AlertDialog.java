package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertController.CheckedItemAdapter;
import androidx.appcompat.app.AlertController.RecycleListView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.OnScrollChangeListener;
import sfs2x.client.entities.invitation.InvitationReply;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    public final AlertController mAlert = new AlertController(getContext(), this, getWindow());

    public static class Builder {
        public final AlertParams P;
        public final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        public AlertDialog create() {
            int i;
            AlertDialog alertDialog = new AlertDialog(this.P.mContext, this.mTheme);
            AlertParams alertParams = this.P;
            AlertController alertController = alertDialog.mAlert;
            View view = alertParams.mCustomTitleView;
            if (view != null) {
                alertController.mCustomTitleView = view;
            } else {
                CharSequence charSequence = alertParams.mTitle;
                if (charSequence != null) {
                    alertController.mTitle = charSequence;
                    TextView textView = alertController.mTitleView;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = alertParams.mIcon;
                if (drawable != null) {
                    alertController.mIcon = drawable;
                    alertController.mIconId = 0;
                    ImageView imageView = alertController.mIconView;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.mIconView.setImageDrawable(drawable);
                    }
                }
                int i2 = alertParams.mIconId;
                if (i2 != 0) {
                    alertController.setIcon(i2);
                }
                int i3 = alertParams.mIconAttrId;
                if (i3 != 0) {
                    if (alertController != null) {
                        TypedValue typedValue = new TypedValue();
                        alertController.mContext.getTheme().resolveAttribute(i3, typedValue, true);
                        alertController.setIcon(typedValue.resourceId);
                    } else {
                        throw null;
                    }
                }
            }
            CharSequence charSequence2 = alertParams.mMessage;
            if (charSequence2 != null) {
                alertController.mMessage = charSequence2;
                TextView textView2 = alertController.mMessageView;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = alertParams.mPositiveButtonText;
            if (charSequence3 != null) {
                alertController.setButton(-1, charSequence3, alertParams.mPositiveButtonListener, null, null);
            }
            CharSequence charSequence4 = alertParams.mNegativeButtonText;
            if (charSequence4 != null) {
                alertController.setButton(-2, charSequence4, alertParams.mNegativeButtonListener, null, null);
            }
            if (!(alertParams.mItems == null && alertParams.mAdapter == null)) {
                RecycleListView recycleListView = (RecycleListView) alertParams.mInflater.inflate(alertController.mListLayout, null);
                if (alertParams.mIsSingleChoice) {
                    i = alertController.mSingleChoiceItemLayout;
                } else {
                    i = alertController.mListItemLayout;
                }
                ListAdapter listAdapter = alertParams.mAdapter;
                if (listAdapter == null) {
                    listAdapter = new CheckedItemAdapter(alertParams.mContext, i, 16908308, alertParams.mItems);
                }
                alertController.mAdapter = listAdapter;
                alertController.mCheckedItem = alertParams.mCheckedItem;
                if (alertParams.mOnClickListener != null) {
                    recycleListView.setOnItemClickListener(new OnItemClickListener(alertController) {
                        public final /* synthetic */ AlertController val$dialog;

                        {
                            this.val$dialog = r2;
                        }

                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            AlertParams.this.mOnClickListener.onClick(this.val$dialog.mDialog, i);
                            if (!AlertParams.this.mIsSingleChoice) {
                                this.val$dialog.mDialog.dismiss();
                            }
                        }
                    });
                }
                if (alertParams.mIsSingleChoice) {
                    recycleListView.setChoiceMode(1);
                }
                alertController.mListView = recycleListView;
            }
            View view2 = alertParams.mView;
            if (view2 == null) {
                int i4 = alertParams.mViewLayoutResId;
                if (i4 != 0) {
                    alertController.mView = null;
                    alertController.mViewLayoutResId = i4;
                    alertController.mViewSpacingSpecified = false;
                }
            } else if (alertParams.mViewSpacingSpecified) {
                alertController.mView = view2;
                alertController.mViewLayoutResId = 0;
                alertController.mViewSpacingSpecified = true;
                alertController.mViewSpacingLeft = 0;
                alertController.mViewSpacingTop = 0;
                alertController.mViewSpacingRight = 0;
                alertController.mViewSpacingBottom = 0;
            } else {
                alertController.mView = view2;
                alertController.mViewLayoutResId = 0;
                alertController.mViewSpacingSpecified = false;
            }
            alertDialog.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.P.mOnDismissListener);
            OnKeyListener onKeyListener = this.P.mOnKeyListener;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        public Builder setNegativeButton(int i, OnClickListener onClickListener) {
            AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(int i, OnClickListener onClickListener) {
            AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }

        public Builder(Context context, int i) {
            this.P = new AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        public Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = charSequence;
            alertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = charSequence;
            alertParams.mPositiveButtonListener = onClickListener;
            return this;
        }
    }

    public AlertDialog(Context context, int i) {
        super(context, resolveDialogTheme(context, i));
    }

    public static int resolveDialogTheme(Context context, int i) {
        if (((i >>> 24) & InvitationReply.EXPIRED) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        AlertController alertController = this.mAlert;
        if (alertController == null) {
            throw null;
        } else if (i == -3) {
            return alertController.mButtonNeutral;
        } else {
            if (i == -2) {
                return alertController.mButtonNegative;
            }
            if (i != -1) {
                return null;
            }
            return alertController.mButtonPositive;
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        View view;
        super.onCreate(bundle);
        AlertController alertController = this.mAlert;
        int i = alertController.mButtonPanelSideLayout;
        if (i == 0) {
            i = alertController.mAlertDialogLayout;
        } else if (alertController.mButtonPanelLayoutHint != 1) {
            i = alertController.mAlertDialogLayout;
        }
        alertController.mDialog.setContentView(i);
        View findViewById = alertController.mWindow.findViewById(R$id.parentPanel);
        View findViewById2 = findViewById.findViewById(R$id.topPanel);
        View findViewById3 = findViewById.findViewById(R$id.contentPanel);
        View findViewById4 = findViewById.findViewById(R$id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(R$id.customPanel);
        View view2 = alertController.mView;
        View view3 = null;
        int i2 = 0;
        if (view2 == null) {
            view2 = alertController.mViewLayoutResId != 0 ? LayoutInflater.from(alertController.mContext).inflate(alertController.mViewLayoutResId, viewGroup, false) : null;
        }
        boolean z2 = view2 != null;
        if (!z2 || !AlertController.canTextInput(view2)) {
            alertController.mWindow.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) alertController.mWindow.findViewById(R$id.custom);
            frameLayout.addView(view2, new LayoutParams(-1, -1));
            if (alertController.mViewSpacingSpecified) {
                frameLayout.setPadding(alertController.mViewSpacingLeft, alertController.mViewSpacingTop, alertController.mViewSpacingRight, alertController.mViewSpacingBottom);
            }
            if (alertController.mListView != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById5 = viewGroup.findViewById(R$id.topPanel);
        View findViewById6 = viewGroup.findViewById(R$id.contentPanel);
        View findViewById7 = viewGroup.findViewById(R$id.buttonPanel);
        ViewGroup resolvePanel = alertController.resolvePanel(findViewById5, findViewById2);
        ViewGroup resolvePanel2 = alertController.resolvePanel(findViewById6, findViewById3);
        ViewGroup resolvePanel3 = alertController.resolvePanel(findViewById7, findViewById4);
        NestedScrollView nestedScrollView = (NestedScrollView) alertController.mWindow.findViewById(R$id.scrollView);
        alertController.mScrollView = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.mScrollView.setNestedScrollingEnabled(false);
        TextView textView = (TextView) resolvePanel2.findViewById(16908299);
        alertController.mMessageView = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.mMessage;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.mScrollView.removeView(alertController.mMessageView);
                if (alertController.mListView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.mScrollView.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.mScrollView);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.mListView, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    resolvePanel2.setVisibility(8);
                }
            }
        }
        Button button = (Button) resolvePanel3.findViewById(16908313);
        alertController.mButtonPositive = button;
        button.setOnClickListener(alertController.mButtonHandler);
        if (!TextUtils.isEmpty(alertController.mButtonPositiveText) || alertController.mButtonPositiveIcon != null) {
            alertController.mButtonPositive.setText(alertController.mButtonPositiveText);
            Drawable drawable = alertController.mButtonPositiveIcon;
            if (drawable != null) {
                int i3 = alertController.mButtonIconDimen;
                drawable.setBounds(0, 0, i3, i3);
                alertController.mButtonPositive.setCompoundDrawables(alertController.mButtonPositiveIcon, null, null, null);
            }
            alertController.mButtonPositive.setVisibility(0);
            z = true;
        } else {
            alertController.mButtonPositive.setVisibility(8);
            z = false;
        }
        Button button2 = (Button) resolvePanel3.findViewById(16908314);
        alertController.mButtonNegative = button2;
        button2.setOnClickListener(alertController.mButtonHandler);
        if (!TextUtils.isEmpty(alertController.mButtonNegativeText) || alertController.mButtonNegativeIcon != null) {
            alertController.mButtonNegative.setText(alertController.mButtonNegativeText);
            Drawable drawable2 = alertController.mButtonNegativeIcon;
            if (drawable2 != null) {
                int i4 = alertController.mButtonIconDimen;
                drawable2.setBounds(0, 0, i4, i4);
                alertController.mButtonNegative.setCompoundDrawables(alertController.mButtonNegativeIcon, null, null, null);
            }
            alertController.mButtonNegative.setVisibility(0);
            z |= true;
        } else {
            alertController.mButtonNegative.setVisibility(8);
        }
        Button button3 = (Button) resolvePanel3.findViewById(16908315);
        alertController.mButtonNeutral = button3;
        button3.setOnClickListener(alertController.mButtonHandler);
        if (!TextUtils.isEmpty(alertController.mButtonNeutralText) || alertController.mButtonNeutralIcon != null) {
            alertController.mButtonNeutral.setText(alertController.mButtonNeutralText);
            Drawable drawable3 = alertController.mButtonNeutralIcon;
            if (drawable3 != null) {
                int i5 = alertController.mButtonIconDimen;
                drawable3.setBounds(0, 0, i5, i5);
                alertController.mButtonNeutral.setCompoundDrawables(alertController.mButtonNeutralIcon, null, null, null);
            }
            alertController.mButtonNeutral.setVisibility(0);
            z |= true;
        } else {
            alertController.mButtonNeutral.setVisibility(8);
        }
        Context context = alertController.mContext;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (z) {
                alertController.centerButton(alertController.mButtonPositive);
            } else if (z) {
                alertController.centerButton(alertController.mButtonNegative);
            } else if (z) {
                alertController.centerButton(alertController.mButtonNeutral);
            }
        }
        if (!(z)) {
            resolvePanel3.setVisibility(8);
        }
        if (alertController.mCustomTitleView != null) {
            resolvePanel.addView(alertController.mCustomTitleView, 0, new LayoutParams(-1, -2));
            alertController.mWindow.findViewById(R$id.title_template).setVisibility(8);
        } else {
            alertController.mIconView = (ImageView) alertController.mWindow.findViewById(16908294);
            if (!(!TextUtils.isEmpty(alertController.mTitle)) || !alertController.mShowTitle) {
                alertController.mWindow.findViewById(R$id.title_template).setVisibility(8);
                alertController.mIconView.setVisibility(8);
                resolvePanel.setVisibility(8);
            } else {
                TextView textView2 = (TextView) alertController.mWindow.findViewById(R$id.alertTitle);
                alertController.mTitleView = textView2;
                textView2.setText(alertController.mTitle);
                int i6 = alertController.mIconId;
                if (i6 != 0) {
                    alertController.mIconView.setImageResource(i6);
                } else {
                    Drawable drawable4 = alertController.mIcon;
                    if (drawable4 != null) {
                        alertController.mIconView.setImageDrawable(drawable4);
                    } else {
                        alertController.mTitleView.setPadding(alertController.mIconView.getPaddingLeft(), alertController.mIconView.getPaddingTop(), alertController.mIconView.getPaddingRight(), alertController.mIconView.getPaddingBottom());
                        alertController.mIconView.setVisibility(8);
                    }
                }
            }
        }
        boolean z3 = viewGroup.getVisibility() != 8;
        int i7 = (resolvePanel == null || resolvePanel.getVisibility() == 8) ? 0 : 1;
        boolean z4 = resolvePanel3.getVisibility() != 8;
        if (!z4) {
            View findViewById8 = resolvePanel2.findViewById(R$id.textSpacerNoButtons);
            if (findViewById8 != null) {
                findViewById8.setVisibility(0);
            }
        }
        if (i7 != 0) {
            NestedScrollView nestedScrollView2 = alertController.mScrollView;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            if (alertController.mMessage == null && alertController.mListView == null) {
                view = null;
            } else {
                view = resolvePanel.findViewById(R$id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View findViewById9 = resolvePanel2.findViewById(R$id.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        ListView listView = alertController.mListView;
        if (listView instanceof RecycleListView) {
            RecycleListView recycleListView = (RecycleListView) listView;
            if (recycleListView == null) {
                throw null;
            } else if (!z4 || i7 == 0) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), i7 != 0 ? recycleListView.getPaddingTop() : recycleListView.mPaddingTopNoTitle, recycleListView.getPaddingRight(), z4 ? recycleListView.getPaddingBottom() : recycleListView.mPaddingBottomNoButtons);
            }
        }
        if (!z3) {
            View view4 = alertController.mListView;
            if (view4 == null) {
                view4 = alertController.mScrollView;
            }
            if (view4 != null) {
                if (z4) {
                    i2 = 2;
                }
                int i8 = i7 | i2;
                View findViewById10 = alertController.mWindow.findViewById(R$id.scrollIndicatorUp);
                View findViewById11 = alertController.mWindow.findViewById(R$id.scrollIndicatorDown);
                if (VERSION.SDK_INT >= 23) {
                    ViewCompat.setScrollIndicators(view4, i8, 3);
                    if (findViewById10 != null) {
                        resolvePanel2.removeView(findViewById10);
                    }
                    if (findViewById11 != null) {
                        resolvePanel2.removeView(findViewById11);
                    }
                } else {
                    if (findViewById10 != null && (i8 & 1) == 0) {
                        resolvePanel2.removeView(findViewById10);
                        findViewById10 = null;
                    }
                    if (findViewById11 == null || (i8 & 2) != 0) {
                        view3 = findViewById11;
                    } else {
                        resolvePanel2.removeView(findViewById11);
                    }
                    if (!(findViewById10 == null && view3 == null)) {
                        if (alertController.mMessage != null) {
                            alertController.mScrollView.setOnScrollChangeListener(new OnScrollChangeListener(alertController, findViewById10, view3) {
                                public final /* synthetic */ View val$bottom;
                                public final /* synthetic */ View val$top;

                                {
                                    this.val$top = r2;
                                    this.val$bottom = r3;
                                }

                                public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                                    AlertController.manageScrollIndicators(nestedScrollView, this.val$top, this.val$bottom);
                                }
                            });
                            alertController.mScrollView.post(new Runnable(findViewById10, view3) {
                                public final /* synthetic */ View val$bottom;
                                public final /* synthetic */ View val$top;

                                {
                                    this.val$top = r2;
                                    this.val$bottom = r3;
                                }

                                public void run() {
                                    AlertController.manageScrollIndicators(AlertController.this.mScrollView, this.val$top, this.val$bottom);
                                }
                            });
                        } else {
                            ListView listView2 = alertController.mListView;
                            if (listView2 != null) {
                                listView2.setOnScrollListener(new OnScrollListener(alertController, findViewById10, view3) {
                                    public final /* synthetic */ View val$bottom;
                                    public final /* synthetic */ View val$top;

                                    {
                                        this.val$top = r2;
                                        this.val$bottom = r3;
                                    }

                                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                                        AlertController.manageScrollIndicators(absListView, this.val$top, this.val$bottom);
                                    }

                                    public void onScrollStateChanged(AbsListView absListView, int i) {
                                    }
                                });
                                alertController.mListView.post(new Runnable(findViewById10, view3) {
                                    public final /* synthetic */ View val$bottom;
                                    public final /* synthetic */ View val$top;

                                    {
                                        this.val$top = r2;
                                        this.val$bottom = r3;
                                    }

                                    public void run() {
                                        AlertController.manageScrollIndicators(AlertController.this.mListView, this.val$top, this.val$bottom);
                                    }
                                });
                            } else {
                                if (findViewById10 != null) {
                                    resolvePanel2.removeView(findViewById10);
                                }
                                if (view3 != null) {
                                    resolvePanel2.removeView(view3);
                                }
                            }
                        }
                    }
                }
            }
        }
        ListView listView3 = alertController.mListView;
        if (listView3 != null) {
            ListAdapter listAdapter = alertController.mAdapter;
            if (listAdapter != null) {
                listView3.setAdapter(listAdapter);
                int i9 = alertController.mCheckedItem;
                if (i9 > -1) {
                    listView3.setItemChecked(i9, true);
                    listView3.setSelection(i9);
                }
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mAlert.mScrollView;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mAlert.mScrollView;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null, null);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.mAlert;
        alertController.mTitle = charSequence;
        TextView textView = alertController.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
