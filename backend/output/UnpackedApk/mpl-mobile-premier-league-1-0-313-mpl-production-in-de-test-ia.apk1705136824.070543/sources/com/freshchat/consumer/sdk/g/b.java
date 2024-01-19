package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.b.g;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.c.i;
import com.freshchat.consumer.sdk.j.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class b extends c<Article> {
    public final i eL;
    public List<String> eM;
    public String eN;
    public List<Article> eO;
    public List<String> mw;
    public boolean mx;

    public b(Context context) {
        super(context);
        this.eL = new i(context);
    }

    public b(Context context, String str, boolean z, List<Article> list, boolean z2) {
        this(context);
        this.eN = str;
        this.eO = list;
        this.mx = z2;
    }

    public b(Context context, List<Article> list) {
        this(context);
        this.eO = list;
    }

    public b(Context context, List<Article> list, List<String> list2, List<String> list3, String str, boolean z) {
        this(context, list);
        if (k.a(list2)) {
            this.eM = list2;
        }
        if (k.a(list3)) {
            this.mw = list3;
        }
        this.eN = str;
        this.mx = z;
    }

    public ArrayList<Article> a(ArrayList<Article> arrayList) {
        ArrayList<Article> arrayList2 = new ArrayList<>(arrayList);
        Collections.sort(arrayList2, new Comparator<Article>() {
            /* renamed from: a */
            public int compare(Article article, Article article2) {
                if (article2.getRank() > article.getRank()) {
                    return 1;
                }
                return article2.getRank() < article.getRank() ? -1 : 0;
            }
        });
        return arrayList2;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.List<com.freshchat.consumer.sdk.beans.Article>] */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v12, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v14, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.freshchat.consumer.sdk.beans.Article> dd() {
        /*
            r2 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<com.freshchat.consumer.sdk.beans.Article> r1 = r2.eO
            boolean r1 = com.freshchat.consumer.sdk.j.k.a(r1)
            if (r1 == 0) goto L_0x0013
            java.util.List<com.freshchat.consumer.sdk.beans.Article> r1 = r2.eO
            r0.addAll(r1)
            goto L_0x0040
        L_0x0013:
            java.util.List<java.lang.String> r0 = r2.mw
            boolean r0 = com.freshchat.consumer.sdk.j.k.a(r0)
            if (r0 == 0) goto L_0x0024
            com.freshchat.consumer.sdk.c.i r0 = r2.eL
            java.util.List<java.lang.String> r1 = r2.mw
            java.util.List r0 = r0.v(r1)
            goto L_0x003b
        L_0x0024:
            java.util.List<java.lang.String> r0 = r2.eM
            boolean r0 = com.freshchat.consumer.sdk.j.k.a(r0)
            if (r0 == 0) goto L_0x0035
            com.freshchat.consumer.sdk.c.i r0 = r2.eL
            java.util.List<java.lang.String> r1 = r2.eM
            java.util.List r0 = r0.i(r1)
            goto L_0x003b
        L_0x0035:
            com.freshchat.consumer.sdk.c.i r0 = r2.eL
            java.util.List r0 = r0.cK()
        L_0x003b:
            java.util.List<com.freshchat.consumer.sdk.beans.Article> r1 = r2.eO
            r1.addAll(r0)
        L_0x0040:
            java.lang.String r1 = r2.eN
            if (r1 == 0) goto L_0x004a
            java.util.List<com.freshchat.consumer.sdk.beans.Article> r0 = r2.eO
            java.util.ArrayList r0 = r2.p(r0)
        L_0x004a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.g.b.dd():java.util.List");
    }

    public boolean gE() {
        return this.mx;
    }

    public void onReset() {
        super.onReset();
    }

    public void onStartLoading() {
        super.onStartLoading();
    }

    public ArrayList<Article> p(List<Article> list) {
        ArrayList<Article> arrayList = new ArrayList<>();
        String str = this.eN;
        if (str == null || str.trim().length() == 0) {
            arrayList.addAll(list);
            return arrayList;
        }
        String[] split = this.eN.split("\\s+");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new g(this.eN.trim()));
        if (split.length > 1) {
            for (String gVar : split) {
                arrayList2.add(new g(gVar));
            }
        }
        for (Article next : list) {
            String description = next.getDescription();
            String title = next.getTitle();
            Iterator it = arrayList2.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += ((g) it.next()).a(title, description);
            }
            next.setRank(i);
            if (next.getRank() != 0) {
                arrayList.add(next);
            }
        }
        return a(arrayList);
    }
}
