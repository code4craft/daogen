package com.dianping.daogen.generator.dao.method.impl;

import com.dianping.daogen.GeneratorContext;
import com.dianping.daogen.java.model.dao.DaoMethod;
import com.dianping.daogen.java.model.lang.Type;
import com.dianping.daogen.java.model.lang.Field;
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
        return generatorContext.getModel().getType();
    }

    @Override
    protected List<DaoMethod.Param> getMethodParams(GeneratorContext generatorContext) {
        DaoMethod.Param param = new DaoMethod.Param();
        Field primaryField = getPrimaryField(generatorContext);
        param.setName(StringUtils.uncapitalize(primaryField.getName())+"s");
        param.setType(new Type(TypeUtils.getBoxedType(primaryField.getType().getOriginName())));
        param.setCondition(true);
        param.setMulti(true);
        param.setColumn(getPrimaryColumn(generatorContext));
        return Collections.singletonList(param);
    }

    @Override
    protected String getMethodType(GeneratorContext generatorContext) {
        return DaoMethod.MethodType.QUERY;
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
