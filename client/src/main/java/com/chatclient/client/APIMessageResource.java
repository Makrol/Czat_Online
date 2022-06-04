package com.chatclient.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface APIMessageResource {
    @POST("/send/{text}/{srcId}/{dstId}")
    Call<Message> sendMessage(@Path("text") String text,@Path("srcId") Long srcId,@Path("dstId") Long dstID);
    @GET("/getMessages/{srcId}/{dstId}")
    Call<List<Message>> getMessage(@Path("srcId") Long srcId, @Path("dstId") Long dstID);
}
