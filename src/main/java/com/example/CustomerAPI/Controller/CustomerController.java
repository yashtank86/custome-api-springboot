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
   public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer uCustomer , @RequestParam String email){

      Customer updatedcustomer = customerRepo.findCustomerByEmail(email);

      updatedcustomer.setFirst_name(uCustomer.getFirst_name());
      updatedcustomer.setLast_name(uCustomer.getLast_name());
      updatedcustomer.setEmail(uCustomer.getEmail());
      updatedcustomer.setPhoneNumber(uCustomer.getPhoneNumber());
      customerRepo.save(updatedcustomer);
      return ResponseEntity.ok(uCustomer);
   }

   @DeleteMapping("/delete")
   public ResponseEntity<String> deleteCustomer(@RequestParam String email){

      Customer deleteCustomer = customerRepo.findCustomerByEmail(email);
      deleteCustomer.getEmail();

      return ResponseEntity.ok("customer deleted successfully!!");
   }

}
