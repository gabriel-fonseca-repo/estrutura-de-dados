package br.fonseca.ED.algoritmos;

public class Palindromo {

    public static void main(String[] args) {

        String strOriginalPal = "ABBA";
        String strOriginalNaoPal = "AKWPODKOPAWK";
        System.out.println(ehPalindromo1(strOriginalPal));
        System.out.println(ehPalindromo1(strOriginalNaoPal));

        System.out.println(ehPalindromo2(strOriginalPal));
        System.out.println(ehPalindromo2(strOriginalNaoPal));

    }

    public static boolean ehPalindromo1(String str) {
        return str.equals(reverse(str));
    }

    public static boolean ehPalindromo2(String str) {
        return str.equals(reverseStrBld(str));
    }

    //método com StringBuffer
    public static String reverseStrBld(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    //método "manual"
    public static String reverse(String str) {
        StringBuilder strReversa = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            strReversa.append(str.charAt(i));
        }
        return strReversa.toString();
    }

}
