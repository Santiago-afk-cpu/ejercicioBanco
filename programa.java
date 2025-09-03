import java.util.Scanner;


class inventor {
    String nombre;
    int edad;
    private int nivelcreativo;

    public inventor (String nombre,int edad,int nivelcreativo){
        this.nombre = nombre;
        this.edad = edad;
        this.nivelcreativo = nivelcreativo;
    }

    public int getnivelcreativo(){
        return nivelcreativo;    
    }
    public void puntos (int puntos){
        if(puntos > 0){
            nivelcreativo += puntos;
        }
    }

    public void invento(){
        System.out.println();
    }
}
class inventorquimico extends inventor{
    public inventorquimico(String nombre, int edad, int nivelcreativo){
        super(nombre, edad, nivelcreativo);
    }

    @Override
    public void invento(){
        String invento = " una máquina de separación de atomos";
        System.out.println(nombre + " que tiene " + edad + " años inventó " + invento + " con nivel creativo " + getnivelcreativo());
    }
}
class inventormecanico extends inventor{
    public inventormecanico(String nombre, int edad, int nivelcreativo){
        super(nombre, edad, nivelcreativo);
    }
    
    @Override
    public void invento(){
        String invento = " Un motor de aceleracion infinita";
        System.out.println(nombre + " que tiene " + edad + " años invento " + invento + " con nivel creativo " + getnivelcreativo());
    }
}
class inventorsoftware extends inventor{
    public inventorsoftware(String nombre, int edad, int nivelcreativo){
        super(nombre, edad, nivelcreativo);
    }

    @Override
    public void invento(){
        String invento = " Un software que funcione en todos los dispositivos sin adaptacion";
        System.out.println(nombre + " que tiene " + edad + " años invento " + invento + " con nivel creativo " + getnivelcreativo());
    }
}
public class programa {
    public static void main(String[] args) {
        Scanner entrar = new Scanner(System.in);

        inventor juanjo = new inventormecanico("juanjo", 25, 70);
        inventor checho = new inventorsoftware("checho", 25, 80);
        inventor galindo = new inventorquimico("galindo", 27, 60);

        juanjo.puntos(20);
        checho.puntos(15);
        galindo.puntos(30);

        int opcion = 0;

        while(opcion != 4){
            System.out.println("\nElige un inventor:");
            System.out.println("1. Mecánico");
            System.out.println("2. Software");
            System.out.println("3. Químico");
            System.out.println("4. Salir");

            opcion = entrar.nextInt();

            switch(opcion){
                case 1:
                    juanjo.invento();
                    break;
                case 2:
                    checho.invento();
                    break;
                case 3:
                    galindo.invento();
                    break;
                case 4:
                    System.out.println("saliendo");
                    break;
                default:
                    System.out.println("no elegiste ninguna opcion");
                    break;
                }
        }
        entrar.close();
    }
}
