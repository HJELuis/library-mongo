package model.state;

public class DatosEliminados implements Estado {
    @Override
    public void estado() {
        System.out.println("Datos eliminados de la base de datos");
    }
}
