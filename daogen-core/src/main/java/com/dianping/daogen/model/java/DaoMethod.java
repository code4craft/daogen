package com.dianping.daogen.model.java;

import com.dianping.daogen.generator.entity.Entity;
import com.dianping.daogen.model.db.Column;
import lombok.Data;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class DaoMethod {

    private String name;

    private String type;

    private Entity entity;

    private com.dianping.daogen.model.java.Type returnType;

    private String returnCollection;

    private List<Param> params;

    private String limit;

    public static interface Type {
        public static final String INSERT = "INSERT";
        public static final String UPDATE = "UPDATE";
        public static final String DELETE = "DELETE";
        public static final String QUERY = "QUERY";
        public static final String LOAD = "LOAD";
    }

    @Data
    public static class Param {
        private String name;
        private com.dianping.daogen.model.java.Type type;
        private boolean multi = false;
        /**
         * true: condition in where clause <br/>
         * false: in values
         */
        private boolean condition = false;

        /**
         * true: in operate part <br/>
         * Update: set `xxx` = #xxx# <br/>
         * Load/Query: select `xxx` from (If not select whole entity) <br/>
         */
        private boolean operate = false;

        private Column column;
    }

}
