package cl.praxis.bibliotecavirtual.service;

import cl.praxis.bibliotecavirtual.entity.Libro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ILibroService { //establecer CRUD´s
    List<Libro> findAllLibros();

    Optional<Libro> findLibroById(Long id);
    Libro saveLibro(Libro libro);
    void updateLibro(Long id, Libro libro);
    void delteLibro(Long id);

}
