package az.kanan.materialshowcase.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import az.kanan.materialshowcase.R;
import az.kanan.materialshowcase.fragments.AddElementFragment;
import az.kanan.materialshowcase.fragments.SearchingResultFragment;
import az.kanan.materialshowcase.fragments.ListFragment;
import az.kanan.materialshowcase.fragments.RVFragment;
import az.kanan.materialshowcase.models.Car;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMainViews();

        initFirstFragment();

        handleIntent(getIntent());

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            searchingProcess(query);
        }
    }

    private void searchingProcess(String value) {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("bmw", "m5", "car"));
        carList.add(new Car("bmw", "m3", "car"));
        carList.add(new Car("bmw", "m4", "car"));
        carList.add(new Car("bmw", "m2", "car"));
        carList.add(new Car("bmw", "m", "car"));
        carList.add(new Car("bmw", "l1", "car"));
        carList.add(new Car("nissan", "sunny", "car"));
        carList.add(new Car("mercedes", "sls", "car"));
        carList.add(new Car("mercedes", "slk", "car"));
        carList.add(new Car("mercedes", "slr", "car"));
        carList.add(new Car("mercedes", "190", "car"));
        carList.add(new Car("toyoto", "prado", "car"));
        carList.add(new Car("toyoto", "camry", "car"));
        carList.add(new Car("toyoto", "corolla", "car"));
        carList.add(new Car("tesla", "x", "car"));
        carList.add(new Car("tesla", "3", "car"));
        carList.add(new Car("tesla", "s", "car"));

        List<Car> resultCarList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getBrand().equals(value) || car.getModel().equals(value)) {
                resultCarList.add(car);
            }
        }

        changeFragment(new SearchingResultFragment(resultCarList), true);

    }

    private void initFirstFragment() {
        changeFragment(new AddElementFragment(), false);
    }

    private void initMainViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        mDrawer = (DrawerLayout) findViewById(R.id.activity_main);
        setupDrawerContent(nvDrawer);

        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);
    }


    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            SearchManager searchManager =
                    (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView =
                    (SearchView) menu.findItem(R.id.search).getActionView();
            searchView.setSearchableInfo(
                    searchManager.getSearchableInfo(getComponentName()));
        }
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
            case R.id.search:
                onSearchRequested();
                return true;
        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }


    public void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                changeFragment(new AddElementFragment(), true);
                break;
            case R.id.nav_second_fragment:
                changeFragment(new ListFragment(), true);
                break;
            case R.id.nav_third_fragment:
                changeFragment(new RVFragment(), true);
                break;
            default:
                changeFragment(new AddElementFragment(), true);
        }

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
    }


    public void changeFragment(Fragment newFragment, Boolean isBackButtonActivateInFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragments_container, newFragment);

        if (isBackButtonActivateInFragment)
            transaction.addToBackStack(null);

        transaction.commit();
    }


}
