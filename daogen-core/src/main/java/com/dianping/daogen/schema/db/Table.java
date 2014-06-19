package com.dianping.daogen.schema.db;

import lombok.Data;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Table {

    private String name;

    private List<Column> columns;

    private String comment;

}
