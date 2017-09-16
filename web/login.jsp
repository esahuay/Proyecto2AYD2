<%-- 
    Document   : login
    Created on : 15/09/2017, 04:25:37 AM
    Author     : Eliseo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menup.jspf" %>
        
         <div class="container theme-showcase" role="main">
            <br>
            <div class="jumbotron">
                <form class="form-horizontal" action="LogServlet" method="post" 
                      onsubmit="return validarDatos()">
                    <legend align="center">Ingrese sus credenciales</legend>
                    <fieldset>
                        <div  class="form-group">
                            <label class="col-md-4 control-label" for="correo">Correo</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="email" name="email" type="email" required placeholder="algun@correo.com"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pwd1">Contraseña</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="password" name="password" type="password" placeholder="123456" required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label"> </label>
                            <div class="col-md-8">
                                <input id="btnAceptar" name="btnAceptar" type="submit" class="btn btn-success" value="Aceptar"/>
                                <input id="btnCancel" name="btnCancel" type="reset" value="Cancelar" class="btn btn-danger">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div id="result">
                    
            </div>
        </div>
        
        <%@include file="WEB-INF/jspf/scripts.jspf"%>
    </body>
</html>
