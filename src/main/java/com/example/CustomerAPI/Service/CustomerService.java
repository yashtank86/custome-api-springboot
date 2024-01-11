package com.example.CustomerAPI.Service;

import com.example.CustomerAPI.Model.Customer;
import com.example.CustomerAPI.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer saveCustomer(Customer savedCustomer){

        Customer customer = new Customer();
        customer.setFirst_name(savedCustomer.getFirst_name());
        customer.setLast_name(savedCustomer.getLast_name());
        customer.setEmail(savedCustomer.getEmail());
        customer.setPhoneNumber(savedCustomer.getPhoneNumber());
        return customerRepo.save(savedCustomer);
    }


    public Optional<Customer> getCustomerByEmail(String email){
        Customer customer = customerRepo.findCustomerByEmail(email);
        return Optional.ofNullable(customer);
    }


}
