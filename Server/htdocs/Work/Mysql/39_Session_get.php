<?php

//This is the output of the user
session_start();
if (isset($_SESSION['username'])) {
    echo "Welcome to " . $_SESSION['username'];
    echo "<br>Your Favorite Category is " . $_SESSION['FatCat'] . "<br>";
} else {
    echo "Please login to Continue";
}

?>