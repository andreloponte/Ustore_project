/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M17
 * Generated at: 2017-03-13 15:12:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Scanner;
import java.util.Date;
import java.util.List;
import desafio.ustore.objetos.Usuario;
import desafio.ustore.repositorio.RepositorioUsuario;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class cadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/Ustore_project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DesafioUstore/WEB-INF/lib/javax.faces-2.3.0-m11.jar!/META-INF/jsf_core.tld", Long.valueOf(1488441466000L));
    _jspx_dependants.put("/WEB-INF/lib/javax.faces-2.3.0-m11.jar", Long.valueOf(1489372294472L));
    _jspx_dependants.put("jar:file:/D:/Ustore_project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DesafioUstore/WEB-INF/lib/javax.faces-2.3.0-m11.jar!/META-INF/html_basic.tld", Long.valueOf(1488441466000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("desafio.ustore.objetos.Usuario");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("org.json.JSONException");
    _jspx_imports_classes.add("org.json.JSONObject");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.util.Scanner");
    _jspx_imports_classes.add("desafio.ustore.repositorio.RepositorioUsuario");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("     <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("     <title>Cadastro de Usuarios</title>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("  ");

		String email = request.getParameter("email");
		if (email == null)
		{
			JSONObject erro = new JSONObject();
			erro.put("Erro", "Email invalido");
			out.println(erro);
			out.println("Favor, inclua um email valido.");
		}
	
      out.write("\r\n");
      out.write("  \t<h1>Cadastro de Usuarios</h1>\r\n");
      out.write("  \t<h3>Digite os dados do usuario:</h3>\r\n");
      out.write("  \t<form id=\"adduser\" name=\"adduser\" method=\"post\" action=\"cadastro.jsp\">\r\n");
      out.write("\t\tNome:<br/>\r\n");
      out.write("\t\t<label>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"nome\" id=\"nome\"/><br/>\r\n");
      out.write("\t\t</label>\r\n");
      out.write("\t\tEmail:<br/>\r\n");
      out.write("\t\t<label>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"email\" id=\"email\"/><br/>\r\n");
      out.write("\t\t</label>\r\n");
      out.write("\t\tTelefone:<br/>\r\n");
      out.write("\t\t<label>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"telefone\" id=\"telefone\"/><br/>\r\n");
      out.write("\t\t</label>\r\n");
      out.write("\t\tSenha:<br/>\r\n");
      out.write("\t\t<label>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"senha\" id=\"senha\"/><br/>\r\n");
      out.write("\t\t</label>\r\n");
      out.write("\t\t<input type=\"submit\" name=\"button\" id=\"button\" value=\"Confirmar\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
