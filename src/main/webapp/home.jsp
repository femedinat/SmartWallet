<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>SmartWallet - Dashboard</title>
  <link rel="stylesheet" href="resources/css/bootstrap.css">
  <style>
    body {
      background-color: #f8f9fa;
    }

    .sidebar {
      height: 100vh;
      background-color: #2c2c2c;
      color: white;
    }

    .sidebar a {
      color: white;
      text-decoration: none;
      display: block;
      margin: 15px 0;
    }

    .card-saldo {
      background-color: #212529;
      color: white;
    }

    .value {
      font-size: 1.5rem;
      font-weight: bold;
    }

    .graph-placeholder {
      height: 200px;
      background-color: #dee2e6;
      border-radius: 8px;
      display: flex;
      align-items: center;
      justify-content: center;
      color: #6c757d;
      font-size: 1rem;
    }

    .config-link {
      position: absolute;
      bottom: 20px;
      left: 20px;
      font-size: 0.9rem;
    }
  </style>
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <!-- Sidebar -->
    <div class="col-md-2 sidebar d-flex flex-column p-4 position-relative">
      <h3 class="mb-4">Smart<span style="color: gold;">Wallet</span></h3>
      <a href="#">Dashboard</a>
      <a href="#">Movimentações</a>
      <a href="#">Classificações</a>
      <div class="config-link">⚙ Configurações</div>
    </div>

    <!-- Main content -->
    <div class="col-md-10 p-4">
      <h2>Dashboard</h2>

      <!-- Cards -->
      <div class="row mt-4">
        <div class="col-md-4">
          <div class="card text-center p-3">
            <h5>RECEITAS</h5>
            <div class="value text-success">R$ ${receitas}</div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card text-center p-3">
            <h5>DESPESAS</h5>
            <div class="value text-danger">R$ ${despesas}</div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card card-saldo text-center p-3">
            <h5>SALDO</h5>
            <div class="value ${saldo >= 0 ? 'text-success' : 'text-danger'}">
              R$ ${saldo}
            </div>
          </div>
        </div>
      </div>

      <!-- Tabela -->
      <div class="row mt-5">
        <div class="d-flex justify-content-end mb-3">
          <a href="add-transacao.jsp" class="btn btn-success fw-bold px-4 py-2 rounded-pill shadow-sm d-flex align-items-center gap-2">
            <span class="fs-5">+</span> Adicionar Transação
          </a>
        </div>
        <div class="col-12">
          <table class="table table-bordered table-hover">
            <thead class="table-dark">
            <tr>
              <th>Id movimentação</th>
              <th>Tipo</th>
              <th>Valor</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="transacao" items="${transacoes}">
              <tr>
                <td>${transacao.id}</td>
                <td>${transacao.type}</td>
                <td>R$ <fmt:formatNumber value="${transacao.value}" type="number" minFractionDigits="2" /></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>

    </div>
  </div>
</div>
</body>
</html>
