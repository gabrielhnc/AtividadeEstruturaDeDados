package Atividade_1.Dinamica;

public class MainListaDinamica {
    static void main() {
        ListaDinamica lista = new ListaDinamica();

        System.out.println("=== Adicionando Elementos [Tamanho 5] ===");
        lista.adicionarElemento("Macarrao");
        lista.adicionarElemento("Pão");
        lista.adicionarElemento("Macarrao");
        lista.adicionarElemento("Hamburguer");
        lista.adicionarElemento("Macarrao");

        System.out.println("=================================================");

        lista.exibirElementos();

        System.out.println("=================================================");

        lista.removerTodas("Macarrao"); // REMOVER TODAS

        System.out.println("Exibindo os elementos restantes: ");
        lista.exibirElementos();

        System.out.println("=================================================");

        System.out.println("CONTANDO ELEMENTOS: ");
        lista.contar(); // CONTAR

        System.out.println("=================================================");

        System.out.println("ADICIONANDO VARIOS: ");
        String[] nomes = {"Arroz" , "Morango", "Pera"};
        lista.adicionarVarios(nomes); // ADICIONAR VARIOS

        System.out.println("=================================================");
        System.out.println("ELEMENTOS ATUAIS DA LISTA: ");
        lista.exibirElementos();

        System.out.println("=================================================");

        lista.obter(5); // OBTER

        System.out.println("=================================================");

        System.out.println("INSERINDO ELEMENTOS:");
        lista.inserir(2, "Bola");
        lista.exibirElementos();

        System.out.println("=================================================");

        lista.removerPorIndice(2);
        lista.exibirElementos();

//        System.out.println("=================================================");
//
//        System.out.println("LIMPANDO A TELA: ");
//        lista.limpar();
//        lista.exibirElementos();

        System.out.println("=================================================");

        System.out.println("ULTIMO INDICE DE UM ELEMENTO: ");
        lista.ultimoIndiceDe("Arroz");
        lista.exibirElementos();

        System.out.println("=================================================");

        System.out.println("CONTANDO OCORRENCIAS: ");
        lista.contarOcorrencias("Morango");

        System.out.println("=================================================");
        System.out.println("SUBSTITUINDO UM ELEMENTO: ");
        lista.substituir("Morango", "Batata");
        lista.exibirElementos();
    }
}
