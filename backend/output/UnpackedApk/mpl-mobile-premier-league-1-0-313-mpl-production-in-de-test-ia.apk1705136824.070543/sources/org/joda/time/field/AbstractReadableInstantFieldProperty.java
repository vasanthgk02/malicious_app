package org.joda.time.field;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.Locale;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.fontbox.cmap.CMapParser;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.MutableDateTime.Property;

public abstract class AbstractReadableInstantFieldProperty implements Serializable {
    public static final long serialVersionUID = 1971226328211649661L;

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractReadableInstantFieldProperty)) {
            return false;
        }
        AbstractReadableInstantFieldProperty abstractReadableInstantFieldProperty = (AbstractReadableInstantFieldProperty) obj;
        if (get() != abstractReadableInstantFieldProperty.get() || !getFieldType().equals(abstractReadableInstantFieldProperty.getFieldType()) || !TypeUtilsKt.equals(getChronology(), abstractReadableInstantFieldProperty.getChronology())) {
            z = false;
        }
        return z;
    }

    public int get() {
        return getField().get(getMillis());
    }

    public String getAsShortText(Locale locale) {
        Property property = (Property) this;
        return property.iField.getAsShortText(property.iInstant.iMillis, locale);
    }

    public String getAsText(Locale locale) {
        Property property = (Property) this;
        return property.iField.getAsText(property.iInstant.iMillis, locale);
    }

    public Chronology getChronology() {
        throw new UnsupportedOperationException("The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty");
    }

    public abstract DateTimeField getField();

    public DateTimeFieldType getFieldType() {
        return getField().getType();
    }

    public abstract long getMillis();

    public int hashCode() {
        return getChronology().hashCode() + getFieldType().hashCode() + (get() * 17);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Property[");
        outline73.append(getField().getName());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
