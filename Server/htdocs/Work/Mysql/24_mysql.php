<?php 
//connecting mysql in php code
/*There are two types we connect in php with php
1. MySqli 
2. PDO->Full form is PHP Data Object
*/

//connect to databases
echo "Welcome to our Databases!!<br/>";
$servername="localhost";
$user="root";
$pass="";

//create a connection

$conn=mysqli_connect($servername,$user,$pass);

if(!$conn){
    die("Could not connect mysql->".mysqli_connect_error());
}else{
 echo "Connected Successfully to Database<br/>";   
}



?>