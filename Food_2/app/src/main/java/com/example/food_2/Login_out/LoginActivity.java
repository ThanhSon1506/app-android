package com.example.food_2.Login_out;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_2.Home.MainActivity;
import com.example.food_2.R;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    //@Override
    EditText edit_gmail;
    EditText edit_matkhau;
    Button btnlogin;
    TextView txt_nguoidung;
    public static final String TAG = MainActivity.class.getSimpleName();
    final String url_Login="https://newfoodapp.000webhostapp.com/login_out.php";
    protected void onCreate(Bundle savedInstanceState) {
        edit_gmail=(EditText) findViewById(R.id.editDangNhap_Gmail);
        edit_matkhau=(EditText) findViewById(R.id.editDangNhap_MK);
        btnlogin=(Button) findViewById(R.id.btnLogin);
        txt_nguoidung=(TextView) findViewById(R.id.txt_dangky);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_person);

    }

    public void DangNhap(View view) {
        //Intent downloadIntent = new Intent(this, RegisterActivity.class);
        //startActivities(new Intent[]{downloadIntent});
        String Email=edit_gmail.getText().toString();
        String Password=edit_matkhau.getText().toString();
        new LoginUser().execute(Email,Password);
    }

    public class LoginUser extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            String Email=strings[0];
            String Password=strings[1];
            OkHttpClient okHttpClient=new OkHttpClient();
            RequestBody formBody= new FormBody.Builder()
                    .add("$userID",Email)
                    .add("$userPassword",Password)
                    .build();
            Request request =new Request.Builder()
                    .url(url_Login)
                    .post(formBody)
                    .build();
            Response response=null;
            try {
                response=okHttpClient.newCall(request).execute();
                if(response.isSuccessful()){
                    String result=response.body().string();
                    if(result.equalsIgnoreCase("login")){
                        Intent i=new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i);
                        Toast.makeText(LoginActivity.this,
                                "Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        finish();
                    }else
                    {
                        Toast.makeText(LoginActivity.this,
                                "Email hoặc mật khẩu sai",Toast.LENGTH_SHORT).show();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}