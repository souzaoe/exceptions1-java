package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero do quarto: ");
			int number = sc.nextInt();
			System.out.print("Check-in data: (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); 
			System.out.print("Check-out data: (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservardo: " + reservation);
			
			System.out.println("______________________________________");
			System.out.print("Numero do quarto: ");
			number = sc.nextInt();
			System.out.print("Check-in data: (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Check-out data: (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);							
		}
		catch(ParseException e) {
			System.out.println("Formato de data invlido");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		sc.close(); 
	}
}
