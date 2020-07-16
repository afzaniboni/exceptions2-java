package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ContaCorrente;
import model.exception.DomainException;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date checkOut = null;

		try {
			System.out.println("Entre com os dados da Conta:");
			System.out.print("Numero: ");
			Integer numero = sc.nextInt();
			sc.nextLine();
			System.out.print("Titular: ");
			String titular = sc.nextLine();
			System.out.print("Saldo Inicial: ");
			Double saldoInicial = sc.nextDouble();
			System.out.print("Limite de Saque: ");
			Double limiteSaque = sc.nextDouble();
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			ContaCorrente conta = new ContaCorrente(numero, titular, saldoInicial, limiteSaque);
			System.out.print("Entre com um deposito: ");
			conta.deposito(sc.nextDouble());

			System.out.print("Entre com saque: ");
			Double saque = sc.nextDouble();
			conta.saque(saque);

			System.out.println(conta.toString());

		} catch (InputMismatchException e) {
			System.out.println("Entrada de dados invalida!!!");
		} catch (DomainException e) {
			System.out.println("Erro de Saque: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro não esperado!!");
		} catch (ParseException e) {
			System.out.println("Data invalida: " + checkOut + e.getMessage());
		}

		sc.close();
	}

}
