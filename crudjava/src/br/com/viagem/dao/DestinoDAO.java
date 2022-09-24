package br.com.viagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.viagem.factory.ConnectionFactory;
import br.com.viagem.model.Destino;

public class DestinoDAO {

	// Salvar o destino
	public void save(Destino contato){

		String sql = "INSERT INTO Destino(pais, cidade, valor, id_destino) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getPais());
			pstm.setString(2, contato.getCidade());
			pstm.setFloat(3, contato.getValor());
			pstm.setInt(4, contato.getId_destino());

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

	// Listar os destinos
	public void listaDestino() {
		String sql = "SELECT * FROM Destino";
		
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
			System.out.println("\n" + String.format("Id %d", result.getInt("id_destino")));
			System.out.println(String.format("Pais %s ", result.getString("pais")));
			System.out.println(String.format("Cidade %s ", result.getString("cidade")));
			System.out.println(String.format("Valor %.2f ", result.getFloat("valor"))+ "\n");
		}
		
	}
	
	// Remover destino
	public void removeDestino(Integer id) {
		String sql = "DELETE FROM Destino WHERE id_destino = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
		    pstm = conn.prepareStatement(sql);
		    
		    String sql2 = "SELECT id_destino FROM Destino WHERE id_destino = ?";
		    PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, id);
			ResultSet result = pstm2.executeQuery();
		    if(result.next()) remove(pstm, id);
		    else System.out.println("Destino não encontrado");
			
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
	
		if(!temErro) System.out.println("Destino removido com sucesso\n");
	}
	
	// Altera destino
public void alteraDestino(Destino destino) {
		
		String sql = "UPDATE Destino SET pais = ?, cidade = ?, valor = ? "
				+ "WHERE id_destino = ?";
		
		Connection conn = null; 
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
		    pstm = conn.prepareStatement(sql);
		    
		    String sql2 = "SELECT id_destino FROM Destino WHERE id_destino = ?";
		    PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, destino.getId_destino());
			ResultSet result = pstm2.executeQuery();
		    if(result.next()) atualiza(pstm, destino);
		    else System.out.println("Insira um id valido.");
		    
			
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
protected void atualiza(PreparedStatement pstm, Destino contato) throws SQLException {
	pstm.setString(1, contato.getPais());
	pstm.setString(2, contato.getCidade());
	pstm.setFloat(3, contato.getValor());
	pstm.setInt(4, contato.getId_destino());
	boolean temErro = pstm.execute();
	
	if(!temErro) System.out.println("Destino alterado com sucesso!\n");
}

}
