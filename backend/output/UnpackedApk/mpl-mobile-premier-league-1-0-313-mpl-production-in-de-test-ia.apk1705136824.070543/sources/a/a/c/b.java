package a.a.c;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.lang.String;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class b<K extends String, V extends BitmapFont> {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue<K> f2441a = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<K, V> f2442b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public ReadWriteLock f2443c;

    /* renamed from: d  reason: collision with root package name */
    public Lock f2444d;

    /* renamed from: e  reason: collision with root package name */
    public Lock f2445e;

    /* renamed from: f  reason: collision with root package name */
    public int f2446f;

    public b(int i) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f2443c = reentrantReadWriteLock;
        this.f2444d = reentrantReadWriteLock.readLock();
        this.f2445e = this.f2443c.writeLock();
        this.f2446f = 0;
        this.f2446f = i;
    }

    public V a(K k) {
        V v;
        this.f2444d.lock();
        try {
            if (this.f2442b.containsKey(k)) {
                this.f2441a.remove(k);
                v = (BitmapFont) this.f2442b.get(k);
                this.f2441a.add(k);
            } else {
                v = null;
            }
            return v;
        } finally {
            this.f2444d.unlock();
        }
    }

    public V a(K k, V v) {
        this.f2445e.lock();
        try {
            if (this.f2442b.containsKey(k)) {
                this.f2441a.remove(k);
            }
            while (this.f2441a.size() >= this.f2446f) {
                this.f2442b.remove((String) this.f2441a.poll());
            }
            this.f2441a.add(k);
            this.f2442b.put(k, v);
            return v;
        } finally {
            this.f2445e.unlock();
        }
    }
}
