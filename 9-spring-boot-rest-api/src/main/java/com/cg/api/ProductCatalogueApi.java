package com.cg.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductCatalogueApi {
@GetMapping( value = "/test", produces = "text/html")
	public String test() {
		return "<font color=blue size=5> Hello Good evening</font>";
	}
}
