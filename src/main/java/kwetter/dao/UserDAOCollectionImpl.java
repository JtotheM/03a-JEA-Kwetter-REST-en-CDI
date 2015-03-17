package kwetter.dao;

import kwetter.domain.User;

import java.util.List;

public class UserDAOCollectionImpl implements UserDAO {

    private DataStorageBean dsb = new DataStorageBean();

    public UserDAOCollectionImpl() {
    }

    @Override
    public int count() {
        return dsb.count();
    }

    @Override
    public void create(User user) {
        dsb.create(user);
    }

    @Override
    public void edit(User user) {
        dsb.edit(user);
    }

    @Override
    public List<User> findAll() {
        return dsb.findAll();
    }

    @Override
    public void remove(User user) {
        dsb.remove(user);
    }

    @Override
    public User find(String name) {
        return dsb.find(name);
    }
}
