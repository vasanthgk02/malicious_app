package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.io.FileTreeWalk;
import kotlin.io.FileTreeWalk.FileTreeWalkIterator;
import kotlin.io.FileTreeWalk.WalkState;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH$J\b\u0010\n\u001a\u00020\tH\u0004J\t\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/collections/AbstractIterator;", "T", "", "()V", "nextValue", "Ljava/lang/Object;", "state", "Lkotlin/collections/State;", "computeNext", "", "done", "hasNext", "", "next", "()Ljava/lang/Object;", "setNext", "value", "(Ljava/lang/Object;)V", "tryToComputeNext", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AbstractIterator.kt */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    public T nextValue;
    public State state = State.NotReady;

    public boolean hasNext() {
        T t;
        T step;
        if (this.state != State.Failed) {
            int ordinal = this.state.ordinal();
            if (ordinal == 0) {
                return true;
            }
            if (ordinal != 2) {
                this.state = State.Failed;
                FileTreeWalkIterator fileTreeWalkIterator = (FileTreeWalkIterator) this;
                while (true) {
                    WalkState peek = fileTreeWalkIterator.state.peek();
                    if (peek == null) {
                        t = null;
                        break;
                    }
                    step = peek.step();
                    if (step == null) {
                        fileTreeWalkIterator.state.pop();
                    } else if (Intrinsics.areEqual(step, peek.root) || !step.isDirectory() || fileTreeWalkIterator.state.size() >= FileTreeWalk.this.maxDepth) {
                        t = step;
                    } else {
                        fileTreeWalkIterator.state.push(fileTreeWalkIterator.directoryState(step));
                    }
                }
                t = step;
                if (t != null) {
                    fileTreeWalkIterator.nextValue = t;
                    fileTreeWalkIterator.state = State.Ready;
                } else {
                    fileTreeWalkIterator.state = State.Done;
                }
                if (this.state == State.Ready) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public T next() {
        if (hasNext()) {
            this.state = State.NotReady;
            return this.nextValue;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
