package com.uniquindio.android.electiva.thevozarron.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.ListaEntrenadores;
import com.uniquindio.android.electiva.thevozarron.fragments.ListaParticipantes;
import com.uniquindio.android.electiva.thevozarron.fragments.MenuOpciones;
import com.uniquindio.android.electiva.thevozarron.fragments.SeccionPrincipal;
import com.uniquindio.android.electiva.thevozarron.vo.Participantes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  SeccionPrincipal.OnSeccionSeleccionada, MenuOpciones.OnOPcionSeleccionada{

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar(); // Añadir la toolbar

        // Setear adaptador al viewpager.
        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        // Preparar las pestañas
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabs.getTabAt(1).setIcon(R.drawable.ic_settings_black_24dp);
        tabs.getTabAt(0).setText("");
        tabs.getTabAt(1).setText("");
    }


    /**
     * Establece la toolbar como action bar
     */
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            //ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    /**
     * Crea una instancia del view pager con los datos
     * predeterminados
     *
     * @param viewPager Nueva instancia
     */
    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(SeccionPrincipal.newInstance(1), "Sección Principal");
        adapter.addFragment(MenuOpciones.newInstance(2), "Opciones");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void OnOPcionSeleccionada(int position) {
        Toast.makeText(this, "OPCION Seleccionada" + position, Toast.LENGTH_SHORT).show();
        if(position==0){
            Intent intent = new Intent(this,CambiarIdiomaActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void OnSeccionSeleccionada(int position) {
        Toast.makeText(this, "SECCION Seleccionada" + position, Toast.LENGTH_SHORT).show();
        if(position==0){
            Intent intent = new Intent(this,ListaEntrenadoresActivity.class);
            startActivity(intent);
        }
        if(position==1){
            Intent intent = new Intent(this, ListaParticipantesActivity.class);
            ArrayList<Participantes> p = new ArrayList<>();
            intent.putParcelableArrayListExtra("list",p);
            startActivity(intent);
        }
    }

    /**
     * Un {@link FragmentPagerAdapter} que gestiona las secciones, fragmentos y
     * títulos de las pestañas
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<Fragment>();
        private final List<String> mFragmentTitles = new ArrayList<String>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
