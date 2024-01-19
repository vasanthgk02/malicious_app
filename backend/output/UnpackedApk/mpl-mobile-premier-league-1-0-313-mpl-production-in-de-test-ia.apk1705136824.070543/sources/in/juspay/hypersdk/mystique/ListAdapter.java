package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.LruCache;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.DuiCallback;
import in.juspay.hypersdk.core.Renderer;
import in.juspay.hypersdk.services.SdkConfigService;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListAdapter extends BaseAdapter {
    public BitmapCache bitmapCache = BitmapCache.getInstance();
    public LruCache<String, Integer> colorCache = new LruCache<>(20);
    public Context context;
    public float density;
    public LruCache<String, Drawable> drawableCache = new LruCache<>(50);
    public final DuiCallback duiCallback;
    public JSONArray holderData;
    public JSONObject itemView;
    public ViewHolder itemViewCache;
    public Renderer renderer;
    public JSONArray rowData;
    public LruCache<String, Typeface> typefaceCache = new LruCache<>(20);
    public LruCache<String, Integer> typefaceWeightCache = new LruCache<>(20);

    public static class CacheHolder {
        public Class<?> className;
        public Constructor<?> constructor;
        public Field field;
        public Pair<String, String> fieldArgs;
        public Object invokeOn;
        public String key;
        public Method method;
        public Object[] params;
        public String storeKey;

        public Class<?> getClassName() {
            return this.className;
        }

        public Constructor<?> getConstructor() {
            return this.constructor;
        }

        public Field getField() {
            return this.field;
        }

        public Pair<String, String> getFieldArgs() {
            return this.fieldArgs;
        }

        public Object getInvokeOn() {
            return this.invokeOn;
        }

        public String getKey() {
            return this.key;
        }

        public Method getMethod() {
            return this.method;
        }

        public Object[] getParams() {
            return this.params;
        }

        public String getStoreKey() {
            return this.storeKey;
        }

        public void setClassName(Class<?> cls) {
            this.className = cls;
        }

        public void setConstructor(Constructor<?> constructor2) {
            this.constructor = constructor2;
        }

        public void setField(Field field2) {
            this.field = field2;
        }

        public void setFieldArgs(Pair<String, String> pair) {
            this.fieldArgs = pair;
        }

        public void setInvokeOn(Object obj) {
            this.invokeOn = obj;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setMethod(Method method2) {
            this.method = method2;
        }

        public void setParams(Object[] objArr) {
            this.params = objArr;
        }

        public void setStoreKey(String str) {
            this.storeKey = str;
        }
    }

    public class Holder {
        public View[] views;

        public Holder(View view) {
            this.views = new View[ListAdapter.this.holderData.length()];
            for (int i = 0; i < ListAdapter.this.holderData.length(); i++) {
                try {
                    this.views[i] = view.findViewById(ListAdapter.this.holderData.getJSONObject(i).getInt("id"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static class ViewHolder {
        public ArrayList<ViewHolder> children = new ArrayList<>();
        public ArrayList<CacheHolder> props = new ArrayList<>();
        public HashMap<String, Object> state = new HashMap<>();
        public Class<?> viewType;

        public boolean checkIfContains(ViewHolder viewHolder) {
            return this.children.contains(viewHolder);
        }

        public ViewHolder getChild(int i) {
            return this.children.get(i);
        }

        public int getChildCount() {
            return this.children.size();
        }

        public ArrayList<ViewHolder> getChildren() {
            return this.children;
        }

        public ArrayList<CacheHolder> getProps() {
            return this.props;
        }

        public HashMap<String, Object> getState() {
            return this.state;
        }

        public Class<?> getViewType() {
            return this.viewType;
        }

        public void putChild(ViewHolder viewHolder) {
            this.children.add(viewHolder);
        }

        public void putState(String str, Object obj) {
            this.state.put(str, obj);
        }

        public void setChildren(ArrayList<ViewHolder> arrayList) {
            this.children = arrayList;
        }

        public void setProps(ArrayList<CacheHolder> arrayList) {
            this.props = arrayList;
        }

        public void setState(HashMap<String, Object> hashMap) {
            this.state = hashMap;
        }

        public void setViewType(Class<?> cls) {
            this.viewType = cls;
        }
    }

    public ListAdapter(Context context2, Renderer renderer2, JSONObject jSONObject, JSONArray jSONArray, JSONArray jSONArray2, DuiCallback duiCallback2) {
        this.renderer = renderer2;
        this.rowData = jSONArray2;
        this.itemView = jSONObject;
        this.holderData = jSONArray;
        this.duiCallback = duiCallback2;
        this.context = context2;
        this.density = context2.getResources().getDisplayMetrics().density;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyUpdate(android.view.View r7, org.json.JSONObject r8, org.json.JSONObject r9, int r10) {
        /*
            r6 = this;
            java.util.Iterator r0 = r8.keys()
        L_0x0004:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0109
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = ""
            java.lang.String r3 = r6.getString(r8, r1, r2)
            java.lang.String r2 = r6.getString(r8, r1, r2)
            java.lang.String r2 = r6.getDefault(r1, r2)
            java.lang.String r2 = r6.getString(r9, r3, r2)
            r3 = -1
            int r4 = r1.hashCode()     // Catch:{ Exception -> 0x0106 }
            r5 = 0
            switch(r4) {
                case -1550943582: goto L_0x008c;
                case -1351902487: goto L_0x0081;
                case -1332194002: goto L_0x0077;
                case -1003668786: goto L_0x006c;
                case -859610604: goto L_0x0062;
                case 3556653: goto L_0x0057;
                case 92909918: goto L_0x004c;
                case 94842723: goto L_0x0042;
                case 908612063: goto L_0x0038;
                case 1941332754: goto L_0x002d;
                default: goto L_0x002b;
            }     // Catch:{ Exception -> 0x0106 }
        L_0x002b:
            goto L_0x0095
        L_0x002d:
            java.lang.String r4 = "visibility"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 4
            goto L_0x0095
        L_0x0038:
            java.lang.String r4 = "packageIcon"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 7
            goto L_0x0095
        L_0x0042:
            java.lang.String r4 = "color"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 2
            goto L_0x0095
        L_0x004c:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 8
            goto L_0x0095
        L_0x0057:
            java.lang.String r4 = "text"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 1
            goto L_0x0095
        L_0x0062:
            java.lang.String r4 = "imageUrl"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 3
            goto L_0x0095
        L_0x006c:
            java.lang.String r4 = "textSize"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 6
            goto L_0x0095
        L_0x0077:
            java.lang.String r4 = "background"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 0
            goto L_0x0095
        L_0x0081:
            java.lang.String r4 = "onClick"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 9
            goto L_0x0095
        L_0x008c:
            java.lang.String r4 = "fontStyle"
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0095
            r3 = 5
        L_0x0095:
            switch(r3) {
                case 0: goto L_0x00c8;
                case 1: goto L_0x00c3;
                case 2: goto L_0x00be;
                case 3: goto L_0x00b9;
                case 4: goto L_0x00b4;
                case 5: goto L_0x00af;
                case 6: goto L_0x00aa;
                case 7: goto L_0x00a5;
                case 8: goto L_0x00a0;
                case 9: goto L_0x009b;
                default: goto L_0x0098;
            }
        L_0x0098:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f4 }
            goto L_0x00cd
        L_0x009b:
            r6.setClickListener(r7, r2, r10)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00a0:
            r6.setAlpha(r7, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00a5:
            r6.setPackageIcon(r7, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00aa:
            r6.setTextSize(r7, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00af:
            r6.setFontStyle(r7, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00b4:
            r6.setVisibility(r7, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00b9:
            r6.setImage(r7, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00be:
            r6.setTextColor(r7, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00c3:
            r6.setText(r7, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00c8:
            r6.setBackground(r7, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x00cd:
            r3.<init>()     // Catch:{ Exception -> 0x00f4 }
            r3.put(r1, r2)     // Catch:{ Exception -> 0x00f4 }
            in.juspay.hypersdk.core.DuiCallback r4 = r6.duiCallback     // Catch:{ Exception -> 0x00f4 }
            in.juspay.hypersdk.core.InflateView r4 = r4.getInflateView()     // Catch:{ Exception -> 0x00f4 }
            if (r4 == 0) goto L_0x0004
            if (r2 == 0) goto L_0x0004
            in.juspay.hypersdk.core.DuiCallback r2 = r6.duiCallback     // Catch:{ Exception -> 0x00f4 }
            in.juspay.hypersdk.core.InflateView r2 = r2.getInflateView()     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r4 = "view"
            r2.putInState(r4, r7)     // Catch:{ Exception -> 0x00f4 }
            in.juspay.hypersdk.core.DuiCallback r2 = r6.duiCallback     // Catch:{ Exception -> 0x00f4 }
            in.juspay.hypersdk.core.InflateView r2 = r2.getInflateView()     // Catch:{ Exception -> 0x00f4 }
            r2.parseKeys(r1, r3, r7, r5)     // Catch:{ Exception -> 0x00f4 }
            goto L_0x0004
        L_0x00f4:
            r1 = move-exception
            in.juspay.hypersdk.core.DuiCallback r2 = r6.duiCallback     // Catch:{ Exception -> 0x0106 }
            in.juspay.hypersdk.core.DuiLogger r2 = r2.getLogger()     // Catch:{ Exception -> 0x0106 }
            java.lang.String r3 = "Error while adding properties to list item"
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0106 }
            r2.e(r3, r1)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0004
        L_0x0106:
            goto L_0x0004
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.ListAdapter.applyUpdate(android.view.View, org.json.JSONObject, org.json.JSONObject, int):void");
    }

    private View createView() {
        boolean z;
        try {
            boolean z2 = true;
            boolean z3 = this.itemViewCache != null;
            if (!z3) {
                this.itemViewCache = new ViewHolder();
            }
            JSONObject cachedSdkConfig = SdkConfigService.getCachedSdkConfig();
            if (cachedSdkConfig != null) {
                try {
                    if (cachedSdkConfig.getJSONObject("uiFeatures").getJSONObject("nbListItemCaching").getBoolean("useCache")) {
                        z = true;
                        Renderer renderer2 = this.renderer;
                        JSONObject jSONObject = this.itemView;
                        ViewHolder viewHolder = this.itemViewCache;
                        if (z || !z3) {
                            z2 = false;
                        }
                        return renderer2.createView(jSONObject, viewHolder, z2);
                    }
                } catch (Exception unused) {
                }
            }
            z = false;
            Renderer renderer22 = this.renderer;
            JSONObject jSONObject2 = this.itemView;
            ViewHolder viewHolder2 = this.itemViewCache;
            if (z) {
            }
            z2 = false;
            return renderer22.createView(jSONObject2, viewHolder2, z2);
        } catch (Exception unused2) {
            return null;
        }
    }

    private String getDefault(String str, String str2) {
        if (str.equals("onClick")) {
            return str2;
        }
        return null;
    }

    private String getString(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return str2;
        }
    }

    private void setAlpha(View view, String str) {
        view.setAlpha(Float.parseFloat(str));
    }

    private void setBackground(View view, String str) {
        if (str == null) {
            if (view.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) view.getBackground()).setColor(0);
            } else {
                view.setBackgroundDrawable(null);
            }
            view.setBackgroundDrawable(null);
            return;
        }
        Integer num = this.colorCache.get(str);
        if (num == null) {
            num = Integer.valueOf(Color.parseColor(str));
            this.colorCache.put(str, num);
        }
        Drawable background = view.getBackground();
        if (background == null || ((background instanceof ColorDrawable) && ((ColorDrawable) background).getColor() != num.intValue())) {
            view.setBackgroundColor(num.intValue());
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(num.intValue());
        }
    }

    private void setClickListener(View view, final String str, final int i) {
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DuiCallback access$000 = ListAdapter.this.duiCallback;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                outline73.append(str);
                outline73.append("',");
                outline73.append(i);
                outline73.append(");");
                access$000.addJsToWebView(outline73.toString());
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b A[Catch:{ Exception -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0121 A[Catch:{ Exception -> 0x01c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setFontStyle(android.view.View r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "assets/"
            java.lang.String r1 = "FONT_ERROR"
            java.lang.String r2 = ","
            boolean r3 = r13 instanceof android.widget.TextView
            if (r3 != 0) goto L_0x000b
            return
        L_0x000b:
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x01c3 }
            boolean r3 = r14.contains(r2)     // Catch:{ Exception -> 0x01c3 }
            android.util.LruCache<java.lang.String, java.lang.Integer> r4 = r12.typefaceWeightCache     // Catch:{ Exception -> 0x01c3 }
            java.lang.Object r4 = r4.get(r14)     // Catch:{ Exception -> 0x01c3 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x01c3 }
            android.util.LruCache<java.lang.String, android.graphics.Typeface> r5 = r12.typefaceCache     // Catch:{ Exception -> 0x01c3 }
            java.lang.Object r5 = r5.get(r14)     // Catch:{ Exception -> 0x01c3 }
            android.graphics.Typeface r5 = (android.graphics.Typeface) r5     // Catch:{ Exception -> 0x01c3 }
            if (r5 == 0) goto L_0x0037
            android.graphics.Typeface r14 = r13.getTypeface()     // Catch:{ Exception -> 0x01c3 }
            if (r14 == r5) goto L_0x0036
            if (r4 == 0) goto L_0x0033
            int r14 = r4.intValue()     // Catch:{ Exception -> 0x01c3 }
            r13.setTypeface(r5, r14)     // Catch:{ Exception -> 0x01c3 }
            goto L_0x0036
        L_0x0033:
            r13.setTypeface(r5)     // Catch:{ Exception -> 0x01c3 }
        L_0x0036:
            return
        L_0x0037:
            if (r3 == 0) goto L_0x018b
            java.lang.String[] r2 = r14.split(r2)     // Catch:{ Exception -> 0x01c3 }
            int r3 = r2.length     // Catch:{ Exception -> 0x01c3 }
            r6 = 2
            if (r3 == r6) goto L_0x004d
            in.juspay.hypersdk.core.DuiCallback r13 = r12.duiCallback     // Catch:{ Exception -> 0x01c3 }
            in.juspay.hypersdk.core.DuiLogger r13 = r13.getLogger()     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r14 = "incorrect font format recieved"
            r13.e(r1, r14)     // Catch:{ Exception -> 0x01c3 }
            return
        L_0x004d:
            r3 = 0
            r7 = r2[r3]     // Catch:{ Exception -> 0x01c3 }
            r8 = 1
            r2 = r2[r8]     // Catch:{ Exception -> 0x01c3 }
            int r9 = r7.hashCode()     // Catch:{ Exception -> 0x01c3 }
            r10 = 3433509(0x346425, float:4.811371E-39)
            r11 = -1
            if (r9 == r10) goto L_0x007c
            r10 = 108403163(0x67619db, float:4.6286453E-35)
            if (r9 == r10) goto L_0x0072
            r10 = 1544803905(0x5c13d641, float:1.6644958E17)
            if (r9 == r10) goto L_0x0068
            goto L_0x0086
        L_0x0068:
            java.lang.String r9 = "default"
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x01c3 }
            if (r7 == 0) goto L_0x0086
            r7 = 2
            goto L_0x0087
        L_0x0072:
            java.lang.String r9 = "resId"
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x01c3 }
            if (r7 == 0) goto L_0x0086
            r7 = 1
            goto L_0x0087
        L_0x007c:
            java.lang.String r9 = "path"
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x01c3 }
            if (r7 == 0) goto L_0x0086
            r7 = 0
            goto L_0x0087
        L_0x0086:
            r7 = -1
        L_0x0087:
            r9 = 26
            if (r7 == 0) goto L_0x0121
            if (r7 == r8) goto L_0x00f5
            if (r7 == r6) goto L_0x0091
            goto L_0x01ab
        L_0x0091:
            int r0 = r2.hashCode()     // Catch:{ Exception -> 0x01c3 }
            r7 = 3029637(0x2e3a85, float:4.245426E-39)
            if (r0 == r7) goto L_0x00b9
            r7 = 1086463900(0x40c21f9c, float:6.0663586)
            if (r0 == r7) goto L_0x00af
            r7 = 1222907667(0x48e41713, float:467128.6)
            if (r0 == r7) goto L_0x00a5
            goto L_0x00c2
        L_0x00a5:
            java.lang.String r0 = "semiBold"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x01c3 }
            if (r0 == 0) goto L_0x00c2
            r11 = 2
            goto L_0x00c2
        L_0x00af:
            java.lang.String r0 = "regular"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x01c3 }
            if (r0 == 0) goto L_0x00c2
            r11 = 0
            goto L_0x00c2
        L_0x00b9:
            java.lang.String r0 = "bold"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x01c3 }
            if (r0 == 0) goto L_0x00c2
            r11 = 1
        L_0x00c2:
            java.lang.String r0 = "sans-serif"
            if (r11 == 0) goto L_0x00e6
            if (r11 == r8) goto L_0x00dd
            if (r11 == r6) goto L_0x00cc
            goto L_0x01ab
        L_0x00cc:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r2 = "sans-serif-medium"
            int r3 = r0.intValue()     // Catch:{ Exception -> 0x01c3 }
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r2, r3)     // Catch:{ Exception -> 0x01c3 }
            r4 = r0
            goto L_0x01ab
        L_0x00dd:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x01c3 }
            int r3 = r2.intValue()     // Catch:{ Exception -> 0x01c3 }
            goto L_0x00ee
        L_0x00e6:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x01c3 }
            int r3 = r2.intValue()     // Catch:{ Exception -> 0x01c3 }
        L_0x00ee:
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r0, r3)     // Catch:{ Exception -> 0x01c3 }
            r4 = r2
            goto L_0x01ab
        L_0x00f5:
            int r0 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x01c3 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01c3 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01c3 }
            if (r2 < r9) goto L_0x0111
            android.content.Context r2 = r12.context     // Catch:{ Exception -> 0x01c3 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x01c3 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x01c3 }
            android.graphics.Typeface r5 = r2.getFont(r0)     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01ab
        L_0x0111:
            android.content.Context r2 = r12.context     // Catch:{ Exception -> 0x01c3 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x01c3 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x01c3 }
            android.graphics.Typeface r5 = androidx.core.content.res.ResourcesCompat.getFont(r2, r0)     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01ab
        L_0x0121:
            boolean r6 = r2.contains(r0)     // Catch:{ Exception -> 0x01c3 }
            if (r6 == 0) goto L_0x0138
            java.lang.String r3 = ""
            java.lang.String r0 = r2.replace(r0, r3)     // Catch:{ Exception -> 0x01c3 }
            android.content.Context r2 = r12.context     // Catch:{ Exception -> 0x01c3 }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ Exception -> 0x01c3 }
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromAsset(r2, r0)     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01ab
        L_0x0138:
            java.lang.String r0 = "res/"
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x01c3 }
            if (r0 == 0) goto L_0x01ab
            java.lang.String r0 = "/"
            java.lang.String[] r0 = r2.split(r0)     // Catch:{ Exception -> 0x01c3 }
            int r2 = r0.length     // Catch:{ Exception -> 0x01c3 }
            int r2 = r2 - r8
            r0 = r0[r2]     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r2 = "\\."
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x01c3 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x01c3 }
            android.content.Context r2 = r12.context     // Catch:{ Exception -> 0x01c3 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r3 = "font"
            android.content.Context r5 = r12.context     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x01c3 }
            int r0 = r2.getIdentifier(r0, r3, r5)     // Catch:{ Exception -> 0x01c3 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01c3 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01c3 }
            if (r2 < r9) goto L_0x017b
            android.content.Context r2 = r12.context     // Catch:{ Exception -> 0x01c3 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x01c3 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x01c3 }
            android.graphics.Typeface r0 = r2.getFont(r0)     // Catch:{ Exception -> 0x01c3 }
            goto L_0x0189
        L_0x017b:
            android.content.Context r2 = r12.context     // Catch:{ Exception -> 0x01c3 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x01c3 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x01c3 }
            android.graphics.Typeface r0 = androidx.core.content.res.ResourcesCompat.getFont(r2, r0)     // Catch:{ Exception -> 0x01c3 }
        L_0x0189:
            r5 = r0
            goto L_0x01ab
        L_0x018b:
            android.content.Context r0 = r12.context     // Catch:{ Exception -> 0x01c3 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x01c3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c3 }
            r2.<init>()     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r3 = "fonts/"
            r2.append(r3)     // Catch:{ Exception -> 0x01c3 }
            r2.append(r14)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r3 = ".ttf"
            r2.append(r3)     // Catch:{ Exception -> 0x01c3 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01c3 }
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromAsset(r0, r2)     // Catch:{ Exception -> 0x01c3 }
        L_0x01ab:
            android.util.LruCache<java.lang.String, android.graphics.Typeface> r0 = r12.typefaceCache     // Catch:{ Exception -> 0x01c3 }
            r0.put(r14, r5)     // Catch:{ Exception -> 0x01c3 }
            if (r4 == 0) goto L_0x01bf
            android.util.LruCache<java.lang.String, java.lang.Integer> r0 = r12.typefaceWeightCache     // Catch:{ Exception -> 0x01c3 }
            r0.put(r14, r4)     // Catch:{ Exception -> 0x01c3 }
            int r14 = r4.intValue()     // Catch:{ Exception -> 0x01c3 }
            r13.setTypeface(r5, r14)     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01d1
        L_0x01bf:
            r13.setTypeface(r5)     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01d1
        L_0x01c3:
            r13 = move-exception
            in.juspay.hypersdk.core.DuiCallback r14 = r12.duiCallback
            in.juspay.hypersdk.core.DuiLogger r14 = r14.getLogger()
            java.lang.String r13 = r13.toString()
            r14.e(r1, r13)
        L_0x01d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.ListAdapter.setFontStyle(android.view.View, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:62|63) */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r7.duiCallback.getLogger().e("IMG_ERR", "Couldn't read from assets");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x015d */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f A[SYNTHETIC, Splitter:B:16:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084 A[Catch:{ Exception -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01d1 A[Catch:{ Exception -> 0x01e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setImage(android.view.View r17, java.lang.String r18) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            java.lang.String r1 = "assets/"
            java.lang.String r8 = "IMG_ERR"
            java.lang.String r2 = "/"
            boolean r3 = r0 instanceof android.widget.ImageView
            if (r3 != 0) goto L_0x000f
            return
        L_0x000f:
            r9 = r0
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            java.lang.String r0 = ","
            r3 = r18
            java.lang.String[] r0 = r3.split(r0)     // Catch:{ Exception -> 0x01e0 }
            int r3 = r0.length     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r4 = "drawable"
            r10 = 0
            r11 = 1
            if (r3 <= r11) goto L_0x0040
            r3 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x01e0 }
            if (r3 != 0) goto L_0x0040
            android.content.Context r3 = r7.context     // Catch:{ Exception -> 0x01e0 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Exception -> 0x01e0 }
            r5 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            android.content.Context r6 = r7.context     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x01e0 }
            int r3 = r3.getIdentifier(r5, r4, r6)     // Catch:{ Exception -> 0x01e0 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x01e0 }
            goto L_0x0041
        L_0x0040:
            r3 = r10
        L_0x0041:
            r12 = 0
            r0 = r0[r12]     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r5 = "->"
            java.lang.String[] r0 = r0.split(r5)     // Catch:{ Exception -> 0x01e0 }
            int r5 = r0.length     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r13 = ""
            if (r5 != r11) goto L_0x0084
            r0 = r0[r12]     // Catch:{ Exception -> 0x01e0 }
            android.content.Context r1 = r7.context     // Catch:{ Exception -> 0x01e0 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01e0 }
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x01e0 }
            int r1 = r1.getIdentifier(r0, r4, r2)     // Catch:{ Exception -> 0x01e0 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01e0 }
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r2 = r7.drawableCache     // Catch:{ Exception -> 0x01e0 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ Exception -> 0x01e0 }
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2     // Catch:{ Exception -> 0x01e0 }
            if (r2 != 0) goto L_0x0081
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x01e0 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x01e0 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01e0 }
            android.graphics.drawable.Drawable r1 = r2.getDrawable(r1)     // Catch:{ Exception -> 0x01e0 }
        L_0x007d:
            r13 = r0
        L_0x007e:
            r10 = r1
            goto L_0x01cf
        L_0x0081:
            r10 = r2
            goto L_0x01cf
        L_0x0084:
            r4 = r0[r12]     // Catch:{ Exception -> 0x01e0 }
            r5 = -1
            int r6 = r4.hashCode()     // Catch:{ Exception -> 0x01e0 }
            r14 = 116079(0x1c56f, float:1.62661E-40)
            r15 = 2
            if (r6 == r14) goto L_0x00b0
            r14 = 3433509(0x346425, float:4.811371E-39)
            if (r6 == r14) goto L_0x00a6
            r14 = 108403163(0x67619db, float:4.6286453E-35)
            if (r6 == r14) goto L_0x009c
            goto L_0x00ba
        L_0x009c:
            java.lang.String r6 = "resId"
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x01e0 }
            if (r4 == 0) goto L_0x00ba
            r5 = 1
            goto L_0x00ba
        L_0x00a6:
            java.lang.String r6 = "path"
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x01e0 }
            if (r4 == 0) goto L_0x00ba
            r5 = 0
            goto L_0x00ba
        L_0x00b0:
            java.lang.String r6 = "url"
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x01e0 }
            if (r4 == 0) goto L_0x00ba
            r5 = 2
        L_0x00ba:
            if (r5 == 0) goto L_0x012d
            if (r5 == r11) goto L_0x0104
            if (r5 == r15) goto L_0x00c2
            goto L_0x01cf
        L_0x00c2:
            r14 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            in.juspay.hypersdk.mystique.BitmapCache r0 = r7.bitmapCache     // Catch:{ Exception -> 0x01e0 }
            android.graphics.Bitmap r0 = r0.get(r14)     // Catch:{ Exception -> 0x01e0 }
            if (r0 == 0) goto L_0x00d1
            r9.setImageBitmap(r0)     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01cf
        L_0x00d1:
            if (r3 == 0) goto L_0x00e4
            android.content.Context r0 = r7.context     // Catch:{ Exception -> 0x01e0 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x01e0 }
            int r1 = r3.intValue()     // Catch:{ Exception -> 0x01e0 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ Exception -> 0x01e0 }
            r9.setImageDrawable(r0)     // Catch:{ Exception -> 0x01e0 }
        L_0x00e4:
            in.juspay.hypersdk.mystique.DownloadImageTask r15 = new in.juspay.hypersdk.mystique.DownloadImageTask     // Catch:{ Exception -> 0x01e0 }
            android.content.Context r0 = r7.context     // Catch:{ Exception -> 0x01e0 }
            android.content.Context r4 = r0.getApplicationContext()     // Catch:{ Exception -> 0x01e0 }
            in.juspay.hypersdk.mystique.BitmapCache r5 = r7.bitmapCache     // Catch:{ Exception -> 0x01e0 }
            in.juspay.hypersdk.core.DuiCallback r6 = r7.duiCallback     // Catch:{ Exception -> 0x01e0 }
            r0 = r15
            r1 = r16
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x01e0 }
            java.lang.String[] r0 = new java.lang.String[r11]     // Catch:{ Exception -> 0x01e0 }
            r0[r12] = r14     // Catch:{ Exception -> 0x01e0 }
            r15.execute(r0)     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01cf
        L_0x0104:
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r1 = r7.drawableCache     // Catch:{ Exception -> 0x01e0 }
            r2 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x01e0 }
            r10 = r1
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Exception -> 0x01e0 }
            if (r10 != 0) goto L_0x01cf
            r1 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x01e0 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01e0 }
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x01e0 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x01e0 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01e0 }
            android.graphics.drawable.Drawable r10 = r2.getDrawable(r1)     // Catch:{ Exception -> 0x01e0 }
            r13 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01cf
        L_0x012d:
            r3 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            boolean r3 = r3.contains(r1)     // Catch:{ Exception -> 0x01e0 }
            if (r3 == 0) goto L_0x016a
            r0 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r0 = r0.replace(r1, r13)     // Catch:{ Exception -> 0x01e0 }
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r1 = r7.drawableCache     // Catch:{ Exception -> 0x01e0 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x01e0 }
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1     // Catch:{ Exception -> 0x01e0 }
            if (r1 != 0) goto L_0x007e
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x015d }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x015d }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ Exception -> 0x015d }
            java.io.InputStream r2 = r2.open(r0)     // Catch:{ Exception -> 0x015d }
            android.graphics.drawable.Drawable r1 = android.graphics.drawable.Drawable.createFromStream(r2, r10)     // Catch:{ Exception -> 0x015d }
            r2.close()     // Catch:{ Exception -> 0x015c }
            goto L_0x007d
        L_0x015c:
            r13 = r0
        L_0x015d:
            in.juspay.hypersdk.core.DuiCallback r0 = r7.duiCallback     // Catch:{ Exception -> 0x01e0 }
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r2 = "Couldn't read from assets"
            r0.e(r8, r2)     // Catch:{ Exception -> 0x01e0 }
            goto L_0x007e
        L_0x016a:
            r1 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r3 = "res/"
            boolean r1 = r1.contains(r3)     // Catch:{ Exception -> 0x01e0 }
            if (r1 == 0) goto L_0x01cf
            r0 = r0[r11]     // Catch:{ Exception -> 0x01e0 }
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x01e0 }
            int r1 = r0.length     // Catch:{ Exception -> 0x01e0 }
            int r1 = r1 - r11
            r1 = r0[r1]     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)     // Catch:{ Exception -> 0x01e0 }
            r1 = r1[r12]     // Catch:{ Exception -> 0x01e0 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01e0 }
            r4 = 26
            if (r3 < r4) goto L_0x0197
            int r3 = r0.length     // Catch:{ Exception -> 0x01e0 }
            int r3 = r3 - r11
            java.lang.Object[] r0 = java.util.Arrays.copyOfRange(r0, r11, r3)     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r0 = android.text.TextUtils.join(r2, r0)     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01a1
        L_0x0197:
            int r3 = r0.length     // Catch:{ Exception -> 0x01e0 }
            int r3 = r3 - r11
            java.lang.Object[] r0 = java.util.Arrays.copyOfRange(r0, r11, r3)     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r0 = android.text.TextUtils.join(r2, r0)     // Catch:{ Exception -> 0x01e0 }
        L_0x01a1:
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x01e0 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x01e0 }
            android.content.Context r3 = r7.context     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x01e0 }
            int r0 = r2.getIdentifier(r1, r0, r3)     // Catch:{ Exception -> 0x01e0 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01e0 }
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r2 = r7.drawableCache     // Catch:{ Exception -> 0x01e0 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x01e0 }
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2     // Catch:{ Exception -> 0x01e0 }
            if (r2 != 0) goto L_0x0081
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x01e0 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x01e0 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x01e0 }
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r0)     // Catch:{ Exception -> 0x01e0 }
            r10 = r0
            r13 = r1
        L_0x01cf:
            if (r10 == 0) goto L_0x01eb
            r9.setImageDrawable(r10)     // Catch:{ Exception -> 0x01e0 }
            boolean r0 = r13.isEmpty()     // Catch:{ Exception -> 0x01e0 }
            if (r0 != 0) goto L_0x01eb
            android.util.LruCache<java.lang.String, android.graphics.drawable.Drawable> r0 = r7.drawableCache     // Catch:{ Exception -> 0x01e0 }
            r0.put(r13, r10)     // Catch:{ Exception -> 0x01e0 }
            goto L_0x01eb
        L_0x01e0:
            in.juspay.hypersdk.core.DuiCallback r0 = r7.duiCallback
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()
            java.lang.String r1 = "Unable to set drawable, input error"
            r0.e(r8, r1)
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.ListAdapter.setImage(android.view.View, java.lang.String):void");
    }

    private void setPackageIcon(View view, String str) {
        PackageManager packageManager = this.context.getPackageManager();
        ((ImageView) view).setImageDrawable(packageManager.getApplicationInfo(str, 0).loadIcon(packageManager));
    }

    private void setText(View view, String str) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!textView.getText().equals(str)) {
                textView.setText(str);
            }
        }
    }

    private void setTextColor(View view, String str) {
        TextView textView;
        int intValue;
        if (view instanceof TextView) {
            if (str == null) {
                textView = (TextView) view;
                intValue = -16777216;
            } else {
                Integer num = this.colorCache.get(str);
                if (num == null) {
                    num = Integer.valueOf(Color.parseColor(str));
                    this.colorCache.put(str, num);
                }
                textView = (TextView) view;
                intValue = num.intValue();
            }
            textView.setTextColor(intValue);
        }
    }

    private void setTextSize(View view, String str) {
        if (view instanceof TextView) {
            float parseInt = ((float) Integer.parseInt(str)) * this.density;
            TextView textView = (TextView) view;
            if (textView.getTextSize() != parseInt) {
                textView.setTextSize(0, parseInt);
            }
        }
    }

    private void setVisibility(View view, String str) {
        view.setVisibility(str.equalsIgnoreCase("gone") ? 8 : str.equalsIgnoreCase("invisible") ? 4 : 0);
    }

    private void updateView(View view, int i) {
        if (view.getTag() != null) {
            Holder holder = (Holder) view.getTag();
            int i2 = 0;
            while (true) {
                View[] viewArr = holder.views;
                if (i2 < viewArr.length) {
                    if (viewArr[i2] != null) {
                        applyUpdate(viewArr[i2], this.holderData.getJSONObject(i2), this.rowData.getJSONObject(i), i);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public int getCount() {
        return this.rowData.length();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createView();
            if (view == null) {
                return new View(this.context);
            }
            view.setTag(new Holder(view));
        }
        try {
            updateView(view, i);
        } catch (Exception unused) {
        }
        return view;
    }

    public void updateRowData(JSONArray jSONArray) {
        this.rowData = jSONArray;
    }
}
