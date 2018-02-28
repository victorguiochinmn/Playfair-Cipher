import java.util.Scanner;

public class Main {

    char[] numeros = {'0','1','2','3','4','5','6','7', '8', '9'};
    char[] letras = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char[] simbolos = {'!','"','#','$','%','&','`','(',')','*','+',',','-','.','/',':',';','<','=','>','?','@','[','\\',']','^','_','|'};

    char[][] floor1 = new char [4][4];
    char[][] floor2 = new char [4][4];
    char[][] floor3 = new char [4][4];
    char[][] floor4 = new char [4][4];

    public static char[][] llenarMatriz(char[] newpass) {
        int i,j = 0;


    }

    public static char[] checkPass (String password) {
        char [] newpass = new char [password.length()];
        newpass[0]=password.charAt(0);
        int k,l;
        l=1;
        for (int i= 0 ; i < password.length();i++) {
            k=0;
            for (int j=0; j< newpass.length; j++){
                if (password.charAt(i)== newpass[j]){
                    k++;
                }
            }
            if (k==0){
                newpass[l]=password.charAt(i);
                l++;
            }
        }
        System.out.println(newpass);
        return newpass;
    }

    public static void main(String[] args) {
        System.out.println("Ingrese una contrasena");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        checkPass(password);
        //llenarMatriz(password);

    }
}
