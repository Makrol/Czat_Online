package com.chatserver.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
class AccountController {

    private final EmployeeRepository repository;

    AccountController(EmployeeRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/account")
    List<Account> all() {
        return repository.findAll();
    }
    @GetMapping("/login/{login}/{password}")
    @ResponseBody
    List<Account> loginAccount(@NonNull @PathVariable String login,@NonNull @PathVariable String password){
        List<Account> tmpList = repository.findAll();
        for(Account a:tmpList){
            if(a.getLogin().equals(login)&&a.getPassword().equals(password)) {
                ArrayList<Account> tmpAccount = new ArrayList<>();
                tmpAccount.add(a);
                return tmpAccount ;
            }
        }
        throw new AccountNotFoundException(login,password);
    }
    @PostMapping("register/{name}/{surname}/{login}/{password}")
    Account registerAccount(@NonNull @PathVariable String name,@NonNull @PathVariable String surname,@NonNull @PathVariable String login,@NonNull @PathVariable String password ){
        Account newAccount = new Account(name,surname,login,password);
        repository.save(newAccount);
        return newAccount;
    }
    // end::get-aggregate-root[]
/*
    @PostMapping("/employees")
    Account newEmployee(@RequestBody Account newAccount) {
        return repository.save(newAccount);
    }

    // Single item

    @GetMapping("/employees/{id}")
    Account one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Account replaceEmployee(@RequestBody Account newAccount, @PathVariable Long id) {

        return repository.findById(id)
                .map(account -> {
                    account.setName(newAccount.getName());
                    account.setSurname(newAccount.getSurname());
                    return repository.save(account);
                })
                .orElseGet(() -> {
                    newAccount.setId(id);
                    return repository.save(newAccount);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }*/
}