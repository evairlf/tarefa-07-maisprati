package reundo;

import estruturaDeDados.listas.ListaDupla;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDupla<ReundoEditor> editorVersion = new ListaDupla<>();
        Scanner scanner = new Scanner(System.in);
        String option;
        int selectedVersion = -1;
        boolean isRetroceded = false;
        try{
            while(true){
                showMenu();
                option = scanner.nextLine();
                switch (option){
                    case "1":
                        if(isRetroceded){
                            System.out.println("Está é a versão escolhida atual por você:");
                            String actualVersion = getSpecificVersion(editorVersion, selectedVersion);
                            System.out.println(actualVersion);
                            System.out.println("Se você adicionar outro texto agora, não poderá desfazer as alterações passadas");
                            System.out.println("Deseja continuar? (Sim ou não)");
                            String isConfirmed = scanner.nextLine();
                            if(!mapChoseContinue(isConfirmed)){
                                break;
                            }

                            while(selectedVersion <= editorVersion.size() - 1){
                                editorVersion.removeLast();
                            }

                            selectedVersion = -1;
                            isRetroceded = false;
                        }
                        System.out.println("Insira o texo que deseja armazenar: ");
                        String text = scanner.nextLine();

                        while(text == null || text.trim().isEmpty()){
                            System.out.println("O campo não pode ser vazio! Por favor insira o texto que deseja armazenar");
                            text = scanner.nextLine();
                        }

                        ReundoEditor editor = new ReundoEditor.Builder()
                                .text(text)
                                .build();
                        editorVersion.insertLast(editor);
                        break;
                    case "2":
                        if(editorVersion.isEmpty()){
                            System.out.println("Não há nada o que desfazer pois, o texto está vazio.");
                            break;
                        }

                        isRetroceded = true;
                        if(selectedVersion == -1){
                            selectedVersion = editorVersion.size() - 1;
                            break;
                        }

                        selectedVersion--;
                        break;
                    case "3":
                        if(isRetroceded){
                            System.out.println("Você pode voltar até a versão " + editorVersion.size());
                            System.out.println("Insira a versão em que deseja voltar: ");
                            String version = scanner.nextLine();

                            while(!checkConversionNumber(version)){
                                System.out.println("Versão inválida. Por favor insira um número válido.");
                            }

                            selectedVersion = Integer.parseInt(version);
                            System.out.println(editorVersion.get(selectedVersion - 1));
                        }

                        System.out.println("Você não desfez nenhuma alteração ainda.");
                        break;
                    case "4":
                        if(editorVersion.isEmpty()){
                            System.out.println("Você não possui nenhum registro.");
                            break;
                        }

                        if(selectedVersion == -1){
                            System.out.println(getFullText(editorVersion));
                            break;
                        }

                        System.out.println(getSpecificVersion(editorVersion, selectedVersion));
                        break;
                    case "0":
                        System.out.println("Encerrando...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showMenu(){
        System.out.println("Escolha uma das opções do menu");
        System.out.println("1 - Armazenar texto");
        System.out.println("2 - Desfazer última alteração");
        System.out.println("3 - Selecionar uma versão do texto");
        System.out.println("4 - Exibir texto");
        System.out.println("0 - Sair");
    }

    private static boolean checkConversionNumber(String number){
        if(number == null || number.trim().isEmpty()){
            return false;
        }

        try{
            int converted = Integer.parseInt(number);
            if(converted < 0 ){
                return false;
            }

            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    private static String getFullText(ListaDupla<ReundoEditor> editorVersion){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < editorVersion.size(); i++){
            sb.append(editorVersion.get(i).getText());
        }

        return sb.toString();
    }

    private static String getSpecificVersion(ListaDupla<ReundoEditor> editorVersion, int version){
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(version > count){
            sb.append(editorVersion.get(count).getText());
            count++;
        }

        return sb.toString();
    }

    private static boolean mapChoseContinue(String isConfirmed){
        return switch (isConfirmed.toLowerCase()) {
            case "sim", "s" -> true;
            default -> false;
        };
    }
}
