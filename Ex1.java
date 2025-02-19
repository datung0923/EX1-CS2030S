import java.util.Scanner;

/**
 * The main class for CS2030S Exercise 1.
 *
 * @author Wei Tsang
 * @version CS2030S AY24/25 Semester 2
 */
class Ex1 {
  public static void main(String[] args) {

    // Create a scanner to read from standard input.
    Scanner sc = new Scanner(System.in);

    // Create a simulation.  The BankSimulation
    // constructor will read the simulation parameters
    // and initial events using the scanner.
    Simulation simulation = new BankSimulation(sc);

    // Create a new simulator and run the simulation
    new Simulator(simulation).run();

    // Clean up the scanner.
    sc.close();
  }
}
