package com.chatserver.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AccountAssembler implements RepresentationModelAssembler<Account, EntityModel<Account>> {

    @Override
    public EntityModel<Account> toModel(Account entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(AccountController.class).loginAccount(entity.getLogin(),entity.getPassword())).withSelfRel(),
                linkTo(methodOn(AccountController.class).all()).withRel("account"));
    }

    @Override
    public CollectionModel<EntityModel<Account>> toCollectionModel(Iterable<? extends Account> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
