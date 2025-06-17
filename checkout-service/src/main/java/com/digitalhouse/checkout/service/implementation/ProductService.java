package com.digitalhouse.checkout.service.implementation;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.digitalhouse.checkout.model.dto.Product;
import com.digitalhouse.checkout.repository.FeignProductRepository;
import com.digitalhouse.checkout.service.IProductService;

@Service
public class ProductService  implements IProductService{
	
	private FeignProductRepository feignProductRepository;
	Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	public ProductService(FeignProductRepository feignProductRepository) {
		this.feignProductRepository = feignProductRepository;
	}

	@Override
	@CircuitBreaker(name="product", fallbackMethod = "getProductFallbackMethod")
	@Retry(name = "product")
	public Product getProduct(String id) {
		logger.info("Llamando a getProduct con id: {}", id);
		return feignProductRepository.getProductById(id, false);
	}

	public Product getProductFallbackMethod(String id, Exception exception) {
		logger.error("Circuit breaker is open o error en el servicio, devolviendo producto fallback para id: {}", id, exception);
		return new Product(id, "Fallback Product", 0.0, "fallback-instance");
	}
}

