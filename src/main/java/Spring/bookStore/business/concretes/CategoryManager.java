package Spring.bookStore.business.concretes;

import Spring.bookStore.business.abstracts.CategoryService;
import Spring.bookStore.core.utilities.results.DataResult;
import Spring.bookStore.core.utilities.results.SuccessDataResult;
import Spring.bookStore.dataAccess.abstracts.CategoryDao;
import Spring.bookStore.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public DataResult<List<Category>> getAllCategory() {
        return new SuccessDataResult<List<Category>>
                (this.categoryDao.findAll(),"Kategoriler Listelendi");
    }

    @Override
    public DataResult<List<Category>> findById(int categoryId) {
        return new SuccessDataResult<List<Category>>
                (this.categoryDao.findById(categoryId),"Kategoriler Listelendi");
    }
}
