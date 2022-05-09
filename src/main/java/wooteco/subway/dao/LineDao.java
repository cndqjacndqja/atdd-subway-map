package wooteco.subway.dao;

import java.util.List;
import java.util.Optional;
import wooteco.subway.dao.entity.LineEntity;
import wooteco.subway.domain.Line;

public interface LineDao {

    Long save(Line line);

    List<LineEntity> findAll();

    boolean deleteById(Long id);

    Optional<LineEntity> findById(Long id);

    boolean updateById(Long id, Line line);

    boolean existsByName(String name);
}
