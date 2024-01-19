package com.userexperior.a.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;

public final class j<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f3694f = (!j.class.desiredAssertionStatus());
    public static final Comparator<Comparable> g = new Comparator<Comparable>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f3695a;

    /* renamed from: b  reason: collision with root package name */
    public n<K, V> f3696b;

    /* renamed from: c  reason: collision with root package name */
    public int f3697c;

    /* renamed from: d  reason: collision with root package name */
    public int f3698d;

    /* renamed from: e  reason: collision with root package name */
    public final n<K, V> f3699e;
    public k h;
    public l i;

    public j() {
        this(g);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Comparator<? super K>, code=java.util.Comparator, for r2v0, types: [java.util.Comparator<? super K>, java.util.Comparator] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(java.util.Comparator r2) {
        /*
            r1 = this;
            r1.<init>()
            r0 = 0
            r1.f3697c = r0
            r1.f3698d = r0
            com.userexperior.a.a.b.n r0 = new com.userexperior.a.a.b.n
            r0.<init>()
            r1.f3699e = r0
            if (r2 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            java.util.Comparator<java.lang.Comparable> r2 = g
        L_0x0014:
            r1.f3695a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.j.<init>(java.util.Comparator):void");
    }

    private n<K, V> a(K k, boolean z) {
        int i2;
        n<K, V> nVar;
        Comparator<? super K> comparator = this.f3695a;
        n<K, V> nVar2 = this.f3696b;
        if (nVar2 != null) {
            Comparable comparable = comparator == g ? (Comparable) k : null;
            while (true) {
                K k2 = nVar2.f3713f;
                i2 = comparable != null ? comparable.compareTo(k2) : comparator.compare(k, k2);
                if (i2 != 0) {
                    n<K, V> nVar3 = i2 < 0 ? nVar2.f3709b : nVar2.f3710c;
                    if (nVar3 == null) {
                        break;
                    }
                    nVar2 = nVar3;
                } else {
                    return nVar2;
                }
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        n<K, V> nVar4 = this.f3699e;
        if (nVar2 != null) {
            nVar = new n<>(nVar2, k, nVar4, nVar4.f3712e);
            if (i2 < 0) {
                nVar2.f3709b = nVar;
            } else {
                nVar2.f3710c = nVar;
            }
            b(nVar2, true);
        } else if (comparator != g || (k instanceof Comparable)) {
            nVar = new n<>(nVar2, k, nVar4, nVar4.f3712e);
            this.f3696b = nVar;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.f3697c++;
        this.f3698d++;
        return nVar;
    }

    private void a(n<K, V> nVar) {
        n<K, V> nVar2 = nVar.f3709b;
        n<K, V> nVar3 = nVar.f3710c;
        n<K, V> nVar4 = nVar3.f3709b;
        n<K, V> nVar5 = nVar3.f3710c;
        nVar.f3710c = nVar4;
        if (nVar4 != null) {
            nVar4.f3708a = nVar;
        }
        a(nVar, nVar3);
        nVar3.f3709b = nVar;
        nVar.f3708a = nVar3;
        int i2 = 0;
        int max = Math.max(nVar2 != null ? nVar2.h : 0, nVar4 != null ? nVar4.h : 0) + 1;
        nVar.h = max;
        if (nVar5 != null) {
            i2 = nVar5.h;
        }
        nVar3.h = Math.max(max, i2) + 1;
    }

    private void a(n<K, V> nVar, n<K, V> nVar2) {
        n<K, V> nVar3 = nVar.f3708a;
        nVar.f3708a = null;
        if (nVar2 != null) {
            nVar2.f3708a = nVar3;
        }
        if (nVar3 == null) {
            this.f3696b = nVar2;
        } else if (nVar3.f3709b == nVar) {
            nVar3.f3709b = nVar2;
        } else if (f3694f || nVar3.f3710c == nVar) {
            nVar3.f3710c = nVar2;
        } else {
            throw new AssertionError();
        }
    }

    private n<K, V> b(Object obj) {
        if (obj != null) {
            try {
                return a((K) obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    private void b(n<K, V> nVar) {
        n<K, V> nVar2 = nVar.f3709b;
        n<K, V> nVar3 = nVar.f3710c;
        n<K, V> nVar4 = nVar2.f3709b;
        n<K, V> nVar5 = nVar2.f3710c;
        nVar.f3709b = nVar5;
        if (nVar5 != null) {
            nVar5.f3708a = nVar;
        }
        a(nVar, nVar2);
        nVar2.f3710c = nVar;
        nVar.f3708a = nVar2;
        int i2 = 0;
        int max = Math.max(nVar3 != null ? nVar3.h : 0, nVar5 != null ? nVar5.h : 0) + 1;
        nVar.h = max;
        if (nVar4 != null) {
            i2 = nVar4.h;
        }
        nVar2.h = Math.max(max, i2) + 1;
    }

    private void b(n<K, V> nVar, boolean z) {
        while (nVar != null) {
            n<K, V> nVar2 = nVar.f3709b;
            n<K, V> nVar3 = nVar.f3710c;
            int i2 = 0;
            int i3 = nVar2 != null ? nVar2.h : 0;
            int i4 = nVar3 != null ? nVar3.h : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                n<K, V> nVar4 = nVar3.f3709b;
                n<K, V> nVar5 = nVar3.f3710c;
                int i6 = nVar5 != null ? nVar5.h : 0;
                if (nVar4 != null) {
                    i2 = nVar4.h;
                }
                int i7 = i2 - i6;
                if (i7 != -1 && (i7 != 0 || z)) {
                    if (f3694f || i7 == 1) {
                        b(nVar3);
                    } else {
                        throw new AssertionError();
                    }
                }
                a(nVar);
                if (z) {
                    break;
                }
            } else if (i5 == 2) {
                n<K, V> nVar6 = nVar2.f3709b;
                n<K, V> nVar7 = nVar2.f3710c;
                int i8 = nVar7 != null ? nVar7.h : 0;
                if (nVar6 != null) {
                    i2 = nVar6.h;
                }
                int i9 = i2 - i8;
                if (i9 != 1 && (i9 != 0 || z)) {
                    if (f3694f || i9 == -1) {
                        a(nVar2);
                    } else {
                        throw new AssertionError();
                    }
                }
                b(nVar);
                if (z) {
                    break;
                }
            } else if (i5 == 0) {
                nVar.h = i3 + 1;
                if (z) {
                    return;
                }
            } else if (f3694f || i5 == -1 || i5 == 1) {
                nVar.h = Math.max(i3, i4) + 1;
                if (!z) {
                    break;
                }
            } else {
                throw new AssertionError();
            }
            nVar = nVar.f3708a;
        }
    }

    public final n<K, V> a(Object obj) {
        n<K, V> b2 = b(obj);
        if (b2 != null) {
            a(b2, true);
        }
        return b2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r3 == r5 || (r3 != null && r3.equals(r5))) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.userexperior.a.a.b.n<K, V> a(java.util.Map.Entry<?, ?> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r5.getKey()
            com.userexperior.a.a.b.n r0 = r4.b(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0023
            V r3 = r0.g
            java.lang.Object r5 = r5.getValue()
            if (r3 == r5) goto L_0x001f
            if (r3 == 0) goto L_0x001d
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r5 = 0
            goto L_0x0020
        L_0x001f:
            r5 = 1
        L_0x0020:
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            if (r1 == 0) goto L_0x0027
            return r0
        L_0x0027:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.j.a(java.util.Map$Entry):com.userexperior.a.a.b.n");
    }

    public final void a(n<K, V> nVar, boolean z) {
        int i2;
        if (z) {
            n<K, V> nVar2 = nVar.f3712e;
            nVar2.f3711d = nVar.f3711d;
            nVar.f3711d.f3712e = nVar2;
        }
        n<K, V> nVar3 = nVar.f3709b;
        n<K, V> nVar4 = nVar.f3710c;
        n<K, V> nVar5 = nVar.f3708a;
        int i3 = 0;
        if (nVar3 == null || nVar4 == null) {
            if (nVar3 != null) {
                a(nVar, nVar3);
                nVar.f3709b = null;
            } else if (nVar4 != null) {
                a(nVar, nVar4);
                nVar.f3710c = null;
            } else {
                a(nVar, (n<K, V>) null);
            }
            b(nVar5, false);
            this.f3697c--;
            this.f3698d++;
            return;
        }
        if (nVar3.h > nVar4.h) {
            do {
                nVar4 = nVar3;
                nVar3 = nVar3.f3710c;
            } while (nVar3 != null);
        } else {
            while (true) {
                n<K, V> nVar6 = nVar4.f3709b;
                if (nVar6 == null) {
                    break;
                }
                nVar4 = nVar6;
            }
        }
        a(nVar4, false);
        n<K, V> nVar7 = nVar.f3709b;
        if (nVar7 != null) {
            i2 = nVar7.h;
            nVar4.f3709b = nVar7;
            nVar7.f3708a = nVar4;
            nVar.f3709b = null;
        } else {
            i2 = 0;
        }
        n<K, V> nVar8 = nVar.f3710c;
        if (nVar8 != null) {
            i3 = nVar8.h;
            nVar4.f3710c = nVar8;
            nVar8.f3708a = nVar4;
            nVar.f3710c = null;
        }
        nVar4.h = Math.max(i2, i3) + 1;
        a(nVar, nVar4);
    }

    public final void clear() {
        this.f3696b = null;
        this.f3697c = 0;
        this.f3698d++;
        n<K, V> nVar = this.f3699e;
        nVar.f3712e = nVar;
        nVar.f3711d = nVar;
    }

    public final boolean containsKey(Object obj) {
        return b(obj) != null;
    }

    public final Set<Entry<K, V>> entrySet() {
        k kVar = this.h;
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(this);
        this.h = kVar2;
        return kVar2;
    }

    public final V get(Object obj) {
        n b2 = b(obj);
        if (b2 != null) {
            return b2.g;
        }
        return null;
    }

    public final Set<K> keySet() {
        l lVar = this.i;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this);
        this.i = lVar2;
        return lVar2;
    }

    public final V put(K k, V v) {
        if (k != null) {
            n a2 = a(k, true);
            V v2 = a2.g;
            a2.g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public final V remove(Object obj) {
        n a2 = a(obj);
        if (a2 != null) {
            return a2.g;
        }
        return null;
    }

    public final int size() {
        return this.f3697c;
    }
}
