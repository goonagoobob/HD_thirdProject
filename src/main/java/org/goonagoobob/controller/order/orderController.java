package org.goonagoobob.controller.order;

import org.springframework.stereotype.Controller;
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
   public void orderForm() {
	   log.info("orderForm controller");
   }
   

}