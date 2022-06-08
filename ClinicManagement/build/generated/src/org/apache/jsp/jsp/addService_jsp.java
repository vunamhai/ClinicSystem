package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addService_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!--\n");
      out.write(" * Copyright(C) 20022, FPT University\n");
      out.write(" * CMS:\n");
      out.write(" * Clinic Management System\n");
      out.write(" *\n");
      out.write(" * Record of change:\n");
      out.write(" * DATE            Version             AUTHOR           DESCRIPTION\n");
      out.write(" * 2022-02-26      1.0                 MinhVT           Add Service \n");
      out.write(" -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Service</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"../assets/styles/jquery-ui.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../assets/styles/jquery-ui.structure.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../assets/styles/jquery-ui.theme.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table style=\"margin-left: auto; margin-right: auto; border: 1px solid\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Tên dịch vụ</th>\n");
      out.write("                <th>Tóm tắt</th>\n");
      out.write("                <th>Mô tả</th>\n");
      out.write("                <th>Hình ảnh</th>\n");
      out.write("                <th>Add</th>\n");
      out.write("            </tr>\n");
      out.write("            <form action=\"../AddServiceController\" method=\"POST\">\n");
      out.write("                <tr>\n");
      out.write("                    <td style=\"text-align: center; border: 1px solid\" >\n");
      out.write("                        <input name=\"serviceName\">\n");
      out.write("                    </td>                  \n");
      out.write("                    <td style=\"text-align: center; border: 1px solid\">\n");
      out.write("                        <input name=\"serviceDescription\">\n");
      out.write("                    </td>\n");
      out.write("                    <td style=\"text-align: center; border: 1px solid\" class=\"btn-success\">\n");
      out.write("                        <a href=\"\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\">Add</button>\n");
      out.write("                        </a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
