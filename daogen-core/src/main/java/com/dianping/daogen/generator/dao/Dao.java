package com.dianping.daogen.generator.dao;

import com.dianping.daogen.generator.dao.method.DaoMethod;
import com.dianping.daogen.javamodel.Clazz;
import lombok.Data;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Dao extends Clazz {

    private List<DaoMethod> methods;

    //insert
    //update
    //update xxx by id
    //delete by id
    //load by id
    //find by ids
    //find by xxx
    //find by id
}
