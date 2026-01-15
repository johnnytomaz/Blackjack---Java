import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int card1 = drawRandomCard();
        int card2 = drawRandomCard();

        System.out.println("You get a \n" + cardString(card1) + "\n and a \n" + cardString(card2));
        int total = Math.min(card1, 10) + Math.min(card2, 10);
        System.out.println("Your total is: " + total);

//        if ((card1 == 11 || card1 == 12 || card1 == 13) && (card2 == 11 || card2 == 12 || card2 == 13)) {
//            card1 = 10;
//            card2 = 10;
//            System.out.println("Your total is: " + (card1 + card2));
//        } else if (card2 == 11 || card2 == 12 || card2 == 13) {
//            card2 = 10;
//            System.out.println("Your total is: " + (card1 + card2));
//        } else if (card1 == 11 || card1 == 12 || card1 == 13) {
//            card1 = 10;
//            System.out.println("Your total is: " + (card1 + card2));
//        } else {
//            System.out.println("Your total is: " + (card1 + card2));
//        }

        int dealer1 = drawRandomCard();
        int dealer2 = drawRandomCard();
        System.out.println("\nThe dealer shows \n" + cardString(dealer1) + "\nand has a card facing down \n" + faceDown());
        int dealerTotal = Math.min(dealer1, 10) + Math.min(dealer2, 10);
        System.out.println("The dealer's total is hidden");

        while (true) {
            String answer = hitOrStay();
            if (answer.equals("hit")) {
                int newCard = drawRandomCard();
                total += Math.min(newCard, 10);
                System.out.println("\n You get a \n" + cardString(newCard));
                System.out.println("Your new total is: " + total);
                if (total > 21){
                    System.out.println("Bust! Player loses");
                    System.exit(0);
                }
            } else if (answer.equals("stay")) {
                break;
            }
        }

        System.out.println("\nDealer's turn");
        System.out.println("The dealer's cards are \n" + cardString(dealer1) + "\n and a \n" + cardString(dealer2));
        System.out.println("\nDealer's total is: " + dealerTotal);

        while (dealerTotal < 17){
            int dealerNewCard = drawRandomCard();
            System.out.println("\nDealer gets a\n" + cardString(dealerNewCard));
            dealerTotal += Math.min(dealerNewCard, 10);
        }

        System.out.println("\nDealer's total is: " + dealerTotal);
        System.out.println("Your total is: " + total + "\n");

        if (dealerTotal > 21){
            System.out.println("Bust! Dealer loses.");
            System.exit(0);
        } else if (total > dealerTotal){
            System.out.println("Player wins!");
        } else if (total < dealerTotal){
                System.out.println("Dealer wins!");
        }


        scan.close();

    }

    public static int drawRandomCard() {
        int cardNumber = (int) (Math.random() * 13) + 1;
        return cardNumber;
    }

    public static String cardString(int cardNumber) {

        switch (cardNumber) {
            case 1:
                return
                        "   _____\n" +
                                "  |A _  |\n" +
                                "  | ( ) |\n" +
                                "  |(_'_)|\n" +
                                "  |  |  |\n" +
                                "  |____V|\n";
            case 2:
                return
                        "   _____\n" +
                                "  |2    |\n" +
                                "  |  o  |\n" +
                                "  |     |\n" +
                                "  |  o  |\n" +
                                "  |____Z|\n";
            case 3:
                return
                        "   _____\n" +
                                "  |3    |\n" +
                                "  | o o |\n" +
                                "  |     |\n" +
                                "  |  o  |\n" +
                                "  |____E|\n";
            case 4:
                return
                        "   _____\n" +
                                "  |4    |\n" +
                                "  | o o |\n" +
                                "  |     |\n" +
                                "  | o o |\n" +
                                "  |____h|\n";
            case 5:
                return
                        "   _____ \n" +
                                "  |5    |\n" +
                                "  | o o |\n" +
                                "  |  o  |\n" +
                                "  | o o |\n" +
                                "  |____S|\n";
            case 6:
                return
                        "   _____ \n" +
                                "  |6    |\n" +
                                "  | o o |\n" +
                                "  | o o |\n" +
                                "  | o o |\n" +
                                "  |____6|\n";
            case 7:
                return
                        "   _____ \n" +
                                "  |7    |\n" +
                                "  | o o |\n" +
                                "  |o o o|\n" +
                                "  | o o |\n" +
                                "  |____7|\n";
            case 8:
                return
                        "   _____ \n" +
                                "  |8    |\n" +
                                "  |o o o|\n" +
                                "  | o o |\n" +
                                "  |o o o|\n" +
                                "  |____8|\n";
            case 9:
                return
                        "   _____ \n" +
                                "  |9    |\n" +
                                "  |o o o|\n" +
                                "  |o o o|\n" +
                                "  |o o o|\n" +
                                "  |____9|\n";
            case 10:
                return
                        "   _____ \n" +
                                "  |10  o|\n" +
                                "  |o o o|\n" +
                                "  |o o o|\n" +
                                "  |o o o|\n" +
                                "  |___10|\n";
            case 11:
                return
                        "   _____\n" +
                                "  |J  ww|\n" +
                                "  | o {)|\n" +
                                "  |o o% |\n" +
                                "  | | % |\n" +
                                "  |__%%[|\n";
            case 12:
                return
                        "   _____\n" +
                                "  |Q  ww|\n" +
                                "  | o {(|\n" +
                                "  |o o%%|\n" +
                                "  | |%%%|\n" +
                                "  |_%%%O|\n";
            case 13:
                return
                        "   _____\n" +
                                "  |K  WW|\n" +
                                "  | o {)|\n" +
                                "  |o o%%|\n" +
                                "  | |%%%|\n" +
                                "  |_%%%>|\n";
            default:
                return "Nothing happens.";
        }
    }


    public static String faceDown() {
        return
                "   _____\n" +
                        "  |     |\n" +
                        "  |  J  |\n" +
                        "  | JJJ |\n" +
                        "  |  J  |\n" +
                        "  |_____|\n";
    }

    public static String hitOrStay() {
        System.out.println("Would you like to hit or stay?");
        String response = scan.nextLine();
        if (response.equalsIgnoreCase("stay") || response.equalsIgnoreCase("hit")) {
            return response;
        } else {
            while (true) {
                System.out.println("Please write 'hit' or 'stay'");
                response = scan.nextLine();
                if (response.equalsIgnoreCase("stay") || response.equalsIgnoreCase("hit")) {
                    return response;


                }
            }
        }
    }
}

