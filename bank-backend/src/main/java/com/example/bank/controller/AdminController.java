package com.example.bank.controller;

import com.example.bank.model.EmailLog;
import com.example.bank.model.Employee;
import com.example.bank.model.Vendor;
import com.example.bank.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return adminService.createEmployee(employee);
    }

    @PostMapping("/vendors")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return adminService.createVendor(vendor);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return adminService.getAllEmployees();
    }

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return adminService.getAllVendors();
    }

    @GetMapping("/emails")
    public List<EmailLog> getAllEmailLogs() {
        return adminService.getAllEmailLogs();
    }

    @PostMapping("/send-emails")
    public void sendEmails() {
        adminService.sendEmailToVendors();
    }
}