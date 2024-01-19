package com.facebook.common.internal;

public final class Objects$ToStringHelper {
    public final String className;
    public ValueHolder holderHead;
    public ValueHolder holderTail;
    public boolean omitNullValues = false;

    public static final class ValueHolder {
        public String name;
        public ValueHolder next;
        public Object value;

        public ValueHolder(Objects$1 objects$1) {
        }
    }

    public Objects$ToStringHelper(String str, Objects$1 objects$1) {
        ValueHolder valueHolder = new ValueHolder(null);
        this.holderHead = valueHolder;
        this.holderTail = valueHolder;
        if (str != null) {
            this.className = str;
            return;
        }
        throw null;
    }

    public Objects$ToStringHelper add(String str, boolean z) {
        addHolder(str, String.valueOf(z));
        return this;
    }

    public final Objects$ToStringHelper addHolder(String str, Object obj) {
        ValueHolder valueHolder = new ValueHolder(null);
        this.holderTail.next = valueHolder;
        this.holderTail = valueHolder;
        valueHolder.value = obj;
        if (str != null) {
            valueHolder.name = str;
            return this;
        }
        throw null;
    }

    public String toString() {
        boolean z = this.omitNullValues;
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        String str = "";
        for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
            if (!z || valueHolder.value != null) {
                sb.append(str);
                String str2 = valueHolder.name;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                sb.append(valueHolder.value);
                str = ", ";
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public Objects$ToStringHelper add(String str, int i) {
        addHolder(str, String.valueOf(i));
        return this;
    }
}
