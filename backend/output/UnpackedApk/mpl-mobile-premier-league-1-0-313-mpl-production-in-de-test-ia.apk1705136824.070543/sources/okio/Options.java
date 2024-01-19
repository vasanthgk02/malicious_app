package okio;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: Options.kt */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    public final ByteString[] byteStrings;
    public final int[] trie;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, k = 1, mv = {1, 4, 1})
    /* compiled from: Options.kt */
    public static final class Companion {
        public Companion() {
        }

        private final void buildTrieRecursive(long j, Buffer buffer, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            int i7;
            Buffer buffer2;
            Buffer buffer3 = buffer;
            int i8 = i;
            List<? extends ByteString> list3 = list;
            int i9 = i2;
            int i10 = i3;
            List<Integer> list4 = list2;
            if (i9 < i10) {
                int i11 = i9;
                while (i11 < i10) {
                    if (((ByteString) list3.get(i11)).size() >= i8) {
                        i11++;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = (ByteString) list.get(i2);
                ByteString byteString2 = (ByteString) list3.get(i10 - 1);
                if (i8 == byteString.size()) {
                    int intValue = list4.get(i9).intValue();
                    int i12 = i9 + 1;
                    i4 = i12;
                    i5 = intValue;
                    byteString = (ByteString) list3.get(i12);
                } else {
                    i4 = i9;
                    i5 = -1;
                }
                if (byteString.getByte(i8) != byteString2.getByte(i8)) {
                    int i13 = 1;
                    for (int i14 = i4 + 1; i14 < i10; i14++) {
                        if (((ByteString) list3.get(i14 - 1)).getByte(i8) != ((ByteString) list3.get(i14)).getByte(i8)) {
                            i13++;
                        }
                    }
                    long intCount = j + getIntCount(buffer3) + ((long) 2) + ((long) (i13 * 2));
                    buffer3.writeInt(i13);
                    buffer3.writeInt(i5);
                    for (int i15 = i4; i15 < i10; i15++) {
                        byte b2 = ((ByteString) list3.get(i15)).getByte(i8);
                        if (i15 == i4 || b2 != ((ByteString) list3.get(i15 - 1)).getByte(i8)) {
                            buffer3.writeInt((int) b2 & 255);
                        }
                    }
                    Buffer buffer4 = new Buffer();
                    while (i4 < i10) {
                        byte b3 = ((ByteString) list3.get(i4)).getByte(i8);
                        int i16 = i4 + 1;
                        int i17 = i16;
                        while (true) {
                            if (i17 >= i10) {
                                i6 = i10;
                                break;
                            } else if (b3 != ((ByteString) list3.get(i17)).getByte(i8)) {
                                i6 = i17;
                                break;
                            } else {
                                i17++;
                            }
                        }
                        if (i16 == i6 && i8 + 1 == ((ByteString) list3.get(i4)).size()) {
                            buffer3.writeInt(list4.get(i4).intValue());
                            i7 = i6;
                            buffer2 = buffer4;
                        } else {
                            buffer3.writeInt(((int) (intCount + getIntCount(buffer4))) * -1);
                            i7 = i6;
                            buffer2 = buffer4;
                            buildTrieRecursive(intCount, buffer4, i8 + 1, list, i4, i6, list2);
                        }
                        buffer4 = buffer2;
                        i4 = i7;
                    }
                    buffer3.writeAll(buffer4);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i18 = i8;
                int i19 = 0;
                while (i18 < min && byteString.getByte(i18) == byteString2.getByte(i18)) {
                    i19++;
                    i18++;
                }
                long intCount2 = j + getIntCount(buffer3) + ((long) 2) + ((long) i19) + 1;
                buffer3.writeInt(-i19);
                buffer3.writeInt(i5);
                int i20 = i8 + i19;
                while (i8 < i20) {
                    buffer3.writeInt((int) byteString.getByte(i8) & 255);
                    i8++;
                }
                if (i4 + 1 == i10) {
                    if (i20 == ((ByteString) list3.get(i4)).size()) {
                        buffer3.writeInt(list4.get(i4).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer5 = new Buffer();
                buffer3.writeInt(((int) (getIntCount(buffer5) + intCount2)) * -1);
                buildTrieRecursive(intCount2, buffer5, i20, list, i4, i3, list2);
                buffer3.writeAll(buffer5);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            companion.buildTrieRecursive((i4 & 1) != 0 ? 0 : j, buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        public final Options of(ByteString... byteStringArr) {
            int i;
            Intrinsics.checkNotNullParameter(byteStringArr, "byteStrings");
            int i2 = 0;
            if (byteStringArr.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, null);
            }
            List mutableList = TweetUtils.toMutableList(byteStringArr);
            TweetUtils.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStringArr.length);
            for (ByteString byteString : byteStringArr) {
                arrayList.add(Integer.valueOf(-1));
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array != null) {
                Integer[] numArr = (Integer[]) array;
                List mutableListOf = TweetUtils.mutableListOf((Integer[]) Arrays.copyOf(numArr, numArr.length));
                int length = byteStringArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    ByteString byteString2 = byteStringArr[i3];
                    int i5 = i4 + 1;
                    int size = ((ArrayList) mutableList).size();
                    Intrinsics.checkNotNullParameter(mutableList, "<this>");
                    ArrayList arrayList2 = (ArrayList) mutableList;
                    int size2 = arrayList2.size();
                    if (size < 0) {
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline44("fromIndex (", 0, ") is greater than toIndex (", size, ")."));
                    } else if (size <= size2) {
                        int i6 = size - 1;
                        int i7 = 0;
                        while (true) {
                            if (i7 > i6) {
                                i = -(i7 + 1);
                                break;
                            }
                            i = (i7 + i6) >>> 1;
                            int compareValues = TweetUtils.compareValues((Comparable) arrayList2.get(i), byteString2);
                            if (compareValues >= 0) {
                                if (compareValues <= 0) {
                                    break;
                                }
                                i6 = i - 1;
                            } else {
                                i7 = i + 1;
                            }
                        }
                        mutableListOf.set(i, Integer.valueOf(i4));
                        i3++;
                        i4 = i5;
                    } else {
                        throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline44("toIndex (", size, ") is greater than size (", size2, ")."));
                    }
                }
                ArrayList arrayList3 = (ArrayList) mutableList;
                if (((ByteString) arrayList3.get(0)).size() > 0) {
                    int i8 = 0;
                    while (i8 < arrayList3.size()) {
                        ByteString byteString3 = (ByteString) arrayList3.get(i8);
                        int i9 = i8 + 1;
                        int i10 = i9;
                        while (i10 < arrayList3.size()) {
                            ByteString byteString4 = (ByteString) arrayList3.get(i10);
                            if (!byteString4.startsWith(byteString3)) {
                                continue;
                                break;
                            }
                            if (!(byteString4.size() != byteString3.size())) {
                                throw new IllegalArgumentException(("duplicate option: " + byteString4).toString());
                            } else if (((Number) mutableListOf.get(i10)).intValue() > ((Number) mutableListOf.get(i8)).intValue()) {
                                arrayList3.remove(i10);
                                mutableListOf.remove(i10);
                            } else {
                                i10++;
                            }
                        }
                        i8 = i9;
                    }
                    Buffer buffer = new Buffer();
                    buildTrieRecursive$default(this, 0, buffer, 0, mutableList, 0, 0, mutableListOf, 53, null);
                    int[] iArr = new int[((int) getIntCount(buffer))];
                    while (!buffer.exhausted()) {
                        iArr[i2] = buffer.readInt();
                        i2++;
                    }
                    Object[] copyOf = Arrays.copyOf(byteStringArr, byteStringArr.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                    return new Options((ByteString[]) copyOf, iArr, null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    public Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains(byteString);
    }

    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }
}
