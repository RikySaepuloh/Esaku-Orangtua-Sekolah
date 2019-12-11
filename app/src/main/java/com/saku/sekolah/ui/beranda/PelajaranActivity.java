package com.saku.sekolah.ui.beranda;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.saku.sekolah.MainActivity;
import com.saku.sekolah.R;
import com.saku.sekolah.adapter.SectionPagerAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PelajaranActivity extends AppCompatActivity {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.pelajaran_tanggal)
    TextView pelajaranTanggal;
    Context context;
    String tanggal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelajaran);
        ButterKnife.bind(this);
        context=this;
        setUpViewPager(pager);
        tablayout.setupWithViewPager(pager);

        setTodayDate();

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


//        System.out.println(formatter.format(date));

        pelajaranTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
//                String day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tanggal=dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                pelajaranTanggal.setText(tanggal);
                                SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");
                                Date date = new Date(year, monthOfYear, dayOfMonth-1);


                                String dayOfWeek = simpledateformat.format(date);
                                switch (dayOfWeek){
                                    case "Monday":
                                        pager.setCurrentItem(0);
                                        break;
                                    case "Tuesday":
                                        pager.setCurrentItem(1);
                                        break;
                                    case "Wednesday":
                                        pager.setCurrentItem(2);
                                        break;
                                    case "Thursday":
                                        pager.setCurrentItem(3);
                                        break;
                                    case "Friday":
                                        pager.setCurrentItem(4);
                                        break;
                                    case "Saturday":
                                        pager.setCurrentItem(5);
                                        break;
                                    default:
                                        Toast.makeText(context,"Anda memilih hari minggu, libur bodoh",Toast.LENGTH_SHORT).show();
                                        pager.setCurrentItem(5);
                                        tanggal=dayOfMonth-1 + "/" + (monthOfYear + 1) + "/" + year;
                                        pelajaranTanggal.setText(tanggal);
                                    break;
                                }
                            }

                        }, year, month, day);
                picker.show();
            }
        });
    }

    private void setTodayDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        tanggal=formatter.format(date);
        pelajaranTanggal.setText(tanggal);
//
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day){
            case Calendar.MONDAY:
                pager.setCurrentItem(0);
                break;
            case Calendar.TUESDAY:
                pager.setCurrentItem(1);
                break;
            case Calendar.WEDNESDAY:
                pager.setCurrentItem(2);
                break;
            case Calendar.THURSDAY:
                pager.setCurrentItem(3);
                break;
            case Calendar.FRIDAY:
                pager.setCurrentItem(4);
                break;
            case Calendar.SATURDAY:
                pager.setCurrentItem(5);
                break;
            default:
                pager.setCurrentItem(0);
        }
    }

    private void setUpViewPager(ViewPager myViewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HariFragment("Senin"), "Senin");
        adapter.addFragment(new HariFragment("Selasa"), "Selasa");
        adapter.addFragment(new HariFragment("Rabu"), "Rabu");
        adapter.addFragment(new HariFragment("Kamis"), "Kamis");
        adapter.addFragment(new HariFragment("Jum'at"), "Jum'at");
        adapter.addFragment(new HariFragment("Sabtu"), "Sabtu");
//        adapter.addFragment(new HariFragment("Minggu"), "Minggu");

        myViewPager.setAdapter(adapter);
    }
}
