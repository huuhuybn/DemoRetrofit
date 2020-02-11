package vn.poly.demoretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DemoService {

    @GET("todos/{id}")
    Call<String> getUserInfo(@Path("id") String id);


}
