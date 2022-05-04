package wooteco.subway.service;

import java.util.List;
import org.springframework.stereotype.Service;
import wooteco.subway.dao.LineDao;
import wooteco.subway.domain.Line;

@Service
public class LineService {
    private final LineDao lineDao;

    public LineService(LineDao lineDao) {
        this.lineDao = lineDao;
    }

    public Long save(Line line) {
        validateDuplicationName(line);
        return lineDao.save(line);
    }

    private void validateDuplicationName(Line line) {
        List<Line> lines = lineDao.findAll();
        if (lines.contains(line)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public List<Line> findAll() {
        return lineDao.findAll();
    }

    public boolean deleteById(Long id) {
        return lineDao.deleteById(id);
    }

    public boolean updateById(Long id, Line line) {
        return lineDao.updateById(id, line);
    }
}