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
import ua.vedroid.cinema.model.dto.StageRequestDto;
import ua.vedroid.cinema.model.dto.StageResponseDto;
import ua.vedroid.cinema.service.StageService;
import ua.vedroid.cinema.service.mapper.StageMapper;

@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageService service;
    private final StageMapper mapper;

    @Autowired
    public StageController(StageService service, StageMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid StageRequestDto stageRequestDto) {
        service.add(mapper.toEntity(stageRequestDto));
    }

    @GetMapping
    public List<StageResponseDto> getAll() {
        return service.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
