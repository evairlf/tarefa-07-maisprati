package gerenciadorDeProcessos;

import estruturaDeDados.fila.SimpleQueue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SimpleQueue<Process> processManager = new SimpleQueue<>();
        Scanner scanner = new Scanner(System.in);
        String option;
        try{
            while (true){
                showMenu();
                option = scanner.nextLine();
                switch(option){
                    case "1":
                        System.out.println("Insira o nome do processo: ");
                        String name = scanner.nextLine();
                        while(name == null || name.trim().isEmpty()){
                            System.out.println("O nome do processo deve ser preenchido. Por favor, insira o nome do processo");
                        }

                        processManager.enqueue(new Process(name));
                        break;
                    case "2":
                        if(processManager.isEmpty()){
                            System.out.println("Não há processos na fila do gerenciador");
                            break;
                        }
                        processManager.dequeue();
                        System.out.println("Processo encerrado.");
                        break;
                    case "3":
                        if(processManager.isEmpty()){
                            System.out.println("A fila de processos está vazia.");
                            break;
                        }
                        processManager.showAllElements();
                        break;
                    case "0":
                        System.out.println("Encerrando...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void showMenu() {
        System.out.println("Escolha uma das opções do menu");
        System.out.println("1 - Adicionar um processo à fila");
        System.out.println("2 - Matar processo");
        System.out.println("3 - Ver a fila completa");
        System.out.println("0 - Sair");
    }
}
