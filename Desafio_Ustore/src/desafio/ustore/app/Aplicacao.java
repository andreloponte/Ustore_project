package desafio.ustore.app;

import java.util.Collections;
import java.util.Scanner;

import cadastrorestaurante.Atendimento;

import java.util.Date;
import java.util.List;

import desafio.ustore.objetos.Usuario;
import desafio.ustore.repositorio.RepositorioUsuario;

import java.util.ArrayList;

public class Aplicacao {
	
	String nome, senha, email;
	int telefone, pos;
	Date created, modified;
	
	public Aplicacao (String nome,String email,int telefone, String senha, Date created, Date modified){
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.created = created;
		this.modified = modified;
	}
	
	public int getPosicao(){
		return pos;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getEmail(){
		return email;
	}
	
	public int getTelefone(){
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
		int esc,i=0,saida=2, laco3, laco4;
		
		String nome, senha, email;
		int telefone, pos;
		Date created, modified;
			
		while (saida>0)
		{
			System.out.println("Bem Vindo ao Cadastro de Usuarios\n");
			System.out.println("*****************************\n");
			System.out.println("O que deseja fazer?\n");
			System.out.println("1 - Cadastrar Novo Usuario");
			System.out.println("2 - Consultar Usuario");
			System.out.println("3 - Excluir Usuario");
			System.out.println("0 - Sair\n");
			esc = ent.nextInt();
			if (esc>0)
			{
				switch (esc)
				{
					case 1:
						System.out.println("Bem Vindo ao Cadastro de Usuarios\n");
						System.out.println("*****************************\n");
						do
						{
							System.out.println("Digite abaixo os dados do usuario que deseja cadastrar:\n");
							System.out.println("Nome");
							nome = new Scanner(System.in).nextLine();
							System.out.println("Email");
							email = new Scanner(System.in).nextLine();
							System.out.println("Telefone");
							telefone = ent.nextInt();
							System.out.println("Senha");
							senha = new Scanner(System.in).nextLine();
							created = new Date();
							
							if (Cadastro.indexOf(email) < 0)
							{
								Cadastro.add(new Aplicacao(nome, email, telefone, senha, created));
								usuario.setNome(nome);
								usuario.setEmail(email);
								usuario.setTelefone(telefone);
								usuario.setSenha(senha);
								usuario.setCreated(created);
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
					
					case 2:
						laco3 = 1;
						while (laco3 < 2){
							System.out.println("\nConsulta de Usuarios\n");
							System.out.println("Qual tipo de consulta deseja fazer?\n");
							System.out.println("1 - Listar Usuarios");
							System.out.println("2 - Consultar Usuario Especifico");
							System.out.println("3 - Voltar ao Menu Principal\n");
							esc = ent.nextInt();
							switch (esc){
								case 1: //Listar Atendimentos
									pos = 0;
									for (Aplicacao n:Cadastro){
										pos++;
										System.out.println("\n"+pos+"\nNome\t\t"+n.nome+"\nEmail\t\t"+n.email+"\nTelefone\t"+n.telefone);
										System.out.println("\nData Cadastro\t\t"+created+"\nUltima modificacao\t\t"+modified);
										pos++;
									}
								break;
								
								case 2: //Consultar Atendimento Espec�fico
									laco4 = 1;
									while (laco4 < 2){
										System.out.println("\n1 - Consultar Nome do Cliente");
										System.out.println("2 - Consultar CPF");
										System.out.println("3 - Consultar Placa do Ve�culo");
										System.out.println("4 - Consultar Atendente");
										System.out.println("5 - Voltar ao Menu Consulta de Atendimento\n");
										escolha3 = entrada.nextInt();
										switch (escolha3){
											case 1: //Consultar Nome do Cliente
												System.out.println("\nDigite o nome do cliente:\n");
												consultastr = new Scanner(System.in).nextLine();
												pos = 0;
												for (Atendimento n:Cadastro){
												if((((Atendimento)Cadastro.get(pos)).getNome()).equalsIgnoreCase(consultastr))
													{
														nomecli = (((Atendimento) Cadastro.get(pos)).getNome());
														cpf = (((Atendimento) Cadastro.get(pos)).getCpf());
														tel = (((Atendimento) Cadastro.get(pos)).getTel());
														marca = (((Atendimento) Cadastro.get(pos)).getMarca()); 
														modelo = (((Atendimento) Cadastro.get(pos)).getModelo());
														placa = (((Atendimento) Cadastro.get(pos)).getPlaca());
														nomefun = (((Atendimento) Cadastro.get(pos)).getAtendente());
														matricula = (((Atendimento) Cadastro.get(pos)).getMatricula());
														System.out.println("\nCliente\t\t"+nomecli+"\nCPF\t\t"+cpf+"\nTelefone\t"+tel);
														System.out.println("Ve�culo:\nMarca\t\t"+marca+"\nModelo\t\t"+modelo+"\nPlaca\t\t"+placa);
														System.out.println("Respons�vel:\nFuncion�rio\t"+nomefun+"\nMatricula\t"+matricula+"\n");
													}
												pos++;
												}
											break;

											case 2: //Consultar CPF
												System.out.println("\nDigite o CPF do cliente:\n");
												consultastr = new Scanner(System.in).nextLine();
												pos = 0;
												for (Atendimento n:Cadastro){
												if((((Atendimento)Cadastro.get(pos)).getCpf()).equalsIgnoreCase(consultastr))
													{
														nomecli = (((Atendimento) Cadastro.get(pos)).getNome());
														cpf = (((Atendimento) Cadastro.get(pos)).getCpf());
														tel = (((Atendimento) Cadastro.get(pos)).getTel());
														marca = (((Atendimento) Cadastro.get(pos)).getMarca()); 
														modelo = (((Atendimento) Cadastro.get(pos)).getModelo());
														placa = (((Atendimento) Cadastro.get(pos)).getPlaca());
														nomefun = (((Atendimento) Cadastro.get(pos)).getAtendente());
														matricula = (((Atendimento) Cadastro.get(pos)).getMatricula());
														System.out.println("\nCliente\t\t"+nomecli+"\nCPF\t\t"+cpf+"\nTelefone\t"+tel);
														System.out.println("Ve�culo:\nMarca\t\t"+marca+"\nModelo\t\t"+modelo+"\nPlaca\t\t"+placa);
														System.out.println("Respons�vel:\nFuncion�rio\t"+nomefun+"\nMatricula\t"+matricula+"\n");
													}
												pos++;
												}
											break;

											case 3: //Consultar Placa do Ve�culo
												System.out.println("\nDigite a placa do ve�culo do cliente:\n");
												consultastr = new Scanner(System.in).nextLine();
												pos = 0;
												for (Atendimento n:Cadastro){
												if((((Atendimento)Cadastro.get(pos)).getPlaca()).equalsIgnoreCase(consultastr))
													{
														nomecli = (((Atendimento) Cadastro.get(pos)).getNome());
														cpf = (((Atendimento) Cadastro.get(pos)).getCpf());
														tel = (((Atendimento) Cadastro.get(pos)).getTel());
														marca = (((Atendimento) Cadastro.get(pos)).getMarca()); 
														modelo = (((Atendimento) Cadastro.get(pos)).getModelo());
														placa = (((Atendimento) Cadastro.get(pos)).getPlaca());
														nomefun = (((Atendimento) Cadastro.get(pos)).getAtendente());
														matricula = (((Atendimento) Cadastro.get(pos)).getMatricula());
														System.out.println("\nCliente\t\t"+nomecli+"\nCPF\t\t"+cpf+"\nTelefone\t"+tel);
														System.out.println("Ve�culo:\nMarca\t\t"+marca+"\nModelo\t\t"+modelo+"\nPlaca\t\t"+placa);
														System.out.println("Respons�vel:\nFuncion�rio\t"+nomefun+"\nMatricula\t"+matricula+"\n");
													}
												pos++;
												}
											break;

											case 4: //Consultar Atendente
												System.out.println("\nDigite o nome do respons�vel pelo atendimento:\n");
												consultastr = new Scanner(System.in).nextLine();
												pos = 0;
												for (Atendimento n:Cadastro){
												if((((Atendimento)Cadastro.get(pos)).getAtendente()).equalsIgnoreCase(consultastr))
													{
														nomecli = (((Atendimento) Cadastro.get(pos)).getNome());
														cpf = (((Atendimento) Cadastro.get(pos)).getCpf());
														tel = (((Atendimento) Cadastro.get(pos)).getTel());
														marca = (((Atendimento) Cadastro.get(pos)).getMarca()); 
														modelo = (((Atendimento) Cadastro.get(pos)).getModelo());
														placa = (((Atendimento) Cadastro.get(pos)).getPlaca());
														nomefun = (((Atendimento) Cadastro.get(pos)).getAtendente());
														matricula = (((Atendimento) Cadastro.get(pos)).getMatricula());
														System.out.println("\nCliente\t\t"+nomecli+"\nCPF\t\t"+cpf+"\nTelefone\t"+tel);
														System.out.println("Ve�culo:\nMarca\t\t"+marca+"\nModelo\t\t"+modelo+"\nPlaca\t\t"+placa);
														System.out.println("Respons�vel:\nFuncion�rio\t"+nomefun+"\nMatricula\t"+matricula+"\n");
													}
												pos++;
												}
											break;

											case 5: //Voltar ao Menu Consulta de Atendimento
												laco4 = 2;
											break;
											
										}
									}
								break;
								
								case 3: //Voltar ao Menu Principal
									laco3 = 2;
								break;

								default:
									System.out.println("\nEssa op��o n�o existe, por favor tente outra.\n");
								break;
							}
						}
					break;
					
					case 3:
						int z = 1;
						System.out.println("------Exclus�o de Usuarios------\n");
						while (z < 2)
						{
							System.out.println("Digite o nome do aluno a ser excluido:\n");
							nome = new Scanner(System.in).nextLine();
							if (Nomes.indexOf(nome)>-1)
							{
								Nomes.remove(Nomes.indexOf(nome));
								System.out.println("Aluno "+nome+" removido.\n");
							}
							else
							{
								System.out.println("Aluno n�o encontrado.\n");
							}
							System.out.println("Deseja fazer uma nova exclus�o?\n");
							System.out.println("1 - Sim");
							System.out.println("2 - N�o\n");
							z = ent.nextInt();
						}
					break;
				}
			}
			else
			{
				saida = -1;
				System.out.println("Obrigado por usar o Cadastro Escolar.");
			}
		}
	}

}
