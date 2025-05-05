<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/style.css">
    <title>Paw Pal - Profile</title>
</head>
<body>
<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/customer-list">Home</a></p>
        <p><a href="/services/all">Browse Services</a></p>
        <p><a href="/profile">Profile</a></p>
        <p><a href="/signout">Sign Out</a></p>
    </nav>
</header>

<section id="profile">
    <div class="owner-info">
        <h2>Owner Information</h2>
        <p><strong>Name:</strong> ${user.fullname}</p>
        <p><strong>Address:</strong> ${user.address}</p>
    </div>

    <div class="pet-info">
        <h2>Pet Profile</h2>
        <p><strong>Details:</strong> ${user.petDetails}</p>
    </div>

    <p><a href="/edit-profile"><button class="edit-profile">Edit Profile</button></a></p>

</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>
</body>
</html>
