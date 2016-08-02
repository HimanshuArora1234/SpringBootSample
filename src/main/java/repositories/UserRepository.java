package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.User;

/**
 * Created by galloisg on 26/07/2016.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}