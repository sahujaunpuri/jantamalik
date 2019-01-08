package filternetfoundation.com.jantamaalik.DonateActivityJava;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import filternetfoundation.com.jantamaalik.MainActivity;
import filternetfoundation.com.jantamaalik.R;

public class donate extends AppCompatActivity {

    Toolbar toolbar;

    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate_menuitem_layout);

        mSharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_language = mSharedPref.getString(MainActivity.sUSER_CURRENT_LANGUAGE, null);
        if(current_language != null && current_language.equals(MainActivity.sLANGUAGE_HINDI)) {
            MainActivity.setUI_Lang(this, "hi");
        }

        toolbar = findViewById(R.id.donate_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void openDonationLink(View view){
        Uri uri = Uri.parse("https://www.instamojo.com/@JantaMalik/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
