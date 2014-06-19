package ${entity.pkg};

import lombok.Data;
<#if entity.imports.imports?has_content>
    <#list entity.imports.imports as imp>
import ${imp};
    </#list>
</#if>

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