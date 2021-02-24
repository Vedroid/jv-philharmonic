package ua.vedroid.cinema.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
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
import ua.vedroid.cinema.model.ConcertSession;
import ua.vedroid.cinema.model.dto.ConcertSessionRequestDto;
import ua.vedroid.cinema.model.dto.ConcertSessionResponseDto;
import ua.vedroid.cinema.service.ConcertSessionService;
import ua.vedroid.cinema.service.mapper.ConcertSessionMapper;

@RestController
@RequestMapping("/concert-sessions")
public class ConcertSessionController {
    private final ConcertSessionService service;
    private final ConcertSessionMapper mapper;

    @Autowired
    public ConcertSessionController(ConcertSessionService service,
                                    ConcertSessionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public void add(@RequestBody ConcertSessionRequestDto dto) {
        service.add(mapper.toEntity(dto));
    }

    @GetMapping("/available")
    public List<ConcertSessionResponseDto> getAllAvailable(@RequestParam Long concertId,
                                                           @RequestParam
                                                         @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                                 LocalDate date) {
        return service.findAvailableSessions(concertId, date).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid ConcertSessionRequestDto dto) {
        ConcertSession concertSession = mapper.toEntity(dto);
        concertSession.setId(id);
        ConcertSession updatedConcertSession = service.update(concertSession);
        return "ConcertSession " + updatedConcertSession + " - updated";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id) {
        ConcertSession deletedConcertSession = service.delete(id);
        return "ConcertSession " + deletedConcertSession + " - removed";
    }
}
