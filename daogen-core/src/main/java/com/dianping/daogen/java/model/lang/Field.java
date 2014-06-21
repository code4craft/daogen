package com.dianping.daogen.java.model.lang;

import com.dianping.daogen.utils.TypeUtils;
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

    public String getSuggestValue(){
        return TypeUtils.getSuggestValue(type.getTypeOriginName());
    }
}
