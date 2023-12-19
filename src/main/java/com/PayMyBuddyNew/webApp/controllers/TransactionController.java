package com.PayMyBuddyNew.webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {
	
	 @GetMapping("/transaction")
	 public String getTransactionPage()
	 {
		 return "transaction";
	 }
}
