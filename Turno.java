public class Turno {
  private int turno;

  public Turno() {
    turno = 0;
  }

  public int getTurno() {
    return turno;
  }

  public void played() {
    turno = turno == 0 ? 1 : 0;
  }
}
