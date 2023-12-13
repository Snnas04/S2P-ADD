package cat.paucasesnovescifp.spaad.dao;

import cat.paucasesnovescifp.spaad.jpa.entitats.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
}
