package com.example.asoto.birdvinseller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.CameraPosition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private GoogleMap mMap;
    private static final LatLng MUSEUM = new LatLng(38.8874245, -77.0200729);

    LinearLayout l1,l2;
    Button btnsub;
    Animation uptodown,downtoup;
    Boolean switched = false;
    View myView;
    View myView1;
    View myView2;
    View myView3;
    ObjectAnimator animator;
    ObjectAnimator animator1;
    ObjectAnimator animator2;
    ObjectAnimator animator3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        /*setContentView(R.layout.nuevoprincipal); */
        setContentView(R.layout.nuevoprincipal);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

/*        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        ArrayList<Map<String, String>> Ordenes;
        Ordenes = new ArrayList<Map<String, String>>();

        HashMap<String, String> elemento = new HashMap<String, String>();
        elemento.put("a","hola");
        elemento.put("b","hola");
        Ordenes.add(elemento);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void Switch(View view){

        myView = findViewById(R.id.Opcion1);
        myView1 = findViewById(R.id.Opcion2);
        myView2 = findViewById(R.id.Opcion1a);
        myView3 = findViewById(R.id.Opcion2a);


        if (switched) {
            // Set the layer type to hardware

            myView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            myView1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            myView2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            myView3.setLayerType(View.LAYER_TYPE_HARDWARE, null);

            // Setup the animation
            animator = ObjectAnimator.ofFloat(myView, View.ALPHA, (float)1.0);
            animator1 = ObjectAnimator.ofFloat(myView1, View.ALPHA, (float)0.0);
            animator2 = ObjectAnimator.ofFloat(myView2, View.ALPHA, (float)1.0);
            animator3 = ObjectAnimator.ofFloat(myView3, View.ALPHA, (float)0.0);

            // Add a listener that does cleanup
            animator1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {

                    animator.start();
                    animator2.start();
                }
            });
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    myView.setLayerType(View.LAYER_TYPE_NONE, null);
                    myView1.setLayerType(View.LAYER_TYPE_NONE, null);
                    myView2.setLayerType(View.LAYER_TYPE_NONE, null);
                    myView3.setLayerType(View.LAYER_TYPE_NONE, null);

                }
            });
            // Start the animation

            animator1.start();
            animator3.start();
            switched = false;
        }
        else {
            // Set the layer type to hardware

            myView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

            // Setup the animation
            animator = ObjectAnimator.ofFloat(myView, View.ALPHA, (float)0.0);
            animator1 = ObjectAnimator.ofFloat(myView1, View.ALPHA, (float)1.0);
            animator2 = ObjectAnimator.ofFloat(myView2, View.ALPHA, (float)0.0);
            animator3 = ObjectAnimator.ofFloat(myView3, View.ALPHA, (float)1.0);

            // Add a listener that does cleanup
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {

                    animator1.start();
                    animator3.start();
                }
            });
            animator1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    myView.setLayerType(View.LAYER_TYPE_NONE, null);
                    myView1.setLayerType(View.LAYER_TYPE_NONE, null);
                    myView2.setLayerType(View.LAYER_TYPE_NONE, null);
                    myView3.setLayerType(View.LAYER_TYPE_NONE, null);
                }
            });
            // Start the animation

            animator.start();
            animator2.start();
            switched = true;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MUSEUM, 10));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(MUSEUM)
                .zoom(16f)
                .bearing(70)
                .tilt(25)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        // update map view



    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
            int x = getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView;
            if (x == 1){

                FrameLayout a = (FrameLayout) inflater.inflate(R.layout.reusableexample, container, false);
                container.addView(a);

                rootView = inflater.inflate(R.layout.menu, container, false);
            }
            else {
                rootView = inflater.inflate(R.layout.ordenes, container, false);
            }



            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }
    }


}
