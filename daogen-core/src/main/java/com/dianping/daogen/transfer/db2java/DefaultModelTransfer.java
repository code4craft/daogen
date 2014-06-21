package com.dianping.daogen.transfer.db2java;

import com.dianping.daogen.GeneratorContext;
import com.dianping.daogen.db.model.Table;
import com.dianping.daogen.java.model.lang.Field;
import com.dianping.daogen.java.model.dao.Model;
import com.dianping.daogen.transfer.model.EntityColumn;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code4crafer@gmail.com
 */
public class DefaultModelTransfer implements ModelTransfer {

    @Setter
    @Getter
    private boolean removePrefix = true;

    @Setter
    @Getter
    private FieldTransfer fieldTransfer;

    @Override
    public Model transfer(Table table, GeneratorContext generatorContext) {
        String tableName = table.getName();
        if (removePrefix) {
            tableName = StringUtils.removePattern(table.getName(), "[A-Za-z]+_");
        }
        List<Field> fieldList = new ArrayList<Field>();
        for (EntityColumn column : table.getColumns()) {
            Field field = fieldTransfer.transfer(column, generatorContext);
            if (field != null) {
                fieldList.add(field);
            }
        }
        tableName = StringUtils.capitalize(tableName);
        return new Model(tableName, fieldList);
    }
}
