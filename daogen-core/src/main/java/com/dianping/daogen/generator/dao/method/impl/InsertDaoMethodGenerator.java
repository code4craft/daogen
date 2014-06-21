package com.dianping.daogen.generator.dao.method.impl;

import com.dianping.daogen.GeneratorContext;
import com.dianping.daogen.java.model.dao.DaoMethod;
import com.dianping.daogen.java.model.lang.Type;
import com.dianping.daogen.java.model.dao.Model;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public class InsertDaoMethodGenerator extends AbstractDaoMethodGenerator {

    @Override
    protected Type getReturnType(GeneratorContext generatorContext) {
        return Type.INT;
    }

    @Override
    protected List<DaoMethod.Param> getMethodParams(GeneratorContext generatorContext) {
        Model model = generatorContext.getModel();
        DaoMethod.Param param = new DaoMethod.Param();
        param.setName(StringUtils.uncapitalize(model.getName()));
        param.setType(generatorContext.getModel().getType());
        return Collections.singletonList(param);
    }

    @Override
    protected String getMethodType(GeneratorContext generatorContext) {
        return DaoMethod.MethodType.INSERT;
    }

    @Override
    public String getMethodName() {
        return "insert";
    }
}
