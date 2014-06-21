package com.dianping.daogen.model.java;

import lombok.Data;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Method {

    private String name;

    private Type returnType;

    private List<Param> params;

    @Data
    public static class Param {
        private String name;
        private Type type;
    }

}
