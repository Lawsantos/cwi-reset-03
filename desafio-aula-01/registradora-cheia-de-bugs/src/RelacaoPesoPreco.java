public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = 12.75 * (qtd * 60 / 1000);
        }
        // refiz o calculo do precoTotal de ' 96.00 * (qtd / 16)) ' para '(96.00 / 16) * qtd '.
        if ("torta".equals(item)) {
            precoTotal = (96.00 / 16) * qtd ;
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * qtd;
        }
        // String cafe estava com acento aqui, retirei
        if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtd;
        }
        // troquei a String "sanduba" por "sanduiche"
        if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * qtd;
        }

        return precoTotal;
    }
}
