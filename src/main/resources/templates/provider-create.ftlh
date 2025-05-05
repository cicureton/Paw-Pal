<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/provider.css">
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

<section id ="create-provider">
    <h1>${title}</h1>

    <form action="/providers/new" method="post">
        <input type="hidden" name="userId" value="${provider.userId?if_exists}" />

        <label for="about">About You:</label><br>
        <textarea id="about" name="about" rows="4" cols="50" required>${provider.about?if_exists}</textarea><br><br>

        <label for="experience">Experience:</label><br>
        <textarea id="experience" name="experience" rows="4" cols="50" required>${provider.experience?if_exists}</textarea><br><br>

        <button type="submit">Apply</button>
    </form>

</section>
<a href="/providers/">Back to Providers List</a>
</body>
</html>
