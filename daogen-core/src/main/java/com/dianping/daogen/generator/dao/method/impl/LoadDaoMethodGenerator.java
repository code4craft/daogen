package com.dianping.daogen.generator.dao.method.impl;

import com.dianping.daogen.generator.GeneratorContext;
import com.dianping.daogen.generator.dao.method.DaoMethod;
import com.dianping.daogen.javamodel.Type;
import com.dianping.daogen.schema.java.Field;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public class LoadDaoMethodGenerator extends AbstractDaoMethodGenerator {

    @Override
    protected Type getReturnType(GeneratorContext generatorContext) {
        return generatorContext.getEntity();
    }

    @Override
    protected List<DaoMethod.Param> getMethodParams(GeneratorContext generatorContext) {
        DaoMethod.Param param = new DaoMethod.Param();
        Field primaryField = generatorContext.getModel().getPrimaryField();
        param.setName(StringUtils.uncapitalize(primaryField.getName()));
        param.setType(primaryField);
        param.setCondition(true);
        param.setColumn(primaryField.getColumn());
        return Collections.singletonList(param);
    }

    @Override
    protected String getMethodType(GeneratorContext generatorContext) {
        return DaoMethod.Type.LOAD;
    }

    @Override
    public String getMethodName() {
        return "loadById";
    }
}
