<%-- 
    Created on : Dec 3, 2016, 12:38:03 AM
    Author     : JZ Greenwell, Casey Hayes
--%>
<%@include file="includes/header.jsp" %>
<section>
  <p>
    Thank you for your patronage of the Belk Library. You've successfully 
    checked out the book, ${user.bookName}. Please note that this book
    is due back on ${user.formattedDate}. A friendly email reminder will be 
    sent to you if your book becomes overdue.
  </p>
  
  <p id="returnHome"><a href="<c:url value='Library?action=Home' />">Return to 
      front page</a></p>
</section>
<%@include file="includes/footer.jsp" %>
