package impressao;

import estruturaDeDados.fila.SimpleQueue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SimpleQueue<Document> documentsQueue = new SimpleQueue<>();
        Scanner scanner = new Scanner(System.in);
        String option;
        try{
            while(true){
                showMenu();
                option = scanner.nextLine();
                switch(option){
                    case "1":
                        System.out.println("Insira o nome do documento que deseja imprimir: ");
                        String name = scanner.nextLine();

                        System.out.println("Insira a quantidade de páginas total do documento ");
                        String pages = scanner.nextLine();
                        while(!checkConvertionPages(pages)){
                            System.out.println("Número de páginas inválido. Por favor insira número de páginas válido.");
                            pages = scanner.nextLine();
                        }

                        System.out.println("Impressão colorida? (Sim ou não)");
                        String isColorful = scanner.nextLine();
                        boolean isColorfulMapped = mapIsColorful(isColorful);

                        documentsQueue.enqueue(new Document(name, Integer.parseInt(pages), isColorfulMapped));
                        break;
                    case "2":
                        if(documentsQueue.isEmpty()){
                            System.out.println("Não há nenhum documento na fila de impressão.");
                            break;
                        }
                        documentsQueue.dequeue();
                        System.out.println("Documento impresso.");
                        break;
                    case "3":
                        if(documentsQueue.isEmpty()){
                            System.out.println("A fila de impressão está vazia.");
                            break;
                        }
                        System.out.println("Fila em ordem de espera");
                        documentsQueue.showAllElements();
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showMenu() {
        System.out.println("Escolha uma das opções do menu");
        System.out.println("1 - Adicionar documento à fila de impressão");
        System.out.println("2 - Imprimir documento");
        System.out.println("3 - Ver a fila completa");
        System.out.println("0 - Sair");
    }

    private static boolean mapIsColorful(String isColorful){
        return switch (isColorful.toLowerCase()) {
            case "sim", "s" -> true;
            default -> false;
        };
    }

    private static boolean checkConvertionPages(String numberPages){
        if(numberPages == null || numberPages.trim().isEmpty()){
            return false;
        }

        try{
            int converted = Integer.parseInt(numberPages);
            if(converted < 0 ){
                return false;
            }

            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
