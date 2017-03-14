package desafio.ustore.webapp;

import java.util.Scanner;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.util.Date;
import java.util.List;

import desafio.ustore.objetos.Usuario;
import desafio.ustore.repositorio.RepositorioUsuario;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

@ManagedBean
@RequestScoped
public final class webapp {
	
	private Usuario usuario = new Usuario();
	
}
