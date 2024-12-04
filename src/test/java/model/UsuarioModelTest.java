package model;

import model.proxy.Model;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioModelTest {


    @Test
    void obtenerPorId() {
        // Crear un mock de una dependencia
        Model dependencyModel = Mockito.mock(Model.class);

        Document expectedDocument = crearUsuario().orElse(new Document());

        when(dependencyModel.obtenerPorId(expectedDocument)).thenReturn(Optional.of(expectedDocument));


        UsuarioModel usuarioModel = new UsuarioModel(dependencyModel);

        Optional<Document> optionalDocument = usuarioModel.obtenerPorId(expectedDocument);

        Document actualDocument = optionalDocument.orElse(new Document());

        assertEquals(expectedDocument, actualDocument);

    }

    @Test
    void actualizar() {
        // Crear un mock de una dependencia
        Model dependencyModel = Mockito.mock(Model.class);

        String expectedMessage = "Usuario actualizado con exito";

        Document documentoActual = crearUsuario().orElse(new Document());

        Document documentoNuevo = new Document().append("nombre", "luis")
                        .append("email", "luis@email.com")
                                .append("password", "123");

        when(dependencyModel.actualizar(documentoActual, documentoNuevo)).thenReturn("actualizado con exito");


        UsuarioModel usuarioModel = new UsuarioModel(dependencyModel);

        String actualMessage = usuarioModel.actualizar(documentoActual, documentoNuevo);


        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void eliminar() {
        // Crear un mock de una dependencia
        Model dependencyModel = Mockito.mock(Model.class);

        String expectedMessage = "Usuario eliminado con exito";

        Document documentoAEliminar = crearUsuario().orElse(new Document());


        when(dependencyModel.eliminar(documentoAEliminar)).thenReturn("eliminado con exito");


        UsuarioModel usuarioModel = new UsuarioModel(dependencyModel);

        String actualMessage = usuarioModel.eliminar(documentoAEliminar);


        assertEquals(expectedMessage, actualMessage);
    }

    private Optional<Document> crearUsuario() {

        Document document = new Document().append("nombre", "Enrique")
                .append("email", "enrique@email.com")
                .append("password" , "123");


        return Optional.of(document);
    }
}