package esercizio2;

import java.util.Scanner;

public class MainEsercizio2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try {
			System.out.println("Inserisci il numero di km percorsi:");
			int km = Integer.parseInt(input.nextLine());

			System.out.println("Inserisci il numero di litri consumati:");
			int litri = Integer.parseInt(input.nextLine());

			if (litri == 0) {
				throw new ArithmeticException("Impossibile calcolare il numero di km/litro.");
			}

			double kmPerLitro = km / litri;
			System.out.println("Il numero di km/litro percorsi è: " + kmPerLitro);
		} catch (ArithmeticException e) {
			System.out.println("ERRORE: divisione per zero! " + e.getMessage());
			input.nextLine();
		} catch (Exception e) {
			System.out.println("Errore: inserimento non valido! Assicurati di inserire numeri validi.");
			input.nextLine();
		} finally {
			input.close();
		}

	}

}
