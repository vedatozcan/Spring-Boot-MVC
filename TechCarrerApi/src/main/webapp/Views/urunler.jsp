<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>



 <table class="table table-striped">
    <thead>
      <tr>
        <th>#</th>
        <th>Kategori Adı</th>
        <th>Keyword</th>
        <th>Description</th>
      </tr>
    </thead>
    <tbody>
 	<c:forEach items="${kategori}" var="entity">
     <tr>
        <td>${entity.Id}</td>
        <td>${entity.Name}</td>
        <td>${entity.Keyword}</td>
         <td>${entity.Description }</td>       
      </tr>
     </c:forEach>
     
    </tbody>

</body>
</html>