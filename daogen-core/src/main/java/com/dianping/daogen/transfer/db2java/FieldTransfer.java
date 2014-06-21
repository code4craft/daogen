package com.dianping.daogen.transfer.db2java;

import com.dianping.daogen.GeneratorContext;
import com.dianping.daogen.transfer.model.EntityColumn;
import com.dianping.daogen.transfer.model.EntityField;

/**
 * @author code4crafer@gmail.com
 */
public interface FieldTransfer {

    public EntityField transfer(EntityColumn column, GeneratorContext generatorContext);
}
