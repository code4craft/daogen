package com.dianping.daogen.java.model.lang;

import lombok.Data;

import java.util.List;

/**
 * 用于表示一个类的内容<br/>
 *
 * @author code4crafer@gmail.com
 */
@Data
public class Class {

    private List<Field> fields;

    private List<Method> methods;

    private Type type;
}
