package org.joda.time.chrono;

import com.freshchat.consumer.sdk.beans.config.DefaultConversationConfig;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

public final class BasicWeekOfWeekyearDateTimeField extends PreciseDurationDateTimeField {
    public final BasicChronology iChronology;

    public BasicWeekOfWeekyearDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.WEEK_OF_WEEKYEAR_TYPE, durationField);
        this.iChronology = basicChronology;
    }

    public int get(long j) {
        BasicChronology basicChronology = this.iChronology;
        return basicChronology.getWeekOfWeekyear(j, basicChronology.getYear(j));
    }

    public int getMaximumValue() {
        return 53;
    }

    public int getMaximumValue(long j) {
        return this.iChronology.getWeeksInYear(this.iChronology.getWeekyear(j));
    }

    public int getMaximumValueForSet(long j, int i) {
        if (i <= 52) {
            return 52;
        }
        return this.iChronology.getWeeksInYear(this.iChronology.getWeekyear(j));
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.iWeekyears;
    }

    public long remainder(long j) {
        return super.remainder(j + DefaultConversationConfig.ACTIVE_CONV_WINDOW);
    }

    public long roundCeiling(long j) {
        return super.roundCeiling(j + DefaultConversationConfig.ACTIVE_CONV_WINDOW) - DefaultConversationConfig.ACTIVE_CONV_WINDOW;
    }

    public long roundFloor(long j) {
        return super.roundFloor(j + DefaultConversationConfig.ACTIVE_CONV_WINDOW) - DefaultConversationConfig.ACTIVE_CONV_WINDOW;
    }
}
