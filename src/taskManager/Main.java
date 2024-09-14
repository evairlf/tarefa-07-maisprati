package taskManager;

import estruturaDeDados.listas.ListaSimples;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaSimples<Task> tasks = new ListaSimples<>();
        Scanner scanner = new Scanner(System.in);
        String option;
        int position;
        try{
            while(true){
                showMenu();
                option = scanner.nextLine();
                switch (option){
                    case "1":
                        System.out.println("Insira o nome da tarefa a ser adicionada: ");
                        String name = scanner.nextLine();
                        tasks.add(new Task(name));
                        break;
                    case "2":
                        System.out.println("A POSIÇÃO da tarefa que deseja remover");
                        position = Integer.parseInt(scanner.nextLine());
                        tasks.remove(position);
                        break;
                    case "3":
                        System.out.println("Indique a POSIÇÃO da tarefa que deseja marcar como conluída: ");
                        position = Integer.parseInt(scanner.nextLine());

                        Task task = tasks.get(position);
                        task.markAsCompleted();

                        System.out.println("A tarefa da posição " + position + " foi marcada como concluída!");
                        break;
                    case "4":
                        tasks.showAllElements();
                        break;
                    case "0":
                        System.out.println("Encerrando...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor selecione novamente.");
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void showMenu(){
        System.out.println("Escolha uma das opções do menu");
        System.out.println("1 - Adicionar nova tarefa");
        System.out.println("2 - Remover uma tarefa");
        System.out.println("3 - Marcar uma tarefa como concluída");
        System.out.println("4 - Exibir todas as tarefas");
        System.out.println("0 - Sair");
    }
}
