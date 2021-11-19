package com.vincent.consumerapplication;

public class Rule {
    private Long id;
    private String result;

    public Rule(Long id, String result) {
        this.id = id;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public String getResult() {
        return result;
    }
}
