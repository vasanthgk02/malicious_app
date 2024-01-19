package kotlin.collections;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0013\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReversedViews.kt */
public final class ReversedList<T> extends AbstractMutableList<T> {
    public final List<T> delegate;

    public ReversedList(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "delegate");
        this.delegate = list;
    }

    public void add(int i, T t) {
        List<T> list = this.delegate;
        if (new IntRange(0, size()).contains(i)) {
            list.add(size() - i, t);
            return;
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Position index ", i, " must be in range [");
        outline74.append(new IntRange(0, size()));
        outline74.append("].");
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public void clear() {
        this.delegate.clear();
    }

    public T get(int i) {
        return this.delegate.get(TweetUtils.access$reverseElementIndex(this, i));
    }

    public int getSize() {
        return this.delegate.size();
    }

    public T removeAt(int i) {
        return this.delegate.remove(TweetUtils.access$reverseElementIndex(this, i));
    }

    public T set(int i, T t) {
        return this.delegate.set(TweetUtils.access$reverseElementIndex(this, i), t);
    }
}
