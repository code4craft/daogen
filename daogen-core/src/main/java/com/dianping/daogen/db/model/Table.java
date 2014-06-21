package com.dianping.daogen.db.model;

import com.dianping.daogen.transfer.model.EntityColumn;
import lombok.Data;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Table {

    private String name;

    private List<EntityColumn> columns;

    private String comment;

    public EntityColumn getPrimaryKey() {
        for (EntityColumn column : columns) {
            if (column.isPrimaryKey()) {
                return column;
            }
        }
        return null;
    }

}
