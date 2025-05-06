<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Reviews</title>
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

<section>
    <h2>Customer Reviews</h2>

    <#list reviews as review>
    <div class="review">
        <p><strong>Rating:</strong> ${review.rating}/5</p>
        <p><strong>Description:</strong> ${review.description}</p>
        <p><strong>Created At:</strong> ${review.createdAt?string("yyyy-MM-dd")}</p>
        <#if review.reply??>
        <p><strong>Provider Reply:</strong> ${review.reply}</p>
    </#if>
    </div>
</#list>

<#if reviews?size == 0>
<p>No reviews yet.</p>
</#if>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>
</body>
</html>
