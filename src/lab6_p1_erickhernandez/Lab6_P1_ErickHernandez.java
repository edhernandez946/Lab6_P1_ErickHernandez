package lab6_p1_erickhernandez;

import java.util.Scanner;
import java.util.Random;

public class Lab6_P1_ErickHernandez {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    
    public static void main(String[] args) {
        menu();
        int opcion = sc.nextInt();
        System.out.println("");
        
        while (opcion > 0 && opcion < 3){
            switch (opcion){
                case 1:
                    System.out.println("Conjuntos:");
                    System.out.print("Tamaño del set 1: ");
                    int size1 = sc.nextInt();
                    
                    while (size1 < 1){
                        System.out.println("Ingrese un numero valido (1 o mayor)");
                        size1 = sc.nextInt();
                    }
                    
                    System.out.print("Tamaño del set 2: ");
                    int size2 = sc.nextInt();
                    
                    while (size2 < 1){
                        System.out.println("Ingrese un numero valido (1 o mayor)");
                        size2 = sc.nextInt();
                    }
                    
                    char [] array1 = genRandCharArray(size1);
                    char [] array2 = genRandCharArray(size2);
                    
                    System.out.println("Conjuntos generados: ");
                    System.out.print("SET1: ");
                    imprimir(array1);
                    System.out.println("");
                    System.out.print("SET2: ");
                    imprimir(array2);
                    System.out.println("");
                    
                    System.out.println("Operaciones:");
                    System.out.println("1. Interseccion");
                    System.out.println("2. Diferencia");
                    System.out.println("Ingrese su opcion:");
                    int opcion2 = sc.nextInt();
                    
                    while (opcion2 < 1 || opcion2 > 2){
                        System.out.println("Ingrese 1 o 2");
                        opcion2 = sc.nextInt();
                    }
                    
                    if (opcion2 == 1){
                        if (intersection(array1, array2).length == 0){
                            System.out.println("Conjunto vacio");
                        }  else{
                            System.out.print("El conjunto de interseccion es: ");
                        imprimir(intersection(array1, array2));
                        System.out.println("");
                        }
                        
                    } else {
                        System.out.println("La diferencia es: ");
                        imprimir(difference(array1, array2));
                        
                    }
                    System.out.println("");
                    
                    break;
                case 2:
                    System.out.println("Cuantos primos tienes?");
                    System.out.println("Ingrese el size de su arreglo");
                    int size = sc.nextInt();
                    while (size < 2){//valida que el size sea mayor a 1
                        System.out.println("Size del arreglo debe ser mayor a 1");
                        size = sc.nextInt();
                    }
                    System.out.println("Ingrese limite inferior");
                    int min = sc.nextInt();
                    System.out.println("Ingrese limite superior");
                    int max = sc.nextInt();
                    
                    while (max < min){
                        System.out.println("El maximo debe ser mayor o igul que el minimo");
                        max = sc.nextInt();
                    }
                    
                    int [] arreglo = genRandArray(size, min, max);
                    System.out.println("Arreglo generado:");
                    imprimir2(arreglo);
                    System.out.println("");
                    
                    int [] resultado = getTotalPrimeCount(arreglo);
                    
                    System.out.print("# de divisores primos: ");
                    imprimir2(resultado);
                    System.out.println("");
                    break;
            }
            
            menu();
            opcion = sc.nextInt();
            System.out.println("");
        }
        
        System.out.println("Salio del programa");
    }
    
    public static void menu(){
        System.out.println("1. Conjuntos");
        System.out.println("2. Cuantos primos tienes?");
        System.out.println("Cualquier otro numero sale del programa");
        
        System.out.println("Ingresar opcion");
    }
    
    public static void imprimir(char [] arreglo){
        for (int j = 0; j < arreglo.length; j++){
            System.out.print("[" + arreglo [j] + "]");
        }
    }
    
    public static void imprimir2(int [] arreglo){
        for (int j = 0; j < arreglo.length; j++){
            System.out.print("[" + arreglo [j] + "]");
        }
    }
    
    public static void imprimir3(char [] arreglo){
        char [] unicos = new char [arreglo.length];
        int cuenta = 0;
        
        for (int i = 65; i <= 73; i++){
            for (int j = 0; j < arreglo.length; j++){
                if ((int)arreglo[j] == i){
                    cuenta++;
                    unicos [j] = arreglo [j];
                }
            }
        }
        
        imprimir(unicos);
    }
    
    public static char [] genRandCharArray(int size){
        char [] temporal = new char [size];
        int ascii_letra = 0;
        for (int i = 0; i < size; i++){
            ascii_letra = random.nextInt((73-65)+1)+65;
            temporal [i] = (char)ascii_letra;
        }
        return temporal;
    }
    
    public static char [] intersection(char [] x, char [] y){
        
        char [] res = new char [x.length + y.length + 2];
        int pos = 0;
        
        for (int i = 0; i < x.length - 2; i++){
            for (int j = 0; j < y.length; j++){
                if (y[j] == x[i]){
                    res [pos] = y[j];
                    pos++;
                }
            }
        }
        
  
        String repetidos = "";
        
        for (int i = 0; i < res.length; i++){
            if ((int)res [i] != 0){
                repetidos += res [i];
            }
        }
        
        res = new char [repetidos.length()];
        pos = 0;
        
        for (int i = 0; i < repetidos.length(); i++){
            res [pos] = repetidos.charAt(pos);
            pos++;
        }
        
        String unicos = "";
        
        for (int i = 65; i < 73; i++){
            for (int j = 0; j < res.length; j++){
                if ((int)res[j] == i){
                    unicos += res [j];
                    break;
                }
            }
        }
        
        res = new char [unicos.length()];
        pos = 0;
        
        for (int i = 0; i < unicos.length(); i++){
            res [pos] = unicos.charAt(pos);
            pos++;
        }
        
        
        return res;
    }
    
    public static char [] difference(char [] x, char [] y){
        char [] universo = new char [x.length + y.length];
        
        for (int i = 0; i < x.length; i++){
            universo [i] = x [i];
        }
        
        for (int i = x.length; i < x.length + y.length; i++){
            universo [i] = y [i - x.length];
        }
        
        char [] res = new char [universo.length];
        int pos = 0;
        
        char [] a_eliminar = intersection(x, y);
        
        for (int i = 0; i < a_eliminar.length; i++){
            for (int j = 0; j < universo.length; j++){
                if (universo [j] == a_eliminar [i]){
                    universo [j] = (char)0;
                }
            }
        }
        
        String dif_sin_espacios = "";
        
        for (int i = 0; i < res.length; i++){
            if ((int)universo [i] != 0){
                dif_sin_espacios += universo [i];
            }
        }
        
        String unicos = "";
        
        for (int i = 65; i < 73; i++){
            for (int j = 0; j < res.length; j++){
                if ((int)universo[j] == i){
                    unicos += universo [j];
                    break;
                }
            }
        }
        
        res = new char [unicos.length()];
        pos = 0;
        
        for (int i = 0; i < unicos.length(); i++){
            res [pos] = unicos.charAt(pos);
            pos++;
        }
        
        return res;
    }
    
    public static int [] genRandArray(int size, int inferior, int superior){
        int [] temporal = new int [size];
        for (int i = 0; i < size; i++){
            temporal [i] = random.nextInt((superior - inferior) + 1) + inferior;
        }
        
        return temporal;
    }
    
    public static boolean isPrime(int x){
        boolean vofprimo = true;
        
        for (int i = 2; i < x; i++){
            if (x % i == 0){
                vofprimo = false;
                i = x;
            }
        }
        
        return vofprimo;
    }
    
    public static int countPrimeFactors(int x){
        int factores_primos = 0;
        
        for (int i = 2; i <= x; i++){
            if (x % i == 0){
                if (isPrime(i)){
                    factores_primos++;
                }
            }
        }
        
        return factores_primos;
        
    }
    
    public static int [] getTotalPrimeCount(int [] array){
        int [] res = new int [array.length];
        
        for (int i = 0; i < array.length; i++){
            res [i] = countPrimeFactors(array[i]);
        }
        
        return res;
    }
}
