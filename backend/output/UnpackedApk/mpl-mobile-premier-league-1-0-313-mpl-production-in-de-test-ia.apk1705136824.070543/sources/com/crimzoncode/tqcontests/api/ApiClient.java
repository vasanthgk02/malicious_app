package com.crimzoncode.tqcontests.api;

import com.crimzoncode.tqcontests.api.response.GenericResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiClient {
    @FormUrlEncoded
    @POST("tournament/attempt/abort.json")
    Call<GenericResponse> abortQuiz(@Field("tournament_id") String str, @Field("session_id") String str2, @Field("user_id") long j, @Field("entry_fee") String str3, @Field("entry_currency") String str4);

    @FormUrlEncoded
    @POST("tournament/attempt/start.json")
    Call<GenericResponse> startQuizAttempt(@Field("board") String str, @Field("class") String str2, @Field("subject") String str3, @Field("chapter") String str4, @Field("user_id") long j, @Field("lang") String str5, @Field("tournament_id") String str6, @Field("session_id") String str7, @Field("entry_fee") String str8, @Field("entry_currency") String str9);

    @FormUrlEncoded
    @POST("tournament/attempt/complete.json")
    Call<GenericResponse> submitQuizAttempt(@FieldMap Map<String, String> map, @Field("id") String str, @Field("millis") int i, @Field("session_id") String str2, @Field("user_id") long j, @Field("entry_fee") String str3, @Field("entry_currency") String str4);
}
