<?php 

//What is a session?

//Used to ingased data to the different pages as like "Facebook"
/*
A session is a way to store and maintain information about a user's interaction with a website or application over a period of time.

In web development, a session is typically created when a user logs into a website or performs some other type of action that requires their activity to be tracked. Once a session is created, a unique session ID is generated and stored on the server-side, and a corresponding session cookie is stored on the user's browser.

As the user interacts with the website or application, information about their activity is stored in the session, allowing the server to remember details about their preferences, login status, shopping cart contents, and other relevant data. This information can then be used to provide a personalized experience for the user and to maintain state across multiple page requests.

Once a user's session is ended, either by logging out or by the session expiring, the session data is typically cleared from the server-side storage. This helps to ensure the security and privacy of user data.
=====================================
Another meaning of a session in php
---------------------------------------
In PHP, a session is a way to store data across multiple pages or requests made by the same user. 

When a user starts a session on a website, PHP creates a unique identifier, also known as the session ID, and stores it as a cookie on the user's browser. The session ID is then used to track the user's activity on the website and associate any data they enter or interact with to their specific session.

Session data is stored on the server-side and can be accessed and modified by the PHP scripts that are part of the same session. This allows developers to store information such as login credentials, user preferences, and shopping cart contents, among other things.

Once the user ends their session (either by logging out or closing their browser), the session data is destroyed and the session ID is no longer valid.
===========================================================================


*/

//verify the data from the user
//This is the set the user value method
session_start();
$_SESSION['username']="Pankaj";
$_SESSION['FatCat']="Book";

echo "Your session is started!<br>";







?>