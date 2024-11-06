package model;

public class Horario {
    private String hora;
    private boolean ocupado;

    public Horario(String hora, boolean ocupado) {
        this.hora = hora;
        this.ocupado = ocupado;
    }

    public String getHora() {
        return hora;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
