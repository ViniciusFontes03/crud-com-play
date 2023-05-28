package controllers;

import play.mvc.Controller;

import java.util.List;

import models.Pessoa;

public class Pessoas extends Controller {
    
    public static void form() {
        render();
    }

    public static void cadastrar(Pessoa p){
        p.save();
        flash.success("Cadastrado com sucesso");
        listar();
    }

    public static void deletar(Long id){
        Pessoa pessoaId = Pessoa.findById(id);
        pessoaId.delete();
        flash.success("Removido com sucesso");
        listar();
    }

    public static void editar(Long id){
        Pessoa p = Pessoa.findById(id);
        renderTemplate("Pessoas/form.html", p);
        listar();
    }

    public static void listar(){
        List<Pessoa> listaPessoas = Pessoa.findAll();
        render(listaPessoas);
    }
    
}
