package com.badlogic.gdx.graphics.g3d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class Material extends Attributes {
    public static int counter;
    public String id;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Material() {
        // StringBuilder outline73 = GeneratedOutlineSupport.outline73("mtl");
        // int i = counter + 1;
        // counter = i;
        // outline73.append(i);
        this(outline73.toString());
    }

    public Material copy() {
        return new Material(this);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Material) && (obj == this || (((Material) obj).id.equals(this.id) && super.equals(obj)));
    }

    public int hashCode() {
        return (this.id.hashCode() * 3) + super.hashCode();
    }

    public Material(String str) {
        this.id = str;
    }

    public Material(Attribute... attributeArr) {
        this();
        set(attributeArr);
    }

    public Material(String str, Attribute... attributeArr) {
        this(str);
        set(attributeArr);
    }

    public Material(Array<Attribute> array) {
        this();
        set((Iterable<Attribute>) array);
    }

    public Material(String str, Array<Attribute> array) {
        this(str);
        set((Iterable<Attribute>) array);
    }

    public Material(Material material) {
        this(material.id, material);
    }

    public Material(String str, Material material) {
        this(str);
        Iterator<Attribute> it = material.iterator();
        while (it.hasNext()) {
            set(it.next().copy());
        }
    }
}
