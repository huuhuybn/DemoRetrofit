package vn.poly.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    // HTTP POST và HTTP GET bằng Volley hoặc Retrofit


    String urlForHTTPGET = "https://jsonplaceholder.typicode.com/todos/1";


    String urlForHTTPPOST = "https://jsonplaceholder.typicode.com/posts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void httpGet(View view) {


        DemoService demoService = DemoRetrofit
                .getInstance().create(DemoService.class);

        demoService.getUserInfo("1").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                TextView tvData = findViewById(R.id.tvData);
                String data = null;
                try {
                    data = response.body().string();
                    if (data != null) {
                        tvData.setText(
                                data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    public void httpPost(View view) {

    }
}
