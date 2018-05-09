package com.bove.martin.toolbar.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.bove.martin.toolbar.R;
import com.bove.martin.toolbar.adapters.PagerAdapter;
import com.bove.martin.toolbar.fragments.ListFragment;
import com.bove.martin.toolbar.interfaces.Comunicacion;
import com.bove.martin.toolbar.model.Persona;
import com.bove.martin.toolbar.utils.Utils;

public class MainActivity extends AppCompatActivity implements Comunicacion {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    public static final int FORM_FRAGMENT = 0;
    public static final int LIST_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Formulario"));
        tabLayout.addTab(tabLayout.newTab().setText("Lista"));

        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager = findViewById(R.id.viewPager);
        adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void enviarPersona(Persona persona) {
        Utils.addPersona(persona);
        ListFragment listFragment = (ListFragment) adapter.getFragment(LIST_FRAGMENT);
        listFragment.updateAdapter();
        tabLayout.getTabAt(LIST_FRAGMENT).select();
    }
}
