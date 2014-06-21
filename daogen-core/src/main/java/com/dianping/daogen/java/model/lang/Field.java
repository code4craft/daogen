package com.dianping.daogen.java.model.lang;

import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Field {

    private String name;

    private Type type;

    public Field(String name, String typeName) {
        this.type = new Type(typeName);
        this.name = name;
    }

}
