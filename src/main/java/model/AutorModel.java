package model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Objects;
import java.util.Optional;

public class AutorModel {
    public final MongoCollection<Document> collection;

    public AutorModel(MongoDatabase database) {collection = database.getCollection("autores"); }

    public void guardar(Document document) {collection.insertOne(document);}

    public void obtener() {
        FindIterable<Document> autores = collection.find();

        for(Document autor: autores) {
            System.out.println(autor);
        }
    }

    public Optional<Document> obtenerPorId(Document document) {
        Document autor = collection.find(document).first();

        if(!Objects.isNull(autor)) {
            System.out.println(autor);
            return  Optional.of(autor);
        }
        return Optional.empty();
    }

    public void actualizar(Document documentoActual, Document documentoNuevo) {
        UpdateResult updateResult = collection.updateOne(documentoActual, documentoNuevo);

        if(updateResult.getModifiedCount() > 0){
            System.out.println("Autor actualizado con éxito");
        } else {
            System.out.println("El autor no fue encontrado");
        }
    }

    public void eliminar(Document document) {
        DeleteResult deleteResult = collection.deleteOne(document);

        if(deleteResult.getDeletedCount() > 0) {
            System.out.println("Autor eliminado con éxito");
        }else {
            System.out.println("El autor no fue encontrado");
        }
    }
}
