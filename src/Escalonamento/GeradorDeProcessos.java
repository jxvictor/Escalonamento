package Escalonamento;

import java.util.Random;

public class GeradorDeProcessos {

    private Long id = 0l;

    public static final Long INCREMENTAR_ID = 1L;

    public static final Integer VALOR_MAXIMO = 50;

    public static final Integer VALOR_MINIMO = 10;

    public static final Integer DIFERENCA = VALOR_MAXIMO - VALOR_MINIMO;

    public Long gerarQuantidadeDeInstrucoes(){
        Random gerador = new Random(System.currentTimeMillis());
        return (long) (gerador.nextInt(DIFERENCA) + VALOR_MINIMO);
    }
    public Processo gerarProcesso(){
        this.id += INCREMENTAR_ID;
        Processo processo = new Processo(this.id, this.gerarQuantidadeDeInstrucoes());
        return processo;
    }
}