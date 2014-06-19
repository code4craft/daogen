package com.dianping.daogen.action;

import com.dianping.daogen.DaoGen;
import com.dianping.daogen.config.Project;
import com.dianping.daogen.config.Task;
import com.dianping.daogen.generator.GeneratorContext;
import com.dianping.daogen.render.FreeMarkerRenderer;
import com.dianping.daogen.render.FreemarkerWrapper;
import com.dianping.daogen.schema.java.Model;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public class GenerateAction extends ActionSupport {

    @Setter
    private String basePackage;

    @Setter
    private String sql;

    @Setter
    private List<String> methods;

    @Getter
    private String entity;

    @Getter
    private String dao;

    @Getter
    private String sqlMap;

    @Getter
    private String test;

    @Getter
    private String springConfig;

    @Getter
    private String sqlConfig;

    @Getter
    private Model model;

    @Getter
    private String errorMsg;

    @Override
    public String execute() throws Exception {
        Project project = new Project();
        project.setBasePackage(basePackage);
        project.setDaoPackage(project.getBasePackage() + ".dao");
        project.setEntityPackage(project.getBasePackage() + ".entity");
        project.setDaoRealizeTarget("your-daoRealize-Target");
        Task task = new Task();
        task.setProject(project);
        task.setMethods(methods);
        DaoGen daoGen = new DaoGen();
        task.setSql(sql);
        try {
            GeneratorContext generatorContext = daoGen.generateGeneratorContext(task);
            model = generatorContext.getModel();
            entity = new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/model/entity.ftl")).render(generatorContext);
            dao = new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/dao/avatardao.ftl")).render(generatorContext);
            sqlMap = new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/sqlmap/avatarsqlmap.ftl")).render(generatorContext);
            test = new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/test/daotest.ftl")).render(generatorContext);
            springConfig = new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/spring/dao.ftl")).render(generatorContext);
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errorMsg = errors.toString();
            return ERROR;
        }
        return SUCCESS;
    }
}
