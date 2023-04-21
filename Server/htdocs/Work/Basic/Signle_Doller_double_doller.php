<?php

// Today's topics is $ doller and $$ doller sign in variable declearations

// single doller is a variable declear 
// double doller use as link a references variable

$u="hello";//u is the orginal variable here which indicate value is hello

$$u=100;// this time u is the reference value which indicate the value of previous "u"

echo $u."<br/>";
echo $$u."<br/>";
echo $hello;


?>