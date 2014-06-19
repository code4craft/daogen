package com.dianping.daogen.schema.java;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


/**
 * @author code4crafer@gmail.com
 */
@AllArgsConstructor
@Data
public class Model {

    private String name;

    private List<Field> fields;

    public Field getPrimaryField(){
        for (Field field : fields) {
            if (field.getColumn().isPrimaryKey()){
                return field;
            }
        }
        return null;
    }

}
