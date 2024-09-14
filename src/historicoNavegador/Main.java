package historicoNavegador;

import estruturaDeDados.listas.ListaSimples;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaSimples<Browser> browserHistory = new ListaSimples<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o tamanho máximo da lista de navegação");
        String sizeHistory = scanner.nextLine();

        while(Integer.parseInt(sizeHistory) <= 0){
            System.out.println("O tamanho deve ser maior do que zero");
            sizeHistory = scanner.nextLine();
        }

        String option;
        try{
            while (true){
                showMenu();
                option = scanner.nextLine();
                switch (option){
                    case "1":
                        checkSize(browserHistory, sizeHistory);
                        System.out.println("Insira a URL: ");
                        String url = scanner.nextLine();
                        browserHistory.add(new Browser(url));
                        break;
                    case "2":
                        browserHistory.showAllElements();
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
        System.out.println("1 - Adicionar nova url");
        System.out.println("2 - Exibir histórico de navegação");
        System.out.println("0 - Sair");
    }

    private static void checkSize(ListaSimples<Browser> browserHistory, String sizeHistory){
        int convertionSize = Integer.parseInt(sizeHistory);

        if(browserHistory.size() >= convertionSize){
            browserHistory.remove(0);
        }
    }
}

