package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {	
		
		Scanner sc = new Scanner(System.in); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int number = sc.nextInt();
		System.out.print("Check-in data: (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); 
		System.out.print("Check-out data: (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data de saída(Check-out) é após a data de entrada (check-in)");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservardo: " + reservation);
			
			System.out.println("______________________________________");
			System.out.print("Numero do quarto: ");
			number = sc.nextInt();
			System.out.print("Check-in data: (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Check-out data: (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date(); 
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: A data de reserva deve ser futura");
			}
			else if (!checkOut.after(checkIn)){
				System.out.println("Erro na reserva: A data de saida deve ser após a data de entrada");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservardo: " + reservation);
			}			
		}		
		sc.close(); 
	}
}
