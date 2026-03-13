package Atividade_1.Simples;

public class MainListaSimples {
    static void main() {
        ListaSimples lista = new ListaSimples(5);

        System.out.println("Adicionando elementos:");
        lista.adicionarElemento("Gabriel");
        lista.adicionarElemento("Erick");
        lista.adicionarElemento("Alef");
        lista.adicionarElemento("Erick");

        System.out.println();

        System.out.println("Contando os elementos:");
        lista.contar();
        lista.exibirElementos();
        System.out.println();

        lista.removerTodas("Erick");
        lista.exibirElementos();
        lista.contar();
        System.out.println();

        String[] nomes = {"Ana", "Beatriz"};

        lista.adicionarVarios(nomes);
        lista.exibirElementos();
        System.out.println();

        System.out.println("Obtendo o valor na posição desejada: ");
        lista.obter(1);
        System.out.println();

        System.out.println("Inserindo o nome desejado: ");
        lista.inserir(1, "Marcos");
        lista.exibirElementos();
        System.out.println();

        System.out.println("Removendo o valor pelo índice");
        lista.removerPorIndice(1);
        lista.exibirElementos();
        System.out.println();

//        Limpando a lista
//        lista.limpar();
//        lista.exibirElementos();

        lista.ultimoIndiceDe("Ana");
        System.out.println();

        lista.contarOcorrencias("Ana");
        System.out.println();

        System.out.println("Substituindo os elementos");
        lista.substituir("Ana", "Erick");
        lista.exibirElementos();
    }
}