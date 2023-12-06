package com.infosupport.jwt;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Stateless
public class UserRepository {
    @PersistenceContext(unitName = "movies")
    EntityManager em;

    public Collection<User> getAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User get(UUID id) {
        return em.find(User.class, id);
    }

    public void add(String username, String password, Set<String> roles) {
        em.persist(new User(username, password, roles));
    }

    public void delete(UUID id) {
        em.remove(get(id));
    }

    public UserDto findByUsernameAndPassword(String username, String password) {
        return UserDto.fromEntity(em.createQuery(
                        """
                        SELECT u 
                        FROM User u 
                        WHERE u.username = :username AND u.password = :password
                        """, User.class)
                .setParameter("username", username)
                .setParameter("password", PasswordUtil.digest(password))
                .getSingleResult());
    }
}
