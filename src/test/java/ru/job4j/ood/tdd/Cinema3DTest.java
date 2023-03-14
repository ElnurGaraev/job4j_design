package ru.job4j.ood.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Calendar;
import java.util.List;

@Disabled
public class Cinema3DTest {
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D());
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(ses -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenSessionIsNotExists() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        assertThatThrownBy(() -> cinema.find(s -> false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сеанс не найден");
    }

    @Test
    public void whenBuyTicketAndPlaceWasTaken() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        Ticket ticket = cinema.buy(account, 5, 3, Calendar.getInstance());
        assertThatThrownBy(() -> cinema.buy(account, 5, 3, Calendar.getInstance()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Место уже занято");
    }
}