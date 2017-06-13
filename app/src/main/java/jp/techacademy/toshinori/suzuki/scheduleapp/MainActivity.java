package jp.techacademy.toshinori.suzuki.scheduleapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements CalendarFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener, EditFragment.OnFragmentInteractionListener {

    public static String TAG = "MainActivity";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment mFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mFragment = HomeFragment.newInstance("home", "1");
                    break;
                case R.id.navigation_calendar:
                    mFragment = CalendarFragment.newInstance(2017, 6, 2);
                    break;
                case R.id.navigation_notifications:
                    mFragment = EditFragment.newInstance("edit", "3");
                    break;
            }
            if (mFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, mFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                return true;
            }

            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.container, HomeFragment.newInstance("home", "1"));
            transaction.commit();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // 選択されたfragmentから何かの処理をActivityにさせたい場合はここに記述
        Log.d(TAG, "onFragmentInteraction: url=" + uri);
    }

}
