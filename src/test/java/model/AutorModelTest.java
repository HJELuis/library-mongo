package model;

import model.proxy.Model;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AutorModelTest {

    @Test
    void obtenerPorId() {
        // Crear un mock de una dependencia
        Model dependencyModel = Mockito.mock(Model.class);

        Document expectedDocument = crearAutor().orElse(new Document());

        when(dependencyModel.obtenerPorId(expectedDocument)).thenReturn(Optional.of(expectedDocument));


        AutorModel autorModel = new AutorModel(dependencyModel);

        Optional<Document> optionalDocument = autorModel.obtenerPorId(expectedDocument);

        Document actualDocument = optionalDocument.orElse(new Document());

        assertEquals(expectedDocument, actualDocument);
    }

    @Test
    void actualizar() {
        // Crear un mock de una dependencia
        Model dependencyModel = Mockito.mock(Model.class);

        String expectedMessage = "Autor actualizado con exito";

        Document documentoActual = crearAutor().orElse(new Document());

        Document documentoNuevo = new Document().append("nombre", "Gabriel")
                .append("apellido", "Marquez")
                .append("biografia", "fue un escritor, guionista, editor de libros y periodista colombiano. Reconocido por sus novelas y cuentos, también escribió narrativa de no ficción, discursos, reportajes, críticas cinematográficas y memorias.");

        when(dependencyModel.actualizar(documentoActual, documentoNuevo)).thenReturn("actualizado con exito");


        AutorModel autorModel = new AutorModel(dependencyModel);

        String actualMessage = autorModel.actualizar(documentoActual, documentoNuevo);


        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void eliminar() {
        // Crear un mock de una dependencia
        Model dependencyModel = Mockito.mock(Model.class);

        String expectedMessage = "Autor eliminado con exito";

        Document documentoAEliminar= crearAutor().orElse(new Document());

        when(dependencyModel.eliminar(documentoAEliminar)).thenReturn("eliminado con exito");


        AutorModel autorModel = new AutorModel(dependencyModel);

        String actualMessage = autorModel.eliminar(documentoAEliminar);


        assertEquals(expectedMessage, actualMessage);
    }

    private Optional<Document> crearAutor() {

        Document document = new Document().append("titulo", "Cien Años de Soledad")
                .append("autor", "Gabriel García Marquez")
                .append("año" , 1967)
                .append("ISBN", 1234567891011L);


        return Optional.of(document);
    }
}