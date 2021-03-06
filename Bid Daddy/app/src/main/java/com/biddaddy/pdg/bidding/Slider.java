package com.biddaddy.pdg.bidding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Slider extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        requestWindowFeature(Window.FEATURE_NO_TITLE);          ////For full screen
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        setContentView(R.layout.activity_slider);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bid Daddy");


        ViewPager vp = (ViewPager) findViewById(R.id.viewpager_id);
        this.addPages(vp);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.mTab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(listener(vp));
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.logout) {
//           // session.logoutUser();
//        }
//        else if (id == R.id.refresh) {
//            Intent i=new Intent(getApplicationContext(),Slider.class);
//            startActivity(i);
//        }
//        else if (id == R.id.search) {
//            Intent i=new Intent(getApplicationContext(),search.class);
//            startActivity(i);
//        }
//        else if (id == R.id.profile) {
//            Intent i=new Intent(getApplicationContext(),profile.class);
//            startActivity(i);
//        }
//
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Slider.this, MainActivity.class);
        startActivity(i);
    }

    //Add all pages
    private void addPages(ViewPager viewPager){
        MyFragPagerAdapter adapter = new MyFragPagerAdapter(getSupportFragmentManager());
        adapter.addPAge(new Frag1());
        adapter.addPAge(new Frag2());
        viewPager.setAdapter(adapter);


    }



    private TabLayout.OnTabSelectedListener listener(final ViewPager pager){

        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // pager.setCurrentItem(tab.getPosition());
            }
        };
    }
}














