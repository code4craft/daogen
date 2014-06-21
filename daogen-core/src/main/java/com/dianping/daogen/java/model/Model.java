package com.dianping.daogen.java.model;

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
