package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber; 
	private Date checkIn; 
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getroomNumber() {
		return roomNumber;
	}

	public void setroomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
<<<<<<< HEAD
	public void updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date(); 
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new IllegalArgumentException("Erro na reserva: A data de reserva deve ser futura");
		}
		if (!checkOut.after(checkIn)){
			throw new IllegalArgumentException("Erro na reserva: A data de saida deve ser ap�s a data de entrada");
=======
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date(); 
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Erro na reserva: A data de reserva deve ser futura";
		}
		if (!checkOut.after(checkIn)){
			return "Erro na reserva: A data de saida deve ser ap�s a data de entrada";
>>>>>>> e8c5cc6f94689f287f9f0271b18e00da8c81bcc3
		}
		
		this.checkIn = checkIn; 
		this.checkOut = checkOut; 
		return null; 
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+", "
				+duration()
				+ " nights";
	}
	

}
