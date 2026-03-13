package Atividade_1.Dinamica;

import Atividade_1.ListaOperacoes;

public class ListaDinamica implements ListaOperacoes {
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if(!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        if(this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirElementos() {
        if(existeInicio()) {
            No aux = this.inicio;
            while(aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if(existeInicio()) {
            if(buscarElemento(elemento)) {
                //removendo primeiro
                if(this.inicio.getConteudo().equals(elemento)) {
                    this.inicio = this.inicio.getProx();
                } else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        if(aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    } while (aux != null);
                } else {
                    this.inicio.setConteudo(null);
                }

                //removendo intermediário
                //método de busca
            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;

        do {
            if(aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while(aux != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    @Override
    public int removerTodas(String elemento) {
        int remov = 0;

        if (!existeInicio()) {
            System.out.println("A lista está vazia!");
            return 0;
        }

        while (existeInicio() && inicio.getConteudo().equals(elemento)) {
            System.out.println("Removendo o inicio: " + elemento);

            if (inicio.getProx() != null) {
                inicio = inicio.getProx();
            } else {
                inicio.setConteudo(null);
            }
            remov++;
        }

        if (existeInicio()) {
            No aux = inicio;
            while (aux.getProx() != null) {
                if (aux.getProx().getConteudo().equals(elemento)) {
                    System.out.println("Removendo: " + elemento);
                    aux.setProx(aux.getProx().getProx());
                    remov++;

                } else {
                    aux = aux.getProx();
                }
            }
        }

        System.out.println("Total de remoções: " + remov);
        return remov;
    }

    @Override
    public int contar() {
        if (!existeInicio()) {
            System.out.println("A lista está vazia!");
            return 0;
        }

        int cont = 0;
        No aux = inicio;

        while(aux != null) {
            cont++;
            aux = aux.getProx();
        }

        System.out.println("Quantidade de elementos: " + cont);
        return cont;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        if (!existeInicio()) {
            System.out.println("A lista está vazia!");
            return 0;
        }

        int adicionados = 0;

        for(int i = 0; i < elementos.length; i++) {
            adicionarElemento(elementos[i]);
            System.out.println("Elemento adicionado: " + elementos[i]);
            adicionados++;
        }

        System.out.println("Quantidade de elementos adicionados: " + adicionados);
        return adicionados;
    }

    @Override
    public String obter(int indice) {
        int qtdTotal = contar();
        No aux = inicio;

        if (indice < qtdTotal && indice >= 0) {
            for (int i = 0; i < indice; i++) {
                aux = aux.getProx();
            }
            String valorDoElemento = aux.getConteudo();
            System.out.println("Elemento obtido: " + valorDoElemento);
            return valorDoElemento;
        } else {
            System.out.println("O indice não corresponde ao intervalo dos elementos!");
        }

        return null;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if(indice < 0) {
            System.out.println("Indice inválido");
            return false;
        }

        if(indice == 0) {
            No novo = new No(elemento);
            novo.setProx(inicio);
            inicio = novo;
            System.out.println("Indice: " + indice + " / Elemento inserido: " + elemento);
            return true;
        }

        No aux = inicio;

        for(int i = 0; aux != null; i++) {
            if(i == indice - 1) {
                No novo = new No(elemento);
                novo.setProx(aux.getProx());
                aux.setProx(novo);
                System.out.println("Indice: " + indice + " / Elemento inserido: " + elemento);
                return true;
            }
            aux = aux.getProx();
        }

        System.out.println("Indice não atende as condições!");
        return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        if(!existeInicio() || indice < 0) {
            System.out.println("A Lista está vazia!");
            return null;
        }

        if(indice == 0) {
            String removido = inicio.getConteudo();

            if(inicio.getProx() != null) {
                inicio = inicio.getProx();
            } else {
                inicio.setConteudo(null);
            }

            System.out.println("Elemento removido do indice " + indice + ": " + removido);
            return removido;
        }

        No aux = inicio;

        for(int i = 0; aux.getProx() != null; i++) {
            if(i == indice - 1) {
                String removido = aux.getProx().getConteudo();
                aux.setProx(aux.getProx().getProx());

                System.out.println("Elemento removido do indice " + indice + ": " + removido);
                return removido;
            }
            aux = aux.getProx();
        }

        return null;
    }

    @Override
    public void limpar() {
        inicio = new No(null);
        System.out.println("Lista limpa com sucesso!");
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        int ultimoIndice = -1;
        int pos = 0;
        No aux = inicio;

        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                ultimoIndice = pos;
            }
            pos++;
            aux = aux.getProx();
        }

        System.out.println("ELEMENTO " + elemento + ": " + ultimoIndice);
        return ultimoIndice;

    }

    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        No aux = inicio;

        while(aux != null) {
            if(aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                cont++;
            }
            aux = aux.getProx();
        }

        System.out.println("Ocorrencias do elemento " + elemento + ": " + cont);
        return cont;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int sub = 0;
        No aux = inicio;

        while(aux != null) {
            if(aux.getConteudo() != null && aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                sub++;
            }
            aux = aux.getProx();
        }

        System.out.println("Total de substituições: " + sub);
        return sub;
    }
}