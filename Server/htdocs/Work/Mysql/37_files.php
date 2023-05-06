<?php
//database connection
//include '_dbconnection.php';

//Writing and appending file
echo "Welcome to write files in php";
$fptr=fopen("pan1.txt","w"); 

//fwrite 2 ta parameter ney ekta holo file pointer onno ta holo jei data write korbo
//oi data 
fwrite($fptr,"This is the best file in the world!\n");
fwrite($fptr,"This is another content.\n");
fwrite($fptr,"This is another content3.\n");

//Appending the file with the same file name
$fptr=fopen("pan1.txt","a");
fwrite($fptr,"This is the append file of the same file!");
fclose($fptr);



?>