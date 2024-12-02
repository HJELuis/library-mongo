package model.state;

public class DatosActualizados implements Estado {

    @Override
    public void estado() {
        System.out.println("Base de datos actualizada");
    }
}
