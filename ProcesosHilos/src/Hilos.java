//clase que extiene de Hilo (Thread)
public class Hilos extends Thread {

	public void run() {

		while (!interrupted()) {
			System.out.println("Mensaje");
		}

		System.out.println("Fin Hilo");
	}

	public void interrumpir() {
		interrupt();
	}

	public static void main(String[] args) {

		//creamos dos hilos
		Hilos h = new Hilos();
		h.start(); //arrancar hilo

		Hilos h2 = new Hilos();
		h2.start();

		//hago una espera de tiempo
		for (int i = 0; i < 30000; i++) {
			// Do nothing
		}

		//detener los hilos
		h.interrumpir();
		h2.interrumpir();
	}
}