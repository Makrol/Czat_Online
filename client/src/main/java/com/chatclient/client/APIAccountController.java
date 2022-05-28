package com.chatclient.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class APIAccountController implements Callback<List<Account>> {
    APIAccountResource resource;
    static final String BASE_URL = "http://localhost:8080/";
    private Retrofit retrofit;
    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIAccountResource APIAccountResource = retrofit.create(APIAccountResource.class);

        // Call<List<Account>> call = gerritAPI.login("bogollo123","12345");
        // call.enqueue(this);
        resource = retrofit.create(APIAccountResource.class);
    }
    Account login(String login,String password) throws IOException {

        Call<List<Account>> tmp = resource.login(login, password);
        Response<List<Account>> response = tmp.execute();
         if (response.isSuccessful()) {
             ArrayList<Account>tmp2= (ArrayList<Account>) response.body();
             return tmp2.get(0);
          }

        return null;
    }
    Account register(String name,String surname,String login, String password)throws  IOException{
        Call<Account> tmp = resource.register(name, surname, login, password);
        Response<Account> response = tmp.execute();
        if(response.isSuccessful()){
            return  response.body();
        }
        return null;
    }
    @Override
    public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
        if(response.isSuccessful()) {
            List<Account> changesList = response.body();
            changesList.forEach(change -> System.out.println(change.getName()));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Account>> call, Throwable t) {
        t.printStackTrace();
    }
}