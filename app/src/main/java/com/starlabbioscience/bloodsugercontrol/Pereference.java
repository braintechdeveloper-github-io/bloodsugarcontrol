package com.starlabbioscience.bloodsugercontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @AUTHOR : JOHN MELODY ME || HAFIZAN ||
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: BLOOD SUGAR CONTROL
 */

public class Pereference extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    String [] SETTINGS;

    {
        SETTINGS = new String[]{"Report Error", "About Us"};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pereference);

        listView = findViewById(R.id.settinglistview);
            arrayAdapter = new ArrayAdapter<String>(Pereference.this,
                    R.layout.support_simple_spinner_dropdown_item, SETTINGS);
            listView.setAdapter(arrayAdapter);
            ON_CLICK_LIST_ITEM();
    }

    private void ON_CLICK_LIST_ITEM() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String CLICKED;
                CLICKED = (String) parent.getItemAtPosition(position);
                if (CLICKED.equals("Report Error")){
                    EMAIL_TO_DEVELOPER();
                }
                else if (CLICKED.equals("About Us")){
                    Intent web;
                    web = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.starlabs.com.my/"));
                    startActivity(web);
                }
                else {
                    System.out.println("--");
                }
            }
        });
    }

    private void EMAIL_TO_DEVELOPER() {
        Intent emailTODeveloper = new Intent(Intent.ACTION_SEND);
        emailTODeveloper.setType("text/plain");
        emailTODeveloper.putExtra(Intent.EXTRA_EMAIL, new String[]
                {"john@braintechgroup.com"});
        emailTODeveloper.putExtra(Intent.EXTRA_CC, new String[]
                {"ang@braintechgroup.com"});
        emailTODeveloper.putExtra(Intent.EXTRA_SUBJECT,
                " Hey Developer, I have some suggestion and Issue!");
        emailTODeveloper.putExtra(Intent.EXTRA_TEXT,
                "Hey Developer, I have some suggestion and Issue!");
        try {
            startActivity(Intent.createChooser(emailTODeveloper,"Pick a Email Platform: "));
        } catch (Exception ignored) {
        }
    }
}
