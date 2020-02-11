package vn.poly.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

        demoService.getUserInfo("1").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                TextView tvData = findViewById(R.id.tvData);
                if (response.body() != null) {
                    tvData.setText(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    public void httpPost(View view) {

    }
}
