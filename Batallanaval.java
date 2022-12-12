import java.util.*; //Se abren todas las liberias que se ocupan en el programa
public class BatallaNavalS {
    public static Scanner leer=new Scanner(System.in);
    public static Scanner leer1=new Scanner(System.in);
    public static Scanner leer2=new Scanner(System.in);
    public static void main(String[] args)  {
        ArrayList<String>nom=new ArrayList<String>();
        ArrayList<Integer>k19=new ArrayList<Integer>();
        ArrayList<Integer>puntos=new ArrayList<Integer>();
        ArrayList<Integer>tablero_barcos=new ArrayList<Integer>();
        //SE INICIAN LOS ARREGLOS
        int marcador1=0;
        int marcador2=0;
        int u541=0, ss=0;
        int dimencion=0, cantbar=0, numBarco2=0, ganador=0, barcoss=0, barcos1=0;
        char [][] mapaj1=null;
        char [][] mapaj2=null;
        char [][] mapav1=null;
        char [][] mapav2=null;
        String nomjug;
            System.out.println("Bienvenidos al Batalla Naval");
            System.out.print("Ingresa el dimencion del tablero: ");
            dimencion=leer.nextInt();
            mapaj1= new char[dimencion] [dimencion];//creacion de tableros con datos que el usuario ingreso
            mapaj2= new char[dimencion] [dimencion];
            mapav1= new char[dimencion] [dimencion];//se hace otro tablero vacio que es el que vamos a mostrar al jugador contrario
            mapav2= new char[dimencion] [dimencion];         
            System.out.println("Su tablero es el siguinte: ");
            mapajuego(mapaj1);
            mapajuego(mapaj2);
            mapajuego2(mapav1);//con estos arreglos llenamos el tablero, con barcos y mostramos un tablero vacio al jugador contrario
            mapajuego(mapav2);
            imprimirTablero3(mapaj1);
            System.out.print("Nombre del Jugador 1: ");
            nomjug=leer1.nextLine();
            nom.add(nomjug);
            System.out.println("----------------------------------");
            System.out.println("Solo se admiten 4 Barcos");
            System.out.println("----------------------------------");
            int vf=0;//se tiene que verificar que el ususario no ingrese una cantidad invalida
            while (vf==0){
                System.out.print("Cantidad de barcos no mayor a 4: ");
                cantbar=leer.nextInt();
                if (cantbar>0 && cantbar<=4){
                    k19.add(cantbar);
                    System.out.println("--------------------------------------");
                    vf=1;
                    System.out.println("Flota del jugador 1 "+cantbar+" barcos");
                }else{
                    System.out.println("Valor incorrecto, por favor vuleva a intentar");
                       }
            }
            Barco1(mapaj1, leer, cantbar, u541, tablero_barcos); //llamamos a la funcion para rellenar el primer mapa de juego
            System.out.println("======================================");
            System.out.print("Nombre del jugador 2: ");
            nomjug=leer2.nextLine();
            nom.add(nomjug);
            System.out.println("----------------------------------");
            System.out.println("Solo se admiten 4 Barcos");
            System.out.println("----------------------------------");
            int vf2=0;//se tiene que verificar que el ususario no ingrese una cantidad invalida
            while (vf2==0){
                System.out.print("Cantidad de barcos no mayor a 4: ");
                numBarco2=leer.nextInt();
                if (numBarco2>0 && numBarco2<=4){
                    k19.add(numBarco2);
                    System.out.println( );
                    vf2=1;
                    System.out.println("Flota del jugador 2 "+numBarco2+" barcos");
                }else{
                    System.out.println("Valor incorrecto, por favor vuleva a intentar");
                }
            }
            Barco1(mapaj2, leer, numBarco2, ss, tablero_barcos);//llamamos a la funcion para rellenar el segundo mapa de juego
            System.out.println("------------------------------------------------");
            int pasaono=0, pasaono2=0, acaba=0;
            tiros_jugadores(mapaj1, mapaj2, leer, leer, nom, marcador1, mapav1, mapav2, marcador2, ganador, u541, ss, pasaono, pasaono2, acaba, tablero_barcos, u541, ss);
        }//comenzamos a jugar por tiradas
    public static void mapajuego(char [][]tablero_jugador1){//introducimos barcos, en el primer tablero y los espacios
        for (int a=0; a<tablero_jugador1.length; a++){//vacios los llenamos con una X
            for (int j=0; j<tablero_jugador1.length; j++){
                tablero_jugador1[a][j]='X';
            }
        }
    }
    public static void mapajuego2(char [][]tablero_nadajugador1){//tiradas del jugador en el otro tablero
        for (int a=0; a<tablero_nadajugador1.length; a++){//se muestra el tablero enemigo con # y se marca con una X
            for (int j=0; j<tablero_nadajugador1.length; j++){
                tablero_nadajugador1[a][j]='O';
            }
        }
    }
    public static void imprimirTablero(char [][]tablero_jugadores){
        int b=0;
        int c=0;
        System.out.print("   ");
        for (int i = 0; i < tablero_jugadores.length; i++) {//Tablero con X y Y para ubicar bian las coordenadas
            c++;
            if (i<=8){
                System.out.print(" "+"X"+c+"  ");
            }else{
            System.out.print(" "+c+"  ");
            }
        }
        System.out.println(" ");
        for (int i = 0; i < tablero_jugadores.length; i++) { 
            b++;
            if (i<=8){
                System.out.print("Y"+b);
            }else{
                System.out.print(b);
            }
            for (int j = 0; j < tablero_jugadores[0].length; j++) {//se hace una cajita donde creamos el tablero para cada jugador
                if (j == 0 || j == tablero_jugadores.length - 1) {//lo pone bello, lo encierra en una cajita
                    if (j == 0) {
                         System.out.print("| " + tablero_jugadores[i][j]+"  ");

                    }
                    if (j == tablero_jugadores.length - 1) {
                        System.out.print("  "+tablero_jugadores[i][j] + "  |");
                    }
                } else {
                    System.out.print("  " + tablero_jugadores[i][j] + "  ");
                }
            }
            System.out.println(" ");
        }
}
    public static void imprimirTablero3(char [][]tablero_vacio){//imprimimos un tablero fantasmas para que el enemigo tire
        int b=0;
        int c=0;
        System.out.print("   ");
        for (int i = 0; i < tablero_vacio.length; i++) {
            c++;
            if (i<=8){
                System.out.print(" "+"X"+c+"  ");
            }else{
            System.out.print(" "+c+"  ");
            }
        }
        System.out.println(" ");
        for (int i = 0; i < tablero_vacio.length; i++) { 
            b++;
            if (i<=8){
                System.out.print("Y"+b);
            }else{
                System.out.print(b);
            }
            for (int j = 0; j < tablero_vacio[0].length; j++) {//se hace una cajita donde creamos el tablero para cada jugador
                if (j == 0 || j == tablero_vacio.length - 1) {//lo encierra en una cajita
                      if (j == 0) {
                         System.out.print("| " + tablero_vacio[i][j]+"  ");
                    }
                    if (j == tablero_vacio.length - 1) {
                        System.out.print("  "+tablero_vacio[i][j] + "  |");
                    }
                } else {
                    System.out.print("  " + tablero_vacio[i][j] + "  ");
                }
            }
            System.out.println(" ");
        }
    }
    public static void Barco1(char [][] tablero_jugador1, Scanner leer, int numBarco1, int tbarcos1, ArrayList<Integer>barcosenjuego){
        int bar_ubi=numBarco1;
        int ubicacion_barcos=1;
        tbarcos1=0;
        int barcos1=0;//barco uno
        while (numBarco1>0){//el usuario tiene que poner sus barcos de diferentes tamaños,
            if (ubicacion_barcos==1){//colocando una por una
                ubicacion_barcos+=1;
                barcos1=barcos1+1;
                tbarcos1=barcos1;
                System.out.println("---------------------------------------------");
                System.out.println("Ubicacion del primer Barco, tu primer barco es una Fragata");
                int otra=0;
                while (otra==0){
                    System.out.println("Ubicacion del barco en el eje X: ");
                    int x= leer.nextInt();
                    if (x>0 && x<=tablero_jugador1[0].length ){
                        int comprobarfila=0;
                        while (comprobarfila==0){
                            System.out.println("Ubicacion del barco en el eje Y: ");
                            int y=leer.nextInt();
                            if (y>0 && y<=tablero_jugador1[0].length ){
                                y=y-1;
                                x=x-1;
                                tablero_jugador1[y][x]='V'; 
                                imprimirTablero(tablero_jugador1); 
                                numBarco1=numBarco1-1;
                                otra=1;
                                comprobarfila=1;
                            }else{
                                System.out.println("Fila incorrecta, vuelva a intentar");
                            }
                        }//si el usuario se digita una columna inexistente tendra que volver a ingreasar
                    }else{
                        System.out.println("Columna incorrecta, vuelva a intentar: ");
                    }
                }//terminamos de poner el barco y lo ubicammos con una V
            }else if (ubicacion_barcos==2){//barco dos
                System.out.println("--------------------------------------------------------");
                System.out.println("Ubicacion de tu segundo barco, tu barco es un Destructor");
                int barcodos=2;
                int barcos2=2*1;
                tbarcos1=tbarcos1+barcos2;
                while (barcodos>0){
                    int otra=0;
                    while (otra==0){
                        System.out.println("Ubicacion del barco en el eje X: ");
                        int x= leer.nextInt();
                        if (x>0 && x<=tablero_jugador1[0].length ){//verificamos que el barco este en una fila dentro del tablero
                            int comprobarfila=0;
                            while (comprobarfila==0){
                                System.out.println("Ubicacion del barco en el eje Y: ");
                                int y=leer.nextInt();
                                if (y>0 && y<=tablero_jugador1[0].length ){
                                    // SE COMPRUEBA LA FILA
                                    y=y-1;
                                    x=x-1;
                                    tablero_jugador1[y][x]='A'; //identificador del barco 2
                                    barcodos--;
                                    otra=1;
                                    comprobarfila=1;
                                    imprimirTablero(tablero_jugador1); //imprimir tablero
                                }else{
                                    System.out.println("Fila incorrecta, vuelva a intentar: ");
                                }
                            }//si el usuario se digita una columna inexistente tendra que volver a ingreasar
                        }else{
                            System.out.println("Columna incorrecta, vuelva a intentar: ");
                        }
                    }
                }
                ubicacion_barcos++;
                numBarco1=numBarco1-1;
            }else if (ubicacion_barcos==3){
                System.out.println("--------------------------------------------------------");//ubicacion del barco 3
                System.out.println("Ubicacion de tu segundo barco, tu barco es un Acorazado");
                int barcotres=3;
                int barcos3=3*1;
                tbarcos1=tbarcos1+barcos3;
                while (barcotres>0){
                    int otra=0;
                    while (otra==0){
                        System.out.println("Ubicacion del barco en el eje X: ");
                        int x= leer.nextInt();
                        if (x>0 && x<=tablero_jugador1[0].length ){ //comprobamos que el barco este dentro del tablero,
                            int comprobarfila=0;// de lo contrario tendras que volvar a ingressar una ubicacion
                            while (comprobarfila==0){
                                  System.out.println("Ubicacion del barco en el eje Y: ");
                                int y=leer.nextInt();
                                if (y>0 && y<=tablero_jugador1[0].length ){
                                    y=y-1;
                                    x=x-1;
                                    tablero_jugador1[y][x]='W'; //este barco mide tres posicionesm estara ubicado por W
                                    barcotres--;
                                    otra=1;
                                    comprobarfila=1;
                                    imprimirTablero(tablero_jugador1); 
                                }else{
                                    System.out.println("Fila incorrecta, vuelva a intentar: ");
                                }
                            }//si el usuario se digita una columna inexistente tendra que volver a ingreasar
                        }else{
                            System.out.println("Columna incorrecta, vuelva a intentar: ");
                        }
                    }
                }
                ubicacion_barcos++;
                numBarco1=numBarco1-1;
            }else if (ubicacion_barcos==4){//ubicacion del cuarto barco
                System.out.println("--------------------------------------------------------");
                System.out.println("Ubicacion de tu segundo barco, tu barco es un Portaviones");
                int barcocuatro=4;
                int barcos4=4*1;
                tbarcos1=tbarcos1+barcos4;
                while (barcocuatro>0){
                    int otra=0;
                    while (otra==0){
                        System.out.println("Ubicacion del barco en el eje X: ");
                        int x= leer.nextInt();
                        if (x>0 && x<=tablero_jugador1[0].length ){
                            int comprobarfila=0;//comprobacioin de que la ubicacion si exista
                            while (comprobarfila==0){
                                System.out.println("Ubicacion del barco en el eje Y: ");
                                int y=leer.nextInt();
                                if (y>0 && y<=tablero_jugador1[0].length ){
                                    y=y-1;
                                    x=x-1;
                                    tablero_jugador1[y][x]='L';//lo identifacamos con una L
                                    barcocuatro--;
                                    otra=1;
                                    comprobarfila=1;
                                    imprimirTablero(tablero_jugador1);
                                }else{ 
                                    System.out.println("Fila incorrecta, vuelva a intentar: ");
                                }
                            }//si el usuario se digita una columna inexistente tendra que volver a ingreasar
                        }else{
                            System.out.println("Columna incorrecta, vuelva a intentar: ");
                        }
                    }
                }
                ubicacion_barcos++;
                numBarco1=numBarco1-1;
                barcosenjuego.add(tbarcos1);
            }
        }
        barcosenjuego.add(tbarcos1);
        bar_ubi=tbarcos1;
    }
    public static void tiros_jugadores(char [][] tab_j1, char [][] tab_j2, Scanner leer, Scanner leer1, ArrayList<String> nombres, int puntos_j1, char [][] tab_vacioj1, char [][] tab_sc2, int puntos_j2, int ganador, int Fragata, int Destructor, int ejecutar, int ejecutar2, int terminar, ArrayList<Integer> tablero_lleno, int barcos, int Portaaviones){
        puntos_j1=0;//se empieza a ejecutar el juego, por tiros
        puntos_j2=0;
        int tiros=0;
        int tiros2=0;
        int tiros3=1;
        int perdedor=0;
        while (tiros==0){ 
            if (terminar==0){
            if (tiros==0){
            if (tiros2==0){
            while (tiros2==0){
                tiros2=1;
                System.out.println("Suerte Jugador 1");
                System.out.print("Jugador 1: ");
                System.out.println(nombres.get(0));
                System.out.print("Puntos: ");
                System.out.println(puntos_j1);
                System.out.println("---------------------------------------------");
                System.out.println("Mapa enemmigo, es hora de hundir al enemigo");//imprime tablero con los lugares donde ya se tiro
                imprimirTablero(tab_sc2);
                System.out.println("---------------------------------------------");
                System.out.println("Mapa del enemigo: ");
                imprimirTablero(tab_j1);
                System.out.println("---------------------------------------------");//si el barco fue atacado lo va a mostrar en el tablero contrario
                int xi=0;
                while (xi==0){//creamos una condicion para que el usuario no se salgas de del tablero, si digita un valor incorrecto
                System.out.println("Pon columna para atacar");//tendra que volver a tirar
                int cox= leer.nextInt();
                if (cox>0 && cox<=tab_j2[0].length ){
                    int vfiy=0;
                    while (vfiy==0){
                        System.out.println("Pon fila para atacar");
                        int fiy=leer.nextInt();
                        if (fiy>0 && fiy<=tab_j2[0].length ){
                            fiy=fiy-1;
                            cox=cox-1;
                            if (tab_j2[fiy][cox]=='V'| tab_j2[fiy][cox]=='A' | tab_j2[fiy][cox]=='W' | tab_j2[fiy][cox]=='L'){
                                System.out.println("Bien hecho almirante, le dimos a uno");
                                 System.out.println("---------------------------------------------");
                                System.out.println("Vamos a por otro Capitan");
                                tab_j2[fiy][cox]='X';
                                tab_sc2[fiy][cox]='X';
                                Destructor=Destructor+1;
                                System.out.println(Destructor);
                                puntos_j1+=200;
                                imprimirTablero(tab_sc2);
                                System.out.println("---------------------------------------------");
                                System.out.println("Ronda terminada, comenzando nuevo tiro");
                                vfiy=1; 
                                xi=1;
                                tiros2=0;
                                ganador=0;
                                perdedor=1;
                            }else{//tiro, al vacio, se marca con una #
                                System.out.println("---------------------------------------------");
                                System.out.println("Jajaja ha, sigue intentando marinero");
                                tab_j2[fiy][cox]='#';
                                tab_sc2[fiy][cox]='#';
                                imprimirTablero(tab_sc2);
                                Destructor=Destructor-1;
                                vfiy=1;
                                xi=1;
                                tiros3=0;
                                tiros=0;
                                Destructor=Destructor-1;
                                if(Destructor<-25){//se le asigna un valor a los tiros para poder undir el barco
                                    terminar=1;
                                    System.out.println("Suerte para la proxima marinero de agua dulce...");//creamos una condicion para que el usuario no se salgas de del tablero, si digita un valor incorrecto
                                }                                                                            //tendra que volver a tirar
                            }
                        }else{
                            System.out.println("Fila incorrecta, vuelva a intentar: ");
                        }
                    }
                }else{
                    System.out.println("Columna incorrecta, vuelva a intentar: ");
                }
            }
        }
        }else if(tiros3==0){//le toca tirar al jugador contrario
            while (tiros3==0){
                tiros3=1;
                System.out.println("Suerte Jugador 2");
                System.out.print("Jugador 2: ");
                System.out.println(nombres.get(1));
                System.out.print("Puntos: ");
                System.out.println(puntos_j2);
                System.out.println("---------------------------------------------");
                System.out.println("Mapa enemmigo, es hora de hundir al enemigo");//imprime tablero con los lugares donde ya se tiro
                imprimirTablero3(tab_vacioj1);
                System.out.println("---------------------------------------------");
                System.out.println("Mapa del enemigo: ");
                imprimirTablero(tab_j2);//si el barco fue atacado lo va a mostrar en el tablero contrario
                System.out.println("---------------------------------------------");
                int columnasi=0;//si el barco fue atacado lo va a mostrar en el tablero contrario
                    while (columnasi==0){
                        System.out.println("Pon columna para atacar");
                        int x= leer.nextInt();
                        if (x>0 && x<=tab_j1[0].length ){
                            int comprobarfila=0;
                            while (comprobarfila==0){
                                System.out.println("Pon fila para atacar");
                                int y=leer.nextInt();
                                if (y>0 && y<=tab_j1[0].length ){
                                    y=y-1;
                                    x=x-1;
                                    if (tab_j1[y][x]=='V'| tab_j1[y][x]=='A' | tab_j1[y][x]=='W' | tab_j1[y][x]=='L'){
                                        System.out.println("Bien hecho almirante, le dimos a uno");
                                        System.out.println("---------------------------------------------");
                                        System.out.println("Vamos a por otro Capitan");
                                        tab_j1[y][x]='X';//si le damos a un barco nos dejara tirar nuevamente
                                        tab_vacioj1[y][x]='X';
                                        Fragata=Fragata+1;
                                        puntos_j2+= 200;
                                        imprimirTablero3(tab_vacioj1);
                                        System.out.println("---------------------------------------------");
                                        System.out.println("Ronda terminada, comenzando nuevo tiro");
                                        comprobarfila=1;//termina ronda
                                        columnasi=1;
                                        tiros3=0;
                                        ganador=1;
                                        perdedor=0;
                                        
                                    }else{
                                        System.out.println("Jajaja ha, sigue intentando marinero");
                                        tab_j1[y][x]='X';
                                        tab_vacioj1[y][x]='X';
                                        imprimirTablero3(tab_vacioj1);
                                        comprobarfila=1;
                                        Fragata=Fragata-1;
                                        columnasi=1;
                                        tiros=0;
                                        tiros2=0;
                                        if(Fragata<-25){//contador para hundir barcos
                                            terminar=1;
                                            System.out.println("Suerte para la proxima marinero de agua dulce...");
                                        }
                                    }
                                }else{
                                    System.out.println("Fila incorrecta, vuelva a intentar: ");
                                }
                            }
                        }else{
                            System.out.println("Columna incorrecta, vuelva a intentar:");
                        }
                }
            }
        }
        }
    }else{
        ArrayList<Integer> puntuacion= new ArrayList<Integer>();//termino del juego
        puntuacion.add(puntos_j1);
        puntuacion.add(puntos_j2);
        System.out.println("Bien hecho Capitan Jugador, has hundido toda la flota");
        System.out.print("Nombre: ");//mostramos,puntos,nombre del ganador
        System.out.println(nombres.get(ganador));
        System.out.print("Puntuacion: ");
        System.out.println(puntuacion.get(ganador));
        System.out.println("Nos vemos en la proxima marinero de agua dulce");
        System.out.print("Nombre: ");//perdedor
        System.out.println(nombres.get(perdedor));
        System.out.print("Puntuacion: ");
        System.out.println(puntuacion.get(perdedor));
        System.out.println("Fin, gracias por jugar Batalla Naval");
        tiros = 1;
