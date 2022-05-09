package wooteco.subway.service.dto.station;

public class StationFindResponse {

    private Long id;
    private String name;

    public StationFindResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
