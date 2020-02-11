package vn.poly.demoretrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DemoService {

    @GET("todos/{id}")
    Call<ResponseBody> getUserInfo(@Path("id") String id);


}
