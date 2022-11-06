package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;


@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> getUser() {
        List<User> user = entityManager.createQuery("SELECT c FROM User c").getResultList();
        return user;
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        Query query = entityManager.createQuery("select user from User user where user.id = :id");
        query.setParameter("id", id);
        List<User> user = query.getResultList();
        if (!isEmpty(user)) {
            return user.get(0);
        }
        return null;
    }

    @Transactional()
    public void save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        System.out.println("Contact saved with id: " + user.getId());
    }

    @Transactional()
    public void update(Long id, User updatedUser) {
        Query query = entityManager.createQuery("UPDATE User user SET user.firstName = :firstName, user.lastName = :lastName, user.email = :email WHERE user.id = :id");
        query.setParameter("id", id);
        query.setParameter("firstName", updatedUser.getFirstName());
        query.setParameter("lastName", updatedUser.getLastName());
        query.setParameter("email", updatedUser.getEmail());
        query.executeUpdate();
    }

    @Transactional()
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM User user WHERE user.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
