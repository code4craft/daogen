package com.dianping.daogen.generator;

import com.dianping.daogen.config.Project;
import com.dianping.daogen.db.model.Table;
import com.dianping.daogen.java.model.Dao;
import com.dianping.daogen.java.model.Model;
import com.dianping.daogen.java.model.Type;
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

    private Type entity;

    private Dao dao;

    private Project project;

    private Map<String,Object> map = new HashMap<String, Object>();

}
