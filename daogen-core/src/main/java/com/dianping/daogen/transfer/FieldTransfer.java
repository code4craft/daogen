package com.dianping.daogen.transfer;

import com.dianping.daogen.schema.db.Column;
import com.dianping.daogen.schema.java.Field;

/**
 * @author code4crafer@gmail.com
 */
public interface FieldTransfer {

    public Field transfer(Column column);
}
