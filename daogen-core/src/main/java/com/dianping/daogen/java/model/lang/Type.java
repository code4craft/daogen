package com.dianping.daogen.java.model.lang;

import com.dianping.daogen.utils.TypeUtils;
import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Type {

    public Type() {
    }

    public Type(String originName) {
        this.originName = originName;
    }

    private String originName;

    public String getFullName() {
        if (originName.contains(".")) {
            return originName;
        } else {
            return null;
        }
    }

    public String getPkg() {
        if (originName.contains(".")) {
            return originName.substring(0, originName.lastIndexOf("."));
        } else {
            return null;
        }
    }

    public String getName() {
        if (originName.contains(".")) {
            return originName.substring(originName.lastIndexOf(".")+1);
        } else {
            return originName;
        }
    }

    public String getSuggestValue(){
        return TypeUtils.getSuggestValue(getOriginName());
    }

    public static Type INT = new Type(Integer.TYPE.getName());

    public static Type LONG = new Type(Long.TYPE.getName());

    public static Type DATE = new Type(java.util.Date.class.getName());

    public static Type STRING = new Type(String.class.getName());

    public static Type VOID = new Type("void");
}
