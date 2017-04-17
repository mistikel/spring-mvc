package com.mitrais.trainee;

import java.util.*;
import java.util.stream.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController
{
    private List<Employee> employees;
    public EmployeeController(){
        employees = new ArrayList<Employee>();
        employees.add(new Employee("Agus Mistiawan","Male","Jakarta"));
        employees.add(new Employee("Haifludin","Male","Jakarta"));
        employees.add(new Employee("Jacqualine","Female","Jakarta"));
    }

    @RequestMapping(value = "/employees", method=RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployee(@RequestParam String gender){
        return employees.stream().filter(c -> c.getGender().equals(gender)).collect(Collectors.toList());
    }


    @RequestMapping(value="/employees", method = RequestMethod.POST)
    @ResponseBody
    public Employee postEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return employee;
    }
}