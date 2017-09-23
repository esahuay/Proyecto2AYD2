<%-- 
    Document   : registrarRestaurante
    Created on : 23/09/2017, 06:24:51 AM
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
                <form class="form-horizontal" action="AddRestaurante" method="post" onsubmit="return validarDatos()">
                    <legend align="center">Ingrese los datos</legend>
                    <fieldset>
                        <div  class="form-group">
                            <label class="col-md-4 control-label" for="nrest">Restaurante</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="nrest" name="nrest" type="input" required placeholder="Restaurante" maxlength="50"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="desc">Descripción</label>
                            <div class="col-md-4">
                                <textarea class="form-control" rows="5" id="desc" name="desc" required maxlength="100"/></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label"> </label>
                            <div class="col-md-8">
                                <input id="btnAceptar" name="btnAceptar" type="submit" class="btn btn-success" value="Aceptar"/>
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

