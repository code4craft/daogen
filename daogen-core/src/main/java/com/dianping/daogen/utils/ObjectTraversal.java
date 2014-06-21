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

    public void traverse(Object object) {
        for (ObjectVisitor objectVisitor : objectVisitors) {
            objectVisitor.visit(object);
        }
        if (!visitedObjects.add(object)) {
            return;
        }
        if (object instanceof Iterable) {
            for (Object subObject : (Iterable) object) {
                traverse(subObject);
            }
        } else if (object instanceof Map) {
            Set<Map.Entry> entrySet = ((Map) object).entrySet();
            for (Map.Entry entry : entrySet) {
                traverse(entry.getKey());
                traverse(entry.getValue());
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
                            traverse(field);
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
