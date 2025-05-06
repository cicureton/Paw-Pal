<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Reply to Review</title>
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
  <h2>Reply to Review</h2>

  <form method="post" action="/reviews/${review.reviewId}/reply">
    <label for="reply">Your Reply:</label>
    <textarea name="reply" rows="3" required></textarea>

    <button type="submit">Submit Reply</button>
  </form>
</section>

<footer>
  <p>Paw Pal &copy; 2025</p>
</footer>
</body>
</html>
