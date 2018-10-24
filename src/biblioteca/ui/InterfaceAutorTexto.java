package biblioteca.ui;

import java.util.List;

import biblioteca.dao.AutorDao;
import biblioteca.modelo.Autor;

public class InterfaceAutorTexto extends InterfaceModeloTexto {
	
	private AutorDao dao;
	
	public InterfaceAutorTexto() {
		super();
		dao = new AutorDao();
	}
	
	private Autor obtemDadosAutor(Autor autor) {
		
		System.out.print("Insira o nome do autor: ");
		String nome = entrada.nextLine();
		
		System.out.println("Insira o CPF do autor (somente números): ");
		long cpf = entrada.nextLong();
		entrada.nextLine();
		
		Autor novoAutor = new Autor(0, nome, cpf);
		
		return novoAutor;
	}
	
	@Override
	public void adicionar() {
		System.out.println("Adicionar autor");
		System.out.println();
		
		Autor novoCliente = obtemDadoAutor(null);	
		dao.insert(novoAutor);
		
	}

	@Override
	public void listarTodos() {
		List<Autor> autor = dao.getAll();
		
		System.out.println("Lista de clientes");
		System.out.println();
		
		System.out.println("id\tNome\tCPF");
		
		for (Autor autor : autor) {
			imprimeItem(autor);
		}
		
	}

	@Override
	public void editar() {
		listarTodos();
		
		System.out.println("Editar autor");
		System.out.println();
		
		System.out.print("Entre o id do autor: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		Autor autorAModifcar = dao.getByKey(id);
		
		Autor novoAutor = obtemDadosAutor(autorAModifcar);
		
		novoAutor.setId(id);
		
		dao.update(novoAutor);
		
	}

	@Override
	public void excluir() {
		listarTodos();
		
		System.out.println("Excluir autor");
		System.out.println();
		
		System.out.print("Entre o id do autor: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		dao.delete(id);
		
	}

}
