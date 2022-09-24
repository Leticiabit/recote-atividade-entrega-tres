package br.com.viagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.viagem.factory.ConnectionFactory;
import br.com.viagem.model.Cliente;

public class ClienteDAO {

	// Salva o cliente
	public void save(Cliente contato){
		
		String sql = "INSERT INTO Cliente(nome, celular, email) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getCelular());
			pstm.setString(3, contato.getEmail());
			
			pstm.execute();
			
			System.out.println("Registro salvo com sucesso!\n");
			
		}catch (Exception e){
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Lista os clientes
	public void listaCliente() {
		String sql = "SELECT * FROM Cliente";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
		    pstm = conn.prepareStatement(sql);
		    ResultSet result = pstm.executeQuery();
		    
			lista(result);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				
				if(pstm!=null) {
					pstm.close();
				}
			
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	protected void lista(ResultSet result) throws SQLException {
		while(result.next()) {
			System.out.println("\n" + String.format("Id %d", result.getInt("id_cliente")));
			System.out.println(String.format("Nome %s ", result.getString("nome")));
			System.out.println(String.format("Celular %s ", result.getString("celular")));
			System.out.println(String.format("Email %s ", result.getString("email"))+ "\n");
		}
	}
	
	// Remover cliente
	public void removeCliente(Integer id) {
		String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
		    pstm = conn.prepareStatement(sql);
		    
		    String sql2 = "SELECT id_cliente FROM Cliente WHERE id_cliente = ?";
		    PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, id);
			ResultSet result = pstm2.executeQuery();
		    if(result.next()) remove(pstm, id);
		    else System.out.println("Cliente não encontrado");
			
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				
				if(pstm!=null) {
					pstm.close();
				}
			
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	protected void remove(PreparedStatement pstm, Integer id) throws SQLException {
		pstm.setInt(1, id);
		boolean temErro = pstm.execute();
	
		if(!temErro) System.out.println("Cliente removido com sucesso!\n");
	}

}
