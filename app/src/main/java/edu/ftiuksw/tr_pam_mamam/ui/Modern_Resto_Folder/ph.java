package edu.ftiuksw.tr_pam_mamam.ui.Modern_Resto_Folder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.ftiuksw.tr_pam_mamam.HomeActivity;
import edu.ftiuksw.tr_pam_mamam.R;
import edu.ftiuksw.tr_pam_mamam.ui.Modern_Resto_Folder.MAP.PhMap;

public class ph extends AppCompatActivity {

    Button phs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ph);

        phs=findViewById(R.id.btn_ph);
        phs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PhMap.class));
                overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
            }
        });
    }
}
