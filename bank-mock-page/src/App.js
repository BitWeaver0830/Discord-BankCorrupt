// src/App.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
    const [employees, setEmployees] = useState([]);
    const [vendors, setVendors] = useState([]);
    const [emails, setEmails] = useState([]);

    useEffect(() => {
        fetchEmployees();
        fetchVendors();
        fetchEmails();
    }, []);

    const fetchEmployees = async () => {
        const response = await axios.get('http://localhost:8080/api/employees');
        setEmployees(response.data);
    };

    const fetchVendors = async () => {
        const response = await axios.get('http://localhost:8080/api/vendors');
        setVendors(response.data);
    };

    const fetchEmails = async () => {
        const response = await axios.get('http://localhost:8080/api/emails');
        setEmails(response.data);
    };

    const createEmployee = async () => {
        const employee = { name: 'John Doe', designation: 'Engineer', ctc: 50000, email: 'john@example.com' };
        await axios.post('http://localhost:8080/api/employees', employee);
        fetchEmployees();
    };

    const createVendor = async () => {
        const vendor = { name: 'Vendor A', email: 'vendor@example.com', upi: 'vendor@upi' };
        await axios.post('http://localhost:8080/api/vendors', vendor);
        fetchVendors();
    };

    const sendEmails = async () => {
        await axios.post('http://localhost:8080/api/send-emails');
        fetchEmails();
    };

    return (
        <div>
            <h1>Backend Test Page</h1>
            <button onClick={createEmployee}>Create Employee</button>
            <button onClick={createVendor}>Create Vendor</button>
            <button onClick={sendEmails}>Send Emails to Vendors</button>
            <h2>Employees</h2>
            <ul>
                {employees.map(emp => (
                    <li key={emp.id}>{emp.name} - {emp.designation} - {emp.ctc} - {emp.email}</li>
                ))}
            </ul>
            <h2>Vendors</h2>
            <ul>
                {vendors.map(vendor => (
                    <li key={vendor.id}>{vendor.name} - {vendor.email} - {vendor.upi}</li>
                ))}
            </ul>
            <h2>Email Logs</h2>
            <ul>
                {emails.map(email => (
                    <li key={email.id}>{email.toEmail} - {email.message}</li>
                ))}
            </ul>
        </div>
    );
}
export default App;
