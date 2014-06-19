package com.dianping.daogen.generator;

import com.dianping.daogen.config.Project;
import com.dianping.daogen.generator.dao.Dao;
import com.dianping.daogen.generator.entity.Entity;
import com.dianping.daogen.generator.sqlmap.SqlMap;
import com.dianping.daogen.schema.db.Table;
import com.dianping.daogen.schema.java.Model;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class GeneratorContext {

    private Model model;

    private Table table;

    private Entity entity;

    private Dao dao;

    private SqlMap sqlMap;

    private Project project;

    private Map<String,Object> map = new HashMap<String, Object>();

}
