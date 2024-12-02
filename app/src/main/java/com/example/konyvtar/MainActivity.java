package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText tiltle;
    EditText szerzo;
    EditText oldalszam;
    Button add;
    ListView list;
    List<Book> bo;
    BookAdatter book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        innzation();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name=tiltle.getText().toString();
                    if(name==" ") throw new Exception("a név nem lehet üres");

                    String szero=szerzo.getText().toString();
                    if(szero==" ") throw new Exception("a szerzö nem lehet üres ");

                    Integer oldal=Integer.parseInt(oldalszam.getText().toString());
                    if(oldal<50)throw new Exception("nem lehet kevesebb mint 50 ");
                    bo.add(new Book(name,szero,oldal));
                    book.notifyDataSetChanged();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG);
                }

            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent s=new Intent(MainActivity.this,DetailsActivity.class);
                Book  kiva=bo.get(i);
               Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_SHORT).show();
                s.putExtra("tiltle",kiva.Tiltle);
                s.putExtra("szero",kiva.creator);
                s.putExtra("page",kiva.laps);
                startActivity(s);
            }
        });

    }
    public  void innzation(){
        tiltle=findViewById(R.id.tiltle);
        szerzo=findViewById(R.id.szerzoname);
        oldalszam=findViewById(R.id.oldalszam);
        add=findViewById(R.id.addbutton);
        list=findViewById(R.id.list);
        bo=new ArrayList<>();
       book=new BookAdatter(bo,MainActivity.this);
        list.setAdapter(book);

    }



}