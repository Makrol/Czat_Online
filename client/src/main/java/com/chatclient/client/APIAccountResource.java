package com.chatclient.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface APIAccountResource {
    @GET("/login/{login}/{password}")
    Call<List<Account>> login(@Path("login") String login, @Path("password") String password);

    @POST("register/{name}/{surname}/{login}/{password}")
    Call<Account> register(@Path("name") String name,@Path("surname") String surname,@Path("login") String login,@Path("password") String password);
}