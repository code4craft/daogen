package com.dianping.daogen.transfer;

import com.dianping.daogen.model.db.Column;
import com.dianping.daogen.model.java.Field;

/**
 * @author code4crafer@gmail.com
 */
public interface FieldTransfer {

    public Field transfer(Column column);
}
