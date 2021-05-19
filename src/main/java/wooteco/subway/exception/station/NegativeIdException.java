package wooteco.subway.exception.station;

public class NegativeIdException extends SubwayStationException {
    private static final String MESSAGE = "id값은 음수일 수 없습니다.";

    public NegativeIdException() {
        super(MESSAGE);
    }

}