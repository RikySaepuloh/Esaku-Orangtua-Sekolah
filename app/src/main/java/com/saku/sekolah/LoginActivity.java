package com.saku.sekolah;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.login.KodePpPresenter;
import com.saku.sekolah.model.login.LoginPresenter;
import com.saku.sekolah.model.login.PpItem;
import com.saku.sekolah.preferences.Preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {
    String TAG = "PhoneActivityTAG";
    Activity activity = this;
    private static final int PERMISSION_REQUEST_CODE = 1;
    ArrayList<String> _mst = new ArrayList<>();

    EditText etUsername, etPassword;
    String newToken;
    BaseApiService mApiService;
    ProgressBar loading;
    TextView btnShow;
    @BindView(R.id.login_spkodepp)
    Spinner spinner;
    private Preferences sp;
    private Context context;
    int params;
    Button btnLogin;
    List<String> kodePpList = new ArrayList<>();
    HashMap<Integer, String> kodePpId = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btn_login);
        btnShow = findViewById(R.id.btn_show);

        params = 0;
        context = this;
        sp = new Preferences(context);

        if (sp.getLoggedStatus().equals("true")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        etUsername.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                initKodePP(etUsername.getText().toString());
                return false;
            }
        });
//        initKodePP();


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (params == 0) {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    params = 1;
                    btnShow.setText("hide");
                } else {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    params = 0;
                    btnShow.setText("show");
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Berhasil Login",Toast.LENGTH_SHORT).show();
//                Toast.makeText(null, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
//                requestLogin();
            }
        });

//
        final TextView tv_lupa_password = findViewById(R.id.tv_lupa_password);
//        tv_lupa_password.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this,ForgetActivity.class);
//                startActivity(i);
//            }
//        });
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSION_REQUEST_CODE:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Log.d(TAG, "Phone number: " + getPhone());
//                } else {
//                    Toast.makeText(activity,"Permission Denied. We can't get phone number.", Toast.LENGTH_LONG).show();
//                }
//                break;
//        }
//    }

    private void login(String nis, String pass,String kode_pp) {
        mApiService.login(nis,pass,kode_pp)
                .enqueue(new Callback<LoginPresenter>() {
                    @Override
                    public void onResponse(Call<LoginPresenter> call, Response<LoginPresenter> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                
//                                List<PpItem> itemList = response.body().getPp();
//                                if (itemList.size() > 0) {
//                                    kodePpList.clear();
//                                    for (int i = 0; i < itemList.size(); i++) { //3 = Limit data
//                                        kodePpList.add(itemList.get(i).getKodePp() + " - " + itemList.get(i).getNama());
//                                        kodePpId.put(i,itemList.get(i).getKodePp());
//                                    }
//                                    ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
//                                            android.R.layout.simple_spinner_item, kodePpList);
//                                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                                    spinner.setAdapter(adapter);
//                                }else{
//                                    kodePpList.clear();
//                                    ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
//                                            android.R.layout.simple_spinner_item, kodePpList);
//                                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                                    spinner.setAdapter(adapter);
//                                    Toast.makeText(context, "Tidak ada data", Toast.LENGTH_LONG).show();
//                                }
                            }
                        }else {
                            Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginPresenter> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initKodePP(String nis) {
        mApiService.getDaftarPP(nis)
                .enqueue(new Callback<KodePpPresenter>() {
                    @Override
                    public void onResponse(Call<KodePpPresenter> call, Response<KodePpPresenter> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getPp() != null) {
                                List<PpItem> itemList = response.body().getPp();
                                if (itemList.size() > 0) {
                                    kodePpList.clear();
                                    for (int i = 0; i < itemList.size(); i++) { //3 = Limit data
                                        kodePpList.add(itemList.get(i).getKodePp() + " - " + itemList.get(i).getNama());
                                        kodePpId.put(i,itemList.get(i).getKodePp());
                                    }
                                    ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                                            android.R.layout.simple_spinner_item, kodePpList);
                                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                    spinner.setAdapter(adapter);
                                }else{
                                    kodePpList.clear();
                                    ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                                            android.R.layout.simple_spinner_item, kodePpList);
                                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                    spinner.setAdapter(adapter);
                                    Toast.makeText(context, "Tidak ada data", Toast.LENGTH_LONG).show();
                                }
                            }
                        }else {
                            Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<KodePpPresenter> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
