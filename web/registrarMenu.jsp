

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        
        <title>Registrar Menu</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Menu</title>
    </head>
    <body>
         <%@include file="WEB-INF/jspf/menup.jspf" %>
         <h1>Crear Menu</h1>
         
         
         <div class="container theme-showcase" role="main">
            <br>
            <div class="jumbotron">
                <form class="form-horizontal" action="addMenu" method="post" onsubmit="return validarDatos()">
                    <legend align="center">Ingrese los datos</legend>
                    <fieldset>
                        <div  class="form-group">
                            <label class="col-md-4 control-label" for="Nombre">Nombre</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="nombre" name="nombre" type="input" required placeholder="Nombre" maxlength="50"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="descripcion">descripcion</label>
                            <div class="col-md-4">
                                <textarea class="form-control" rows="5" id="descripcion" name="descripcion" required maxlength="100"/></textarea>
                            </div>
                        </div>
                        <div  class="form-group">
                            <label class="col-md-4 control-label" for="Precio">Precio</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="Precio" name="Precio" type="price" required placeholder="Precio" maxlength="50"/>
                            </div>
                        </div>
                        <div  class="form-group">
                            <label class="col-md-4 control-label" for="imagen">Imagen</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="imagen" name="imagen" type="file" required placeholder="Nombre" maxlength="50"/>
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
    
    </body>
</html>