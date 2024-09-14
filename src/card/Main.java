package card;

import estruturaDeDados.listas.ListaDupla;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ListaDupla<Card> hand = new ListaDupla<>();
        Scanner scanner = new Scanner(System.in);
        String option;
        String position;
        try{
            while(true){
                showMenu();
                option = scanner.nextLine();
                switch (option){
                    case "1":
                        System.out.println("Insira o valor da carta (2, 3, 4, 5, 6, 7, 8, 9, 10, Valete, Dama, Rei, Ás)");
                        String rank = scanner.nextLine();
                        while(!isValidRank(rank)){
                            System.out.println("Por favor, insira um valor de carta válido (2, 3, 4, 5, 6, 7, 8, 9, 10, Valete, Dama, Rei, Ás)");
                            rank = scanner.nextLine();
                        }

                        System.out.println("Insira o naipe da carta (Espadas, Copas, Ouros, Paus)");
                        String suit = scanner.nextLine();
                        while(!isValidSuit(suit)){
                            System.out.println("Por favor, insira um naipe válido de carta (Espadas, Copas, Ouros, Paus)");
                            suit = scanner.nextLine();
                        }

                        hand.insertLast(new Card(suit, rank));
                        System.out.println("Carta puxada.");
                        break;
                    case "2":
                        System.out.println("Insira a POSIÇÃO em que a carta que deseja descartar se encontra.");
                        position = scanner.nextLine();
                        hand.remove(Integer.parseInt(position));
                        System.out.println("Carta descartada.");
                        break;
                    case "3":
                        if(hand.size() < 2){
                            System.out.println("Você não tem cartas suficientes para trocar de posição");
                            break;
                        }
                        System.out.println("Insira a POSIÇÃO em que a PRIMEIRA carta se encontra (entre 0 e " + (hand.size() - 1) + ")");
                        position = scanner.nextLine();

                        System.out.println("Insira a POSIÇÃO em que a SEGUNDA carta se encontra (entre 0 e " + (hand.size() - 1) + ")");
                        String position2 = scanner.nextLine();
                        hand.swap(Integer.parseInt(position), Integer.parseInt(position2));
                        System.out.println("Posição trocada");
                        break;
                    case "4":
                        if(hand.isEmpty()){
                            System.out.println("Sua mão está vazia.");
                        }

                        hand.showAllElements();
                        break;
                    case "0":
                        System.out.println("Encerrando...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void showMenu(){
        System.out.println("Escolha uma das opções do menu");
        System.out.println("1 - Puxar uma carta");
        System.out.println("2 - Descartar uma carta");
        System.out.println("3 - Trocar a posição de 2 cartas");
        System.out.println("4 - Mostrar a mão");
        System.out.println("0 - Sair");
    }

    private static boolean isValidSuit(String suit){
        switch (suit.toLowerCase()){
            case "espadas":
            case "copas":
            case "ouros":
            case "paus":
                return true;
            default:
                return false;
        }
    }

    private static boolean isValidRank(String rank){
        final Set<String> validRanks = new HashSet<>();
        validRanks.add("2");
        validRanks.add("3");
        validRanks.add("4");
        validRanks.add("5");
        validRanks.add("6");
        validRanks.add("7");
        validRanks.add("8");
        validRanks.add("9");
        validRanks.add("10");
        validRanks.add("valete");
        validRanks.add("dama");
        validRanks.add("rei");
        validRanks.add("ás");

        return validRanks.contains(rank.toLowerCase());
    }
}
