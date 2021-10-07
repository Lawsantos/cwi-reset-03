public class ReposicaoCozinha {

    public static void reporItem(String item) {
        // String 'pao' estava como 'paes'
        if ("pao".equals(item)) {
            ItensPorQuantidade.pao = 3600;
        }
        if ("torta".equals(item)) {
            ItensPorQuantidade.torta = 4;
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche = 20;
        }
    }
}
