package br.sc.senai.web.MB;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.sc.senai.web.Dominio.Mercadorias;
import br.sc.senai.web.model.MercadoriasRn;

@ManagedBean
public class MercadoriaMB {
	
	private List<Mercadorias> mercadorias;
	private Mercadorias mercadoria;
	private MercadoriasRn rn;
	
	@PostConstruct
	
	public void init(){
		 rn = new MercadoriasRn();
			mercadoria = new Mercadorias();
		}


	public List<Mercadorias> getMercadorias() {
		if( mercadorias == null){
			mercadorias = rn.listar();
		}
		return mercadorias;
	}


	
	public void setMercadorias(List<Mercadorias> mercadorias) {
		this.mercadorias = mercadorias;
	}


	
	public Mercadorias getMercadoria() {
		return mercadoria;
	}


	
	public void setMercadoria(Mercadorias mercadoria) {
		this.mercadoria = mercadoria;
	}


	public String salvar(){
		try {
			rn.salvar(mercadoria);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "listMercadoria";
	}
	
	public String excluir(String idParam){
		Long idMercadoria = Long.parseLong(idParam);
		try {
			rn.excluir(idMercadoria);
			mercadorias = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String editar(String idParam){
		Long idMercadoria = Long.parseLong(idParam);
		mercadoria = rn.buscarPorId(idMercadoria);
		return "cadMercadoria";
	}
	 

}
