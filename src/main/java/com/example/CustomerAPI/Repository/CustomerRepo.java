package com.example.CustomerAPI.Repository;

import com.example.CustomerAPI.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.email =:email")
    Customer findCustomerByEmail(String email);

  /*  @Query("SELECT c FROM Customer c WHERE c.id =:id")
    Customer findCustomerById(Integer id);

    */

}
