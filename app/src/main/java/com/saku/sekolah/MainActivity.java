package com.saku.sekolah;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.saku.sekolah.ui.beranda.BerandaFragment;
import com.saku.sekolah.ui.keuangan.KeuanganFragment;
import com.saku.sekolah.ui.pengguna.PenggunaFragment;
import com.saku.sekolah.ui.pesan.PesanFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static Locale localeID = new Locale("in","ID");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navListener);
        loadFragment(new BerandaFragment());
//        navView.setOnNavigationItemSelectedListener(navListener);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_beranda, R.id.navigation_keuangan, R.id.navigation_pesan,R.id.navigation_pengguna)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
////        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment=null;
                    switch (menuItem.getItemId()){
                        case R.id.navigation_beranda:
                            selectedFragment = new BerandaFragment();
                            break;
                        case R.id.navigation_keuangan:
                            selectedFragment = new KeuanganFragment();
                            break;
                        case R.id.navigation_pesan:
                            selectedFragment = new PesanFragment();
                            break;
                        case R.id.navigation_pengguna:
                            selectedFragment = new PenggunaFragment();
                            break;
                    }
                    getSupportFragmentManager().popBackStack();
                    return loadFragment(selectedFragment);
                }
            };

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("Peringatan");
            builder.setMessage("Yakin ingin keluar?");
            builder.setCancelable(true);
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.super.onBackPressed();
                }
            });

            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // Do something when want to stay in the app
//                    Toast.makeText(getApplicationContext(),"thank you",Toast.LENGTH_LONG).show();
                }
            });

            // Create the alert dialog using alert dialog builder
            AlertDialog dialog = builder.create();

            // Finally, display the dialog when user press back button
            dialog.show();
        }else{
            super.onBackPressed();
        }


//        }
    }

}
