package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.sc.senac.model.dto.VendaDTO;
import br.sc.senac.model.vo.VendaVO;

public class VendaDAO {

	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	
	public boolean existeRegistroDaVenda(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idVenda FROM venda WHERE senhaPedido = " + vendaVO.getSenhaPedido() + " and datavenda = '" + df.format(vendaVO.getDataVenda()) + "'";
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de existencia de venda");
			e.printStackTrace();
		} finally{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		int retorno = 0;
		String query = "INSERT INTO venda (dataVenda, senhaPedido, flagVendaCancelada) values ('" + df.format(vendaVO.getDataVenda()) + "'," + vendaVO.getSenhaPedido() + "," + vendaVO.isFlagVendaCancelada() + ")";
		try {
			stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
			resultado = stmt.getGeneratedKeys();
			if (resultado.next()) {
				return resultado.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de cadastro de venda");
			e.printStackTrace();
		} finally{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public boolean cadastrarItemPratoDAO(VendaVO vendaVO) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int contador = 0;
		int resultado = 0;
		boolean retorno = false;
		String query = "";
		try {
		for(int i = 0; i < vendaVO.getItemPrato().size(); i++) {
			query = "INSERT INTO itemprato (idprato,idvenda,quantidade) values (" + vendaVO.getItemPrato().get(i).getIdPrato() + ", " + vendaVO.getIdVenda() + ", " + vendaVO.getItemPrato().get(i).getQuantidade() + ")";
			resultado = stmt.executeUpdate(query);
			if(resultado == 1) {
				contador++;
			} 
		}	
		if (contador == vendaVO.getItemPrato().size()){
			retorno = true;
		}else {
			System.out.println("\nNem todos os pratos foram cadastrados com sucesso!");
		}
		
		}catch(SQLException e) {
			System.out.println("\nErro ao executar a query de cadastro de item prato!");
			e.printStackTrace();
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public boolean cadastrarItemBebidaDAO(VendaVO vendaVO) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int contador = 0;
		int resultado = 0;
		boolean retorno = false;
		String query = "";
		try {
		for(int i = 0; i < vendaVO.getItemBebidas().size(); i++) {
			query = "INSERT INTO itembebida (idbebida,idvenda,quantidade) values (" + vendaVO.getItemBebidas().get(i).getIdBebida() + ", " + vendaVO.getIdVenda() + ", " + vendaVO.getItemBebidas().get(i).getQuantidade() + ")";
			resultado = stmt.executeUpdate(query);
			if(resultado == 1) {
				contador++;
			} 
		}	
		if (contador == vendaVO.getItemBebidas().size()){
			retorno = true;
		}else {
			System.out.println("\nNem todos os bebidas foram cadastrados com sucesso!");
		}
		
		}catch(SQLException e) {
			System.out.println("\nErro ao executar a query de cadastro de item bebida!");
			e.printStackTrace();
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public boolean existeRegistroDaVendaPorID(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idvenda from venda where idvenda = " + vendaVO.getIdVenda();
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica venda por ID!");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cancelarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE venda SET flagvendacancelada = 1 where idvenda = " + vendaVO.getIdVenda();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que cancela venda!");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	@SuppressWarnings("resource")
	public ArrayList<VendaDTO> gerarRelatorioVendasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<VendaDTO> vendasDTO = new ArrayList<VendaDTO>();
		String queryprato = "SELECT PRATO.NOME,PRATO.PRECO,quantidade,(prato.preco*quantidade) FROM itemprato inner join prato on prato.idprato = itemprato.idprato inner join venda on itemprato.idvenda = venda.idvenda where flagvendacancelada is false";
		String querybebida = "SELECT BEBIDA.NOME,BEBIDA.PRECO,quantidade,(bebida.preco*quantidade) FROM itembebida inner join bebida on bebida.idbebida = itembebida.idbebida inner join venda on venda.idvenda = itembebida.idvenda where flagvendacancelada is false";
		
		try {
			resultado = stmt.executeQuery(queryprato);
			while(resultado.next()) {
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setTipo("Prato");
				vendaDTO.setDescricao(resultado.getString(1));
				vendaDTO.setPreco(Double.parseDouble(resultado.getString(2)));
				vendaDTO.setQuantidade(Integer.parseInt(resultado.getString(3)));
				vendaDTO.setSubtotal(Double.parseDouble(resultado.getString(4)));
				vendasDTO.add(vendaDTO);
			}
			resultado = stmt.executeQuery(querybebida);
			while(resultado.next()) {
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setTipo("Bebida");
				vendaDTO.setDescricao(resultado.getString(1));
				vendaDTO.setPreco(Double.parseDouble(resultado.getString(2)));
				vendaDTO.setQuantidade(Integer.parseInt(resultado.getString(3)));
				vendaDTO.setSubtotal(Double.parseDouble(resultado.getString(4)));
				vendasDTO.add(vendaDTO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar o relatorio dos venda!");
			e.printStackTrace();
		} finally{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vendasDTO;
	}

	@SuppressWarnings("resource")
	public ArrayList<VendaDTO> gerarRelatorioVendasCanceladasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<VendaDTO> vendasCanceladasDTO = new ArrayList<VendaDTO>();
		String queryprato = "SELECT PRATO.NOME,PRATO.PRECO,quantidade,(prato.preco*quantidade) FROM itemprato inner join prato on prato.idprato = itemprato.idprato inner join venda on itemprato.idvenda = venda.idvenda where flagvendacancelada is true";
		String querybebida = "SELECT BEBIDA.NOME,BEBIDA.PRECO,quantidade,(bebida.preco*quantidade) FROM itembebida inner join bebida on bebida.idbebida = itembebida.idbebida inner join venda on venda.idvenda = itembebida.idvenda where flagvendacancelada is true";
		
		try {
			resultado = stmt.executeQuery(queryprato);
			while(resultado.next()) {
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setTipo("Prato");
				vendaDTO.setDescricao(resultado.getString(1));
				vendaDTO.setPreco(Double.parseDouble(resultado.getString(2)));
				vendaDTO.setQuantidade(Integer.parseInt(resultado.getString(3)));
				vendaDTO.setSubtotal(Double.parseDouble(resultado.getString(4)));
				vendasCanceladasDTO.add(vendaDTO);
			}
			resultado = stmt.executeQuery(querybebida);
			while(resultado.next()) {
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setTipo("Bebida");
				vendaDTO.setDescricao(resultado.getString(1));
				vendaDTO.setPreco(Double.parseDouble(resultado.getString(2)));
				vendaDTO.setQuantidade(Integer.parseInt(resultado.getString(3)));
				vendaDTO.setSubtotal(Double.parseDouble(resultado.getString(4)));
				vendasCanceladasDTO.add(vendaDTO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar o relatorio dos vendas canceladas!");
			e.printStackTrace();
		} finally{
			Banco.closeResultSet(resultado);
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vendasCanceladasDTO;
	}

	@SuppressWarnings("resource")
	public ArrayList<VendaDTO> gerarRelatorioVendaPorIDDAO(VendaDTO vendaDTO2) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<VendaDTO> vendasIDDTO = new ArrayList<VendaDTO>();
		String queryprato = "SELECT PRATO.NOME,PRATO.PRECO,quantidade,(prato.preco*quantidade) FROM itemprato inner join prato on prato.idprato = itemprato.idprato inner join venda on itemprato.idvenda = venda.idvenda where venda.idvenda = " + vendaDTO2.getQuantidade();
		String querybebida = "SELECT BEBIDA.NOME,BEBIDA.PRECO,quantidade,(bebida.preco*quantidade) FROM itembebida inner join bebida on bebida.idbebida = itembebida.idbebida inner join venda on venda.idvenda = itembebida.idvenda where venda.idvenda = " + vendaDTO2.getQuantidade();
		
		try {
			resultado = stmt.executeQuery(queryprato);
			while(resultado.next()) {
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setTipo("Prato");
				vendaDTO.setDescricao(resultado.getString(1));
				vendaDTO.setPreco(Double.parseDouble(resultado.getString(2)));
				vendaDTO.setQuantidade(Integer.parseInt(resultado.getString(3)));
				vendaDTO.setSubtotal(Double.parseDouble(resultado.getString(4)));
				vendasIDDTO.add(vendaDTO);
			}
			resultado = stmt.executeQuery(querybebida);
			while(resultado.next()) {
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setTipo("Bebida");
				vendaDTO.setDescricao(resultado.getString(1));
				vendaDTO.setPreco(Double.parseDouble(resultado.getString(2)));
				vendaDTO.setQuantidade(Integer.parseInt(resultado.getString(3)));
				vendaDTO.setSubtotal(Double.parseDouble(resultado.getString(4)));
				vendasIDDTO.add(vendaDTO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar o relatorio dos vendas canceladas!");
			e.printStackTrace();
		} finally{
			Banco.closeResultSet(resultado);
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vendasIDDTO;
	}

}
