package org.apache.fontbox.afm;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public String name;
    public List<CompositePart> parts = new ArrayList();

    public void addPart(CompositePart compositePart) {
        this.parts.add(compositePart);
    }

    public String getName() {
        return this.name;
    }

    public List<CompositePart> getParts() {
        return this.parts;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParts(List<CompositePart> list) {
        this.parts = list;
    }
}
