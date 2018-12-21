package com.equipe2pds20182.caronaufma;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class act_Login extends AppCompatActivity {
    private Button transitar,cadastrar;
    private EditText matricula,senha;
    private Boolean logar = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act__login);


        /*lincando tudo*/
        transitar = (Button) findViewById(R.id.buttonId);
        cadastrar = findViewById(R.id.buttonIdTryCadastrar);
        matricula = findViewById(R.id.editTextIdMatriculaL);
        senha = findViewById(R.id.editTextIdSenhaL);

        // ligando o firebase
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        /* Efetuar login */
        transitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("/users/").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            user usuario = (dataSnapshot.child(matricula.getText().toString()).getValue(user.class));
                            //mudar_de_tela();

                            if (usuario.senha.equals(senha.getText().toString())){
                                Toast.makeText(act_Login.this,"Trocando essa porra",Toast.LENGTH_SHORT).show();

                                logar = true;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                if (logar){
                    logar = false;
                    mudar_de_tela();
                }else{
                    Toast.makeText(act_Login.this,"Senha ou Matricula incorreta",Toast.LENGTH_SHORT).show();
                }

            }
        });


        /* Passa pra tela que deve ser efetuado o login */
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent passar = new Intent(act_Login.this , CadastroActivity.class);
                startActivity(passar);
            }
        });
    }


    private final void mudar_de_tela (){

        Intent passar = new Intent(act_Login.this, act_main.class);
        startActivity(passar);
    }
}
