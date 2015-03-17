package kwetter.dao;

import kwetter.domain.User;

import java.util.List;

public interface UserDAO {
    int count();

    void create(User user);

    void edit(User user);

    List<User> findAll();

    void remove(User user);

    User find(String name);
}
