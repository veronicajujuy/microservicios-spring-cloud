package com.digitalhouse.checkout.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalhouse.checkout.model.Checkout;
import com.digitalhouse.checkout.service.ICheckoutService;

@RestController
@RequestMapping(value ="/checkout")
public class CheckoutRestController {
	private ICheckoutService checkoutService;
	
	
	
	public CheckoutRestController(ICheckoutService checkoutService) {
		super();
		this.checkoutService = checkoutService;
	}



	@GetMapping()
	public Checkout getCheckout(@RequestParam List<String> productIds) {
		
		return checkoutService.buildCheckout(productIds);
		
	}

}
