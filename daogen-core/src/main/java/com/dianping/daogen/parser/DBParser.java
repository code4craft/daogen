package com.dianping.daogen.parser;

import com.dianping.daogen.schema.db.Table;

/**
 * @author code4crafer@gmail.com
 */
public interface DBParser {

    public Table parse(String schema);
}
