package com.mitrais.trainee;

import org.springframework.stereotype.Component;


@Component
public class Employee{
    private String id;
    private String name;
    private String gender;
    private String privilage;
    
    public Employee(String id, String name, String gender, String privilage){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.privilage = privilage;
    }

    public Employee(){
        
    }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setPrivilage(String privilage){
        this.privilage = privilage;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getGender(){
        return this.gender;
    }

    public String getPrivilage(){
        return this.privilage;
    }

}