package cs110.class_test;

public class SimpleChecksum {
    public static void main(String[] args) {
        System.out.println(checksum("rtipjmrohenuqtcyvsxekntxnnlnjpnwyxldpjmgjjroberhulnyqagqesonguwivyhacqymokircxl"));
    }

    static long checksum(String message) {
        long k = 7;
        for (int i = 0; i < message.length(); i++) {
            k *= 23;
            k += message.charAt(i);
            k *= 13;
            k = k % 1000000009;
        }
        return k;
    }
}
