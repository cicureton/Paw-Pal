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

<section id="provider-details">
    <h1>${title}</h1>

    <div class="provider-card">
        <p><strong>About:</strong> ${provider.about}</p>
        <p><strong>Experience:</strong> ${provider.experience}</p>
        <p><strong>Approval Status:</strong> ${provider.approvalStatus}</p>
        <form action="/bookings/provider/${provider.providerId}" method="get">
            <button type="submit">View Current Bookings</button>
        </form>

    </div>

    <a href="/providers/update/${provider.providerId}">Edit</a> |
    <a href="/providers/delete/${provider.providerId}" onclick="return confirm('Are you sure?')">Delete</a>


</section>

</body>
</html>
