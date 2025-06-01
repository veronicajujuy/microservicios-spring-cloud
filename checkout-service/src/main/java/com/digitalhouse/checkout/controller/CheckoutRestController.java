package com.digitalhouse.checkout.controller;

import java.sql.SQLOutput;
import java.util.List;

import org.springframework.web.bind.annotation.*;

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
	public Checkout getCheckout(@RequestParam List<String> productIds,
								@RequestHeader("X-Request-from") String requestFrom) {
		System.out.println("Enviado desde: "+ requestFrom);
		if(!requestFrom.equals("gateway")) {
				return null;
			}
			return checkoutService.buildCheckout(productIds);
	}

}
