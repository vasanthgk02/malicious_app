package co.hyperverge.hypersnapsdk.f;

import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: NonBlockingFixedSizeQueue */
public class d<E> extends ArrayBlockingQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    public int f3179a;

    public d(int i) {
        super(i);
        this.f3179a = i;
    }

    public synchronized boolean add(E e2) {
        if (super.size() == this.f3179a) {
            remove();
        }
        return super.add(e2);
    }
}
