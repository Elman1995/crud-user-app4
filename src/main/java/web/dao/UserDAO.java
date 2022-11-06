package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUser();

    public User getUser(Long id);

    public void save(User user);

    public void update(Long id, User updatedUser);

    public void delete(Long id);

}
