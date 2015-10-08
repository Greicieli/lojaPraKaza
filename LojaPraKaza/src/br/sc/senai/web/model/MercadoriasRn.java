package br.sc.senai.web.model;

import java.util.List;

import br.sc.senai.web.Dao.MercadoriasDao;
import br.sc.senai.web.Dominio.Mercadorias;



public class MercadoriasRn {
	
	private MercadoriasDao dao;
	
	public MercadoriasRn(){
		dao = new MercadoriasDao();
	}
	public void salvar(Mercadorias mercadoria)throws Exception{
		if(mercadoria.getNome().trim().isEmpty()){
			throw new Exception("O nome é Obrigatório");
		}
		if(mercadoria.getCategoria().trim().isEmpty()){
			throw new Exception("A Categoria é Obrigatória");
		}
		
		dao.salvar(mercadoria);
		
	}
	public List<Mercadorias> listar() {
		return dao.listarTodos();
	}

	public Mercadorias buscarPorId(Long idMercadoria) {
		return dao.buscarPorId(idMercadoria);
	}

	public void excluir(Long idMercadoria) throws Exception {
		dao.excluir(idMercadoria);
	}
	
	}


