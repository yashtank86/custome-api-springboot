package com.example.CustomerAPI.Controller;

import com.example.CustomerAPI.Exception.CustomerNotFoundException;
import com.example.CustomerAPI.Model.Customer;
import com.example.CustomerAPI.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

   @Autowired
   private CustomerService customerService;

   @RequestMapping(method = {POST}, path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public Customer saveCustomer(@Valid @RequestBody Customer customer){
       return customerService.saveCustomer(customer);
   }

   @RequestMapping(method = {GET}, path = "/retrieve")
   @ResponseBody
   public Customer getCustomerByEmail(@RequestParam String email){
       return customerService.getCustomerByEmail(email).orElseThrow(CustomerNotFoundException::new);
   }

}
