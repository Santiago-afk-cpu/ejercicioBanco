public class CuentaB {
    String titular;
    Integer numeroCuenta;
    Integer saldo;

    public CuentaB(String titular, Integer numeroCuenta, Integer saldo){
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void mostrarDatos(){
        System.out.println("Titular: " + titular);
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
    }

    public void depositarDinero(Integer cantidad){
        saldo += cantidad;
        System.out.println("Se ha depositado: " + cantidad);
    }

    public void retirarDinero(Integer cantidad){
        saldo -= cantidad;
        System.out.println("Se retiro: " + cantidad);
        System.out.println("El saldo restante es: " + saldo);
    }
    
    public void transferirDinero(CuentaB cuenta, Integer cantidad){
        cuenta.saldo += cantidad;
        System.out.println("La cuenta " + titular + " le transfirio " + cantidad + " a " + cuenta.titular);
    }

    public static void main(String[] args) {
        CuentaB cuenta = new CuentaB("Checho", 12345678, 50000);
        CuentaB cuentaDos = new CuentaB("Yeison", 51335778, 70000);

        cuenta.mostrarDatos();
        System.out.println();
        cuenta.depositarDinero(20000);
        System.out.println();
        cuenta.retirarDinero(40000);
        System.out.println();
        cuenta.transferirDinero(cuentaDos, 120000);
        System.out.println();
        cuenta.mostrarDatos();
        System.out.println();
        cuentaDos.mostrarDatos();
        System.out.println();
    }
}