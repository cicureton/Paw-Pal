<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/service.css">
    <title>Paw Pal - Book Service</title>
</head>

<body>

<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/services/all">Browse Services</a></p>
        <p><a href="/providers/login">Sign Out</a></p>
    </nav>
</header>

<section id="create-booking">
    <h2>Book Service</h2>

    <form method="post" action="/bookings/new">
        <input type="hidden" name="serviceId" value="${serviceId}" />
        <input type="hidden" name="providerId" value="${providerId}" />
        <input type="hidden" name="customerId" value="${customerId}" /> <!-- Assuming the customer ID is stored or retrieved dynamically -->

        <label for="appointment">Choose Appointment Date & Time:</label>
        <input type="datetime-local" id="appointment" name="appointment" required>

        <label for="status">Booking Status:</label>
        <select name="status" id="status">
            <option value="Pending">Pending</option>
            <option value="Confirmed">Confirmed</option>
        </select>

        <button type="submit">Confirm Booking</button>
    </form>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>

</body>
</html>
