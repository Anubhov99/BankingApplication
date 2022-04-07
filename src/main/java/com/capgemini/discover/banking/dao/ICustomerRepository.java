package com.capgemini.discover.banking.dao;

import com.capgemini.discover.banking.eo.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer,Integer> {

}
