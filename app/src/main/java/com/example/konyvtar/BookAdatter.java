package com.example.konyvtar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookAdatter  extends BaseAdapter {
    List<Book> books;
    Context con;

    public BookAdatter(List<Book> books, Context con) {
        this.books = books;
        this.con = con;
    }

    @Override
    public int getCount() {
        return  books.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(con).inflate(R.layout.listwiewitem,viewGroup,false);
        TextView  tiltle=view.findViewById(R.id.name_wiew);
        TextView  author=view.findViewById(R.id.szero_wiew);
        TextView  paeg=view.findViewById(R.id.lapszamwiew);
        Button delete=view.findViewById(R.id.delete);
        Toast.makeText(con, ""+i, Toast.LENGTH_SHORT).show();
        Book b=books.get(i);
        System.out.printf(b.toString());
        tiltle.setText(b.Tiltle);
        author.setText(b.creator);
        paeg.setText(String.valueOf( b.laps));
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(con);
                builder.setTitle("törlés");
                builder.setMessage("biztosantörlik");
                builder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                                books.remove(i);
                                 notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("nem",null);
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });


        return view;
    }
}
