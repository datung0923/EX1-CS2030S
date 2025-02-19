class Counter {
  private final int id;
  private boolean isAvailable;
  private static int lastId = -1;

  public Counter() {
    lastId += 1;
    this.id = lastId;
    isAvailable = true;
  }

  public void occupy() {
    isAvailable = false;
  }

  public void free() {
    isAvailable = true;
  }

  public boolean getAvailibility() {
    return isAvailable;
  }

  public int getID() {
    return id;
  }

  @Override
  public String toString() {
    return "Counter " + id + (isAvailable ? " is available" : " is occupied");
  }
}
