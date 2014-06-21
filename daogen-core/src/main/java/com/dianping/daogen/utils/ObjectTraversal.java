package com.dianping.daogen.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 遍历一个对象的工具<br/>
 * 策略：递归遍历所有字段，采取不同策略：            <br/>
 * <p/>
 * 1. 对于基本类型以及JDK默认类型，不遍历其字段<br/>
 * 2. 对于Iterable类型的字段，迭代内容进行遍历<br/>
 * 3. 对于Map类型的字段，对key-value分别进行遍历<br/>
 *
 * @author code4crafer@gmail.com
 */
public class ObjectTraversal {

    private List<ObjectVisitor> objectVisitors;

    public ObjectTraversal(ObjectVisitor... visitors) {
        objectVisitors = new ArrayList<ObjectVisitor>();
        for (ObjectVisitor visitor : visitors) {
            objectVisitors.add(visitor);
        }
    }

    private Set<Object> visitedObjects = new HashSet<Object>();

    /**
     * @param name   key
     * @param object
     */
    public void traverse(String name, Object object) {
        for (ObjectVisitor objectVisitor : objectVisitors) {
            objectVisitor.visit(name, object);
        }
        if (!visitedObjects.add(object)) {
            return;
        }
        if (object instanceof Iterable) {
            int index = 0;
            for (Object subObject : (Iterable) object) {
                traverse(String.format("%s[%d]", name, index), subObject);
            }
        } else if (object instanceof Map) {
            Set<Map.Entry> entrySet = ((Map) object).entrySet();
            int index = 0;
            for (Map.Entry entry : entrySet) {
                traverse(String.format("%s[k][%d]", name, index), entry.getKey());
                traverse(String.format("%s[v][%d]", name, index), entry.getValue());
                index++;
            }
        } else if (object.getClass().getName().startsWith("java")
                || object.getClass().getName().startsWith("javax")
                || !object.getClass().getName().contains(".")) {
            //stop
        } else {
            List<Field> declaredFields = getDeclaredFieldsIncludeParentExcludeJdk(object.getClass());
            for (Field declaredField : declaredFields) {
                try {
                    if (!Modifier.isStatic(declaredField.getModifiers())) {
                        Object field = declaredField.get(object);
                        if (field != null) {
                            traverse(declaredField.getName(), field);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Field> getDeclaredFieldsIncludeParentExcludeJdk(Class clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        List<Field> fields = new ArrayList<Field>();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            fields.add(declaredField);
        }
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            if (superclass.getName().startsWith("java")
                    || superclass.getName().startsWith("javax")
                    || !superclass.getName().contains(".")) {
                //stop
            } else {
                fields.addAll(getDeclaredFieldsIncludeParentExcludeJdk(superclass));
            }
        }
        return fields;
    }

}
