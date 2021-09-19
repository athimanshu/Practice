package company.kronos;

public class SurajTask2 {

 public static String capitalizeFirstLetters(String s) {
        /*Please implement this method to
capitalize all first letters of the words in the given String.
All other symbols shall remain intact. If a word starts not with a letter, it shall remain intact too.
Assume that the parameter String can only contain spaces and alphanumeric characters.
NOTE: please keep in mind that the words can be divided by single or multiple spaces.
The spaces also can be found at the beginning or the end of the parameter string,
and you need to preserve them.

Please add a main method which evaluates and displays one or more test cases.
*/
        String strValue = s.trim();
        String [] str = strValue.split(" ");
        String newString = "";
        for(int i =0; i<str.length;i++){
            if(str[i].equals(""))
                continue;
            str[i] = str[i].substring(0,1).toUpperCase()+str[i].substring(1, str[i].length());
            newString = newString +" "+str[i];
        }

        return newString;
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        String s ="   hello           suraj how are you !";
        System.out.println(capitalizeFirstLetters(s));

    }

}