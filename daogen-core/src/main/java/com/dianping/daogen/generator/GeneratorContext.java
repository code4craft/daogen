package com.dianping.daogen.generator;

import com.dianping.daogen.config.Project;
import com.dianping.daogen.model.db.Table;
import com.dianping.daogen.model.java.Dao;
import com.dianping.daogen.model.java.Model;
import com.dianping.daogen.model.java.Type;
import com.dianping.daogen.model.mapping.Mappings;
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

    private Mappings mappings = new Mappings();

    private Type entity;

    private Dao dao;

    private Project project;

    private Map<String,Object> map = new HashMap<String, Object>();

}
