package com.dianping.daogen.parser.db;

import com.dianping.daogen.model.db.Table;

/**
 * @author code4crafer@gmail.com
 */
public interface DBParser {

    public Table parse(String schema);
}
