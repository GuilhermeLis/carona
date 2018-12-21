package com.equipe2pds20182.caronaufma;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastrarCarona extends AppCompatActivity {
    private EditText dia,hora,modeloCarro,placaCarro,corCarro,partida,caminho1,caminho2,caminho3,destino ;
    private Button cadastro;

    /*declarando variaveis do firebase*/
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_carona);

        /* Declarando todos os editText */
        dia = findViewById(R.id.editTextIdDia);
        hora = findViewById(R.id.editTextIdHoras);
        modeloCarro = findViewById(R.id.editTextIdModeloCarro);
        placaCarro = findViewById(R.id.editTextIdPlacaCarro);
        corCarro = findViewById(R.id.editTextIdCorCarro);
        partida = findViewById(R.id.editTextIdPartida);
        caminho1 = findViewById(R.id.editTextIdCaminho1);
        caminho2 = findViewById(R.id.editTextIdCaminho2);
        caminho3 = findViewById(R.id.editTextIdCaminho3);
        destino = findViewById(R.id.editTextIdDestino);
        cadastro = findViewById(R.id.buttonIdCadastroCarona);

        /* ajustando o firebase*/
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("carona");

        /* colocando o botão de cadastro de carona */

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carona a = new Carona(modeloCarro.getText().toString(),placaCarro.getText().toString(),corCarro.getText().toString(),"6",dia.getText().toString(),partida.getText().toString(),caminho1.getText().toString(),caminho2.getText().toString(),caminho3.getText().toString(),destino.getText().toString());
                mMessagesDatabaseReference.push().setValue(a);

                Intent passar = new Intent(CadastrarCarona.this, act_main.class);
                startActivity(passar);
            }
        });



    }

}
