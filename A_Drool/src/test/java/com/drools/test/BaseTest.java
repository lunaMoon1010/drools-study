package com.drools.test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class BaseTest {
    static KieContainer kieContainer;
    static KieServices kieServices;

    @BeforeClass
    public static void beforeClass() {
        // 1 获取 KieServices
        kieServices = KieServices.get();

        // 2 根据 KieServices 获取 KieContainer
        // kmodule.xml 默认位置由 KieModuleModelImpl 指定
        kieContainer = kieServices.getKieClasspathContainer();
    }
    @Before
    public void setUp() {
        System.out.println("-----------Before-------------");
    }
    @After
    public void tearDown() {
        System.out.println("-----------After-----------");
    }
}
