package com.dianping.daogen.transfer.model;

import com.dianping.daogen.db.model.Column;
import com.dianping.daogen.java.model.lang.runtime.Field;
import lombok.Getter;
import lombok.Setter;

/**
 * @author code4crafer@gmail.com
 */
public class EntityColumn extends Column {

    @Setter
    @Getter
    private Field field;

    public EntityColumn(String name, String type, boolean isPrimaryKey, String comment) {
        super(name, type, isPrimaryKey, comment);
    }

}
