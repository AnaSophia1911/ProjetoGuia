package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.model.ContaPoupanca;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		float saldo, limite, valor;
		String titular;

		while (true) {

			System.out.println(Cores.TEXT_CYAN_BRIGHT);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("");
			System.out.println("                    Banco do Bostil                   ");
			System.out.println("");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("");
			System.out.println("              Entre com a opção desejada              ");
			System.out.println("");
			System.out.println("              1 - Criar conta");
			System.out.println("              2 - Listar todas as contas existentes");
			System.out.println("              3 - Buscar conta por número");
			System.out.println("              4 - Atualizar dados da conta");
			System.out.println("              5 - Apagar conta");
			System.out.println("              6 - Sacar ");
			System.out.println("              7 - Depositar");
			System.out.println("              8 - Transferir");
			System.out.println("              9 - Sair");
			System.out.println("");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + Cores.TEXT_RESET);
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException m) {
				System.out.println("\nDigite valores inteiros.");
				leia.nextInt();
				opcao = 0;
			}
			if (opcao == 9) {
				System.out.println(Cores.TEXT_BLUE_BOLD + "Banco do Bostil, fazemos por nós!");
				leia.close();
				System.exit(0);
			}
			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Criar conta\n\n");

				System.out.println("Digite o número da agencia: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o tipo de conta: 1-conta corrente 2-conta poupança ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);
				System.out.println("Digite o saldo da conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {

				case 1 -> {
					System.out.println("Digite o limite de crédito: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia de aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Listar contas existentes\n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Acessar conta - Por favor digite o número\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Atualizar dados da conta \n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				if (contas.buscarNaCollection(numero) != null) {
					System.out.println("Digite o número da agência:");
					agencia = leia.nextInt();
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					System.out.println("Digite o saldo da conta: ");
					saldo = leia.nextFloat();

					tipo = contas.retornaTipo(numero);

					switch (tipo) {

					case 1 -> {
						System.out.println("Digite o limite da conta: ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido.");
					}
					}
				} else
					System.out.println("\nConta não encontrada.");
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Apagar conta \n\n");

				System.out.println("Digite o número da conta a ser DELETADA.");
				numero = leia.nextInt();

				contas.deletar(numero);
				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Sacar \n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o valor do saque: ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);
				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Depositar \n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o valor do depósito: ");
					valor = leia.nextFloat();

				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Transferir \n\n");
				
				System.out.println("Digite o número da conta de origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o número da conta destinatária: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o valor da transferência: ");
					valor = leia.nextFloat();
				} while (valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida.");
				break;

			}
		}

	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}

	}
}
