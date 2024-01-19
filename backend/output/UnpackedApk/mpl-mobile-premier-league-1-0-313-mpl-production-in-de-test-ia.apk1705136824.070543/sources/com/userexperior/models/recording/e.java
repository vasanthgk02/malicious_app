package com.userexperior.models.recording;

import android.graphics.Rect;
import android.view.View;
import com.userexperior.models.recording.enums.c;
import java.util.ArrayList;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public List<g> f4080a;

    /* renamed from: b  reason: collision with root package name */
    public List<c> f4081b;

    public final List<Rect> a(View view) {
        if (view == null || this.f4081b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c next : this.f4081b) {
            if (next.f4083b == view) {
                arrayList.add(next.f4082a);
            }
        }
        return arrayList;
    }
}
