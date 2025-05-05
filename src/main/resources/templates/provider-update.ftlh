<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/provider.css">
    <title>${title}</title>
</head>

<body>

<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/services/all">Browse Services</a></p>
        <p><a href="/signin">Sign in</a></p>
    </nav>
</header>

<section id="update-provider">
    <h1>${title}</h1>

    <form action="/providers/update/${provider.providerId}" method="post">
        <input type="hidden" name="userId" value="${provider.userId}" />

        <label for="about">About You:</label><br>
        <textarea id="about" name="about" rows="4" cols="50">${provider.about}</textarea><br><br>

        <label for="experience">Experience:</label><br>
        <textarea id="experience" name="experience" rows="4" cols="50">${provider.experience}</textarea><br><br>

        <label for="approvalStatus">Approval Status:</label><br>
        <#if isAdmin?? && isAdmin>

        <select id="approvalStatus" name="approvalStatus">
            <option value="pending" <#if provider.approvalStatus == "pending">selected</#if>>Pending</option>
            <option value="approved" <#if provider.approvalStatus == "approved">selected</#if>>Approved</option>
            <option value="rejected" <#if provider.approvalStatus == "rejected">selected</#if>>Rejected</option>
        </select>
        <#else>
            <p>${provider.approvalStatus?cap_first}</p>
            <input type="hidden" name="approvalStatus" value="${provider.approvalStatus}" />
        </#if>
        <br><br>

    <button type="submit">Update</button>
    </form>
    <a href="/providers/${provider.providerId}">Cancel</a>

</section>

</body>

</html>
