class Customer {
  private final int id;
  private final double arrivalTime;
  private final double serviceTime;
  private static int lastId = -1;

  public Customer(double arrivalTime, double serviceTime) {
    lastId += 1;
    this.id = lastId;
    this.arrivalTime = arrivalTime;
    this.serviceTime = serviceTime;
  }

  public int getID() {
    return id;
  }

  public double getArrivalTime() {
    return arrivalTime;
  }

  public double getServiceTime() {
    return serviceTime;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer %d: Arrives at %.2f, Service Time %.2f", id, arrivalTime, serviceTime);
  }
}
