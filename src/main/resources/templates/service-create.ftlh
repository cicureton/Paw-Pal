<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/service.css">
    <title>Paw Pal - Create Service</title>
</head>

<body>

<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/services/all">Browse Services</a></p>
        <p><a href="profile.html">Profile</a></p>
        <p><a href="index.html">Sign Out</a></p>
    </nav>
</header>

<section id="create-services">
    <h2>Create a New Service</h2>

    <form method="post" action="/services/new">

        <label for="title">Service Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="description">Service Description:</label>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea>

        <label for="serviceType">Select Service Type:</label>
        <select id="serviceType" name="serviceType">
            <option value="Dog Walking">Dog Walking</option>
            <option value="Pet Sitting">Pet Sitting</option>
            <option value="Grooming">Grooming</option>
        </select>

        <label for="availability">Select Availability:</label>
        <input type="date" id="availability" name="availability">

        <label for="price">Set Your Price ($):</label>
        <input type="number" id="price" name="price" step="0.01" required>

        <button type="submit" id="set-service">Set Service</button>

    </form>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>

</body>
</html>
