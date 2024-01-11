package com.example.CustomerAPI.Controller;

import com.example.CustomerAPI.Exception.CustomerNotFoundException;
import com.example.CustomerAPI.Model.Customer;
import com.example.CustomerAPI.Repository.CustomerRepo;
import com.example.CustomerAPI.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

   @Autowired
   private CustomerService customerService;

   @Autowired
   private CustomerRepo customerRepo;

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

   @RequestMapping(method = {PUT}, path = "/update")
   @ResponseBody
   public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,@RequestParam String email ){

      Customer updatedCustomer = customerRepo.findCustomerByEmail(email);

      updatedCustomer.setFirst_name(customer.getFirst_name());
      updatedCustomer.setLast_name(customer.getLast_name());
      updatedCustomer.setEmail(customer.getEmail());
      updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
      customerRepo.save(updatedCustomer);
      return ResponseEntity.ok(customer);
   }

   @DeleteMapping("/delete")
   public ResponseEntity<String> deleteCustomer(@RequestParam String email){

      Customer deleteCustomer = customerRepo.findCustomerByEmail(email);
     if( deleteCustomer.getEmail().equals(email)) customerRepo.delete(deleteCustomer);
     else ResponseEntity.ok("something went wrong!!");
     return ResponseEntity.ok("customer deleted successfully!!");
   }

}