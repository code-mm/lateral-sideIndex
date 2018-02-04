package com.example.maohuawei.lateralsideindex;

public class Person {

    private String name;

    private String images;

    private String pinyin;

    private String tel;


    public Person(String name, String tel) {
        this.name = name;
        this.pinyin = PinYinUtils.getPinYin(name);
        this.tel = tel;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPinyin() {
        return pinyin;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", images='" + images + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}