package co.hyperverge.hypersnapsdk.b.g;

import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

/* compiled from: ApiInterface */
public interface b {
    @GET
    Call<ResponseBody> a(@Url String str, @HeaderMap Map<String, String> map);

    @PUT
    @Multipart
    Call<ResponseBody> a(@Url String str, @HeaderMap Map<String, String> map, @Part MultipartBody.Part part);

    @POST
    @Multipart
    Call<ResponseBody> a(@Url String str, @HeaderMap Map<String, String> map, @Part MultipartBody.Part part, @PartMap Map<String, RequestBody> map2);

    @POST
    @Multipart
    Call<ResponseBody> a(@Url String str, @HeaderMap Map<String, String> map, @Part MultipartBody.Part part, @PartMap Map<String, RequestBody> map2, @Part("isBackCamera") RequestBody requestBody);

    @POST
    @Multipart
    Call<ResponseBody> a(@Url String str, @HeaderMap Map<String, String> map, @Part MultipartBody.Part part, @Part MultipartBody.Part part2, @PartMap Map<String, RequestBody> map2);

    @POST
    @Multipart
    Call<ResponseBody> a(@Url String str, @HeaderMap Map<String, String> map, @Part MultipartBody.Part part, @Part MultipartBody.Part part2, @PartMap Map<String, RequestBody> map2, @Part("isBackCamera") RequestBody requestBody);

    @POST
    Call<ResponseBody> a(@Url String str, @HeaderMap Map<String, String> map, @Body RequestBody requestBody);

    @POST
    @Multipart
    Call<ResponseBody> b(@Url String str, @HeaderMap Map<String, String> map, @Part MultipartBody.Part part, @PartMap Map<String, RequestBody> map2);

    @POST
    @Multipart
    Call<ResponseBody> b(@Url String str, @HeaderMap Map<String, String> map, @Part MultipartBody.Part part, @Part MultipartBody.Part part2, @PartMap Map<String, RequestBody> map2);

    @POST
    Call<ResponseBody> b(@Url String str, @HeaderMap Map<String, String> map, @Body RequestBody requestBody);

    @POST
    @Multipart
    Call<ResponseBody> c(@Url String str, @HeaderMap Map<String, String> map, @Part MultipartBody.Part part, @PartMap Map<String, RequestBody> map2);
}
