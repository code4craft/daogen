package com.dianping.daogen.model.mapping;

import com.dianping.daogen.model.db.Column;
import com.dianping.daogen.model.java.Field;
import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class EntityColumn extends Column {

    private Field field;

    public EntityColumn(String name, String type, boolean isPrimaryKey, String comment) {
        super(name, type, isPrimaryKey, comment);
    }
}
