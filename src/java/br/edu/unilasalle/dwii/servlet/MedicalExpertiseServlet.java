/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unilasalle.dwii.servlet;

import br.edu.unilasalle.dwii.classes.MedicalExpertise;
import br.edu.unilasalle.dwii.database.MedicalExpertiseDAO;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ChristianGuilherme
 */
@WebServlet("/medical_expertises/*")
public class MedicalExpertiseServlet extends HttpServlet {
  
  private MedicalExpertiseDAO dao = new MedicalExpertiseDAO();
  
  @Override
  protected void service(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    String method = request.getMethod();
    
    switch (method) {
      case "GET": {
        try {
          this.show(request, response);
        } catch (ClassNotFoundException | SQLException | IOException exception) {
          throw new RuntimeException(exception);
        }
        break;
      }
      case "POST": {
        try {
          this.store(request, response);
        } catch (ClassNotFoundException | SQLException | IOException exception) {
          throw new RuntimeException(exception);
        }
        break;
      }
    }
  }
  
  
  private void store(
          HttpServletRequest req,
          HttpServletResponse res
  ) throws IOException, SQLException, ClassNotFoundException {
    StringBuilder buffer = new StringBuilder();
    BufferedReader reader = req.getReader();
    String line;
    while ((line = reader.readLine()) != null) {
      buffer.append(line);
    }
    Gson gson = new Gson();
    MedicalExpertise expertise = gson.fromJson(buffer.toString(), MedicalExpertise.class);
    expertise.setActive(true);
    
    dao.store(expertise); 
    res.setStatus(201);
   
  }
  
  private void show(
          HttpServletRequest req, 
          HttpServletResponse res
  ) throws IOException, SQLException, ClassNotFoundException {
    
    String path = req.getPathInfo();
    Gson gson = new Gson();
    PrintWriter out = res.getWriter();
    
    if (path == null || path.equals("/")) {
      Collection<MedicalExpertise> expertises = dao.list();
      if (expertises.isEmpty()) {
        res.sendError(HttpServletResponse.SC_NO_CONTENT);
        return;
      }
      out.print(gson.toJson(expertises));
      out.flush();
      return;
    } 
    
    String[] segments = path.split("/");
    if (segments.length != 2) {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    
    Long id = Long.parseLong(segments[1], 10);
    
    MedicalExpertise expertise = dao.show(id);
    if (expertise == null) {
      res.sendError(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    out.print(gson.toJson(expertise));
    out.flush();
  }
}
