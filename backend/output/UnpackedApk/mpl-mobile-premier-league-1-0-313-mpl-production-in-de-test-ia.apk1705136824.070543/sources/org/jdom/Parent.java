package org.jdom;

import java.io.Serializable;

public interface Parent extends Cloneable, Serializable {
    Parent getParent();
}
