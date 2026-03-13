package Atividade_1.Simples;

import Atividade_1.ListaOperacoes;

public class ListaSimples implements ListaOperacoes {
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        if(!estaVazio()){
            System.out.print("['" + lista[0] + "'");
            for (int i = 1; i < this.lista.length; i++) {
                System.out.print(", '" + lista[i] + "'");
            }
            System.out.print("]\n");
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento){
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if(buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }

    @Override
    public int removerTodas(String elemento) {
        if(!estaVazio()){
            for(int i = 0; i<lista.length; i++){
                if(lista[i] != null && lista[i].equals(elemento)){
                    lista[i] = null;
                }
            }
            System.out.println("Todos os elementos '" + elemento + "' foram removidas com sucesso.");
        }else System.out.println("A lista está vazia.");
        return -1;
    }

    @Override
    public int contar() {
        int cont = 0;
        if(!estaVazio()){
            for(int i = 0; i < lista.length; i++){
                if(lista[i] != null){
                    cont++;
                }
            }
            System.out.println("A quantidade de elementos na lista: " + cont);
        } else{
            System.out.println("A lista está vazia.");
        }
        return 0;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for(int i = 0; i < elementos.length; i++){
            if(!estaCheia()){
                lista[encontrarPosicaoVazia()] = elementos[i];
                adicionados++;
            } else{
                break;
            }
        }
        System.out.println("Foram adicionados " + adicionados + " nomes");
        return adicionados;
    }

    @Override
    public String obter(int indice) {
        if(indice >= 0 && indice < lista.length){
            System.out.println("Nome " + lista[indice] + " encontrada na posição " + indice + " com sucesso.");
            return lista[indice];
        } else return null;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice > lista.length || estaCheia()) {
            return false;
        }

        for(int i = lista.length - 1; i > indice; i--){
            lista[i] = lista[i - 1];
        }

        lista[indice] = elemento;
        System.out.println(elemento + " inserido na posição " + indice);
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        if(indice >= 0 && indice < lista.length){
            lista[indice] = null;
            for (int i = indice; i < lista.length - 1; i++){
                lista[i] = lista[i + 1];
            }
            lista[lista.length - 1] = null;
            return lista[indice];
        } else return null;
    }

    @Override
    public void limpar() {
        lista = new String[0];
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        for(int i = lista.length - 1; i >= 0; i--){
            if(lista[i] != null && lista[i].equals(elemento)){
                System.out.println("A última ocorrência do elemento " + elemento + " fica no índice " + i);
                return i;
            }
        }
        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        for (int i = 0; i < lista.length - 1; i++){
            if(lista[i] != null && lista[i].equalsIgnoreCase(elemento)){
                cont++;
            }
        }
        System.out.println("O elemento " + elemento + " possui " + cont + " ocorrências");
        return cont;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int quantidadeTrocas = 0;
        for(int i = 0; i < lista.length - 1; i++){
            if(lista[i] != null && lista[i].equals(antigo)){
                lista[i] = novo;
                quantidadeTrocas++;
            }
        }
        return  quantidadeTrocas;
    }
}