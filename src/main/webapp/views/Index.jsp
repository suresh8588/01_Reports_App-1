<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reports Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3 class="pb-3 pt-3">Reports Application</h3>
		<form:form action="search" modelAttribute="search" method="POST">


			<table>
				<tr>
					<td>Plan Name</td>
					<td><form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items="${names }" />
						</form:select></td>

					<td>Plan Status</td>
					<td><form:select path="planStatus">
							<form:option value="">-Select-</form:option>
							<form:options items="${statuses }" />
						</form:select></td>

					<td>Gender</td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">Fe-Male</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date</td>
					<td><form:input path="startDate" type="date"
							data-date-format="yyyy/mm/dd" /></td>
					<td>End Date</td>
					<td><form:input type="date" path="endDate"
							data-date-format="yyyy/mm/dd" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Search"
						class="btn btn-primary"></td>
						<td><a href="/Reports/" class ="btn btn-secondary">Reset</a></td>
				</tr>
			</table>
			<hr>

			<table class="table table-success table-striped table-hover">
				<thead>
					<tr>
						<th>Sl No</th>
						<th>Citizen Name</th>
						<th>Gender</th>
						<th>Plan Name</th>
						<th>Plan Status</th>
						<th>Plan Strat Date</th>
						<th>Plan End Date</th>
						<th>Benefit Amount</th>
						<th>Denied Date</th>
						<th>Denied Reason</th>
						<th>Terminated Date</th>
						<th>Termination Reason</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${plans }" var="plan" varStatus="index">
						<tr>
							<td>${index.count }</td>
							<td>${plan.citizenName }</td>
							<td>${plan.gender }</td>
							<td>${plan.planName }</td>
							<td>${plan.planStatus }</td>
							<td>${plan.planStratDate }</td>
							<td>${plan.planEndDate }</td>
							<td>${plan.benefitAmount }</td>
							<td>${plan.denialDate }</td>
							<td>${plan.denialReason }</td>
							<td>${plan.terminatedDate }</td>
							<td>${plan.terminationReason }</td>
						</tr>

					</c:forEach>
					<tr>
						<c:if test="${empty plans}">
							<td colspan="12" style="text-align: center">No Records
								Found</td>
						</c:if>
					</tr>

				</tbody>

			</table>
			<hr>
			Export : <a href="excel">Excel</a>
			<a href="pdf">Pdf</a>
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>