package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {
    public final DataDecoder<Data> dataDecoder;

    public interface DataDecoder<Data> {
    }

    public static final class DataUriFetcher<Data> implements DataFetcher<Data> {
        public Data data;
        public final String dataUri;
        public final DataDecoder<Data> reader;

        public DataUriFetcher(String str, DataDecoder<Data> dataDecoder) {
            this.dataUri = str;
            this.reader = dataDecoder;
        }

        public void cancel() {
        }

        public void cleanup() {
            try {
                DataDecoder<Data> dataDecoder = this.reader;
                Data data2 = this.data;
                if (((AnonymousClass1) dataDecoder) != null) {
                    ((InputStream) data2).close();
                    return;
                }
                throw null;
            } catch (IOException unused) {
            }
        }

        public Class<Data> getDataClass() {
            if (((AnonymousClass1) this.reader) != null) {
                return InputStream.class;
            }
            throw null;
        }

        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public void loadData(Priority priority, DataCallback<? super Data> dataCallback) {
            try {
                Data decode = ((AnonymousClass1) this.reader).decode(this.dataUri);
                this.data = decode;
                dataCallback.onDataReady(decode);
            } catch (IllegalArgumentException e2) {
                dataCallback.onLoadFailed(e2);
            }
        }
    }

    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {
        public final DataDecoder<InputStream> opener = new DataDecoder<InputStream>(this) {
            public Object decode(String str) throws IllegalArgumentException {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        };

        public ModelLoader<Model, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.opener);
        }

        public void teardown() {
        }
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder2) {
        this.dataDecoder = dataDecoder2;
    }

    public LoadData<Data> buildLoadData(Model model, int i, int i2, Options options) {
        return new LoadData<>(new ObjectKey(model), new DataUriFetcher(model.toString(), this.dataDecoder));
    }

    public boolean handles(Model model) {
        return model.toString().startsWith("data:image");
    }
}
