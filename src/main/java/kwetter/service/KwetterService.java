package kwetter.service;

import kwetter.dao.UserDAO;
import kwetter.dao.UserDAOCollectionImpl;
import kwetter.domain.User;

import java.util.List;

public class KwetterService {
    private UserDAO userDAO = new UserDAOCollectionImpl();

    public KwetterService() {

    }

    public void create(User user) {
        userDAO.create(user);
    }

    public void edit(User user) {
        userDAO.edit(user);
    }

    public void remove(User user) {
        userDAO.remove(user);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User find(String username) {
        return userDAO.find(username);
    }

    public int count() {
        return userDAO.count();
    }
}