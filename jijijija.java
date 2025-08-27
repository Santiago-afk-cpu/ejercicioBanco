class brainrot {
    private String nombre;
    private String secret;
    private String raza;
    private String mundo;
    private int edad;
    protected float vida;

    public brainrot(String nombre, String raza, String mundo, int edad, float vida, String secret) {
        this.nombre = nombre;
        this.raza = raza;
        this.mundo = mundo;
        this.edad = edad;
        this.vida = vida;
        this.secret = secret;
    }

    public String getNombre() { 
        return nombre; 
    }

    public int getEdad() { 
        return edad; 
    }

    public String getRaza() { 
        return raza; 
    }

    public String getMundo() { 
        return mundo; 
    }

    public float getVida() { 
        return vida; 
    }

    public String getSecret() { 
        return secret; 
    }
}
class Tralalelo extends brainrot {
    public Tralalelo(String nombre, String raza, String mundo, int edad, float vida, String secret) {
        super(nombre, raza, mundo, edad, vida, secret);
    }

    public String morder() {
        this.vida += 10;
        return getNombre() + "mordio y regenero vida. vida actual:" + this.vida;
    }

    public String restarvida (float vida, int morder){ 
        return "se le resto una cantida de vida considerable"+ (morder-= vida)+ vida; 
    }
}

class tungtungtungsahur extends brainrot {
    public tungtungtungsahur(String nombre, String raza, String mundo, int edad, float vida, String secret){
        super(nombre, raza, mundo, edad, vida, secret);
    }

    public String defensa() {
        if(this.vida > 50){
            this.vida += 20;
            return getNombre() + "activo su defensa. vida actual:" + this.vida;
        } else {
            return getNombre() + "no pudo activar la defensa.";
        }
    }

    public String restarvida (float vida, int golpear){ 
        return "se le resto una cantida de vida considerable"+ (golpear-= vida)+ vida; 
    }
}

class orcaleroorcala extends brainrot {
    public orcaleroorcala(String nombre, String raza, String mundo, int edad, float vida, String secret){
        super(nombre, raza, mundo, edad, vida, secret);
    }

    public String regenerarvida(){
        if(this.vida < 50){
            this.vida += 30;
            return getNombre() + "regeneró vida. vida actual:" + this.vida;
        } else {
            return getNombre() + "ya tiene vida suficiente.";
        }
    }

    public String restarvida (float vida, int morder){
         return "se le resto una cantida de vida considerable"+ (morder-= vida)+ vida;
    }
}

public class jijijija {
    public static void main(String[] args) {
        Tralalelo p1 = new Tralalelo("Tralalero Tralala", "tiburon", "tierra", 120, 40, "roba brainrot");
        tungtungtungsahur p2 = new tungtungtungsahur("Tung Tung Tung Sahur", "madera", "tierra", 300, 70, "destruye brainrot");
        orcaleroorcala p3 = new orcaleroorcala("orcaleroorcala", "ballena", "tierra", 200, 20, "crea briainrot");

        System.out.println(p1.morder());
        System.out.println(p2.defensa());
        System.out.println(p3.regenerarvida());
    }
}
