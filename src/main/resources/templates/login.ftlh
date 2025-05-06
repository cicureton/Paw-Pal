<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login - Paw Pal</title>
    <link rel="stylesheet" href="/css/signup-login.css">
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

<div class="login-container">
    <h2>Login to Paw Pal</h2>

    <#if error??>
    <div class="error">${error}</div>
</#if>

<form action="/providers/login" method="post">
    <div class="input-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" required />
    </div>

    <div class="input-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required />
    </div>

    <button type="submit" class="login-button">Login</button>
</form>

<div class="signup-links">
    <p>Don't have an account?</p>
    <a href="/providers/createForm">Sign up as Provider</a> |
    <a href="/customers/createForm">Sign up as Customer</a>
</div>
</div>

</body>
</html>
