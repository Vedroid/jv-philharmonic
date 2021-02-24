package ua.vedroid.cinema.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ConcertSessionRequestDto {
    @NotNull
    private String concertTitle;
    @NotNull
    @Positive
    private Long stageId;
    @NotNull
    private String showTime;

    public String getConcertTitle() {
        return concertTitle;
    }

    public void setConcertTitle(String concertTitle) {
        this.concertTitle = concertTitle;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
