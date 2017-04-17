package com.mitrais.trainee;

import org.springframework.stereotype.Component;


@Component
public class Employee{
    private String name;
    private String gender;
    private String privilage;
    
    public Employee( String name, String gender, String privilage){

        this.name = name;
        this.gender = gender;
        this.privilage = privilage;
    }

    public Employee(){
        
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