package com.herbert.wanderbyway.entryPoint.rest.search;

import com.herbert.wanderbyway.core.search.SearchItem;
import com.herbert.wanderbyway.core.search.SearchOptions;
import com.herbert.wanderbyway.core.search.useCases.FindAllByNameUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchRestController {
    FindAllByNameUseCase findAllByNameUseCase;

    public SearchRestController(FindAllByNameUseCase findAllByNameUseCase) {
        this.findAllByNameUseCase = findAllByNameUseCase;
    }

    @GetMapping("/{query}")
    SearchResult searchByName(
            @PathVariable String query,
            @RequestParam(required = false) Boolean airport,
            @RequestParam(required = false) Boolean train,
            @RequestParam(required = false) Boolean city,
            @RequestParam(required = false) Boolean port,
            @RequestParam(required = false) Boolean bus
            ){
        SearchOptions options = new SearchOptions(airport, train, city, port, bus);
        List<SearchItem> results = findAllByNameUseCase.findAllByName(query, options);
        return new SearchResult(results.size(), options, results);
    }
}
