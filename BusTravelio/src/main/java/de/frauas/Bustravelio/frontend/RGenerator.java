package de.frauas.Bustravelio.frontend;

public class RGenerator {
    static String coupon(int n ){
        n = 10;
        String AlphaNumericString = "A012PQRjklmnopqrstRSTWXYZ0BCDEYZ012PQRj12PQRjklmnopqrstRSTUVWkUVWXYZ0BCDEYZ012PQRjklmnopqrstRSTUVWXYZ012PQRSTUVWXYZ3456789abcdefghijklmnopqSTUVWXYZ3456789abcdefghijklFGHIJKghijklmLMNOPQQRSTUVWXYZ012PQRSTUVWXYZ3456789abcdefghijklmnopqrstRSTUVWXYZ012PQRSTUVWXYZ3456789abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length()* Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}