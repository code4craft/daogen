package com.dianping.daogen.model.java;

import com.dianping.daogen.utils.TypeUtils;
import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Field extends Type {

    private String name;

    public Field(String name, String typeName) {
        super(typeName);
        this.name = name;
    }

    public String getSuggestValue(){
        return TypeUtils.getSuggestValue(getTypeOriginName());
    }
}
