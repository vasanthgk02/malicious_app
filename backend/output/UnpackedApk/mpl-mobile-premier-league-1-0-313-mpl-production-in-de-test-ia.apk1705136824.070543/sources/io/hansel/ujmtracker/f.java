package io.hansel.ujmtracker;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<e> f5318a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f5319b;

    public Pair<ArrayList<String>, Set<String>> a(String str, String str2, HashMap<String, Object> hashMap) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (this.f5319b) {
            int size = this.f5318a.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.f5318a.get(i);
                if (eVar != null) {
                    Pair<ArrayList<String>, Set<String>> a2 = eVar.a(str, str2, hashMap);
                    if (a2 != null) {
                        ArrayList arrayList2 = (ArrayList) a2.first;
                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                            arrayList.addAll(arrayList2);
                        }
                        Set set = (Set) a2.second;
                        if (set != null) {
                            hashSet.addAll(set);
                        }
                    }
                }
            }
        }
        return Pair.create(arrayList, hashSet);
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f5319b) {
            int size = this.f5318a.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.f5318a.get(i);
                if (eVar != null) {
                    ArrayList<String> a2 = eVar.a();
                    if (a2 != null && !a2.isEmpty()) {
                        arrayList.addAll(a2);
                    }
                }
            }
        }
        return arrayList;
    }

    public void a(e eVar) {
        this.f5318a.add(eVar);
    }

    public void b() {
        this.f5319b = true;
    }
}
