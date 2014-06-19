package com.dianping.daogen.parser;

import com.dianping.daogen.schema.db.Table;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafer@gmail.com
 */
public class MysqlCreateTableParserTest {

    private String sql = "CREATE TABLE `ME_Web` (\n" +
            "  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '',\n" +
            "  `Name` varchar(200) NOT NULL DEFAULT '' COMMENT '',\n" +
            "  `EnName` varchar(200) NOT NULL DEFAULT '' COMMENT '',\n" +
            "  `Status` int(11) NOT NULL DEFAULT '0' COMMENT '状态，为0表示不可用',\n" +
            "  `AddTime` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '添加时间',\n" +
            "  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',\n" +
            "  PRIMARY KEY (`Id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    @Test
    public void testParse() throws Exception {
        DBParser dbParser = new MysqlCreateTableParser();
        Table table = dbParser.parse(sql);
        assertThat(table.getName()).isEqualTo("ME_Web");
        assertThat(table.getColumns()).hasSize(6);
        assertThat(table.getColumns().get(0).isPrimaryKey()).isTrue();
        assertThat(table.getColumns().get(0).getType()).isEqualTo("int");
    }
}
