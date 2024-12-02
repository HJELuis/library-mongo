package model.state;

public class SinDatos implements Estado {
    @Override
    public void estado() {
        System.out.println("Base de datos no creada");
    }
}
