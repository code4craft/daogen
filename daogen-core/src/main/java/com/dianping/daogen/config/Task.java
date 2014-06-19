package com.dianping.daogen.config;

import lombok.Data;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Task {

    private String sql;

    private List<String> methods;

    private Project project;

}
