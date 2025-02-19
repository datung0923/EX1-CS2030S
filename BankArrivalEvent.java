class BankArrivalEvent extends Event {

  private final Customer customer;
  private final Counter counter;
  private double servicetime;


  public BankArrivalEvent(double arrivaltime, double servicetime, Customer customer, Counter counter) {
    // Call the constructor BankEvent(int, double, int)
    // Initialize the fields
    super(arrivaltime);
    this.servicetime= servicetime;
    this.customer = customer;
    this.counter = counter;
  }

  @Override
  public String toString() {
    String str = "";
    str = String.format(": Customer %d arrives", this.customer.getID());
    return super.toString() + str;
  }

  /**
   * The logic that the simulation should follow when simulating
   * this event.
   *
   * @return An array of new events to be simulated.
   */
  @Override
  public Event[] simulate() {
    Counter freeCounter = Bank.getAvailibleCounter();
    // Attempt to get a free counter from the bank
    //
    if (freeCounter == null) {
      return new Event[] {new BankDepartureEvent(this.getTime(), customer)};
    } else {
      freeCounter.occupy();
      return new Event[] {new BankStartEvent(this.getTime(),servicetime,customer, freeCounter)};
    }
  }
}
