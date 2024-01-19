package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal.ProtobufList;
import java.util.Collections;
import java.util.List;

public abstract class ListFieldSchema {
    public static final ListFieldSchema FULL_INSTANCE = new ListFieldSchemaFull(null);
    public static final ListFieldSchema LITE_INSTANCE = new ListFieldSchemaLite(null);

    public static final class ListFieldSchemaFull extends ListFieldSchema {
        public static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public ListFieldSchemaFull(AnonymousClass1 r1) {
            super(null);
        }

        public void makeImmutableListAt(Object obj, long j) {
            Object obj2;
            List list = (List) UnsafeUtil.getObject(obj, j);
            if (list instanceof LazyStringList) {
                obj2 = ((LazyStringList) list).getUnmodifiableView();
            } else if (!UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof ProtobufList)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    ProtobufList protobufList = (ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                    }
                    return;
                }
            } else {
                return;
            }
            UnsafeUtil.MEMORY_ACCESSOR.putObject(obj, j, obj2);
        }

        public <E> void mergeListsAt(Object obj, Object obj2, long j) {
            List list = (List) UnsafeUtil.getObject(obj2, j);
            List mutableListAt = mutableListAt(obj, j, list.size());
            int size = mutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(list);
            }
            if (size > 0) {
                list = mutableListAt;
            }
            UnsafeUtil.MEMORY_ACCESSOR.putObject(obj, j, list);
        }

        public <L> List<L> mutableListAt(Object obj, long j) {
            return mutableListAt(obj, j, 10);
        }

        /* JADX WARNING: type inference failed for: r1v9 */
        /* JADX WARNING: type inference failed for: r0v6, types: [java.util.List<L>] */
        /* JADX WARNING: type inference failed for: r1v14 */
        /* JADX WARNING: type inference failed for: r1v15 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <L> java.util.List<L> mutableListAt(java.lang.Object r3, long r4, int r6) {
            /*
                java.lang.Object r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject(r3, r4)
                java.util.List r0 = (java.util.List) r0
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x0031
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.LazyStringList
                if (r1 == 0) goto L_0x0016
                androidx.datastore.preferences.protobuf.LazyStringArrayList r0 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                r0.<init>(r6)
                goto L_0x002b
            L_0x0016:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x0026
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x0026
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r6 = r0.mutableCopyWithCapacity(r6)
                r0 = r6
                goto L_0x002b
            L_0x0026:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x002b:
                androidx.datastore.preferences.protobuf.UnsafeUtil$MemoryAccessor r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.MEMORY_ACCESSOR
                r6.putObject(r3, r4, r0)
                goto L_0x008d
            L_0x0031:
                java.lang.Class<?> r1 = UNMODIFIABLE_LIST_CLASS
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x0051
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
                androidx.datastore.preferences.protobuf.UnsafeUtil$MemoryAccessor r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.MEMORY_ACCESSOR
                r6.putObject(r3, r4, r1)
            L_0x004f:
                r0 = r1
                goto L_0x008d
            L_0x0051:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList
                if (r1 == 0) goto L_0x006e
                androidx.datastore.preferences.protobuf.LazyStringArrayList r1 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList r0 = (androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList) r0
                int r6 = r1.size()
                r1.addAll(r6, r0)
                androidx.datastore.preferences.protobuf.UnsafeUtil$MemoryAccessor r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.MEMORY_ACCESSOR
                r6.putObject(r3, r4, r1)
                goto L_0x004f
            L_0x006e:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x008d
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x008d
                r1 = r0
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r1 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r1
                boolean r2 = r1.isModifiable()
                if (r2 != 0) goto L_0x008d
                int r0 = r0.size()
                int r0 = r0 + r6
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r1.mutableCopyWithCapacity(r0)
                androidx.datastore.preferences.protobuf.UnsafeUtil$MemoryAccessor r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.MEMORY_ACCESSOR
                r6.putObject(r3, r4, r0)
            L_0x008d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ListFieldSchema.ListFieldSchemaFull.mutableListAt(java.lang.Object, long, int):java.util.List");
        }
    }

    public static final class ListFieldSchemaLite extends ListFieldSchema {
        public ListFieldSchemaLite(AnonymousClass1 r1) {
            super(null);
        }

        public static <E> ProtobufList<E> getProtobufList(Object obj, long j) {
            return (ProtobufList) UnsafeUtil.getObject(obj, j);
        }

        public void makeImmutableListAt(Object obj, long j) {
            getProtobufList(obj, j).makeImmutable();
        }

        public <E> void mergeListsAt(Object obj, Object obj2, long j) {
            ProtobufList protobufList = getProtobufList(obj, j);
            ProtobufList protobufList2 = getProtobufList(obj2, j);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size > 0) {
                protobufList2 = protobufList;
            }
            UnsafeUtil.MEMORY_ACCESSOR.putObject(obj, j, protobufList2);
        }

        public <L> List<L> mutableListAt(Object obj, long j) {
            ProtobufList protobufList = getProtobufList(obj, j);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            UnsafeUtil.MEMORY_ACCESSOR.putObject(obj, j, mutableCopyWithCapacity);
            return mutableCopyWithCapacity;
        }
    }

    public ListFieldSchema(AnonymousClass1 r1) {
    }

    public abstract void makeImmutableListAt(Object obj, long j);

    public abstract <L> void mergeListsAt(Object obj, Object obj2, long j);

    public abstract <L> List<L> mutableListAt(Object obj, long j);
}
