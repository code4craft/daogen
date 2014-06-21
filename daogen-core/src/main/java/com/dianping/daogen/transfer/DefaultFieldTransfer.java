package com.dianping.daogen.transfer;

import com.dianping.daogen.model.db.Column;
import com.dianping.daogen.model.java.Field;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author code4crafer@gmail.com
 */
public class DefaultFieldTransfer implements FieldTransfer {

    private Set<String> ignoreColumns = new HashSet<String>() {{
        add("AddTime");
        add("UpdateTime");
    }};

    @Override
    public Field transfer(Column column) {
        if (ignoreColumns.contains(column.getName())) {
            return null;
        }
        Class transferType = transferType(column.getType());
        if (transferType == null) {
            throw new IllegalArgumentException("Unknown db type " + column);
        }
        return new Field(transferName(column.getName()), transferType.getName(), column);
    }

    protected String transferName(String columnName) {
        String uncapitalize = StringUtils.uncapitalize(columnName);
        if (uncapitalize.equals("iD")) {
            return "id";
        }
        return uncapitalize;
    }

    private static Map<String, Class> typeTransferMap = new HashMap<String, Class>() {
        {
            put("int", Integer.TYPE);
            put("tinyint", Integer.TYPE);
            put("smallint", Integer.TYPE);
            put("bigint", Long.TYPE);
            put("varchar", String.class);
            put("text", String.class);
            put("mediumText", String.class);
            put("timestamp", Date.class);
            put("datetime", Date.class);
            put("decimal", BigDecimal.class);
        }
    };

    protected Class transferType(String dbType) {
        return typeTransferMap.get(dbType);
    }
}
