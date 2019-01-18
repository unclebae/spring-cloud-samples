package kido.example.customerservice.rest;

import kido.example.customerservice.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    private List<Customer> customers;

    public CustomerController() {
        customers = new LinkedList<>();
        customers.add(new Customer(1, "Peter", "Test1"));
        customers.add(new Customer(2, "Peter", "Test2"));
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
    public Customer getCustomer(@PathVariable int id) {
        Optional<Customer> customer = customers.stream().filter(customer1 -> customer1.getId() == id).findFirst();

        return customer.get();
    }

    @RequestMapping(value = "/customer/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getCustomerUser(@PathVariable String id) {
        final String resultData = restTemplate.exchange("http://user-service/users/{id}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }, id).getBody();

        return resultData;
    }

}
