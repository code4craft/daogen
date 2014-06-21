<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE sqlMap PUBLIC "-//ibatis.apache.org//DTD SQL Map 2.0//EN" "http://ibatis.apache.org/dtd/sql-map-2.dtd">

<!--Create by daogen http://code.dianpingoa.com/yihua.huang/daogen/-->
<!--@author yihua.huang@dianping.com-->
<sqlMap namespace="${model.name}">

    <resultMap id="${model.name?uncap_first}" class="${entity.typeFullName}">
        <#list model.fields as field>
            <result column="${field.column.name}" property="${field.name}"/>
        </#list>
    </resultMap>

<#list dao.methods as method>
    <#if method.type=="INSERT">
    <insert id="${method.name}" parameterClass="map">
        INSERT INTO ${table.name}
        (<#list model.fields as field>`${mappings.fieldColumnMap[field.name].name}`<#if (field_index+1) < model.fields?size>,</#if></#list>)
        VALUES
        (<#list model.fields as field>#${method.params[0].name}.${field.name}#<#if (field_index+1) < model.fields?size>,</#if></#list>);
    </insert>

    </#if>
    <#if method.name=="findByStartId">
    <select id="${method.name}" resultMap="${model.name?uncap_first}" parameterClass="map">
        SELECT <#list model.fields as field>`${mappings.fieldColumnMap[field.name].name}`<#if (field_index+1) < model.fields?size>,</#if></#list>
        FROM ${table.name}
        WHERE `${method.params[0].column.name}` > #${method.params[0].name}#
        ORDER By `${method.params[0].column.name}` ASC
        LIMIT ${method.limit};
    </select>

    <#elseif method.type=="LOAD" || method.type=="QUERY">
    <select id="${method.name}" resultMap="${model.name?uncap_first}" parameterClass="map">
        SELECT <#list model.fields as field>`${mappings.fieldColumnMap[field.name].name}`<#if (field_index+1) < model.fields?size>,</#if></#list>
        FROM ${table.name}
        WHERE <#list method.params as param><#if param.condition><#if param.multi>`${param.column.name}` in
        <iterate property="${param.name}" open="(" close=")" conjunction=",">
            #${param.name}[]#
        </iterate><#else>`${param.column.name}`=#${param.name}#</#if><#if (param_index+1) < method.params?size> AND </#if></#if></#list>;
    </select>

    </#if>
</#list>

</sqlMap>