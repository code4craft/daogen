package com.dianping.daogen.generator.dao.method.impl;

import com.dianping.daogen.GeneratorContext;
import com.dianping.daogen.db.model.Column;
import com.dianping.daogen.java.model.dao.DaoMethod;
import com.dianping.daogen.java.model.lang.Type;
import com.dianping.daogen.java.model.lang.Field;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public class LoadDaoMethodGenerator extends AbstractDaoMethodGenerator {

    @Override
    protected Type getReturnType(GeneratorContext generatorContext) {
        return generatorContext.getModel().getType();
    }

    @Override
    protected List<DaoMethod.Param> getMethodParams(GeneratorContext generatorContext) {
        DaoMethod.Param param = new DaoMethod.Param();
        Column primaryKey = getPrimaryColumn(generatorContext);
        Field primaryField = getPrimaryField(generatorContext);
        param.setName(StringUtils.uncapitalize(primaryField.getName()));
        param.setType(primaryField.getType());
        param.setCondition(true);
        param.setColumn(primaryKey);
        return Collections.singletonList(param);
    }


    @Override
    protected String getMethodType(GeneratorContext generatorContext) {
        return DaoMethod.MethodType.LOAD;
    }

    @Override
    public String getMethodName() {
        return "loadById";
    }
}
