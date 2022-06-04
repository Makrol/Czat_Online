package com.chatclient.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class APIMessageController implements Callback<List<Message>> {
    APIMessageResource resource;
    ObjectMapper mapper = new ObjectMapper();
    static final String BASE_URL = "http://localhost:8081/";
    private Retrofit retrofit;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        APIMessageResource apiMessageResource = retrofit.create(APIMessageResource.class);


        resource = retrofit.create(APIMessageResource.class);
    }

    public List<Message> getMessages(Long srcId,Long dstID) throws IOException {
        Call<List<Message>> tmp = resource.getMessage(srcId, dstID);
        Response<List<Message>> response = tmp.execute();
        if(response.isSuccessful()){
            return response.body();
        }
        return null;

    }
    public Message sendMessage(String text,Long srcId,Long dstID) throws IOException{
        Call<Message> tmp = resource.sendMessage(text,srcId, dstID);
        Response<Message> response = tmp.execute();
        if(response.isSuccessful()){
            return response.body();
        }
        return null;
    }

    @Override
    public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
        if(response.isSuccessful()){
            List<Message> changeList = response.body();
            changeList.forEach(change->System.out.println(change.getId()));
        }else{
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Message>> call, Throwable throwable) {
        throwable.printStackTrace();
    }
}
