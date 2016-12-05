<%-- 
    Created on : Dec 3, 2016, 12:38:03 AM
    Author     : JZ Greenwell, Casey Hayes
--%>
<%@include file="includes/header.jsp" %>
<section>
  <h2>Currently checked out books</h2>
    <table id="yoyt">
        <thead>
          <tr>
            <th>Patron Name</th>
            <th>Email Address</th>
            <th>Book Title</th>
            <th>Due Date</th>
            <th colspan="3">Overdue</th>
          </tr> 
        </thead>
        <c:forEach var="user" items="${users}">
          <tr>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.bookName}</td>
            <td>${user.formattedDate}</td>
            <td><c:if test="${user.overDue}">overdue</c:if></td>
            <td>
              <form action="Library" method="post">
                <input type="hidden" name="email" id="email" 
                       value="${user.email}">
                <input type="hidden" name="bookName" id="bookName" 
                       value="${user.bookName}">
                <input type="submit" name="action" id="checkout" 
                       value="Check in">
              </form>
            </td>
          </tr>
        </c:forEach>
    </table>
  
  <p><a href="<c:url value='Library?action=Home' />">Return to front 
      page</a></p>
</section>
<%@include file="includes/footer.jsp" %>   
