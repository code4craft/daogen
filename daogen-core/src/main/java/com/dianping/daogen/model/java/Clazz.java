package com.dianping.daogen.model.java;

import com.dianping.daogen.importOrganize.Imports;
import lombok.Data;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Clazz extends Type {

    private Imports imports = new Imports();

}