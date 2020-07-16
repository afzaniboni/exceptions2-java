package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ContaCorrente;
import model.exception.DomainException;

public class Programa1 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		ContaCorrente conta = new ContaCorrente();

		try {
			entradaDados(conta);

//			conta = new ContaCorrente(numero, titular, saldoInicial, limiteSaque);

			System.out.println(conta.toString());

		} catch (InputMismatchException e) {
			System.out.println("Entrada de dados invalida!!!");
		} catch (DomainException e) {
			System.out.println("Erro de Saque: " + e.getMessage() + " Saldo: " + conta.getSaldo());
		} catch (RuntimeException e) {
			System.out.println("Erro não esperado!!" + e.getMessage());
		}

	}

	private static void entradaDados(ContaCorrente conta) throws DomainException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados da Conta:");
		System.out.print("Numero: ");
		conta.setNumero(sc.nextInt());
		sc.nextLine();
		System.out.print("Titular: ");
		conta.setTitular(sc.nextLine());
		System.out.print("Saldo Inicial: ");
		conta.deposito(sc.nextDouble());
		System.out.print("Limite de Saque: ");
		conta.setLimiteSaque(sc.nextDouble());
		
		System.out.print("Entre com um deposito: ");
		conta.deposito(sc.nextDouble());

		System.out.print("Entre com saque: ");
		conta.saque(sc.nextDouble());
		
		
		sc.close();
	}

}
