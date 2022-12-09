import java.util.*;
public class Batallanaval {
    public static int [][] tablerojugador1=new int[100][100];
    public static int [][] tablerojugador2=new int[100][100];
    public static Scanner leer = new Scanner (System.in);
    public static String nom1,nom2;
    public static int [][] turnojug1;
    public static int [][] turnojug2; 
    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido al Batalla Naval");
        int numeroBarcos1 = 0;
        int numeroBarcos2 = 0;
        boolean numeroBarcosValido1 = false;
        boolean numeroBarcosValido2 = false;   
               System.out.println("Ingrese el nombre del jugador 1");
               nom1 = leer.nextLine();
               do {//bucle-ciclo de repeticion, su condicion es tener un booleano como control
                   try { //bloque de codigo donde pudiera existir un error y este hace un salto
                       System.out.println("Ingrese el numero de barcos que desea colocar de 1 a 4");
                       numeroBarcos1 = leer.nextInt();
                       if (numeroBarcos1 >= 1 && numeroBarcos1 <= 4) {
                           numeroBarcosValido1 = true;
                       } else {
                           System.out.println("El numero de barcos debe ser de 1 a 4");
                       }
                   } catch (Exception e) {//tratamos el problema que se pudo haber generador por el bloque anterior
                       System.out.println("caracter invalido");
                       leer.nextLine();
                   }
               } while (!numeroBarcosValido1);
               for (int i = 0; i < numeroBarcos1; i++) {
                   System.out.println("Ingrese la posicion del barco " + (i + 1) + " en el eje X (0-9)");
                   int coorx = leer.nextInt();
                   System.out.println("Ingrese la posicion del barco " + (i + 1) + " en el eje Y (0-9)");
                   int coory = leer.nextInt();
                   tablerojugador1[coorx][coory] = 1;
               }
               for (int i = 0; i < 50; i++) {
                   System.out.println();
               }
               System.out.println("Ingrese el nombre del jugador 2");
               nom2 = leer.nextLine();
               numeroBarcos2 = 0;
               numeroBarcosValido2 = false;
               do {
                   try {
                       System.out.println("Ingrese el numero de barcos que desea colocar de 1 a 4");
                       numeroBarcos2 = leer.nextInt();
                       if (numeroBarcos2 >= 1 && numeroBarcos2 <= 4) {
                           numeroBarcosValido2 = true;
                       } else {
                           System.out.println("El numero de barcos debe ser de 1 a 4");
                       }
                   } catch (Exception e) {
                       System.out.println("El numero de barcos debe ser de 1 a 4");
                       leer.nextLine();
                   }
               } while (!numeroBarcosValido2);
               for (int i = 0; i < numeroBarcos2; i++) {
                   System.out.println("Ingrese la posicion del barco " + (i + 1) + " en el eje X (0-9)");
                   int posicionX2 = leer.nextInt();
                   System.out.println("Ingrese la posicion del barco " + (i + 1) + " en el eje Y (0-9)");
                   int posicionY2 = leer.nextInt();
                   tablerojugador2[posicionX2][posicionY2] = 1;
               }
               for (int i = 0; i < 50; i++) {
                   System.out.println();
               }
               boolean ganador = false;
               int puntosJugador1 = 0;
               int puntosJugador2 = 0;
               int turno = 1;
               while (!ganador) {
                   if (turno == 1) {
                       System.out.println("Turno de " + nom1);
                       for (int i = 0; i < 10; i++) {
                           for (int j = 0; j < 10; j++) {
                               if (turnojug2[i][j] == 1) {
                                   if (tablerojugador1[i][j] == 1) {
                                       System.out.print("2");
                                   } else {
                                       System.out.print("X");
                                   }
                               } else {
                                   if (tablerojugador1[i][j] == 1) {
                                       System.out.print("1");
                                   } else {
                                       System.out.print("0");
                                   }
                               }
                           }
                           System.out.println();
                       }
                       System.out.println("Puntaje de " + nom1 + ": " + puntosJugador1);
                       System.out.println("Barcos por hundir de " + nom2 + ": " + numeroBarcos2);
                       System.out.println("Ingrese la posicion del tiro en el eje X (0-9)");
                       int posicionX1 = leer.nextInt();
                       System.out.println("Ingrese la posicion del tiro en el eje Y (0-9)");
                       int posicionY1 = leer.nextInt();
                       if (turnojug1[posicionX1][posicionY1] == 1) {
                           System.out.println("tiro repetido, vuelve a tirar");
                       } else {
                           turnojug1[posicionX1][posicionY1] = 1;
                           if (tablerojugador2[posicionX1][posicionY1] == 1) {
                               for (int i = 0; i < 50; i++) {
                                   System.out.println();
                               }
                               System.out.println("Barco hundido");
                               puntosJugador1 += 10;
                               numeroBarcos2--;
                               if (numeroBarcos2 == 0) {
                                   System.out.println("Ganaste " + nom1);
                                   System.out.println("Puntaje de " + nom1 + ": " + puntosJugador1);
                                   System.out.println("Barcos por hundir de " + nom2 + ": " + numeroBarcos2);
                                   System.out.println("Se muestra tablero de " + nom2 + " con sus barcos hunidos y tus tiros fallidos:");
                                   for (int i = 0; i < 10; i++) {
                                       for (int j = 0; j < 10; j++) {
                                           if (turnojug1[i][j] == 1) {
                                               if (tablerojugador2[i][j] == 1) {
                                                   System.out.print("2");
                                               } else {
                                                   System.out.print("X");
                                               }
                                           } else {
                                               if (tablerojugador2[i][j] == 1) {
                                                   System.out.print("1");
                                               } else {
                                                   System.out.print("0");
                                               }
                                           }
                                       }
                                       System.out.println();
                                   }
                                   ganador = true;
                               }
                           } else {
                               for (int i = 0; i < 50; i++) {
                                   System.out.println();
                               }
                               System.out.println("Tiro al agua");
                           }
                           turno = 2;
                       }
                   } else {
                       System.out.println("Turno de " + nom2);
                       for (int i = 0; i < 10; i++) {
                           for (int j = 0; j < 10; j++) {
                               if (turnojug1[i][j] == 1) {
                                   if (tablerojugador2[i][j] == 1) {
                                       System.out.print("2");
                                   } else {
                                       System.out.print("X");
                                   }
                               } else {
                                   if (tablerojugador2[i][j] == 1) {
                                       System.out.print("1");
                                   } else {
                                       System.out.print("0");
                                   }
                               }
                           }
                           System.out.println();
                       }
                       System.out.println("Puntaje de " + nom2 + ": " + puntosJugador2);
                       System.out.println("Barcos por hundir de " + nom1 + ": " + numeroBarcos1);
                       System.out.println("Ingrese la posicion del tiro en el eje X (0-9)");
                       int posicionX2 = leer.nextInt();
                       System.out.println("Ingrese la posicion del tiro en el eje Y (0-9)");
                       int posicionY2 = leer.nextInt();
                       if (turnojug2[posicionX2][posicionY2] == 1) {
                           System.out.println("tiro repetido, vuelve a tirar");
                       } else {
                           turnojug2[posicionX2][posicionY2] = 1;
                           if (tablerojugador1[posicionX2][posicionY2] == 1) {
                               for (int i = 0; i < 50; i++) {
                                   System.out.println();
                               }
                               System.out.println("Barco hundido");
                               puntosJugador2 += 10;
                               numeroBarcos1--;
                               if (numeroBarcos1 == 0) {
                                   System.out.println("Ganaste " + nom2);
                                   System.out.println("Puntaje de " + nom2 + ": " + puntosJugador2);
                                   System.out.println("Barcos por hundir de " + nom1 + ": " + numeroBarcos1);
                                   System.out.println("Se muestra tablero de " + nom1 + " con sus barcos hunidos y tus tiros fallidos:");
                                   for (int i = 0; i < 10; i++) {
                                       for (int j = 0; j < 10; j++) {
                                           if (turnojug2[i][j] == 1) {
                                               if (tablerojugador1[i][j] == 1) {
                                                   System.out.print("2");
                                               } else {
                                                   System.out.print("X");
                                               }
                                           } else {
                                               if (tablerojugador1[i][j] == 1) {
                                                   System.out.print("1");
                                               } else {
                                                   System.out.print("0");
                                               }
                                           }
                                       }
                                       System.out.println();
                                   }
                                   ganador = true;
                               }
                           } else {
                               for (int i = 0; i < 50; i++) {
                                   System.out.println();
                               }
                               System.out.println("Tiro al agua");
                           }
                           turno = 1;
                       }
                   }
               }
           }
       }
    
