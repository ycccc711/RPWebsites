package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Spinner spn1,spn2;
    Button go;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1  = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        go = findViewById(R.id.btnGO);


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        String[] sub1 = getResources().getStringArray(R.array.sub_rp);
                        aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, sub1);
                        aa.notifyDataSetChanged();
                        //bind the ArrayAdapter to the spinner
                        spn2.setAdapter(aa);
                        break;
                    case 1:
                        String[] sub2 = getResources().getStringArray(R.array.sub_soi);
                        aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, sub2);
                        aa.notifyDataSetChanged();
                        //bind the ArrayAdapter to the spinner
                        spn2.setAdapter(aa);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][]sites = {
                        {
                                "https://www.youtube.com/",
                                "https://www.google.com",
                        },
                        {
                                "https://www.instagram.com/",
                                "https://www.facebook.com/",
                        }
                };
                //String url = "https://www.facebook.com/";
                String url = sites[spn1.getSelectedItemPosition()][spn2.getSelectedItemPosition()];
                startActivity(new Intent(MainActivity.this,webView.class).putExtra("URL",url));
            }
        });

    }
}
