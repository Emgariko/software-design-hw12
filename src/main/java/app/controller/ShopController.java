package app.controller;

import app.controller.dto.ProductDto;
import app.domain.Product;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/shop")
public interface ShopController {
    @PostMapping
    Mono<Product> addProduct(@RequestBody ProductDto product);

    @GetMapping("/{userId}")
    Flux<Product> getProducts(@PathVariable("userId") String userId);
}
