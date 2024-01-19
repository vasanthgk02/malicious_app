package com.freshchat.consumer.sdk.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.beans.Tag.TaggedType;
import com.freshchat.consumer.sdk.c.a.a;
import com.freshchat.consumer.sdk.c.a.d;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i extends b {
    public static final Uri en = Uri.parse("sqlite://com.freshchat.consumer.sdk.model/articles");
    public static final String[] eo = new a().cR();
    public static final String[] ep = new d().cR();
    public Context context;

    public i(Context context2) {
        super(context2);
        this.context = context2.getApplicationContext();
    }

    private Cursor ac(String str) {
        return cs().query("articles", eo, "_id=?", new String[]{str}, null, null, null);
    }

    private Cursor cL() {
        return cs().query("articles", eo, null, null, null, null, "position");
    }

    private List<Article> g(Cursor cursor) {
        return b.b(cursor) ? j(cursor, i(cursor)) : new ArrayList();
    }

    private List<Category> h(Cursor cursor, Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        if (b.d(cursor)) {
            do {
                Category category = new Category();
                category.setId(cursor.getString(map.get("_id").intValue()));
                category.setTitle(cursor.getString(map.get("title").intValue()));
                category.setPosition(cursor.getInt(map.get("position").intValue()));
                category.setIconUrl(cursor.getString(map.get("icon_url").intValue()));
                category.setDescription(cursor.getString(map.get("description").intValue()));
                category.setCategoryAlias(cursor.getString(map.get("category_alias").intValue()));
                arrayList.add(category);
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    private Map<String, Integer> h(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("_id", Integer.valueOf(cursor.getColumnIndex("_id")));
            hashMap.put("category_alias", GeneratedOutlineSupport.outline26(hashMap, "description", GeneratedOutlineSupport.outline26(hashMap, "icon_url", GeneratedOutlineSupport.outline26(hashMap, "position", GeneratedOutlineSupport.outline26(hashMap, "title", Integer.valueOf(cursor.getColumnIndex("title")), cursor, "position"), cursor, "icon_url"), cursor, "description"), cursor, "category_alias"));
        }
        return hashMap;
    }

    private List<String> i(Cursor cursor, Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        if (b.d(cursor)) {
            do {
                arrayList.add(cursor.getString(map.get("_id").intValue()));
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    private Map<String, Integer> i(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("_id", Integer.valueOf(cursor.getColumnIndex("_id")));
            hashMap.put("article_alias", GeneratedOutlineSupport.outline26(hashMap, "content", GeneratedOutlineSupport.outline26(hashMap, "title", GeneratedOutlineSupport.outline26(hashMap, "category_id", Integer.valueOf(cursor.getColumnIndex("category_id")), cursor, "title"), cursor, "content"), cursor, "article_alias"));
        }
        return hashMap;
    }

    private Cursor j(List<String> list) {
        if (k.isEmpty(list)) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" SELECT DISTINCT a.*  FROM articles as a  INNER JOIN categories as c  ON (a.category_id = c._id), (SELECT *  FROM tags WHERE ");
        GeneratedOutlineSupport.outline103(outline73, j.a(k.b((Collection<?>) list), TaggedType.CATEGORY, TaggedType.ARTICLE), ") AS matching_tags  WHERE  (  matching_tags.", "tagged_type", " = '");
        outline73.append(TaggedType.ARTICLE.asInt());
        outline73.append("' AND  matching_tags.");
        outline73.append("tagged_id");
        outline73.append(" = a.");
        GeneratedOutlineSupport.outline103(outline73, "_id", " )  OR  (  matching_tags.", "tagged_type", " = '");
        outline73.append(TaggedType.CATEGORY.asInt());
        outline73.append("' AND  matching_tags.");
        outline73.append("tagged_id");
        outline73.append(" = a.");
        GeneratedOutlineSupport.outline103(outline73, "category_id", " )  ORDER BY c.", "position", ",a.");
        outline73.append("position");
        return cs().rawQuery(outline73.toString(), (String[]) list.toArray(new String[0]));
    }

    private List<Article> j(Cursor cursor, Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        if (b.d(cursor)) {
            do {
                arrayList.add(l(cursor, map));
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    private List<String> k(Cursor cursor, Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        if (b.d(cursor)) {
            do {
                Article l = l(cursor, map);
                if (l != null) {
                    arrayList.add(l.getId());
                }
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    private Article l(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        String string = cursor.getString(map.get("_id").intValue());
        String string2 = cursor.getString(map.get("category_id").intValue());
        String string3 = cursor.getString(map.get("title").intValue());
        String string4 = cursor.getString(map.get("content").intValue());
        String string5 = cursor.getString(map.get("article_alias").intValue());
        Article article = new Article();
        article.setId(string);
        article.setCategoryId(string2);
        article.setTitle(string3);
        article.setDescription(string4);
        article.setArticleAlias(string5);
        return article;
    }

    private Cursor m(List<String> list) {
        if (k.isEmpty(list)) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" SELECT DISTINCT c.*  FROM categories as c  INNER JOIN articles as a  ON ( c._id = a.category_id), (SELECT DISTINCT tagged_id FROM tags WHERE ");
        GeneratedOutlineSupport.outline103(outline73, j.a(k.b((Collection<?>) list), TaggedType.CATEGORY), ") AS matching_tags  WHERE matching_tags.", "tagged_id", " = c.");
        return cs().rawQuery(GeneratedOutlineSupport.outline63(outline73, "_id", " ORDER BY c.", "position"), (String[]) list.toArray(new String[0]));
    }

    private void n(List<Article> list) {
        SQLiteStatement compileStatement = cs().compileStatement(new a().cS());
        for (Article next : list) {
            compileStatement.clearBindings();
            compileStatement.bindString(1, next.getId());
            compileStatement.bindString(2, next.getCategoryId());
            compileStatement.bindString(3, next.getTitle());
            compileStatement.bindString(4, next.getDescription());
            compileStatement.bindString(5, Integer.toString(next.getPosition()));
            compileStatement.bindString(6, next.getUpdatedAt());
            compileStatement.bindString(7, next.getArticleAlias() == null ? "" : next.getArticleAlias());
            compileStatement.execute();
        }
        b.a(compileStatement);
    }

    private void o(List<Category> list) {
        SQLiteStatement compileStatement = cs().compileStatement(new d().cS());
        for (Category next : list) {
            compileStatement.clearBindings();
            compileStatement.bindString(1, next.getId());
            compileStatement.bindString(2, next.getTitle());
            compileStatement.bindString(3, next.getDescription());
            String str = "";
            compileStatement.bindString(4, next.getIconUrl() == null ? str : next.getIconUrl());
            compileStatement.bindString(5, Integer.toString(next.getPosition()));
            compileStatement.bindString(6, Long.toString(next.getUpdatedAt()));
            if (next.getCategoryAlias() != null) {
                str = next.getCategoryAlias();
            }
            compileStatement.bindString(7, str);
            compileStatement.execute();
        }
        b.a(compileStatement);
    }

    public Category Y(String str) {
        Cursor cursor;
        try {
            if (as.isEmpty(str)) {
                b.c(null);
                return null;
            }
            cursor = cs().query("categories", ep, "_id=?", new String[]{str}, null, null, null);
            try {
                if (b.b(cursor)) {
                    List<Category> h = h(cursor, h(cursor));
                    if (k.a(h)) {
                        Category category = h.get(0);
                        b.c(cursor);
                        return category;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    b.c(cursor);
                    throw th;
                }
            }
            b.c(cursor);
            return null;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            q.a(e);
            b.c(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            b.c(cursor);
            throw th;
        }
    }

    public Map<String, Integer> a(Cursor cursor) {
        return null;
    }

    public void a(List<Category> list, List<Article> list2, List<Tag> list3) {
        SQLiteDatabase cs = cs();
        cs.beginTransaction();
        try {
            cs.delete("articles", null, null);
            cs.delete("categories", null, null);
            j jVar = new j(this.context);
            jVar.a(TaggedType.CATEGORY);
            jVar.a(TaggedType.ARTICLE);
            if (k.a(list)) {
                o(list);
                if (k.a(list2)) {
                    n(list2);
                }
                if (k.a(list3)) {
                    jVar.f(list3);
                }
            }
            cs.setTransactionSuccessful();
            cs.endTransaction();
        } catch (Exception e2) {
            q.a(e2);
            throw e2;
        } catch (Throwable th) {
            cs.endTransaction();
            throw th;
        }
    }

    public Article ab(String str) {
        Cursor cursor;
        Article article = null;
        try {
            cursor = ac(str);
            try {
                if (b.b(cursor)) {
                    article = l(cursor, i(cursor));
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return article;
                } catch (Throwable th) {
                    th = th;
                    b.c(cursor);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            q.a(e);
            b.c(cursor);
            return article;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return article;
    }

    public List<Category> cJ() {
        List<Category> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = cs().rawQuery("SELECT * FROM categories WHERE _id IN (SELECT DISTINCT category_id FROM articles) ORDER BY position", null);
            if (b.b(cursor)) {
                arrayList = h(cursor, h(cursor));
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Article> cK() {
        List<Article> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = cL();
            arrayList = g(cursor);
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public void cM() {
        if (aw.fI()) {
            this.context.getContentResolver().notifyChange(en, null);
        }
    }

    public List<String> h(List<String> list) {
        List<String> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = j(list);
            if (b.b(cursor)) {
                arrayList = k(cursor, i(cursor));
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Article> i(List<String> list) {
        List<Article> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = j(list);
            arrayList = g(cursor);
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<String> k(List<String> list) {
        List<String> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = m(list);
            if (b.b(cursor)) {
                arrayList = i(cursor, h(cursor));
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Category> l(List<String> list) {
        List<Category> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = m(list);
            if (b.b(cursor)) {
                arrayList = h(cursor, h(cursor));
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Article> v(List<String> list) {
        String outline53 = GeneratedOutlineSupport.outline53(" SELECT * FROM articles WHERE category_id IN ( ", as.a(ColorPropConverter.PREFIX_ATTR, ",", k.b((Collection<?>) list)), " ) ORDER BY ", "position");
        List<Article> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = cs().rawQuery(outline53, (String[]) list.toArray(new String[0]));
            arrayList = g(cursor);
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }
}
