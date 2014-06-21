package com.dianping.daogen.generator.dao.method;

import com.dianping.daogen.generator.Generator;
import com.dianping.daogen.generator.GeneratorContext;
import com.dianping.daogen.model.java.Dao;
import com.dianping.daogen.generator.dao.method.impl.FindByStartDaoMethodGenerator;
import com.dianping.daogen.generator.dao.method.impl.FindDaoMethodGenerator;
import com.dianping.daogen.generator.dao.method.impl.InsertDaoMethodGenerator;
import com.dianping.daogen.generator.dao.method.impl.LoadDaoMethodGenerator;
import com.dianping.daogen.import_organize.Imports;
import com.dianping.daogen.model.java.DaoMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author code4crafer@gmail.com
 */
public class DaoGenerator implements Generator<Dao> {

    @Setter
    @Getter
    private String pkg;

    @Setter
    @Getter
    private List<DaoMethodGenerator> methodGenerators;

    private static Map<String, DaoMethodGenerator> methodGeneratorMap = new HashMap<String, DaoMethodGenerator>();

    static {
        InsertDaoMethodGenerator insertDaoMethodGenerator = new InsertDaoMethodGenerator();
        methodGeneratorMap.put(insertDaoMethodGenerator.getMethodName(), insertDaoMethodGenerator);

        LoadDaoMethodGenerator loadDaoMethodGenerator = new LoadDaoMethodGenerator();
        methodGeneratorMap.put(loadDaoMethodGenerator.getMethodName(), loadDaoMethodGenerator);

        FindDaoMethodGenerator findDaoMethodGenerator = new FindDaoMethodGenerator();
        methodGeneratorMap.put(findDaoMethodGenerator.getMethodName(), findDaoMethodGenerator);

        FindByStartDaoMethodGenerator findByStartDaoMethodGenerator = new FindByStartDaoMethodGenerator();
        methodGeneratorMap.put(findByStartDaoMethodGenerator.getMethodName(), findByStartDaoMethodGenerator);
    }

    public static DaoGenerator createByMethodNames(List<String> methods) {
        List<DaoMethodGenerator> methodGenerators = new ArrayList<DaoMethodGenerator>();
        for (String method : methods) {
            DaoMethodGenerator daoMethodGenerator = methodGeneratorMap.get(method);
            if (daoMethodGenerator == null) {
                throw new IllegalArgumentException("Method " + method + " is not defined!");
            }
            methodGenerators.add(daoMethodGenerator);
        }
        DaoGenerator daoGenerator=new DaoGenerator();
        daoGenerator.setMethodGenerators(methodGenerators);
        return daoGenerator;
    }

    @Override
    public Dao generate(GeneratorContext generatorContext) {
        Dao dao = new Dao();
        generatorContext.setDao(dao);
        List<DaoMethod> daoMethods = new ArrayList<DaoMethod>();
        for (Generator<DaoMethod> methodGenerator : methodGenerators) {
            DaoMethod daoMethod = methodGenerator.generate(generatorContext);
            daoMethods.add(daoMethod);
        }
        dao.setMethods(daoMethods);
        Imports imports = dao.getImports();
        for (DaoMethod daoMethod : daoMethods) {
            imports.merge(daoMethod.getEntity().getTypeFullName());
        }
        dao.setImports(imports);
        dao.setTypeOriginName(pkg + "." + generatorContext.getModel().getName() + "Dao");
        return dao;
    }

}