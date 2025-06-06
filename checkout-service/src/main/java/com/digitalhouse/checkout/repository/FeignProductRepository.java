package com.digitalhouse.checkout.repository;

import com.digitalhouse.checkout.configuration.LoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalhouse.checkout.model.dto.Product;
// acá configuramos el cliente Feign para que se comunique con el servicio de productos
@FeignClient(name ="products-service")
//@LoadBalancerClient(name = "products-service", configuration = LoadBalancerConfiguration.class)
public interface FeignProductRepository {
	
	@RequestMapping(method= RequestMethod.GET,value ="/products")
	Product getProductById(@RequestParam String id);

}
