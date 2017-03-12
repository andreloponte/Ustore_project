package desafio.ustore.app;

import java.util.Scanner;

import java.util.Date;
import java.util.List;

import desafio.ustore.objetos.Usuario;
import desafio.ustore.repositorio.RepositorioUsuario;

import java.util.ArrayList;

public class Aplicacao {
	
	String nome, senha, email, telefone;
	int pos, id;
	Date created, modified;
	
	public Aplicacao (int id, String nome,String email,String telefone, String senha, Date created, Date modified){
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.created = created;
		this.modified = modified;
	}
	
	public int getId(){
		return id;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getTelefone(){
		return telefone;
	}
	
	public String getSenha(){
		return senha;
	}

	public Date getCreated(){
		return created;
	}

	public Date getModified(){
		return modified;
	}

	public static void main(String[] args) {
		ArrayList<Aplicacao> Cadastro = new ArrayList<>();
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
		Usuario usuario = new Usuario();
		Scanner ent = new Scanner(System.in);
		String continuar;
		int esc,i=0,saida=2, laco1/*, laco2*/;
		
		String nome, senha, email, telefone;
		int pos, id;
		Date created, modified;
		
		List<Usuario> usuarios = repositorioUsuario.listarTodos();
		for (Usuario u : usuarios) {
			id = u.getId();
			nome = u.getNome();
			email = u.getEmail();
			telefone = u.getTelefone();
			senha = u.getSenha();
			created = u.getCreated();
			modified = u.getModified();
			Cadastro.add(new Aplicacao(id, nome, email, telefone, senha, created, modified));
		}
		
		while (saida>0)
		{
			System.out.println("Bem Vindo ao Cadastro de Usuarios\n");
			System.out.println("*****************************\n");
			System.out.println("O que deseja fazer?\n");
			System.out.println("1 - Cadastrar Novo Usuario");
			System.out.println("2 - Consultar Usuario");
			System.out.println("3 - Editar Usuario");
			System.out.println("4 - Excluir Usuario");
			System.out.println("0 - Sair\n");
			esc = ent.nextInt();
			if (esc>0)
			{
				switch (esc)
				{
					case 1: // Cadastro de novo Usuario
						System.out.println("Bem Vindo ao Cadastro de Usuarios\n");
						System.out.println("*****************************\n");
						do
						{
							System.out.println("Digite abaixo os dados do usuario que deseja cadastrar:\n");
							System.out.println("Nome:");
							nome = new Scanner(System.in).nextLine();
							System.out.println("Email:");
							email = new Scanner(System.in).nextLine();
							System.out.println("Telefone:");
							telefone = new Scanner(System.in).nextLine();
							System.out.println("Senha:");
							senha = new Scanner(System.in).nextLine();
							created = new Date();
							modified = new Date();
							pos = 0;
							for (Aplicacao n:Cadastro){
								pos++;
							}
							id = pos;
									
							if (Cadastro.indexOf(email) < 0)
							{
								Cadastro.add(new Aplicacao(id, nome, email, telefone, senha, created, modified));
								usuario.setNome(nome);
								usuario.setEmail(email);
								usuario.setTelefone(telefone);
								usuario.setSenha(senha);
								usuario.setCreated(created);
								usuario.setModified(modified);
								repositorioUsuario.salvar(usuario);
								// USAR JSON
								System.out.printf("%s foi adicionado a lista de usuarios.\n\n",Cadastro.get(i));
								++i;
								System.out.println("Adicionar mais usuarios? S / N\n");
								continuar = new Scanner(System.in).nextLine();
							}
							else
							{
								System.out.println("Usuario j� existente. Deseja adicionar outro usuario? S / N\n");
								continuar = new Scanner(System.in).nextLine();
							}
						}while(continuar.equalsIgnoreCase("S"));
					break;
					
					case 2: // Consulta de Usuarios
/*						laco1 = 1;
						while (laco1 < 2){
							System.out.println("\nConsulta de Usuarios\n");
							System.out.println("*****************************\n");
							System.out.println("Qual tipo de consulta deseja fazer?\n");
							System.out.println("1 - Listar Usuarios");
							System.out.println("2 - Consultar Usuario Especifico");
							System.out.println("2 - Voltar ao Menu Principal\n");
							esc = ent.nextInt();
							switch (esc){
								case 1: //Listar Usuarios
								*/
									pos = 0;
									for (Aplicacao n:Cadastro){
										pos++;
										System.out.println("\n"+pos+"\nNome\t\t"+n.nome+"\nEmail\t\t"+n.email+"\nTelefone\t"+n.telefone);
										System.out.println("\nData Cadastro\t\t"+n.created+"\nUltima modificacao\t"+n.modified);
									}
									if (pos < 1){
										System.out.println("\nNao existem usuarios cadastrados.\n");
									}
//								break;
								
/*	N�o est� retornando o resultado esperado
 							case 2: //Consultar Usuario Espec�fico
									laco2 = 1;
									while (laco2 < 2){
										System.out.println("\n1 - Consultar Nome do Usuario");
										System.out.println("2 - Consultar Email");
										System.out.println("3 - Consultar Telefone");
										System.out.println("4 - Voltar ao Menu Consulta de Usuarios\n");
										esc = ent.nextInt();
										switch (esc){
											case 1: //Consultar Nome do Usuario
												System.out.println("\nDigite o nome do usuario:\n");
												nome = new Scanner(System.in).nextLine();
												if (Cadastro.lastIndexOf(nome) < 0)
												{
													System.out.println("Usuario inexistente.");													
												} 
												else {
													pos = 1;
													for (Aplicacao n:Cadastro){
														if((((Aplicacao)Cadastro.get(pos)).getNome()).equalsIgnoreCase(nome))
														{
															nome = (((Aplicacao) Cadastro.get(pos)).getNome());
															email = (((Aplicacao) Cadastro.get(pos)).getEmail());
															telefone = (((Aplicacao) Cadastro.get(pos)).getTelefone());
															senha = (((Aplicacao) Cadastro.get(pos)).getSenha()); 
															created = (((Aplicacao) Cadastro.get(pos)).getCreated());
															modified = (((Aplicacao) Cadastro.get(pos)).getModified());
															System.out.println("\n"+pos+"\nNome\t\t"+n.nome+"\nEmail\t\t"+n.email+"\nTelefone\t"+n.telefone);
															System.out.println("\nData Cadastro\t\t"+created+"\nUltima modificacao\t"+modified);
														}
													pos++;
													}
												}
											break;

											case 2: //Consultar Email do Usuario
												System.out.println("\nDigite o email do usuario:\n");
												email = new Scanner(System.in).nextLine();
												if (Cadastro.lastIndexOf(email) < 0)
												{
													System.out.println("Usuario inexistente.");													
												} 
												else {
													pos = 1;
													for (Aplicacao n:Cadastro){
														if((((Aplicacao)Cadastro.get(pos)).getEmail()).equalsIgnoreCase(email))
														{
															nome = (((Aplicacao) Cadastro.get(pos)).getNome());
															email = (((Aplicacao) Cadastro.get(pos)).getEmail());
															telefone = (((Aplicacao) Cadastro.get(pos)).getTelefone());
															senha = (((Aplicacao) Cadastro.get(pos)).getSenha()); 
															created = (((Aplicacao) Cadastro.get(pos)).getCreated());
															modified = (((Aplicacao) Cadastro.get(pos)).getModified());
															System.out.println("\n"+pos+"\nNome\t\t"+n.nome+"\nEmail\t\t"+n.email+"\nTelefone\t"+n.telefone);
															System.out.println("\nData Cadastro\t\t"+created+"\nUltima modificacao\t"+modified);
														}
													pos++;
													}
												}
											break;

											case 3: //Consultar Telefone do Usuario
												System.out.println("\nDigite telefone do usuario:\n");
												telefone = new Scanner(System.in).nextLine();
												if (Cadastro.lastIndexOf(telefone) < 0)
												{
													System.out.println("Usuario inexistente.");													
												} 
												else {
													pos = 1;
													for (Aplicacao n:Cadastro){
														if((((Aplicacao)Cadastro.get(pos)).getTelefone()).equalsIgnoreCase(telefone))
														{
															nome = (((Aplicacao) Cadastro.get(pos)).getNome());
															email = (((Aplicacao) Cadastro.get(pos)).getEmail());
															telefone = (((Aplicacao) Cadastro.get(pos)).getTelefone());
															senha = (((Aplicacao) Cadastro.get(pos)).getSenha()); 
															created = (((Aplicacao) Cadastro.get(pos)).getCreated());
															modified = (((Aplicacao) Cadastro.get(pos)).getModified());
															System.out.println("\n"+pos+"\nNome\t\t"+n.nome+"\nEmail\t\t"+n.email+"\nTelefone\t"+n.telefone);
															System.out.println("\nData Cadastro\t\t"+created+"\nUltima modificacao\t"+modified);
														}
													pos++;
													};
												}
											break;

											case 4: //Voltar ao Menu Consulta de Usuarios
												laco2 = 2;
											break;
											
										}
									}
								break;
							
								case 2: //Voltar ao Menu Principal
									laco1 = 2;
								break;

								default:
									System.out.println("\nEssa op��o n�o existe, por favor tente outra.\n");
								break;
							}
						}
						*/	
					break;
					
					case 3: //Edicao de usuarios
						int y = 1;
						System.out.println("------Edicao de Usuarios------\n");
						System.out.println("*****************************\n");
						while (y < 2)
						{
							System.out.println("Digite o numero do usuario a ser editado:\n");
							pos = 0;
							for (Aplicacao n:Cadastro){
								pos++;
								System.out.println("\n"+pos+"\nNome\t\t"+n.nome+"\nEmail\t\t"+n.email+"\nTelefone\t"+n.telefone);
								System.out.println("\nData Cadastro\t\t"+n.created+"\nUltima modificacao\t"+n.modified);
							}
							if (pos < 1){
								System.out.println("\nNao existem usuarios cadastrados.\n");
								y = 2;
							}
							else
							{
								esc = ent.nextInt();
								esc--;
								System.out.println("Nome: "+((Aplicacao) Cadastro.get(esc)).nome);
								System.out.println("Email: "+((Aplicacao) Cadastro.get(esc)).email);
								System.out.println("Telefone: "+((Aplicacao) Cadastro.get(esc)).telefone);
								System.out.println("Senha: "+((Aplicacao) Cadastro.get(esc)).senha);
								System.out.println("Digite abaixo os novos dados do usuario:");
								System.out.println("Nome:");
								nome = new Scanner(System.in).nextLine();
								System.out.println("Email:");
								email = new Scanner(System.in).nextLine();
								System.out.println("Telefone:");
								telefone = new Scanner(System.in).nextLine();
								System.out.println("Senha:");
								senha = new Scanner(System.in).nextLine();
								modified = new Date();
								id = (((Aplicacao) Cadastro.get(esc)).getId());
								Usuario u = repositorioUsuario.obterPorId(id);
								u.setNome(nome);
								u.setEmail(email);
								u.setTelefone(telefone);
								u.setSenha(senha);
								u.setModified(modified);
								repositorioUsuario.salvar(u);
								System.out.println("\nUsuario "+nome+" editado com sucesso.");
								System.out.println("\nOs novos dados do usuario s�o:");
								System.out.println("Nome: "+nome);
								System.out.println("Email: "+email);
								System.out.println("Telefone: "+telefone);
								System.out.println("Senha: "+senha);
								Cadastro.removeAll(Cadastro);
								List<Usuario> usu = repositorioUsuario.listarTodos();
								for (Usuario us : usu) {
									id = us.getId();
									nome = us.getNome();
									email = us.getEmail();
									telefone = us.getTelefone();
									senha = us.getSenha();
									created = us.getCreated();
									modified = us.getModified();
									Cadastro.add(new Aplicacao(id, nome, email, telefone, senha, created, modified));
								}
								System.out.println("Deseja editar outro usuario?\n");
								System.out.println("1 - Sim");
								System.out.println("2 - Nao\n");
								y = ent.nextInt();
							}
						}
					break;
					
					case 4: //Exclusao de usuarios
						int z = 1;
						System.out.println("------Exclusao de Usuarios------\n");
						System.out.println("*****************************\n");
						while (z < 2)
						{
							System.out.println("Digite o numero do usuario a ser excluido:\n");
							pos = 0;
							for (Aplicacao n:Cadastro){
								pos++;
								System.out.println("\n"+pos+"\nNome\t\t"+n.nome+"\nEmail\t\t"+n.email+"\nTelefone\t"+n.telefone);
								System.out.println("\nData Cadastro\t\t"+n.created+"\nUltima modificacao\t"+n.modified);
							}
							if (pos < 1){
								System.out.println("\nNao existem usuarios cadastrados.\n");
								z = 2;
							}
							else
							{
								esc = ent.nextInt();
								esc--;
								id = (((Aplicacao) Cadastro.get(esc)).getId());
								Usuario u = repositorioUsuario.obterPorId(id);
								repositorioUsuario.remover(u);
								System.out.println("Usuario "+u+" removido.\n");
								Cadastro.removeAll(Cadastro);
								List<Usuario> usu = repositorioUsuario.listarTodos();
								for (Usuario us : usu) {
									id = us.getId();
									nome = us.getNome();
									email = us.getEmail();
									telefone = us.getTelefone();
									senha = us.getSenha();
									created = us.getCreated();
									modified = us.getModified();
									Cadastro.add(new Aplicacao(id, nome, email, telefone, senha, created, modified));
								}
								System.out.println("Deseja fazer uma nova exclusao?\n");
								System.out.println("1 - Sim");
								System.out.println("2 - Nao\n");
								z = ent.nextInt();
							}
						}
					break;
				}
			}
			else
			{
				saida = -1;
				System.out.println("\nObrigado por usar o Cadastro de Usuarios.");
			}
		}
	}

}
