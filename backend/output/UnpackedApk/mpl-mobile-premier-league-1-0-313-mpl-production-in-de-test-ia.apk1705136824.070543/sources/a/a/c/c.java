package a.a.c;

import com.badlogic.gdx.audio.Sound;
import java.lang.String;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class c<K extends String, V extends Sound> {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue<K> f2447a = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<K, V> f2448b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public ReadWriteLock f2449c;

    /* renamed from: d  reason: collision with root package name */
    public Lock f2450d;

    /* renamed from: e  reason: collision with root package name */
    public Lock f2451e;

    /* renamed from: f  reason: collision with root package name */
    public int f2452f;

    public c(int i) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f2449c = reentrantReadWriteLock;
        this.f2450d = reentrantReadWriteLock.readLock();
        this.f2451e = this.f2449c.writeLock();
        this.f2452f = 0;
        this.f2452f = i;
    }

    public V a(K k) {
        V v;
        this.f2450d.lock();
        try {
            if (this.f2448b.containsKey(k)) {
                this.f2447a.remove(k);
                v = (Sound) this.f2448b.get(k);
                this.f2447a.add(k);
            } else {
                v = null;
            }
            return v;
        } finally {
            this.f2450d.unlock();
        }
    }

    public V a(K k, V v) {
        this.f2451e.lock();
        try {
            if (this.f2448b.containsKey(k)) {
                this.f2447a.remove(k);
            }
            while (this.f2447a.size() >= this.f2452f) {
                this.f2448b.remove((String) this.f2447a.poll());
            }
            this.f2447a.add(k);
            this.f2448b.put(k, v);
            return v;
        } finally {
            this.f2451e.unlock();
        }
    }
}
