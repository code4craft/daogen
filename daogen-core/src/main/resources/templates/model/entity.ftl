package ${entity.pkg};

import lombok.Data;

/**
*
* Create by daogen http://code.dianpingoa.com/yihua.huang/daogen/<#if table.comment?exists>
*
* ${table.comment}</#if>
*
* @author yihua.huang@dianping.com
*/
@Data
public class ${entity.typeName} {

<#list model.fields as field>
    <#if field.column.comment?exists>
    /**
    * ${field.column.comment}
    */
    </#if>
    private ${field.typeName} ${field.name};

</#list>
}