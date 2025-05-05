<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/service.css">
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

<section id="service-details">
    <h2>${title}</h2>

    <div class="service-card">
        <h3>${service.title}</h3>
        <p><strong>Description:</strong> ${service.description}</p>
        <p><strong>Price:</strong> $${service.price}</p>
        <p><strong>Availability:</strong> ${service.availability}</p>

        <form action="/bookings/create/${service.serviceId}" method="get">
            <button type="submit">Book This Service</button>
        </form>
    </div>

    <div>
        <a href="/services/all">← Back to Services</a>
    </div>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>

</body>
</html>
