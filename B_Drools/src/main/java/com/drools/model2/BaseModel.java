package com.drools.model2;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本数据模型，存放所有数据模型都有属性
 */
public class BaseModel {
    private List<String> fireRuleList = new ArrayList<>();

    public List<String> getFireRuleList() {
        return fireRuleList;
    }

    public void setFireRuleList(List<String> fireRuleList) {
        this.fireRuleList = fireRuleList;
    }
}
