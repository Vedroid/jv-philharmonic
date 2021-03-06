package ua.vedroid.philharmonic.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vedroid.philharmonic.model.dto.ConcertRequestDto;
import ua.vedroid.philharmonic.model.dto.ConcertResponseDto;
import ua.vedroid.philharmonic.service.ConcertService;
import ua.vedroid.philharmonic.service.mapper.ConcertMapper;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertService service;
    private final ConcertMapper mapper;

    @Autowired
    public ConcertController(ConcertService service,
                             ConcertMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid ConcertRequestDto dto) {
        service.add(mapper.toEntity(dto));
    }

    @GetMapping
    public List<ConcertResponseDto> getAll() {
        return service.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
