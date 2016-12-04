<%-- 
    Created on : Dec 3, 2016, 12:38:03 AM
    Author     : JZ Greenwell, Casey Hayes
--%>
<%@include file="includes/header.jsp" %>
<section>
  <h2>Checkout a book</h2>
  <form action="checkout" method="post">
    <label for="firstName">First Name</label>
    <span><br></span>
    <input type="text" name="firstName" id="firstName" autofocus 
           required title="Please enter your first name."
           pattern="^[a-zA-Z]+"
           value="">
    <br>
    <label for="lastName">Last Name:</label>
    <span><br></span>
    <input type="text" name="lastName" id="lastName" required 
           title="Please enter your last name."
           pattern="^[a-zA-Z]+"
           value="">
    <br>
    <label for="email">Email Address:</label>
    <span><br></span>
    <input type="email" name="email" id="email" required 
           title="Please enter your email address" 
           value="">
    <br>
    <label for="book">Book Title:</label>
    <span><br></span>
    <input type="text" name="book" id="book" required
           title="Please enter the title of the book"
           value="">
    <br>
    <label for="calculate"></label>
    <input type="submit" name="action" id="checkout" value="Checkout">
    </form>
    <p><a href="<c:url value='/library.jsp' />">Return to front page</a></p>
    </section>
    <%@include file="includes/footer.jsp" %>   
