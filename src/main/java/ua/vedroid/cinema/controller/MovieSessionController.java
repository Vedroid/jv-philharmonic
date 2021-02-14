package ua.vedroid.cinema.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.vedroid.cinema.model.MovieSession;
import ua.vedroid.cinema.model.dto.MovieSessionRequestDto;
import ua.vedroid.cinema.model.dto.MovieSessionResponseDto;
import ua.vedroid.cinema.service.MovieSessionService;
import ua.vedroid.cinema.service.mapper.MovieSessionMapper;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService service;
    private final MovieSessionMapper mapper;

    @Autowired
    public MovieSessionController(MovieSessionService service,
                                  MovieSessionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public void add(@RequestBody MovieSessionRequestDto dto) {
        service.add(mapper.toEntity(dto));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(@RequestParam Long movieId,
                                                         @RequestParam
                                                         @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                                 LocalDate date) {
        return service.findAvailableSessions(movieId, date).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = mapper.toEntity(dto);
        movieSession.setId(id);
        MovieSession updatedMovieSession = service.update(movieSession);
        return "MovieSession " + updatedMovieSession + " - updated";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id, @RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = mapper.toEntity(dto);
        movieSession.setId(id);
        MovieSession deletedMovieSession = service.delete(movieSession);
        return "MovieSession " + deletedMovieSession + " - removed";
    }
}
