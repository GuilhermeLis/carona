package com.equipe2pds20182.caronaufma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastrarPerfilActivity extends AppCompatActivity {
    private ImageButton fotoPerfil;
    private Button cadastrar;
    static int RESULT_LOAD_IMAGE = 1;
    private TextView email,matricula;
    private EditText nascimento,curso,nome;

    //variaveis do firebase
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_perfil);

        // Iniciando o firebase
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("users");

        //linkando os itens
        fotoPerfil = findViewById(R.id.imageButtonIdPerfil);
        cadastrar = findViewById(R.id.buttonIdCadastrarP);
        email = findViewById(R.id.textViewIdEmail);
        matricula = findViewById(R.id.textViewIdMatricula);

        nascimento = findViewById(R.id.editTextIdNascimentoP);
        curso = findViewById(R.id.editTextIdCursoP);
        nome = findViewById(R.id.editTextNameP);


        // pegando os dados da activity anterior
        Intent cadastro = getIntent();
        final Bundle recebido = cadastro.getExtras();
        email.setText(recebido.getString("email"));
        matricula.setText(recebido.getString("matricula"));

        //execução de pegar uma imagem da galeria
        fotoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Passando de tela
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);


            }
        });



        //Efetuar o cadastro do usuário
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validação de senha pela firebase
                // esse parte não está funcionando
                /*mAuth.createUserWithEmailAndPassword(recebido.getString("email") , recebido.getString("senha")).addOnCompleteListener(CadastrarPerfilActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CadastrarPerfilActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/


                    cadastrarFirebase(recebido.getString("matricula"),recebido.getString("email"),recebido.getString("senha"));
                    Intent i = new Intent(CadastrarPerfilActivity.this, act_Login.class);
                    startActivity(i);
            }
        });
    }


    private  void cadastrarFirebase(String matricula, String email, String senha){
        user usuario = new user(matricula,email,nome.getText().toString(),nascimento.getText().toString(),curso.getText().toString(),senha);
        mMessagesDatabaseReference.child(usuario.matricula).setValue(usuario);
    }
    private boolean verificarPreenchido(){
        if (nascimento.getText().length() != 0 && curso.getText().length() != 0 && nome.getText().length() != 0 ){
            return true;
        }else{

            if (nascimento.getText().length() == 0){
                nascimento.setError("Matrícula não foi preenchida");
            }
            if(curso.getText().length() == 0){
                curso.setError("Email não foi preenchido");
            }
            if (nome.getText().length() == 0){
                nome.setError("Senha não foi preenchida");
            }

        }
        return false;
    }

}