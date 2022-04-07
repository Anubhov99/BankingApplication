package com.capgemini.discover.banking.service;

import com.capgemini.discover.banking.eo.Customer;
import com.capgemini.discover.banking.exceptions.CustomerIdException;
import com.capgemini.discover.banking.exceptions.ValidateCustomerException;

import java.util.List;

public interface ICustomerService {
public Customer addCustomer(Customer customer) throws ValidateCustomerException;
    public List<Customer> viewAllCustomers()throws CustomerIdException;


}
