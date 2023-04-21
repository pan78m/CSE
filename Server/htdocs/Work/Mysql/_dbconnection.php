<?php
//Create Databases using sql command
$servername="localhost";
$username="root";
$password="";
$dbn="Pan";

//connection to database
$conn=mysqli_connect($servername,$username,$password,$dbn);
if(!$conn){
    die("Could not connect mysql->".mysqli_connect_error());
}else{
 echo "Connected Successfully to Database<br/>";   
}


?>