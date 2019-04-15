package com.example.m6.model;

public class test {
    String name;
    int  usernumber;
    chainingTest instance;

    public test(){

    }
    public test(String name, int usernumber, chainingTest instance){
        this.name = name;
        this.usernumber = usernumber;
        this.instance = instance;
    }
    public String getName(){return name;}
    public void setName(String name){
        this.name = name;
    }
    public int getUsernumber(){return usernumber;}
    public void setUsernumber(int usernumber){
        this.usernumber = usernumber;
    }

    public chainingTest getInstance() {
        return instance;
    }

    public void setInstance(chainingTest instance) {
        this.instance = instance;
    }
}
