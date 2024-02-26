package com.inmobi.androidsdk.ai.controller;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.controller.util.NavigationStringEnum;
import com.inmobi.androidsdk.ai.controller.util.TransitionStringEnum;
import com.inmobi.androidsdk.impl.Constants;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JSController {
    private static final String BOOLEAN_TYPE = "boolean";
    public static final String EXIT = "exit";
    private static final String FLOAT_TYPE = "float";
    public static final String FULL_SCREEN = "fullscreen";
    private static final String INT_TYPE = "int";
    private static final String NAVIGATION_TYPE = "class com.mraid.NavigationStringEnum";
    private static final String STRING_TYPE = "class java.lang.String";
    public static final String STYLE_NORMAL = "normal";
    private static final String TRANSITION_TYPE = "class com.mraid.TransitionStringEnum";
    protected ExpandProperties expProps = new ExpandProperties();
    protected IMWebView imWebView;
    protected Context mContext;
    protected ExpandProperties temporaryexpProps = new ExpandProperties();

    public static class Dimensions extends ReflectedParcelable {
        public static final Creator<Dimensions> CREATOR = new Creator<Dimensions>() {
            public Dimensions createFromParcel(Parcel in) {
                return new Dimensions(in);
            }

            public Dimensions[] newArray(int size) {
                return new Dimensions[size];
            }
        };
        public int height;
        public int width;
        public int x;
        public int y;

        public Dimensions() {
            this.x = -1;
            this.y = -1;
            this.width = -1;
            this.height = -1;
        }

        protected Dimensions(Parcel in) {
            super(in);
        }

        public String toString() {
            return "x: " + this.x + ", y: " + this.y + ", width: " + this.width + ", height: " + this.height;
        }
    }

    public static class ExpandProperties extends ReflectedParcelable {
        public static final Creator<ExpandProperties> CREATOR = new Creator<ExpandProperties>() {
            public ExpandProperties createFromParcel(Parcel in) {
                return new ExpandProperties(in);
            }

            public ExpandProperties[] newArray(int size) {
                return new ExpandProperties[size];
            }
        };
        public int actualHeightRequested;
        public int actualWidthRequested;
        public int bottomStuff;
        public boolean checkFlag;
        public int currentX;
        public int currentY;
        public int height;
        public boolean isModal;
        public boolean lockOrientation;
        public String orientation;
        public int portraitHeightRequested;
        public int portraitWidthRequested;
        public String rotationAtExpand;
        public int topStuff;
        public boolean useCustomClose;
        public int width;
        public int x;
        public int y;
        public boolean zeroWidthHeight;

        public ExpandProperties() {
            this.width = 0;
            this.height = 0;
            this.x = -1;
            this.y = -1;
            this.useCustomClose = false;
            this.isModal = true;
            this.lockOrientation = false;
            this.orientation = Constants.QA_SERVER_URL;
            this.actualWidthRequested = 0;
            this.actualHeightRequested = 0;
            this.topStuff = 0;
            this.bottomStuff = 0;
            this.portraitWidthRequested = 0;
            this.portraitHeightRequested = 0;
            this.zeroWidthHeight = false;
            this.rotationAtExpand = Constants.QA_SERVER_URL;
            this.checkFlag = true;
            this.currentX = 0;
            this.currentY = 0;
        }

        public void reinitializeExpandProperties() {
            this.width = 0;
            this.height = 0;
            this.x = -1;
            this.y = -1;
            this.useCustomClose = false;
            this.isModal = true;
            this.lockOrientation = false;
            this.orientation = Constants.QA_SERVER_URL;
            this.actualWidthRequested = 0;
            this.actualHeightRequested = 0;
            this.topStuff = 0;
            this.bottomStuff = 0;
            this.portraitWidthRequested = 0;
            this.portraitHeightRequested = 0;
            this.zeroWidthHeight = false;
            this.rotationAtExpand = Constants.QA_SERVER_URL;
            this.checkFlag = true;
            this.currentX = 0;
            this.currentY = 0;
        }

        protected ExpandProperties(Parcel in) {
            super(in);
        }
    }

    public static class PlayerProperties extends ReflectedParcelable {
        public static final Creator<PlayerProperties> CREATOR = new Creator<PlayerProperties>() {
            public PlayerProperties createFromParcel(Parcel in) {
                return new PlayerProperties(in);
            }

            public PlayerProperties[] newArray(int size) {
                return new PlayerProperties[size];
            }
        };
        public boolean audioMuted;
        public boolean autoPlay;
        public boolean doLoop;
        public String id;
        public boolean showControl;
        public String startStyle;
        public String stopStyle;

        public PlayerProperties() {
            this.showControl = true;
            this.autoPlay = true;
            this.audioMuted = false;
            this.doLoop = false;
            this.stopStyle = JSController.STYLE_NORMAL;
            this.startStyle = JSController.STYLE_NORMAL;
            this.id = Constants.QA_SERVER_URL;
        }

        public PlayerProperties(Parcel in) {
            super(in);
        }

        public void setStopStyle(String style) {
            this.stopStyle = style;
        }

        public void setProperties(boolean audioMuted2, boolean autoPlay2, boolean controls, boolean loop, String startStyle2, String stopStyle2, String id2) {
            this.autoPlay = autoPlay2;
            this.showControl = controls;
            this.doLoop = loop;
            this.audioMuted = audioMuted2;
            this.startStyle = startStyle2;
            this.stopStyle = stopStyle2;
            this.id = id2;
        }

        public boolean isAutoPlay() {
            return this.autoPlay;
        }

        public boolean showControl() {
            return this.showControl;
        }

        public boolean doLoop() {
            return this.doLoop;
        }

        public boolean doMute() {
            return this.audioMuted;
        }

        public boolean exitOnComplete() {
            return this.stopStyle.equalsIgnoreCase(JSController.EXIT);
        }

        public boolean isFullScreen() {
            return this.startStyle.equalsIgnoreCase(JSController.FULL_SCREEN);
        }

        public void setFullScreen() {
            this.startStyle = JSController.FULL_SCREEN;
        }
    }

    public static class Properties extends ReflectedParcelable {
        public static final Creator<Properties> CREATOR = new Creator<Properties>() {
            public Properties createFromParcel(Parcel in) {
                return new Properties(in);
            }

            public Properties[] newArray(int size) {
                return new Properties[size];
            }
        };
        public int backgroundColor;
        public float backgroundOpacity;
        public boolean useBackground;

        protected Properties(Parcel in) {
            super(in);
        }

        public Properties() {
            this.useBackground = false;
            this.backgroundColor = 0;
            this.backgroundOpacity = 0.0f;
        }
    }

    public static class ReflectedParcelable implements Parcelable {
        public ReflectedParcelable() {
        }

        public int describeContents() {
            return 0;
        }

        protected ReflectedParcelable(Parcel in) {
            Field[] fieldArr = null;
            Field[] fields = getClass().getDeclaredFields();
            int i = 0;
            while (i < fields.length) {
                try {
                    Field f = fields[i];
                    Class<?> type = f.getType();
                    if (type.isEnum()) {
                        String typeStr = type.toString();
                        if (typeStr.equals(JSController.NAVIGATION_TYPE)) {
                            f.set(this, NavigationStringEnum.fromString(in.readString()));
                        } else if (typeStr.equals(JSController.TRANSITION_TYPE)) {
                            f.set(this, TransitionStringEnum.fromString(in.readString()));
                        }
                    } else if (!(f.get(this) instanceof Creator)) {
                        f.set(this, in.readValue(null));
                    }
                    i++;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }

        public void writeToParcel(Parcel out, int flags1) {
            Field[] fieldArr = null;
            Field[] fields = getClass().getDeclaredFields();
            int i = 0;
            while (i < fields.length) {
                try {
                    Field f = fields[i];
                    Class<?> type = f.getType();
                    if (type.isEnum()) {
                        String typeStr = type.toString();
                        if (typeStr.equals(JSController.NAVIGATION_TYPE)) {
                            out.writeString(((NavigationStringEnum) f.get(this)).getText());
                        } else if (typeStr.equals(JSController.TRANSITION_TYPE)) {
                            out.writeString(((TransitionStringEnum) f.get(this)).getText());
                        }
                    } else {
                        Object dt = f.get(this);
                        if (!(dt instanceof Creator)) {
                            out.writeValue(dt);
                        }
                    }
                    i++;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    public abstract void stopAllListeners();

    public void reinitializeExpandProperties() {
        this.expProps.reinitializeExpandProperties();
    }

    public JSController(IMWebView adView, Context context) {
        this.imWebView = adView;
        this.mContext = context;
    }

    protected static Object getFromJSON(JSONObject json, Class<?> c) throws IllegalAccessException, InstantiationException, NumberFormatException, NullPointerException {
        int iVal;
        Field[] fieldArr = null;
        Field[] fields = c.getDeclaredFields();
        Object obj = c.newInstance();
        for (Field f : fields) {
            String JSONName = f.getName().replace('_', '-');
            String typeStr = f.getType().toString();
            try {
                if (typeStr.equals(INT_TYPE)) {
                    String value = json.getString(JSONName).toLowerCase();
                    if (value.startsWith("#")) {
                        iVal = -1;
                        try {
                            if (value.startsWith("#0x")) {
                                iVal = Integer.decode(value.substring(1)).intValue();
                            } else {
                                iVal = Integer.parseInt(value.substring(1), 16);
                            }
                        } catch (NumberFormatException e) {
                        }
                    } else {
                        iVal = Integer.parseInt(value);
                    }
                    f.set(obj, Integer.valueOf(iVal));
                } else if (typeStr.equals(STRING_TYPE)) {
                    f.set(obj, json.getString(JSONName));
                } else if (typeStr.equals(BOOLEAN_TYPE)) {
                    f.set(obj, Boolean.valueOf(json.getBoolean(JSONName)));
                } else if (typeStr.equals(FLOAT_TYPE)) {
                    f.set(obj, Float.valueOf(Float.parseFloat(json.getString(JSONName))));
                } else if (typeStr.equals(NAVIGATION_TYPE)) {
                    f.set(obj, NavigationStringEnum.fromString(json.getString(JSONName)));
                } else if (typeStr.equals(TRANSITION_TYPE)) {
                    f.set(obj, TransitionStringEnum.fromString(json.getString(JSONName)));
                }
            } catch (JSONException e2) {
            }
        }
        return obj;
    }
}
