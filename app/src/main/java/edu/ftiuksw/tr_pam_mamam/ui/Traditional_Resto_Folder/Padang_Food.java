package edu.ftiuksw.tr_pam_mamam.ui.Traditional_Resto_Folder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.ftiuksw.tr_pam_mamam.HomeActivity;
import edu.ftiuksw.tr_pam_mamam.R;
import edu.ftiuksw.tr_pam_mamam.ui.Traditional_Resto_Folder.MAP.Padang_Food_Map;

public class Padang_Food extends AppCompatActivity {
    Button padangs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.padang_food);

        padangs = findViewById(R.id.btn_padangs);

        padangs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Padang_Food_Map.class));
                overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
            }
        });
    }
}
