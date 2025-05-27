<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Adicionar Transação</title>
  <link rel="stylesheet" href="resources/css/bootstrap.css">
</head>
<body class="bg-light">

<div class="container mt-5">
  <h2>Adicionar Nova Transação</h2>
  <form action="transacao" method="post" class="mt-4">
    <div class="mb-3">
      <label for="tipo" class="form-label">Tipo</label>
      <select name="tipo" id="tipo" class="form-select" required>
        <option value="">Selecione</option>
        <option value="Receita">Receita</option>
        <option value="Despesa">Despesa</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="valor" class="form-label">Valor (R$)</label>
      <input type="number" name="valor" id="valor" class="form-control" step="0.01" required>
    </div>

    <button type="submit" class="btn btn-success">Salvar</button>
    <a href="home" class="btn btn-secondary">Cancelar</a>
  </form>
</div>

</body>
</html>
