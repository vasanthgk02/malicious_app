package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {
    public final InternalRewinder rewinder;

    public static final class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory<ParcelFileDescriptor> {
        public DataRewinder build(Object obj) {
            return new ParcelFileDescriptorRewinder((ParcelFileDescriptor) obj);
        }

        public Class<ParcelFileDescriptor> getDataClass() {
            return ParcelFileDescriptor.class;
        }
    }

    public static final class InternalRewinder {
        public final ParcelFileDescriptor parcelFileDescriptor;

        public InternalRewinder(ParcelFileDescriptor parcelFileDescriptor2) {
            this.parcelFileDescriptor = parcelFileDescriptor2;
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.rewinder = new InternalRewinder(parcelFileDescriptor);
    }

    public void cleanup() {
    }

    public ParcelFileDescriptor rewindAndGet() throws IOException {
        InternalRewinder internalRewinder = this.rewinder;
        if (internalRewinder != null) {
            try {
                Os.lseek(internalRewinder.parcelFileDescriptor.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return internalRewinder.parcelFileDescriptor;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        } else {
            throw null;
        }
    }
}
