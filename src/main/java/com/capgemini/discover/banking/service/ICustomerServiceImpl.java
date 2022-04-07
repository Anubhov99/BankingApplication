package com.capgemini.discover.banking.service;

import com.capgemini.discover.banking.dao.ICustomerRepository;
import com.capgemini.discover.banking.eo.Customer;
import com.capgemini.discover.banking.exceptions.CustomerIdException;
import com.capgemini.discover.banking.exceptions.ValidateCustomerException;
import com.capgemini.discover.banking.util.bankingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerDao;

    private boolean validateCustomer(Customer customer) throws ValidateCustomerException {

        if (!customer.getFirstName().matches(bankingConstants.CUSTOMER_PATTERN))
            throw new ValidateCustomerException(bankingConstants.CUSTOMER_CANNOT_BE_EMPTY);

        if (!customer.getLastName().matches(bankingConstants.CUSTOMER_PATTERN))
            throw new ValidateCustomerException(bankingConstants.CUSTOMER_CANNOT_BE_EMPTY);

        if (!customer.getMobileNumber().matches("[1-9][0-9]{9}"))
            throw new ValidateCustomerException(bankingConstants.MOBILE_NUMBER_CANNOT_BE_EMPTY);

        return true;
    }

    @Override
    public Customer addCustomer(Customer customer) throws ValidateCustomerException {
        validateCustomer(customer);
        Customer customer1 = new Customer();
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setMobileNumber(customer.getMobileNumber());
        return customerDao.save(customer1);


    }






    @Override
    public List<Customer> viewAllCustomers() throws CustomerIdException {
        List<Customer> customerlist = (List<Customer>) customerDao.findAll();
        if (customerlist.isEmpty())
            throw new CustomerIdException(bankingConstants.CUSTOMER_NOT_FOUND);
        customerlist.sort((a1, a2) -> a1.getFirstName().compareTo(a2.getFirstName()));
        return customerlist;
    }


}
