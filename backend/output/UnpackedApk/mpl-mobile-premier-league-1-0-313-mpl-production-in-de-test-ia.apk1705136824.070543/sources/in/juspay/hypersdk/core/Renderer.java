package in.juspay.hypersdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.mystique.ErrorCallback;
import in.juspay.hypersdk.mystique.ListAdapter.ViewHolder;
import in.juspay.hypersdk.services.SdkConfigService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Renderer {
    public HashMap<String, ViewGroup> container;
    public DynamicUI dynamicUI;
    public HashMap<String, View> prevView;
    public HashMap<String, ArrayList<View>> viewCache = new HashMap<>();
    public int viewCacheCapacity;

    public static class RenderTreeNode {
        public View itself;
        public ViewGroup parent;

        public RenderTreeNode(ViewGroup viewGroup, View view) {
            this.parent = viewGroup;
            this.itself = view;
        }
    }

    public Renderer(DynamicUI dynamicUI2) {
        this.dynamicUI = dynamicUI2;
        this.container = new HashMap<>();
        this.prevView = new HashMap<>();
        try {
            this.viewCacheCapacity = SdkConfigService.getCachedSdkConfig().getJSONObject("uiFeatures").getJSONObject("nbListItemCaching").getInt("bgCacheCapacity");
        } catch (JSONException unused) {
            this.viewCacheCapacity = 4;
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new RelativeLayout(Renderer.this.dynamicUI.getAppContext()));
                arrayList.add(new RelativeLayout(Renderer.this.dynamicUI.getAppContext()));
                arrayList.add(new RelativeLayout(Renderer.this.dynamicUI.getAppContext()));
                Renderer.this.viewCache.put("android.widget.RelativeLayout", arrayList);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new LinearLayout(Renderer.this.dynamicUI.getAppContext()));
                arrayList2.add(new LinearLayout(Renderer.this.dynamicUI.getAppContext()));
                arrayList2.add(new LinearLayout(Renderer.this.dynamicUI.getAppContext()));
                arrayList2.add(new LinearLayout(Renderer.this.dynamicUI.getAppContext()));
                Renderer.this.viewCache.put("android.widget.LinearLayout", arrayList2);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(new ImageView(Renderer.this.dynamicUI.getAppContext()));
                arrayList3.add(new ImageView(Renderer.this.dynamicUI.getAppContext()));
                arrayList3.add(new ImageView(Renderer.this.dynamicUI.getAppContext()));
                Renderer.this.viewCache.put("android.widget.ImageView", arrayList3);
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(new ScrollView(Renderer.this.dynamicUI.getAppContext()));
                Renderer.this.viewCache.put("android.widget.ScrollView", arrayList4);
                ArrayList arrayList5 = new ArrayList();
                arrayList5.add(new TextView(Renderer.this.dynamicUI.getAppContext()));
                arrayList5.add(new TextView(Renderer.this.dynamicUI.getAppContext()));
                arrayList5.add(new TextView(Renderer.this.dynamicUI.getAppContext()));
                Renderer.this.viewCache.put("android.widget.TextView", arrayList5);
                ArrayList arrayList6 = new ArrayList();
                arrayList6.add(new EditText(Renderer.this.dynamicUI.getAppContext()));
                arrayList6.add(new EditText(Renderer.this.dynamicUI.getAppContext()));
                Renderer.this.viewCache.put("android.widget.EditText", arrayList6);
                ArrayList arrayList7 = new ArrayList();
                arrayList7.add(new FrameLayout(Renderer.this.dynamicUI.getAppContext()));
                Renderer.this.viewCache.put("android.widget.FrameLayout", arrayList7);
            }
        });
    }

    private void addViewFromRenderTreeNodeQueue(Queue<RenderTreeNode> queue) {
        while (!queue.isEmpty()) {
            RenderTreeNode poll = queue.poll();
            poll.parent.addView(poll.itself);
        }
    }

    private View createAllNodesAndReturnRoot(JSONObject jSONObject, Queue<RenderTreeNode> queue, boolean z) {
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            setCurrentNodeDetails(string, jSONObject2);
        }
        Object newInstanceFromClassName = getNewInstanceFromClassName(string);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            this.dynamicUI.getInflateView().parseKeys(keys.next(), jSONObject2, newInstanceFromClassName, z);
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                View createAllNodesAndReturnRoot = createAllNodesAndReturnRoot(jSONArray.getJSONObject(i), queue, z);
                if (!(createAllNodesAndReturnRoot == null || newInstanceFromClassName == null)) {
                    queue.add(new RenderTreeNode((ViewGroup) newInstanceFromClassName, createAllNodesAndReturnRoot));
                }
            }
        }
        return (View) newInstanceFromClassName;
    }

    private View createNodesAndReturnRoot(JSONObject jSONObject, InflateView inflateView) {
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            setCurrentNodeDetails(string, jSONObject2);
        }
        Object newInstanceFromClassName = getNewInstanceFromClassName(string);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            inflateView.parseKeys(keys.next(), jSONObject2, newInstanceFromClassName, inflateView.getUseAppContext());
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                View createNodesAndReturnRoot = createNodesAndReturnRoot(jSONArray.getJSONObject(i), inflateView);
                if (!(createNodesAndReturnRoot == null || newInstanceFromClassName == null)) {
                    ((ViewGroup) newInstanceFromClassName).addView(createNodesAndReturnRoot);
                }
            }
        }
        return (View) newInstanceFromClassName;
    }

    private Object getNewInstanceFromClassName(String str) {
        this.dynamicUI.getActivity();
        Context appContext = this.dynamicUI.getAppContext();
        View cachedViewFor = getCachedViewFor(str);
        if (cachedViewFor != null) {
            return cachedViewFor;
        }
        if (appContext != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2096886772:
                    if (str.equals("android.widget.FrameLayout")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1973910559:
                    if (str.equals("android.widget.RelativeLayout")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1929723370:
                    if (str.equals("android.view.TextureView")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1430722502:
                    if (str.equals("android.widget.LinearLayout")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1238256809:
                    if (str.equals("androidx.swiperefreshlayout.widget.SwipeRefreshLayout")) {
                        c2 = Tokenizer.FF;
                        break;
                    }
                    break;
                case -214285650:
                    if (str.equals("android.widget.CheckBox")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case -149114526:
                    if (str.equals("android.widget.EditText")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -50131582:
                    if (str.equals("android.widget.ImageButton")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 670921973:
                    if (str.equals("android.widget.ImageView")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 841510749:
                    if (str.equals("android.widget.ScrollView")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1540240509:
                    if (str.equals("android.widget.TextView")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1583615229:
                    if (str.equals("android.widget.Button")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1663696930:
                    if (str.equals("android.widget.RadioButton")) {
                        c2 = 10;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return new RelativeLayout(appContext);
                case 1:
                    return new LinearLayout(appContext);
                case 2:
                    return new FrameLayout(appContext);
                case 3:
                    return new ScrollView(appContext);
                case 4:
                    return new TextView(appContext);
                case 5:
                    return new Button(appContext);
                case 6:
                    return new EditText(appContext);
                case 7:
                    return new ImageView(appContext);
                case 8:
                    return new ImageButton(appContext);
                case 9:
                    return new CheckBox(appContext);
                case 10:
                    return new RadioButton(appContext);
                case 11:
                    return new TextureView(appContext);
                case 12:
                    return new SwipeRefreshLayout(appContext, null);
                default:
                    return getInflateView().getClassName(str).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{appContext});
            }
        } else {
            this.dynamicUI.getLogger().e("Missing Context", "getNewInstanceFromClassName, it is not  context, it is applicationContext");
            throw new Exception("Failed to fetch context");
        }
    }

    private void removeViewFromContainer(View view, String str) {
        ViewGroup viewGroup = this.container.get(str);
        if (viewGroup != null) {
            viewGroup.removeViewAt(viewGroup.indexOfChild(view));
        }
    }

    private void render(View view, String str) {
        ViewGroup viewGroup = this.container.get(str);
        if (view == null || viewGroup == null) {
            ErrorCallback errorCallback = this.dynamicUI.getErrorCallback();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(" isNull : fn__Render -  instance null ");
            outline73.append(getErrorDetails());
            errorCallback.onError("ERROR", outline73.toString());
            return;
        }
        viewGroup.addView(view);
    }

    public void addStoredViewToParent(String str, String str2, int i, boolean z, String str3) {
        String str4;
        StringBuilder sb;
        ErrorCallback errorCallback;
        int identifier = this.dynamicUI.getAppContext().getResources().getIdentifier(str, "id", this.dynamicUI.getAppContext().getPackageName());
        if (i >= 0) {
            ViewGroup viewGroup = (ViewGroup) this.dynamicUI.getContainer(str3).findViewById(identifier);
            if (z) {
                viewGroup.removeAllViews();
            }
            View view = (View) this.dynamicUI.getViewFromScreenName(str2);
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                viewGroup.addView(view, i);
                return;
            }
            errorCallback = this.dynamicUI.getErrorCallback();
            sb = new StringBuilder();
            str4 = " isNull : fn__addViewToParent - child null ";
        } else {
            errorCallback = this.dynamicUI.getErrorCallback();
            sb = new StringBuilder();
            str4 = " isNull : fn__addViewToParent - negative index ";
        }
        sb.append(str4);
        sb.append(getErrorDetails());
        errorCallback.onError("ERROR", sb.toString());
    }

    public void addViewToParent(String str, JSONObject jSONObject, int i, boolean z, String str2) {
        String str3;
        StringBuilder sb;
        ErrorCallback errorCallback;
        int identifier = this.dynamicUI.getAppContext().getResources().getIdentifier(str, "id", this.dynamicUI.getAppContext().getPackageName());
        if (i < 0 || this.dynamicUI.getContainer(str2) == null) {
            if (this.dynamicUI.getContainer(str2) == null) {
                this.dynamicUI.getLogger().e("Missing Container", "addViewToParent, InflateView, it is not  activity, it is applicationContext");
            }
            if (jSONObject.has("props")) {
                setCurrentNodeDetails(jSONObject.getString("type"), jSONObject.getJSONObject("props"));
            }
            errorCallback = this.dynamicUI.getErrorCallback();
            sb = new StringBuilder();
            str3 = " isNull : fn__addViewToParent - negative index ";
        } else {
            ViewGroup viewGroup = (ViewGroup) this.dynamicUI.getContainer(str2).findViewById(identifier);
            if (z) {
                viewGroup.removeAllViews();
            }
            LinkedList linkedList = new LinkedList();
            InflateView inflateView = new InflateView(this.dynamicUI);
            inflateView.setUseAppContext(true);
            View createAllNodesAndReturnRoot = createAllNodesAndReturnRoot(jSONObject, linkedList, inflateView.getUseAppContext());
            addViewFromRenderTreeNodeQueue(linkedList);
            if (createAllNodesAndReturnRoot != null) {
                viewGroup.addView(createAllNodesAndReturnRoot, i);
                return;
            }
            errorCallback = this.dynamicUI.getErrorCallback();
            sb = new StringBuilder();
            str3 = " isNull : fn__addViewToParent - child null ";
        }
        sb.append(str3);
        sb.append(getErrorDetails());
        errorCallback.onError("ERROR", sb.toString());
    }

    public View createView(JSONObject jSONObject) {
        return createView(jSONObject, new ViewHolder(), false);
    }

    public View createView(JSONObject jSONObject, ViewHolder viewHolder, boolean z) {
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            setCurrentNodeDetails(string, jSONObject2);
        }
        Object newInstanceFromClassName = getNewInstanceFromClassName(string);
        Iterator<String> keys = jSONObject2.keys();
        InflateView inflateView = new InflateView(this.dynamicUI);
        inflateView.setUseAppContext(true);
        while (keys.hasNext()) {
            this.dynamicUI.getInflateView().parseKeys(keys.next(), jSONObject2, newInstanceFromClassName, inflateView.getUseAppContext(), viewHolder, z);
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                ViewHolder child = viewHolder.getChildCount() > i ? viewHolder.getChild(i) : new ViewHolder();
                if (!viewHolder.checkIfContains(child)) {
                    viewHolder.putChild(child);
                }
                View createView = createView(jSONObject3, child, z);
                if (createView != null) {
                    ((ViewGroup) newInstanceFromClassName).addView(createView);
                }
                i++;
            }
        }
        return (View) newInstanceFromClassName;
    }

    public void dismissPopUp() {
        this.dynamicUI.getInflateView().dismissPopUp();
    }

    public View getCachedViewFor(String str) {
        ArrayList arrayList = this.viewCache.get(str);
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 0) {
            replenishCache(str);
            return null;
        }
        View view = (View) arrayList.remove(0);
        if (size < this.viewCacheCapacity) {
            replenishCache(str);
        }
        return view;
    }

    public String getErrorDetails() {
        return this.dynamicUI.getInflateView().getErrorDetails();
    }

    public InflateView getInflateView() {
        return this.dynamicUI.getInflateView();
    }

    public void parseAndRunPipe(Object obj, String str, String str2, String str3, boolean z) {
        this.dynamicUI.getInflateView().setCurrView("modifyDom");
        this.dynamicUI.getInflateView().setCurrViewId("");
        InflateView inflateView = this.dynamicUI.getInflateView();
        inflateView.setFileOrigin("ln: " + str2 + CMap.SPACE + str3);
        this.dynamicUI.getInflateView().parseAndRunPipe(obj, str, z);
    }

    public void prepareAndStoreView(String str, JSONObject jSONObject) {
        InflateView inflateView = new InflateView(this.dynamicUI);
        inflateView.setUseAppContext(true);
        this.dynamicUI.addToScreenMap(str, createNodesAndReturnRoot(jSONObject, inflateView));
    }

    public void renderUI(JSONObject jSONObject, ViewGroup viewGroup, String str) {
        renderUI(jSONObject, viewGroup, true, str);
    }

    public void renderUI(JSONObject jSONObject, ViewGroup viewGroup, boolean z, String str) {
        if (str == null) {
            str = "default";
        }
        this.container.put(str, viewGroup);
        LinkedList linkedList = new LinkedList();
        InflateView inflateView = new InflateView(this.dynamicUI);
        inflateView.setUseAppContext(true);
        View createAllNodesAndReturnRoot = createAllNodesAndReturnRoot(jSONObject, linkedList, inflateView.getUseAppContext());
        if (z) {
            HashMap<String, View> hashMap = this.prevView;
            if (!(hashMap == null || hashMap.get(str) == createAllNodesAndReturnRoot)) {
                removeViewFromContainer(this.prevView.get(str), str);
            }
        }
        addViewFromRenderTreeNodeQueue(linkedList);
        render(createAllNodesAndReturnRoot, str);
        this.prevView.put(str, createAllNodesAndReturnRoot);
    }

    @SuppressLint({"StaticFieldLeak"})
    public void replenishCache(final String str) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                ArrayList arrayList = Renderer.this.viewCache.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    Renderer.this.viewCache.put(str, arrayList);
                }
                if (arrayList.size() < Renderer.this.viewCacheCapacity) {
                    try {
                        arrayList.add((View) Class.forName(str).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{Renderer.this.dynamicUI.getAppContext()}));
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public void setCurrentNodeDetails(String str, JSONObject jSONObject) {
        this.dynamicUI.getInflateView().setCurrView(str);
        if (jSONObject.has("node_id")) {
            this.dynamicUI.getInflateView().setCurrViewId(jSONObject.getString("node_id"));
        }
        if (jSONObject.has("__filename")) {
            this.dynamicUI.getInflateView().setFileOrigin(jSONObject.getString("__filename"));
        }
    }
}
