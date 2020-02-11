package vn.poly.demoretrofit;

import retrofit2.Retrofit;

public class DemoRetrofit {

    public static Retrofit retrofit;

    public static Retrofit getInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .build();
        }
        return retrofit;
    }
}
