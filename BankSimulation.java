import java.util.Scanner;

public class BankSimulation extends Simulation {

  private Bank bank;
  private Customer[] customers;
  private Event[] initEvents;


  public BankSimulation(Scanner sc) {
    customers = new Customer[sc.nextInt()];
    int numberOfCounters = sc.nextInt();
    this.bank = new Bank(numberOfCounters);
    this.initEvents = new Event[customers.length];

      for (int i = 0; i < customers.length; i++) {
        customers[i] = new Customer(sc.nextDouble(), sc.nextDouble()); // arrivaltime, servicetime
        initEvents[i] =
                new BankArrivalEvent(
                        customers[i].getArrivalTime(), customers[i].getServiceTime(), customers[i], Bank.getAvailibleCounter());

    }
  }

  @Override
  public Event[] getInitialEvents() {
      return this.initEvents;
  }
}