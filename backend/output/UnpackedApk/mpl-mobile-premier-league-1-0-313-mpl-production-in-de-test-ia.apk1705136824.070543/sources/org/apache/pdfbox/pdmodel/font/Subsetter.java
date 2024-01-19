package org.apache.pdfbox.pdmodel.font;

import java.io.IOException;

public interface Subsetter {
    void addToSubset(int i);

    void subset() throws IOException;
}
