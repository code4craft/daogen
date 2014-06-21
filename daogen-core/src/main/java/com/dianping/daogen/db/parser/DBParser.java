package com.dianping.daogen.db.parser;

import com.dianping.daogen.db.model.Table;

/**
 * @author code4crafer@gmail.com
 */
public interface DBParser {

    public Table parse(String schema);
}
