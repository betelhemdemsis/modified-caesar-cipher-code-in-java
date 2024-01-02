import java.util.Scanner;

public class Main {
    public static String encrypt(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                char base = Character.isUpperCase(text.charAt(i)) ? 'A' : 'a';
                result += (char) (((text.charAt(i) - base + shift) % 26) + base);
            } else {
                result += text.charAt(i);
            }
        }
        System.out.println("text u entered: " + text);
        System.out.println("Cipher text: " + result);
        return result;
    }

    public static String decrypt(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                char base = Character.isUpperCase(text.charAt(i)) ? 'A' : 'a';
                char shiftedChar = (char) (((text.charAt(i) - base - shift + 26) % 26) + base);
                result += shiftedChar;
            } else {
                result += text.charAt(i);
            }
        }
        System.out.println("text u entered: " + text);
        System.out.println("Cipher text: " + result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message:");
        String plaintext = scanner.nextLine();
        System.out.print("Enter the shift key: ");
        int shift = scanner.nextInt();
        if (shift > 25) {
            System.out.println("Enter a number less than 25! ");
        } else if (shift < 1) {
            System.out.println("Enter a positive number!! ");
        } else {
            System.out.println("choose between the two enter: ");
            System.out.println("1 for Encryption");
            System.out.println("2 for Decryption");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    encrypt(plaintext, shift);
                    break;
                case 2:
                    decrypt(plaintext, shift);
                    break;
                default:
                    System.out.println("invalid enter 1 or 2!");
                    break;
            }
        }
    }
}


