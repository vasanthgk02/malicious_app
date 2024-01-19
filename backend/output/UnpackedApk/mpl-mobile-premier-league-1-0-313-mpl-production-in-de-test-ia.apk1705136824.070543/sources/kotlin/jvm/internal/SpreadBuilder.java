package kotlin.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SpreadBuilder {
    public final ArrayList<Object> list;

    public SpreadBuilder(int i) {
        this.list = new ArrayList<>(i);
    }

    public void addSpread(Object obj) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    ArrayList<Object> arrayList = this.list;
                    arrayList.ensureCapacity(arrayList.size() + objArr.length);
                    Collections.addAll(this.list, objArr);
                }
            } else if (obj instanceof Collection) {
                this.list.addAll((Collection) obj);
            } else if (obj instanceof Iterable) {
                for (Object add : (Iterable) obj) {
                    this.list.add(add);
                }
            } else if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                while (it.hasNext()) {
                    this.list.add(it.next());
                }
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Don't know how to spread ");
                outline73.append(obj.getClass());
                throw new UnsupportedOperationException(outline73.toString());
            }
        }
    }

    public int size() {
        return this.list.size();
    }
}
