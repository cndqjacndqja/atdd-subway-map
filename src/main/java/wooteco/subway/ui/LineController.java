package wooteco.subway.ui;

import java.net.URI;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wooteco.subway.dao.LineDao;
import wooteco.subway.domain.Line;
import wooteco.subway.dto.LineRequest;
import wooteco.subway.dto.LineResponse;

@RestController
public class LineController {

    @PostMapping("/lines")
    public ResponseEntity<LineResponse> createLine(@RequestBody LineRequest lineRequest) {
        Line line = new Line(lineRequest.getName(), lineRequest.getColor());
        Long savedId = LineDao.save(line);
        LineResponse lineResponse = new LineResponse(savedId, line.getName(), line.getColor(),
            new ArrayList<>());
        return ResponseEntity.created(URI.create("/lines/" + savedId)).body(lineResponse);
    }
}
