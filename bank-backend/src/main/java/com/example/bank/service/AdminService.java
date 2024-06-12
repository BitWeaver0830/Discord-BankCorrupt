package com.example.bank.service;

import com.example.bank.model.EmailLog;
import com.example.bank.model.Employee;
import com.example.bank.model.Vendor;
import com.example.bank.repository.EmailLogRepository;
import com.example.bank.repository.EmployeeRepository;
import com.example.bank.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private EmailLogRepository emailLogRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public List<EmailLog> getAllEmailLogs() {
        return emailLogRepository.findAll();
    }

    public void sendEmailToVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        for (Vendor vendor : vendors) {
            String message = "Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi();
            System.out.println("Mock email sent: " + message);

            EmailLog emailLog = new EmailLog();
            emailLog.setToEmail(vendor.getEmail());
            emailLog.setMessage(message);
            emailLogRepository.save(emailLog);
        }
    }
}