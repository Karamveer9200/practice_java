package cs110.class_test;

public class Crypto {
    public static void main(String[] args) {
        String message = "she.may.be.but.little.but.she.is.fierce!";
        //System.out.println(message.charAt(2));

        arrayDisp(message, 5,8);
        System.out.println(" ");
        System.out.println(encrypt(message, 5, 8));
        System.out.println(" ");
        String eMsg = encrypt(message, 5, 8);
        System.out.println(" ");
        eArrayDisp2(eMsg, 8,5);
        System.out.println(" ");
        System.out.println(decrypt(eMsg,8,5));
    }

    // String message to char[][] (2d array)
    static char[][] messageToArray(String message, int x, int y) {
        char[][] encryption = new char[x][y];
        int num = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                encryption[i][j] = message.charAt(num);
                num++;
            }
        }
        return encryption;
    }

    // encrypting the using array and keys
    static String encrypt(String oMessage, int x, int y) {
        String retVal = "";
        char[][] encryption = messageToArray(oMessage, x, y);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                retVal = retVal + encryption[j][i];
            }
        }
        return retVal;
    }


    // encrypted String message to char[][] (2d array)
    static char[][] eMessageToArray2(String message, int x, int y) {
        char[][] array = new char[x][y];
        int num = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = message.charAt(num);
                num++;
            }
        }
        return array;
    }


    // decrypting the using array and keys
    static String decrypt(String eMessage, int x, int y) {
        String retVal = "";
        char[][] decryption = eMessageToArray2(eMessage, x, y);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                retVal = retVal + decryption[j][i];
            }
        }
        return retVal;
    }


    static void arrayDisp(String message, int x, int y) {
        int num = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(message.charAt(num) + " ");
                num++;
            }
            System.out.println(" ");
        }
    }

    static void eArrayDisp2(String message, int x, int y) {
        int num = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(message.charAt(num) + " ");
                num++;
            }
            System.out.println(" ");
        }
    }
}


