package ua.vedroid.cinema.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie_sessions")
public class ConcertSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Concert concert;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_hall_id")
    private Stage stage;
    @Column(name = "show_time")
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Concert getMovie() {
        return concert;
    }

    public void setMovie(Concert concert) {
        this.concert = concert;
    }

    public Stage getCinemaHall() {
        return stage;
    }

    public void setCinemaHall(Stage stage) {
        this.stage = stage;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "ConcertSession{"
                + "id=" + id
                + ", concert=" + concert
                + ", stage=" + stage
                + ", showTime=" + showTime
                + '}';
    }
}
