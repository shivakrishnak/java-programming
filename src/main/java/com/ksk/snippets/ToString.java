package com.ksk.snippets;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ToString {

    private String name;
    private String id;
    private int age;

    public ToString(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.setExcludeFieldNames("logger");
        builder.setExcludeNullValues(true);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ToString("shiva", null, 21).toString());
        System.out.println(new ToString(null, null, 21).toString());
    }
}
