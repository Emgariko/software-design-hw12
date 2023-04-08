package app.service;

import app.controller.ShopController;
import app.controller.dto.ProductDto;
import app.domain.Product;
import app.domain.User;
import app.repository.ProductRepository;
import app.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class ShopService implements ShopController {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ShopService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<Product> addProduct(ProductDto productDto) {
        Product product = new Product(productDto.getName(), productDto.getAmdPrice());
        return productRepository.save(product);
    }

    private Function<Product, Product> toCurrency(User.Currency currency) {
        return product -> {
            double price = product.getPrice();
            switch (currency) {
                case EUR:
                    price /= 426;
                    break;
                case USD:
                    price /= 388;
                    break;
                case RUB:
                    price /= 5;
                    break;
            }
            return new Product(product.getName(), price);
        };
    }

    @Override
    public Flux<Product> getProducts(String userId) {
        Mono<User> userMono = userRepository.findById(userId);
        Flux<Product> productFlux = productRepository.findAll();
        return userMono.flatMapMany(user -> productFlux.map(toCurrency(user.getCurrency())));
    }
}
