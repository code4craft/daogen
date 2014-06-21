package com.dianping.daogen.transfer;

import com.dianping.daogen.generator.GeneratorContext;
import com.dianping.daogen.model.mapping.EntityColumn;
import com.dianping.daogen.model.mapping.EntityField;

/**
 * @author code4crafer@gmail.com
 */
public interface FieldTransfer {

    public EntityField transfer(EntityColumn column, GeneratorContext generatorContext);
}
