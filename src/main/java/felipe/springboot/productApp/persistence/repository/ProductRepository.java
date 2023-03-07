package felipe.springboot.productApp.persistence.repository;

import felipe.springboot.productApp.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findProductByAndDeleted(Long id, Boolean deleted);

}
