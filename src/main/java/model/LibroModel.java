package model;

import com.mongodb.client.MongoDatabase;
import model.proxy.Model;
import model.proxy.ModelImplemet;
import org.bson.Document;

import java.util.Optional;

public class LibroModel implements Model {

    private final Model model;

    public LibroModel(String nombre, MongoDatabase database) {
        this.model = new ModelImplemet(nombre, database);
    }

    public void guardar(Document document) {
        this.model.guardar(document);
    }

    public void obtener() {
        this.model.obtener();
    }

    public Optional<Document> obtenerPorId(Document document) {
        return this.model.obtenerPorId(document);
    }

    public String actualizar(Document documentoActual, Document documentoNuevo) {
        return "Libro " + this.model.actualizar(documentoActual, documentoNuevo);
    }

    public String eliminar(Document document) {
        return "Libro " + this.model.eliminar(document);
    }

}
