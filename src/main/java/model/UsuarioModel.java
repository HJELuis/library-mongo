package model;

import com.mongodb.client.MongoDatabase;
import model.proxy.Model;
import model.proxy.ModelImplemet;
import org.bson.Document;

import java.util.Optional;

public class UsuarioModel implements Model {

    private final Model model;

    public UsuarioModel(String nombre, MongoDatabase database) {
        this.model = new ModelImplemet(nombre, database);
    }

    public UsuarioModel(Model model) {
        this.model = model;
    }

    @Override
    public void guardar(Document document) {
        this.model.guardar(document);
    }

    @Override
    public void obtener() {
        this.model.obtener();
    }

    @Override
    public Optional<Document> obtenerPorId(Document document) {
        return this.model.obtenerPorId(document);
    }

    public String actualizar(Document documentoActual, Document documentoNuevo){
        return "Usuario " + this.model.actualizar(documentoActual, documentoNuevo);
    }

    public String eliminar(Document document) {
       return "Usuario " + this.model.eliminar(document);
    }
}
