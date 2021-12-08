package com.example.kalkulator;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView op, hasil;
    EditText angka1, angka2;
    RadioGroup radiogrup;
    Button bhasil;
    ArrayList<String> addArray = new ArrayList<String>();
    ListView history;
    private double a1, a2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history = (ListView) findViewById(R.id.history);

        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);

        op = findViewById(R.id.op);
        hasil = findViewById(R.id.hasil);

        radiogrup = findViewById(R.id.radg);
        radiogrup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup Group, int checkedId) {
                switch (checkedId) {
                    case R.id.tambah:
                        op.setText("+");

                        bhasil = findViewById(R.id.bhasil);
                        bhasil.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                konver();
                                double thasil = a1 + a2;
                                hasil.setText(Double.toString(thasil));

                                String gethasil = a1+ "+"+ a2+ "="+ thasil;

                                addArray.add(gethasil);
                                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,addArray);
                                history.setAdapter(adapter);
                            }
                        });
                        break;

                    case R.id.kurang:
                        op.setText("-");

                        bhasil = findViewById(R.id.bhasil);
                        bhasil.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                konver();
                                double thasil = a1 - a2;
                                hasil.setText(Double.toString(thasil));

                                String gethasil = a1+ "-"+ a2+ "="+ thasil;

                                addArray.add(gethasil);
                                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,addArray);
                                history.setAdapter(adapter);
                            }
                        });
                        break;

                    case R.id.kali:
                        op.setText("x");

                        bhasil = findViewById(R.id.bhasil);
                        bhasil.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                konver();
                                double thasil = a1 * a2;
                                hasil.setText(Double.toString(thasil));

                                String gethasil = a1+ "x"+ a2+ "="+ thasil;

                                addArray.add(gethasil);
                                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,addArray);
                                history.setAdapter(adapter);
                            }
                        });
                        break;

                    case R.id.bagi:
                        op.setText(":");

                        bhasil = findViewById(R.id.bhasil);
                        bhasil.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                konver();
                                double thasil = a1 / a2;
                                hasil.setText(Double.toString(thasil));

                                String gethasil = a1+ ":"+ a2+ "="+ thasil;

                                addArray.add(gethasil);
                                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,addArray);
                                history.setAdapter(adapter);
                            }
                        });
                        break;
                }
            }
        });
    }
    public void konver() {
        a1 = Double.parseDouble(angka1.getText().toString());
        a2 = Double.parseDouble(angka2.getText().toString());
    }
}