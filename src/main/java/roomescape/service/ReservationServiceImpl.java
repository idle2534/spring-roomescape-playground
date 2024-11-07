package roomescape.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.dao.ReservationDao;
import roomescape.dao.TimeDao;
import roomescape.domain.Reservation;
import roomescape.domain.Reservation.NotFoundReservationException;
import roomescape.domain.Time;
import roomescape.dto.ReservationRequestDto;
import roomescape.dto.TimeRequestDto;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

  private final ReservationDao reservationDao;
  private final TimeDao timeDao;

  @Override
  public List<Reservation> getReservations() {
    return reservationDao.findAll();
  }

  @Override
  public Reservation addReservation(final ReservationRequestDto reservationRequestDto) {
    Reservation reservation = reservationDao.createReservation(reservationRequestDto);
    return reservation;
  }

  @Override
  public void removeReservation(final Long id) {
    if (reservationDao.deleteReservation(id) == 0)
      throw new NotFoundReservationException();
  }
}
