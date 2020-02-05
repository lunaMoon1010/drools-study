package com.drools.test;

import com.drools.model.Car;
import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * Drools hello world
 */
public class DroolsHelloWorld extends BaseTest{
    @Test
    public void helloWorld(){
        // 3 根据 KieContainer 获取 KieSession
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        Car car = new Car();
        car.setDiscount(100);
        Person person = new Person();
        person.setAge(70);
        car.setPerson(person);


        Car car2 = new Car();
        car2.setDiscount(100);
        Person person2 = new Person();
        person2.setAge(50);
        car2.setPerson(person2);

        kieSession.insert(car);
        kieSession.insert(car2);

        int count = kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("击中的规则个数："+ count);

    }
}
