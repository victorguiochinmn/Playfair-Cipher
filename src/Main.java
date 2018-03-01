import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static ArrayList<String> newpass = new ArrayList<String>();
    static ArrayList<String> listpass = new ArrayList<String>();

    String[][] floor1 = new String [4][4];
    String[][] floor2 = new String [4][4];
    String[][] floor3 = new String [4][4];
    String[][] floor4 = new String [4][4];

    public static ArrayList<String> checkPass (String password) {
        newpass.add(String.valueOf(password.charAt(0)));
        int k;
        for (int i= 0 ; i < password.length();i++) {
            k=0;
            for (int j=0; j< newpass.size(); j++){
                if (String.valueOf(password.charAt(i)).equals(newpass.get(j))){
                    k++;
                }
            }
            if (k==0){
                newpass.add(String.valueOf(password.charAt(i)));
            }
        }
        System.out.println(newpass);
        return newpass;
    }

    public static ArrayList<String> preLlenado (ArrayList<String> password) {
        for (int i= 0 ; i < password.size();i++) {
            for (int j=0; j< listpass.size(); j++){
                if (password.get(i).equals(listpass.get(j))){
                    listpass.remove(j);
                }
            }
        }
        System.out.println(listpass);
        return listpass;
    }


    public static void main(String[] args) {
        for(int i=48; i < 58; i++) {
            char  letter = (char) i ;
            String letter2 = String.valueOf(letter);
            listpass.add(letter2);
        }

        for(int i=65; i < 91; i++) {
            char  letter = (char) i ;
            String letter2 = String.valueOf(letter);
            listpass.add(letter2);
        }

        for(int i=33; i < 125; i++) {
            if (i >= 33 && i < 48) {
                char  letter = (char) i ;
                String letter2 = String.valueOf(letter);
                listpass.add(letter2);
            }
            if (i >= 58 && i < 65) {
                char  letter = (char) i ;
                String letter2 = String.valueOf(letter);
                listpass.add(letter2);
            }
            if (i >= 91 && i < 96) {
                char  letter = (char) i ;
                String letter2 = String.valueOf(letter);
                listpass.add(letter2);
            }
            if (i==124) {
                char  letter = (char) i ;
                String letter2 = String.valueOf(letter);
                listpass.add(letter2);
            }
        }

        System.out.println(listpass.size());

        System.out.println("Ingrese una contrasena");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine().toUpperCase();
        preLlenado(checkPass(password));
        //llenarMatriz(password);

    }
}
