package esercizio1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import exception.InvalidPositionException;

public class MainEsercizio1 {

	public static void main(String[] args) throws InvalidPositionException {

		int[] array = new int[5];
		Random casual = new Random();

		Scanner input = new Scanner(System.in);

		// GENERO VALORI CASUALI NELL'ARRAY
		for (int i = 0; i < array.length; i++) {
			array[i] = casual.nextInt(10) + 1;
		}

		System.out.println("Array iniziale: " + Arrays.toString(array));

		int value;
		int index;

		// DO WHILE CHE CREA UN CICLO INFINITO FINCHè NON VIENE DIGITATO LO "0"
		do {
			// TRY-CATCH PER LA GESTIONE DEGLI ERRORI
			try {
				System.out.println(
						"Inserisci un valore da 1 a 10 per sostituire un numero nell'array! [(Inserisci 0 per terminare]):");
				value = Integer.parseInt(input.nextLine());

				if (value == 0) {
					break;
				}

				if (value > 10) {
					throw new IllegalArgumentException("Valore non valido! Inserire un numero da 1-10!");
				}

				System.out.println("Inserisci la posizione dell'array (0-4) per sostituire il numero:");
				index = Integer.parseInt(input.nextLine());

				validatePosition(index);

				// NUOVO ARRAY CON VALORI MODIFICATI
				array[index] = value;

				System.out.println("Nuovo array: " + Arrays.toString(array));

				// GESTISCO GLI "EXCEPTION"
			} catch (IllegalArgumentException e) {
				System.out.println("Si è verificato un errore: " + e.getMessage());

				input.nextLine();
			} catch (InvalidPositionException e) {
				System.out.println("Si è verificato un errore: " + e.getMessage());
				input.nextLine();
			}
		} while (true);

		System.out.println("Programma terminato.");
		input.close();
	}

	public static void validatePosition(int index) throws InvalidPositionException {
		if (index < 0 || index >= 4) {
			throw new InvalidPositionException(
					"Posizione non valida! La posizione inserita deve essere compresa tra 0 e 4.");
		}
	}
}
