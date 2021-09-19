package com.sandeep.baatchit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.sandeep.baatchit.R;
import com.sandeep.baatchit.profile.ProfileActivity;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewpager;
    FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabMain);
        viewpager = findViewById(R.id.vpMain);

        setViewpager();

    }


    private void setViewpager()
    {

      tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_chat));
      tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_request));
      tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_findfriends));

      tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm,getLifecycle());
        viewpager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
    //this method is called when our activity is created and here we can create menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.mnuProfile)
        {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean doubleBackPressed = false;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if(tabLayout.getSelectedTabPosition()>0)
        {
            tabLayout.selectTab(tabLayout.getTabAt(0));
        }
        else
            {

            if (doubleBackPressed)
            {
                finishAffinity();
            }
            else
                {
                doubleBackPressed = true;
                Toast.makeText(this, R.string.press_back_again_to_exit, Toast.LENGTH_SHORT).show();

                //delay

                android.os.Handler handler = new android.os.Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doubleBackPressed = false;
                    }
                },2000);

            }
        }
    }
}