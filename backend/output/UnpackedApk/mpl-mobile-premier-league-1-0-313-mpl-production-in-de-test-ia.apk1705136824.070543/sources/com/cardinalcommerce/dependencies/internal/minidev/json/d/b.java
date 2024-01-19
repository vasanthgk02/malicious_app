package com.cardinalcommerce.dependencies.internal.minidev.json.d;

import com.cardinalcommerce.dependencies.internal.minidev.asm.ConvertDate;
import java.util.Date;

public abstract class b<T> extends j<T> {

    /* renamed from: a  reason: collision with root package name */
    public static j<Date> f1940a = new a<Date>(null) {
        /* renamed from: b */
        public Date a(Object obj) {
            return ConvertDate.convertToDate(obj);
        }
    };
}
