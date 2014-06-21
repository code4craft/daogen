package com.dianping.daogen.generator.dao.method.impl;

import com.dianping.daogen.generator.AbstractGeneratorTest;
import com.dianping.daogen.GeneratorContext;
import com.dianping.daogen.java.model.dao.DaoMethod;
import org.junit.Test;

/**
 * @author code4crafer@gmail.com
 */
public class InsertDaoMethodGeneratorTest extends AbstractGeneratorTest{

    private InsertDaoMethodGenerator insertDaoMethodGenerator = new InsertDaoMethodGenerator();

    @Test
    public void testGenerate() throws Exception {
        GeneratorContext context = getContext();
        DaoMethod daoMethod = insertDaoMethodGenerator.generate(context);
        System.out.println(daoMethod);
    }
}
