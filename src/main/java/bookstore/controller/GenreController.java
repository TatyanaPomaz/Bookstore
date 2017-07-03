package bookstore.controller;

import bookstore.model.Genre;
import bookstore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GenreController {
    private GenreService genreService;

    @Autowired(required = true)
    @Qualifier(value = "genreService")
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping(value = "genres", method = RequestMethod.GET)
    public String getListOfGenres(Model model) {
        model.addAttribute("genre", new Genre());
        model.addAttribute("listGenres", genreService.getAllGenres());

        return "genres";
    }

    @RequestMapping(value = "/genres/add", method = RequestMethod.POST)
    public String addGenre(@ModelAttribute("genre") Genre genre) {
        if (genre.getId() == 0) {
            genreService.addGenre(genre);
        } else {
            genreService.updateGenre(genre);
        }

        return "redirect:/genres";
    }

    @RequestMapping("/removegenre/{id}")
    public String removeGenre(@PathVariable("id") long id) {
        genreService.removeGenre(id);

        return "redirect:/genres";
    }

    @RequestMapping("/editgenre/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("genre", genreService.getGenreById(id));
        model.addAttribute("listGenres", genreService.getAllGenres());

        return "genres";
    }

}
