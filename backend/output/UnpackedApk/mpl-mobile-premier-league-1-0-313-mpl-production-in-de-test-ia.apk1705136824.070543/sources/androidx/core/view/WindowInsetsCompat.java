package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import androidx.core.graphics.Insets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED;
    public final Impl mImpl;

    public static class Api21ReflectionHolder {
        public static Field sContentInsets;
        public static boolean sReflectionSucceeded = true;
        public static Field sStableInsets;
        public static Field sViewAttachInfoField;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                e2.getMessage();
            }
        }
    }

    public static class BuilderImpl {
        public final WindowInsetsCompat mInsets;

        public BuilderImpl() {
            this.mInsets = new WindowInsetsCompat((WindowInsetsCompat) null);
        }

        public abstract WindowInsetsCompat build();

        public abstract void setStableInsets(Insets insets);

        public abstract void setSystemWindowInsets(Insets insets);

        public BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat;
        }
    }

    public static class BuilderImpl20 extends BuilderImpl {
        public static Constructor<WindowInsets> sConstructor;
        public static boolean sConstructorFetched;
        public static Field sConsumedField;
        public static boolean sConsumedFieldFetched;
        public WindowInsets mPlatformInsets;
        public Insets mStableInsets;

        public BuilderImpl20() {
            if (!sConsumedFieldFetched) {
                try {
                    sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                sConsumedFieldFetched = true;
            }
            Field field = sConsumedField;
            WindowInsets windowInsets = null;
            if (field != null) {
                try {
                    WindowInsets windowInsets2 = (WindowInsets) field.get(null);
                    if (windowInsets2 != null) {
                        windowInsets = new WindowInsets(windowInsets2);
                        this.mPlatformInsets = windowInsets;
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException unused3) {
                }
                sConstructorFetched = true;
            }
            Constructor<WindowInsets> constructor = sConstructor;
            if (constructor != null) {
                try {
                    windowInsets = constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException unused4) {
                }
            }
            this.mPlatformInsets = windowInsets;
        }

        public WindowInsetsCompat build() {
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            windowInsetsCompat.mImpl.setOverriddenInsets(null);
            windowInsetsCompat.mImpl.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        public void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }

        public void setSystemWindowInsets(Insets insets) {
            WindowInsets windowInsets = this.mPlatformInsets;
            if (windowInsets != null) {
                this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        public BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
        }
    }

    public static class BuilderImpl29 extends BuilderImpl {
        public final Builder mPlatBuilder;

        public BuilderImpl29() {
            this.mPlatBuilder = new Builder();
        }

        public WindowInsetsCompat build() {
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            windowInsetsCompat.mImpl.setOverriddenInsets(null);
            return windowInsetsCompat;
        }

        public void setStableInsets(Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        public void setSystemWindowInsets(Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        public BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
            Builder builder;
            super(windowInsetsCompat);
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = new Builder(windowInsets);
            } else {
                builder = new Builder();
            }
            this.mPlatBuilder = builder;
        }
    }

    public static class BuilderImpl30 extends BuilderImpl29 {
        public BuilderImpl30() {
        }

        public BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    public static class Impl {
        public static final WindowInsetsCompat CONSUMED;
        public final WindowInsetsCompat mHost;

        static {
            BuilderImpl builderImpl;
            int i = VERSION.SDK_INT;
            if (i >= 30) {
                builderImpl = new BuilderImpl30();
            } else if (i >= 29) {
                builderImpl = new BuilderImpl29();
            } else {
                builderImpl = new BuilderImpl20();
            }
            CONSUMED = builderImpl.build().mImpl.consumeDisplayCutout().mImpl.consumeStableInsets().consumeSystemWindowInsets();
        }

        public Impl(WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public void copyRootViewBounds(View view) {
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            if (isRound() != impl.isRound() || isConsumed() != impl.isConsumed() || !Objects.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) || !Objects.equals(getStableInsets(), impl.getStableInsets()) || !Objects.equals(getDisplayCutout(), impl.getDisplayCutout())) {
                z = false;
            }
            return z;
        }

        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        public Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        public Insets getStableInsets() {
            return Insets.NONE;
        }

        public Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout()});
        }

        public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            return CONSUMED;
        }

        public boolean isConsumed() {
            return false;
        }

        public boolean isRound() {
            return false;
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        }

        public void setStableInsets(Insets insets) {
        }
    }

    public static class Impl20 extends Impl {
        public static Class<?> sAttachInfoClass;
        public static Field sAttachInfoField;
        public static Method sGetViewRootImplMethod;
        public static Class<?> sViewRootImplClass;
        public static Field sVisibleInsetsField;
        public static boolean sVisibleRectReflectionFetched;
        public Insets[] mOverriddenInsets;
        public final WindowInsets mPlatformInsets;
        public Insets mRootViewVisibleInsets;
        public WindowInsetsCompat mRootWindowInsets;
        public Insets mSystemWindowInsets = null;

        public Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mPlatformInsets = windowInsets;
        }

        public void copyRootViewBounds(View view) {
            if (VERSION.SDK_INT < 30) {
                if (!sVisibleRectReflectionFetched) {
                    try {
                        sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                        sViewRootImplClass = Class.forName("android.view.ViewRootImpl");
                        Class<?> cls = Class.forName("android.view.View$AttachInfo");
                        sAttachInfoClass = cls;
                        sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                        sAttachInfoField = sViewRootImplClass.getDeclaredField("mAttachInfo");
                        sVisibleInsetsField.setAccessible(true);
                        sAttachInfoField.setAccessible(true);
                    } catch (ReflectiveOperationException e2) {
                        e2.getMessage();
                    }
                    sVisibleRectReflectionFetched = true;
                }
                Method method = sGetViewRootImplMethod;
                Insets insets = null;
                if (!(method == null || sAttachInfoClass == null || sVisibleInsetsField == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            new NullPointerException();
                        } else {
                            Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(invoke));
                            if (rect != null) {
                                insets = Insets.of(rect.left, rect.top, rect.right, rect.bottom);
                            }
                        }
                    } catch (ReflectiveOperationException e3) {
                        e3.getMessage();
                    }
                }
                if (insets == null) {
                    insets = Insets.NONE;
                }
                this.mRootViewVisibleInsets = insets;
                return;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) obj).mRootViewVisibleInsets);
        }

        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            BuilderImpl builderImpl;
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            int i5 = VERSION.SDK_INT;
            if (i5 >= 30) {
                builderImpl = new BuilderImpl30(windowInsetsCompat);
            } else if (i5 >= 29) {
                builderImpl = new BuilderImpl29(windowInsetsCompat);
            } else {
                builderImpl = new BuilderImpl20(windowInsetsCompat);
            }
            builderImpl.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), i, i2, i3, i4));
            builderImpl.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), i, i2, i3, i4));
            return builderImpl.build();
        }

        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
            this.mOverriddenInsets = insetsArr;
        }

        public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
            this.mRootWindowInsets = windowInsetsCompat;
        }
    }

    public static class Impl21 extends Impl20 {
        public Insets mStableInsets = null;

        public Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        public final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        public void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }
    }

    public static class Impl28 extends Impl21 {
        public Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            if (!Objects.equals(this.mPlatformInsets, impl28.mPlatformInsets) || !Objects.equals(this.mRootViewVisibleInsets, impl28.mRootViewVisibleInsets)) {
                z = false;
            }
            return z;
        }

        public DisplayCutoutCompat getDisplayCutout() {
            DisplayCutout displayCutout = this.mPlatformInsets.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new DisplayCutoutCompat(displayCutout);
        }

        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    public static class Impl29 extends Impl28 {
        public Insets mMandatorySystemGestureInsets = null;
        public Insets mSystemGestureInsets = null;
        public Insets mTappableElementInsets = null;

        public Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets == null) {
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
            }
            return this.mMandatorySystemGestureInsets;
        }

        public Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets == null) {
                this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
            }
            return this.mSystemGestureInsets;
        }

        public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(i, i2, i3, i4));
        }

        public void setStableInsets(Insets insets) {
        }
    }

    public static class Impl30 extends Impl29 {
        public static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        public Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public final void copyRootViewBounds(View view) {
        }
    }

    static {
        if (VERSION.SDK_INT >= 30) {
            CONSUMED = Impl30.CONSUMED;
        } else {
            CONSUMED = Impl.CONSUMED;
        }
    }

    public WindowInsetsCompat(WindowInsets windowInsets) {
        int i = VERSION.SDK_INT;
        if (i >= 30) {
            this.mImpl = new Impl30(this, windowInsets);
        } else if (i >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
        } else if (i >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
        } else {
            this.mImpl = new Impl21(this, windowInsets);
        }
    }

    public static Insets insetInsets(Insets insets, int i, int i2, int i3, int i4) {
        int max = Math.max(0, insets.left - i);
        int max2 = Math.max(0, insets.top - i2);
        int max3 = Math.max(0, insets.right - i3);
        int max4 = Math.max(0, insets.bottom - i4);
        if (max == i && max2 == i2 && max3 == i3 && max4 == i4) {
            return insets;
        }
        return Insets.of(max, max2, max3, max4);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return Objects.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    public int hashCode() {
        Impl impl = this.mImpl;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        BuilderImpl builderImpl;
        int i5 = VERSION.SDK_INT;
        if (i5 >= 30) {
            builderImpl = new BuilderImpl30(this);
        } else if (i5 >= 29) {
            builderImpl = new BuilderImpl29(this);
        } else {
            builderImpl = new BuilderImpl20(this);
        }
        builderImpl.setSystemWindowInsets(Insets.of(i, i2, i3, i4));
        return builderImpl.build();
    }

    public WindowInsets toWindowInsets() {
        Impl impl = this.mImpl;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).mPlatformInsets;
        }
        return null;
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets, View view) {
        if (windowInsets != null) {
            WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat(windowInsets);
            if (view != null && view.isAttachedToWindow()) {
                windowInsetsCompat.mImpl.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
                windowInsetsCompat.mImpl.copyRootViewBounds(view.getRootView());
            }
            return windowInsetsCompat;
        }
        throw null;
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        this.mImpl = new Impl(this);
    }
}
