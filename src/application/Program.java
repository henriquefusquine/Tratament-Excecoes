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
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIN = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIN, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter date to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIN = sdf.parse(sc.next());

			reservation.updateDate(checkIN, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			sc.close();
		} catch (ParseException e) {
			System.out.println("Invalid date format!");
		}
		catch (IllegalArgumentException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
	}
}