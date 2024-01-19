package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.JsonMappingException;

public class UnresolvedForwardReference extends JsonMappingException {
    public static final long serialVersionUID = 1;

    public String getMessage() {
        return super.getMessage();
    }
}
