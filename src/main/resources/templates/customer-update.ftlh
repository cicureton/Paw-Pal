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
        <p><a href="/customers/login">Sign in</a></p> <!-- Adjust login link to match your system -->
    </nav>
</header>

<section id="customer-update">
    <h1>${title}</h1>

    <form action="/customers/update" method="post">
        <input type="hidden" name="customerId" value="${customer.customerId}" />


        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${customer.username}" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${customer.email}" required><br><br>

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${customer.firstName}" required><br><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${customer.lastName}" required><br><br>

        <label for="address">Address:</label>
        <textarea id="address" name="address">${customer.address}</textarea><br><br>

        <label for="petDetails">Pet Details:</label>
        <textarea id="petDetails" name="petDetails">${customer.petDetails}</textarea><br><br>

        <input type="submit" value="Update Customer">
    </form>

</section>

</body>
</html>
