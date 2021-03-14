package com.devrob.progressbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerOptions;
    private EditText editText1;
    private EditText editText2;
    private TextView textViewResults;
    private FloatingActionButton floatingActionButton;
    private Button btnCalcular;
    private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configVIew();
        setAdapter();
        setOnClickResults();
        setResult();
    }

    void configVIew(){
        spinnerOptions = (Spinner) findViewById(R.id.spinner_1);
        editText1 = (EditText) findViewById(R.id.editText_1);
        editText2 = (EditText) findViewById(R.id.editText_2);
        textViewResults = (TextView) findViewById(R.id.textView_Results);
        btnCalcular = (Button) findViewById(R.id.btn_calcular);
        model = new ViewModelProvider(this).get(MainViewModel.class);
        spinnerOptions.setOnItemSelectedListener(this);
    }

    void setAdapter(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.options_array,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);
    }

    void setOnClickResults(){
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText1.getText().toString().isEmpty()|| editText2.getText().toString().isEmpty()){
                    return ;
                }
                Double n1 = Double.parseDouble(editText1.getText().toString());
                Double n2 = Double.parseDouble(editText2.getText().toString());
                model.calcular(n1 ,n2);

            }
        });
    }

    void setResult(){
        model.getResult().observe(this,result -> {
            textViewResults.setText(result.toString());
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        model.setSelectedOp(position);
        if(editText1.getText().toString().isEmpty()|| editText2.getText().toString().isEmpty()){
            return ;
        }
        Double n1 = Double.parseDouble(editText1.getText().toString());
        Double n2 = Double.parseDouble(editText2.getText().toString());
        model.calcular(n1 ,n2);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}