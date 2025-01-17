package pt.ipleiria.estg.dei.amsi.myscores.activities;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.classes.User;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonBD;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonJogos;
import pt.ipleiria.estg.dei.amsi.myscores.fragments.fragmentPaginaInicial;
import pt.ipleiria.estg.dei.amsi.myscores.fragments.fragmentPaginaPerfil;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonUsers;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentTransaction fragmentoReplace;

    private TextView tvNome, tvEmail;

    private ArrayList<User> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SingletonBD.iniciarBD(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*SingletonUsers.getInstance(this).getAllUsersAPI(this);*/

        user = SingletonUsers.getInstance(this).getUser();

        fragmentoReplace = getSupportFragmentManager().beginTransaction();

        LinearLayout navHearder = findViewById(R.id.navigation_header_container);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Fragmento que é iniciado depois do log in
        navigationView.setCheckedItem(R.id.itemPaginaInicial);
        Fragment fragment = new fragmentPaginaInicial();
        mostrarFragmento(fragment);

        View headerView = navigationView.getHeaderView(0);
        tvNome = headerView.findViewById(R.id.textViewUsername);
        tvNome.setText(user.get(0).getNome());
        tvEmail = headerView.findViewById(R.id.textViewEmail);
        tvEmail.setText(user.get(0).getEmail());

        SharedPreferences.Editor sharedPreferences = getApplicationContext().getSharedPreferences("userShared",Context.MODE_PRIVATE).edit();
        sharedPreferences.putInt("userid", user.get(0).getId());
        Log.d("testeShared", sharedPreferences.toString());

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //Para fazer as opções é nesta função
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.itemPaginaPerfil) {
            fragment = new fragmentPaginaPerfil();
            mostrarFragmento(fragment);
        } else if (id == R.id.itemPaginaInicial) {
            fragment = new fragmentPaginaInicial();
            mostrarFragmento(fragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void mostrarFragmento(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContent, fragment);
        fragmentTransaction.commit();
    }
}
