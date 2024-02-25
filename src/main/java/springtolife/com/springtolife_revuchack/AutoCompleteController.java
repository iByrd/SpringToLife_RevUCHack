package springtolife.com.springtolife_revuchack;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
// spur of the moment note - add animal noises to accompany users selection
@RestController
public class AutoCompleteController {
    @GetMapping("/getFriendNamesAutocomplete")
    public List<String> getFriendNames(@RequestParam(required = false) String term) {
        try {
            // Load the JSON file from the classpath
            Resource resource = new ClassPathResource("static/json/FriendJSON.json");

            // Use Jackson ObjectMapper to deserialize the JSON into a List of Strings
            ObjectMapper objectMapper = new ObjectMapper();
            List<String> allPokemonNames = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<String>>() {});

            System.out.println(allPokemonNames);
            String userSearch = term.substring(0, 1).toUpperCase() + term.substring(1);

            if (term != null && !term.isEmpty()) {
                // Filter the list based on the user's input
                return allPokemonNames.stream()
                        .filter(name -> name.contains(userSearch))
                        .collect(Collectors.toList());
            } else {
                // Return all names if no filter is provided
                return allPokemonNames;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
