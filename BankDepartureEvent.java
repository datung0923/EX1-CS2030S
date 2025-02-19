class BankDepartureEvent extends Event {
  private final Customer customer;

  public BankDepartureEvent(double time, Customer customer) {
    super(time);
    this.customer = customer;
  }

  @Override
  public String toString() {
    return super.toString() + String.format(": Customer %d departed", customer.getID());
  }

  @Override
  public Event[] simulate() {
    return new Event[] {}; // no follow up event is needed
  }
}
