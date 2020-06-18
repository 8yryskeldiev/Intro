package com.example.intro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {
    int fragmentCount=3;
    int pos;
    Button next, skip;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_intro );
        TabLayout tabLayout = findViewById( R.id.tabDots );
        tabLayout.setupWithViewPager( viewPager, true );
        next = findViewById( R.id.next );
        next.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextClick();
            }
        } );
        skip = findViewById( R.id.skip );
        skip.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( IntroActivity.this, MainActivity.class );
                startActivity( intent );
                finish();
            }
        } );
        viewPager = findViewById( R.id.viewPager );
        viewPager.setAdapter( new SectionsPagerAdapter( getSupportFragmentManager() ) );
        viewPager.addOnPageChangeListener( new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                    case 1:
                        next.setText( "Next" );
                    skip.setVisibility( View.VISIBLE );
                break;
                    case 2:
                        next.setText( "Start" );
                        skip.setVisibility( View.GONE );
                        break;
                }
            }
        } );
    }

    private void nextClick() {
        if (viewPager.getCurrentItem() < fragmentCount-1) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        } else {
            Intent intent=new Intent( this , MainActivity.class );
            startActivity( intent );
            finish();
        }
    }


    public  class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            pos=position;
            Bundle bundle= new Bundle();
            bundle.putInt("pos",pos);
 BlankFragment fragment= new BlankFragment();
 fragment.setArguments( bundle );
 return fragment;
        }

        @Override
        public int getCount() {
            return fragmentCount;
        }
    }


}
