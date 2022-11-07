package net.zabalburu.mcdonalds.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zabalburu.mcdonalds.modelo.Producto;
import net.zabalburu.mcdonalds.servicio.Servicio;

/**
 * Servlet implementation class MostrarMenu
 */
@WebServlet("/MostrarMenu")
public class MostrarMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Servicio servicio = new Servicio();
    private NumberFormat nf = NumberFormat.getInstance();
    private NumberFormat nfPorc = NumberFormat.getPercentInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarMenu() {
        super();
        // TODO Auto-generated constructor stub
        nf.setMaximumFractionDigits(1);
        nf.setMinimumFractionDigits(1);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("id");
		if (ids == null) {
			// No se han seleccionado productos
			response.sendRedirect("ListaProductos?error=error"
					+ "");
		} else {
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
					"    <title>Información Nutricional</title>\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n");
			
			out.println("<div class='container'>");
			out.println("<div class='row mt-5'><div class='col-3'></div><h2 class='col-6 text-center'>Seleccione los productos deseados</h2></div>");
			out.println("<div class='row'>");
			out.println("<div class='col-1'></div>");
			out.println("<div>");
			out.println("<table class=\"table\">\r\n" + 
		    		"  <thead>\r\n" + 
		    		"    <tr>\r\n" + 
		    		"      <th scope=\"col\">Producto</th>\r\n" + 
		    		"      <th scope=\"col\">Categoría</th>\r\n" + 
		    		"      <th scope=\"col\">Calorías</th>\r\n" +
		    		"      <th scope=\"col\">Colesterol</th>\r\n" + 
		    		"      <th scope=\"col\">Grasa Saturada</th>\r\n" + 
		    		"    </tr>\r\n" + 
		    		"  </thead>\r\n" + 
		    		"  <tbody>\r\n");
		    	
				List<Producto> productos = servicio.getProductos();
				double totalCalorias = 0;
				double totalColesterol = 0;
				double porcColesterol = 0;
				double totalGrasas = 0;
				double porcGrasas = 0;
				for(String strId : ids) {
					Integer id = Integer.parseInt(strId);
					Producto p = productos.get(id);
					out.println("    <tr>\r\n" + 
		    		"      <th scope=\"row\">" + p.getProducto() +"</th>\r\n" + 
		    		"      <td>" + p.getCategoria() + "</td>\r\n" + 
		    		"      <td>" + nf.format(p.getCalorias()) + "</td>\r\n" +
		    		"      <td>" + nf.format(p.getColesterol()) + " ( " + 
		    				nfPorc.format(p.getPorcDiaColesterol()/100) 
		    		+ " CDR )</td>\r\n" + 
		    		"      <td>" + nf.format(p.getGrasaSaturada()) + " ( " + 
		    				nfPorc.format(p.getPorcDiaGrasaSaturada()/100) 
		    		+ " CDR )</td>\r\n" + 
		    		"    </tr>\r\n"); 
					totalCalorias += p.getCalorias();
					totalColesterol += p.getColesterol();
					totalGrasas += p.getGrasaSaturada();
					porcColesterol += p.getPorcDiaColesterol();
					porcGrasas += p.getPorcDiaGrasaSaturada();
				}
				out.println("    <tr>\r\n" + 
			    		"      <th scope=\"row\">Totales</th>\r\n" + 
			    		"      <td></th>\r\n" + 
			    		"      <th>" + nf.format(totalCalorias) + "</th>\r\n" +
			    		"      <th>" + nf.format(totalColesterol) + " ( " + 
			    				nfPorc.format(porcColesterol/100) 
			    		+ " CDR )</th>\r\n" + 
			    		"      <th>" + nf.format(totalGrasas) + " ( " + 
			    				nfPorc.format(porcGrasas/100) 
			    		+ " CDR )</th>\r\n" + 
			    		"    </tr>\r\n"); 
		    
		    out.println("  </tbody>\r\n" + 
		    		"</table>");
		    out.println("<div class='alert alert-info'>Calorías diarias recomendadas por la OMS : <strong>1.600 - 2.000 Mujeres / 2.000 - 2.500 hombres</strong></div>");
		    out.println("<a href='ListaProductos' class='btn btn-primary'>Volver</a>");
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
