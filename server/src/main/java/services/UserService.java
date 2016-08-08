package services;

import java.util.List;

import entities.User;

/**
 * Created by galloisg on 26/07/2016.
 */
public interface UserService {

   List<User> findAll();

   User create(User u);
}