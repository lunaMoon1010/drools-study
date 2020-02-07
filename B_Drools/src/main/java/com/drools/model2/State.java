package com.drools.model2;

import java.util.ArrayList;
import java.util.List;

public class State {
    private List<String> nodeList = new ArrayList<>();

    public List<String> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<String> nodeList) {
        this.nodeList = nodeList;
    }
}
