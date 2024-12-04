import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import model.AutorModel;
import model.LibroModel;
import model.UsuarioModel;
import model.state.DatosActualizados;
import model.state.DatosEliminados;
import model.state.DatosGuardados;
import model.state.Notificador;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Optional;

public class Libreria {

    public static void main(String[] args) {
        String connectionString = "mongodb://root:toor@localhost:27017";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("libreria");

        Notificador notificador = new Notificador();
        notificador.estado();

        UsuarioModel usuarioModel = new UsuarioModel("usuarios", database);

        Document usuario = new Document("nombre", "Luis")
                .append("correo", "luis@gmail.com")
                .append("contraseña", "123");
        usuarioModel.guardar(usuario);

        notificador.setEstado(new DatosGuardados());
        notificador.estado();

        LibroModel libroModel = new LibroModel("libros", database);

        Document libro = new Document("titulo","Cien Años de soledad")
                .append("autor", "Gabriel García Marquez")
                .append("año", 1967)
                .append("ISBN", 1234567891011L);
        libroModel.guardar(libro);

        notificador.setEstado(new DatosGuardados());
        notificador.estado();

        AutorModel autorModel = new AutorModel("autores", database);

        Document autorDocument = new Document("nombre", "Gabriel")
                .append("apellido", "García")
                .append("biografia", "fue un escritor, guionista, editor de libros y periodista colombiano. Reconocido por sus novelas y cuentos, también escribió narrativa de no ficción, discursos, reportajes, críticas cinematográficas y memorias.");

        autorModel.guardar(autorDocument);

        notificador.setEstado(new DatosGuardados());
        notificador.estado();



        //Prueba para obtener y actualizar un libro
//        ObjectId objectId = new ObjectId("6750b92df234073ca917df7d");
//
//        Document libroABuscar = new Document("_id",objectId);
//
//        Optional<Document> libroEncontrado = libroModel.obtenerPorId(libroABuscar);
//
//
//        libroEncontrado.ifPresent(libro -> {
//            Document document = new Document("titulo","Cien Años de Soledad (segunda edición)")
//                .append("autor", "Gabriel García Marquez")
//                .append("año", 1967)
//                .append("ISBN", 1234567891011L);
//
//            Document nuevoLibro = new Document("$set", document);
//
//            libroModel.actualizar(libro, nuevoLibro);
//        });
//
//        notificador.setEstado(new DatosActualizados());
//        notificador.estado();
//
//        libroModel.obtener();

        //prueba para eliminar libro

//        libroEncontrado.ifPresent(libroModel::eliminar);
//
//        libroModel.obtener();
//
//        notificador.setEstado(new DatosEliminados());
//        notificador.estado();




        


    }
}
