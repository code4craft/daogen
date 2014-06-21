package com.dianping.daogen.generator.dao.method.impl;

import com.dianping.daogen.GeneratorContext;
import com.dianping.daogen.java.model.dao.DaoMethod;
import com.dianping.daogen.java.model.lang.runtime.Type;
import com.dianping.daogen.java.model.lang.runtime.Field;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public class FindByStartDaoMethodGenerator extends AbstractDaoMethodGenerator {

    @Override
    protected Type getReturnType(GeneratorContext generatorContext) {
        return generatorContext.getModel().getType();
    }

    @Override
    protected List<DaoMethod.Param> getMethodParams(GeneratorContext generatorContext) {
        List<DaoMethod.Param> params = new ArrayList<DaoMethod.Param>();
        DaoMethod.Param param = new DaoMethod.Param();
        Field primaryField = getPrimaryField(generatorContext);
        param.setName(StringUtils.uncapitalize(primaryField.getName()));
        param.setType(primaryField.getType());
        param.setCondition(true);
        param.setColumn(getPrimaryColumn(generatorContext));
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
        return DaoMethod.MethodType.QUERY;
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
