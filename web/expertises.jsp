<%-- 
    Document   : expertises
    Created on : 24/04/2018, 16:01:59
    Author     : ChristianGuilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="WEB-INF/jspf/styles.jspf" %>
    <title>Especializações</title>
  </head>
  <body id="expertises">
    <%@include file="WEB-INF/jspf/header.jspf" %>
    <div class="container">
      <div class="row">
        <div class="col mt-3">
          <h3>Especializações disponíveis</h3>
          <ul class="unstyled-list mt-3" id="expertise-list">
            <li>Carregando especializações...</li>
          </ul>
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-auto mt-3">
          <button 
            type="button"
            data-toggle="modal" data-target="#expertise-modal"
            class="btn btn-primary">Adicionar especialização</button>
        </div>
      </div>
    </div>
    <div class="modal fade" id="expertise-modal" tabindex="-1" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Cadastrar especialização</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form id="expertise-form">
              <div class="form-group">
                <label for="expertise-name" class="form-control-label">Nome</label>
                <input type="text" id="expertise-name" class="form-control" name="name">
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-primary" id="expertise-form-btn">Cadastrar</button>
          </div>
        </div>
      </div>
    </div>
    <%@include file="WEB-INF/jspf/scripts.jspf" %>
  </body>
</html>
