package HomeworkLesson6.repository;

import HomeworkLesson6.entity.Product;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProductRepository {

    private final SessionFactory sessionFactory;

    @Transactional
    public Product save(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
        return product;
    }

    @Transactional
    public Product edit(Product product) {
        sessionFactory.getCurrentSession().update(product);
        return product;
    }

    @Transactional
    public Optional<Product> findById(Integer id) {

        Product product = (Product) sessionFactory.getCurrentSession().getNamedQuery("Product.findById")
                .setParameter("id", id).getSingleResult();
        return Optional.of(product);
    }

    @Transactional
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession().getNamedQuery("Product.findAll").getResultList();
    }

    @Transactional
    public void deleteById(Integer id) {
        sessionFactory.getCurrentSession().getNamedQuery("Product.deleteById").setParameter("id", id);
    }
}