package com.dianping.daogen.java.model.lang.statics;

import lombok.Data;

/**
 * 一个Java源码文件由许多块组成，每个块是一个确定的语法单元，或者一个或多个不确定的语法单元
 *
 * @author code4crafer@gmail.com
 */
@Data
public class JavaFile {

    private BlockList blockList;

}
