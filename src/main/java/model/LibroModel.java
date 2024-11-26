package model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Objects;
import java.util.Optional;

public class LibroModel {

    public final MongoCollection<Document> collection;

    public LibroModel(MongoDatabase database) {collection = database.getCollection("libros"); }

    public void guardar(Document document) {collection.insertOne(document);}

    public void obtener() {
        FindIterable<Document> libros = collection.find();

        for(Document libro: libros) {
            System.out.println(libro);
        }
    }

    public Optional<Document> obtenerPorId(Document document) {
        Document libro = collection.find(document).first();

        if(!Objects.isNull(libro)) {
            System.out.println(libro);
            return  Optional.of(libro);
        }
        return Optional.empty();
    }

    public void actualizar(Document documentoActual, Document documentoNuevo) {
        UpdateResult updateResult = collection.updateOne(documentoActual, documentoNuevo);

        if(updateResult.getModifiedCount() > 0){
            System.out.println("Libro actualizado con éxito");
        } else {
            System.out.println("El libro no fue encontrado");
        }
    }

    public void eliminar(Document document) {
        DeleteResult deleteResult = collection.deleteOne(document);

        if(deleteResult.getDeletedCount() > 0) {
            System.out.println("Libro eliminado con éxito");
        }else {
            System.out.println("El libro no fue encontrado");
        }
    }

}
