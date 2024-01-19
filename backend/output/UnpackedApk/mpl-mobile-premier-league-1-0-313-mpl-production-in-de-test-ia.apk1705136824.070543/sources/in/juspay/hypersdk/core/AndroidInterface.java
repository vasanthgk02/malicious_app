package in.juspay.hypersdk.core;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import in.juspay.hypersdk.mystique.ErrorCallback;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AndroidInterface {
    public final DynamicUI dynamicUI;
    public final Set<String> onGoingPrepareScreenSet = new HashSet();
    public final Map<String, PendingAddScreenMapItem> pendingAddScreenMap = new HashMap();
    public String state;
    public final Handler uiHandler;

    public static final class PendingAddScreenMapItem {
        public String callbackName;
        public int index;
        public String parentId;
        public boolean replaceChild;
        public String runInUIprop;
        public String screenName;

        public PendingAddScreenMapItem(String str, String str2, int i, String str3, boolean z, String str4) {
            this.parentId = str;
            this.screenName = str2;
            this.index = i;
            this.callbackName = str3;
            this.replaceChild = z;
            this.runInUIprop = str4;
        }
    }

    public class PreRenderThread extends Thread {
        public PreRenderThread(Runnable runnable) {
            super(runnable);
        }
    }

    public AndroidInterface(DynamicUI dynamicUI2) {
        this.dynamicUI = dynamicUI2;
        this.uiHandler = new Handler(Looper.getMainLooper());
    }

    private int findChildIndex(int i, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (viewGroup.getChildAt(i2).getId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public boolean replaceViewImpl(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        int findChildIndex = findChildIndex(view2.getId(), viewGroup);
        if (findChildIndex == -1) {
            return false;
        }
        viewGroup.removeViewAt(findChildIndex);
        viewGroup.addView(view, findChildIndex);
        return true;
    }

    private void runOnUiThread(Runnable runnable) {
        this.uiHandler.post(runnable);
    }

    @JavascriptInterface
    @Deprecated
    public void Render(String str, String str2) {
        render(str, str2, null);
    }

    @JavascriptInterface
    @Deprecated
    public void Render(String str, String str2, String str3) {
        render(str, str2, str3, null);
    }

    @JavascriptInterface
    public void addStoredViewToParent(String str, String str2, int i, String str3, boolean z, String str4) {
        addStoredViewToParent(str, str2, i, str3, z, str4, null);
    }

    @JavascriptInterface
    public void addStoredViewToParent(String str, String str2, int i, String str3, boolean z, String str4, String str5) {
        final String str6 = str2;
        final String str7 = str;
        final int i2 = i;
        final String str8 = str3;
        final boolean z2 = z;
        final String str9 = str4;
        final String str10 = str5;
        AnonymousClass4 r0 = new Runnable() {
            public void run() {
                try {
                    if (AndroidInterface.this.onGoingPrepareScreenSet.contains(str6)) {
                        Map access$200 = AndroidInterface.this.pendingAddScreenMap;
                        String str = str6;
                        PendingAddScreenMapItem pendingAddScreenMapItem = new PendingAddScreenMapItem(str7, str6, i2, str8, z2, str9);
                        access$200.put(str, pendingAddScreenMapItem);
                        return;
                    }
                    AndroidInterface.this.dynamicUI.getRenderer().addStoredViewToParent(str7, str6, i2, z2, str10);
                    InflateView inflateView = new InflateView(AndroidInterface.this.dynamicUI);
                    inflateView.setUseAppContext(true);
                    AndroidInterface.this.dynamicUI.getRenderer().parseAndRunPipe(AndroidInterface.this.dynamicUI.getAppContext(), str9, "", "", inflateView.getUseAppContext());
                    if (str8 != null) {
                        DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                        access$000.addJsToWebView("window.callUICallback('" + str8 + "','success');");
                    }
                } catch (Exception e2) {
                    DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73(" excep: fn__addStoredViewToParent  - ");
                    outline73.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                    logger.e("ERROR", outline73.toString());
                    ErrorCallback errorCallback = AndroidInterface.this.dynamicUI.getErrorCallback();
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73(" excep: fn__addStoredViewToParent  - ");
                    outline732.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                    errorCallback.onException("ERROR", outline732.toString(), e2);
                }
            }
        };
        runOnUiThread(r0);
    }

    @JavascriptInterface
    public String addToContainerList(int i, String str) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        return (container == null || !(container.findViewById(i) instanceof ViewGroup)) ? "__failed" : this.dynamicUI.addToContainerList((ViewGroup) container.findViewById(i));
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3) {
        addViewToParent(str, str2, i, str3, (String) null);
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3, String str4) {
        addViewToParent(str, str2, i, str3, false, str4);
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3, boolean z) {
        addViewToParent(str, str2, i, str3, z, null);
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3, boolean z, String str4) {
        try {
            final JSONObject jSONObject = new JSONObject(str2);
            final String str5 = str;
            final int i2 = i;
            final boolean z2 = z;
            final String str6 = str4;
            final String str7 = str3;
            AnonymousClass2 r0 = new Runnable() {
                public void run() {
                    try {
                        AndroidInterface.this.dynamicUI.getRenderer().addViewToParent(str5, jSONObject, i2, z2, str6);
                        if (str7 != null) {
                            DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                            access$000.addJsToWebView("window.callUICallback('" + str7 + "','success');");
                        }
                    } catch (Exception e2) {
                        DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" excep: fn__addViewToParent  - ");
                        outline73.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                        logger.e("ERROR", outline73.toString());
                        ErrorCallback errorCallback = AndroidInterface.this.dynamicUI.getErrorCallback();
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73(" excep: fn__addViewToParent  - ");
                        outline732.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                        errorCallback.onException("ERROR", outline732.toString(), e2);
                        if (str7 != null) {
                            DynamicUI access$0002 = AndroidInterface.this.dynamicUI;
                            StringBuilder outline733 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                            outline733.append(str7);
                            outline733.append("','failure');");
                            access$0002.addJsToWebView(outline733.toString());
                        }
                    }
                }
            };
            runOnUiThread(r0);
        } catch (JSONException unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("JSONERROR", "Error while parsing " + str2);
        }
    }

    @JavascriptInterface
    public void cancelAnim(final String str, final String str2) {
        InflateView inflateView = this.dynamicUI.getRenderer().getInflateView();
        final ObjectAnimator objectAnimator = (ObjectAnimator) ((Pair) inflateView.getStateValFromKey("M_anim_" + str)).second;
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    objectAnimator.cancel();
                    float floatValue = ((Float) objectAnimator.getAnimatedValue()).floatValue();
                    DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                    access$000.addJsToWebView("window.callUICallback('" + str2 + "', '" + floatValue + "');");
                } catch (Exception unused) {
                    DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error parsing json for animation with id ");
                    outline73.append(str);
                    logger.e("JSONERROR", outline73.toString());
                }
            }
        });
    }

    @JavascriptInterface
    public void dismissPopUp() {
        this.dynamicUI.getRenderer().dismissPopUp();
    }

    @JavascriptInterface
    public int dpToPx(int i) {
        if (i > 0) {
            return Math.round(((float) i) * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        }
        return 0;
    }

    @JavascriptInterface
    public String fetchData(String str) {
        return this.dynamicUI.getAppContext().getSharedPreferences("DUI", 0).getString(str, "null");
    }

    @JavascriptInterface
    public void generateUIElement(String str, int i, String[] strArr, String str2) {
        generateUIElement(str, i, strArr, str2, null);
    }

    @JavascriptInterface
    public void generateUIElement(String str, int i, String[] strArr, String str2, String str3) {
        if (this.dynamicUI.getContainer(str3) != null) {
            final String str4 = str;
            final String str5 = str3;
            final int i2 = i;
            final String[] strArr2 = strArr;
            final String str6 = str2;
            AnonymousClass14 r1 = new Runnable() {
                public void run() {
                    if (str4.equals("PopupMenu")) {
                        AndroidInterface.this.dynamicUI.getContainer(str5).findViewById(i2).setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                AnonymousClass14 r0 = AnonymousClass14.this;
                                AndroidInterface.this.showPopup(view, strArr2, str6);
                            }
                        });
                    }
                }
            };
            runOnUiThread(r1);
            return;
        }
        this.dynamicUI.getLogger().e("missing_container", "render, no container");
    }

    @JavascriptInterface
    public String getInternalStorageBaseFilePath() {
        return this.dynamicUI.getAppContext().getDir("juspay", 0).getAbsolutePath();
    }

    @JavascriptInterface
    public String getNewID() {
        return String.valueOf(ViewCompat.generateViewId());
    }

    public Renderer getRenderer() {
        return this.dynamicUI.getRenderer();
    }

    @JavascriptInterface
    public String getScreenDimensions() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.dynamicUI.getActivity() != null) {
            this.dynamicUI.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            displayMetrics = Resources.getSystem().getDisplayMetrics();
        }
        return GeneratedOutlineSupport.outline44("{\"width\":", displayMetrics.widthPixels, ",\"height\":", displayMetrics.heightPixels, " }");
    }

    @JavascriptInterface
    public String getState() {
        String str = this.state;
        return str != null ? str : "{}";
    }

    @JavascriptInterface
    public boolean isFilePresent(String str) {
        return new File(str).exists();
    }

    @JavascriptInterface
    public void moveView(String str, String str2) {
        moveView(str, str2, null);
    }

    @JavascriptInterface
    public void moveView(final String str, final String str2, final String str3) {
        if (this.dynamicUI.getContainer(str3) != null) {
            runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        View findViewById = AndroidInterface.this.dynamicUI.getContainer(str3).findViewById(Integer.parseInt(str));
                        ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                        viewGroup.removeView(findViewById);
                        viewGroup.addView(findViewById, Integer.parseInt(str2));
                    } catch (Exception unused) {
                        DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" fn__moveView - ");
                        outline73.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                        logger.e("ERROR", outline73.toString());
                    }
                }
            });
        } else {
            this.dynamicUI.getLogger().e("missing_container", "moveView, no container");
        }
    }

    @JavascriptInterface
    public void prepareAndStoreView(final String str, String str2, final String str3) {
        try {
            final JSONObject jSONObject = new JSONObject(str2);
            PreRenderThread preRenderThread = new PreRenderThread(new Runnable() {
                public void run() {
                    try {
                        AndroidInterface.this.setPrepareScreenTaskStatus(str, true);
                        AndroidInterface.this.dynamicUI.getRenderer().prepareAndStoreView(str, jSONObject);
                        if (str3 != null) {
                            DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                            access$000.addJsToWebView("window.callUICallback('" + str3 + "','success');");
                        }
                    } catch (Exception e2) {
                        DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" excep: fn__prepareAndStoreView  - ");
                        outline73.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                        logger.e("ERROR", outline73.toString());
                        ErrorCallback errorCallback = AndroidInterface.this.dynamicUI.getErrorCallback();
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73(" excep: fn__prepareAndStoreView  - ");
                        outline732.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                        errorCallback.onException("ERROR", outline732.toString(), e2);
                        if (str3 != null) {
                            DynamicUI access$0002 = AndroidInterface.this.dynamicUI;
                            StringBuilder outline733 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                            outline733.append(str3);
                            outline733.append("','failure');");
                            access$0002.addJsToWebView(outline733.toString());
                        }
                    }
                    AndroidInterface.this.setPrepareScreenTaskStatus(str, false);
                    AndroidInterface.this.processPendingAddScreen(str);
                }
            });
            preRenderThread.setName("PreRenderThread");
            preRenderThread.start();
        } catch (JSONException unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("JSONERROR", "Error while parsing " + str2);
        }
    }

    public void processPendingAddScreen(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                PendingAddScreenMapItem pendingAddScreenMapItem = (PendingAddScreenMapItem) AndroidInterface.this.pendingAddScreenMap.get(str);
                if (pendingAddScreenMapItem != null) {
                    AndroidInterface.this.pendingAddScreenMap.remove(str);
                    AndroidInterface.this.addStoredViewToParent(pendingAddScreenMapItem.parentId, pendingAddScreenMapItem.screenName, pendingAddScreenMapItem.index, pendingAddScreenMapItem.callbackName, pendingAddScreenMapItem.replaceChild, pendingAddScreenMapItem.runInUIprop, null);
                }
            }
        });
    }

    @JavascriptInterface
    public void removeView(int i) {
        removeView(i, null);
    }

    @JavascriptInterface
    public void removeView(final int i, final String str) {
        if (this.dynamicUI.getContainer(str) != null) {
            runOnUiThread(new Runnable() {
                public void run() {
                    View findViewById = AndroidInterface.this.dynamicUI.getContainer(str).findViewById(i);
                    if (findViewById != null) {
                        ((ViewGroup) findViewById.getParent()).removeView(findViewById);
                    }
                }
            });
        } else {
            this.dynamicUI.getLogger().e("missing_container", "removeView, no container");
        }
    }

    @JavascriptInterface
    public void render(String str, String str2) {
        render(str, str2, BaseParser.TRUE, null);
    }

    @JavascriptInterface
    public void render(String str, String str2, String str3) {
        render(str, str2, str3, null);
    }

    @JavascriptInterface
    public void render(String str, String str2, String str3, String str4) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (this.dynamicUI.getContainer(str4) != null) {
                Handler handler = new Handler(Looper.getMainLooper());
                final String str5 = str4;
                final String str6 = str3;
                final String str7 = str2;
                AnonymousClass1 r0 = new Runnable() {
                    public void run() {
                        try {
                            AndroidInterface.this.dynamicUI.getRenderer().renderUI(jSONObject, AndroidInterface.this.dynamicUI.getContainer(str5), Boolean.parseBoolean(str6), str5);
                            if (str7 != null) {
                                DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                                access$000.addJsToWebView("window.callUICallback(" + str7 + ",'success');");
                            }
                        } catch (Exception e2) {
                            DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73(" excep: fn__Render  - ");
                            outline73.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                            logger.e("ERROR", outline73.toString());
                            ErrorCallback errorCallback = AndroidInterface.this.dynamicUI.getErrorCallback();
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73(" excep: fn__Render  - ");
                            outline732.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                            errorCallback.onException("ERROR", outline732.toString(), e2);
                            if (str7 != null) {
                                DynamicUI access$0002 = AndroidInterface.this.dynamicUI;
                                StringBuilder outline733 = GeneratedOutlineSupport.outline73("window.callUICallback(");
                                outline733.append(str7);
                                outline733.append(",'failure');");
                                access$0002.addJsToWebView(outline733.toString());
                            }
                        }
                    }
                };
                handler.post(r0);
                return;
            }
            this.dynamicUI.getLogger().e("missing_container", "render, it is not activity, it is applicationContext/ no container");
            ErrorCallback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onError("ERROR", " excep: fn__Render  - missing_container - " + this.dynamicUI.getRenderer().getErrorDetails());
            if (str2 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback(" + str2 + ",'failure');");
            }
        } catch (JSONException unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("fn__render - ");
            outline73.append(this.dynamicUI.getRenderer().getErrorDetails());
            outline73.append(" - ");
            outline73.append(str);
            logger.e("JSONERROR", outline73.toString());
        }
    }

    @JavascriptInterface
    public void replaceView(String str, int i) {
        replaceView(str, i, null);
    }

    @JavascriptInterface
    public void replaceView(String str, final int i, final String str2) {
        if (this.dynamicUI.getContainer(str2) != null) {
            try {
                final JSONObject jSONObject = new JSONObject(str);
                runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            View createView = AndroidInterface.this.dynamicUI.getRenderer().createView(jSONObject);
                            View findViewById = AndroidInterface.this.dynamicUI.getContainer(str2).findViewById(i);
                            if (findViewById != null) {
                                if (findViewById instanceof ViewGroup) {
                                    int childCount = ((ViewGroup) findViewById).getChildCount();
                                    for (int i = 0; i < childCount; i++) {
                                        View childAt = ((ViewGroup) findViewById).getChildAt(0);
                                        if (childAt != null) {
                                            ((ViewGroup) findViewById).removeViewAt(0);
                                            ((ViewGroup) createView).addView(childAt, i);
                                        }
                                    }
                                }
                                if (AndroidInterface.this.replaceViewImpl(createView, findViewById)) {
                                    createView.requestLayout();
                                }
                            }
                        } catch (JSONException unused) {
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (JSONException unused) {
                DuiLogger logger = this.dynamicUI.getLogger();
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("fn__replaceView - ");
                outline73.append(this.dynamicUI.getRenderer().getErrorDetails());
                outline73.append(" - ");
                outline73.append(str);
                logger.e("JSONERROR", outline73.toString());
            }
            return;
        }
        this.dynamicUI.getLogger().e("missing_container", "replaceView, no container");
    }

    @JavascriptInterface
    public void run(String str, String str2) {
        Renderer renderer;
        Object appContext;
        String str3;
        String str4;
        try {
            InflateView inflateView = new InflateView(this.dynamicUI);
            if (this.dynamicUI.getActivity() != null) {
                inflateView.setUseAppContext(false);
                renderer = this.dynamicUI.getRenderer();
                appContext = this.dynamicUI.getActivity();
                str3 = "";
                str4 = "";
            } else {
                inflateView.setUseAppContext(true);
                renderer = this.dynamicUI.getRenderer();
                appContext = this.dynamicUI.getAppContext();
                str3 = "";
                str4 = "";
            }
            renderer.parseAndRunPipe(appContext, str, str3, str4, inflateView.getUseAppContext());
            if (str2 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback(" + str2 + ",'success');");
            }
        } catch (Exception e2) {
            String name = e2.getClass().getName();
            this.dynamicUI.getLogger().e("runInUI", name);
            ErrorCallback errorCallback = this.dynamicUI.getErrorCallback();
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(name, " - ");
            outline78.append(this.dynamicUI.getRenderer().getErrorDetails());
            errorCallback.onError("runInUI", outline78.toString());
            if (str2 != null) {
                DynamicUI dynamicUI3 = this.dynamicUI;
                dynamicUI3.addJsToWebView("window.callUICallback(" + str2 + ",'failure');");
            }
        }
    }

    @JavascriptInterface
    public void runInUI(final String str, final String str2) {
        runOnUiThread(new Runnable() {
            public void run() {
                Renderer renderer;
                Object appContext;
                String str;
                String str2;
                String str3;
                try {
                    InflateView inflateView = new InflateView(AndroidInterface.this.dynamicUI);
                    if (AndroidInterface.this.dynamicUI.getActivity() != null) {
                        inflateView.setUseAppContext(false);
                        renderer = AndroidInterface.this.dynamicUI.getRenderer();
                        appContext = AndroidInterface.this.dynamicUI.getActivity();
                        str = str;
                        str2 = "";
                        str3 = "";
                    } else {
                        inflateView.setUseAppContext(true);
                        renderer = AndroidInterface.this.dynamicUI.getRenderer();
                        appContext = AndroidInterface.this.dynamicUI.getAppContext();
                        str = str;
                        str2 = "";
                        str3 = "";
                    }
                    renderer.parseAndRunPipe(appContext, str, str2, str3, inflateView.getUseAppContext());
                    if (str2 != null) {
                        DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                        access$000.addJsToWebView("window.callUICallback(" + str2 + ",'success');");
                    }
                } catch (Exception e2) {
                    String name = e2.getClass().getName();
                    DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                    StringBuilder outline80 = GeneratedOutlineSupport.outline80(" excep: fn__runInUI  - ", name, " - ");
                    outline80.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                    logger.e("ERROR", outline80.toString());
                    ErrorCallback errorCallback = AndroidInterface.this.dynamicUI.getErrorCallback();
                    StringBuilder outline802 = GeneratedOutlineSupport.outline80(" excep: fn__runInUI  - ", name, " - ");
                    outline802.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                    errorCallback.onError("ERROR", outline802.toString());
                    if (str2 != null) {
                        DynamicUI access$0002 = AndroidInterface.this.dynamicUI;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback(");
                        outline73.append(str2);
                        outline73.append(",'failure');");
                        access$0002.addJsToWebView(outline73.toString());
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void runInUI(String str, String str2, String str3, String str4) {
        final String str5 = str;
        final String str6 = str3;
        final String str7 = str4;
        final String str8 = str2;
        AnonymousClass8 r0 = new Runnable() {
            public void run() {
                Renderer renderer;
                Object appContext;
                String str;
                String str2;
                String str3;
                try {
                    InflateView inflateView = new InflateView(AndroidInterface.this.dynamicUI);
                    if (AndroidInterface.this.dynamicUI.getActivity() != null) {
                        inflateView.setUseAppContext(false);
                        renderer = AndroidInterface.this.dynamicUI.getRenderer();
                        appContext = AndroidInterface.this.dynamicUI.getActivity();
                        str = str5;
                        str2 = str6;
                        str3 = str7;
                    } else {
                        inflateView.setUseAppContext(true);
                        renderer = AndroidInterface.this.dynamicUI.getRenderer();
                        appContext = AndroidInterface.this.dynamicUI.getAppContext();
                        str = str5;
                        str2 = str6;
                        str3 = str7;
                    }
                    renderer.parseAndRunPipe(appContext, str, str2, str3, inflateView.getUseAppContext());
                    if (str8 != null) {
                        DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                        access$000.addJsToWebView("window.callUICallback(" + str8 + ",'success');");
                    }
                } catch (Exception e2) {
                    DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73(" excep: fn__runInUI  - ");
                    outline73.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                    logger.e("ERROR", outline73.toString());
                    ErrorCallback errorCallback = AndroidInterface.this.dynamicUI.getErrorCallback();
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73(" excep: fn__runInUI  - ");
                    outline732.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                    errorCallback.onException("ERROR", outline732.toString(), e2);
                    if (str8 != null) {
                        DynamicUI access$0002 = AndroidInterface.this.dynamicUI;
                        StringBuilder outline733 = GeneratedOutlineSupport.outline73("window.callUICallback(");
                        outline733.append(str8);
                        outline733.append(",'failure');");
                        access$0002.addJsToWebView(outline733.toString());
                    }
                }
            }
        };
        runOnUiThread(r0);
    }

    public void runInUIOnView(final View view, final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    InflateView inflateView = new InflateView(AndroidInterface.this.dynamicUI);
                    inflateView.setUseAppContext(false);
                    AndroidInterface.this.dynamicUI.getRenderer().parseAndRunPipe(view, str, "", "", inflateView.getUseAppContext());
                } catch (Exception e2) {
                    DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73(" excep: fn__runInUI  - ");
                    outline73.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                    logger.e("ERROR", outline73.toString());
                    ErrorCallback errorCallback = AndroidInterface.this.dynamicUI.getErrorCallback();
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73(" excep: fn__runInUI  - ");
                    outline732.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                    errorCallback.onException("ERROR", outline732.toString(), e2);
                }
            }
        });
    }

    @JavascriptInterface
    public void saveData(String str, String str2) {
        this.dynamicUI.getAppContext().getSharedPreferences("DUI", 0).edit().putString(str, str2).apply();
    }

    @JavascriptInterface
    public void saveState(String str) {
        this.state = str;
    }

    @JavascriptInterface
    public String setFragmentContainer(int i, String str) {
        if (this.dynamicUI.getContainer(str) != null) {
            View findViewById = this.dynamicUI.getContainer(str).findViewById(i);
            if (findViewById instanceof ViewGroup) {
                return this.dynamicUI.addToContainerList((ViewGroup) findViewById);
            }
        }
        return "__failed";
    }

    @JavascriptInterface
    public void setImage(final int i, final String str, final String str2) {
        if (this.dynamicUI.getContainer(str2) != null) {
            runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        byte[] decode = Base64.decode(str, 0);
                        ((ImageView) AndroidInterface.this.dynamicUI.getContainer(str2).findViewById(i)).setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                    } catch (Exception e2) {
                        DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" excep: fn__setImage  - ");
                        outline73.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                        logger.e("ERROR", outline73.toString());
                        ErrorCallback errorCallback = AndroidInterface.this.dynamicUI.getErrorCallback();
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73(" excep: fn__setImage  - ");
                        outline732.append(AndroidInterface.this.dynamicUI.getRenderer().getErrorDetails());
                        errorCallback.onException("ERROR", outline732.toString(), e2);
                    }
                }
            });
        } else {
            this.dynamicUI.getLogger().e("missing_container", "setImage, no container");
        }
    }

    public void setPrepareScreenTaskStatus(final String str, final boolean z) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (z) {
                    AndroidInterface.this.onGoingPrepareScreenSet.add(str);
                } else {
                    AndroidInterface.this.onGoingPrepareScreenSet.remove(str);
                }
            }
        });
    }

    @JavascriptInterface
    public void setState(String str) {
        this.state = str;
    }

    @JavascriptInterface
    @Deprecated
    public void showLoading() {
    }

    public void showPopup(View view, String[] strArr, final String str) {
        if (this.dynamicUI.getActivity() != null) {
            PopupMenu popupMenu = new PopupMenu(this.dynamicUI.getActivity(), view);
            for (int i = 0; i < strArr.length; i++) {
                popupMenu.getMenu().add(0, i, 0, strArr[i]);
            }
            popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem menuItem) {
                    DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                    outline73.append(str);
                    outline73.append("', '");
                    outline73.append(menuItem.getItemId());
                    outline73.append("');");
                    access$000.addJsToWebView(outline73.toString());
                    Activity activity = AndroidInterface.this.dynamicUI.getActivity();
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("You Clicked : ");
                    outline732.append(menuItem.getTitle());
                    Toast.makeText(activity, outline732.toString(), 0).show();
                    return true;
                }
            });
            popupMenu.show();
            return;
        }
        this.dynamicUI.getLogger().e("Missing Activity", "showPopup, it is not  activity, it is applicationContext");
    }

    @JavascriptInterface
    public void startAnim(String str) {
        startAnim(str, null);
    }

    @JavascriptInterface
    public void startAnim(final String str, final String str2) {
        final Pair<String, ObjectAnimator> findAnimationById = this.dynamicUI.getRenderer().getInflateView().findAnimationById(str);
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (findAnimationById != null && findAnimationById.second != null) {
                        ((ObjectAnimator) findAnimationById.second).start();
                        ((ObjectAnimator) findAnimationById.second).addListener(new AnimatorListener() {
                            public void onAnimationCancel(Animator animator) {
                            }

                            public void onAnimationEnd(Animator animator) {
                                String str = str2;
                                if (str != null && !str.isEmpty()) {
                                    DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                                    outline73.append(str2);
                                    outline73.append("', '");
                                    outline73.append(str);
                                    outline73.append("');");
                                    access$000.addJsToWebView(outline73.toString());
                                }
                            }

                            public void onAnimationRepeat(Animator animator) {
                            }

                            public void onAnimationStart(Animator animator) {
                            }
                        });
                    }
                } catch (Exception unused) {
                    DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error parsing json for animation with id ");
                    outline73.append(str);
                    logger.e("JSONERROR", outline73.toString());
                }
            }
        });
    }

    @JavascriptInterface
    public void throwError(String str) {
        this.dynamicUI.getLogger().e("throwError", str);
    }

    @JavascriptInterface
    public void toggleKeyboard(final int i, final String str, final String str2) {
        if (this.dynamicUI.getActivity() != null) {
            runOnUiThread(new Runnable() {
                public void run() {
                    View findViewById = AndroidInterface.this.dynamicUI.getContainer(str2).findViewById(i);
                    InputMethodManager inputMethodManager = (InputMethodManager) AndroidInterface.this.dynamicUI.getActivity().getSystemService("input_method");
                    if (str.equals(AnalyticsConstants.SHOW)) {
                        inputMethodManager.showSoftInput(findViewById, 1);
                    } else {
                        inputMethodManager.hideSoftInputFromWindow(findViewById.getWindowToken(), 0);
                    }
                }
            });
        } else {
            this.dynamicUI.getLogger().e("Missing Activity", "toggleKeyboard, it is not  activity, it is applicationContext");
        }
    }

    @JavascriptInterface
    public void updateAnim(int i, String str) {
        updateAnim(i, str, null);
    }

    @JavascriptInterface
    public void updateAnim(final int i, String str, final String str2) {
        if (this.dynamicUI.getContainer(str2) != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                final JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            AndroidInterface.this.dynamicUI.getRenderer().getInflateView().handleAnimation(AndroidInterface.this.dynamicUI.getContainer(str2).findViewById(i), jSONArray);
                        } catch (Exception unused) {
                            DuiLogger logger = AndroidInterface.this.dynamicUI.getLogger();
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("updateAnim: View doesn't exist for id -");
                            outline73.append(i);
                            logger.e("ERROR", outline73.toString());
                        }
                    }
                });
            } catch (JSONException unused) {
                DuiLogger logger = this.dynamicUI.getLogger();
                logger.e("JSONERROR", "Error parsing json for animation string " + str);
            }
            return;
        }
        this.dynamicUI.getLogger().e("missing_container", "updateAnim, no container");
    }

    @JavascriptInterface
    public void updateProperties(String str) {
        updateProperties(str, null);
    }

    @JavascriptInterface
    public void updateProperties(final String str, final String str2) {
        if (this.dynamicUI.getContainer(str2) != null) {
            runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        View findViewById = AndroidInterface.this.dynamicUI.getContainer(str2).findViewById(jSONObject.getInt("id"));
                        jSONObject.remove("id");
                        InflateView inflateView = new InflateView(AndroidInterface.this.dynamicUI);
                        inflateView.setUseAppContext(true);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            AndroidInterface.this.dynamicUI.getRenderer().getInflateView().parseKeys(keys.next(), jSONObject, findViewById, inflateView.getUseAppContext());
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            });
        } else {
            this.dynamicUI.getLogger().e("missing_container", "updateProperties, no container");
        }
    }
}
