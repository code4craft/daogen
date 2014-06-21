package com.dianping.daogen.java.model.dao;

import com.dianping.daogen.java.model.lang.Field;
import com.dianping.daogen.java.model.lang.Type;
import lombok.Data;

import java.util.List;


/**
 * @author code4crafer@gmail.com
 */
@Data
public class Model {

    private String name;

    private List<Field> fields;

    private Type type;

    public Model(String name, List<Field> fields) {
        this.name = name;
        this.fields = fields;
    }

    public Model(String name, List<Field> fields, Type type) {
        this.name = name;
        this.fields = fields;
        this.type = type;
    }
}
