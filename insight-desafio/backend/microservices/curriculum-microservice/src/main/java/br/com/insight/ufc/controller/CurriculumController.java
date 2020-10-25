package br.com.insight.ufc.controller;

import br.com.insight.ufc.dto.CreateCurriculumDTO;
import br.com.insight.ufc.dto.CurriculumDTO;
import br.com.insight.ufc.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/curriculums")
public class CurriculumController {

    private final CurriculumService curriculumService;

    @Autowired
    public CurriculumController(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }


    @GetMapping(
            value = "/{id}"
    )
    public ResponseEntity<CurriculumDTO> getCurriculum(@PathVariable String id) {

        return ResponseEntity.ok().body(curriculumService.findCurriculum(id));

    }

    @GetMapping
    public ResponseEntity<List<CurriculumDTO>> getCurriculums(
            @RequestParam(value = "course", required = false) List<String> courses
    ) {
        return ResponseEntity.ok().body(curriculumService.findCurriculums(courses));

    }

    @PostMapping
    public ResponseEntity<?> createCurriculum(@RequestBody CreateCurriculumDTO request) {

        String id = curriculumService.createCurriculum(request).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PostMapping(
            value = "/{id}/activity"
    )
    public ResponseEntity<?> addActivity(@RequestBody CreateCurriculumDTO request) {

        String id = curriculumService.createCurriculum(request).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();

    }

}
