<bean name="${dao.typeName?uncap_first}" parent="parentDao">
    <property name="proxyInterfaces"
              value="${dao.typeFullName}" />
    <property name="target">
        <bean parent="${project.daoRealizeTarget}">
            <constructor-arg value="${model.name}" />
        </bean>
    </property>
</bean>

