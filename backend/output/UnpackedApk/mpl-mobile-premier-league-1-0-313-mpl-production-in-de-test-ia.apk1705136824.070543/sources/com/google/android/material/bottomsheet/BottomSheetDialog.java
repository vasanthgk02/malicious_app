package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.badlogic.gdx.graphics.GL20;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback;
import com.google.android.material.shape.MaterialShapeDrawable;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;

public class BottomSheetDialog extends AppCompatDialog {
    public BottomSheetBehavior<FrameLayout> behavior;
    public FrameLayout bottomSheet;
    public BottomSheetCallback bottomSheetCallback;
    public boolean cancelable;
    public boolean canceledOnTouchOutside;
    public boolean canceledOnTouchOutsideSet;
    public FrameLayout container;
    public CoordinatorLayout coordinator;
    public BottomSheetCallback edgeToEdgeCallback;
    public boolean edgeToEdgeEnabled;

    public static class EdgeToEdgeCallback extends BottomSheetCallback {
        public final WindowInsetsCompat insetsCompat;
        public final boolean lightBottomSheet;
        public final boolean lightStatusBar;

        public EdgeToEdgeCallback(View view, WindowInsetsCompat windowInsetsCompat, AnonymousClass1 r7) {
            ColorStateList colorStateList;
            this.insetsCompat = windowInsetsCompat;
            boolean z = true;
            this.lightStatusBar = VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & 8192) != 0;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.from(view).materialShapeDrawable;
            if (materialShapeDrawable != null) {
                colorStateList = materialShapeDrawable.drawableState.fillColor;
            } else {
                colorStateList = ViewCompat.getBackgroundTintList(view);
            }
            if (colorStateList != null) {
                int defaultColor = colorStateList.getDefaultColor();
                this.lightBottomSheet = (defaultColor == 0 || ColorUtils.calculateLuminance(defaultColor) <= 0.5d) ? false : z;
            } else if (view.getBackground() instanceof ColorDrawable) {
                int color = ((ColorDrawable) view.getBackground()).getColor();
                this.lightBottomSheet = (color == 0 || ColorUtils.calculateLuminance(color) <= 0.5d) ? false : z;
            } else {
                this.lightBottomSheet = this.lightStatusBar;
            }
        }

        public void onSlide(View view, float f2) {
            setPaddingForPosition(view);
        }

        public void onStateChanged(View view, int i) {
            setPaddingForPosition(view);
        }

        public final void setPaddingForPosition(View view) {
            if (view.getTop() < this.insetsCompat.getSystemWindowInsetTop()) {
                BottomSheetDialog.setLightStatusBar(view, this.lightBottomSheet);
                view.setPadding(view.getPaddingLeft(), this.insetsCompat.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                BottomSheetDialog.setLightStatusBar(view, this.lightStatusBar);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BottomSheetDialog(Context context, int i) {
        // if (i == 0) {
            // TypedValue typedValue = new TypedValue();
            // if (context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true)) {
                // i = typedValue.resourceId;
            // } else {
                // i = R$style.Theme_Design_Light_BottomSheetDialog;
            // }
        // }
        super(context, i);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetCallback() {
            public void onSlide(View view, float f2) {
            }

            public void onStateChanged(View view, int i) {
                if (i == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public static void setLightStatusBar(View view, boolean z) {
        if (VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
    }

    public void cancel() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        super.cancel();
    }

    public final FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(R$id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(R$id.design_bottom_sheet);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            from.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
        }
        return this.container;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.edgeToEdgeEnabled && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            if (z) {
                window.getDecorView().setSystemUiVisibility(GL20.GL_SRC_COLOR);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(LinearLayoutManager.INVALID_OFFSET);
            if (VERSION.SDK_INT < 23) {
                window.addFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
            }
            window.setLayout(-1, -1);
        }
    }

    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null && bottomSheetBehavior.state == 5) {
            bottomSheetBehavior.setState(4);
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.cancelable != z) {
            this.cancelable = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z;
        this.canceledOnTouchOutsideSet = true;
    }

    public void setContentView(int i) {
        super.setContentView(wrapInBottomSheet(i, null, null));
    }

    public final View wrapInBottomSheet(int i, View view, LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R$id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    BottomSheetCallback bottomSheetCallback = bottomSheetDialog.edgeToEdgeCallback;
                    if (bottomSheetCallback != null) {
                        bottomSheetDialog.behavior.callbacks.remove(bottomSheetCallback);
                    }
                    BottomSheetDialog bottomSheetDialog2 = BottomSheetDialog.this;
                    bottomSheetDialog2.edgeToEdgeCallback = new EdgeToEdgeCallback(bottomSheetDialog2.bottomSheet, windowInsetsCompat, null);
                    BottomSheetDialog bottomSheetDialog3 = BottomSheetDialog.this;
                    bottomSheetDialog3.behavior.addBottomSheetCallback(bottomSheetDialog3.edgeToEdgeCallback);
                    return windowInsetsCompat;
                }
            });
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing()) {
                    BottomSheetDialog bottomSheetDialog2 = BottomSheetDialog.this;
                    if (!bottomSheetDialog2.canceledOnTouchOutsideSet) {
                        TypedArray obtainStyledAttributes = bottomSheetDialog2.getContext().obtainStyledAttributes(new int[]{16843611});
                        bottomSheetDialog2.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                        bottomSheetDialog2.canceledOnTouchOutsideSet = true;
                    }
                    if (bottomSheetDialog2.canceledOnTouchOutside) {
                        BottomSheetDialog.this.cancel();
                    }
                }
            }
        });
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                if (BottomSheetDialog.this.cancelable) {
                    accessibilityNodeInfoCompat.mInfo.addAction(1048576);
                    accessibilityNodeInfoCompat.mInfo.setDismissable(true);
                    return;
                }
                accessibilityNodeInfoCompat.mInfo.setDismissable(false);
            }

            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                if (i == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.cancelable) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view, i, bundle);
            }
        });
        this.bottomSheet.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.container;
    }

    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }
}
