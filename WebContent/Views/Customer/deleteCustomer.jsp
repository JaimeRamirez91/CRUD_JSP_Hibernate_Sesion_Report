<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/estilo.css" />
</head>
<body class="container">
          <!-- navbar -->
         <jsp:include page="../Componentes/navbar.jsp" />
		 <h1 class="text-center mt-fixed-nav">ELIMINAR CUSTOMER </h1>
         <c:url value="/addCustomer" var="registerUrl" /> <!-- URL petici�n-->
         <c:if test="${success == null}">
	         <form method="POST" action="${registerUrl}" class="col-6 offset-3">
	                <c:forEach items="${datos}" var="customer">
	                    <input type="hidden" name="option" value="delete">
	                    <input type="hidden" name="customer_id" value="${customer.customer_id}">
	                    <section class='alert alert-danger col-8 offset-2 text-center ' role='alert' id='alerta'>
	                        �Esta seguro de eliminar el usuario:? : ${customer.first_name}
	                    </section>               
	                </c:forEach>
	                <input type="submit" class="col-4 offset-4 btn btn-outline-danger" value="Eliminar" >
	        </form>
        </c:if>
        <c:if test="${success != null}">
        	<section class="alert alert-danger col-4 offset-4 text-center" role="alert" id="alerta"> ${success} </section>
        	<a  class="btn btn-outline-success text-center col-4 offset-4" href="http://localhost:8080/CRUD_JSP_Hibernate_Sesion_Report/addCustomer?action=list">Retornal a la lista principal</a>
      </c:if>
</body>
</html>