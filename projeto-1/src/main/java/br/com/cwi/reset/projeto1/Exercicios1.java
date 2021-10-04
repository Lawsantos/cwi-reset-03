package br.com.cwi.reset.projeto1;

import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {

        Integer soma = 0;
        for (Integer num : numeros) {
            soma += num;
        }
        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        return (double) somarLista(numeros) / numeros.size();
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        Integer maior = numeros.get(0);

        for (Integer num : numeros) {
            if (num > maior) {
                maior = num;
            }
        }
        return maior;
    }

    public String obterPalavraInvertida(String palavra) {
        String invertida = "";

        for (int i = palavra.length() - 1; i >= 0; i--) {
            invertida += palavra.charAt(i);
        }

        return invertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        Integer[] indice = numeros.toArray(new Integer[numeros.size()]);
        Integer aux;
        for (int i = 0; i < numeros.size() - 1; i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                if (indice[j] < indice[i]) {
                    aux = indice[j];
                    indice[j] = indice[i];
                    indice[i] = aux;
                }
            }
        }
        return Arrays.asList(indice);
    }
}

