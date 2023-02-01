package org.goonagoobob.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/order/")
public class orderController {
   @GetMapping("/orderComplete")
   public void orderComplete() {
      
   }
   

}