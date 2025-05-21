<%@ page import="dao.InternshipDAO, java.util.List, model.Internship" %>
<%
    InternshipDAO dao = new InternshipDAO();
    List<Internship> list = dao.getAllInternships();
    for (Internship i : list) {
%>
<option value="<%= i.getId() %>"><%= i.getTitle() %></option>
<% } %>
