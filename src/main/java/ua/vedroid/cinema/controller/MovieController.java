package ua.vedroid.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vedroid.cinema.model.dto.MovieRequestDto;
import ua.vedroid.cinema.model.dto.MovieResponseDto;
import ua.vedroid.cinema.service.MovieService;
import ua.vedroid.cinema.service.mapper.MovieMapper;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService service;
    private final MovieMapper mapper;

    @Autowired
    public MovieController(MovieService service,
                           MovieMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid MovieRequestDto dto) {
        service.add(mapper.toEntity(dto));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return service.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
