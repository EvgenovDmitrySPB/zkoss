package com.leo.zkozz.model.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Form {

    LLC("ООО"),
    IE("ИП"),
    JSC("АО");

    private String name;

    Form(String name) {
        this.name = name;
    }
}
