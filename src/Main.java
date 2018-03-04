import java.util.*;

public class Main {
    static ArrayList<String> newpass = new ArrayList<String>();
    static ArrayList<String> listpass = new ArrayList<String>();
    static String[][] floor1 = new String [4][4];
    static String[][] floor2 = new String [4][4];
    static String[][] floor3 = new String [4][4];
    static String[][] floor4 = new String [4][4];
    static int[] primeraLetra= new int[3];
    static int[] segundaLetra= new int[3];
    static int[] terceraLetra= new int[3];

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
        return newpass;
    }

    public static void llenarMatrices(ArrayList<String> passwd) {
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!(passwd.isEmpty())) {
                    floor1[i][j] = passwd.get(0);
                    passwd.remove(0);
                } else if (passwd.isEmpty() && i < 4 && j < 4) {
                    floor1[i][j] = listpass.get(0);
                    listpass.remove(0);
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!(passwd.isEmpty())) {
                    floor2[i][j] = passwd.get(0);
                    passwd.remove(0);
                } else if (passwd.isEmpty() && i < 4 && j < 4) {
                    floor2[i][j] = listpass.get(0);
                    listpass.remove(0);
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!(passwd.isEmpty())) {
                    floor3[i][j] = passwd.get(0);
                    passwd.remove(0);
                } else if (passwd.isEmpty() && i < 4 && j < 4) {
                    floor3[i][j] = listpass.get(0);
                    listpass.remove(0);
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!(passwd.isEmpty())) {
                    floor4[i][j] = passwd.get(0);
                    passwd.remove(0);
                } else if (passwd.isEmpty() && i < 4 && j < 4) {
                    floor4[i][j] = listpass.get(0);
                    listpass.remove(0);
                }
            }
        }
    }

    public static ArrayList<String> preLlenado (ArrayList<String> passwd) {
        for (int i= 0 ; i < passwd.size();i++) {
            for (int j=0; j< listpass.size(); j++){
                if (passwd.get(i).equals(listpass.get(j))){
                    listpass.remove(j);
                }
            }
        }
        return listpass;
    }

    public static String[][] crearTrigramas(String message) {
        int j = 0;
        String[][] trigramas = new String[message.length()/2][3];
        for (int i=0; i < message.length(); i = i+3) {
            if (!((i+2) >= message.length())){
                if (message.charAt(i) != message.charAt(i+1) && message.charAt(i+1) != message.charAt(i+2)) {
                    if(message.charAt(i) != message.charAt(i+2)){
                        trigramas[j][0] = String.valueOf(message.charAt(i));
                        trigramas[j][1] = String.valueOf(message.charAt(i+1));
                        trigramas[j][2] = String.valueOf(message.charAt(i+2));
                        j++;
                    } else {
                        trigramas[j][0] = String.valueOf(message.charAt(i));
                        trigramas[j][1] = String.valueOf(message.charAt(i+1));
                        trigramas[j][2] = "X";
                        i--;
                        j++;
                    }
                } else if (message.charAt(i) != message.charAt(i+1)) {
                    trigramas[j][0] = String.valueOf(message.charAt(i));
                    trigramas[j][1] = String.valueOf(message.charAt(i+1));
                    trigramas[j][2] = "X";
                    i--;
                    j++;
                } else {
                    trigramas[j][0] = String.valueOf(message.charAt(i));
                    trigramas[j][1] = "X";
                    trigramas[j][2] = String.valueOf(message.charAt(i+1));
                    i--;
                    j++;
                }
            }
            if ( ((i+2) >= message.length()) &&  !((i+1) >= message.length())){
                if (message.charAt(i) != message.charAt(i+1)) {
                    trigramas[j][0] = String.valueOf(message.charAt(i));
                    trigramas[j][1] = String.valueOf(message.charAt(i+1));
                    trigramas[j][2] = "X";
                    i--;
                    j++;
                } else {
                    trigramas[j][0] = String.valueOf(message.charAt(i));
                    trigramas[j][1] = "X";
                    trigramas[j][2] = String.valueOf(message.charAt(i+1));
                    i--;
                    j++;
                }
            }
            if ( ((i+2) >= message.length()) &&  ((i+1) >= message.length())){
                trigramas[j][0] = String.valueOf(message.charAt(i));
                trigramas[j][1] = "X";
                trigramas[j][2] = "Z";
            }
        }
        return trigramas;
    }
    
    public static void encriptar(String[][] trigramas){
        String encryptedText="";
        for (int i =0 ; i < trigramas.length;i++){
            if(trigramas[i][0]!=null){
                primeraLetra=encontrarPosicion(trigramas[i][0]);
                segundaLetra=encontrarPosicion(trigramas[i][1]);
                terceraLetra=encontrarPosicion(trigramas[i][2]);
                System.out.print(primeraLetra[0]+"\t");
                System.out.print(primeraLetra[1]+"\t");
                System.out.print(primeraLetra[2]+"\n");
                System.out.print(segundaLetra[0]+"\t");
                System.out.print(segundaLetra[1]+"\t");
                System.out.print(segundaLetra[2]+"\n");
                System.out.print(terceraLetra[0]+"\t");
                System.out.print(terceraLetra[1]+"\t");
                System.out.print(terceraLetra[2]+"\n");
                System.out.print("===========\n");
                /*if(terceraLetra[0]==1){
                    encryptedText+=floor1[primeraLetra[1]][segundaLetra[2]];
                } else if(terceraLetra[0]==2){
                    encryptedText+=floor2[primeraLetra[1]][segundaLetra[2]];
                } else if(terceraLetra[0]==3){
                    encryptedText+=floor3[primeraLetra[1]][segundaLetra[2]];
                } else if(terceraLetra[0]==4){
                    encryptedText+=floor4[primeraLetra[1]][segundaLetra[2]];
                } 
                if(primeraLetra[0]==1){
                    encryptedText+=floor1[segundaLetra[1]][terceraLetra[2]];
                } else if(primeraLetra[0]==2){
                    encryptedText+=floor2[segundaLetra[1]][terceraLetra[2]];
                } else if(primeraLetra[0]==3){
                    encryptedText+=floor3[segundaLetra[1]][terceraLetra[2]];
                }else if(primeraLetra[0]==4){
                    encryptedText+=floor4[segundaLetra[1]][terceraLetra[2]];
                }
                if(segundaLetra[0]==1){
                    encryptedText+=floor1[terceraLetra[1]][primeraLetra[2]];
                } else if(segundaLetra[0]==2){
                    encryptedText+=floor2[terceraLetra[1]][primeraLetra[2]];
                } else if(segundaLetra[0]==3){
                    encryptedText+=floor3[terceraLetra[1]][primeraLetra[2]];
                } else if(primeraLetra[0]==4){
                    encryptedText+=floor4[terceraLetra[1]][primeraLetra[2]];
                }*/
                
            }
        }
        //System.out.println(encryptedText);}
    }
    
    public static int[] encontrarPosicion(String letra){
        boolean encontrado=false;
        int[] posicion= new int[3];
        for(int i=0; i <4;i++){
            for (int j=0;j<4;j++){
                if(floor1[i][j].equals(letra)){
                    encontrado=true;
                    posicion[0]=1;
                    posicion[1]=i;
                    posicion[2]=j;
                }
            }
        }
        if(encontrado==false){
            for(int i=0; i <4;i++){
                for (int j=0;j<4;j++){
                    if(floor2[i][j].equals(letra)){
                        encontrado=true;
                        posicion[0]=2;
                        posicion[1]=i;
                        posicion[2]=j;
                    }
                }
            }
        } 
        if(encontrado==false){
            for(int i=0; i <4;i++){
                for (int j=0;j<4;j++){
                    if(floor3[i][j].equals(letra)){
                        encontrado=true;
                        posicion[0]=3;
                        posicion[1]=i;
                        posicion[2]=j;
                    }
                }
            }
        } 
        if(encontrado==false){
                for(int i=0; i <4;i++){
                    for (int j=0;j<4;j++){
                        if(floor4[i][j].equals(letra)){
                            posicion[0]=4;
                            posicion[1]=i;
                            posicion[2]=j;
                        }
                    }
                }
        }
        return posicion;
    }

    public static void main(String[] args) {

        for(int i=48; i < 58; i++) {
            char  letter = (char) i ;
            String letter2 = String.valueOf(letter);
            listpass.add(letter2);
        }
        for(int i=65; i < 91; i++) {
            char  number = (char) i ;
            String number2 = String.valueOf(number);
            listpass.add(number2);
        }
        for(int i=33; i < 125; i++) {
            if (i >= 33 && i < 48) {
                char  simbols = (char) i ;
                String simbols2 = String.valueOf(simbols);
                listpass.add(simbols2);
            }
            if (i >= 58 && i < 65) {
                char  simbols = (char) i ;
                String simbols2 = String.valueOf(simbols);
                listpass.add(simbols2);
            }
            if (i >= 91 && i < 96) {
                char  simbols = (char) i ;
                String simbols2 = String.valueOf(simbols);
                listpass.add(simbols2);
            }
            if (i==124) {
                char  simbols = (char) i ;
                String simbols2 = String.valueOf(simbols);
                listpass.add(simbols2);
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el mensaje que desea encriptar");
        String message = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese una contrasena");
        String password = scanner.nextLine().toUpperCase();
        ArrayList<String> passwd = checkPass(password);
        listpass =(preLlenado(passwd));
        llenarMatrices(passwd);
        encriptar(crearTrigramas(message));
    }
}