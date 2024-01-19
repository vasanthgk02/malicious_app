package co.hyperverge.hypersnapsdk.b.g;

import co.hyperverge.hypersnapsdk.b.e;
import co.hyperverge.hypersnapsdk.b.f.b;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/* compiled from: RemoteConfigApiInterface */
public interface d {
    @GET
    Call<b> a(@Url String str);

    @GET
    Call<e> b(@Url String str);
}
