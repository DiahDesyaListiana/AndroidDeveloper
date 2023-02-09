package com.poliban.ac.id.e020320093.appwithsettings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.poliban.ac.id.e020320093.appwithsettings.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Creates the view with a Toolbar and a Floating Action Button. Also sets
     * default values for preference settings and reads those settings.
     *
     * @param savedInstanceState Instance state bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action",
                                Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Sets default values only once, first time this is called.
        // The third argument is a boolean that indicates whether
        // the default values should be set more than once. When false,
        // the system sets the default values only if this method has never
        // been called in the past.
        PreferenceManager
                .setDefaultValues(this,
                        R.xml.preferences, false);

        // Read the settings from the shared preferences, put them into the
        // SettingsActivity, and display a toast.
        SharedPreferences sharedPref =
                PreferenceManager
                        .getDefaultSharedPreferences(this);
        Boolean switchPref = sharedPref.getBoolean
                (SettingsActivity.KEY_PREF_EXAMPLE_SWITCH, false);
        Toast.makeText(this, switchPref.toString(),
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Inflates the options menu and adds items to the menu.
     *
     * @param menu Options menu
     * @return True if menu is inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar
        // if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles option menu selections and automatically handles clicks
     * on the Up button in the app bar.
     *
     * @param item Item in options menu
     * @return True if Settings is selected in the options menu.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // If option menu item is Settings, return true.
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,
                    SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}