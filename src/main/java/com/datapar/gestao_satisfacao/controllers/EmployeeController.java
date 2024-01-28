package com.datapar.gestao_satisfacao.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.datapar.gestao_satisfacao.model.Employee;
import com.datapar.gestao_satisfacao.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //@GetMapping("/")
    //String viewHomePage(Model model) {
        //pagina principal para navegação
    //    model.addAttribute("listEmployees", employeeService.getAllEmployees());
    //    return "index";
    //}
    
    @GetMapping("/")
    String viewHomePage(Model model) {
        //pagina principal para navegação
        return findPaginated(1, model);
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //mostrar lista de employees
        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        return "new_employee";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //create model atribute to bind form data
        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") UUID id, Model model){
        //get employee from the service 
        Employee employee = employeeService.getEmployeeById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") UUID id, Model model){
        //delete employee
        employeeService.deleteEmployeeById(id); 

        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable ( value = "pageNo") int pageNo, Model model){
        int pageSize = 5;

        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
        List<Employee> listEmployees = page.getContent();
       
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listEmployees", listEmployees);

        return "index";

    }

}
