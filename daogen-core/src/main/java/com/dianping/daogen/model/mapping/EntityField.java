package com.dianping.daogen.model.mapping;

import com.dianping.daogen.model.db.Column;
import com.dianping.daogen.model.java.Field;
import lombok.Data;

/**
 * 带有Column关联的field<br/>
 *
 * @author code4crafer@gmail.com
 */
@Data
public class EntityField extends Field {

    private Column column;

    public EntityField(String name, String typeName, Column column) {
        super(name, typeName);
        this.column = column;
    }
}
