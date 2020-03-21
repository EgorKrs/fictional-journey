package com.loneliness.repository;


import com.loneliness.entity.User;


import java.util.Optional;

public interface UserDetailsRepo  {
    Optional<User> findById(String s);
}
