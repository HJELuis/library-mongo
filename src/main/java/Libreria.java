import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import model.UsuarioModel;
import model.state.DatosGuardados;
import model.state.Notificador;
import org.bson.Document;

public class Libreria {

    public static void main(String[] args) {
        String connectionString = "mongodb://root:toor@localhost:27017";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("libreria");

        Notificador notificador = new Notificador();
        notificador.estado();

//        UsuarioModel usuarioModel = new UsuarioModel(database);
//

//        Document segundoDocumento = new Document("nombre", "Enrique")
//                .append("email", "enrique@gmail.com")
//                .append("password", "321");
//
//        //usuarioModel.guardar(document);
//        //usuarioModel.guardar(segundoDocumento);
//
//        //usuarioModel.obtener();
//
//        ObjectId objectId = new ObjectId("674a51ddaf441a33e42ce3e7");
//        Document documentoABuscar = new Document("_id", objectId);
//        usuarioModel.obtenerPorId(documentoABuscar);

        UsuarioModel usuarioModel = new UsuarioModel("usuarios", database);

        Document document = new Document("nombre", "Luis")
                .append("email", "luis@gmail.com")
                .append("password", "123");
        usuarioModel.guardar(document);

        notificador.setEstado(new DatosGuardados());
        notificador.estado();
        


    }
}
