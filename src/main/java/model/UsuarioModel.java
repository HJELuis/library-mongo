package model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Objects;
import java.util.Optional;

public class UsuarioModel {

    private final MongoCollection<Document> collection;

    public UsuarioModel(MongoDatabase database) {
        collection = database.getCollection("usuarios");
    }

    public void guardar(Document document) {
        collection.insertOne(document);
    }

    public void obtener() {
        FindIterable<Document> usuarios = collection.find();

        for (Document usuario: usuarios) {
//            ObjectId id = usuario.getObjectId("_id");
//            String nombre = usuario.getString("nombre");
//            String email = usuario.getString("email");
//            String password = usuario.getString("passsword");
            System.out.println(usuario);
        }
    }

    public Optional<Document> obtenerPorId(Document document){

        Document usuario = collection.find(document).first();

        if(!Objects.isNull(usuario)) {
            System.out.println(usuario);
            return Optional.of(usuario);
        }
        return Optional.empty();
    }

    public void actualizar(Document documentoActual, Document documentoNuevo){

        UpdateResult updateResult = collection.updateOne(documentoActual, documentoNuevo);

        if(updateResult.getModifiedCount() > 0) {
            System.out.println("Usuario actualizado con éxito");
        } else {
            System.out.println("El usuario no fue encontrado");
        }

    }

    public void eliminar(Document document) {
        DeleteResult deleteResult = collection.deleteOne(document);

        if(deleteResult.getDeletedCount() > 0) {
            System.out.println("Usuario eliminado con éxito");
        } else {
            System.out.println("El usuario no fue encontrado");
        }
    }
}
