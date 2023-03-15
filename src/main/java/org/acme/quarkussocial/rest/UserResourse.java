package org.acme.quarkussocial.rest;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.acme.domain.model.UserEntity;
import org.acme.domain.repository.UserRepository;
import org.acme.dto.CreateUserRequestDTO;
import org.acme.dto.ResponseError;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResourse {

    private UserRepository repository;
    private Validator validator;

    @Inject
    public UserResourse(UserRepository repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @POST
    @Transactional
    public Response createUser(CreateUserRequestDTO userRequestDTO) {
        Set<ConstraintViolation<CreateUserRequestDTO>> violations = validator.validate(userRequestDTO);
        if (!violations.isEmpty()) {
            return ResponseError.createFromValidator(violations).withStatusCode(ResponseError.UNPROCESSABLE_ENTITY_STATUS);
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setNome(userRequestDTO.getNome());
        userEntity.setIdade(userRequestDTO.getIdade());

        repository.persist(userEntity);

        return Response
                .status(Response.Status.CREATED.getStatusCode())
                .entity(userEntity)
                .build();
    }

    @GET
    public Response listAllUsers() {
        PanacheQuery<UserEntity> query = repository.findAll();
        return Response.ok(query.list()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response removeUser(@PathParam("id") Long id) {
        UserEntity user = repository.findById(id);

        if (user != null) {
            repository.delete(user);
            return Response.noContent().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long id, CreateUserRequestDTO userData) {
        UserEntity user = repository.findById(id);

        if (user != null) {
            user.setIdade(userData.getIdade());
            user.setNome(userData.getNome());
            return Response.noContent().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
