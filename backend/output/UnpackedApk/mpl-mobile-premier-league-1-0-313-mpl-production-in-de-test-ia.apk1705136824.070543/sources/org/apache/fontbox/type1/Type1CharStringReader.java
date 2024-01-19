package org.apache.fontbox.type1;

import java.io.IOException;
import org.apache.fontbox.cff.Type1CharString;

public interface Type1CharStringReader {
    Type1CharString getType1CharString(String str) throws IOException;
}
