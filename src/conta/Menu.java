package conta;

import java.util.Scanner;
import conta.model.ContaPoupanca;
import conta.model.Conta;
import conta.model.ContaCorrente;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);

		int opcao;
		
		while(true) {
			
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
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_BLUE_BOLD+"Banco do Bostil, fazemos por nós!");
				leia.close();
				System.exit(0);
			}
			switch(opcao) {
			
			case 1:
				System.out.println(Cores.TEXT_BLUE_BOLD+"Criar conta\n\n");break;
			case 2:
				System.out.println(Cores.TEXT_BLUE_BOLD+"Listar contas existentes\n\n");break;
			case 3:
				System.out.println(Cores.TEXT_BLUE_BOLD+"Acessar conta - Por favor digite o número\n\n");break;
			case 4:
				System.out.println(Cores.TEXT_BLUE_BOLD+"Atualizar dados da conta \n\n");break;
			case 5:
				System.out.println(Cores.TEXT_BLUE_BOLD+"Apagar conta \n\n");break;
			case 6:
				System.out.println(Cores.TEXT_BLUE_BOLD+"Sacar \n\n");break;
			case 7:
				System.out.println(Cores.TEXT_BLUE_BOLD+"Depositar \n\n");break;
			case 8:
				System.out.println(Cores.TEXT_BLUE_BOLD+"Transferir \n\n");break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD+"\nOpção Inválida.");
				break;
				
			}
		}

	}
}
