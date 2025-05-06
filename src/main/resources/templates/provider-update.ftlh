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
        <p><a href="/signin">Sign in</a></p>
    </nav>
</header>
<section id="update-provider">
<h1>Update Provider Profile</h1>

<form action="/providers/update/${provider.providerId}" method="post">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${provider.username}" />
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${provider.email}" />
    </div>
    <div>
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${provider.firstName}" />
    </div>
    <div>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${provider.lastName}" />
    </div>
    <div>
        <label for="about">About:</label>
        <textarea id="about" name="about" maxlength="255">${provider.about}</textarea>
    </div>
    <div>
        <label for="experience">Experience:</label>
        <textarea id="experience" name="experience" maxlength="255">${provider.experience}</textarea>
    </div>
    <div>
        <label for="approvalStatus">Approval Status:</label>
        <input type="text" id="approvalStatus" name="approvalStatus" value="${provider.approvalStatus}" readonly />
    </div>
    <button type="submit">Update Profile</button>
</form>
<section/>

<p><a href="/providers/${provider.providerId}">Back to Profile</a></p>
</body>

</html>
