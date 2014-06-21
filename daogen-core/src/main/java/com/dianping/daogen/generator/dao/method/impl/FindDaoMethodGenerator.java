package com.dianping.daogen.generator.dao.method.impl;

import com.dianping.daogen.generator.GeneratorContext;
import com.dianping.daogen.model.java.DaoMethod;
import com.dianping.daogen.model.java.Type;
import com.dianping.daogen.model.java.Field;
import com.dianping.daogen.utils.TypeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public class FindDaoMethodGenerator extends AbstractDaoMethodGenerator {

    @Override
    protected Type getReturnType(GeneratorContext generatorContext) {
        return generatorContext.getEntity();
    }

    @Override
    protected List<DaoMethod.Param> getMethodParams(GeneratorContext generatorContext) {
        DaoMethod.Param param = new DaoMethod.Param();
        Field primaryField = generatorContext.getModel().getPrimaryField();
        param.setName(StringUtils.uncapitalize(primaryField.getName())+"s");
        param.setType(new Type(TypeUtils.getBoxedType(primaryField.getTypeOriginName())));
        param.setCondition(true);
        param.setMulti(true);
        param.setColumn(primaryField.getColumn());
        return Collections.singletonList(param);
    }

    @Override
    protected String getMethodType(GeneratorContext generatorContext) {
        return DaoMethod.Type.QUERY;
    }

    @Override
    public String getMethodName() {
        return "findByIds";
    }

    @Override
    protected String getReturnCollection(GeneratorContext generatorContext) {
        return "List";
    }
}
