package com.chatserver.server;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

@RestController
class AccountController {

    private final AccountRepository repository;
    final static ObjectMapper mapper = new ObjectMapper();
    private static final AccountAssembler assembler = new AccountAssembler();

    AccountController(AccountRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/account")
    List<Account> all() {
        return repository.findAll();
    }

    @GetMapping(value="/login/{login}/{password}", produces="application/json")

    public EntityModel<Account> loginAccount(@Validated @NonNull @PathVariable String login,@Validated @NonNull @PathVariable String password){
        List<Account> tmpList = repository.findAll();

        for(Account a:tmpList){
            if(a.getLogin().equals(login)&&a.getPassword().equals(password)) {
                return assembler.toModel(a) ;
            }
        }
        return assembler.toModel(null);

    }

    @PostMapping("register/{name}/{surname}/{login}/{password}")
    Account registerAccount(@NonNull @PathVariable String name,@NonNull @PathVariable String surname,@NonNull @PathVariable String login,@NonNull @PathVariable String password ){
        Account newAccount = new Account(name,surname,login,password);
        repository.save(newAccount);
        return newAccount;
    }

    @GetMapping("connect/{login}")
    public EntityModel<Account> connect(@NonNull @PathVariable String login){
        List<Account> tmpList = repository.findAll();
        for (Account a:tmpList) {
            if(a.getLogin().equals(login))
                return assembler.toModel(a);
        }
        return  assembler.toModel(null);
    }
    @PutMapping("/updateLogin/{id}/{data}")
    public EntityModel<Account> updateLogin(@NonNull @PathVariable Long id,@NonNull @PathVariable String data){
        List<Account> newList = repository.findAll();
        Account tmp = new Account();
        for (Account a:newList) {
            if(a.getId()==id)
                tmp = a;
        }
        tmp.setLogin(data);
        repository.deleteById(id);
        repository.save(tmp);
        return assembler.toModel(tmp);
    }

    @PutMapping("/updatePassword/{id}/{data}")
    public EntityModel<Account> updatePassword(@NonNull @PathVariable Long id,@NonNull @PathVariable String data){
        List<Account> newList = repository.findAll();
        Account tmp = new Account();
        for (Account a:newList) {
            if(a.getId()==id)
                tmp = a;
        }
        tmp.setPassword(data);
        repository.deleteById(id);
        repository.save(tmp);
        return assembler.toModel(tmp);
    }

    @PutMapping("/updateName/{id}/{data}")
    public EntityModel<Account> updateName(@NonNull @PathVariable Long id,@NonNull @PathVariable String data){
        List<Account> newList = repository.findAll();
        Account tmp = new Account();
        for (Account a:newList) {
            if(a.getId()==id)
                tmp = a;
        }
        tmp.setName(data);
        repository.deleteById(id);
        repository.save(tmp);
        return assembler.toModel(tmp);
    }

    @PutMapping("/updateSurname/{id}/{data}")
    public EntityModel<Account> updateSurname(@NonNull @PathVariable Long id,@NonNull @PathVariable String data){
        List<Account> newList = repository.findAll();
        Account tmp = new Account();
        for (Account a:newList) {
            if(a.getId()==id)
                tmp = a;
        }
        tmp.setSurname(data);
        repository.deleteById(id);
        repository.save(tmp);
        return assembler.toModel(tmp);
    }
    
    @DeleteMapping("/delete/{id}")
    public EntityModel<Account> deleteAccount(@NonNull @PathVariable Long id){
        repository.deleteById(id);
        return assembler.toModel(new Account());
    }

}