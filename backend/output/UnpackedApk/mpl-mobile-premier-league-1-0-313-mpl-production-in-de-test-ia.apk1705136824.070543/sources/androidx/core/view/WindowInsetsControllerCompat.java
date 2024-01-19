package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.badlogic.gdx.graphics.GL30;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;

public final class WindowInsetsControllerCompat {
    public final Impl mImpl;

    public static class Impl {
        public abstract void hide(int i);

        public void setAppearanceLightNavigationBars(boolean z) {
        }

        public void setAppearanceLightStatusBars(boolean z) {
        }

        public abstract void setSystemBarsBehavior(int i);

        public abstract void show(int i);
    }

    public static class Impl20 extends Impl {
        public final View mView;
        public final Window mWindow;

        public Impl20(Window window, View view) {
            this.mWindow = window;
            this.mView = view;
        }

        public void hide(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    if (i2 == 1) {
                        setSystemUiFlag(4);
                    } else if (i2 == 2) {
                        setSystemUiFlag(2);
                    } else if (i2 == 8) {
                        ((InputMethodManager) this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
                    }
                }
            }
        }

        public void setSystemBarsBehavior(int i) {
            if (i == 0) {
                unsetSystemUiFlag(GL30.GL_COLOR);
            } else if (i == 1) {
                unsetSystemUiFlag(4096);
                setSystemUiFlag(2048);
            } else if (i == 2) {
                unsetSystemUiFlag(2048);
                setSystemUiFlag(4096);
            }
        }

        public void setSystemUiFlag(int i) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        public void show(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    if (i2 == 1) {
                        unsetSystemUiFlag(4);
                        this.mWindow.clearFlags(1024);
                    } else if (i2 == 2) {
                        unsetSystemUiFlag(2);
                    } else if (i2 == 8) {
                        final View view = this.mView;
                        if (view == null || (!view.isInEditMode() && !view.onCheckIsTextEditor())) {
                            view = this.mWindow.getCurrentFocus();
                        } else {
                            view.requestFocus();
                        }
                        if (view == null) {
                            view = this.mWindow.findViewById(16908290);
                        }
                        if (view != null && view.hasWindowFocus()) {
                            view.post(new Runnable(this) {
                                public void run() {
                                    ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                                }
                            });
                        }
                    }
                }
            }
        }

        public void unsetSystemUiFlag(int i) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }
    }

    public static class Impl23 extends Impl20 {
        public Impl23(Window window, View view) {
            super(window, view);
        }

        public void setAppearanceLightStatusBars(boolean z) {
            if (z) {
                this.mWindow.clearFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
                this.mWindow.addFlags(LinearLayoutManager.INVALID_OFFSET);
                setSystemUiFlag(8192);
                return;
            }
            unsetSystemUiFlag(8192);
        }
    }

    public static class Impl26 extends Impl23 {
        public Impl26(Window window, View view) {
            super(window, view);
        }

        public void setAppearanceLightNavigationBars(boolean z) {
            if (z) {
                this.mWindow.clearFlags(134217728);
                this.mWindow.addFlags(LinearLayoutManager.INVALID_OFFSET);
                setSystemUiFlag(16);
                return;
            }
            unsetSystemUiFlag(16);
        }
    }

    public static class Impl30 extends Impl {
        public final WindowInsetsController mInsetsController;

        public Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this.mInsetsController = window.getInsetsController();
        }

        public void hide(int i) {
            this.mInsetsController.hide(i);
        }

        public void setAppearanceLightNavigationBars(boolean z) {
            if (z) {
                this.mInsetsController.setSystemBarsAppearance(16, 16);
            } else {
                this.mInsetsController.setSystemBarsAppearance(0, 16);
            }
        }

        public void setAppearanceLightStatusBars(boolean z) {
            if (z) {
                this.mInsetsController.setSystemBarsAppearance(8, 8);
            } else {
                this.mInsetsController.setSystemBarsAppearance(0, 8);
            }
        }

        public void setSystemBarsBehavior(int i) {
            this.mInsetsController.setSystemBarsBehavior(i);
        }

        public void show(int i) {
            this.mInsetsController.show(i);
        }
    }

    public WindowInsetsControllerCompat(Window window, View view) {
        int i = VERSION.SDK_INT;
        if (i >= 30) {
            this.mImpl = new Impl30(window, this);
        } else if (i >= 26) {
            this.mImpl = new Impl26(window, view);
        } else if (i >= 23) {
            this.mImpl = new Impl23(window, view);
        } else {
            this.mImpl = new Impl20(window, view);
        }
    }
}
