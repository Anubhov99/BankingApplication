package com.capgemini.discover.banking.controller;

import com.capgemini.discover.banking.eo.Customer;
import com.capgemini.discover.banking.exceptions.CustomerIdException;
import com.capgemini.discover.banking.exceptions.ValidateCustomerException;
import com.capgemini.discover.banking.service.ICustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    ICustomerServiceImpl customerService;

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody Customer customer) throws ValidateCustomerException
    {
        Customer customer1= customerService.addCustomer(customer);
        return customer1;
    }

    @GetMapping("/getallcustomer")
    public List<Customer> viewCustomer() throws CustomerIdException
    {
        return customerService.viewAllCustomers();
    }
}
