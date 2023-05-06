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
*/hud

echo "Setting Cookies & super global in PHP!<br/>";
//ghjkvf,po0kijty77g hyg,iugggggecho time();
// Syntex to set a cookie
setcookie("category", "Books", time() + 86400, "/");

echo "This cookie is set<br>";

                                                                                                                                                                                                                                                                               