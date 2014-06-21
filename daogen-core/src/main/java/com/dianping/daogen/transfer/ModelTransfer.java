package com.dianping.daogen.transfer;

import com.dianping.daogen.model.db.Table;
import com.dianping.daogen.model.java.Model;

/**
 * @author code4crafer@gmail.com
 */
public interface ModelTransfer {

    public Model transfer(Table table);
}
