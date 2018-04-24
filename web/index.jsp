<%-- 
    Document   : index
    Created on : 24/04/2018, 16:01:59
    Author     : ChristianGuilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="WEB-INF/jspf/styles.jspf" %>
    <title>Início</title>
  </head>
  <body>
    <%@include file="WEB-INF/jspf/header.jspf" %>
    <div class="banner">
      <img src="assets/img/banner.jpg" alt="" class="img-fluid">
    </div>
    <div class="container view">
      <div class="row">
        <div class="col mt-3">
          <h3>Últimos agendamentos</h3>
        </div>
      </div>
      <div class="row">
        <div class="col">
          <p>Nenhum agendamento recente</p>
        </div>
      </div>
    </div>
    <%@include file="WEB-INF/jspf/scripts.jspf" %>
  </body>
</html>
