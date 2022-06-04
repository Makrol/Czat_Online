package com.chatserver.server;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class MessageAssembler implements RepresentationModelAssembler<Message, EntityModel<Message>> {
    @Override
    public EntityModel<Message> toModel(Message entity) {
        return EntityModel.of(entity);
    }
}
