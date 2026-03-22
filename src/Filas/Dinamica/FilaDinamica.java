package Filas.Dinamica;

import Atividade_2.PilhaDinamica.NoInteiro;

public class FilaDinamica {
    NoInteiro inicio;

    public FilaDinamica() {
        this.inicio = new NoInteiro(null);
    }

    public void enfileirar(int numero) {
        if(estaVazio()) {
            System.out.println("Número " + numero + " adicionado a Fila.");
            this.inicio.setConteudo(numero);
        } else {
            NoInteiro novoNo = new NoInteiro(numero);
            NoInteiro aux = this.inicio;
            while(aux != null) {
                if(aux.getProx() == null) {
                    System.out.println("Número " + numero + " adicionado a Fila.");
                    aux.setProx(novoNo);
                    return;
                }
                aux = aux.getProx();
            }
        }
    }

    public void exibir(){
        if(!estaVazio()) {
            NoInteiro aux = this.inicio;
            while(aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    private boolean estaVazio() {
        if(this.inicio.getConteudo() == null) {
            System.out.println("A Fila está vazia.");
            return true;
        } else {
            return false;
        }
    }

    public void desenfileirar() {
        if(!estaVazio()) {
            if(this.inicio.getProx() == null) {
                this.inicio.setConteudo(null);
            } else {
                this.inicio = this.inicio.getProx();
            }
        }
    }
}