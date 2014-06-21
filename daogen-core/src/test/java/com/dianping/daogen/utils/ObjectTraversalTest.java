package com.dianping.daogen.utils;

import com.dianping.daogen.db.model.Column;
import com.dianping.daogen.java.model.Field;
import org.junit.Test;

/**
 * @author code4crafer@gmail.com
 */
public class ObjectTraversalTest {

    @Test
    public void testTraverse() throws Exception {
        Column column = new Column("C1", "int", false, "test");
        Field field = new Field("name", "typeName");
        ObjectTraversal objectTraversal = new ObjectTraversal(new ObjectVisitor() {
            @Override
            public void visit(String name, Object object) {
                System.out.println(name + ":" + object);
            }
        });
        objectTraversal.traverse("Object", field);
    }
}
