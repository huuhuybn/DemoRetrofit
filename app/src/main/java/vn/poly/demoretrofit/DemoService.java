package vn.poly.demoretrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DemoService {

    @GET("todos/{id}")
    Call<ResponseBody> getUserInfo(@Path("id") String id);

    @FormUrlEncoded
    @POST("posts/")
    Call<ResponseBody> createUser(@Field("userId") String id,
                                  @Field("title") String title,
                                  @Field("body") String body);

}
