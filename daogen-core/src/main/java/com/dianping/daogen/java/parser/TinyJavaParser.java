package com.dianping.daogen.java.parser;

import com.dianping.daogen.java.file.BlockList;
import com.dianping.daogen.java.file.JavaFile;

/**
 * 极其简单的Java解析器，只解析到方法级别<br/>
 *
 * @author code4crafer@gmail.com
 */
public class TinyJavaParser {

    private TokenQueue sourceCode;

    private JavaFile javaFile;

    public BlockList parse(){
        BlockList blockList = new BlockList();
        while (!sourceCode.isEmpty()){

        }
        return blockList;
    }

}
