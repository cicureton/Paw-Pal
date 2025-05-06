<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/service.css">
    <title>Paw Pal - Services</title>
</head>

<body>

<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/services/all">Browse Services</a></p>
        <p><a href="/providers/login">Sign out</a></p>
    </nav>
</header>

<section id="services">
    <h2>${title}</h2>

    <#list services as service>
    <div class="service">
        <h3>${service.title}</h3>
        <p>${service.description}</p>
        <p><strong>Price:</strong> $${service.price}</p>

        <form action="/services/${service.serviceId}" method="get">
            <button type="submit">View Details</button>
        </form>
    </div>
</#list>

<#if services?size == 0>
<p>No services available at the moment. Check back later!</p>
</#if>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>

</body>
</html>

