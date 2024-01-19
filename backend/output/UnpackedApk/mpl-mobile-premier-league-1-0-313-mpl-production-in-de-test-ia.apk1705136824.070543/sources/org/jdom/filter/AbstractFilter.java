package org.jdom.filter;

import java.io.Serializable;

public abstract class AbstractFilter implements Serializable {
    public abstract boolean matches(Object obj);
}
