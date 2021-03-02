package com.poc.repository;

import com.poc.model.entity.UserEntity;

import javax.transaction.Transactional;

public class UserRepository extends RepositoryManager<UserEntity> {

    @Transactional
    @Override
    public void insert(UserEntity entity) {
        em.persist(entity);
    }

    @Override
    public void delete(UserEntity entity) {

    }
}
