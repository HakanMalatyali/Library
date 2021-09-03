package Spring.bookStore.dataAccess.abstracts;


import Spring.bookStore.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    List<Category> findById(int categoryId);
}
