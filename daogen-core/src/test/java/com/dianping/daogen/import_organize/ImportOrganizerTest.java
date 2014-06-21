package com.dianping.daogen.import_organize;

import com.dianping.daogen.generator.entity.Entity;
import com.dianping.daogen.model.java.Dao;
import com.dianping.daogen.model.java.DaoMethod;
import com.dianping.daogen.model.java.Type;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafer@gmail.com
 */
public class ImportOrganizerTest {

    @Test
    public void testImportOrganize() throws Exception {
        Dao dao = new Dao();
        List<DaoMethod> daoMethods = new ArrayList<DaoMethod>();
        DaoMethod daoMethod = new DaoMethod();
        Entity entity = new Entity();
        entity.setTypeOriginName("com.dianping.daogen.Entity1");
        daoMethod.setEntity(entity);
        List<DaoMethod.Param> params = new ArrayList<DaoMethod.Param>();
        DaoMethod.Param param = new DaoMethod.Param();
        param.setType(new Type("java.util.Date"));
        params.add(param);
        daoMethod.setParams(params);
        daoMethods.add(daoMethod);
        dao.setMethods(daoMethods);
        ImportOrganizer.organizeImports(dao);
        assertThat(dao.getImports().getImports()).contains("com.dianping.daogen.Entity1");
        assertThat(dao.getImports().getImports()).contains("java.util.Date");
    }
}
