package com.chatserver.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class MessageController {
    private final MessageRepository repository;
    final static ObjectMapper mapper = new ObjectMapper();
    private static final AccountAssembler assembler = new AccountAssembler();
    MessageController(MessageRepository repository){
        this.repository=repository;
    }

    @PostMapping("/send/{text}/{srcId}/{dstId}")
    public Message sendMessage(@NonNull @PathVariable String text,@NonNull @PathVariable Long srcId,@NonNull @PathVariable Long dstId){
        Message newMessage = new Message(text,srcId,dstId);
        System.out.println(text);
        repository.save(newMessage);
        return newMessage;
    }
    @GetMapping("/getMessages/{srcId}/{dstId}")
    public List<Message> getMessages(@NonNull @PathVariable Long srcId,@NonNull @PathVariable Long dstId){
        List<Message> allMessages = repository.findAll();
        List<Message> tmpMessages = new ArrayList<>();
        for (Message m:allMessages) {
            if((m.getDstId().equals(dstId)&&m.getSrcId().equals(srcId))||(m.getDstId().equals(srcId)&&m.getSrcId().equals(dstId))){
                tmpMessages.add(m);
            }
        }
        return tmpMessages;
    }
    @GetMapping("/getMessages")
    public List<Message> allMessages(){
        List<Message> allMessages = repository.findAll();

        return allMessages;
    }
    

}
