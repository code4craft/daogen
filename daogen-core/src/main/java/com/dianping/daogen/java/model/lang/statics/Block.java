package com.dianping.daogen.java.model.lang.statics;

import lombok.Data;

/**
 * 语句块，可以指向一个语法单元，也可以没有<br/>
 *
 * @author code4crafer@gmail.com
 */
@Data
public class Block {

    private Object element;

    private String source;

    public Block(Object element, String source) {
        this.element = element;
        this.source = source;
    }
}
