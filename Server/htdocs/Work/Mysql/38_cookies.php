<?php
//Setting Cookies & $_COOKIE super global in PHP

/*
PHP cookie is a small piece of information which is stored at client browser. It is used to recognize the user.
Cookie is created at server side and saved to client browser. Each time when client sends request to the server, cookie is embedded with request. Such way, cookie can be received at the server side.
->>Difference between 
------------------------- 
Cookies VS Sessions
--------------------------
Cookies store normal data such as->> defaul and others normal data
Sessions store sensetive data such as->> password ,user id and etc
------------------------------

The full meaning of "Cookies"
==================================================================================
In PHP, a cookie is a small piece of data that is stored on the user's browser by the server. Cookies are commonly used to store user preferences, login information, shopping cart contents, and other types of data that need to be persisted across multiple requests.

When a server sends a response to a client's request, it can include a set of instructions in the HTTP headers that tell the client's browser to store a cookie with a specific name, value, and expiration time. Once the cookie is stored, it can be accessed by the server on subsequent requests made by the same client.

In PHP, cookies can be created and manipulated using the setcookie() function. The function takes several parameters, including the name and value of the cookie, its expiration time, and the domain and path where it should be sent.

Here's an example of how to set a cookie in PHP:
setcookie('username', 'johndoe', time() + 3600, '/');
This sets a cookie named "username" with the value "johndoe" that will expire in one hour (time() + 3600). The last parameter ('/') specifies that the cookie should be sent to all pages within the domain.

To retrieve the value of a cookie in PHP, you can use the $_COOKIE superglobal array. For example:
$username = $_COOKIE['username'];
=========================================

*/

echo "Setting Cookies & super global in PHP!<br/>";
//ghjkvf,po0kijty77g hyg,iugggggecho time();
// Syntex to set a cookie
setcookie("category", "Books", time() + 86400, "/");

echo "This cookie is set<br>";

                                                                                                                                                                                                                                                                               