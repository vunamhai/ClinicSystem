package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class serviceManagementList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write(" * 2022-02-08      1.0                 MinhVT         Controller Service Management List\n");
      out.write("-->\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/service/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto|Varela+Round\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"new.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <title>Clinic Management</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\" id=\"service-container\">\n");
      out.write("            <!-- Header -->\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\n");
      out.write("                            data-bs-target=\"#navbarClinicHeader\" aria-controls=\"navbarClinicHeader\" aria-expanded=\"false\"\n");
      out.write("                            aria-label=\"Toggle navigation\">\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"navbarClinicHeader\">\n");
      out.write("                        <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n");
      out.write("\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link active\" href=\"#\">Quản lý dịch vụ</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"../ClinicManagement/ViewFeedbackManagedListController\">Quản lý phản hồi</a>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                        <div class=\"avatar\">\n");
      out.write("                            <img src=\"https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png\" alt=\"avatar\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("            <h1 id=\"title\">\n");
      out.write("                Dach sách dịch vụ\n");
      out.write("            </h1>\n");
      out.write("\n");
      out.write("            <div class=\"wrapper\">\n");
      out.write("                <button id=\"add-btn\" type=\"button\" class=\"btn btn-light mb-3\" onclick=\"showAddServiceModal()\">\n");
      out.write("                    <i class=\"bi bi-plus-circle-fill\"></i>\n");
      out.write("                    Thêm dịch vụ\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <!-- Table -->\n");
      out.write("                <table class=\"table table-bordered align-middle\" id=\"table-services\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th scope=\"col\">#</th>\n");
      out.write("                            <th scope=\"col\">Mã ID</th>\n");
      out.write("                            <th scope=\"col\">Tên dịch vụ</th>\n");
      out.write("                            <th scope=\"col\">Tóm tắt dịch vụ</th>\n");
      out.write("                            <th scope=\"col\">Thao tác</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("                <div id=\"modal-update\" class=\"modal-update\">\n");
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        function openModalUpdateService(idService) {\n");
      out.write("                        $.ajax({\n");
      out.write("                        type: \"get\",\n");
      out.write("                                url: \"/ClinicManagement/UpdateService\",\n");
      out.write("                                data: {\n");
      out.write("                                idService: idService\n");
      out.write("                                }, // serializes the form's elements.\n");
      out.write("                                success: function (data)\n");
      out.write("                                {\n");
      out.write("                                var formUpdate = document.getElementById(\"modal-update\");\n");
      out.write("                                formUpdate.innerHTML += data;\n");
      out.write("                                }\n");
      out.write("                        });\n");
      out.write("                        document.getElementById(\"modal-update\").style.display = \"flex\";\n");
      out.write("                        }\n");
      out.write("                    </script>\n");
      out.write("                    <script>\n");
      out.write("                        function openModalViewService(idService) {\n");
      out.write("                         $.ajax({\n");
      out.write("                        type: \"get\",\n");
      out.write("                                url: \"/ClinicManagement/ViewService\",\n");
      out.write("                                data: {\n");
      out.write("                                idService: idService\n");
      out.write("                                }, // serializes the form's elements.\n");
      out.write("                                success: function (data)\n");
      out.write("                                {\n");
      out.write("                                var formUpdate = document.getElementById(\"modal-update\");\n");
      out.write("                                formUpdate.innerHTML += data;\n");
      out.write("                                }\n");
      out.write("                        });\n");
      out.write("                        document.getElementById(\"modal-update\").style.display = \"flex\";\n");
      out.write("                        }\n");
      out.write("                    </script>\n");
      out.write("                    <script>\n");
      out.write("                        function openModalDeleteService(idService) {\n");
      out.write("                        $.ajax({\n");
      out.write("                        type: \"get\",\n");
      out.write("                                url: \"/ClinicManagement/DeleteService\",\n");
      out.write("                                data: {\n");
      out.write("                                idService: idService\n");
      out.write("                                }, // serializes the form's elements.\n");
      out.write("                                success: function (data)\n");
      out.write("                                {\n");
      out.write("                                var formUpdate = document.getElementById(\"modal-update\");\n");
      out.write("                                formUpdate.innerHTML += data;\n");
      out.write("                                }\n");
      out.write("                        });\n");
      out.write("                        document.getElementById(\"modal-update\").style.display = \"flex\";\n");
      out.write("                        }\n");
      out.write("                    </script>\n");
      out.write("\n");
      out.write("                    <!-- Pagination -->\n");
      out.write("\n");
      out.write("                    <!-- Detail Service Modal -->\n");
      out.write("                    <div class=\"modal fade\" id=\"detailServiceModal\" data-bs-keyboard=\"false\" tabindex=\"-1\" aria-hidden=\"true\">\n");
      out.write("                        <div class=\"modal-dialog modal-lg\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <div class=\"non-block\"></div>\n");
      out.write("                                    <h5 class=\"modal-title\" id=\"staticBackdropLabel\">Chi tiết dịch vụ</h5>\n");
      out.write("                                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("                                    <div class=\"container-fluid\">\n");
      out.write("                                        <form class=\"row g-3\">\n");
      out.write("                                            <div class=\"pe-5 col-6\">\n");
      out.write("                                                <div class=\"row mb-3\">\n");
      out.write("                                                    <label for=\"serviceCode\" class=\"col-4 col-form-label\">Mã dịch vụ</label>\n");
      out.write("                                                    <div class=\"col-8\">\n");
      out.write("                                                        <span class=\"form-control-plaintext service_id\"></span>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row mb-3\">\n");
      out.write("                                                    <label for=\"serviceName\" class=\"col-4 col-form-label\">Tên dịch vụ</label>\n");
      out.write("                                                    <div class=\"col-8\">\n");
      out.write("                                                        <span class=\"desc-text form-control-plaintext service_name\"></span>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <label for=\"serviceDesc\" class=\"col-4 col-form-label\">Mô tả</label>\n");
      out.write("                                                    <div class=\"col-8\">\n");
      out.write("                                                        <span class=\"form-control-plaintext service_desc\"></span>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"ps-5 col-6\">\n");
      out.write("                                                <div class=\"row\">\n");
      out.write("                                                    <div class=\"col-7 col-form-label\">\n");
      out.write("                                                        Bác sĩ\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"row list-doctors\">\n");
      out.write("                                                    <div class=\"list-doctors-scroll\">\n");
      out.write("\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </form>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- Add Service Modal -->\n");
      out.write("                  \n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Select Doctor Modal -->\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <!-- Delete Service Modal -->\n");
      out.write("              \n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Bootstrap Bundle -->\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"\n");
      out.write("                    integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("                    integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js\" integrity=\"sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("            <script src=\"./index.js\"></script>\n");
      out.write("            \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${services}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("service");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                <th scope=\"row\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${service.serviceId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${service.serviceName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td class=\"service-desc\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${service.serviceDescription}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>\n");
          out.write("                                    <div class=\"action\">\n");
          out.write("                                        <button class=\"bi bi-pencil-fill\" data-toggle=\"modal\" onclick=\"\"\n");
          out.write("                                                data-target=\"#myModal\">View</button> \n");
          out.write("                                        <button class=\"bi bi-pencil-fill\" data-toggle=\"modal\" onclick=\"openModalUpdateService(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${service.serviceId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(")\"\n");
          out.write("                                                data-target=\"#myModal\">Edit</button> \n");
          out.write("<!--                                        <button class=\"bi bi-trash-fill\" data-toggle=\"modal\" onclick=\"\"\n");
          out.write("                                                data-target=\"#myModal\">Delete</button>-->\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
