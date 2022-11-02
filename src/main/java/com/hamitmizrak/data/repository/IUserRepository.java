package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {

    //delivered query
    //Not: @Query gelişmiş sorgular için kullanıyoruz.
   Optional<UserEntity> findByUsername(String username);
}

