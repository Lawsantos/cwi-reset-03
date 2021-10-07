
public class Registradora {

    private static String item;

    public static void main(String[] args) {
       primeiroBug();

       segundoBug();

       terceiroBug();

       quartoBug();

       quintoBug();

       sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        double precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);

        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    System.out.println("Cozinha fechada!");
                    System.out.println("Reposição do " + item + " não esta mais disponível. Quantidade restante em estoque é de "+ (quantidade > 0 ? quantidade : 0) + ".");
                }else {

                    ReposicaoCozinha.reporItem(item);
                }
            }

            if ("leite".equals(item) || "cafe".equals(item)) {

                ReposicaoFornecedor.reporItem(item);
            }
        }

        return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;
        ItensPorQuantidade.estoqueItem(item, quantidade);
        double precoTotal = registrarItem(item, quantidade);
        ItensPorQuantidade.estoqueItem(item, quantidade);
        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.printf("Valor total: %.2f%n", precoTotal2);
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
        ItensPorQuantidade.estoqueItem(item, quantidade);

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;
        int qtdItem = 0;
        
        if (item == item2){
            qtdItem = (quantidade2 - quantidade);
            double precoTotal2 = registrarItem(item2, qtdItem);
            ItensPorQuantidade.estoqueItem(item2, qtdItem);

        }else if (qtdItem > 0) {
            double precoTotal2 = registrarItem(item2, qtdItem);
            System.out.println(String.format("Valor total: %.2f", precoTotal2));
        }
    }

}
