package com.suman.topic5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.suman.topic5.adapter.RecycleAdapter;
import com.suman.topic5.model.Recycle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etAge;
    RadioGroup Ggroup;
    RadioButton rgMale, rgFemale, rgOthers;
    Button btnSave;
    RecyclerView Rview;
    Spinner spinnerImg;
    private String Bands[] = {

            "Anthrax",
            "Arch enemy",
            "venom",
            "Lamb of God"
    };
    private String gender;
    private int image;
    final List<Recycle> band = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        rgMale = findViewById(R.id.rgMale);
        rgFemale = findViewById(R.id.rgFemale);
        rgOthers =findViewById(R.id.rgOthers);
        btnSave = findViewById(R.id.btnsave);
        spinnerImg = findViewById(R.id.spinnerImg);
        Rview = findViewById(R.id.Rview);

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                Bands
        );

        spinnerImg.setAdapter(arrayAdapter);

        spinnerImg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinnerImg.getSelectedItem().toString().equals("Anthrax")){
                    image = R.drawable.anth;
                }
                else if (spinnerImg.getSelectedItem().toString().equals("Arch enemy")){
                    image = R.drawable.arcene;
                }
                else if (spinnerImg.getSelectedItem().toString().equals("venom")){
                    image = R.drawable.ven;
                }
                else if (spinnerImg.getSelectedItem().toString().equals("Lamb of God")){
                    image = R.drawable.log;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rgMale.setOnClickListener(this);
        rgFemale.setOnClickListener(this);
        rgOthers.setOnClickListener(this);
        btnSave.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rgMale :
                gender = "Male";
                break;
            case R.id.rgFemale :
                gender = "Female";
                break;
            case R.id.rgOthers :
                gender = "Others";
                break;
            case R.id.btnsave :
                if (TextUtils.isEmpty(etName.getText().toString())){
                    etName.setError("please enter name");
                }
               else if (TextUtils.isEmpty(etAge.getText().toString())){
                    etAge.setError("please enter Age");
                }
            else {
                band.add(new Recycle(image,etName.getText().toString(),etAge.getText().toString(),gender));
                    RecycleAdapter recycleAdapter = new RecycleAdapter(this,band);
                    Rview.setAdapter(recycleAdapter);
                    Rview.setLayoutManager(new LinearLayoutManager(this));
                    etName.setText("");
                    rgMale.setSelected(false);
                    rgFemale.setSelected(false);
                    rgOthers.setSelected(false);
                    etAge.setText("");







                }
//                }
                break;

        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
