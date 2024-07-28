package cl.praxis.bibliotecavirtual.controller;

import cl.praxis.bibliotecavirtual.entity.Libro;
import cl.praxis.bibliotecavirtual.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibroController {
    @Autowired
    private ILibroService iLibroService;

    @GetMapping("/libros") //ruta url
    public String listarTodosLosLibros(Model model){ //Model Model interfaz para pasar datos desde controlador hacia la vista
        model.addAttribute("libros", iLibroService.findAllLibros());//modeles el objeto que se usará para agregar attr
        return "/listalibros";
    }

    @GetMapping("/nuevoLibro") //para usar este endpoint, debo enviarlo a listalibros para que se pueda ver
    public String registrarNuevoLibro(){
        return "/registrarLibro"; //retorno hacia la vista html

    }
    @PostMapping("/guardarLibro") //postMappin se utiliza para crear o actualizar un recurso
    public String guardarLibro(Libro libro){
        iLibroService.saveLibro(libro);
        return "redirect:/libros"; //el redirect re dirige a ala vista una vez guardado el libro
    }
    @GetMapping("/editarlibros/{id}") //preparación de vista para editar un libro
    public String editarLibro(@PathVariable Long id, Model model){ //indica que extraera el id desde la solicitud url
        Libro libro = iLibroService.findLibroById(id).get(); //capturar libro por id creando un libro
        model.addAttribute("libro", libro);//añadir libro recuperado(findbyid) al model "libro" attb reflejado en vista (libro es el objeto recuperado del sservicio y que se añade al modelo)
        return "/editarlibro"; //devuelve una caden que representa el nombre de la vista que se debe renderizar
     }

     @PostMapping("/actualizarLibro")
    public String actualizarLibro(@RequestParam("id") Long id, Libro libro){
        iLibroService.updateLibro(id, libro);
        return"redirect:/libros";
     }

}
