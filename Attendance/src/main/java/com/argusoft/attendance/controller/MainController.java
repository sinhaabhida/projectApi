/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.controller;

import com.argusoft.attendance.model.Attendance;
import com.argusoft.attendance.model.Department;
import com.argusoft.attendance.model.Employee;
import com.argusoft.attendance.service.AttendanceService;
import com.argusoft.attendance.service.DepartmentService;
import com.argusoft.attendance.service.EmployeeService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mohil
 */
@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String indexPage(ModelMap modelMap) {
        return "index";
    }

    @RequestMapping(value = {"viewEmployee"}, method = RequestMethod.GET)
    public String viewEmployeePage(ModelMap modelMap,
            @RequestParam(name = "ename", defaultValue = "") String employeeName) {
        if (employeeName.equals("")) {
            modelMap.addAttribute("employees", employeeService.getEmployees());
        } else {
            modelMap.addAttribute("employees",
                    employeeService.getEmployeesByName(employeeName));
        }

        return "viewEmployee";
    }

    @RequestMapping(value = {"editEmployee"}, method = RequestMethod.GET)
    public ModelAndView editEmployeePage(@RequestParam("id") int id) {

        return new ModelAndView("editEmployee", "command",
                employeeService.getEmployeeById(id));
    }

    @RequestMapping(value = {"editEmployeeDB"}, method = RequestMethod.POST)
    public String editEmployeeDB(@ModelAttribute Employee employee) {
        if (employee.getId() == -1) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return "redirect:viewEmployee";
    }

    @RequestMapping(value = {"addEmployee"}, method = RequestMethod.GET)
    public ModelAndView addEmployeePage() {

        return new ModelAndView("editEmployee", "command",
                new Employee());
    }

    @RequestMapping(value = {"deleteEmployee"}, method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:viewEmployee";
    }

    @RequestMapping(value = {"viewDepartment"}, method = RequestMethod.GET)
    public String viewDepartmentPage(ModelMap modelMap) {
        modelMap.addAttribute("departments", departmentService.getDepartments());
        return "viewDepartment";
    }

    @RequestMapping(value = {"editDepartment"}, method = RequestMethod.GET)
    public ModelAndView editDepartmentPage(@RequestParam("id") int id) {

        return new ModelAndView("editDepartment", "command",
                departmentService.getDepartmentById(id));
    }

    @RequestMapping(value = {"editDepartmentDB"}, method = RequestMethod.POST)
    public String editDepartmentDB(@ModelAttribute Department department) {
        if (department.getId() == -1) {
            departmentService.addDepartment(department);
        } else {
            departmentService.updateDepartment(department);
        }
        return "redirect:viewDepartment";
    }

    @RequestMapping(value = {"addDepartment"}, method = RequestMethod.GET)
    public ModelAndView addDepartmentPage() {

        return new ModelAndView("editDepartment", "command",
                new Department());
    }

    @RequestMapping(value = {"deleteDepartment"}, method = RequestMethod.GET)
    public String deleteDepartment(@RequestParam("id") int id) {
        departmentService.deleteDepartment(id);
        return "redirect:viewDepartment";
    }

    @RequestMapping(value = {"viewAttendance"}, method = RequestMethod.GET)
    public String viewAttendancePage(ModelMap modelMap,
            @RequestParam(name = "id") int employeeId,
            @RequestParam(name = "month", defaultValue = "-1") int month) {
        if(month == -1) {
            modelMap.addAttribute("attendances",
                attendanceService.getAttendanceByEmployeeId(employeeId));
        } else {
            modelMap.addAttribute("attendances",
                attendanceService.getAttendanceByMonth(employeeId, month));
        }
        
        return "viewAttendance";
    }
    
    @RequestMapping(value = {"addAttendance"}, method = RequestMethod.GET)
    public String addAttendance(ModelMap modelMap,
            @RequestParam(name = "id") int employeeId,
            @RequestParam(name = "date") String date) {
        
        String[] dateNums = date.split("-");
        Date d = new Date(Integer.parseInt(dateNums[0]) - 1900,
                Integer.parseInt(dateNums[1]) - 1,
                Integer.parseInt(dateNums[2]));
        
        attendanceService.addAttendance(new Attendance(employeeId, d));
        modelMap.addAttribute("attendances",
                attendanceService.getAttendanceByEmployeeId(employeeId));
        
        return "viewAttendance";
    }
}
