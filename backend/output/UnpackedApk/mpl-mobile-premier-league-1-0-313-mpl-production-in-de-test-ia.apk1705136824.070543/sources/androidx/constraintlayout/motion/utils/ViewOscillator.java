package androidx.constraintlayout.motion.utils;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public abstract class ViewOscillator extends KeyCycleOscillator {

    public static class AlphaSet extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setAlpha(get(f2));
        }
    }

    public static class CustomSet extends ViewOscillator {
        public ConstraintAttribute mCustom;
        public float[] value = new float[1];

        public void setCustom(Object obj) {
            this.mCustom = (ConstraintAttribute) obj;
        }

        public void setProperty(View view, float f2) {
            this.value[0] = get(f2);
            this.mCustom.setInterpolatedValue(view, this.value);
        }
    }

    public static class ElevationSet extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setElevation(get(f2));
        }
    }

    public static class PathRotateSet extends ViewOscillator {
        public void setProperty(View view, float f2) {
        }
    }

    public static class ProgressSet extends ViewOscillator {
        public boolean mNoMethod = false;

        public void setProperty(View view, float f2) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f2));
            } else if (!this.mNoMethod) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f2))});
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
        }
    }

    public static class RotationSet extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setRotation(get(f2));
        }
    }

    public static class RotationXset extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setRotationX(get(f2));
        }
    }

    public static class RotationYset extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setRotationY(get(f2));
        }
    }

    public static class ScaleXset extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setScaleX(get(f2));
        }
    }

    public static class ScaleYset extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setScaleY(get(f2));
        }
    }

    public static class TranslationXset extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setTranslationX(get(f2));
        }
    }

    public static class TranslationYset extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setTranslationY(get(f2));
        }
    }

    public static class TranslationZset extends ViewOscillator {
        public void setProperty(View view, float f2) {
            view.setTranslationZ(get(f2));
        }
    }

    public static ViewOscillator makeSpline(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 10;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = Tokenizer.FF;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 13;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c2 = 9;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 2;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 1;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 5;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 0;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 8;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new AlphaSet();
            case 1:
                return new ElevationSet();
            case 2:
                return new RotationSet();
            case 3:
                return new RotationXset();
            case 4:
                return new RotationYset();
            case 5:
                return new PathRotateSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case 8:
                return new AlphaSet();
            case 9:
                return new AlphaSet();
            case 10:
                return new TranslationXset();
            case 11:
                return new TranslationYset();
            case 12:
                return new TranslationZset();
            case 13:
                return new ProgressSet();
            default:
                return null;
        }
    }

    public abstract void setProperty(View view, float f2);
}
