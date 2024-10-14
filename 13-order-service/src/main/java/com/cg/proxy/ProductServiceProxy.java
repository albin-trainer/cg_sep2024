package com.cg.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cg.entity.Order;
@FeignClient("product-catalougue")
public interface ProductServiceProxy { //Lets Assume this interface done by diff Person
	@GetMapping("/products/{pid}")
Order orderProduct(@PathVariable("pid")  int pid );
}
