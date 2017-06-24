<%--@elvariable id="validationErrors" type="java.util.Set<javax.validation.ConstraintViolation>"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    	<link href="css/bootstrap.css" rel="stylesheet">
        <title><spring:message code="title.create.employee" /></title>
        <style type="text/css">
            .errors {
                color:#CC0000;
                display: block;
            }
        </style>
    </head>
    <body>
        <h2><spring:message code="title.create.employee" /></h2>
        <c:if test="${validationErrors != null}" ><div class="errors">
            <ul>
                <c:forEach items="${validationErrors}" var="error">
                    <li><c:out value="${error.message}" /></li>
                </c:forEach>
            </ul>
        </div></c:if>
        <table class="table table-striped table-bordered table-hover">
        <form:form method="post" modelAttribute="employeeForm">
            <tr>
            	<td><form:label path="firstName"><spring:message code="form.first.name" />
            		</form:label></td>
            	<td><form:input path="firstName" /></td>
            	<td><form:errors path="firstName" cssClass="errors"  /></td>
            </tr>	
            <tr>
            	<td><form:label path="middleName">
                	<spring:message code="form.middle.name" />
                	</form:label>
				</td>
            	<td>
            		<form:input path="middleName" />
            	</td>	
                <td>
                	<form:errors path="middleName" cssClass="errors" />
                </td>	
			</tr>
			<tr>
            	<td><form:label path="lastName"><spring:message code="form.last.name" />
            		</form:label>
            	</td>
            	<td>
            	<form:input path="lastName" />
            	</td>
            	<td>
           		 	<form:errors path="lastName" cssClass="errors" />
				</td>
            </tr>	
           	<tr>	
            	<td colspan="3">
            		<input type="submit" value="Submit" class="btn btn-block" />
            	</td>
            </tr>
        </form:form>
        </table>
    </body>
</html>
