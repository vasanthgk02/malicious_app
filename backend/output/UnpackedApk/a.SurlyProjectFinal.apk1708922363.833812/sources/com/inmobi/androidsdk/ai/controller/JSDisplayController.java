package com.inmobi.androidsdk.ai.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.container.IMWebView.ViewState;
import com.inmobi.androidsdk.ai.controller.JSController.Dimensions;
import com.inmobi.androidsdk.ai.controller.JSController.ExpandProperties;
import com.inmobi.androidsdk.impl.Constants;
import org.json.JSONObject;

public class JSDisplayController extends JSController {
    private float mDensity = ((Activity) this.mContext).getResources().getDisplayMetrics().density;
    private WindowManager mWindowManager;

    public JSDisplayController(IMWebView adView, Context c) {
        super(adView, c);
        DisplayMetrics metrics = new DisplayMetrics();
        this.mWindowManager = (WindowManager) c.getSystemService("window");
        this.mWindowManager.getDefaultDisplay().getMetrics(metrics);
    }

    public void open(String url) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSDisplayController-> open: url: " + url);
        }
        if (!URLUtil.isValidUrl(url)) {
            this.imWebView.raiseError("Invalid url", "open");
        } else {
            this.imWebView.openURL(url);
        }
    }

    public String getState() {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSDisplayController-> getState ");
        }
        return this.imWebView.getState();
    }

    /* access modifiers changed from: 0000 */
    public Dimensions getDeviceDimensions(Dimensions d) {
        int topStuff = 0;
        int bottomStuff = 0;
        Display display = this.mWindowManager.getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Width: " + width + " height: " + height);
        }
        d.width = (int) (((float) d.width) * this.mDensity);
        d.height = (int) (((float) d.height) * this.mDensity);
        d.x = (int) (((float) d.x) * this.mDensity);
        d.y = (int) (((float) d.y) * this.mDensity);
        if (d.height < 0) {
            d.height = this.imWebView.getHeight();
        }
        if (d.width < 0) {
            d.width = this.imWebView.getWidth();
        }
        int[] loc = new int[2];
        this.imWebView.getLocationOnScreen(loc);
        if (d.x < 0) {
            d.x = loc[0];
        }
        if (d.y < 0) {
            View contentView = ((Activity) this.mContext).findViewById(16908290);
            topStuff = contentView.getTop();
            bottomStuff = height - contentView.getBottom();
            d.y = loc[1] - topStuff;
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "topStuff: " + topStuff + " ,bottomStuff: " + bottomStuff);
            }
        }
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "loc 0: " + loc[0] + " loc 1: " + loc[1]);
        }
        int widthDiff = width - (d.x + d.width);
        if (widthDiff < 0) {
            d.x += widthDiff;
        }
        if (d.x < 0) {
            d.x = 0;
        }
        int heightDiff = height - (d.y + d.height);
        if (heightDiff < 0) {
            d.y += heightDiff;
            d.y -= topStuff;
            d.y -= bottomStuff;
        }
        if (d.y < 0) {
            d.y = 0;
        }
        return d;
    }

    private ExpandProperties getExpandXYCoordinate(ExpandProperties props) {
        int curRotation;
        int curRotation2;
        Display display = this.mWindowManager.getDefaultDisplay();
        int width = ((Activity) this.mContext).getResources().getDisplayMetrics().widthPixels;
        int height = ((Activity) this.mContext).getResources().getDisplayMetrics().heightPixels;
        View contentView = ((Activity) this.mContext).getWindow().findViewById(16908290);
        props.topStuff = contentView.getTop();
        props.bottomStuff = height - contentView.getBottom();
        if (VERSION.SDK_INT >= 8) {
            curRotation = display.getRotation();
        } else {
            curRotation = display.getOrientation();
        }
        if (this.imWebView.getWhetherTablet(curRotation2, width, height)) {
            curRotation2++;
            if (curRotation2 > 3) {
                curRotation2 = 0;
            }
            this.imWebView.isTablet = true;
        }
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Device current rotation: " + curRotation2);
            Log.d(Constants.LOGGING_TAG, "Density of device: " + this.mDensity);
        }
        props.width = (int) (((float) props.width) * this.mDensity);
        props.height = (int) (((float) props.height) * this.mDensity);
        props.x = (int) (((float) props.x) * this.mDensity);
        props.y = (int) (((float) props.y) * this.mDensity);
        props.currentX = 0;
        props.currentY = 0;
        this.imWebView.publisherOrientation = ((Activity) this.imWebView.getContext()).getRequestedOrientation();
        if (curRotation2 == 0 || curRotation2 == 2) {
            props.rotationAtExpand = "portrait";
        } else {
            props.rotationAtExpand = "landscape";
        }
        props.checkFlag = false;
        if (props.lockOrientation && this.imWebView.publisherOrientation == -1 && props.rotationAtExpand.equals(props.orientation)) {
            props.checkFlag = this.imWebView.adCreativeLocksOrientation(props, curRotation2);
        }
        if (props.lockOrientation && this.imWebView.publisherOrientation == 0 && props.orientation.equals("landscape")) {
            props.checkFlag = true;
        }
        if (props.lockOrientation && this.imWebView.publisherOrientation == 1 && props.orientation.equals("portrait")) {
            props.checkFlag = true;
        }
        if (!props.lockOrientation) {
            props.checkFlag = true;
        }
        if (props.checkFlag) {
            if (props.height <= 0 || props.width <= 0) {
                props.height = height;
                props.width = width;
                props.zeroWidthHeight = true;
            }
            if (curRotation2 == 0 || curRotation2 == 2) {
                props.portraitWidthRequested = props.width;
                props.portraitHeightRequested = props.height;
            } else {
                props.portraitWidthRequested = props.height;
                props.portraitHeightRequested = props.width;
            }
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, " Device Width: " + width + " Device height: " + height);
            }
            int height2 = height - props.topStuff;
            if (props.width > width) {
                props.width = width;
            }
            if (props.height > height2) {
                props.height = height2;
            }
            int[] loc = new int[2];
            this.imWebView.getLocationOnScreen(loc);
            if (props.x < 0) {
                props.x = loc[0];
            }
            if (props.y < 0) {
                props.y = loc[1] - props.topStuff;
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "topStuff: " + props.topStuff + " ,bottomStuff: " + props.bottomStuff);
                }
            }
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "loc 0: " + loc[0] + " loc 1: " + loc[1]);
            }
            int widthDiff = width - (props.x + props.width);
            if (widthDiff < 0) {
                props.x += widthDiff;
                if (props.x < 0) {
                    props.width += props.x;
                    props.x = 0;
                }
            }
            int heightDiff = height2 - (props.y + props.height);
            if (heightDiff < 0) {
                props.y += heightDiff;
                if (props.y < 0) {
                    props.height += props.y;
                    props.y = 0;
                }
            }
            props.currentX = props.x;
            props.currentY = props.y;
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "final expanded width after density : " + props.width + "final expanded height after density " + props.height + "portrait width requested :" + props.portraitWidthRequested + "portrait height requested :" + props.portraitHeightRequested);
            }
        }
        return props;
    }

    public void setExpandProperties(String props) {
        try {
            this.expProps = (ExpandProperties) getFromJSON(new JSONObject(props), ExpandProperties.class);
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "JSDisplayController-> ExpandProperties is set: expProps.width: " + this.expProps.width + "expProps.height: " + this.expProps.height + "expProps.orientation: " + this.expProps.orientation + "expProps.boolean1: " + this.expProps.lockOrientation + "expProps.boolean2: " + this.expProps.isModal + "expProps.boolean3: " + this.expProps.useCustomClose);
            }
            this.imWebView.setExpandPropertiesForInterstitial(this.expProps.useCustomClose, this.expProps.lockOrientation, this.expProps.orientation);
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception while setting the expand properties", e);
            }
        }
    }

    public void expand(String URL) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSDisplayController-> expand: url: " + URL);
        }
        try {
            this.imWebView.useLockOrient = false;
            if (this.imWebView.getStateVariable() != ViewState.DEFAULT) {
                this.imWebView.injectJavaScript("window.mraidview.fireErrorEvent(\"Current state is not default\", \"expand\")");
            } else if (this.imWebView.getStateVariable() != ViewState.DEFAULT || !this.imWebView.mIsInterstitialAd) {
                copyExpandProperties(this.temporaryexpProps, this.expProps);
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "JSDisplayController-> At the time of expand the properties are: tempexpProps.width: " + this.temporaryexpProps.width + "tempexpProps.height: " + this.temporaryexpProps.height + "tempexpProps.orientation: " + this.temporaryexpProps.orientation + "tempexpProps.boolean1: " + this.temporaryexpProps.lockOrientation + "tempexpProps.boolean2: " + this.temporaryexpProps.isModal + "tempexpProps.boolean3: " + this.temporaryexpProps.useCustomClose);
                }
                this.imWebView.expand(URL, getExpandXYCoordinate(this.temporaryexpProps));
            } else {
                this.imWebView.injectJavaScript("window.mraidview.fireErrorEvent(\"Expand cannot be called on interstitial ad\", \"expand\")");
            }
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception while expanding the ad.", e);
            }
        }
    }

    private void copyExpandProperties(ExpandProperties mtemporaryexpProps, ExpandProperties mexpProps) {
        mtemporaryexpProps.width = mexpProps.width;
        mtemporaryexpProps.height = mexpProps.height;
        mtemporaryexpProps.x = mexpProps.x;
        mtemporaryexpProps.y = mexpProps.y;
        mtemporaryexpProps.actualWidthRequested = mexpProps.actualWidthRequested;
        mtemporaryexpProps.actualHeightRequested = mexpProps.actualHeightRequested;
        mtemporaryexpProps.lockOrientation = mexpProps.lockOrientation;
        mtemporaryexpProps.isModal = mexpProps.isModal;
        mtemporaryexpProps.useCustomClose = mexpProps.useCustomClose;
        mtemporaryexpProps.orientation = mexpProps.orientation;
        mtemporaryexpProps.topStuff = mexpProps.topStuff;
        mtemporaryexpProps.bottomStuff = mexpProps.bottomStuff;
        mtemporaryexpProps.portraitWidthRequested = mexpProps.portraitWidthRequested;
        mtemporaryexpProps.portraitHeightRequested = mexpProps.portraitHeightRequested;
        mtemporaryexpProps.zeroWidthHeight = mexpProps.zeroWidthHeight;
        mtemporaryexpProps.rotationAtExpand = mexpProps.rotationAtExpand;
        mtemporaryexpProps.checkFlag = mexpProps.checkFlag;
        mtemporaryexpProps.currentX = mexpProps.currentX;
        mtemporaryexpProps.currentY = mexpProps.currentY;
    }

    public void useCustomClose(boolean customClose) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSDisplayController-> useCustomClose" + customClose);
        }
        this.imWebView.setCustomClose(customClose);
    }

    public void close() {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSDisplayController-> close");
        }
        if (this.imWebView.mOriginalWebviewForExpandUrl != null) {
            this.imWebView.mOriginalWebviewForExpandUrl.close();
        } else {
            this.imWebView.close();
        }
    }

    public boolean isViewable() {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSDisplayController-> isViewable ");
        }
        return this.imWebView.isViewable();
    }

    public String getPlacementType() {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSDisplayController-> getPlacementType ");
        }
        return this.imWebView.getPlacementType();
    }

    public String getOrientation() {
        String ret;
        try {
            ret = this.imWebView.getCurrentRotation(this.imWebView.getIntegerCurrentRotation());
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "JSDisplayController-> getOrientation: " + ret);
            }
        } catch (Exception e) {
            ret = "-1";
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "JSDisplayController-> Error getOrientation: " + ret);
            }
        }
        return ret;
    }

    public void stopAllListeners() {
    }
}
