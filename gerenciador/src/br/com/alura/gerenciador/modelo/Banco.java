package br.com.alura.gerenciador.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequêncial = 1;
	
	static {
		Date data = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.format(data);
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequêncial++);
		empresa.setNome("Alura");
		empresa.setDataAbertura(data);
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequêncial++);
		empresa2.setNome("Caelum");
		empresa2.setDataAbertura(data);
		lista.add(empresa);
		lista.add(empresa2);
		
		
		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("6789");
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequêncial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(int id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
		
		
	}

	public Empresa buscaEmpresa(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario findUser(String login, String senha) {
		for (Usuario u: listaUsuarios) {
			if(u.ehIgual(login, senha)) {
				return u;
			}
		}
		return null;
	}

}
