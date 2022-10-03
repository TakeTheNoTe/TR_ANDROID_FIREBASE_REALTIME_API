package edu.ftiuksw.tr_pam_mamam.ui.Modern_Resto_Folder;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.ftiuksw.tr_pam_mamam.R;

public class ModernRestoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modern_resto, container, false);
        final Button mkfc,mroosterchicken,msteak,mph;

        mkfc = view.findViewById(R.id.btn_kfc);
        mroosterchicken = view.findViewById(R.id.btn_rooster_chicken);
        msteak = view.findViewById(R.id.btn_steak);
        mph = view.findViewById(R.id.btn_ph);

        mkfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),kfc.class);
                startActivity(intent);
            }
        });

        mroosterchicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Rooster_Chicken.class);
                startActivity(intent);
            }
        });

        msteak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),steak.class);
                startActivity(intent);
            }
        });

        mph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ph.class);
                startActivity(intent);
            }
        });
        return view;
    }
}