package androidx.versionedparcelable;

import android.os.Parcel;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Method;

public class VersionedParcelParcel extends VersionedParcel {
    public int mCurrentField;
    public final int mEnd;
    public int mFieldId;
    public int mNextRead;
    public final int mOffset;
    public final Parcel mParcel;
    public final SparseIntArray mPositionLookup;
    public final String mPrefix;

    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public void closeField() {
        int i = this.mCurrentField;
        if (i >= 0) {
            int i2 = this.mPositionLookup.get(i);
            int dataPosition = this.mParcel.dataPosition();
            this.mParcel.setDataPosition(i2);
            this.mParcel.writeInt(dataPosition - i2);
            this.mParcel.setDataPosition(dataPosition);
        }
    }

    public VersionedParcel createSubParcel() {
        Parcel parcel = this.mParcel;
        int dataPosition = parcel.dataPosition();
        int i = this.mNextRead;
        if (i == this.mOffset) {
            i = this.mEnd;
        }
        VersionedParcelParcel versionedParcelParcel = new VersionedParcelParcel(parcel, dataPosition, i, GeneratedOutlineSupport.outline62(new StringBuilder(), this.mPrefix, "  "), this.mReadCache, this.mWriteCache, this.mParcelizerCache);
        return versionedParcelParcel;
    }

    public boolean readField(int i) {
        while (true) {
            boolean z = true;
            if (this.mNextRead < this.mEnd) {
                int i2 = this.mFieldId;
                if (i2 == i) {
                    return true;
                }
                if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                    return false;
                }
                this.mParcel.setDataPosition(this.mNextRead);
                int readInt = this.mParcel.readInt();
                this.mFieldId = this.mParcel.readInt();
                this.mNextRead += readInt;
            } else {
                if (this.mFieldId != i) {
                    z = false;
                }
                return z;
            }
        }
    }

    public void setOutputField(int i) {
        closeField();
        this.mCurrentField = i;
        this.mPositionLookup.put(i, this.mParcel.dataPosition());
        this.mParcel.writeInt(0);
        this.mParcel.writeInt(i);
    }

    public VersionedParcelParcel(Parcel parcel, int i, int i2, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mNextRead = 0;
        this.mFieldId = -1;
        this.mParcel = parcel;
        this.mOffset = i;
        this.mEnd = i2;
        this.mNextRead = i;
        this.mPrefix = str;
    }
}
