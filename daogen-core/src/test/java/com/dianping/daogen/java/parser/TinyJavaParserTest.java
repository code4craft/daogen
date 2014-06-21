package com.dianping.daogen.java.parser;

import com.dianping.daogen.java.model.lang.statics.BlockList;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author code4crafer@gmail.com
 */
public class TinyJavaParserTest {

    private String java;

    @Before
    public void setUp() throws Exception {
        java = IOUtils.toString(TinyJavaParser.class.getClassLoader().getResourceAsStream("Block.java.test"));
    }

    @Test
    public void testParse() throws Exception {
        TinyJavaParser tinyJavaParser = new TinyJavaParser();
        tinyJavaParser.setSourceCode(new TokenQueue(java));
        BlockList parse = tinyJavaParser.parse();
        System.out.println(parse);
    }
}
