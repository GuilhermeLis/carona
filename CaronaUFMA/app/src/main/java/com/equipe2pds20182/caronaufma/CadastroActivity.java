package com.equipe2pds20182.caronaufma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {
    private Button cadastro;
    static int aceitou = 1;
    private EditText email,matricula,senha,senha2;

    private String sEmail,sMatricula,sSenha,sSenha2;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // iniciando tudo sobre o firebase
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("user");



        /* campo de inderecçamento de todos os itens da activity */
        cadastro = findViewById(R.id.buttonIdCadastro);
        email = findViewById(R.id.editTextIdNome);
        matricula = findViewById(R.id.editTextIdMatricula);
        senha = findViewById(R.id.editTextIdSenha);
        senha2 = findViewById(R.id.editTextIdSenha2);



        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent passar = new Intent(CadastroActivity.this, TermosActivity.class);
                //startActivity(passar);


                if (aceitou == 1 && verificarPreenchido() && verificarSenha()){




                    Bundle dadosCadastro = new Bundle();
                    Intent indo = new Intent(CadastroActivity.this,  CadastrarPerfilActivity.class);

                    dadosCadastro.putString("email",email.getText().toString());
                    dadosCadastro.putString("matricula",matricula.getText().toString());
                    dadosCadastro.putString("senha",senha.getText().toString());
                    indo.putExtras(dadosCadastro);
                    startActivity(indo);
                }

            }
        });


    }


    private boolean verificarPreenchido(){
        if (email.getText().length() != 0 && matricula.getText().length() != 0 && senha.getText().length() != 0 ){
            return true;
        }else{

            if (matricula.getText().length() == 0){
                matricula.setError("Matrícula não foi preenchida");
            }
            if(email.getText().length() == 0){
                email.setError("Email não foi preenchido");
            }
            if (senha.getText().length() == 0){
                senha.setError("Senha não foi preenchida");
            }

        }
        return false;
    }

    private boolean verificarSenha(){
        if (senha.getText().toString().equals(senha2.getText().toString())){
            return true;
        }else{
            senha2.setError("As senhas precisam ser iguais");
        }
        return false;
    }




}