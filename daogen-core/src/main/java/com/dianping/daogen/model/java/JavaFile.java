package com.dianping.daogen.model.java;

import com.dianping.daogen.import_organize.Imports;
import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class JavaFile {

    private Imports imports;

    private String pkg;

    private String clazz;
}
