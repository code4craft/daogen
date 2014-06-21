package com.dianping.daogen.utils;

import com.dianping.daogen.model.java.Field;
import org.junit.Test;

/**
 * @author code4crafer@gmail.com
 */
public class ObjectTraversalTest {

    @Test
    public void testTraverse() throws Exception {
        Field field = new Field("name", "typeName", null);
        ObjectTraversal objectTraversal = new ObjectTraversal(new ObjectVisitor() {
            @Override
            public void visit(Object object) {
                System.out.println("Value:"+object);
            }
        });
        objectTraversal.traverse(field);
    }
}
