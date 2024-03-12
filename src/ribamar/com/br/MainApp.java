package ribamar.com.br;

import java.lang.reflect.Field;

public class MainApp {
    public static void main(String[] args) {
        try {
            imprimirTabela1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void imprimirTabela1() throws NoSuchFieldException {
        // Obtém o objeto Class associado à classe Tabela1
        Class<Tabela1> tabela1Class = Tabela1.class;

        Field[] campos = tabela1Class.getDeclaredFields();

        for (Field campo : campos) {
            // Verifica se o campo está anotado com Tabela
            if (campo.isAnnotationPresent(Tabela.class)) {
                // Acessa a anotação Tabela
                Tabela tabela = campo.getAnnotation(Tabela.class);

                // Imprime o valor da anotação
                System.out.println("Nome da Tabela: " + tabela.value());
            }
        }
    }
}
