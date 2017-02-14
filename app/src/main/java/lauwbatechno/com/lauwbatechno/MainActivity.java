package lauwbatechno.com.lauwbatechno;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, new Home()).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.home:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_layout, new Home()).commit();
                break;
            case R.id.web:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_layout, new Web()).commit();
                break;
            case R.id.peta:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_layout, new Peta()).commit();
                break;
            case R.id.video:
                Intent intent = new Intent(MainActivity.this, Video.class);
                startActivity(intent);
                break;
            case R.id.exit:
                finish();
                break;
            default:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_layout, new Home()).commit();
                break;









            case R.id.galeri:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_layout, new Galeri()).commit();
                break;
            case R.id.tentang:
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_layout, new Tentang()).commit();
                break;

        }




        /*switch (id){
            case R.id.home :
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_layout, new Home()).commit();
                break;
            case R.id.web :
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_layout, new Home()).commit();
                break;
        }*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
