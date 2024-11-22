import java.util.concurrent.Semaphore;

public class Supermercado {
    private static final Semaphore semaforoCajas = new Semaphore(2);

    public static void main(String[] args) {
        long tiempoInicial = System.currentTimeMillis();

        String[] carritoCliente1 = {"Leche", "Pan", "Huevos", "Cereal", "Mantequilla"};
        String[] carritoCliente2 = {"Manzanas", "Azúcar", "Arroz", "Pasta", "Tomates"};
        String[] carritoCliente3 = {"Cerveza", "Carne", "Queso", "Verduras", "Lechuga"};
        String[] carritoCliente4 = {"Galletas", "Refresco", "Café", "Sal", "Yogur"};
        String[] carritoCliente5 = {"Papel Higiénico", "Papel Aluminio", "Jabón", "Shampoo", "Detergente"};

        Thread cliente1 = new Thread(new Cliente("Cliente 1", carritoCliente1, tiempoInicial, semaforoCajas));
        Thread cliente2 = new Thread(new Cliente("Cliente 2", carritoCliente2, tiempoInicial, semaforoCajas));
        Thread cliente3 = new Thread(new Cliente("Cliente 3", carritoCliente3, tiempoInicial, semaforoCajas));
        Thread cliente4 = new Thread(new Cliente("Cliente 4", carritoCliente4, tiempoInicial, semaforoCajas));
        Thread cliente5 = new Thread(new Cliente("Cliente 5", carritoCliente5, tiempoInicial, semaforoCajas));

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
    }
}
