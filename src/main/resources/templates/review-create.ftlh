<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Write a Review</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/profile">Profile</a></p>
        <p><a href="/signout">Sign Out</a></p>
    </nav>
</header>

<section id="review-form">
    <h2>Leave a Review</h2>

    <form method="post" action="/reviews/add">
        <input type="hidden" name="bookingId" value="${bookingId}">

        <label for="rating">Rating (1 to 5):</label>
        <input type="number" name="rating" min="1" max="5" required>

        <label for="description">Comments:</label>
        <textarea name="description" rows="4" required></textarea>

        <button type="submit">Submit Review</button>
    </form>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>
</body>
</html>
