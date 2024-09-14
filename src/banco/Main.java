package banco;

import estruturaDeDados.fila.SimpleQueue;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleQueue<Client> bankQueue = new SimpleQueue<>();

    public static void main(String[] args) {
        try {
            while (true) {
                showMenu();
                String option = scanner.nextLine().trim();
                handleOption(option);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void showMenu() {
        System.out.println("Escolha uma das opções do menu:");
        System.out.println("1 - Adicionar cliente à fila");
        System.out.println("2 - Chamar cliente ao guichê");
        System.out.println("3 - Ver a fila completa");
        System.out.println("4 - Buscar cliente por ID");
        System.out.println("0 - Sair");
    }

    private static void handleOption(String option) {
        switch (option) {
            case "1":
                addClientToQueue();
                break;
            case "2":
                serveNextClient();
                break;
            case "3":
                displayQueue();
                break;
            case "4":
                searchClientById();
                break;
            case "0":
                System.out.println("Encerrando...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }
    }

    private static void addClientToQueue() {
        System.out.print("Insira o nome do cliente: ");
        String name = scanner.nextLine().trim();

        while (name.isEmpty()) {
            System.out.println("O nome não pode ser vazio. Por favor, insira o nome do cliente novamente.");
            name = scanner.nextLine().trim();
        }

        Client client = new Client(name);
        bankQueue.enqueue(client);
        System.out.println("Cliente adicionado à fila: " + client);
    }

    private static void serveNextClient() {
        if (bankQueue.isEmpty()) {
            System.out.println("A fila está vazia. Não há clientes para atender.");
        } else {
            Client client = bankQueue.dequeue();
            System.out.println("Atendendo cliente: " + client);
        }
    }

    private static void displayQueue() {
        if (bankQueue.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Fila atual:");
            bankQueue.showAllElements();
        }
    }

    private static void searchClientById() {
        System.out.print("Insira o ID do cliente: ");
        int id = getValidClientId();

        boolean found = false;
        int size = bankQueue.size();
        Client[] clients = new Client[size];


        for (int i = 0; i < size; i++) {
            clients[i] = bankQueue.dequeue();
        }


        for (Client client : clients) {
            if (client.getId() == id) {
                System.out.println("Cliente encontrado: " + client);
                found = true;
                break;
            }
        }


        for (Client client : clients) {
            bankQueue.enqueue(client);
        }

        if (!found) {
            System.out.println("Cliente com ID " + id + " não encontrado na fila.");
        }
    }

    private static int getValidClientId() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Por favor, insira um número válido.");
            }
        }
    }
}
