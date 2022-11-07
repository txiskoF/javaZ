package net.zabalburu.mcdonalds.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zabalburu.mcdonalds.modelo.Producto;
import net.zabalburu.mcdonalds.servicio.Servicio;

/**
 * Servlet implementation class ListaProductos
 */
@WebServlet("/ListaProductos")
public class ListaProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Servicio servicio = new Servicio(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		out.println("<!doctype html>\r\n" + 
				"<html lang=\"es\">\r\n" + 
				"  <head>\r\n" + 
				"    <!-- Required meta tags -->\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
				"\r\n" + 
				"    <!-- Bootstrap CSS -->\r\n" + 
				"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n" + 
				"\r\n" + 
				"    <title>Seleccione los productos deseados</title>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n");
		
		out.println("<div class='container'>");
		out.println("<div class='row mt-5'><div class='col-3'></div><h2 class='col-6 text-center'>Seleccione los productos deseados</h2></div>");
		
		if (request.getParameter("error")!=null) {
			out.println("<div class='row mt-1'>");
			out.println("<div class='col-3'></div>");
			out.println("<div class='alert alert-danger col-6'>Debe seleccionar algún producto</div>");
			out.println("</div>");
		}
		out.println("<div class='row'>");
		out.println("<div class='col-3'></div>");
		out.println("<div>");
		out.println("<form action='MostrarMenu' method='GET'>\r\n"); 
	    out.println("<table class=\"table\">\r\n" + 
	    		"  <thead>\r\n" + 
	    		"    <tr>\r\n" + 
	    		"      <th scope=\"col\">#</th>\r\n" + 
	    		"      <th scope=\"col\">Categoría</th>\r\n" + 
	    		"      <th scope=\"col\">Producto</th>\r\n" + 
	    		"      <th scope=\"col\"></th>\r\n" + 
	    		"    </tr>\r\n" + 
	    		"  </thead>\r\n" + 
	    		"  <tbody>\r\n");
	    int contador = 1;
	    for(Producto p : servicio.getProductos()) {
	    	
	    	out.println("    <tr>\r\n" + 
	    		"      <th scope=\"row\">" + contador +"</th>\r\n" + 
	    		"      <td>" + p.getProducto() + "</td>\r\n" + 
	    		"      <td>" + p.getCategoria() + "</td>\r\n" + 
	    		"      <td><input type='checkbox' name='id' value='" +
	    			(contador - 1) +
	    			"'</td>\r\n" + 
	    		"    </tr>\r\n"); 
	    	contador++;
	    }
	    
	    out.println("  </tbody>\r\n" + 
	    		"</table>");
	    out.println("<input type='submit' class='btn btn-primary' name='Enviar' value='Enviar'>");
		out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println( 
				"    <!-- Optional JavaScript -->\r\n" + 
				"    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n" + 
				"    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n" + 
				"  </body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
