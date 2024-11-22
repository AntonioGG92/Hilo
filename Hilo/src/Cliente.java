import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {
    private long tiempoInicial;
    private Semaphore semaforo;

    public Cliente(String nombre, String[] carrito, long tiempoInicial, Semaphore semaforo) {
        this.nombre = nombre;
        this.carrito = carrito;
        this.tiempoInicial = tiempoInicial;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            int numeroCaja = obtenerNumeroCaja();
            System.out.println(nombre + " comienza a ser atendido en la caja " + numeroCaja + " al tiempo: "
                    + (System.currentTimeMillis() - this.tiempoInicial) + " ms");

            for (int i = 0; i < carrito.length; i++) {
                procesarProducto(carrito[i]);
                System.out.println(nombre + " pasa el producto " + carrito[i] + " por la caja " + numeroCaja + " al tiempo: "
                        + (System.currentTimeMillis() - this.tiempoInicial) + " ms");
            }

            System.out.println(nombre + " ha terminado en la caja " + numeroCaja + " al tiempo: "
                    + (System.currentTimeMillis() - this.tiempoInicial) + " ms");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaforo.release();
        }
    }

    private void procesarProducto(String producto) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private int obtenerNumeroCaja() {
        return 3 - semaforo.availablePermits();
    }

    private String nombre;
    private String[] carrito;
}
