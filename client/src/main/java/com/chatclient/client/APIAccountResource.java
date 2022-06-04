package com.chatclient.client;

import retrofit2.Call;
import retrofit2.http.*;

public interface APIAccountResource {

    @GET("/login/{login}/{password}")
    Call<Account> login(@Path("login") String login, @Path("password") String password);

    @GET("/connect/{login}")
    Call<Account> connect(@Path("login") String login);

    @POST("/register/{name}/{surname}/{login}/{password}")
    Call<Account> register(@Path("name") String name, @Path("surname") String surname, @Path("login") String login, @Path("password") String password);

    @PUT("/updateLogin/{id}/{data}")
    Call<Account> updateLogin(@Path("id") Long id, @Path("data") String data);

    @PUT("/updatePassword/{id}/{data}")
    Call<Account> updatePassword(@Path("id") Long id, @Path("data") String data);

    @PUT("/updateName/{id}/{data}")
    Call<Account> updateName(@Path("id") Long id, @Path("data") String data);

    @PUT("/updateSurname/{id}/{data}")
    Call<Account> updateSurname(@Path("id") Long id, @Path("data") String data);

    @DELETE("/delete/{id}")
    Call<Account> deleteAccount(@Path("id") Long id);
}