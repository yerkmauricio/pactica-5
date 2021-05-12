<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginInicio" method="POST">
            <table border="1" cellpadding="2">
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" name="usuario" value="" size="40"/></td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input type="password" name="password" value="" size="40"/></td>
                </tr>
                
                  
                   
                
            </table>
             <input type="submit" name="Ingresar" />
            
        </form>
    </body>
</html>
