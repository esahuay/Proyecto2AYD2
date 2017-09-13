<%-- 
    Document   : registrarUsuario
    Created on : 12/09/2017, 11:31:03 AM
    Author     : wxjoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <title>Registrarse</title>
        <script>
            function validarDatos(){
                var element = document.getElementById("nombre");
                var txtNombre = element.value;
                
                element = document.getElementById("apellido");
                var txtApellido =  element.value;
                
                element = document.getElementById("correo");
                var txtCorreo = element.value;
                
                element = document.getElementById("pwd1");
                var txtPwd1 = element.value;
                
                element = document.getElementById("pwd2");
                var txtPwd2 = element.value;
                
                if(txtPwd2 !== txtPwd1){
                    alert("la contraseña no coincide");
                    return false;
                }
                
                $.post('/Proyecto2AYD2/RegUser',{
                    nombre: txtNombre,
                    apellido: txtApellido,
                    correo: txtCorreo,
                    pass: txtPwd1
                }, function(resText){
                    element = document.getElementById("pwd1");
                    element.value="";
                    element = document.getElementById("pwd2");
                    element.value="";
                    $('#result').html(resText);
                });
                
                return false;
            }
        </script>
    </head>
    <body id="aplication">
        <%@include file="WEB-INF/jspf/menup.jspf" %>
        <div class="container theme-showcase" role="main">
            <br>
            <div class="jumbotron">
                <h3>Registrar Usuario</h3>
                <form class="form-horizontal" action="#" method="post" 
                      onsubmit="return validarDatos()">
                    <legend>Datos de Usuario</legend>
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombre">Nombre</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="nombre" name="nombre" type="text" required placeholder="Nombre"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="apellido">Apellido</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="apellido" name="apellido" type="text" placeholder="Apellido" required />
                            </div>
                        </div>
                        <div  class="form-group">
                            <label class="col-md-4 control-label" for="correo">Correo</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="correo" name="correo" type="email" required placeholder="algun@correo.com"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pwd1">Contraseña</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="pwd1" name="pwd1" type="password" placeholder="123456" required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pwd2"> Repetir Contraseña</label>
                            <div class="col-md-4">
                                <input class="form-control input-md" id="pwd2" name="pwd2" type="password" placeholder="123456"required />
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
