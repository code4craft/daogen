package ${model.type.pkg};

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
public class ${model.type.name} {

<#list model.fields as field>
    <#if field.column.comment?exists>
    /**
    * ${field.column.comment}
    */
    </#if>
    private ${field.type.name} ${field.name};

</#list>
}