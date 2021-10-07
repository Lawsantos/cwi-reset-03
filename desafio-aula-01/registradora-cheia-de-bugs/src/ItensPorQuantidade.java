public class ItensPorQuantidade {

    static int pao = 3600;
    static int torta = 4;
    static int fatiaTorta = torta * 16;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public static int estoqueItem(String item, int qtda) {

        int venda = 0;

        if ("pao".equals(item)) {
            venda = ItensPorQuantidade.pao -= qtda;
        }

        if ("torta".equals(item)) {
            venda = ItensPorQuantidade.fatiaTorta -= qtda;
        }

        if ("sanduiche".equals(item)) {
            venda = ItensPorQuantidade.sanduiche -= qtda;
        }

        if ("cafe".equals(item)) {
            venda = ItensPorQuantidade.leite -= qtda;
        }

        if ("leite".equals(item)) {
            venda = ItensPorQuantidade.cafe -= qtda;
        }
        return venda;
    }
}
