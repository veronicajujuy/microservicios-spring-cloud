package com.digitalhouse.checkout.controller;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

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

	@GetMapping("/{id}")
	public Checkout getCheckoutId(@PathVariable String id){
		return new Checkout(id);
	}


	@GetMapping()
	public Checkout getCheckout(@RequestParam List<String> productIds,
								@RequestHeader("X-Request-from") String requestFrom,
								@RequestHeader() Map<String, String> headers) {
		System.out.println("Enviado desde: "+ requestFrom);
		System.out.println("Headers: " + headers);
			// Si no viene desde gateway, no se procesa la solicitud
			// Esto es para evitar que se pueda acceder directamente al servicio de checkout
			// y que solo se pueda acceder a través del gateway.
			// Si se quiere permitir el acceso directo, se puede eliminar esta validación.
		if(!requestFrom.equals("gateway")) {
				return null;
			}
			return checkoutService.buildCheckout(productIds);
	}

}
