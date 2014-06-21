package com.dianping.daogen.transfer.model;

import com.dianping.daogen.db.model.Column;
import com.dianping.daogen.java.model.Field;
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
