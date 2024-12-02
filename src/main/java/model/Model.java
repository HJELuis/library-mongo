package model;

import org.bson.Document;

import java.util.Optional;

//Interfaz para uso de patrón de diseño proxy
public interface Model {
    void guardar(Document document);
    void obtener();
    Optional<Document> obtenerPorId(Document document);
    String actualizar(Document documentoActual, Document documentoNuevo);
    String eliminar(Document document);
}
