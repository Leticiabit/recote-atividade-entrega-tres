package br.com.viagem.main;

import java.util.Scanner;

import br.com.viagem.dao.ViagemDAO;
import br.com.viagem.model.Viagem;
import br.com.viagem.dao.ClienteDAO;
import br.com.viagem.model.Cliente;
import br.com.viagem.dao.DestinoDAO;
import br.com.viagem.model.Destino;

public class Main {

	public static void main(String[] args) {

		int op;
		Scanner tc = new Scanner(System.in);
		  
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		ViagemDAO viagemDAO = new ViagemDAO();
		Cliente contato = new Cliente();
		Destino destino = new Destino();
		Viagem viagem = new Viagem();
				
		  do {
			  System.out.println("Menu de viagens!\n");
			  System.out.println("1 - Cadastrar cliente \n2 - Remover cliente \n3 - Visualizar clientes \n4 - Cadastrar destino \n5 - Remover destino \n6 - Visualizar destinos \n7 - Cadastrar Viagem \n8 - Visualizar viagens \n9 - Remover viagem \n10 - Sair \n");
			  op = Integer.parseInt(tc.nextLine());
			  
			  switch(op) {
			  
			  	case 1:
			  		System.out.println("Nome:");
					contato.setNome(tc.nextLine());
					System.out.println("Celular:");
					contato.setCelular(tc.nextLine());
					System.out.println("E-mail:");
					contato.setEmail(tc.nextLine());
					clienteDAO.save(contato);
			  		break;
				  
			  	case 2:
			  		System.out.println("Escolha o id do cliente que será removido: ");
					clienteDAO.removeCliente(Integer.parseInt(tc.nextLine()));
			  		break;
				  
			  	case 3:
					clienteDAO.listaCliente();
			  		break;

			  	case 4:
			 		System.out.println("Pais:");
					destino.setPais(tc.nextLine());
			 		System.out.println("Cidade:");
					destino.setCidade(tc.nextLine());
			 		System.out.println("Valor:");
					destino.setValor(Integer.parseInt(tc.nextLine()));
					destinoDAO.save(destino);
			  		break;
			  		
			  	case 5:
			  		System.out.println("Escolha o id do destino que será removido: ");
					destinoDAO.removeDestino(Integer.parseInt(tc.nextLine()));
					break;
					
			  	case 6:
					destinoDAO.listaDestino();
			  		break;

			  	case 7:
			 		System.out.println("id_cliente:");
					viagem.setId_cliente(Integer.parseInt(tc.nextLine()));
			 		System.out.println("id_destino:");
					viagem.setId_destino(Integer.parseInt(tc.nextLine()));
					System.out.println("Data do voo:");
					viagem.setDatavoo(tc.nextLine());
					System.out.println("Data da compra:");
					viagem.setDatacompra(tc.nextLine());
					viagemDAO.save(viagem);
					break;
			  	
			  	case 8:
					viagemDAO.listaViagem();
			  		break;
			  		
			  	case 9:
			  		System.out.println("Escolha o id da viagem que será removida: ");
					viagemDAO.removeViagem(Integer.parseInt(tc.nextLine()));
					break;

			  	case 10:
			  		System.out.println("Programa finalizado!");
			  		break;
			  }
		  } while(op != 10);
	
		// Altera destino, nao esta funcionando
		//		Destino destinoAlterado = new Destino();
		//System.out.println("Pais de destino:");
		//destinoAlterado.setPais(tc.nextLine());
		//System.out.println("Cidade de destino");
		//destinoAlterado.setCidade(tc.nextLine());
		//System.out.println("Valor da viagem:");
		//destinoAlterado.setValor(Integer.parseInt(tc.nextLine()));
		//destinoDAO.alteraDestino(destinoAlterado);
		
		tc.close();
	}
}
