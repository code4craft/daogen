package com.dianping.daogen;

import com.dianping.daogen.config.Project;
import com.dianping.daogen.db.model.Table;
import com.dianping.daogen.java.model.dao.Dao;
import com.dianping.daogen.java.model.dao.Model;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class GeneratorContext {

    private Table table;

    private Model model;

    private Dao dao;

    private Project project;

    private Map<String,Object> map = new HashMap<String, Object>();

}
