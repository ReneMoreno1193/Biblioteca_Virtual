package cl.praxis.bibliotecavirtual.service.impl;

import cl.praxis.bibliotecavirtual.entity.Libro;
import cl.praxis.bibliotecavirtual.repository.ILibroRepository;
import cl.praxis.bibliotecavirtual.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements ILibroService {
    @Autowired
    private ILibroRepository libroRepository;

    @Override
    public List<Libro> findAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> findLibroById(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void updateLibro(Long id, Libro libro) {
        Libro libroBD = findLibroById(id).get();
        libroBD.setTitulo(libro.getTitulo() );
        libroBD.setAutor(libro.getAutor());
        libroBD.setIsbn(libro.getIsbn());
        libroRepository.save(libro);

    }

    @Override
    public void delteLibro(Long id) {
         libroRepository.deleteById(id);

    }
}
