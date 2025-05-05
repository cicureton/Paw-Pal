<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<header>
    <h1>Edit Profile</h1>
    <nav>
        <p><a href="/profile">Back to Profile</a></p>
    </nav>
</header>

<section id="edit-profile">
    <form method="post" action="/edit-profile">
        <label>Full Name:</label>
        <input type="text" name="fullname" value="${user.fullname}" required>

        <label>Address:</label>
        <input type="text" name="address" value="${user.address}" required>

        <label>Pet Details:</label>
        <textarea name="petDetails" required>${user.petDetails}</textarea>

        <button type="submit">Save Changes</button>
    </form>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>
</body>
</html>
