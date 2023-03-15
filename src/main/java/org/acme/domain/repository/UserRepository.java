package org.acme.domain.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.domain.model.UserEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {



}
