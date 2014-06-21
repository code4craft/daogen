package com.dianping.daogen.renderer;

import com.dianping.daogen.GeneratorContext;
import com.dianping.daogen.render.FreeMarkerRenderer;
import com.dianping.daogen.render.FreemarkerWrapper;
import org.junit.Test;

/**
 * @author code4crafer@gmail.com
 */
public class FreeMarkerRendererTest extends AbstractRendererTest {

    @Test
    public void testRenderEntity() throws Exception {
        FreeMarkerRenderer freeMarkerRenderer = new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/model/entity.ftl"));
        GeneratorContext context = getContext();
        String output = freeMarkerRenderer.render(context);
        System.out.println(output);
    }

    @Test
    public void testRenderDao() throws Exception {
        FreeMarkerRenderer freeMarkerRenderer = new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/dao/avatardao.ftl"));
        GeneratorContext context = getContext();
        String output = freeMarkerRenderer.render(context);
        System.out.println(output);
    }

    @Test
    public void testSqlMap() throws Exception {
        FreeMarkerRenderer freeMarkerRenderer = new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/sqlmap/avatarsqlmap.ftl"));
        GeneratorContext context = getContext();
        String output = freeMarkerRenderer.render(context);
        System.out.println(output);
    }

    @Test
    public void testDaoTest() throws Exception {
        FreeMarkerRenderer freeMarkerRenderer = new FreeMarkerRenderer(FreemarkerWrapper.getInstance().getTemplate("templates/test/daotest.ftl"));
        GeneratorContext context = getContext();
        String output = freeMarkerRenderer.render(context);
        System.out.println(output);
    }
}
