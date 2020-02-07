package drools.component;

import drools.utils.KieUtils;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Created by neo on 17/7/31.
 */

@Component
public class ReloadDroolsRules {


    private String loadRules() {
        // 从数据库加载的规则
        return "package plausibcheck.adress\n\n rule \"Postcode 6 numbers\"\n\n    when\n  then\n        System.out.println(\"规则2中打印日志：校验通过!\");\n end";
    }


    public void reloadByHelper() throws UnsupportedEncodingException {
        // 通过 KieHelper加载规则文件
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(loadRules(),ResourceType.DRL);
        // 验证规则文件是否语法错误
        Results results = kieHelper.verify();
        if (results.hasMessages(Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new IllegalStateException("### errors ###");
        }
        // 加载规则文件后生成KieContainer
        KieContainer kieContainer = kieHelper.getKieContainer();
        // 替换正在使用的KieContainer
        KieUtils.setKieContainer(kieContainer);
        System.out.println("新规则重载成功");
    }

}
