package com.PayMyBuddyNew.webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransfertController {
	
	
	@GetMapping("/transfert")
	String getTransfertPage()
	{
		return "transfert";
	}

}
