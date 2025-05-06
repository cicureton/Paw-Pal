<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/user.css">
    <title>${title}</title>
</head>

<body>

<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/services/all">Browse Services</a></p>
        <p><a href="/providers/login">Sign out</a></p> <!-- Adjust login link to match your system -->
    </nav>
</header>

<section id="customer-details">
    <h1>Profile</h1>

    <div class="customer-card">
        <p><strong>Username:</strong> ${customer.username}</p>
        <p><strong>Email:</strong> ${customer.email}</p>
        <p><strong>First Name:</strong> ${customer.firstName}</p>
        <p><strong>Last Name:</strong> ${customer.lastName}</p>
        <p><strong>Address:</strong> ${customer.address}</p>
        <p><strong>Pet Details:</strong> ${customer.petDetails}</p>
        <p><strong>Status:</strong> ${customer.status}</p>
        <form action="/bookings/customer/${customer.customerId}" method="get">
            <button type="submit">View Current Bookings</button>
        </form>
    </div>

    <a href="/customers/update/${customer.customerId}">Edit</a> |
    <a href="/customers/delete/${customer.customerId}" onclick="return confirm('Are you sure you want to delete this customer?')">Delete</a>

</section>

</body>
</html>
