package model;

import model.proxy.Model;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LibroModelTest {

    @Test
    void obtenerPorId() {
        // Crear un mock de una dependencia
        Model dependencyModel = Mockito.mock(Model.class);

        Document expectedDocument = crearLibro().orElse(new Document());

        when(dependencyModel.obtenerPorId(expectedDocument)).thenReturn(Optional.of(expectedDocument));


        LibroModel libroModel = new LibroModel(dependencyModel);

        Optional<Document> optionalDocument = libroModel.obtenerPorId(expectedDocument);

        Document actualDocument = optionalDocument.orElse(new Document());

        assertEquals(expectedDocument, actualDocument);
    }

    @Test
    void actualizar() {
        // Crear un mock de una dependencia
        Model dependencyModel = Mockito.mock(Model.class);

        String expectedMessage = "Libro actualizado con exito";

        Document documentoActual = crearLibro().orElse(new Document());

        Document documentoNuevo = new Document().append("titulo", "Cien Años de Soledad(segunda edición)")
                .append("autor", "Gabriel García Marquez")
                .append("año", 1967)
                .append("ISBN", 1234567891011L);

        when(dependencyModel.actualizar(documentoActual, documentoNuevo)).thenReturn("actualizado con exito");


        LibroModel LibroModel = new LibroModel(dependencyModel);

        String actualMessage = LibroModel.actualizar(documentoActual, documentoNuevo);


        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void eliminar() {
        // Crear un mock de una dependencia
        Model dependencyModel = Mockito.mock(Model.class);

        String expectedMessage = "Libro eliminado con exito";

        Document documentoAEliminar = crearLibro().orElse(new Document());


        when(dependencyModel.eliminar(documentoAEliminar)).thenReturn("eliminado con exito");


        LibroModel libroModel = new LibroModel(dependencyModel);

        String actualMessage = libroModel.eliminar(documentoAEliminar);


        assertEquals(expectedMessage, actualMessage);
    }

    private Optional<Document> crearLibro() {

        Document document = new Document().append("titulo", "Cien Años de Soledad")
                .append("autor", "Gabriel García Marquez")
                .append("año" , 1967)
                .append("ISBN", 1234567891011L);


        return Optional.of(document);
    }
}