package model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Objects;
import java.util.Optional;

public class ModelImplemet implements Model{

    public final MongoCollection<Document> collection;


    public ModelImplemet(String nombre, MongoDatabase database) {
        this.collection = database.getCollection(nombre);
    }


    @Override
    public void guardar(Document document) {
        collection.insertOne(document);
    }

    @Override
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

    @Override
    public Optional<Document> obtenerPorId(Document document) {
        Document usuario = collection.find(document).first();

        if(!Objects.isNull(usuario)) {
            System.out.println(usuario);
            return Optional.of(usuario);
        }
        return Optional.empty();
    }

    @Override
    public String actualizar(Document documentoActual, Document documentoNuevo) {
        UpdateResult updateResult = collection.updateOne(documentoActual, documentoNuevo);

        if(updateResult.getModifiedCount() > 0){
            return "actualizado con éxito";
        } else {
            return "no fue encontrado";
        }
    }

    @Override
    public String eliminar(Document document) {
        DeleteResult deleteResult = collection.deleteOne(document);

        if(deleteResult.getDeletedCount() > 0) {
           return "eliminado con éxito";
        }else {
            return "no fue encontrado";
        }
    }
}
