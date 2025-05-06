<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Review Details</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/profile">Profile</a></p>
    </nav>
</header>

<section>
    <h2>Review</h2>
    <p><strong>Rating:</strong> ${review.rating}/5</p>
    <p><strong>Description:</strong> ${review.description}</p>
    <p><strong>Date:</strong> ${review.createdAt?string("yyyy-MM-dd")}</p>
    <#if review.reply??>
    <p><strong>Reply:</strong> ${review.reply}</p>
</#if>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>
</body>
</html>
