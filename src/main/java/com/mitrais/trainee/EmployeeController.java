package com.mitrais.trainee;

import java.util.*;
import java.util.stream.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeController
{
    private List<Employee> employees = new ArrayList<Employee>();
    public EmployeeController(){
        employees.add(new Employee("1","Agus Mistiawan","Male","Jakarta"));
        employees.add(new Employee("2","Haifludin","Male","Jakarta"));
        employees.add(new Employee("3","Jacqualine","Female","Jakarta"));
    }

    @RequestMapping(value = "/employees", method=RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployee(@RequestParam String gender){
        return employees.stream().filter(c -> c.getGender().equals(gender)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/employees/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public Employee getEmployeeById(@PathVariable String id){
        Employee response = employees.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        if(response == null){
            throw new EmployeeNotFoundException();
        }
        return response;
        
    }


    @RequestMapping(value="/employees", method = RequestMethod.POST)
    @ResponseBody
    public Employee postEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return employee;
    }
}