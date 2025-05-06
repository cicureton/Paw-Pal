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
        <p><a href="/providers/login">Sign in</a></p>
    </nav>
</header>

<section id="update-service">
    <h2>${title}</h2>

    <form action="/services/update/${service.serviceId}" method="post">
        <label for="title">Service Title:</label>
        <input type="text" id="title" name="title" value="${service.title}" required>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required>${service.description}</textarea>

        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" value="${service.price}" required>

        <label for="availability">Availability:</label>
        <input type="text" id="availability" name="availability" value="${service.availability}" required>

        <button type="submit">Update Service</button>
    </form>

    <div>
        <a href="/services/all">← Cancel and go back</a>
    </div>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>

</body>
</html>
