<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>SmartWallet - Login</title>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <style>
        body {
            background-color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            text-align: center;
            max-width: 400px;
            width: 100%;
        }
        .logo {
            font-size: 1.8em;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .logo img {
            height: 35px;
            vertical-align: middle;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<div class="login-container">
    <div class="logo">
        <img src="https://cdn-icons-png.flaticon.com/512/2948/2948035.png" alt="Carteira">
        SmartWallet
    </div>

    <form action="login" method="post">
        <div class="form-group mb-3">
            <input type="email" name="email" class="form-control" placeholder="Email" required>
        </div>

        <div class="form-group mb-3">
            <input type="password" name="senha" class="form-control" placeholder="Senha" required>
        </div>

        <button type="submit" class="btn btn-warning w-100 mb-2">Entrar</button>
    </form>

    <c:if test="${not empty erro}">
        <div class="alert alert-danger">${erro}</div>
    </c:if>
    <div class="mt-2">
        <a href="#"><img src="https://cdn-icons-png.flaticon.com/512/124/124010.png" height="30" alt="Facebook"></a>
        <a href="#"><img src="https://cdn-icons-png.flaticon.com/512/300/300221.png" height="30" alt="Google"></a>
    </div>
</div>
</body>
</html>
