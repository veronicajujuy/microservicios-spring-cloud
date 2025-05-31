package com.digitalhouse.checkout.service.implementation;

import org.springframework.stereotype.Service;

import com.digitalhouse.checkout.model.dto.Product;
import com.digitalhouse.checkout.repository.FeignProductRepository;
import com.digitalhouse.checkout.service.IProductService;

@Service
public class ProductService  implements IProductService{
	
	private FeignProductRepository feignProductRepository;
	
	public ProductService(FeignProductRepository feignProductRepository) {
		this.feignProductRepository = feignProductRepository;
	}

	@Override
	public Product getProduct(String id) {
	return feignProductRepository.getProductById(id);
	}

}
