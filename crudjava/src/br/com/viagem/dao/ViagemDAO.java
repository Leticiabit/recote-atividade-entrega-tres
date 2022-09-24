package br.com.viagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.viagem.factory.ConnectionFactory;
import br.com.viagem.model.Viagem;

public class ViagemDAO {

	// Cadastrar viagem
	public void save(Viagem contato) {

		String sql = "INSERT INTO Viagem(id_cliente, id_destino, datavoo, datacompra) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, contato.getId_cliente());
			pstm.setInt(2, contato.getId_destino());
			pstm.setString(3, contato.getDatavoo());
			pstm.setString(4, contato.getDatacompra());

			pstm.execute();

			System.out.println("Registro salvo com sucesso!\n");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Listar viagem
	public void listaViagem() {
		String sql = "SELECT * FROM Viagem";
		
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
			System.out.println("\n" + String.format("Id do cliente %d", result.getInt("id_cliente")));
			System.out.println(String.format("Id do destino %d", result.getInt("id_cliente")));
			System.out.println(String.format("Data do voo %s ", result.getString("datavoo")));
			System.out.println(String.format("Data da compra %s ", result.getString("datacompra")));
			System.out.println(String.format("Id da viagem %d", result.getInt("id_viagem")) + "\n");
		}	
	}

	// Remover viagem
	public void removeViagem(Integer id) {
		String sql = "DELETE FROM Viagem WHERE id_viagem = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
		    pstm = conn.prepareStatement(sql);
		    
		    String sql2 = "SELECT id_viagem FROM Viagem WHERE id_viagem = ?";
		    PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, id);
			ResultSet result = pstm2.executeQuery();
		    if(result.next()) remove(pstm, id);
		    else System.out.println("Viagem não encontrada");
			
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
	
		if(!temErro) System.out.println("Viagem removida com sucesso!\n");
	}
	
}