package th.ac.kmitl.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.kmitl.atm.model.Customer;
import th.ac.kmitl.atm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //responsible for handle user request
    //step 1 : update model for template
    //step 2 : choose HTML template

    private CustomerService customerService;

    //@Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping //handle user request
    public String getCustomerPage(Model model) {

        //customers.add(new Customer(1,"Calra",1234));
        //customers.add(new Customer(2,"Caleruega",5678));
        //customers.add(new Customer(3,"Chistmas",9876));

        //step 1 : update model for template
        model.addAttribute("allCustomers", customerService.getCustomers());
        //step 2 : choose HTML for template
        return "customer"; //customer.html template
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";
    }



}
