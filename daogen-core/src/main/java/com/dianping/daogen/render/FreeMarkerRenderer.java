package com.dianping.daogen.render;

import com.dianping.daogen.GeneratorContext;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author code4crafer@gmail.com
 */
public class FreeMarkerRenderer implements Renderer {

    private Template template;

    public FreeMarkerRenderer(Template template) {
        this.template = template;
    }

    @Override
    public String render(GeneratorContext context) {
        StringWriter stringWriter = new StringWriter();
        try {
            template.process(context, stringWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }
}
