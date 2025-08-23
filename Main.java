import java.util.ArrayList;
import java.util.List;
class Vehiculo {
    private String marca;
    private String modelo;
    private int velocidad;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    protected void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void mostrarInfo() {
        System.out.println("Vehículo: " + marca + " " + modelo + " | Velocidad: " + velocidad + " km/h");
    }

    public void acelerar() {
        setVelocidad(getVelocidad() + 5);
        System.out.println("El vehículo acelera suavemente. Velocidad: " + getVelocidad() + " km/h");
    }
}

class Coche extends Vehiculo {
    public Coche(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void acelerar() {
        setVelocidad(getVelocidad() + 20);
        System.out.println("El coche acelera rápidamente 🚗💨. Velocidad: " + getVelocidad() + " km/h");
    }
}
class Moto extends Vehiculo {
    public Moto(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void acelerar() {
        setVelocidad(getVelocidad() + 15);
        System.out.println("La moto acelera con agilidad 🏍️💨. Velocidad: " + getVelocidad() + " km/h");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Genérico", "Modelo X");
        Vehiculo v2 = new Coche("Toyota", "Corolla");
        Vehiculo v3 = new Moto("Yamaha", "R3");

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);

        for (Vehiculo v : vehiculos) {
            v.mostrarInfo();
            v.acelerar(); 
            System.out.println();
        }
    }
}
