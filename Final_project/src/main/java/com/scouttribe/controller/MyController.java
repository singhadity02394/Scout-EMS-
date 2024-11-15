package com.scouttribe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scouttribe.entity.Customer;
import com.scouttribe.entity.EventProvider;
import com.scouttribe.service.AdminService;
import com.scouttribe.service.CustomerService;
import com.scouttribe.service.EventProviderService;

import org.springframework.ui.Model;


@Controller  // Use @Controller instead of @RestController
@RequestMapping("/")
public class MyController {
	
	@GetMapping("/hh")
	public String home() {
		return "home";  // Renders 'home.html' from src/main/resources/templates/
	}
	
	

    // ---------------------------A D M I N   A R E A --------------------------------------------------------------------
    
	   @Autowired
	    private AdminService adminService;
	   
    // this shows login for admin page
    @GetMapping("/admin_login")
    public String showLoginForm() {
        return "admin_login_form";
    }

    // this checks the credentials and proceeds
    @PostMapping("/login")
    public String authenticateUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        boolean isAuthenticated = adminService.authenticate(username, password);
        if (isAuthenticated) {
            model.addAttribute("message", "Login successful!");
            return "admin_dashboard";
        } else {
            model.addAttribute("message", "Invalid username or password.");
            return "admin_login_form";
        }
    }
    
    // --------------------------A D M I N    A R E A    E N D S------------------------------------------------------------------------------------
    

    
    
    
    
//    // --------------------------C U S T O M E R     A R E A ----------------------------------------------------------------------------------------
    
    @Autowired
    private CustomerService customerService;
    
    
    @GetMapping("/customer_login")
    public String customer_login() {
    	return "Customer_login" ; 
    }
//    
    @PostMapping("/customer_login")
    public String customerLogin(
            @RequestParam("username") String email,
            @RequestParam("password") String password,
            Model model) {

        boolean isAuthenticated = customerService.finddata(email, password);

        if (isAuthenticated) {
            // Redirect to customer dashboard on successful login
            return "customer_dashboard"; 
        } else {
            // Return to login page with an error message on failure
            model.addAttribute("error", "Invalid email or password");
            return "customer_login"; // Ensure your login HTML file is named "login.html"
        }
    }
//    
//    
    @GetMapping("/customer_register")
    public String customer_register() {
    	return "customer_register" ; 
    }
//    
//
//    // Handle form submission for registration
    @PostMapping("/register")
    public String registerCustomer(
            @RequestParam("name") String name, 
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("confirmPassword") String confirmedPassword) {

        // Validate if passwords match
        if (!newPassword.equals(confirmedPassword)) {
            return "error"; // Show error page if passwords do not match
        }

        // Create a new customer object with the received data
        Customer customer = new Customer(name, email, newPassword, phone);

        // Save the customer to the database using the service layer
        customerService.saveCustomer(customer);

        // Redirect to a success page (can be a login page or confirmation page)
        return "customer_register_success"; // Redirect to a page after successful registration
    }




//---------------------------C U S T O M E R   A R E A    E N D S    H E R E -------------------------------------------------------------------------------

    
    
    
    
    

// --------------------------E V E N T       P R O V I D E R         A R E A ----------------------------------------------------------------------------------------

    
    @Autowired
    private EventProviderService eventProviderService;

    @GetMapping("/event_provider_login")
    public String event_provider_login() {
    	return "event_provider_login" ; 
    }
    
    @GetMapping("/event_provider_register")
    public String event_provider_register() {
    	return "event_provider_registration"; 
    }
    
    @PostMapping("/event_register")
    public String register(@RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("event-type") String eventType,
            Model model) {
    	
        EventProvider eventProvider = new EventProvider();
        eventProvider.setName(name);
        eventProvider.setEmail(email);
        eventProvider.setPhone(phone);
        eventProvider.setAddress(address);
        eventProvider.setEventType(eventType);
        
        eventProviderService.saveEventProvider(eventProvider);
        return "event_provider_dashboard"; 
    	
    }
    
    
 //---------------------------E V E N T       P R O V I D E R         A R E A     E N D S     H E R E -------------------------------
    
}


//

