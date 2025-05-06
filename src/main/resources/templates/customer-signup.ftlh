<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Sign-Up</title>
    <link rel="stylesheet" href="/css/signup-login.css">
</head>
<body>
<h1>Customer Sign-Up</h1>
<form action="/customers/new" method="post">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required maxlength="20" placeholder="Enter username" />
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required maxlength="255" placeholder="Enter email" />
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required maxlength="255" placeholder="Enter password" />
    </div>
    <div>
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required maxlength="50" placeholder="Enter first name" />
    </div>
    <div>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required maxlength="50" placeholder="Enter last name" />
    </div>
    <div>
        <label for="address">Address:</label>
        <textarea id="address" name="address" placeholder="Enter your address"></textarea>
    </div>
    <div>
        <label for="petDetails">Pet Details:</label>
        <textarea id="petDetails" name="petDetails" placeholder="Describe your pet(s)"></textarea>
    </div>
    <button type="submit">Sign Up</button>
</form>
<p>Already have an account? <a href="/providers/login">Login here</a>.</p>
</body>
</html>
