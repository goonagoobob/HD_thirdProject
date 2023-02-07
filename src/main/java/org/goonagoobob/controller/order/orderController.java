package org.goonagoobob.controller.order;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/order/")
public class orderController {
   @GetMapping("/complete")
   public void orderComplete() {
      log.info("orderComplete controller");
   }
   
   @GetMapping("/cancel")
   public void orderCancel() {
	   log.info("orderCancel controller");
   }
   
   @GetMapping("/form")
   public void orderForm(Model model, Authentication authentication) {
	   log.info("orderForm controller");
	   UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	   model.addAttribute("username", userDetails.getUsername());
   }
   

}