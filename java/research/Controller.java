package research;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	 @Autowired 
	    private ResearchRepository researchRepository;

	    @GetMapping(path="/all")
	    public @ResponseBody Iterable<Users> getAllUsers() {
	      return researchRepository.findAll();
	    }

	
}
