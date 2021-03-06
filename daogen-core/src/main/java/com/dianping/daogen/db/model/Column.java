package com.dianping.daogen.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author code4crafer@gmail.com
 */
@AllArgsConstructor
@Data
public class Column {

    private String name;

    private String type;

    private boolean isPrimaryKey;

    private String comment;

}
