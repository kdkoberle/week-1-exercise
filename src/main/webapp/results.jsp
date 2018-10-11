<%@ page import="java.util.ArrayList" %>
<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>
<script type="text/javascript" class="init">
    $[document].ready(function () {
        $('userTable').DataTable();
    });
</script>
<html><body>


<div class="container-fluid">
    <h2>Search Results</h2>
    <table id="userTable" class="display" cellspacing="0" width="40%">
        <thead>
            <th>First Name</th>
            <th>Last Name</th>
            <th>User ID</th>
            <th>Age</th>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.userName}</td>
                    <td>${user.calculateAge()}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>


</div>
<!--
<div class="container-fluid">
    <h2>Search Results: </h2>
    <br/>
    <br />

    <table cellpadding="10" cellspacing="10" style="border: 1px solid black;">
        <tr>
            <td>  First Name  </td>
            <td>  Last Name  </td>
            <td>  User ID  </td>
            <td>  DOB  </td>
            <td>  Age  </td>
        </tr>


    </table>

-->

</div>

</body>
</html>
