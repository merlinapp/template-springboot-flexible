package com.merlinjobs.flexible.template.data;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.merlinjobs.flexible.template.data.interfaces.Dao;
import com.merlinjobs.flexible.template.data.models.User;

import java.util.List;

/**
 * CRUD operations for Users in DataStore
 */
public class UserDao implements Dao<User>  {

    /**
     * @param id urlSafe
     * @return list of Users
     * Return a list of Users
     */
    @Override
    public User get(String id) {
        Key<User> userKey = Key.create(id);
        return ObjectifyService.ofy().load().key(userKey).now();
    }

    /**
     * @param q quantity of records to return
     * @return list of Users
     * Return a list of Users
     */
    @Override
    public List<User> getAny(int q) {
        return ObjectifyService.ofy().load().type(User.class).limit(q).list();
    }

    /**
     * @param user of User model
     * @return user key with urlSafe format
     * Save given entity in DataStore and return the key in urlSafe format
     */
    @Override
    public String save(User user) {
        Key<User> userKey = ObjectifyService.ofy().save().entity(user).now();
        return userKey.toLegacyUrlSafe();
    }


    /**
     * @param user of User model
     * Save given entity in DataStore
     */
    @Override
    public void saveAsync(User user) {
        ObjectifyService.ofy().save().entity(user);
    }


    /**
     * @param user of User model
     * Delete given entity in DataStore
     */
    @Override
    public void delete(User user) {
        ObjectifyService.ofy().delete().entity(user).now();
    }

}
