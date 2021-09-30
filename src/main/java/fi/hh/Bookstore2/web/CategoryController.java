package fi.hh.Bookstore2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.Bookstore2.domain.Category;
import fi.hh.Bookstore2.domain.CategoryRepository;


@Controller
public class CategoryController {
	 

	@Autowired
	private CategoryRepository crepository; 
	
	// Show all categories
    @RequestMapping(value="/categorylist")
    public String studentList(Model model) {	
        model.addAttribute("categories", crepository.findAll());
        return "categorylist";
    }
  
    // Add new category
    @RequestMapping(value = "/addcategory")
    public String addcategory(Model model){
    	model.addAttribute("category", new Category());
    	model.addAttribute("categories", crepository.findAll());
        return "addcategory";
    }     
    
    // Save new student
    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String save(Category category){
        crepository.save(category);
        return "redirect:categorylist";
    }    

    // Delete student
    @RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long categoryid, Model model) {
    	crepository.deleteById(categoryid);
        return "redirect:categorylist";
    }     
}