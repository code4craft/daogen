package com.dianping.daogen.config;

import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Project {

    private String outputDir;

    private String sqlMapPath;

    private String basePackage;

    private String daoPackage;

    private String entityPackage;

    private String testPackage;

    private String springDir;

    private String springFileName;

    private String daoRealizeTarget;

    private String sqlConfigFileName;

}
