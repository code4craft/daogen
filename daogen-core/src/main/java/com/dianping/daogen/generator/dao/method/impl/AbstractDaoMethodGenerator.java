package com.dianping.daogen.generator.dao.method.impl;

import com.dianping.daogen.generator.GeneratorContext;
import com.dianping.daogen.model.db.Column;
import com.dianping.daogen.model.java.DaoMethod;
import com.dianping.daogen.generator.dao.method.DaoMethodGenerator;
import com.dianping.daogen.model.java.Field;
import com.dianping.daogen.model.java.Type;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public abstract class AbstractDaoMethodGenerator implements DaoMethodGenerator {

    @Override
    public DaoMethod generate(GeneratorContext generatorContext) {
        DaoMethod daoMethod = new DaoMethod();
        daoMethod.setEntity(generatorContext.getEntity());
        daoMethod.setName(getMethodName());
        daoMethod.setType(getMethodType(generatorContext));
        daoMethod.setParams(getMethodParams(generatorContext));
        daoMethod.setReturnType(getReturnType(generatorContext));
        daoMethod.setReturnCollection(getReturnCollection(generatorContext));
        postGenerate(daoMethod);
        return daoMethod;
    }

    protected void postGenerate(DaoMethod daoMethod) {
    }

    protected Column getPrimaryColumn(GeneratorContext generatorContext) {
        return generatorContext.getTable().getPrimaryKey();
    }

    protected Field getPrimaryField(GeneratorContext generatorContext) {
        Field primaryField = null;
        if (generatorContext.getTable().getPrimaryKey() != null) {
            primaryField = generatorContext.getTable().getPrimaryKey().getField();
        }
        return primaryField;
    }

    protected abstract Type getReturnType(GeneratorContext generatorContext);

    protected String getReturnCollection(GeneratorContext generatorContext){
        return null;
    }

    protected abstract List<DaoMethod.Param> getMethodParams(GeneratorContext generatorContext);

    protected abstract String getMethodType(GeneratorContext generatorContext);

    public abstract String getMethodName();

}
