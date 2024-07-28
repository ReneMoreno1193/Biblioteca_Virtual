package cl.praxis.bibliotecavirtual.repository;

import cl.praxis.bibliotecavirtual.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
}
