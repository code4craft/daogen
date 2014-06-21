package com.dianping.daogen.transfer.db2java;

import com.dianping.daogen.GeneratorContext;
import com.dianping.daogen.db.model.Table;
import com.dianping.daogen.java.model.dao.Model;

/**
 * @author code4crafer@gmail.com
 */
public interface ModelTransfer {

    public Model transfer(Table table, GeneratorContext generatorContext);
}
