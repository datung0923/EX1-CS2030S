class BankEndEvent extends Event {
  private final double servicetime;
  private final Customer customer;
  private final Counter counter;

  public BankEndEvent(double time, double servicetime, Customer customer, Counter counter) {
    // Call the constructor BankEvent(int, double, int)
    // Initialize the fields
    super(time+servicetime);
    this.servicetime = servicetime;
    this.customer = customer;
    this.counter = counter;
  }

  @Override
  public String toString() {
    String str = "";
    str =
        String.format(
            ": Customer %d service done (by Counter %d)",
            this.customer.getID(), this.counter.getID());
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
    // The current event is a service-end event.
    // Mark the counter is available, then schedule
    // a departure event at the current time.
    counter.free();
    return new Event[] {new BankDepartureEvent(this.getTime(), customer)};
  }
}
