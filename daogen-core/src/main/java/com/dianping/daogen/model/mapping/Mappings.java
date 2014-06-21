package com.dianping.daogen.model.mapping;

import com.dianping.daogen.model.db.Column;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author code4crafer@gmail.com
 */
@Data
public class Mappings {

    private Map<String,Column> fieldColumnMap = new HashMap<String, Column>();

}
