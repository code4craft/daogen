package com.dianping.daogen;

import com.dianping.daogen.config.Project;
import com.dianping.daogen.config.Task;
import com.dianping.daogen.java.model.dao.Dao;
import com.dianping.daogen.generator.dao.method.DaoGenerator;
import com.dianping.daogen.db.parser.MysqlCreateTableParser;
import com.dianping.daogen.render.FreeMarkerRenderer;
import com.dianping.daogen.render.FreemarkerWrapper;
import com.dianping.daogen.db.model.Table;
import com.dianping.daogen.java.model.dao.Model;
import com.dianping.daogen.transfer.db2java.DefaultFieldTransfer;
import com.dianping.daogen.transfer.db2java.DefaultModelTransfer;
import com.google.common.collect.Lists;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public class DaoGen {

    private List<String> sqlMapPath = new ArrayList<String>();

    public void process(Task task) throws IOException, TemplateModelException {
        Project project = task.getProject();
        GeneratorContext generatorContext = generateGeneratorContext(task);
        String sourcePath = project.getOutputDir() + "src/main/java/";
        String daoPathname = sourcePath + project.getDaoPackage().replaceAll("\\.", "/");
        File daoFilePath = new File(daoPathname);
        FileUtils.forceMkdir(daoFilePath);
        writeFile(daoPathname + "/" + generatorContext.getDao().getType().getName() + ".java", new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/dao/avatardao.ftl")).render(generatorContext));
        String entityPathName = sourcePath + project.getEntityPackage().replaceAll("\\.", "/");
        File entityFilePath = new File(entityPathName);
        FileUtils.forceMkdir(entityFilePath);
        writeFile(entityFilePath + "/" + generatorContext.getModel().getName() + ".java",
                new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/model/entity.ftl")).render(generatorContext));

        String resourcePath = project.getOutputDir() + "src/main/resources/" + project.getSqlMapPath();
        FileUtils.forceMkdir(new File(resourcePath));
        sqlMapPath.add(project.getSqlMapPath() + generatorContext.getModel().getName() + ".xml");
        writeFile(resourcePath + generatorContext.getModel().getName() + ".xml",
                new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/sqlmap/avatarsqlmap.ftl")).render(generatorContext));

        String testDaoPathname = project.getOutputDir() + "src/test/java/" + project.getDaoPackage().replaceAll("\\.", "/");
        File testDaoFilePath = new File(testDaoPathname);
        FileUtils.forceMkdir(testDaoFilePath);
        writeFile(testDaoPathname + "/" + generatorContext.getDao().getType().getName() + "Test.java",
                new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/test/daotest.ftl")).render(generatorContext));

        System.out.println(new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/spring/dao.ftl")).render(generatorContext));

    }

    public List<String> getSqlMapPath() {
        return sqlMapPath;
    }

    private void writeFile(String fileName, String content) throws IOException {
        File file = new File(fileName);
//        if (file.exists()) {
//            file = new File(fileName.substring(0, fileName.lastIndexOf(".")) + "2" + fileName.substring(fileName.lastIndexOf(".")));
//        }
        FileUtils.writeStringToFile(file,
                content);
    }

    public GeneratorContext generateGeneratorContext(Task task) throws TemplateModelException {
        Project project = task.getProject();
        DefaultModelTransfer modelTransfer = new DefaultModelTransfer();
        modelTransfer.setFieldTransfer(new DefaultFieldTransfer());
        GeneratorContext generatorContext = new GeneratorContext();
        Table table = new MysqlCreateTableParser().parse(task.getSql());
        Model model = modelTransfer.transfer(table,generatorContext);
        generatorContext.setModel(model);
        generatorContext.setTable(table);
        //type of model
        DaoGenerator daoGenerator = DaoGenerator.createByMethodNames(task.getMethods());
        daoGenerator.setPkg(project.getDaoPackage());
        Dao dao = daoGenerator.generate(generatorContext);
        generatorContext.setDao(dao);
        BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
        TemplateHashModel staticModels = wrapper.getStaticModels();
        TemplateHashModel fileStatics =
                (TemplateHashModel) staticModels.get("com.dianping.daogen.utils.TypeUtils");
        generatorContext.getMap().put("typeUtils", fileStatics);
        generatorContext.setProject(project);
        return generatorContext;
    }

    public static void main(String[] args) throws IOException, TemplateModelException {
        List<String> sqls = new ArrayList<String>();
        sqls.add("CREATE TABLE `DP_DaoGen` (\n" +
                "    `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一id',\n" +
                "    `Name` varchar(200) NOT NULL DEFAULT '' COMMENT '名称',\n" +
                "    `EnName` varchar(200) NOT NULL DEFAULT '' COMMENT '英文名，唯一',\n" +
                "    `Status` int(11) NOT NULL DEFAULT '0' COMMENT '状态，为0表示不可用',\n" +
                "    `AddTime` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '添加时间',\n" +
                "    `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',\n" +
                "    PRIMARY KEY (`Id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Dao生成器';");
        Project project = new Project();
        project.setOutputDir("/Users/yihua/dp_workspace/deal-navi-service/deal-navi-dal/");
        project.setBasePackage("com.dianping.tuangou.navi.dal");
        project.setSqlMapPath("config/sqlmap/TPD_Deal/");
        project.setDaoPackage(project.getBasePackage() + ".dao");
        project.setEntityPackage(project.getBasePackage() + ".entity");
        project.setDaoRealizeTarget("daoRealizeTpdTarget");
        Task task = new Task();
        task.setProject(project);
        task.setMethods(Lists.newArrayList("loadById", "findByIds", "findByStartId"));
        DaoGen daoGen = new DaoGen();
        for (String sql : sqls) {
            task.setSql(sql);
            daoGen.process(task);
        }
        for (String s : daoGen.sqlMapPath) {
            System.out.println("<sqlMap resource=\"" + s + "\"/>");
        }


    }

}
