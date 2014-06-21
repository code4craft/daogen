package com.dianping.daogen.generator.dao.method.impl;

import com.dianping.daogen.generator.GeneratorContext;
import com.dianping.daogen.model.java.DaoMethod;
import com.dianping.daogen.model.java.Type;
import com.dianping.daogen.model.java.Field;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public class FindByStartDaoMethodGenerator extends AbstractDaoMethodGenerator {

    @Override
    protected Type getReturnType(GeneratorContext generatorContext) {
        return generatorContext.getEntity();
    }

    @Override
    protected List<DaoMethod.Param> getMethodParams(GeneratorContext generatorContext) {
        List<DaoMethod.Param> params = new ArrayList<DaoMethod.Param>();
        DaoMethod.Param param = new DaoMethod.Param();
        Field primaryField = generatorContext.getModel().getPrimaryField();
        param.setName(StringUtils.uncapitalize(primaryField.getName()));
        param.setType(primaryField);
        param.setCondition(true);
        param.setColumn(primaryField.getColumn());
        params.add(param);

        param = new DaoMethod.Param();
        param.setCondition(false);
        param.setType(new Type(Integer.TYPE.getName()));
        param.setName("max");
        params.add(param);
        return params;
    }

    @Override
    protected void postGenerate(DaoMethod daoMethod) {
        daoMethod.setLimit("#max#");
    }

    @Override
    protected String getMethodType(GeneratorContext generatorContext) {
        return DaoMethod.Type.QUERY;
    }

    @Override
    public String getMethodName() {
        return "findByStartId";
    }

    @Override
    protected String getReturnCollection(GeneratorContext generatorContext) {
        return "List";
    }
}
