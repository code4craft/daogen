package com.dianping.daogen.java.model.dao;

import com.dianping.daogen.java.model.lang.Field;
import com.dianping.daogen.java.model.lang.Type;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


/**
 * @author code4crafer@gmail.com
 */
@AllArgsConstructor
@Data
public class Model extends Type {

    private String name;

    private List<Field> fields;

}
