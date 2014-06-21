package com.dianping.daogen.model.java;

import com.dianping.daogen.model.db.Column;
import com.dianping.daogen.utils.TypeUtils;
import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Field extends Type {

    private String name;

    private Column column;

    public Field(String name, String typeName, Column column) {
        super(typeName);
        this.name = name;
        this.column = column;
    }

    public String getSuggestValue(){
        return TypeUtils.getSuggestValue(getTypeOriginName());
    }
}
