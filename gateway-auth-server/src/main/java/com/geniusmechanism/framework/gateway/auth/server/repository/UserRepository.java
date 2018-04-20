package com.geniusmechanism.framework.gateway.auth.server.repository;

import com.geniusmechanism.framework.gateway.auth.server.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
//    List<User> findAllUsers();
}
