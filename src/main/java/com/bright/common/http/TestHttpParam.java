package com.bright.common.http;

/**
 * @author zhengyuan
 * @since 2020/12/03
 */
public class TestHttpParam {
    private int id;
    private String name;

    public TestHttpParam(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestHttpParam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
