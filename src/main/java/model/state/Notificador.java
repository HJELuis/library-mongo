package model.state;

public class Notificador {
    private Estado estado;
    public Notificador() {
        this.estado = new SinDatos();
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void estado() {
        this.estado.estado();
    }

}
