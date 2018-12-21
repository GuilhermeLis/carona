package com.equipe2pds20182.caronaufma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class TermosActivity extends AppCompatActivity {
    private TextView termo;
    private CheckBox decisao;
    private String name,matricula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos);
        termo = findViewById(R.id.textView);
        decisao = findViewById(R.id.checkBoxIdConcordo);
        termo.setText("Esta pasta consiste em vários arquivos de layout (xml). Por isso, criamos uma pasta chat e movemos todo o conteúdo relacionado ao chat para dentro dela. Ela também tem muitas imagens que são usadas somente nesta tela, por isso também movemos os arquivos de imagem para dentro da pasta chat: drawable-hdpi, drawable-xhdpi, drawable-xxhdpi e drawable-xxxhdpi folders.\n" +
                "\n" +
                "Quando chegar a hora de implementar um layout landscape ou especifico para tablet, podemos simplesmente criar uma pasta layout-land ou layout-sw720dp dentro da pasta chat.\n" +
                "\n" +
                "Como declarar uma pasta de recursos?\n" +
                "\n" +
                "Abra o arquivo app.gradle e declare um sourceSets dentro da seção android.\n" +
                "blaasdasdasdasssssssssssssssssssssssssssssssssssssssssssssss\n" +
                "asdasdasdsadddddddddddddddddddddddddddddddddasdadadasd\n" +
                "sdasdasdadadasdas\n");

        Intent dados = getIntent();
        Bundle getDados = dados.getExtras();

        decisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decisao.isChecked()) {
                    CadastroActivity.aceitou = 1;
                    Intent passar = new Intent (TermosActivity.this, CadastroActivity.class);
                    startActivity(passar);

                }
            }
        });

    }

}
