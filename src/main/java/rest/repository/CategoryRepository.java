package rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

}
