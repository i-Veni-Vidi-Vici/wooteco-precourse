package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Subway {

//    private final InputView inputView;
//    private final OutputView outputView;
//
//
//    public Subway() {
//        inputView = new InputView();
//        outputView = new OutputView();
//
//    }

    void run() {
        initializeStation();
        initializeLine();
        initializeSection();


    }

    private void initializeStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private void initializeLine() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private void initializeSection() {
        initializeTwoLineSection();
        initializeThreeLineSection();
        initializeShinbundangSection();
    }

    private void initializeTwoLineSection() {
        SectionRepository.initialize(LineRepository.checkExistence("2호선"),
                StationRepository.checkExistence("교대역"), StationRepository.checkExistence("역삼역"));
        SectionRepository.add(LineRepository.checkExistence("2호선"),
                StationRepository.checkExistence("강남역"), 2);
    }

    private void initializeThreeLineSection() {
        SectionRepository.initialize(LineRepository.checkExistence("3호선"),
                StationRepository.checkExistence("교대역"), StationRepository.checkExistence("매봉역"));
        SectionRepository.add(LineRepository.checkExistence("3호선"),
                StationRepository.checkExistence("남부터미널역"), 1);
        SectionRepository.add(LineRepository.checkExistence("3호선"),
                StationRepository.checkExistence("양재역 "), 2);
    }

    private void initializeShinbundangSection() {
        SectionRepository.initialize(LineRepository.checkExistence("신분당선"),
                StationRepository.checkExistence("강남역"), StationRepository.checkExistence("양재시민의숲역"));
        SectionRepository.add(LineRepository.checkExistence("신분당선"),
                StationRepository.checkExistence("양재역"), 1);
    }

//    private ReservedDate reserveDate() {
//        boolean isReserving = true;
//        ReservedDate reservedDate = null;
//
//        while (isReserving) {
//            try {
//                reservedDate = new ReservedDate(converter.convertToNumber(inputView.getDate()));
//                isReserving = false;
//            } catch (IllegalArgumentException exception) {
//                outputView.printError("[ERROR]");
//            }
//        }
//
//        return reservedDate;
//    }
}

