package io.hansel.visualizer;

import android.app.Activity;
import android.content.Context;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.visualizer.b.f;
import io.hansel.visualizer.c.d.b;
import io.hansel.visualizer.c.d.g;
import io.hansel.visualizer.c.d.j;
import io.hansel.visualizer.c.d.k;
import io.hansel.visualizer.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DOM {

    /* renamed from: a  reason: collision with root package name */
    public final a f5743a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final g f5744b;

    public static class GetDocumentResponse {
        @io.hansel.visualizer.d.b.a(required = true)
        public Node root;

        public GetDocumentResponse() {
        }
    }

    public static class Node {
        @io.hansel.visualizer.d.b.a
        public CoreJSONObject attr;
        @io.hansel.visualizer.d.b.a
        public List<Node> children;
        @io.hansel.visualizer.d.b.a
        public String eid;
        @io.hansel.visualizer.d.b.a
        public String type;

        public Node() {
        }
    }

    public DOM(g gVar) {
        this.f5744b = (g) io.hansel.visualizer.b.g.b(gVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[SYNTHETIC, Splitter:B:19:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.hansel.visualizer.DOM.Node a(java.lang.Object r16, io.hansel.visualizer.c.d.j r17, io.hansel.visualizer.b.a<java.lang.Object> r18, int r19) {
        /*
            r15 = this;
            r7 = r15
            r5 = r18
            r6 = r19
            java.lang.String r1 = "attr"
            io.hansel.core.json.CoreJSONObject r0 = new io.hansel.core.json.CoreJSONObject
            r0.<init>()
            r2 = r16
            r15.a(r2, r5, r0)
            r3 = r0
        L_0x0012:
            r4 = 0
            if (r2 == 0) goto L_0x003d
            boolean r0 = r2 instanceof android.view.View
            if (r0 != 0) goto L_0x003d
            io.hansel.core.json.CoreJSONObject r8 = new io.hansel.core.json.CoreJSONObject     // Catch:{ Exception -> 0x0032 }
            r8.<init>()     // Catch:{ Exception -> 0x0032 }
            r9 = r17
            io.hansel.visualizer.c.d.k r0 = r9.a(r2)     // Catch:{ Exception -> 0x002f }
            java.util.List<java.lang.Object> r0 = r0.f5817c     // Catch:{ Exception -> 0x002f }
            java.lang.Object r2 = r0.get(r4)     // Catch:{ Exception -> 0x002f }
            r15.a(r2, r5, r8)     // Catch:{ Exception -> 0x002f }
            r3 = r8
            goto L_0x0012
        L_0x002f:
            r0 = move-exception
            r3 = r8
            goto L_0x0035
        L_0x0032:
            r0 = move-exception
            r9 = r17
        L_0x0035:
            io.hansel.core.logger.LogGroup r8 = io.hansel.core.logger.LogGroup.PT
            java.lang.String r10 = "Error processing UI while capturing the screen"
            io.hansel.core.logger.HSLLogger.printStackTrace(r0, r10, r8)
            goto L_0x003f
        L_0x003d:
            r9 = r17
        L_0x003f:
            r0 = r3
            r3 = r2
            io.hansel.visualizer.DOM$Node r8 = new io.hansel.visualizer.DOM$Node
            r2 = 0
            r8.<init>()
            if (r3 == 0) goto L_0x0120
            int r10 = r0.length()     // Catch:{ Exception -> 0x0128 }
            if (r10 <= 0) goto L_0x0120
            boolean r10 = r0.has(r1)     // Catch:{ Exception -> 0x0128 }
            if (r10 == 0) goto L_0x0118
            io.hansel.core.json.CoreJSONObject r10 = r0.getJSONObject(r1)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r11 = "w"
            int r11 = r10.getInt(r11)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r12 = "h"
            int r12 = r10.getInt(r12)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r13 = "x"
            int r13 = r10.getInt(r13)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r14 = "y"
            int r10 = r10.getInt(r14)     // Catch:{ Exception -> 0x0128 }
            int r13 = r13 + r11
            java.lang.String r11 = "hidden"
            r14 = 1
            if (r13 <= r14) goto L_0x00d5
            int r10 = r10 + r12
            if (r10 <= r14) goto L_0x00d5
            io.hansel.core.json.CoreJSONObject r1 = r0.getJSONObject(r1)     // Catch:{ Exception -> 0x0128 }
            r8.attr = r1     // Catch:{ Exception -> 0x0128 }
            r1 = r3
            android.view.View r1 = (android.view.View) r1     // Catch:{ Exception -> 0x0128 }
            int r10 = r1.getVisibility()     // Catch:{ Exception -> 0x0128 }
            if (r10 == 0) goto L_0x0098
            io.hansel.core.json.CoreJSONObject r10 = r8.attr     // Catch:{ Exception -> 0x0128 }
            java.lang.Boolean r12 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0128 }
            r10.putOpt(r11, r12)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r10 = "Node is hidden (not visible)"
            io.hansel.core.logger.HSLLogger.d(r10)     // Catch:{ Exception -> 0x0128 }
        L_0x0098:
            java.lang.Object r10 = r1.getTag(r6)     // Catch:{ Exception -> 0x0128 }
            if (r10 == 0) goto L_0x00d5
            java.lang.Object r1 = r1.getTag(r6)     // Catch:{ Exception -> 0x0128 }
            boolean r10 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0128 }
            if (r10 != 0) goto L_0x00aa
            boolean r10 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x0128 }
            if (r10 == 0) goto L_0x00d5
        L_0x00aa:
            boolean r10 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0128 }
            if (r10 == 0) goto L_0x00b8
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0128 }
            boolean r1 = java.lang.Boolean.parseBoolean(r1)     // Catch:{ Exception -> 0x0128 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0128 }
        L_0x00b8:
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0128 }
            io.hansel.core.json.CoreJSONObject r10 = r8.attr     // Catch:{ Exception -> 0x0128 }
            java.lang.String r12 = "ignore"
            r10.putOpt(r12, r1)     // Catch:{ Exception -> 0x0128 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0128 }
            r10.<init>()     // Catch:{ Exception -> 0x0128 }
            java.lang.String r12 = "Node has skipTag value set to "
            r10.append(r12)     // Catch:{ Exception -> 0x0128 }
            r10.append(r1)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r1 = r10.toString()     // Catch:{ Exception -> 0x0128 }
            io.hansel.core.logger.HSLLogger.d(r1)     // Catch:{ Exception -> 0x0128 }
        L_0x00d5:
            r1 = r3
            android.view.View r1 = (android.view.View) r1     // Catch:{ Exception -> 0x0128 }
            r10 = 2147483647(0x7fffffff, float:NaN)
            java.lang.Object r1 = r1.getTag(r10)     // Catch:{ Exception -> 0x0128 }
            if (r1 == 0) goto L_0x00ed
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0128 }
            java.lang.String r10 = "xpath"
            java.lang.Object r1 = r1.get(r10)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0128 }
            goto L_0x00ee
        L_0x00ed:
            r1 = r2
        L_0x00ee:
            java.lang.String r10 = "type"
            java.lang.String r0 = r0.getString(r10)     // Catch:{ Exception -> 0x0128 }
            r8.type = r0     // Catch:{ Exception -> 0x0128 }
            if (r1 != 0) goto L_0x00fa
            r1 = r0
        L_0x00fa:
            r8.eid = r1     // Catch:{ Exception -> 0x0128 }
            io.hansel.core.json.CoreJSONObject r0 = r8.attr     // Catch:{ Exception -> 0x0128 }
            if (r0 == 0) goto L_0x010c
            boolean r0 = r0.optBoolean(r11, r4)     // Catch:{ Exception -> 0x0128 }
            if (r0 == 0) goto L_0x010c
            java.lang.String r0 = "Skipping child views of hidden node"
            io.hansel.core.logger.HSLLogger.d(r0)     // Catch:{ Exception -> 0x0128 }
            return r8
        L_0x010c:
            r1 = r15
            r2 = r8
            r4 = r17
            r5 = r18
            r6 = r19
            r1.a(r2, r3, r4, r5, r6)
            return r8
        L_0x0118:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0128 }
            java.lang.String r1 = "This is no attribute node"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0128 }
            throw r0     // Catch:{ Exception -> 0x0128 }
        L_0x0120:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0128 }
            java.lang.String r1 = "This is no accumulator node"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0128 }
            throw r0     // Catch:{ Exception -> 0x0128 }
        L_0x0128:
            r0 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.DOM.a(java.lang.Object, io.hansel.visualizer.c.d.j, io.hansel.visualizer.b.a, int):io.hansel.visualizer.DOM$Node");
    }

    private void a(Node node, Object obj, j jVar, io.hansel.visualizer.b.a<Object> aVar, int i) {
        k a2 = jVar.a(obj);
        List<Node> emptyList = a2.f5817c.size() == 0 ? Collections.emptyList() : new ArrayList<>(a2.f5817c.size());
        int size = a2.f5817c.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj2 = a2.f5817c.get(i2);
            Activity b2 = b.a().b();
            if (obj2 != null && (!(obj2 instanceof Activity) || obj2 == b2)) {
                Node a3 = a(obj2, jVar, aVar, i);
                if (!(a3 == null || a3.eid == null)) {
                    emptyList.add(a3);
                }
            }
        }
        if (emptyList.size() > 0) {
            node.children = emptyList;
        }
    }

    private void a(Object obj, io.hansel.visualizer.b.a<Object> aVar, CoreJSONObject coreJSONObject) {
        if (aVar != null) {
            aVar.a(obj);
        }
        this.f5744b.b(obj).a(obj, coreJSONObject);
    }

    public CoreJSONObject a(final Context context) {
        GetDocumentResponse getDocumentResponse = new GetDocumentResponse();
        getDocumentResponse.root = (Node) this.f5744b.a((f<V>) new f<Node>() {
            public Node call() {
                DOM.this.f5744b.j();
                Object c2 = DOM.this.f5744b.c();
                int identifier = context.getResources().getIdentifier("hansel_ignore_view", "id", context.getPackageName());
                DOM dom = DOM.this;
                return dom.a(c2, dom.f5744b.g(), null, identifier);
            }
        });
        return ((CoreJSONObject) this.f5743a.a((Object) getDocumentResponse, CoreJSONObject.class)).optJSONObject("root");
    }

    public void a() {
        this.f5744b.e();
    }
}
