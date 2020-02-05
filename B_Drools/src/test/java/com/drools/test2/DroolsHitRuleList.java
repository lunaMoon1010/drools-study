package com.drools.test2;


import com.drools.model2.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 在实体类中添加击中规则的数组，保存了击中规则的信息
 */
public class DroolsHitRuleList{
    @Test
    public void hitRuleList(){
        // 1 获取 KieServices
        KieServices kieServices = KieServices.get();

        // 2 根据 KieServices 获取 KieContainer
        // kmodule.xml 默认位置由 KieModuleModelImpl 指定
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // 3 根据 KieContainer 获取 KieSession
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        Person person = new Person();
        person.setAge(99);

        kieSession.insert(person);
        int count = kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("击中的规则个数："+ count);
        System.out.println("击中的规则为："+ person.getFireRuleList());
    }
}
