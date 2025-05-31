package com.digitalhouse.checkout.configuration;

import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;

import org.springframework.core.env.Environment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;

public class LoadBalancerConfiguration {
	
	 @Bean
	    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
	            LoadBalancerClientFactory loadBalancerClientFactory) {
	        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
	        return new RandomLoadBalancer(loadBalancerClientFactory
	                .getLazyProvider(name, ServiceInstanceListSupplier.class),
	                name);
	    }

}
