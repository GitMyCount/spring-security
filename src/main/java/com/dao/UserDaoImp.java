package com.dao;

import com.entity.Role;
import com.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return getEntityManager()
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return getEntityManager().find(User.class, id);
    }

    @Override
    public void edit(User user) {
        getEntityManager().merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = getEntityManager().find(User.class, id);
        getEntityManager().remove(user);
    }

    @Override
    public User getUserByName(String username) {
        return getEntityManager()
                .createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();

    }

    @Override
    public Role getRoleByName(String name) {
        return getEntityManager()
                .createQuery("SELECT r FROM Role r WHERE r.role= :name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
