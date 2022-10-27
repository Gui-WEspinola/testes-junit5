package model;

import java.util.ArrayList;

public class Pilha {
    int limite = 5;
    ArrayList<Livro> pilhaLivros = new ArrayList<>();

    public void push(Livro livro){
        if (pilhaLivros.size() >= limite)
            throw new ArrayStoreException("Não é possível adicionar mais livros!");

        if (!livro.getTitulo().toUpperCase().startsWith("A") && !livro.getTitulo().toUpperCase().startsWith("O"))
            return;

        pilhaLivros.add(livro);
    }

    public Livro getLivro(){
        return pilhaLivros.get(pilhaLivros.size() - 1);
    }

    public void removeLivro(){
        pilhaLivros.remove(pilhaLivros.size() - 1);
    }

    public int count(){
        return pilhaLivros.size();
    }

    public int getLimite() {
        return limite;
    }
}
