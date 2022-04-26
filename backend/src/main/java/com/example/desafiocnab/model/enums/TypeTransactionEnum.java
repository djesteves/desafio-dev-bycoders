package com.example.desafiocnab.model.enums;

public enum TypeTransactionEnum {

    DEBITO_PLUS(1),
    BOLETO_MINUS(2),
    FINANCIAMENTO_MINUS(3),
    CREDITO_PLUS(4),
    RECEBIMENTOEMPRESTIMO_PLUS(5),
    VENDAS_PLUS(6),
    RECEBIMENTOTED_PLUS(7),
    RECEBIMENTODOC_PLUS(8),
    ALUGUEL_MINUS(9);

    private final int tipo;

    TypeTransactionEnum(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public static TypeTransactionEnum get(final int tipo) {
        for (final TypeTransactionEnum typeTransactionEnum : values()) {
            if (typeTransactionEnum.getTipo() == (tipo)) {
                return typeTransactionEnum;
            }
        }
        throw new IllegalArgumentException("Tipo não Encontrado");
    }

    public static String getOperator(final int tipo) {
        for (final TypeTransactionEnum typeTransactionEnum : values()) {
            if (typeTransactionEnum.getTipo() == (tipo)) {

                String[] result = typeTransactionEnum.toString().split("_");
                return result[1].trim();
            }
        }
        throw new IllegalArgumentException("Tipo não Encontrado");
    }
}