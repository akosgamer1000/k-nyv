package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {
    TextView tiltle;
    TextView szero;
    TextView lapsz;
    TextView year;
    Button back;
    Random s=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        innizatilon();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent s=new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(s);
               finish();
            }
        });
    }

    public  void innizatilon(){

            tiltle=findViewById(R.id.name2);
            szero=findViewById(R.id.szero2);
            lapsz=findViewById(R.id.laps2);
            year=findViewById(R.id.year2);
            back=findViewById(R.id.back);
            String tilte=getIntent().getStringExtra("tiltle");
            String szerok=getIntent().getStringExtra("szero");
            Integer laps=getIntent().getIntExtra("page",1);
            tiltle.setText(tilte);
            szero.setText(szerok);
            lapsz.setText(String.valueOf(laps));
            year.setText(String.valueOf(s.nextInt(2500)));

    }
}