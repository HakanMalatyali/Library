package Spring.bookStore.business.abstracts;

import Spring.bookStore.core.utilities.results.DataResult;
import Spring.bookStore.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAllCategory();
    DataResult<List<Category>> findById(int categoryId);
}
