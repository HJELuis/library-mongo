package model.state;

public class DatosGuardados implements Estado {
    @Override
    public void estado() {
        System.out.println("Datos guardados en la base de datos");
    }
}
