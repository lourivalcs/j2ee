package com.poc.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class RepositoryManager<T> {
    @PersistenceContext(unitName = "app-poc")
    protected EntityManager em;

    public abstract void insert(T entity);

    public abstract void delete(T entity);
}
