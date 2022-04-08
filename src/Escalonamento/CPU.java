package Escalonamento;

public class CPU {
    public static final Integer INT_CLOCK = 5; //1 a 5
    Escalonador escalonador;

    public CPU(Escalonador escalonador){
        this.escalonador = escalonador;
    }

    public void executarProcesso() {
    	System.out.println("--------------------------------------------");
    	System.out.println("Inicio de execução de processo             -");
    	System.out.println("--------------------------------------------");
        while(escalonador.hasProcesso()) {
            Processo processo = escalonador.getProcesso();
            for (int i = 0; i < INT_CLOCK && processo.hasInstrucao(); i++) {
                processo.decrescerInstrucoes();
                System.out.println("Processo decrescido, restam: " + processo.getQuantidadeDeInstrucoes() +"processos.");


            }
            //Sleep para cada ciclo
            try { 
            	Thread.sleep (1000); // 1000 = 1 segundo
            } 
            catch (InterruptedException ex) {
            }
            
            System.out.println("--------------------------------------------");
            System.out.println("Fim de clock                               -");
            System.out.println("--------------------------------------------");

            if (!processo.hasInstrucao()) {
                escalonador.excluirProcesso(processo);
                System.out.println("--------------------------------------------");
                System.out.println("Processo concluído.                        -");
                System.out.println("--------------------------------------------");
            }
        }
    }
}
