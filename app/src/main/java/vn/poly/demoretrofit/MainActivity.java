package vn.poly.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    // HTTP POST và HTTP GET bằng Volley hoặc Retrofit


    String urlForHTTPGET = "https://jsonplaceholder.typicode.com/todos/1";


    String urlForHTTPPOST = "https://jsonplaceholder.typicode.com/posts";


    private RecyclerView lvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvList = findViewById(R.id.recyclerView);
    }

    public void httpGet(View view) {


        DemoService demoService = DemoRetrofit
                .getInstance().create(DemoService.class);

        demoService.getPost().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                UserAdapter userAdapter = new UserAdapter(MainActivity.this,
                        response.body());
                LinearLayoutManager linearLayoutManager =
                        new LinearLayoutManager(MainActivity.this);
                lvList.setLayoutManager(linearLayoutManager);
                lvList.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }

    public void httpPost(View view) {
        DemoService demoService = DemoRetrofit
                .getInstance().create(DemoService.class);

        demoService.createUser("1", "Hello", "Huy Nguyen")
                .enqueue(new Callback<ResponseBody>() {
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
}
