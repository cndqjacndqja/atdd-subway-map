package wooteco.subway.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wooteco.subway.admin.domain.Line;
import wooteco.subway.admin.dto.LineRequest;
import wooteco.subway.admin.dto.LineResponse;
import wooteco.subway.admin.repository.LineRepository;

import java.net.URI;

@RestController
@RequestMapping("/lines")
public class LineController {
    private LineRepository lineRepository;

    public LineController(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @PostMapping
    public ResponseEntity createLines(@RequestBody LineRequest view) {
        Line line = view.toLine();
        Line persistLine = lineRepository.save(line);

        return ResponseEntity
                .created(URI.create("/lines/"+ persistLine.getId()))
                .body(LineResponse.of(persistLine));
    }

    @GetMapping
    public ResponseEntity showLines() {
        return ResponseEntity.ok().body(lineRepository.findAll());
    }
}
