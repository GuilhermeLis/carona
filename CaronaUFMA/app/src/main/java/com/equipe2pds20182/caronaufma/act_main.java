package com.equipe2pds20182.caronaufma;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class act_main extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private List<Carona> itens_tela;


    private static final String TAG = "PostDetailActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent passar = new Intent(act_main.this, CadastrarCarona.class);
                startActivity(passar);
            }
        });
        itens_tela = new ArrayList<Carona>();
        /*indexando os itens da content_act_main*/

        //itens_tela.add(new Carona("essa porra deu certo"));
        mRecyclerView = findViewById(R.id.telaId);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //mLayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(mLayoutManager);
        //ArrayList<String> nomes = new ArrayList<String>();
        //nomes.add("guilherme");
        //nomes.add("lisboa");
        //nomes.add("da silva");
        //nomes [0] = "e ai pegou?";
        //nomes [1] = "tudo beleza";


        // specify an adapter (see also next example)
        //mAdapter = new MyAdapter(nomes);
        //mRecyclerView.setAdapter(mAdapter);


        //ref.child("/carona/test").setValue(new Carona("testando essa merda q raiva"));
        DatabaseReference ref =  FirebaseDatabase.getInstance().getReference();
        ref.child("/carona/").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Carona item;
                for( DataSnapshot s : dataSnapshot.getChildren() ){
                    //item = dataSnapshot.child(s.getKey()).getValue(Carona.class);
                    // item = s.getValue(Carona.class);
                    //String i = s.getKey();
                    //u.add(i);
                    //item = dataSnapshot.getValue(Carona.class);
                    //itens_tela.add(item);
                    itens_tela.add(dataSnapshot.getValue(Carona.class));
                    //Toast.makeText(act_main.this,u,Toast.LENGTH_SHORT).show();
                    //itens_tela.add(item);

                };
                itens_tela.add(new Carona("sedan","novo","vida","ludar","enfim","test2","test5","bote","algum lugar"));
                //Toast.makeText(act_main.this,"tou chengando",Toast.LENGTH_SHORT).show();
                //item = (dataSnapshot.child("/carona/test").getValue(Carona.class));
                //itens_tela.add(item);
                //Toast.makeText(act_main.this, item.modeloDoCarro ,Toast.LENGTH_SHORT).show();
                /*
                for (int p = 0; p < u.size(); p++){
                    item = dataSnapshot.child(u.get(p)).getValue(Carona.class);
                    itens_tela.add(item);
                }*/
            };


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());


            }
        });

        setupRecycler();
        /*Criando a listview*/
        //ArrayAdapter <Carona> adapter = new ArrayAdapter <Carona> (this,android.R.layout.simple_list_item_1,itens_tela);
        //tela.setAdapter(adapter);


    }


    private void setupRecycler() {

        // Configurando o gerenciador de layout para ser uma lista.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        mAdapter = new LineAdapter(itens_tela);
        mRecyclerView.setAdapter(mAdapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
