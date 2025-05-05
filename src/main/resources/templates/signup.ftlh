<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/style.css">
    <title>Paw Pal - Sign Up</title>
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

<section id="signup">
    <h2>Create an Account</h2>
    <#if error??>
        <div class="error">${error}</div>
    </#if>
    <form method="post" action="/signup">
        <label>Full Name:</label>
        <input type="text" name="fullname" required>

        <label>Address:</label>
        <input type="text" name="address" required>

        <label>Pet Details:</label>
        <textarea name="petDetails" required></textarea>

        <label>Username:</label>
        <input type="text" name="username" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <label>Confirm Password:</label>
        <input type="password" name="confirmPassword" required>

        <button type="submit">Sign Up</button>
    </form>

    <p>Already have an account? <a href="/signin">Sign in</a></p>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>
</body>
</html>
