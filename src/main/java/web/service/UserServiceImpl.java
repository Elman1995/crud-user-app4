package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    public List<User> getUser() {
        return userDAO.getUser();
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(Long id, User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    public void delete(Long id) {
        userDAO.delete(id);
    }

}
