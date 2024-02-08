package com.herbert.wanderbyway.entryPoint.rest.search;

import com.herbert.wanderbyway.core.search.SearchItem;
import com.herbert.wanderbyway.core.search.useCases.FindAllByNameUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchRestController {
    FindAllByNameUseCase findAllByNameUseCase;

    public SearchRestController(FindAllByNameUseCase findAllByNameUseCase) {
        this.findAllByNameUseCase = findAllByNameUseCase;
    }

    @GetMapping("/{query}")
    List<SearchItem> searchByName(@PathVariable String query){
        return findAllByNameUseCase.findAllByName(query);
    }
}
