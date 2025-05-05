<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="/css/booking.css">
</head>
<body>
<header>
    <h1>Paw Pal</h1>
    <nav>
        <p><a href="/">Home</a></p>
        <p><a href="/services/all">Browse Services</a></p>
        <p><a href="/profile.html">Profile</a></p>
        <p><a href="/index.html">Sign Out</a></p>
    </nav>
</header>

<section id="booking">
    <h2>${title}</h2>

    <div class="booking-list">
        <#list bookings as booking>
        <div class="booking-card">
            <div class="booking-header">
                <h3>Booking #${booking.bookingId}</h3>
            </div>
            <div class="booking-info">
                <p><strong>Customer:</strong> ${booking.customer.name}</p>
                <p><strong>Service:</strong> ${booking.petService.title}</p>
                <p><strong>Price:</strong> $${booking.petService.price}</p>
                <p><strong>Availability:</strong> ${booking.petService.availability}</p>
                <p><strong>Appointment:</strong> ${booking.appointment?string("yyyy-MM-dd HH:mm")}</p>
                <p><strong>Status:</strong> ${booking.status}</p>
            </div>
            <div class="booking-actions">
                <a href="/bookings/update/${booking.bookingId}">Accept</a> |
                <a href="/bookings/delete/${booking.bookingId}">Reject</a>
            </div>
        </div>
    </#list>
    </div>
</section>

<footer>
    <p>Paw Pal &copy; 2025</p>
</footer>
</body>
</html>
