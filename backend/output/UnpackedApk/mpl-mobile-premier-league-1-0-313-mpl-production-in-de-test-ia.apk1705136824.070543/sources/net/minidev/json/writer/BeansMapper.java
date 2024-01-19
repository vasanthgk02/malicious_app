package net.minidev.json.writer;

import java.util.Date;
import net.minidev.asm.ConvertDate;

public abstract class BeansMapper<T> extends JsonReaderI<T> {
    public static JsonReaderI<Date> MAPPER_DATE = new ArraysMapper<Date>(null) {
        public Object convert(Object obj) {
            return ConvertDate.convertToDate(obj);
        }
    };
}
