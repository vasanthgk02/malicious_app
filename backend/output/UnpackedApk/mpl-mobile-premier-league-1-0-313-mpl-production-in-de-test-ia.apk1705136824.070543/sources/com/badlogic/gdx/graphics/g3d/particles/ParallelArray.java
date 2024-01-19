package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ParallelArray {
    public Array<Channel> arrays = new Array<>(false, 2, Channel.class);
    public int capacity;
    public int size;

    public abstract class Channel {
        public Object data;
        public int id;
        public int strideSize;

        public Channel(int i, Object obj, int i2) {
            this.id = i;
            this.strideSize = i2;
            this.data = obj;
        }

        public abstract void add(int i, Object... objArr);

        public abstract void setCapacity(int i);

        public abstract void swap(int i, int i2);
    }

    public static class ChannelDescriptor {
        public int count;
        public int id;
        public Class<?> type;

        public ChannelDescriptor(int i, Class<?> cls, int i2) {
            this.id = i;
            this.type = cls;
            this.count = i2;
        }
    }

    public interface ChannelInitializer<T extends Channel> {
        void init(T t);
    }

    public class FloatChannel extends Channel {
        public float[] data = ((float[]) this.data);

        public FloatChannel(int i, int i2, int i3) {
            super(i, new float[(i3 * i2)], i2);
        }

        public void add(int i, Object... objArr) {
            int i2 = this.strideSize;
            int i3 = ParallelArray.this.size * i2;
            int i4 = i2 + i3;
            int i5 = 0;
            while (i3 < i4) {
                this.data[i3] = objArr[i5].floatValue();
                i3++;
                i5++;
            }
        }

        public void setCapacity(int i) {
            int i2 = this.strideSize * i;
            float[] fArr = new float[i2];
            float[] fArr2 = this.data;
            System.arraycopy(fArr2, 0, fArr, 0, Math.min(fArr2.length, i2));
            this.data = fArr;
            this.data = fArr;
        }

        public void swap(int i, int i2) {
            int i3 = this.strideSize;
            int i4 = i * i3;
            int i5 = i2 * i3;
            int i6 = i3 + i4;
            while (i4 < i6) {
                float[] fArr = this.data;
                float f2 = fArr[i4];
                fArr[i4] = fArr[i5];
                fArr[i5] = f2;
                i4++;
                i5++;
            }
        }
    }

    public class IntChannel extends Channel {
        public int[] data = ((int[]) this.data);

        public IntChannel(int i, int i2, int i3) {
            super(i, new int[(i3 * i2)], i2);
        }

        public void add(int i, Object... objArr) {
            int i2 = this.strideSize;
            int i3 = ParallelArray.this.size * i2;
            int i4 = i2 + i3;
            int i5 = 0;
            while (i3 < i4) {
                this.data[i3] = objArr[i5].intValue();
                i3++;
                i5++;
            }
        }

        public void setCapacity(int i) {
            int i2 = this.strideSize * i;
            int[] iArr = new int[i2];
            int[] iArr2 = this.data;
            System.arraycopy(iArr2, 0, iArr, 0, Math.min(iArr2.length, i2));
            this.data = iArr;
            this.data = iArr;
        }

        public void swap(int i, int i2) {
            int i3 = this.strideSize;
            int i4 = i * i3;
            int i5 = i2 * i3;
            int i6 = i3 + i4;
            while (i4 < i6) {
                int[] iArr = this.data;
                int i7 = iArr[i4];
                iArr[i4] = iArr[i5];
                iArr[i5] = i7;
                i4++;
                i5++;
            }
        }
    }

    public class ObjectChannel<T> extends Channel {
        public Class<T> componentType;
        public T[] data = ((Object[]) this.data);

        public ObjectChannel(int i, int i2, int i3, Class<T> cls) {
            super(i, java.lang.reflect.Array.newInstance(cls, i3 * i2), i2);
            this.componentType = cls;
        }

        public void add(int i, Object... objArr) {
            int i2 = this.strideSize;
            int i3 = ParallelArray.this.size * i2;
            int i4 = i2 + i3;
            int i5 = 0;
            while (i3 < i4) {
                this.data[i3] = objArr[i5];
                i3++;
                i5++;
            }
        }

        public void setCapacity(int i) {
            T[] tArr = (Object[]) java.lang.reflect.Array.newInstance(this.componentType, this.strideSize * i);
            T[] tArr2 = this.data;
            System.arraycopy(tArr2, 0, tArr, 0, Math.min(tArr2.length, tArr.length));
            this.data = tArr;
            this.data = tArr;
        }

        public void swap(int i, int i2) {
            int i3 = this.strideSize;
            int i4 = i * i3;
            int i5 = i2 * i3;
            int i6 = i3 + i4;
            while (i4 < i6) {
                T[] tArr = this.data;
                T t = tArr[i4];
                tArr[i4] = tArr[i5];
                tArr[i5] = t;
                i4++;
                i5++;
            }
        }
    }

    public ParallelArray(int i) {
        this.capacity = i;
        this.size = 0;
    }

    private <T extends Channel> T allocateChannel(ChannelDescriptor channelDescriptor) {
        Class<?> cls = channelDescriptor.type;
        if (cls == Float.TYPE) {
            return new FloatChannel(channelDescriptor.id, channelDescriptor.count, this.capacity);
        }
        if (cls == Integer.TYPE) {
            return new IntChannel(channelDescriptor.id, channelDescriptor.count, this.capacity);
        }
        ObjectChannel objectChannel = new ObjectChannel(channelDescriptor.id, channelDescriptor.count, this.capacity, cls);
        return objectChannel;
    }

    private int findIndex(int i) {
        int i2 = 0;
        while (true) {
            Array<Channel> array = this.arrays;
            if (i2 >= array.size) {
                return -1;
            }
            if (((Channel[]) array.items)[i2].id == i) {
                return i2;
            }
            i2++;
        }
    }

    public <T extends Channel> T addChannel(ChannelDescriptor channelDescriptor) {
        return addChannel(channelDescriptor, null);
    }

    public void addElement(Object... objArr) {
        if (this.size != this.capacity) {
            int i = 0;
            ArrayIterator it = this.arrays.iterator();
            while (it.hasNext()) {
                Channel channel = (Channel) it.next();
                channel.add(i, objArr);
                i += channel.strideSize;
            }
            this.size++;
            return;
        }
        throw new GdxRuntimeException((String) "Capacity reached, cannot add other elements");
    }

    public void clear() {
        this.arrays.clear();
        this.size = 0;
    }

    public <T extends Channel> T getChannel(ChannelDescriptor channelDescriptor) {
        ArrayIterator it = this.arrays.iterator();
        while (it.hasNext()) {
            T t = (Channel) it.next();
            if (t.id == channelDescriptor.id) {
                return t;
            }
        }
        return null;
    }

    public <T> void removeArray(int i) {
        this.arrays.removeIndex(findIndex(i));
    }

    public void removeElement(int i) {
        int i2 = this.size - 1;
        ArrayIterator it = this.arrays.iterator();
        while (it.hasNext()) {
            ((Channel) it.next()).swap(i, i2);
        }
        this.size = i2;
    }

    public void setCapacity(int i) {
        if (this.capacity != i) {
            ArrayIterator it = this.arrays.iterator();
            while (it.hasNext()) {
                ((Channel) it.next()).setCapacity(i);
            }
            this.capacity = i;
        }
    }

    public <T extends Channel> T addChannel(ChannelDescriptor channelDescriptor, ChannelInitializer<T> channelInitializer) {
        T channel = getChannel(channelDescriptor);
        if (channel == null) {
            channel = allocateChannel(channelDescriptor);
            if (channelInitializer != null) {
                channelInitializer.init(channel);
            }
            this.arrays.add(channel);
        }
        return channel;
    }
}
