package felipe.springboot.productApp.domain.service;

import felipe.springboot.productApp.common.dto.ProductDto;
import felipe.springboot.productApp.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    Product findProductById(Long id);

    Product createProduct(ProductDto productDto);

    Product updateProduct(ProductDto productDto);

    Product updateProductPriceById(Long id, BigDecimal price);

    void disableProductById(Long id);
}
