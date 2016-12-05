<%-- 
    Created on : Dec 3, 2016, 12:38:03 AM
    Author     : JZ Greenwell, Casey Hayes
--%>
<%@include file="includes/header.jsp" %>

<section>
  <p>
    <a href="<c:url value='Library?action=GetBook' />">Check out a book</a>
  </p>
  <p>
    <a href="<c:url value='Library?action=ManageBooks' />">Manage checked out 
      books</a>
  </p>
</section>

<%@include file="includes/footer.jsp" %>   
