package com.dianping.daogen.generator.entity;

import com.dianping.daogen.generator.Generator;
import com.dianping.daogen.generator.GeneratorContext;
import com.dianping.daogen.importOrganize.Imports;
import com.dianping.daogen.model.java.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @author code4crafer@gmail.com
 */
public class EntityGenerator implements Generator<Entity> {

    @Setter
    @Getter
    private String suffix = "Entity";

    @Setter
    @Getter
    private String pkg;

    @Override
    public Entity generate(GeneratorContext generatorContext) {
        Model model = generatorContext.getModel();
        Entity entity = new Entity();
        Imports imports = Imports.create(model.getFields());
        entity.setImports(imports);
        entity.setTypeOriginName(pkg + "." + model.getName() + suffix);
        return entity;
    }

}
