package algoexpert.string;

public class CaeserCipher {

    public String caesarCypherEncryptor(String str, int key) {
        char[] letters = new char[26];
        for(int i=0;i<26;i++){
            letters[i] =(char) (97 + i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            int val = ((str.charAt(i) + key)-97)%26;
            sb.append(letters[val]);
        }
        return sb.toString();


    }
    public static void main(String[] args) {
        CaeserCipher obj = new CaeserCipher();
        System.out.println(obj.caesarCypherEncryptor("xyz",2));
    }
}
