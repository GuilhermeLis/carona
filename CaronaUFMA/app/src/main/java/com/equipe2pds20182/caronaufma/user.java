package com.equipe2pds20182.caronaufma;

public class user {
    public String matricula,email,nome,nascimento,curso,senha;

    public user(){

    }

    public user(String matricula, String email, String nome, String nascimento, String curso, String senha){
        this.matricula = matricula;
        this.email = email;
        this.nome = nome;
        this.nascimento = nascimento;
        this.curso =curso;
        this.senha = senha;
    }
}
