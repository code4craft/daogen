package com.dianping.daogen.java.model.lang.statics;

import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Import implements BlockElement {

    private String typeName;

    public Import(String typeName) {
        this.typeName = typeName;
    }
}
