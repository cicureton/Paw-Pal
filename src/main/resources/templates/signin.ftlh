<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/style.css">
    <title>Paw Pal - Sign In</title>
</head>
<body>
<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/services">Browse Services</a></p>
        <p><a href="/signin">Sign in</a></p>
    </nav>
</header>

<section id="signin">
    <h2>Welcome to Paw Pal</h2>
    <#if error??>
    <div class="error">${error}</div>
</#if>
<form method="post" action="/signin">
    <label>Username:</label>
    <input type="text" name="username" required>

    <label>Password:</label>
    <input type="password" name="password" required>

    <button type="submit">Sign In</button>
</form>

<p>New to Paw Pal? <a href="/signup">Create an account</a></p>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>
</body>
</html>
