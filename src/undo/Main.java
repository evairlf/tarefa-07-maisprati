package undo;

import estruturaDeDados.listas.ListaSimples;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ListaSimples<Editor> editorVersions = new ListaSimples<>();
    private static String accumulatedText = "";

    public static void main(String[] args) {
        try {
            while (true) {
                showMenu();
                String option = scanner.nextLine();
                handleOption(option);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void showMenu() {
        System.out.println("Escolha uma das opções do menu:");
        System.out.println("1 - Armazenar texto");
        System.out.println("2 - Desfazer última alteração");
        System.out.println("3 - Desfazer múltiplas alterações");
        System.out.println("4 - Exibir texto");
        System.out.println("0 - Sair");
    }

    private static void handleOption(String option) {
        switch (option) {
            case "1":
                storeText();
                break;
            case "2":
                undoLastChange();
                break;
            case "3":
                undoMultipleChanges();
                break;
            case "4":
                displayText();
                break;
            case "0":
                System.out.println("Encerrando...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void storeText() {
        System.out.print("Insira o texto que deseja armazenar: ");
        String text = scanner.nextLine().trim();

        while (text.isEmpty()) {
            System.out.println("O campo não pode ser vazio! Por favor, insira o texto novamente.");
            text = scanner.nextLine().trim();
        }

        accumulatedText += text + " ";
        editorVersions.add(new Editor(accumulatedText));
    }

    private static void undoLastChange() {
        if (editorVersions.isEmpty()) {
            System.out.println("Não há nada o que desfazer, pois o texto está vazio.");
            return;
        }
        editorVersions.remove(editorVersions.size() - 1);
        if (!editorVersions.isEmpty()) {
            accumulatedText = editorVersions.get(editorVersions.size() - 1).getText();
        } else {
            accumulatedText = "";
        }
    }

    private static void undoMultipleChanges() {
        if (editorVersions.isEmpty()) {
            System.out.println("Não há alterações para desfazer.");
            return;
        }

        System.out.print("Insira o número de alterações a desfazer: ");
        int numChanges = getValidNumber();

        int size = editorVersions.size();
        if (numChanges >= size) {
            System.out.println("Você não pode desfazer mais do que o número total de versões. O máximo disponível é: " + size);
            return;
        }

        while (numChanges-- > 0) {
            editorVersions.remove(editorVersions.size() - 1);
        }
        if (!editorVersions.isEmpty()) {
            accumulatedText = editorVersions.get(editorVersions.size() - 1).getText();
        } else {
            accumulatedText = "";
        }
        System.out.println("Você retrocedeu " + (numChanges + 1) + " alterações.");
    }

    private static void displayText() {
        if (editorVersions.isEmpty()) {
            System.out.println("Você não possui nenhum registro.");
        } else {
            System.out.println(editorVersions.get(editorVersions.size() - 1));
        }
    }

    private static int getValidNumber() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Número inválido. Por favor, insira um número válido.");
            }
        }
    }
}
