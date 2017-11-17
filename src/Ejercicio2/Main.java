package Ejercicio2;

class Q1 {
	
	  int n;
	  synchronized int get() {
	    System.out.println("Obtengo: " + n);
	    return n;
	  }
	  synchronized void put(int n) {
	    this.n = n;
	    System.out.println("Pongo: " + n);
	  }
	}
	class Producer1 implements Runnable {
	  Q1 q;
	  Producer1(Q1 q) {
	    this.q = q;
	    new Thread(this, "Productor").start();
	  }
	  public void run() {
	    int i = 0;
	    while(true) {
	      q.put(i++);
	    }
	  }
	}
	class Consumer1 implements Runnable {
	  Q1 q;
	  Consumer1(Q1 q) {
	    this.q = q;
	    new Thread(this, "Consumidor").start();
	  }
	  public void run() {
	    while(true) {
	      q.get();
	    }
	  }
	}
	class PC {
	  public static void main(String args[]) {
	    Q1 q = new Q1();
	    new Producer1(q);
	    new Consumer1(q);
	    System.out.println("Pulsa Control-C para parar.");
	  }
	}

