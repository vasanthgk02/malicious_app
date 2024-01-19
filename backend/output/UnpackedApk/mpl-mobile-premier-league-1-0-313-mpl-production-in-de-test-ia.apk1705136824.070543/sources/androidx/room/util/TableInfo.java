package androidx.room.util;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.Index$Order;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.notification.SMTNotificationConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0006\u0014\u0015\u0016\u0017\u0018\u0019B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/util/TableInfo;", "", "name", "", "columns", "", "Landroidx/room/util/TableInfo$Column;", "foreignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;)V", "indices", "Landroidx/room/util/TableInfo$Index;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Column", "Companion", "CreatedFrom", "ForeignKey", "ForeignKeyWithSequence", "Index", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TableInfo.kt */
public final class TableInfo {
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0010\u0010\u000b\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/util/TableInfo$Column;", "", "name", "", "type", "notNull", "", "primaryKeyPosition", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "defaultValue", "createdFrom", "(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V", "affinity", "getAffinity$annotations", "()V", "isPrimaryKey", "()Z", "equals", "other", "findAffinity", "hashCode", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TableInfo.kt */
    public static final class Column {
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0054, code lost:
            r5 = kotlin.text.CharsKt__CharKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) "BLOB", false, 2) ? 5 : (kotlin.text.CharsKt__CharKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) "REAL", false, 2) || kotlin.text.CharsKt__CharKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) "FLOA", false, 2) || kotlin.text.CharsKt__CharKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) "DOUB", false, 2)) ? 4 : 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Column(java.lang.String r2, java.lang.String r3, boolean r4, int r5, java.lang.String r6, int r7) {
            /*
                r1 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "type"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.<init>()
                r1.name = r2
                r1.type = r3
                r1.notNull = r4
                r1.primaryKeyPosition = r5
                r1.defaultValue = r6
                r1.createdFrom = r7
                java.util.Locale r2 = java.util.Locale.US
                java.lang.String r4 = "US"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
                java.lang.String r2 = r3.toUpperCase(r2)
                java.lang.String r3 = "this as java.lang.String).toUpperCase(locale)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                r3 = 0
                java.lang.String r4 = "INT"
                r5 = 2
                boolean r4 = kotlin.text.CharsKt__CharKt.contains$default(r2, r4, r3, r5)
                if (r4 == 0) goto L_0x0035
                r5 = 3
                goto L_0x0074
            L_0x0035:
                java.lang.String r4 = "CHAR"
                boolean r4 = kotlin.text.CharsKt__CharKt.contains$default(r2, r4, r3, r5)
                if (r4 != 0) goto L_0x0074
                java.lang.String r4 = "CLOB"
                boolean r4 = kotlin.text.CharsKt__CharKt.contains$default(r2, r4, r3, r5)
                if (r4 != 0) goto L_0x0074
                java.lang.String r4 = "TEXT"
                boolean r4 = kotlin.text.CharsKt__CharKt.contains$default(r2, r4, r3, r5)
                if (r4 == 0) goto L_0x004e
                goto L_0x0074
            L_0x004e:
                java.lang.String r4 = "BLOB"
                boolean r4 = kotlin.text.CharsKt__CharKt.contains$default(r2, r4, r3, r5)
                if (r4 == 0) goto L_0x0058
                r5 = 5
                goto L_0x0074
            L_0x0058:
                java.lang.String r4 = "REAL"
                boolean r4 = kotlin.text.CharsKt__CharKt.contains$default(r2, r4, r3, r5)
                if (r4 != 0) goto L_0x0073
                java.lang.String r4 = "FLOA"
                boolean r4 = kotlin.text.CharsKt__CharKt.contains$default(r2, r4, r3, r5)
                if (r4 != 0) goto L_0x0073
                java.lang.String r4 = "DOUB"
                boolean r2 = kotlin.text.CharsKt__CharKt.contains$default(r2, r4, r3, r5)
                if (r2 == 0) goto L_0x0071
                goto L_0x0073
            L_0x0071:
                r5 = 1
                goto L_0x0074
            L_0x0073:
                r5 = 4
            L_0x0074:
                r1.affinity = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfo.Column.<init>(java.lang.String, java.lang.String, boolean, int, java.lang.String, int):void");
        }

        @SuppressLint({"SyntheticAccessor"})
        public static final boolean defaultValueEquals(String str, String str2) {
            boolean z;
            Intrinsics.checkNotNullParameter(str, "current");
            if (Intrinsics.areEqual(str, str2)) {
                return true;
            }
            if (!(str.length() == 0)) {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i < str.length()) {
                        char charAt = str.charAt(i);
                        int i4 = i3 + 1;
                        if (i3 == 0 && charAt != '(') {
                            break;
                        }
                        if (charAt == '(') {
                            i2++;
                        } else if (charAt == ')') {
                            i2--;
                            if (i2 == 0 && i3 != str.length() - 1) {
                                break;
                            }
                        } else {
                            continue;
                        }
                        i++;
                        i3 = i4;
                    } else if (i2 == 0) {
                        z = true;
                    }
                }
            }
            z = false;
            if (!z) {
                return false;
            }
            String substring = str.substring(1, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return Intrinsics.areEqual(CharsKt__CharKt.trim(substring).toString(), str2);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Column)) {
                return false;
            }
            Column column = (Column) obj;
            if (this.primaryKeyPosition != column.primaryKeyPosition || !Intrinsics.areEqual(this.name, column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.createdFrom == 1 && column.createdFrom == 2) {
                String str = this.defaultValue;
                if (str != null && !defaultValueEquals(str, column.defaultValue)) {
                    return false;
                }
            }
            if (this.createdFrom == 2 && column.createdFrom == 1) {
                String str2 = column.defaultValue;
                if (str2 != null && !defaultValueEquals(str2, this.defaultValue)) {
                    return false;
                }
            }
            int i = this.createdFrom;
            if (i != 0 && i == column.createdFrom) {
                String str3 = this.defaultValue;
                if (str3 == null ? column.defaultValue != null : !defaultValueEquals(str3, column.defaultValue)) {
                    return false;
                }
            }
            if (this.affinity != column.affinity) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Column{name='");
            outline73.append(this.name);
            outline73.append("', type='");
            outline73.append(this.type);
            outline73.append("', affinity='");
            outline73.append(this.affinity);
            outline73.append("', notNull=");
            outline73.append(this.notNull);
            outline73.append(", primaryKeyPosition=");
            outline73.append(this.primaryKeyPosition);
            outline73.append(", defaultValue='");
            String str = this.defaultValue;
            if (str == null) {
                str = "undefined";
            }
            return GeneratedOutlineSupport.outline62(outline73, str, "'}");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKey;", "", "referenceTable", "", "onDelete", "onUpdate", "columnNames", "", "referenceColumnNames", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "equals", "", "other", "hashCode", "", "toString", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TableInfo.kt */
    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List<String> list, List<String> list2) {
            Intrinsics.checkNotNullParameter(str, "referenceTable");
            Intrinsics.checkNotNullParameter(str2, "onDelete");
            Intrinsics.checkNotNullParameter(str3, "onUpdate");
            Intrinsics.checkNotNullParameter(list, "columnNames");
            Intrinsics.checkNotNullParameter(list2, "referenceColumnNames");
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = list;
            this.referenceColumnNames = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            boolean z = false;
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (!Intrinsics.areEqual(this.referenceTable, foreignKey.referenceTable) || !Intrinsics.areEqual(this.onDelete, foreignKey.onDelete) || !Intrinsics.areEqual(this.onUpdate, foreignKey.onUpdate)) {
                return false;
            }
            if (Intrinsics.areEqual(this.columnNames, foreignKey.columnNames)) {
                z = Intrinsics.areEqual(this.referenceColumnNames, foreignKey.referenceColumnNames);
            }
            return z;
        }

        public int hashCode() {
            int outline11 = GeneratedOutlineSupport.outline11(this.onUpdate, GeneratedOutlineSupport.outline11(this.onDelete, this.referenceTable.hashCode() * 31, 31), 31);
            return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + outline11) * 31);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("ForeignKey{referenceTable='");
            outline73.append(this.referenceTable);
            outline73.append("', onDelete='");
            outline73.append(this.onDelete);
            outline73.append(" +', onUpdate='");
            outline73.append(this.onUpdate);
            outline73.append("', columnNames=");
            outline73.append(this.columnNames);
            outline73.append(", referenceColumnNames=");
            outline73.append(this.referenceColumnNames);
            outline73.append('}');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "", "id", "", "sequence", "from", "", "to", "(IILjava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getId", "()I", "getSequence", "getTo", "compareTo", "other", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TableInfo.kt */
    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        public final String from;
        public final int id;
        public final int sequence;
        public final String to;

        public ForeignKeyWithSequence(int i, int i2, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "from");
            Intrinsics.checkNotNullParameter(str2, "to");
            this.id = i;
            this.sequence = i2;
            this.from = str;
            this.to = str2;
        }

        public int compareTo(Object obj) {
            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj;
            Intrinsics.checkNotNullParameter(foreignKeyWithSequence, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER);
            int i = this.id - foreignKeyWithSequence.id;
            return i == 0 ? this.sequence - foreignKeyWithSequence.sequence : i;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$Index;", "", "name", "", "unique", "", "columns", "", "(Ljava/lang/String;ZLjava/util/List;)V", "orders", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "equals", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TableInfo.kt */
    public static final class Index {
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        public Index(String str, boolean z, List<String> list, List<String> list2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(list, "columns");
            Intrinsics.checkNotNullParameter(list2, "orders");
            this.name = str;
            this.unique = z;
            this.columns = list;
            this.orders = list2;
            if (list2.isEmpty()) {
                int size = this.columns.size();
                r5 = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    r5.add(Index$Order.ASC.name());
                }
                list2 = r5;
            }
            this.orders = list2;
        }

        public boolean equals(Object obj) {
            boolean z;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Index)) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique != index.unique || !Intrinsics.areEqual(this.columns, index.columns) || !Intrinsics.areEqual(this.orders, index.orders)) {
                return false;
            }
            if (CharsKt__CharKt.startsWith$default(this.name, (String) "index_", false, 2)) {
                z = CharsKt__CharKt.startsWith$default(index.name, (String) "index_", false, 2);
            } else {
                z = Intrinsics.areEqual(this.name, index.name);
            }
            return z;
        }

        public int hashCode() {
            int i;
            if (CharsKt__CharKt.startsWith$default(this.name, (String) "index_", false, 2)) {
                i = -1184239155;
            } else {
                i = this.name.hashCode();
            }
            int hashCode = this.columns.hashCode();
            return this.orders.hashCode() + ((hashCode + (((i * 31) + (this.unique ? 1 : 0)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Index{name='");
            outline73.append(this.name);
            outline73.append("', unique=");
            outline73.append(this.unique);
            outline73.append(", columns=");
            outline73.append(this.columns);
            outline73.append(", orders=");
            return GeneratedOutlineSupport.outline64(outline73, this.orders, "'}");
        }

        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Index(java.lang.String r5, boolean r6, java.util.List<java.lang.String> r7) {
            /*
                r4 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "columns"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                int r0 = r7.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 0
            L_0x0014:
                if (r2 >= r0) goto L_0x0022
                androidx.room.Index$Order r3 = androidx.room.Index$Order.ASC
                java.lang.String r3 = r3.name()
                r1.add(r3)
                int r2 = r2 + 1
                goto L_0x0014
            L_0x0022:
                r4.<init>(r5, r6, r7, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfo.Index.<init>(java.lang.String, boolean, java.util.List):void");
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "columns");
        Intrinsics.checkNotNullParameter(set, "foreignKeys");
        this.name = str;
        this.columns = map;
        this.foreignKeys = set;
        this.indices = set2;
    }

    /* JADX INFO: finally extract failed */
    public static final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Throwable th;
        Map map;
        Throwable th2;
        Throwable th3;
        Set set;
        Set set2;
        SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
        String str2 = str;
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase2, "database");
        Intrinsics.checkNotNullParameter(str2, "tableName");
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase2, "database");
        Intrinsics.checkNotNullParameter(str2, "tableName");
        Cursor query = supportSQLiteDatabase2.query("PRAGMA table_info(`" + str2 + "`)");
        try {
            if (query.getColumnCount() <= 0) {
                map = ArraysKt___ArraysJvmKt.emptyMap();
                TweetUtils.closeFinally(query, null);
            } else {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("notnull");
                int columnIndex4 = query.getColumnIndex("pk");
                int columnIndex5 = query.getColumnIndex("dflt_value");
                Map createMapBuilder = TweetUtils.createMapBuilder();
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    String string2 = query.getString(columnIndex2);
                    boolean z = query.getInt(columnIndex3) != 0;
                    int i = query.getInt(columnIndex4);
                    String string3 = query.getString(columnIndex5);
                    Intrinsics.checkNotNullExpressionValue(string, "name");
                    Intrinsics.checkNotNullExpressionValue(string2, "type");
                    Column column = new Column(string, string2, z, i, string3, 2);
                    ((MapBuilder) createMapBuilder).put(string, column);
                }
                map = TweetUtils.build(createMapBuilder);
                TweetUtils.closeFinally(query, null);
            }
            Cursor query2 = supportSQLiteDatabase2.query("PRAGMA foreign_key_list(`" + str2 + "`)");
            try {
                int columnIndex6 = query2.getColumnIndex("id");
                int columnIndex7 = query2.getColumnIndex(Values.SEQ);
                int columnIndex8 = query2.getColumnIndex("table");
                int columnIndex9 = query2.getColumnIndex("on_delete");
                int columnIndex10 = query2.getColumnIndex("on_update");
                List<ForeignKeyWithSequence> readForeignKeyFieldMappings = CompoundButtonCompat.readForeignKeyFieldMappings(query2);
                query2.moveToPosition(-1);
                SetBuilder setBuilder = new SetBuilder();
                while (query2.moveToNext()) {
                    if (query2.getInt(columnIndex7) == 0) {
                        int i2 = query2.getInt(columnIndex6);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = columnIndex6;
                        ArrayList arrayList3 = new ArrayList();
                        for (T next : readForeignKeyFieldMappings) {
                            int i4 = columnIndex7;
                            List<ForeignKeyWithSequence> list = readForeignKeyFieldMappings;
                            if (((ForeignKeyWithSequence) next).id == i2) {
                                arrayList3.add(next);
                            }
                            columnIndex7 = i4;
                            readForeignKeyFieldMappings = list;
                        }
                        int i5 = columnIndex7;
                        List<ForeignKeyWithSequence> list2 = readForeignKeyFieldMappings;
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) it.next();
                            arrayList.add(foreignKeyWithSequence.from);
                            arrayList2.add(foreignKeyWithSequence.to);
                        }
                        String string4 = query2.getString(columnIndex8);
                        Intrinsics.checkNotNullExpressionValue(string4, "cursor.getString(tableColumnIndex)");
                        String string5 = query2.getString(columnIndex9);
                        Intrinsics.checkNotNullExpressionValue(string5, "cursor.getString(onDeleteColumnIndex)");
                        String string6 = query2.getString(columnIndex10);
                        Intrinsics.checkNotNullExpressionValue(string6, "cursor.getString(onUpdateColumnIndex)");
                        ForeignKey foreignKey = new ForeignKey(string4, string5, string6, arrayList, arrayList2);
                        setBuilder.add(foreignKey);
                        columnIndex6 = i3;
                        columnIndex7 = i5;
                        readForeignKeyFieldMappings = list2;
                        columnIndex8 = columnIndex8;
                    }
                }
                Set build = TweetUtils.build((Set<E>) setBuilder);
                TweetUtils.closeFinally(query2, null);
                Cursor query3 = supportSQLiteDatabase2.query("PRAGMA index_list(`" + str2 + "`)");
                try {
                    int columnIndex11 = query3.getColumnIndex("name");
                    int columnIndex12 = query3.getColumnIndex("origin");
                    int columnIndex13 = query3.getColumnIndex("unique");
                    if (!(columnIndex11 == -1 || columnIndex12 == -1)) {
                        if (columnIndex13 != -1) {
                            SetBuilder setBuilder2 = new SetBuilder();
                            while (query3.moveToNext()) {
                                if (Intrinsics.areEqual("c", query3.getString(columnIndex12))) {
                                    String string7 = query3.getString(columnIndex11);
                                    boolean z2 = query3.getInt(columnIndex13) == 1;
                                    Intrinsics.checkNotNullExpressionValue(string7, "name");
                                    Index readIndex = CompoundButtonCompat.readIndex(supportSQLiteDatabase2, string7, z2);
                                    if (readIndex == null) {
                                        TweetUtils.closeFinally(query3, null);
                                        set = null;
                                        break;
                                    }
                                    setBuilder2.add(readIndex);
                                }
                            }
                            set2 = TweetUtils.build((Set<E>) setBuilder2);
                            TweetUtils.closeFinally(query3, null);
                            set = set2;
                            return new TableInfo(str2, map, build, set);
                        }
                    }
                    set2 = null;
                    TweetUtils.closeFinally(query3, null);
                    set = set2;
                    return new TableInfo(str2, map, build, set);
                } catch (Throwable th4) {
                    Throwable th5 = th4;
                    TweetUtils.closeFinally(query3, th3);
                    throw th5;
                }
            } catch (Throwable th6) {
                Throwable th7 = th6;
                TweetUtils.closeFinally(query2, th2);
                throw th7;
            }
        } catch (Throwable th8) {
            Throwable th9 = th8;
            TweetUtils.closeFinally(query, th);
            throw th9;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!Intrinsics.areEqual(this.name, tableInfo.name) || !Intrinsics.areEqual(this.columns, tableInfo.columns) || !Intrinsics.areEqual(this.foreignKeys, tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set = this.indices;
        if (set != null) {
            Set<Index> set2 = tableInfo.indices;
            if (set2 != null) {
                z = Intrinsics.areEqual(set, set2);
            }
        }
        return z;
    }

    public int hashCode() {
        int hashCode = this.columns.hashCode();
        return this.foreignKeys.hashCode() + ((hashCode + (this.name.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TableInfo{name='");
        outline73.append(this.name);
        outline73.append("', columns=");
        outline73.append(this.columns);
        outline73.append(", foreignKeys=");
        outline73.append(this.foreignKeys);
        outline73.append(", indices=");
        outline73.append(this.indices);
        outline73.append('}');
        return outline73.toString();
    }
}
