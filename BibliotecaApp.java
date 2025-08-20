import java.util.*;

class Libro {
    String titulo, autor, codigo;
    boolean disponible = true;

    Libro(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
    }

    void mostrarDatos() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", Código: " + codigo + ", Disponible: " + disponible);
    }

    void marcarPrestado() {
        disponible = false;
    }

    void marcarDisponible() {
        disponible = true;
    }
}

class Usuario {
    String nombre, idUsuario;
    ArrayList<Libro> librosPrestados = new ArrayList<>();

    Usuario(String nombre, String idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    void mostrarDatos() {
        System.out.println("Nombre: " + nombre + ", ID: " + idUsuario + ", Libros prestados: " + librosPrestados.size());
    }

    boolean agregarPrestamo(Libro libro) {
        if (librosPrestados.size() < 3) {
            librosPrestados.add(libro);
            return true;
        }
        return false;
    }

    void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }
}

class Prestamo {
    Usuario usuario;
    Libro libro;

    Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
    }

    void mostrarDatos() {
        System.out.println("Usuario: " + usuario.idUsuario + ", Libro: " + libro.titulo);
    }
}

class Biblioteca {
    ArrayList<Libro> libros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Prestamo> prestamos = new ArrayList<>();

    void registrarLibro(String titulo, String autor, String codigo) {
        libros.add(new Libro(titulo, autor, codigo));
        System.out.println("Libro registrado.");
    }

    void registrarUsuario(String nombre, String idUsuario) {
        usuarios.add(new Usuario(nombre, idUsuario));
        System.out.println("Usuario registrado.");
    }

    void prestarLibro(String idUsuario, String codigoLibro) {
        Usuario u = buscarUsuario(idUsuario);
        Libro l = buscarLibro(codigoLibro);
        if (u == null || l == null) {
            System.out.println("Usuario o libro no encontrado.");
            return;
        }
        if (!l.disponible) {
            System.out.println("Libro no disponible.");
            return;
        }
        if (!u.agregarPrestamo(l)) {
            System.out.println("El usuario ya tiene 3 libros.");
            return;
        }

        l.marcarPrestado();
        prestamos.add(new Prestamo(u, l));
        System.out.println("Libro prestado correctamente.");
    }

    void devolverLibro(String idUsuario, String codigoLibro) {
        Prestamo p = buscarPrestamo(idUsuario, codigoLibro);
        if (p == null) {
            System.out.println("Préstamo no encontrado.");
            return;
        }

        p.usuario.devolverLibro(p.libro);
        p.libro.marcarDisponible();
        prestamos.remove(p);
        System.out.println("Libro devuelto correctamente.");
    }

    void mostrarLibrosDisponibles() {
        for (Libro l : libros)
            if (l.disponible)
                l.mostrarDatos();
    }

    void mostrarUsuarios() {
        for (Usuario u : usuarios)
            u.mostrarDatos();
    }

    void mostrarHistorialPrestamos() {
        for (Prestamo p : prestamos)
            p.mostrarDatos();
    }

    Usuario buscarUsuario(String id) {
        for (Usuario u : usuarios)
            if (u.idUsuario.equals(id))
                return u;
        return null;
    }

    Libro buscarLibro(String codigo) {
        for (Libro l : libros)
            if (l.codigo.equals(codigo))
                return l;
        return null;
    }

    Prestamo buscarPrestamo(String id, String codigo) {
        for (Prestamo p : prestamos)
            if (p.usuario.idUsuario.equals(id) && p.libro.codigo.equals(codigo))
                return p;
        return null;
    }
}

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblio = new Biblioteca();
        int op;

        do {
            System.out.println("\n== MENÚ BIBLIOTECA ==");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Ver libros disponibles");
            System.out.println("6. Ver usuarios");
            System.out.println("7. Ver historial de préstamos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Autor: ");
                    String a = sc.nextLine();
                    System.out.print("Código: ");
                    String c = sc.nextLine();
                    biblio.registrarLibro(t, a, c);
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    biblio.registrarUsuario(n, id);
                    break;
                case 3:
                    System.out.print("ID Usuario: ");
                    String idU = sc.nextLine();
                    System.out.print("Código Libro: ");
                    String codL = sc.nextLine();
                    biblio.prestarLibro(idU, codL);
                    break;
                case 4:
                    System.out.print("ID Usuario: ");
                    String idDev = sc.nextLine();
                    System.out.print("Código Libro: ");
                    String codDev = sc.nextLine();
                    biblio.devolverLibro(idDev, codDev);
                    break;
                case 5:
                    biblio.mostrarLibrosDisponibles();
                    break;
                case 6:
                    biblio.mostrarUsuarios();
                    break;
                case 7:
                    biblio.mostrarHistorialPrestamos();
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 0);
        sc.close();
    }
}