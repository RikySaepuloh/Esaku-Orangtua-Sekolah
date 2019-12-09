package com.saku.sekolah;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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
import com.saku.sekolah.model.login.Login;
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
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
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

        if (sp.getIsLogedIn().equals(true)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
//        etUsername.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                initKodePP(etUsername.getText().toString());
//                return false;
//            }
//        });

        etUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    initKodePP(etUsername.getText().toString());
                }
            }
        });


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
                final String kode_plan = kodePpId.get(spinner.getSelectedItemPosition());
                login(etUsername.getText().toString(), etPassword.getText().toString(), kode_plan);
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

    private void login(String nik, String pass, String kode_pp) {
        progressBar.setVisibility(View.VISIBLE);
        mApiService.login(nik, pass, kode_pp)
                .enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                if (response.body().isIsLogedIn()) {
                                    sp.saveUserLog(response.body().getUserLog());
                                    sp.saveUserStatus(response.body().getUserStatus());
                                    sp.saveNamaLokasi(response.body().getNamalokasi());
                                    sp.saveKodePp(response.body().getKodePP());
                                    sp.saveNoHp(response.body().getNoHp());
                                    sp.saveUserPwd(response.body().getUserPwd());
                                    sp.setLoggedStatus(response.body().isIsLogedIn());
                                    sp.saveKodeLokasiKonsol(response.body().getKodeLokasiKonsol());
                                    sp.saveNamaUser(response.body().getNamaUser());
                                    sp.savePeriode(response.body().getPeriode());
                                    sp.saveFormLogin(response.body().getFormLogin());
                                    sp.saveLoginTime(response.body().getLoginTime());
                                    sp.saveLogo(response.body().getLogo());
                                    sp.saveNikUser(response.body().getNikUser());
                                    sp.saveEmail(response.body().getEmail());
                                    sp.saveKodeMenu(response.body().getKodeMenu());
                                    sp.saveToken(response.body().getToken());
                                    sp.saveExitUrl(response.body().getExitUrl());
                                    sp.saveKodeFs(response.body().getKodeFs());
                                    sp.saveHakAkses(response.body().getHakakses());
                                    sp.saveFoto(response.body().getFoto());
                                    sp.saveApiKey(response.body().getApiKey());
                                    sp.saveLokasi(response.body().getLokasi());
                                    sp.saveNamaPp(response.body().getNamaPP());
                                    sp.saveDash(response.body().getDash());
                                    sp.saveKodeBidang(response.body().getKodeBidang());
//                                    if (sp.getIsLogedIn().equals(true)){
//                                        Toast.makeText(context, "WHAT", Toast.LENGTH_SHORT).show();
//                                    }
                                    progressBar.setVisibility(View.GONE);
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        } else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
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
                                    for (int i = 0; i < itemList.size(); i++) {
                                        kodePpList.add(itemList.get(i).getKodePp() + " - " + itemList.get(i).getNama());
                                        kodePpId.put(i, itemList.get(i).getKodePp());
                                    }
                                    ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                                            android.R.layout.simple_spinner_item, kodePpList);
                                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                    spinner.setAdapter(adapter);
                                } else {
                                    kodePpList.clear();
                                    ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                                            android.R.layout.simple_spinner_item, kodePpList);
                                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                    spinner.setAdapter(adapter);
                                    Toast.makeText(context, "Tidak ada data", Toast.LENGTH_LONG).show();
                                }
                            }
                        } else {
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
