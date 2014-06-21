package com.dianping.daogen.java.model.lang.statics;

import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Package implements BlockElement {

    private String name;

    public Package(String name) {
        this.name = name;
    }
}
