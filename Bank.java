class Bank {
  private static Counter[] counters;

  public Bank(int numberOfCounters) {
    counters = new Counter[numberOfCounters];
    for (int i = 0; i < numberOfCounters; i++) {
      counters[i] = new Counter();
    }
  }

  public Counter[] getCounters() {
    return counters;
  }

  public static Counter getAvailibleCounter() {
    for (Counter c : counters) {
      if (c.getAvailibility()) {
        return c;
      }
    }
    return null;
  }

  }

