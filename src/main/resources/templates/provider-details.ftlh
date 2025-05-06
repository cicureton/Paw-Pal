<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/user.css">
    <title>${title}</title>
</head>

<body>

<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/services/all">Browse Services</a></p>
        <p><a href="/providers/{${provider.providerId}}">Profile</a></p>
        <p><a href="/providers/login">Sign out</a></p> <!-- Adjust login link to match your system -->
    </nav>
</header>

<section id="provider-details">
    <h1>Profile</h1>

    <div class="provider-card">
        <p><strong>Username:</strong> ${provider.username}</p>
        <p><strong>Email:</strong> ${provider.email}</p>
        <p><strong>First Name:</strong> ${provider.firstName}</p>
        <p><strong>Last Name:</strong> ${provider.lastName}</p>
        <p><strong>About:</strong> ${provider.about}</p>
        <p><strong>Experience:</strong> ${provider.experience}</p>
        <p><strong>Approval Status:</strong> ${provider.approvalStatus}</p>
        <p><strong>Status:</strong> ${provider.status}</p>
        <form action="/bookings/provider/${provider.providerId}" method="get">
            <button type="submit">View Current Bookings</button>
        </form>
        <p></p>
        <form action="/services/createForm" method="get">
            <input type="hidden" name="providerId" value="${provider.providerId}" />
            <button type="submit">Create a New Service</button>
        </form>
    </div>


    <a href="/providers/update/${provider.providerId}">Edit</a> |
    <a href="/providers/delete/${provider.providerId}" onclick="return confirm('Are you sure you want to delete this provider?')">Delete</a>

</section>

</body>
</html>
