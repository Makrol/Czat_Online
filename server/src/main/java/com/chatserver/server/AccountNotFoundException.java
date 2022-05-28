package com.chatserver.server;

class AccountNotFoundException extends RuntimeException {

    AccountNotFoundException(Long id) {
        super("Could not find account " + id);
    }
    AccountNotFoundException(String login, String password) {
        super("Could not find account login: " + login+" password: "+password);
    }
}