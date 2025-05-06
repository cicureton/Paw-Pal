<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Application Review</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css"/>
    <style>
        body {
            background-color: #f4f4f4;
        }
        .container {
            margin-top: 30px;
        }
        .card {
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 30px;
        }
        .btn-approve {
            background-color: #28a745;
            color: white;
            border: none;
        }
        .btn-deny {
            background-color: #dc3545;
            color: white;
            border: none;
        }
        .btn-approve:hover, .btn-deny:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/stats/dashboard">Admin Dashboard</a>
    </div>
</nav>

<div class="container">
    <!-- Display Pending Applications -->
    <#if pendingApplications?has_content>
    <h3>Pending Applications</h3>
    <#list pendingApplications as app>
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <h3 class="text-primary">Applicant Information</h3>
                <p><strong>Name:</strong> ${app.user.firstName} ${app.user.lastName}</p>
                <p><strong>Email:</strong> ${app.user.email}</p>
                <p><strong>Position Applied For:</strong> ${app.user.role}</p>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <h3 class="text-primary">Application Letter</h3>
                <blockquote class="blockquote">
                    <p>${app.provider.about}</p>
                </blockquote>
                <div class="d-flex justify-content-between">
                    <button class="btn btn-approve" data-bs-toggle="modal" data-bs-target="#approveModal${app.applicationId}">Approve</button>
                    <button class="btn btn-deny" data-bs-toggle="modal" data-bs-target="#denyModal${app.applicationId}">Deny</button>
                </div>
            </div>
        </div>
    </div>
</#list>
<#else>
<div class="alert alert-info">No pending applications to review at the moment.</div>
</#if>

<!-- Display Approved Applications -->
<#if approvedApplications?has_content>
<h3>Approved Applications</h3>
<#list approvedApplications as app>
<!-- Similar structure as above for approved applications -->
</#list>
</#if>

<!-- Display Denied Applications -->
<#if deniedApplications?has_content>
<h3>Denied Applications</h3>
<#list deniedApplications as app>
<!-- Similar structure as above for denied applications -->
</#list>
</#if>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
