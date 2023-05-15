<?php
//This is the logged out function
//when a user logged out the login section go to the page again before login first
//Then this user go to the home section found
session_start();
session_unset();
session_destroy();
echo "Your have been logged out<br>";

?>