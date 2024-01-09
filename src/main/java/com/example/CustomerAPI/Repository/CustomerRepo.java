package com.example.CustomerAPI.Repository;

import com.example.CustomerAPI.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.email =:email")
    Customer findCustomerByEmail(String email);

}
