package androidx.recyclerview.widget;

import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView.AnonymousClass6;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;
import sfs2x.client.requests.GenericMessageRequest;

public final class AdapterHelper implements androidx.recyclerview.widget.OpReorderer.Callback {
    public final Callback mCallback;
    public final boolean mDisableRecycler;
    public int mExistingUpdateTypes = 0;
    public final OpReorderer mOpReorderer;
    public final ArrayList<UpdateOp> mPendingUpdates = new ArrayList<>();
    public final ArrayList<UpdateOp> mPostponedList = new ArrayList<>();
    public Pools$Pool<UpdateOp> mUpdateOpPool = new Pools$SimplePool(30);

    public interface Callback {
    }

    public static final class UpdateOp {
        public int cmd;
        public int itemCount;
        public Object payload;
        public int positionStart;

        public UpdateOp(int i, int i2, int i3, Object obj) {
            this.cmd = i;
            this.positionStart = i2;
            this.itemCount = i3;
            this.payload = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateOp)) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i = this.cmd;
            if (i != updateOp.cmd) {
                return false;
            }
            if (i == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                return false;
            }
            Object obj2 = this.payload;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.payload)) {
                    return false;
                }
            } else if (updateOp.payload != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.cmd;
            sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : GenericMessageRequest.KEY_RECIPIENT_MODE : "add");
            sb.append(",s:");
            sb.append(this.positionStart);
            sb.append("c:");
            sb.append(this.itemCount);
            sb.append(",p:");
            sb.append(this.payload);
            sb.append(CMapParser.MARK_END_OF_ARRAY);
            return sb.toString();
        }
    }

    public AdapterHelper(Callback callback) {
        this.mCallback = callback;
        this.mDisableRecycler = false;
        this.mOpReorderer = new OpReorderer(this);
    }

    public final boolean canFindInPreLayout(int i) {
        int size = this.mPostponedList.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.mPostponedList.get(i2);
            int i3 = updateOp.cmd;
            if (i3 == 8) {
                if (findPositionOffset(updateOp.itemCount, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = updateOp.positionStart;
                int i5 = updateOp.itemCount + i4;
                while (i4 < i5) {
                    if (findPositionOffset(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i = 0; i < size; i++) {
            ((AnonymousClass6) this.mCallback).dispatchUpdate(this.mPostponedList.get(i));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i);
            int i2 = updateOp.cmd;
            if (i2 == 1) {
                ((AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
                ((AnonymousClass6) this.mCallback).offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            } else if (i2 == 2) {
                ((AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
                Callback callback = this.mCallback;
                int i3 = updateOp.positionStart;
                int i4 = updateOp.itemCount;
                AnonymousClass6 r4 = (AnonymousClass6) callback;
                RecyclerView.this.offsetPositionRecordsForRemove(i3, i4, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i4;
            } else if (i2 == 4) {
                ((AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
                ((AnonymousClass6) this.mCallback).markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
            } else if (i2 == 8) {
                ((AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
                ((AnonymousClass6) this.mCallback).offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
            }
        }
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    public final void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i;
        int i2 = updateOp.cmd;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i2);
        int i3 = updateOp.positionStart;
        int i4 = updateOp.cmd;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + updateOp);
        }
        int i5 = 1;
        for (int i6 = 1; i6 < updateOp.itemCount; i6++) {
            int updatePositionWithPostponed2 = updatePositionWithPostponed((i * i6) + updateOp.positionStart, updateOp.cmd);
            int i7 = updateOp.cmd;
            if (i7 == 2 ? updatePositionWithPostponed2 == updatePositionWithPostponed : i7 == 4 && updatePositionWithPostponed2 == updatePositionWithPostponed + 1) {
                i5++;
            } else {
                UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i5, updateOp.payload);
                dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, i3);
                if (!this.mDisableRecycler) {
                    obtainUpdateOp.payload = null;
                    this.mUpdateOpPool.release(obtainUpdateOp);
                }
                if (updateOp.cmd == 4) {
                    i3 += i5;
                }
                updatePositionWithPostponed = updatePositionWithPostponed2;
                i5 = 1;
            }
        }
        Object obj = updateOp.payload;
        if (!this.mDisableRecycler) {
            updateOp.payload = null;
            this.mUpdateOpPool.release(updateOp);
        }
        if (i5 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i5, obj);
            dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, i3);
            if (!this.mDisableRecycler) {
                obtainUpdateOp2.payload = null;
                this.mUpdateOpPool.release(obtainUpdateOp2);
            }
        }
    }

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i) {
        ((AnonymousClass6) this.mCallback).dispatchUpdate(updateOp);
        int i2 = updateOp.cmd;
        if (i2 == 2) {
            Callback callback = this.mCallback;
            int i3 = updateOp.itemCount;
            AnonymousClass6 r0 = (AnonymousClass6) callback;
            RecyclerView.this.offsetPositionRecordsForRemove(i, i3, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i3;
        } else if (i2 == 4) {
            ((AnonymousClass6) this.mCallback).markViewHoldersUpdated(i, updateOp.itemCount, updateOp.payload);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public int findPositionOffset(int i, int i2) {
        int size = this.mPostponedList.size();
        while (i2 < size) {
            UpdateOp updateOp = this.mPostponedList.get(i2);
            int i3 = updateOp.cmd;
            if (i3 == 8) {
                int i4 = updateOp.positionStart;
                if (i4 == i) {
                    i = updateOp.itemCount;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (updateOp.itemCount <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = updateOp.positionStart;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = updateOp.itemCount;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += updateOp.itemCount;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean hasPendingUpdates() {
        return this.mPendingUpdates.size() > 0;
    }

    public UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj) {
        UpdateOp updateOp = (UpdateOp) this.mUpdateOpPool.acquire();
        if (updateOp == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        updateOp.cmd = i;
        updateOp.positionStart = i2;
        updateOp.itemCount = i3;
        updateOp.payload = obj;
        return updateOp;
    }

    public final void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        int i = updateOp.cmd;
        if (i == 1) {
            ((AnonymousClass6) this.mCallback).offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
        } else if (i == 2) {
            Callback callback = this.mCallback;
            AnonymousClass6 r0 = (AnonymousClass6) callback;
            RecyclerView.this.offsetPositionRecordsForRemove(updateOp.positionStart, updateOp.itemCount, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else if (i == 4) {
            ((AnonymousClass6) this.mCallback).markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
        } else if (i == 8) {
            ((AnonymousClass6) this.mCallback).offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x0009 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preProcess() {
        /*
            r16 = this;
            r0 = r16
            androidx.recyclerview.widget.OpReorderer r1 = r0.mOpReorderer
            java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r2 = r0.mPendingUpdates
            r3 = 0
            if (r1 == 0) goto L_0x02d7
        L_0x0009:
            int r4 = r2.size()
            r5 = 1
            int r4 = r4 - r5
            r7 = 0
        L_0x0010:
            r8 = 8
            r9 = -1
            if (r4 < 0) goto L_0x0026
            java.lang.Object r10 = r2.get(r4)
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r10 = (androidx.recyclerview.widget.AdapterHelper.UpdateOp) r10
            int r10 = r10.cmd
            if (r10 != r8) goto L_0x0022
            if (r7 == 0) goto L_0x0023
            goto L_0x0027
        L_0x0022:
            r7 = 1
        L_0x0023:
            int r4 = r4 + -1
            goto L_0x0010
        L_0x0026:
            r4 = -1
        L_0x0027:
            r7 = 4
            r10 = 2
            if (r4 == r9) goto L_0x01ed
            int r8 = r4 + 1
            java.lang.Object r11 = r2.get(r4)
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r11 = (androidx.recyclerview.widget.AdapterHelper.UpdateOp) r11
            java.lang.Object r12 = r2.get(r8)
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r12 = (androidx.recyclerview.widget.AdapterHelper.UpdateOp) r12
            int r13 = r12.cmd
            if (r13 == r5) goto L_0x01b9
            if (r13 == r10) goto L_0x00b1
            if (r13 == r7) goto L_0x0042
            goto L_0x0009
        L_0x0042:
            int r6 = r11.itemCount
            int r9 = r12.positionStart
            if (r6 >= r9) goto L_0x004d
            int r9 = r9 + -1
            r12.positionStart = r9
            goto L_0x0063
        L_0x004d:
            int r10 = r12.itemCount
            int r9 = r9 + r10
            if (r6 >= r9) goto L_0x0063
            int r10 = r10 + -1
            r12.itemCount = r10
            androidx.recyclerview.widget.OpReorderer$Callback r6 = r1.mCallback
            int r9 = r11.positionStart
            java.lang.Object r10 = r12.payload
            androidx.recyclerview.widget.AdapterHelper r6 = (androidx.recyclerview.widget.AdapterHelper) r6
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r5 = r6.obtainUpdateOp(r7, r9, r5, r10)
            goto L_0x0064
        L_0x0063:
            r5 = r3
        L_0x0064:
            int r6 = r11.positionStart
            int r9 = r12.positionStart
            if (r6 > r9) goto L_0x006f
            int r9 = r9 + 1
            r12.positionStart = r9
            goto L_0x0087
        L_0x006f:
            int r10 = r12.itemCount
            int r9 = r9 + r10
            if (r6 >= r9) goto L_0x0087
            int r9 = r9 - r6
            androidx.recyclerview.widget.OpReorderer$Callback r10 = r1.mCallback
            int r6 = r6 + 1
            java.lang.Object r13 = r12.payload
            androidx.recyclerview.widget.AdapterHelper r10 = (androidx.recyclerview.widget.AdapterHelper) r10
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r6 = r10.obtainUpdateOp(r7, r6, r9, r13)
            int r7 = r12.itemCount
            int r7 = r7 - r9
            r12.itemCount = r7
            goto L_0x0088
        L_0x0087:
            r6 = r3
        L_0x0088:
            r2.set(r8, r11)
            int r7 = r12.itemCount
            if (r7 <= 0) goto L_0x0093
            r2.set(r4, r12)
            goto L_0x00a5
        L_0x0093:
            r2.remove(r4)
            androidx.recyclerview.widget.OpReorderer$Callback r7 = r1.mCallback
            androidx.recyclerview.widget.AdapterHelper r7 = (androidx.recyclerview.widget.AdapterHelper) r7
            boolean r8 = r7.mDisableRecycler
            if (r8 != 0) goto L_0x00a5
            r12.payload = r3
            androidx.core.util.Pools$Pool<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r7 = r7.mUpdateOpPool
            r7.release(r12)
        L_0x00a5:
            if (r5 == 0) goto L_0x00aa
            r2.add(r4, r5)
        L_0x00aa:
            if (r6 == 0) goto L_0x0009
            r2.add(r4, r6)
            goto L_0x0009
        L_0x00b1:
            int r7 = r11.positionStart
            int r9 = r11.itemCount
            if (r7 >= r9) goto L_0x00c5
            int r13 = r12.positionStart
            if (r13 != r7) goto L_0x00c2
            int r13 = r12.itemCount
            int r9 = r9 - r7
            if (r13 != r9) goto L_0x00c2
            r6 = 0
            goto L_0x00d1
        L_0x00c2:
            r6 = 0
            r7 = 0
            goto L_0x00d6
        L_0x00c5:
            int r13 = r12.positionStart
            int r14 = r9 + 1
            if (r13 != r14) goto L_0x00d4
            int r13 = r12.itemCount
            int r7 = r7 - r9
            if (r13 != r7) goto L_0x00d4
            r6 = 1
        L_0x00d1:
            r7 = r6
            r6 = 1
            goto L_0x00d6
        L_0x00d4:
            r6 = 0
            r7 = 1
        L_0x00d6:
            int r9 = r11.itemCount
            int r13 = r12.positionStart
            if (r9 >= r13) goto L_0x00e1
            int r13 = r13 + -1
            r12.positionStart = r13
            goto L_0x0106
        L_0x00e1:
            int r14 = r12.itemCount
            int r13 = r13 + r14
            if (r9 >= r13) goto L_0x0106
            int r14 = r14 + -1
            r12.itemCount = r14
            r11.cmd = r10
            r11.itemCount = r5
            int r4 = r12.itemCount
            if (r4 != 0) goto L_0x0009
            r2.remove(r8)
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r1.mCallback
            androidx.recyclerview.widget.AdapterHelper r4 = (androidx.recyclerview.widget.AdapterHelper) r4
            boolean r5 = r4.mDisableRecycler
            if (r5 != 0) goto L_0x0009
            r12.payload = r3
            androidx.core.util.Pools$Pool<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r4 = r4.mUpdateOpPool
            r4.release(r12)
            goto L_0x0009
        L_0x0106:
            int r5 = r11.positionStart
            int r9 = r12.positionStart
            if (r5 > r9) goto L_0x0111
            int r9 = r9 + 1
            r12.positionStart = r9
            goto L_0x0129
        L_0x0111:
            int r13 = r12.itemCount
            int r9 = r9 + r13
            if (r5 >= r9) goto L_0x0129
            int r9 = r9 - r5
            androidx.recyclerview.widget.OpReorderer$Callback r13 = r1.mCallback
            int r5 = r5 + 1
            androidx.recyclerview.widget.AdapterHelper r13 = (androidx.recyclerview.widget.AdapterHelper) r13
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r5 = r13.obtainUpdateOp(r10, r5, r9, r3)
            int r9 = r11.positionStart
            int r10 = r12.positionStart
            int r9 = r9 - r10
            r12.itemCount = r9
            goto L_0x012a
        L_0x0129:
            r5 = r3
        L_0x012a:
            if (r6 == 0) goto L_0x0143
            r2.set(r4, r12)
            r2.remove(r8)
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r1.mCallback
            androidx.recyclerview.widget.AdapterHelper r4 = (androidx.recyclerview.widget.AdapterHelper) r4
            boolean r5 = r4.mDisableRecycler
            if (r5 != 0) goto L_0x0009
            r11.payload = r3
            androidx.core.util.Pools$Pool<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r4 = r4.mUpdateOpPool
            r4.release(r11)
            goto L_0x0009
        L_0x0143:
            if (r7 == 0) goto L_0x0174
            if (r5 == 0) goto L_0x015d
            int r6 = r11.positionStart
            int r7 = r5.positionStart
            if (r6 <= r7) goto L_0x0152
            int r7 = r5.itemCount
            int r6 = r6 - r7
            r11.positionStart = r6
        L_0x0152:
            int r6 = r11.itemCount
            int r7 = r5.positionStart
            if (r6 <= r7) goto L_0x015d
            int r7 = r5.itemCount
            int r6 = r6 - r7
            r11.itemCount = r6
        L_0x015d:
            int r6 = r11.positionStart
            int r7 = r12.positionStart
            if (r6 <= r7) goto L_0x0168
            int r7 = r12.itemCount
            int r6 = r6 - r7
            r11.positionStart = r6
        L_0x0168:
            int r6 = r11.itemCount
            int r7 = r12.positionStart
            if (r6 <= r7) goto L_0x01a2
            int r7 = r12.itemCount
            int r6 = r6 - r7
            r11.itemCount = r6
            goto L_0x01a2
        L_0x0174:
            if (r5 == 0) goto L_0x018c
            int r6 = r11.positionStart
            int r7 = r5.positionStart
            if (r6 < r7) goto L_0x0181
            int r7 = r5.itemCount
            int r6 = r6 - r7
            r11.positionStart = r6
        L_0x0181:
            int r6 = r11.itemCount
            int r7 = r5.positionStart
            if (r6 < r7) goto L_0x018c
            int r7 = r5.itemCount
            int r6 = r6 - r7
            r11.itemCount = r6
        L_0x018c:
            int r6 = r11.positionStart
            int r7 = r12.positionStart
            if (r6 < r7) goto L_0x0197
            int r7 = r12.itemCount
            int r6 = r6 - r7
            r11.positionStart = r6
        L_0x0197:
            int r6 = r11.itemCount
            int r7 = r12.positionStart
            if (r6 < r7) goto L_0x01a2
            int r7 = r12.itemCount
            int r6 = r6 - r7
            r11.itemCount = r6
        L_0x01a2:
            r2.set(r4, r12)
            int r6 = r11.positionStart
            int r7 = r11.itemCount
            if (r6 == r7) goto L_0x01af
            r2.set(r8, r11)
            goto L_0x01b2
        L_0x01af:
            r2.remove(r8)
        L_0x01b2:
            if (r5 == 0) goto L_0x0009
            r2.add(r4, r5)
            goto L_0x0009
        L_0x01b9:
            int r5 = r11.itemCount
            int r7 = r12.positionStart
            if (r5 >= r7) goto L_0x01c1
            r6 = -1
            goto L_0x01c2
        L_0x01c1:
            r6 = 0
        L_0x01c2:
            int r5 = r11.positionStart
            int r7 = r12.positionStart
            if (r5 >= r7) goto L_0x01ca
            int r6 = r6 + 1
        L_0x01ca:
            int r5 = r12.positionStart
            int r7 = r11.positionStart
            if (r5 > r7) goto L_0x01d5
            int r5 = r12.itemCount
            int r7 = r7 + r5
            r11.positionStart = r7
        L_0x01d5:
            int r5 = r12.positionStart
            int r7 = r11.itemCount
            if (r5 > r7) goto L_0x01e0
            int r5 = r12.itemCount
            int r7 = r7 + r5
            r11.itemCount = r7
        L_0x01e0:
            int r5 = r12.positionStart
            int r5 = r5 + r6
            r12.positionStart = r5
            r2.set(r4, r12)
            r2.set(r8, r11)
            goto L_0x0009
        L_0x01ed:
            java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r1 = r0.mPendingUpdates
            int r1 = r1.size()
            r2 = 0
        L_0x01f4:
            if (r2 >= r1) goto L_0x02d1
            java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r4 = r0.mPendingUpdates
            java.lang.Object r4 = r4.get(r2)
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = (androidx.recyclerview.widget.AdapterHelper.UpdateOp) r4
            int r11 = r4.cmd
            if (r11 == r5) goto L_0x02ca
            if (r11 == r10) goto L_0x026c
            if (r11 == r7) goto L_0x020f
            if (r11 == r8) goto L_0x020a
            goto L_0x02cd
        L_0x020a:
            r0.postponeAndUpdateViewHolders(r4)
            goto L_0x02cd
        L_0x020f:
            int r11 = r4.positionStart
            int r12 = r4.itemCount
            int r12 = r12 + r11
            r13 = r11
            r14 = 0
            r15 = -1
        L_0x0217:
            if (r11 >= r12) goto L_0x024b
            androidx.recyclerview.widget.AdapterHelper$Callback r6 = r0.mCallback
            androidx.recyclerview.widget.RecyclerView$6 r6 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass6) r6
            androidx.recyclerview.widget.RecyclerView$ViewHolder r6 = r6.findViewHolder(r11)
            if (r6 != 0) goto L_0x0239
            boolean r6 = r0.canFindInPreLayout(r11)
            if (r6 == 0) goto L_0x022a
            goto L_0x0239
        L_0x022a:
            if (r15 != r5) goto L_0x0237
            java.lang.Object r6 = r4.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r6 = r0.obtainUpdateOp(r7, r13, r14, r6)
            r0.postponeAndUpdateViewHolders(r6)
            r13 = r11
            r14 = 0
        L_0x0237:
            r15 = 0
            goto L_0x0247
        L_0x0239:
            if (r15 != 0) goto L_0x0246
            java.lang.Object r6 = r4.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r6 = r0.obtainUpdateOp(r7, r13, r14, r6)
            r0.dispatchAndUpdateViewHolders(r6)
            r13 = r11
            r14 = 0
        L_0x0246:
            r15 = 1
        L_0x0247:
            int r14 = r14 + r5
            int r11 = r11 + 1
            goto L_0x0217
        L_0x024b:
            int r6 = r4.itemCount
            if (r14 == r6) goto L_0x0260
            java.lang.Object r6 = r4.payload
            boolean r11 = r0.mDisableRecycler
            if (r11 != 0) goto L_0x025c
            r4.payload = r3
            androidx.core.util.Pools$Pool<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r11 = r0.mUpdateOpPool
            r11.release(r4)
        L_0x025c:
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = r0.obtainUpdateOp(r7, r13, r14, r6)
        L_0x0260:
            if (r15 != 0) goto L_0x0267
            r0.dispatchAndUpdateViewHolders(r4)
            goto L_0x02cd
        L_0x0267:
            r0.postponeAndUpdateViewHolders(r4)
            goto L_0x02cd
        L_0x026c:
            int r6 = r4.positionStart
            int r11 = r4.itemCount
            int r11 = r11 + r6
            r12 = r6
            r13 = 0
            r14 = -1
        L_0x0274:
            if (r12 >= r11) goto L_0x02ad
            androidx.recyclerview.widget.AdapterHelper$Callback r15 = r0.mCallback
            androidx.recyclerview.widget.RecyclerView$6 r15 = (androidx.recyclerview.widget.RecyclerView.AnonymousClass6) r15
            androidx.recyclerview.widget.RecyclerView$ViewHolder r15 = r15.findViewHolder(r12)
            if (r15 != 0) goto L_0x0295
            boolean r15 = r0.canFindInPreLayout(r12)
            if (r15 == 0) goto L_0x0287
            goto L_0x0295
        L_0x0287:
            if (r14 != r5) goto L_0x0292
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r14 = r0.obtainUpdateOp(r10, r6, r13, r3)
            r0.postponeAndUpdateViewHolders(r14)
            r14 = 1
            goto L_0x0293
        L_0x0292:
            r14 = 0
        L_0x0293:
            r15 = 0
            goto L_0x02a2
        L_0x0295:
            if (r14 != 0) goto L_0x02a0
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r14 = r0.obtainUpdateOp(r10, r6, r13, r3)
            r0.dispatchAndUpdateViewHolders(r14)
            r14 = 1
            goto L_0x02a1
        L_0x02a0:
            r14 = 0
        L_0x02a1:
            r15 = 1
        L_0x02a2:
            if (r14 == 0) goto L_0x02a8
            int r12 = r12 - r13
            int r11 = r11 - r13
            r13 = 1
            goto L_0x02aa
        L_0x02a8:
            int r13 = r13 + 1
        L_0x02aa:
            int r12 = r12 + r5
            r14 = r15
            goto L_0x0274
        L_0x02ad:
            int r11 = r4.itemCount
            if (r13 == r11) goto L_0x02c0
            boolean r11 = r0.mDisableRecycler
            if (r11 != 0) goto L_0x02bc
            r4.payload = r3
            androidx.core.util.Pools$Pool<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r11 = r0.mUpdateOpPool
            r11.release(r4)
        L_0x02bc:
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = r0.obtainUpdateOp(r10, r6, r13, r3)
        L_0x02c0:
            if (r14 != 0) goto L_0x02c6
            r0.dispatchAndUpdateViewHolders(r4)
            goto L_0x02cd
        L_0x02c6:
            r0.postponeAndUpdateViewHolders(r4)
            goto L_0x02cd
        L_0x02ca:
            r0.postponeAndUpdateViewHolders(r4)
        L_0x02cd:
            int r2 = r2 + 1
            goto L_0x01f4
        L_0x02d1:
            java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r1 = r0.mPendingUpdates
            r1.clear()
            return
        L_0x02d7:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AdapterHelper.preProcess():void");
    }

    public void recycleUpdateOp(UpdateOp updateOp) {
        if (!this.mDisableRecycler) {
            updateOp.payload = null;
            this.mUpdateOpPool.release(updateOp);
        }
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            recycleUpdateOp(list.get(i));
        }
        list.clear();
    }

    public final int updatePositionWithPostponed(int i, int i2) {
        for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.mPostponedList.get(size);
            int i3 = updateOp.cmd;
            if (i3 == 8) {
                int i4 = updateOp.positionStart;
                int i5 = updateOp.itemCount;
                if (i4 >= i5) {
                    int i6 = i5;
                    i5 = i4;
                    i4 = i6;
                }
                if (i < i4 || i > i5) {
                    int i7 = updateOp.positionStart;
                    if (i < i7) {
                        if (i2 == 1) {
                            updateOp.positionStart = i7 + 1;
                            updateOp.itemCount++;
                        } else if (i2 == 2) {
                            updateOp.positionStart = i7 - 1;
                            updateOp.itemCount--;
                        }
                    }
                } else {
                    int i8 = updateOp.positionStart;
                    if (i4 == i8) {
                        if (i2 == 1) {
                            updateOp.itemCount++;
                        } else if (i2 == 2) {
                            updateOp.itemCount--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            updateOp.positionStart = i8 + 1;
                        } else if (i2 == 2) {
                            updateOp.positionStart = i8 - 1;
                        }
                        i--;
                    }
                }
            } else {
                int i9 = updateOp.positionStart;
                if (i9 <= i) {
                    if (i3 == 1) {
                        i -= updateOp.itemCount;
                    } else if (i3 == 2) {
                        i += updateOp.itemCount;
                    }
                } else if (i2 == 1) {
                    updateOp.positionStart = i9 + 1;
                } else if (i2 == 2) {
                    updateOp.positionStart = i9 - 1;
                }
            }
        }
        for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.mPostponedList.get(size2);
            if (updateOp2.cmd == 8) {
                int i10 = updateOp2.itemCount;
                if (i10 == updateOp2.positionStart || i10 < 0) {
                    this.mPostponedList.remove(size2);
                    if (!this.mDisableRecycler) {
                        updateOp2.payload = null;
                        this.mUpdateOpPool.release(updateOp2);
                    }
                }
            } else if (updateOp2.itemCount <= 0) {
                this.mPostponedList.remove(size2);
                if (!this.mDisableRecycler) {
                    updateOp2.payload = null;
                    this.mUpdateOpPool.release(updateOp2);
                }
            }
        }
        return i;
    }
}
