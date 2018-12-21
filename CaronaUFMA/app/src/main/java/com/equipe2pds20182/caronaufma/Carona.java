package com.equipe2pds20182.caronaufma;

import java.util.ArrayList;

public class Carona {
    public String modeloDoCarro,placaDoCarro,corDoCarro,ofertante,quantidade,dia,partida, caminho1, caminho2, caminho3, chegada;
    public Carona( String modeloDoCarro, String placaDoCarro,String corDoCarro, String quantidade, String dia, String partida, String caminho1,String caminho2,String caminho3, String chegada){
        //this.ofertante = ofertante;
        this.modeloDoCarro =modeloDoCarro;
        this.placaDoCarro = placaDoCarro;
        this.corDoCarro = corDoCarro;
        this.partida = partida;
        this.caminho1 = caminho1;
        this.caminho2 = caminho2;
        this.caminho3 = caminho3;
        this.partida = partida;
        this.chegada =chegada;
        this.quantidade = quantidade;
        this.dia = dia;
    }

    public Carona( String modeloDoCarro, String placaDoCarro,String corDoCarro, String quantidade, String dia, String partida, String caminho1,String caminho2, String chegada){
        //this.ofertante = ofertante;
        this.modeloDoCarro =modeloDoCarro;
        this.placaDoCarro = placaDoCarro;
        this.corDoCarro = corDoCarro;
        this.partida = partida;
        this.caminho1 = caminho1;
        this.caminho2 = caminho2;
        this.partida = partida;
        this.chegada =chegada;
        this.quantidade = quantidade;
        this.dia = dia;
    }
    public Carona () {

    }
    public Carona( String modeloDoCarro ){
        //this.ofertante = ofertante;
        this.modeloDoCarro =modeloDoCarro;
    }






    /*
    @Override
    public String toString() {
        return  " Quantidade: " + quantidade + "\n" +
                " Dia: " + dia + "\n" +
                " Partida: " + partida +"\n" +
                " Chegada: " + chegada + "\n";
    }*/
}
