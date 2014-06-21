package com.dianping.daogen.java.model.dao;

import com.dianping.daogen.java.model.lang.runtime.Type;
import lombok.Data;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Dao {

    private List<DaoMethod> methods;

    private Type type;

    //insert
    //update
    //update xxx by id
    //delete by id
    //load by id
    //find by ids
    //find by xxx
    //find by id
}
