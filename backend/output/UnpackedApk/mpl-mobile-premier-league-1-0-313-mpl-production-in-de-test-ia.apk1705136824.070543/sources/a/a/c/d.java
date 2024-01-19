package a.a.c;

import com.badlogic.gdx.graphics.Texture;
import java.lang.String;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class d<K extends String, V extends Texture> {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue<K> f2453a = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<K, V> f2454b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public ReadWriteLock f2455c;

    /* renamed from: d  reason: collision with root package name */
    public Lock f2456d;

    /* renamed from: e  reason: collision with root package name */
    public Lock f2457e;

    /* renamed from: f  reason: collision with root package name */
    public int f2458f;

    public d(int i) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f2455c = reentrantReadWriteLock;
        this.f2456d = reentrantReadWriteLock.readLock();
        this.f2457e = this.f2455c.writeLock();
        this.f2458f = 0;
        this.f2458f = i;
    }

    public V a(K k) {
        V v;
        this.f2456d.lock();
        try {
            if (this.f2454b.containsKey(k)) {
                this.f2453a.remove(k);
                v = (Texture) this.f2454b.get(k);
                this.f2453a.add(k);
            } else {
                v = null;
            }
            return v;
        } finally {
            this.f2456d.unlock();
        }
    }

    public V a(K k, V v) {
        this.f2457e.lock();
        try {
            if (this.f2454b.containsKey(k)) {
                this.f2453a.remove(k);
            }
            while (this.f2453a.size() >= this.f2458f) {
                this.f2454b.remove((String) this.f2453a.poll());
            }
            this.f2453a.add(k);
            this.f2454b.put(k, v);
            return v;
        } finally {
            this.f2457e.unlock();
        }
    }
}
