package com.dianping.daogen.transfer.model;

import com.dianping.daogen.db.model.Column;
import com.dianping.daogen.java.model.lang.runtime.Field;
import lombok.Getter;
import lombok.Setter;

/**
 * 带有Column关联的field<br/>
 *
 * @author code4crafer@gmail.com
 */
public class EntityField extends Field {

    @Setter
    @Getter
    private Column column;

    public EntityField(String name, String typeName, Column column) {
        super(name, typeName);
        this.column = column;
    }
}
