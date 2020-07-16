package model.entities;

import model.exception.DomainException;

public class ContaCorrente {

	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	public ContaCorrente() {
	}

	public ContaCorrente(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(Double deposito) {
		
		saldo = saldo == null ? deposito : this.saldo + deposito;
	}

	public void saque(Double saque) throws DomainException {
		
		if (saque > limiteSaque) {
			throw new DomainException("Saque não pode ser maior que o Limite de Saque");
		}
		
		if (saque > saldo) {
			throw new DomainException("Saque não pode ser maior que o Saldo");
		}
		
		saldo -= saque;
		
	}

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", saldo=" + String.format("%.2f", saldo) + "]";
	}

}
