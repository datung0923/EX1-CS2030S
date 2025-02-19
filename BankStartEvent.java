class BankStartEvent extends Event {
  private final Customer customer;
  private final Counter counter;
  private final double servicetime;

  public BankStartEvent(double time, double servicetime,Customer customer, Counter counter) {
    // Call the constructor BankEvent(int, double, int)
    // Initialize the fields
    super(time);
    this.servicetime = servicetime;
    this.customer = customer;
    this.counter = counter;
  }

  /**
   * Returns the string representation of the event,
   * depending on the type of event.
   *
   * @return A string representing the event.
   */
  @Override
  public String toString() {
    String str = "";
    str = String.format(
            ": Customer %d service begin (by Counter %d)",
            this.customer.getID(), this.counter.getID());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    // The current event is a service-begin event.
    // Mark the counter is unavailable, then schedule
    // a service-end event at the current time + service time.
    return new Event[] {new BankEndEvent(this.getTime(),this.servicetime, customer, counter)};
  }
}
