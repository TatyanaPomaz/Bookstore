package bookstore.controller;

import bookstore.model.Author;
import bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {
    private AuthorService authorService;

    @Autowired(required = true)
    @Qualifier(value = "authorService")
    public void setGenreService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public String getListOfAuthors(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("listAuthors", authorService.getAllAuthors());

        return "authors";
    }

    @RequestMapping(value = "/authors/add", method = RequestMethod.POST)
    public String addGenre(@ModelAttribute("author") Author author) {
        if (author.getId() == 0) {
            authorService.addAuthor(author);
        } else {
            authorService.updateAuthor(author);
        }

        return "redirect:/authors";
    }

    @RequestMapping("/removeauthor/{id}")
    public String removeAuthor(@PathVariable("id") long id) {
        authorService.removeAuthor(id);

        return "redirect:/authors";
    }

    @RequestMapping("/editauthor/{id}")
    public String editAuthor(@PathVariable("id") long id, Model model) {
        model.addAttribute("author", authorService.getAuthorkById(id));
        model.addAttribute("listGenres", authorService.getAllAuthors());

        return "authors";
    }
}
