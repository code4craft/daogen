package com.dianping.daogen.java.model.lang;

import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Type {

    public Type() {
    }

    public Type(String typeOriginName) {
        this.typeOriginName = typeOriginName;
    }

    private String typeOriginName;

    public String getTypeFullName() {
        if (typeOriginName.contains(".")) {
            return typeOriginName;
        } else {
            return null;
        }
    }

    public String getPkg() {
        if (typeOriginName.contains(".")) {
            return typeOriginName.substring(0, typeOriginName.lastIndexOf("."));
        } else {
            return null;
        }
    }

    public String getTypeName() {
        if (typeOriginName.contains(".")) {
            return typeOriginName.substring(typeOriginName.lastIndexOf(".")+1);
        } else {
            return typeOriginName;
        }
    }

    public static Type INT = new Type(Integer.TYPE.getName());

    public static Type LONG = new Type(Long.TYPE.getName());

    public static Type DATE = new Type(java.util.Date.class.getName());

    public static Type STRING = new Type(String.class.getName());

    public static Type VOID = new Type("void");
}
